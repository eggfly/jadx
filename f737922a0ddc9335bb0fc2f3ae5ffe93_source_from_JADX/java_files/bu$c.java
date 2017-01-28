public class bu$c {
    public String DW;
    public int EQ;
    public bs FH;
    public bv Hw;
    public int J0;
    public int J8;
    final /* synthetic */ bu Mr;
    public int QX;
    public int[] VH;
    public int Ws;
    public int XL;
    public int Zo;
    public String aM;
    public co[] gn;
    public bj j3;
    public int j6;
    public int tp;
    public int[] u7;
    public int v5;
    public int we;

    public bu$c(bu buVar, int i, bv bvVar, bj bjVar, int i2, int i3, int i4, int i5, co coVar, int[] iArr, co[] coVarArr, int[] iArr2, String str) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = i;
        this.DW = str;
        this.Hw = bvVar;
        this.j3 = bjVar;
        this.tp = i2;
        this.EQ = i3;
        this.FH = coVar;
        this.v5 = i5;
        this.Zo = i4;
        this.gn = coVarArr;
        this.u7 = iArr2;
        this.VH = iArr;
    }

    public bu$c(bu buVar, int i, bv bvVar, String str) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = i;
        this.DW = str;
        this.Hw = bvVar;
    }

    public bu$c(bu buVar, int i, bv bvVar, bs bsVar, String str) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = i;
        this.DW = str;
        this.Hw = bvVar;
        this.FH = bsVar;
    }

    public bu$c(bu buVar, int i, bv bvVar, bj bjVar, int i2, int i3, String str) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = i;
        this.DW = str;
        this.Hw = bvVar;
        this.j3 = bjVar;
        this.tp = i2;
        this.EQ = i3;
    }

    public bu$c(bu buVar, int i, bv bvVar, bj bjVar, int i2, int i3, int i4, co coVar, String str) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = i;
        this.DW = str;
        this.Hw = bvVar;
        this.j3 = bjVar;
        this.tp = i2;
        this.EQ = i3;
        this.FH = coVar;
        this.v5 = i4;
    }

    public bu$c(bu buVar, int i, bv bvVar, bj bjVar, int i2, int i3, int i4, int i5, co coVar, String str) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = i;
        this.DW = str;
        this.Hw = bvVar;
        this.j3 = bjVar;
        this.tp = i2;
        this.EQ = i3;
        this.FH = coVar;
        this.v5 = i5;
        this.Zo = i4;
    }

    public bu$c(bu buVar, int i, bv bvVar, int i2, int i3, int i4, int i5, String str, String str2) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = i;
        this.DW = str2;
        this.Hw = bvVar;
        this.tp = i2;
        this.EQ = i3;
        this.we = i4;
        this.J0 = i5;
        this.aM = str;
    }

    public bu$c(bu buVar, int i, bv bvVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = i;
        this.DW = str;
        this.Hw = bvVar;
        this.tp = i2;
        this.EQ = i3;
        this.we = i4;
        this.J0 = i5;
        this.J8 = i6;
        this.Ws = i7;
        this.QX = i8;
        this.XL = i9;
    }

    public bu$c(bu buVar, ee eeVar) {
        this.Mr = buVar;
        this.aM = "";
        this.j6 = eeVar.readInt();
        this.DW = eeVar.readUTF();
        this.tp = eeVar.readInt();
        this.EQ = eeVar.readInt();
        this.we = eeVar.readInt();
        this.J0 = eeVar.readInt();
        this.J8 = eeVar.readInt();
        this.Ws = eeVar.readInt();
        this.QX = eeVar.readInt();
        this.XL = eeVar.readInt();
        this.aM = eeVar.readUTF();
        this.FH = buVar.FH.FH(eeVar.readInt());
        this.v5 = eeVar.readInt();
        this.Hw = buVar.DW.gn(eeVar.readInt());
        this.Zo = eeVar.readInt();
        if (eeVar.readBoolean()) {
            int readInt = eeVar.readInt();
            this.VH = new int[readInt];
            this.gn = new co[readInt];
            this.u7 = new int[readInt];
            for (int i = 0; i < readInt; i++) {
                this.VH[i] = eeVar.readInt();
                this.gn[i] = (co) buVar.FH.FH(eeVar.readInt());
                this.u7[i] = eeVar.readInt();
            }
        }
    }

    protected void j6(ef efVar) {
        boolean z;
        int i = 0;
        efVar.writeInt(this.j6);
        efVar.writeUTF(this.DW);
        efVar.writeInt(this.tp);
        efVar.writeInt(this.EQ);
        efVar.writeInt(this.we);
        efVar.writeInt(this.J0);
        efVar.writeInt(this.J8);
        efVar.writeInt(this.Ws);
        efVar.writeInt(this.QX);
        efVar.writeInt(this.XL);
        efVar.writeUTF(this.aM);
        efVar.writeInt(this.Mr.FH.j6(this.FH));
        efVar.writeInt(this.v5);
        efVar.writeInt(this.Mr.DW.QX(this.Hw));
        efVar.writeInt(this.Zo);
        if (this.gn != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.gn != null) {
            efVar.writeInt(this.gn.length);
            while (i < this.gn.length) {
                efVar.writeInt(this.VH[i]);
                efVar.writeInt(this.Mr.FH.j6(this.gn[i]));
                efVar.writeInt(this.u7[i]);
                i++;
            }
        }
    }
}
