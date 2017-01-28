import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jgit.JGitText;

public class ary extends aoe {
    private static final String[] DW;
    private final AtomicInteger EQ;
    private final arc FH;
    private final File Hw;
    private final File VH;
    private final File Zo;
    private final File gn;
    private final AtomicReference<ary$g> tp;
    private final AtomicReference<axf<ary$c>> u7;
    private final File v5;
    private final AtomicInteger we;

    public /* synthetic */ aof j6(String str, boolean z) {
        return DW(str, z);
    }

    static {
        DW = new String[]{"MERGE_HEAD", "FETCH_HEAD", "ORIG_HEAD", "CHERRY_PICK_HEAD"};
    }

    ary(arc arc) {
        this.u7 = new AtomicReference();
        this.tp = new AtomicReference();
        this.EQ = new AtomicInteger();
        this.we = new AtomicInteger();
        awp gn = arc.gn();
        this.FH = arc;
        this.Hw = arc.DW();
        this.v5 = gn.j6(this.Hw, "refs/");
        this.Zo = gn.j6(this.Hw, "logs");
        this.VH = gn.j6(this.Hw, "logs/refs/");
        this.gn = gn.j6(this.Hw, "packed-refs");
        this.u7.set(axf.j6());
        this.tp.set(ary$g.j6);
    }

    aoh FH() {
        return this.FH;
    }

    public void j6() {
        awv.DW(this.v5);
        awv.DW(this.Zo);
        awv.DW(this.VH);
        awv.DW(new File(this.v5, "refs/heads/".substring("refs/".length())));
        awv.DW(new File(this.v5, "refs/tags/".substring("refs/".length())));
        awv.DW(new File(this.VH, "refs/heads/".substring("refs/".length())));
    }

    public void DW() {
    }

    public boolean j6(String str) {
        String substring;
        axf Zo = Zo();
        axf Hw = Hw();
        int lastIndexOf = str.lastIndexOf(47);
        while (lastIndexOf > 0) {
            substring = str.substring(0, lastIndexOf);
            if (Hw.DW(substring) || Zo.DW(substring)) {
                return true;
            }
            lastIndexOf = str.lastIndexOf(47, lastIndexOf - 1);
        }
        substring = new StringBuilder(String.valueOf(str)).append('/').toString();
        lastIndexOf = -(Zo.j6(substring) + 1);
        if (lastIndexOf < Zo.FH() && Zo.j6(lastIndexOf).j6().startsWith(substring)) {
            return true;
        }
        lastIndexOf = -(Hw.j6(substring) + 1);
        if (lastIndexOf >= Hw.FH() || !((ary$c) Hw.j6(lastIndexOf)).j6().startsWith(substring)) {
            return false;
        }
        return true;
    }

    private axf<ary$c> Hw() {
        axf<ary$c> axf_ary_c = (axf) this.u7.get();
        ary$d ary_d = new ary$d(this, axf_ary_c);
        ary_d.j6("");
        if (ary_d.DW == null) {
            return axf_ary_c;
        }
        axf<ary$c> FH = ary_d.DW.FH();
        if (!this.u7.compareAndSet(axf_ary_c, FH)) {
            return FH;
        }
        this.EQ.incrementAndGet();
        return FH;
    }

    public aoc DW(String str) {
        axf Zo = Zo();
        String[] strArr = j6;
        int length = strArr.length;
        int i = 0;
        aoc aoc = null;
        while (i < length) {
            aoc j6 = j6(strArr[i] + str, Zo);
            if (j6 != null) {
                aoc = j6(j6, 0, null, null, Zo);
                break;
            }
            i++;
            aoc = j6;
        }
        gn();
        return aoc;
    }

