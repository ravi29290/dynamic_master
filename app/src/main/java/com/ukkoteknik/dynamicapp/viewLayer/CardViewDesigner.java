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

public class CardViewDesigner extends Designer {
    CardView layout;
    Context context;

    public CardViewDesigner(Context context) {
        super(context);
        layout = new CardView(context);
    }

    public CardViewDesigner radius(float radius) {
        this.radius = radius;
        return this;
    }

    public CardViewDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public CardViewDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public CardViewDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public CardViewDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public CardViewDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public CardViewDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public CardViewDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public CardViewDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public CardViewDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public CardViewDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public CardViewDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop = layout_margin;
        return this;
    }

    public CardViewDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top = padding;
        this.padding_right = padding;
        return this;
    }

    public CardViewDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public CardViewDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public CardViewDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public CardViewDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public CardViewDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public CardViewDesigner orientation(int orientation) {
        this.orientation = orientation;
        return this;
    }

    public CardViewDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }

    public CardViewDesigner elevation(int elevation) {
        this.elevation = elevation;
        return this;
    }

    public CardView getView(LinearLayout parent) {
        layout.setLayoutParams(getLinearlayoutParams());
        drawCardView(layout);

        parent.addView(layout);
        return layout;
    }

    public CardView getView(LinearLayout parent, int index) {
        layout.setLayoutParams(getLinearlayoutParams());
        drawCardView(layout);

        parent.addView(layout, index);
        return layout;
    }

    public CardView getView(RelativeLayout parent) {
        layout.setLayoutParams(getRelativelayoutParams());
        drawCardView(layout);

        parent.addView(layout);
        return layout;
    }

    public CardView getView(FrameLayout parent) {
        layout.setLayoutParams(getFramelayoutParams());
        drawCardView(layout);

        parent.addView(layout);
        return layout;
    }

    public CardView getView() {
        layout.setLayoutParams(getFramelayoutParams());
        drawCardView(layout);

        return layout;
    }

    public CardView getView(ViewGroup parent) {
        layout.setLayoutParams(getViewGrouplayoutParams());
        drawCardView(layout);

        parent.addView(layout);
        return layout;
    }

}
