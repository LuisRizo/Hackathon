package com.gnirt69.qrcodesannerexample;

/**
 * Created by ycyin on 4/30/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button y=(Button) findViewById(R.id.button);
        final Context context = getApplicationContext();
        final int duration = Toast.LENGTH_SHORT;
        assert y != null;
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText code;
                code = (EditText) findViewById(R.id.editText);
                assert code != null;
                String confirmation = code.getText().toString();
                if(confirmation.compareTo("9569")== 0){
                    CharSequence text = "Correct!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    startActivity(new Intent(test.this,MainActivity.class));
                }
                else{
                    CharSequence text = "Wrong!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    code = null;
                }
            }
        });

    }
}