    public Map<String, aoc> FH(String str) {
        axf Zo = Zo();
        axf axf = (axf) this.u7.get();
        ary$d ary_d = new ary$d(this, axf);
        ary_d.j6(str);
        if (ary_d.DW != null) {
            ary_d.DW.DW();
            axf FH = ary_d.DW.FH();
            if (this.u7.compareAndSet(axf, FH)) {
                this.EQ.incrementAndGet();
                axf = FH;
            } else {
                axf = FH;
            }
        }
        gn();
        axf$a axf_a = ary_d.j6;
        int i = 0;
        axf axf2 = axf;
        while (i < axf_a.j6()) {
            aoc j6 = axf_a.j6(i);
            aoc j62 = j6(j6, 0, str, axf2, Zo);
            if (j62 == null || j62.v5() == null) {
                axf_a.DW(i);
                int j63 = axf2.j6(j6.j6());
                if (j63 >= 0) {
                    axf2 = axf2.FH(j63);
                }
            } else {
                axf_a.j6(i, j62);
                i++;
            }
        }
        axf_a.DW();
        return new axg(str, Zo, j6(axf2), axf_a.FH());
    }

    private axf<aoc> j6(axf<? extends aoc> axf__extends_aoc) {
        return axf__extends_aoc;
    }

    public aoc j6(aoc aoc) {
        aoc FH = aoc.FH();
        if (FH.gn() || FH.v5() == null) {
            return aoc;
        }
        anu DW = DW(FH);
        if (FH.Zo().j6()) {
            axf axf = (axf) this.u7.get();
            int j6 = axf.j6(FH.j6());
            if (j6 >= 0 && axf.j6(j6) == FH) {
                this.u7.compareAndSet(axf, axf.j6(j6, ((ary$c) FH).j6(DW)));
            }
        }
        return j6(aoc, DW);
    }

    private anu DW(aoc aoc) {
        aql aql = new aql(FH());
        try {
            anu anu_b;
            aqg gn = aql.gn(aoc.v5());
            if (gn instanceof aqj) {
                anu_b = new anu$b(aoc.Zo(), aoc.j6(), aoc.v5(), aql.VH(gn).Hw());
            } else {
                anu_b = new anu$a(aoc.Zo(), aoc.j6(), aoc.v5());
                aql.we();
            }
            return anu_b;
        } finally {
            aql.we();
        }
    }

    private static aoc j6(aoc aoc, anu anu) {
        if (!aoc.DW()) {
            return anu;
        }
        return new aom(aoc.j6(), j6(aoc.Hw(), anu));
    }

    void j6(arz arz, are are, String str) {
        j6(j6(are, arz.v5().j6(), str));
        gn();
    }

    public arz DW(String str, boolean z) {
        aoc anu_c;
        int i = 0;
        axf Zo = Zo();
        aoc j6 = j6(str, Zo);
        if (j6 != null) {
            j6 = j6(j6, 0, null, null, Zo);
        }
        if (j6 == null) {
            anu_c = new anu$c(aoc$a.NEW, str, null);
        } else {
            if (z && j6.DW()) {
                i = 1;
            }
            anu_c = i != 0 ? new anu$c(aoc$a.LOOSE, str, j6.v5()) : j6;
        }
        arz arz = new arz(this, anu_c);
        if (i != 0) {
            arz.VH();
        }
        return arz;
    }

    void j6(arz arz, are are) {
        j6(new ary$f(are, arz.v5().FH().j6(), arz.Zo().Hw()));
    }

    private void j6(ary$c ary_c) {
        axf axf;
        do {
            axf = (axf) this.u7.get();
        } while (!this.u7.compareAndSet(axf, axf.j6((aoc) ary_c)));
        this.EQ.incrementAndGet();
        gn();
    }

    void j6(arz arz) {
        aoc FH = arz.v5().FH();
        String j6 = FH.j6();
        ary$g Zo = Zo();
        if (Zo.DW(j6)) {
            ark ark = new ark(this.gn, arz.DW().gn());
            if (ark.j6()) {
                try {
                    ary$g VH = VH();
                    int j62 = VH.j6(j6);
                    if (j62 >= 0) {
                        j6(ark, VH.FH(j62), Zo);
                    }
                    ark.Zo();
                } catch (Throwable th) {
                    ark.Zo();
                }
            } else {
                throw new alg(this.gn);
            }
        }
        axf axf;
        int j63;
        do {
            axf = (axf) this.u7.get();
            j63 = axf.j6(j6);
            if (j63 < 0) {
                break;
            }
        } while (!this.u7.compareAndSet(axf, axf.FH(j63)));
        int Zo2 = Zo(j6) - 2;
        j6(v5(j6), Zo2);
        if (FH.Zo().j6()) {
            arz.FH();
            j6(Hw(j6), Zo2);
        }
        this.EQ.incrementAndGet();
        gn();
    }

