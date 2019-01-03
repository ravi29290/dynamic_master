package com.ukkoteknik.dynamicapp.viewLayer;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.gson.JsonArray;
import com.ukkoteknik.dynamicapp.R;
import com.ukkoteknik.dynamicapp.customComponents.JsonArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  ManojSadhu on 2/8/2018.
 */

public class Designer {
    static float density;
    protected int layout_width = ViewGroup.LayoutParams.WRAP_CONTENT;
    protected int layout_height = ViewGroup.LayoutParams.WRAP_CONTENT;

    protected int padding_left = 0;
    protected int padding_right = 0;
    protected int padding_top = 0;
    protected int padding_bottom = 0;

    protected int layout_marginLeft = 0;
    protected int layout_marginRight = 0;
    protected int layout_marginTop = 0;
    protected int layout_marginBottom = 0;

    protected int background_resource = 0;
    protected String background_color = "";

    protected GradientDrawable shape = null;

    protected int visibility = View.VISIBLE;

    protected int layout_gravity = Gravity.NO_GRAVITY;
    protected int gravity = Gravity.NO_GRAVITY;

    //for linearlayout
    protected int orientation = LinearLayout.VERTICAL;
    protected int weight = 0;
    //for all text type views
    protected String text = "";
    protected String textColor = "";
    protected int textColorInt = 0;
    protected float textSize = 18;
    protected int maxLines = 0;
    protected boolean checked = false;
    protected String hint = "";
    protected int inputType = InputType.TYPE_CLASS_TEXT;
    //only for editText
    protected int maxLength = 0;
    //for CardView
    protected float radius = 0;
    protected float elevation = 0;

    //only for image
    protected int src = 0;
    protected Bitmap bitmap = null;

    //only for Ratingbar
    protected int noOfStars = 5;
    protected float rating = 0;
    protected boolean isIndicator = false;
    protected float stepSize = 0.5f;

    //for single and multi select
    CharSequence[] spinnerItems = null;
    List<String> spinnerItemsList = null;
    JsonArray spinnerItemsJson = null;

    Object tag = null;


    Context context;

    Designer(Context context) {
        this.context = context;
        density = context.getResources().getDisplayMetrics().density;

    }

