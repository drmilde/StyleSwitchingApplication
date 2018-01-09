package com.example.milde.styleswitchingapplication;

import java.util.HashMap;

/**
 * Created by milde on 09.01.18.
 */

public class Style {
    private HashMap<String, Integer> ids = new HashMap<String, Integer>();
    private String name = "noName";

    public Style(String name) {
        this.name = name;
    }

    public void clear() {
        ids.clear();
    }

    public void addStyleId(String key, int styleId) {
        ids.put(key, styleId);
    }

    public int getStyleId(String key) {
        return ids.get(key);
    }

    // getter

    public HashMap<String, Integer> getIds() {
        return ids;
    }

    public String getName() {
        return name;
    }
    //setter

    public void setIds(HashMap<String, Integer> ids) {
        this.ids = ids;
    }

}
