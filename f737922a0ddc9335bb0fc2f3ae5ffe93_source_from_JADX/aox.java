import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.jgit.JGitText;

public class aox extends apc {
    private List<String> EQ;
    private Map<String, akt> J0;
    private Map<String, aou<? extends akh>> J8;
    private awd Mr;
    private anw QX;
    private aoq U2;
    private awb VH;
    private Map<String, aox$a> Ws;
    private boolean XL;
    private boolean aM;
    private String[] gn;
    private ako j3;
    private ans tp;
    private akq u7;
    private List<String> we;

    protected aox(aoh aoh, boolean z) {
        super(aoh);
        this.EQ = new ArrayList();
        this.we = new LinkedList();
        this.J0 = new HashMap();
        this.J8 = new HashMap();
        this.Ws = new HashMap();
        this.U2 = new aoq(ajr.j6((ajr$a) aoh.VH().j6("diff", null, "algorithm", ajr$a.HISTOGRAM)));
        this.gn = new String[]{"BASE", "OURS", "THEIRS"};
        this.QX = DW();
        this.aM = z;
        if (z) {
            this.j3 = ako.j6();
        }
    }

    protected boolean FH() {
        Object obj;
        if (this.j3 == null) {
            this.j3 = j6().XL();
            obj = 1;
        } else {
            obj = null;
        }
        try {
            this.u7 = this.j3.DW();
            avx akp = new akp(this.u7);
            this.VH = new awb(this.j6);
            this.VH.j6(u7());
            this.VH.DW(this.Zo[0]);
            this.VH.DW(this.Zo[1]);
            this.VH.j6(akp);
            if (this.Mr != null) {
                this.VH.j6(this.Mr);
            }
            while (this.VH.EQ()) {
                awd awd;
                avy avy = (avy) this.VH.j6(0, avy.class);
                avy avy2 = (avy) this.VH.j6(1, avy.class);
                avy avy3 = (avy) this.VH.j6(2, avy.class);
                akp akp2 = (akp) this.VH.j6(3, akp.class);
                if (this.Mr == null) {
                    awd = null;
                } else {
                    awd = (awd) this.VH.j6(4, awd.class);
                }
                if (!j6(avy, avy2, avy3, akp2, awd)) {
                    EQ();
                    break;
                } else if (this.VH.Ws() && this.XL) {
                    this.VH.QX();
                }
            }
            if (this.aM) {
                this.u7.DW();
                this.u7 = null;
            } else if (this.u7.Hw()) {
                this.u7 = null;
                tp();
            } else {
                EQ();
                throw new alc();
            }
            if (v5().isEmpty()) {
                this.tp = this.j3.j6(this.QX);
                if (obj != null) {
                    this.j3.u7();
                }
                return true;
            }
            this.tp = null;
            if (obj != null) {
                this.j3.u7();
            }
            return false;
        } catch (Throwable th) {
            if (obj != null) {
                this.j3.u7();
            }
        }
    }

    private void tp() {
        any Hw = this.j6.FH().Hw();
        for (Entry entry : this.J0.entrySet()) {
            try {
                File file = new File(this.j6.Mr(), (String) entry.getKey());
                if (entry.getValue() != null) {
                    j6(file.getParentFile());
                    akr.j6(this.j6, file, (akt) entry.getValue(), Hw);
                } else if (!file.delete()) {
                    this.Ws.put((String) entry.getKey(), aox$a.COULD_NOT_DELETE);
                }
                this.we.add((String) entry.getKey());
            } finally {
                Hw.FH();
            }
        }
    }

    private void j6(File file) {
        if (!file.isDirectory() && !file.mkdirs()) {
            File file2 = file;
            while (file2 != null && !file2.exists()) {
                file2 = file2.getParentFile();
            }
            if (file2 == null || file2.isDirectory()) {
                throw new IOException(JGitText.j6().cannotCreateDirectory);
            }
            awv.j6(file2);
            if (!file.mkdirs()) {
                throw new IOException(JGitText.j6().cannotCreateDirectory);
            }
        }
    }

