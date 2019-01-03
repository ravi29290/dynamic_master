package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ukkoteknik.dynamicapp.ValueInteface;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class EditTextDesigner extends Designer {
    EditText view;
    Context context;


    public EditTextDesigner(Context context) {
        super(context);
        view = new EditText(context);
    }

    public EditTextDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public EditTextDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public EditTextDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public EditTextDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public EditTextDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public EditTextDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public EditTextDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public EditTextDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public EditTextDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public EditTextDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public EditTextDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop = layout_margin;
        return this;
    }

    public EditTextDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top = padding;
        this.padding_right = padding;
        return this;
    }

    public EditTextDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public EditTextDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public EditTextDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public EditTextDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public EditTextDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public EditTextDesigner text(String text) {
        this.text = text;
        return this;
    }

    public EditTextDesigner textColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public EditTextDesigner textColor(int textColor) {
        this.textColorInt = textColor;
        return this;
    }

    public EditTextDesigner hint(String hint) {
        this.hint = hint;
        return this;
    }

    public EditTextDesigner textSize(float textSize) {
        this.hint = hint;
        return this;
    }

    public EditTextDesigner maxLines(int maxlines) {
        this.maxLines = maxlines;
        return this;
    }

    public EditTextDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }

    public EditTextDesigner inputType(int inputType) {
        this.inputType = inputType;
        return this;
    }

    public EditTextDesigner maxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public EditText getView(LinearLayout parent) {
        view.setLayoutParams(getLinearlayoutParams());
        drawEditText(view);

        parent.addView(view);
        return view;
    }

    public EditText getView(FrameLayout parent) {
        view.setLayoutParams(getFramelayoutParams());
        drawEditText(view);

        parent.addView(view);
        return view;
    }

    public EditText getView(RelativeLayout parent) {
        view.setLayoutParams(getRelativelayoutParams());
        drawEditText(view);

        parent.addView(view);
        return view;
    }

    public EditText getView(ViewGroup parent) {
        view.setLayoutParams(getViewGrouplayoutParams());
        drawEditText(view);

        parent.addView(view);
        return view;
    }


}
