package com.example.lyus.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import java.util.Objects;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainQRActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private ImageButton qr;
    private String restult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
    }

    public void onClick(View v){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

//    @Override
//    protected void onPause(){
//        super.onPause();
//        try{
//            mScannerView.stopCamera();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public void handleResult(Result result) {
        Intent i = new Intent(MainQRActivity.this, MainFingerprintActivity.class);
        startActivity(i);
        this.restult = result.getText();
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getText()));
//        startActivity(browserIntent);
        //Do anything with result here :D
//        TelephonyManager telemamanger = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        String getSimSerialNumber = telemamanger.getSimSerialNumber();
//        String getSimNumber = telemamanger.getLine1Number();


//        Log.w("handleResult", result.getText());
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan result");
//        if(Objects.equals(result.getText(), getSimNumber/*"19174368930"*/)){
//                //builder.setMessage("Correct");
//                CharSequence text = "Correct!";
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//            Intent i=new Intent(MainQRActivity.this, test.class);
//            startActivity(i);
//        } else {
//            //builder.setMessage("Wrong");
//            CharSequence text = "Wrong!";
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//        }
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();

        //Resume scanning
        //mScannerView.resumeCameraPreview(this);
    }
}
