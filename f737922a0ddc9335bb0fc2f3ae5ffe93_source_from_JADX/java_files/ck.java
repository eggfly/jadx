import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ck {
    private Map<cj, dg> DW;
    private Map<cj, do> j6;

    public ck() {
        this.j6 = new HashMap();
        this.DW = new HashMap();
    }

    public void j6(List<cj> list) {
        for (cj j6 : list) {
            j6(j6);
        }
    }

    public void j6(cj cjVar) {
        Zo(cjVar, cjVar.Ws());
    }

    private void Zo(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        if (lg > 0) {
            for (int i2 = 0; i2 < lg; i2++) {
                Zo(cjVar, cjVar.Hw(i, i2));
            }
            return;
        }
        j6(cjVar, i);
    }

    public void j6(cj cjVar, int i) {
        if (!this.DW.containsKey(cjVar)) {
            this.DW.put(cjVar, new dg());
            this.j6.put(cjVar, new do());
        }
        dg dgVar = (dg) this.DW.get(cjVar);
        do doVar = (do) this.j6.get(cjVar);
        if (!dgVar.DW(i)) {
            dgVar.j6(i, doVar.Hw());
            doVar.j6(i);
            doVar.j6(cjVar.nw(i));
            doVar.j6(cjVar.KD(i));
            doVar.j6(cjVar.SI(i));
            doVar.j6(cjVar.ro(i));
        }
    }

    public void j6(int i, int i2, int i3, int i4, int i5) {
        if (!this.DW.containsKey(null)) {
            this.DW.put(null, new dg());
            this.j6.put(null, new do());
        }
        do doVar = (do) this.j6.get(null);
        ((dg) this.DW.get(null)).j6(i, doVar.Hw());
        doVar.j6(i);
        doVar.j6(i2);
        doVar.j6(i3);
        doVar.j6(i4);
        doVar.j6(i5);
    }

    public void j6() {
        this.j6.clear();
        this.DW.clear();
    }

    public void j6(int i, int i2, int i3, int i4, String str) {
        j6(i, i2, i3, i4);
        j6(i, i2, str);
    }

    public int DW(cj cjVar, int i) {
        if (this.DW.containsKey(cjVar)) {
            dg dgVar = (dg) this.DW.get(cjVar);
            do doVar = (do) this.j6.get(cjVar);
            if (dgVar.DW(i)) {
                return doVar.FH(dgVar.FH(i) + 1);
            }
            if (cjVar.lg(i) > 0) {
                return DW(cjVar, cjVar.Hw(i, 0));
            }
        }
        return cjVar.nw(i);
    }

    public int FH(cj cjVar, int i) {
        if (this.DW.containsKey(cjVar)) {
            dg dgVar = (dg) this.DW.get(cjVar);
            do doVar = (do) this.j6.get(cjVar);
            if (dgVar.DW(i)) {
                return doVar.FH(dgVar.FH(i) + 2);
            }
            if (cjVar.lg(i) > 0) {
                return FH(cjVar, cjVar.Hw(i, 0));
            }
        }
        return cjVar.KD(i);
    }

    public int j6(int i) {
        for (Entry key : this.DW.entrySet()) {
            cj cjVar = (cj) key.getKey();
            dg dgVar = (dg) this.DW.get(cjVar);
            do doVar = (do) this.j6.get(cjVar);
            if (dgVar.DW(i)) {
                return doVar.FH(dgVar.FH(i) + 3);
            }
        }
        return 0;
    }

    public int Hw(cj cjVar, int i) {
        if (this.DW.containsKey(cjVar)) {
            dg dgVar = (dg) this.DW.get(cjVar);
            do doVar = (do) this.j6.get(cjVar);
            if (dgVar.DW(i)) {
                return doVar.FH(dgVar.FH(i) + 3);
            }
            if (cjVar.lg(i) > 0) {
                return Hw(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
            }
        }
        return cjVar.SI(i);
    }

    public int v5(cj cjVar, int i) {
        if (this.DW.containsKey(cjVar)) {
            dg dgVar = (dg) this.DW.get(cjVar);
            do doVar = (do) this.j6.get(cjVar);
            if (dgVar.DW(i)) {
                return doVar.FH(dgVar.FH(i) + 4);
            }
            if (cjVar.lg(i) > 0) {
                return v5(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
            }
        }
        return cjVar.ro(i);
    }

    public void j6(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 == i5) {
            DW(i, i2, i6 - i4);
            return;
        }
        DW(i, i2, i6 - 1);
        while (i3 < i5) {
            j6(i, i2);
            i3++;
        }
    }

    public void j6(int i, int i2, int i3, int i4) {
        if (i == i3) {
            j6(i, i2, i4 - i2);
            return;
        }
        j6(i3, 1, i4 - i2);
        for (Entry key : this.DW.entrySet()) {
            cj cjVar = (cj) key.getKey();
            dg dgVar = (dg) this.DW.get(cjVar);
            do doVar = (do) this.j6.get(cjVar);
            for (int i5 = 0; i5 < doVar.Hw(); i5 += 5) {
                if (doVar.FH(i5 + 1) > i) {
                    doVar.j6(i5 + 1, doVar.FH(i5 + 1) - (i3 - i));
                }
                if (doVar.FH(i5 + 3) > i) {
                    doVar.j6(i5 + 3, doVar.FH(i5 + 3) - (i3 - i));
                }
            }
        }
    }

    public void j6(int i, int i2, int i3) {
        DW(i, i2, -i3);
    }

    public void j6(int i, int i2, String str) {
        int i3 = 0;
        if (str.lastIndexOf(10) == -1) {
            DW(i, i2, str.length());
            return;
        }
        DW(i, i2, (str.length() - str.lastIndexOf(10)) - 1);
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            if (str.charAt(i5) == '\n') {
                i4++;
            }
        }
        while (i3 < i4) {
            j6(i, i2);
            i3++;
        }
    }

    public void DW(int i, int i2, int i3) {
        for (Entry key : this.DW.entrySet()) {
            cj cjVar = (cj) key.getKey();
            dg dgVar = (dg) this.DW.get(cjVar);
            do doVar = (do) this.j6.get(cjVar);
            int i4 = 0;
            while (i4 < doVar.Hw()) {
                if (doVar.FH(i4 + 1) == i && doVar.FH(i4 + 2) >= i2) {
                    doVar.j6(i4 + 2, doVar.FH(i4 + 2) + i3);
                }
                if (doVar.FH(i4 + 3) == i && doVar.FH(i4 + 4) > i2) {
                    doVar.j6(i4 + 4, doVar.FH(i4 + 4) + i3);
                }
                i4 += 5;
            }
        }
    }

    public void j6(int i, int i2) {
        for (Entry key : this.DW.entrySet()) {
            do doVar = (do) this.j6.get((cj) key.getKey());
            for (int i3 = 0; i3 < doVar.Hw(); i3 += 5) {
                int FH = doVar.FH(i3 + 1);
                int FH2 = doVar.FH(i3 + 2);
                int FH3 = doVar.FH(i3 + 3);
                int FH4 = doVar.FH(i3 + 4);
                if (FH3 >= i) {
                    if (FH > i) {
                        doVar.j6(i3 + 1, FH + 1);
                    } else if (FH == i && FH2 >= i2) {
                        doVar.j6(i3 + 1, FH + 1);
                        doVar.j6(i3 + 2, (FH2 - i2) + 1);
                    }
                    if (FH3 > i) {
                        doVar.j6(i3 + 3, FH3 + 1);
                    } else if (FH3 == i && FH4 > i2) {
                        doVar.j6(i3 + 3, FH3 + 1);
                        doVar.j6(i3 + 4, (FH4 - i2) + 1);
                    }
                }
            }
        }
    }
}
