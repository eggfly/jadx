package com.google.android.gms.ads.formats;

import agg;
import agh;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.bf;

public abstract class NativeAdView extends FrameLayout {
    private final bf DW;
    private final FrameLayout j6;

    public NativeAdView(Context context) {
        super(context);
        this.j6 = DW(context);
        this.DW = j6();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = DW(context);
        this.DW = j6();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j6 = DW(context);
        this.DW = j6();
    }

    private FrameLayout DW(Context context) {
        View j6 = j6(context);
        j6.setLayoutParams(new LayoutParams(-1, -1));
        addView(j6);
        return j6;
    }

    private bf j6() {
        b.j6(this.j6, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return w.DW().j6(this.j6.getContext(), (FrameLayout) this, this.j6);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.j6);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.j6 != view) {
            super.bringChildToFront(this.j6);
        }
    }

    protected View j6(String str) {
        try {
            agg j6 = this.DW.j6(str);
            if (j6 != null) {
                return (View) agh.j6(j6);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.DW("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    FrameLayout j6(Context context) {
        return new FrameLayout(context);
    }

    protected void j6(String str, View view) {
        try {
            this.DW.j6(str, agh.j6((Object) view));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.DW("Unable to call setAssetView on delegate", e);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.j6);
    }

    public void removeView(View view) {
        if (this.j6 != view) {
            super.removeView(view);
        }
    }

    public void setNativeAd(a aVar) {
        try {
            this.DW.j6((agg) aVar.j6());
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.DW("Unable to call setNativeAd on delegate", e);
        }
    }
}
