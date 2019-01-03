package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.widget.CheckBox;
import android.widget.Toast;

import com.ukkoteknik.dynamicapp.ComponentValueChangeListener;
import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.OptionModel;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

@SuppressLint("AppCompatCustomView")
public class CustomCheckBox extends CheckBox implements ValueInteface {

    private String key;
    private Context context;

    public CustomCheckBox(Context context,String key) {
        super(context);
        this.context=context;
        setProperties(key);
    }

    public CustomCheckBox setCheckBoxText(String value) {
        setText(value);
        return this;
    }

    public CustomCheckBox setProperties(String key) {
        this.key = key;
        Map<String, Asset> map = MyApp.instance.getAssetMap(key);
        setAttributes(map);
        return this;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getKeyType() {
        return key;
    }

    @Override
    public void setAttributes(Map<String, Asset> map) {
        /*if (map.containsKey(Constants.TEXT))
            this.setText(map.get(Constants.TEXT));
        if (map.containsKey(Constants.TEXT_COLOR))
            this.setTextColor(Color.parseColor(map.get(Constants.TEXT_COLOR)));
        if (map.containsKey(Constants.TEXT_SIZE))
            this.setTextSize(Float.parseFloat(map.get(Constants.TEXT_SIZE)));
        if (map.containsKey(Constants.GRAVITY))
            this.setGravity(Integer.parseInt(map.get(Constants.GRAVITY)));*/


        Asset asset = map.get(key);
        String json = asset.getUiAttributes();

        /*try {

            JSONObject jsonObject = new JSONObject(json);
            String width = jsonObject.getString("width");
            String height = jsonObject.getString("height");
            String color = jsonObject.getString("color");
            String padding = jsonObject.getString("padding");
            String margin = jsonObject.getString("margin");

            int marginValue = Integer.parseInt(margin);

            this.setWidth(Integer.parseInt(width));
            this.setHeight(Integer.parseInt(height));
            this.setTextColor(Color.parseColor(color));
            this.setPadding(marginValue, marginValue, marginValue, marginValue);

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

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
