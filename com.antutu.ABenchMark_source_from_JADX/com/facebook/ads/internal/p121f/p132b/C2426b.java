package com.facebook.ads.internal.p121f.p132b;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0491i;
import android.support.v7.widget.RecyclerView.C0493h;
import android.support.v7.widget.RecyclerView.C0525n;
import android.support.v7.widget.RecyclerView.C0529r;
import android.support.v7.widget.ao;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

/* renamed from: com.facebook.ads.internal.f.b.b */
public class C2426b extends LinearLayoutManager {
    private final C2431d f8373a;
    private final C2424a f8374b;
    private final Context f8375c;
    private int[] f8376d;
    private int f8377e;
    private float f8378f;
    private C2425a f8379g;
    private int f8380h;

    /* renamed from: com.facebook.ads.internal.f.b.b.a */
    private class C2425a extends ao {
        final /* synthetic */ C2426b f8372a;

        public C2425a(C2426b c2426b, Context context) {
            this.f8372a = c2426b;
            super(context);
        }

        public int calculateDxToMakeVisible(View view, int i) {
            C0493h layoutManager = getLayoutManager();
            if (!layoutManager.canScrollHorizontally()) {
                return 0;
            }
            C0491i c0491i = (C0491i) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view) - c0491i.leftMargin, layoutManager.getDecoratedRight(view) + c0491i.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i) + this.f8372a.f8377e;
        }

        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return this.f8372a.f8378f / ((float) displayMetrics.densityDpi);
        }

        public PointF computeScrollVectorForPosition(int i) {
            return this.f8372a.computeScrollVectorForPosition(i);
        }

        protected int getHorizontalSnapPreference() {
            return -1;
        }
    }

    public C2426b(Context context, C2431d c2431d, C2424a c2424a) {
        super(context);
        this.f8377e = 0;
        this.f8378f = 50.0f;
        this.f8375c = context;
        this.f8373a = c2431d;
        this.f8374b = c2424a;
        this.f8380h = -1;
        this.f8379g = new C2425a(this, this.f8375c);
    }

    public void m9282a(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.f8378f = (float) (50.0d / d);
        this.f8379g = new C2425a(this, this.f8375c);
    }

    void m9283a(int i) {
        this.f8380h = i;
    }

    public void m9284b(int i) {
        this.f8377e = i;
    }

    public void onMeasure(C0525n c0525n, C0529r c0529r, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if ((mode == 1073741824 && getOrientation() == 1) || (mode2 == 1073741824 && getOrientation() == 0)) {
            super.onMeasure(c0525n, c0529r, i, i2);
            return;
        }
        int[] a;
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f8374b.m9279b(this.f8380h)) {
            a = this.f8374b.m9278a(this.f8380h);
        } else {
            a = new int[]{0, 0};
            if (getItemCount() >= 1) {
                for (int i3 = 0; i3 < 1; i3++) {
                    this.f8376d = this.f8373a.m9297a(c0525n, i3, MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    if (getOrientation() == 0) {
                        a[0] = a[0] + this.f8376d[0];
                        if (i3 == 0) {
                            a[1] = (this.f8376d[1] + getPaddingTop()) + getPaddingBottom();
                        }
                    } else {
                        a[1] = a[1] + this.f8376d[1];
                        if (i3 == 0) {
                            a[0] = (this.f8376d[0] + getPaddingLeft()) + getPaddingRight();
                        }
                    }
                }
                if (this.f8380h != -1) {
                    this.f8374b.m9277a(this.f8380h, a);
                }
            }
        }
        if (mode == 1073741824) {
            a[0] = size;
        }
        if (mode2 == 1073741824) {
            a[1] = size2;
        }
        setMeasuredDimension(a[0], a[1]);
    }

    public void scrollToPosition(int i) {
        super.scrollToPositionWithOffset(i, this.f8377e);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0529r c0529r, int i) {
        this.f8379g.setTargetPosition(i);
        startSmoothScroll(this.f8379g);
    }
}
