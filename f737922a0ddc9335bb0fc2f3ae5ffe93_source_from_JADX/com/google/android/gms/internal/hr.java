package com.google.android.gms.internal;

import com.aide.uidesigner.ProxyTextView;

public interface hr {

    public static final class a extends t {
        private static volatile a[] Hw;
        public e[] DW;
        public b[] FH;
        public Integer j6;

        public a() {
            DW();
        }

        public static a[] j6() {
            if (Hw == null) {
                synchronized (r.FH) {
                    if (Hw == null) {
                        Hw = new a[0];
                    }
                }
            }
            return Hw;
        }

        public a DW() {
            this.j6 = null;
            this.DW = e.j6();
            this.FH = b.j6();
            this.J8 = -1;
            return this;
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i = 0;
            int FH = super.FH();
            if (this.j6 != null) {
                FH += m.DW(1, this.j6.intValue());
            }
            if (this.DW != null && this.DW.length > 0) {
                int i2 = FH;
                for (t tVar : this.DW) {
                    if (tVar != null) {
                        i2 += m.FH(2, tVar);
                    }
                }
                FH = i2;
            }
            if (this.FH != null && this.FH.length > 0) {
                while (i < this.FH.length) {
                    t tVar2 = this.FH[i];
                    if (tVar2 != null) {
                        FH += m.FH(3, tVar2);
                    }
                    i++;
                }
            }
            return FH;
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
            return !r.j6(this.DW, aVar.DW) ? false : r.j6(this.FH, aVar.FH);
        }

