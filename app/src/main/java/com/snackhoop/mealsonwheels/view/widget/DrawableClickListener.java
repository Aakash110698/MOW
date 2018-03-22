package com.snackhoop.mealsonwheels.view.widget;

public interface DrawableClickListener {

    public static enum DrawablePosition { TOP, BOTTOM, LEFT, RIGHT };
    public void onClick(DrawablePosition target, int id);
    }