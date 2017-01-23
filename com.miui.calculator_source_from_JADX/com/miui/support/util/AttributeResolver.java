package com.miui.support.util;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import java.lang.ref.WeakReference;

public class AttributeResolver {
    private static final TypedValue f3626a;
    private static final ThreadLocal<TypedValue> f3627b;
    private static ResultCache f3628c;

    private static class ResultCache {
        public final WeakReference<Context> f3624a;
        public final boolean f3625b;

        public ResultCache(Context context, boolean z) {
            this.f3624a = new WeakReference(context);
            this.f3625b = z;
        }
    }

    static {
        f3626a = new TypedValue();
        f3627b = new ThreadLocal();
    }

    protected AttributeResolver() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static TypedValue m5321b(Context context) {
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            return f3626a;
        }
        TypedValue typedValue = (TypedValue) f3627b.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f3627b.set(typedValue);
        return typedValue;
    }

    public static int m5316a(Context context, int i) {
        TypedValue b = m5321b(context);
        if (context.getTheme().resolveAttribute(i, b, true)) {
            return b.resourceId;
        }
        return -1;
    }

    public static Drawable m5320b(Context context, int i) {
        TypedValue b = m5321b(context);
        if (context.getTheme().resolveAttribute(i, b, true)) {
            if (b.resourceId > 0) {
                return context.getResources().getDrawable(b.resourceId);
            }
            if (b.type >= 28 && b.type <= 31) {
                return new ColorDrawable(b.data);
            }
        }
        return null;
    }

    public static int m5322c(Context context, int i) {
        TypedValue b = m5321b(context);
        if (context.getTheme().resolveAttribute(i, b, true)) {
            if (b.resourceId > 0) {
                return context.getResources().getColor(b.resourceId);
            }
            if (b.type >= 28 && b.type <= 31) {
                return b.data;
            }
        }
        return context.getResources().getColor(-1);
    }

    public static boolean m5319a(Context context, int i, boolean z) {
        TypedValue b = m5321b(context);
        if (!context.getTheme().resolveAttribute(i, b, true)) {
            return z;
        }
        if (b.type != 18 || b.data == 0) {
            return false;
        }
        return true;
    }

    public static float m5323d(Context context, int i) {
        return context.getResources().getDimension(m5316a(context, i));
    }

    public static int m5324e(Context context, int i) {
        return context.getResources().getDimensionPixelSize(m5316a(context, i));
    }

    public static int m5317a(Context context, int i, int i2) {
        TypedValue b = m5321b(context);
        if (context.getTheme().resolveAttribute(i, b, true) && b.type == 16) {
            return b.data;
        }
        return i2;
    }

    public static boolean m5318a(Context context) {
        boolean z = true;
        ResultCache resultCache = f3628c;
        if (resultCache != null && resultCache.f3624a.get() == context) {
            return resultCache.f3625b;
        }
        if (m5317a(context, C0234R.attr.miui_version, 0) != 0) {
            int a = m5316a(context, 16842845);
            if (a > 0) {
                Theme newTheme = context.getResources().newTheme();
                newTheme.applyStyle(a, true);
                TypedArray obtainStyledAttributes = newTheme.obtainStyledAttributes(C0264R.styleable.AlertDialog);
                if (obtainStyledAttributes.getResourceId(C0264R.styleable.AlertDialog_layout, -1) == -1) {
                    z = false;
                }
                obtainStyledAttributes.recycle();
                f3628c = new ResultCache(context, z);
                return z;
            }
        }
        f3628c = new ResultCache(context, false);
        return false;
    }
}
