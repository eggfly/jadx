package com.echo.holographlibrary;

import android.graphics.Path;
import android.graphics.Region;

public class PieSlice {
    private int mColor;
    private float mGoalValue;
    private float mOldValue;
    private final Path mPath;
    private final Region mRegion;
    private int mSelectedColor;
    private String mTitle;
    private float mValue;

    public PieSlice() {
        this.mPath = new Path();
        this.mRegion = new Region();
        this.mColor = -13388315;
        this.mSelectedColor = -1;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public int getColor() {
        return this.mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public int getSelectedColor() {
        if (-1 == this.mSelectedColor) {
            this.mSelectedColor = Utils.darkenColor(this.mColor);
        }
        return this.mSelectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        this.mSelectedColor = selectedColor;
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float value) {
        this.mValue = value;
    }

    public float getOldValue() {
        return this.mOldValue;
    }

    public void setOldValue(float oldValue) {
        this.mOldValue = oldValue;
    }

    public float getGoalValue() {
        return this.mGoalValue;
    }

    public void setGoalValue(float goalValue) {
        this.mGoalValue = goalValue;
    }

    public Path getPath() {
        return this.mPath;
    }

    public Region getRegion() {
        return this.mRegion;
    }
}
