package com.ukkoteknik.dynamicapp.utils;

import android.os.SystemClock;
import android.view.View;

/**
 * Created by  Manoj Sadhu on 7/11/2018.
 */
public abstract class OnOneClickListener implements View.OnClickListener {
    private static final long MIN_CLICK_INTERVAL = 1000; //in millis
    private long lastClickTime = 0;

    @Override
    public final void onClick(View v) {
        long currentTime = SystemClock.elapsedRealtime();
        if (currentTime - lastClickTime > MIN_CLICK_INTERVAL) {
            lastClickTime = currentTime;
            onOneClick(v);
        }
    }

    public abstract void onOneClick(View v);
}