package com.ukkoteknik.dynamicapp.retrofit;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.ukkoteknik.dynamicapp.pojo.Submission;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface APIInterface {

    @POST("feed-backdata")
    Call<JsonObject> getFeedbackList();

    @GET()
    Call<JsonObject> getQuestions(@Url String url);

    @POST("save-feedback")
    Call<JsonObject> postFeedbackData(@Body JsonObject data);


}
