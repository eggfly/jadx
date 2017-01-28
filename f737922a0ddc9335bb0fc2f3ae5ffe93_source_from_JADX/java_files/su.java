public class su implements tb {
    private final acu DW;
    private tj EQ;
    private final boolean FH;
    private abg Hw;
    private ti J0;
    private abf VH;
    private abf Zo;
    private abn gn;
    private final String j6;
    private tg tp;
    private td u7;
    private int v5;
    private sr we;

    public static String j6(Object obj) {
        if (obj == null) {
            return "(none)";
        }
        return obj.toString();
    }

    public su(acu acu, String str, boolean z) {
        if (acu == null) {
            throw new NullPointerException("bytes == null");
        } else if (str == null) {
            throw new NullPointerException("filePath == null");
        } else {
            this.j6 = str;
            this.DW = acu;
            this.FH = z;
            this.v5 = -1;
        }
    }

    public su(byte[] bArr, String str, boolean z) {
        this(new acu(bArr), str, z);
    }

    public void j6(sr srVar) {
        if (srVar == null) {
            throw new NullPointerException("attributeFactory == null");
        }
        this.we = srVar;
    }

    public acu j6() {
        return this.DW;
    }

    public int DW() {
        Ws();
        return we();
    }

    public int FH() {
        Ws();
        return this.v5;
    }

    public abf Hw() {
        Ws();
        return this.Zo;
    }

    public abf v5() {
        Ws();
        return this.VH;
    }

    public aai Zo() {
        Ws();
        return this.Hw;
    }

    public abn VH() {
        Ws();
        return this.gn;
    }

    public td gn() {
        QX();
        return this.u7;
    }

    public tg u7() {
        QX();
        return this.tp;
    }

    public ta tp() {
        QX();
        return this.EQ;
    }

    public abe EQ() {
        sz j6 = tp().j6("SourceFile");
        if (j6 instanceof rj) {
            return ((rj) j6).DW();
        }
        return null;
    }

    public abn j6(int i, int i2) {
        if (i2 == 0) {
            return abk.j6;
        }
        if (this.Hw == null) {
            throw new IllegalStateException("pool not yet initialized");
        }
        return new su$a(this.DW, i, i2, this.Hw, this.J0);
    }

    public int we() {
        return this.DW.FH(0);
    }

    public int J0() {
        return this.DW.Zo(4);
    }

    public int J8() {
        return this.DW.Zo(6);
    }

    private void Ws() {
        if (this.v5 == -1) {
            XL();
        }
    }

    private void QX() {
        if (this.EQ == null) {
            XL();
        }
    }

    private void XL() {
        try {
            aM();
        } catch (th e) {
            e.j6("...while parsing " + this.j6);
            throw e;
        } catch (Throwable e2) {
            th thVar = new th(e2);
            thVar.j6("...while parsing " + this.j6);
            throw thVar;
        }
    }

    private boolean j6(int i, int i2, int i3) {
        if (i == -889275714 && i2 >= 0) {
            if (i3 == 50) {
                if (i2 <= 0) {
                    return true;
                }
            } else if (i3 < 50 && i3 >= 45) {
                return true;
            }
        }
        return false;
    }

    private void aM() {
        if (this.DW.j6() < 10) {
            throw new th("severely truncated class file");
        }
        if (this.J0 != null) {
            this.J0.j6(this.DW, 0, 0, "begin classfile");
            this.J0.j6(this.DW, 0, 4, "magic: " + add.j6(we()));
            this.J0.j6(this.DW, 4, 2, "minor_version: " + add.FH(J0()));
            this.J0.j6(this.DW, 6, 2, "major_version: " + add.FH(J8()));
        }
        if (!this.FH || j6(we(), J0(), J8())) {
            sp spVar = new sp(this.DW);
            spVar.j6(this.J0);
            this.Hw = spVar.DW();
            this.Hw.l_();
            int j6 = spVar.j6();
            int Zo = this.DW.Zo(j6);
            this.Zo = (abf) this.Hw.j6(this.DW.Zo(j6 + 2));
            this.VH = (abf) this.Hw.DW(this.DW.Zo(j6 + 4));
            int Zo2 = this.DW.Zo(j6 + 6);
            if (this.J0 != null) {
                this.J0.j6(this.DW, j6, 2, "access_flags: " + zh.j6(Zo));
                this.J0.j6(this.DW, j6 + 2, 2, "this_class: " + this.Zo);
                this.J0.j6(this.DW, j6 + 4, 2, "super_class: " + j6(this.VH));
                this.J0.j6(this.DW, j6 + 6, 2, "interfaces_count: " + add.FH(Zo2));
                if (Zo2 != 0) {
                    this.J0.j6(this.DW, j6 + 8, 0, "interfaces:");
                }
            }
            j6 += 8;
            this.gn = j6(j6, Zo2);
            Zo2 = (Zo2 * 2) + j6;
            if (this.FH) {
                String u7 = this.Zo.u7().u7();
                if (!(this.j6.endsWith(".class") && this.j6.startsWith(u7) && this.j6.length() == u7.length() + 6)) {
                    throw new th("class name (" + u7 + ") does not match path (" + this.j6 + ")");
                }
            }
            this.v5 = Zo;
            sv svVar = new sv(this, this.Zo, Zo2, this.we);
            svVar.j6(this.J0);
            this.u7 = svVar.j6();
            sx sxVar = new sx(this, this.Zo, svVar.Hw(), this.we);
            sxVar.j6(this.J0);
            this.tp = sxVar.j6();
            ss ssVar = new ss(this, 0, sxVar.Hw(), this.we);
            ssVar.j6(this.J0);
            this.EQ = ssVar.DW();
            this.EQ.l_();
            Zo2 = ssVar.j6();
            if (Zo2 != this.DW.j6()) {
                throw new th("extra bytes at end of class file, at offset " + add.j6(Zo2));
            } else if (this.J0 != null) {
                this.J0.j6(this.DW, Zo2, 0, "end classfile");
                return;
            } else {
                return;
            }
        }
        throw new th("bad class file magic (" + add.j6(we()) + ") or version (" + add.FH(J8()) + "." + add.FH(J0()) + ")");
    }
}
