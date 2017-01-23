package com.google.android.gms.p146b;

import com.xiaomi.pushsdk.BuildConfig;
import java.util.Arrays;

/* renamed from: com.google.android.gms.b.kq */
public interface kq {

    /* renamed from: com.google.android.gms.b.kq.a */
    public static final class C3336a extends kh<C3336a> {
        public String[] f11638b;
        public String[] f11639c;
        public int[] f11640d;
        public long[] f11641e;

        public C3336a() {
            m13713f();
        }

        public void m13711a(kg kgVar) {
            int i = 0;
            if (this.f11638b != null && this.f11638b.length > 0) {
                for (String str : this.f11638b) {
                    if (str != null) {
                        kgVar.m13652a(1, str);
                    }
                }
            }
            if (this.f11639c != null && this.f11639c.length > 0) {
                for (String str2 : this.f11639c) {
                    if (str2 != null) {
                        kgVar.m13652a(2, str2);
                    }
                }
            }
            if (this.f11640d != null && this.f11640d.length > 0) {
                for (int a : this.f11640d) {
                    kgVar.m13649a(3, a);
                }
            }
            if (this.f11641e != null && this.f11641e.length > 0) {
                while (i < this.f11641e.length) {
                    kgVar.m13650a(4, this.f11641e[i]);
                    i++;
                }
            }
            super.m13671a(kgVar);
        }

