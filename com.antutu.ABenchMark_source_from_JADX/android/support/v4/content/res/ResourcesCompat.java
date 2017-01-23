package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class ResourcesCompat {
    private ResourcesCompat() {
    }

    public static int getColor(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 23 ? ResourcesCompatApi23.getColor(resources, i, theme) : resources.getColor(i);
    }

    public static ColorStateList getColorStateList(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 23 ? ResourcesCompatApi23.getColorStateList(resources, i, theme) : resources.getColorStateList(i);
    }

    public static Drawable getDrawable(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? ResourcesCompatApi21.getDrawable(resources, i, theme) : resources.getDrawable(i);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Theme theme) {
        return VERSION.SDK_INT >= 21 ? ResourcesCompatApi21.getDrawableForDensity(resources, i, i2, theme) : VERSION.SDK_INT >= 15 ? ResourcesCompatIcsMr1.getDrawableForDensity(resources, i, i2) : resources.getDrawable(i);
    }
}
