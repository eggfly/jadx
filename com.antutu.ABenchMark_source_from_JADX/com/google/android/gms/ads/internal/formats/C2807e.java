package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.p146b.bf;
import com.google.android.gms.p146b.bl.C2806a;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.e */
public class C2807e extends C2806a implements C2804a {
    private String f9517a;
    private List<C2802c> f9518b;
    private String f9519c;
    private bf f9520d;
    private String f9521e;
    private String f9522f;
    private C2799a f9523g;
    private Bundle f9524h;
    private Object f9525i;
    private C2810h f9526j;

    public C2807e(String str, List list, String str2, bf bfVar, String str3, String str4, C2799a c2799a, Bundle bundle) {
        this.f9525i = new Object();
        this.f9517a = str;
        this.f9518b = list;
        this.f9519c = str2;
        this.f9520d = bfVar;
        this.f9521e = str3;
        this.f9522f = str4;
        this.f9523g = c2799a;
        this.f9524h = bundle;
    }

    public String m10833a() {
        return this.f9517a;
    }

    public void m10834a(C2810h c2810h) {
        synchronized (this.f9525i) {
            this.f9526j = c2810h;
        }
    }

    public List m10835b() {
        return this.f9518b;
    }

    public String m10836c() {
        return this.f9519c;
    }

    public bf m10837d() {
        return this.f9520d;
    }

    public String m10838e() {
        return this.f9521e;
    }

    public String m10839f() {
        return this.f9522f;
    }

    public C2687a m10840g() {
        return C2690b.m10262a(this.f9526j);
    }

    public Bundle m10841h() {
        return this.f9524h;
    }

    public void m10842i() {
        this.f9517a = null;
        this.f9518b = null;
        this.f9519c = null;
        this.f9520d = null;
        this.f9521e = null;
        this.f9522f = null;
        this.f9523g = null;
        this.f9524h = null;
        this.f9525i = null;
        this.f9526j = null;
    }

    public String m10843j() {
        return MessageService.MSG_DB_NOTIFY_REACHED;
    }

    public String m10844k() {
        return BuildConfig.FLAVOR;
    }

    public C2799a m10845l() {
        return this.f9523g;
    }
}