    void j6(aof aof, String str, boolean z) {
        aoa aoa;
        ans J0 = aof.J0();
        ans Zo = aof.Zo();
        aoc v5 = aof.v5();
        aoa u7 = aof.u7();
        if (u7 == null) {
            aoa = new aoa(this.FH);
        } else {
            aoa = new aoa(u7);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ans.j6(J0));
        stringBuilder.append(' ');
        stringBuilder.append(ans.j6(Zo));
        stringBuilder.append(' ');
        stringBuilder.append(aoa.Hw());
        stringBuilder.append('\t');
        stringBuilder.append(str);
        stringBuilder.append('\n');
        byte[] DW = anj.DW(stringBuilder.toString());
        if (z && v5.DW()) {
            j6(v5.j6(), DW);
            j6(v5.FH().j6(), DW);
            return;
        }
        j6(v5.j6(), DW);
    }

    private void j6(String str, byte[] bArr) {
        boolean z;
        File v5 = v5(str);
        if (v5() && VH(str)) {
            z = true;
        } else if (v5.isFile()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            FileOutputStream fileOutputStream;
            ash ash = (ash) FH().VH().j6(ash.j6);
            try {
                fileOutputStream = new FileOutputStream(v5, true);
            } catch (FileNotFoundException e) {
                File parentFile = v5.getParentFile();
                if (parentFile.exists()) {
                    throw e;
                } else if (parentFile.mkdirs() || parentFile.isDirectory()) {
                    fileOutputStream = new FileOutputStream(v5, true);
                } else {
                    throw new IOException(MessageFormat.format(JGitText.j6().cannotCreateDirectory, new Object[]{parentFile}));
                }
            }
            try {
                if (ash.FH()) {
                    FileChannel channel = fileOutputStream.getChannel();
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    while (wrap.remaining() > 0) {
                        channel.write(wrap);
                    }
                    channel.force(true);
                } else {
                    fileOutputStream.write(bArr);
                }
                fileOutputStream.close();
            } catch (Throwable th) {
                fileOutputStream.close();
            }
        }
    }

    private boolean v5() {
        return ((ank) this.FH.er().j6(ank.j6)).FH();
    }

    private boolean VH(String str) {
        return str.equals("HEAD") || str.startsWith("refs/heads/") || str.startsWith("refs/remotes/") || str.equals("refs/stash");
    }

    private aoc j6(aoc aoc, int i, String str, axf<ary$c> axf_ary_c, axf<aoc> axf_aoc) {
        if (!aoc.DW()) {
            return aoc;
        }
        aoc Hw = aoc.Hw();
        if (5 <= i) {
            return null;
        }
        aoc j6;
        if (axf_ary_c == null || !Hw.j6().startsWith(str)) {
            j6 = j6(Hw.j6(), (axf) axf_aoc);
            if (j6 == null) {
                return aoc;
            }
        }
        int j62 = axf_ary_c.j6(Hw.j6());
        if (j62 >= 0) {
            j6 = axf_ary_c.j6(j62);
        } else {
            int j63 = axf_aoc.j6(Hw.j6());
            if (j63 < 0) {
                return aoc;
            }
            j6 = axf_aoc.j6(j63);
        }
        j6 = j6(j6, i + 1, str, axf_ary_c, axf_aoc);
        if (j6 == null) {
            return null;
        }
        return new aom(aoc.j6(), j6);
    }

    private ary$g Zo() {
        ary$g ary_g = (ary$g) this.tp.get();
        if (!ary_g.DW.DW(this.gn)) {
            return ary_g;
        }
        ary$g VH = VH();
        if (this.tp.compareAndSet(ary_g, VH)) {
            this.EQ.incrementAndGet();
        }
        return VH;
    }

