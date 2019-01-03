package com.ukkoteknik.dynamicapp.activities;

import android.content.Intent;

import android.view.Menu;
import android.view.MenuItem;

import com.ukkoteknik.dynamicapp.R;
import com.ukkoteknik.dynamicapp.base.BaseActivity;

/**
 * Created by  Manoj Sadhu on 8/23/2018.
 */
public abstract class HomeActivity extends BaseActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        else if (item.getItemId() == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }

}
