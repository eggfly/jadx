package com.echo.holographlibrary;

import android.graphics.Path;
import android.graphics.Region;
import android.support.v4.view.ViewCompat;

public class LinePoint {
    private int mColor;
    private final Path mPath;
    private final Region mRegion;
    private int mSelectedColor;
    private float mX;
    private float mY;

    public LinePoint() {
        this(0.0f, 0.0f);
    }

    public LinePoint(double x, double y) {
        this((float) x, (float) y);
    }

    public LinePoint(float x, float y) {
        this.mPath = new Path();
        this.mRegion = new Region();
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.mSelectedColor = -1;
        this.mX = x;
        this.mY = y;
    }

    public float getX() {
        return this.mX;
    }

    public void setX(float x) {
        this.mX = x;
    }

    public float getY() {
        return this.mY;
    }

    public void setY(float y) {
        this.mY = y;
    }

    public void setX(double x) {
        this.mX = (float) x;
    }

    public void setY(double y) {
        this.mY = (float) y;
    }

    public Region getRegion() {
        return this.mRegion;
    }

    public Path getPath() {
        return this.mPath;
    }

    public String toString() {
        return "x= " + this.mX + ", y= " + this.mY;
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
            this.mSelectedColor &= -2130706433;
        }
        return this.mSelectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        this.mSelectedColor = selectedColor;
    }
}
