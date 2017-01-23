package com.google.android.gms.p146b;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@gb
/* renamed from: com.google.android.gms.b.cz */
class cz {
    final AdRequestParcel f10552a;
    final String f10553b;
    final int f10554c;

    cz(AdRequestParcel adRequestParcel, String str, int i) {
        this.f10552a = adRequestParcel;
        this.f10553b = str;
        this.f10554c = i;
    }

    cz(cx cxVar) {
        this(cxVar.m12168a(), cxVar.m12171c(), cxVar.m12170b());
    }

    cz(String str) {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            this.f10553b = new String(Base64.decode(split[0], 0), HttpRequest.f14548a);
            this.f10554c = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            this.f10552a = AdRequestParcel.CREATOR.m10724a(obtain);
            obtain.recycle();
        } catch (IllegalArgumentException e) {
            throw new IOException("Malformed QueueSeed encoding.");
        } catch (Throwable th) {
            obtain.recycle();
        }
    }

    String m12198a() {
        String encodeToString;
        Parcel obtain = Parcel.obtain();
        try {
            encodeToString = Base64.encodeToString(this.f10553b.getBytes(HttpRequest.f14548a), 0);
            String num = Integer.toString(this.f10554c);
            this.f10552a.writeToParcel(obtain, 0);
            encodeToString = encodeToString + "\u0000" + num + "\u0000" + Base64.encodeToString(obtain.marshall(), 0);
            return encodeToString;
        } catch (UnsupportedEncodingException e) {
            encodeToString = "QueueSeed encode failed because UTF-8 is not available.";
            C2972b.m11579b(encodeToString);
            return BuildConfig.FLAVOR;
        } finally {
            obtain.recycle();
        }
    }
}
