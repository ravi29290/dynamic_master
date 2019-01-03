package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class FrameDesigner extends Designer {
    FrameLayout layout;
    Context context;


    public FrameDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public FrameDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public FrameDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public FrameDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public FrameDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public FrameDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public FrameDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public FrameDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public FrameDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public FrameDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public FrameDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop= layout_margin;
        return this;
    }

    public FrameDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top= padding;
        this.padding_right= padding;
        return this;
    }


    public FrameDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public FrameDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public FrameDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public FrameDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public FrameDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }


    public FrameDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }


    public FrameDesigner(Context context) {
        super(context);
        layout = new FrameLayout(context);
    }

    public FrameLayout getView(LinearLayout parent) {
        layout.setLayoutParams(getLinearlayoutParams());
        drawFrameLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public FrameLayout getView(FrameLayout parent) {
        layout.setLayoutParams(getFramelayoutParams());
        drawFrameLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public FrameLayout getView(RelativeLayout parent) {
        layout.setLayoutParams(getRelativelayoutParams());
        drawFrameLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public FrameLayout getView(ViewGroup parent) {
        layout.setLayoutParams(getViewGrouplayoutParams());
        drawFrameLayout(layout);

        parent.addView(layout);
        return layout;
    }

}
