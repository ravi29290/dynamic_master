package com.ukkoteknik.dynamicapp;

import android.view.View;

import com.ukkoteknik.dynamicapp.asset.Asset;

import java.util.List;
import java.util.Map;

public interface ValueInteface {

    String getValue();

    String getKeyType();

    void setAttributes(Map<String, Asset> map);

    void setChangeEventListener(ComponentValueChangeListener componentValueChangeListener);

    void resolveDependencies(FormTemplate formTemplate);

    void updateListToSpinner(List<OptionModel> list);

    void setManualText(String value);

}
