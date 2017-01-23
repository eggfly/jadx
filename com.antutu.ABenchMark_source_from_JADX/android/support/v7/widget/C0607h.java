package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.h */
public class C0607h extends Button implements TintableBackgroundView {
    private final C0616l f2060a;
    private final C0606g f2061b;
    private final C0635y f2062c;

    public C0607h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.buttonStyle);
    }

    public C0607h(Context context, AttributeSet attributeSet, int i) {
        super(be.m2498a(context), attributeSet, i);
        this.f2060a = C0616l.m2672a();
        this.f2061b = new C0606g(this, this.f2060a);
        this.f2061b.m2648a(attributeSet, i);
        this.f2062c = C0635y.m2727a((TextView) this);
        this.f2062c.m2731a(attributeSet, i);
        this.f2062c.m2728a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2061b != null) {
            this.f2061b.m2651c();
        }
        if (this.f2062c != null) {
            this.f2062c.m2728a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2061b != null ? this.f2061b.m2643a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2061b != null ? this.f2061b.m2649b() : null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2061b != null) {
            this.f2061b.m2647a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2061b != null) {
            this.f2061b.m2644a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f2062c != null) {
            this.f2062c.m2732a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2061b != null) {
            this.f2061b.m2645a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2061b != null) {
            this.f2061b.m2646a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2062c != null) {
            this.f2062c.m2729a(context, i);
        }
    }
}
