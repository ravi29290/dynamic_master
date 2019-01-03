package com.ukkoteknik.dynamicapp.CustomComponentsNew;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ukkoteknik.dynamicapp.Adapters.CustomListTemplateAdapter;
import com.ukkoteknik.dynamicapp.ComponentValueChangeListener;
import com.ukkoteknik.dynamicapp.FormTemplate;
import com.ukkoteknik.dynamicapp.OptionModel;
import com.ukkoteknik.dynamicapp.UserModel;
import com.ukkoteknik.dynamicapp.ValueInteface;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.realm.RealmResults;

public class CustomListView extends ListView implements ValueInteface {

    private String key;
    private Context context;
    private List<Map<String, Object>> listMapAsset = new ArrayList<>();
    boolean detailedView = false;

    public CustomListView(Context context, String key) {
        super(context);
        this.context = context;
        this.key = key;
        setProperties(key);
    }

    public CustomListView setProperties(String key) {
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
        List<Map<String, String>> listMap = putDataInMap(textJson);


        CustomListTemplateAdapter customListTemplateAdapter = new CustomListTemplateAdapter(context, listMap, listMapAsset);
        this.setAdapter(customListTemplateAdapter);

        /*if (detailedView) {
            this.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(context, "pos : " + i, Toast.LENGTH_SHORT).show();
                }
            });
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

    private List<Map<String, String>> putDataInMap(String textJson) {
        List<Map<String, String>> listMap = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(textJson);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            detailedView = jsonObject.getBoolean("detailedView");
            Iterator<String> keysItr = jsonObject.keys();
            while (keysItr.hasNext()) {
                String key = keysItr.next();
                Object value = jsonObject.get(key);
                if (value instanceof JSONArray) {
                    for (int j = 0; j < ((JSONArray) value).length(); j++) {
                        JSONObject jsonObject1 = ((JSONArray) value).getJSONObject(j);
                        Iterator<String> iterator = jsonObject1.keys();
                        Map<String, String> map = new HashMap<>();
                        while (iterator.hasNext()) {
                            String key1 = iterator.next();
                            map.put(key1, jsonObject1.getString(key1));
                        }
                        listMap.add(map);
                    }
                } else if (value instanceof JSONObject) {
                    Iterator<String> jsonObjectIterator = ((JSONObject) value).keys();
                    while (jsonObjectIterator.hasNext()) {
                        String key1 = jsonObjectIterator.next();
                        Object object = ((JSONObject) value).get(key1);
                        if (object instanceof JSONArray) {
                            JSONArray jsonArray1 = ((JSONArray) object);
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                Map<String, Object> map = new HashMap<>();
                                JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                                Iterator<String> iterator = jsonObject1.keys();
                                while (iterator.hasNext()) {
                                    String key2 = iterator.next();
                                    Object object1 = jsonObject1.get(key2);
                                    map.put(key2, object1);
                                }
                                listMapAsset.add(map);
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listMap;
    }
}
