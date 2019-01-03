package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

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

import java.util.List;
import java.util.Map;

@SuppressLint("AppCompatCustomView")
public class CustomEditText extends EditText implements ValueInteface {

    private String key;
    private Context context;

    public CustomEditText(Context context, String key) {
        super(context);
        this.context = context;
        this.key = key;
        setProperties(key);
    }

    public CustomEditText setProperties(String key) {
        Map<String, Asset> map = MyApp.instance.getAssetMap(key);
        setAttributes(map);
        return this;
    }


    @Override
    public String getValue() {
        return getText().toString();
    }

    @Override
    public String getKeyType() {
        return key;
    }


    @Override
    public void setAttributes(Map<String, Asset> map) {

        Asset asset = map.get(key);
        String json = asset.getDataAttributes();
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String placeHolder = jsonObject.getString("placeHolder");
            this.setHint(placeHolder);

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
