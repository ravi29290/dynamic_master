package com.ukkoteknik.dynamicapp.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ukkoteknik.dynamicapp.CustomComponentsNew.CustomTextView;
import com.ukkoteknik.dynamicapp.R;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.realms.DetailedModel;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmResults;

public class DetailedActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    private List<DetailedModel> listDetailedassets = new ArrayList<>();
    private List<ValueInteface> listOfViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        linearLayout = findViewById(R.id.linear_detailed);
        addListComponents();

    }

    private void addListComponents() {
        RealmResults<DetailedModel> result = MyApp.instance.realm.where(DetailedModel.class).findAll();
        for (int i = 0; i < result.size(); i++) {
            DetailedModel asset = result.get(i);
            listDetailedassets.add(asset);
        }
        viewCreation();
    }

    private void viewCreation() {
        int count = listDetailedassets.size();
        Log.v("FormTemplate", "count : " + count);
        for (int i = 0; i < count; i++) {
            DetailedModel detailedModel = listDetailedassets.get(i);
            RealmList<Asset> subDetailList = detailedModel.getList();
            int size = subDetailList.size();
            LinearLayout linearLayout_sub = new LinearLayout(getApplicationContext());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.weight = 1.0f;
            if (detailedModel.getTemplateType().equals("horizontal")) {
                linearLayout_sub.setOrientation(LinearLayout.HORIZONTAL);
            } else {
                linearLayout_sub.setOrientation(LinearLayout.VERTICAL);
            }
            for (int j = 0; j < size; j++) {
                Asset asset = subDetailList.get(j);
                try {
                    Class aClass = Class.forName("com.ukkoteknik.dynamicapp.CustomComponentsNew" + "." + asset.getClassName());
                    Constructor<?> ctr = aClass.getConstructor(Context.class, String.class);
                    Object object = ctr.newInstance(this, asset.getKey());
                    listOfViews.add((ValueInteface) object);

                    linearLayout_sub.addView((View) object);
                    if (object instanceof CustomTextView) {
                        ((CustomTextView) object).setGravity(Gravity.CENTER);
                    }
                    ((View) object).setLayoutParams(lp);
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
            linearLayout.addView(linearLayout_sub);
        }
    }
}
