package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f1754a;
    private int f1755b;
    private WeakReference<View> f1756c;
    private LayoutInflater f1757d;
    private C0554a f1758e;

    /* renamed from: android.support.v7.widget.ViewStubCompat.a */
    public interface C0554a {
        void m2154a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1754a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.ViewStubCompat, i, 0);
        this.f1755b = obtainStyledAttributes.getResourceId(C0417R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f1754a = obtainStyledAttributes.getResourceId(C0417R.styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0417R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View m2155a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1754a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = (this.f1757d != null ? this.f1757d : LayoutInflater.from(getContext())).inflate(this.f1754a, viewGroup, false);
            if (this.f1755b != -1) {
                inflate.setId(this.f1755b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1756c = new WeakReference(inflate);
            if (this.f1758e != null) {
                this.f1758e.m2154a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1755b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1757d;
    }

    public int getLayoutResource() {
        return this.f1754a;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f1755b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1757d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f1754a = i;
    }

    public void setOnInflateListener(C0554a c0554a) {
        this.f1758e = c0554a;
    }

    public void setVisibility(int i) {
        if (this.f1756c != null) {
            View view = (View) this.f1756c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m2155a();
        }
    }
}
