import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;

class asr {
    private final asl DW;
    private axj$c EQ;
    private final any FH;
    private final ass[] Hw;
    private Deflater J0;
    private long VH;
    private final int Zo;
    private int gn;
    private final asw j6;
    private ass tp;
    private int u7;
    private final long v5;
    private int we;

    asr(asw asw, asl asl, any any) {
        this.j6 = asw;
        this.DW = asl;
        this.FH = any;
        this.Hw = new ass[(this.j6.Zo() + 1)];
        for (int i = 0; i < this.Hw.length; i++) {
            this.Hw[i] = new ass();
        }
        this.v5 = this.j6.VH();
        this.Zo = this.j6.v5();
    }

    void j6(aob aob, asv[] asvArr, int i, int i2) {
        int i3 = i + i2;
        while (i < i3) {
            try {
                this.tp = this.Hw[this.gn];
                if (0 < this.v5) {
                    j6(this.tp);
                    int DW = DW(this.gn);
                    long j6 = j6(asvArr[i]);
                    while (this.v5 < this.VH + j6 && DW != this.gn) {
                        j6(this.Hw[DW]);
                        DW = DW(DW);
                    }
                }
                this.tp.j6(asvArr[i]);
                if (this.tp.j6.U2()) {
                    FH();
                } else {
                    aob.j6(1);
                    j6();
                }
                i++;
            } catch (Throwable th) {
                if (this.J0 != null) {
                    this.J0.end();
                }
            }
        }
        if (this.J0 != null) {
            this.J0.end();
        }
    }

    private static long j6(asv asv) {
        return asn.j6(asv.lg());
    }

    private void j6(ass ass) {
        if (ass.FH != null) {
            this.VH -= ass.FH.DW();
        } else if (this.tp.DW != null) {
            this.VH -= (long) ass.DW.length;
        }
        ass.j6(null);
    }

    private void j6() {
        this.u7 = this.Zo;
        int FH = FH(this.gn);
        while (FH != this.gn) {
            ass ass = this.Hw[FH];
            if (ass.Hw()) {
                break;
            } else if (j6(ass, FH) == 0) {
                this.EQ = null;
                return;
            } else {
                FH = FH(FH);
            }
        }
        if (this.EQ == null) {
            FH();
            return;
        }
        ans ans = this.Hw[this.we].j6;
        asv asv = this.tp.j6;
        if (ans.U2()) {
            asv.DW(ans.Hw());
        } else {
            asv.DW(ans);
        }
        asv.DW(ans.Ws() + 1);
        asv.VH();
        j6((asv) ans, asv);
        this.EQ = null;
        if (asv.Ws() != this.Zo) {
            DW();
            FH();
        }
    }

    private int j6(ass ass, int i) {
        int i2 = 0;
        if (ass.DW() != this.tp.DW()) {
            FH();
            return i2;
        } else if (ass.j6() > this.u7) {
            return 1;
        } else {
            int j6 = j6(this.tp, this.u7, ass);
            if (j6 <= 8) {
                return 1;
            }
            if (this.tp.FH() - ass.FH() > j6) {
                return 1;
            }
            if (this.tp.FH() < ass.FH() / 16) {
                return 1;
            }
            try {
                asn DW = DW(ass);
                try {
                    byte[] FH = FH(this.tp);
                    if (this.EQ != null && this.EQ.DW() < ((long) j6)) {
                        j6 = (int) this.EQ.DW();
                    }
                    axj$c axj_c = new axj$c(j6);
                    try {
                        if (!DW.j6((OutputStream) axj_c, FH, j6)) {
                            return 1;
                        }
                        if (j6(ass, axj_c)) {
                            this.EQ = axj_c;
                            this.we = i;
                        }
                        return 1;
                    } catch (IOException e) {
                        return 1;
                    }
                } catch (alf e2) {
                    return i2;
                }
            } catch (alf e3) {
                Hw(i);
                return 1;
            } catch (IOException e4) {
                if (ass.j6.U2()) {
                    Hw(i);
                    return 1;
                }
                throw e4;
            }
        }
    }

    private void j6(asv asv, asv asv2) {
        if (2147483647L >= this.EQ.DW()) {
            int DW = (int) this.EQ.DW();
            if (this.DW.j6(DW, asv, asv2)) {
                try {
                    byte[] bArr = new byte[j6(DW)];
                    OutputStream asr_a = new asr$a(Hw(), bArr);
                    this.EQ.j6(asr_a, null);
                    this.EQ = null;
                    asv2.j6(this.DW.j6(bArr, asr_a.j6(), DW));
                    asv2.v5(DW);
                } catch (IOException e) {
                    this.DW.j6(DW);
                } catch (OutOfMemoryError e2) {
                    this.DW.j6(DW);
                }
            }
        }
    }

    private static int j6(int i) {
        return ((((i + 7) >> 3) + i) + ((i + 63) >> 6)) + 11;
    }

    private void DW() {
        this.Hw[this.gn] = this.Hw[this.we];
        ass ass = this.tp;
        int FH = FH(this.gn);
        while (FH != this.we) {
            ass ass2 = this.Hw[FH];
            this.Hw[FH] = ass;
            FH = FH(FH);
            ass = ass2;
        }
        this.Hw[FH] = ass;
    }

    private void FH() {
        this.gn = DW(this.gn);
    }

    private int DW(int i) {
        int i2 = i + 1;
        if (i2 == this.Hw.length) {
            return 0;
        }
        return i2;
    }

    private int FH(int i) {
        if (i == 0) {
            return this.Hw.length - 1;
        }
        return i - 1;
    }

    private void Hw(int i) {
    }

    private boolean j6(ass ass, axj$c axj_c) {
        if (this.EQ == null) {
            return true;
        }
        if (axj_c.DW() == this.EQ.DW()) {
            if (ass.j6() >= this.Hw[this.we].j6()) {
                return false;
            }
            return true;
        } else if (axj_c.DW() >= this.EQ.DW()) {
            return false;
        } else {
            return true;
        }
    }

    private static int j6(ass ass, int i, ass ass2) {
        return (((ass.FH() / 2) - 20) * (i - ass2.j6())) / i;
    }

    private asn DW(ass ass) {
        asn asn = ass.FH;
        if (asn == null) {
            try {
                asn = new asn(FH(ass));
                if (0 < this.v5) {
                    this.VH += asn.DW() - asn.j6();
                }
                ass.FH = asn;
            } catch (OutOfMemoryError e) {
                alf$c alf_c = new alf$c(e);
                alf_c.j6(ass.j6);
                throw alf_c;
            }
        }
        return asn;
    }

    private byte[] FH(ass ass) {
        byte[] bArr = ass.DW;
        if (bArr == null) {
            bArr = asy.j6(this.j6, this.FH, ass.j6);
            if (0 < this.v5) {
                this.VH += (long) bArr.length;
            }
            ass.DW = bArr;
        }
        return bArr;
    }

    private Deflater Hw() {
        if (this.J0 == null) {
            this.J0 = new Deflater(this.j6.EQ());
        } else {
            this.J0.reset();
        }
        return this.J0;
    }
}
