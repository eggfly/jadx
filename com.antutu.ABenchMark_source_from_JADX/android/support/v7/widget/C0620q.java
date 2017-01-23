package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.q */
public class C0620q extends MultiAutoCompleteTextView implements TintableBackgroundView {
    private static final int[] f2097a;
    private C0616l f2098b;
    private C0606g f2099c;
    private C0635y f2100d;

    static {
        f2097a = new int[]{16843126};
    }

    public C0620q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.autoCompleteTextViewStyle);
    }

    public C0620q(Context context, AttributeSet attributeSet, int i) {
        super(be.m2498a(context), attributeSet, i);
        this.f2098b = C0616l.m2672a();
        bh a = bh.m2502a(getContext(), attributeSet, f2097a, i, 0);
        if (a.m2517f(0)) {
            setDropDownBackgroundDrawable(a.m2505a(0));
        }
        a.m2506a();
        this.f2099c = new C0606g(this, this.f2098b);
        this.f2099c.m2648a(attributeSet, i);
        this.f2100d = C0635y.m2727a((TextView) this);
        this.f2100d.m2731a(attributeSet, i);
        this.f2100d.m2728a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2099c != null) {
            this.f2099c.m2651c();
        }
        if (this.f2100d != null) {
            this.f2100d.m2728a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2099c != null ? this.f2099c.m2643a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2099c != null ? this.f2099c.m2649b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2099c != null) {
            this.f2099c.m2647a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2099c != null) {
            this.f2099c.m2644a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f2098b != null) {
            setDropDownBackgroundDrawable(this.f2098b.m2695a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2099c != null) {
            this.f2099c.m2645a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2099c != null) {
            this.f2099c.m2646a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2100d != null) {
            this.f2100d.m2729a(context, i);
        }
    }
}
