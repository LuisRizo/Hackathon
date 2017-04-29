package com.hackthon.yong.customlistview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class TransactionsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transection);

        ListView listView=(ListView)findViewById(R.id.listView);

        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

        }

    }

    class CustomAdapter extends BaseAdapter {

        int [] IMAGES = {R.drawable.ibm, R.drawable.imgres_1, R.drawable.imgres, R.drawable.imgres_3,
                R.drawable.google_2};

        String [] COMPANY= {"Technology", "Google Buy", "Amazon Buy", "Lagcc CUNY", "Best Program"};

        String [] PRICES = { "$ 10.00", "$ 12.00", "$ 5.00", "$ 7.00", "$15.00"};

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            return null;
        }

    }
}
