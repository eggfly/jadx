import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jgit.JGitText;

public class arl extends arb {
    private static final arl$b j6;
    private final ani DW;
    private final AtomicReference<arb$a[]> EQ;
    private final File FH;
    private final File Hw;
    private final File VH;
    private final File Zo;
    private final AtomicReference<arl$b> gn;
    private final awp tp;
    private final AtomicReference<arl$a> u7;
    private final File v5;
    private final asd we;

    static {
        j6 = new arl$b(are.j6, new aro[0]);
    }

    public arl(ani ani, File file, File[] fileArr, awp awp) {
        this.DW = ani;
        this.FH = file;
        this.Hw = new File(this.FH, "info");
        this.v5 = new File(this.FH, "pack");
        this.Zo = new File(this.Hw, "alternates");
        this.VH = new File(this.Hw, "cached-packs");
        this.gn = new AtomicReference(j6);
        this.u7 = new AtomicReference();
        this.we = new asd();
        this.tp = awp;
        this.EQ = new AtomicReference();
        if (fileArr != null) {
            Object obj = new arb$a[fileArr.length];
            for (int i = 0; i < fileArr.length; i++) {
                obj[i] = DW(fileArr[i]);
            }
            this.EQ.set(obj);
        }
    }

    public final File gn() {
        return this.FH;
    }

    public boolean j6() {
        return this.FH.exists();
    }

    public void DW() {
        awv.FH(this.FH);
        awv.DW(this.Hw);
        awv.DW(this.v5);
    }

    public arm Ws() {
        return new arm(this, this.DW);
    }

    public void v5() {
        int i = 0;
        this.we.j6();
        arl$b arl_b = (arl$b) this.gn.get();
        this.gn.set(j6);
        for (aro FH : arl_b.DW) {
            FH.FH();
        }
        arb$a[] arb_aArr = (arb$a[]) this.EQ.get();
        if (arb_aArr != null) {
            this.EQ.set(null);
            int length = arb_aArr.length;
            while (i < length) {
                arb_aArr[i].DW();
                i++;
            }
        }
    }

    public File FH(anb anb) {
        return super.FH(anb);
    }

    public Collection<aro> J8() {
        arl$b arl_b = (arl$b) this.gn.get();
        if (arl_b == j6) {
            arl_b = j6(arl_b);
        }
        return Collections.unmodifiableCollection(Arrays.asList(arl_b.DW));
    }

    Collection<? extends ask> EQ() {
        arl$a arl_a = (arl$a) this.u7.get();
        if (arl_a == null || arl_a.j6.DW(this.VH)) {
            arl_a = j6(arl_a);
        }
        Collection<? extends ask> j6 = arl_a.j6();
        Object obj = null;
        for (arb$a j62 : we()) {
            Collection<? extends ask> j63 = j62.j6();
            if (!j63.isEmpty()) {
                if (j6.isEmpty()) {
                    j6 = j63;
                } else {
                    Collection<? extends ask> arrayList;
                    if (obj == null) {
                        arrayList = new ArrayList(j6);
                        obj = 1;
                    } else {
                        arrayList = j6;
                    }
                    arrayList.addAll(j63);
                    j6 = arrayList;
                }
            }
        }
        return j6;
    }

