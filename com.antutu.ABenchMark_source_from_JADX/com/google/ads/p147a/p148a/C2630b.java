package com.google.ads.p147a.p148a;

import com.google.android.gms.p146b.kg;
import com.google.android.gms.p146b.kl;
import com.google.android.gms.p146b.km;
import com.taobao.accs.common.Constants;

/* renamed from: com.google.ads.a.a.b */
public interface C2630b {

    /* renamed from: com.google.ads.a.a.b.a */
    public static final class C2627a extends km {
        public Long f9113A;
        public String f9114B;
        public Long f9115C;
        public Long f9116D;
        public Long f9117E;
        public C2628b f9118F;
        public Long f9119G;
        public Long f9120H;
        public Long f9121I;
        public Long f9122J;
        public C2626a[] f9123K;
        public Long f9124L;
        public String f9125M;
        public Integer f9126N;
        public Boolean f9127O;
        public String f9128P;
        public Long f9129Q;
        public C2629c f9130R;
        public String f9131a;
        public String f9132b;
        public Long f9133c;
        public Long f9134d;
        public Long f9135e;
        public Long f9136f;
        public Long f9137g;
        public Long f9138h;
        public Long f9139i;
        public Long f9140j;
        public Long f9141k;
        public Long f9142l;
        public String f9143m;
        public Long f9144n;
        public Long f9145o;
        public Long f9146p;
        public Long f9147q;
        public Long f9148r;
        public Long f9149s;
        public Long f9150t;
        public Long f9151u;
        public Long f9152v;
        public String f9153w;
        public String f9154x;
        public Long f9155y;
        public Long f9156z;

        /* renamed from: com.google.ads.a.a.b.a.a */
        public static final class C2626a extends km {
            private static volatile C2626a[] f9110c;
            public Long f9111a;
            public Long f9112b;

            public C2626a() {
                m10127c();
            }

            public static C2626a[] m10124a() {
                if (f9110c == null) {
                    synchronized (kl.f11627a) {
                        if (f9110c == null) {
                            f9110c = new C2626a[0];
                        }
                    }
                }
                return f9110c;
            }

            public void m10125a(kg kgVar) {
                if (this.f9111a != null) {
                    kgVar.m13650a(1, this.f9111a.longValue());
                }
                if (this.f9112b != null) {
                    kgVar.m13650a(2, this.f9112b.longValue());
                }
                super.m10117a(kgVar);
            }

            protected int m10126b() {
                int b = super.m10118b();
                if (this.f9111a != null) {
                    b += kg.m13634c(1, this.f9111a.longValue());
                }
                return this.f9112b != null ? b + kg.m13634c(2, this.f9112b.longValue()) : b;
            }

            public C2626a m10127c() {
                this.f9111a = null;
                this.f9112b = null;
                this.S = -1;
                return this;
            }
        }

        public C2627a() {
            m10128a();
        }

        public C2627a m10128a() {
            this.f9131a = null;
            this.f9132b = null;
            this.f9133c = null;
            this.f9134d = null;
            this.f9135e = null;
            this.f9136f = null;
            this.f9137g = null;
            this.f9138h = null;
            this.f9139i = null;
            this.f9140j = null;
            this.f9141k = null;
            this.f9142l = null;
            this.f9143m = null;
            this.f9144n = null;
            this.f9145o = null;
            this.f9146p = null;
            this.f9147q = null;
            this.f9148r = null;
            this.f9149s = null;
            this.f9150t = null;
            this.f9151u = null;
            this.f9152v = null;
            this.f9153w = null;
            this.f9154x = null;
            this.f9155y = null;
            this.f9156z = null;
            this.f9113A = null;
            this.f9114B = null;
            this.f9115C = null;
            this.f9116D = null;
            this.f9117E = null;
            this.f9118F = null;
            this.f9119G = null;
            this.f9120H = null;
            this.f9121I = null;
            this.f9122J = null;
            this.f9123K = C2626a.m10124a();
            this.f9124L = null;
            this.f9125M = null;
            this.f9126N = null;
            this.f9127O = null;
            this.f9128P = null;
            this.f9129Q = null;
            this.f9130R = null;
            this.S = -1;
            return this;
        }

