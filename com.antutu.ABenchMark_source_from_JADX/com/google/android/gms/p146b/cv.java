package com.google.android.gms.p146b;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.igexin.download.Downloads;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@gb
/* renamed from: com.google.android.gms.b.cv */
class cv {
    private final Object[] f10526a;
    private boolean f10527b;

    cv(AdRequestParcel adRequestParcel, String str, int i) {
        this.f10526a = cv.m12152a(adRequestParcel, str, i);
    }

    private static String m12151a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(new ArrayList(bundle.keySet()));
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            String str2 = obj == null ? "null" : obj instanceof Bundle ? cv.m12151a((Bundle) obj) : obj.toString();
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }

    private static Object[] m12152a(AdRequestParcel adRequestParcel, String str, int i) {
        Set hashSet = new HashSet(Arrays.asList(((String) aq.af.m11794c()).split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(adRequestParcel.f9308b));
        }
        if (hashSet.contains(Downloads.COLUMN_EXTRAS)) {
            arrayList.add(cv.m12151a(adRequestParcel.f9309c));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(adRequestParcel.f9310d));
        }
        if (hashSet.contains("keywords")) {
            if (adRequestParcel.f9311e != null) {
                arrayList.add(adRequestParcel.f9311e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.f9312f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(adRequestParcel.f9313g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.f9314h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(adRequestParcel.f9315i);
        }
        if (hashSet.contains(MsgConstant.KEY_LOCATION_PARAMS)) {
            if (adRequestParcel.f9317k != null) {
                arrayList.add(adRequestParcel.f9317k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(adRequestParcel.f9318l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(cv.m12151a(adRequestParcel.f9319m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(cv.m12151a(adRequestParcel.f9320n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (adRequestParcel.f9321o != null) {
                arrayList.add(adRequestParcel.f9321o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(adRequestParcel.f9322p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(adRequestParcel.f9323q);
        }
        return arrayList.toArray();
    }

    void m12153a() {
        this.f10527b = true;
    }

    boolean m12154b() {
        return this.f10527b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cv)) {
            return false;
        }
        return Arrays.equals(this.f10526a, ((cv) obj).f10526a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10526a);
    }

    public String toString() {
        return "[InterstitialAdPoolKey " + Arrays.toString(this.f10526a) + "]";
    }
}
