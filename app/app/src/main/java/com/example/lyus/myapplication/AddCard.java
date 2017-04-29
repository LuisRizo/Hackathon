package com.example.lyus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddCard extends AppCompatActivity {

    private TextView tvName, tvCCN, tvCCV, tvExpDate;
    private ImageButton imgBtnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        tvName = (TextView) findViewById(R.id.TvName);
        tvCCN = (TextView) findViewById(R.id.TvCCN);
        tvCCV = (TextView) findViewById(R.id.TvCCV);
        tvExpDate = (TextView) findViewById(R.id.TvExpDate);
        imgBtnSubmit = (ImageButton) findViewById(R.id.ImgBtnSubmit);

    }
}
