package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class LinearDesigner extends Designer {
    Context context;
    private LinearLayout layout;


    public LinearDesigner(Context context) {
        super(context);
        layout = new LinearLayout(context);
    }

    public LinearDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public LinearDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public LinearDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public LinearDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public LinearDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public LinearDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public LinearDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public LinearDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public LinearDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public LinearDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public LinearDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop = layout_margin;
        return this;
    }

    public LinearDesigner tag(Object tag){
        this.tag = tag;
        return this;
    }

    public LinearDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top = padding;
        this.padding_right = padding;
        return this;
    }

    public LinearDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public LinearDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public LinearDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public LinearDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public LinearDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public LinearDesigner orientation(int orientation) {
        this.orientation = orientation;
        return this;
    }

    public LinearDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }

    public LinearLayout getView(LinearLayout parent) {
        layout.setLayoutParams(getLinearlayoutParams());
        drawLinearLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public LinearLayout getView(LinearLayout parent, int index) {
        layout.setLayoutParams(getLinearlayoutParams());
        drawLinearLayout(layout);

        parent.addView(layout, index);
        return layout;
    }

    public LinearLayout getView(RelativeLayout parent) {
        layout.setLayoutParams(getRelativelayoutParams());
        drawLinearLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public LinearLayout getView(FrameLayout parent) {
        layout.setLayoutParams(getFramelayoutParams());
        drawLinearLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public LinearLayout getView(CardView parent) {
        layout.setLayoutParams(getCardViewParams());
        drawLinearLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public LinearLayout getView(ViewGroup parent) {
        layout.setLayoutParams(getViewGrouplayoutParams());
        drawLinearLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public LinearLayout getView() {
        layout.setLayoutParams(getViewGrouplayoutParams());
        drawLinearLayout(layout);
        return layout;
    }

}
