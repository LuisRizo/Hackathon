package com.hackthon.yong.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater inflater= getActivity().getLayoutInflater();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
