import com.aide.uidesigner.ProxyTextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.JGitText;

class avt extends atg {
    private final anq DW;
    private LinkedList<ans> EQ;
    private final List<avv> FH;
    private int Hw;
    private final LinkedList<avv> J0;
    private final LinkedList<avt$a> J8;
    private final anw Mr;
    private final ano QX;
    private final any U2;
    private final aqe VH;
    private final Set<String> Ws;
    private final HashMap<ans, List<Throwable>> XL;
    private final awc Zo;
    private String aM;
    private final aqe gn;
    private final List<arw> j3;
    private final aoh j6;
    private final apo tp;
    private final aqe u7;
    private final aql v5;
    private final LinkedList<avv> we;

    avt(avw avw, avv avv) {
        this.QX = new ano();
        avd avd = (avd) avw;
        this.j6 = avd.FH;
        this.DW = avd.gn() ? new anq() : null;
        this.Mr = this.j6.Hw();
        this.U2 = this.j6.v5();
        this.FH = new ArrayList();
        this.FH.add(avv);
        this.J8 = new LinkedList();
        this.Ws = new HashSet();
        this.we = new LinkedList();
        this.we.add(avv);
        this.J0 = new LinkedList();
        this.J0.add(avv);
        this.XL = new HashMap();
        this.j3 = new ArrayList(4);
        this.v5 = new aql(this.U2);
        this.v5.j6(false);
        this.Zo = new awc(this.U2);
        this.VH = this.v5.j6("COMPLETE");
        this.gn = this.v5.j6("IN_WORK_QUEUE");
        this.u7 = this.v5.j6("LOCALLY_SEEN");
        this.tp = new apo();
        this.EQ = new LinkedList();
    }

    public boolean EQ() {
        return true;
    }

    protected void DW(aob aob, Collection<aoc> collection, Set<ans> set) {
        j6((Set) set);
        j6((Collection) collection);
        while (!aob.j6() && !this.EQ.isEmpty()) {
            ans ans = (ans) this.EQ.removeFirst();
            if (!(ans instanceof aqg) || !((aqg) ans).DW(this.VH)) {
                j6(aob, (anb) ans);
            }
            j6(ans);
        }
    }

    public Collection<arw> we() {
        return this.j3;
    }

    public void FH(String str) {
        this.aM = str;
    }

    public void u7() {
        this.Mr.Hw();
        this.U2.FH();
        Iterator it = this.J8.iterator();
        while (it.hasNext()) {
            avt$a avt_a = (avt$a) it.next();
            if (avt_a.Hw != null) {
                avt_a.Hw.delete();
            }
        }
        for (avv v5 : this.FH) {
            v5.v5();
        }
    }

    private void j6(Collection<aoc> collection) {
        HashSet hashSet = new HashSet();
        for (aoc v5 : collection) {
            anb v52 = v5.v5();
            try {
                aqg gn = this.v5.gn(v52);
                if (!gn.DW(this.VH) && hashSet.add(v52)) {
                    gn.FH(this.gn);
                    this.EQ.add(gn);
                }
            } catch (ali e) {
                if (hashSet.add(v52)) {
                    this.EQ.add(v52);
                }
            } catch (Throwable e2) {
                throw new amb(MessageFormat.format(JGitText.j6().cannotRead, new Object[]{v52.DW()}), e2);
            }
        }
    }

