package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

class c {
    private static final int[] j6;

    static {
        j6 = new int[]{16843531};
    }

    public static Object j6(Object obj, Activity activity, Drawable drawable, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }

    public static Object j6(Object obj, Activity activity, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }

    public static Drawable j6(Activity activity) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            activity = actionBar.getThemedContext();
        }
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(null, j6, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
}
