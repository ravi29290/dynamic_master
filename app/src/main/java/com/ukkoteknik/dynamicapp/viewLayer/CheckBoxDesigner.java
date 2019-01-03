package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class CheckBoxDesigner extends Designer {
    CheckBox view;
    Context context;


    public CheckBoxDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public CheckBoxDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public CheckBoxDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public CheckBoxDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public CheckBoxDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public CheckBoxDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public CheckBoxDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public CheckBoxDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public CheckBoxDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public CheckBoxDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public CheckBoxDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop= layout_margin;
        return this;
    }

    public CheckBoxDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top= padding;
        this.padding_right= padding;
        return this;
    }


    public CheckBoxDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public CheckBoxDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public CheckBoxDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public CheckBoxDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public CheckBoxDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public CheckBoxDesigner text(String text) {
        this.text = text;
        return this;
    }

    public CheckBoxDesigner textColor(String textColor) {
        this.textColor = textColor;
        return this;
    }
    public CheckBoxDesigner textColor(int textColor) {
        this.textColorInt = textColor;
        return this;
    }

    public CheckBoxDesigner textSize(float textSize) {
        this.textSize = textSize;
        return this;
    }

    public CheckBoxDesigner maxLines(int maxlines) {
        this.maxLines = maxlines;
        return this;
    }


    public CheckBoxDesigner checked(boolean checked) {
        this.checked = checked;
        return this;
    }


    public CheckBoxDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }
    public CheckBoxDesigner tag(Object tag) {
        this.tag = tag;
        return this;
    }






    public CheckBoxDesigner(Context context) {
        super(context);
        view = new CheckBox(context);
        gravity = Gravity.CENTER_VERTICAL;
    }

    public CheckBox getView(LinearLayout parent) {
        view.setLayoutParams(getLinearlayoutParams());
        drawCheckBox(view);

        parent.addView(view);
        return view;
    }

    public CheckBox getView(FrameLayout parent) {
        view.setLayoutParams(getFramelayoutParams());
        drawCheckBox(view);

        parent.addView(view);
        return view;
    }
    
    public CheckBox getView(RelativeLayout parent) {
        view.setLayoutParams(getRelativelayoutParams());
        drawCheckBox(view);

        parent.addView(view);
        return view;
    }

    public CheckBox getView(ViewGroup parent) {
        view.setLayoutParams(getViewGrouplayoutParams());
        drawCheckBox(view);

        parent.addView(view);
        return view;
    }

}
