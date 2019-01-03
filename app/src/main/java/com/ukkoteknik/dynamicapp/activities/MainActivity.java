package com.ukkoteknik.dynamicapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.R;

public class MainActivity extends AppCompatActivity {

    public static MainActivity reference;
    //RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);
        new FormTemplate(this, linearLayout);

    }

    public void offlineLogout() {

    }

}
