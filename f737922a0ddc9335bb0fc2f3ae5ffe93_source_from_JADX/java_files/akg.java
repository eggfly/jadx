import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class akg {
    private static /* synthetic */ int[] EQ;
    private static final Comparator<ajt> j6;
    private List<ajt> DW;
    private List<ajt> FH;
    private List<ajt> Hw;
    private int VH;
    private final aoh Zo;
    private int gn;
    private boolean tp;
    private int u7;
    private boolean v5;

    static /* synthetic */ int[] v5() {
        int[] iArr = EQ;
        if (iArr == null) {
            iArr = new int[ajt$a.values().length];
            try {
                iArr[ajt$a.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ajt$a.COPY.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ajt$a.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ajt$a.MODIFY.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ajt$a.RENAME.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            EQ = iArr;
        }
        return iArr;
    }

    static {
        j6 = new akg$1();
    }

    public akg(aoh aoh) {
        this.VH = 60;
        this.gn = -1;
        this.Zo = aoh;
        this.u7 = ((ajs) aoh.VH().j6(ajs.j6)).FH();
        Hw();
    }

    public int j6() {
        return this.VH;
    }

    public int DW() {
        return this.u7;
    }

    public void j6(Collection<ajt> collection) {
        if (this.v5) {
            throw new IllegalStateException(JGitText.j6().renamesAlreadyFound);
        }
        for (ajt ajt : collection) {
            switch (v5()[ajt.v5().ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.Hw.add(ajt);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    if (!j6(ajt.FH(), ajt.Hw())) {
                        List j6 = ajt.j6(ajt);
                        this.FH.add((ajt) j6.get(0));
                        this.Hw.add((ajt) j6.get(1));
                        break;
                    }
                    this.DW.add(ajt);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.FH.add(ajt);
                    break;
                default:
                    this.DW.add(ajt);
                    break;
            }
        }
    }

    public List<ajt> FH() {
        return j6(anp.j6);
    }

    public List<ajt> j6(aob aob) {
        if (this.v5) {
            return Collections.unmodifiableList(this.DW);
        }
        any v5 = this.Zo.v5();
        try {
            List<ajt> j6 = j6(v5, aob);
            return j6;
        } finally {
            v5.FH();
        }
    }

    public List<ajt> j6(any any, aob aob) {
        ajq j6 = ajq.j6(any);
        return j6(new ajq$c(j6, j6), aob);
    }

    public List<ajt> j6(ajq$c ajq_c, aob aob) {
        if (!this.v5) {
            this.v5 = true;
            if (aob == null) {
                aob = anp.j6;
            }
            if (this.gn > 0) {
                DW(ajq_c, aob);
            }
            if (!(this.Hw.isEmpty() || this.FH.isEmpty())) {
                FH(aob);
            }
            if (!(this.Hw.isEmpty() || this.FH.isEmpty())) {
                FH(ajq_c, aob);
            }
            if (!(this.gn <= 0 || this.Hw.isEmpty() || this.FH.isEmpty())) {
                DW(aob);
            }
            this.DW.addAll(this.Hw);
            this.Hw = null;
            this.DW.addAll(this.FH);
            this.FH = null;
            Collections.sort(this.DW, j6);
        }
        return Collections.unmodifiableList(this.DW);
    }

    public void Hw() {
        this.DW = new ArrayList();
        this.FH = new ArrayList();
        this.Hw = new ArrayList();
        this.v5 = false;
    }

    private void DW(ajq$c ajq_c, aob aob) {
        List arrayList = new ArrayList(this.DW.size());
        aob.j6(JGitText.j6().renamesBreakingModifies, this.DW.size());
        for (int i = 0; i < this.DW.size(); i++) {
            ajt ajt = (ajt) this.DW.get(i);
            if (ajt.v5() == ajt$a.MODIFY) {
                int j6 = j6(ajq_c, ajt);
                if (j6 < this.gn) {
                    List j62 = ajt.j6(ajt);
                    ajt = (ajt) j62.get(0);
                    ajt.VH = j6;
                    this.FH.add(ajt);
                    this.Hw.add((ajt) j62.get(1));
                } else {
                    arrayList.add(ajt);
                }
            } else {
                arrayList.add(ajt);
            }
            aob.j6(1);
        }
        this.DW = arrayList;
    }

    private void DW(aob aob) {
        HashMap hashMap = new HashMap();
        List arrayList = new ArrayList(this.Hw.size());
        aob.j6(JGitText.j6().renamesRejoiningModifies, this.Hw.size() + this.FH.size());
        for (ajt ajt : this.FH) {
            hashMap.put(ajt.DW, ajt);
            aob.j6(1);
        }
        for (ajt ajt2 : this.Hw) {
            ajt ajt3 = (ajt) hashMap.remove(ajt2.FH);
            if (ajt3 == null) {
                arrayList.add(ajt2);
            } else if (j6(ajt3.Hw, ajt2.v5)) {
                this.DW.add(ajt.j6(ajt$a.MODIFY, ajt3, ajt2, ajt3.VH));
            } else {
                hashMap.put(ajt3.DW, ajt3);
                arrayList.add(ajt2);
            }
            aob.j6(1);
        }
        this.Hw = arrayList;
        this.FH = new ArrayList(hashMap.values());
    }

    private int j6(ajq$c ajq_c, ajt ajt) {
        try {
            akj akj = new akj();
            akj.j6(ajq_c.DW(ajt$b.OLD, ajt));
            akj.j6();
            akj akj2 = new akj();
            akj2.j6(ajq_c.DW(ajt$b.NEW, ajt));
            akj2.j6();
            return akj.j6(akj2, 100);
        } catch (akj$a e) {
            this.tp = true;
            return this.gn + 1;
        }
    }

    private void FH(ajq$c ajq_c, aob aob) {
        int max = Math.max(this.Hw.size(), this.FH.size());
        if (DW() == 0 || max <= DW()) {
            akk akk = new akk(ajq_c, this.FH, this.Hw);
            akk.j6(j6());
            akk.j6(aob);
            this.tp |= akk.Hw();
            this.FH = akk.DW();
            this.Hw = akk.FH();
            this.DW.addAll(akk.j6());
            return;
        }
        this.tp = true;
    }

    private void FH(aob aob) {
        ajt ajt;
        aob.j6(JGitText.j6().renamesFindingExact, ((this.Hw.size() + this.Hw.size()) + this.FH.size()) + (this.Hw.size() * this.FH.size()));
        HashMap j6 = j6(this.FH, aob);
        HashMap j62 = j6(this.Hw, aob);
        ArrayList arrayList = new ArrayList(this.Hw.size());
        ArrayList arrayList2 = new ArrayList();
        for (Object next : j62.values()) {
            Object next2;
            if (next2 instanceof ajt) {
                arrayList.add((ajt) next2);
            } else {
                arrayList2.add((List) next2);
            }
        }
        List arrayList3 = new ArrayList(this.Hw.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ajt ajt2 = (ajt) it.next();
            next2 = j6.get(ajt2.u7);
            if (next2 instanceof ajt) {
                ajt = (ajt) next2;
                if (j6(ajt.Hw, ajt2.v5)) {
                    ajt.Zo = ajt$a.RENAME;
                    this.DW.add(j6(ajt, ajt2));
                } else {
                    arrayList3.add(ajt2);
                }
            } else if (next2 != null) {
                ajt = j6(ajt2, (List) next2);
                if (ajt != null) {
                    ajt.Zo = ajt$a.RENAME;
                    this.DW.add(j6(ajt, ajt2));
                } else {
                    arrayList3.add(ajt2);
                }
            } else {
                arrayList3.add(ajt2);
            }
            aob.j6(1);
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            List<ajt> list = (List) it2.next();
            Object obj = j6.get(((ajt) list.get(0)).u7);
            ajt j63;
            if (obj instanceof ajt) {
                ajt2 = (ajt) obj;
                j63 = j6(ajt2, (List) list);
                if (j63 != null) {
                    ajt2.Zo = ajt$a.RENAME;
                    this.DW.add(j6(ajt2, j63));
                    for (ajt ajt3 : list) {
                        if (ajt3 != j63) {
                            if (j6(ajt2.Hw, ajt3.v5)) {
                                this.DW.add(DW(ajt2, ajt3));
                            } else {
                                arrayList3.add(ajt3);
                            }
                        }
                    }
                } else {
                    arrayList3.addAll(list);
                }
            } else if (obj != null) {
                int i;
                List list2 = (List) obj;
                long[] jArr = new long[(list2.size() * list.size())];
                int i2 = 0;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    String str = ((ajt) list2.get(i3)).DW;
                    for (i = 0; i < list.size(); i++) {
                        jArr[i2] = akk.j6(akk.j6(((ajt) list.get(i)).FH, str), i3, i);
                        i2++;
                    }
                }
                Arrays.sort(jArr);
                for (i = i2 - 1; i >= 0; i--) {
                    long j = jArr[i];
                    i2 = akk.j6(j);
                    int DW = akk.DW(j);
                    j63 = (ajt) list2.get(i2);
                    ajt ajt4 = (ajt) list.get(DW);
                    if (ajt4 == null) {
                        aob.j6(1);
                    } else {
                        ajt$a ajt_a;
                        if (j63.Zo == ajt$a.DELETE) {
                            j63.Zo = ajt$a.RENAME;
                            ajt_a = ajt$a.RENAME;
                        } else {
                            ajt_a = ajt$a.COPY;
                        }
                        this.DW.add(ajt.j6(ajt_a, j63, ajt4, 100));
                        list.set(DW, null);
                        aob.j6(1);
                    }
                }
            } else {
                arrayList3.addAll(list);
            }
        }
        this.Hw = arrayList3;
        this.FH = new ArrayList(j6.size());
        for (Object next22 : j6.values()) {
            if (next22 instanceof ajt) {
                ajt3 = (ajt) next22;
                if (ajt3.Zo == ajt$a.DELETE) {
                    this.FH.add(ajt3);
                }
            } else {
                for (ajt ajt32 : (List) next22) {
                    if (ajt32.Zo == ajt$a.DELETE) {
                        this.FH.add(ajt32);
                    }
                }
            }
        }
        aob.DW();
    }

    private static ajt j6(ajt ajt, List<ajt> list) {
        ajt ajt2 = null;
        int i = -1;
        for (ajt ajt3 : list) {
            if (j6(DW(ajt3), DW(ajt))) {
                int j6 = akk.j6(j6(ajt3), j6(ajt));
                if (j6 > i) {
                    i = j6;
                    ajt2 = ajt3;
                }
            }
        }
        return ajt2;
    }

    private HashMap<amz, Object> j6(List<ajt> list, aob aob) {
        HashMap<amz, Object> hashMap = new HashMap();
        for (ajt ajt : list) {
            Object put = hashMap.put(FH(ajt), ajt);
            if (put instanceof ajt) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add((ajt) put);
                arrayList.add(ajt);
                hashMap.put(FH(ajt), arrayList);
            } else if (put != null) {
                ((List) put).add(ajt);
                hashMap.put(FH(ajt), put);
            }
            aob.j6(1);
        }
        return hashMap;
    }

    private static String j6(ajt ajt) {
        return ajt.Zo == ajt$a.DELETE ? ajt.DW : ajt.FH;
    }

    private static anl DW(ajt ajt) {
        return ajt.Zo == ajt$a.DELETE ? ajt.Hw : ajt.v5;
    }

    private static amz FH(ajt ajt) {
        return ajt.Zo == ajt$a.DELETE ? ajt.gn : ajt.u7;
    }

    static boolean j6(anl anl, anl anl2) {
        return (anl.FH() & 61440) == (anl2.FH() & 61440);
    }

    private static ajt j6(ajt ajt, ajt ajt2) {
        return ajt.j6(ajt$a.RENAME, ajt, ajt2, 100);
    }

    private static ajt DW(ajt ajt, ajt ajt2) {
        return ajt.j6(ajt$a.COPY, ajt, ajt2, 100);
    }
}
