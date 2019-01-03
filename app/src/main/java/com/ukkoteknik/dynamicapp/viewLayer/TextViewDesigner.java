package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class TextViewDesigner extends Designer {
    TextView view;
    Context context;


    public TextViewDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public TextViewDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public TextViewDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public TextViewDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public TextViewDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public TextViewDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public TextViewDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public TextViewDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public TextViewDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public TextViewDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public TextViewDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop = layout_margin;
        return this;
    }

    public TextViewDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top = padding;
        this.padding_right = padding;
        return this;
    }


    public TextViewDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public TextViewDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public TextViewDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public TextViewDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public TextViewDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public TextViewDesigner text(String text) {
        this.text = text;
        return this;
    }

    public TextViewDesigner textColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public TextViewDesigner textColor(int textColor) {
        this.textColorInt = textColor;
        return this;
    }

    public TextViewDesigner textSize(float textSize) {
        this.textSize = textSize;
        return this;
    }

    public TextViewDesigner maxLines(int maxlines) {
        this.maxLines = maxlines;
        return this;
    }

    public TextViewDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }

    public TextViewDesigner tag(Object tag) {
        this.tag = tag;
        return this;
    }


    public TextViewDesigner(Context context) {
        super(context);
        view = new TextView(context);
    }

    public TextView getView(LinearLayout parent) {
        view.setLayoutParams(getLinearlayoutParams());
        drawTextView(view);

        parent.addView(view);
        return view;
    }

    public TextView getView(FrameLayout parent) {
        view.setLayoutParams(getFramelayoutParams());
        drawTextView(view);

        parent.addView(view);
        return view;
    }

    public TextView getView(RelativeLayout parent) {
        view.setLayoutParams(getRelativelayoutParams());
        drawTextView(view);

        parent.addView(view);
        return view;
    }

    public TextView getView(ViewGroup parent) {
        view.setLayoutParams(getViewGrouplayoutParams());
        drawTextView(view);

        parent.addView(view);
        return view;
    }

}
