package com.google.android.gms.internal;

import com.aide.uidesigner.ProxyTextView;

public interface h {

    public static final class a extends n<a> {
        private static volatile a[] Ws;
        public String DW;
        public int[] EQ;
        public a[] FH;
        public a[] Hw;
        public String VH;
        public String Zo;
        public long gn;
        public int j6;
        public a[] tp;
        public boolean u7;
        public a[] v5;
        public boolean we;

        public a() {
            DW();
        }

        public static a[] j6() {
            if (Ws == null) {
                synchronized (r.FH) {
                    if (Ws == null) {
                        Ws = new a[0];
                    }
                }
            }
            return Ws;
        }

        public a DW() {
            this.j6 = 1;
            this.DW = "";
            this.FH = j6();
            this.Hw = j6();
            this.v5 = j6();
            this.Zo = "";
            this.VH = "";
            this.gn = 0;
            this.u7 = false;
            this.tp = j6();
            this.EQ = w.j6;
            this.we = false;
            this.J0 = null;
            this.J8 = -1;
            return this;
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i;
            int i2 = 0;
            int FH = super.FH() + m.DW(1, this.j6);
            if (!this.DW.equals("")) {
                FH += m.DW(2, this.DW);
            }
            if (this.FH != null && this.FH.length > 0) {
                i = FH;
                for (t tVar : this.FH) {
                    if (tVar != null) {
                        i += m.FH(3, tVar);
                    }
                }
                FH = i;
            }
            if (this.Hw != null && this.Hw.length > 0) {
                i = FH;
                for (t tVar2 : this.Hw) {
                    if (tVar2 != null) {
                        i += m.FH(4, tVar2);
                    }
                }
                FH = i;
            }
            if (this.v5 != null && this.v5.length > 0) {
                i = FH;
                for (t tVar22 : this.v5) {
                    if (tVar22 != null) {
                        i += m.FH(5, tVar22);
                    }
                }
                FH = i;
            }
            if (!this.Zo.equals("")) {
                FH += m.DW(6, this.Zo);
            }
            if (!this.VH.equals("")) {
                FH += m.DW(7, this.VH);
            }
            if (this.gn != 0) {
                FH += m.Hw(8, this.gn);
            }
            if (this.we) {
                FH += m.DW(9, this.we);
            }
            if (this.EQ != null && this.EQ.length > 0) {
                int i3 = 0;
                for (int DW : this.EQ) {
                    i3 += m.DW(DW);
                }
                FH = (FH + i3) + (this.EQ.length * 1);
            }
            if (this.tp != null && this.tp.length > 0) {
                while (i2 < this.tp.length) {
                    t tVar3 = this.tp[i2];
                    if (tVar3 != null) {
                        FH += m.FH(11, tVar3);
                    }
                    i2++;
                }
            }
            return this.u7 ? FH + m.DW(12, this.u7) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.j6 != aVar.j6) {
                return false;
            }
            if (this.DW == null) {
                if (aVar.DW != null) {
                    return false;
                }
            } else if (!this.DW.equals(aVar.DW)) {
                return false;
            }
            if (!r.j6(this.FH, aVar.FH) || !r.j6(this.Hw, aVar.Hw) || !r.j6(this.v5, aVar.v5)) {
                return false;
            }
            if (this.Zo == null) {
                if (aVar.Zo != null) {
                    return false;
                }
            } else if (!this.Zo.equals(aVar.Zo)) {
                return false;
            }
            if (this.VH == null) {
                if (aVar.VH != null) {
                    return false;
                }
            } else if (!this.VH.equals(aVar.VH)) {
                return false;
            }
            return (this.gn == aVar.gn && this.u7 == aVar.u7 && r.j6(this.tp, aVar.tp) && r.j6(this.EQ, aVar.EQ) && this.we == aVar.we) ? (this.J0 == null || this.J0.DW()) ? aVar.J0 == null || aVar.J0.DW() : this.J0.equals(aVar.J0) : false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.u7 ? 1231 : 1237) + (((((this.VH == null ? 0 : this.VH.hashCode()) + (((this.Zo == null ? 0 : this.Zo.hashCode()) + (((((((((this.DW == null ? 0 : this.DW.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.j6) * 31)) * 31) + r.j6(this.FH)) * 31) + r.j6(this.Hw)) * 31) + r.j6(this.v5)) * 31)) * 31)) * 31) + ((int) (this.gn ^ (this.gn >>> 32)))) * 31)) * 31) + r.j6(this.tp)) * 31) + r.j6(this.EQ)) * 31;
            if (!this.we) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.J0 == null || this.J0.DW())) {
                i2 = this.J0.hashCode();
            }
            return hashCode + i2;
        }

        public a j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                int DW;
                Object obj;
                int i;
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        j6 = lVar.VH();
                        switch (j6) {
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.j6 = j6;
                                break;
                            default:
                                continue;
                        }
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 26:
                        DW = w.DW(lVar, 26);
                        j6 = this.FH == null ? 0 : this.FH.length;
                        obj = new a[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.FH, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new a();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new a();
                        lVar.j6(obj[j6]);
                        this.FH = obj;
                        continue;
                    case 34:
                        DW = w.DW(lVar, 34);
                        j6 = this.Hw == null ? 0 : this.Hw.length;
                        obj = new a[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.Hw, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new a();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new a();
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
                        this.Zo = lVar.u7();
                        continue;
                    case 58:
                        this.VH = lVar.u7();
                        continue;
                    case 64:
                        this.gn = lVar.Zo();
                        continue;
                    case 72:
                        this.we = lVar.gn();
                        continue;
                    case 80:
                        int DW2 = w.DW(lVar, 80);
                        Object obj2 = new int[DW2];
                        i = 0;
                        DW = 0;
                        while (i < DW2) {
                            if (i != 0) {
                                lVar.j6();
                            }
                            int VH = lVar.VH();
                            switch (VH) {
                                case ProxyTextView.TYPEFACE_SANS /*1*/:
                                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                                    j6 = DW + 1;
                                    obj2[DW] = VH;
                                    break;
                                default:
                                    j6 = DW;
                                    break;
                            }
                            i++;
                            DW = j6;
                        }
                        if (DW != 0) {
                            j6 = this.EQ == null ? 0 : this.EQ.length;
                            if (j6 != 0 || DW != DW2) {
                                Object obj3 = new int[(j6 + DW)];
                                if (j6 != 0) {
                                    System.arraycopy(this.EQ, 0, obj3, 0, j6);
                                }
                                System.arraycopy(obj2, 0, obj3, j6, DW);
                                this.EQ = obj3;
                                break;
                            }
                            this.EQ = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = lVar.FH(lVar.we());
                        DW = lVar.aM();
                        j6 = 0;
                        while (lVar.QX() > 0) {
                            switch (lVar.VH()) {
                                case ProxyTextView.TYPEFACE_SANS /*1*/:
                                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                                    j6++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (j6 != 0) {
                            lVar.v5(DW);
                            DW = this.EQ == null ? 0 : this.EQ.length;
                            Object obj4 = new int[(j6 + DW)];
                            if (DW != 0) {
                                System.arraycopy(this.EQ, 0, obj4, 0, DW);
                            }
                            while (lVar.QX() > 0) {
                                int VH2 = lVar.VH();
                                switch (VH2) {
                                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                                        j6 = DW + 1;
                                        obj4[DW] = VH2;
                                        DW = j6;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.EQ = obj4;
                        }
                        lVar.Hw(i);
                        continue;
                    case 90:
                        DW = w.DW(lVar, 90);
                        j6 = this.tp == null ? 0 : this.tp.length;
                        obj = new a[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.tp, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new a();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new a();
                        lVar.j6(obj[j6]);
                        this.tp = obj;
                        continue;
                    case 96:
                        this.u7 = lVar.gn();
                        continue;
                    default:
                        if (!super.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            int i = 0;
            mVar.j6(1, this.j6);
            if (!this.DW.equals("")) {
                mVar.j6(2, this.DW);
            }
            if (this.FH != null && this.FH.length > 0) {
                for (t tVar : this.FH) {
                    if (tVar != null) {
                        mVar.j6(3, tVar);
                    }
                }
            }
            if (this.Hw != null && this.Hw.length > 0) {
                for (t tVar2 : this.Hw) {
                    if (tVar2 != null) {
                        mVar.j6(4, tVar2);
                    }
                }
            }
            if (this.v5 != null && this.v5.length > 0) {
                for (t tVar22 : this.v5) {
                    if (tVar22 != null) {
                        mVar.j6(5, tVar22);
                    }
                }
            }
            if (!this.Zo.equals("")) {
                mVar.j6(6, this.Zo);
            }
            if (!this.VH.equals("")) {
                mVar.j6(7, this.VH);
            }
            if (this.gn != 0) {
                mVar.DW(8, this.gn);
            }
            if (this.we) {
                mVar.j6(9, this.we);
            }
            if (this.EQ != null && this.EQ.length > 0) {
                for (int j6 : this.EQ) {
                    mVar.j6(10, j6);
                }
            }
            if (this.tp != null && this.tp.length > 0) {
                while (i < this.tp.length) {
                    t tVar3 = this.tp[i];
                    if (tVar3 != null) {
                        mVar.j6(11, tVar3);
                    }
                    i++;
                }
            }
            if (this.u7) {
                mVar.j6(12, this.u7);
            }
            super.j6(mVar);
        }
    }
}