        public void m10129a(kg kgVar) {
            if (this.f9131a != null) {
                kgVar.m13652a(1, this.f9131a);
            }
            if (this.f9132b != null) {
                kgVar.m13652a(2, this.f9132b);
            }
            if (this.f9133c != null) {
                kgVar.m13650a(3, this.f9133c.longValue());
            }
            if (this.f9134d != null) {
                kgVar.m13650a(4, this.f9134d.longValue());
            }
            if (this.f9135e != null) {
                kgVar.m13650a(5, this.f9135e.longValue());
            }
            if (this.f9136f != null) {
                kgVar.m13650a(6, this.f9136f.longValue());
            }
            if (this.f9137g != null) {
                kgVar.m13650a(7, this.f9137g.longValue());
            }
            if (this.f9138h != null) {
                kgVar.m13650a(8, this.f9138h.longValue());
            }
            if (this.f9139i != null) {
                kgVar.m13650a(9, this.f9139i.longValue());
            }
            if (this.f9140j != null) {
                kgVar.m13650a(10, this.f9140j.longValue());
            }
            if (this.f9141k != null) {
                kgVar.m13650a(11, this.f9141k.longValue());
            }
            if (this.f9142l != null) {
                kgVar.m13650a(12, this.f9142l.longValue());
            }
            if (this.f9143m != null) {
                kgVar.m13652a(13, this.f9143m);
            }
            if (this.f9144n != null) {
                kgVar.m13650a(14, this.f9144n.longValue());
            }
            if (this.f9145o != null) {
                kgVar.m13650a(15, this.f9145o.longValue());
            }
            if (this.f9146p != null) {
                kgVar.m13650a(16, this.f9146p.longValue());
            }
            if (this.f9147q != null) {
                kgVar.m13650a(17, this.f9147q.longValue());
            }
            if (this.f9148r != null) {
                kgVar.m13650a(18, this.f9148r.longValue());
            }
            if (this.f9149s != null) {
                kgVar.m13650a(19, this.f9149s.longValue());
            }
            if (this.f9150t != null) {
                kgVar.m13650a(20, this.f9150t.longValue());
            }
            if (this.f9124L != null) {
                kgVar.m13650a(21, this.f9124L.longValue());
            }
            if (this.f9151u != null) {
                kgVar.m13650a(22, this.f9151u.longValue());
            }
            if (this.f9152v != null) {
                kgVar.m13650a(23, this.f9152v.longValue());
            }
            if (this.f9125M != null) {
                kgVar.m13652a(24, this.f9125M);
            }
            if (this.f9129Q != null) {
                kgVar.m13650a(25, this.f9129Q.longValue());
            }
            if (this.f9126N != null) {
                kgVar.m13649a(26, this.f9126N.intValue());
            }
            if (this.f9153w != null) {
                kgVar.m13652a(27, this.f9153w);
            }
            if (this.f9127O != null) {
                kgVar.m13653a(28, this.f9127O.booleanValue());
            }
            if (this.f9154x != null) {
                kgVar.m13652a(29, this.f9154x);
            }
            if (this.f9128P != null) {
                kgVar.m13652a(30, this.f9128P);
            }
            if (this.f9155y != null) {
                kgVar.m13650a(31, this.f9155y.longValue());
            }
            if (this.f9156z != null) {
                kgVar.m13650a(32, this.f9156z.longValue());
            }
            if (this.f9113A != null) {
                kgVar.m13650a(33, this.f9113A.longValue());
            }
            if (this.f9114B != null) {
                kgVar.m13652a(34, this.f9114B);
            }
            if (this.f9115C != null) {
                kgVar.m13650a(35, this.f9115C.longValue());
            }
            if (this.f9116D != null) {
                kgVar.m13650a(36, this.f9116D.longValue());
            }
            if (this.f9117E != null) {
                kgVar.m13650a(37, this.f9117E.longValue());
            }
            if (this.f9118F != null) {
                kgVar.m13651a(38, this.f9118F);
            }
            if (this.f9119G != null) {
                kgVar.m13650a(39, this.f9119G.longValue());
            }
            if (this.f9120H != null) {
                kgVar.m13650a(40, this.f9120H.longValue());
            }
            if (this.f9121I != null) {
                kgVar.m13650a(41, this.f9121I.longValue());
            }
            if (this.f9122J != null) {
                kgVar.m13650a(42, this.f9122J.longValue());
            }
            if (this.f9123K != null && this.f9123K.length > 0) {
                for (km kmVar : this.f9123K) {
                    if (kmVar != null) {
                        kgVar.m13651a(43, kmVar);
                    }
                }
            }
            if (this.f9130R != null) {
                kgVar.m13651a((int) Constants.COMMAND_PING, this.f9130R);
            }
            super.m10117a(kgVar);
        }

