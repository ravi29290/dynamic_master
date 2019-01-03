package com.ukkoteknik.dynamicapp.realms;

import com.ukkoteknik.dynamicapp.asset.Asset;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AssetModel extends RealmObject {

    @PrimaryKey
    private long id;
    String key;
    RealmList<Asset> list;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RealmList<Asset> getList() {
        return list;
    }

    public void setList(RealmList<Asset> list) {
        this.list = list;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
