package com.google.android.gms.internal;

import com.aide.uidesigner.ProxyTextView;

public interface hs {

    public static final class a extends t {
        private static volatile a[] Hw;
        public Boolean DW;
        public Boolean FH;
        public String j6;

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
                FH += m.DW(1, this.j6);
            }
            if (this.DW != null) {
                FH += m.DW(2, this.DW.booleanValue());
            }
            return this.FH != null ? FH + m.DW(3, this.FH.booleanValue()) : FH;
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
            return this.FH == null ? aVar.FH == null : this.FH.equals(aVar.FH);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.FH != null) {
                i = this.FH.hashCode();
            }
            return hashCode + i;
        }

        public a j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 10:
                        this.j6 = lVar.u7();
                        continue;
                    case 16:
                        this.DW = Boolean.valueOf(lVar.gn());
                        continue;
                    case 24:
                        this.FH = Boolean.valueOf(lVar.gn());
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
                mVar.j6(2, this.DW.booleanValue());
            }
            if (this.FH != null) {
                mVar.j6(3, this.FH.booleanValue());
            }
            super.j6(mVar);
        }
    }

    public static final class b extends t {
        public String DW;
        public Integer FH;
        public c[] Hw;
        public com.google.android.gms.internal.hr.a[] Zo;
        public Long j6;
        public a[] v5;

        public b() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i;
            int i2 = 0;
            int FH = super.FH();
            if (this.j6 != null) {
                FH += m.Hw(1, this.j6.longValue());
            }
            if (this.DW != null) {
                FH += m.DW(2, this.DW);
            }
            if (this.FH != null) {
                FH += m.DW(3, this.FH.intValue());
            }
            if (this.Hw != null && this.Hw.length > 0) {
                i = FH;
                for (t tVar : this.Hw) {
                    if (tVar != null) {
                        i += m.FH(4, tVar);
                    }
                }
                FH = i;
            }
            if (this.v5 != null && this.v5.length > 0) {
                i = FH;
                for (t tVar2 : this.v5) {
                    if (tVar2 != null) {
                        i += m.FH(5, tVar2);
                    }
                }
                FH = i;
            }
            if (this.Zo != null && this.Zo.length > 0) {
                while (i2 < this.Zo.length) {
                    t tVar3 = this.Zo[i2];
                    if (tVar3 != null) {
                        FH += m.FH(6, tVar3);
                    }
                    i2++;
                }
            }
            return FH;
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
            if (this.FH == null) {
                if (bVar.FH != null) {
                    return false;
                }
            } else if (!this.FH.equals(bVar.FH)) {
                return false;
            }
            return !r.j6(this.Hw, bVar.Hw) ? false : !r.j6(this.v5, bVar.v5) ? false : r.j6(this.Zo, bVar.Zo);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.FH != null) {
                i = this.FH.hashCode();
            }
            return ((((((hashCode + i) * 31) + r.j6(this.Hw)) * 31) + r.j6(this.v5)) * 31) + r.j6(this.Zo);
        }

        public b j6() {
            this.j6 = null;
            this.DW = null;
            this.FH = null;
            this.Hw = c.j6();
            this.v5 = a.j6();
            this.Zo = com.google.android.gms.internal.hr.a.j6();
            this.J8 = -1;
            return this;
        }

        public b j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                int DW;
                Object obj;
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        this.j6 = Long.valueOf(lVar.Zo());
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 24:
                        this.FH = Integer.valueOf(lVar.VH());
                        continue;
                    case 34:
                        DW = w.DW(lVar, 34);
                        j6 = this.Hw == null ? 0 : this.Hw.length;
                        obj = new c[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.Hw, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new c();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new c();
                        lVar.j6(obj[j6]);
                        this.Hw = obj;
                        continue;
                    case 42:
                        DW = w.DW(lVar, 42);
                        j6 = this.v5 == null ? 0 : this.v5.length;
                        obj = new a[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.v5, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new a();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new a();
                        lVar.j6(obj[j6]);
                        this.v5 = obj;
                        continue;
                    case 50:
                        DW = w.DW(lVar, 50);
                        j6 = this.Zo == null ? 0 : this.Zo.length;
                        obj = new com.google.android.gms.internal.hr.a[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.Zo, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new com.google.android.gms.internal.hr.a();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new com.google.android.gms.internal.hr.a();
                        lVar.j6(obj[j6]);
                        this.Zo = obj;
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
                mVar.DW(1, this.j6.longValue());
            }
            if (this.DW != null) {
                mVar.j6(2, this.DW);
            }
            if (this.FH != null) {
                mVar.j6(3, this.FH.intValue());
            }
            if (this.Hw != null && this.Hw.length > 0) {
                for (t tVar : this.Hw) {
                    if (tVar != null) {
                        mVar.j6(4, tVar);
                    }
                }
            }
            if (this.v5 != null && this.v5.length > 0) {
                for (t tVar2 : this.v5) {
                    if (tVar2 != null) {
                        mVar.j6(5, tVar2);
                    }
                }
            }
            if (this.Zo != null && this.Zo.length > 0) {
                while (i < this.Zo.length) {
                    t tVar3 = this.Zo[i];
                    if (tVar3 != null) {
                        mVar.j6(6, tVar3);
                    }
                    i++;
                }
            }
            super.j6(mVar);
        }
    }

    public static final class c extends t {
        private static volatile c[] FH;
        public String DW;
        public String j6;

        public c() {
            DW();
        }

        public static c[] j6() {
            if (FH == null) {
                synchronized (r.FH) {
                    if (FH == null) {
                        FH = new c[0];
                    }
                }
            }
            return FH;
        }

        public c DW() {
            this.j6 = null;
            this.DW = null;
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
            return this.DW != null ? FH + m.DW(2, this.DW) : FH;
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
            return this.DW == null ? cVar.DW == null : this.DW.equals(cVar.DW);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (this.DW != null) {
                i = this.DW.hashCode();
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
            super.j6(mVar);
        }
    }
}
