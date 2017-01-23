package com.google.android.gms.p146b;

import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p124b.C2701a.C2700a;
import com.google.android.gms.ads.p124b.C2708f;
import com.google.android.gms.p146b.bf.C2801a;
import com.google.android.gms.p151a.C2687a;
import java.util.ArrayList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.bm */
public class bm extends C2708f {
    private final bl f10371a;
    private final List<C2700a> f10372b;
    private final bg f10373c;

    public bm(bl blVar) {
        bg bgVar;
        this.f10372b = new ArrayList();
        this.f10371a = blVar;
        try {
            List<Object> b = this.f10371a.m10824b();
            if (b != null) {
                for (Object a : b) {
                    bf a2 = m11925a(a);
                    if (a2 != null) {
                        this.f10372b.add(new bg(a2));
                    }
                }
            }
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get image.", e);
        }
        try {
            bf d = this.f10371a.m10826d();
            if (d != null) {
                bgVar = new bg(d);
                this.f10373c = bgVar;
            }
        } catch (Throwable e2) {
            C2972b.m11580b("Failed to get icon.", e2);
        }
        bgVar = null;
        this.f10373c = bgVar;
    }

    bf m11925a(Object obj) {
        return obj instanceof IBinder ? C2801a.m10788a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object m11926a() {
        return m11933h();
    }

    public CharSequence m11927b() {
        try {
            return this.f10371a.m10823a();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get headline.", e);
            return null;
        }
    }

    public List<C2700a> m11928c() {
        return this.f10372b;
    }

    public CharSequence m11929d() {
        try {
            return this.f10371a.m10825c();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get body.", e);
            return null;
        }
    }

    public C2700a m11930e() {
        return this.f10373c;
    }

    public CharSequence m11931f() {
        try {
            return this.f10371a.m10827e();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get call to action.", e);
            return null;
        }
    }

    public CharSequence m11932g() {
        try {
            return this.f10371a.m10828f();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get attribution.", e);
            return null;
        }
    }

    protected C2687a m11933h() {
        try {
            return this.f10371a.m10829g();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
