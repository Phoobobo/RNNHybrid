package com.phoobobo.rnnhybridlib;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;

public class ReactActivityPlus extends ReactActivity {
    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegatePlus(this, getMainComponentName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        super.onCreate(savedInstanceState);
    }
}
