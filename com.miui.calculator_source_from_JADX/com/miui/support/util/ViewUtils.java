package com.miui.support.util;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.internal.variable.Android_View_View_class;
import com.miui.support.internal.variable.Android_View_View_class.Factory;
import java.util.Locale;

public class ViewUtils {
    private static final Android_View_View_class f3717a;

    static {
        f3717a = Factory.getInstance().get();
    }

    private ViewUtils() {
    }

    public static void m5448a(View view, Rect rect) {
        rect.left = view.getScrollX() + view.getPaddingLeft();
        rect.top = view.getScrollY() + view.getPaddingTop();
        rect.right = (view.getWidth() - view.getPaddingRight()) - rect.left;
        rect.bottom = (view.getHeight() - view.getPaddingBottom()) - rect.top;
    }

    public static boolean m5453a(ViewGroup viewGroup) {
        return f3717a.getCustomizedValue(viewGroup).mTagChildrenSequenceState;
    }

    public static void m5450a(ViewGroup viewGroup, boolean z) {
        f3717a.getCustomizedValue(viewGroup).mTagChildrenSequenceState = z;
    }

    public static boolean m5452a(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static boolean m5451a() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static void m5449a(ViewGroup viewGroup, View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = m5452a((View) viewGroup);
        int width = viewGroup.getWidth();
        if (a) {
            i5 = width - i3;
        } else {
            i5 = i;
        }
        if (a) {
            i3 = width - i;
        }
        view.layout(i5, i2, i3, i4);
    }
}
