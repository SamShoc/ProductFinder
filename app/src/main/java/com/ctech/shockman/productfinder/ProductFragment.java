package com.ctech.shockman.productfinder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Toast;

//https://code.tutsplus.com/tutorials/android-sdk-create-a-barcode-reader--mobile-17162
//https://github.com/SueSmith/android-book-barcode-scanner
//https://github.com/zxing/zxing/tree/master/android-integration/src/main/java/com/google/zxing/integration/android

public class ProductFragment extends Fragment {

    private Button mPicButton;
    private Button mTextButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, container, false);

        mTextButton = v.findViewById(R.id.text_button);
        mPicButton = v.findViewById(R.id.pic_button);
        mPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.pic_button) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator();
                    scanIntegrator.initiateScan();
                }
            }
        });


        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {

        } else {
            Toast toast = Toast.makeText(R.string.no_data);
            toast.show();
        }
    }
}
