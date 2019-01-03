package com.ukkoteknik.dynamicapp.pojo;

public class Question {
    String id;
    String question_name;
    String rating_type;
    String feed_back_form_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) {
        this.question_name = question_name;
    }

    public String getRating_type() {
        return rating_type;
    }

    public void setRating_type(String rating_type) {
        this.rating_type = rating_type;
    }

    public String getFeed_back_form_id() {
        return feed_back_form_id;
    }

    public void setFeed_back_form_id(String feed_back_form_id) {
        this.feed_back_form_id = feed_back_form_id;
    }
}
