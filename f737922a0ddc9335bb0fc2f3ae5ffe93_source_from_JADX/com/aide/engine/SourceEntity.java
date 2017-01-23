package com.aide.engine;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ba;
import bj;
import bp;
import bs;
import bt;
import bv;
import bw;
import bz;
import cc;
import cf;
import cl;
import co;
import cp;
import ej;
import java.util.ArrayList;
import java.util.List;

public class SourceEntity implements Parcelable {
    public static final Creator<SourceEntity> CREATOR;
    private boolean BT;
    private boolean DW;
    private int EQ;
    private boolean FH;
    private String Hw;
    private int J0;
    private int J8;
    private int Mr;
    private int QX;
    private boolean U2;
    private String VH;
    private int Ws;
    private int XL;
    private String Zo;
    private boolean a8;
    private String aM;
    private String er;
    private String gW;
    private List<SourceEntity> gn;
    private int j3;
    private a j6;
    private boolean lg;
    private String rN;
    private List<SourceEntity> tp;
    private boolean u7;
    private String v5;
    private int we;
    private String yS;

    static class 1 implements Creator<SourceEntity> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public SourceEntity j6(Parcel parcel) {
            return new SourceEntity(parcel);
        }

        public SourceEntity[] j6(int i) {
            return new SourceEntity[i];
        }
    }

    public enum a {
        Method,
        Field,
        Property,
        Event,
        Class,
        Type,
        Package,
        Variable,
        Region,
        Comment,
        Language,
        Parameter,
        Keyword,
        UnknownIdentifier,
        Constructor,
        File
    }

    static {
        CREATOR = new 1();
    }

    public SourceEntity(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.j6 = a.values()[parcel.readInt()];
        this.DW = parcel.readInt() != 0;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.FH = z;
        this.Hw = parcel.readString();
        this.gW = parcel.readString();
        this.v5 = parcel.readString();
        this.Zo = parcel.readString();
        this.VH = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.u7 = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.BT = z;
        this.EQ = parcel.readInt();
        this.we = parcel.readInt();
        this.J0 = parcel.readInt();
        this.J8 = parcel.readInt();
        this.Ws = parcel.readInt();
        this.QX = parcel.readInt();
        this.XL = parcel.readInt();
        this.aM = parcel.readString();
        this.j3 = parcel.readInt();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.U2 = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.a8 = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.lg = z2;
        this.rN = parcel.readString();
        this.er = parcel.readString();
        this.yS = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.j6.ordinal());
        parcel.writeInt(this.DW ? 1 : 0);
        if (this.FH) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.Hw);
        parcel.writeString(this.gW);
        parcel.writeString(this.v5);
        parcel.writeString(this.Zo);
        parcel.writeString(this.VH);
        if (this.u7) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.BT) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.EQ);
        parcel.writeInt(this.we);
        parcel.writeInt(this.J0);
        parcel.writeInt(this.J8);
        parcel.writeInt(this.Ws);
        parcel.writeInt(this.QX);
        parcel.writeInt(this.XL);
        parcel.writeString(this.aM);
        parcel.writeInt(this.j3);
        if (this.U2) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.a8) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.lg) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.rN);
        parcel.writeString(this.er);
        parcel.writeString(this.yS);
    }

    protected SourceEntity(String str) {
        this.j6 = a.Keyword;
        this.Hw = str;
        this.FH = true;
        this.v5 = "";
        this.Zo = "<code><b><font color=\"#2A50D0\">" + str + "</font></b></code>";
    }

    protected SourceEntity(cc ccVar, List<cp> list) {
        this.j6 = a.Method;
        this.FH = true;
        this.v5 = "";
        this.Zo = "";
        this.tp = new ArrayList();
        for (cp sourceEntity : list) {
            this.tp.add(new SourceEntity(ccVar, false, sourceEntity));
        }
    }

    protected SourceEntity(cc ccVar, bj bjVar, List<SourceEntity> list) {
        this.j6 = a.Language;
        this.Hw = bjVar.j6();
        this.gn = list;
    }

    protected SourceEntity(String str, boolean z) {
        this.j6 = a.UnknownIdentifier;
        this.Hw = str;
    }

    private SourceEntity(cc ccVar, String str, co coVar, int i) {
        this.j6 = a.Parameter;
        this.Hw = str;
        this.Mr = i;
    }

    protected SourceEntity(cc ccVar, boolean z, cp cpVar) {
        this.j6 = a.Variable;
        this.a8 = z;
        this.Hw = ccVar.ro.j6(cpVar.VH());
        this.aM = cpVar.FH().er();
        this.EQ = cpVar.Hw();
        this.J0 = cpVar.Zo();
        this.we = cpVar.v5();
        this.DW = true;
        this.Zo = cpVar.DW();
        this.v5 = "";
        this.FH = true;
        this.VH = cpVar.gn() != null ? " : " + cpVar.gn().eU() : "";
    }

    protected SourceEntity(cc ccVar, bs bsVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<SourceEntity> list) {
        this(ccVar, bsVar, i, i2, i3, i4, i5, i6, i7);
        this.gn = list;
    }

    protected SourceEntity(cc ccVar, bs bsVar, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(ccVar, bsVar);
        this.DW = true;
        this.J8 = i6;
        this.Ws = i7;
        this.QX = i4;
        this.XL = i5;
        this.EQ = i;
        this.we = i2;
        this.J0 = i3;
    }

    protected SourceEntity(cc ccVar, String str, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<SourceEntity> list) {
        if (z) {
            this.j6 = a.Comment;
        } else {
            this.j6 = a.Region;
        }
        this.Hw = str;
        this.DW = true;
        this.J8 = i6;
        this.Ws = i7;
        this.QX = i4;
        this.XL = i5;
        this.EQ = i;
        this.we = i2;
        this.J0 = i3;
        this.gn = list;
    }

    protected SourceEntity(cc ccVar, bs bsVar, boolean z) {
        this(ccVar, bsVar);
        this.U2 = z;
    }

    protected SourceEntity(cc ccVar, boolean z, bs bsVar) {
        this(ccVar, bsVar);
        this.a8 = z;
    }

    protected SourceEntity(cc ccVar, bs bsVar, int i) {
        this(ccVar, bsVar);
        if (bsVar.cT()) {
            this.j6 = a.Class;
            this.Hw = bsVar.eU();
            if (bsVar.EQ() == 0) {
                this.Mr = 0;
            } else {
                this.Mr = bsVar.Ev();
            }
        }
    }

    protected SourceEntity(cc ccVar, bs bsVar, String str) {
        this(ccVar, bsVar);
        this.gW = str;
    }

    protected SourceEntity(cc ccVar, bs bsVar) {
        this.j3 = bsVar.v5();
        if (bsVar.zh() && ((bz) bsVar).u7()) {
            if (((bz) bsVar).J0()) {
                this.j6 = a.Property;
            } else if (((bz) bsVar).we()) {
                this.j6 = a.Event;
            } else {
                this.j6 = a.Field;
            }
            this.Hw = bsVar.eU();
            this.Mr = bsVar.Ev();
            j6(ccVar, (bz) bsVar);
            j6(bsVar);
        } else if (bsVar.zh() && ((bz) bsVar).gn()) {
            boolean z;
            if (((bz) bsVar).sy()) {
                this.j6 = a.Constructor;
            } else if (((bz) bsVar).J8()) {
                this.j6 = a.Property;
            } else {
                this.j6 = a.Method;
            }
            this.Hw = bsVar.eU();
            if (((bz) bsVar).lp() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.u7 = z;
            this.Mr = bsVar.Ev();
            j6(ccVar, (bz) bsVar);
            j6(bsVar);
        } else if (bsVar.cT()) {
            this.j6 = a.Class;
            this.Hw = ((bp) bsVar).br();
            if (((bp) bsVar).hz()) {
                this.Mr = 0;
            } else {
                this.Mr = bsVar.Ev();
            }
            if (((bp) bsVar).hz()) {
                ((bp) bsVar).rN();
            }
            j6(bsVar);
        } else if (bsVar.n5()) {
            this.j6 = a.Class;
            bp gn = ((cf) bsVar).gn();
            this.Hw = bsVar.eU();
            if (gn.hz()) {
                this.Mr = 0;
            } else {
                this.Mr = gn.Ev();
            }
            if (gn.hz()) {
                gn.rN();
            }
        } else if (bsVar.qp()) {
            this.j6 = a.Package;
            this.Hw = bsVar.eU();
        } else {
            this.j6 = a.Type;
            this.Hw = bsVar.eU();
        }
    }

    public void j6() {
        this.lg = true;
    }

    public void j6(cc ccVar) {
        DW(ccVar);
        this.BT = true;
        this.U2 = true;
    }

    private void j6(bs bsVar) {
        this.yS = bsVar.mb();
    }

    private void j6(cc ccVar, bz bzVar) {
        this.VH = "";
        if (bzVar.gn()) {
            this.VH += "(";
            for (int i = 0; i < bzVar.lp(); i++) {
                if (i > 0) {
                    this.VH += ", ";
                }
                try {
                    this.VH += bzVar.v5(i).eU() + " ";
                } catch (ej e) {
                    this.VH += "";
                }
                this.VH += ccVar.ro.j6(bzVar.Zo(i));
            }
            this.VH += ")";
        }
        try {
            if (bzVar.Mz().Gj() != 1) {
                this.VH += " : " + bzVar.Mz().eU();
            }
        } catch (ej e2) {
            this.VH += "";
        }
    }

    public SourceEntity(ba baVar, bv bvVar) {
        this.j6 = a.File;
        this.Hw = bvVar.v5();
        this.EQ = 1;
        this.we = 1;
        this.J0 = 1;
        this.aM = bvVar.er();
        this.DW = true;
        this.er = bvVar.u7().DW(baVar.cn.v5(bvVar.gn()).u7());
    }

    public a DW() {
        return this.j6;
    }

    public boolean FH() {
        return this.BT;
    }

    public boolean Hw() {
        return this.a8;
    }

    public boolean v5() {
        return this.lg;
    }

    public boolean Zo() {
        return this.U2;
    }

    protected int VH() {
        return this.j3;
    }

    protected void j6(cc ccVar, co coVar) {
        bs FH = ccVar.cb.FH(this.j3);
        co v5;
        if (FH.zh() && ((bz) FH).u7()) {
            try {
                if (coVar.AL()) {
                    v5 = ccVar.cb.v5(FH.tp(), FH.Hw());
                } else if (coVar.w9()) {
                    v5 = ccVar.cb.v5(FH.tp(), FH.Hw());
                } else {
                    v5 = coVar;
                }
                while (v5.Z1()) {
                    v5 = v5.a_();
                }
                while (v5.q7()) {
                    v5 = v5.a_();
                }
            } catch (ej e) {
            }
        } else if (FH.zh() && ((bz) FH).gn()) {
            try {
                if (coVar.AL()) {
                    v5 = ccVar.cb.v5(FH.tp(), FH.Hw());
                } else if (coVar.w9()) {
                    v5 = ccVar.cb.v5(FH.tp(), FH.Hw());
                } else {
                    v5 = coVar;
                }
                while (v5.Z1()) {
                    v5 = v5.a_();
                }
                while (v5.q7()) {
                    v5 = v5.a_();
                }
            } catch (ej e2) {
            }
        }
    }

    protected void DW(cc ccVar, co coVar) {
        co a_;
        int lp;
        int i;
        String j6;
        int VH;
        bs FH = ccVar.cb.FH(this.j3);
        if (FH.zh() && ((bz) FH).gn()) {
            if (coVar != null) {
                try {
                    if (coVar.Z1()) {
                        a_ = coVar.a_();
                    } else {
                        a_ = coVar;
                    }
                    try {
                        if (a_.q7()) {
                            a_ = a_.a_();
                        }
                        coVar = a_;
                    } catch (ej e) {
                        coVar = a_;
                        lp = ((bz) FH).lp();
                        this.tp = new ArrayList(lp);
                        if (((bz) FH).cn()) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        while (i < lp) {
                            j6 = ccVar.ro.j6(((bz) FH).Zo(i));
                            VH = ((bz) FH).VH(i);
                            VH = 4194304 | VH;
                            if (coVar != null) {
                                try {
                                    a_ = ((bz) FH).FH(coVar, i);
                                } catch (ej e2) {
                                    this.tp.add(new SourceEntity(ccVar, j6, null, 0));
                                }
                            } else {
                                a_ = null;
                            }
                            this.tp.add(new SourceEntity(ccVar, j6, a_, VH));
                            i++;
                        }
                    }
                } catch (ej e3) {
                    a_ = coVar;
                    coVar = a_;
                    lp = ((bz) FH).lp();
                    this.tp = new ArrayList(lp);
                    if (((bz) FH).cn()) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    while (i < lp) {
                        j6 = ccVar.ro.j6(((bz) FH).Zo(i));
                        VH = ((bz) FH).VH(i);
                        VH = 4194304 | VH;
                        if (coVar != null) {
                            a_ = null;
                        } else {
                            a_ = ((bz) FH).FH(coVar, i);
                        }
                        this.tp.add(new SourceEntity(ccVar, j6, a_, VH));
                        i++;
                    }
                }
            }
            lp = ((bz) FH).lp();
            this.tp = new ArrayList(lp);
            if (((bz) FH).cn()) {
                i = 1;
            } else {
                i = 0;
            }
            while (i < lp) {
                j6 = ccVar.ro.j6(((bz) FH).Zo(i));
                VH = ((bz) FH).VH(i);
                if (i == lp - 1 && ((bz) FH).sh() && ((bz) FH).OW() == 0) {
                    VH = 4194304 | VH;
                }
                if (coVar != null) {
                    a_ = ((bz) FH).FH(coVar, i);
                } else {
                    a_ = null;
                }
                this.tp.add(new SourceEntity(ccVar, j6, a_, VH));
                i++;
            }
        }
    }

    protected synchronized void j6(bw bwVar, cl clVar, bt btVar) {
        bs FH = btVar.FH(this.j3);
        if (FH != null) {
            bs gn;
            if (FH.n5()) {
                gn = ((cf) FH).gn();
            } else {
                gn = FH;
            }
            if (gn.qp()) {
                this.FH = true;
                this.Zo = j6(bwVar, btVar);
                this.v5 = "";
            } else {
                this.FH = true;
                this.DW = true;
                this.Zo = j6(bwVar, btVar);
                this.v5 = gn.x9();
                bv tp = gn.tp();
                this.aM = tp == null ? "" : tp.er();
                this.EQ = gn.er();
                this.we = gn.gW();
                this.J0 = gn.yS();
                this.J8 = gn.SI();
                this.Ws = gn.nw();
            }
        }
    }

    protected void DW(cc ccVar) {
        bs Xa;
        bs FH = ccVar.cb.FH(this.j3);
        if (FH.zh() && ((bz) FH).u7()) {
            Xa = ((bz) FH).Xa();
        } else if (FH.zh() && ((bz) FH).gn()) {
            if (((bz) FH).sy()) {
                bp Xa2 = ((bz) FH).Xa();
                if (Xa2.hz()) {
                    Xa2.rN();
                    return;
                }
                Xa = Xa2.Xa();
            } else {
                Xa = ((bz) FH).Xa();
            }
        } else if (FH.cT() && !((bp) FH).hz()) {
            Xa = FH.Xa();
        } else if (FH.cT() && ((bp) FH).hz()) {
            Xa = ((bp) FH).rN();
        } else {
            return;
        }
        this.rN = Xa.iW();
        if (Xa.tp() != null && Xa.tp().Hw().contains(".js")) {
            this.rN = Xa.tp().v5();
        }
    }

    private String j6(bw bwVar, bt btVar) {
        bs FH = btVar.FH(this.j3);
        if (FH.n5()) {
            FH = ((cf) FH).gn();
        }
        String jw = FH.jw();
        this.Zo = jw;
        return jw;
    }

    public boolean gn() {
        return this.u7;
    }

    public synchronized int u7() {
        return this.EQ;
    }

    public synchronized int tp() {
        return this.we;
    }

    public synchronized int EQ() {
        return this.J0;
    }

    public String we() {
        return this.rN;
    }

    public synchronized String J0() {
        return this.aM;
    }

    public String J8() {
        return this.Hw;
    }

    public String Ws() {
        return this.er;
    }

    public String toString() {
        return this.Hw;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof SourceEntity) && this.j3 != -1 && this.j3 == ((SourceEntity) obj).j3) {
            return true;
        }
        return false;
    }

    public String QX() {
        if (this.yS == null || (!this.yS.startsWith("java/") && !this.yS.startsWith("javax/") && !this.yS.startsWith("org/") && !this.yS.startsWith("android/"))) {
            return null;
        }
        return this.yS;
    }

    public String XL() {
        return this.VH;
    }

    public String aM() {
        if (this.gW != null) {
            return this.gW;
        }
        return j3();
    }

    public String j3() {
        String J8 = J8();
        if (DW() != a.Method) {
            return J8;
        }
        if (gn()) {
            return J8 + "(";
        }
        return J8 + "()";
    }
}
