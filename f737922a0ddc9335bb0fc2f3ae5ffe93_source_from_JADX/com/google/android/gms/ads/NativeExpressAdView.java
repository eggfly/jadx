package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.ads.purchase.b;
import com.google.android.gms.internal.eh;

@eh
public final class NativeExpressAdView extends BaseAdView {
    public NativeExpressAdView(Context context) {
        super(context, 2);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 2);
    }

    public /* bridge */ /* synthetic */ void DW() {
        super.DW();
    }

    public /* bridge */ /* synthetic */ void FH() {
        super.FH();
    }

    public /* bridge */ /* synthetic */ a getAdListener() {
        return super.getAdListener();
    }

    public /* bridge */ /* synthetic */ d getAdSize() {
        return super.getAdSize();
    }

    public /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    public /* bridge */ /* synthetic */ b getInAppPurchaseListener() {
        return super.getInAppPurchaseListener();
    }

    public /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    public f getVideoController() {
        return this.j6.we();
    }

    public g getVideoOptions() {
        return this.j6.J8();
    }

    public /* bridge */ /* synthetic */ void j6() {
        super.j6();
    }

    public /* bridge */ /* synthetic */ void j6(c cVar) {
        super.j6(cVar);
    }

    public /* bridge */ /* synthetic */ void setAdListener(a aVar) {
        super.setAdListener(aVar);
    }

    public /* bridge */ /* synthetic */ void setAdSize(d dVar) {
        super.setAdSize(dVar);
    }

    public /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    public /* bridge */ /* synthetic */ void setInAppPurchaseListener(b bVar) {
        super.setInAppPurchaseListener(bVar);
    }

    public void setVideoOptions(g gVar) {
        this.j6.j6(gVar);
    }
}
