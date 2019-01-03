package com.ukkoteknik.dynamicapp.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ukkoteknik.dynamicapp.R;
import com.ukkoteknik.dynamicapp.customComponents.InteractiveScrollView;
import com.ukkoteknik.dynamicapp.customComponents.QuestionCardDynamic;
import com.ukkoteknik.dynamicapp.pojo.Question;
import com.ukkoteknik.dynamicapp.singleTon.MyApp;
import com.ukkoteknik.dynamicapp.utils.DeviceIdUtils;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsDynamicFormActivity extends AppCompatActivity {

    String quetionUrl = "";
    String formId = "";
    InteractiveScrollView scrollView;
    int currentPage = 1;
    List<Question> questionList;
    Button submit;
    FrameLayout root;
    LinearLayout dynamicForm;
    List<QuestionCardDynamic> questionCardList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_dynamic_form);

        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_gradient));
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getIntent().getStringExtra("formname"));*/

        initViews();

        if (MyApp.isNetworkAvailable(QuestionsDynamicFormActivity.this)) {
            getQuestions(quetionUrl);
        } else {
            Toast.makeText(QuestionsDynamicFormActivity.this, "You are in offline,please connect to Internet...", Toast.LENGTH_SHORT).show();
        }

        scrollView.setOnBottomReachedListener(() -> {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    createpage(currentPage++);
                    scrollView.smoothScrollBy(10, 10);
                }
            }, 50);
        });
        submit.setOnClickListener((view) -> {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("form_id", formId);
            jsonObject.addProperty("user_id", 0);
            DeviceIdUtils deviceIdUtils = new DeviceIdUtils(QuestionsDynamicFormActivity.this);
            jsonObject.addProperty("ip_address", deviceIdUtils.getIPAddress(false));
            JsonArray feedbackJsonArray = new JsonArray();

            for (QuestionCardDynamic questionCardDynamic : questionCardList) {
                    /*JsonObject jsonObject1 = questionCardDynamic.getValue();
                    if (jsonObject1.get("value").getAsFloat() != 0.0) {
                        feedback.add(questionCardDynamic.getValue());
                    }*/
                feedbackJsonArray.add(questionCardDynamic.getValue());
            }
            jsonObject.add("feed_back", feedbackJsonArray);
            Log.v("QuestionCardDynamic", "json format : " + jsonObject);
            retrofit2.Call<JsonObject> submitCall = MyApp.apiInterface.postFeedbackData(jsonObject);
            submitCall.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(@NonNull retrofit2.Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                    JsonObject jsonObject1 = response.body();
                    if (jsonObject1 != null) {
                        if (jsonObject1.get("status").getAsBoolean()) {
                            showDialog();
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull retrofit2.Call<JsonObject> call, @NonNull Throwable t) {
                    Log.v("QuestionCardDynamic", "error : " + t.toString());
                }
            });
        });
    }

    private void initViews() {

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.layout_custom_actionbar);
        View action_view = getSupportActionBar().getCustomView();

        TextView txt_title = action_view.findViewById(R.id.txt_title);
        txt_title.setText(getIntent().getStringExtra("formname"));

        scrollView = findViewById(R.id.scroll);
        submit = findViewById(R.id.submit);
        root = findViewById(R.id.root);
        dynamicForm = findViewById(R.id.dynamicForm);

        quetionUrl = getIntent().getStringExtra("questions");
        formId = getIntent().getStringExtra("formId");
    }
    private void showDialog() {
        Dialog dialog = new Dialog(QuestionsDynamicFormActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.layout_thanks);
        TextView txt_feedback = (TextView) dialog.findViewById(R.id.txt_thanks);
        ImageView img_cancel = (ImageView) dialog.findViewById(R.id.image_cancel);
        String thanks = "Thanks for submitting" + "\n" + "your feedback";
        txt_feedback.setText(thanks);
        dialog.show();
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        new Handler().postDelayed(() -> {
            dialog.dismiss();
            startActivity(new Intent(QuestionsDynamicFormActivity.this, MainActivity.class));
            finish();
        }, 3000);
    }
    private void getQuestions(String quetionUrl) {
        retrofit2.Call<JsonObject> questionCall = MyApp.apiInterface.getQuestions(quetionUrl);
        questionCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                JsonObject jsonObject = response.body();
                if (jsonObject.get("status").getAsBoolean()) {
                    JsonArray jsonArray = jsonObject.getAsJsonObject("response").getAsJsonArray("question");
                    questionList = MyApp.gson.fromJson(jsonArray, new TypeToken<List<Question>>() {
                    }.getType());
                    createpage(currentPage++);
                }
            }


            @Override
            public void onFailure(@NonNull retrofit2.Call<JsonObject> call, @NonNull Throwable t) {
                Log.v("QuestionsDynamic", "error : " + t.toString());
            }
        });
    }
    private void createpage(int pageNo) {
        if (questionList != null) {
            int size = questionList.size();
            int i;
            for (i = (pageNo - 1) * 10; i < pageNo * 10 && i < size; i++) {
                Question questionnaire = questionList.get(i);
                QuestionCardDynamic questionCardDynamic = new QuestionCardDynamic(this, questionnaire, root, (i + 1));
                dynamicForm.addView(questionCardDynamic);
                questionCardList.add(questionCardDynamic);
            }
            if (i == size) {
                submit.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }

}
