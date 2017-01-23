import java.util.ArrayList;
import java.util.Iterator;

public class se extends sd {
    private final ArrayList<sd> DW;
    private final sh j6;

    public /* synthetic */ sd j6(sd sdVar) {
        return DW(sdVar);
    }

    public se(int i) {
        super(i != 0);
        this.j6 = new sh(i);
        this.DW = new ArrayList();
    }

    public se(sh shVar, ArrayList<sd> arrayList) {
        super(shVar.Zo() > 0);
        this.j6 = shVar;
        this.DW = arrayList;
    }

    private se(se seVar) {
        int i = 0;
        super(seVar.v5() > 0);
        this.j6 = seVar.j6.v5();
        this.DW = new ArrayList(seVar.DW.size());
        int size = seVar.DW.size();
        while (i < size) {
            sd sdVar = (sd) seVar.DW.get(i);
            if (sdVar == null) {
                this.DW.add(null);
            } else {
                this.DW.add(sdVar.j6());
            }
            i++;
        }
    }

    public void l_() {
        this.j6.l_();
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            sd sdVar = (sd) it.next();
            if (sdVar != null) {
                sdVar.l_();
            }
        }
        super.l_();
    }

    public sd j6() {
        return new se(this);
    }

    public void j6(ada ada) {
        ada.j6("(locals array set; primary)");
        this.j6.j6(ada);
        int size = this.DW.size();
        for (int i = 0; i < size; i++) {
            sd sdVar = (sd) this.DW.get(i);
            if (sdVar != null) {
                ada.j6("(locals array set: primary for caller " + add.FH(i) + ')');
                sdVar.DW().j6(ada);
            }
        }
    }

    public String Hw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(locals array set; primary)\n");
        stringBuilder.append(DW().Hw());
        stringBuilder.append('\n');
        int size = this.DW.size();
        for (int i = 0; i < size; i++) {
            sd sdVar = (sd) this.DW.get(i);
            if (sdVar != null) {
                stringBuilder.append("(locals array set: primary for caller " + add.FH(i) + ")\n");
                stringBuilder.append(sdVar.DW().Hw());
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }

    public void j6(abl abl) {
        if (this.j6.Zo() != 0) {
            we();
            this.j6.j6(abl);
            Iterator it = this.DW.iterator();
            while (it.hasNext()) {
                sd sdVar = (sd) it.next();
                if (sdVar != null) {
                    sdVar.j6(abl);
                }
            }
        }
    }

    public int v5() {
        return this.j6.Zo();
    }

    public void j6(int i, abm abm) {
        we();
        this.j6.j6(i, abm);
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            sd sdVar = (sd) it.next();
            if (sdVar != null) {
                sdVar.j6(i, abm);
            }
        }
    }

    public void j6(zw zwVar) {
        j6(zwVar.VH(), (abm) zwVar);
    }

    public abm j6(int i) {
        return this.j6.j6(i);
    }

    private se j6(se seVar) {
        sh j6 = this.j6.j6(seVar.DW());
        int size = this.DW.size();
        int size2 = seVar.DW.size();
        int max = Math.max(size, size2);
        ArrayList arrayList = new ArrayList(max);
        int i = 0;
        Object obj = null;
        while (i < max) {
            sd sdVar;
            sd sdVar2;
            sd sdVar3;
            Object obj2;
            if (i < size) {
                sdVar = (sd) this.DW.get(i);
            } else {
                sdVar = null;
            }
            if (i < size2) {
                sdVar2 = (sd) seVar.DW.get(i);
            } else {
                sdVar2 = null;
            }
            if (sdVar == sdVar2) {
                sdVar3 = sdVar;
            } else if (sdVar == null) {
                sdVar3 = sdVar2;
            } else if (sdVar2 == null) {
                sdVar3 = sdVar;
            } else {
                try {
                    sdVar3 = sdVar.j6(sdVar2);
                } catch (sl e) {
                    e.j6("Merging locals set for caller block " + add.FH(i));
                    sdVar3 = null;
                }
            }
            if (obj == null && sdVar == sdVar3) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            arrayList.add(sdVar3);
            i++;
            obj = obj2;
        }
        if (this.j6 == j6 && obj == null) {
            return this;
        }
        this(j6, arrayList);
        return this;
    }

    private se j6(sh shVar) {
        sh j6 = this.j6.j6(shVar.DW());
        ArrayList arrayList = new ArrayList(this.DW.size());
        int size = this.DW.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            sd sdVar = (sd) this.DW.get(i);
            sd sdVar2 = null;
            if (sdVar != null) {
                try {
                    sdVar2 = sdVar.j6((sd) shVar);
                } catch (sl e) {
                    e.j6("Merging one locals against caller block " + add.FH(i));
                }
            }
            if (obj == null && sdVar == sdVar2) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            arrayList.add(sdVar2);
            i++;
            obj = obj2;
        }
        if (this.j6 == j6 && obj == null) {
            return this;
        }
        this(j6, arrayList);
        return this;
    }

    public se DW(sd sdVar) {
        try {
            se j6;
            if (sdVar instanceof se) {
                j6 = j6((se) sdVar);
            } else {
                j6 = j6((sh) sdVar);
            }
            j6.l_();
            return j6;
        } catch (ada e) {
            e.j6("underlay locals:");
            j6(e);
            e.j6("overlay locals:");
            sdVar.j6(e);
            throw e;
        }
    }

    private sd FH(int i) {
        if (i >= this.DW.size()) {
            return null;
        }
        return (sd) this.DW.get(i);
    }

    public se j6(sd sdVar, int i) {
        sd sdVar2;
        sd FH = FH(i);
        sh j6 = this.j6.j6(sdVar.DW());
        if (FH == sdVar) {
            sdVar2 = FH;
        } else if (FH == null) {
            sdVar2 = sdVar;
        } else {
            sdVar2 = FH.j6(sdVar);
        }
        if (sdVar2 == FH && j6 == this.j6) {
            return this;
        }
        int size = this.DW.size();
        int max = Math.max(i + 1, size);
        ArrayList arrayList = new ArrayList(max);
        int i2 = 0;
        j6 = null;
        while (i2 < max) {
            sd sdVar3;
            sh shVar;
            if (i2 == i) {
                sdVar3 = sdVar2;
            } else if (i2 < size) {
                sdVar3 = (sd) this.DW.get(i2);
            } else {
                sdVar3 = null;
            }
            if (sdVar3 == null) {
                shVar = j6;
            } else if (j6 == null) {
                shVar = sdVar3.DW();
            } else {
                shVar = j6.j6(sdVar3.DW());
            }
            arrayList.add(sdVar3);
            i2++;
            j6 = shVar;
        }
        this(j6, arrayList);
        l_();
        return this;
    }

    public sd DW(int i) {
        return FH(i);
    }

    protected sh DW() {
        return this.j6;
    }
}
