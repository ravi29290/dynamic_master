package com.ukkoteknik.dynamicapp.asset;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Asset extends RealmObject {

    @PrimaryKey
    private String id;
    private String key;
    private String type;
    private String value;
    private String language;
    private String className;
    private String uiAttributes;
    private String dataAttributes;
    private String label;
    private String dependency="";
    private String screenType="";

    public Asset() {

    }

    public Asset(String key, String type, String value, String language, String className) {
        this.key = key;
        this.type = type;
        this.value = value;
        this.language = language;
        this.className = className;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUiAttributes() {
        return uiAttributes;
    }

    public void setUiAttributes(String uiAttributes) {
        this.uiAttributes = uiAttributes;
    }

    public String getDataAttributes() {
        return dataAttributes;
    }

    public void setDataAttributes(String dataAttributes) {
        this.dataAttributes = dataAttributes;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }
}
