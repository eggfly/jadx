package com.google.android.gms.internal;

import com.aide.uidesigner.ProxyTextView;
import java.util.Arrays;

public interface x {

    public static final class a extends n<a> {
        public String[] DW;
        public int[] FH;
        public long[] Hw;
        public String[] j6;

        public a() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int FH = super.FH();
            if (this.j6 == null || this.j6.length <= 0) {
                i = FH;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.j6) {
                    if (str != null) {
                        i3++;
                        i2 += m.DW(str);
                    }
                }
                i = (FH + i2) + (i3 * 1);
            }
            if (this.DW != null && this.DW.length > 0) {
                i3 = 0;
                FH = 0;
                for (String str2 : this.DW) {
                    if (str2 != null) {
                        FH++;
                        i3 += m.DW(str2);
                    }
                }
                i = (i + i3) + (FH * 1);
            }
            if (this.FH != null && this.FH.length > 0) {
                i3 = 0;
                for (int FH2 : this.FH) {
                    i3 += m.DW(FH2);
                }
                i = (i + i3) + (this.FH.length * 1);
            }
            if (this.Hw == null || this.Hw.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.Hw.length) {
                i2 += m.v5(this.Hw[i4]);
                i4++;
            }
            return (i + i2) + (this.Hw.length * 1);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return (r.j6(this.j6, aVar.j6) && r.j6(this.DW, aVar.DW) && r.j6(this.FH, aVar.FH) && r.j6(this.Hw, aVar.Hw)) ? (this.J0 == null || this.J0.DW()) ? aVar.J0 == null || aVar.J0.DW() : this.J0.equals(aVar.J0) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + r.j6(this.j6)) * 31) + r.j6(this.DW)) * 31) + r.j6(this.FH)) * 31) + r.j6(this.Hw)) * 31;
            int hashCode2 = (this.J0 == null || this.J0.DW()) ? 0 : this.J0.hashCode();
            return hashCode2 + hashCode;
        }

        public a j6() {
            this.j6 = w.Zo;
            this.DW = w.Zo;
            this.FH = w.j6;
            this.Hw = w.DW;
            this.J0 = null;
            this.J8 = -1;
            return this;
        }

        public a j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                int DW;
                Object obj;
                int FH;
                Object obj2;
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 10:
                        DW = w.DW(lVar, 10);
                        j6 = this.j6 == null ? 0 : this.j6.length;
                        obj = new String[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.j6, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.u7();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.u7();
                        this.j6 = obj;
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        DW = w.DW(lVar, 18);
                        j6 = this.DW == null ? 0 : this.DW.length;
                        obj = new String[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.DW, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.u7();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.u7();
                        this.DW = obj;
                        continue;
                    case 24:
                        DW = w.DW(lVar, 24);
                        j6 = this.FH == null ? 0 : this.FH.length;
                        obj = new int[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.FH, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.VH();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.VH();
                        this.FH = obj;
                        continue;
                    case 26:
                        FH = lVar.FH(lVar.we());
                        DW = lVar.aM();
                        j6 = 0;
                        while (lVar.QX() > 0) {
                            lVar.VH();
                            j6++;
                        }
                        lVar.v5(DW);
                        DW = this.FH == null ? 0 : this.FH.length;
                        obj2 = new int[(j6 + DW)];
                        if (DW != 0) {
                            System.arraycopy(this.FH, 0, obj2, 0, DW);
                        }
                        while (DW < obj2.length) {
                            obj2[DW] = lVar.VH();
                            DW++;
                        }
                        this.FH = obj2;
                        lVar.Hw(FH);
                        continue;
                    case 32:
                        DW = w.DW(lVar, 32);
                        j6 = this.Hw == null ? 0 : this.Hw.length;
                        obj = new long[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.Hw, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.Zo();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.Zo();
                        this.Hw = obj;
                        continue;
                    case 34:
                        FH = lVar.FH(lVar.we());
                        DW = lVar.aM();
                        j6 = 0;
                        while (lVar.QX() > 0) {
                            lVar.Zo();
                            j6++;
                        }
                        lVar.v5(DW);
                        DW = this.Hw == null ? 0 : this.Hw.length;
                        obj2 = new long[(j6 + DW)];
                        if (DW != 0) {
                            System.arraycopy(this.Hw, 0, obj2, 0, DW);
                        }
                        while (DW < obj2.length) {
                            obj2[DW] = lVar.Zo();
                            DW++;
                        }
                        this.Hw = obj2;
                        lVar.Hw(FH);
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
            if (this.j6 != null && this.j6.length > 0) {
                for (String str : this.j6) {
                    if (str != null) {
                        mVar.j6(1, str);
                    }
                }
            }
            if (this.DW != null && this.DW.length > 0) {
                for (String str2 : this.DW) {
                    if (str2 != null) {
                        mVar.j6(2, str2);
                    }
                }
            }
            if (this.FH != null && this.FH.length > 0) {
                for (int j6 : this.FH) {
                    mVar.j6(3, j6);
                }
            }
            if (this.Hw != null && this.Hw.length > 0) {
                while (i < this.Hw.length) {
                    mVar.DW(4, this.Hw[i]);
                    i++;
                }
            }
            super.j6(mVar);
        }
    }

    public static final class b extends n<b> {
        public String DW;
        public String FH;
        public int j6;

        public b() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int FH = super.FH();
            if (this.j6 != 0) {
                FH += m.DW(1, this.j6);
            }
            if (!this.DW.equals("")) {
                FH += m.DW(2, this.DW);
            }
            return !this.FH.equals("") ? FH + m.DW(3, this.FH) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.j6 != bVar.j6) {
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
            return (this.J0 == null || this.J0.DW()) ? bVar.J0 == null || bVar.J0.DW() : this.J0.equals(bVar.J0);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.FH == null ? 0 : this.FH.hashCode()) + (((this.DW == null ? 0 : this.DW.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.j6) * 31)) * 31)) * 31;
            if (!(this.J0 == null || this.J0.DW())) {
                i = this.J0.hashCode();
            }
            return hashCode + i;
        }

        public b j6() {
            this.j6 = 0;
            this.DW = "";
            this.FH = "";
            this.J0 = null;
            this.J8 = -1;
            return this;
        }

        public b j6(l lVar) {
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
                            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                            case 19:
                            case ProxyTextView.INPUTTYPE_date /*20*/:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.j6 = j6;
                                break;
                            default:
                                continue;
                        }
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.DW = lVar.u7();
                        continue;
                    case 26:
                        this.FH = lVar.u7();
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
            if (this.j6 != 0) {
                mVar.j6(1, this.j6);
            }
            if (!this.DW.equals("")) {
                mVar.j6(2, this.DW);
            }
            if (!this.FH.equals("")) {
                mVar.j6(3, this.FH);
            }
            super.j6(mVar);
        }
    }

    public static final class c extends n<c> {
        public byte[][] DW;
        public boolean FH;
        public byte[] j6;

        public c() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i = 0;
            int FH = super.FH();
            if (!Arrays.equals(this.j6, w.gn)) {
                FH += m.DW(1, this.j6);
            }
            if (this.DW != null && this.DW.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.DW.length) {
                    byte[] bArr = this.DW[i];
                    if (bArr != null) {
                        i3++;
                        i2 += m.FH(bArr);
                    }
                    i++;
                }
                FH = (FH + i2) + (i3 * 1);
            }
            return this.FH ? FH + m.DW(3, this.FH) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return (Arrays.equals(this.j6, cVar.j6) && r.j6(this.DW, cVar.DW) && this.FH == cVar.FH) ? (this.J0 == null || this.J0.DW()) ? cVar.J0 == null || cVar.J0.DW() : this.J0.equals(cVar.J0) : false;
        }

        public int hashCode() {
            int hashCode = ((this.FH ? 1231 : 1237) + ((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.j6)) * 31) + r.j6(this.DW)) * 31)) * 31;
            int hashCode2 = (this.J0 == null || this.J0.DW()) ? 0 : this.J0.hashCode();
            return hashCode2 + hashCode;
        }

        public c j6() {
            this.j6 = w.gn;
            this.DW = w.VH;
            this.FH = false;
            this.J0 = null;
            this.J8 = -1;
            return this;
        }

        public c j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 10:
                        this.j6 = lVar.tp();
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        int DW = w.DW(lVar, 18);
                        j6 = this.DW == null ? 0 : this.DW.length;
                        Object obj = new byte[(DW + j6)][];
                        if (j6 != 0) {
                            System.arraycopy(this.DW, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.tp();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.tp();
                        this.DW = obj;
                        continue;
                    case 24:
                        this.FH = lVar.gn();
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
            if (!Arrays.equals(this.j6, w.gn)) {
                mVar.j6(1, this.j6);
            }
            if (this.DW != null && this.DW.length > 0) {
                for (byte[] bArr : this.DW) {
                    if (bArr != null) {
                        mVar.j6(2, bArr);
                    }
                }
            }
            if (this.FH) {
                mVar.j6(3, this.FH);
            }
            super.j6(mVar);
        }
    }

    public static final class d extends n<d> {
        public long DW;
        public byte[] EQ;
        public long FH;
        public String Hw;
        public int Mr;
        public String QX;
        public int[] U2;
        public boolean VH;
        public a Ws;
        public long XL;
        public int Zo;
        public long a8;
        public c aM;
        public e[] gn;
        public byte[] j3;
        public long j6;
        public f lg;
        public byte[] tp;
        public b u7;
        public int v5;
        public byte[] we;

        public d() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int i;
            int i2 = 0;
            int FH = super.FH();
            if (this.j6 != 0) {
                FH += m.Hw(1, this.j6);
            }
            if (!this.Hw.equals("")) {
                FH += m.DW(2, this.Hw);
            }
            if (this.gn != null && this.gn.length > 0) {
                i = FH;
                for (t tVar : this.gn) {
                    if (tVar != null) {
                        i += m.FH(3, tVar);
                    }
                }
                FH = i;
            }
            if (!Arrays.equals(this.tp, w.gn)) {
                FH += m.DW(6, this.tp);
            }
            if (this.Ws != null) {
                FH += m.FH(7, this.Ws);
            }
            if (!Arrays.equals(this.EQ, w.gn)) {
                FH += m.DW(8, this.EQ);
            }
            if (this.u7 != null) {
                FH += m.FH(9, this.u7);
            }
            if (this.VH) {
                FH += m.DW(10, this.VH);
            }
            if (this.v5 != 0) {
                FH += m.DW(11, this.v5);
            }
            if (this.Zo != 0) {
                FH += m.DW(12, this.Zo);
            }
            if (!Arrays.equals(this.we, w.gn)) {
                FH += m.DW(13, this.we);
            }
            if (!this.QX.equals("")) {
                FH += m.DW(14, this.QX);
            }
            if (this.XL != 180000) {
                FH += m.v5(15, this.XL);
            }
            if (this.aM != null) {
                FH += m.FH(16, this.aM);
            }
            if (this.DW != 0) {
                FH += m.Hw(17, this.DW);
            }
            if (!Arrays.equals(this.j3, w.gn)) {
                FH += m.DW(18, this.j3);
            }
            if (this.Mr != 0) {
                FH += m.DW(19, this.Mr);
            }
            if (this.U2 != null && this.U2.length > 0) {
                i = 0;
                while (i2 < this.U2.length) {
                    i += m.DW(this.U2[i2]);
                    i2++;
                }
                FH = (FH + i) + (this.U2.length * 2);
            }
            if (this.FH != 0) {
                FH += m.Hw(21, this.FH);
            }
            if (this.a8 != 0) {
                FH += m.Hw(22, this.a8);
            }
            return this.lg != null ? FH + m.FH(23, this.lg) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.j6 != dVar.j6 || this.DW != dVar.DW || this.FH != dVar.FH) {
                return false;
            }
            if (this.Hw == null) {
                if (dVar.Hw != null) {
                    return false;
                }
            } else if (!this.Hw.equals(dVar.Hw)) {
                return false;
            }
            if (this.v5 != dVar.v5 || this.Zo != dVar.Zo || this.VH != dVar.VH || !r.j6(this.gn, dVar.gn)) {
                return false;
            }
            if (this.u7 == null) {
                if (dVar.u7 != null) {
                    return false;
                }
            } else if (!this.u7.equals(dVar.u7)) {
                return false;
            }
            if (!Arrays.equals(this.tp, dVar.tp) || !Arrays.equals(this.EQ, dVar.EQ) || !Arrays.equals(this.we, dVar.we)) {
                return false;
            }
            if (this.Ws == null) {
                if (dVar.Ws != null) {
                    return false;
                }
            } else if (!this.Ws.equals(dVar.Ws)) {
                return false;
            }
            if (this.QX == null) {
                if (dVar.QX != null) {
                    return false;
                }
            } else if (!this.QX.equals(dVar.QX)) {
                return false;
            }
            if (this.XL != dVar.XL) {
                return false;
            }
            if (this.aM == null) {
                if (dVar.aM != null) {
                    return false;
                }
            } else if (!this.aM.equals(dVar.aM)) {
                return false;
            }
            if (!Arrays.equals(this.j3, dVar.j3) || this.Mr != dVar.Mr || !r.j6(this.U2, dVar.U2) || this.a8 != dVar.a8) {
                return false;
            }
            if (this.lg == null) {
                if (dVar.lg != null) {
                    return false;
                }
            } else if (!this.lg.equals(dVar.lg)) {
                return false;
            }
            return (this.J0 == null || this.J0.DW()) ? dVar.J0 == null || dVar.J0.DW() : this.J0.equals(dVar.J0);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.lg == null ? 0 : this.lg.hashCode()) + (((((((((((this.aM == null ? 0 : this.aM.hashCode()) + (((((this.QX == null ? 0 : this.QX.hashCode()) + (((this.Ws == null ? 0 : this.Ws.hashCode()) + (((((((((this.u7 == null ? 0 : this.u7.hashCode()) + (((((this.VH ? 1231 : 1237) + (((((((this.Hw == null ? 0 : this.Hw.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.j6 ^ (this.j6 >>> 32)))) * 31) + ((int) (this.DW ^ (this.DW >>> 32)))) * 31) + ((int) (this.FH ^ (this.FH >>> 32)))) * 31)) * 31) + this.v5) * 31) + this.Zo) * 31)) * 31) + r.j6(this.gn)) * 31)) * 31) + Arrays.hashCode(this.tp)) * 31) + Arrays.hashCode(this.EQ)) * 31) + Arrays.hashCode(this.we)) * 31)) * 31)) * 31) + ((int) (this.XL ^ (this.XL >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.j3)) * 31) + this.Mr) * 31) + r.j6(this.U2)) * 31) + ((int) (this.a8 ^ (this.a8 >>> 32)))) * 31)) * 31;
            if (!(this.J0 == null || this.J0.DW())) {
                i = this.J0.hashCode();
            }
            return hashCode + i;
        }

        public d j6() {
            this.j6 = 0;
            this.DW = 0;
            this.FH = 0;
            this.Hw = "";
            this.v5 = 0;
            this.Zo = 0;
            this.VH = false;
            this.gn = e.j6();
            this.u7 = null;
            this.tp = w.gn;
            this.EQ = w.gn;
            this.we = w.gn;
            this.Ws = null;
            this.QX = "";
            this.XL = 180000;
            this.aM = null;
            this.j3 = w.gn;
            this.Mr = 0;
            this.U2 = w.j6;
            this.a8 = 0;
            this.lg = null;
            this.J0 = null;
            this.J8 = -1;
            return this;
        }

        public d j6(l lVar) {
            while (true) {
                int j6 = lVar.j6();
                int DW;
                Object obj;
                switch (j6) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        break;
                    case 8:
                        this.j6 = lVar.Zo();
                        continue;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        this.Hw = lVar.u7();
                        continue;
                    case 26:
                        DW = w.DW(lVar, 26);
                        j6 = this.gn == null ? 0 : this.gn.length;
                        obj = new e[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.gn, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = new e();
                            lVar.j6(obj[j6]);
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = new e();
                        lVar.j6(obj[j6]);
                        this.gn = obj;
                        continue;
                    case 50:
                        this.tp = lVar.tp();
                        continue;
                    case 58:
                        if (this.Ws == null) {
                            this.Ws = new a();
                        }
                        lVar.j6(this.Ws);
                        continue;
                    case 66:
                        this.EQ = lVar.tp();
                        continue;
                    case 74:
                        if (this.u7 == null) {
                            this.u7 = new b();
                        }
                        lVar.j6(this.u7);
                        continue;
                    case 80:
                        this.VH = lVar.gn();
                        continue;
                    case 88:
                        this.v5 = lVar.VH();
                        continue;
                    case 96:
                        this.Zo = lVar.VH();
                        continue;
                    case 106:
                        this.we = lVar.tp();
                        continue;
                    case 114:
                        this.QX = lVar.u7();
                        continue;
                    case 120:
                        this.XL = lVar.EQ();
                        continue;
                    case 130:
                        if (this.aM == null) {
                            this.aM = new c();
                        }
                        lVar.j6(this.aM);
                        continue;
                    case 136:
                        this.DW = lVar.Zo();
                        continue;
                    case 146:
                        this.j3 = lVar.tp();
                        continue;
                    case 152:
                        j6 = lVar.VH();
                        switch (j6) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                this.Mr = j6;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        DW = w.DW(lVar, 160);
                        j6 = this.U2 == null ? 0 : this.U2.length;
                        obj = new int[(DW + j6)];
                        if (j6 != 0) {
                            System.arraycopy(this.U2, 0, obj, 0, j6);
                        }
                        while (j6 < obj.length - 1) {
                            obj[j6] = lVar.VH();
                            lVar.j6();
                            j6++;
                        }
                        obj[j6] = lVar.VH();
                        this.U2 = obj;
                        continue;
                    case 162:
                        int FH = lVar.FH(lVar.we());
                        DW = lVar.aM();
                        j6 = 0;
                        while (lVar.QX() > 0) {
                            lVar.VH();
                            j6++;
                        }
                        lVar.v5(DW);
                        DW = this.U2 == null ? 0 : this.U2.length;
                        Object obj2 = new int[(j6 + DW)];
                        if (DW != 0) {
                            System.arraycopy(this.U2, 0, obj2, 0, DW);
                        }
                        while (DW < obj2.length) {
                            obj2[DW] = lVar.VH();
                            DW++;
                        }
                        this.U2 = obj2;
                        lVar.Hw(FH);
                        continue;
                    case 168:
                        this.FH = lVar.Zo();
                        continue;
                    case 176:
                        this.a8 = lVar.Zo();
                        continue;
                    case 186:
                        if (this.lg == null) {
                            this.lg = new f();
                        }
                        lVar.j6(this.lg);
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
            if (this.j6 != 0) {
                mVar.DW(1, this.j6);
            }
            if (!this.Hw.equals("")) {
                mVar.j6(2, this.Hw);
            }
            if (this.gn != null && this.gn.length > 0) {
                for (t tVar : this.gn) {
                    if (tVar != null) {
                        mVar.j6(3, tVar);
                    }
                }
            }
            if (!Arrays.equals(this.tp, w.gn)) {
                mVar.j6(6, this.tp);
            }
            if (this.Ws != null) {
                mVar.j6(7, this.Ws);
            }
            if (!Arrays.equals(this.EQ, w.gn)) {
                mVar.j6(8, this.EQ);
            }
            if (this.u7 != null) {
                mVar.j6(9, this.u7);
            }
            if (this.VH) {
                mVar.j6(10, this.VH);
            }
            if (this.v5 != 0) {
                mVar.j6(11, this.v5);
            }
            if (this.Zo != 0) {
                mVar.j6(12, this.Zo);
            }
            if (!Arrays.equals(this.we, w.gn)) {
                mVar.j6(13, this.we);
            }
            if (!this.QX.equals("")) {
                mVar.j6(14, this.QX);
            }
            if (this.XL != 180000) {
                mVar.FH(15, this.XL);
            }
            if (this.aM != null) {
                mVar.j6(16, this.aM);
            }
            if (this.DW != 0) {
                mVar.DW(17, this.DW);
            }
            if (!Arrays.equals(this.j3, w.gn)) {
                mVar.j6(18, this.j3);
            }
            if (this.Mr != 0) {
                mVar.j6(19, this.Mr);
            }
            if (this.U2 != null && this.U2.length > 0) {
                while (i < this.U2.length) {
                    mVar.j6(20, this.U2[i]);
                    i++;
                }
            }
            if (this.FH != 0) {
                mVar.DW(21, this.FH);
            }
            if (this.a8 != 0) {
                mVar.DW(22, this.a8);
            }
            if (this.lg != null) {
                mVar.j6(23, this.lg);
            }
            super.j6(mVar);
        }
    }

    public static final class e extends n<e> {
        private static volatile e[] FH;
        public String DW;
        public String j6;

        public e() {
            DW();
        }

        public static e[] j6() {
            if (FH == null) {
                synchronized (r.FH) {
                    if (FH == null) {
                        FH = new e[0];
                    }
                }
            }
            return FH;
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        public e DW() {
            this.j6 = "";
            this.DW = "";
            this.J0 = null;
            this.J8 = -1;
            return this;
        }

        protected int FH() {
            int FH = super.FH();
            if (!this.j6.equals("")) {
                FH += m.DW(1, this.j6);
            }
            return !this.DW.equals("") ? FH + m.DW(2, this.DW) : FH;
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
            return (this.J0 == null || this.J0.DW()) ? eVar.J0 == null || eVar.J0.DW() : this.J0.equals(eVar.J0);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.DW == null ? 0 : this.DW.hashCode()) + (((this.j6 == null ? 0 : this.j6.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.J0 == null || this.J0.DW())) {
                i = this.J0.hashCode();
            }
            return hashCode + i;
        }

        public e j6(l lVar) {
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
                        if (!super.j6(lVar, j6)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void j6(m mVar) {
            if (!this.j6.equals("")) {
                mVar.j6(1, this.j6);
            }
            if (!this.DW.equals("")) {
                mVar.j6(2, this.DW);
            }
            super.j6(mVar);
        }
    }

    public static final class f extends n<f> {
        public int j6;

        public f() {
            j6();
        }

        public /* synthetic */ t DW(l lVar) {
            return j6(lVar);
        }

        protected int FH() {
            int FH = super.FH();
            return this.j6 != -1 ? FH + m.DW(1, this.j6) : FH;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.j6 == fVar.j6 ? (this.J0 == null || this.J0.DW()) ? fVar.J0 == null || fVar.J0.DW() : this.J0.equals(fVar.J0) : false;
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.j6) * 31;
            int hashCode2 = (this.J0 == null || this.J0.DW()) ? 0 : this.J0.hashCode();
            return hashCode2 + hashCode;
        }

        public f j6() {
            this.j6 = -1;
            this.J0 = null;
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
                            case -1:
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
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
                                this.j6 = j6;
                                break;
                            default:
                                continue;
                        }
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
            if (this.j6 != -1) {
                mVar.j6(1, this.j6);
            }
            super.j6(mVar);
        }
    }
}
