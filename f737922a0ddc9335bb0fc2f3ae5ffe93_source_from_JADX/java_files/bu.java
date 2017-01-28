import java.util.Vector;

public class bu {
    private final bw DW;
    private final bt FH;
    private dj<bu$b> Hw;
    private ec VH;
    private ec Zo;
    private bu$a gn;
    private final cc j6;
    private dj<bu$d> v5;

    protected bu(cc ccVar) {
        this.j6 = ccVar;
        this.DW = ccVar.cn;
        this.FH = ccVar.cb;
        this.Zo = new ec();
        this.VH = new ec();
        this.Hw = new dj();
        this.v5 = new dj();
    }

    protected void j6(ee eeVar) {
        int i;
        int i2 = 0;
        this.Zo = new ec(eeVar);
        this.VH = new ec(eeVar);
        int readInt = eeVar.readInt();
        this.Hw = new dj(readInt);
        for (i = 0; i < readInt; i++) {
            bv gn = this.DW.gn(eeVar.readInt());
            this.Hw.j6(gn.vy(), new bu$b(this, eeVar));
        }
        i = eeVar.readInt();
        this.v5 = new dj(i);
        while (i2 < i) {
            this.v5.j6(eeVar.readInt(), new bu$d(this, eeVar));
            i2++;
        }
    }

    public void j6(ef efVar) {
        this.Zo.j6(efVar);
        this.VH.j6(efVar);
        efVar.writeInt(this.Hw.DW());
        this.Hw.j6.j6();
        while (this.Hw.j6.DW()) {
            bu$b bu_b = (bu$b) this.Hw.j6.Hw();
            efVar.writeInt(this.DW.gn(this.Hw.j6.FH()).vy());
            bu_b.j6(efVar);
        }
        efVar.writeInt(this.v5.DW());
        this.v5.j6.j6();
        while (this.v5.j6.DW()) {
            bu$d bu_d = (bu$d) this.v5.j6.Hw();
            efVar.writeInt(this.v5.j6.FH());
            bu_d.j6(efVar);
        }
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, String str, int i5) {
        bu$a bu_a = new bu$a(this, i, i2, i3, i4, "Warning: " + str, i5, 0);
        if (!this.Hw.j6(bvVar.vy())) {
            this.Hw.j6(bvVar.vy(), new bu$b(this));
        }
        ((bu$b) this.Hw.FH(bvVar.vy())).j6.addElement(bu_a);
        this.gn = bu_a;
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, String str, int i5) {
        if (i > 0) {
            bu$a bu_a = new bu$a(this, i, i2, i3, i4, str, i5, 0);
            int j6 = this.j6.cn.j6(bvVar, bjVar);
            if (!this.v5.j6(j6)) {
                this.v5.j6(j6, new bu$d(this));
            }
            ((bu$d) this.v5.FH(j6)).DW.addElement(bu_a);
            this.gn = bu_a;
            return;
        }
        this.gn = null;
    }

    public void DW(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, String str, int i5) {
        if (i > 0) {
            bu$a bu_a = new bu$a(this, i, i2, i3, i4, str, i5, 0);
            int j6 = this.j6.cn.j6(bvVar, bjVar);
            if (!this.v5.j6(j6)) {
                this.v5.j6(j6, new bu$d(this));
            }
            ((bu$d) this.v5.FH(j6)).DW.addElement(bu_a);
            this.Zo.j6(j6);
            this.gn = bu_a;
            return;
        }
        this.gn = null;
    }

    public void FH(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, String str, int i5) {
        if (i > 0) {
            bu$a bu_a = new bu$a(this, i, i2, i3, i4, str, 70, i5);
            int j6 = this.j6.cn.j6(bvVar, bjVar);
            if (!this.v5.j6(j6)) {
                this.v5.j6(j6, new bu$d(this));
            }
            ((bu$d) this.v5.FH(j6)).DW.addElement(bu_a);
            this.gn = bu_a;
            return;
        }
        this.gn = null;
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, int i5) {
        if (i > 0) {
            bu$a bu_a = new bu$a(this, i, i2, i3, i4, "", 200, i5);
            int j6 = this.j6.cn.j6(bvVar, bjVar);
            if (!this.v5.j6(j6)) {
                this.v5.j6(j6, new bu$d(this));
            }
            ((bu$d) this.v5.FH(j6)).j6.addElement(bu_a);
            this.VH.j6(j6);
            this.gn = bu_a;
            return;
        }
        this.gn = null;
    }

