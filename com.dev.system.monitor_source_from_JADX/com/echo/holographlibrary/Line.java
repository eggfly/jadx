package com.echo.holographlibrary;

import java.util.ArrayList;

public class Line {
    private int mColor;
    private ArrayList<LinePoint> mPoints;
    private boolean mShowPoints;
    private int mStrokeWidth;
    private boolean mUseDips;

    public Line() {
        this.mPoints = new ArrayList();
        this.mShowPoints = true;
        this.mStrokeWidth = 6;
        this.mUseDips = false;
    }

    public boolean isUsingDips() {
        return this.mUseDips;
    }

    public void setUsingDips(boolean treatSizesAsDips) {
        this.mUseDips = treatSizesAsDips;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        if (strokeWidth < 0) {
            throw new IllegalArgumentException("strokeWidth must not be less than zero");
        }
        this.mStrokeWidth = strokeWidth;
    }

    public int getColor() {
        return this.mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public ArrayList<LinePoint> getPoints() {
        return this.mPoints;
    }

    public void setPoints(ArrayList<LinePoint> points) {
        this.mPoints = points;
    }

    public void addPoint(LinePoint point) {
        for (int i = 0; i < this.mPoints.size(); i++) {
            if (point.getX() < ((LinePoint) this.mPoints.get(i)).getX()) {
                this.mPoints.add(i, point);
                return;
            }
        }
        this.mPoints.add(point);
    }

    public void removePoint(LinePoint point) {
        this.mPoints.remove(point);
    }

    public LinePoint getPoint(int index) {
        return (LinePoint) this.mPoints.get(index);
    }

    public LinePoint getPoint(float x, float y) {
        for (int i = 0; i < this.mPoints.size(); i++) {
            LinePoint p = (LinePoint) this.mPoints.get(i);
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    public int getSize() {
        return this.mPoints.size();
    }

    public boolean isShowingPoints() {
        return this.mShowPoints;
    }

    public void setShowingPoints(boolean showPoints) {
        this.mShowPoints = showPoints;
    }
}
