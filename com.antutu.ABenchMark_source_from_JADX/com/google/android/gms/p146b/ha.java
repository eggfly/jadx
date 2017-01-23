package com.google.android.gms.p146b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import anet.channel.strategy.dispatch.C0714a;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;

@gb
/* renamed from: com.google.android.gms.b.ha */
public class ha {
    long f11253a;
    long f11254b;
    int f11255c;
    final String f11256d;
    int f11257e;
    int f11258f;
    private final Object f11259g;

    public ha(String str) {
        this.f11253a = -1;
        this.f11254b = -1;
        this.f11255c = -1;
        this.f11259g = new Object();
        this.f11257e = 0;
        this.f11258f = 0;
        this.f11256d = str;
    }

    public static boolean m12969a(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", C0714a.ANDROID);
        if (identifier == 0) {
            C2972b.m11581c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                return true;
            }
            C2972b.m11581c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            C2972b.m11583d("Fail to fetch AdActivity theme");
            C2972b.m11581c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public long m12970a() {
        return this.f11254b;
    }

    public Bundle m12971a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f11259g) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f11256d);
            bundle.putLong("basets", this.f11254b);
            bundle.putLong("currts", this.f11253a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f11255c);
            bundle.putInt("pclick", this.f11257e);
            bundle.putInt("pimp", this.f11258f);
            bundle.putBoolean("support_transparent_background", ha.m12969a(context));
        }
        return bundle;
    }

    public void m12972a(AdRequestParcel adRequestParcel, long j) {
        synchronized (this.f11259g) {
            if (this.f11254b == -1) {
                this.f11254b = j;
                this.f11253a = this.f11254b;
            } else {
                this.f11253a = j;
            }
            if (adRequestParcel.f9309c == null || adRequestParcel.f9309c.getInt("gw", 2) != 1) {
                this.f11255c++;
                return;
            }
        }
    }

    public void m12973b() {
        synchronized (this.f11259g) {
            this.f11257e++;
        }
    }

    public void m12974c() {
        synchronized (this.f11259g) {
            this.f11258f++;
        }
    }
}
