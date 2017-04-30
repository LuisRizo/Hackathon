package com.fingerprintscanner;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by yong.zhou on 4/29/17.
 */

public class FingerprintModule extends ReactContextBaseJavaModule{

    private FingerprintManager fingerprintManager;
    private Fingerprint fingerprint;

    public FingerprintModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);

        fingerprintManager = (FingerprintManager) reactApplicationContext.getSystemService(Context.FINGERPRINT_SERVICE);
        fingerprint = new Fingerprint(fingerprintManager, reactApplicationContext);
    }

    @Override
    public String getName() {
        return "Fingerprint";
    }

    @ReactMethod
    public void authenticate(){
        fingerprint.authenticate();
    }
}
