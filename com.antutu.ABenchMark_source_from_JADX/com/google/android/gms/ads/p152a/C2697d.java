package com.google.android.gms.ads.p152a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C2301a;
import com.google.android.gms.ads.C2719d;
import com.google.android.gms.ads.C2724g;
import com.google.android.gms.ads.internal.client.C2756c;

/* renamed from: com.google.android.gms.ads.a.d */
public final class C2697d extends ViewGroup {
    private final C2756c f9227a;

    public C2301a getAdListener() {
        return this.f9227a.m10622b();
    }

    public C2719d getAdSize() {
        return this.f9227a.m10624c();
    }

    public C2719d[] getAdSizes() {
        return this.f9227a.m10625d();
    }

    public String getAdUnitId() {
        return this.f9227a.m10626e();
    }

    public C2694a getAppEventListener() {
        return this.f9227a.m10627f();
    }

    public String getMediationAdapterClassName() {
        return this.f9227a.m10632k();
    }

    public C2696c getOnCustomRenderedAdLoadedListener() {
        return this.f9227a.m10629h();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int b;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            C2719d adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                b = adSize.m10347b(context);
                i3 = adSize.m10345a(context);
            } else {
                b = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            b = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(b, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(C2301a c2301a) {
        this.f9227a.m10614a(c2301a);
    }

    public void setAdSizes(C2719d... c2719dArr) {
        if (c2719dArr == null || c2719dArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f9227a.m10623b(c2719dArr);
    }

    public void setAdUnitId(String str) {
        this.f9227a.m10619a(str);
    }

    public void setAppEventListener(C2694a c2694a) {
        this.f9227a.m10612a(c2694a);
    }

    public void setCorrelator(C2724g c2724g) {
        this.f9227a.m10615a(c2724g);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.f9227a.m10620a(z);
    }

    public void setOnCustomRenderedAdLoadedListener(C2696c c2696c) {
        this.f9227a.m10613a(c2696c);
    }
}
