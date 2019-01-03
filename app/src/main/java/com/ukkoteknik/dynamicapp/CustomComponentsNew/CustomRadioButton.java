package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.widget.RadioButton;

import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

@SuppressLint("AppCompatCustomView")
public class CustomRadioButton extends RadioButton {

    public CustomRadioButton(Context context, String key) {
        super(context);
        setProperties(key);
    }

    public CustomRadioButton setRadioText(String value) {
        setText(value);
        return this;
    }


    public CustomRadioButton setProperties(String key) {
        Map<String, Asset> map = MyApp.instance.getAssetMap(key);

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

        return this;
    }
}
