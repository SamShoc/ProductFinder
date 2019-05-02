package com.ctech.shockman.productfinder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment myFragment = fm.findFragmentById(R.id.fragment_container);

        if (myFragment == null) {
            myFragment = new ProductFragment();
            fm.beginTransaction().add(R.id.fragment_container, myFragment).commit();
        }
    }

}
