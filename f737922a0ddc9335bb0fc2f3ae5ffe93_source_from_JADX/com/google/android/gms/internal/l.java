package com.google.android.gms.internal;

import com.aide.uidesigner.ProxyTextView;

public final class l {
    private int DW;
    private int FH;
    private int Hw;
    private int VH;
    private int Zo;
    private int gn;
    private final byte[] j6;
    private int tp;
    private int u7;
    private int v5;

    private l(byte[] bArr, int i, int i2) {
        this.VH = Integer.MAX_VALUE;
        this.u7 = 64;
        this.tp = 67108864;
        this.j6 = bArr;
        this.DW = i;
        this.FH = i + i2;
        this.v5 = i;
    }

    private void Mr() {
        this.FH += this.Hw;
        int i = this.FH;
        if (i > this.VH) {
            this.Hw = i - this.VH;
            this.FH -= this.Hw;
            return;
        }
        this.Hw = 0;
    }

    public static long j6(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static l j6(byte[] bArr) {
        return j6(bArr, 0, bArr.length);
    }

    public static l j6(byte[] bArr, int i, int i2) {
        return new l(bArr, i, i2);
    }

    public void DW() {
        int j6;
        do {
            j6 = j6();
            if (j6 == 0) {
                return;
            }
        } while (DW(j6));
    }

    public boolean DW(int i) {
        switch (w.j6(i)) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                VH();
                return true;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                Ws();
                return true;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                Zo(we());
                return true;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                DW();
                j6(w.j6(w.DW(i), 4));
                return true;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return false;
            case 5:
                J8();
                return true;
            default:
                throw s.Zo();
        }
    }

    public long EQ() {
        return j6(J0());
    }

    public double FH() {
        return Double.longBitsToDouble(Ws());
    }

    public int FH(int i) {
        if (i < 0) {
            throw s.DW();
        }
        int i2 = this.v5 + i;
        int i3 = this.VH;
        if (i2 > i3) {
            throw s.j6();
        }
        this.VH = i2;
        Mr();
        return i3;
    }

    public float Hw() {
        return Float.intBitsToFloat(J8());
    }

    public void Hw(int i) {
        this.VH = i;
        Mr();
    }

    public long J0() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte j3 = j3();
            j |= ((long) (j3 & 127)) << i;
            if ((j3 & 128) == 0) {
                return j;
            }
        }
        throw s.FH();
    }

    public int J8() {
        return (((j3() & 255) | ((j3() & 255) << 8)) | ((j3() & 255) << 16)) | ((j3() & 255) << 24);
    }

    public int QX() {
        if (this.VH == Integer.MAX_VALUE) {
            return -1;
        }
        return this.VH - this.v5;
    }

    public int VH() {
        return we();
    }

    public long Ws() {
        byte j3 = j3();
        byte j32 = j3();
        return ((((((((((long) j32) & 255) << 8) | (((long) j3) & 255)) | ((((long) j3()) & 255) << 16)) | ((((long) j3()) & 255) << 24)) | ((((long) j3()) & 255) << 32)) | ((((long) j3()) & 255) << 40)) | ((((long) j3()) & 255) << 48)) | ((((long) j3()) & 255) << 56);
    }

    public boolean XL() {
        return this.v5 == this.FH;
    }

    public long Zo() {
        return J0();
    }

    public void Zo(int i) {
        if (i < 0) {
            throw s.DW();
        } else if (this.v5 + i > this.VH) {
            Zo(this.VH - this.v5);
            throw s.j6();
        } else if (i <= this.FH - this.v5) {
            this.v5 += i;
        } else {
            throw s.j6();
        }
    }

    public int aM() {
        return this.v5 - this.DW;
    }

    public boolean gn() {
        return we() != 0;
    }

    public byte j3() {
        if (this.v5 == this.FH) {
            throw s.j6();
        }
        byte[] bArr = this.j6;
        int i = this.v5;
        this.v5 = i + 1;
        return bArr[i];
    }

    public int j6() {
        if (XL()) {
            this.Zo = 0;
            return 0;
        }
        this.Zo = we();
        if (this.Zo != 0) {
            return this.Zo;
        }
        throw s.Hw();
    }

    public void j6(int i) {
        if (this.Zo != i) {
            throw s.v5();
        }
    }

    public void j6(t tVar) {
        int we = we();
        if (this.gn >= this.u7) {
            throw s.VH();
        }
        we = FH(we);
        this.gn++;
        tVar.DW(this);
        j6(0);
        this.gn--;
        Hw(we);
    }

    public byte[] j6(int i, int i2) {
        if (i2 == 0) {
            return w.gn;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.j6, this.DW + i, obj, 0, i2);
        return obj;
    }

    public byte[] tp() {
        int we = we();
        if (we < 0) {
            throw s.DW();
        } else if (we == 0) {
            return w.gn;
        } else {
            if (we > this.FH - this.v5) {
                throw s.j6();
            }
            Object obj = new byte[we];
            System.arraycopy(this.j6, this.v5, obj, 0, we);
            this.v5 = we + this.v5;
            return obj;
        }
    }

    public String u7() {
        int we = we();
        if (we < 0) {
            throw s.DW();
        } else if (we > this.FH - this.v5) {
            throw s.j6();
        } else {
            String str = new String(this.j6, this.v5, we, r.j6);
            this.v5 = we + this.v5;
            return str;
        }
    }

    public long v5() {
        return J0();
    }

    public void v5(int i) {
        if (i > this.v5 - this.DW) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.v5 - this.DW));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.v5 = this.DW + i;
        }
    }

    public int we() {
        byte j3 = j3();
        if (j3 >= null) {
            return j3;
        }
        int i = j3 & 127;
        byte j32 = j3();
        if (j32 >= null) {
            return i | (j32 << 7);
        }
        i |= (j32 & 127) << 7;
        j32 = j3();
        if (j32 >= null) {
            return i | (j32 << 14);
        }
        i |= (j32 & 127) << 14;
        j32 = j3();
        if (j32 >= null) {
            return i | (j32 << 21);
        }
        i |= (j32 & 127) << 21;
        j32 = j3();
        i |= j32 << 28;
        if (j32 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (j3() >= null) {
                return i;
            }
        }
        throw s.FH();
    }
}
