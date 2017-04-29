package com.example.lyus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
// Array of options --> Array

// list view {view: da_items.xml}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yoyopayListView();
    }
    private void yoyopayListView()
    {
        String[] myItems= {"Blue", "Green", "Purple", "Red"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,       // layout to use (create)
                        myItems);       // Items to be displayed


        ListView list =(ListView) findViewById(R.id.item);
        list.setAdapter(adapter);
    }

    public void print(){
        System.out.println("Something");

    }
}