    private arl$a j6(arl$a arl_a) {
        byte[] j6;
        int i = 0;
        are j62 = are.j6(this.VH);
        try {
            j6 = awx.j6(this.VH);
        } catch (FileNotFoundException e) {
            j6 = new byte[0];
        }
        if (arl_a != null && arl_a.j6.DW(j62) && Arrays.equals(arl_a.FH, j6)) {
            arl_a.j6.j6(j62);
            return arl_a;
        }
        List arrayList = new ArrayList(4);
        Set hashSet = new HashSet();
        while (i < j6.length) {
            if (j6[i] == 35 || j6[i] == (byte) 10) {
                i = axe.Hw(j6, i);
            } else if (j6[i] == 43) {
                hashSet.add(ans.v5(j6, i + 2));
                i = axe.Hw(j6, i + 2);
            } else {
                List arrayList2 = new ArrayList(4);
                while (i < j6.length && j6[i] == 80) {
                    int Hw = axe.Hw(j6, i);
                    if (j6[Hw - 1] == (byte) 10) {
                        Hw--;
                    }
                    arrayList2.add(axe.FH(j6, i + 2, Hw));
                    i = axe.Hw(j6, Hw);
                }
                if (!(hashSet.isEmpty() || arrayList2.isEmpty())) {
                    arrayList.add(new arh(this, hashSet, arrayList2));
                    hashSet = new HashSet();
                }
            }
        }
        arrayList.trimToSize();
        return new arl$a(j62, Collections.unmodifiableList(arrayList), j6);
    }

    public aro j6(File file, File file2) {
        String name = file.getName();
        String name2 = file2.getName();
        if (name.length() != 50 || !name.startsWith("pack-") || !name.endsWith(".pack")) {
            throw new IOException(MessageFormat.format(JGitText.j6().notAValidPack, new Object[]{file}));
        } else if (name2.length() != 49 || !name2.startsWith("pack-") || !name2.endsWith(".idx")) {
            throw new IOException(MessageFormat.format(JGitText.j6().notAValidPack, new Object[]{file2}));
        } else if (name.substring(0, 45).equals(name2.substring(0, 45))) {
            aro aro = new aro(file2, file);
            j6(aro);
            return aro;
        } else {
            throw new IOException(MessageFormat.format(JGitText.j6().packDoesNotMatchIndex, new Object[]{file}));
        }
    }

    public String toString() {
        return "ObjectDirectory[" + gn() + "]";
    }

