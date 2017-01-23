package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.p */
public class C0476p extends ImageView implements TintableBackgroundView {
    private C0606g f1361a;
    private C0619o f1362b;

    public C0476p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0476p(Context context, AttributeSet attributeSet, int i) {
        super(be.m2498a(context), attributeSet, i);
        C0616l a = C0616l.m2672a();
        this.f1361a = new C0606g(this, a);
        this.f1361a.m2648a(attributeSet, i);
        this.f1362b = new C0619o(this, a);
        this.f1362b.m2700a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1361a != null) {
            this.f1361a.m2651c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1361a != null ? this.f1361a.m2643a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1361a != null ? this.f1361a.m2649b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1361a != null) {
            this.f1361a.m2647a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1361a != null) {
            this.f1361a.m2644a(i);
        }
    }

    public void setImageResource(int i) {
        this.f1362b.m2699a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1361a != null) {
            this.f1361a.m2645a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1361a != null) {
            this.f1361a.m2646a(mode);
        }
    }
}
