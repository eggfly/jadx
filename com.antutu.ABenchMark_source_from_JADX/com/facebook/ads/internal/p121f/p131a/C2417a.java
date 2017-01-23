package com.facebook.ads.internal.p121f.p131a;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.p121f.C2463j;
import com.facebook.ads.internal.p121f.C2464k;

/* renamed from: com.facebook.ads.internal.f.a.a */
public class C2417a extends LinearLayout {
    private C2464k f8357a;
    private int f8358b;

    public C2417a(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        int i = 21;
        super(context);
        setOrientation(1);
        setVerticalGravity(16);
        this.f8357a = new C2464k(getContext(), 2);
        this.f8357a.setMinTextSize((float) (nativeAdViewAttributes.getTitleTextSize() - 2));
        this.f8357a.setText(nativeAd.getAdTitle());
        C2463j.m9384a(this.f8357a, nativeAdViewAttributes);
        this.f8357a.setLayoutParams(new LayoutParams(-2, -2));
        addView(this.f8357a);
        if (nativeAd.getAdTitle() != null) {
            i = Math.min(nativeAd.getAdTitle().length(), 21);
        }
        this.f8358b = i;
        addView(C2463j.m9383a(context, nativeAd, nativeAdViewAttributes));
    }

    public int getMinVisibleTitleCharacters() {
        return this.f8358b;
    }

    public TextView getTitleTextView() {
        return this.f8357a;
    }
}
