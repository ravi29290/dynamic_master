package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ukkoteknik.dynamicapp.ComponentValueChangeListener;
import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.OptionModel;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.Constants;

import java.io.File;
import java.util.List;
import java.util.Map;

@SuppressLint("AppCompatCustomView")
public class CustomImageView extends ImageView implements ValueInteface {

    private Context context;

    public CustomImageView(Context context, String key) {
        super(context);
        this.context=context;
        setProperties(key);
    }

    public CustomImageView setProperties(String key) {
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
        return null;
    }

    @Override
    public void setAttributes(Map<String, Asset> map) {

        /*LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(layoutParams);

        if (map.containsKey(Constants.WIDTH))
            this.getLayoutParams().width = Integer.parseInt(map.get(Constants.WIDTH));
        if (map.containsKey(Constants.HEIGHT))
            this.getLayoutParams().height = Integer.parseInt(map.get(Constants.HEIGHT));
        if (map.containsKey(Constants.IMAGE)) {
            Bitmap myBitmap = null;
            File imgFile = new File(map.get(Constants.IMAGE));
            if (imgFile.exists()) {
                myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            }
            this.setImageBitmap(myBitmap);
        }
        if (map.containsKey(Constants.GRAVITY))
            layoutParams.gravity = Gravity.CENTER;
        if (map.containsKey(Constants.SCALE_TYPE)) {
            if (map.get(Constants.SCALE_TYPE).equals("fitxy"))
                this.setScaleType(ScaleType.FIT_XY);
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
