package com.example.milde.styleswitchingapplication;

import java.util.ArrayList;

/**
 * Created by milde on 09.01.18.
 */

public class Style {
    private ArrayList<String> colors = new ArrayList<String>();
    private ArrayList<String> images = new ArrayList<String>();


    public void clear() {
        colors.clear();
        images.clear();
    }

    public void addColor(String color) {
        colors.add(color);
    }

    public void addImages(String image) {
        images.add(image);
    }

    // getter
    public ArrayList<String> getColors() {
        return colors;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    //setter
    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
