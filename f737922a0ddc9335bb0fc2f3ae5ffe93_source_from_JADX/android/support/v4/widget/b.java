package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;

class b {
    private static final int[] j6;

    static class a implements OnApplyWindowInsetsListener {
        a() {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((c) view).j6(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    static {
        j6 = new int[]{16843828};
    }

    public static void j6(View view) {
        if (view instanceof c) {
            view.setOnApplyWindowInsetsListener(new a());
            view.setSystemUiVisibility(1280);
        }
    }

    public static void j6(View view, Object obj, int i) {
        obj = (WindowInsets) obj;
        if (i == 3) {
            obj = obj.replaceSystemWindowInsets(obj.getSystemWindowInsetLeft(), obj.getSystemWindowInsetTop(), 0, obj.getSystemWindowInsetBottom());
        } else if (i == 5) {
            obj = obj.replaceSystemWindowInsets(0, obj.getSystemWindowInsetTop(), obj.getSystemWindowInsetRight(), obj.getSystemWindowInsetBottom());
        }
        view.dispatchApplyWindowInsets(obj);
    }

    public static void j6(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        obj = (WindowInsets) obj;
        if (i == 3) {
            obj = obj.replaceSystemWindowInsets(obj.getSystemWindowInsetLeft(), obj.getSystemWindowInsetTop(), 0, obj.getSystemWindowInsetBottom());
        } else if (i == 5) {
            obj = obj.replaceSystemWindowInsets(0, obj.getSystemWindowInsetTop(), obj.getSystemWindowInsetRight(), obj.getSystemWindowInsetBottom());
        }
        marginLayoutParams.leftMargin = obj.getSystemWindowInsetLeft();
        marginLayoutParams.topMargin = obj.getSystemWindowInsetTop();
        marginLayoutParams.rightMargin = obj.getSystemWindowInsetRight();
        marginLayoutParams.bottomMargin = obj.getSystemWindowInsetBottom();
    }

    public static int j6(Object obj) {
        return obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
    }

    public static Drawable j6(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(j6);
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            return drawable;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
