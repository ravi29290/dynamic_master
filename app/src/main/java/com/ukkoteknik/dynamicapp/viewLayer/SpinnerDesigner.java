package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.gson.JsonArray;

import java.util.List;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class SpinnerDesigner extends Designer {
    Spinner view;
    Context context;


    public SpinnerDesigner(Context context) {
        super(context);
        view = new Spinner(context);
        this.context = context;
        gravity = Gravity.CENTER_VERTICAL;
    }

    public SpinnerDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public SpinnerDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public SpinnerDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public SpinnerDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public SpinnerDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public SpinnerDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public SpinnerDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public SpinnerDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public SpinnerDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public SpinnerDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public SpinnerDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop = layout_margin;
        return this;
    }

    public SpinnerDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top = padding;
        this.padding_right = padding;
        return this;
    }

    public SpinnerDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public SpinnerDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public SpinnerDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public SpinnerDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public SpinnerDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public SpinnerDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }

    public SpinnerDesigner tag(String tag) {
        this.tag = tag;
        return this;
    }

    public SpinnerDesigner items(CharSequence[] spinnerItems) {
        this.spinnerItems = spinnerItems;
        return this;
    }

    public SpinnerDesigner items(List<String> spinnerItems) {
        this.spinnerItemsList = spinnerItems;
        return this;
    }

    public SpinnerDesigner items(JsonArray jsonArray) {
        this.spinnerItemsJson = jsonArray;
        return this;
    }


    public Spinner getView(LinearLayout parent) {
        view.setLayoutParams(getLinearlayoutParams());
        drawSpinner(view);

        parent.addView(view);
        return view;
    }

    public Spinner getView(FrameLayout parent) {
        view.setLayoutParams(getFramelayoutParams());
        drawSpinner(view);

        parent.addView(view);
        return view;
    }

    public Spinner getView(RelativeLayout parent) {
        view.setLayoutParams(getRelativelayoutParams());
        drawSpinner(view);

        parent.addView(view);
        return view;
    }

    public Spinner getView(ViewGroup parent) {
        view.setLayoutParams(getViewGrouplayoutParams());
        drawSpinner(view);

        parent.addView(view);
        return view;
    }

}
