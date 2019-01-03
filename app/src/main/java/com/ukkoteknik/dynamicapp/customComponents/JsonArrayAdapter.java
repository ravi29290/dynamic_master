package com.ukkoteknik.dynamicapp.customComponents;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ukkoteknik.dynamicapp.R;

public class JsonArrayAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final JsonArray jsonArray;
    Resources resources;
    String packageName;

    public JsonArrayAdapter(@NonNull Context context, JsonArray jsonArray) {
        super(context, R.layout.simple_dropdown);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.jsonArray = jsonArray;
        resources = context.getResources();
        packageName = context.getPackageName();
    }

    public JsonArray getData() {
        return jsonArray;
    }

    @Override
    public int getCount() {
        return jsonArray.size();
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        JsonObject jsonObject = jsonArray.get(position).getAsJsonObject();
        final TextView view = (TextView) mInflater.inflate(R.layout.simple_dropdown, parent, false);
        view.setText(resources.getIdentifier(jsonObject.get("name").getAsString(), "string", packageName));
        view.setTag(jsonObject.get("value").getAsString());

        return view;
    }
}