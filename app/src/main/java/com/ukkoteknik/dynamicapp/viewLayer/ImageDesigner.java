package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class ImageDesigner extends Designer {
    ImageView view;
    Context context;


    public ImageDesigner(Context context) {
        super(context);
        view = new ImageView(context);
        this.context = context;
        gravity = Gravity.CENTER_VERTICAL;
    }

    public ImageDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public ImageDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public ImageDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public ImageDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public ImageDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public ImageDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public ImageDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public ImageDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public ImageDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public ImageDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public ImageDesigner src(int src) {
        this.src = src;
        return this;
    }

    public ImageDesigner bitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        return this;
    }

    public ImageDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop = layout_margin;
        return this;
    }

    public ImageDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top = padding;
        this.padding_right = padding;
        return this;
    }

    public ImageDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public ImageDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public ImageDesigner tag(String tag) {
        this.tag = tag;
        return this;
    }


    public ImageView getView(LinearLayout parent) {
        view.setLayoutParams(getLinearlayoutParams());
        drawImageView(view);

        parent.addView(view);
        return view;
    }

    public ImageView getView(FrameLayout parent) {
        view.setLayoutParams(getFramelayoutParams());
        drawImageView(view);

        parent.addView(view);
        return view;
    }

    public ImageView getView(RelativeLayout parent) {
        view.setLayoutParams(getRelativelayoutParams());
        drawImageView(view);

        parent.addView(view);
        return view;
    }

    public ImageView getView(ViewGroup parent) {
        view.setLayoutParams(getViewGrouplayoutParams());
        drawImageView(view);

        parent.addView(view);
        return view;
    }

}
