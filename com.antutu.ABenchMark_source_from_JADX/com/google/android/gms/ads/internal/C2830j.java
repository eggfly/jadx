package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2772z;
import com.google.android.gms.ads.internal.client.aa.C2739a;
import com.google.android.gms.ads.internal.client.ag;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.bo;
import com.google.android.gms.p146b.bp;
import com.google.android.gms.p146b.bq;
import com.google.android.gms.p146b.br;
import com.google.android.gms.p146b.du;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.ads.internal.j */
public class C2830j extends C2739a {
    private final Context f9579a;
    private final C2772z f9580b;
    private final du f9581c;
    private final bo f9582d;
    private final bp f9583e;
    private final SimpleArrayMap<String, br> f9584f;
    private final SimpleArrayMap<String, bq> f9585g;
    private final NativeAdOptionsParcel f9586h;
    private final List<String> f9587i;
    private final ag f9588j;
    private final String f9589k;
    private final VersionInfoParcel f9590l;
    private WeakReference<C2900q> f9591m;
    private final C2795e f9592n;
    private final Object f9593o;

    /* renamed from: com.google.android.gms.ads.internal.j.1 */
    class C28291 implements Runnable {
        final /* synthetic */ AdRequestParcel f9577a;
        final /* synthetic */ C2830j f9578b;

        C28291(C2830j c2830j, AdRequestParcel adRequestParcel) {
            this.f9578b = c2830j;
            this.f9577a = adRequestParcel;
        }

        public void run() {
            synchronized (this.f9578b.f9593o) {
                C2900q c = this.f9578b.m10960c();
                this.f9578b.f9591m = new WeakReference(c);
                c.m11275a(this.f9578b.f9582d);
                c.m11276a(this.f9578b.f9583e);
                c.m11271a(this.f9578b.f9584f);
                c.m10430a(this.f9578b.f9580b);
                c.m11282b(this.f9578b.f9585g);
                c.m11279a(this.f9578b.m10950d());
                c.m11272a(this.f9578b.f9586h);
                c.m10428a(this.f9578b.f9588j);
                c.m10442a(this.f9577a);
            }
        }
    }

    C2830j(Context context, String str, du duVar, VersionInfoParcel versionInfoParcel, C2772z c2772z, bo boVar, bp bpVar, SimpleArrayMap<String, br> simpleArrayMap, SimpleArrayMap<String, bq> simpleArrayMap2, NativeAdOptionsParcel nativeAdOptionsParcel, ag agVar, C2795e c2795e) {
        this.f9593o = new Object();
        this.f9579a = context;
        this.f9589k = str;
        this.f9581c = duVar;
        this.f9590l = versionInfoParcel;
        this.f9580b = c2772z;
        this.f9583e = bpVar;
        this.f9582d = boVar;
        this.f9584f = simpleArrayMap;
        this.f9585g = simpleArrayMap2;
        this.f9586h = nativeAdOptionsParcel;
        this.f9587i = m10950d();
        this.f9588j = agVar;
        this.f9592n = c2795e;
    }

    private List<String> m10950d() {
        List<String> arrayList = new ArrayList();
        if (this.f9583e != null) {
            arrayList.add(MessageService.MSG_DB_NOTIFY_REACHED);
        }
        if (this.f9582d != null) {
            arrayList.add(MessageService.MSG_DB_NOTIFY_CLICK);
        }
        if (this.f9584f.size() > 0) {
            arrayList.add(MessageService.MSG_DB_NOTIFY_DISMISS);
        }
        return arrayList;
    }

    public void m10956a(AdRequestParcel adRequestParcel) {
        m10957a(new C28291(this, adRequestParcel));
    }

    protected void m10957a(Runnable runnable) {
        hj.f11297a.post(runnable);
    }

    public boolean m10958a() {
        synchronized (this.f9593o) {
            if (this.f9591m != null) {
                C2900q c2900q = (C2900q) this.f9591m.get();
                boolean k = c2900q != null ? c2900q.m10457k() : false;
                return k;
            }
            return false;
        }
    }

    public String m10959b() {
        synchronized (this.f9593o) {
            if (this.f9591m != null) {
                C2900q c2900q = (C2900q) this.f9591m.get();
                String j = c2900q != null ? c2900q.m10490j() : null;
                return j;
            }
            return null;
        }
    }

    protected C2900q m10960c() {
        return new C2900q(this.f9579a, this.f9592n, AdSizeParcel.m10500a(this.f9579a), this.f9589k, this.f9581c, this.f9590l);
    }
}
