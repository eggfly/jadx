package com.google.android.gms.ads.internal.client;

import aeq$d;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.d;
import com.google.android.gms.internal.eh;

@eh
public final class zzk {
    private final String DW;
    private final d[] j6;

    public zzk(Context context, AttributeSet attributeSet) {
        Object obj = 1;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, aeq$d.AdsAttrs);
        String string = obtainAttributes.getString(aeq$d.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(aeq$d.AdsAttrs_adSizes);
        Object obj2 = !TextUtils.isEmpty(string) ? 1 : null;
        if (TextUtils.isEmpty(string2)) {
            obj = null;
        }
        if (obj2 != null && r1 == null) {
            this.j6 = j6(string);
        } else if (obj2 == null && r1 != null) {
            this.j6 = j6(string2);
        } else if (obj2 != null) {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else {
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        this.DW = obtainAttributes.getString(aeq$d.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.DW)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static d[] j6(String str) {
        String[] split = str.split("\\s*,\\s*");
        d[] dVarArr = new d[split.length];
        for (int i = 0; i < split.length; i++) {
            String str2;
            String valueOf;
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    dVarArr[i] = new d("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    str2 = "Could not parse XML attribute \"adSize\": ";
                    valueOf = String.valueOf(trim);
                    throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            } else if ("BANNER".equals(trim)) {
                dVarArr[i] = d.j6;
            } else if ("LARGE_BANNER".equals(trim)) {
                dVarArr[i] = d.FH;
            } else if ("FULL_BANNER".equals(trim)) {
                dVarArr[i] = d.DW;
            } else if ("LEADERBOARD".equals(trim)) {
                dVarArr[i] = d.Hw;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                dVarArr[i] = d.v5;
            } else if ("SMART_BANNER".equals(trim)) {
                dVarArr[i] = d.VH;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                dVarArr[i] = d.Zo;
            } else if ("FLUID".equals(trim)) {
                dVarArr[i] = d.gn;
            } else {
                str2 = "Could not parse XML attribute \"adSize\": ";
                valueOf = String.valueOf(trim);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
        }
        if (dVarArr.length != 0) {
            return dVarArr;
        }
        str2 = "Could not parse XML attribute \"adSize\": ";
        valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public String j6() {
        return this.DW;
    }

    public d[] j6(boolean z) {
        if (z || this.j6.length == 1) {
            return this.j6;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