        protected int m10130b() {
            int b = super.m10118b();
            if (this.f9131a != null) {
                b += kg.m13628b(1, this.f9131a);
            }
            if (this.f9132b != null) {
                b += kg.m13628b(2, this.f9132b);
            }
            if (this.f9133c != null) {
                b += kg.m13634c(3, this.f9133c.longValue());
            }
            if (this.f9134d != null) {
                b += kg.m13634c(4, this.f9134d.longValue());
            }
            if (this.f9135e != null) {
                b += kg.m13634c(5, this.f9135e.longValue());
            }
            if (this.f9136f != null) {
                b += kg.m13634c(6, this.f9136f.longValue());
            }
            if (this.f9137g != null) {
                b += kg.m13634c(7, this.f9137g.longValue());
            }
            if (this.f9138h != null) {
                b += kg.m13634c(8, this.f9138h.longValue());
            }
            if (this.f9139i != null) {
                b += kg.m13634c(9, this.f9139i.longValue());
            }
            if (this.f9140j != null) {
                b += kg.m13634c(10, this.f9140j.longValue());
            }
            if (this.f9141k != null) {
                b += kg.m13634c(11, this.f9141k.longValue());
            }
            if (this.f9142l != null) {
                b += kg.m13634c(12, this.f9142l.longValue());
            }
            if (this.f9143m != null) {
                b += kg.m13628b(13, this.f9143m);
            }
            if (this.f9144n != null) {
                b += kg.m13634c(14, this.f9144n.longValue());
            }
            if (this.f9145o != null) {
                b += kg.m13634c(15, this.f9145o.longValue());
            }
            if (this.f9146p != null) {
                b += kg.m13634c(16, this.f9146p.longValue());
            }
            if (this.f9147q != null) {
                b += kg.m13634c(17, this.f9147q.longValue());
            }
            if (this.f9148r != null) {
                b += kg.m13634c(18, this.f9148r.longValue());
            }
            if (this.f9149s != null) {
                b += kg.m13634c(19, this.f9149s.longValue());
            }
            if (this.f9150t != null) {
                b += kg.m13634c(20, this.f9150t.longValue());
            }
            if (this.f9124L != null) {
                b += kg.m13634c(21, this.f9124L.longValue());
            }
            if (this.f9151u != null) {
                b += kg.m13634c(22, this.f9151u.longValue());
            }
            if (this.f9152v != null) {
                b += kg.m13634c(23, this.f9152v.longValue());
            }
            if (this.f9125M != null) {
                b += kg.m13628b(24, this.f9125M);
            }
            if (this.f9129Q != null) {
                b += kg.m13634c(25, this.f9129Q.longValue());
            }
            if (this.f9126N != null) {
                b += kg.m13626b(26, this.f9126N.intValue());
            }
            if (this.f9153w != null) {
                b += kg.m13628b(27, this.f9153w);
            }
            if (this.f9127O != null) {
                b += kg.m13629b(28, this.f9127O.booleanValue());
            }
            if (this.f9154x != null) {
                b += kg.m13628b(29, this.f9154x);
            }
            if (this.f9128P != null) {
                b += kg.m13628b(30, this.f9128P);
            }
            if (this.f9155y != null) {
                b += kg.m13634c(31, this.f9155y.longValue());
            }
            if (this.f9156z != null) {
                b += kg.m13634c(32, this.f9156z.longValue());
            }
            if (this.f9113A != null) {
                b += kg.m13634c(33, this.f9113A.longValue());
            }
            if (this.f9114B != null) {
                b += kg.m13628b(34, this.f9114B);
            }
            if (this.f9115C != null) {
                b += kg.m13634c(35, this.f9115C.longValue());
            }
            if (this.f9116D != null) {
                b += kg.m13634c(36, this.f9116D.longValue());
            }
            if (this.f9117E != null) {
                b += kg.m13634c(37, this.f9117E.longValue());
            }
            if (this.f9118F != null) {
                b += kg.m13635c(38, this.f9118F);
            }
            if (this.f9119G != null) {
                b += kg.m13634c(39, this.f9119G.longValue());
            }
            if (this.f9120H != null) {
                b += kg.m13634c(40, this.f9120H.longValue());
            }
            if (this.f9121I != null) {
                b += kg.m13634c(41, this.f9121I.longValue());
            }
            if (this.f9122J != null) {
                b += kg.m13634c(42, this.f9122J.longValue());
            }
            if (this.f9123K != null && this.f9123K.length > 0) {
                int i = b;
                for (km kmVar : this.f9123K) {
                    if (kmVar != null) {
                        i += kg.m13635c(43, kmVar);
                    }
                }
                b = i;
            }
            return this.f9130R != null ? b + kg.m13635c((int) Constants.COMMAND_PING, this.f9130R) : b;
        }
    }

