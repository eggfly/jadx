import com.aide.uidesigner.ProxyTextView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class apy extends aql {
    private aqc EQ;
    private apy$a J0;
    private apy$a J8;
    private int QX;
    private byte[] Ws;
    private boolean XL;
    private apl tp;
    private List<aqg> u7;
    private aqc we;

    public apy(aoh aoh) {
        this(aoh.v5());
    }

    public apy(any any) {
        super(any);
        this.u7 = new ArrayList();
        this.tp = new apl();
        this.Ws = new byte[256];
    }

    public void FH(aqg aqg) {
        aqg aqg2 = aqg;
        while (aqg2 instanceof aqj) {
            DW(aqg2);
            aqg2 = ((aqj) aqg2).gn();
            Zo(aqg2);
        }
        if (aqg2 instanceof aqc) {
            super.DW((aqc) aqg2);
        } else {
            DW(aqg2);
        }
    }

    public void Hw(aqg aqg) {
        aqg aqg2 = aqg;
        while (aqg2 instanceof aqj) {
            aqg2.we |= 4;
            if (this.XL) {
                DW(aqg2);
            }
            aqg2 = ((aqj) aqg2).gn();
            Zo(aqg2);
        }
        if (aqg2 instanceof aqc) {
            super.FH((aqc) aqg2);
        } else if (aqg2 instanceof aqk) {
            j6((aqk) aqg2);
        } else {
            aqg2.we |= 4;
        }
        if (aqg2.v_() != 1 && this.XL) {
            DW(aqg2);
        }
    }

    public void j6(aqi aqi) {
        super.j6(aqi);
        this.XL = DW(aqi.BOUNDARY);
    }

    public void j6(aqi aqi, boolean z) {
        super.j6(aqi, z);
        this.XL = DW(aqi.BOUNDARY);
    }

    public aqc Hw() {
        aqc Hw;
        do {
            Hw = super.Hw();
            if (Hw == null) {
                if (this.EQ != null) {
                    this.DW.j6(this, this.EQ, this.we);
                }
                return null;
            } else if ((Hw.we & 4) != 0) {
                j6(Hw.u7());
            } else {
                if (this.EQ == null) {
                    this.EQ = Hw;
                }
                this.we = Hw;
                this.tp.j6(Hw.u7());
                return Hw;
            }
        } while (!this.XL);
        return Hw;
    }

    public aqg v5() {
        this.QX = 0;
        apy$a apy_a = this.J8;
        while (apy_a != null) {
            byte[] bArr = apy_a.FH;
            int i = apy_a.Hw;
            while (i < bArr.length) {
                int j6 = j6(bArr, i);
                this.FH.Hw(bArr, j6);
                int i2 = j6 + 20;
                aqg aqg = (aqg) this.Hw.j6(this.FH);
                if (aqg == null || (aqg.we & 2) == 0) {
                    switch (j6(bArr, i, i2, apy_a) >>> 12) {
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            if (aqg == null) {
                                aqg = new aqk(this.FH);
                                aqg.we = 2;
                                this.Hw.j6((ant$a) aqg);
                                return j6(aqg);
                            } else if (aqg instanceof aqk) {
                                i = aqg.we | 2;
                                aqg.we = i;
                                if ((i & 4) == 0) {
                                    return j6(aqg);
                                }
                                if (this.XL) {
                                    return j6(aqg);
                                }
                            } else {
                                throw new alb((ans) aqg, 2);
                            }
                            break;
                        case 8:
                        case 10:
                            if (aqg == null) {
                                ant$a aqb = new aqb(this.FH);
                                aqb.we = 2;
                                this.Hw.j6(aqb);
                                return aqb;
                            } else if (aqg instanceof aqb) {
                                i = aqg.we | 2;
                                aqg.we = i;
                                if ((i & 4) == 0 || this.XL) {
                                    return aqg;
                                }
                            } else {
                                throw new alb((ans) aqg, 3);
                            }
                        case 14:
                            i = i2;
                            break;
                        default:
                            String str = JGitText.j6().corruptObjectInvalidMode3;
                            r5 = new Object[4];
                            r5[0] = String.format("%o", new Object[]{Integer.valueOf(i)});
                            r5[1] = this.FH.DW();
                            r5[2] = axe.FH(bArr, apy_a.v5, apy_a.Zo);
                            r5[3] = apy_a.DW;
                            throw new ala(MessageFormat.format(str, r5));
                    }
                    i = i2;
                } else {
                    i = i2;
                }
            }
            this.J8 = apy_a.j6;
            DW(apy_a);
            apy_a = this.J8;
        }
        while (true) {
            aqg j62 = this.tp.j6();
            if (j62 == null) {
                this.DW.DW();
                return null;
            }
            j6 = j62.we;
            if ((j6 & 2) == 0) {
                j6 |= 2;
                j62.we = j6;
                if ((((j6 & 4) == 0 ? 1 : 0) | this.XL) != 0) {
                    if (j62 instanceof aqk) {
                        apy$a gn = gn(j62);
                        gn.j6 = null;
                        this.J8 = gn;
                    }
                    return j62;
                }
            }
        }
    }

    private aqg j6(aqg aqg) {
        apy$a gn = gn(aqg);
        gn.j6 = this.J8;
        this.J8 = gn;
        return aqg;
    }

    private static int j6(byte[] bArr, int i) {
        do {
            int i2 = i + 1;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i2++;
            if (bArr[i2] == null) {
                return i2 + 1;
            }
            i = i2 + 1;
        } while (bArr[i] != null);
        return i + 1;
    }

    private static int j6(byte[] bArr, int i, int i2, apy$a apy_a) {
        int i3 = bArr[i] - 48;
        while (true) {
            i++;
            byte b = bArr[i];
            if ((byte) 32 != b) {
                i3 = (i3 << 3) + (b - 48);
                i++;
                b = bArr[i];
                if ((byte) 32 == b) {
                    break;
                }
                i3 = (i3 << 3) + (b - 48);
                i++;
                b = bArr[i];
                if ((byte) 32 == b) {
                    break;
                }
                i3 = (i3 << 3) + (b - 48);
                i++;
                b = bArr[i];
                if ((byte) 32 == b) {
                    break;
                }
                i3 = (i3 << 3) + (b - 48);
                i++;
                b = bArr[i];
                if ((byte) 32 == b) {
                    break;
                }
                i3 = (i3 << 3) + (b - 48);
                i++;
                b = bArr[i];
                if ((byte) 32 == b) {
                    break;
                }
                i3 = (i3 << 3) + (b - 48);
                i++;
                b = bArr[i];
                if ((byte) 32 == b) {
                    break;
                }
                i3 = (i3 << 3) + (b - 48);
            } else {
                break;
            }
        }
        apy_a.Hw = i2;
        apy_a.v5 = i + 1;
        apy_a.Zo = i2 - 21;
        return i3;
    }

    public void Zo() {
        ans v5;
        do {
        } while (Hw() != null);
        while (true) {
            v5 = v5();
            if (v5 != null) {
                if ((v5 instanceof aqb) && !this.DW.DW(v5)) {
                    break;
                }
            } else {
                return;
            }
        }
        throw new ali(v5, 3);
    }

    public int VH() {
        apy$a apy_a = this.J8;
        if (apy_a == null) {
            return 0;
        }
        byte[] bArr;
        int i;
        int i2 = apy_a.Zo;
        if (i2 == 0) {
            apy_a = apy_a.j6;
            if (apy_a == null) {
                return 0;
            }
            i2 = apy_a.Zo;
        }
        if (16 <= i2 - apy_a.v5) {
            bArr = apy_a.FH;
            i = i2;
            i2 -= 16;
        } else {
            i2 = this.QX;
            if (i2 == 0) {
                i2 = j6(this.J8);
                this.QX = i2;
            }
            byte[] bArr2 = this.Ws;
            bArr = bArr2;
            i = i2;
            i2 = Math.max(0, i2 - 16);
        }
        i2 = 0;
        for (int i3 = i2; i3 < i; i3++) {
            byte b = bArr[i3];
            if (b != 32) {
                i2 = (i2 >>> 2) + (b << 24);
            }
        }
        return i2;
    }

    public byte[] gn() {
        if (this.QX == 0) {
            this.QX = j6(this.J8);
        }
        return this.Ws;
    }

    public int u7() {
        if (this.QX == 0) {
            this.QX = j6(this.J8);
        }
        return this.QX;
    }

    private int j6(apy$a apy_a) {
        if (apy_a == null) {
            return 0;
        }
        int i = apy_a.Zo;
        if (i == 0) {
            return j6(apy_a.j6);
        }
        int j6;
        int i2 = apy_a.VH;
        if (i2 == 0) {
            j6 = j6(apy_a.j6);
            if (j6 == this.Ws.length) {
                FH(j6);
            }
            if (j6 != 0) {
                i2 = j6 + 1;
                this.Ws[j6] = (byte) 47;
            } else {
                i2 = j6;
            }
            apy_a.VH = i2;
        }
        int i3 = apy_a.v5;
        i -= i3;
        j6 = i2 + i;
        while (this.Ws.length < j6) {
            FH(i2);
        }
        System.arraycopy(apy_a.FH, i3, this.Ws, i2, i);
        return j6;
    }

    private void FH(int i) {
        Object obj = new byte[(this.Ws.length << 1)];
        System.arraycopy(this.Ws, 0, obj, 0, i);
        this.Ws = obj;
    }

    public void tp() {
        super.tp();
        this.tp = new apl();
        this.EQ = null;
        this.we = null;
        this.J8 = null;
        this.J0 = null;
    }

    protected void j6(int i) {
        super.j6(i);
        for (aqg aqg : this.u7) {
            aqg.we &= -9;
        }
        this.u7 = new ArrayList();
        this.tp = new apl();
        this.EQ = null;
        this.we = null;
        this.J8 = null;
        this.J0 = null;
    }

    private void DW(aqg aqg) {
        if ((aqg.we & 8) == 0) {
            aqg.we |= 8;
            this.u7.add(aqg);
            this.tp.j6(aqg);
        }
    }

    private void j6(aqk aqk) {
        if ((aqk.we & 4) == 0) {
            aqk.we |= 4;
            byte[] v5 = this.DW.FH(aqk, 2).v5();
            int i = 0;
            while (i < v5.length) {
                int i2 = i;
                i = v5[i] - 48;
                while (true) {
                    i2++;
                    byte b = v5[i2];
                    if (32 == b) {
                        do {
                            i2++;
                        } while (v5[i2] != null);
                        i2++;
                        switch (i >>> 12) {
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                                this.FH.Hw(v5, i2);
                                j6(FH(this.FH));
                                break;
                            case 8:
                            case 10:
                                this.FH.Hw(v5, i2);
                                aqb DW = DW(this.FH);
                                DW.we |= 4;
                                break;
                            case 14:
                                break;
                            default:
                                this.FH.Hw(v5, i2);
                                String str = JGitText.j6().corruptObjectInvalidMode3;
                                r4 = new Object[4];
                                r4[0] = String.format("%o", new Object[]{Integer.valueOf(i)});
                                r4[1] = this.FH.DW();
                                r4[2] = "";
                                r4[3] = aqk;
                                throw new ala(MessageFormat.format(str, r4));
                        }
                        i = i2 + 20;
                    } else {
                        i = (i << 3) + (b - 48);
                    }
                }
            }
        }
    }

    private apy$a gn(aqg aqg) {
        apy$a apy_a = this.J0;
        if (apy_a != null) {
            this.J0 = apy_a.j6;
            apy_a.Hw = 0;
            apy_a.v5 = 0;
            apy_a.Zo = 0;
            apy_a.VH = 0;
        } else {
            apy_a = new apy$a();
        }
        apy_a.DW = aqg;
        apy_a.FH = this.DW.FH(aqg, 2).v5();
        return apy_a;
    }

    private void DW(apy$a apy_a) {
        apy_a.FH = null;
        apy_a.j6 = this.J0;
        this.J0 = apy_a;
    }
}
