import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.JGitText;

public abstract class atj extends ath implements auj {
    private final boolean J0;
    private boolean J8;
    private long Mr;
    private boolean QX;
    private boolean Ws;
    private boolean XL;
    private boolean aM;
    private boolean j3;

    public atj(auc auc) {
        super(auc);
        this.J0 = this.FH.tp();
    }

    public void j6(aob aob, Map<String, aus> map) {
        Hw();
        DW(aob, map);
    }

    protected amb gn() {
        try {
            this.FH.QX().u7();
        } catch (alm e) {
        } catch (amb e2) {
            return e2;
        } catch (amb e3) {
        }
        return new amb(this.DW, JGitText.j6().pushNotPermitted);
    }

    protected void DW(aob aob, Map<String, aus> map) {
        try {
            j6(map.values(), aob);
            if (this.j3) {
                j6((Map) map, aob);
            }
            if (this.aM) {
                if (this.Ws) {
                    DW(map);
                }
                if (this.QX && this.Zo.read() >= 0) {
                    throw new amb(this.DW, MessageFormat.format(JGitText.j6().expectedEOFReceived, new Object[]{Character.valueOf((char) r0)}));
                }
            }
            u7();
        } catch (amb e) {
            throw e;
        } catch (Throwable e2) {
            throw new amb(this.DW, e2.getMessage(), e2);
        } catch (Throwable th) {
            u7();
        }
    }

    private void j6(Collection<aus> collection, aob aob) {
        String j6 = j6(aob);
        for (aus aus : collection) {
            if (this.J8 || !aus.Hw()) {
                ans Zo;
                StringBuilder stringBuilder = new StringBuilder();
                aoc j62 = j6(aus.v5());
                if (j62 == null) {
                    Zo = ans.Zo();
                } else {
                    Zo = j62.v5();
                }
                stringBuilder.append(Zo.DW());
                stringBuilder.append(' ');
                stringBuilder.append(aus.FH().DW());
                stringBuilder.append(' ');
                stringBuilder.append(aus.v5());
                if (!this.aM) {
                    this.aM = true;
                    stringBuilder.append(j6);
                }
                this.u7.j6(stringBuilder.toString());
                aus.j6(aus$a.AWAITING_REPORT);
                if (!aus.Hw()) {
                    this.j3 = true;
                }
            } else {
                aus.j6(aus$a.REJECTED_NODELETE);
            }
        }
        if (aob.j6()) {
            throw new amb(this.DW, JGitText.j6().pushCancelled);
        }
        this.u7.j6();
        this.tp = false;
    }

    private String j6(aob aob) {
        StringBuilder stringBuilder = new StringBuilder();
        this.Ws = j6(stringBuilder, "report-status");
        this.J8 = j6(stringBuilder, "delete-refs");
        this.XL = j6(stringBuilder, "ofs-delta");
        this.QX = j6(stringBuilder, "side-band-64k");
        if (this.QX) {
            this.Zo = new auu(this.Zo, aob, v5());
            this.gn = new aue(this.Zo);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setCharAt(0, '\u0000');
        }
        return stringBuilder.toString();
    }

