import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

public final class us {
    private final int DW;
    private ArrayList<uf> FH;
    private boolean Hw;
    private int Zo;
    private final tq j6;
    private boolean v5;

    public us(tq tqVar, int i, int i2) {
        this.j6 = tqVar;
        this.DW = i2;
        this.FH = new ArrayList(i);
        this.Zo = -1;
        this.Hw = false;
        this.v5 = false;
    }

    public boolean j6() {
        return this.Hw;
    }

    public boolean DW() {
        return this.v5;
    }

    private static boolean DW(uf ufVar) {
        if (ufVar instanceof uo) {
            zy FH = ((uo) ufVar).FH();
            int Hw = FH.Hw();
            for (int i = 0; i < Hw; i++) {
                if (j6(FH.j6(i))) {
                    return true;
                }
            }
        } else if ((ufVar instanceof up) && j6(((up) ufVar).FH())) {
            return true;
        }
        return false;
    }

    private static boolean j6(zw zwVar) {
        return (zwVar == null || zwVar.u7().j6() == null) ? false : true;
    }

    public HashSet<aah> FH() {
        HashSet hashSet = new HashSet(20);
        Iterator it = this.FH.iterator();
        while (it.hasNext()) {
            j6(hashSet, (uf) it.next());
        }
        return hashSet;
    }

    private static void j6(HashSet<aah> hashSet, uf ufVar) {
        if (ufVar instanceof ud) {
            hashSet.add(((ud) ufVar).FH());
        } else if (ufVar instanceof uo) {
            zy FH = ((uo) ufVar).FH();
            int Hw = FH.Hw();
            for (int i = 0; i < Hw; i++) {
                j6((HashSet) hashSet, FH.j6(i));
            }
        } else if (ufVar instanceof up) {
            j6((HashSet) hashSet, ((up) ufVar).FH());
        }
    }

    private static void j6(HashSet<aah> hashSet, zw zwVar) {
        if (zwVar != null) {
            zq u7 = zwVar.u7();
            abe j6 = u7.j6();
            abe DW = u7.DW();
            abl j62 = zwVar.j6();
            if (j62 != abl.tp) {
                hashSet.add(abf.DW(j62));
            }
            if (j6 != null) {
                hashSet.add(j6);
            }
            if (DW != null) {
                hashSet.add(DW);
            }
        }
    }

    public void j6(uf ufVar) {
        this.FH.add(ufVar);
        FH(ufVar);
    }

    private void FH(uf ufVar) {
        if (!this.Hw && ufVar.u7().j6() >= 0) {
            this.Hw = true;
        }
        if (!this.v5 && DW(ufVar)) {
            this.v5 = true;
        }
    }

    public void j6(int i, uc ucVar) {
        int size = (this.FH.size() - i) - 1;
        try {
            this.FH.set(size, ((uz) this.FH.get(size)).j6(ucVar));
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("too few instructions");
        } catch (ClassCastException e2) {
            throw new IllegalArgumentException("non-reversible instruction");
        }
    }

    public void j6(ue$a ue_a) {
        Iterator it = this.FH.iterator();
        while (it.hasNext()) {
            uf ufVar = (uf) it.next();
            if (ufVar instanceof ud) {
                j6((ud) ufVar, ue_a);
            }
        }
    }

    private static void j6(ud udVar, ue$a ue_a) {
        aah FH = udVar.FH();
        int j6 = ue_a.j6(FH);
        if (j6 >= 0) {
            udVar.j6(j6);
        }
        if (FH instanceof aba) {
            int j62 = ue_a.j6(((aba) FH).J0());
            if (j62 >= 0) {
                udVar.DW(j62);
            }
        }
    }

    public ug Hw() {
        if (this.Zo >= 0) {
            throw new UnsupportedOperationException("already processed");
        }
        uh[] v5 = v5();
        j6(v5);
        FH(v5);
        Zo();
        return ug.j6(this.FH, this.Zo + this.DW);
    }

    private uh[] v5() {
        int size = this.FH.size();
        uh[] uhVarArr = new uh[size];
        for (int i = 0; i < size; i++) {
            uhVarArr[i] = ((uf) this.FH.get(i)).gn();
        }
        return uhVarArr;
    }

