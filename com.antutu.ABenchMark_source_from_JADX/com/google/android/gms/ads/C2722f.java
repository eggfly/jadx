package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.C2646a;
import com.google.android.gms.ads.internal.client.C2756c;
import com.google.android.gms.ads.purchase.C2992b;

/* renamed from: com.google.android.gms.ads.f */
class C2722f extends ViewGroup {
    private final C2756c f9284a;

    public C2722f(Context context, int i) {
        super(context);
        this.f9284a = new C2756c(this, C2722f.m10363a(i));
    }

    private static boolean m10363a(int i) {
        return i == 2;
    }

    public void m10364a() {
        this.f9284a.m10631j();
    }

    public void m10365a(C2716c c2716c) {
        this.f9284a.m10617a(c2716c.m10333a());
    }

    public void m10366b() {
        this.f9284a.m10630i();
    }

    public void m10367c() {
        this.f9284a.m10611a();
    }

    public C2301a getAdListener() {
        return this.f9284a.m10622b();
    }

    public C2719d getAdSize() {
        return this.f9284a.m10624c();
    }

    public String getAdUnitId() {
        return this.f9284a.m10626e();
    }

    public C2992b getInAppPurchaseListener() {
        return this.f9284a.m10628g();
    }

    public String getMediationAdapterClassName() {
        return this.f9284a.m10632k();
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
        this.f9284a.m10614a(c2301a);
        if (c2301a != null && (c2301a instanceof C2646a)) {
            this.f9284a.m10616a((C2646a) c2301a);
        } else if (c2301a == null) {
            this.f9284a.m10616a(null);
        }
    }

    public void setAdSize(C2719d c2719d) {
        this.f9284a.m10621a(c2719d);
    }

    public void setAdUnitId(String str) {
        this.f9284a.m10619a(str);
    }

    public void setInAppPurchaseListener(C2992b c2992b) {
        this.f9284a.m10618a(c2992b);
    }
}
