package com.ukkoteknik.dynamicapp.pojo;

public class Submission {
    int form_id;
    int user_id;
    int ip_address;
    String feed_back;

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIp_address() {
        return ip_address;
    }

    public void setIp_address(int ip_address) {
        this.ip_address = ip_address;
    }

    public String getFeed_back() {
        return feed_back;
    }

    public void setFeed_back(String feed_back) {
        this.feed_back = feed_back;
    }
}
