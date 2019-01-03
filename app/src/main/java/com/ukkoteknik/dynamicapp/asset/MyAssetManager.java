package com.ukkoteknik.dynamicapp.asset;

import android.util.Log;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ukkoteknik.dynamicapp.realms.AssetModel;
import com.ukkoteknik.dynamicapp.realms.DetailedModel;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmList;

public class MyAssetManager {

    public Map<String, Asset> filldata() {
        String json = Constants.getJSONString(MyApp.instance);
        Map<String, Asset> map1 = putJsonStringToMap(json);
        return map1;
    }

    private Map<String, Asset> putJsonStringToMap(String json) {
        Map<String, Asset> map = new HashMap<>();
        try {
            JSONObject jsonOb = new JSONObject(json);
            Iterator<String> keys = jsonOb.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonOb.get(key);

                if (value instanceof JSONArray) {
                    JSONArray jsonArray = ((JSONArray) value);
                    long m = 1;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        List<Asset> listAsset = new ArrayList<>();
                        RealmList<Asset> list = new RealmList<>();
                        if (jsonObject.has("horizontalTemplate")) {
                            String templateType = jsonObject.getString("templateType");
                            DetailedModel detailedModel = new DetailedModel();
                            JSONArray jsonArray1 = jsonObject.getJSONArray("horizontalTemplate");
                            for (int j = 0; j < jsonArray1.length(); j++) {
                                JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                                Asset asset1 = jsonToAsset(jsonObject1, key);
                                //MyApp.instance.realm.executeTransaction(realm -> realm.insertOrUpdate(asset1));
                                map.put(jsonObject1.getString("key"), asset1);
                                //listAsset.add(asset1);
                                list.add(asset1);
                            }
                            detailedModel.setId(m);
                            detailedModel.setTemplateType(templateType);
                            detailedModel.setList(list);

                            MyApp.instance.realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    realm.insertOrUpdate(detailedModel);
                                }
                            });

                            m++;

                        } else {
                            Asset asset = jsonToAsset(jsonArray.getJSONObject(i), key);
                            MyApp.instance.realm.executeTransaction(realm -> realm.insertOrUpdate(asset));
                            map.put(jsonObject.getString("key"), asset);
                        }

                        if (jsonObject.has("className") && jsonObject.getString("className").equals("CustomListView")) {
                            JSONArray dataAttributes = jsonObject.getJSONArray("dataAttributes");
                            for (int j = 0; j < dataAttributes.length(); j++) {
                                JSONObject jsonObj = dataAttributes.getJSONObject(j).getJSONObject("displayAttribute");
                                JSONArray jsonArr1 = jsonObj.getJSONArray("itemTemplate");
                                for (int k = 0; k < jsonArr1.length(); k++) {
                                    JSONObject jsonObject1 = jsonArr1.getJSONObject(k);
                                    Asset asset1 = jsonToAsset(jsonObject1, key);
                                    map.put(jsonObject1.getString("key"), asset1);
                                    //MyApp.instance.realm.executeTransaction(realm -> realm.insertOrUpdate(asset1));
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }

    private Asset jsonToAsset(JSONObject jsonObject, String key) throws JSONException {
        Asset asset = new Asset();
        asset.setLabel(jsonObject.getString("label"));
        asset.setClassName(jsonObject.getString("className"));
        asset.setKey(jsonObject.getString("key"));
        asset.setType(jsonObject.getString("type"));
        asset.setUiAttributes(jsonObject.getString("uiAttributes"));
        asset.setDataAttributes(jsonObject.getString("dataAttributes"));
        asset.setId(jsonObject.getString("id"));
        asset.setDependency(jsonObject.getString("dependency"));
        asset.setScreenType(key);
        return asset;
    }

}



