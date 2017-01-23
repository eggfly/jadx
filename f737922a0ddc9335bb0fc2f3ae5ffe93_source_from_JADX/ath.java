import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jgit.JGitText;

abstract class ath extends atf {
    protected final avn DW;
    protected boolean EQ;
    protected final avd FH;
    protected axs Hw;
    private axn J0;
    private final Set<String> J8;
    protected OutputStream VH;
    protected InputStream Zo;
    protected aue gn;
    protected final aoh j6;
    protected boolean tp;
    protected auf u7;
    protected axt v5;
    protected final Set<ans> we;

    ath(auc auc) {
        this.J8 = new HashSet();
        this.we = new HashSet();
        this.FH = (avd) auc;
        this.j6 = this.FH.FH;
        this.DW = this.FH.Hw;
    }

    protected final void j6(InputStream inputStream, OutputStream outputStream) {
        int J0 = this.FH.J0();
        if (J0 > 0) {
            this.J0 = new axn(new StringBuilder(String.valueOf(Thread.currentThread().getName())).append("-Timer").toString());
            this.Hw = new axs(inputStream, this.J0);
            this.v5 = new axt(outputStream, this.J0);
            this.Hw.j6(J0 * 1000);
            this.v5.j6(J0 * 1000);
            inputStream = this.Hw;
            outputStream = this.v5;
        }
        this.Zo = inputStream;
        this.VH = outputStream;
        this.gn = new aue(this.Zo);
        this.u7 = new auf(this.VH);
        this.tp = true;
    }

    protected void VH() {
        try {
            J0();
        } catch (amb e) {
            u7();
            throw e;
        } catch (Throwable e2) {
            u7();
            throw new amb(e2.getMessage(), e2);
        } catch (Throwable e22) {
            u7();
            throw new amb(e22.getMessage(), e22);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void J0() {
        /*
        r9 = this;
        r2 = 0;
        r3 = new java.util.LinkedHashMap;
        r3.<init>();
    L_0x0006:
        r0 = r9.gn;	 Catch:{ EOFException -> 0x0014 }
        r0 = r0.j6();	 Catch:{ EOFException -> 0x0014 }
        r1 = aue.j6;
        if (r0 != r1) goto L_0x0021;
    L_0x0010:
        r9.j6(r3);
        return;
    L_0x0014:
        r0 = move-exception;
        r1 = r3.isEmpty();
        if (r1 == 0) goto L_0x0020;
    L_0x001b:
        r0 = r9.gn();
        throw r0;
    L_0x0020:
        throw r0;
    L_0x0021:
        r1 = "ERR ";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0037;
    L_0x002a:
        r1 = new alr;
        r2 = r9.DW;
        r3 = 4;
        r0 = r0.substring(r3);
        r1.<init>(r2, r0);
        throw r1;
    L_0x0037:
        r1 = r3.isEmpty();
        if (r1 == 0) goto L_0x0058;
    L_0x003d:
        r4 = r0.indexOf(r2);
        if (r4 < 0) goto L_0x0058;
    L_0x0043:
        r1 = r4 + 1;
        r1 = r0.substring(r1);
        r5 = " ";
        r5 = r1.split(r5);
        r6 = r5.length;
        r1 = r2;
    L_0x0052:
        if (r1 < r6) goto L_0x008b;
    L_0x0054:
        r0 = r0.substring(r2, r4);
    L_0x0058:
        r1 = 41;
        r4 = r0.length();
        r1 = r0.substring(r1, r4);
        r4 = r3.isEmpty();
        if (r4 == 0) goto L_0x0071;
    L_0x0068:
        r4 = "capabilities^{}";
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x0006;
    L_0x0071:
        r4 = 40;
        r0 = r0.substring(r2, r4);
        r4 = ans.DW(r0);
        r0 = ".have";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x0095;
    L_0x0084:
        r0 = r9.we;
        r0.add(r4);
        goto L_0x0006;
    L_0x008b:
        r7 = r5[r1];
        r8 = r9.J8;
        r8.add(r7);
        r1 = r1 + 1;
        goto L_0x0052;
    L_0x0095:
        r0 = "^{}";
        r0 = r1.endsWith(r0);
        if (r0 == 0) goto L_0x00f9;
    L_0x009e:
        r0 = r1.length();
        r0 = r0 + -3;
        r1 = r1.substring(r2, r0);
        r0 = r3.get(r1);
        r0 = (aoc) r0;
        if (r0 != 0) goto L_0x00ca;
    L_0x00b0:
        r0 = new alq;
        r3 = r9.DW;
        r4 = org.eclipse.jgit.JGitText.j6();
        r4 = r4.advertisementCameBefore;
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r5[r2] = r1;
        r2 = 1;
        r5[r2] = r1;
        r1 = java.text.MessageFormat.format(r4, r5);
        r0.<init>(r3, r1);
        throw r0;
    L_0x00ca:
        r5 = r0.VH();
        if (r5 == 0) goto L_0x00e9;
    L_0x00d0:
        r0 = new java.lang.StringBuilder;
        r1 = java.lang.String.valueOf(r1);
        r0.<init>(r1);
        r1 = "^{}";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = r9.Hw(r0);
        throw r0;
    L_0x00e9:
        r5 = new anu$b;
        r6 = aoc$a.NETWORK;
        r0 = r0.v5();
        r5.<init>(r6, r1, r0, r4);
        r3.put(r1, r5);
        goto L_0x0006;
    L_0x00f9:
        r0 = new anu$a;
        r5 = aoc$a.NETWORK;
        r0.<init>(r5, r1, r4);
        r0 = r3.put(r1, r0);
        r0 = (aoc) r0;
        if (r0 == 0) goto L_0x0006;
    L_0x0108:
        r0 = r9.Hw(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ath.J0():void");
    }

    protected amb gn() {
        return new alk(this.DW, JGitText.j6().notFound);
    }

    protected boolean DW(String str) {
        return this.J8.contains(str);
    }

    protected boolean j6(StringBuilder stringBuilder, String str) {
        if (!DW(str)) {
            return false;
        }
        stringBuilder.append(' ');
        stringBuilder.append(str);
        return true;
    }

    private alq Hw(String str) {
        return new alq(this.DW, MessageFormat.format(JGitText.j6().duplicateAdvertisementsOf, new Object[]{str}));
    }

    public void u7() {
        if (this.VH != null) {
            try {
                if (this.tp) {
                    this.tp = false;
                    this.u7.j6();
                }
                this.VH.close();
            } catch (IOException e) {
            } finally {
                this.VH = null;
                this.u7 = null;
            }
        }
        if (this.Zo != null) {
            try {
                this.Zo.close();
            } catch (IOException e2) {
            } finally {
                this.Zo = null;
                this.gn = null;
            }
        }
        if (this.J0 != null) {
            try {
                this.J0.DW();
            } finally {
                this.J0 = null;
                this.Hw = null;
                this.v5 = null;
            }
        }
    }

    protected void tp() {
        if (this.tp && this.VH != null) {
            try {
                this.tp = false;
                this.u7.j6();
            } catch (IOException e) {
                try {
                    this.VH.close();
                } catch (IOException e2) {
                } finally {
                    this.VH = null;
                    this.u7 = null;
                }
            }
        }
    }
}
