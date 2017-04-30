package com.example.luis.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class LoginActivity extends AppCompatActivity {

    private static final String hostname = "localhost";
    private static final int portnumber = 6027;

    private static final String debugString = "debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Socket socket = null;

        try {
            Log.i(debugString, "Attempting to connect to server");
            socket = new Socket(hostname, portnumber);
            Log.i(debugString, "Connection Stablished");

            BufferedWriter bw = new BufferedWriter()
        } catch (IOException e) {
            Log.e(debugString, e.getMessage());
            e.printStackTrace();
        }

    }
}
