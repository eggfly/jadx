package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.m */
public class C0617m extends EditText implements TintableBackgroundView {
    private C0616l f2090a;
    private C0606g f2091b;
    private C0635y f2092c;

    public C0617m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.editTextStyle);
    }

    public C0617m(Context context, AttributeSet attributeSet, int i) {
        super(be.m2498a(context), attributeSet, i);
        this.f2090a = C0616l.m2672a();
        this.f2091b = new C0606g(this, this.f2090a);
        this.f2091b.m2648a(attributeSet, i);
        this.f2092c = C0635y.m2727a((TextView) this);
        this.f2092c.m2731a(attributeSet, i);
        this.f2092c.m2728a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2091b != null) {
            this.f2091b.m2651c();
        }
        if (this.f2092c != null) {
            this.f2092c.m2728a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2091b != null ? this.f2091b.m2643a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2091b != null ? this.f2091b.m2649b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2091b != null) {
            this.f2091b.m2647a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2091b != null) {
            this.f2091b.m2644a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2091b != null) {
            this.f2091b.m2645a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2091b != null) {
            this.f2091b.m2646a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2092c != null) {
            this.f2092c.m2729a(context, i);
        }
    }
}
