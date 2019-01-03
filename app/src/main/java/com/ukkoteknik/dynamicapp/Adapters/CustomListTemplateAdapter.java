package com.ukkoteknik.dynamicapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ukkoteknik.dynamicapp.CustomComponentsNew.CustomButton;
import com.ukkoteknik.dynamicapp.CustomComponentsNew.CustomTextView;
import com.ukkoteknik.dynamicapp.R;
import com.ukkoteknik.dynamicapp.UserModel;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.activities.DetailedActivity;
import com.ukkoteknik.dynamicapp.activities.ListViewTemplateActivity;
import com.ukkoteknik.dynamicapp.asset.Asset;

import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomListTemplateAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, String>> list_map;
    private Map<String, Object> mapAsset;

    private List<Map<String, Object>> listMapAsset;

    public CustomListTemplateAdapter(Context context, List<Map<String, String>> list_map, List<Map<String, Object>> listMapAsset) {
        this.context = context;
        this.list_map = list_map;
        this.listMapAsset = listMapAsset;
    }

    @Override
    public int getCount() {
        return list_map.size();
    }

    @Override
    public Object getItem(int i) {
        return list_map.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.custom_layout_item, null);
        LinearLayout linearLayout = view1.findViewById(R.id.linear_custom);

        Map<String, String> map = list_map.get(i);
        for (int j = 0; j < listMapAsset.size(); j++) {
            Map<String, Object> mapAsset = listMapAsset.get(j);
            try {
                Class aClass = Class.forName("com.ukkoteknik.dynamicapp.CustomComponentsNew" + "." + mapAsset.get("className"));
                Constructor<?> ctr = aClass.getConstructor(Context.class, String.class);
                Object object = ctr.newInstance(context, mapAsset.get("key"));
                ((ValueInteface) object).setManualText(map.get(mapAsset.get("value")));
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

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailedActivity.class));
            }
        });

        return view1;
    }

}




