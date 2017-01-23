package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.ad.C2729a;
import com.google.android.gms.ads.internal.reward.client.C2956c;
import com.google.android.gms.ads.internal.util.client.C2971a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.bd;
import com.google.android.gms.p146b.fc;
import com.google.android.gms.p146b.fg;
import com.google.android.gms.p151a.C2687a;

/* renamed from: com.google.android.gms.ads.internal.client.g */
public class C2764g extends C2729a {
    private C2772z f9429a;

    /* renamed from: com.google.android.gms.ads.internal.client.g.1 */
    class C27631 implements Runnable {
        final /* synthetic */ C2764g f9428a;

        C27631(C2764g c2764g) {
            this.f9428a = c2764g;
        }

        public void run() {
            if (this.f9428a.f9429a != null) {
                try {
                    this.f9428a.f9429a.m10702a(1);
                } catch (Throwable e) {
                    C2972b.m11584d("Could not notify onAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void m10659a(AdSizeParcel adSizeParcel) {
    }

    public void m10660a(af afVar) {
    }

    public void m10661a(ag agVar) {
    }

    public void m10662a(C2769y c2769y) {
    }

    public void m10663a(C2772z c2772z) {
        this.f9429a = c2772z;
    }

    public void m10664a(C2956c c2956c) {
    }

    public void m10665a(bd bdVar) {
    }

    public void m10666a(fc fcVar) {
    }

    public void m10667a(fg fgVar, String str) {
    }

    public void m10668a(String str) {
    }

    public void m10669a(boolean z) {
    }

    public boolean m10670a(AdRequestParcel adRequestParcel) {
        C2972b.m11579b("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        C2971a.f10085a.post(new C27631(this));
        return false;
    }

    public void m10671b() {
    }

    public boolean m10672c() {
        return false;
    }

    public void m10673d() {
    }

    public void m10674e() {
    }

    public void m10675f() {
    }

    public C2687a f_() {
        return null;
    }

    public void m10676h() {
    }

    public AdSizeParcel m10677i() {
        return null;
    }

    public String m10678j() {
        return null;
    }

    public void j_() {
    }

    public boolean m10679k() {
        return false;
    }
}
