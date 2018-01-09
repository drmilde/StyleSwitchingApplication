package com.example.milde.styleswitchingapplication;

import java.util.ArrayList;

/**
 * Created by milde on 09.01.18.
 */

public class StyleBuffer {
    private ArrayList<Style> buffer = new ArrayList<Style>();
    private int currentStyle = 0;


    public int newStyle(String name) {
        buffer.add(new Style(name)); // add at end of buffer
        return buffer.size()-1;
    }

    public boolean addStyleId(String key, int styleId) {
        Style style = buffer.get(currentStyle);
        if (style != null){
            style.addStyleId(key, styleId);
            return true;
        }

        return false;
    }

    public int getStyleId(String key) {
        Style style = buffer.get(currentStyle);
        if (style != null) {
            return style.getStyleId(key);
        }
        return 0;
    }

    public String getStyleName() {
        Style style = buffer.get(currentStyle);
        if (style != null) {
            return style.getName();
        }
        return null;
    }

    public void clear() {
        buffer.clear();
    }


    // getter
    public int getCurrentStyle() {
        return currentStyle;
    }

    // setter

    public void setCurrentStyle(int currentStyle) {
        this.currentStyle = Math.max (0, Math.min(currentStyle, buffer.size()-1));
    }

}
