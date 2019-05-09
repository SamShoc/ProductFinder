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

        mPicButton = v.findViewById(R.id.pic_button);
        mTextButton = v.findViewById(R.id.text_button);

        return v;
    }
}
