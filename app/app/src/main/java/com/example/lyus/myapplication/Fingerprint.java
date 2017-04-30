package com.example.lyus.myapplication;

import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;

public class Fingerprint extends FingerprintManager.AuthenticationCallback {

    private FingerprintManager fingerprintManager;
    private FingerprintManager.CryptoObject cryptoObject;
    private CancellationSignal cancellationSignal;

    public Fingerprint(FingerprintManager fingerprintManager){
        this.fingerprintManager = fingerprintManager;
    }

    public void setCryptoObject(FingerprintManager.CryptoObject cryptoObject){
        this.cryptoObject = cryptoObject;
    }

    public void authenticate(){
        cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
    }

    @Override
    public void onAuthenticationFailed() {
        //TODO: Decide what to do when the authentication fails
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        //TODO: Decide what to do after the authentication is successful
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
    }

}
