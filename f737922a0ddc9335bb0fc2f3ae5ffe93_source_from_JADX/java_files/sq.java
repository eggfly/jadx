public final class sq {
    private final aai DW;
    private final acu FH;
    private final ti Hw;
    private int Zo;
    private final su j6;
    private final acu$a v5;

    public sq(su suVar, int i, int i2, ti tiVar) {
        if (suVar == null) {
            throw new NullPointerException("cf == null");
        }
        this.j6 = suVar;
        this.DW = suVar.Zo();
        this.Hw = tiVar;
        this.FH = suVar.j6().j6(i, i + i2);
        this.v5 = this.FH.DW();
        this.Zo = 0;
    }

    public aah j6() {
        try {
            aah FH = FH();
            if (this.v5.available() == 0) {
                return FH;
            }
            throw new th("extra data in attribute");
        } catch (Throwable e) {
            throw new RuntimeException("shouldn't happen", e);
        }
    }

    public zf j6(zd zdVar) {
        try {
            zf FH = FH(zdVar);
            if (this.v5.available() == 0) {
                return FH;
            }
            throw new th("extra data in attribute");
        } catch (Throwable e) {
            throw new RuntimeException("shouldn't happen", e);
        }
    }

    public ze DW(zd zdVar) {
        try {
            ze Hw = Hw(zdVar);
            if (this.v5.available() == 0) {
                return Hw;
            }
            throw new th("extra data in attribute");
        } catch (Throwable e) {
            throw new RuntimeException("shouldn't happen", e);
        }
    }

    private zf FH(zd zdVar) {
        int readUnsignedByte = this.v5.readUnsignedByte();
        if (this.Hw != null) {
            j6(1, "num_parameters: " + add.v5(readUnsignedByte));
        }
        zf zfVar = new zf(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            if (this.Hw != null) {
                j6(0, "parameter_annotations[" + i + "]:");
                DW(1);
            }
            zfVar.j6(i, Hw(zdVar));
            if (this.Hw != null) {
                this.Hw.j6(-1);
            }
        }
        zfVar.l_();
        return zfVar;
    }

    private ze Hw(zd zdVar) {
        int readUnsignedShort = this.v5.readUnsignedShort();
        if (this.Hw != null) {
            j6(2, "num_annotations: " + add.FH(readUnsignedShort));
        }
        ze zeVar = new ze();
        for (int i = 0; i < readUnsignedShort; i++) {
            if (this.Hw != null) {
                j6(0, "annotations[" + i + "]:");
                DW(1);
            }
            zeVar.j6(v5(zdVar));
            if (this.Hw != null) {
                this.Hw.j6(-1);
            }
        }
        zeVar.l_();
        return zeVar;
    }

    private zc v5(zd zdVar) {
        j6(4);
        int readUnsignedShort = this.v5.readUnsignedShort();
        int readUnsignedShort2 = this.v5.readUnsignedShort();
        abf abf = new abf(abl.j6(((abe) this.DW.j6(readUnsignedShort)).tp()));
        if (this.Hw != null) {
            j6(2, "type: " + abf.Hw());
            j6(2, "num_elements: " + readUnsignedShort2);
        }
        zc zcVar = new zc(abf, zdVar);
        for (readUnsignedShort = 0; readUnsignedShort < readUnsignedShort2; readUnsignedShort++) {
            if (this.Hw != null) {
                j6(0, "elements[" + readUnsignedShort + "]:");
                DW(1);
            }
            zcVar.DW(DW());
            if (this.Hw != null) {
                DW(-1);
            }
        }
        zcVar.l_();
        return zcVar;
    }

    private zg DW() {
        j6(5);
        abe abe = (abe) this.DW.j6(this.v5.readUnsignedShort());
        if (this.Hw != null) {
            j6(2, "element_name: " + abe.Hw());
            j6(0, "value: ");
            DW(1);
        }
        aah FH = FH();
        if (this.Hw != null) {
            DW(-1);
        }
        return new zg(abe, FH);
    }

    private aah FH() {
        int readUnsignedByte = this.v5.readUnsignedByte();
        if (this.Hw != null) {
            j6(1, "tag: " + new abe(Character.toString((char) readUnsignedByte)).u7());
        }
        switch (readUnsignedByte) {
            case 64:
                return new aaj(v5(zd.EMBEDDED));
            case 66:
                return aan.j6(((aat) Hw()).r_());
            case 67:
                aat aat = (aat) Hw();
                aat.r_();
                return aao.j6(aat.r_());
            case 68:
                return (aap) Hw();
            case 70:
                return (aas) Hw();
            case 73:
                return (aat) Hw();
            case 74:
                return (aaz) Hw();
            case 83:
                return abd.j6(((aat) Hw()).r_());
            case 90:
                return aam.j6(((aat) Hw()).r_());
            case 91:
                j6(2);
                int readUnsignedShort = this.v5.readUnsignedShort();
                aak$a aak_a = new aak$a(readUnsignedShort);
                if (this.Hw != null) {
                    j6(2, "num_values: " + readUnsignedShort);
                    DW(1);
                }
                for (readUnsignedByte = 0; readUnsignedByte < readUnsignedShort; readUnsignedByte++) {
                    if (this.Hw != null) {
                        DW(-1);
                        j6(0, "element_value[" + readUnsignedByte + "]:");
                        DW(1);
                    }
                    aak_a.j6(readUnsignedByte, FH());
                }
                if (this.Hw != null) {
                    DW(-1);
                }
                aak_a.l_();
                return new aak(aak_a);
            case 99:
                abl DW = abl.DW(((abe) this.DW.j6(this.v5.readUnsignedShort())).tp());
                if (this.Hw != null) {
                    j6(2, "class_info: " + DW.Hw());
                }
                return new abf(DW);
            case 101:
                j6(4);
                readUnsignedByte = this.v5.readUnsignedShort();
                abe abe = (abe) this.DW.j6(readUnsignedByte);
                abe abe2 = (abe) this.DW.j6(this.v5.readUnsignedShort());
                if (this.Hw != null) {
                    j6(2, "type_name: " + abe.Hw());
                    j6(2, "const_name: " + abe2.Hw());
                }
                return new aaq(new abc(abe2, abe));
            case 115:
                return Hw();
            default:
                throw new th("unknown annotation tag: " + add.v5(readUnsignedByte));
        }
    }

    private aah Hw() {
        aah j6 = this.DW.j6(this.v5.readUnsignedShort());
        if (this.Hw != null) {
            j6(2, "constant_value: " + (j6 instanceof abe ? ((abe) j6).u7() : j6.Hw()));
        }
        return j6;
    }

    private void j6(int i) {
        if (this.v5.available() < i) {
            throw new th("truncated annotation attribute");
        }
    }

    private void j6(int i, String str) {
        this.Hw.j6(this.FH, this.Zo, i, str);
        this.Zo += i;
    }

    private void DW(int i) {
        this.Hw.j6(i);
    }
}