    public void Hw(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, String str, int i5) {
        if (i > 0) {
            bu$a bu_a = new bu$a(this, i, i2, i3, i4, str, i5, 0);
            int j6 = this.j6.cn.j6(bvVar, bjVar);
            if (!this.v5.j6(j6)) {
                this.v5.j6(j6, new bu$d(this));
            }
            ((bu$d) this.v5.FH(j6)).DW.addElement(bu_a);
            this.Zo.j6(j6);
            this.VH.j6(j6);
            this.gn = bu_a;
            return;
        }
        this.gn = null;
    }

    public void v5(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, String str, int i5) {
        if (i > 0) {
            bu$a bu_a = new bu$a(this, i, i2, i3, i4, str, i5, 0);
            int j6 = this.j6.cn.j6(bvVar, bjVar);
            if (!this.v5.j6(j6)) {
                this.v5.j6(j6, new bu$d(this));
            }
            ((bu$d) this.v5.FH(j6)).DW.addElement(bu_a);
            this.VH.j6(j6);
            this.gn = bu_a;
            return;
        }
        this.gn = null;
    }

    public void Zo(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, String str, int i5) {
        if (i > 0) {
            bu$a bu_a = new bu$a(this, i, i2, i3, i4, str, i5, 0);
            int j6 = this.j6.cn.j6(bvVar, bjVar);
            if (!this.v5.j6(j6)) {
                this.v5.j6(j6, new bu$d(this));
            }
            ((bu$d) this.v5.FH(j6)).j6.addElement(bu_a);
            this.VH.j6(j6);
            this.gn = bu_a;
            return;
        }
        this.gn = null;
    }

    public void j6(bv bvVar, bj bjVar, bv bvVar2, int i, String str) {
        if (this.gn == null) {
        }
    }

    public void j6(bv bvVar, bj bjVar, String str) {
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, co coVar, int[] iArr, co[] coVarArr, int[] iArr2, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 5, bvVar, bjVar, i, i2, i3, i4, coVar, iArr, coVarArr, iArr2, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, co coVar, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 4, bvVar, bjVar, i, i2, i3, i4, coVar, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, co coVar, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 3, bvVar, bjVar, i, i2, i3, coVar, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void DW(bv bvVar, bj bjVar, int i, int i2, int i3, co coVar, String str) {
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 8, bvVar, bjVar, i, i2, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void DW(bv bvVar, bj bjVar, int i, int i2, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 9, bvVar, bjVar, i, i2, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void FH(bv bvVar, bj bjVar, int i, int i2, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 1, bvVar, bjVar, i, i2, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void DW(bv bvVar, bj bjVar, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 11, bvVar, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void j6(bv bvVar, bj bjVar, bp bpVar, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 2, bvVar, bpVar, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, String str, String str2) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 0, bvVar, i, i2, i3, i4, str, str2);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str) {
        if (this.gn != null) {
            bu$c bu_c = new bu$c(this, 7, bvVar, i, i2, i3, i4, i5, i6, i7, i8, str);
            if (this.gn.gn == null) {
                this.gn.gn = new Vector(3);
            }
            this.gn.gn.addElement(bu_c);
        }
    }

    public eb j6() {
        eb ebVar = new eb(this.DW);
        this.v5.j6.j6();
        while (this.v5.j6.DW()) {
            ebVar.j6(this.DW.Hw(this.v5.j6.FH()));
        }
        return ebVar;
    }

    public void j6(bv bvVar) {
        if (this.Hw.j6(bvVar.vy())) {
            ((bu$b) this.Hw.FH(bvVar.vy())).j6 = new Vector();
        }
    }

    public void j6(bv bvVar, bj bjVar) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        if (this.v5.j6(j6)) {
            ((bu$d) this.v5.FH(j6)).DW = new Vector();
        }
        this.Zo.DW(j6);
        this.VH.DW(j6);
    }

    public void DW(bv bvVar, bj bjVar) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        if (this.v5.j6(j6)) {
            ((bu$d) this.v5.FH(j6)).j6 = new Vector();
        }
    }

    public boolean DW(bv bvVar) {
        return this.Hw.j6(bvVar.vy()) && ((bu$b) this.Hw.FH(bvVar.vy())).j6.size() > 0;
    }

    public boolean FH(bv bvVar) {
        this.VH.j6.j6();
        while (this.VH.j6.DW()) {
            if (this.j6.cn.Hw(this.VH.j6.FH()) == bvVar) {
                return true;
            }
        }
        return false;
    }

    public boolean Hw(bv bvVar) {
        for (bj j6 : bvVar.BT().Zo()) {
            if (this.v5.j6(this.j6.cn.j6(bvVar, j6))) {
                return true;
            }
        }
        return false;
    }

    public boolean FH(bv bvVar, bj bjVar) {
        return this.Zo.FH(this.j6.cn.j6(bvVar, bjVar));
    }

    public int v5(bv bvVar) {
        if (this.Hw.j6(bvVar.vy())) {
            return ((bu$b) this.Hw.FH(bvVar.vy())).j6.size();
        }
        return 0;
    }

    public int j6(bv bvVar, int i) {
        return ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).FH;
    }

