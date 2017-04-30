package com.example.lyus.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // private Button btnLogin;

    ListView list;
    String[] titles;
    String[] description;
    int[] imgs = {R.drawable.ibm, R.drawable.imgres, R.drawable.imgres1, R.drawable.imgres3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getReseources();

      /Users/yong.zhou/Hackathon/Hackathon/app/app  titles = res.getStringArray(R.array.titles);
        description = res.getStringArray(R.array.description);

        list = (ListView) findViewById(R.id.List1);
        MyAdapter adapter = new MyAdapter(this,titles, imgs, description);
        list.setAdapter(adapter);
    }

     class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        int[] imgs;
        String myTitles[];
        String myDescription[];

        MyAdapter(Context c, String[]titles,int[] imgs, String[] description) {
            super(c, R.layout.row, R.id.text1, titles);
            this.context = c;
            this.imgs = imgs;
            this.myDescription = description;
            this.myTitles = titles;

        }
    public View getView(int posistion, View converView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        View row = layoutInflater.inflate(R.layout.row, parent, false);
        ImageView iamges = (ImageView) findViewById(R.id.icon);
        TextView myTitle = (TextView) findViewById(R.id.text1);
        TextView myDescription = (TextView) findViewById(R.id.text2);
        images.setImageResource(imgs[posistion]);
        myTitle.setText(titles[posistion]);
        myDescription.setText(description[posistion]);
        return row;


     /*   Class_
                btnLogin = (Button) findViewById(R.id.BtnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);*/
            }
        }

    }

