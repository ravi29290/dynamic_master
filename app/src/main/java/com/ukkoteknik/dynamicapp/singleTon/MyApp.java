package com.ukkoteknik.dynamicapp.singleTon;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ukkoteknik.dynamicapp.asset.Asset;
import com.ukkoteknik.dynamicapp.asset.MyAssetManager;
import com.ukkoteknik.dynamicapp.retrofit.APIClient;
import com.ukkoteknik.dynamicapp.retrofit.APIInterface;
import com.ukkoteknik.dynamicapp.utils.Constants;
import com.ukkoteknik.dynamicapp.utils.gson.AnnotationExclusionStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by  Manoj Sadhu on 10/31/2018.
 */
public class MyApp extends Application {
    public static APIInterface apiInterface;
    public static RealmConfiguration realmConfiguration;
    public static RealmConfiguration realmConfigurationInMemory;
    public static MyApp instance;
    public static Gson gson;
    public Realm realm, realmInmemory;
    public MyAssetManager myAssetManager;
    private static Map<String, Asset> map = new HashMap<>();

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isAcceptingText()) {
            View view = activity.getCurrentFocus();
            if (view == null) {
                view = new View(activity);
            }
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        gson = new GsonBuilder()
                //.serializeNulls()
                .setExclusionStrategies(new AnnotationExclusionStrategy())
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Realm.init(getApplicationContext());
        realmConfiguration = new RealmConfiguration.Builder()
                .name(Constants.DATABASE_NAME)
                .schemaVersion(Constants.DATABASE_VERSION)
                .compactOnLaunch()
                .build();
        Realm.compactRealm(realmConfiguration);
        realmConfigurationInMemory = new RealmConfiguration.Builder()
                .inMemory()
                .schemaVersion(Constants.DATABASE_VERSION)
                .build();
        realm = Realm.getInstance(MyApp.realmConfiguration);
        realmInmemory = Realm.getInstance(MyApp.realmConfigurationInMemory);

        myAssetManager = new MyAssetManager();
        map = myAssetManager.filldata();

    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Asset getAsset(String key) {
        return map.get(key);
    }

    public Map<String, Asset> getAssetMap(String key) {
        Asset assets = map.get(key);
        Map<String, Asset> stringStringMap = new HashMap<>();
        stringStringMap.put(assets.getKey(), assets);
        return stringStringMap;
    }


}