        public int hashCode() {
            return (((((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + r.j6(this.DW)) * 31) + r.j6(this.FH);
        }

        public a j6(l lVar) {
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
                        obj = new e[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.DW, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new e();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new e();
                        lVar.j6(obj[j6]);
                        this.DW = obj;
                        continue;
                    case 26:
                        DW = w.DW(lVar, 26);
                        j6 = this.FH == null ? 0 : this.FH.length;
                        obj = new b[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.FH, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new b();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new b();
                        lVar.j6(obj[j6]);
                        this.FH = obj;
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
                while (i < this.FH.length) {
                    t tVar2 = this.FH[i];
                    if (tVar2 != null) {
                        mVar.j6(3, tVar2);
                    }
                    i++;
                }
            }
            super.j6(mVar);
        }
    }

    public static final class b extends t {
        private static volatile b[] Zo;
        public String DW;
        public c[] FH;
        public Boolean Hw;
        public Integer j6;
        public d v5;

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
            this.j6 = null;
            this.DW = null;
            this.FH = c.j6();
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
                FH += m.DW(1, this.j6.intValue());
            }
            if (this.DW != null) {
                FH += m.DW(2, this.DW);
            }
            if (this.FH != null && this.FH.length > 0) {
                int i = FH;
                for (t tVar : this.FH) {
                    if (tVar != null) {
                        i += m.FH(3, tVar);
                    }
                }
                FH = i;
            }
            if (this.Hw != null) {
                FH += m.DW(4, this.Hw.booleanValue());
            }
            return this.v5 != null ? FH + m.FH(5, this.v5) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.j6 == null) {
                if (bVar.j6 != null) {
                    return false;
                }
            } else if (!this.j6.equals(bVar.j6)) {
                return false;
            }
            if (this.DW == null) {
                if (bVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(bVar.DW)) {
                return false;
            }
            if (!r.j6(this.FH, bVar.FH)) {
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
            int hashCode = ((this.Hw == null ? 0 : this.Hw.hashCode()) + (((((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + r.j6(this.FH)) * 31)) * 31;
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
                    case 8:
                        this.j6 = Integer.valueOf(lVar.VH());
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 26:
                        int DW = w.DW(lVar, 26);
                        j6 = this.FH == null ? 0 : this.FH.length;
                        Object obj = new c[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.FH, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new c();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new c();
                        lVar.j6(obj[j6]);
                        this.FH = obj;
                        continue;
                    case 32:
                        this.Hw = Boolean.valueOf(lVar.gn());
                        continue;
                    case 42:
                        if (this.v5 == null) {
                            this.v5 = new d();
                        }
                        lVar.j6(this.v5);
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
            if (this.FH != null && this.FH.length > 0) {
                for (t tVar : this.FH) {
                    if (tVar != null) {
                        mVar.j6(3, tVar);
                    }
                }
            }
            if (this.Hw != null) {
                mVar.j6(4, this.Hw.booleanValue());
            }
            if (this.v5 != null) {
                mVar.j6(5, this.v5);
            }
            super.j6(mVar);
        }
    }

    public static final class c extends t {
        private static volatile c[] v5;
        public d DW;
        public Boolean FH;
        public String Hw;
        public f j6;

        public c() {
            DW();
        }

        public static c[] j6() {
            if (v5 == null) {
                synchronized (r.FH) {
                    if (v5 == null) {
                        v5 = new c[0];
                    }
                }
            }
            return v5;
        }

        public c DW() {
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
                FH += m.FH(1, this.j6);
            }
            if (this.DW != null) {
                FH += m.FH(2, this.DW);
            }
            if (this.FH != null) {
                FH += m.DW(3, this.FH.booleanValue());
            }
            return this.Hw != null ? FH + m.DW(4, this.Hw) : FH;
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
            return this.Hw == null ? cVar.Hw == null : this.Hw.equals(cVar.Hw);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.FH == null ? 0 : this.FH.hashCode()) + (((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.Hw != null) {
                i = this.Hw.hashCode();
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
                        if (this.j6 == null) {
                            this.j6 = new f();
                        }
                        lVar.j6(this.j6);
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        if (this.DW == null) {
                            this.DW = new d();
                        }
                        lVar.j6(this.DW);
                        continue;
                    case 24:
                        this.FH = Boolean.valueOf(lVar.gn());
                        continue;
                    case 34:
                        this.Hw = lVar.u7();
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
                mVar.j6(3, this.FH.booleanValue());
            }
            if (this.Hw != null) {
                mVar.j6(4, this.Hw);
            }
            super.j6(mVar);
        }
    }

    public static final class d extends t {
        public Boolean DW;
        public String FH;
        public String Hw;
        public Integer j6;
        public String v5;

        public d() {
            j6();
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
                FH += m.DW(2, this.DW.booleanValue());
            }
            if (this.FH != null) {
                FH += m.DW(3, this.FH);
            }
            if (this.Hw != null) {
                FH += m.DW(4, this.Hw);
            }
            return this.v5 != null ? FH + m.DW(5, this.v5) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.j6 == null) {
                if (dVar.j6 != null) {
                    return false;
                }
            } else if (!this.j6.equals(dVar.j6)) {
                return false;
            }
            if (this.DW == null) {
                if (dVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(dVar.DW)) {
                return false;
            }
            if (this.FH == null) {
                if (dVar.FH != null) {
                    return false;
                }
            } else if (!this.FH.equals(dVar.FH)) {
                return false;
            }
            if (this.Hw == null) {
                if (dVar.Hw != null) {
                    return false;
                }
            } else if (!this.Hw.equals(dVar.Hw)) {
                return false;
            }
            return this.v5 == null ? dVar.v5 == null : this.v5.equals(dVar.v5);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.Hw == null ? 0 : this.Hw.hashCode()) + (((this.FH == null ? 0 : this.FH.hashCode()) + (((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.v5 != null) {
                i = this.v5.hashCode();
            }
            return hashCode + i;
        }

        public d j6() {
            this.DW = null;
            this.FH = null;
            this.Hw = null;
            this.v5 = null;
            this.J8 = -1;
            return this;
        }

        public d j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        j6 = lVar.VH();
                        switch (j6) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                                this.j6 = Integer.valueOf(j6);
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.DW = Boolean.valueOf(lVar.gn());
                        continue;
                    case 26:
                        this.FH = lVar.u7();
                        continue;
                    case 34:
                        this.Hw = lVar.u7();
                        continue;
                    case 42:
                        this.v5 = lVar.u7();
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
                mVar.j6(2, this.DW.booleanValue());
            }
            if (this.FH != null) {
                mVar.j6(3, this.FH);
            }
            if (this.Hw != null) {
                mVar.j6(4, this.Hw);
            }
            if (this.v5 != null) {
                mVar.j6(5, this.v5);
            }
            super.j6(mVar);
        }
    }

    public static final class e extends t {
        private static volatile e[] Hw;
        public String DW;
        public c FH;
        public Integer j6;

        public e() {
            DW();
        }

        public static e[] j6() {
            if (Hw == null) {
                synchronized (r.FH) {
                    if (Hw == null) {
                        Hw = new e[0];
                    }
                }
            }
            return Hw;
        }

        public e DW() {
            this.j6 = null;
            this.DW = null;
            this.FH = null;
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
                FH += m.DW(2, this.DW);
            }
            return this.FH != null ? FH + m.FH(3, this.FH) : FH;
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
            if (this.DW == null) {
                if (eVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(eVar.DW)) {
                return false;
            }
            return this.FH == null ? eVar.FH == null : this.FH.equals(eVar.FH);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.FH != null) {
                i = this.FH.hashCode();
            }
            return hashCode + i;
        }

        public e j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        this.j6 = Integer.valueOf(lVar.VH());
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 26:
                        if (this.FH == null) {
                            this.FH = new c();
                        }
                        lVar.j6(this.FH);
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
            super.j6(mVar);
        }
    }

    public static final class f extends t {
        public String DW;
        public Boolean FH;
        public String[] Hw;
        public Integer j6;

        public f() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i = 0;
            int FH = super.FH();
            if (this.j6 != null) {
                FH += m.DW(1, this.j6.intValue());
            }
            if (this.DW != null) {
                FH += m.DW(2, this.DW);
            }
            if (this.FH != null) {
                FH += m.DW(3, this.FH.booleanValue());
            }
            if (this.Hw == null || this.Hw.length <= 0) {
                return FH;
            }
            int i2 = 0;
            int i3 = 0;
            while (i < this.Hw.length) {
                String str = this.Hw[i];
                if (str != null) {
                    i3++;
                    i2 += m.DW(str);
                }
                i++;
            }
            return (FH + i2) + (i3 * 1);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (this.j6 == null) {
                if (fVar.j6 != null) {
                    return false;
                }
            } else if (!this.j6.equals(fVar.j6)) {
                return false;
            }
            if (this.DW == null) {
                if (fVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(fVar.DW)) {
                return false;
            }
            if (this.FH == null) {
                if (fVar.FH != null) {
                    return false;
                }
            } else if (!this.FH.equals(fVar.FH)) {
                return false;
            }
            return r.j6(this.Hw, fVar.Hw);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.FH != null) {
                i = this.FH.hashCode();
            }
            return ((hashCode + i) * 31) + r.j6(this.Hw);
        }

        public f j6() {
            this.DW = null;
            this.FH = null;
            this.Hw = w.Zo;
            this.J8 = -1;
            return this;
        }

        public f j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        j6 = lVar.VH();
                        switch (j6) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            case 5:
                            case 6:
                                this.j6 = Integer.valueOf(j6);
                                break;
                            default:
                                continue;
                        }
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 24:
                        this.FH = Boolean.valueOf(lVar.gn());
                        continue;
                    case 34:
                        int DW = w.DW(lVar, 34);
                        j6 = this.Hw == null ? 0 : this.Hw.length;
                        Object obj = new String[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.Hw, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.u7();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.u7();
                        this.Hw = obj;
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
                mVar.j6(3, this.FH.booleanValue());
            }
            if (this.Hw != null && this.Hw.length > 0) {
                for (String str : this.Hw) {
                    if (str != null) {
                        mVar.j6(4, str);
                    }
                }
            }
            super.j6(mVar);
        }
    }
}
