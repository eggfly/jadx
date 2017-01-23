package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0413b;
import android.support.v7.view.C0413b.C0345a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v7.app.a */
public abstract class C0355a {

    /* renamed from: android.support.v7.app.a.a */
    public static class C0352a extends MarginLayoutParams {
        public int f849a;

        public C0352a(int i, int i2) {
            super(i, i2);
            this.f849a = 0;
            this.f849a = 8388627;
        }

        public C0352a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f849a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.ActionBarLayout);
            this.f849a = obtainStyledAttributes.getInt(C0417R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0352a(C0352a c0352a) {
            super(c0352a);
            this.f849a = 0;
            this.f849a = c0352a.f849a;
        }

        public C0352a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f849a = 0;
        }
    }

    /* renamed from: android.support.v7.app.a.b */
    public interface C0353b {
        void m983a(boolean z);
    }

    /* renamed from: android.support.v7.app.a.c */
    public static abstract class C0354c {
        public abstract Drawable m984a();

        public abstract CharSequence m985b();

        public abstract View m986c();

        public abstract void m987d();

        public abstract CharSequence m988e();
    }

    public abstract int m989a();

    public C0413b m990a(C0345a c0345a) {
        return null;
    }

    public void m991a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void m992a(int i) {
    }

    public void m993a(Configuration configuration) {
    }

    public void m994a(CharSequence charSequence) {
    }

    public void m995a(boolean z) {
    }

    public boolean m996a(int i, KeyEvent keyEvent) {
        return false;
    }

    public void m997b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public abstract boolean m998b();

    public Context m999c() {
        return null;
    }

    public void m1000c(boolean z) {
    }

    public int m1001d() {
        return 0;
    }

    public void m1002d(boolean z) {
    }

    public void m1003e(boolean z) {
    }

    public boolean m1004e() {
        return false;
    }

    public boolean m1005f() {
        return false;
    }

    boolean m1006g() {
        return false;
    }

    void m1007h() {
    }
}
