package com.ctech.shockman.productfinder;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//https://code.tutsplus.com/tutorials/android-sdk-create-a-barcode-reader--mobile-17162
//https://github.com/SueSmith/android-book-barcode-scanner
//https://github.com/zxing/zxing/tree/master/android-integration/src/main/java/com/google/zxing/integration/android
//https://stackoverflow.com/questions/45385813/get-google-search-results-and-show-in-android-app

public class ProductFragment extends Fragment {

    private Button mPicButton;
    private EditText mTextBox;
    private TextView mContentText;
    private Button mEnterButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void myClick(View v) {
        if(v.getId()==R.id.pic_button) {
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, container, false);

        mTextBox = v.findViewById(R.id.text_box);
        mContentText = v.findViewById(R.id.scan_content);

        mEnterButton = v.findViewById(R.id.enter_button);
        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mTextBox.getText().toString();
                mContentText.setText(text);
                try{
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    String term = mContentText.getText().toString();
                    intent.putExtra(SearchManager.QUERY, term);
                    startActivity(intent);
                } catch (Exception e) {

                }

            }
        });

        mPicButton = v.findViewById(R.id.pic_button);
        mPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick(v);
            }
        });


        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            mContentText.setText(scanContent);
            try {
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String term = mContentText.getText().toString();
                intent.putExtra(SearchManager.QUERY, term);
                startActivity(intent);
            } catch (Exception e) {

            }
        } else {
            Toast toast = Toast.makeText("@String/no_data").Toast.LENGTH_SHORT;
            toast.show();
            //its broken
        }
        //IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        /*if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            //String scanFormat = scanningResult.getFormatName();
            mContentText.setText(scanContent);
        } else {
            //Toast toast = Toast.makeText("@String/no_data", Toast.LENGTH_SHORT);
            //toast.show();
        }
        */
    }
}
