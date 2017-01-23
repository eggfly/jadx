package com.github.amlcurran.showcaseview.targets;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;

class AppCompatReflector implements Reflector {
    private Activity mActivity;

    public AppCompatReflector(Activity activity) {
        this.mActivity = activity;
    }

    public ViewParent getActionBarView() {
        return getHomeButton().getParent().getParent();
    }

    public View getHomeButton() {
        View homeButton = this.mActivity.findViewById(16908332);
        if (homeButton != null) {
            return homeButton;
        }
        homeButton = this.mActivity.findViewById(this.mActivity.getResources().getIdentifier("home", "id", this.mActivity.getPackageName()));
        if (homeButton != null) {
            return homeButton;
        }
        throw new RuntimeException("insertShowcaseViewWithType cannot be used when the theme has no ActionBar");
    }

    public void showcaseActionItem(int itemId) {
    }
}
