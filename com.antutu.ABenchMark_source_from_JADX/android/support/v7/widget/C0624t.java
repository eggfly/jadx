package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* renamed from: android.support.v7.widget.t */
public class C0624t extends RadioButton implements TintableCompoundButton {
    private C0616l f2110a;
    private C0610k f2111b;

    public C0624t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.radioButtonStyle);
    }

    public C0624t(Context context, AttributeSet attributeSet, int i) {
        super(be.m2498a(context), attributeSet, i);
        this.f2110a = C0616l.m2672a();
        this.f2111b = new C0610k(this, this.f2110a);
        this.f2111b.m2656a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2111b != null ? this.f2111b.m2652a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f2111b != null ? this.f2111b.m2653a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.f2111b != null ? this.f2111b.m2657b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f2110a != null ? this.f2110a.m2695a(getContext(), i) : ContextCompat.getDrawable(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2111b != null) {
            this.f2111b.m2658c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2111b != null) {
            this.f2111b.m2654a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f2111b != null) {
            this.f2111b.m2655a(mode);
        }
    }
}
