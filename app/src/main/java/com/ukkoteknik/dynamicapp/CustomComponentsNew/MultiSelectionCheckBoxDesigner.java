package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.ukkoteknik.dynamicapp.ComponentValueChangeListener;
import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.OptionModel;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiSelectionCheckBoxDesigner extends LinearLayout implements ValueInteface {

    Context context;
    String key;

    public MultiSelectionCheckBoxDesigner(Context context, String key) {
        super(context);
        this.key = key;
        this.context = context;
        setProperties(key);
    }

    public MultiSelectionCheckBoxDesigner setProperties(String key) {
        Map<String, Asset> map = MyApp.instance.getAssetMap(key);
        setAttributes(map);
        return this;
    }

    @Override
    public String getKeyType() {
        return key;
    }

    @Override
    public String getValue() {
        String value = "";
        int count = this.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            if (view instanceof CheckBox) {
                if (((CheckBox) view).isChecked())
                    value = value + ((CheckBox) view).getText().toString() + ",";
            }
        }
        if (value.length() > 0) {
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }

    @Override
    public void setAttributes(Map<String, Asset> map) {
        /*String[] newString = map.get(Constants.OPTIONS).split(",");
        for (String aNewString : newString) {
            CheckBox checkBox = new CustomCheckBox(context, key).setCheckBoxText(aNewString);
            this.addView(checkBox);
        }*/

        Asset asset = map.get(key);
        String textJson = asset.getDataAttributes();

        List<OptionModel> list_options = new ArrayList<>();

        try {
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

        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (OptionModel optionModel : list_options) {
            CheckBox checkBox = new CustomCheckBox(context, key).setCheckBoxText(optionModel.getName());
            this.addView(checkBox);
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