    public int DW(bv bvVar, int i) {
        return ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).Hw;
    }

    public int FH(bv bvVar, int i) {
        return ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).v5;
    }

    public int Hw(bv bvVar, int i) {
        return ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).Zo;
    }

    public String v5(bv bvVar, int i) {
        return ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).VH;
    }

    public int Zo(bv bvVar, int i) {
        return ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).j6;
    }

    public int VH(bv bvVar, int i) {
        Vector vector = ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).gn;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public String j6(bv bvVar, int i, int i2) {
        return ((bu$c) ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).gn.elementAt(i2)).DW;
    }

    public int Hw(bv bvVar, bj bjVar) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        if (!this.v5.j6(j6)) {
            return 0;
        }
        Vector vector = ((bu$d) this.v5.FH(j6)).DW;
        Vector vector2 = ((bu$d) this.v5.FH(j6)).j6;
        return vector2.size() + vector.size();
    }

    public int j6(bv bvVar, bj bjVar, int i) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            return ((bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size)).FH;
        }
        return ((bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i)).FH;
    }

    public int DW(bv bvVar, bj bjVar, int i) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            return ((bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size)).Hw;
        }
        return ((bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i)).Hw;
    }

    public int FH(bv bvVar, bj bjVar, int i) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            return ((bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size)).v5;
        }
        return ((bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i)).v5;
    }

    public int Hw(bv bvVar, bj bjVar, int i) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            return ((bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size)).Zo;
        }
        return ((bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i)).Zo;
    }

    public String v5(bv bvVar, bj bjVar, int i) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            return ((bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size)).VH;
        }
        return ((bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i)).VH;
    }

    public int Zo(bv bvVar, bj bjVar, int i) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            return ((bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size)).j6;
        }
        return ((bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i)).j6;
    }

    public int VH(bv bvVar, bj bjVar, int i) {
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            return ((bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size)).DW;
        }
        return ((bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i)).DW;
    }

    public int gn(bv bvVar, bj bjVar, int i) {
        bu$a bu_a;
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            bu_a = (bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size);
        } else {
            bu_a = (bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i);
        }
        if (bu_a.gn == null) {
            return 0;
        }
        return bu_a.gn.size();
    }

    public String j6(bv bvVar, bj bjVar, int i, int i2) {
        bu$a bu_a;
        int j6 = this.j6.cn.j6(bvVar, bjVar);
        int size = ((bu$d) this.v5.FH(j6)).j6.size();
        if (i >= size) {
            bu_a = (bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size);
        } else {
            bu_a = (bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i);
        }
        return ((bu$c) bu_a.gn.elementAt(i2)).DW;
    }

    public void j6(bv bvVar, bj bjVar, boolean z, int i, int i2) {
        bu$c bu_c;
        if (z) {
            bu_c = (bu$c) ((bu$a) ((bu$b) this.Hw.FH(bvVar.vy())).j6.elementAt(i)).gn.elementAt(i2);
        } else {
            bu$a bu_a;
            int j6 = this.j6.cn.j6(bvVar, bjVar);
            int size = ((bu$d) this.v5.FH(j6)).j6.size();
            if (i >= size) {
                bu_a = (bu$a) ((bu$d) this.v5.FH(j6)).DW.elementAt(i - size);
            } else {
                bu_a = (bu$a) ((bu$d) this.v5.FH(j6)).j6.elementAt(i);
            }
            bu_c = (bu$c) bu_a.gn.elementAt(i2);
        }
        this.j6.j6(bu_c);
    }
}
