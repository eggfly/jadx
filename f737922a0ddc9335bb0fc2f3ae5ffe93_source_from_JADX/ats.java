import com.aide.uidesigner.ProxyTextView;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.JGitText;

class ats {
    private static /* synthetic */ int[] u7;
    private final Collection<auq> DW;
    private final HashMap<ans, aoc> FH;
    private final HashSet<ans> Hw;
    private final ArrayList<arw> VH;
    private final ArrayList<atr> Zo;
    private atq gn;
    private final avd j6;
    private final ArrayList<avb> v5;

    static /* synthetic */ int[] j6() {
        int[] iArr = u7;
        if (iArr == null) {
            iArr = new int[aof$a.values().length];
            try {
                iArr[aof$a.FAST_FORWARD.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[aof$a.FORCED.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[aof$a.IO_FAILURE.ordinal()] = 9;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[aof$a.LOCK_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[aof$a.NEW.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[aof$a.NOT_ATTEMPTED.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[aof$a.NO_CHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[aof$a.REJECTED.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[aof$a.REJECTED_CURRENT_BRANCH.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[aof$a.RENAMED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            u7 = iArr;
        }
        return iArr;
    }

    ats(avd avd, Collection<auq> collection) {
        this.FH = new HashMap();
        this.Hw = new HashSet();
        this.v5 = new ArrayList();
        this.Zo = new ArrayList();
        this.VH = new ArrayList();
        this.j6 = avd;
        this.DW = collection;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(aob r4, att r5) {
        /*
        r3 = this;
        r0 = r3.FH;
        r0.clear();
        r0 = r3.v5;
        r0.clear();
        r0 = r3.Zo;
        r0.clear();
        r0 = r3.VH;
        r0.clear();
        r3.DW(r4, r5);	 Catch:{ all -> 0x0024 }
        r0 = r3.VH;	 Catch:{ IOException -> 0x0051 }
        r1 = r0.iterator();	 Catch:{ IOException -> 0x0051 }
    L_0x001d:
        r0 = r1.hasNext();	 Catch:{ IOException -> 0x0051 }
        if (r0 != 0) goto L_0x0047;
    L_0x0023:
        return;
    L_0x0024:
        r1 = move-exception;
        r0 = r3.VH;	 Catch:{ IOException -> 0x003c }
        r2 = r0.iterator();	 Catch:{ IOException -> 0x003c }
    L_0x002b:
        r0 = r2.hasNext();	 Catch:{ IOException -> 0x003c }
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        throw r1;
    L_0x0032:
        r0 = r2.next();	 Catch:{ IOException -> 0x003c }
        r0 = (arw) r0;	 Catch:{ IOException -> 0x003c }
        r0.j6();	 Catch:{ IOException -> 0x003c }
        goto L_0x002b;
    L_0x003c:
        r0 = move-exception;
        r1 = new amb;
        r2 = r0.getMessage();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0047:
        r0 = r1.next();	 Catch:{ IOException -> 0x0051 }
        r0 = (arw) r0;	 Catch:{ IOException -> 0x0051 }
        r0.j6();	 Catch:{ IOException -> 0x0051 }
        goto L_0x001d;
    L_0x0051:
        r0 = move-exception;
        r1 = new amb;
        r2 = r0.getMessage();
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: ats.j6(aob, att):void");
    }

    private void DW(aob aob, att att) {
        auz FH;
        this.gn = this.j6.QX();
        att.j6(this.j6.Hw(), this.gn.j6());
        Set hashSet = new HashSet();
        Iterator it = this.DW.iterator();
        while (it.hasNext()) {
            try {
                auq auq = (auq) it.next();
                FH = auq.FH();
                if (FH == null) {
                    throw new amb(MessageFormat.format(JGitText.j6().sourceRefNotSpecifiedForRefspec, new Object[]{auq}));
                }
                FH = auq.DW();
                if (FH != null) {
                    j6(auq, hashSet);
                } else {
                    DW(auq, hashSet);
                }
            } finally {
                j6(att);
            }
        }
        List emptyList = Collections.emptyList();
        FH = this.j6.Zo();
        if (FH == auz.AUTO_FOLLOW) {
            Collection Hw = Hw();
        } else {
            if (FH == auz.FETCH_TAGS) {
                v5();
            }
            Object obj = emptyList;
        }
        aoc aoc;
        anb VH;
        aql aql;
        Iterator it2;
        if (this.FH.isEmpty() || FH()) {
            it = null;
            if (aob.j6()) {
                if (FH == auz.AUTO_FOLLOW && !Hw.isEmpty()) {
                    this.Hw.addAll(this.FH.keySet());
                    this.FH.clear();
                    FH = Hw.iterator();
                    while (FH.hasNext()) {
                        aoc = (aoc) FH.next();
                        VH = aoc.VH();
                        if (VH == null) {
                            VH = aoc.v5();
                        }
                        Hw = this.j6.FH.j6(VH);
                        if (Hw != null) {
                            j6(aoc);
                        }
                    }
                    if (!this.FH.isEmpty() && (r4 == null || !FH())) {
                        DW();
                        if (!this.FH.isEmpty()) {
                            j6(aob);
                        }
                    }
                }
                j6(att);
                aql = new aql(this.j6.FH);
                try {
                    if (aob instanceof ang) {
                        ((ang) aob).j6(250, TimeUnit.MILLISECONDS);
                    }
                    aob.j6(JGitText.j6().updatingReferences, this.v5.size());
                    if (this.j6.EQ()) {
                        j6(att, aql);
                    }
                    it2 = this.v5.iterator();
                    while (it2.hasNext()) {
                        avb avb = (avb) it2.next();
                        aob.j6(1);
                        avb.j6(aql);
                        att.j6(avb);
                    }
                    aob.DW();
                    aql.we();
                    if (!aob.j6() && !this.Zo.isEmpty()) {
                        try {
                            DW(att);
                            return;
                        } catch (Throwable e) {
                            throw new amb(MessageFormat.format(JGitText.j6().failureUpdatingFETCH_HEAD, new Object[]{e.getMessage()}), e);
                        }
                    }
                    return;
                } catch (Throwable e2) {
                    throw new amb(MessageFormat.format(JGitText.j6().failureUpdatingTrackingRef, new Object[]{avb.j6(), e2.getMessage()}), e2);
                } catch (Throwable th) {
                    aql.we();
                }
            } else {
                j6(att);
            }
        }
        j6(aob);
        boolean Zo = this.gn.Zo();
        if (aob.j6()) {
            this.Hw.addAll(this.FH.keySet());
            this.FH.clear();
            FH = Hw.iterator();
            while (FH.hasNext()) {
                aoc = (aoc) FH.next();
                VH = aoc.VH();
                if (VH == null) {
                    VH = aoc.v5();
                }
                Hw = this.j6.FH.j6(VH);
                if (Hw != null) {
                    j6(aoc);
                }
            }
            DW();
            if (this.FH.isEmpty()) {
                j6(aob);
            }
            j6(att);
            aql = new aql(this.j6.FH);
            if (aob instanceof ang) {
                ((ang) aob).j6(250, TimeUnit.MILLISECONDS);
            }
            aob.j6(JGitText.j6().updatingReferences, this.v5.size());
            if (this.j6.EQ()) {
                j6(att, aql);
            }
            it2 = this.v5.iterator();
            while (it2.hasNext()) {
                avb avb2 = (avb) it2.next();
                aob.j6(1);
                avb2.j6(aql);
                att.j6(avb2);
            }
            aob.DW();
            aql.we();
            if (!aob.j6()) {
                return;
            }
            return;
        }
        j6(att);
    }

    private void j6(aob aob) {
        try {
            this.gn.FH("jgit fetch " + this.j6.Hw);
            this.gn.j6(aob, this.FH.values(), this.Hw);
            if (this.j6.gn() && !this.gn.EQ() && !FH()) {
                throw new amb(this.j6.Hw(), JGitText.j6().peerDidNotSupplyACompleteObjectGraph);
            }
        } finally {
            this.VH.addAll(this.gn.we());
        }
    }

    private void j6(att att) {
        if (this.gn != null) {
            this.gn.u7();
            att.DW(this.gn.FH());
            this.gn = null;
        }
    }

    private void DW() {
        if (this.gn == null) {
            aoc aoc;
            this.gn = this.j6.QX();
            HashMap hashMap = new HashMap();
            for (aoc aoc2 : this.gn.DW()) {
                hashMap.put(aoc2.v5(), aoc2);
            }
            Collection<aoc> arrayList = new ArrayList(this.FH.values());
            this.FH.clear();
            for (aoc aoc3 : arrayList) {
                aoc2 = (aoc) hashMap.get(aoc3.v5());
                if (aoc2 != null) {
                    this.FH.put(aoc2.v5(), aoc2);
                } else {
                    DW(aoc3.v5());
                    j6(aoc3.v5());
                }
            }
        }
    }

    private void j6(ans ans) {
        Iterator it = this.v5.iterator();
        while (it.hasNext()) {
            if (((avb) it.next()).DW().DW((anb) ans)) {
                it.remove();
            }
        }
    }

    private void DW(ans ans) {
        Iterator it = this.Zo.iterator();
        while (it.hasNext()) {
            if (((atr) it.next()).j6.DW((anb) ans)) {
                it.remove();
            }
        }
    }

    private void DW(att att) {
        File DW = this.j6.FH.DW();
        if (DW != null) {
            ark ark = new ark(new File(DW, "FETCH_HEAD"), this.j6.FH.gn());
            Writer outputStreamWriter;
            try {
                if (ark.j6()) {
                    outputStreamWriter = new OutputStreamWriter(ark.DW());
                    Iterator it = this.Zo.iterator();
                    while (it.hasNext()) {
                        atr atr = (atr) it.next();
                        atr.j6(outputStreamWriter);
                        att.j6(atr);
                    }
                    outputStreamWriter.close();
                    ark.Hw();
                }
                ark.Zo();
            } catch (Throwable th) {
                ark.Zo();
            }
        }
    }

    private boolean FH() {
        apy apy;
        try {
            apy = new apy(this.j6.FH);
            for (ans gn : this.FH.keySet()) {
                apy.FH(apy.gn(gn));
            }
            for (aoc v5 : this.j6.FH.J8().values()) {
                apy.Hw(apy.gn(v5.v5()));
            }
            apy.Zo();
            apy.we();
            return true;
        } catch (ali e) {
            return false;
        } catch (Throwable e2) {
            throw new amb(JGitText.j6().unableToCheckConnectivity, e2);
        } catch (Throwable th) {
            apy.we();
        }
    }

    private void j6(auq auq, Set<aoc> set) {
        for (aoc aoc : this.gn.DW()) {
            if (auq.j6(aoc) && set.add(aoc)) {
                j6(aoc, auq.DW(aoc));
            }
        }
    }

    private void DW(auq auq, Set<aoc> set) {
        aoc j6 = this.gn.j6(auq.FH());
        if (j6 == null) {
            throw new amb(MessageFormat.format(JGitText.j6().remoteDoesNotHaveSpec, new Object[]{auq.FH()}));
        } else if (set.add(j6)) {
            j6(j6, auq);
        }
    }

    private Collection<aoc> Hw() {
        Collection<aoc> arrayList = new ArrayList();
        Map J8 = this.j6.FH.J8();
        for (aoc aoc : this.gn.DW()) {
            if (DW(aoc)) {
                aoc aoc2 = (aoc) J8.get(aoc.j6());
                anb v5 = aoc.v5();
                if (aoc.VH() == null) {
                    if (aoc2 == null || !v5.DW(aoc2.v5())) {
                        if (this.FH.containsKey(v5) || this.j6.FH.j6(v5)) {
                            j6(aoc);
                        } else {
                            arrayList.add(aoc);
                        }
                    }
                } else if (aoc2 != null) {
                    if (!v5.DW(aoc2.v5())) {
                        j6(aoc);
                    }
                } else if (this.FH.containsKey(aoc.VH()) || this.j6.FH.j6(aoc.VH())) {
                    j6(aoc);
                } else {
                    arrayList.add(aoc);
                }
            }
        }
        return arrayList;
    }

    private void v5() {
        Map J8 = this.j6.FH.J8();
        for (aoc aoc : this.gn.DW()) {
            if (DW(aoc)) {
                aoc aoc2 = (aoc) J8.get(aoc.j6());
                if (aoc2 == null || !aoc.v5().DW(aoc2.v5())) {
                    j6(aoc);
                }
            }
        }
    }

    private void j6(aoc aoc) {
        j6(aoc, new auq().DW(aoc.j6()).FH(aoc.j6()));
    }

    private void j6(aoc aoc, auq auq) {
        boolean z = true;
        ans v5 = aoc.v5();
        if (auq.Hw() != null) {
            try {
                avb j6 = j6(auq, v5);
                if (!v5.DW(j6.FH())) {
                    this.v5.add(j6);
                } else {
                    return;
                }
            } catch (Throwable e) {
                throw new amb(MessageFormat.format(JGitText.j6().cannotResolveLocalTrackingRefForUpdating, new Object[]{auq.Hw()}), e);
            }
        }
        this.FH.put(v5, aoc);
        atr atr = new atr();
        atr.j6 = v5;
        if (auq.Hw() == null) {
            z = false;
        }
        atr.DW = z;
        atr.FH = aoc.j6();
        atr.Hw = this.j6.Hw();
        this.Zo.add(atr);
    }

    private avb j6(auq auq, ans ans) {
        return new avb(this.j6.FH, auq, ans, "fetch");
    }

    private void j6(att att, aql aql) {
        aoh aoh = this.j6.FH;
        for (aoc aoc : aoh.J8().values()) {
            String j6 = aoc.j6();
            for (auq auq : this.DW) {
                if (auq.v5(j6)) {
                    auq VH = auq.VH(j6);
                    if (att.j6(VH.FH()) == null) {
                        j6(att, aoh, aql, VH, aoc);
                    }
                }
            }
        }
    }

    private void j6(att att, aoh aoh, aql aql, auq auq, aoc aoc) {
        try {
            avb avb = new avb(aoh, aoc.j6(), auq.FH(), true, ans.Zo(), "deleted");
            att.j6(avb);
            if (!this.j6.we()) {
                avb.DW(aql);
                switch (j6()[avb.Hw().ordinal()]) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    default:
                        throw new amb(this.j6.Hw(), MessageFormat.format(JGitText.j6().cannotDeleteStaleTrackingRef2, new Object[]{r2, avb.Hw().name()}));
                }
            }
        } catch (Throwable e) {
            throw new amb(this.j6.Hw(), MessageFormat.format(JGitText.j6().cannotDeleteStaleTrackingRef, new Object[]{r2}), e);
        }
    }

    private static boolean DW(aoc aoc) {
        return j6(aoc.j6());
    }

    private static boolean j6(String str) {
        return str.startsWith("refs/tags/");
    }
}
