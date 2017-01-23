package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public final class NativeContentAdView extends NativeAdView {
    public NativeContentAdView(Context context) {
        super(context);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final View getAdvertiserView() {
        return super.j6("1004");
    }

    public final View getBodyView() {
        return super.j6("1002");
    }

    public final View getCallToActionView() {
        return super.j6("1003");
    }

    public final View getHeadlineView() {
        return super.j6("1001");
    }

    public final View getImageView() {
        return super.j6("1005");
    }

    public final View getLogoView() {
        return super.j6("1006");
    }

    public final void setAdvertiserView(View view) {
        super.j6("1004", view);
    }

    public final void setBodyView(View view) {
        super.j6("1002", view);
    }

    public final void setCallToActionView(View view) {
        super.j6("1003", view);
    }

    public final void setHeadlineView(View view) {
        super.j6("1001", view);
    }

    public final void setImageView(View view) {
        super.j6("1005", view);
    }

    public final void setLogoView(View view) {
        super.j6("1006", view);
    }
}
