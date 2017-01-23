package com.github.amlcurran.showcaseview.targets;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;

public class ViewTarget implements Target {
    private final View mView;

    public ViewTarget(View view) {
        this.mView = view;
    }

    public ViewTarget(int viewId, Activity activity) {
        this.mView = activity.findViewById(viewId);
    }

    public Point getPoint() {
        int[] location = new int[2];
        this.mView.getLocationInWindow(location);
        return new Point(location[0] + (this.mView.getWidth() / 2), location[1] + (this.mView.getHeight() / 2));
    }
}
