import com.aide.uidesigner.ProxyTextView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.JGitText;

public abstract class aub {
    private static /* synthetic */ int[] P8;
    private String BT;
    private aub$c DW;
    private int EQ;
    private byte[] FH;
    private byte[] Hw;
    private boolean J0;
    private boolean J8;
    private int Mr;
    private boolean QX;
    private int U2;
    private InputStream VH;
    private boolean Ws;
    private long XL;
    private final ano Zo;
    private ant<aub$a> a8;
    private aud[] aM;
    private awn<aud> er;
    private any gW;
    private byte[] gn;
    private anv<ans> j3;
    private final anr j6;
    private anv<ans> lg;
    private aty<aub$f> rN;
    private int tp;
    private long u7;
    private final MessageDigest v5;
    private long vy;
    private anq we;
    private MessageDigest yS;

    protected abstract int DW(byte[] bArr, int i, int i2);

    protected abstract void DW();

    protected abstract void DW(aub$e aub_e, byte[] bArr, int i, int i2);

    protected abstract aub$d j6(aub$f aub_f, aub$d aub_d);

    protected abstract aub$d j6(aud aud, aub$d aub_d);

    protected abstract void j6(long j);

    protected abstract void j6(long j, int i, long j2);

    protected abstract void j6(long j, long j2, long j3);

    protected abstract void j6(long j, anb anb, long j2);

    protected abstract void j6(aub$e aub_e, byte[] bArr, int i, int i2);

    protected abstract void j6(aud aud);

    protected abstract void j6(aud aud, int i, byte[] bArr);

    protected abstract void j6(byte[] bArr);

    protected abstract void j6(byte[] bArr, int i, int i2);

    protected abstract boolean j6(int i);

    protected abstract boolean j6(int i, byte[] bArr, aud aud);

