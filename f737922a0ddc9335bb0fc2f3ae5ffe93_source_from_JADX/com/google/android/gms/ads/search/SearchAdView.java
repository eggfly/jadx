package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.internal.client.f;
import com.google.android.gms.internal.eh;

@eh
public final class SearchAdView extends ViewGroup {
    private final f j6;

    public SearchAdView(Context context) {
        super(context);
        this.j6 = new f(this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = new f(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j6 = new f(this, attributeSet, false);
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

    public void setAdSize(d dVar) {
        this.j6.j6(dVar);
    }

    public void setAdUnitId(String str) {
        this.j6.j6(str);
    }
}
