package com.ukkoteknik.dynamicapp.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by  Manoj Sadhu on 3/9/2018.
 */

public class Constants {

    public static final String BASE_URL = "https://hff-feedback.utpfapps.com/";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Feedback.realm";
    public static final String SHARED_PREFS = "Feedback";

    //Fields
    public static final String TEXT = "text";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String TEXT_COLOR = "color";
    public static final String TEXT_SIZE = "textsize";
    public static final String PADDING = "padding";
    public static final String PADDING_LEFT = "paddingLeft";
    public static final String PADDING_RIGHT = "paddingRight";
    public static final String PADDING_TOP = "paddingTop";
    public static final String PADDING_BOTTOM = "paddingBottom";
    public static final String MARGIN = "margin";
    public static final String MARGIN_LEFT = "marginLeft";
    public static final String MARGIN_RIGHT = "marginRight";
    public static final String MARGIN_TOP = "marginTop";
    public static final String MARGIN_BOTTOM = "marginBottom";
    public static final String DRAWABLE_PADDING = "drawablePadding";
    public static final String DRAWABLE_LEFT = "drawableLeft";
    public static final String HINT = "hint";
    public static final String INPUT_TYPE = "inputType";
    public static final String BACKGROUND = "background";
    public static final String GRAVITY = "gravity";
    public static final String IMAGE = "icon";
    public static final String SCALE_TYPE = "scaleType";
    public static final String OPTIONS = "options";
    public static final String NUM_OF_STARS = "noOfStars";
    public static final String STEP_SIZE = "stepSize";
    public static final String IS_INDICATOR = "isIndicator";
    public static final String ORIENTATION = "orientation";
    public static final String DEPENDENCY = "dependency";


    public static String getJSONString(Context context) {
        String str = "";
        try {
            AssetManager assetManager = context.getAssets();
            InputStream in = assetManager.open("Question1.json");
            InputStreamReader isr = new InputStreamReader(in);
            char[] inputBuffer = new char[100];

            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return str;
    }

}
