package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;

class bc {
    static final int[] f1969a;
    static final int[] f1970b;
    static final int[] f1971c;
    static final int[] f1972d;
    static final int[] f1973e;
    static final int[] f1974f;
    static final int[] f1975g;
    static final int[] f1976h;
    private static final ThreadLocal<TypedValue> f1977i;
    private static final int[] f1978j;

    static {
        f1977i = new ThreadLocal();
        f1969a = new int[]{-16842910};
        f1970b = new int[]{16842908};
        f1971c = new int[]{16843518};
        f1972d = new int[]{16842919};
        f1973e = new int[]{16842912};
        f1974f = new int[]{16842913};
        f1975g = new int[]{-16842919, -16842908};
        f1976h = new int[0];
        f1978j = new int[1];
    }

    public static int m2491a(Context context, int i) {
        f1978j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1978j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int m2492a(Context context, int i, float f) {
        int a = m2491a(context, i);
        return ColorUtils.setAlphaComponent(a, Math.round(((float) Color.alpha(a)) * f));
    }

    private static TypedValue m2493a() {
        TypedValue typedValue = (TypedValue) f1977i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f1977i.set(typedValue);
        return typedValue;
    }

    public static ColorStateList m2494b(Context context, int i) {
        f1978j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1978j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int m2495c(Context context, int i) {
        ColorStateList b = m2494b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f1969a, b.getDefaultColor());
        }
        TypedValue a = m2493a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m2492a(context, i, a.getFloat());
    }
}
