package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.p146b.bf;
import com.google.android.gms.p146b.bj.C2803a;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.d */
public class C2805d extends C2803a implements C2804a {
    private String f9505a;
    private List<C2802c> f9506b;
    private String f9507c;
    private bf f9508d;
    private String f9509e;
    private double f9510f;
    private String f9511g;
    private String f9512h;
    private C2799a f9513i;
    private Bundle f9514j;
    private Object f9515k;
    private C2810h f9516l;

    public C2805d(String str, List list, String str2, bf bfVar, String str3, double d, String str4, String str5, C2799a c2799a, Bundle bundle) {
        this.f9515k = new Object();
        this.f9505a = str;
        this.f9506b = list;
        this.f9507c = str2;
        this.f9508d = bfVar;
        this.f9509e = str3;
        this.f9510f = d;
        this.f9511g = str4;
        this.f9512h = str5;
        this.f9513i = c2799a;
        this.f9514j = bundle;
    }

    public String m10808a() {
        return this.f9505a;
    }

    public void m10809a(C2810h c2810h) {
        synchronized (this.f9515k) {
            this.f9516l = c2810h;
        }
    }

    public List m10810b() {
        return this.f9506b;
    }

    public String m10811c() {
        return this.f9507c;
    }

    public bf m10812d() {
        return this.f9508d;
    }

    public String m10813e() {
        return this.f9509e;
    }

    public double m10814f() {
        return this.f9510f;
    }

    public String m10815g() {
        return this.f9511g;
    }

    public String m10816h() {
        return this.f9512h;
    }

    public C2687a m10817i() {
        return C2690b.m10262a(this.f9516l);
    }

    public String m10818j() {
        return MessageService.MSG_DB_NOTIFY_CLICK;
    }

    public String m10819k() {
        return BuildConfig.FLAVOR;
    }

    public C2799a m10820l() {
        return this.f9513i;
    }

    public Bundle m10821m() {
        return this.f9514j;
    }

    public void m10822n() {
        this.f9505a = null;
        this.f9506b = null;
        this.f9507c = null;
        this.f9508d = null;
        this.f9509e = null;
        this.f9510f = 0.0d;
        this.f9511g = null;
        this.f9512h = null;
        this.f9513i = null;
        this.f9514j = null;
        this.f9515k = null;
        this.f9516l = null;
    }
}