    /* renamed from: com.google.ads.a.a.b.b */
    public static final class C2628b extends km {
        public Long f9157a;
        public Integer f9158b;
        public Boolean f9159c;
        public Integer f9160d;

        public void m10131a(kg kgVar) {
            if (this.f9157a != null) {
                kgVar.m13650a(1, this.f9157a.longValue());
            }
            if (this.f9158b != null) {
                kgVar.m13649a(2, this.f9158b.intValue());
            }
            if (this.f9159c != null) {
                kgVar.m13653a(3, this.f9159c.booleanValue());
            }
            if (this.f9160d != null) {
                kgVar.m13649a(4, this.f9160d.intValue());
            }
            super.m10117a(kgVar);
        }

        protected int m10132b() {
            int b = super.m10118b();
            if (this.f9157a != null) {
                b += kg.m13634c(1, this.f9157a.longValue());
            }
            if (this.f9158b != null) {
                b += kg.m13626b(2, this.f9158b.intValue());
            }
            if (this.f9159c != null) {
                b += kg.m13629b(3, this.f9159c.booleanValue());
            }
            return this.f9160d != null ? b + kg.m13626b(4, this.f9160d.intValue()) : b;
        }
    }

    /* renamed from: com.google.ads.a.a.b.c */
    public static final class C2629c extends km {
        public Long f9161a;
        public String f9162b;
        public byte[] f9163c;

        public void m10133a(kg kgVar) {
            if (this.f9161a != null) {
                kgVar.m13650a(1, this.f9161a.longValue());
            }
            if (this.f9162b != null) {
                kgVar.m13652a(3, this.f9162b);
            }
            if (this.f9163c != null) {
                kgVar.m13654a(4, this.f9163c);
            }
            super.m10117a(kgVar);
        }

        protected int m10134b() {
            int b = super.m10118b();
            if (this.f9161a != null) {
                b += kg.m13634c(1, this.f9161a.longValue());
            }
            if (this.f9162b != null) {
                b += kg.m13628b(3, this.f9162b);
            }
            return this.f9163c != null ? b + kg.m13630b(4, this.f9163c) : b;
        }
    }
}