    private void EQ() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:42)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:66)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r8 = this;
        r0 = r8.aM;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r8.we;
        r0.clear();
    L_0x0009:
        return;
    L_0x000a:
        r0 = r8.j6;
        r1 = r0.QX();
        r0 = r8.j6;
        r0 = r0.FH();
        r2 = r0.Hw();
        r0 = r8.we;
        r3 = r0.iterator();
    L_0x0020:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0009;
    L_0x0026:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        r4 = r1.DW(r0);
        r5 = new java.io.FileOutputStream;
        r6 = new java.io.File;
        r7 = r8.j6;
        r7 = r7.Mr();
        r6.<init>(r7, r0);
        r5.<init>(r6);
        r0 = r4.J0();	 Catch:{ all -> 0x0052 }
        r0 = r2.FH(r0);	 Catch:{ all -> 0x0052 }
        r0.j6(r5);	 Catch:{ all -> 0x0052 }
        r5.close();
        r3.remove();
        goto L_0x0020;
    L_0x0052:
        r0 = move-exception;
        r5.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: aox.EQ():void");
    }

    private akt j6(byte[] bArr, avy avy, int i) {
        if (avy == null || avy.we().equals(anl.j6)) {
            return null;
        }
        akt akt = new akt(bArr, i);
        akt.j6(avy.we());
        akt.j6(avy.EQ());
        this.u7.DW(akt);
        return akt;
    }

    private boolean j6(avy avy, avy avy2, avy avy3, akp akp, awd awd) {
        this.XL = true;
        int j6 = this.VH.j6(1);
        int j62 = this.VH.j6(2);
        int j63 = this.VH.j6(0);
        if (j6 == 0 && j62 == 0 && j63 == 0) {
            return true;
        }
        if (we()) {
            return false;
        }
        if (DW(j6) && DW(j62) && this.VH.j6(1, 2)) {
            if (j6 == j62) {
                j6(this.VH.J0(), avy2, 0);
                return true;
            }
            j62 = j6(j63, j6, j62);
            if (j62 != anl.Zo.FH()) {
                if (j62 == j6) {
                    j6(this.VH.J0(), avy2, 0);
                } else if (J0()) {
                    return false;
                } else {
                    this.J0.put(this.VH.we(), j6(this.VH.J0(), avy3, 0));
                }
                return true;
            }
            j6(this.VH.J0(), avy, 1);
            j6(this.VH.J0(), avy2, 2);
            j6(this.VH.J0(), avy3, 3);
            this.EQ.add(this.VH.we());
            this.J8.put(this.VH.we(), new aou(Collections.emptyList()));
            return true;
        } else if (DW(j6) && j63 == j62 && this.VH.j6(0, 2)) {
            j6(this.VH.J0(), avy2, 0);
            return true;
        } else {
            if (j63 == j6 && this.VH.j6(0, 1)) {
                if (J0()) {
                    return false;
                }
                if (DW(j62)) {
                    akt j64 = j6(this.VH.J0(), avy3, 0);
                    if (j64 != null) {
                        this.J0.put(this.VH.we(), j64);
                    }
                    return true;
                } else if (j62 == 0 && j63 != 0) {
                    this.J0.put(this.VH.we(), null);
                    return true;
                }
            }
            if (this.VH.Ws()) {
                if (DW(j6) && !DW(j62)) {
                    if (DW(j63)) {
                        j6(this.VH.J0(), avy, 1);
                    }
                    j6(this.VH.J0(), avy2, 2);
                    this.EQ.add(this.VH.we());
                    this.XL = false;
                    return true;
                } else if (DW(j62) && !DW(j6)) {
                    if (DW(j63)) {
                        j6(this.VH.J0(), avy, 1);
                    }
                    j6(this.VH.J0(), avy3, 3);
                    this.EQ.add(this.VH.we());
                    this.XL = false;
                    return true;
                } else if (!DW(j6)) {
                    return true;
                }
            }
            if (DW(j6) && DW(j62)) {
                if (J0()) {
                    return false;
                }
                aou j65 = j6(avy, avy2, avy3);
                j6(avy, avy2, avy3, j65, j6(j65));
                if (j65.DW()) {
                    this.EQ.add(this.VH.we());
                }
                this.we.add(this.VH.we());
            } else if (!(j6 == j62 || ((j6 == 0 || this.VH.j6(0, 1)) && (j62 == 0 || this.VH.j6(0, 2))))) {
                j6(this.VH.J0(), avy, 1);
                j6(this.VH.J0(), avy2, 2);
                akt j66 = j6(this.VH.J0(), avy3, 3);
                if (j6 == 0) {
                    if (J0()) {
                        return false;
                    }
                    if (DW(j62) && j66 != null) {
                        this.J0.put(this.VH.we(), j66);
                    }
                }
                this.EQ.add(this.VH.we());
                this.J8.put(this.VH.we(), j6(avy, avy2, avy3));
            }
            return true;
        }
    }

    private aou<ake> j6(avy avy, avy avy2, avy avy3) {
        return this.U2.j6(akf.j6, avy == null ? ake.j6 : j6(avy.EQ(), this.j6), avy2 == null ? ake.j6 : j6(avy2.EQ(), this.j6), avy3 == null ? ake.j6 : j6(avy3.EQ(), this.j6));
    }

    private boolean we() {
        boolean z = true;
        int j6 = this.VH.j6(3);
        int j62 = this.VH.j6(1);
        if (!DW(j6) || (this.VH.j6(3, 1) && j62 == j6)) {
            z = false;
        }
        if (z) {
            this.Ws.put(this.VH.we(), aox$a.DIRTY_INDEX);
        }
        return z;
    }

    private boolean J0() {
        boolean z = true;
        if (this.aM) {
            return false;
        }
        int j6 = this.VH.j6(4);
        int j62 = this.VH.j6(1);
        if (!DW(j6) || (this.VH.j6(4, 1) && j62 == j6)) {
            z = false;
        }
        if (z) {
            if (j6(j6) && j6(j62)) {
                return false;
            }
            this.Ws.put(this.VH.we(), aox$a.DIRTY_WORKTREE);
        }
        return z;
    }

    private boolean j6(int i) {
        anl j6 = anl.j6(i);
        return j6 == anl.FH || j6 == anl.Hw;
    }

    private void j6(avy avy, avy avy2, avy avy3, aou<ake> aou_ake, File file) {
        if (aou_ake.DW()) {
            j6(this.VH.J0(), avy, 1);
            j6(this.VH.J0(), avy2, 2);
            j6(this.VH.J0(), avy3, 3);
            this.J8.put(this.VH.we(), aou_ake);
            return;
        }
        anl anl;
        akt akt = new akt(this.VH.we());
        int j6 = j6(this.VH.j6(0), this.VH.j6(1), this.VH.j6(2));
        if (j6 == anl.Zo.FH()) {
            anl = anl.FH;
        } else {
            anl = anl.j6(j6);
        }
        akt.j6(anl);
        akt.j6(file.lastModified());
        akt.j6((int) file.length());
        InputStream fileInputStream = new FileInputStream(file);
        try {
            akt.j6(this.QX.j6(3, file.length(), fileInputStream));
            this.u7.DW(akt);
        } finally {
            fileInputStream.close();
            akt = this.aM;
            if (akt != null) {
                awv.j6(file);
            }
        }
    }

    private File j6(aou<ake> aou_ake) {
        File file = null;
        aos aos = new aos();
        OutputStream fileOutputStream;
        if (!this.aM) {
            File Mr = this.j6.Mr();
            if (Mr == null) {
                throw new UnsupportedOperationException();
            }
            file = new File(Mr, this.VH.we());
            fileOutputStream = new FileOutputStream(file);
            try {
                aos.j6(fileOutputStream, aou_ake, Arrays.asList(this.gn), "UTF-8");
            } finally {
                fileOutputStream.close();
            }
        } else if (!aou_ake.DW()) {
            file = File.createTempFile("merge_", "_temp", null);
            fileOutputStream = new FileOutputStream(file);
            try {
                aos.j6(fileOutputStream, aou_ake, Arrays.asList(this.gn), "UTF-8");
            } finally {
                fileOutputStream.close();
            }
        }
        return file;
    }

    private int j6(int i, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        if (i == i2) {
            if (i3 != anl.Zo.FH()) {
                return i3;
            }
            return i2;
        } else if (i != i3) {
            return anl.Zo.FH();
        } else {
            if (i2 != anl.Zo.FH()) {
                i3 = i2;
            }
            return i3;
        }
    }

    private static ake j6(ans ans, aoh aoh) {
        if (ans.DW(ans.Zo())) {
            return new ake(new byte[0]);
        }
        return new ake(aoh.j6((anb) ans, 3).v5());
    }

    private static boolean DW(int i) {
        return (i == 0 || anl.j6.DW(i)) ? false : true;
    }

    public ans Hw() {
        return this.tp == null ? null : this.tp.v5();
    }

    public void j6(String[] strArr) {
        this.gn = strArr;
    }

    public List<String> v5() {
        return this.EQ;
    }

    public Map<String, aou<? extends akh>> Zo() {
        return this.J8;
    }

    public Map<String, aox$a> VH() {
        return this.Ws.size() == 0 ? null : this.Ws;
    }

    public boolean gn() {
        return this.Ws.size() > 0;
    }

    public void j6(awd awd) {
        this.Mr = awd;
    }
}