    private void j6(uh[] uhVarArr) {
        int i = this.Zo < 0 ? 0 : this.Zo;
        while (true) {
            int DW = DW(uhVarArr);
            if (i >= DW) {
                this.Zo = i;
                return;
            }
            int i2 = DW - i;
            int size = this.FH.size();
            for (int i3 = 0; i3 < size; i3++) {
                uf ufVar = (uf) this.FH.get(i3);
                if (!(ufVar instanceof uc)) {
                    this.FH.set(i3, ufVar.Hw(i2));
                }
            }
            i = DW;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int DW(uh[] r7) {
        /*
        r6 = this;
        r0 = r6.FH;
        r3 = r0.size();
        r1 = r6.Zo;
        r0 = 0;
        r2 = r0;
    L_0x000a:
        if (r2 >= r3) goto L_0x0039;
    L_0x000c:
        r0 = r6.FH;
        r0 = r0.get(r2);
        r0 = (uf) r0;
        r4 = r7[r2];
        r5 = r6.j6(r0, r4);
        if (r5 != 0) goto L_0x0035;
    L_0x001c:
        r4 = r6.Hw(r0);
        r4 = r4.FH();
        r4 = r4.FH(r0);
        r0 = r0.j6(r4);
        if (r0 <= r1) goto L_0x0037;
    L_0x002e:
        r7[r2] = r5;
        r1 = r0;
    L_0x0031:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x000a;
    L_0x0035:
        if (r4 == r5) goto L_0x0031;
    L_0x0037:
        r0 = r1;
        goto L_0x002e;
    L_0x0039:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: us.DW(uh[]):int");
    }

    private uh j6(uf ufVar, uh uhVar) {
        while (uhVar != null && !uhVar.FH().DW(ufVar)) {
            uhVar = ui.j6(uhVar, this.j6);
        }
        return uhVar;
    }

    private uh Hw(uf ufVar) {
        uh j6 = j6(ufVar.we(), ufVar.gn());
        if (j6 != null) {
            return j6;
        }
        throw new acz("No expanded opcode for " + ufVar);
    }

    private void FH(uh[] uhVarArr) {
        if (this.Zo == 0) {
            int size = this.FH.size();
            for (int i = 0; i < size; i++) {
                uf ufVar = (uf) this.FH.get(i);
                uh gn = ufVar.gn();
                uh uhVar = uhVarArr[i];
                if (gn != uhVar) {
                    this.FH.set(i, ufVar.j6(uhVar));
                }
            }
            return;
        }
        this.FH = Hw(uhVarArr);
    }

    private ArrayList<uf> Hw(uh[] uhVarArr) {
        int size = this.FH.size();
        ArrayList<uf> arrayList = new ArrayList(size * 2);
        for (int i = 0; i < size; i++) {
            Object obj;
            uh uhVar;
            Object obj2;
            Object Hw;
            uf ufVar = (uf) this.FH.get(i);
            uh gn = ufVar.gn();
            uh uhVar2 = uhVarArr[i];
            if (uhVar2 != null) {
                obj = null;
                uhVar = uhVar2;
                obj2 = null;
            } else {
                uhVar = Hw(ufVar);
                BitSet FH = uhVar.FH().FH(ufVar);
                obj = ufVar.DW(FH);
                obj2 = ufVar.FH(FH);
                Hw = ufVar.Hw(FH);
            }
            if (obj != null) {
                arrayList.add(obj);
            }
            if (uhVar != gn) {
                Hw = Hw.j6(uhVar);
            }
            arrayList.add(Hw);
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    private void Zo() {
        do {
            VH();
        } while (gn());
    }

    private void VH() {
        int size = this.FH.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            uf ufVar = (uf) this.FH.get(i2);
            ufVar.FH(i);
            i += ufVar.j6();
        }
    }

    private boolean gn() {
        int i = 0;
        int size = this.FH.size();
        boolean z = false;
        while (i < size) {
            boolean z2;
            uf ufVar = (uf) this.FH.get(i);
            if (ufVar instanceof uz) {
                uh gn = ufVar.gn();
                uz uzVar = (uz) ufVar;
                if (gn.FH().j6(uzVar)) {
                    z2 = z;
                } else {
                    int i2;
                    int i3;
                    if (gn.DW() == 40) {
                        uh j6 = j6(ufVar, gn);
                        if (j6 == null) {
                            throw new UnsupportedOperationException("method too long");
                        }
                        this.FH.set(i, ufVar.j6(j6));
                        i2 = i;
                        i3 = size;
                    } else {
                        try {
                            uc ucVar = (uc) this.FH.get(i + 1);
                            this.FH.set(i, new uz(ui.Sf, uzVar.u7(), zx.j6, uzVar.FH()));
                            this.FH.add(i, uzVar.j6(ucVar));
                            i3 = size + 1;
                            i2 = i + 1;
                        } catch (IndexOutOfBoundsException e) {
                            throw new IllegalStateException("unpaired TargetInsn (dangling)");
                        } catch (ClassCastException e2) {
                            throw new IllegalStateException("unpaired TargetInsn");
                        }
                    }
                    size = i3;
                    i = i2;
                    z2 = true;
                }
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        return z;
    }
}
