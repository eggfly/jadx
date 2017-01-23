import com.aide.uidesigner.ProxyTextView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.JGitText;

public class aun {
    private static /* synthetic */ int[] KD;
    private static /* synthetic */ int[] SI;
    private static /* synthetic */ int[] ro;
    private boolean BT;
    private final aql DW;
    private auh EQ;
    private boolean FH;
    private boolean Hw;
    private int J0;
    private axn J8;
    private auf Mr;
    private arw P8;
    private InputStream QX;
    private aub U2;
    private boolean VH;
    private axs Ws;
    private OutputStream XL;
    private boolean Zo;
    private Map<String, aoc> a8;
    private OutputStream aM;
    private boolean ei;
    private List<aum> er;
    private Throwable gW;
    private boolean gn;
    private aue j3;
    private final aoh j6;
    private Set<ans> lg;
    private long nw;
    private Set<String> rN;
    private aup tp;
    private aoa u7;
    private boolean v5;
    private boolean vy;
    private aug we;
    private StringBuilder yS;

    static /* synthetic */ int[] gn() {
        int[] iArr = SI;
        if (iArr == null) {
            iArr = new int[aum$b.values().length];
            try {
                iArr[aum$b.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[aum$b.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[aum$b.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[aum$b.UPDATE_NONFASTFORWARD.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            SI = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] tp() {
        int[] iArr = ro;
        if (iArr == null) {
            iArr = new int[aum$a.values().length];
            try {
                iArr[aum$a.LOCK_FAILURE.ordinal()] = 8;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[aum$a.NOT_ATTEMPTED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[aum$a.OK.ordinal()] = 9;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[aum$a.REJECTED_CURRENT_BRANCH.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[aum$a.REJECTED_MISSING_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[aum$a.REJECTED_NOCREATE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[aum$a.REJECTED_NODELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[aum$a.REJECTED_NONFASTFORWARD.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[aum$a.REJECTED_OTHER_REASON.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            ro = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] u7() {
        int[] iArr = KD;
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
            KD = iArr;
        }
        return iArr;
    }

    public aun(aoh aoh) {
        this.FH = true;
        this.j6 = aoh;
        this.DW = new aql(this.j6);
        aun$a aun_a = (aun$a) this.j6.VH().j6(aun$a.j6);
        this.Hw = aun_a.DW;
        this.v5 = aun_a.FH;
        this.Zo = aun_a.Hw;
        this.VH = aun_a.v5;
        this.gn = aun_a.Zo;
        this.tp = aup.j6;
        this.EQ = auh.j6;
        this.we = aug.j6;
        this.lg = new HashSet();
    }

    public final Map<String, aoc> j6() {
        if (this.a8 == null) {
            this.a8 = this.tp.j6(this.j6.J8());
            aoc aoc = (aoc) this.a8.get("HEAD");
            if (aoc != null && aoc.DW()) {
                this.a8.remove("HEAD");
            }
            for (aoc aoc2 : this.a8.values()) {
                if (aoc2.v5() != null) {
                    this.lg.add(aoc2.v5());
                }
            }
            this.lg.addAll(this.j6.J0());
        }
        return this.a8;
    }

    public boolean DW() {
        return this.ei;
    }

    public boolean FH() {
        return this.Hw;
    }

    public boolean Hw() {
        return this.v5;
    }

    public boolean v5() {
        return this.Zo;
    }

    public boolean Zo() {
        return this.VH;
    }

    public aoa VH() {
        return this.u7;
    }

    public void j6(String str) {
        if (this.a8 == null) {
            if (this.yS == null) {
                this.yS = new StringBuilder();
            }
            this.yS.append(str).append('\n');
            return;
        }
        try {
            if (this.aM != null) {
                this.aM.write(anj.DW("error: " + str + "\n"));
            }
        } catch (IOException e) {
        }
    }

    public void j6(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) {
        auf auf;
        try {
            this.QX = inputStream;
            this.XL = outputStream;
            this.aM = outputStream2;
            if (this.J0 > 0) {
                axn axn = new axn(new StringBuilder(String.valueOf(Thread.currentThread().getName())).append("-Timer").toString());
            }
            this.j3 = new aue(this.QX);
            this.Mr = new auf(this.XL);
            this.Mr.j6(false);
            this.rN = new HashSet();
            this.er = new ArrayList();
            EQ();
            this.DW.we();
            try {
                if (this.vy) {
                    ((auv) this.aM).j6();
                    ((auv) this.XL).j6();
                    auf = new auf(outputStream);
                    auf.j6(false);
                    auf.j6();
                }
                if (this.FH) {
                    if (!(this.vy || this.aM == null)) {
                        this.aM.flush();
                    }
                    this.XL.flush();
                }
                we();
                this.Ws = null;
                this.QX = null;
                this.XL = null;
                this.aM = null;
                this.j3 = null;
                this.Mr = null;
                this.a8 = null;
                this.rN = null;
                this.er = null;
                if (this.J8 != null) {
                    try {
                        this.J8.DW();
                    } finally {
                        this.J8 = null;
                    }
                }
            } catch (Throwable th) {
                we();
                this.Ws = null;
                this.QX = null;
                this.XL = null;
                this.aM = null;
                this.j3 = null;
                this.Mr = null;
                this.a8 = null;
                this.rN = null;
                this.er = null;
                if (this.J8 != null) {
                    this.J8.DW();
                }
            } finally {
                this.J8 = null;
            }
        } catch (Throwable th2) {
            we();
            this.Ws = null;
            this.QX = null;
            this.XL = null;
            this.aM = null;
            this.j3 = null;
            this.Mr = null;
            this.a8 = null;
            this.rN = null;
            this.er = null;
            if (this.J8 != null) {
                try {
                    this.J8.DW();
                } finally {
                    this.J8 = null;
                }
            }
        } finally {
            this.J8 = null;
        }
    }

    private void EQ() {
        if (this.FH) {
            j6(new auo$a(this.Mr));
            this.Mr.DW();
        } else {
            j6();
        }
        if (this.yS == null) {
            J0();
            if (!this.er.isEmpty()) {
                J8();
                if (Ws()) {
                    try {
                        QX();
                        if (XL()) {
                            aM();
                        }
                        this.U2 = null;
                        this.gW = null;
                    } catch (Throwable e) {
                        this.gW = e;
                    } catch (Throwable e2) {
                        this.gW = e2;
                    } catch (Throwable e22) {
                        this.gW = e22;
                    }
                }
                if (this.gW == null) {
                    j3();
                    Mr();
                }
                we();
                if (this.BT) {
                    j6(true, new aun$1(this));
                    this.Mr.j6();
                } else if (this.aM != null) {
                    j6(false, new aun$2(this));
                }
                this.we.j6(this, j6(aum$a.OK));
                if (this.gW != null) {
                    throw new amd(this.gW);
                }
            }
        }
    }

    private void we() {
        if (this.P8 != null) {
            this.P8.j6();
            this.P8 = null;
        }
    }

    public void j6(auo auo) {
        if (this.yS != null) {
            auo.j6("ERR " + this.yS);
            return;
        }
        auo.j6(this.j6);
        auo.j6("side-band-64k");
        auo.j6("delete-refs");
        auo.j6("report-status");
        if (this.gn) {
            auo.j6("ofs-delta");
        }
        auo.j6(j6());
        for (anb j6 : this.lg) {
            auo.j6(j6);
        }
        if (auo.j6()) {
            auo.j6(ans.Zo(), "capabilities^{}");
        }
        auo.DW();
    }

    private void J0() {
        String DW;
        while (true) {
            try {
                DW = this.j3.DW();
                if (DW != aue.j6) {
                    if (this.er.isEmpty()) {
                        int indexOf = DW.indexOf(0);
                        if (indexOf >= 0) {
                            for (Object add : DW.substring(indexOf + 1).split(" ")) {
                                this.rN.add(add);
                            }
                            DW = DW.substring(0, indexOf);
                        }
                    }
                    if (DW.length() < 83) {
                        break;
                    }
                    ans DW2 = ans.DW(DW.substring(0, 40));
                    ans DW3 = ans.DW(DW.substring(41, 81));
                    DW = DW.substring(82);
                    aum aum = new aum(DW2, DW3, DW);
                    if (DW.equals("HEAD")) {
                        aum.j6(aum$a.REJECTED_CURRENT_BRANCH);
                    } else {
                        aum.j6((aoc) this.a8.get(aum.FH()));
                    }
                    this.er.add(aum);
                } else {
                    return;
                }
            } catch (EOFException e) {
                if (!this.er.isEmpty()) {
                    throw e;
                }
                return;
            }
        }
        DW = JGitText.j6().errorInvalidProtocolWantedOldNewRef;
        j6(DW);
        throw new alq(DW);
    }

    private void J8() {
        this.BT = this.rN.contains("report-status");
        this.vy = this.rN.contains("side-band-64k");
        if (this.vy) {
            OutputStream outputStream = this.XL;
            this.XL = new auv(1, 65520, outputStream);
            this.aM = new auv(2, 65520, outputStream);
            this.Mr = new auf(this.XL);
            this.Mr.j6(false);
        }
    }

    private boolean Ws() {
        for (aum Hw : this.er) {
            if (Hw.Hw() != aum$b.DELETE) {
                return true;
            }
        }
        return false;
    }

    private void QX() {
        boolean z = true;
        if (this.Ws != null) {
            this.Ws.j6((this.J0 * 10) * 1000);
        }
        aob aob = anp.j6;
        aob aob2 = anp.j6;
        if (this.vy) {
            aob2 = new auw(this.aM);
        }
        anw Hw = this.j6.Hw();
        try {
            String str = "jgit receive-pack";
            if (VH() != null) {
                str = new StringBuilder(String.valueOf(str)).append(" from ").append(VH().Hw()).toString();
            }
            this.U2 = Hw.j6(this.QX);
            this.U2.j6(true);
            this.U2.DW(this.ei);
            this.U2.FH(this.ei);
            aub aub = this.U2;
            if (this.FH) {
                z = false;
            }
            aub.Hw(z);
            this.U2.v5(FH());
            this.U2.j6(str);
            this.U2.DW(this.nw);
            this.P8 = this.U2.j6(aob, aob2);
            Hw.FH();
            if (this.Ws != null) {
                this.Ws.j6(this.J0 * 1000);
            }
        } finally {
            Hw.Hw();
        }
    }

    private boolean XL() {
        return FH() || DW();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aM() {
        /*
        r7 = this;
        r2 = 0;
        r0 = r7.ei;
        if (r0 == 0) goto L_0x011f;
    L_0x0005:
        r0 = r7.U2;
        r1 = r0.VH();
        r0 = r7.U2;
        r0 = r0.Zo();
        r3 = r1;
        r1 = r0;
    L_0x0013:
        r7.U2 = r2;
        r2 = new apy;
        r0 = r7.j6;
        r2.<init>(r0);
        r0 = 0;
        r2.j6(r0);
        r0 = r7.ei;
        if (r0 == 0) goto L_0x0035;
    L_0x0024:
        r0 = aqi.TOPO;
        r2.j6(r0);
        r0 = r3.j6();
        if (r0 != 0) goto L_0x0035;
    L_0x002f:
        r0 = aqi.BOUNDARY;
        r4 = 1;
        r2.j6(r0, r4);
    L_0x0035:
        r0 = r7.er;
        r4 = r0.iterator();
    L_0x003b:
        r0 = r4.hasNext();
        if (r0 != 0) goto L_0x0068;
    L_0x0041:
        r0 = r7.lg;
        r4 = r0.iterator();
    L_0x0047:
        r0 = r4.hasNext();
        if (r0 != 0) goto L_0x008a;
    L_0x004d:
        r0 = r2.Hw();
        if (r0 != 0) goto L_0x00b7;
    L_0x0053:
        r0 = r2.v5();
        if (r0 != 0) goto L_0x00d2;
    L_0x0059:
        r0 = r7.ei;
        if (r0 == 0) goto L_0x0067;
    L_0x005d:
        r1 = r3.iterator();
    L_0x0061:
        r0 = r1.hasNext();
        if (r0 != 0) goto L_0x0103;
    L_0x0067:
        return;
    L_0x0068:
        r0 = r4.next();
        r0 = (aum) r0;
        r5 = r0.Zo();
        r6 = aum$a.NOT_ATTEMPTED;
        if (r5 != r6) goto L_0x003b;
    L_0x0076:
        r5 = r0.Hw();
        r6 = aum$b.DELETE;
        if (r5 == r6) goto L_0x003b;
    L_0x007e:
        r0 = r0.DW();
        r0 = r2.gn(r0);
        r2.FH(r0);
        goto L_0x003b;
    L_0x008a:
        r0 = r4.next();
        r0 = (ans) r0;
        r0 = r2.gn(r0);
        r2.Hw(r0);
        r5 = r7.ei;
        if (r5 == 0) goto L_0x0047;
    L_0x009b:
        r5 = r3.j6();
        if (r5 != 0) goto L_0x0047;
    L_0x00a1:
        r0 = r2.VH(r0);
        r5 = r0 instanceof aqc;
        if (r5 == 0) goto L_0x00af;
    L_0x00a9:
        r0 = (aqc) r0;
        r0 = r0.u7();
    L_0x00af:
        r5 = r0 instanceof aqk;
        if (r5 == 0) goto L_0x0047;
    L_0x00b3:
        r2.Hw(r0);
        goto L_0x0047;
    L_0x00b7:
        r4 = r7.ei;
        if (r4 == 0) goto L_0x004d;
    L_0x00bb:
        r4 = aqe.j6;
        r4 = r0.DW(r4);
        if (r4 != 0) goto L_0x004d;
    L_0x00c3:
        r4 = r1.DW(r0);
        if (r4 != 0) goto L_0x004d;
    L_0x00c9:
        r1 = new ali;
        r2 = "commit";
        r1.<init>(r0, r2);
        throw r1;
    L_0x00d2:
        r4 = aqe.j6;
        r4 = r0.DW(r4);
        if (r4 != 0) goto L_0x0053;
    L_0x00da:
        r4 = r7.ei;
        if (r4 == 0) goto L_0x00ee;
    L_0x00de:
        r4 = r1.DW(r0);
        if (r4 != 0) goto L_0x0053;
    L_0x00e4:
        r1 = new ali;
        r2 = r0.v_();
        r1.<init>(r0, r2);
        throw r1;
    L_0x00ee:
        r4 = r0 instanceof aqb;
        if (r4 == 0) goto L_0x0053;
    L_0x00f2:
        r4 = r7.j6;
        r4 = r4.j6(r0);
        if (r4 != 0) goto L_0x0053;
    L_0x00fa:
        r1 = new ali;
        r2 = "blob";
        r1.<init>(r0, r2);
        throw r1;
    L_0x0103:
        r0 = r1.next();
        r0 = (ans) r0;
        r0 = r2.gn(r0);
        r3 = aqe.j6;
        r3 = r0.DW(r3);
        if (r3 != 0) goto L_0x0061;
    L_0x0115:
        r1 = new ali;
        r2 = r0.v_();
        r1.<init>(r0, r2);
        throw r1;
    L_0x011f:
        r1 = r2;
        r3 = r2;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: aun.aM():void");
    }

    private void j3() {
        for (aum aum : this.er) {
            aoc v5 = aum.v5();
            if (aum.Zo() == aum$a.NOT_ATTEMPTED) {
                if (aum.Hw() != aum$b.DELETE || v5()) {
                    if (aum.Hw() == aum$b.CREATE) {
                        if (!Hw()) {
                            aum.j6(aum$a.REJECTED_NOCREATE);
                        } else if (v5 != null && !Zo()) {
                            aum.j6(aum$a.REJECTED_NONFASTFORWARD);
                        } else if (v5 != null) {
                            aum.j6(aum$a.REJECTED_OTHER_REASON, MessageFormat.format(JGitText.j6().refAlreadyExists, new Object[]{v5}));
                        }
                    }
                    if (aum.Hw() != aum$b.DELETE || v5 == null || ans.Zo().DW(aum.j6()) || v5.v5().DW(aum.j6())) {
                        if (aum.Hw() == aum$b.UPDATE) {
                            if (v5 == null) {
                                aum.j6(aum$a.REJECTED_OTHER_REASON, JGitText.j6().noSuchRef);
                            } else if (v5.v5().DW(aum.j6())) {
                                try {
                                    aqg gn = this.DW.gn(aum.j6());
                                    try {
                                        aqg gn2 = this.DW.gn(aum.DW());
                                        if ((gn instanceof aqc) && (gn2 instanceof aqc)) {
                                            try {
                                                if (!this.DW.j6((aqc) gn, (aqc) gn2)) {
                                                    aum.j6(aum$b.UPDATE_NONFASTFORWARD);
                                                }
                                            } catch (ali e) {
                                                aum.j6(aum$a.REJECTED_MISSING_OBJECT, e.getMessage());
                                            } catch (IOException e2) {
                                                aum.j6(aum$a.REJECTED_OTHER_REASON);
                                            }
                                        } else {
                                            aum.j6(aum$b.UPDATE_NONFASTFORWARD);
                                        }
                                    } catch (IOException e3) {
                                        aum.j6(aum$a.REJECTED_MISSING_OBJECT, aum.DW().DW());
                                    }
                                } catch (IOException e4) {
                                    aum.j6(aum$a.REJECTED_MISSING_OBJECT, aum.j6().DW());
                                }
                            } else {
                                aum.j6(aum$a.REJECTED_OTHER_REASON, JGitText.j6().invalidOldIdSent);
                            }
                        }
                        if (!aum.FH().startsWith("refs/") || !aoh.Hw(aum.FH())) {
                            aum.j6(aum$a.REJECTED_OTHER_REASON, JGitText.j6().funnyRefname);
                        }
                    } else {
                        aum.j6(aum$a.REJECTED_OTHER_REASON, JGitText.j6().invalidOldIdSent);
                    }
                } else {
                    aum.j6(aum$a.REJECTED_NODELETE);
                }
            }
        }
    }

    private void Mr() {
        aob aob;
        this.EQ.j6(this, j6(aum$a.NOT_ATTEMPTED));
        List<aum> j6 = j6(aum$a.NOT_ATTEMPTED);
        anp anp = anp.j6;
        if (this.vy) {
            auw auw = new auw(this.aM);
            auw.j6(250, TimeUnit.MILLISECONDS);
            aob = auw;
        } else {
            Object obj = anp;
        }
        aob.j6(JGitText.j6().updatingReferences, j6.size());
        for (aum aum : j6) {
            aob.j6(1);
            j6(aum);
        }
        aob.DW();
    }

    private void j6(aum aum) {
        try {
            aof j6 = this.j6.j6(aum.FH());
            j6.j6(VH());
            switch (gn()[aum.Hw().ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    j6.DW(Zo());
                    j6.DW(aum.j6());
                    j6.j6(aum.DW());
                    j6.j6("push", true);
                    j6(aum, j6.j6(this.DW));
                    return;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    if (!ans.Zo().DW(aum.j6())) {
                        j6.DW(aum.j6());
                    }
                    j6.DW(true);
                    j6(aum, j6.DW(this.DW));
                    return;
                default:
                    return;
            }
        } catch (IOException e) {
            aum.j6(aum$a.REJECTED_OTHER_REASON, MessageFormat.format(JGitText.j6().lockError, new Object[]{e.getMessage()}));
        }
        aum.j6(aum$a.REJECTED_OTHER_REASON, MessageFormat.format(JGitText.j6().lockError, new Object[]{e.getMessage()}));
    }

    private void j6(aum aum, aof$a aof_a) {
        switch (u7()[aof_a.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                aum.j6(aum$a.NOT_ATTEMPTED);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case 9:
                aum.j6(aum$a.LOCK_FAILURE);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
                aum.j6(aum$a.OK);
            case 7:
                aum.j6(aum$a.REJECTED_NONFASTFORWARD);
            case 8:
                aum.j6(aum$a.REJECTED_CURRENT_BRANCH);
            default:
                aum.j6(aum$a.REJECTED_OTHER_REASON, aof_a.name());
        }
    }

    private List<aum> j6(aum$a aum_a) {
        List<aum> arrayList = new ArrayList(this.er.size());
        for (aum aum : this.er) {
            if (aum.Zo() == aum_a) {
                arrayList.add(aum);
            }
        }
        return arrayList;
    }

    private void j6(boolean z, aun$b aun_b) {
        if (this.gW != null) {
            aun_b.j6("unpack error " + this.gW.getMessage());
            if (z) {
                for (aum FH : this.er) {
                    aun_b.j6("ng " + FH.FH() + " n/a (unpacker error)");
                }
                return;
            }
            return;
        }
        if (z) {
            aun_b.j6("unpack ok");
        }
        for (aum FH2 : this.er) {
            if (FH2.Zo() != aum$a.OK) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ng ");
                stringBuilder.append(FH2.FH());
                stringBuilder.append(" ");
                switch (tp()[FH2.Zo().ordinal()]) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        stringBuilder.append("server bug; ref not processed");
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        stringBuilder.append("creation prohibited");
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        stringBuilder.append("deletion prohibited");
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        stringBuilder.append("non-fast forward");
                        break;
                    case 5:
                        stringBuilder.append("branch is currently checked out");
                        break;
                    case 6:
                        if (FH2.VH() != null) {
                            if (FH2.VH().length() != 40) {
                                stringBuilder.append(FH2.VH());
                                break;
                            } else {
                                stringBuilder.append("object " + FH2.VH() + " missing");
                                break;
                            }
                        }
                        stringBuilder.append("missing object(s)");
                        break;
                    case 7:
                        if (FH2.VH() != null) {
                            stringBuilder.append(FH2.VH());
                            break;
                        } else {
                            stringBuilder.append("unspecified reason");
                            break;
                        }
                    case 8:
                        stringBuilder.append("failed to lock");
                        break;
                    case 9:
                        break;
                }
                aun_b.j6(stringBuilder.toString());
            } else if (z) {
                aun_b.j6("ok " + FH2.FH());
            }
        }
    }
}
