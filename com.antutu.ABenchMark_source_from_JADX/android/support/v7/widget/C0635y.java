package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.C0417R;
import android.support.v7.p015b.C0418a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.y */
class C0635y {
    private static final int[] f2143b;
    private static final int[] f2144c;
    final TextView f2145a;
    private bf f2146d;
    private bf f2147e;
    private bf f2148f;
    private bf f2149g;

    static {
        f2143b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
        f2144c = new int[]{C0417R.attr.textAllCaps};
    }

    C0635y(TextView textView) {
        this.f2145a = textView;
    }

    protected static bf m2726a(Context context, C0616l c0616l, int i) {
        ColorStateList b = c0616l.m2698b(context, i);
        if (b == null) {
            return null;
        }
        bf bfVar = new bf();
        bfVar.f1985d = true;
        bfVar.f1982a = b;
        return bfVar;
    }

    static C0635y m2727a(TextView textView) {
        return VERSION.SDK_INT >= 17 ? new C0636z(textView) : new C0635y(textView);
    }

    void m2728a() {
        if (this.f2146d != null || this.f2147e != null || this.f2148f != null || this.f2149g != null) {
            Drawable[] compoundDrawables = this.f2145a.getCompoundDrawables();
            m2730a(compoundDrawables[0], this.f2146d);
            m2730a(compoundDrawables[1], this.f2147e);
            m2730a(compoundDrawables[2], this.f2148f);
            m2730a(compoundDrawables[3], this.f2149g);
        }
    }

    void m2729a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f2144c);
        if (obtainStyledAttributes.hasValue(0)) {
            m2732a(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    final void m2730a(Drawable drawable, bf bfVar) {
        if (drawable != null && bfVar != null) {
            C0616l.m2675a(drawable, bfVar, this.f2145a.getDrawableState());
        }
    }

    void m2731a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.f2145a.getContext();
        C0616l a = C0616l.m2672a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2143b, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2146d = C0635y.m2726a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f2147e = C0635y.m2726a(context, a, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f2148f = C0635y.m2726a(context, a, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.f2149g = C0635y.m2726a(context, a, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.f2145a.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0417R.styleable.TextAppearance);
                if (obtainStyledAttributes2.hasValue(C0417R.styleable.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(C0417R.styleable.TextAppearance_textAllCaps, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f2144c, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                m2732a(z);
            }
        }
    }

    void m2732a(boolean z) {
        this.f2145a.setTransformationMethod(z ? new C0418a(this.f2145a.getContext()) : null);
    }
}
