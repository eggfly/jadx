import com.aide.uidesigner.ProxyTextView;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.JGitText;

public class avo {
    private static /* synthetic */ int[] cn;
    private static /* synthetic */ int[] ro;
    private final aqe BT;
    private final aql DW;
    private Map<String, aoc> EQ;
    private asw FH;
    private int Hw;
    private aui J0;
    private final Set<String> J8;
    private avq KD;
    private int Mr;
    private avo$a P8;
    private final Set<aqg> QX;
    private asy$c SI;
    private int U2;
    private InputStream VH;
    private final Set<ans> Ws;
    private final Set<aqg> XL;
    private axn Zo;
    private Boolean a8;
    private final Set<ans> aM;
    private ati$c ei;
    private final aqe er;
    private final aqe gW;
    private OutputStream gn;
    private final List<ans> j3;
    private final aoh j6;
    private boolean lg;
    private boolean nw;
    private Set<ans> rN;
    private auf tp;
    private aue u7;
    private boolean v5;
    private final aqf vy;
    private aup we;
    private final aqe yS;

    static /* synthetic */ int[] DW() {
        int[] iArr = ro;
        if (iArr == null) {
            iArr = new int[ati$c.values().length];
            try {
                iArr[ati$c.CONTINUE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ati$c.DETAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ati$c.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            ro = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] FH() {
        int[] iArr = cn;
        if (iArr == null) {
            iArr = new int[avo$a.values().length];
            try {
                iArr[avo$a.ADVERTISED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[avo$a.ANY.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[avo$a.REACHABLE_COMMIT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            cn = iArr;
        }
        return iArr;
    }

    public avo(aoh aoh) {
        this.v5 = true;
        this.J0 = aui.j6;
        this.J8 = new HashSet();
        this.Ws = new HashSet();
        this.QX = new HashSet();
        this.XL = new HashSet();
        this.aM = new HashSet();
        this.j3 = new ArrayList();
        this.P8 = avo$a.ADVERTISED;
        this.ei = ati$c.OFF;
        this.KD = avq.j6;
        this.j6 = aoh;
        this.DW = new aql(this.j6);
        this.DW.j6(false);
        this.er = this.DW.j6("WANT");
        this.yS = this.DW.j6("PEER_HAS");
        this.gW = this.DW.j6("COMMON");
        this.BT = this.DW.j6("SATISFIED");
        this.DW.j6(this.yS);
        this.vy = new aqf();
        this.vy.j6(this.er);
        this.vy.j6(this.yS);
        this.vy.j6(this.gW);
        this.vy.j6(this.BT);
        this.we = aup.j6;
    }

    public final Map<String, aoc> j6() {
        if (this.EQ == null) {
            j6(this.j6.J8());
        }
        return this.EQ;
    }

    public void j6(Map<String, aoc> map) {
        this.EQ = this.we.j6(map);
    }

    public void j6(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) {
        try {
            this.VH = inputStream;
            this.gn = outputStream;
            if (this.Hw > 0) {
                axn axn = new axn(new StringBuilder(String.valueOf(Thread.currentThread().getName())).append("-Timer").toString());
            }
            this.u7 = new aue(this.VH);
            this.tp = new auf(this.gn);
            Hw();
            this.DW.we();
            if (this.Zo != null) {
                try {
                    this.Zo.DW();
                } finally {
                    this.Zo = null;
                }
            }
        } catch (Throwable th) {
            this.DW.we();
            if (this.Zo != null) {
                this.Zo.DW();
            }
        } finally {
            this.Zo = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Hw() {
        /*
        r6 = this;
        r0 = r6.v5;
        if (r0 == 0) goto L_0x002d;
    L_0x0004:
        r0 = new auo$a;
        r1 = r6.tp;
        r0.<init>(r1);
        r6.j6(r0);
    L_0x000e:
        r6.Zo();	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r0 = r6.Ws;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r0 = r0.isEmpty();	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        if (r0 == 0) goto L_0x0069;
    L_0x0019:
        r0 = r6.J0;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r1 = r6.Ws;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r2 = 0;
        r0.j6(r6, r1, r2);	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r0 = r6.J0;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r2 = r6.Ws;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r6;
        r0.j6(r1, r2, r3, r4, r5);	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
    L_0x002c:
        return;
    L_0x002d:
        r0 = r6.P8;
        r1 = avo$a.ANY;
        if (r0 != r1) goto L_0x003a;
    L_0x0033:
        r0 = java.util.Collections.emptySet();
        r6.rN = r0;
        goto L_0x000e;
    L_0x003a:
        r0 = new java.util.HashSet;
        r0.<init>();
        r6.rN = r0;
        r0 = r6.j6();
        r0 = r0.values();
        r1 = r0.iterator();
    L_0x004d:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x000e;
    L_0x0053:
        r0 = r1.next();
        r0 = (aoc) r0;
        r2 = r0.v5();
        if (r2 == 0) goto L_0x004d;
    L_0x005f:
        r2 = r6.rN;
        r0 = r0.v5();
        r2.add(r0);
        goto L_0x004d;
    L_0x0069:
        r0 = r6.J8;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r1 = "multi_ack_detailed";
        r0 = r0.contains(r1);	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        if (r0 == 0) goto L_0x0094;
    L_0x0074:
        r0 = ati$c.DETAILED;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r6.ei = r0;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r0 = r6.J8;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r1 = "no-done";
        r0 = r0.contains(r1);	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r6.nw = r0;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
    L_0x0083:
        r0 = r6.Mr;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        if (r0 == 0) goto L_0x008a;
    L_0x0087:
        r6.v5();	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
    L_0x008a:
        r0 = r6.VH();	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        if (r0 == 0) goto L_0x002c;
    L_0x0090:
        r6.tp();
        goto L_0x002c;
    L_0x0094:
        r0 = r6.J8;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r1 = "multi_ack";
        r0 = r0.contains(r1);	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        if (r0 == 0) goto L_0x00ad;
    L_0x009f:
        r0 = ati$c.CONTINUE;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r6.ei = r0;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        goto L_0x0083;
    L_0x00a4:
        r0 = move-exception;
        r1 = r0.getMessage();
        r6.j6(r1);
        throw r0;
    L_0x00ad:
        r0 = ati$c.OFF;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        r6.ei = r0;	 Catch:{ alq -> 0x00a4, avr -> 0x00b2, IOException -> 0x00e3, RuntimeException -> 0x00ee, Error -> 0x00f9 }
        goto L_0x0083;
    L_0x00b2:
        r0 = move-exception;
        r1 = r0.j6();
        if (r1 != 0) goto L_0x00e2;
    L_0x00b9:
        r1 = r0.getMessage();
        if (r1 == 0) goto L_0x00e2;
    L_0x00bf:
        r1 = r6.tp;	 Catch:{ Throwable -> 0x0104 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0104 }
        r3 = "ERR ";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0104 }
        r3 = r0.getMessage();	 Catch:{ Throwable -> 0x0104 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0104 }
        r3 = "\n";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0104 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0104 }
        r1.j6(r2);	 Catch:{ Throwable -> 0x0104 }
        r0.DW();	 Catch:{ Throwable -> 0x0104 }
    L_0x00e2:
        throw r0;
    L_0x00e3:
        r0 = move-exception;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.internalServerError;
        r6.j6(r1);
        throw r0;
    L_0x00ee:
        r0 = move-exception;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.internalServerError;
        r6.j6(r1);
        throw r0;
    L_0x00f9:
        r0 = move-exception;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.internalServerError;
        r6.j6(r1);
        throw r0;
    L_0x0104:
        r1 = move-exception;
        goto L_0x00e2;
        */
        throw new UnsupportedOperationException("Method not decompiled: avo.Hw():void");
    }

    private void j6(String str) {
        try {
            this.tp.j6("ERR " + str + "\n");
        } catch (Throwable th) {
        }
    }

    private void v5() {
        apr$c apr_c = new apr$c(this.DW.EQ(), this.Mr);
        for (ans Zo : this.Ws) {
            try {
                apr_c.j6(apr_c.Zo((anb) Zo));
            } catch (alb e) {
            }
        }
        while (true) {
            aqc Hw = apr_c.Hw();
            if (Hw == null) {
                this.tp.j6();
                return;
            }
            apr$a apr_a = (apr$a) Hw;
            if (apr_a.VH() == this.Mr && !this.aM.contains(apr_a)) {
                this.tp.j6("shallow " + Hw.DW());
            }
            if (apr_a.VH() < this.Mr && this.aM.contains(apr_a)) {
                this.j3.add(apr_a.Hw());
                this.tp.j6("unshallow " + apr_a.DW());
            }
        }
    }

    public void j6(auo auo) {
        try {
            this.J0.j6(this);
            auo.j6(this.j6);
            auo.j6("include-tag");
            auo.j6("multi_ack_detailed");
            auo.j6("multi_ack");
            auo.j6("ofs-delta");
            auo.j6("side-band");
            auo.j6("side-band-64k");
            auo.j6("thin-pack");
            auo.j6("no-progress");
            auo.j6("shallow");
            if (!this.v5) {
                auo.j6("no-done");
            }
            auo.j6(true);
            this.rN = auo.j6(j6());
            auo.DW();
        } catch (avr e) {
            if (e.getMessage() != null) {
                auo.j6("ERR " + e.getMessage());
                e.DW();
            }
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Zo() {
        /*
        r9 = this;
        r4 = 1;
        r8 = 45;
        r2 = 0;
        r3 = r4;
    L_0x0005:
        r0 = r9.u7;	 Catch:{ EOFException -> 0x0010 }
        r1 = r0.j6();	 Catch:{ EOFException -> 0x0010 }
        r0 = aue.j6;
        if (r1 != r0) goto L_0x0014;
    L_0x000f:
        return;
    L_0x0010:
        r0 = move-exception;
        if (r3 != 0) goto L_0x000f;
    L_0x0013:
        throw r0;
    L_0x0014:
        r0 = "deepen ";
        r0 = r1.startsWith(r0);
        if (r0 == 0) goto L_0x0029;
    L_0x001d:
        r0 = 7;
        r0 = r1.substring(r0);
        r0 = java.lang.Integer.parseInt(r0);
        r9.Mr = r0;
        goto L_0x0005;
    L_0x0029:
        r0 = "shallow ";
        r0 = r1.startsWith(r0);
        if (r0 == 0) goto L_0x0042;
    L_0x0032:
        r0 = r9.aM;
        r5 = 8;
        r1 = r1.substring(r5);
        r1 = ans.DW(r1);
        r0.add(r1);
        goto L_0x0005;
    L_0x0042:
        r0 = "want ";
        r0 = r1.startsWith(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x004b:
        r0 = r1.length();
        if (r0 >= r8) goto L_0x006b;
    L_0x0051:
        r0 = new alq;
        r3 = org.eclipse.jgit.JGitText.j6();
        r3 = r3.expectedGot;
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = "want";
        r5[r2] = r6;
        r5[r4] = r1;
        r1 = java.text.MessageFormat.format(r3, r5);
        r0.<init>(r1);
        throw r0;
    L_0x006b:
        if (r3 == 0) goto L_0x00ae;
    L_0x006d:
        r0 = r1.length();
        if (r0 <= r8) goto L_0x00ae;
    L_0x0073:
        r0 = r1.substring(r8);
        r3 = " ";
        r3 = r0.startsWith(r3);
        if (r3 == 0) goto L_0x0084;
    L_0x0080:
        r0 = r0.substring(r4);
    L_0x0084:
        r3 = " ";
        r3 = r0.split(r3);
        r5 = r3.length;
        r0 = r2;
    L_0x008d:
        if (r0 < r5) goto L_0x00a4;
    L_0x008f:
        r0 = r1.substring(r2, r8);
    L_0x0093:
        r1 = r9.Ws;
        r3 = 5;
        r0 = r0.substring(r3);
        r0 = ans.DW(r0);
        r1.add(r0);
        r3 = r2;
        goto L_0x0005;
    L_0x00a4:
        r6 = r3[r0];
        r7 = r9.J8;
        r7.add(r6);
        r0 = r0 + 1;
        goto L_0x008d;
    L_0x00ae:
        r0 = r1;
        goto L_0x0093;
        */
        throw new UnsupportedOperationException("Method not decompiled: avo.Zo():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean VH() {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r2 = java.lang.Boolean.FALSE;
        r7.a8 = r2;
        r2 = ans.Zo();
        r3 = new java.util.ArrayList;
        r4 = 64;
        r3.<init>(r4);
    L_0x0011:
        r4 = r7.u7;	 Catch:{ EOFException -> 0x005e }
        r4 = r4.j6();	 Catch:{ EOFException -> 0x005e }
        r5 = aue.j6;
        if (r4 != r5) goto L_0x0076;
    L_0x001b:
        r2 = r7.j6(r3, r2);
        r4 = r7.XL;
        r4 = r4.isEmpty();
        if (r4 != 0) goto L_0x002d;
    L_0x0027:
        r4 = r7.ei;
        r5 = ati$c.OFF;
        if (r4 == r5) goto L_0x0035;
    L_0x002d:
        r4 = r7.tp;
        r5 = "NAK\n";
        r4.j6(r5);
    L_0x0035:
        r4 = r7.nw;
        if (r4 == 0) goto L_0x006a;
    L_0x0039:
        r4 = r7.lg;
        if (r4 == 0) goto L_0x006a;
    L_0x003d:
        r1 = r7.tp;
        r3 = new java.lang.StringBuilder;
        r4 = "ACK ";
        r3.<init>(r4);
        r2 = r2.DW();
        r2 = r3.append(r2);
        r3 = "\n";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.j6(r2);
    L_0x005d:
        return r0;
    L_0x005e:
        r0 = move-exception;
        r2 = r7.v5;
        if (r2 != 0) goto L_0x0069;
    L_0x0063:
        r2 = r7.Mr;
        if (r2 <= 0) goto L_0x0069;
    L_0x0067:
        r0 = r1;
        goto L_0x005d;
    L_0x0069:
        throw r0;
    L_0x006a:
        r4 = r7.v5;
        if (r4 != 0) goto L_0x0070;
    L_0x006e:
        r0 = r1;
        goto L_0x005d;
    L_0x0070:
        r4 = r7.tp;
        r4.DW();
        goto L_0x0011;
    L_0x0076:
        r5 = "have ";
        r5 = r4.startsWith(r5);
        if (r5 == 0) goto L_0x0095;
    L_0x007f:
        r5 = r4.length();
        r6 = 45;
        if (r5 != r6) goto L_0x0095;
    L_0x0087:
        r5 = 5;
        r4 = r4.substring(r5);
        r4 = ans.DW(r4);
        r3.add(r4);
        goto L_0x0011;
    L_0x0095:
        r5 = "done";
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x00da;
    L_0x009e:
        r1 = r7.j6(r3, r2);
        r2 = r7.XL;
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x00b3;
    L_0x00aa:
        r1 = r7.tp;
        r2 = "NAK\n";
        r1.j6(r2);
        goto L_0x005d;
    L_0x00b3:
        r2 = r7.ei;
        r3 = ati$c.OFF;
        if (r2 == r3) goto L_0x005d;
    L_0x00b9:
        r2 = r7.tp;
        r3 = new java.lang.StringBuilder;
        r4 = "ACK ";
        r3.<init>(r4);
        r1 = r1.DW();
        r1 = r3.append(r1);
        r3 = "\n";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r2.j6(r1);
        goto L_0x005d;
    L_0x00da:
        r2 = new alq;
        r3 = org.eclipse.jgit.JGitText.j6();
        r3 = r3.expectedGot;
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = "have";
        r5[r1] = r6;
        r5[r0] = r4;
        r0 = java.text.MessageFormat.format(r3, r5);
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: avo.VH():boolean");
    }

    private ans j6(List<ans> list, ans ans) {
        boolean z = false;
        this.J0.j6(this, this.Ws, list.size());
        if (!list.isEmpty()) {
            boolean z2;
            HashSet hashSet;
            Iterable arrayList;
            this.lg = false;
            if (!this.QX.isEmpty() || this.Ws.isEmpty()) {
                z2 = false;
                hashSet = null;
                Object obj = list;
            } else {
                Collection hashSet2 = new HashSet(list);
                arrayList = new ArrayList(hashSet2.size() + this.Ws.size());
                arrayList.addAll(this.Ws);
                arrayList.addAll(hashSet2);
                hashSet = hashSet2;
                z2 = true;
            }
            apk j6 = this.DW.j6(arrayList, z2);
            int i = 0;
            Set set = null;
            while (true) {
                try {
                    ans j62 = j6.j6();
                    if (j62 == null) {
                        j6.v5();
                        if (!(set == null || set.isEmpty())) {
                            switch (FH()[this.P8.ordinal()]) {
                                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                    j6(set);
                                    break;
                                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                    break;
                                default:
                                    throw new alq(MessageFormat.format(JGitText.j6().wantNotValid, new Object[]{((aqg) set.iterator().next()).DW()}));
                            }
                        }
                        int size = list.size() - i;
                        if (size > 0) {
                            int size2 = list.size() - 1;
                            while (size2 >= 0) {
                                anb anb = (ans) list.get(size2);
                                if (this.DW.v5(anb) != null) {
                                    size2--;
                                } else if (gn()) {
                                    switch (DW()[this.ei.ordinal()]) {
                                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                                            z = true;
                                            break;
                                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                            this.tp.j6("ACK " + anb.DW() + " continue\n");
                                            z = true;
                                            break;
                                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                            this.tp.j6("ACK " + anb.DW() + " ready\n");
                                            this.lg = true;
                                            break;
                                    }
                                    z = true;
                                } else {
                                    z = true;
                                }
                            }
                        }
                        if (this.ei == ati$c.DETAILED && !r6 && gn()) {
                            ans ans2 = (ans) list.get(list.size() - 1);
                            this.lg = true;
                            this.tp.j6("ACK " + ans2.DW() + " ready\n");
                            this.lg = true;
                        }
                        this.J0.j6(this, this.QX, i, size, this.lg);
                        list.clear();
                    } else {
                        if (this.Ws.remove(j62)) {
                            if (!(this.rN.contains(j62) || this.P8 == avo$a.ANY)) {
                                if (set == null) {
                                    set = new HashSet();
                                }
                                set.add(j62);
                            }
                            if (!j62.DW(this.er)) {
                                j62.FH(this.er);
                                this.QX.add(j62);
                            }
                            if (!(j62 instanceof aqc)) {
                                j62.FH(this.BT);
                            }
                            if (j62 instanceof aqj) {
                                aqg VH = this.DW.VH((aqg) j62);
                                if ((VH instanceof aqc) && !VH.DW(this.er)) {
                                    VH.FH(this.er);
                                    this.QX.add(VH);
                                }
                            }
                            if (!hashSet.contains(j62)) {
                            }
                        }
                        Set set2 = set;
                        i++;
                        if (j62 instanceof aqc) {
                            aqc aqc = (aqc) j62;
                            if (this.U2 == 0 || aqc.gn() < this.U2) {
                                this.U2 = aqc.gn();
                            }
                        }
                        if (j62.DW(this.yS)) {
                            set = set2;
                            ans = j62;
                        } else {
                            j62.FH(this.yS);
                            if (j62 instanceof aqc) {
                                ((aqc) j62).j6(this.yS);
                            }
                            j6((aqg) j62);
                            switch (DW()[this.ei.ordinal()]) {
                                case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    if (this.XL.size() != 1) {
                                        set = set2;
                                        ans = j62;
                                        break;
                                    }
                                    this.tp.j6("ACK " + j62.DW() + "\n");
                                    set = set2;
                                    ans = j62;
                                    continue;
                                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                    this.tp.j6("ACK " + j62.DW() + " continue\n");
                                    set = set2;
                                    ans = j62;
                                    continue;
                                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                    this.tp.j6("ACK " + j62.DW() + " common\n");
                                    break;
                            }
                            set = set2;
                            ans = j62;
                        }
                    }
                } catch (Throwable e) {
                    if (this.Ws.contains(e.j6())) {
                        throw new alq(MessageFormat.format(JGitText.j6().wantNotValid, new Object[]{r7.DW()}), e);
                    }
                } catch (Throwable th) {
                    j6.v5();
                }
            }
        }
        return ans;
    }

    private void j6(Set<aqg> set) {
        for (aqg aqg : set) {
            if (aqg instanceof aqc) {
                this.DW.DW((aqc) aqg);
            } else {
                throw new alq(MessageFormat.format(JGitText.j6().wantNotValid, new Object[]{((aqg) set.iterator().next()).DW()}));
            }
        }
        for (anb Zo : this.rN) {
            try {
                this.DW.FH(this.DW.Zo(Zo));
            } catch (alb e) {
            }
        }
        if (this.DW.Hw() != null) {
            throw new alq(MessageFormat.format(JGitText.j6().wantNotValid, new Object[]{r0.DW()}));
        }
        this.DW.XL();
    }

    private void j6(aqg aqg) {
        if (!aqg.DW(this.gW)) {
            aqg.FH(this.gW);
            this.XL.add(aqg);
            this.a8 = null;
        }
    }

    private boolean gn() {
        if (this.a8 == null) {
            this.a8 = Boolean.valueOf(u7());
        }
        return this.a8.booleanValue();
    }

    private boolean u7() {
        if (this.XL.isEmpty()) {
            return false;
        }
        try {
            for (aqg DW : this.QX) {
                if (!DW(DW)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable e) {
            throw new alq(JGitText.j6().internalRevisionError, e);
        }
    }

    private boolean DW(aqg aqg) {
        if (aqg.DW(this.BT)) {
            return true;
        }
        aqg Hw;
        this.DW.j6(this.vy);
        this.DW.DW((aqc) aqg);
        if (this.U2 != 0) {
            this.DW.j6(aqr.j6(((long) this.U2) * 1000));
        }
        do {
            Hw = this.DW.Hw();
            if (Hw == null) {
                return false;
            }
        } while (!Hw.DW(this.yS));
        j6(Hw);
        aqg.FH(this.BT);
        return true;
    }

    private void tp() {
        boolean z = this.J8.contains("side-band") || this.J8.contains("side-band-64k");
        if (!this.v5 && this.VH.read() >= 0) {
            throw new ala(MessageFormat.format(JGitText.j6().expectedEOFReceived, new Object[]{"\\x" + Integer.toHexString(this.VH.read())}));
        } else if (z) {
            try {
                j6(true);
            } catch (avr e) {
                throw e;
            } catch (Throwable e2) {
                if (EQ()) {
                    throw new avp(e2);
                }
                throw e2;
            } catch (Throwable e22) {
                if (EQ()) {
                    throw new avp(e22);
                }
                throw e22;
            } catch (Throwable e222) {
                if (EQ()) {
                    throw new avp(e222);
                }
                throw e222;
            }
        } else {
            j6(false);
        }
    }

    private boolean EQ() {
        try {
            auv auv = new auv(3, 1000, this.gn);
            auv.write(anj.DW(JGitText.j6().internalServerError));
            auv.flush();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private void j6(boolean z) {
        OutputStream auv;
        aob aob = anp.j6;
        OutputStream outputStream = this.gn;
        auv auv2 = null;
        if (z) {
            int i;
            if (this.J8.contains("side-band-64k")) {
                i = 65520;
            } else {
                i = 1000;
            }
            auv = new auv(1, i, this.gn);
            if (!this.J8.contains("no-progress")) {
                auv2 = new auv(2, i, this.gn);
                aob = new auw(auv2);
            }
        } else {
            auv = outputStream;
        }
        try {
            aoc j6;
            aql aql;
            if (this.QX.isEmpty()) {
                this.J0.j6(this, this.Ws, this.XL);
            } else {
                this.J0.j6(this, this.QX, this.XL);
            }
            asw asw = this.FH;
            if (asw == null) {
                asw = new asw(this.j6);
            }
            asy asy = new asy(asw, this.DW.EQ());
            asy.v5(true);
            asy.DW(true);
            asy.j6(this.J8.contains("ofs-delta"));
            asy.Hw(this.J8.contains("thin-pack"));
            asy.FH(false);
            if (this.XL.isEmpty() && this.EQ != null) {
                Set hashSet = new HashSet();
                for (aoc j62 : this.EQ.values()) {
                    if (j62.VH() != null) {
                        hashSet.add(j62.VH());
                    } else {
                        try {
                            if (j62.v5() != null && j62.j6().startsWith("refs/heads/")) {
                                hashSet.add(j62.v5());
                            }
                        } catch (Throwable th) {
                            asy.v5();
                        }
                    }
                }
                asy.j6(hashSet);
            }
            if (this.Mr > 0) {
                asy.j6(this.Mr, this.j3);
            }
            aql aql2 = this.DW;
            if (this.QX.isEmpty()) {
                asy.j6(aob, this.Ws, this.XL);
                aql = aql2;
            } else {
                this.DW.XL();
                aql2 = this.DW.j3();
                asy.j6(aob, (apy) aql2, this.QX, this.XL);
                aql = aql2;
            }
            if (this.J8.contains("include-tag") && this.EQ != null) {
                for (aoc j622 : this.EQ.values()) {
                    anb v5 = j622.v5();
                    if (!this.QX.isEmpty()) {
                        aqg v52 = aql.v5(v5);
                        if (v52 != null && v52.DW(this.er)) {
                        }
                    } else if (this.Ws.contains(v5)) {
                    }
                    if (!j622.gn()) {
                        j622 = this.j6.j6(j622);
                    }
                    v5 = j622.VH();
                    if (v5 != null) {
                        anb v53 = j622.v5();
                        if (asy.j6(v5) && !asy.j6(v53)) {
                            asy.j6(aql.gn(v53));
                        }
                    }
                }
            }
            asy.j6(aob, anp.j6, auv);
            this.SI = asy.Hw();
            if (auv2 != null) {
                auv2.write(anj.DW(new StringBuilder(String.valueOf(asy.Hw().DW())).append('\n').toString()));
                auv2.flush();
            }
            asy.v5();
            if (z) {
                this.tp.j6();
            }
            if (this.SI != null) {
                this.KD.j6(this.SI);
            }
        } catch (avr e) {
            if (z && e.getMessage() != null) {
                e.DW();
                auv2 = new auv(3, 1000, this.gn);
                auv2.write(anj.DW(e.getMessage()));
                auv2.flush();
            }
            throw e;
        }
    }
}
