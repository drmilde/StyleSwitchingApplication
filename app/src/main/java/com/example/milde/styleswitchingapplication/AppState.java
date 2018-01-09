package com.example.milde.styleswitchingapplication;

import java.util.ArrayList;

/**
 * Created by milde on 09.01.18.
 */

public class AppState {
    private static final AppState ourInstance = new AppState();
    private ArrayList<Style> styles = new ArrayList<Style>();

    public static AppState getInstance() {
        return ourInstance;
    }

    private AppState() {
    }

    // getter

}
