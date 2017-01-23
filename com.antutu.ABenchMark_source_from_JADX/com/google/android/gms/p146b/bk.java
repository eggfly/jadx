package com.google.android.gms.p146b;

import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p124b.C2701a.C2700a;
import com.google.android.gms.ads.p124b.C2706d;
import com.google.android.gms.p146b.bf.C2801a;
import com.google.android.gms.p151a.C2687a;
import java.util.ArrayList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.bk */
public class bk extends C2706d {
    private final bj f10367a;
    private final List<C2700a> f10368b;
    private final bg f10369c;

    public bk(bj bjVar) {
        bg bgVar;
        this.f10368b = new ArrayList();
        this.f10367a = bjVar;
        try {
            List<Object> b = this.f10367a.m10793b();
            if (b != null) {
                for (Object a : b) {
                    bf a2 = m11905a(a);
                    if (a2 != null) {
                        this.f10368b.add(new bg(a2));
                    }
                }
            }
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get image.", e);
        }
        try {
            bf d = this.f10367a.m10795d();
            if (d != null) {
                bgVar = new bg(d);
                this.f10369c = bgVar;
            }
        } catch (Throwable e2) {
            C2972b.m11580b("Failed to get icon.", e2);
        }
        bgVar = null;
        this.f10369c = bgVar;
    }

    bf m11905a(Object obj) {
        return obj instanceof IBinder ? C2801a.m10788a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object m11906a() {
        return m11915j();
    }

    public CharSequence m11907b() {
        try {
            return this.f10367a.m10792a();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get headline.", e);
            return null;
        }
    }

    public List<C2700a> m11908c() {
        return this.f10368b;
    }

    public CharSequence m11909d() {
        try {
            return this.f10367a.m10794c();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get body.", e);
            return null;
        }
    }

    public C2700a m11910e() {
        return this.f10369c;
    }

    public CharSequence m11911f() {
        try {
            return this.f10367a.m10796e();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get call to action.", e);
            return null;
        }
    }

    public Double m11912g() {
        Double d = null;
        try {
            double f = this.f10367a.m10797f();
            if (f != -1.0d) {
                d = Double.valueOf(f);
            }
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence m11913h() {
        try {
            return this.f10367a.m10798g();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get store", e);
            return null;
        }
    }

    public CharSequence m11914i() {
        try {
            return this.f10367a.m10799h();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get price.", e);
            return null;
        }
    }

    protected C2687a m11915j() {
        try {
            return this.f10367a.m10800i();
        } catch (Throwable e) {
            C2972b.m11580b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
