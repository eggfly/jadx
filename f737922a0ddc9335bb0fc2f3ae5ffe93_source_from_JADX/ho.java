import java.util.List;
import java.util.Set;

public class ho implements bm {
    private final hk DW;
    private final cc j6;

    public ho(cc ccVar, hl hlVar) {
        this.j6 = ccVar;
        this.DW = new hk(ccVar, hlVar);
    }

    public boolean j6(String str) {
        return false;
    }

    public void j6(bv bvVar, String str) {
    }

    public void j6(bv bvVar, int i, int i2) {
        List lg = bvVar.lg();
        for (int i3 = i; i3 <= Math.min(lg.size() - 1, i2); i3++) {
            String str = (String) lg.get(i3);
            if (str.trim().startsWith("//")) {
                int indexOf = str.indexOf("//") + 1;
                this.j6.rN.j6(bvVar, i3, indexOf, i3, indexOf + 2, "");
            }
        }
    }

    public void DW(bv bvVar, int i, int i2) {
        for (int i3 = i; i3 <= i2; i3++) {
            this.j6.rN.j6(bvVar, i3, 1, i3, 1, "//");
        }
    }

    public void j6(cj cjVar, int i, int i2) {
    }

    public dj<bm$a> j6(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.DW(cjVar, ckVar, i, i2);
    }

    public dj<bm$a> DW(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.DW(cjVar, ckVar, i, i2);
    }

    public dj<bm$a> FH(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.j6(cjVar, ckVar, i, i2);
    }

    public void DW(cj cjVar, ck ckVar, int i, int i2) {
        this.DW.j6(cjVar, ckVar, i);
    }

    public int[] FH(cj cjVar, ck ckVar, int i, int i2) {
        return null;
    }

    public void j6(cj cjVar, ck ckVar, int i, int i2) {
    }

    public Set<? extends bd> j6(cj cjVar, int i) {
        return null;
    }

    public String j6() {
        return null;
    }

    public void j6(bv bvVar, int i, int i2, boolean z) {
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3, int i4, boolean z) {
    }

    public void j6(cj cjVar, int i, int i2, int i3, boolean z) {
    }

    public boolean FH(bv bvVar, int i, int i2) {
        return false;
    }

    public void j6(cj cjVar, bv bvVar, bj bjVar, int i, int i2) {
        this.j6.lg.j6(bvVar, i, i2);
    }

    public void Hw(bv bvVar, int i, int i2) {
    }

    public void v5(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3) {
    }

    public void j6(de deVar, bv bvVar, int i, int i2, String str, List<String> list) {
    }

    public boolean j6(bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        return false;
    }

    public void j6(bv bvVar, bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
    }

    public void Zo(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void VH(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, co coVar) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, co coVar) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, co coVar, int[] iArr, co[] coVarArr, int[] iArr2) {
    }

    public void gn(bv bvVar, int i, int i2) {
    }

    public void DW(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void FH(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void Hw(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void u7(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar, int i, int i2, bz bzVar) {
    }

    public void j6(bv bvVar, bv bvVar2, int i, int i2, int i3, int i4) {
    }

    public void v5(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public String j6(String str, String str2) {
        return null;
    }

    public String j6(cj cjVar, int i, int i2, co coVar) {
        return null;
    }

    public String j6(cj cjVar, dq<bp, bs> dqVar) {
        return null;
    }

    public String j6(ce ceVar) {
        return null;
    }

    public String DW(ce ceVar) {
        return null;
    }

    public String FH(ce ceVar) {
        return null;
    }

    public String j6(cj cjVar, dq<bp, bs> dqVar, ea<ce> eaVar) {
        return null;
    }

    public String j6(cj cjVar, int i, int i2, ea<? extends co> eaVar) {
        return null;
    }

    public String j6(cj cjVar, int i, int i2, ea<? extends co> eaVar, ea<bs> eaVar2) {
        return null;
    }
}
