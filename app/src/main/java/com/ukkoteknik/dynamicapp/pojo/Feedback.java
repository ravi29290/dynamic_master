package com.ukkoteknik.dynamicapp.pojo;

import java.util.Date;

public class Feedback {
    String id;
    String feed_back_form;
    String description;
    Date from_date;
    Date end_date;
    String language;
    String questions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeed_back_form() {
        return feed_back_form;
    }

    public void setFeed_back_form(String feed_back_form) {
        this.feed_back_form = feed_back_form;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
