package com.jcraft.jsch.jcraft;

import agx;
import com.aide.uidesigner.ProxyTextView;

public class Compression implements com.jcraft.jsch.Compression {
    private int DW;
    private agx FH;
    private byte[] Hw;
    private final int j6;
    private byte[] v5;

    public Compression() {
        this.j6 = 52;
        this.Hw = new byte[4096];
        this.FH = new agx();
    }

    public void j6(int i, int i2) {
        if (i == 1) {
            this.FH.FH(i2);
            this.DW = 1;
        } else if (i == 0) {
            this.FH.j6();
            this.v5 = new byte[4096];
            this.DW = 0;
        }
    }

    public byte[] j6(byte[] bArr, int i, int[] iArr) {
        this.FH.j6 = bArr;
        this.FH.DW = i;
        this.FH.FH = iArr[0] - i;
        do {
            this.FH.v5 = this.Hw;
            this.FH.Zo = 0;
            this.FH.VH = 4096;
            int Hw = this.FH.Hw(1);
            switch (Hw) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    int i2 = 4096 - this.FH.VH;
                    if (bArr.length < (i + i2) + 52) {
                        Object obj = new byte[(((i + i2) + 52) * 2)];
                        System.arraycopy(bArr, 0, obj, 0, bArr.length);
                        bArr = obj;
                    }
                    System.arraycopy(this.Hw, 0, bArr, i, i2);
                    i += i2;
                    break;
                default:
                    System.err.println("compress: deflate returnd " + Hw);
                    break;
            }
        } while (this.FH.VH == 0);
        iArr[0] = i;
        return bArr;
    }

    public byte[] DW(byte[] bArr, int i, int[] iArr) {
        this.FH.j6 = bArr;
        this.FH.DW = i;
        this.FH.FH = iArr[0];
        int i2 = 0;
        while (true) {
            this.FH.v5 = this.Hw;
            this.FH.Zo = 0;
            this.FH.VH = 4096;
            int DW = this.FH.DW(1);
            Object obj;
            switch (DW) {
                case -5:
                    if (i2 > bArr.length - i) {
                        obj = new byte[(i2 + i)];
                        System.arraycopy(bArr, 0, obj, 0, i);
                        System.arraycopy(this.v5, 0, obj, i, i2);
                        bArr = obj;
                    } else {
                        System.arraycopy(this.v5, 0, bArr, i, i2);
                    }
                    iArr[0] = i2;
                    return bArr;
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    if (this.v5.length < (i2 + 4096) - this.FH.VH) {
                        DW = this.v5.length * 2;
                        if (DW < (i2 + 4096) - this.FH.VH) {
                            DW = (i2 + 4096) - this.FH.VH;
                        }
                        obj = new byte[DW];
                        System.arraycopy(this.v5, 0, obj, 0, i2);
                        this.v5 = obj;
                    }
                    System.arraycopy(this.Hw, 0, this.v5, i2, 4096 - this.FH.VH);
                    i2 += 4096 - this.FH.VH;
                    iArr[0] = i2;
                default:
                    System.err.println("uncompress: inflate returnd " + DW);
                    return null;
            }
        }
    }
}
