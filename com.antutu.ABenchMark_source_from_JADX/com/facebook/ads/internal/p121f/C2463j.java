package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;

/* renamed from: com.facebook.ads.internal.f.j */
public abstract class C2463j {
    public static LinearLayout m9383a(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        LinearLayout linearLayout = new LinearLayout(context);
        View c2465l = new C2465l(context);
        c2465l.setText(nativeAd.getAdSocialContext());
        C2463j.m9385b(c2465l, nativeAdViewAttributes);
        linearLayout.addView(c2465l);
        return linearLayout;
    }

    public static void m9384a(TextView textView, NativeAdViewAttributes nativeAdViewAttributes) {
        textView.setTextColor(nativeAdViewAttributes.getTitleTextColor());
        textView.setTextSize((float) nativeAdViewAttributes.getTitleTextSize());
        textView.setTypeface(nativeAdViewAttributes.getTypeface(), 1);
    }

    public static void m9385b(TextView textView, NativeAdViewAttributes nativeAdViewAttributes) {
        textView.setTextColor(nativeAdViewAttributes.getDescriptionTextColor());
        textView.setTextSize((float) nativeAdViewAttributes.getDescriptionTextSize());
        textView.setTypeface(nativeAdViewAttributes.getTypeface());
    }
}
