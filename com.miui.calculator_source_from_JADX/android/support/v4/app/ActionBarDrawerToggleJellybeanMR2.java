package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;

class ActionBarDrawerToggleJellybeanMR2 {
    private static final int[] f51a;

    ActionBarDrawerToggleJellybeanMR2() {
    }

    static {
        f51a = new int[]{16843531};
    }

    public static Object m63a(Object obj, Activity activity, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }
}
