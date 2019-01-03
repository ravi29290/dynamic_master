package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ukkoteknik.dynamicapp.ComponentValueChangeListener;
import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.OptionModel;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomRadioGroup extends RadioGroup implements ValueInteface {

    Context context;
    String key;

    public CustomRadioGroup(Context context, String key) {
        super(context);
        this.context = context;
        this.key = key;
        setProperties(key);
    }

    public CustomRadioGroup setProperties(String key) {
        Map<String, Asset> map = MyApp.instance.getAssetMap(key);
        setAttributes(map);
        return this;
    }

    @Override
    public String getValue() {
        int id = this.getCheckedRadioButtonId();

        String value = "";
        if (id != -1) {
            RadioButton radioButton = findViewById(id);
            value = radioButton.getText().toString();
        }
        return value;
    }

    @Override
    public String getKeyType() {
        return key;
    }

    @Override
    public void setAttributes(Map<String, Asset> map) {
        /*String[] newString = map.get(Constants.OPTIONS).split(",");
        for (String aNewString : newString) {
            RadioButton radioButton = new CustomRadioButton(context, key).setRadioText(aNewString);
            addView(radioButton);
        }*/

        Asset asset = map.get(key);
        String textJson = asset.getDataAttributes();

        try {
            /*JSONObject jsonObject1 = new JSONObject(textJson);
            String value = jsonObject1.getString("value");
            String[] array = value.split(",");

            for (String aNewString : array) {
                RadioButton radioButton = new CustomRadioButton(context, key).setRadioText(aNewString);
                addView(radioButton);
            }*/

            List<OptionModel> list_options = new ArrayList<>();

            JSONArray jsonArray = new JSONArray(textJson);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            JSONArray optArray = jsonObject.getJSONArray("options");
            for (int i = 0; i < optArray.length(); i++) {
                JSONObject jsonObject1 = optArray.getJSONObject(i);
                int id = jsonObject1.getInt("id");
                String value = jsonObject1.getString("value");

                OptionModel optionModel = new OptionModel();
                optionModel.setId(id);
                optionModel.setName(value);

                list_options.add(optionModel);

            }


            for (OptionModel optionModel : list_options) {
                RadioButton radioButton = new CustomRadioButton(context, key).setRadioText(optionModel.getName());
                addView(radioButton);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void setChangeEventListener(ComponentValueChangeListener componentValueChangeListener) {

    }

    @Override
    public void resolveDependencies(FormTemplate formTemplate) {

    }

    @Override
    public void updateListToSpinner(List<OptionModel> list) {

    }

    @Override
    public void setManualText(String value) {

    }


}
