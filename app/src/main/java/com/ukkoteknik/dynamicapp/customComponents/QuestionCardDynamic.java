package com.ukkoteknik.dynamicapp.customComponents;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.ukkoteknik.dynamicapp.pojo.Question;
import com.ukkoteknik.dynamicapp.viewLayer.CardViewDesigner;
import com.ukkoteknik.dynamicapp.viewLayer.FrameDesigner;
import com.ukkoteknik.dynamicapp.viewLayer.LinearDesigner;
import com.ukkoteknik.dynamicapp.viewLayer.RatingBarDesigner;
import com.ukkoteknik.dynamicapp.viewLayer.TextViewDesigner;

import org.json.JSONObject;

import io.realm.RealmList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by  Manoj Sadhu on 5/16/2018.
 */
public class QuestionCardDynamic extends FrameLayout {
    int index = 0;
    private int normalColor;
    private int selectedColor;
    private String title = "";
    private FrameLayout colorBar;
    private int titleSize = 18;
    private int optionTextSize = 16;
    private String titleColor = "#FF000000";
    private String optionColor = "#3d3d3d";
    private EditText otherEditText = null;
    private LinearLayout contentView;
    private TextView titleView;
    private View optionView;
    private boolean isMandatory = false;
    private String dependentValue = "";
    private boolean dependentCondition = false;
    private View[] dependentviews;
    private Activity activity;
    private Resources resources;
    private View root;
    private RatingBar ratingBar;
    Question questionnaire;

    public QuestionCardDynamic(Activity activity, Question questionnaire, View root, int i) {
        super(activity);
        this.questionnaire = questionnaire;
        this.index = i;
        this.root = root;
        init(activity, null);
    }

    public QuestionCardDynamic(Activity activity, @Nullable AttributeSet attrs) {
        super(activity, attrs);
        init(activity, attrs);
    }

    public QuestionCardDynamic(Activity activity, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(activity, attrs, defStyleAttr);
        init(activity, attrs);
    }

    private void init(Activity activity, AttributeSet attributeSet) {
        this.activity = activity;
        this.resources = getResources();
        /*normalColor = resources.getColor(R.color.normal);
        selectedColor = resources.getColor(R.color.selected);*/

        TypedArray a = null;
        /*if (attributeSet != null) {
            a = activity.obtainStyledAttributes(attributeSet,
                    R.styleable.QuestionCardDynamic, 0, 0);
            if (a.hasValue(R.styleable.QuestionCardDynamic_question))
                title = a.getString(R.styleable.QuestionCardDynamic_question);
        }*/
        //LinearLayout dummyLayout = new LinearDesigner(activity).getView(this);
        final CardView cardView = new CardViewDesigner(activity).width(MATCH_PARENT).height(MATCH_PARENT)
                .marginTop(15).paddingBottom(15).paddingTop(5).radius(8).getView(this);
        cardView.setCardElevation(5);
        //cardView.setRadius(10);
        cardView.setCardBackgroundColor(Color.WHITE);
        cardView.setPreventCornerOverlap(false);
        //cardView.setBackgroundColor(Color.WHITE);
        final LinearLayout linearLayout = new LinearDesigner(activity).width(MATCH_PARENT).height(MATCH_PARENT)
                .gravity(Gravity.CENTER_VERTICAL).orientation(LinearLayout.HORIZONTAL).getView(cardView);
        //colorBar = new FrameDesigner(activity).width(10).height(MATCH_PARENT).backgroundColor(normalColor).getView(linearLayout);
        final LinearLayout linearLayout1 = new LinearDesigner(activity).width(MATCH_PARENT)
                .gravity(Gravity.CENTER_VERTICAL).layoutGravity(Gravity.CENTER_VERTICAL).paddingLeft(10).getView(linearLayout);
        titleView = new TextViewDesigner(activity).text(index + ". " + questionnaire.getQuestion_name()).layoutGravity(Gravity.CENTER_VERTICAL).textColor(titleColor)
                .textSize(titleSize).marginLeft(10).marginRight(10).marginTop(5).marginBottom(5).getView(linearLayout1);

        ratingBar = new RatingBarDesigner(activity).noOfStars(5).getView(linearLayout1);

        contentView = linearLayout1;
        if (attributeSet != null)
            a.recycle();
    }


    public JsonObject getValue() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", questionnaire.getId());
        //jsonObject.addProperty("value", (int) ratingBar.getRating());
        jsonObject.addProperty("value", ratingBar.getRating());
        return jsonObject;
    }


    private void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams p = (MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
