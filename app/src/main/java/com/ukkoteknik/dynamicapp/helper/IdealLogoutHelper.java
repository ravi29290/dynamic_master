package com.ukkoteknik.dynamicapp.helper;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;


import com.ukkoteknik.dynamicapp.activities.MainActivity;
import com.ukkoteknik.dynamicapp.utils.Constants;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by  Manoj Sadhu on 10/18/2018.
 */
public class IdealLogoutHelper {

    private static final IdealLogoutHelper ourInstance = new IdealLogoutHelper();
    private Handler logoutHandler = new Handler();

    private SharedPreferences sharedPreferences = MainActivity.reference.getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE);
    private SharedPreferences.Editor editor = sharedPreferences.edit();
    private Activity currentActivity;

    private Runnable logoutRunnable = () -> {

        MainActivity.reference.runOnUiThread(() -> {
            MainActivity.reference.offlineLogout();
            if (currentActivity != null)
                currentActivity.finishAffinity();
        });
        stopTimer();
        //Toast.makeText(MyApp.instance.getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
    };

    private IdealLogoutHelper() {
    }

    public static IdealLogoutHelper getInstance() {
        return ourInstance;
    }

    public void startTimer() {
        logoutHandler.postDelayed(logoutRunnable, /*5000*/3600000);
    }

    public void resetTimer() {
        editor.putLong("lastInteraction", System.currentTimeMillis());
        editor.apply();

        logoutHandler.removeCallbacks(logoutRunnable);
        startTimer();
    }

    private void stopTimer() {
        editor.putLong("lastInteraction", 0L);
        editor.apply();

        //logoutHandler.removeCallbacks(logoutRunnable);
    }


    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }
}