    static /* synthetic */ int[] EQ() {
        int[] iArr = P8;
        if (iArr == null) {
            iArr = new int[aub$e.values().length];
            try {
                iArr[aub$e.DATABASE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[aub$e.INPUT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            P8 = iArr;
        }
        return iArr;
    }

    protected aub(anr anr, InputStream inputStream) {
        this.j6 = anr.Zo();
        this.VH = inputStream;
        this.DW = new aub$c(this);
        this.gW = this.j6.Hw();
        this.gn = new byte[8192];
        this.FH = new byte[8192];
        this.Hw = new byte[64];
        this.v5 = anj.j6();
        this.Zo = new ano();
        this.yS = anj.j6();
        this.J8 = true;
    }

    public boolean FH() {
        return this.J0;
    }

    public void j6(boolean z) {
        this.J0 = z;
    }

    public boolean Hw() {
        return this.J8;
    }

    public void DW(boolean z) {
        if (z) {
            this.j3 = new anv();
        } else {
            this.j3 = null;
        }
    }

    private boolean we() {
        return this.j3 != null;
    }

    public void FH(boolean z) {
        this.Ws = z;
    }

    public boolean v5() {
        return this.QX;
    }

    public void Hw(boolean z) {
        this.QX = z;
    }

    public anv<ans> Zo() {
        if (this.j3 != null) {
            return this.j3;
        }
        return new anv();
    }

    public anv<ans> VH() {
        if (this.lg != null) {
            return this.lg;
        }
        return new anv();
    }

    public void j6(anq anq) {
        this.we = anq;
    }

    public void v5(boolean z) {
        j6(z ? new anq() : null);
    }

    public String gn() {
        return this.BT;
    }

    public void j6(String str) {
        this.BT = str;
    }

    public void DW(long j) {
        this.vy = j;
    }

    public int u7() {
        return this.U2;
    }

    public aud DW(int i) {
        return this.aM[i];
    }

    public List<aud> j6(Comparator<aud> comparator) {
        Arrays.sort(this.aM, 0, this.U2, comparator);
        List<aud> asList = Arrays.asList(this.aM);
        if (this.U2 < this.aM.length) {
            return asList.subList(0, this.U2);
        }
        return asList;
    }

    public final arw j6(aob aob) {
        return j6(aob, aob);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public arw j6(aob r12, aob r13) {
        /*
        r11 = this;
        r2 = 0;
        r10 = 0;
        if (r12 != 0) goto L_0x0006;
    L_0x0004:
        r12 = anp.j6;
    L_0x0006:
        if (r13 != 0) goto L_0x0137;
    L_0x0008:
        r3 = anp.j6;
    L_0x000a:
        if (r12 != r3) goto L_0x0010;
    L_0x000c:
        r4 = 2;
        r12.DW(r4);
    L_0x0010:
        r11.J0();	 Catch:{ all -> 0x00a6 }
        r4 = r11.XL;	 Catch:{ all -> 0x00a6 }
        r4 = (int) r4;	 Catch:{ all -> 0x00a6 }
        r4 = new aud[r4];	 Catch:{ all -> 0x00a6 }
        r11.aM = r4;	 Catch:{ all -> 0x00a6 }
        r4 = new ant;	 Catch:{ all -> 0x00a6 }
        r4.<init>();	 Catch:{ all -> 0x00a6 }
        r11.a8 = r4;	 Catch:{ all -> 0x00a6 }
        r4 = new aty;	 Catch:{ all -> 0x00a6 }
        r4.<init>();	 Catch:{ all -> 0x00a6 }
        r11.rN = r4;	 Catch:{ all -> 0x00a6 }
        r4 = new awn;	 Catch:{ all -> 0x00a6 }
        r4.<init>();	 Catch:{ all -> 0x00a6 }
        r11.er = r4;	 Catch:{ all -> 0x00a6 }
        r4 = org.eclipse.jgit.JGitText.j6();	 Catch:{ all -> 0x00a6 }
        r4 = r4.receivingObjects;	 Catch:{ all -> 0x00a6 }
        r6 = r11.XL;	 Catch:{ all -> 0x00a6 }
        r5 = (int) r6;	 Catch:{ all -> 0x00a6 }
        r12.j6(r4, r5);	 Catch:{ all -> 0x00a6 }
    L_0x003b:
        r4 = (long) r2;
        r6 = r11.XL;	 Catch:{ all -> 0x00d3 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 < 0) goto L_0x00ba;
    L_0x0042:
        r11.J8();	 Catch:{ all -> 0x00d3 }
        r11.Ws();	 Catch:{ all -> 0x00d3 }
        r12.DW();	 Catch:{ all -> 0x00a6 }
        r2 = r11.er;	 Catch:{ all -> 0x00a6 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x00a6 }
        if (r2 != 0) goto L_0x0056;
    L_0x0053:
        r11.XL();	 Catch:{ all -> 0x00a6 }
    L_0x0056:
        r2 = r11.Mr;	 Catch:{ all -> 0x00a6 }
        if (r2 <= 0) goto L_0x010b;
    L_0x005a:
        r2 = r3 instanceof ang;	 Catch:{ all -> 0x00a6 }
        if (r2 == 0) goto L_0x0069;
    L_0x005e:
        r0 = r3;
        r0 = (ang) r0;	 Catch:{ all -> 0x00a6 }
        r2 = r0;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00a6 }
        r2.j6(r4, r6);	 Catch:{ all -> 0x00a6 }
    L_0x0069:
        r2 = org.eclipse.jgit.JGitText.j6();	 Catch:{ all -> 0x00a6 }
        r2 = r2.resolvingDeltas;	 Catch:{ all -> 0x00a6 }
        r4 = r11.Mr;	 Catch:{ all -> 0x00a6 }
        r3.j6(r2, r4);	 Catch:{ all -> 0x00a6 }
        r11.DW(r3);	 Catch:{ all -> 0x00a6 }
        r2 = r11.U2;	 Catch:{ all -> 0x00a6 }
        r4 = (long) r2;	 Catch:{ all -> 0x00a6 }
        r6 = r11.XL;	 Catch:{ all -> 0x00a6 }
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x0108;
    L_0x0080:
        r2 = r11.FH();	 Catch:{ all -> 0x00a6 }
        if (r2 != 0) goto L_0x00dc;
    L_0x0086:
        r2 = new java.io.IOException;	 Catch:{ all -> 0x00a6 }
        r3 = org.eclipse.jgit.JGitText.j6();	 Catch:{ all -> 0x00a6 }
        r3 = r3.packHasUnresolvedDeltas;	 Catch:{ all -> 0x00a6 }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00a6 }
        r5 = 0;
        r6 = r11.XL;	 Catch:{ all -> 0x00a6 }
        r8 = r11.U2;	 Catch:{ all -> 0x00a6 }
        r8 = (long) r8;	 Catch:{ all -> 0x00a6 }
        r6 = r6 - r8;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00a6 }
        r4[r5] = r6;	 Catch:{ all -> 0x00a6 }
        r3 = java.text.MessageFormat.format(r3, r4);	 Catch:{ all -> 0x00a6 }
        r2.<init>(r3);	 Catch:{ all -> 0x00a6 }
        throw r2;	 Catch:{ all -> 0x00a6 }
    L_0x00a6:
        r2 = move-exception;
        r3 = r11.gW;	 Catch:{ all -> 0x0127 }
        if (r3 == 0) goto L_0x00b0;
    L_0x00ab:
        r3 = r11.gW;	 Catch:{ all -> 0x0127 }
        r3.FH();	 Catch:{ all -> 0x0127 }
    L_0x00b0:
        r11.gW = r10;
        r3 = r11.DW;	 Catch:{ all -> 0x012b }
        r3.j6();	 Catch:{ all -> 0x012b }
        r11.DW = r10;
        throw r2;
    L_0x00ba:
        r11.QX();	 Catch:{ all -> 0x00d3 }
        r4 = 1;
        r12.j6(r4);	 Catch:{ all -> 0x00d3 }
        r4 = r12.j6();	 Catch:{ all -> 0x00d3 }
        if (r4 == 0) goto L_0x00d8;
    L_0x00c7:
        r2 = new java.io.IOException;	 Catch:{ all -> 0x00d3 }
        r3 = org.eclipse.jgit.JGitText.j6();	 Catch:{ all -> 0x00d3 }
        r3 = r3.downloadCancelled;	 Catch:{ all -> 0x00d3 }
        r2.<init>(r3);	 Catch:{ all -> 0x00d3 }
        throw r2;	 Catch:{ all -> 0x00d3 }
    L_0x00d3:
        r2 = move-exception;
        r12.DW();	 Catch:{ all -> 0x00a6 }
        throw r2;	 Catch:{ all -> 0x00a6 }
    L_0x00d8:
        r2 = r2 + 1;
        goto L_0x003b;
    L_0x00dc:
        r11.FH(r3);	 Catch:{ all -> 0x00a6 }
        r2 = r11.U2;	 Catch:{ all -> 0x00a6 }
        r4 = (long) r2;	 Catch:{ all -> 0x00a6 }
        r6 = r11.XL;	 Catch:{ all -> 0x00a6 }
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x0108;
    L_0x00e8:
        r2 = new java.io.IOException;	 Catch:{ all -> 0x00a6 }
        r3 = org.eclipse.jgit.JGitText.j6();	 Catch:{ all -> 0x00a6 }
        r3 = r3.packHasUnresolvedDeltas;	 Catch:{ all -> 0x00a6 }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00a6 }
        r5 = 0;
        r6 = r11.XL;	 Catch:{ all -> 0x00a6 }
        r8 = r11.U2;	 Catch:{ all -> 0x00a6 }
        r8 = (long) r8;	 Catch:{ all -> 0x00a6 }
        r6 = r6 - r8;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00a6 }
        r4[r5] = r6;	 Catch:{ all -> 0x00a6 }
        r3 = java.text.MessageFormat.format(r3, r4);	 Catch:{ all -> 0x00a6 }
        r2.<init>(r3);	 Catch:{ all -> 0x00a6 }
        throw r2;	 Catch:{ all -> 0x00a6 }
    L_0x0108:
        r3.DW();	 Catch:{ all -> 0x00a6 }
    L_0x010b:
        r2 = 0;
        r11.yS = r2;	 Catch:{ all -> 0x00a6 }
        r2 = 0;
        r11.a8 = r2;	 Catch:{ all -> 0x00a6 }
        r2 = 0;
        r11.rN = r2;	 Catch:{ all -> 0x00a6 }
        r2 = r11.gW;	 Catch:{ all -> 0x012f }
        if (r2 == 0) goto L_0x011d;
    L_0x0118:
        r2 = r11.gW;	 Catch:{ all -> 0x012f }
        r2.FH();	 Catch:{ all -> 0x012f }
    L_0x011d:
        r11.gW = r10;
        r2 = r11.DW;	 Catch:{ all -> 0x0133 }
        r2.j6();	 Catch:{ all -> 0x0133 }
        r11.DW = r10;
        return r10;
    L_0x0127:
        r2 = move-exception;
        r11.gW = r10;
        throw r2;
    L_0x012b:
        r2 = move-exception;
        r11.DW = r10;
        throw r2;
    L_0x012f:
        r2 = move-exception;
        r11.gW = r10;
        throw r2;
    L_0x0133:
        r2 = move-exception;
        r11.DW = r10;
        throw r2;
    L_0x0137:
        r3 = r13;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: aub.j6(aob, aob):arw");
    }

    private void DW(aob aob) {
        int i = this.U2;
        for (int i2 = 0; i2 < i; i2++) {
            j6(this.aM[i2], aob);
            if (aob.j6()) {
                throw new IOException(JGitText.j6().downloadCancelledDuringIndexing);
            }
        }
    }

    private void j6(aud aud, aob aob) {
        aub$f DW = DW(aud);
        if (DW != null) {
            aub$b aub_b = new aub$b();
            aub_b.v5 = DW;
            aub$d DW2 = DW(aud, new aub$d());
            switch (DW2.j6) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    aub_b.FH = DW(aub$e.DATABASE, DW2.DW);
                    aub_b.DW = aud;
                    if (j6(aud.gW())) {
                        j6(aub_b.j6(), DW2.j6, DW2, aob);
                        return;
                    }
                    throw new IOException(MessageFormat.format(JGitText.j6().corruptionDetectedReReadingAt, new Object[]{Long.valueOf(aud.yS())}));
                default:
                    throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(DW2.j6)}));
            }
        }
    }

    private void j6(aub$b aub_b, int i, aub$d aub_d, aob aob) {
        do {
            aob.j6(1);
            aub_d = DW(aub_b.j6, aub_d);
            switch (aub_d.j6) {
                case 6:
                case 7:
                    byte[] DW = DW(aub$e.DATABASE, aub_d.DW);
                    j6(i, asj.j6(DW));
                    aub_b.FH = asj.j6(aub_b.Hw.FH, DW);
                    DW = (byte[]) null;
                    if (j6(aub_b.j6.DW)) {
                        this.v5.update(anj.DW(i));
                        this.v5.update((byte) 32);
                        this.v5.update(anj.j6((long) aub_b.FH.length));
                        this.v5.update((byte) 0);
                        this.v5.update(aub_b.FH);
                        this.Zo.Hw(this.v5.digest(), 0);
                        j6(this.Zo, i, aub_b.FH);
                        aud j6 = j6(this.Zo, aub_b.j6, aub_b.Hw.DW);
                        j6.j6(aub_b.j6.j6);
                        j6(j6, i, aub_b.FH);
                        FH(j6);
                        aub_b.DW = j6;
                        aub_b.v5 = DW(j6);
                        aub_b = aub_b.j6();
                        break;
                    }
                    throw new IOException(MessageFormat.format(JGitText.j6().corruptionDetectedReReadingAt, new Object[]{Long.valueOf(aub_b.j6.j6)}));
                default:
                    throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(aub_d.j6)}));
            }
        } while (aub_b != null);
    }

    private final void j6(int i, long j) {
        if (0 < this.vy && this.vy < j) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    throw new alx(j, this.vy);
                case 6:
                case 7:
                    throw new alx(this.vy);
                default:
                    throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(i)}));
            }
        }
    }

    protected aub$d j6(aub$d aub_d) {
        int j6 = j6(aub$e.DATABASE);
        this.Hw[0] = (byte) j6;
        aub_d.j6 = (j6 >> 4) & 7;
        long j = (long) (j6 & 15);
        int i = 4;
        int i2 = 1;
        while ((j6 & 128) != 0) {
            j6 = j6(aub$e.DATABASE);
            int i3 = i2 + 1;
            this.Hw[i2] = (byte) j6;
            j += (long) ((j6 & 127) << i);
            i += 7;
            i2 = i3;
        }
        aub_d.DW = j;
        switch (aub_d.j6) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                j6(aub$e.DATABASE, this.Hw, 0, i2);
                break;
            case 6:
                i = j6(aub$e.DATABASE);
                j6 = i2 + 1;
                this.Hw[i2] = (byte) i;
                while ((i & 128) != 0) {
                    i = j6(aub$e.DATABASE);
                    int i4 = j6 + 1;
                    this.Hw[j6] = (byte) i;
                    j6 = i4;
                }
                j6(aub$e.DATABASE, this.Hw, 0, j6);
                break;
            case 7:
                System.arraycopy(this.gn, j6(aub$e.DATABASE, 20), this.Hw, i2, 20);
                i = i2 + 20;
                Hw(20);
                j6(aub$e.DATABASE, this.Hw, 0, i);
                break;
            default:
                throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(aub_d.j6)}));
        }
        return aub_d;
    }

    private aub$f j6(anb anb) {
        aub$a aub_a = (aub$a) this.a8.j6(anb);
        return aub_a != null ? aub_a.VH() : null;
    }

    private static aub$f j6(aub$f aub_f) {
        aub$f aub_f2 = null;
        aub$f aub_f3 = aub_f;
        while (aub_f3 != null) {
            aub_f = aub_f3.FH;
            aub_f3.FH = aub_f2;
            aub_f2 = aub_f3;
            aub_f3 = aub_f;
        }
        return aub_f2;
    }

    private aub$f DW(aud aud) {
        aub$f j6 = j6(j6((anb) aud));
        aub$f j62 = j6((aub$f) this.rN.j6(aud.yS()));
        if (j6 == null) {
            return j62;
        }
        if (j62 == null) {
            return j6;
        }
        aub$f aub_f = null;
        aub$f aub_f2 = j6;
        j6 = j62;
        j62 = null;
        while (true) {
            if (aub_f2 == null && j6 == null) {
                return j62;
            }
            aub$f aub_f3;
            if (j6 == null || (aub_f2 != null && aub_f2.j6 < j6.j6)) {
                aub_f3 = aub_f2.FH;
                aub$f aub_f4 = aub_f2;
                aub_f2 = j6;
                j6 = aub_f4;
            } else {
                aub_f3 = aub_f2;
                aub_f2 = j6.FH;
            }
            if (aub_f != null) {
                aub_f.FH = j6;
            } else {
                j62 = j6;
            }
            j6.FH = null;
            aub_f = j6;
            j6 = aub_f2;
            aub_f2 = aub_f3;
        }
    }

    private void FH(aob aob) {
        FH(this.a8.DW());
        if (this.Ws) {
            this.lg = new anv();
        }
        List<ans> arrayList = new ArrayList(64);
        Iterator it = this.a8.iterator();
        while (it.hasNext()) {
            anb anb = (aub$a) it.next();
            if (anb.VH != null) {
                if (this.Ws) {
                    this.lg.j6((ans) anb);
                }
                try {
                    anx FH = this.gW.FH(anb);
                    aub$b aub_b = new aub$b();
                    aub_b.FH = FH.DW(Integer.MAX_VALUE);
                    aub_b.DW = anb;
                    int DW = FH.DW();
                    aud j6 = j6(anb, null, null);
                    if (j6(DW, aub_b.FH, j6)) {
                        aud[] audArr = this.aM;
                        int i = this.U2;
                        this.U2 = i + 1;
                        audArr[i] = j6;
                    }
                    aub_b.v5 = DW(j6);
                    j6(aub_b.j6(), DW, new aub$d(), aob);
                    if (aob.j6()) {
                        throw new IOException(JGitText.j6().downloadCancelledDuringIndexing);
                    }
                } catch (ali e) {
                    arrayList.add(anb);
                }
            }
        }
        for (ans ans : arrayList) {
            if (ans.VH != null) {
                throw new ali(ans, "delta base");
            }
        }
        DW();
    }

    private void FH(int i) {
        Object obj = new aud[(((int) this.XL) + i)];
        System.arraycopy(this.aM, 0, obj, 0, this.U2);
        this.aM = obj;
    }

    private void J0() {
        int length = (anj.j6.length + 4) + 4;
        int j6 = j6(aub$e.INPUT, length);
        for (int i = 0; i < anj.j6.length; i++) {
            if (this.gn[j6 + i] != anj.j6[i]) {
                throw new IOException(JGitText.j6().notAPACKFile);
            }
        }
        long FH = axb.FH(this.gn, j6 + 4);
        if (FH == 2 || FH == 3) {
            this.XL = axb.FH(this.gn, j6 + 8);
            Hw(length);
            j6(this.XL);
            return;
        }
        throw new IOException(MessageFormat.format(JGitText.j6().unsupportedPackVersion, new Object[]{Long.valueOf(FH)}));
    }

    private void J8() {
        j3();
        byte[] digest = this.yS.digest();
        byte[] bArr = new byte[20];
        System.arraycopy(this.gn, j6(aub$e.INPUT, 20), bArr, 0, 20);
        Hw(20);
        if (this.EQ != 0) {
            throw new ala(MessageFormat.format(JGitText.j6().expectedEOFReceived, new Object[]{"\\x" + Integer.toHexString(this.gn[this.tp] & 255)}));
        } else if (v5() && this.VH.read() >= 0) {
            throw new ala(MessageFormat.format(JGitText.j6().expectedEOFReceived, new Object[]{"\\x" + Integer.toHexString(r1)}));
        } else if (Arrays.equals(digest, bArr)) {
            j6(bArr);
        } else {
            throw new ala(JGitText.j6().corruptObjectPackfileChecksumIncorrect);
        }
    }

    private void Ws() {
        this.VH = null;
    }

    private void QX() {
        long aM = aM();
        int j6 = j6(aub$e.INPUT);
        this.Hw[0] = (byte) j6;
        int i = (j6 >> 4) & 7;
        long j = (long) (j6 & 15);
        int i2 = 4;
        int i3 = 1;
        while ((j6 & 128) != 0) {
            j6 = j6(aub$e.INPUT);
            int i4 = i3 + 1;
            this.Hw[i3] = (byte) j6;
            j += (long) ((j6 & 127) << i2);
            i2 += 7;
            i3 = i4;
        }
        j6(i, j);
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                j6(aM, i, j);
                j6(aub$e.INPUT, this.Hw, 0, i3);
                DW(aM, i, j);
            case 6:
                i2 = j6(aub$e.INPUT);
                i = i3 + 1;
                this.Hw[i3] = (byte) i2;
                long j2 = (long) (i2 & 127);
                while ((i2 & 128) != 0) {
                    j2++;
                    i2 = j6(aub$e.INPUT);
                    int i5 = i + 1;
                    this.Hw[i] = (byte) i2;
                    j2 = (j2 << 7) + ((long) (i2 & 127));
                    i = i5;
                }
                long j3 = aM - j2;
                j6(aM, j3, j);
                j6(aub$e.INPUT, this.Hw, 0, i);
                j6(aub$e.INPUT, j);
                aub$f j62 = j6();
                j62.j6 = aM;
                j62.FH = (aub$f) this.rN.j6(j3, j62);
                this.Mr++;
            case 7:
                aub$a aub_a;
                i2 = j6(aub$e.INPUT, 20);
                anb Hw = ans.Hw(this.gn, i2);
                System.arraycopy(this.gn, i2, this.Hw, i3, 20);
                i3 += 20;
                Hw(20);
                aub$a aub_a2 = (aub$a) this.a8.j6(Hw);
                if (aub_a2 == null) {
                    ant$a aub_a3 = new aub$a(Hw);
                    this.a8.j6(aub_a3);
                    aub_a = aub_a3;
                } else {
                    aub_a = aub_a2;
                }
                j6(aM, Hw, j);
                j6(aub$e.INPUT, this.Hw, 0, i3);
                j6(aub$e.INPUT, j);
                aub$f j63 = j6();
                j63.j6 = aM;
                aub_a.j6(j63);
                this.Mr++;
            default:
                throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(i)}));
        }
    }

    private void DW(long j, int i, long j2) {
        Object obj;
        byte[] bArr;
        this.v5.update(anj.DW(i));
        this.v5.update((byte) 32);
        this.v5.update(anj.j6(j2));
        this.v5.update((byte) 0);
        if (i == 3) {
            byte[] tp = tp();
            InputStream FH = FH(aub$e.INPUT, j2);
            long j3 = 0;
            while (j3 < j2) {
                int read = FH.read(tp);
                if (read <= 0) {
                    break;
                }
                this.v5.update(tp, 0, read);
                j3 += (long) read;
            }
            FH.close();
            this.Zo.Hw(this.v5.digest(), 0);
            if (Hw() && this.gW.DW(this.Zo)) {
                obj = 1;
            } else {
                obj = (byte) 0;
            }
            bArr = (byte[]) null;
        } else {
            byte[] DW = DW(aub$e.INPUT, j2);
            this.v5.update(DW);
            this.Zo.Hw(this.v5.digest(), 0);
            j6(this.Zo, i, DW);
            bArr = DW;
            obj = (byte) 0;
        }
        aud j6 = j6(this.Zo, null, null);
        j6.j6(j);
        j6(j6);
        if (bArr != null) {
            j6(j6, i, bArr);
        }
        FH(j6);
        if (obj != null) {
            this.er.add(j6);
        }
    }

    private void j6(anb anb, int i, byte[] bArr) {
        if (this.we != null) {
            try {
                this.we.j6(i, bArr);
            } catch (ala e) {
                throw new IOException(MessageFormat.format(JGitText.j6().invalidObject, new Object[]{anj.j6(i), anb.DW(), e.getMessage()}));
            }
        }
        if (Hw()) {
            try {
                if (!Arrays.equals(bArr, this.gW.FH(anb, i).DW(bArr.length))) {
                    throw new IOException(MessageFormat.format(JGitText.j6().collisionOn, new Object[]{anb.DW()}));
                }
            } catch (ali e2) {
            }
        }
    }

    private void XL() {
        byte[] tp = tp();
        byte[] bArr = new byte[tp.length];
        aub$d aub_d = new aub$d();
        Iterator it = this.er.iterator();
        aub$d aub_d2 = aub_d;
        while (it.hasNext()) {
            aud aud = (aud) it.next();
            aub_d2 = DW(aud, aub_d2);
            if (aub_d2.j6 != 3) {
                throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(aub_d2.j6)}));
            }
            InputStream FH = this.gW.FH(aud, aub_d2.j6).FH();
            try {
                long j = aub_d2.DW;
                if (FH.j6() != j) {
                    throw new IOException(MessageFormat.format(JGitText.j6().collisionOn, new Object[]{aud.DW()}));
                }
                InputStream FH2 = FH(aub$e.DATABASE, j);
                while (0 < j) {
                    int min = (int) Math.min((long) tp.length, j);
                    awx.j6(FH, bArr, 0, min);
                    awx.j6(FH2, tp, 0, min);
                    for (int i = 0; i < min; i++) {
                        if (bArr[i] != tp[i]) {
                            throw new IOException(MessageFormat.format(JGitText.j6().collisionOn, new Object[]{aud.DW()}));
                        }
                    }
                    j -= (long) min;
                }
                FH2.close();
                FH.close();
            } catch (Throwable th) {
                FH.close();
            }
        }
    }

    private long aM() {
        return this.u7 + ((long) this.tp);
    }

    private aub$d DW(aud aud, aub$d aub_d) {
        this.tp = 0;
        this.EQ = 0;
        return j6(aud, aub_d);
    }

    private aub$d DW(aub$f aub_f, aub$d aub_d) {
        this.tp = 0;
        this.EQ = 0;
        return j6(aub_f, aub_d);
    }

    private int j6(aub$e aub_e) {
        if (this.EQ == 0) {
            j6(aub_e, 1);
        }
        this.EQ--;
        byte[] bArr = this.gn;
        int i = this.tp;
        this.tp = i + 1;
        return bArr[i] & 255;
    }

    private void Hw(int i) {
        this.tp += i;
        this.EQ -= i;
    }

    private int j6(aub$e aub_e, int i) {
        while (this.EQ < i) {
            int i2 = this.EQ + this.tp;
            int length = this.gn.length - i2;
            if (this.EQ + length < i) {
                switch (EQ()[aub_e.ordinal()]) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        j3();
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        if (this.EQ > 0) {
                            System.arraycopy(this.gn, this.tp, this.gn, 0, this.EQ);
                        }
                        this.tp = 0;
                        break;
                }
                i2 = this.EQ;
                length = this.gn.length - i2;
            }
            switch (EQ()[aub_e.ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i2 = this.VH.read(this.gn, i2, length);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    i2 = DW(this.gn, i2, length);
                    break;
            }
            if (i2 <= 0) {
                throw new EOFException(JGitText.j6().packfileIsTruncated);
            }
            this.EQ += i2;
        }
        return this.tp;
    }

    private void j3() {
        this.yS.update(this.gn, 0, this.tp);
        j6(this.gn, 0, this.tp);
        if (this.EQ > 0) {
            System.arraycopy(this.gn, this.tp, this.gn, 0, this.EQ);
        }
        this.u7 += (long) this.tp;
        this.tp = 0;
    }

    protected byte[] tp() {
        return this.FH;
    }

    protected aud j6(anb anb, aub$f aub_f, ans ans) {
        aud aud = new aud(anb);
        if (aub_f != null) {
            aud.Zo(aub_f.DW);
        }
        return aud;
    }

    protected aub$f j6() {
        return new aub$f();
    }

    private void j6(aub$e aub_e, long j) {
        InputStream FH = FH(aub_e, j);
        awx.j6(FH, j);
        FH.close();
    }

    private byte[] DW(aub$e aub_e, long j) {
        byte[] bArr = new byte[((int) j)];
        InputStream FH = FH(aub_e, j);
        awx.j6(FH, bArr, 0, bArr.length);
        FH.close();
        return bArr;
    }

    private InputStream FH(aub$e aub_e, long j) {
        this.DW.j6(aub_e, j);
        return this.DW;
    }

    private void FH(aud aud) {
        aud[] audArr = this.aM;
        int i = this.U2;
        this.U2 = i + 1;
        audArr[i] = aud;
        if (we()) {
            this.j3.j6((ans) aud);
        }
    }
}
