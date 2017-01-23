package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hf;

@gb
/* renamed from: com.google.android.gms.ads.internal.overlay.a */
public class C2845a {
    public boolean m11043a(Context context, Intent intent, C2730p c2730p) {
        try {
            hf.m12982e("Launching an intent: " + intent.toURI());
            C2968s.m11525e().m13033a(context, intent);
            if (c2730p != null) {
                c2730p.m10416l();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            C2972b.m11583d(e.getMessage());
            return false;
        }
    }

    public boolean m11044a(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, C2730p c2730p) {
        int i = 0;
        if (adLauncherIntentInfoParcel == null) {
            C2972b.m11583d("No intent data for launcher overlay.");
            return i;
        } else if (adLauncherIntentInfoParcel.f9644i != null) {
            return m11043a(context, adLauncherIntentInfoParcel.f9644i, c2730p);
        } else {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.f9638c)) {
                C2972b.m11583d("Open GMSG did not contain a URL.");
                return i;
            }
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.f9639d)) {
                intent.setData(Uri.parse(adLauncherIntentInfoParcel.f9638c));
            } else {
                intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.f9638c), adLauncherIntentInfoParcel.f9639d);
            }
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f9640e)) {
                intent.setPackage(adLauncherIntentInfoParcel.f9640e);
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f9641f)) {
                String[] split = adLauncherIntentInfoParcel.f9641f.split("/", 2);
                if (split.length < 2) {
                    C2972b.m11583d("Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.f9641f);
                    return i;
                }
                intent.setClassName(split[i], split[1]);
            }
            Object obj = adLauncherIntentInfoParcel.f9642g;
            if (!TextUtils.isEmpty(obj)) {
                try {
                    i = Integer.parseInt(obj);
                } catch (NumberFormatException e) {
                    C2972b.m11583d("Could not parse intent flags.");
                }
                intent.addFlags(i);
            }
            return m11043a(context, intent, c2730p);
        }
    }
}