    private void j6(ans ans) {
        try {
            aqg aqg;
            if (ans instanceof aqg) {
                aqg = (aqg) ans;
                if (!aqg.DW(this.VH)) {
                    this.v5.Zo(aqg);
                } else {
                    return;
                }
            }
            aqg = this.v5.gn(ans);
            if (aqg.DW(this.VH)) {
                return;
            }
            switch (aqg.v_()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    FH(aqg);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    DW(aqg);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    j6(aqg);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    Hw(aqg);
                    break;
                default:
                    throw new amb(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{ans.DW()}));
            }
            this.XL.remove(ans);
        } catch (Throwable e) {
            throw new amb(MessageFormat.format(JGitText.j6().cannotRead, new Object[]{ans.DW()}), e);
        }
    }

    private void j6(aqg aqg) {
        try {
            if (this.U2.DW((anb) aqg, 3)) {
                aqg.FH(this.VH);
                return;
            }
            throw new amb(MessageFormat.format(JGitText.j6().cannotReadBlob, new Object[]{aqg.DW()}), new ali((ans) aqg, "blob"));
        } catch (Throwable e) {
            throw new amb(MessageFormat.format(JGitText.j6().cannotReadBlob, new Object[]{aqg.DW()}), e);
        }
    }

    private void DW(aqg aqg) {
        this.Zo.j6((anb) aqg);
        while (this.Zo.EQ()) {
            try {
                anl DW = this.Zo.DW(0);
                int DW2 = DW.DW();
                switch (DW2) {
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        this.Zo.j6(this.QX, 0);
                        v5(this.v5.j6(this.QX, DW2));
                        break;
                    default:
                        if (anl.v5.equals(DW)) {
                            break;
                        }
                        this.Zo.j6(this.QX, 0);
                        throw new ala(MessageFormat.format(JGitText.j6().invalidModeFor, new Object[]{DW, this.QX.DW(), this.Zo.we(), aqg.XL().DW()}));
                }
            } catch (Throwable e) {
                throw new amb(MessageFormat.format(JGitText.j6().cannotReadTree, new Object[]{aqg.DW()}), e);
            }
        }
        aqg.FH(this.VH);
    }

    private void FH(aqg aqg) {
        aqc aqc = (aqc) aqg;
        j6(aqc.gn());
        v5(aqc.u7());
        for (aqg v5 : aqc.EQ()) {
            v5(v5);
        }
        aqg.FH(this.VH);
    }

    private void Hw(aqg aqg) {
        v5(((aqj) aqg).gn());
        aqg.FH(this.VH);
    }

    private void v5(aqg aqg) {
        if (!aqg.DW(this.VH) && !aqg.DW(this.gn)) {
            aqg.FH(this.gn);
            this.EQ.add(aqg);
        }
    }

    private void j6(aob aob, anb anb) {
        Collection FH;
        if (j6(anb)) {
            return;
        }
        while (!DW(aob, anb)) {
            int i;
            String DW = anb.DW();
            String substring = DW.substring(0, 2);
            String stringBuilder = new StringBuilder(String.valueOf(substring)).append("/").append(DW.substring(2)).toString();
            for (i = this.Hw; i < this.FH.size(); i++) {
                if (j6(anb, stringBuilder, (avv) this.FH.get(i))) {
                    this.Hw = i;
                    return;
                }
            }
            for (i = 0; i < this.Hw; i++) {
                if (j6(anb, stringBuilder, (avv) this.FH.get(i))) {
                    this.Hw = i;
                    return;
                }
            }
            while (!this.we.isEmpty()) {
                avv avv = (avv) this.we.removeFirst();
                try {
                    aob.j6("Listing packs", 0);
                    FH = avv.FH();
                    if (!(r0 == null || r0.isEmpty())) {
                        for (String DW2 : r0) {
                            if (this.Ws.add(DW2)) {
                                this.J8.add(new avt$a(this, avv, DW2));
                            }
                        }
                        if (DW(aob, anb)) {
                            return;
                        }
                    }
                } catch (IOException e) {
                    FH = e;
                    j6(anb, (Throwable) FH);
                } finally {
                    aob.DW();
                }
            }
            Collection<avv> j6 = j6(anb, aob);
            if (j6 == null || j6.isEmpty()) {
                List list = (List) this.XL.get(anb);
                amb amb = new amb(MessageFormat.format(JGitText.j6().cannotGet, new Object[]{anb.DW()}));
                if (!(list == null || list.isEmpty())) {
                    if (list.size() == 1) {
                        amb.initCause((Throwable) list.get(0));
                    } else {
                        amb.initCause(new aky(list));
                    }
                }
                throw amb;
            }
            for (avv avv2 : j6) {
                this.FH.add(avv2);
                this.we.add(avv2);
                this.J0.add(avv2);
            }
        }
    }

    private boolean j6(anb anb) {
        try {
            return this.U2.DW(anb);
        } catch (Throwable e) {
            throw new amb(MessageFormat.format(JGitText.j6().cannotReadObject, new Object[]{anb.DW()}), e);
        }
    }

    private boolean DW(aob aob, anb anb) {
        int i = 1;
        boolean z = false;
        Iterator it = this.J8.iterator();
        while (it.hasNext() && !aob.j6()) {
            avt$a avt_a = (avt$a) it.next();
            try {
                avt_a.j6(aob);
                if (aob.j6()) {
                    return z;
                }
                if (avt_a.v5.j6(anb)) {
                    try {
                        avt_a.DW(aob);
                        try {
                            if (avt_a.Hw != null) {
                                awv.j6(avt_a.Hw);
                            }
                            it.remove();
                            if (j6(anb)) {
                                it = VH();
                                while (it.hasNext()) {
                                    ans ans = (ans) it.next();
                                    if (avt_a.v5.j6((anb) ans)) {
                                        it.remove();
                                        j6(ans);
                                    } else {
                                        this.EQ.add(ans);
                                    }
                                }
                                return i;
                            }
                            j6(anb, new FileNotFoundException(MessageFormat.format(JGitText.j6().objectNotFoundIn, new Object[]{anb.DW(), avt_a.DW})));
                        } catch (Throwable e) {
                            throw new amb(e.getMessage(), e);
                        }
                    } catch (Throwable e2) {
                        j6(anb, e2);
                    } finally {
                        try {
                            i = avt_a.Hw;
                            if (i != 0) {
                                awv.j6(avt_a.Hw);
                            }
                            it.remove();
                        } catch (Throwable e3) {
                            throw new amb(e3.getMessage(), e3);
                        }
                    }
                }
                continue;
            } catch (Throwable e32) {
                j6(anb, e32);
                it.remove();
            }
        }
        return z;
    }

    private Iterator<ans> VH() {
        Iterator<ans> it = this.EQ.iterator();
        this.EQ = new LinkedList();
        return it;
    }

    private boolean j6(anb anb, String str, avv avv) {
        try {
            j6(anb, avv.DW(str).j6());
            return true;
        } catch (Throwable e) {
            j6(anb, e);
            return false;
        } catch (Throwable e2) {
            throw new amb(MessageFormat.format(JGitText.j6().cannotDownload, new Object[]{anb.DW()}), e2);
        }
    }

    private void j6(anb anb, byte[] bArr) {
        try {
            anx j6 = asc.j6(bArr, anb);
            int DW = j6.DW();
            byte[] v5 = j6.v5();
            if (this.DW != null) {
                try {
                    this.DW.j6(DW, v5);
                } catch (ala e) {
                    throw new amb(MessageFormat.format(JGitText.j6().transportExceptionInvalid, new Object[]{anj.j6(DW), anb.DW(), e.getMessage()}));
                }
            }
            if (anb.j6(anb, this.Mr.DW(DW, v5))) {
                this.Mr.FH();
                return;
            }
            throw new amb(MessageFormat.format(JGitText.j6().incorrectHashFor, new Object[]{anb.DW(), r0.DW(), anj.j6(DW), Integer.valueOf(bArr.length)}));
        } catch (Throwable e2) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException(anb.DW());
            fileNotFoundException.initCause(e2);
            throw fileNotFoundException;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Collection<avv> j6(anb r4, aob r5) {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.J0;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = r3.J0;
        r0 = r0.removeFirst();
        r0 = (avv) r0;
        r1 = org.eclipse.jgit.JGitText.j6();	 Catch:{ IOException -> 0x002c }
        r1 = r1.listingAlternates;	 Catch:{ IOException -> 0x002c }
        r2 = 0;
        r5.j6(r1, r2);	 Catch:{ IOException -> 0x002c }
        r0 = r0.DW();	 Catch:{ IOException -> 0x002c }
        if (r0 == 0) goto L_0x0039;
    L_0x0022:
        r1 = r0.isEmpty();	 Catch:{ IOException -> 0x002c }
        if (r1 != 0) goto L_0x0039;
    L_0x0028:
        r5.DW();
        goto L_0x0009;
    L_0x002c:
        r0 = move-exception;
        r3.j6(r4, r0);	 Catch:{ all -> 0x0034 }
        r5.DW();
        goto L_0x0000;
    L_0x0034:
        r0 = move-exception;
        r5.DW();
        throw r0;
    L_0x0039:
        r5.DW();
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: avt.j6(anb, aob):java.util.Collection<avv>");
    }

    private void j6(Set<ans> set) {
        for (aoc v5 : this.j6.J8().values()) {
            try {
                Zo(this.v5.gn(v5.v5()));
            } catch (Throwable e) {
                throw new amb(MessageFormat.format(JGitText.j6().localRefIsMissingObjects, new Object[]{v5.j6()}), e);
            }
        }
        for (ans gn : set) {
            try {
                Zo(this.v5.gn(gn));
            } catch (Throwable e2) {
                throw new amb(MessageFormat.format(JGitText.j6().transportExceptionMissingAssumed, new Object[]{gn.DW()}), e2);
            }
        }
    }

    private void Zo(aqg aqg) {
        aqg aqg2 = aqg;
        while (aqg2.v_() == 4) {
            aqg2.FH(this.VH);
            aqg2 = ((aqj) aqg2).gn();
            this.v5.Zo(aqg2);
        }
        switch (aqg2.v_()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j6((aqc) aqg2);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j6((aqk) aqg2);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                aqg2.FH(this.VH);
            default:
        }
    }

    private void j6(int i) {
        while (true) {
            try {
                break;
                aqc FH = this.tp.FH();
                if (FH != null && FH.gn() >= i) {
                    this.tp.j6();
                    j6(FH.u7());
                    aqc[] EQ = FH.EQ();
                    int length = EQ.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        j6(EQ[i2]);
                        i2++;
                    }
                    aqc FH2 = this.tp.FH();
                    if (FH2 != null) {
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable e) {
                throw new amb(JGitText.j6().localObjectsIncomplete, e);
            }
        }
    }

    private void j6(aqc aqc) {
        if (!aqc.DW(this.u7)) {
            this.v5.Zo((aqg) aqc);
            aqc.FH(this.u7);
            aqc.FH(this.VH);
            aqc.j6(this.VH);
            this.tp.j6(aqc);
        }
    }

    private void j6(aqk aqk) {
        if (!aqk.DW(this.VH)) {
            aqk.FH(this.VH);
            this.Zo.j6((anb) aqk);
            while (this.Zo.EQ()) {
                anl DW = this.Zo.DW(0);
                int DW2 = DW.DW();
                switch (DW2) {
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        this.Zo.j6(this.QX, 0);
                        aqg j6 = this.v5.j6(this.QX, DW2);
                        if (!j6.DW(this.VH)) {
                            j6.FH(this.VH);
                            this.Zo.QX();
                            break;
                        }
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        this.Zo.j6(this.QX, 0);
                        this.v5.j6(this.QX, DW2).FH(this.VH);
                        break;
                    default:
                        if (anl.v5.equals(DW)) {
                            break;
                        }
                        this.Zo.j6(this.QX, 0);
                        throw new ala(MessageFormat.format(JGitText.j6().corruptObjectInvalidMode3, new Object[]{DW, this.QX.DW(), this.Zo.we(), aqk.DW()}));
                }
            }
        }
    }

    private void j6(anb anb, Throwable th) {
        ans Hw = anb.Hw();
        List list = (List) this.XL.get(Hw);
        if (list == null) {
            list = new ArrayList(2);
            this.XL.put(Hw, list);
        }
        list.add(th);
    }
}