    public static void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins((int) (left * density), (int) (top * density), (int) (right * density), (int) (bottom * density));
            view.requestLayout();
        }
    }

    public static void setColor(View view, float index, int total) {
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        float fraction = 1.0f - index / total;
        int color = (int) argbEvaluator.evaluate(fraction, Color.parseColor("#42C3FC"), Color.parseColor("#005bb4")); //blue gray
        view.setBackgroundColor(color);
    }

    public static void setLiteColor(View view, float index, int total) {
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        float fraction = 1.0f - index / total;
        int color = (int) argbEvaluator.evaluate(fraction, Color.parseColor("#42C3FC"), Color.parseColor("#2c82d6")); //blue gray
        view.setBackgroundColor(color);
    }

    public static void setColors(View... views) {
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        int viewsLength = views.length;
        for (int index = 0; index < viewsLength; index++) {
            View view = views[index];
            float fraction = 1.0f - ((float) index / viewsLength);
            int color = (int) argbEvaluator.evaluate(fraction, Color.parseColor("#42C3FC"), Color.parseColor("#005bb4")); //blue gray
            view.setBackgroundColor(color);
        }
    }

    protected ViewGroup.LayoutParams getViewGrouplayoutParams() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                (layout_width == -1 || layout_width == -2) ? layout_width : (int) (layout_width * density),
                (layout_height == -1 || layout_height == -2) ? layout_height : (int) (layout_height * density)
        );
        return params;
    }

    protected LinearLayout.LayoutParams getLinearlayoutParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (layout_width == -1 || layout_width == -2) ? layout_width : (int) (layout_width * density),
                (layout_height == -1 || layout_height == -2) ? layout_height : (int) (layout_height * density),
                weight
        );
        params.gravity = layout_gravity;
        return params;
    }

    protected RelativeLayout.LayoutParams getRelativelayoutParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                (layout_width == -1 || layout_width == -2) ? layout_width : (int) (layout_width * density),
                (layout_height == -1 || layout_height == -2) ? layout_height : (int) (layout_height * density)
        );
        return params;
    }

    protected FrameLayout.LayoutParams getFramelayoutParams() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                (layout_width == -1 || layout_width == -2) ? layout_width : (int) (layout_width * density),
                (layout_height == -1 || layout_height == -2) ? layout_height : (int) (layout_height * density)
        );
        params.gravity = layout_gravity;
        return params;
    }

    protected CardView.LayoutParams getCardViewParams() {
        CardView.LayoutParams params = new CardView.LayoutParams(
                (layout_width == -1 || layout_width == -2) ? layout_width : (int) (layout_width * density),
                (layout_height == -1 || layout_height == -2) ? layout_height : (int) (layout_height * density)
        );
        params.gravity = layout_gravity;
        return params;
    }

    protected void drawFrameLayout(FrameLayout layout) {
        layout.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        layout.setVisibility(visibility);

        if (background_resource != 0)
            layout.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            layout.setBackgroundColor(Color.parseColor(background_color));

        setMargins(layout, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawCardView(CardView layout) {
        layout.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        layout.setVisibility(visibility);
        layout.setRadius(radius * density);
        layout.setCardElevation(elevation);

        if (background_resource != 0)
            layout.setCardBackgroundColor(background_resource);

        if (!TextUtils.isEmpty(background_color))
            layout.setBackgroundColor(Color.parseColor(background_color));

        setMargins(layout, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawLinearLayout(LinearLayout layout) {
        layout.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        layout.setVisibility(visibility);
        if (tag != null)
            layout.setTag(tag);

        if (background_resource != 0)
            layout.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            layout.setBackgroundColor(Color.parseColor(background_color));

        layout.setOrientation(orientation);
        layout.setGravity(gravity);

        setMargins(layout, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawRadioGroup(RadioGroup layout) {
        layout.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        layout.setVisibility(visibility);

        if (background_resource != 0)
            layout.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            layout.setBackgroundColor(Color.parseColor(background_color));

        layout.setGravity(gravity);
        layout.setOrientation(orientation);

        setMargins(layout, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawRelativeLayout(RelativeLayout layout) {
        layout.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        layout.setVisibility(visibility);

        if (background_resource != 0)
            layout.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            layout.setBackgroundColor(Color.parseColor(background_color));

        layout.setGravity(gravity);

        setMargins(layout, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawTextView(TextView view) {
        view.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        view.setVisibility(visibility);

        if (tag != null)
            view.setTag(tag);


        if (background_resource != 0)
            view.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            view.setBackgroundColor(Color.parseColor(background_color));

        view.setGravity(gravity);
        view.setText(text);
        view.setTextSize(textSize);

        if (!TextUtils.isEmpty(textColor))
            view.setTextColor(Color.parseColor(textColor));
        if (!(textColorInt == 0))
            view.setTextColor(textColorInt);

        if (maxLines != 0)
            view.setMaxLines(maxLines);
        setMargins(view, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawEditText(TextView view) {
        view.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        view.setVisibility(visibility);

        if (tag != null)
            view.setTag(tag);


        if (background_resource != 0)
            view.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            view.setBackgroundColor(Color.parseColor(background_color));

        view.setGravity(gravity);
        view.setText(text);
        view.setTextSize(textSize);
        view.setHint(hint);
        view.setInputType(inputType);

        if (!TextUtils.isEmpty(textColor))
            view.setTextColor(Color.parseColor(textColor));
        if (!(textColorInt == 0))
            view.setTextColor(textColorInt);

        if (maxLines != 0)
            view.setMaxLines(maxLines);

        if (maxLength > 0)
            view.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        setMargins(view, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawCheckBox(CheckBox view) {
        view.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        view.setVisibility(visibility);

        if (tag != null)
            view.setTag(tag);

        if (background_resource != 0)
            view.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            view.setBackgroundColor(Color.parseColor(background_color));

        view.setGravity(gravity);
        view.setText(text);
        view.setTextSize(textSize);
        view.setChecked(checked);
        if (!TextUtils.isEmpty(textColor))
            view.setTextColor(Color.parseColor(textColor));
        if (!(textColorInt == 0))
            view.setTextColor(textColorInt);

        if (maxLines != 0)
            view.setMaxLines(maxLines);
        setMargins(view, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawRadioButton(RadioButton view) {
        view.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        view.setVisibility(visibility);

        if (tag != null)
            view.setTag(tag);


        if (background_resource != 0)
            view.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            view.setBackgroundColor(Color.parseColor(background_color));

        view.setGravity(gravity);
        view.setText(text);
        view.setTextSize(textSize);
        view.setChecked(checked);
        if (!TextUtils.isEmpty(textColor))
            view.setTextColor(Color.parseColor(textColor));
        if (!(textColorInt == 0))
            view.setTextColor(textColorInt);

        if (maxLines != 0)
            view.setMaxLines(maxLines);
        setMargins(view, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawSpinner(Spinner view) {
        view.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        view.setVisibility(visibility);

        if (tag != null)
            view.setTag(tag);


        if (background_resource != 0)
            view.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            view.setBackgroundColor(Color.parseColor(background_color));

        view.setGravity(gravity);

        setMargins(view, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);
        if (spinnerItems != null)
            view.setAdapter(new ArrayAdapter<CharSequence>(context, R.layout.simple_dropdown, spinnerItems));
        if (spinnerItemsList != null)
            view.setAdapter(new ArrayAdapter<String>(context, R.layout.simple_dropdown, spinnerItemsList));
        if (spinnerItemsJson != null)
            view.setAdapter(new JsonArrayAdapter(context, spinnerItemsJson));

    }


    protected void drawImageView(ImageView view) {
        view.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        view.setVisibility(visibility);

        if (tag != null)
            view.setTag(tag);


        if (background_resource != 0)
            view.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            view.setBackgroundColor(Color.parseColor(background_color));

        setMargins(view, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

        /*if (src != 0)
            view.setImageResource(src);*/
        if (bitmap != null) {
            view.setImageBitmap(bitmap);
        }


    }

    protected void drawButton(Button view) {
        view.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        view.setVisibility(visibility);

        if (tag != null)
            view.setTag(tag);


        if (background_resource != 0)
            view.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            view.setBackgroundColor(Color.parseColor(background_color));

        view.setGravity(gravity);
        view.setText(text);
        view.setTextSize(textSize);

        if (!TextUtils.isEmpty(textColor))
            view.setTextColor(Color.parseColor(textColor));
        if (!(textColorInt == 0))
            view.setTextColor(textColorInt);

        if (shape != null) {
            view.setBackground(shape);
        }

        if (maxLines != 0)
            view.setMaxLines(maxLines);
        setMargins(view, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }

    protected void drawRating(RatingBar view) {
        view.setPadding((int) (padding_left * density), (int) (padding_top * density), (int) (padding_right * density), (int) (padding_bottom * density));
        view.setVisibility(visibility);

        if (tag != null)
            view.setTag(tag);

        view.setRating(rating);
        view.setIsIndicator(isIndicator);
        view.setNumStars(noOfStars);
        view.setStepSize(stepSize);


        if (background_resource != 0)
            view.setBackgroundResource(background_resource);

        if (!TextUtils.isEmpty(background_color))
            view.setBackgroundColor(Color.parseColor(background_color));


        setMargins(view, layout_marginLeft, layout_marginTop, layout_marginRight, layout_marginBottom);

    }


}