    private ary$g VH() {
        are j6 = are.j6(this.gn);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.gn), anj.DW));
            try {
                ary$g ary_g = new ary$g(j6(bufferedReader), j6);
                return ary_g;
            } finally {
                bufferedReader.close();
            }
        } catch (FileNotFoundException e) {
            return ary$g.j6;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private axf<aoc> j6(java.io.BufferedReader r11) {
        /*
        r10 = this;
        r5 = 1;
        r1 = 0;
        r6 = new axf$a;
        r6.<init>();
        r0 = 0;
        r2 = r1;
        r3 = r0;
        r0 = r1;
    L_0x000b:
        r4 = r11.readLine();
        if (r4 != 0) goto L_0x001b;
    L_0x0011:
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r6.DW();
    L_0x0016:
        r0 = r6.FH();
        return r0;
    L_0x001b:
        r7 = r4.charAt(r1);
        r8 = 35;
        if (r7 != r8) goto L_0x003f;
    L_0x0023:
        r7 = "# pack-refs with:";
        r7 = r4.startsWith(r7);
        if (r7 == 0) goto L_0x000b;
    L_0x002c:
        r2 = "# pack-refs with:";
        r2 = r2.length();
        r2 = r4.substring(r2);
        r4 = " peeled";
        r2 = r2.contains(r4);
        goto L_0x000b;
    L_0x003f:
        r7 = r4.charAt(r1);
        r8 = 94;
        if (r7 != r8) goto L_0x0077;
    L_0x0047:
        if (r3 != 0) goto L_0x0055;
    L_0x0049:
        r0 = new java.io.IOException;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.peeledLineBeforeRef;
        r0.<init>(r1);
        throw r0;
    L_0x0055:
        r4 = r4.substring(r5);
        r7 = ans.DW(r4);
        r4 = new anu$b;
        r8 = aoc$a.PACKED;
        r9 = r3.j6();
        r3 = r3.v5();
        r4.<init>(r8, r9, r3, r7);
        r3 = r6.j6();
        r3 = r3 + -1;
        r6.j6(r3, r4);
        r3 = r4;
        goto L_0x000b;
    L_0x0077:
        r7 = 32;
        r7 = r4.indexOf(r7);
        r8 = r4.substring(r1, r7);
        r8 = ans.DW(r8);
        r7 = r7 + 1;
        r9 = r4.length();
        r7 = j6(r4, r7, r9);
        if (r2 == 0) goto L_0x00a7;
    L_0x0091:
        r4 = new anu$a;
        r9 = aoc$a.PACKED;
        r4.<init>(r9, r7, r8);
    L_0x0098:
        if (r3 == 0) goto L_0x00a1;
    L_0x009a:
        r3 = aod.DW(r3, r4);
        if (r3 <= 0) goto L_0x00a1;
    L_0x00a0:
        r0 = r5;
    L_0x00a1:
        r6.j6(r4);
        r3 = r4;
        goto L_0x000b;
    L_0x00a7:
        r4 = new anu$c;
        r9 = aoc$a.PACKED;
        r4.<init>(r9, r7, r8);
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: ary.j6(java.io.BufferedReader):axf<aoc>");
    }

    private static String j6(String str, int i, int i2) {
        return new StringBuilder(i2 - i).append(str, i, i2).toString();
    }

    private void j6(ark ark, axf<aoc> axf_aoc, ary$g ary_g) {
        new ary$1(this, axf_aoc, ark, ary_g, axf_aoc).DW();
    }

    private aoc j6(String str, axf<aoc> axf_aoc) {
        axf axf = (axf) this.u7.get();
        int j6 = axf.j6(str);
        aoc j62;
        if (j6 >= 0) {
            ary$c ary_c = (ary$c) axf.j6(j6);
            j62 = j6(ary_c, str);
            if (j62 == null) {
                if (this.u7.compareAndSet(axf, axf.FH(j6))) {
                    this.EQ.incrementAndGet();
                }
                return axf_aoc.FH(str);
            } else if (ary_c == j62) {
                return j62;
            } else {
                if (this.u7.compareAndSet(axf, axf.j6(j6, j62))) {
                    this.EQ.incrementAndGet();
                }
                return j62;
            }
        }
        j62 = j6(null, str);
        if (j62 == null) {
            return axf_aoc.FH(str);
        }
        for (Object equals : DW) {
            if (str.equals(equals)) {
                return j62;
            }
        }
        if (this.u7.compareAndSet(axf, axf.DW(j6, j62))) {
            this.EQ.incrementAndGet();
        }
        return j62;
    }

    private ary$c j6(ary$c ary_c, String str) {
        are u7;
        File Hw = Hw(str);
        if (ary_c != null) {
            u7 = ary_c.u7();
            if (!u7.DW(Hw)) {
                return ary_c;
            }
            str = ary_c.j6();
        } else {
            u7 = null;
        }
        are j6 = are.j6(Hw);
        try {
            byte[] j62 = awx.j6(Hw, 4096);
            int length = j62.length;
            if (length == 0) {
                return null;
            }
            String FH;
            if (j6(j62, length)) {
                if (length == 4096) {
                    return null;
                }
                while (length > 0 && Character.isWhitespace(j62[length - 1])) {
                    length--;
                }
                if (length < 6) {
                    FH = axe.FH(j62, 0, length);
                    throw new IOException(MessageFormat.format(JGitText.j6().notARef, new Object[]{str, FH}));
                }
                String FH2 = axe.FH(j62, 5, length);
                if (ary_c == null || !ary_c.DW() || !ary_c.Hw().j6().equals(FH2)) {
                    return j6(j6, str, FH2);
                }
                u7.j6(j6);
                return ary_c;
            } else if (length < 40) {
                return null;
            } else {
                try {
                    anb v5 = ans.v5(j62, 0);
                    if (ary_c == null || ary_c.DW() || !ary_c.Hw().v5().DW(v5)) {
                        return new ary$f(j6, str, v5);
                    }
                    u7.j6(j6);
                    return ary_c;
                } catch (IllegalArgumentException e) {
                    int i = length;
                    while (i > 0 && Character.isWhitespace(j62[i - 1])) {
                        i--;
                    }
                    FH = axe.FH(j62, 0, i);
                    throw new IOException(MessageFormat.format(JGitText.j6().notARef, new Object[]{str, FH}));
                }
            }
        } catch (FileNotFoundException e2) {
            return null;
        }
    }

    private static boolean j6(byte[] bArr, int i) {
        if (i >= 6 && bArr[0] == 114 && bArr[1] == 101 && bArr[2] == 102 && bArr[3] == 58 && bArr[4] == 32) {
            return true;
        }
        return false;
    }

    private void gn() {
        int i = this.we.get();
        int i2 = this.EQ.get();
        if (i != i2 && this.we.compareAndSet(i, i2) && i != 0) {
            this.FH.j6(new aml());
        }
    }

    File Hw(String str) {
        if (!str.startsWith("refs/")) {
            return new File(this.Hw, str);
        }
        return new File(this.v5, str.substring("refs/".length()));
    }

    File v5(String str) {
        if (!str.startsWith("refs/")) {
            return new File(this.Zo, str);
        }
        return new File(this.VH, str.substring("refs/".length()));
    }

    static int Zo(String str) {
        int i = 0;
        int indexOf = str.indexOf(47);
        while (indexOf >= 0) {
            i++;
            indexOf = str.indexOf(47, indexOf + 1);
        }
        return i;
    }

    static void j6(File file, int i) {
        int i2 = 0;
        if (file.delete() || !file.isFile()) {
            File parentFile = file.getParentFile();
            while (i2 < i && parentFile.delete()) {
                parentFile = parentFile.getParentFile();
                i2++;
            }
            return;
        }
        throw new IOException(MessageFormat.format(JGitText.j6().fileCannotBeDeleted, new Object[]{file}));
    }

    private static ary$e j6(are are, String str, String str2) {
        return new ary$e(are, str, new anu$c(aoc$a.NEW, str2, null));
    }
}
