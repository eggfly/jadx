import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class apg extends ajt {
    private static final byte[] BT;
    static final byte[] EQ;
    static final byte[] J0;
    static final byte[] J8;
    private static final byte[] Mr;
    private static final byte[] U2;
    private static final byte[] a8;
    private static final byte[] er;
    private static final byte[] gW;
    private static final byte[] j3;
    private static final byte[] lg;
    private static final byte[] rN;
    static final byte[] tp;
    static final byte[] we;
    private static final byte[] yS;
    final int QX;
    final byte[] Ws;
    int XL;
    apg$a aM;
    private List<aph> vy;

    static {
        j3 = anj.j6("old mode ");
        Mr = anj.j6("new mode ");
        tp = anj.j6("deleted file mode ");
        EQ = anj.j6("new file mode ");
        U2 = anj.j6("copy from ");
        a8 = anj.j6("copy to ");
        lg = anj.j6("rename old ");
        rN = anj.j6("rename new ");
        er = anj.j6("rename from ");
        yS = anj.j6("rename to ");
        gW = anj.j6("similarity index ");
        BT = anj.j6("dissimilarity index ");
        we = anj.j6("index ");
        J0 = anj.j6("--- ");
        J8 = anj.j6("+++ ");
    }

    public apg(byte[] bArr, ajw ajw, apg$a apg_a) {
        this(bArr, 0);
        this.XL = bArr.length;
        DW(j6(api.j6.length, bArr.length), bArr.length);
        this.aM = apg_a;
        j6(new aph(this, ajw));
    }

    apg(byte[] bArr, int i) {
        this.Ws = bArr;
        this.QX = i;
        this.Zo = ajt$a.MODIFY;
        this.aM = apg$a.UNIFIED;
    }

    public byte[] tp() {
        return this.Ws;
    }

    public int EQ() {
        return this.QX;
    }

    public int we() {
        return this.XL;
    }

    public apg$a J0() {
        return this.aM;
    }

    public List<? extends aph> J8() {
        if (this.vy == null) {
            return Collections.emptyList();
        }
        return this.vy;
    }

    void j6(aph aph) {
        if (aph.j6() != this) {
            throw new IllegalArgumentException(JGitText.j6().hunkBelongsToAnotherFile);
        }
        if (this.vy == null) {
            this.vy = new ArrayList();
        }
        this.vy.add(aph);
    }

    public ajw Ws() {
        ajw ajw = new ajw();
        for (aph Zo : this.vy) {
            ajw.addAll(Zo.Zo());
        }
        return ajw;
    }

    int j6(int i, int i2) {
        int Hw = axe.Hw(this.Ws, i);
        if (Hw >= i2) {
            return -1;
        }
        int DW = axe.DW(this.Ws, i, '/');
        if (DW >= Hw) {
            return Hw;
        }
        int i3 = i;
        while (i3 < Hw) {
            i3 = axe.DW(this.Ws, i3, ' ');
            if (i3 >= Hw) {
                return Hw;
            }
            int DW2 = axe.DW(this.Ws, i3, '/');
            if (DW2 >= Hw) {
                return Hw;
            }
            if (j6(DW, i3 - 1, DW2, Hw - 1)) {
                if (this.Ws[i] != (byte) 34) {
                    this.DW = axe.j6(anj.DW, this.Ws, DW, i3 - 1);
                } else if (this.Ws[i3 - 2] != (byte) 34) {
                    return Hw;
                } else {
                    this.DW = axc.j6.j6(this.Ws, i, i3 - 1);
                    this.DW = j6(this.DW);
                }
                this.FH = this.DW;
                return Hw;
            }
        }
        return Hw;
    }

    int DW(int i, int i2) {
        while (i < i2) {
            int Hw = axe.Hw(this.Ws, i);
            if (j6(this.Ws, i, Hw) >= 1) {
                break;
            }
            if (axe.j6(this.Ws, i, J0) < 0) {
                if (axe.j6(this.Ws, i, J8) < 0) {
                    if (axe.j6(this.Ws, i, j3) < 0) {
                        if (axe.j6(this.Ws, i, Mr) < 0) {
                            if (axe.j6(this.Ws, i, tp) < 0) {
                                if (axe.j6(this.Ws, i, EQ) < 0) {
                                    if (axe.j6(this.Ws, i, U2) < 0) {
                                        if (axe.j6(this.Ws, i, a8) < 0) {
                                            if (axe.j6(this.Ws, i, lg) < 0) {
                                                if (axe.j6(this.Ws, i, rN) < 0) {
                                                    if (axe.j6(this.Ws, i, er) < 0) {
                                                        if (axe.j6(this.Ws, i, yS) < 0) {
                                                            if (axe.j6(this.Ws, i, gW) < 0) {
                                                                if (axe.j6(this.Ws, i, BT) < 0) {
                                                                    if (axe.j6(this.Ws, i, we) < 0) {
                                                                        break;
                                                                    }
                                                                    VH(we.length + i, Hw);
                                                                } else {
                                                                    this.VH = axe.j6(this.Ws, BT.length + i, null);
                                                                }
                                                            } else {
                                                                this.VH = axe.j6(this.Ws, gW.length + i, null);
                                                            }
                                                        } else {
                                                            this.FH = j6(this.FH, yS.length + i, Hw);
                                                            this.Zo = ajt$a.RENAME;
                                                        }
                                                    } else {
                                                        this.DW = j6(this.DW, er.length + i, Hw);
                                                        this.Zo = ajt$a.RENAME;
                                                    }
                                                } else {
                                                    this.FH = j6(this.FH, rN.length + i, Hw);
                                                    this.Zo = ajt$a.RENAME;
                                                }
                                            } else {
                                                this.DW = j6(this.DW, lg.length + i, Hw);
                                                this.Zo = ajt$a.RENAME;
                                            }
                                        } else {
                                            this.FH = j6(this.FH, a8.length + i, Hw);
                                            this.Zo = ajt$a.COPY;
                                        }
                                    } else {
                                        this.DW = j6(this.DW, U2.length + i, Hw);
                                        this.Zo = ajt$a.COPY;
                                    }
                                } else {
                                    v5(i, Hw);
                                }
                            } else {
                                this.Hw = Zo(tp.length + i, Hw);
                                this.v5 = anl.Zo;
                                this.Zo = ajt$a.DELETE;
                            }
                        } else {
                            this.v5 = Zo(Mr.length + i, Hw);
                        }
                    } else {
                        this.Hw = Zo(j3.length + i, Hw);
                    }
                } else {
                    Hw(i, Hw);
                }
            } else {
                FH(i, Hw);
            }
            i = Hw;
        }
        return i;
    }

    void FH(int i, int i2) {
        this.DW = j6(j6(this.DW, J0.length + i, i2));
        if (this.DW == "/dev/null") {
            this.Zo = ajt$a.ADD;
        }
    }

    void Hw(int i, int i2) {
        this.FH = j6(j6(this.FH, J8.length + i, i2));
        if (this.FH == "/dev/null") {
            this.Zo = ajt$a.DELETE;
        }
    }

    void v5(int i, int i2) {
        this.Hw = anl.Zo;
        this.v5 = Zo(EQ.length + i, i2);
        this.Zo = ajt$a.ADD;
    }

    private String j6(String str, int i, int i2) {
        if (i == i2) {
            return str;
        }
        String j6;
        if (this.Ws[i] == 34) {
            j6 = axc.j6.j6(this.Ws, i, i2 - 1);
        } else {
            int i3 = i2;
            while (i < i3 && this.Ws[i3 - 1] != 9) {
                i3--;
            }
            if (i != i3) {
                i2 = i3;
            }
            j6 = axe.j6(anj.DW, this.Ws, i, i2 - 1);
        }
        if (j6.equals("/dev/null")) {
            j6 = "/dev/null";
        }
        return j6;
    }

    private static String j6(String str) {
        int indexOf = str.indexOf(47);
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    anl Zo(int i, int i2) {
        int i3 = 0;
        while (i < i2 - 1) {
            i3 = (i3 << 3) + (this.Ws[i] - 48);
            i++;
        }
        return anl.j6(i3);
    }

    void VH(int i, int i2) {
        int DW = axe.DW(this.Ws, i, '.');
        int DW2 = axe.DW(this.Ws, DW, ' ');
        this.gn = amz.j6(this.Ws, i, DW - 1);
        this.u7 = amz.j6(this.Ws, DW + 1, DW2 - 1);
        if (DW2 < i2) {
            anl Zo = Zo(DW2, i2);
            this.Hw = Zo;
            this.v5 = Zo;
        }
    }

    private boolean j6(int i, int i2, int i3, int i4) {
        if (i2 - i != i4 - i3) {
            return false;
        }
        while (i < i2) {
            int i5 = i + 1;
            int i6 = i3 + 1;
            if (this.Ws[i] != this.Ws[i3]) {
                return false;
            }
            i3 = i6;
            i = i5;
        }
        return true;
    }

    static int j6(byte[] bArr, int i, int i2) {
        int i3 = i;
        while (i3 < i2 && bArr[i3] == 64) {
            i3++;
        }
        if (i3 - i < 2 || i3 == i2) {
            return 0;
        }
        int i4 = i3 + 1;
        if (bArr[i3] != 32 || i4 == i2) {
            return 0;
        }
        i3 = i4 + 1;
        if (bArr[i4] == 45) {
            return (i3 - 3) - i;
        }
        return 0;
    }
}
