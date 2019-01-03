package com.ukkoteknik.dynamicapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ukkoteknik.dynamicapp.activities.QuestionsDynamicFormActivity;
import com.ukkoteknik.dynamicapp.R;
import com.ukkoteknik.dynamicapp.pojo.Feedback;

import java.util.List;

public class FeedbackRecyclerAdapter extends RecyclerView.Adapter<FeedbackRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Feedback> feedback_list;

    public FeedbackRecyclerAdapter(Context context, List<Feedback> feedback_list) {
        this.context = context;
        this.feedback_list = feedback_list;
    }

    @NonNull
    @Override
    public FeedbackRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_feedback_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackRecyclerAdapter.ViewHolder viewHolder, int i) {
        Feedback feedback = feedback_list.get(i);
        viewHolder.txt_feedback_form.setText(feedback.getFeed_back_form());
        viewHolder.txt_feedback_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, QuestionsDynamicFormActivity.class);
                intent.putExtra("questions", feedback.getQuestions());
                intent.putExtra("formname", feedback.getFeed_back_form());
                intent.putExtra("formId", feedback.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedback_list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_feedback_form;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_feedback_form = itemView.findViewById(R.id.txt_feedback_form);
        }
    }
}
