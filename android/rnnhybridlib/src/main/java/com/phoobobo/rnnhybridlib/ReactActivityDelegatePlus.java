package com.phoobobo.rnnhybridlib;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.react.ReactActivityDelegate;

import javax.annotation.Nullable;

public class ReactActivityDelegatePlus extends ReactActivityDelegate {

    private Bundle mLaunchOptions = null;

    public ReactActivityDelegatePlus(Activity activity, @Nullable String mainComponentName) {
        super(activity, mainComponentName);
    }

    public void setLaunchOptions(Bundle bundle) {
        mLaunchOptions = bundle;
    }

    @Nullable
    @Override
    protected Bundle getLaunchOptions() {
        return mLaunchOptions;
    }
}
