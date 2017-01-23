import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.eclipse.jgit.JGitText;

abstract class avv {
    abstract avv$a DW(String str);

    abstract Collection<avv> DW();

    abstract Collection<String> FH();

    abstract avn j6();

    abstract avv j6(String str);

    abstract void v5();

    avv() {
    }

    void FH(String str) {
        throw new IOException(MessageFormat.format(JGitText.j6().deletingNotSupported, new Object[]{str}));
    }

    OutputStream j6(String str, aob aob, String str2) {
        throw new IOException(MessageFormat.format(JGitText.j6().writingNotSupported, new Object[]{str}));
    }

    void j6(String str, byte[] bArr) {
        OutputStream j6 = j6(str, null, null);
        try {
            j6.write(bArr);
        } finally {
            j6.close();
        }
    }

    void Hw(String str) {
        FH("../" + str);
    }

    void v5(String str) {
        FH("../logs/" + str);
    }

    void j6(String str, ans ans) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(41);
        ans.DW(byteArrayOutputStream);
        byteArrayOutputStream.write(10);
        j6("../" + str, byteArrayOutputStream.toByteArray());
    }

    void j6(Collection<String> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : collection) {
            stringBuilder.append("P ");
            stringBuilder.append(str);
            stringBuilder.append('\n');
        }
        j6("info/packs", anj.j6(stringBuilder.toString()));
    }

    BufferedReader Zo(String str) {
        return new BufferedReader(new InputStreamReader(DW(str).j6, anj.DW));
    }

    Collection<avv> VH(String str) {
        BufferedReader Zo = Zo(str);
        try {
            Collection<avv> arrayList = new ArrayList();
            while (true) {
                String readLine = Zo.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.endsWith("/")) {
                    readLine = new StringBuilder(String.valueOf(readLine)).append("/").toString();
                }
                arrayList.add(j6(readLine));
            }
            return arrayList;
        } finally {
            Zo.close();
        }
    }

    protected void j6(Map<String, aoc> map) {
        BufferedReader Zo;
        try {
            Zo = Zo("../packed-refs");
            j6((Map) map, Zo);
            Zo.close();
        } catch (FileNotFoundException e) {
        } catch (Throwable e2) {
            throw new amb(j6(), JGitText.j6().errorInPackedRefs, e2);
        } catch (Throwable th) {
            Zo.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j6(java.util.Map<java.lang.String, aoc> r9, java.io.BufferedReader r10) {
        /*
        r8 = this;
        r7 = 1;
        r2 = 0;
        r0 = 0;
        r1 = r2;
        r3 = r0;
    L_0x0005:
        r0 = r10.readLine();
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r4 = r0.charAt(r2);
        r5 = 35;
        if (r4 != r5) goto L_0x0031;
    L_0x0014:
        r4 = "# pack-refs with:";
        r4 = r0.startsWith(r4);
        if (r4 == 0) goto L_0x0005;
    L_0x001d:
        r1 = "# pack-refs with:";
        r1 = r1.length();
        r0 = r0.substring(r1);
        r1 = " peeled";
        r0 = r0.contains(r1);
        r1 = r0;
        goto L_0x0005;
    L_0x0031:
        r4 = r0.charAt(r2);
        r5 = 94;
        if (r4 != r5) goto L_0x0067;
    L_0x0039:
        if (r3 != 0) goto L_0x0047;
    L_0x003b:
        r0 = new amb;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.peeledLineBeforeRef;
        r0.<init>(r1);
        throw r0;
    L_0x0047:
        r0 = r0.substring(r7);
        r4 = ans.DW(r0);
        r0 = new anu$b;
        r5 = aoc$a.PACKED;
        r6 = r3.j6();
        r3 = r3.v5();
        r0.<init>(r5, r6, r3, r4);
        r3 = r0.j6();
        r9.put(r3, r0);
        r3 = r0;
        goto L_0x0005;
    L_0x0067:
        r3 = 32;
        r3 = r0.indexOf(r3);
        if (r3 >= 0) goto L_0x0083;
    L_0x006f:
        r1 = new amb;
        r3 = org.eclipse.jgit.JGitText.j6();
        r3 = r3.unrecognizedRef;
        r4 = new java.lang.Object[r7];
        r4[r2] = r0;
        r0 = java.text.MessageFormat.format(r3, r4);
        r1.<init>(r0);
        throw r1;
    L_0x0083:
        r4 = r0.substring(r2, r3);
        r4 = ans.DW(r4);
        r3 = r3 + 1;
        r3 = r0.substring(r3);
        if (r1 == 0) goto L_0x00a4;
    L_0x0093:
        r0 = new anu$a;
        r5 = aoc$a.PACKED;
        r0.<init>(r5, r3, r4);
    L_0x009a:
        r3 = r0.j6();
        r9.put(r3, r0);
        r3 = r0;
        goto L_0x0005;
    L_0x00a4:
        r0 = new anu$c;
        r5 = aoc$a.PACKED;
        r0.<init>(r5, r3, r4);
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: avv.j6(java.util.Map, java.io.BufferedReader):void");
    }
}
