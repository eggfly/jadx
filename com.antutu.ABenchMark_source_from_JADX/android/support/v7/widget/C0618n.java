package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: android.support.v7.widget.n */
public class C0618n extends ImageButton implements TintableBackgroundView {
    private C0606g f2093a;
    private C0619o f2094b;

    public C0618n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.imageButtonStyle);
    }

    public C0618n(Context context, AttributeSet attributeSet, int i) {
        super(be.m2498a(context), attributeSet, i);
        C0616l a = C0616l.m2672a();
        this.f2093a = new C0606g(this, a);
        this.f2093a.m2648a(attributeSet, i);
        this.f2094b = new C0619o(this, a);
        this.f2094b.m2700a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2093a != null) {
            this.f2093a.m2651c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2093a != null ? this.f2093a.m2643a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2093a != null ? this.f2093a.m2649b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2093a != null) {
            this.f2093a.m2647a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2093a != null) {
            this.f2093a.m2644a(i);
        }
    }

    public void setImageResource(int i) {
        this.f2094b.m2699a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2093a != null) {
            this.f2093a.m2645a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2093a != null) {
            this.f2093a.m2646a(mode);
        }
    }
}
