package com.rnnhybrid;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;

import javax.annotation.Nullable;

// TODO: 做成单例，预防每次启动白屏
public class MainReactActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "RNNHybrid";
    }

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new MyReactActivityDelegate(this, getMainComponentName());
    }

    class MyReactActivityDelegate extends ReactActivityDelegate {

        public MyReactActivityDelegate(Activity activity, @Nullable String mainComponentName) {
            super(activity, mainComponentName);
        }

        @Nullable
        @Override
        protected Bundle getLaunchOptions() {
            return getIntent().getExtras();
        }
    }
}
