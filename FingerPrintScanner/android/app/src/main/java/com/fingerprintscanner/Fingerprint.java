package com.fingerprintscanner;

/**
 * Created by yong.zhou on 4/29/17.
 */

import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class Fingerprint extends FingerprintManager.AuthenticationCallback {
    private FingerprintManager fingerprintManager;
    private FingerprintManager.CryptoObject cryptoObject;
    private CancellationSignal cancellationSignal;
    private ReactContext reactContext;
    public Fingerprint(FingerprintManager fingerprintManager, ReactContext reactContext){
        this.fingerprintManager = fingerprintManager;
        this.reactContext = reactContext;
    }

    public void setCryptoObject(FingerprintManager.CryptoObject cryptoObject){
        this.cryptoObject = cryptoObject;
    }

    public void authenticate(){
        cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
        WritableMap params = Arguments.createMap();
        params.putString("authStatus", "Waiting for fingerprint");
        sendEvent("authStatus", params);
    }

    @Override
    public void onAuthenticationFailed() {
        WritableMap params = Arguments.createMap();
        params.putString("authStatus", "Invalid fingerprint");
        sendEvent("authStatus", params);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        WritableMap params = Arguments.createMap();
        params.putString("authStatus", "Authentication Successful!");
        sendEvent("authStatus", params);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
    }

    private void sendEvent(String eventName, WritableMap params) {
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
    }
}
