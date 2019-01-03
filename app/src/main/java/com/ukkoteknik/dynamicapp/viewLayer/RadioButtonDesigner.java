package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class RadioButtonDesigner extends Designer {
    RadioButton view;
    Context context;


    public RadioButtonDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public RadioButtonDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public RadioButtonDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public RadioButtonDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public RadioButtonDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public RadioButtonDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public RadioButtonDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public RadioButtonDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public RadioButtonDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public RadioButtonDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public RadioButtonDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop= layout_margin;
        return this;
    }

    public RadioButtonDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top= padding;
        this.padding_right= padding;
        return this;
    }


    public RadioButtonDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public RadioButtonDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public RadioButtonDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public RadioButtonDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public RadioButtonDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public RadioButtonDesigner text(String text) {
        this.text = text;
        return this;
    }

    public RadioButtonDesigner textColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public RadioButtonDesigner textColor(int textColor) {
        this.textColorInt = textColor;
        return this;
    }

    public RadioButtonDesigner textSize(float textSize) {
        this.textSize = textSize;
        return this;
    }

    public RadioButtonDesigner maxLines(int maxlines) {
        this.maxLines = maxlines;
        return this;
    }


    public RadioButtonDesigner checked(boolean checked) {
        this.checked = checked;
        return this;
    }

    public RadioButtonDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }

    public RadioButtonDesigner tag(String tag) {
        this.tag = tag;
        return this;
    }


    public RadioButtonDesigner(Context context) {
        super(context);
        view = new RadioButton(context);
        gravity = Gravity.CENTER_VERTICAL;
    }

    public RadioButton getView(LinearLayout parent) {
        view.setLayoutParams(getLinearlayoutParams());
        drawRadioButton(view);

        parent.addView(view);
        return view;
    }

    public RadioButton getView(FrameLayout parent) {
        view.setLayoutParams(getFramelayoutParams());
        drawRadioButton(view);

        parent.addView(view);
        return view;
    }
    
    public RadioButton getView(RelativeLayout parent) {
        view.setLayoutParams(getRelativelayoutParams());
        drawRadioButton(view);

        parent.addView(view);
        return view;
    }

    public RadioButton getView(ViewGroup parent) {
        view.setLayoutParams(getViewGrouplayoutParams());
        drawRadioButton(view);

        parent.addView(view);
        return view;
    }

}
