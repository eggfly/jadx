package com.github.amlcurran.showcaseview.targets;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;

class ActionBarReflector implements Reflector {
    private Activity mActivity;

    public ActionBarReflector(Activity activity) {
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
        throw new RuntimeException("insertShowcaseViewWithType cannot be used when the theme has no ActionBar");
    }

    public void showcaseActionItem(int itemId) {
    }
}
