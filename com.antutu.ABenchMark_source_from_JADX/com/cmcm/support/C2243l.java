package com.cmcm.support;

import com.cmcm.support.C2239j.C2238a;
import com.cmcm.support.jni.C2240i;
import com.cmcm.support.p116a.C2193f;
import com.cmcm.support.p117b.C2201b.C2200a;
import com.cmcm.support.p117b.C2202c;
import com.cmcm.support.p117b.C2203d;

/* renamed from: com.cmcm.support.l */
public class C2243l {
    private C2203d f7712a;
    private C2202c f7713b;
    private C2200a f7714c;
    private String f7715d;
    private String f7716e;
    private String f7717f;
    private String f7718g;
    private String f7719h;
    private int f7720i;
    private String f7721j;
    private C2238a f7722k;

    public C2243l() {
        this.f7712a = null;
        this.f7713b = null;
        this.f7714c = null;
        this.f7715d = null;
        this.f7716e = null;
        this.f7717f = null;
        this.f7718g = null;
        this.f7719h = null;
        this.f7720i = 0;
        this.f7721j = null;
        this.f7722k = null;
        this.f7712a = new C2203d();
        this.f7713b = new C2202c();
    }

    private byte[] m8464a(int i, int i2, String str, String str2) {
        try {
            return C2240i.b3(i, i2, str, str2);
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] m8465a(int i, String str, String str2, String str3) {
        try {
            return str == "kav_event_active" ? C2240i.b2(i, 81, str2, str3) : str == "kav_event_sactive" ? C2240i.b2(i, 82, str2, str3) : null;
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] m8466a(String str, String str2, String str3, int i, String str4) {
        try {
            return C2240i.m8459a(str, str2, this.f7717f, str3, i, str4);
        } catch (Exception e) {
            return null;
        }
    }

    public C2202c m8467a() {
        if (this.f7713b.m8274b() == null || this.f7713b.m8269a() == null) {
            byte[] a = m8466a(this.f7715d, this.f7716e, this.f7718g, this.f7720i, this.f7721j);
            if (a != null) {
                this.f7713b.m8271a(a);
                this.f7713b.m8272b(this.f7715d);
                this.f7713b.m8270a(this.f7718g);
            }
        }
        return this.f7713b;
    }

    public void m8468a(int i) {
        this.f7720i = i;
    }

    public void m8469a(C2200a c2200a) {
        this.f7714c = c2200a;
    }

    public void m8470a(C2238a c2238a) {
        this.f7722k = c2238a;
    }

    public void m8471a(String str) {
        this.f7715d = str;
    }

    public boolean m8472a(C2193f c2193f) {
        byte[] a = m8466a(this.f7715d, this.f7716e, this.f7718g, this.f7720i, this.f7721j);
        if (a == null || this.f7722k == null) {
            return false;
        }
        byte[] c1 = C2240i.c1(a, (int) this.f7722k.m8453a(), this.f7722k.m8456b(), C2246o.m8503b(this.f7717f, this.f7718g, this.f7720i, this.f7721j));
        if (c1 == null) {
            return false;
        }
        if (c2193f != null) {
            c2193f.m8251a(c1 != null, this.f7715d, this.f7716e);
        }
        this.f7713b.m8271a(a);
        this.f7713b.m8273b(c1);
        this.f7713b.m8272b(this.f7715d);
        this.f7713b.m8270a(this.f7718g);
        return this.f7712a.m8278a(this.f7713b, this.f7719h, this.f7714c);
    }

    public C2202c m8473b() {
        if (this.f7713b.m8274b() == null || this.f7713b.m8269a() == null) {
            byte[] a = m8464a(this.f7720i, Integer.valueOf(this.f7715d).intValue(), this.f7718g, this.f7716e);
            if (a != null) {
                this.f7713b.m8271a(a);
                this.f7713b.m8272b(this.f7715d);
                this.f7713b.m8270a(this.f7718g);
            }
        }
        return this.f7713b;
    }

    public void m8474b(String str) {
        this.f7716e = str;
    }

    public boolean m8475b(C2193f c2193f) {
        boolean z = false;
        byte[] a = m8465a(this.f7720i, this.f7715d, this.f7718g, this.f7716e);
        if (a == null || this.f7722k == null) {
            return false;
        }
        byte[] c1 = C2240i.c1(a, (int) this.f7722k.m8453a(), this.f7722k.m8456b(), C2246o.m8502b(this.f7718g));
        if (c1 == null) {
            return false;
        }
        if (c2193f != null) {
            if (c1 != null) {
                z = true;
            }
            c2193f.m8251a(z, this.f7715d, this.f7716e);
        }
        this.f7713b.m8271a(a);
        this.f7713b.m8273b(c1);
        this.f7713b.m8272b(this.f7715d);
        this.f7713b.m8270a(this.f7718g);
        return this.f7712a.m8278a(this.f7713b, this.f7719h, this.f7714c);
    }

    public void m8476c(String str) {
        this.f7718g = str;
    }

    public boolean m8477c(C2193f c2193f) {
        boolean z = false;
        byte[] a = m8464a(this.f7720i, Integer.valueOf(this.f7715d).intValue(), this.f7718g, this.f7716e);
        if (a == null || this.f7722k == null) {
            return false;
        }
        byte[] c1 = C2240i.c1(a, (int) this.f7722k.m8453a(), this.f7722k.m8456b(), C2246o.m8502b(this.f7718g));
        if (c1 == null) {
            return false;
        }
        if (c2193f != null) {
            if (c1 != null) {
                z = true;
            }
            c2193f.m8251a(z, this.f7715d, this.f7716e);
        }
        this.f7713b.m8271a(a);
        this.f7713b.m8273b(c1);
        this.f7713b.m8272b(this.f7715d);
        this.f7713b.m8270a(this.f7718g);
        return this.f7712a.m8278a(this.f7713b, this.f7719h, this.f7714c);
    }

    public void m8478d(String str) {
        this.f7721j = str;
    }

    public void m8479e(String str) {
        this.f7717f = str;
    }

    public void m8480f(String str) {
        this.f7719h = str;
    }
}
