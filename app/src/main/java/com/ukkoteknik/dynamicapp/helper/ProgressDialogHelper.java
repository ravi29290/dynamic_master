package com.ukkoteknik.dynamicapp.helper;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.ukkoteknik.dynamicapp.R;

import org.quanqi.circularprogress.CircularProgressView;


/**
 * Created by  Manoj Sadhu on 6/6/2018.
 */
public class ProgressDialogHelper {
    static ProgressDialogHelper progressDialogHelper;
    static AlertDialog progressDialog;
    private static TextView message;
    private static CircularProgressView loading;
    private static Button ok;
    private static Activity activity;

    private ProgressDialogHelper() {

    }

    public static ProgressDialogHelper getInstance(Activity activity) {
        if (progressDialogHelper == null) {
            progressDialogHelper = new ProgressDialogHelper();
        }

        ProgressDialogHelper.activity = activity;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        View dialogView = LayoutInflater.from(activity).inflate(R.layout.progress_dialog, null, false);
        dialogBuilder.setView(dialogView);
        message = dialogView.findViewById(R.id.message);
        loading = dialogView.findViewById(R.id.loading);
        ok = dialogView.findViewById(R.id.ok);

        ok.setOnClickListener(v -> {
            progressDialog.dismiss();
        });

        final AlertDialog dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        progressDialog = dialog;


        return progressDialogHelper;
    }

    public void setMessage(String message, boolean finished) {
        activity.runOnUiThread(() -> {
            ProgressDialogHelper.message.setText(message);
            if (finished) {
                loading.setVisibility(View.GONE);
                ok.setVisibility(View.VISIBLE);
            }
        });
    }

    public void setMessage(int message, boolean finished) {
        activity.runOnUiThread(() -> {
            ProgressDialogHelper.message.setText(message);
            if (finished) {
                loading.setVisibility(View.GONE);
                ok.setVisibility(View.VISIBLE);
            }
        });
    }

    public void showProgress() {
        progressDialog.show();
    }

    public void closeProgress() {
        progressDialog.dismiss();
    }
}
