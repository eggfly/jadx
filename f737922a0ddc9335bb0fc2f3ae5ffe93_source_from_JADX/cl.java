import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cl {
    private static final long DW;
    private static final long FH;
    private static final long j6;
    private dh EQ;
    private final cj Hw;
    private long[] J0;
    private final cc VH;
    private final cl$a Zo;
    private dj<cj> gn;
    private dg tp;
    private dj<cj> u7;
    private final cl$b v5;
    private int[] we;

    static {
        j6 = 10000000;
        DW = 5000000;
        FH = 5000000;
    }

    public cl(cc ccVar) {
        this.v5 = new cl$b();
        this.Zo = new cl$a();
        this.VH = ccVar;
        this.gn = new dj();
        this.u7 = new dj();
        this.tp = new dg();
        this.EQ = new dh();
        this.Hw = new cj(ccVar);
    }

    protected void j6() {
        this.gn.j6.j6();
        while (this.gn.j6.DW()) {
            cj cjVar = (cj) this.gn.j6.Hw();
            if (this.VH.cn.Hw(this.gn.j6.FH()).QX() != cjVar.J0()) {
                cjVar.FH();
            } else {
                cjVar.Hw();
            }
        }
        this.u7.j6.j6();
        while (this.u7.j6.DW()) {
            cjVar = (cj) this.u7.j6.Hw();
            if (this.VH.cn.Hw(this.u7.j6.FH()).QX() != cjVar.J0()) {
                cjVar.FH();
            } else {
                cjVar.Hw();
            }
        }
    }

    public cj j6(bv bvVar, bj bjVar, int i, int i2, String str, int i3) {
        cj DW = DW(bvVar, bjVar);
        j6(bvVar, bjVar, this.Hw, false, ";" + str.substring(0, i3 - 1) + "i;", i, i2);
        if (DW.v5() == this.Hw.v5()) {
            return this.Hw;
        }
        return DW;
    }

    public cj j6(bv bvVar, bj bjVar, int i, int i2, String str) {
        cj DW = DW(bvVar, bjVar);
        j6(bvVar, bjVar, this.Hw, false, ";" + str + ";", i, i2);
        if (DW.v5() == this.Hw.v5()) {
            return this.Hw;
        }
        return DW;
    }

    public List<cj> j6(bv bvVar, int i, int i2, String str) {
        Map hashMap = new HashMap();
        for (bj put : bvVar.BT().Zo()) {
            hashMap.put(put, this.v5.DW());
        }
        j6(bvVar, hashMap, false, str, i, i2);
        List arrayList = new ArrayList();
        for (cj add : hashMap.values()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public cj j6(bv bvVar, int i, int i2) {
        if (bvVar.BT() == null) {
            return null;
        }
        cj cjVar;
        Set<String> hashSet = new HashSet();
        List<bj> Zo = bvVar.BT().Zo();
        for (bj bjVar : Zo) {
            if (!(bjVar.v5() == null || bjVar.v5().j6() == null)) {
                hashSet.add(bjVar.v5().j6());
            }
        }
        int i3 = Integer.MAX_VALUE;
        cj cjVar2 = null;
        loop1:
        for (String str : hashSet) {
            Map hashMap = new HashMap();
            for (bj bjVar2 : Zo) {
                if (bjVar2.v5() != null && str.equals(bjVar2.v5().j6())) {
                    hashMap.put(bjVar2, this.v5.DW());
                }
            }
            j6(bvVar, hashMap, false, str, i, i2);
            cj cjVar3 = cjVar2;
            int i4 = i3;
            for (Entry value : hashMap.entrySet()) {
                cjVar = (cj) value.getValue();
                int v5 = cjVar.v5(i, i2);
                if (v5 == 0) {
                    break loop1;
                }
                int i5;
                if (v5 <= i4 || cjVar.tp().u7() != null) {
                    i5 = v5;
                } else {
                    cjVar = cjVar3;
                    i5 = i4;
                }
                i4 = i5;
                cjVar3 = cjVar;
            }
            cjVar2 = cjVar3;
            i3 = i4;
        }
        cjVar = cjVar2;
        if (cjVar == null) {
            return null;
        }
        cj DW = DW(bvVar, cjVar.tp());
        if (DW.v5() == cjVar.v5()) {
            return cjVar;
        }
        return DW;
    }

    public cj DW(bv bvVar, bj bjVar, int i, int i2, String str) {
        cj DW = DW(bvVar, bjVar);
        j6(bvVar, bjVar, this.Hw, false, str, i, i2);
        if (DW.v5() == this.Hw.v5()) {
            return this.Hw;
        }
        return DW;
    }

    public List<cj> j6(bv bvVar) {
        return j6(bvVar, true);
    }

    public cj j6(bv bvVar, bj bjVar) {
        cj cjVar = null;
        for (cj cjVar2 : j6(bvVar)) {
            cj cjVar22;
            if (cjVar22.tp() != bjVar) {
                j6(cjVar22);
                cjVar22 = cjVar;
            }
            cjVar = cjVar22;
        }
        if (cjVar == null) {
            return DW(bvVar, bjVar);
        }
        return cjVar;
    }

    public cj DW(bv bvVar, int i, int i2) {
        cj cjVar = null;
        if (bvVar.BT() != null) {
            cj cjVar2;
            int i3 = Integer.MAX_VALUE;
            List<cj> j6 = j6(bvVar);
            cj cjVar3 = null;
            for (cj cjVar22 : j6) {
                cj cjVar4;
                if (cjVar3 == null) {
                    cjVar4 = cjVar22;
                } else {
                    cjVar4 = cjVar3;
                }
                int v5 = cjVar22.v5(i, i2);
                if (v5 == 0) {
                    cjVar = cjVar22;
                    cjVar22 = cjVar4;
                    break;
                }
                int i4;
                if (v5 < i3) {
                    i4 = v5;
                } else {
                    cjVar22 = cjVar;
                    i4 = i3;
                }
                cjVar3 = cjVar4;
                i3 = i4;
                cjVar = cjVar22;
            }
            cjVar22 = cjVar3;
            if (cjVar == null) {
                cjVar = cjVar22;
            }
            for (cj cjVar222 : j6) {
                if (cjVar222 != cjVar) {
                    j6(cjVar222);
                }
            }
        }
        return cjVar;
    }

    public cj FH(bv bvVar, int i, int i2) {
        cj cjVar = null;
        if (bvVar.BT() != null) {
            cj cjVar2;
            int i3 = Integer.MAX_VALUE;
            List<cj> DW = DW(bvVar);
            cj cjVar3 = null;
            for (cj cjVar22 : DW) {
                cj cjVar4;
                if (cjVar3 == null) {
                    cjVar4 = cjVar22;
                } else {
                    cjVar4 = cjVar3;
                }
                int v5 = cjVar22.v5(i, i2);
                if (v5 == 0) {
                    cjVar = cjVar22;
                    cjVar22 = cjVar4;
                    break;
                }
                int i4;
                if (v5 < i3) {
                    i4 = v5;
                } else {
                    cjVar22 = cjVar;
                    i4 = i3;
                }
                cjVar3 = cjVar4;
                i3 = i4;
                cjVar = cjVar22;
            }
            cjVar22 = cjVar3;
            if (cjVar == null) {
                cjVar = cjVar22;
            }
            for (cj cjVar222 : DW) {
                if (cjVar222 != cjVar) {
                    j6(cjVar222);
                }
            }
        }
        return cjVar;
    }

    public List<cj> DW(bv bvVar) {
        return j6(bvVar, false);
    }

    public cj DW(bv bvVar, bj bjVar) {
        int j6 = this.VH.cn.j6(bvVar, bjVar);
        this.EQ.j6(j6, ew.j6());
        cj cjVar;
        if (this.gn.j6(j6)) {
            this.tp.j6(j6, this.tp.FH(j6) + 1);
            cjVar = (cj) this.gn.FH(j6);
            if (!cjVar.u7()) {
                return cjVar;
            }
            j6(bvVar, bjVar, cjVar, true, null, 0, 0);
            return cjVar;
        } else if (this.u7.j6(j6)) {
            cjVar = (cj) this.u7.FH(j6);
            this.gn.j6(j6, cjVar);
            this.tp.j6(j6, 1);
            this.u7.DW(j6);
            if (!cjVar.u7()) {
                return cjVar;
            }
            j6(bvVar, bjVar, cjVar, true, null, 0, 0);
            return cjVar;
        } else {
            if (v5() >= DW) {
                cjVar = this.v5.DW();
                j6(bvVar, bjVar, cjVar, true, null, 0, 0);
                cj j62 = j6(cjVar.j6());
                if (j62 != null) {
                    int j63 = this.VH.cn.j6(j62.we(), j62.tp());
                    cjVar.j6(j62);
                    this.v5.j6(cjVar);
                    this.u7.DW(j63);
                    this.tp.j6(j6, 1);
                    this.gn.j6(j6, j62);
                    return j62;
                }
                this.v5.j6(cjVar);
            }
            cjVar = new cj(this.VH);
            this.gn.j6(j6, cjVar);
            this.tp.j6(j6, 1);
            j6(bvVar, bjVar, cjVar, true, null, 0, 0);
            return cjVar;
        }
    }

    private List<cj> j6(bv bvVar, boolean z) {
        List arrayList = new ArrayList();
        if (bvVar.BT() != null) {
            bj bjVar;
            cj cjVar;
            List<bj> Zo = bvVar.BT().Zo();
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            for (bj bjVar2 : Zo) {
                if (!z || bjVar2.u7() != null) {
                    int j6 = this.VH.cn.j6(bvVar, bjVar2);
                    this.EQ.j6(j6, ew.j6());
                    if (this.gn.j6(j6)) {
                        this.tp.j6(j6, this.tp.FH(j6) + 1);
                        cjVar = (cj) this.gn.FH(j6);
                        if (cjVar.u7()) {
                            hashMap.put(bjVar2, cjVar);
                        } else {
                            hashMap2.put(bjVar2, cjVar);
                        }
                    } else if (this.u7.j6(j6)) {
                        cjVar = (cj) this.u7.FH(j6);
                        this.gn.j6(j6, cjVar);
                        this.tp.j6(j6, 1);
                        this.u7.DW(j6);
                        if (cjVar.u7()) {
                            hashMap.put(bjVar2, cjVar);
                        } else {
                            hashMap2.put(bjVar2, cjVar);
                        }
                    } else {
                        hashMap.put(bjVar2, this.v5.DW());
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                j6(bvVar, hashMap, true, null, 0, 0);
            }
            for (Entry entry : hashMap.entrySet()) {
                cj j62;
                cjVar = (cj) entry.getValue();
                bjVar2 = (bj) entry.getKey();
                int j63 = this.VH.cn.j6(bvVar, bjVar2);
                if (v5() >= DW) {
                    j62 = j6(cjVar.j6());
                    if (j62 != null) {
                        this.u7.DW(this.VH.cn.j6(j62.we(), j62.tp()));
                        this.tp.j6(j63, 1);
                        this.gn.j6(j63, j62);
                        cjVar.j6(j62);
                        this.v5.j6(cjVar);
                        hashMap2.put(bjVar2, j62);
                    }
                }
                j62 = new cj(this.VH);
                this.gn.j6(j63, j62);
                this.tp.j6(j63, 1);
                cjVar.j6(j62);
                this.v5.j6(cjVar);
                hashMap2.put(bjVar2, j62);
            }
            for (bj bjVar22 : Zo) {
                if (hashMap2.containsKey(bjVar22)) {
                    arrayList.add(hashMap2.get(bjVar22));
                }
            }
        }
        return arrayList;
    }

    private cj j6(long j) {
        cj cjVar;
        cj cjVar2;
        if (null == null) {
            this.u7.j6.j6();
            cjVar = null;
            while (this.u7.j6.DW()) {
                cjVar2 = (cj) this.u7.j6.Hw();
                if (cjVar2.tp().Zo() != null || j >= cjVar2.DW() || (cjVar != null && cjVar.DW() <= cjVar2.DW())) {
                    cjVar2 = cjVar;
                }
                cjVar = cjVar2;
            }
            cjVar2 = cjVar;
        } else {
            cjVar2 = null;
        }
        if (cjVar2 == null) {
            this.u7.j6.j6();
            cjVar = cjVar2;
            while (this.u7.j6.DW()) {
                cjVar2 = (cj) this.u7.j6.Hw();
                if (j >= cjVar2.DW() || (cjVar != null && cjVar.DW() <= cjVar2.DW())) {
                    cjVar2 = cjVar;
                }
                cjVar = cjVar2;
            }
        } else {
            cjVar = cjVar2;
        }
        if (cjVar == null) {
            this.u7.j6.j6();
            long j2 = 0;
            cjVar = null;
            while (this.u7.j6.DW()) {
                cjVar2 = (cj) this.u7.j6.Hw();
                if (j2 < cjVar2.DW()) {
                    j2 = cjVar2.DW();
                } else {
                    cjVar2 = cjVar;
                }
                cjVar = cjVar2;
            }
        }
        return cjVar;
    }

    private void j6(bv bvVar, Map<bj, cj> map, boolean z, String str, int i, int i2) {
        Reader rN;
        try {
            if (bvVar.BT() != null) {
                for (Entry entry : map.entrySet()) {
                    cj cjVar = (cj) entry.getValue();
                    bj bjVar = (bj) entry.getKey();
                    cjVar.FH();
                    cjVar.j6(bvVar, bjVar);
                    cjVar.j6(bvVar.QX());
                    if (z) {
                        this.VH.sG.DW(bvVar, bjVar);
                    }
                }
                rN = bvVar.rN();
                if (str != null) {
                    rN = this.Zo.j6(rN, str, i, i2);
                }
                bvVar.BT().j6(bvVar, rN, map, z);
                rN.close();
            }
        } catch (IOException e) {
        } catch (Throwable th) {
            rN.close();
        }
    }

    public void j6(bv bvVar, bj bjVar, cj cjVar, boolean z, String str, int i, int i2) {
        Reader rN;
        try {
            cjVar.FH();
            cjVar.j6(bvVar, bjVar);
            cjVar.j6(bvVar.QX());
            if (bvVar.BT() != null) {
                if (z) {
                    this.VH.sG.DW(bvVar, bjVar);
                }
                rN = bvVar.rN();
                if (str != null) {
                    rN = this.Zo.j6(rN, str, i, i2);
                }
                Map hashMap = new HashMap();
                hashMap.put(bjVar, cjVar);
                bvVar.BT().j6(bvVar, rN, hashMap, z);
                rN.close();
                return;
            }
            cjVar.j6(cjVar.j6(0, true, new int[0], 0, 0, 1, 1));
        } catch (IOException e) {
            cjVar.j6(cjVar.j6(0, true, new int[0], 0, 0, 1, 1));
        } catch (Throwable th) {
            rN.close();
        }
    }

    protected void DW() {
        this.gn.j6.j6();
        while (this.gn.j6.DW()) {
            this.u7.j6(this.gn.j6.FH(), (cj) this.gn.j6.Hw());
        }
        this.tp.j6();
        this.gn.j6();
        this.v5.FH();
    }

    public void j6(cj cjVar) {
        int j6 = this.VH.cn.j6(cjVar.we(), cjVar.tp());
        int FH = this.tp.FH(j6) - 1;
        if (FH <= 0) {
            this.tp.j6(j6);
            this.gn.DW(j6);
            if (cjVar.j6() < FH) {
                this.u7.j6(j6, cjVar);
            }
            if (v5() > j6) {
                DW(DW);
                return;
            }
            return;
        }
        this.tp.j6(j6, FH);
    }

    public eb FH() {
        eb ebVar = new eb(this.VH.cn);
        this.u7.j6.j6();
        while (this.u7.j6.DW()) {
            ebVar.j6(this.VH.cn.Hw(this.u7.j6.FH()));
        }
        return ebVar;
    }

    protected void Hw() {
        DW(0);
        this.v5.j6();
    }

    private void DW(long j) {
        int i = 0;
        if (j == 0) {
            this.u7 = new dj();
            return;
        }
        long FH;
        if (this.we == null || this.we.length < this.u7.DW()) {
            this.we = new int[this.u7.DW()];
            this.J0 = new long[this.u7.DW()];
        }
        this.u7.j6.j6();
        int i2 = 0;
        while (this.u7.j6.DW()) {
            int i3;
            int FH2 = this.u7.j6.FH();
            long j6 = ((cj) this.u7.j6.Hw()).j6();
            FH = this.EQ.FH(FH2);
            if (j6 <= 0 || FH <= 0) {
                i3 = i2;
            } else {
                this.we[i2] = FH2;
                if (this.VH.cn.FH(FH2).u7() == null) {
                    FH += 1000;
                }
                this.J0[i2] = FH;
                i3 = i2 + 1;
            }
            i2 = i3;
        }
        j6(0, i2 - 1);
        FH = v5();
        while (i < i2 && FH > j) {
            cj cjVar = (cj) this.u7.FH(this.we[i]);
            this.u7.DW(this.we[i]);
            FH -= cjVar.j6();
            i++;
        }
    }

    private void j6(int i, int i2) {
        if (i < i2) {
            long j = this.J0[((i2 - i) / 2) + i];
            int i3 = i2;
            int i4 = i;
            while (i4 <= i3) {
                while (this.J0[i4] < j) {
                    i4++;
                }
                while (j < this.J0[i3]) {
                    i3--;
                }
                if (i4 <= i3) {
                    int i5 = this.we[i3];
                    this.we[i3] = this.we[i4];
                    this.we[i4] = i5;
                    long j2 = this.J0[i3];
                    this.J0[i3] = this.J0[i4];
                    this.J0[i4] = j2;
                    i4++;
                    i3--;
                }
            }
            j6(i, i3);
            j6(i4, i2);
        }
    }

    public long v5() {
        this.gn.j6.j6();
        long j = 0;
        while (this.gn.j6.DW()) {
            j = ((cj) this.gn.j6.Hw()).j6() + j;
        }
        this.u7.j6.j6();
        while (this.u7.j6.DW()) {
            j += ((cj) this.u7.j6.Hw()).j6();
        }
        return j;
    }
}
