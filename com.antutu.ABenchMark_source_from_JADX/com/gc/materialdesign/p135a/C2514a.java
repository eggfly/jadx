package com.gc.materialdesign.p135a;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

/* renamed from: com.gc.materialdesign.a.a */
public class C2514a {
    public static int m9521a(float f, Resources resources) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static int m9522a(View view) {
        if (view.getId() == 16908290) {
            return view.getTop();
        }
        return C2514a.m9522a((View) view.getParent()) + view.getTop();
    }

    public static int m9523b(View view) {
        if (view.getId() == 16908290) {
            return view.getLeft();
        }
        return C2514a.m9523b((View) view.getParent()) + view.getLeft();
    }
}
