package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v7.widget.g */
class C0606g {
    private final View f2055a;
    private final C0616l f2056b;
    private bf f2057c;
    private bf f2058d;
    private bf f2059e;

    C0606g(View view, C0616l c0616l) {
        this.f2055a = view;
        this.f2056b = c0616l;
    }

    private boolean m2642b(Drawable drawable) {
        if (this.f2059e == null) {
            this.f2059e = new bf();
        }
        bf bfVar = this.f2059e;
        bfVar.m2500a();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.f2055a);
        if (backgroundTintList != null) {
            bfVar.f1985d = true;
            bfVar.f1982a = backgroundTintList;
        }
        Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.f2055a);
        if (backgroundTintMode != null) {
            bfVar.f1984c = true;
            bfVar.f1983b = backgroundTintMode;
        }
        if (!bfVar.f1985d && !bfVar.f1984c) {
            return false;
        }
        C0616l.m2675a(drawable, bfVar, this.f2055a.getDrawableState());
        return true;
    }

    ColorStateList m2643a() {
        return this.f2058d != null ? this.f2058d.f1982a : null;
    }

    void m2644a(int i) {
        m2650b(this.f2056b != null ? this.f2056b.m2698b(this.f2055a.getContext(), i) : null);
    }

    void m2645a(ColorStateList colorStateList) {
        if (this.f2058d == null) {
            this.f2058d = new bf();
        }
        this.f2058d.f1982a = colorStateList;
        this.f2058d.f1985d = true;
        m2651c();
    }

    void m2646a(Mode mode) {
        if (this.f2058d == null) {
            this.f2058d = new bf();
        }
        this.f2058d.f1983b = mode;
        this.f2058d.f1984c = true;
        m2651c();
    }

    void m2647a(Drawable drawable) {
        m2650b(null);
    }

    void m2648a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2055a.getContext().obtainStyledAttributes(attributeSet, C0417R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0417R.styleable.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.f2056b.m2698b(this.f2055a.getContext(), obtainStyledAttributes.getResourceId(C0417R.styleable.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    m2650b(b);
                }
            }
            if (obtainStyledAttributes.hasValue(C0417R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.f2055a, obtainStyledAttributes.getColorStateList(C0417R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(C0417R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.f2055a, ak.m2319a(obtainStyledAttributes.getInt(C0417R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode m2649b() {
        return this.f2058d != null ? this.f2058d.f1983b : null;
    }

    void m2650b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2057c == null) {
                this.f2057c = new bf();
            }
            this.f2057c.f1982a = colorStateList;
            this.f2057c.f1985d = true;
        } else {
            this.f2057c = null;
        }
        m2651c();
    }

    void m2651c() {
        Drawable background = this.f2055a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !m2642b(background)) {
            if (this.f2058d != null) {
                C0616l.m2675a(background, this.f2058d, this.f2055a.getDrawableState());
            } else if (this.f2057c != null) {
                C0616l.m2675a(background, this.f2057c, this.f2055a.getDrawableState());
            }
        }
    }
}
