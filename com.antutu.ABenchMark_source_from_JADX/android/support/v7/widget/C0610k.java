package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* renamed from: android.support.v7.widget.k */
class C0610k {
    private final CompoundButton f2068a;
    private final C0616l f2069b;
    private ColorStateList f2070c;
    private Mode f2071d;
    private boolean f2072e;
    private boolean f2073f;
    private boolean f2074g;

    C0610k(CompoundButton compoundButton, C0616l c0616l) {
        this.f2070c = null;
        this.f2071d = null;
        this.f2072e = false;
        this.f2073f = false;
        this.f2068a = compoundButton;
        this.f2069b = c0616l;
    }

    int m2652a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f2068a);
        return buttonDrawable != null ? i + buttonDrawable.getIntrinsicWidth() : i;
    }

    ColorStateList m2653a() {
        return this.f2070c;
    }

    void m2654a(ColorStateList colorStateList) {
        this.f2070c = colorStateList;
        this.f2072e = true;
        m2659d();
    }

    void m2655a(Mode mode) {
        this.f2071d = mode;
        this.f2073f = true;
        m2659d();
    }

    void m2656a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2068a.getContext().obtainStyledAttributes(attributeSet, C0417R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0417R.styleable.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0417R.styleable.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f2068a.setButtonDrawable(this.f2069b.m2695a(this.f2068a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0417R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.f2068a, obtainStyledAttributes.getColorStateList(C0417R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0417R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.f2068a, ak.m2319a(obtainStyledAttributes.getInt(C0417R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode m2657b() {
        return this.f2071d;
    }

    void m2658c() {
        if (this.f2074g) {
            this.f2074g = false;
            return;
        }
        this.f2074g = true;
        m2659d();
    }

    void m2659d() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f2068a);
        if (buttonDrawable == null) {
            return;
        }
        if (this.f2072e || this.f2073f) {
            buttonDrawable = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.f2072e) {
                DrawableCompat.setTintList(buttonDrawable, this.f2070c);
            }
            if (this.f2073f) {
                DrawableCompat.setTintMode(buttonDrawable, this.f2071d);
            }
            if (buttonDrawable.isStateful()) {
                buttonDrawable.setState(this.f2068a.getDrawableState());
            }
            this.f2068a.setButtonDrawable(buttonDrawable);
        }
    }
}
