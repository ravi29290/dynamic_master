package com.ukkoteknik.dynamicapp.activities;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.ukkoteknik.dynamicapp.Adapters.CustomListTemplateAdapter;
import com.ukkoteknik.dynamicapp.R;
import com.ukkoteknik.dynamicapp.UserModel;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.Constants;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

public class ListViewTemplateActivity extends AppCompatActivity {

    private List<Asset> listassets = new ArrayList<>();
    private List<ValueInteface> listOfViews = new ArrayList<>();
    private LinearLayout linearLayout;
    List<UserModel> list_users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_template);

        //RealmResults<Asset> result = MyApp.instance.realm.where(Asset.class).equalTo("screenType", "listData").findAll();
        RealmResults<Asset> result = MyApp.instance.realm.where(Asset.class).equalTo("screenType", "listFields").findAll();
        for (int i = 0; i < result.size(); i++) {
            Asset asset = result.get(i);
            listassets.add(asset);
        }

        LinearLayout linearLayout = findViewById(R.id.linear_list);

        int count = listassets.size();
        for (int j = 0; j < count; j++) {
            Asset asset = listassets.get(j);
            try {
                Class aClass = Class.forName("com.ukkoteknik.dynamicapp.CustomComponentsNew" + "." + asset.getClassName());
                Constructor<?> ctr = aClass.getConstructor(Context.class, String.class);
                Object object = ctr.newInstance(ListViewTemplateActivity.this, asset.getKey());
                listOfViews.add((ValueInteface) object);
                linearLayout.addView((View) object);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
