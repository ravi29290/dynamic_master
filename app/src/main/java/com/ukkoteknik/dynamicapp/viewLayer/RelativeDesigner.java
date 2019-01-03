package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class RelativeDesigner extends Designer {
    RelativeLayout layout;
    Context context;


    public RelativeDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public RelativeDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public RelativeDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public RelativeDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public RelativeDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public RelativeDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public RelativeDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public RelativeDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public RelativeDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public RelativeDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public RelativeDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop= layout_margin;
        return this;
    }

    public RelativeDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top= padding;
        this.padding_right= padding;
        return this;
    }


    public RelativeDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public RelativeDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public RelativeDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public RelativeDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public RelativeDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }


    public RelativeDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }


    public RelativeDesigner(Context context) {
        super(context);
        layout = new RelativeLayout(context);
    }

    public RelativeLayout getView(LinearLayout parent) {
        layout.setLayoutParams(getRelativelayoutParams());
        drawRelativeLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public RelativeLayout getView(FrameLayout parent) {
        layout.setLayoutParams(getFramelayoutParams());
        drawRelativeLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public RelativeLayout getView(RelativeLayout parent) {
        layout.setLayoutParams(getRelativelayoutParams());
        drawRelativeLayout(layout);

        parent.addView(layout);
        return layout;
    }

    public RelativeLayout getView(ViewGroup parent) {
        layout.setLayoutParams(getViewGrouplayoutParams());
        drawRelativeLayout(layout);

        parent.addView(layout);
        return layout;
    }

}
