package com.github.amlcurran.showcaseview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class ApiUtils {
    public boolean isCompatWith(int versionCode) {
        return VERSION.SDK_INT >= versionCode;
    }

    public boolean isCompatWithHoneycomb() {
        return isCompatWith(11);
    }

    @TargetApi(14)
    public void setFitsSystemWindowsCompat(View view) {
        if (isCompatWith(14)) {
            view.setFitsSystemWindows(true);
        }
    }
}
