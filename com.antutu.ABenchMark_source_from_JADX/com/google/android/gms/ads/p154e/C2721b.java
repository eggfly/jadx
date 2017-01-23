package com.google.android.gms.ads.p154e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C2301a;
import com.google.android.gms.ads.C2719d;
import com.google.android.gms.ads.internal.client.C2756c;

/* renamed from: com.google.android.gms.ads.e.b */
public final class C2721b extends ViewGroup {
    private final C2756c f9283a;

    public C2301a getAdListener() {
        return this.f9283a.m10622b();
    }

    public C2719d getAdSize() {
        return this.f9283a.m10624c();
    }

    public String getAdUnitId() {
        return this.f9283a.m10626e();
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
        this.f9283a.m10614a(c2301a);
    }

    public void setAdSize(C2719d c2719d) {
        this.f9283a.m10621a(c2719d);
    }

    public void setAdUnitId(String str) {
        this.f9283a.m10619a(str);
    }
}
