package com.miui.support.util;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.miui.support.internal.graphics.drawable.PlaceholderDrawable;

public class DrawableUtil {
    private DrawableUtil() {
    }

    public static boolean m5370a(Drawable drawable) {
        return (drawable instanceof PlaceholderDrawable) || ((drawable instanceof ColorDrawable) && ((ColorDrawable) drawable).getColor() == 0);
    }
}
