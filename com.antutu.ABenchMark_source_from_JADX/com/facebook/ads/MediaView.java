package com.facebook.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.C2317i;
import com.facebook.ads.internal.p121f.C2451e;
import com.facebook.ads.internal.p121f.p132b.C2430c;
import com.facebook.ads.internal.p121f.p133c.C2449a;
import com.facebook.ads.internal.util.C2502k;
import com.facebook.ads.internal.util.C2510r;

public class MediaView extends RelativeLayout {
    private static final String f7796a;
    private static final int f7797b;
    private final C2451e f7798c;
    private final C2449a f7799d;
    private final C2430c f7800e;
    private boolean f7801f;
    private boolean f7802g;

    static {
        f7796a = MediaView.class.getSimpleName();
        f7797b = Color.argb(51, 145, 150, 165);
    }

    public MediaView(Context context) {
        this(context, null);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7801f = false;
        this.f7802g = true;
        setBackgroundColor(f7797b);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f7798c = new C2451e(context);
        this.f7798c.setVisibility(8);
        addView(this.f7798c, layoutParams);
        this.f7799d = new C2449a(context);
        layoutParams.addRule(13);
        this.f7799d.setAutoplay(this.f7802g);
        this.f7799d.setVisibility(8);
        addView(this.f7799d, layoutParams);
        float f = context.getResources().getDisplayMetrics().density;
        int round = Math.round(4.0f * f);
        int round2 = Math.round(f * 12.0f);
        this.f7800e = new C2430c(getContext());
        this.f7800e.setChildSpacing(round);
        this.f7800e.setPadding(0, round2, 0, round2);
        this.f7800e.setVisibility(8);
        addView(this.f7800e, layoutParams);
    }

    private boolean m8561a(NativeAd nativeAd) {
        return VERSION.SDK_INT >= 14 && !C2510r.m9516a(nativeAd.m8624c());
    }

    private boolean m8562b(NativeAd nativeAd) {
        if (nativeAd.m8628g() == null) {
            return false;
        }
        for (NativeAd adCoverImage : nativeAd.m8628g()) {
            if (adCoverImage.getAdCoverImage() == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isAutoplay() {
        return this.f7802g;
    }

    public void setAutoplay(boolean z) {
        this.f7802g = z;
        this.f7799d.setAutoplay(z);
    }

    public void setNativeAd(NativeAd nativeAd) {
        nativeAd.m8623b(true);
        nativeAd.setMediaViewAutoplay(this.f7802g);
        if (this.f7801f) {
            this.f7798c.m9348a(null, null);
            this.f7799d.setVideoURI(null);
            this.f7801f = false;
        }
        String url = nativeAd.getAdCoverImage() != null ? nativeAd.getAdCoverImage().getUrl() : null;
        this.f7799d.getPlaceholderView().setImageDrawable(null);
        if (m8562b(nativeAd)) {
            this.f7798c.setVisibility(8);
            this.f7799d.setVisibility(8);
            this.f7800e.setVisibility(0);
            bringChildToFront(this.f7800e);
            this.f7800e.setCurrentPosition(0);
            this.f7800e.setAdapter(new C2317i(this.f7800e, nativeAd.m8628g()));
        } else if (m8561a(nativeAd)) {
            String c = nativeAd.m8624c();
            this.f7798c.setVisibility(8);
            this.f7799d.setVisibility(0);
            this.f7800e.setVisibility(8);
            bringChildToFront(this.f7799d);
            this.f7801f = true;
            try {
                this.f7799d.setAutoplay(this.f7802g);
                this.f7799d.setVideoPlayReportMS(nativeAd.m8625d());
                this.f7799d.setVideoPlayReportURI(nativeAd.m8626e());
                this.f7799d.setVideoTimeReportURI(nativeAd.m8627f());
                this.f7799d.setVideoURI(c);
                if (url != null) {
                    new C2502k(this.f7799d.getPlaceholderView()).m9502a(url);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (url != null) {
            this.f7799d.m9332a();
            this.f7798c.setVisibility(0);
            this.f7799d.setVisibility(8);
            this.f7800e.setVisibility(8);
            bringChildToFront(this.f7798c);
            this.f7801f = true;
            new C2502k(this.f7798c).m9502a(url);
        }
    }
}
