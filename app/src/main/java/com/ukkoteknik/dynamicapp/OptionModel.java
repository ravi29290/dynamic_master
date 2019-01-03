package com.ukkoteknik.dynamicapp;

public class OptionModel {

    private int id;
    private String name;

    public OptionModel() {

    }

    public OptionModel(int id, String value) {
        this.id = id;
        this.name = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
