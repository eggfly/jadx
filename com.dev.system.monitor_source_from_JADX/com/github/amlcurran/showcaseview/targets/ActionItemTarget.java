package com.github.amlcurran.showcaseview.targets;

import android.app.Activity;
import android.graphics.Point;

public class ActionItemTarget implements Target {
    ActionBarViewWrapper mActionBarWrapper;
    private final Activity mActivity;
    private final int mItemId;

    public ActionItemTarget(Activity activity, int itemId) {
        this.mActivity = activity;
        this.mItemId = itemId;
    }

    public Point getPoint() {
        setUp();
        return new ViewTarget(this.mActionBarWrapper.getActionItem(this.mItemId)).getPoint();
    }

    protected void setUp() {
        this.mActionBarWrapper = new ActionBarViewWrapper(ReflectorFactory.getReflectorForActivity(this.mActivity).getActionBarView());
    }
}