    private void j6(Map<String, aus> map, aob aob) {
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        asy asy = new asy(this.FH.J8(), this.j6.v5());
        for (aoc v5 : DW()) {
            try {
                hashSet.add(v5.v5());
            } finally {
                asy.v5();
            }
        }
        hashSet.addAll(this.we);
        for (aus aus : map.values()) {
            if (!ans.Zo().DW(aus.FH())) {
                hashSet2.add(aus.FH());
            }
        }
        asy.v5(true);
        asy.Hw(this.J0);
        asy.FH(false);
        asy.j6(this.XL);
        asy.j6(aob, hashSet2, hashSet);
        asy.j6(aob, aob, this.VH);
        this.Mr = asy.Hw().j6();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void DW(java.util.Map<java.lang.String, aus> r10) {
        /*
        r9 = this;
        r8 = 3;
        r2 = -1;
        r7 = 2;
        r4 = 1;
        r5 = 0;
        r0 = r9.Zo();
        r1 = "unpack ";
        r1 = r0.startsWith(r1);
        if (r1 != 0) goto L_0x0028;
    L_0x0012:
        r1 = new alq;
        r2 = r9.DW;
        r3 = org.eclipse.jgit.JGitText.j6();
        r3 = r3.unexpectedReportLine;
        r4 = new java.lang.Object[r4];
        r4[r5] = r0;
        r0 = java.text.MessageFormat.format(r3, r4);
        r1.<init>(r2, r0);
        throw r1;
    L_0x0028:
        r1 = "unpack ";
        r1 = r1.length();
        r0 = r0.substring(r1);
        r1 = "ok";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x00c3;
    L_0x003c:
        r1 = new amb;
        r2 = r9.DW;
        r3 = org.eclipse.jgit.JGitText.j6();
        r3 = r3.errorOccurredDuringUnpackingOnTheRemoteEnd;
        r4 = new java.lang.Object[r4];
        r4[r5] = r0;
        r0 = java.text.MessageFormat.format(r3, r4);
        r1.<init>(r2, r0);
        throw r1;
    L_0x0052:
        r0 = "ok ";
        r0 = r1.startsWith(r0);
        if (r0 == 0) goto L_0x007a;
    L_0x005b:
        r0 = r1.length();
        r3 = r4;
    L_0x0060:
        if (r0 != r2) goto L_0x008c;
    L_0x0062:
        r0 = new alq;
        r2 = org.eclipse.jgit.JGitText.j6();
        r2 = r2.unexpectedReportLine2;
        r3 = new java.lang.Object[r7];
        r6 = r9.DW;
        r3[r5] = r6;
        r3[r4] = r1;
        r1 = java.text.MessageFormat.format(r2, r3);
        r0.<init>(r1);
        throw r0;
    L_0x007a:
        r0 = "ng ";
        r0 = r1.startsWith(r0);
        if (r0 == 0) goto L_0x010f;
    L_0x0083:
        r0 = " ";
        r0 = r1.indexOf(r0, r8);
        r3 = r5;
        goto L_0x0060;
    L_0x008c:
        r6 = r1.substring(r8, r0);
        if (r3 == 0) goto L_0x00b4;
    L_0x0092:
        r0 = 0;
        r1 = r0;
    L_0x0094:
        r0 = r10.get(r6);
        r0 = (aus) r0;
        if (r0 != 0) goto L_0x00bc;
    L_0x009c:
        r0 = new alq;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.unexpectedRefReport;
        r2 = new java.lang.Object[r7];
        r3 = r9.DW;
        r2[r5] = r3;
        r2[r4] = r6;
        r1 = java.text.MessageFormat.format(r1, r2);
        r0.<init>(r1);
        throw r0;
    L_0x00b4:
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r1 = r0;
        goto L_0x0094;
    L_0x00bc:
        if (r3 == 0) goto L_0x00dc;
    L_0x00be:
        r1 = aus$a.OK;
        r0.j6(r1);
    L_0x00c3:
        r0 = r9.gn;
        r1 = r0.j6();
        r0 = aue.j6;
        if (r1 != r0) goto L_0x0052;
    L_0x00cd:
        r0 = r10.values();
        r1 = r0.iterator();
    L_0x00d5:
        r0 = r1.hasNext();
        if (r0 != 0) goto L_0x00e5;
    L_0x00db:
        return;
    L_0x00dc:
        r3 = aus$a.REJECTED_OTHER_REASON;
        r0.j6(r3);
        r0.j6(r1);
        goto L_0x00c3;
    L_0x00e5:
        r0 = r1.next();
        r0 = (aus) r0;
        r2 = r0.u7();
        r3 = aus$a.AWAITING_REPORT;
        if (r2 != r3) goto L_0x00d5;
    L_0x00f3:
        r1 = new alq;
        r2 = org.eclipse.jgit.JGitText.j6();
        r2 = r2.expectedReportForRefNotReceived;
        r3 = new java.lang.Object[r7];
        r6 = r9.DW;
        r3[r5] = r6;
        r0 = r0.v5();
        r3[r4] = r0;
        r0 = java.text.MessageFormat.format(r2, r3);
        r1.<init>(r0);
        throw r1;
    L_0x010f:
        r0 = r2;
        r3 = r5;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: atj.DW(java.util.Map):void");
    }

    private String Zo() {
        if (this.Hw == null) {
            return this.gn.j6();
        }
        int j6 = this.Hw.j6();
        try {
            this.Hw.j6(Math.max((int) Math.min(this.Mr, 28800000), j6) * 10);
            String j62 = this.gn.j6();
            return j62;
        } finally {
            this.Hw.j6(j6);
        }
    }
}