        protected int m13712b() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int b = super.m13672b();
            if (this.f11638b == null || this.f11638b.length <= 0) {
                i = b;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.f11638b) {
                    if (str != null) {
                        i3++;
                        i2 += kg.m13631b(str);
                    }
                }
                i = (b + i2) + (i3 * 1);
            }
            if (this.f11639c != null && this.f11639c.length > 0) {
                i3 = 0;
                b = 0;
                for (String str2 : this.f11639c) {
                    if (str2 != null) {
                        b++;
                        i3 += kg.m13631b(str2);
                    }
                }
                i = (i + i3) + (b * 1);
            }
            if (this.f11640d != null && this.f11640d.length > 0) {
                i3 = 0;
                for (int b2 : this.f11640d) {
                    i3 += kg.m13625b(b2);
                }
                i = (i + i3) + (this.f11640d.length * 1);
            }
            if (this.f11641e == null || this.f11641e.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.f11641e.length) {
                i2 += kg.m13636c(this.f11641e[i4]);
                i4++;
            }
            return (i + i2) + (this.f11641e.length * 1);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3336a)) {
                return false;
            }
            C3336a c3336a = (C3336a) obj;
            return (kl.m13699a(this.f11638b, c3336a.f11638b) && kl.m13699a(this.f11639c, c3336a.f11639c) && kl.m13697a(this.f11640d, c3336a.f11640d) && kl.m13698a(this.f11641e, c3336a.f11641e)) ? (this.a == null || this.a.m13686b()) ? c3336a.a == null || c3336a.a.m13686b() : this.a.equals(c3336a.a) : false;
        }

        public C3336a m13713f() {
            this.f11638b = kp.f11635f;
            this.f11639c = kp.f11635f;
            this.f11640d = kp.f11630a;
            this.f11641e = kp.f11631b;
            this.a = null;
            this.S = -1;
            return this;
        }

        public int hashCode() {
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + kl.m13694a(this.f11638b)) * 31) + kl.m13694a(this.f11639c)) * 31) + kl.m13692a(this.f11640d)) * 31) + kl.m13693a(this.f11641e)) * 31;
            int hashCode2 = (this.a == null || this.a.m13686b()) ? 0 : this.a.hashCode();
            return hashCode2 + hashCode;
        }
    }

    /* renamed from: com.google.android.gms.b.kq.b */
    public static final class C3337b extends kh<C3337b> {
        public int f11642b;
        public String f11643c;
        public String f11644d;

        public C3337b() {
            m13716f();
        }

        public void m13714a(kg kgVar) {
            if (this.f11642b != 0) {
                kgVar.m13649a(1, this.f11642b);
            }
            if (!this.f11643c.equals(BuildConfig.FLAVOR)) {
                kgVar.m13652a(2, this.f11643c);
            }
            if (!this.f11644d.equals(BuildConfig.FLAVOR)) {
                kgVar.m13652a(3, this.f11644d);
            }
            super.m13671a(kgVar);
        }

        protected int m13715b() {
            int b = super.m13672b();
            if (this.f11642b != 0) {
                b += kg.m13626b(1, this.f11642b);
            }
            if (!this.f11643c.equals(BuildConfig.FLAVOR)) {
                b += kg.m13628b(2, this.f11643c);
            }
            return !this.f11644d.equals(BuildConfig.FLAVOR) ? b + kg.m13628b(3, this.f11644d) : b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3337b)) {
                return false;
            }
            C3337b c3337b = (C3337b) obj;
            if (this.f11642b != c3337b.f11642b) {
                return false;
            }
            if (this.f11643c == null) {
                if (c3337b.f11643c != null) {
                    return false;
                }
            } else if (!this.f11643c.equals(c3337b.f11643c)) {
                return false;
            }
            if (this.f11644d == null) {
                if (c3337b.f11644d != null) {
                    return false;
                }
            } else if (!this.f11644d.equals(c3337b.f11644d)) {
                return false;
            }
            return (this.a == null || this.a.m13686b()) ? c3337b.a == null || c3337b.a.m13686b() : this.a.equals(c3337b.a);
        }

        public C3337b m13716f() {
            this.f11642b = 0;
            this.f11643c = BuildConfig.FLAVOR;
            this.f11644d = BuildConfig.FLAVOR;
            this.a = null;
            this.S = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f11644d == null ? 0 : this.f11644d.hashCode()) + (((this.f11643c == null ? 0 : this.f11643c.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f11642b) * 31)) * 31)) * 31;
            if (!(this.a == null || this.a.m13686b())) {
                i = this.a.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.b.kq.c */
    public static final class C3338c extends kh<C3338c> {
        public byte[] f11645b;
        public byte[][] f11646c;
        public boolean f11647d;

        public C3338c() {
            m13719f();
        }

        public void m13717a(kg kgVar) {
            if (!Arrays.equals(this.f11645b, kp.f11637h)) {
                kgVar.m13654a(1, this.f11645b);
            }
            if (this.f11646c != null && this.f11646c.length > 0) {
                for (byte[] bArr : this.f11646c) {
                    if (bArr != null) {
                        kgVar.m13654a(2, bArr);
                    }
                }
            }
            if (this.f11647d) {
                kgVar.m13653a(3, this.f11647d);
            }
            super.m13671a(kgVar);
        }

        protected int m13718b() {
            int i = 0;
            int b = super.m13672b();
            if (!Arrays.equals(this.f11645b, kp.f11637h)) {
                b += kg.m13630b(1, this.f11645b);
            }
            if (this.f11646c != null && this.f11646c.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.f11646c.length) {
                    byte[] bArr = this.f11646c[i];
                    if (bArr != null) {
                        i3++;
                        i2 += kg.m13638c(bArr);
                    }
                    i++;
                }
                b = (b + i2) + (i3 * 1);
            }
            return this.f11647d ? b + kg.m13629b(3, this.f11647d) : b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3338c)) {
                return false;
            }
            C3338c c3338c = (C3338c) obj;
            return (Arrays.equals(this.f11645b, c3338c.f11645b) && kl.m13700a(this.f11646c, c3338c.f11646c) && this.f11647d == c3338c.f11647d) ? (this.a == null || this.a.m13686b()) ? c3338c.a == null || c3338c.a.m13686b() : this.a.equals(c3338c.a) : false;
        }

        public C3338c m13719f() {
            this.f11645b = kp.f11637h;
            this.f11646c = kp.f11636g;
            this.f11647d = false;
            this.a = null;
            this.S = -1;
            return this;
        }

        public int hashCode() {
            int hashCode = ((this.f11647d ? 1231 : 1237) + ((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f11645b)) * 31) + kl.m13695a(this.f11646c)) * 31)) * 31;
            int hashCode2 = (this.a == null || this.a.m13686b()) ? 0 : this.a.hashCode();
            return hashCode2 + hashCode;
        }
    }

    /* renamed from: com.google.android.gms.b.kq.d */
    public static final class C3339d extends kh<C3339d> {
        public long f11648b;
        public long f11649c;
        public long f11650d;
        public String f11651e;
        public int f11652f;
        public int f11653g;
        public boolean f11654h;
        public C3340e[] f11655i;
        public C3337b f11656j;
        public byte[] f11657k;
        public byte[] f11658l;
        public byte[] f11659m;
        public C3336a f11660n;
        public String f11661o;
        public long f11662p;
        public C3338c f11663q;
        public byte[] f11664r;
        public int f11665s;
        public int[] f11666t;
        public long f11667u;

        public C3339d() {
            m13722f();
        }

        public void m13720a(kg kgVar) {
            int i = 0;
            if (this.f11648b != 0) {
                kgVar.m13650a(1, this.f11648b);
            }
            if (!this.f11651e.equals(BuildConfig.FLAVOR)) {
                kgVar.m13652a(2, this.f11651e);
            }
            if (this.f11655i != null && this.f11655i.length > 0) {
                for (km kmVar : this.f11655i) {
                    if (kmVar != null) {
                        kgVar.m13651a(3, kmVar);
                    }
                }
            }
            if (!Arrays.equals(this.f11657k, kp.f11637h)) {
                kgVar.m13654a(6, this.f11657k);
            }
            if (this.f11660n != null) {
                kgVar.m13651a(7, this.f11660n);
            }
            if (!Arrays.equals(this.f11658l, kp.f11637h)) {
                kgVar.m13654a(8, this.f11658l);
            }
            if (this.f11656j != null) {
                kgVar.m13651a(9, this.f11656j);
            }
            if (this.f11654h) {
                kgVar.m13653a(10, this.f11654h);
            }
            if (this.f11652f != 0) {
                kgVar.m13649a(11, this.f11652f);
            }
            if (this.f11653g != 0) {
                kgVar.m13649a(12, this.f11653g);
            }
            if (!Arrays.equals(this.f11659m, kp.f11637h)) {
                kgVar.m13654a(13, this.f11659m);
            }
            if (!this.f11661o.equals(BuildConfig.FLAVOR)) {
                kgVar.m13652a(14, this.f11661o);
            }
            if (this.f11662p != 180000) {
                kgVar.m13660b(15, this.f11662p);
            }
            if (this.f11663q != null) {
                kgVar.m13651a(16, this.f11663q);
            }
            if (this.f11649c != 0) {
                kgVar.m13650a(17, this.f11649c);
            }
            if (!Arrays.equals(this.f11664r, kp.f11637h)) {
                kgVar.m13654a(18, this.f11664r);
            }
            if (this.f11665s != 0) {
                kgVar.m13649a(19, this.f11665s);
            }
            if (this.f11666t != null && this.f11666t.length > 0) {
                while (i < this.f11666t.length) {
                    kgVar.m13649a(20, this.f11666t[i]);
                    i++;
                }
            }
            if (this.f11650d != 0) {
                kgVar.m13650a(21, this.f11650d);
            }
            if (this.f11667u != 0) {
                kgVar.m13650a(22, this.f11667u);
            }
            super.m13671a(kgVar);
        }

        protected int m13721b() {
            int i;
            int i2 = 0;
            int b = super.m13672b();
            if (this.f11648b != 0) {
                b += kg.m13634c(1, this.f11648b);
            }
            if (!this.f11651e.equals(BuildConfig.FLAVOR)) {
                b += kg.m13628b(2, this.f11651e);
            }
            if (this.f11655i != null && this.f11655i.length > 0) {
                i = b;
                for (km kmVar : this.f11655i) {
                    if (kmVar != null) {
                        i += kg.m13635c(3, kmVar);
                    }
                }
                b = i;
            }
            if (!Arrays.equals(this.f11657k, kp.f11637h)) {
                b += kg.m13630b(6, this.f11657k);
            }
            if (this.f11660n != null) {
                b += kg.m13635c(7, this.f11660n);
            }
            if (!Arrays.equals(this.f11658l, kp.f11637h)) {
                b += kg.m13630b(8, this.f11658l);
            }
            if (this.f11656j != null) {
                b += kg.m13635c(9, this.f11656j);
            }
            if (this.f11654h) {
                b += kg.m13629b(10, this.f11654h);
            }
            if (this.f11652f != 0) {
                b += kg.m13626b(11, this.f11652f);
            }
            if (this.f11653g != 0) {
                b += kg.m13626b(12, this.f11653g);
            }
            if (!Arrays.equals(this.f11659m, kp.f11637h)) {
                b += kg.m13630b(13, this.f11659m);
            }
            if (!this.f11661o.equals(BuildConfig.FLAVOR)) {
                b += kg.m13628b(14, this.f11661o);
            }
            if (this.f11662p != 180000) {
                b += kg.m13640d(15, this.f11662p);
            }
            if (this.f11663q != null) {
                b += kg.m13635c(16, this.f11663q);
            }
            if (this.f11649c != 0) {
                b += kg.m13634c(17, this.f11649c);
            }
            if (!Arrays.equals(this.f11664r, kp.f11637h)) {
                b += kg.m13630b(18, this.f11664r);
            }
            if (this.f11665s != 0) {
                b += kg.m13626b(19, this.f11665s);
            }
            if (this.f11666t != null && this.f11666t.length > 0) {
                i = 0;
                while (i2 < this.f11666t.length) {
                    i += kg.m13625b(this.f11666t[i2]);
                    i2++;
                }
                b = (b + i) + (this.f11666t.length * 2);
            }
            if (this.f11650d != 0) {
                b += kg.m13634c(21, this.f11650d);
            }
            return this.f11667u != 0 ? b + kg.m13634c(22, this.f11667u) : b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3339d)) {
                return false;
            }
            C3339d c3339d = (C3339d) obj;
            if (this.f11648b != c3339d.f11648b || this.f11649c != c3339d.f11649c || this.f11650d != c3339d.f11650d) {
                return false;
            }
            if (this.f11651e == null) {
                if (c3339d.f11651e != null) {
                    return false;
                }
            } else if (!this.f11651e.equals(c3339d.f11651e)) {
                return false;
            }
            if (this.f11652f != c3339d.f11652f || this.f11653g != c3339d.f11653g || this.f11654h != c3339d.f11654h || !kl.m13699a(this.f11655i, c3339d.f11655i)) {
                return false;
            }
            if (this.f11656j == null) {
                if (c3339d.f11656j != null) {
                    return false;
                }
            } else if (!this.f11656j.equals(c3339d.f11656j)) {
                return false;
            }
            if (!Arrays.equals(this.f11657k, c3339d.f11657k) || !Arrays.equals(this.f11658l, c3339d.f11658l) || !Arrays.equals(this.f11659m, c3339d.f11659m)) {
                return false;
            }
            if (this.f11660n == null) {
                if (c3339d.f11660n != null) {
                    return false;
                }
            } else if (!this.f11660n.equals(c3339d.f11660n)) {
                return false;
            }
            if (this.f11661o == null) {
                if (c3339d.f11661o != null) {
                    return false;
                }
            } else if (!this.f11661o.equals(c3339d.f11661o)) {
                return false;
            }
            if (this.f11662p != c3339d.f11662p) {
                return false;
            }
            if (this.f11663q == null) {
                if (c3339d.f11663q != null) {
                    return false;
                }
            } else if (!this.f11663q.equals(c3339d.f11663q)) {
                return false;
            }
            return (Arrays.equals(this.f11664r, c3339d.f11664r) && this.f11665s == c3339d.f11665s && kl.m13697a(this.f11666t, c3339d.f11666t) && this.f11667u == c3339d.f11667u) ? (this.a == null || this.a.m13686b()) ? c3339d.a == null || c3339d.a.m13686b() : this.a.equals(c3339d.a) : false;
        }

        public C3339d m13722f() {
            this.f11648b = 0;
            this.f11649c = 0;
            this.f11650d = 0;
            this.f11651e = BuildConfig.FLAVOR;
            this.f11652f = 0;
            this.f11653g = 0;
            this.f11654h = false;
            this.f11655i = C3340e.m13723f();
            this.f11656j = null;
            this.f11657k = kp.f11637h;
            this.f11658l = kp.f11637h;
            this.f11659m = kp.f11637h;
            this.f11660n = null;
            this.f11661o = BuildConfig.FLAVOR;
            this.f11662p = 180000;
            this.f11663q = null;
            this.f11664r = kp.f11637h;
            this.f11665s = 0;
            this.f11666t = kp.f11630a;
            this.f11667u = 0;
            this.a = null;
            this.S = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((((((this.f11663q == null ? 0 : this.f11663q.hashCode()) + (((((this.f11661o == null ? 0 : this.f11661o.hashCode()) + (((this.f11660n == null ? 0 : this.f11660n.hashCode()) + (((((((((this.f11656j == null ? 0 : this.f11656j.hashCode()) + (((((this.f11654h ? 1231 : 1237) + (((((((this.f11651e == null ? 0 : this.f11651e.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.f11648b ^ (this.f11648b >>> 32)))) * 31) + ((int) (this.f11649c ^ (this.f11649c >>> 32)))) * 31) + ((int) (this.f11650d ^ (this.f11650d >>> 32)))) * 31)) * 31) + this.f11652f) * 31) + this.f11653g) * 31)) * 31) + kl.m13694a(this.f11655i)) * 31)) * 31) + Arrays.hashCode(this.f11657k)) * 31) + Arrays.hashCode(this.f11658l)) * 31) + Arrays.hashCode(this.f11659m)) * 31)) * 31)) * 31) + ((int) (this.f11662p ^ (this.f11662p >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.f11664r)) * 31) + this.f11665s) * 31) + kl.m13692a(this.f11666t)) * 31) + ((int) (this.f11667u ^ (this.f11667u >>> 32)))) * 31;
            if (!(this.a == null || this.a.m13686b())) {
                i = this.a.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.b.kq.e */
    public static final class C3340e extends kh<C3340e> {
        private static volatile C3340e[] f11668d;
        public String f11669b;
        public String f11670c;

        public C3340e() {
            m13726g();
        }

        public static C3340e[] m13723f() {
            if (f11668d == null) {
                synchronized (kl.f11627a) {
                    if (f11668d == null) {
                        f11668d = new C3340e[0];
                    }
                }
            }
            return f11668d;
        }

        public void m13724a(kg kgVar) {
            if (!this.f11669b.equals(BuildConfig.FLAVOR)) {
                kgVar.m13652a(1, this.f11669b);
            }
            if (!this.f11670c.equals(BuildConfig.FLAVOR)) {
                kgVar.m13652a(2, this.f11670c);
            }
            super.m13671a(kgVar);
        }

        protected int m13725b() {
            int b = super.m13672b();
            if (!this.f11669b.equals(BuildConfig.FLAVOR)) {
                b += kg.m13628b(1, this.f11669b);
            }
            return !this.f11670c.equals(BuildConfig.FLAVOR) ? b + kg.m13628b(2, this.f11670c) : b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3340e)) {
                return false;
            }
            C3340e c3340e = (C3340e) obj;
            if (this.f11669b == null) {
                if (c3340e.f11669b != null) {
                    return false;
                }
            } else if (!this.f11669b.equals(c3340e.f11669b)) {
                return false;
            }
            if (this.f11670c == null) {
                if (c3340e.f11670c != null) {
                    return false;
                }
            } else if (!this.f11670c.equals(c3340e.f11670c)) {
                return false;
            }
            return (this.a == null || this.a.m13686b()) ? c3340e.a == null || c3340e.a.m13686b() : this.a.equals(c3340e.a);
        }

        public C3340e m13726g() {
            this.f11669b = BuildConfig.FLAVOR;
            this.f11670c = BuildConfig.FLAVOR;
            this.a = null;
            this.S = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f11670c == null ? 0 : this.f11670c.hashCode()) + (((this.f11669b == null ? 0 : this.f11669b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.a == null || this.a.m13686b())) {
                i = this.a.hashCode();
            }
            return hashCode + i;
        }
    }
}
