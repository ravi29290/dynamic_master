package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ukkoteknik.dynamicapp.ComponentValueChangeListener;
import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.OptionModel;
import com.ukkoteknik.dynamicapp.UserModel;
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

@SuppressLint("AppCompatCustomView")
public class CustomTextView extends TextView implements ValueInteface {

    private String key;
    private Context context;

    public CustomTextView(Context context, String key) {
        super(context);
        this.context = context;
        this.key = key;
        setProperties(key);
    }

    public CustomTextView setProperties(String key) {
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
        Asset asset = map.get(key);
        String textJson = asset.getDataAttributes();

        setManualText(asset.getLabel());
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
        this.setText(value);
    }


}
