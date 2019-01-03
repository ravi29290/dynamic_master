package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class RatingBarDesigner extends Designer {
    RatingBar view;
    Context context;


    public RatingBarDesigner(Context context) {
        super(context);
        view = new RatingBar(context);
        gravity = Gravity.CENTER;
    }

    public RatingBarDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public RatingBarDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public RatingBarDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public RatingBarDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public RatingBarDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public RatingBarDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public RatingBarDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public RatingBarDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public RatingBarDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public RatingBarDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public RatingBarDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop = layout_margin;
        return this;
    }

    public RatingBarDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top = padding;
        this.padding_right = padding;
        return this;
    }


    public RatingBarDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public RatingBarDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public RatingBarDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }
    
    public RatingBarDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }

    public RatingBarDesigner noOfStars(int noOfStars) {
        this.noOfStars = noOfStars;
        return this;
    }

    public RatingBarDesigner isIndicator(boolean isIndicator) {
        this.isIndicator = isIndicator;
        return this;
    }

    public RatingBarDesigner stepSize(float stepSize) {
        this.stepSize = stepSize;
        return this;
    }

    public RatingBarDesigner rating(float rating) {
        this.rating = rating;
        return this;
    }

    public RatingBar getView(LinearLayout parent) {
        view.setLayoutParams(getLinearlayoutParams());
        drawRating(view);

        parent.addView(view);
        return view;
    }

    public RatingBar getView(FrameLayout parent) {
        view.setLayoutParams(getFramelayoutParams());
        drawRating(view);

        parent.addView(view);
        return view;
    }

    public RatingBar getView(RelativeLayout parent) {
        view.setLayoutParams(getRelativelayoutParams());
        drawRating(view);

        parent.addView(view);
        return view;
    }

    public RatingBar getView(ViewGroup parent) {
        view.setLayoutParams(getViewGrouplayoutParams());
        drawRating(view);

        parent.addView(view);
        return view;
    }

}
