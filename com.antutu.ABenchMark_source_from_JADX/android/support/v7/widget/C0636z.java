package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.z */
class C0636z extends C0635y {
    private static final int[] f2150b;
    private bf f2151c;
    private bf f2152d;

    static {
        f2150b = new int[]{16843666, 16843667};
    }

    C0636z(TextView textView) {
        super(textView);
    }

    void m2733a() {
        super.m2728a();
        if (this.f2151c != null || this.f2152d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m2730a(compoundDrawablesRelative[0], this.f2151c);
            m2730a(compoundDrawablesRelative[2], this.f2152d);
        }
    }

    void m2734a(AttributeSet attributeSet, int i) {
        super.m2731a(attributeSet, i);
        Context context = this.a.getContext();
        C0616l a = C0616l.m2672a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2150b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f2151c = C0635y.m2726a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2152d = C0635y.m2726a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
