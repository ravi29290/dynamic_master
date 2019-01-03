package com.ukkoteknik.dynamicapp.realms;

import com.ukkoteknik.dynamicapp.asset.Asset;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DetailedModel extends RealmObject {

    @PrimaryKey
    private long id;
    private String templateType;
    private RealmList<Asset> list;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public RealmList<Asset> getList() {
        return list;
    }

    public void setList(RealmList<Asset> list) {
        this.list = list;
    }
}
