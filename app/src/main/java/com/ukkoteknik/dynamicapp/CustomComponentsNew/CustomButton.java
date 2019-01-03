package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ukkoteknik.dynamicapp.ComponentValueChangeListener;
import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.OptionModel;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.Constants;

import java.util.List;
import java.util.Map;

@SuppressLint("AppCompatCustomView")
public class CustomButton extends Button implements ValueInteface {

    static float density;
    protected int layout_width = ViewGroup.LayoutParams.MATCH_PARENT;
    protected int layout_height = ViewGroup.LayoutParams.WRAP_CONTENT;

    protected int padding_left = 0;
    protected int padding_right = 0;
    protected int padding_top = 0;
    protected int padding_bottom = 0;

    protected int layout_marginLeft = 0;
    protected int layout_marginRight = 0;
    protected int layout_marginTop = 0;
    protected int layout_marginBottom = 0;

    protected int layout_gravity = Gravity.NO_GRAVITY;
    protected int gravity = Gravity.NO_GRAVITY;
    protected int weight = 0;
    LinearLayout.LayoutParams params = getLinearlayoutParams();

    Context context;
    String key;

    public CustomButton(Context context, String key) {
        super(context);
        this.context = context;
        this.key = key;
        setProperties(key);
    }

    public CustomButton setProperties(String key) {
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
            this.setGravity(Integer.parseInt(map.get(Constants.GRAVITY)));
        if (map.containsKey(Constants.MARGIN_LEFT)) {
            int value = Integer.parseInt(map.get(Constants.MARGIN_LEFT));
            params.setMargins(value, 0, 0, 0);
            this.setLayoutParams(params);
        }
        if (map.containsKey(Constants.MARGIN_RIGHT)) {
            int value = Integer.parseInt(map.get(Constants.MARGIN_RIGHT));
            params.setMargins(0, 0, value, 0);
            this.setLayoutParams(params);
        }
        if (map.containsKey(Constants.MARGIN_TOP)) {
            int value = Integer.parseInt(map.get(Constants.MARGIN_TOP));
            params.setMargins(0, value, 0, 0);
            this.setLayoutParams(params);
        }
        if (map.containsKey(Constants.MARGIN_BOTTOM)) {
            int value = Integer.parseInt(map.get(Constants.MARGIN_BOTTOM));
            params.setMargins(0, 0, 0, value);
            this.setLayoutParams(params);
        }
        if (map.containsKey(Constants.MARGIN)) {
            int value = Integer.parseInt(map.get(Constants.MARGIN));
            params.setMargins(value, value, value, value);
            this.setLayoutParams(params);
        }
        if (map.containsKey(Constants.PADDING_LEFT)) {
            int value = Integer.parseInt(map.get(Constants.PADDING_LEFT));
            this.setPadding(value, 0, 0, 0);
        }
        if (map.containsKey(Constants.PADDING_RIGHT)) {
            int value = Integer.parseInt(map.get(Constants.PADDING_RIGHT));
            this.setPadding(0, 0, value, 0);
        }
        if (map.containsKey(Constants.PADDING_TOP)) {
            int value = Integer.parseInt(map.get(Constants.PADDING_TOP));
            this.setPadding(0, value, 0, 0);
        }
        if (map.containsKey(Constants.PADDING_BOTTOM)) {
            int value = Integer.parseInt(map.get(Constants.PADDING_BOTTOM));
            this.setPadding(0, 0, 0, value);
        }
        if (map.containsKey(Constants.PADDING)) {
            int value = Integer.parseInt(map.get(Constants.PADDING));
            this.setPadding(value, value, value, value);
        }

        if (map.containsKey(Constants.BACKGROUND)) {
            GradientDrawable myGrad = new GradientDrawable();
            myGrad.setShape(GradientDrawable.RECTANGLE);
            myGrad.setCornerRadius(25);
            myGrad.setStroke(2, Color.BLACK);
            this.setBackground(myGrad);
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


    protected LinearLayout.LayoutParams getLinearlayoutParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (layout_width == -1 || layout_width == -2) ? layout_width : (int) (layout_width * density),
                (layout_height == -1 || layout_height == -2) ? layout_height : (int) (layout_height * density),
                weight
        );
        return params;
    }



}
