package com.ukkoteknik.dynamicapp.base;

import android.support.v7.app.AppCompatActivity;
import com.ukkoteknik.dynamicapp.helper.IdealLogoutHelper;


public class BaseActivity extends AppCompatActivity {

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        IdealLogoutHelper.getInstance().resetTimer();
        //Toast.makeText(this, "intracted", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IdealLogoutHelper.getInstance().setCurrentActivity(this);
    }
}
