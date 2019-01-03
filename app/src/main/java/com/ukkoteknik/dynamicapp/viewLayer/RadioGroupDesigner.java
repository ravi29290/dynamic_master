package com.ukkoteknik.dynamicapp.viewLayer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class RadioGroupDesigner extends Designer {
    public RadioGroup layout;
    public Context context;


    public RadioGroupDesigner width(int layout_width) {
        this.layout_width = layout_width;
        return this;
    }

    public RadioGroupDesigner height(int layout_height) {
        this.layout_height = layout_height;
        return this;
    }

    public RadioGroupDesigner paddingLeft(int padding_left) {
        this.padding_left = padding_left;
        return this;
    }

    public RadioGroupDesigner paddingRight(int padding_right) {
        this.padding_right = padding_right;
        return this;
    }

    public RadioGroupDesigner paddingTop(int padding_top) {
        this.padding_top = padding_top;
        return this;
    }

    public RadioGroupDesigner paddingBottom(int padding_bottom) {
        this.padding_bottom = padding_bottom;
        return this;
    }

    public RadioGroupDesigner marginLeft(int layout_marginLeft) {
        this.layout_marginLeft = layout_marginLeft;
        return this;
    }

    public RadioGroupDesigner marginRight(int layout_marginRight) {
        this.layout_marginRight = layout_marginRight;
        return this;
    }

    public RadioGroupDesigner marginTop(int layout_marginTop) {
        this.layout_marginTop = layout_marginTop;
        return this;
    }

    public RadioGroupDesigner marginBottom(int layout_marginBottom) {
        this.layout_marginBottom = layout_marginBottom;
        return this;
    }


    public RadioGroupDesigner margin(int layout_margin) {
        this.layout_marginBottom = layout_margin;
        this.layout_marginLeft = layout_margin;
        this.layout_marginRight = layout_margin;
        this.layout_marginTop= layout_margin;
        return this;
    }

    public RadioGroupDesigner padding(int padding) {
        this.padding_bottom = padding;
        this.padding_left = padding;
        this.padding_top= padding;
        this.padding_right= padding;
        return this;
    }


    public RadioGroupDesigner backgroundResource(int background_resource) {
        this.background_resource = background_resource;
        return this;
    }

    public RadioGroupDesigner backgroundColor(String background_color) {
        this.background_color = background_color;
        return this;
    }

    public RadioGroupDesigner visibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public RadioGroupDesigner layoutGravity(int layout_gravity) {
        this.layout_gravity = layout_gravity;
        return this;
    }

    public RadioGroupDesigner gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public RadioGroupDesigner orientation(int orientation) {
        this.orientation = orientation;
        return this;
    }

    public RadioGroupDesigner weight(int weight) {
        this.weight = weight;
        return this;
    }




    public RadioGroupDesigner(Context context) {
        super(context);
        layout = new RadioGroup(context);
    }


    public RadioGroup getView(LinearLayout parent) {
        layout.setLayoutParams(getLinearlayoutParams());
        drawRadioGroup(layout);

        parent.addView(layout);
        return layout;
    }

    public RadioGroup getView(RelativeLayout parent) {
        layout.setLayoutParams(getRelativelayoutParams());
        drawRadioGroup(layout);

        parent.addView(layout);
        return layout;
    }

    public RadioGroup getView(FrameLayout parent) {
        layout.setLayoutParams(getFramelayoutParams());
        drawRadioGroup(layout);

        parent.addView(layout);
        return layout;
    }
    public RadioGroup getView(ViewGroup parent) {
        layout.setLayoutParams(getViewGrouplayoutParams());
        drawRadioGroup(layout);

        parent.addView(layout);
        return layout;
    }

}
