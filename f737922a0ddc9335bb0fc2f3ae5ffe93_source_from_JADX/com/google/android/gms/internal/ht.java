package com.google.android.gms.internal;

import com.aide.uidesigner.ProxyTextView;

public interface ht {

    public static final class a extends t {
        private static volatile a[] v5;
        public f DW;
        public f FH;
        public Boolean Hw;
        public Integer j6;

        public a() {
            DW();
        }

        public static a[] j6() {
            if (v5 == null) {
                synchronized (r.FH) {
                    if (v5 == null) {
                        v5 = new a[0];
                    }
                }
            }
            return v5;
        }

        public a DW() {
            this.j6 = null;
            this.DW = null;
            this.FH = null;
            this.Hw = null;
            this.J8 = -1;
            return this;
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int FH = super.FH();
            if (this.j6 != null) {
                FH += m.DW(1, this.j6.intValue());
            }
            if (this.DW != null) {
                FH += m.FH(2, this.DW);
            }
            if (this.FH != null) {
                FH += m.FH(3, this.FH);
            }
            return this.Hw != null ? FH + m.DW(4, this.Hw.booleanValue()) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.j6 == null) {
                if (aVar.j6 != null) {
                    return false;
                }
            } else if (!this.j6.equals(aVar.j6)) {
                return false;
            }
            if (this.DW == null) {
                if (aVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(aVar.DW)) {
                return false;
            }
            if (this.FH == null) {
                if (aVar.FH != null) {
                    return false;
                }
            } else if (!this.FH.equals(aVar.FH)) {
                return false;
            }
            return this.Hw == null ? aVar.Hw == null : this.Hw.equals(aVar.Hw);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.FH == null ? 0 : this.FH.hashCode()) + (((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.Hw != null) {
                i = this.Hw.hashCode();
            }
            return hashCode + i;
        }

        public a j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        this.j6 = Integer.valueOf(lVar.VH());
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        if (this.DW == null) {
                            this.DW = new f();
                        }
                        lVar.j6(this.DW);
                        continue;
                    case 26:
                        if (this.FH == null) {
                            this.FH = new f();
                        }
                        lVar.j6(this.FH);
                        continue;
                    case 32:
                        this.Hw = Boolean.valueOf(lVar.gn());
                        continue;
                    default:
                        if (!w.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            if (this.j6 != null) {
                mVar.j6(1, this.j6.intValue());
            }
            if (this.DW != null) {
                mVar.j6(2, this.DW);
            }
            if (this.FH != null) {
                mVar.j6(3, this.FH);
            }
            if (this.Hw != null) {
                mVar.j6(4, this.Hw.booleanValue());
            }
            super.j6(mVar);
        }
    }

    public static final class b extends t {
        private static volatile b[] Zo;
        public String DW;
        public Long FH;
        public Long Hw;
        public c[] j6;
        public Integer v5;

        public b() {
            DW();
        }

        public static b[] j6() {
            if (Zo == null) {
                synchronized (r.FH) {
                    if (Zo == null) {
                        Zo = new b[0];
                    }
                }
            }
            return Zo;
        }

