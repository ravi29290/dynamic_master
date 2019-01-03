package com.ukkoteknik.dynamicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ukkoteknik.dynamicapp.singleTon.MyApp;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<OptionModel> list;

    public CustomAdapter(Context context, List<OptionModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView view1 = (TextView) LayoutInflater.from(context).inflate(R.layout.simple_dropdown, viewGroup, false);
        view1.setText(list.get(i).getName());
        return view1;
    }
}
