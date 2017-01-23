package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.j */
public class C0609j extends CheckedTextView {
    private static final int[] f2065a;
    private C0616l f2066b;
    private C0635y f2067c;

    static {
        f2065a = new int[]{16843016};
    }

    public C0609j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0609j(Context context, AttributeSet attributeSet, int i) {
        super(be.m2498a(context), attributeSet, i);
        this.f2067c = C0635y.m2727a((TextView) this);
        this.f2067c.m2731a(attributeSet, i);
        this.f2067c.m2728a();
        this.f2066b = C0616l.m2672a();
        bh a = bh.m2502a(getContext(), attributeSet, f2065a, i, 0);
        setCheckMarkDrawable(a.m2505a(0));
        a.m2506a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2067c != null) {
            this.f2067c.m2728a();
        }
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f2066b != null) {
            setCheckMarkDrawable(this.f2066b.m2695a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2067c != null) {
            this.f2067c.m2729a(context, i);
        }
    }
}
