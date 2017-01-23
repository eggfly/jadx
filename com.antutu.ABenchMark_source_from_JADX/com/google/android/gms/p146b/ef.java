package com.google.android.gms.p146b;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.formats.C2802c;
import com.google.android.gms.ads.mediation.C2644k;
import com.google.android.gms.ads.p124b.C2701a.C2700a;
import com.google.android.gms.p146b.ea.C3161a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import java.util.ArrayList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.ef */
public class ef extends C3161a {
    private final C2644k f10741a;

    public ef(C2644k c2644k) {
        this.f10741a = c2644k;
    }

    public String m12536a() {
        return this.f10741a.m10216e();
    }

    public void m12537a(C2687a c2687a) {
        this.f10741a.m10188b((View) C2690b.m10263a(c2687a));
    }

    public List m12538b() {
        List<C2700a> f = this.f10741a.m10217f();
        if (f == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (C2700a c2700a : f) {
            arrayList.add(new C2802c(c2700a.m10274a(), c2700a.m10275b(), c2700a.m10276c()));
        }
        return arrayList;
    }

    public void m12539b(C2687a c2687a) {
        this.f10741a.m10185a((View) C2690b.m10263a(c2687a));
    }

    public String m12540c() {
        return this.f10741a.m10218g();
    }

    public bf m12541d() {
        C2700a h = this.f10741a.m10219h();
        return h != null ? new C2802c(h.m10274a(), h.m10275b(), h.m10276c()) : null;
    }

    public String m12542e() {
        return this.f10741a.m10220i();
    }

    public String m12543f() {
        return this.f10741a.m10221j();
    }

    public void m12544g() {
        this.f10741a.m10192d();
    }

    public boolean m12545h() {
        return this.f10741a.m10187a();
    }

    public boolean m12546i() {
        return this.f10741a.m10190b();
    }

    public Bundle m12547j() {
        return this.f10741a.m10191c();
    }
}
