package com.github.amlcurran.showcaseview.targets;

import android.graphics.Point;

public class PointTarget implements Target {
    private final Point mPoint;

    public PointTarget(Point point) {
        this.mPoint = point;
    }

    public PointTarget(int xValue, int yValue) {
        this.mPoint = new Point(xValue, yValue);
    }

    public Point getPoint() {
        return this.mPoint;
    }
}
