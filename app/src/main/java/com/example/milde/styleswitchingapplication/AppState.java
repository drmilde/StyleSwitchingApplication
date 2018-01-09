package com.example.milde.styleswitchingapplication;

/**
 * Created by milde on 09.01.18.
 */

public class AppState {
    private static final AppState ourInstance = new AppState();
    private StyleBuffer styleBuffer = new StyleBuffer();
    private int currentStyle = 0;

    public static AppState getInstance() {
        return ourInstance;
    }

    private AppState() {
        // TODO irgendetwas Sinnvolles hier ???
    }

    // Interface to StyleBuffer
    public void clearStyles() {
        styleBuffer.clear();
    }

    public int newStyle(String name) {
        return styleBuffer.newStyle(name);
    }

    public boolean addStyleId(String key, int styleId) {
        return styleBuffer.addStyleId(key, styleId);
    }

    public int getStyleId(String key) {
        return styleBuffer.getStyleId(key);
    }

    public String getStyleName() {
        return styleBuffer.getStyleName();
    }

    // getter
    public int getCurrentStyle() {
        return currentStyle;
    }

    // setter
    public void setCurrentStyle(int currentStyle) {
        styleBuffer.setCurrentStyle(currentStyle);
        this.currentStyle = styleBuffer.getCurrentStyle();
    }
}
