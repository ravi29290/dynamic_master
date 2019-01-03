package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class ButtonDesigner extends Designer {
    Button view;
    Context context;


    public ButtonDesigner(Context context) {
        super(context);
        view = new Button(context);
        gravity = Gravity.CENTER;
    }

    public ButtonDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public ButtonDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public ButtonDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public ButtonDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public ButtonDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public ButtonDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public ButtonDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public ButtonDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public ButtonDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public ButtonDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }

    public ButtonDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop = layout_margin;
        return this;
    }

    public ButtonDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top = padding;
        this.padding_right = padding;
        return this;
    }

    public ButtonDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public ButtonDesigner backgroundShape(GradientDrawable shape) {
        this.shape = shape;
        return this;
    }

    public ButtonDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public ButtonDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public ButtonDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public ButtonDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public ButtonDesigner text(String text) {
        this.text = text;
        return this;
    }

    public ButtonDesigner textColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public ButtonDesigner textColor(int textColor) {
        this.textColorInt = textColor;
        return this;
    }

    public ButtonDesigner textSize(float textSize) {
        this.textSize = textSize;
        return this;
    }

    public ButtonDesigner maxLines(int maxlines) {
        this.maxLines = maxlines;
        return this;
    }

    public ButtonDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }

    public Button getView(LinearLayout parent) {
        view.setLayoutParams(getLinearlayoutParams());
        drawButton(view);

        parent.addView(view);
        return view;
    }

    public Button getView(FrameLayout parent) {
        view.setLayoutParams(getFramelayoutParams());
        drawButton(view);

        parent.addView(view);
        return view;
    }

    public Button getView(RelativeLayout parent) {
        view.setLayoutParams(getRelativelayoutParams());
        drawButton(view);

        parent.addView(view);
        return view;
    }

    public Button getView(ViewGroup parent) {
        view.setLayoutParams(getViewGrouplayoutParams());
        drawButton(view);

        parent.addView(view);
        return view;
    }

}
