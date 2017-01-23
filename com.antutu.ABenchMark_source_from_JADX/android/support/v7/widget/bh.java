package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class bh {
    private final Context f1987a;
    private final TypedArray f1988b;

    private bh(Context context, TypedArray typedArray) {
        this.f1987a = context;
        this.f1988b = typedArray;
    }

    public static bh m2501a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new bh(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static bh m2502a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new bh(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float m2503a(int i, float f) {
        return this.f1988b.getFloat(i, f);
    }

    public int m2504a(int i, int i2) {
        return this.f1988b.getInt(i, i2);
    }

    public Drawable m2505a(int i) {
        if (this.f1988b.hasValue(i)) {
            int resourceId = this.f1988b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0616l.m2672a().m2695a(this.f1987a, resourceId);
            }
        }
        return this.f1988b.getDrawable(i);
    }

    public void m2506a() {
        this.f1988b.recycle();
    }

    public boolean m2507a(int i, boolean z) {
        return this.f1988b.getBoolean(i, z);
    }

    public int m2508b(int i, int i2) {
        return this.f1988b.getColor(i, i2);
    }

    public Drawable m2509b(int i) {
        if (this.f1988b.hasValue(i)) {
            int resourceId = this.f1988b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0616l.m2672a().m2696a(this.f1987a, resourceId, true);
            }
        }
        return null;
    }

    public int m2510c(int i, int i2) {
        return this.f1988b.getInteger(i, i2);
    }

    public CharSequence m2511c(int i) {
        return this.f1988b.getText(i);
    }

    public int m2512d(int i, int i2) {
        return this.f1988b.getDimensionPixelOffset(i, i2);
    }

    public String m2513d(int i) {
        return this.f1988b.getString(i);
    }

    public int m2514e(int i, int i2) {
        return this.f1988b.getDimensionPixelSize(i, i2);
    }

    public CharSequence[] m2515e(int i) {
        return this.f1988b.getTextArray(i);
    }

    public int m2516f(int i, int i2) {
        return this.f1988b.getLayoutDimension(i, i2);
    }

    public boolean m2517f(int i) {
        return this.f1988b.hasValue(i);
    }

    public int m2518g(int i, int i2) {
        return this.f1988b.getResourceId(i, i2);
    }
}
