package com.ukkoteknik.dynamicapp;

import android.content.Context;
import android.content.Intent;
import android.icu.util.Currency;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ukkoteknik.dynamicapp.Adapters.CustomListTemplateAdapter;
import com.ukkoteknik.dynamicapp.CustomComponentsNew.CustomButton;
import com.ukkoteknik.dynamicapp.CustomComponentsNew.CustomEditText;
import com.ukkoteknik.dynamicapp.CustomComponentsNew.CustomRadioButton;
import com.ukkoteknik.dynamicapp.CustomComponentsNew.CustomRadioGroup;
import com.ukkoteknik.dynamicapp.CustomComponentsNew.CustomSpinner;
import com.ukkoteknik.dynamicapp.CustomComponentsNew.MultiSelectionCheckBoxDesigner;
import com.ukkoteknik.dynamicapp.activities.ListViewTemplateActivity;
import com.ukkoteknik.dynamicapp.activities.MainActivity;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.realms.AssetModel;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import io.realm.RealmResults;

public class FormTemplate {

    private Context context;
    private LinearLayout linearLayout;
    private List<Asset> listassets = new ArrayList<>();
    private Button submit;
    private Button cancel;
    private List<ValueInteface> listOfViews = new ArrayList<>();

    public FormTemplate(Context context, LinearLayout linearLayout) {
        this.context = context;
        this.linearLayout = linearLayout;
        addListComponents();
    }

    private void addListComponents() {
        RealmResults<Asset> result = MyApp.instance.realm.where(Asset.class).equalTo("screenType", "formFileds").findAll();
        for (int i = 0; i < result.size(); i++) {
            Asset asset = result.get(i);
            listassets.add(asset);
        }
        viewCreation();
    }

    private void viewCreation() {
        int count = listassets.size();
        Log.v("FormTemplate", "count : " + count);
        for (int i = 0; i < count; i++) {

            Asset asset = listassets.get(i);
            try {
                Class aClass = Class.forName("com.ukkoteknik.dynamicapp.CustomComponentsNew" + "." + asset.getClassName());
                Constructor<?> ctr = aClass.getConstructor(Context.class, String.class);
                Object object = ctr.newInstance(context, asset.getKey());
                listOfViews.add((ValueInteface) object);
                if (!asset.getDependency().equals("")) {
                    ((ValueInteface) object).resolveDependencies(this);
                }
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

        //submit = new CustomButton(context, "BTNOK");
        submit = new Button(context);
        submit.setText("Submit");
        linearLayout.addView(submit);

        //cancel = new CustomButton(context, "BTNCANCEL");
        cancel = new Button(context);
        cancel.setText("Cancel");
        linearLayout.addView(cancel);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("MainActivity", "values :" + getValue());
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ListViewTemplateActivity.class));
            }
        });
    }

    public Map<String, String> getValue() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < listOfViews.size(); i++) {
            ValueInteface valueInteface = listOfViews.get(i);
            if (valueInteface.getValue() != null)
                map.put(valueInteface.getKeyType(), valueInteface.getValue());
        }
        return map;
    }

    public ValueInteface getComponentByKey(String key) {
        for (int i = 0; i < listOfViews.size(); i++) {
            ValueInteface valueInteface = listOfViews.get(i);
            if (valueInteface.getKeyType().equals(key))
                return valueInteface;
        }
        return null;
    }

}