    boolean DW(anb anb) {
        if (this.we.j6(anb)) {
            return true;
        }
        aro[] aroArr = ((arl$b) this.gn.get()).DW;
        int length = aroArr.length;
        int i = 0;
        while (i < length) {
            aro aro = aroArr[i];
            try {
                if (aro.j6(anb)) {
                    return true;
                }
                i++;
            } catch (IOException e) {
                DW(aro);
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(java.util.Set<ans> r10, amz r11) {
        /*
        r9 = this;
        r8 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r2 = 0;
        r3 = r10.size();
        r0 = r9.gn;
        r0 = r0.get();
        r0 = (arl$b) r0;
    L_0x000f:
        r4 = r0.DW;
        r5 = r4.length;
        r1 = r2;
    L_0x0013:
        if (r1 < r5) goto L_0x004b;
    L_0x0015:
        r1 = r10.size();
        if (r1 != r3) goto L_0x0026;
    L_0x001b:
        r1 = r9.j6(r0);
        if (r1 == r0) goto L_0x0026;
    L_0x0021:
        r0 = r1.DW;
        r0 = r0.length;
        if (r0 != 0) goto L_0x0060;
    L_0x0026:
        r0 = r11.v5();
        r1 = 2;
        r1 = r0.substring(r2, r1);
        r0 = new java.io.File;
        r3 = r9.gn();
        r0.<init>(r3, r1);
        r3 = r0.list();
        if (r3 == 0) goto L_0x0042;
    L_0x003e:
        r4 = r3.length;
        r0 = r2;
    L_0x0040:
        if (r0 < r4) goto L_0x0062;
    L_0x0042:
        r1 = r9.we();
        r3 = r1.length;
        r0 = r2;
    L_0x0048:
        if (r0 < r3) goto L_0x0094;
    L_0x004a:
        return;
    L_0x004b:
        r6 = r4[r1];
        r7 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r6.j6(r10, r11, r7);	 Catch:{ IOException -> 0x005b }
    L_0x0052:
        r6 = r10.size();
        if (r6 > r8) goto L_0x004a;
    L_0x0058:
        r1 = r1 + 1;
        goto L_0x0013;
    L_0x005b:
        r7 = move-exception;
        r9.DW(r6);
        goto L_0x0052;
    L_0x0060:
        r0 = r1;
        goto L_0x000f;
    L_0x0062:
        r5 = r3[r0];
        r6 = r5.length();
        r7 = 38;
        if (r6 == r7) goto L_0x006f;
    L_0x006c:
        r0 = r0 + 1;
        goto L_0x0040;
    L_0x006f:
        r6 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x00a4 }
        r7 = java.lang.String.valueOf(r1);	 Catch:{ IllegalArgumentException -> 0x00a4 }
        r6.<init>(r7);	 Catch:{ IllegalArgumentException -> 0x00a4 }
        r5 = r6.append(r5);	 Catch:{ IllegalArgumentException -> 0x00a4 }
        r5 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x00a4 }
        r5 = ans.DW(r5);	 Catch:{ IllegalArgumentException -> 0x00a4 }
        r6 = r11.DW(r5);	 Catch:{ IllegalArgumentException -> 0x00a4 }
        if (r6 != 0) goto L_0x008d;
    L_0x008a:
        r10.add(r5);	 Catch:{ IllegalArgumentException -> 0x00a4 }
    L_0x008d:
        r5 = r10.size();
        if (r5 <= r8) goto L_0x006c;
    L_0x0093:
        goto L_0x004a;
    L_0x0094:
        r2 = r1[r0];
        r2 = r2.j6;
        r2.j6(r10, r11);
        r2 = r10.size();
        if (r2 > r8) goto L_0x004a;
    L_0x00a1:
        r0 = r0 + 1;
        goto L_0x0048;
    L_0x00a4:
        r5 = move-exception;
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: arl.j6(java.util.Set, amz):void");
    }

    anx DW(asg asg, anb anb) {
        if (this.we.j6(anb)) {
            anx j6 = j6(asg, anb.DW(), anb);
            if (j6 != null) {
                return j6;
            }
            this.we.FH(anb);
        }
        arl$b arl_b = (arl$b) this.gn.get();
        while (true) {
            aro[] aroArr = arl_b.DW;
            int length = aroArr.length;
            int i = 0;
            while (i < length) {
                aro aro = aroArr[i];
                try {
                    anx j62 = aro.j6(asg, anb);
                    if (j62 != null) {
                        return j62;
                    }
                    i++;
                } catch (alp e) {
                    arl_b = j6(arl_b);
                } catch (IOException e2) {
                    DW(aro);
                }
            }
            return null;
        }
    }

    long FH(asg asg, anb anb) {
        arl$b arl_b = (arl$b) this.gn.get();
        while (true) {
            aro[] aroArr = arl_b.DW;
            int length = aroArr.length;
            int i = 0;
            while (i < length) {
                aro aro = aroArr[i];
                try {
                    long DW = aro.DW(asg, anb);
                    if (0 <= DW) {
                        return DW;
                    }
                    i++;
                } catch (alp e) {
                    arl_b = j6(arl_b);
                } catch (IOException e2) {
                    DW(aro);
                }
            }
            return -1;
        }
    }

    long DW(asg asg, String str, anb anb) {
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(DW(str));
            long j6 = asc.j6(fileInputStream, anb, asg);
            fileInputStream.close();
            return j6;
        } catch (FileNotFoundException e) {
            return -1;
        } catch (Throwable th) {
            fileInputStream.close();
        }
    }

    void j6(asy asy, asv asv, asg asg) {
        arl$b arl_b = (arl$b) this.gn.get();
        loop0:
        while (true) {
            for (aro aro : arl_b.DW) {
                try {
                    asz FH = aro.FH(asg, (anb) asv);
                    if (FH != null) {
                        asy.j6(asv, FH);
                    }
                } catch (alp e) {
                    arl_b = j6(arl_b);
                } catch (IOException e2) {
                    DW(aro);
                }
            }
            break loop0;
        }
        for (arb$a arb_a : we()) {
            arb_a.j6.j6(asy, asv, asg);
        }
    }

    boolean j6(String str) {
        return DW(str).exists();
    }

    anx j6(asg asg, String str, anb anb) {
        InputStream fileInputStream;
        try {
            File DW = DW(str);
            fileInputStream = new FileInputStream(DW);
            this.we.DW(anb);
            anx j6 = asc.j6(fileInputStream, DW, anb, asg);
            fileInputStream.close();
            return j6;
        } catch (FileNotFoundException e) {
            this.we.FH(anb);
            return null;
        } catch (Throwable th) {
            fileInputStream.close();
        }
    }

    arb$c j6(File file, ans ans, boolean z) {
        if (this.we.j6(ans)) {
            awv.j6(file);
            return arb$c.EXISTS_LOOSE;
        } else if (z || !j6((anb) ans)) {
            File FH = FH((anb) ans);
            if (FH.exists()) {
                awv.j6(file);
                return arb$c.EXISTS_LOOSE;
            } else if (file.renameTo(FH)) {
                FH.setReadOnly();
                this.we.DW(ans);
                return arb$c.INSERTED;
            } else {
                awv.DW(FH.getParentFile());
                if (file.renameTo(FH)) {
                    FH.setReadOnly();
                    this.we.DW(ans);
                    return arb$c.INSERTED;
                } else if (z || !j6((anb) ans)) {
                    awv.j6(file);
                    return arb$c.FAILURE;
                } else {
                    awv.j6(file);
                    return arb$c.EXISTS_PACKED;
                }
            }
        } else {
            awv.j6(file);
            return arb$c.EXISTS_PACKED;
        }
    }

    boolean J0() {
        arl$b arl_b = (arl$b) this.gn.get();
        if (!arl_b.j6.DW(this.v5)) {
            return false;
        }
        if (arl_b != j6(arl_b)) {
            return true;
        }
        return false;
    }

    ani u7() {
        return this.DW;
    }

    awp tp() {
        return this.tp;
    }

    private void j6(aro aro) {
        arl$b arl_b;
        Object obj;
        do {
            arl_b = (arl$b) this.gn.get();
            Object obj2 = arl_b.DW;
            String name = aro.j6().getName();
            int length = obj2.length;
            int i = 0;
            while (i < length) {
                aro aro2 = obj2[i];
                if (aro.j6.compare(aro, aro2) < 0) {
                    break;
                } else if (!name.equals(aro2.j6().getName())) {
                    i++;
                } else {
                    return;
                }
            }
            obj = new aro[(obj2.length + 1)];
            obj[0] = aro;
            System.arraycopy(obj2, 0, obj, 1, obj2.length);
        } while (!this.gn.compareAndSet(arl_b, new arl$b(arl_b.j6, obj)));
    }

    private void DW(aro aro) {
        arl$b arl_b;
        Object obj;
        do {
            arl_b = (arl$b) this.gn.get();
            aro[] aroArr = arl_b.DW;
            int j6 = j6(aroArr, aro);
            if (j6 < 0) {
                break;
            }
            obj = new aro[(aroArr.length - 1)];
            System.arraycopy(aroArr, 0, obj, 0, j6);
            System.arraycopy(aroArr, j6 + 1, obj, j6, obj.length - j6);
        } while (!this.gn.compareAndSet(arl_b, new arl$b(arl_b.j6, obj)));
        aro.FH();
    }

    private static int j6(aro[] aroArr, aro aro) {
        for (int i = 0; i < aroArr.length; i++) {
            if (aroArr[i] == aro) {
                return i;
            }
        }
        return -1;
    }

    private arl$b j6(arl$b arl_b) {
        synchronized (this.gn) {
            arl$b DW;
            arl$b arl_b2;
            do {
                arl_b2 = (arl$b) this.gn.get();
                if (arl_b2 != arl_b) {
                    return arl_b2;
                }
                DW = DW(arl_b2);
                if (DW == arl_b2) {
                    return DW;
                }
            } while (!this.gn.compareAndSet(arl_b2, DW));
            return DW;
        }
    }

    private arl$b DW(arl$b arl_b) {
        Map FH = FH(arl_b);
        are j6 = are.j6(this.v5);
        Set<String> QX = QX();
        List arrayList = new ArrayList(QX.size() >> 2);
        int i = 0;
        for (String str : QX) {
            if (str.length() == 49 && str.endsWith(".idx")) {
                String str2 = str.substring(0, str.length() - 4) + ".pack";
                if (QX.contains(str2)) {
                    aro aro = (aro) FH.remove(str2);
                    if (aro != null) {
                        arrayList.add(aro);
                    } else {
                        arrayList.add(new aro(new File(this.v5, str), new File(this.v5, str2)));
                        i = 1;
                    }
                }
            }
        }
        if (i == 0 && FH.isEmpty() && j6.DW(arl_b.j6)) {
            arl_b.j6.j6(j6);
            return arl_b;
        }
        for (aro FH2 : FH.values()) {
            FH2.FH();
        }
        if (arrayList.isEmpty()) {
            return new arl$b(j6, j6.DW);
        }
        aro[] aroArr = (aro[]) arrayList.toArray(new aro[arrayList.size()]);
        Arrays.sort(aroArr, aro.j6);
        return new arl$b(j6, aroArr);
    }

    private static Map<String, aro> FH(arl$b arl_b) {
        Map<String, aro> hashMap = new HashMap();
        for (aro aro : arl_b.DW) {
            if (aro.v5()) {
                aro.FH();
            } else {
                aro aro2 = (aro) hashMap.put(aro.j6().getName(), aro);
                if (aro2 != null) {
                    hashMap.put(aro2.j6().getName(), aro2);
                    aro.FH();
                }
            }
        }
        return hashMap;
    }

    private Set<String> QX() {
        String[] list = this.v5.list();
        if (list == null) {
            return Collections.emptySet();
        }
        Set<String> hashSet = new HashSet(list.length << 1);
        for (String str : list) {
            if (str.startsWith("pack-")) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    arb$a[] we() {
        arb$a[] arb_aArr = (arb$a[]) this.EQ.get();
        if (arb_aArr == null) {
            synchronized (this.EQ) {
                arb_aArr = (arb$a[]) this.EQ.get();
                if (arb_aArr == null) {
                    try {
                        arb_aArr = XL();
                    } catch (IOException e) {
                        arb_aArr = new arb$a[0];
                    }
                    this.EQ.set(arb_aArr);
                }
            }
        }
        return arb_aArr;
    }

    private arb$a[] XL() {
        List arrayList = new ArrayList(4);
        BufferedReader j6 = j6(this.Zo);
        while (true) {
            String readLine = j6.readLine();
            if (readLine == null) {
                break;
            }
            try {
                arrayList.add(Hw(readLine));
            } finally {
                j6.close();
            }
        }
        return (arb$a[]) arrayList.toArray(new arb$a[arrayList.size()]);
    }

    private static BufferedReader j6(File file) {
        return new BufferedReader(new FileReader(file));
    }

    private arb$a Hw(String str) {
        return DW(this.tp.j6(this.FH, str));
    }

    private arb$a DW(File file) {
        File parentFile = file.getParentFile();
        if (aoj$a.FH(parentFile, this.tp)) {
            return new arb$b((arc) aoj.j6(aoj$a.j6(parentFile, this.tp)));
        }
        return new arb$a(new arl(this.DW, file, null, this.tp));
    }

    public anr Zo() {
        return VH();
    }

    arb VH() {
        return new aqy(this);
    }
}
