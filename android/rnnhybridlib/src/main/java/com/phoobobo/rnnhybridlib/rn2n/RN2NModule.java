package com.phoobobo.rnnhybridlib.rn2n;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public class RN2NModule extends ReactContextBaseJavaModule {
    public RN2NModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RN2N";
    }

    @ReactMethod
    public void launchNative(String componentName, ReadableMap options) {
        Bundle bundle = parseReadableMapToBundle(options);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        Context context = getCurrentActivity();
        if (context != null) {
            intent.setComponent(new ComponentName(context, componentName));
            context.startActivity(intent);
        }
    }

    private Bundle parseReadableMapToBundle(ReadableMap options) {
        return Arguments.toBundle(options);
    }
}
