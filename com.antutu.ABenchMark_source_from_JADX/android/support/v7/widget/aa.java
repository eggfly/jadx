package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.util.AttributeSet;
import android.widget.TextView;

public class aa extends TextView implements TintableBackgroundView {
    private C0616l f1134a;
    private C0606g f1135b;
    private C0635y f1136c;

    public aa(Context context) {
        this(context, null);
    }

    public aa(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public aa(Context context, AttributeSet attributeSet, int i) {
        super(be.m2498a(context), attributeSet, i);
        this.f1134a = C0616l.m2672a();
        this.f1135b = new C0606g(this, this.f1134a);
        this.f1135b.m2648a(attributeSet, i);
        this.f1136c = C0635y.m2727a((TextView) this);
        this.f1136c.m2731a(attributeSet, i);
        this.f1136c.m2728a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1135b != null) {
            this.f1135b.m2651c();
        }
        if (this.f1136c != null) {
            this.f1136c.m2728a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1135b != null ? this.f1135b.m2643a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1135b != null ? this.f1135b.m2649b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1135b != null) {
            this.f1135b.m2647a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1135b != null) {
            this.f1135b.m2644a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1135b != null) {
            this.f1135b.m2645a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1135b != null) {
            this.f1135b.m2646a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1136c != null) {
            this.f1136c.m2729a(context, i);
        }
    }
}
