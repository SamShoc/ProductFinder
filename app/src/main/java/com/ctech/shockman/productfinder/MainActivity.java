package com.ctech.shockman.productfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mPicButton;
    private Button mTextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPicButton = findViewById(R.id.pic_button);
        mTextButton = findViewById(R.id.text_button);
    }
}
