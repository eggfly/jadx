import java.io.Writer;
import java.security.MessageDigest;
import java.util.zip.Adler32;

public final class wq {
    private final xk DW;
    private final wm EQ;
    private final xk FH;
    private final xk Hw;
    private final xk J0;
    private final wz J8;
    private int QX;
    private final xv VH;
    private final xp[] Ws;
    private int XL;
    private final xt Zo;
    private final xo gn;
    private tq j6;
    private final xj tp;
    private final wx u7;
    private final xk v5;
    private final xk we;

    public wq(tq tqVar) {
        this.j6 = tqVar;
        this.J8 = new wz(this);
        this.FH = new xk(null, this, 4, xk$a.NONE);
        this.DW = new xk("word_data", this, 4, xk$a.TYPE);
        this.v5 = new xk("string_data", this, 1, xk$a.INSTANCE);
        this.we = new xk(null, this, 1, xk$a.NONE);
        this.J0 = new xk("byte_data", this, 1, xk$a.TYPE);
        this.Zo = new xt(this);
        this.VH = new xv(this);
        this.gn = new xo(this);
        this.u7 = new wx(this);
        this.tp = new xj(this);
        this.EQ = new wm(this);
        this.Hw = new xk("map", this, 4, xk$a.NONE);
        this.Ws = new xp[]{this.J8, this.Zo, this.VH, this.gn, this.u7, this.tp, this.EQ, this.DW, this.FH, this.v5, this.J0, this.we, this.Hw};
        this.QX = -1;
        this.XL = 79;
    }

    public tq j6() {
        return this.j6;
    }

    public void j6(wl wlVar) {
        this.EQ.j6(wlVar);
    }

    public byte[] j6(Writer writer, boolean z) {
        boolean z2 = writer != null;
        acv j6 = j6(z2, z);
        if (z2) {
            j6.j6(writer);
        }
        return j6.v5();
    }

    int DW() {
        if (this.QX >= 0) {
            return this.QX;
        }
        throw new RuntimeException("file size not yet known");
    }

    xk FH() {
        return this.v5;
    }

    xk Hw() {
        return this.DW;
    }

    xk v5() {
        return this.FH;
    }

    xk Zo() {
        return this.Hw;
    }

    xt VH() {
        return this.Zo;
    }

    wm gn() {
        return this.EQ;
    }

    xk u7() {
        return this.we;
    }

    xv tp() {
        return this.VH;
    }

    xo EQ() {
        return this.gn;
    }

    wx we() {
        return this.u7;
    }

    xj J0() {
        return this.tp;
    }

    xk J8() {
        return this.J0;
    }

    xp Ws() {
        return this.DW;
    }

    xp QX() {
        return this.Hw;
    }

    void j6(aah aah) {
        if (aah instanceof abe) {
            this.Zo.j6((abe) aah);
        } else if (aah instanceof abf) {
            this.VH.j6((abf) aah);
        } else if (aah instanceof aal) {
            this.tp.j6((aal) aah);
        } else if (aah instanceof aar) {
            this.u7.j6((aar) aah);
        } else if (aah instanceof aaq) {
            this.u7.j6(((aaq) aah).u7());
        } else if (aah == null) {
            throw new NullPointerException("cst == null");
        }
    }

    xb DW(aah aah) {
        if (aah instanceof abe) {
            return this.Zo.j6(aah);
        }
        if (aah instanceof abf) {
            return this.VH.j6(aah);
        }
        if (aah instanceof aal) {
            return this.tp.j6(aah);
        }
        if (aah instanceof aar) {
            return this.u7.j6(aah);
        }
        return null;
    }

    private acv j6(boolean z, boolean z2) {
        ada ada;
        int i = 0;
        this.EQ.gn();
        this.we.gn();
        this.DW.gn();
        this.J0.gn();
        this.tp.gn();
        this.u7.gn();
        this.gn.gn();
        this.FH.gn();
        this.VH.gn();
        this.Zo.gn();
        this.v5.gn();
        this.J8.gn();
        int length = this.Ws.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            xp xpVar = this.Ws[i2];
            int DW = xpVar.DW(i3);
            if (DW < i3) {
                throw new RuntimeException("bogus placement for section " + i2);
            }
            try {
                if (xpVar == this.Hw) {
                    xe.j6(this.Ws, this.Hw);
                    this.Hw.gn();
                }
                if (xpVar instanceof xk) {
                    ((xk) xpVar).Hw();
                }
                i2++;
                i3 = DW + xpVar.o_();
            } catch (Throwable e) {
                throw ada.j6(e, "...while writing section " + i2);
            }
        }
        this.QX = i3;
        byte[] bArr = new byte[this.QX];
        acr acv = new acv(bArr);
        if (z) {
            acv.j6(this.XL, z2);
        }
        while (i < length) {
            xp xpVar2 = this.Ws[i];
            DW = xpVar2.VH() - acv.VH();
            if (DW < 0) {
                throw new ada("excess write of " + (-DW));
            }
            try {
                acv.VH(xpVar2.VH() - acv.VH());
                xpVar2.FH(acv);
                i++;
            } catch (Throwable e2) {
                if (e2 instanceof ada) {
                    ada = (ada) e2;
                } else {
                    ada = new ada(e2);
                }
                ada.j6("...while writing section " + i);
                throw ada;
            }
        }
        if (acv.VH() != this.QX) {
            throw new RuntimeException("foreshortened write");
        }
        j6(bArr);
        DW(bArr);
        if (z) {
            this.DW.j6(acv, xd.TYPE_CODE_ITEM, "\nmethod code index:\n\n");
            XL().j6(acv);
            acv.gn();
        }
        return acv;
    }

    public xq XL() {
        xq xqVar = new xq();
        for (xp j6 : this.Ws) {
            xqVar.j6(j6);
        }
        return xqVar;
    }

    private static void j6(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr, 32, bArr.length - 32);
            try {
                int digest = instance.digest(bArr, 12, 20);
                if (digest != 20) {
                    throw new RuntimeException("unexpected digest write: " + digest + " bytes");
                }
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void DW(byte[] bArr) {
        Adler32 adler32 = new Adler32();
        adler32.update(bArr, 12, bArr.length - 12);
        int value = (int) adler32.getValue();
        bArr[8] = (byte) value;
        bArr[9] = (byte) (value >> 8);
        bArr[10] = (byte) (value >> 16);
        bArr[11] = (byte) (value >> 24);
    }
}