        public b DW() {
            this.j6 = c.j6();
            this.DW = null;
            this.FH = null;
            this.Hw = null;
            this.v5 = null;
            this.J8 = -1;
            return this;
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int FH = super.FH();
            if (this.j6 != null && this.j6.length > 0) {
                for (t tVar : this.j6) {
                    if (tVar != null) {
                        FH += m.FH(1, tVar);
                    }
                }
            }
            if (this.DW != null) {
                FH += m.DW(2, this.DW);
            }
            if (this.FH != null) {
                FH += m.Hw(3, this.FH.longValue());
            }
            if (this.Hw != null) {
                FH += m.Hw(4, this.Hw.longValue());
            }
            return this.v5 != null ? FH + m.DW(5, this.v5.intValue()) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!r.j6(this.j6, bVar.j6)) {
                return false;
            }
            if (this.DW == null) {
                if (bVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(bVar.DW)) {
                return false;
            }
            if (this.FH == null) {
                if (bVar.FH != null) {
                    return false;
                }
            } else if (!this.FH.equals(bVar.FH)) {
                return false;
            }
            if (this.Hw == null) {
                if (bVar.Hw != null) {
                    return false;
                }
            } else if (!this.Hw.equals(bVar.Hw)) {
                return false;
            }
            return this.v5 == null ? bVar.v5 == null : this.v5.equals(bVar.v5);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.Hw == null ? 0 : this.Hw.hashCode()) + (((this.FH == null ? 0 : this.FH.hashCode()) + (((this.DW == null ? 0 : this.DW.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + r.j6(this.j6)) * 31)) * 31)) * 31)) * 31;
            if (this.v5 != null) {
                i = this.v5.hashCode();
            }
            return hashCode + i;
        }

        public b j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 10:
                        int DW = w.DW(lVar, 10);
                        j6 = this.j6 == null ? 0 : this.j6.length;
                        Object obj = new c[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.j6, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new c();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new c();
                        lVar.j6(obj[j6]);
                        this.j6 = obj;
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 24:
                        this.FH = Long.valueOf(lVar.Zo());
                        continue;
                    case 32:
                        this.Hw = Long.valueOf(lVar.Zo());
                        continue;
                    case 40:
                        this.v5 = Integer.valueOf(lVar.VH());
                        continue;
                    default:
                        if (!w.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            if (this.j6 != null && this.j6.length > 0) {
                for (t tVar : this.j6) {
                    if (tVar != null) {
                        mVar.j6(1, tVar);
                    }
                }
            }
            if (this.DW != null) {
                mVar.j6(2, this.DW);
            }
            if (this.FH != null) {
                mVar.DW(3, this.FH.longValue());
            }
            if (this.Hw != null) {
                mVar.DW(4, this.Hw.longValue());
            }
            if (this.v5 != null) {
                mVar.j6(5, this.v5.intValue());
            }
            super.j6(mVar);
        }
    }

    public static final class c extends t {
        private static volatile c[] Zo;
        public String DW;
        public Long FH;
        public Float Hw;
        public String j6;
        public Double v5;

        public c() {
            DW();
        }

        public static c[] j6() {
            if (Zo == null) {
                synchronized (r.FH) {
                    if (Zo == null) {
                        Zo = new c[0];
                    }
                }
            }
            return Zo;
        }

        public c DW() {
            this.j6 = null;
            this.DW = null;
            this.FH = null;
            this.Hw = null;
            this.v5 = null;
            this.J8 = -1;
            return this;
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int FH = super.FH();
            if (this.j6 != null) {
                FH += m.DW(1, this.j6);
            }
            if (this.DW != null) {
                FH += m.DW(2, this.DW);
            }
            if (this.FH != null) {
                FH += m.Hw(3, this.FH.longValue());
            }
            if (this.Hw != null) {
                FH += m.DW(4, this.Hw.floatValue());
            }
            return this.v5 != null ? FH + m.DW(5, this.v5.doubleValue()) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.j6 == null) {
                if (cVar.j6 != null) {
                    return false;
                }
            } else if (!this.j6.equals(cVar.j6)) {
                return false;
            }
            if (this.DW == null) {
                if (cVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(cVar.DW)) {
                return false;
            }
            if (this.FH == null) {
                if (cVar.FH != null) {
                    return false;
                }
            } else if (!this.FH.equals(cVar.FH)) {
                return false;
            }
            if (this.Hw == null) {
                if (cVar.Hw != null) {
                    return false;
                }
            } else if (!this.Hw.equals(cVar.Hw)) {
                return false;
            }
            return this.v5 == null ? cVar.v5 == null : this.v5.equals(cVar.v5);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.Hw == null ? 0 : this.Hw.hashCode()) + (((this.FH == null ? 0 : this.FH.hashCode()) + (((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.v5 != null) {
                i = this.v5.hashCode();
            }
            return hashCode + i;
        }

        public c j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 10:
                        this.j6 = lVar.u7();
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 24:
                        this.FH = Long.valueOf(lVar.Zo());
                        continue;
                    case 37:
                        this.Hw = Float.valueOf(lVar.Hw());
                        continue;
                    case 41:
                        this.v5 = Double.valueOf(lVar.FH());
                        continue;
                    default:
                        if (!w.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            if (this.j6 != null) {
                mVar.j6(1, this.j6);
            }
            if (this.DW != null) {
                mVar.j6(2, this.DW);
            }
            if (this.FH != null) {
                mVar.DW(3, this.FH.longValue());
            }
            if (this.Hw != null) {
                mVar.j6(4, this.Hw.floatValue());
            }
            if (this.v5 != null) {
                mVar.j6(5, this.v5.doubleValue());
            }
            super.j6(mVar);
        }
    }

    public static final class d extends t {
        public e[] j6;

        public d() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int FH = super.FH();
            if (this.j6 != null && this.j6.length > 0) {
                for (t tVar : this.j6) {
                    if (tVar != null) {
                        FH += m.FH(1, tVar);
                    }
                }
            }
            return FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            return r.j6(this.j6, ((d) obj).j6);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + r.j6(this.j6);
        }

        public d j6() {
            this.j6 = e.j6();
            this.J8 = -1;
            return this;
        }

        public d j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 10:
                        int DW = w.DW(lVar, 10);
                        j6 = this.j6 == null ? 0 : this.j6.length;
                        Object obj = new e[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.j6, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new e();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new e();
                        lVar.j6(obj[j6]);
                        this.j6 = obj;
                        continue;
                    default:
                        if (!w.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            if (this.j6 != null && this.j6.length > 0) {
                for (t tVar : this.j6) {
                    if (tVar != null) {
                        mVar.j6(1, tVar);
                    }
                }
            }
            super.j6(mVar);
        }
    }

    public static final class e extends t {
        private static volatile e[] KD;
        public a[] BT;
        public b[] DW;
        public String EQ;
        public g[] FH;
        public Long Hw;
        public Integer J0;
        public String Mr;
        public Integer P8;
        public String QX;
        public String SI;
        public Boolean U2;
        public Long VH;
        public String Ws;
        public String XL;
        public Long Zo;
        public String a8;
        public Long aM;
        public Integer ei;
        public String er;
        public Boolean gW;
        public Long gn;
        public Long j3;
        public Integer j6;
        public Long lg;
        public Integer nw;
        public Integer rN;
        public String tp;
        public String u7;
        public Long v5;
        public String vy;
        public String we;
        public String yS;

        public e() {
            DW();
        }

        public static e[] j6() {
            if (KD == null) {
                synchronized (r.FH) {
                    if (KD == null) {
                        KD = new e[0];
                    }
                }
            }
            return KD;
        }

        public e DW() {
            this.j6 = null;
            this.DW = b.j6();
            this.FH = g.j6();
            this.Hw = null;
            this.v5 = null;
            this.Zo = null;
            this.VH = null;
            this.gn = null;
            this.u7 = null;
            this.tp = null;
            this.EQ = null;
            this.we = null;
            this.J0 = null;
            this.Ws = null;
            this.QX = null;
            this.XL = null;
            this.aM = null;
            this.j3 = null;
            this.Mr = null;
            this.U2 = null;
            this.a8 = null;
            this.lg = null;
            this.rN = null;
            this.er = null;
            this.yS = null;
            this.gW = null;
            this.BT = a.j6();
            this.vy = null;
            this.P8 = null;
            this.ei = null;
            this.nw = null;
            this.SI = null;
            this.J8 = -1;
            return this;
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i;
            int i2 = 0;
            int FH = super.FH();
            if (this.j6 != null) {
                FH += m.DW(1, this.j6.intValue());
            }
            if (this.DW != null && this.DW.length > 0) {
                i = FH;
                for (t tVar : this.DW) {
                    if (tVar != null) {
                        i += m.FH(2, tVar);
                    }
                }
                FH = i;
            }
            if (this.FH != null && this.FH.length > 0) {
                i = FH;
                for (t tVar2 : this.FH) {
                    if (tVar2 != null) {
                        i += m.FH(3, tVar2);
                    }
                }
                FH = i;
            }
            if (this.Hw != null) {
                FH += m.Hw(4, this.Hw.longValue());
            }
            if (this.v5 != null) {
                FH += m.Hw(5, this.v5.longValue());
            }
            if (this.Zo != null) {
                FH += m.Hw(6, this.Zo.longValue());
            }
            if (this.gn != null) {
                FH += m.Hw(7, this.gn.longValue());
            }
            if (this.u7 != null) {
                FH += m.DW(8, this.u7);
            }
            if (this.tp != null) {
                FH += m.DW(9, this.tp);
            }
            if (this.EQ != null) {
                FH += m.DW(10, this.EQ);
            }
            if (this.we != null) {
                FH += m.DW(11, this.we);
            }
            if (this.J0 != null) {
                FH += m.DW(12, this.J0.intValue());
            }
            if (this.Ws != null) {
                FH += m.DW(13, this.Ws);
            }
            if (this.QX != null) {
                FH += m.DW(14, this.QX);
            }
            if (this.XL != null) {
                FH += m.DW(16, this.XL);
            }
            if (this.aM != null) {
                FH += m.Hw(17, this.aM.longValue());
            }
            if (this.j3 != null) {
                FH += m.Hw(18, this.j3.longValue());
            }
            if (this.Mr != null) {
                FH += m.DW(19, this.Mr);
            }
            if (this.U2 != null) {
                FH += m.DW(20, this.U2.booleanValue());
            }
            if (this.a8 != null) {
                FH += m.DW(21, this.a8);
            }
            if (this.lg != null) {
                FH += m.Hw(22, this.lg.longValue());
            }
            if (this.rN != null) {
                FH += m.DW(23, this.rN.intValue());
            }
            if (this.er != null) {
                FH += m.DW(24, this.er);
            }
            if (this.yS != null) {
                FH += m.DW(25, this.yS);
            }
            if (this.VH != null) {
                FH += m.Hw(26, this.VH.longValue());
            }
            if (this.gW != null) {
                FH += m.DW(28, this.gW.booleanValue());
            }
            if (this.BT != null && this.BT.length > 0) {
                while (i2 < this.BT.length) {
                    t tVar3 = this.BT[i2];
                    if (tVar3 != null) {
                        FH += m.FH(29, tVar3);
                    }
                    i2++;
                }
            }
            if (this.vy != null) {
                FH += m.DW(30, this.vy);
            }
            if (this.P8 != null) {
                FH += m.DW(31, this.P8.intValue());
            }
            if (this.ei != null) {
                FH += m.DW(32, this.ei.intValue());
            }
            if (this.nw != null) {
                FH += m.DW(33, this.nw.intValue());
            }
            return this.SI != null ? FH + m.DW(34, this.SI) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.j6 == null) {
                if (eVar.j6 != null) {
                    return false;
                }
            } else if (!this.j6.equals(eVar.j6)) {
                return false;
            }
            if (!r.j6(this.DW, eVar.DW)) {
                return false;
            }
            if (!r.j6(this.FH, eVar.FH)) {
                return false;
            }
            if (this.Hw == null) {
                if (eVar.Hw != null) {
                    return false;
                }
            } else if (!this.Hw.equals(eVar.Hw)) {
                return false;
            }
            if (this.v5 == null) {
                if (eVar.v5 != null) {
                    return false;
                }
            } else if (!this.v5.equals(eVar.v5)) {
                return false;
            }
            if (this.Zo == null) {
                if (eVar.Zo != null) {
                    return false;
                }
            } else if (!this.Zo.equals(eVar.Zo)) {
                return false;
            }
            if (this.VH == null) {
                if (eVar.VH != null) {
                    return false;
                }
            } else if (!this.VH.equals(eVar.VH)) {
                return false;
            }
            if (this.gn == null) {
                if (eVar.gn != null) {
                    return false;
                }
            } else if (!this.gn.equals(eVar.gn)) {
                return false;
            }
            if (this.u7 == null) {
                if (eVar.u7 != null) {
                    return false;
                }
            } else if (!this.u7.equals(eVar.u7)) {
                return false;
            }
            if (this.tp == null) {
                if (eVar.tp != null) {
                    return false;
                }
            } else if (!this.tp.equals(eVar.tp)) {
                return false;
            }
            if (this.EQ == null) {
                if (eVar.EQ != null) {
                    return false;
                }
            } else if (!this.EQ.equals(eVar.EQ)) {
                return false;
            }
            if (this.we == null) {
                if (eVar.we != null) {
                    return false;
                }
            } else if (!this.we.equals(eVar.we)) {
                return false;
            }
            if (this.J0 == null) {
                if (eVar.J0 != null) {
                    return false;
                }
            } else if (!this.J0.equals(eVar.J0)) {
                return false;
            }
            if (this.Ws == null) {
                if (eVar.Ws != null) {
                    return false;
                }
            } else if (!this.Ws.equals(eVar.Ws)) {
                return false;
            }
            if (this.QX == null) {
                if (eVar.QX != null) {
                    return false;
                }
            } else if (!this.QX.equals(eVar.QX)) {
                return false;
            }
            if (this.XL == null) {
                if (eVar.XL != null) {
                    return false;
                }
            } else if (!this.XL.equals(eVar.XL)) {
                return false;
            }
            if (this.aM == null) {
                if (eVar.aM != null) {
                    return false;
                }
            } else if (!this.aM.equals(eVar.aM)) {
                return false;
            }
            if (this.j3 == null) {
                if (eVar.j3 != null) {
                    return false;
                }
            } else if (!this.j3.equals(eVar.j3)) {
                return false;
            }
            if (this.Mr == null) {
                if (eVar.Mr != null) {
                    return false;
                }
            } else if (!this.Mr.equals(eVar.Mr)) {
                return false;
            }
            if (this.U2 == null) {
                if (eVar.U2 != null) {
                    return false;
                }
            } else if (!this.U2.equals(eVar.U2)) {
                return false;
            }
            if (this.a8 == null) {
                if (eVar.a8 != null) {
                    return false;
                }
            } else if (!this.a8.equals(eVar.a8)) {
                return false;
            }
            if (this.lg == null) {
                if (eVar.lg != null) {
                    return false;
                }
            } else if (!this.lg.equals(eVar.lg)) {
                return false;
            }
            if (this.rN == null) {
                if (eVar.rN != null) {
                    return false;
                }
            } else if (!this.rN.equals(eVar.rN)) {
                return false;
            }
            if (this.er == null) {
                if (eVar.er != null) {
                    return false;
                }
            } else if (!this.er.equals(eVar.er)) {
                return false;
            }
            if (this.yS == null) {
                if (eVar.yS != null) {
                    return false;
                }
            } else if (!this.yS.equals(eVar.yS)) {
                return false;
            }
            if (this.gW == null) {
                if (eVar.gW != null) {
                    return false;
                }
            } else if (!this.gW.equals(eVar.gW)) {
                return false;
            }
            if (!r.j6(this.BT, eVar.BT)) {
                return false;
            }
            if (this.vy == null) {
                if (eVar.vy != null) {
                    return false;
                }
            } else if (!this.vy.equals(eVar.vy)) {
                return false;
            }
            if (this.P8 == null) {
                if (eVar.P8 != null) {
                    return false;
                }
            } else if (!this.P8.equals(eVar.P8)) {
                return false;
            }
            if (this.ei == null) {
                if (eVar.ei != null) {
                    return false;
                }
            } else if (!this.ei.equals(eVar.ei)) {
                return false;
            }
            if (this.nw == null) {
                if (eVar.nw != null) {
                    return false;
                }
            } else if (!this.nw.equals(eVar.nw)) {
                return false;
            }
            return this.SI == null ? eVar.SI == null : this.SI.equals(eVar.SI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.nw == null ? 0 : this.nw.hashCode()) + (((this.ei == null ? 0 : this.ei.hashCode()) + (((this.P8 == null ? 0 : this.P8.hashCode()) + (((this.vy == null ? 0 : this.vy.hashCode()) + (((((this.gW == null ? 0 : this.gW.hashCode()) + (((this.yS == null ? 0 : this.yS.hashCode()) + (((this.er == null ? 0 : this.er.hashCode()) + (((this.rN == null ? 0 : this.rN.hashCode()) + (((this.lg == null ? 0 : this.lg.hashCode()) + (((this.a8 == null ? 0 : this.a8.hashCode()) + (((this.U2 == null ? 0 : this.U2.hashCode()) + (((this.Mr == null ? 0 : this.Mr.hashCode()) + (((this.j3 == null ? 0 : this.j3.hashCode()) + (((this.aM == null ? 0 : this.aM.hashCode()) + (((this.XL == null ? 0 : this.XL.hashCode()) + (((this.QX == null ? 0 : this.QX.hashCode()) + (((this.Ws == null ? 0 : this.Ws.hashCode()) + (((this.J0 == null ? 0 : this.J0.hashCode()) + (((this.we == null ? 0 : this.we.hashCode()) + (((this.EQ == null ? 0 : this.EQ.hashCode()) + (((this.tp == null ? 0 : this.tp.hashCode()) + (((this.u7 == null ? 0 : this.u7.hashCode()) + (((this.gn == null ? 0 : this.gn.hashCode()) + (((this.VH == null ? 0 : this.VH.hashCode()) + (((this.Zo == null ? 0 : this.Zo.hashCode()) + (((this.v5 == null ? 0 : this.v5.hashCode()) + (((this.Hw == null ? 0 : this.Hw.hashCode()) + (((((((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + r.j6(this.DW)) * 31) + r.j6(this.FH)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + r.j6(this.BT)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.SI != null) {
                i = this.SI.hashCode();
            }
            return hashCode + i;
        }

        public e j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                int DW;
                Object obj;
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        this.j6 = Integer.valueOf(lVar.VH());
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        DW = w.DW(lVar, 18);
                        j6 = this.DW == null ? 0 : this.DW.length;
                        obj = new b[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.DW, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new b();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new b();
                        lVar.j6(obj[j6]);
                        this.DW = obj;
                        continue;
                    case 26:
                        DW = w.DW(lVar, 26);
                        j6 = this.FH == null ? 0 : this.FH.length;
                        obj = new g[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.FH, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new g();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new g();
                        lVar.j6(obj[j6]);
                        this.FH = obj;
                        continue;
                    case 32:
                        this.Hw = Long.valueOf(lVar.Zo());
                        continue;
                    case 40:
                        this.v5 = Long.valueOf(lVar.Zo());
                        continue;
                    case 48:
                        this.Zo = Long.valueOf(lVar.Zo());
                        continue;
                    case 56:
                        this.gn = Long.valueOf(lVar.Zo());
                        continue;
                    case 66:
                        this.u7 = lVar.u7();
                        continue;
                    case 74:
                        this.tp = lVar.u7();
                        continue;
                    case 82:
                        this.EQ = lVar.u7();
                        continue;
                    case 90:
                        this.we = lVar.u7();
                        continue;
                    case 96:
                        this.J0 = Integer.valueOf(lVar.VH());
                        continue;
                    case 106:
                        this.Ws = lVar.u7();
                        continue;
                    case 114:
                        this.QX = lVar.u7();
                        continue;
                    case 130:
                        this.XL = lVar.u7();
                        continue;
                    case 136:
                        this.aM = Long.valueOf(lVar.Zo());
                        continue;
                    case 144:
                        this.j3 = Long.valueOf(lVar.Zo());
                        continue;
                    case 154:
                        this.Mr = lVar.u7();
                        continue;
                    case 160:
                        this.U2 = Boolean.valueOf(lVar.gn());
                        continue;
                    case 170:
                        this.a8 = lVar.u7();
                        continue;
                    case 176:
                        this.lg = Long.valueOf(lVar.Zo());
                        continue;
                    case 184:
                        this.rN = Integer.valueOf(lVar.VH());
                        continue;
                    case 194:
                        this.er = lVar.u7();
                        continue;
                    case 202:
                        this.yS = lVar.u7();
                        continue;
                    case 208:
                        this.VH = Long.valueOf(lVar.Zo());
                        continue;
                    case 224:
                        this.gW = Boolean.valueOf(lVar.gn());
                        continue;
                    case 234:
                        DW = w.DW(lVar, 234);
                        j6 = this.BT == null ? 0 : this.BT.length;
                        obj = new a[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.BT, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new a();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new a();
                        lVar.j6(obj[j6]);
                        this.BT = obj;
                        continue;
                    case 242:
                        this.vy = lVar.u7();
                        continue;
                    case 248:
                        this.P8 = Integer.valueOf(lVar.VH());
                        continue;
                    case 256:
                        this.ei = Integer.valueOf(lVar.VH());
                        continue;
                    case 264:
                        this.nw = Integer.valueOf(lVar.VH());
                        continue;
                    case 274:
                        this.SI = lVar.u7();
                        continue;
                    default:
                        if (!w.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            int i = 0;
            if (this.j6 != null) {
                mVar.j6(1, this.j6.intValue());
            }
            if (this.DW != null && this.DW.length > 0) {
                for (t tVar : this.DW) {
                    if (tVar != null) {
                        mVar.j6(2, tVar);
                    }
                }
            }
            if (this.FH != null && this.FH.length > 0) {
                for (t tVar2 : this.FH) {
                    if (tVar2 != null) {
                        mVar.j6(3, tVar2);
                    }
                }
            }
            if (this.Hw != null) {
                mVar.DW(4, this.Hw.longValue());
            }
            if (this.v5 != null) {
                mVar.DW(5, this.v5.longValue());
            }
            if (this.Zo != null) {
                mVar.DW(6, this.Zo.longValue());
            }
            if (this.gn != null) {
                mVar.DW(7, this.gn.longValue());
            }
            if (this.u7 != null) {
                mVar.j6(8, this.u7);
            }
            if (this.tp != null) {
                mVar.j6(9, this.tp);
            }
            if (this.EQ != null) {
                mVar.j6(10, this.EQ);
            }
            if (this.we != null) {
                mVar.j6(11, this.we);
            }
            if (this.J0 != null) {
                mVar.j6(12, this.J0.intValue());
            }
            if (this.Ws != null) {
                mVar.j6(13, this.Ws);
            }
            if (this.QX != null) {
                mVar.j6(14, this.QX);
            }
            if (this.XL != null) {
                mVar.j6(16, this.XL);
            }
            if (this.aM != null) {
                mVar.DW(17, this.aM.longValue());
            }
            if (this.j3 != null) {
                mVar.DW(18, this.j3.longValue());
            }
            if (this.Mr != null) {
                mVar.j6(19, this.Mr);
            }
            if (this.U2 != null) {
                mVar.j6(20, this.U2.booleanValue());
            }
            if (this.a8 != null) {
                mVar.j6(21, this.a8);
            }
            if (this.lg != null) {
                mVar.DW(22, this.lg.longValue());
            }
            if (this.rN != null) {
                mVar.j6(23, this.rN.intValue());
            }
            if (this.er != null) {
                mVar.j6(24, this.er);
            }
            if (this.yS != null) {
                mVar.j6(25, this.yS);
            }
            if (this.VH != null) {
                mVar.DW(26, this.VH.longValue());
            }
            if (this.gW != null) {
                mVar.j6(28, this.gW.booleanValue());
            }
            if (this.BT != null && this.BT.length > 0) {
                while (i < this.BT.length) {
                    t tVar3 = this.BT[i];
                    if (tVar3 != null) {
                        mVar.j6(29, tVar3);
                    }
                    i++;
                }
            }
            if (this.vy != null) {
                mVar.j6(30, this.vy);
            }
            if (this.P8 != null) {
                mVar.j6(31, this.P8.intValue());
            }
            if (this.ei != null) {
                mVar.j6(32, this.ei.intValue());
            }
            if (this.nw != null) {
                mVar.j6(33, this.nw.intValue());
            }
            if (this.SI != null) {
                mVar.j6(34, this.SI);
            }
            super.j6(mVar);
        }
    }

    public static final class f extends t {
        public long[] DW;
        public long[] j6;

        public f() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i;
            int i2;
            int i3 = 0;
            int FH = super.FH();
            if (this.j6 == null || this.j6.length <= 0) {
                i = FH;
            } else {
                i2 = 0;
                for (long Hw : this.j6) {
                    i2 += m.Hw(Hw);
                }
                i = (FH + i2) + (this.j6.length * 1);
            }
            if (this.DW == null || this.DW.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.DW.length) {
                i2 += m.Hw(this.DW[i3]);
                i3++;
            }
            return (i + i2) + (this.DW.length * 1);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return !r.j6(this.j6, fVar.j6) ? false : r.j6(this.DW, fVar.DW);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + r.j6(this.j6)) * 31) + r.j6(this.DW);
        }

        public f j6() {
            this.j6 = w.DW;
            this.DW = w.DW;
            this.J8 = -1;
            return this;
        }

        public f j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                int DW;
                Object obj;
                int FH;
                Object obj2;
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        DW = w.DW(lVar, 8);
                        j6 = this.j6 == null ? 0 : this.j6.length;
                        obj = new long[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.j6, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.v5();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.v5();
                        this.j6 = obj;
                        continue;
                    case 10:
                        FH = lVar.FH(lVar.we());
                        DW = lVar.aM();
                        j6 = 0;
                        while (lVar.QX() > 0) {
                            lVar.v5();
                            j6++;
                        }
                        lVar.v5(DW);
                        DW = this.j6 == null ? 0 : this.j6.length;
                        obj2 = new long[(j6 + DW)];
                        if (DW != 0) {
                            System.arraycopy(this.j6, 0, obj2, 0, DW);
                        }
                        while (DW < obj2.length) {
                            obj2[DW] = lVar.v5();
                            DW++;
                        }
                        this.j6 = obj2;
                        lVar.Hw(FH);
                        continue;
                    case 16:
                        DW = w.DW(lVar, 16);
                        j6 = this.DW == null ? 0 : this.DW.length;
                        obj = new long[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.DW, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.v5();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.v5();
                        this.DW = obj;
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        FH = lVar.FH(lVar.we());
                        DW = lVar.aM();
                        j6 = 0;
                        while (lVar.QX() > 0) {
                            lVar.v5();
                            j6++;
                        }
                        lVar.v5(DW);
                        DW = this.DW == null ? 0 : this.DW.length;
                        obj2 = new long[(j6 + DW)];
                        if (DW != 0) {
                            System.arraycopy(this.DW, 0, obj2, 0, DW);
                        }
                        while (DW < obj2.length) {
                            obj2[DW] = lVar.v5();
                            DW++;
                        }
                        this.DW = obj2;
                        lVar.Hw(FH);
                        continue;
                    default:
                        if (!w.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            int i = 0;
            if (this.j6 != null && this.j6.length > 0) {
                for (long j6 : this.j6) {
                    mVar.j6(1, j6);
                }
            }
            if (this.DW != null && this.DW.length > 0) {
                while (i < this.DW.length) {
                    mVar.j6(2, this.DW[i]);
                    i++;
                }
            }
            super.j6(mVar);
        }
    }

    public static final class g extends t {
        private static volatile g[] VH;
        public String DW;
        public String FH;
        public Long Hw;
        public Double Zo;
        public Long j6;
        public Float v5;

        public g() {
            DW();
        }

        public static g[] j6() {
            if (VH == null) {
                synchronized (r.FH) {
                    if (VH == null) {
                        VH = new g[0];
                    }
                }
            }
            return VH;
        }

        public g DW() {
            this.j6 = null;
            this.DW = null;
            this.FH = null;
            this.Hw = null;
            this.v5 = null;
            this.Zo = null;
            this.J8 = -1;
            return this;
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int FH = super.FH();
            if (this.j6 != null) {
                FH += m.Hw(1, this.j6.longValue());
            }
            if (this.DW != null) {
                FH += m.DW(2, this.DW);
            }
            if (this.FH != null) {
                FH += m.DW(3, this.FH);
            }
            if (this.Hw != null) {
                FH += m.Hw(4, this.Hw.longValue());
            }
            if (this.v5 != null) {
                FH += m.DW(5, this.v5.floatValue());
            }
            return this.Zo != null ? FH + m.DW(6, this.Zo.doubleValue()) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            if (this.j6 == null) {
                if (gVar.j6 != null) {
                    return false;
                }
            } else if (!this.j6.equals(gVar.j6)) {
                return false;
            }
            if (this.DW == null) {
                if (gVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(gVar.DW)) {
                return false;
            }
            if (this.FH == null) {
                if (gVar.FH != null) {
                    return false;
                }
            } else if (!this.FH.equals(gVar.FH)) {
                return false;
            }
            if (this.Hw == null) {
                if (gVar.Hw != null) {
                    return false;
                }
            } else if (!this.Hw.equals(gVar.Hw)) {
                return false;
            }
            if (this.v5 == null) {
                if (gVar.v5 != null) {
                    return false;
                }
            } else if (!this.v5.equals(gVar.v5)) {
                return false;
            }
            return this.Zo == null ? gVar.Zo == null : this.Zo.equals(gVar.Zo);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.v5 == null ? 0 : this.v5.hashCode()) + (((this.Hw == null ? 0 : this.Hw.hashCode()) + (((this.FH == null ? 0 : this.FH.hashCode()) + (((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.Zo != null) {
                i = this.Zo.hashCode();
            }
            return hashCode + i;
        }

        public g j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        this.j6 = Long.valueOf(lVar.Zo());
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 26:
                        this.FH = lVar.u7();
                        continue;
                    case 32:
                        this.Hw = Long.valueOf(lVar.Zo());
                        continue;
                    case 45:
                        this.v5 = Float.valueOf(lVar.Hw());
                        continue;
                    case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                        this.Zo = Double.valueOf(lVar.FH());
                        continue;
                    default:
                        if (!w.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            if (this.j6 != null) {
                mVar.DW(1, this.j6.longValue());
            }
            if (this.DW != null) {
                mVar.j6(2, this.DW);
            }
            if (this.FH != null) {
                mVar.j6(3, this.FH);
            }
            if (this.Hw != null) {
                mVar.DW(4, this.Hw.longValue());
            }
            if (this.v5 != null) {
                mVar.j6(5, this.v5.floatValue());
            }
            if (this.Zo != null) {
                mVar.j6(6, this.Zo.doubleValue());
            }
            super.j6(mVar);
        }
    }
}
