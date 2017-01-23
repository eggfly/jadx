package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.internal.client.f;

public final class PublisherAdView extends ViewGroup {
    private final f j6;

    public PublisherAdView(Context context) {
        super(context);
        this.j6 = new f(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = new f(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j6 = new f(this, attributeSet, true);
    }

    public a getAdListener() {
        return this.j6.DW();
    }

    public d getAdSize() {
        return this.j6.FH();
    }

    public d[] getAdSizes() {
        return this.j6.Hw();
    }

    public String getAdUnitId() {
        return this.j6.v5();
    }

    public a getAppEventListener() {
        return this.j6.Zo();
    }

    public String getMediationAdapterClassName() {
        return this.j6.EQ();
    }

    public c getOnCustomRenderedAdLoadedListener() {
        return this.j6.gn();
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
        int DW;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            d adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                DW = adSize.DW(context);
                i3 = adSize.j6(context);
            } else {
                DW = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            DW = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(DW, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(a aVar) {
        this.j6.j6(aVar);
    }

    public void setAdSizes(d... dVarArr) {
        if (dVarArr == null || dVarArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.j6.DW(dVarArr);
    }

    public void setAdUnitId(String str) {
        this.j6.j6(str);
    }

    public void setAppEventListener(a aVar) {
        this.j6.j6(aVar);
    }

    public void setCorrelator(e eVar) {
        this.j6.j6(eVar);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.j6.j6(z);
    }

    public void setOnCustomRenderedAdLoadedListener(c cVar) {
        this.j6.j6(cVar);
    }
}
