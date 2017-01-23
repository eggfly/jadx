package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.C2686R;
import com.google.android.gms.ads.C2719d;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.t */
public final class C2782t {
    private final C2719d[] f9452a;
    private final String f9453b;

    public C2782t(Context context, AttributeSet attributeSet) {
        Object obj = 1;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C2686R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(C2686R.styleable.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(C2686R.styleable.AdsAttrs_adSizes);
        Object obj2 = !TextUtils.isEmpty(string) ? 1 : null;
        if (TextUtils.isEmpty(string2)) {
            obj = null;
        }
        if (obj2 != null && r1 == null) {
            this.f9452a = C2782t.m10732a(string);
        } else if (obj2 == null && r1 != null) {
            this.f9452a = C2782t.m10732a(string2);
        } else if (obj2 == null || r1 == null) {
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        } else {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        }
        this.f9453b = obtainAttributes.getString(C2686R.styleable.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.f9453b)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static C2719d[] m10732a(String str) {
        String[] split = str.split("\\s*,\\s*");
        C2719d[] c2719dArr = new C2719d[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    c2719dArr[i] = new C2719d("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + trim);
                }
            } else if ("BANNER".equals(trim)) {
                c2719dArr[i] = C2719d.f9257a;
            } else if ("LARGE_BANNER".equals(trim)) {
                c2719dArr[i] = C2719d.f9259c;
            } else if ("FULL_BANNER".equals(trim)) {
                c2719dArr[i] = C2719d.f9258b;
            } else if ("LEADERBOARD".equals(trim)) {
                c2719dArr[i] = C2719d.f9260d;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                c2719dArr[i] = C2719d.f9261e;
            } else if ("SMART_BANNER".equals(trim)) {
                c2719dArr[i] = C2719d.f9263g;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                c2719dArr[i] = C2719d.f9262f;
            } else if ("FLUID".equals(trim)) {
                c2719dArr[i] = C2719d.f9264h;
            } else {
                throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + trim);
            }
        }
        if (c2719dArr.length != 0) {
            return c2719dArr;
        }
        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
    }

    public String m10733a() {
        return this.f9453b;
    }

    public C2719d[] m10734a(boolean z) {
        if (z || this.f9452a.length == 1) {
            return this.f9452a;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
