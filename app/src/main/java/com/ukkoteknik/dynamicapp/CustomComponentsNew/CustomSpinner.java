package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Path;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.ukkoteknik.dynamicapp.ComponentValueChangeListener;
import com.ukkoteknik.dynamicapp.CustomAdapter;
import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.OptionModel;
import com.ukkoteknik.dynamicapp.PatientModel;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.customComponents.JsonArrayAdapter;
import com.ukkoteknik.dynamicapp.realms.AssetModel;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint("AppCompatCustomView")
public class CustomSpinner extends Spinner implements ValueInteface {

    private Context context;
    String key;
    String dependency = "";
    Map<String, Asset> map;

    public CustomSpinner(Context context, String key) {
        super(context);
        this.key = key;
        this.context = context;
        setProperties(key);
    }


    public CustomSpinner setProperties(String key) {
        map = MyApp.instance.getAssetMap(key);
        setAttributes(map);
        return this;
    }

    public void drawSpinner(List<OptionModel> list) {
        CustomAdapter customAdapter = new CustomAdapter(context, list);
        this.setAdapter(customAdapter);
        selectedItemListener();
    }

    public void selectedItemListener() {
        this.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (changeEventListeners != null) {
                    for (int j = 0; j < changeEventListeners.size(); j++) {
                        ComponentValueChangeListener changeListener = changeEventListeners.get(j);
                        changeListener.onDependencyValueChange(CustomSpinner.this);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void updateValuesToSpinner(List<OptionModel> list) {
        drawSpinner(list);
    }

    @Override
    public String getValue() {
        int value = 0;
        if (getSelectedItem() instanceof OptionModel)
            value = ((OptionModel) getSelectedItem()).getId();
        return String.valueOf(value);
    }

    @Override
    public String getKeyType() {
        return key;
    }

    @Override
    public void setAttributes(Map<String, Asset> map) {
        List<OptionModel> list = new ArrayList<>();
        Asset asset = map.get(key);
        String dataAttributes = asset.getDataAttributes();
        try {
            JSONArray jsonArray = new JSONArray(dataAttributes);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            JSONArray jsonArray1 = jsonObject.getJSONArray("options");
            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                int id = jsonObject1.getInt("id");
                String value = jsonObject1.getString("name");
                OptionModel optionModel = new OptionModel();
                optionModel.setId(id);
                optionModel.setName(value);
                list.add(optionModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        drawSpinner(list);
    }

    public List<ComponentValueChangeListener> changeEventListeners;

    @Override
    public void setChangeEventListener(ComponentValueChangeListener componentValueChangeListener) {
        if (changeEventListeners == null) {
            changeEventListeners = new ArrayList<ComponentValueChangeListener>();
        }
        changeEventListeners.add(componentValueChangeListener);
    }

    @Override
    public void resolveDependencies(FormTemplate formTemplate) {
        Asset asset = map.get(key);
        if (asset != null) {
            dependency = asset.getDependency();
            if (!dependency.equals("")) {
                ValueInteface valueInteface = formTemplate.getComponentByKey(dependency);
                valueInteface.setChangeEventListener(new ComponentValueChangeListener() {
                    @Override
                    public void onDependencyValueChange(ValueInteface valueInteface) {
                        Log.v("CustomSpinner", "Dependency Changed : ");
                        int id = Integer.parseInt(valueInteface.getValue());
                        updateValuesToSpinner(getValueDependOnId(id));
                    }
                });
            }
        }
    }

    @Override
    public void updateListToSpinner(List<OptionModel> list) {
        updateValuesToSpinner(list);
    }

    @Override
    public void setManualText(String value) {

    }

    private List<OptionModel> getValueDependOnId(int id) {
        List<OptionModel> list = new ArrayList<>();
        Asset asset2 = map.get(key);
        String json = asset2.getDataAttributes();
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            JSONArray jsonArray1 = jsonObject.getJSONArray("options");
            for (int j = 0; j < jsonArray1.length(); j++) {
                JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                int id1 = jsonObject1.getInt("id");
                if (id == id1) {
                    JSONArray jsonArray2 = jsonObject1.getJSONArray("value");
                    for (int i = 0; i < jsonArray2.length(); i++) {
                        JSONObject jsonObject2 = jsonArray2.getJSONObject(i);
                        int id2 = jsonObject2.getInt("id");
                        String name = jsonObject2.getString("name");

                        OptionModel optionModel = new OptionModel();
                        optionModel.setId(id2);
                        optionModel.setName(name);

                        list.add(optionModel);
                    }
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
