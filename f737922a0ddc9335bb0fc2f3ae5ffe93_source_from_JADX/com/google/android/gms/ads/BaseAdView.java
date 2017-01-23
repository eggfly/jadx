package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.client.f;
import com.google.android.gms.ads.purchase.b;

class BaseAdView extends ViewGroup {
    protected final f j6;

    public BaseAdView(Context context, int i) {
        super(context);
        this.j6 = new f(this, j6(i));
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.j6 = new f(this, attributeSet, false, j6(i));
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.j6 = new f(this, attributeSet, false, j6(i2));
    }

    private static boolean j6(int i) {
        return i == 2;
    }

    public void DW() {
        this.j6.u7();
    }

    public void FH() {
        this.j6.j6();
    }

    public a getAdListener() {
        return this.j6.DW();
    }

    public d getAdSize() {
        return this.j6.FH();
    }

    public String getAdUnitId() {
        return this.j6.v5();
    }

    public b getInAppPurchaseListener() {
        return this.j6.VH();
    }

    public String getMediationAdapterClassName() {
        return this.j6.EQ();
    }

    public void j6() {
        this.j6.tp();
    }

    public void j6(c cVar) {
        this.j6.j6(cVar.j6());
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
        if (aVar != null && (aVar instanceof a)) {
            this.j6.j6((a) aVar);
        } else if (aVar == null) {
            this.j6.j6(null);
        }
    }

    public void setAdSize(d dVar) {
        this.j6.j6(dVar);
    }

    public void setAdUnitId(String str) {
        this.j6.j6(str);
    }

    public void setInAppPurchaseListener(b bVar) {
        this.j6.j6(bVar);
    }
}
