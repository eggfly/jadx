package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.internal.adapters.c */
public class C2300c extends BroadcastReceiver {
    private String f7961a;
    private Context f7962b;
    private InterstitialAdapterListener f7963c;
    private InterstitialAdapter f7964d;

    public C2300c(Context context, String str, InterstitialAdapter interstitialAdapter, InterstitialAdapterListener interstitialAdapterListener) {
        this.f7962b = context;
        this.f7961a = str;
        this.f7963c = interstitialAdapterListener;
        this.f7964d = interstitialAdapter;
    }

    public void m8721a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.f7961a);
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f7961a);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.f7961a);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.f7961a);
        intentFilter.addAction("com.facebook.ads.interstitial.error:" + this.f7961a);
        LocalBroadcastManager.getInstance(this.f7962b).registerReceiver(this, intentFilter);
    }

    public void m8722b() {
        try {
            LocalBroadcastManager.getInstance(this.f7962b).unregisterReceiver(this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        Object obj = intent.getAction().split(":")[0];
        if (this.f7963c != null && obj != null) {
            if ("com.facebook.ads.interstitial.clicked".equals(obj)) {
                this.f7963c.onInterstitialAdClicked(this.f7964d, intent.getStringExtra("com.facebook.ads.interstitial.ad.click.url"), intent.getBooleanExtra("com.facebook.ads.interstitial.ad.player.handles.click", true));
            } else if ("com.facebook.ads.interstitial.dismissed".equals(obj)) {
                this.f7963c.onInterstitialAdDismissed(this.f7964d);
            } else if ("com.facebook.ads.interstitial.displayed".equals(obj)) {
                this.f7963c.onInterstitialAdDisplayed(this.f7964d);
            } else if ("com.facebook.ads.interstitial.impression.logged".equals(obj)) {
                this.f7963c.onInterstitialLoggingImpression(this.f7964d);
            } else if ("com.facebook.ads.interstitial.error".equals(obj)) {
                this.f7963c.onInterstitialError(this.f7964d, AdError.INTERNAL_ERROR);
            }
        }
    }
}
