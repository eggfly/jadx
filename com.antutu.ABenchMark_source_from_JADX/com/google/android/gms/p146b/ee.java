package com.google.android.gms.p146b;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.formats.C2802c;
import com.google.android.gms.ads.mediation.C2642j;
import com.google.android.gms.ads.p124b.C2701a.C2700a;
import com.google.android.gms.p146b.dz.C3157a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import java.util.ArrayList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.ee */
public class ee extends C3157a {
    private final C2642j f10740a;

    public ee(C2642j c2642j) {
        this.f10740a = c2642j;
    }

    public String m12522a() {
        return this.f10740a.m10200e();
    }

    public void m12523a(C2687a c2687a) {
        this.f10740a.m10188b((View) C2690b.m10263a(c2687a));
    }

    public List m12524b() {
        List<C2700a> f = this.f10740a.m10202f();
        if (f == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (C2700a c2700a : f) {
            arrayList.add(new C2802c(c2700a.m10274a(), c2700a.m10275b(), c2700a.m10276c()));
        }
        return arrayList;
    }

    public void m12525b(C2687a c2687a) {
        this.f10740a.m10185a((View) C2690b.m10263a(c2687a));
    }

    public String m12526c() {
        return this.f10740a.m10203g();
    }

    public bf m12527d() {
        C2700a h = this.f10740a.m10204h();
        return h != null ? new C2802c(h.m10274a(), h.m10275b(), h.m10276c()) : null;
    }

    public String m12528e() {
        return this.f10740a.m10205i();
    }

    public double m12529f() {
        return this.f10740a.m10206j();
    }

    public String m12530g() {
        return this.f10740a.m10207k();
    }

    public String m12531h() {
        return this.f10740a.m10208l();
    }

    public void m12532i() {
        this.f10740a.m10192d();
    }

    public boolean m12533j() {
        return this.f10740a.m10187a();
    }

    public boolean m12534k() {
        return this.f10740a.m10190b();
    }

    public Bundle m12535l() {
        return this.f10740a.m10191c();
    }
}
