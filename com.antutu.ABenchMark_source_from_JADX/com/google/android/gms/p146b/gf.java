package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.dd.C3135d;
import java.util.Map;
import java.util.concurrent.Future;

@gb
/* renamed from: com.google.android.gms.b.gf */
public final class gf {
    ii f11057a;
    C3135d f11058b;
    public final cb f11059c;
    public final cb f11060d;
    private final Object f11061e;
    private String f11062f;
    private String f11063g;
    private hw<gi> f11064h;

    /* renamed from: com.google.android.gms.b.gf.1 */
    class C32271 implements cb {
        final /* synthetic */ gf f11055a;

        C32271(gf gfVar) {
            this.f11055a = gfVar;
        }

        public void m12837a(ii iiVar, Map<String, String> map) {
            synchronized (this.f11055a.f11061e) {
                if (this.f11055a.f11064h.isDone()) {
                } else if (this.f11055a.f11062f.equals(map.get("request_id"))) {
                    Object giVar = new gi(1, map);
                    C2972b.m11583d("Invalid " + giVar.m12885e() + " request error: " + giVar.m12882b());
                    this.f11055a.f11064h.m12217b(giVar);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.b.gf.2 */
    class C32282 implements cb {
        final /* synthetic */ gf f11056a;

        C32282(gf gfVar) {
            this.f11056a = gfVar;
        }

        public void m12838a(ii iiVar, Map<String, String> map) {
            synchronized (this.f11056a.f11061e) {
                if (this.f11056a.f11064h.isDone()) {
                    return;
                }
                Object giVar = new gi(-2, map);
                if (this.f11056a.f11062f.equals(giVar.m12887g())) {
                    String d = giVar.m12884d();
                    if (d == null) {
                        C2972b.m11583d("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (d.contains("%40mediation_adapters%40")) {
                        String replaceAll = d.replaceAll("%40mediation_adapters%40", hd.m12978a(iiVar.getContext(), (String) map.get("check_adapters"), this.f11056a.f11063g));
                        giVar.m12881a(replaceAll);
                        hf.m12982e("Ad request URL modified to " + replaceAll);
                    }
                    this.f11056a.f11064h.m12217b(giVar);
                    return;
                }
                C2972b.m11583d(giVar.m12887g() + " ==== " + this.f11056a.f11062f);
            }
        }
    }

    public gf(String str, String str2) {
        this.f11061e = new Object();
        this.f11064h = new hw();
        this.f11059c = new C32271(this);
        this.f11060d = new C32282(this);
        this.f11063g = str2;
        this.f11062f = str;
    }

    public C3135d m12843a() {
        return this.f11058b;
    }

    public void m12844a(C3135d c3135d) {
        this.f11058b = c3135d;
    }

    public void m12845a(ii iiVar) {
        this.f11057a = iiVar;
    }

    public Future<gi> m12846b() {
        return this.f11064h;
    }

    public void m12847c() {
        if (this.f11057a != null) {
            this.f11057a.destroy();
            this.f11057a = null;
        }
    }
}
