import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class ahz extends aie<aqc> {
    private static /* synthetic */ int[] we;
    private aoa DW;
    private String EQ;
    private aoa FH;
    private String Hw;
    private boolean[] VH;
    private List<String> Zo;
    private boolean gn;
    private List<ans> tp;
    private boolean u7;
    private boolean v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    static /* synthetic */ int[] DW() {
        int[] iArr = we;
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
            we = iArr;
        }
        return iArr;
    }

    protected ahz(aoh aoh) {
        super(aoh);
        this.Zo = new ArrayList();
        this.tp = new LinkedList();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public aqc j6() {
        /*
        r10 = this;
        r4 = 1;
        r0 = 0;
        r10.Zo();
        r1 = r10.j6;
        r2 = r1.aM();
        r1 = r2.j6();
        if (r1 != 0) goto L_0x0029;
    L_0x0011:
        r1 = new ajp;
        r3 = org.eclipse.jgit.JGitText.j6();
        r3 = r3.cannotCommitOnARepoWithState;
        r4 = new java.lang.Object[r4];
        r2 = r2.name();
        r4[r0] = r2;
        r0 = java.text.MessageFormat.format(r3, r4);
        r1.<init>(r0);
        throw r1;
    L_0x0029:
        r10.j6(r2);
        r1 = r10.v5;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        if (r1 == 0) goto L_0x005a;
    L_0x0030:
        r1 = r10.j6;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = r1.j3();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        if (r1 != 0) goto L_0x005a;
    L_0x0038:
        r1 = r10.j6;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = r1.Mr();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        if (r1 == 0) goto L_0x005a;
    L_0x0040:
        r1 = new aid;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r3 = r10.j6;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1.<init>(r3);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = r1.tp();	 Catch:{ aji -> 0x0073 }
        r3 = ".";
        r1 = r1.j6(r3);	 Catch:{ aji -> 0x0073 }
        r3 = 1;
        r1 = r1.j6(r3);	 Catch:{ aji -> 0x0073 }
        r1.j6();	 Catch:{ aji -> 0x0073 }
    L_0x005a:
        r1 = r10.j6;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r3 = "HEAD";
        r1 = r1.FH(r3);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        if (r1 != 0) goto L_0x008b;
    L_0x0065:
        r0 = new ajj;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = org.eclipse.jgit.JGitText.j6();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = r1.commitOnRepoWithoutHEADCurrentlyNotSupported;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r0.<init>(r1);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        throw r0;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
    L_0x0071:
        r0 = move-exception;
        throw r0;
    L_0x0073:
        r0 = move-exception;
        r1 = new ajg;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r2 = r0.getMessage();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1.<init>(r2, r0);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        throw r1;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
    L_0x007e:
        r0 = move-exception;
        r1 = new ajg;
        r2 = org.eclipse.jgit.JGitText.j6();
        r2 = r2.exceptionCaughtDuringExecutionOfCommitCommand;
        r1.<init>(r2, r0);
        throw r1;
    L_0x008b:
        r1 = r10.j6;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r3 = "HEAD^{commit}";
        r3 = r1.DW(r3);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        if (r3 == 0) goto L_0x00ac;
    L_0x0096:
        r1 = r10.gn;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        if (r1 == 0) goto L_0x016b;
    L_0x009a:
        r1 = new aql;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r4 = r10.j6;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1.<init>(r4);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = r1.Zo(r3);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = r1.EQ();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
    L_0x00a9:
        r4 = r1.length;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        if (r0 < r4) goto L_0x015b;
    L_0x00ac:
        r0 = r10.j6;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = r0.XL();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r0 = r10.Zo;	 Catch:{ all -> 0x0156 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0156 }
        if (r0 != 0) goto L_0x00be;
    L_0x00ba:
        r1 = r10.j6(r3, r1);	 Catch:{ all -> 0x0156 }
    L_0x00be:
        r0 = r10.j6;	 Catch:{ all -> 0x0156 }
        r4 = r0.Hw();	 Catch:{ all -> 0x0156 }
        r0 = r1.j6(r4);	 Catch:{ all -> 0x0151 }
        r5 = r10.u7;	 Catch:{ all -> 0x0151 }
        if (r5 == 0) goto L_0x00cf;
    L_0x00cc:
        r10.j6(r0);	 Catch:{ all -> 0x0151 }
    L_0x00cf:
        r5 = new anh;	 Catch:{ all -> 0x0151 }
        r5.<init>();	 Catch:{ all -> 0x0151 }
        r6 = r10.FH;	 Catch:{ all -> 0x0151 }
        r5.DW(r6);	 Catch:{ all -> 0x0151 }
        r6 = r10.DW;	 Catch:{ all -> 0x0151 }
        r5.j6(r6);	 Catch:{ all -> 0x0151 }
        r6 = r10.Hw;	 Catch:{ all -> 0x0151 }
        r5.j6(r6);	 Catch:{ all -> 0x0151 }
        r6 = r10.tp;	 Catch:{ all -> 0x0151 }
        r5.j6(r6);	 Catch:{ all -> 0x0151 }
        r5.j6(r0);	 Catch:{ all -> 0x0151 }
        r5 = r4.j6(r5);	 Catch:{ all -> 0x0151 }
        r4.FH();	 Catch:{ all -> 0x0151 }
        r6 = new aql;	 Catch:{ all -> 0x0151 }
        r0 = r10.j6;	 Catch:{ all -> 0x0151 }
        r6.<init>(r0);	 Catch:{ all -> 0x0151 }
        r7 = r6.Zo(r5);	 Catch:{ all -> 0x014c }
        r0 = r10.j6;	 Catch:{ all -> 0x014c }
        r8 = "HEAD";
        r8 = r0.j6(r8);	 Catch:{ all -> 0x014c }
        r8.j6(r5);	 Catch:{ all -> 0x014c }
        r0 = r10.EQ;	 Catch:{ all -> 0x014c }
        if (r0 == 0) goto L_0x0173;
    L_0x010d:
        r0 = r10.EQ;	 Catch:{ all -> 0x014c }
        r9 = 0;
        r8.j6(r0, r9);	 Catch:{ all -> 0x014c }
    L_0x0113:
        if (r3 == 0) goto L_0x0198;
    L_0x0115:
        r8.DW(r3);	 Catch:{ all -> 0x014c }
    L_0x0118:
        r0 = r8.Ws();	 Catch:{ all -> 0x014c }
        r3 = DW();	 Catch:{ all -> 0x014c }
        r9 = r0.ordinal();	 Catch:{ all -> 0x014c }
        r3 = r3[r9];	 Catch:{ all -> 0x014c }
        switch(r3) {
            case 2: goto L_0x01d0;
            case 3: goto L_0x0129;
            case 4: goto L_0x01a1;
            case 5: goto L_0x01a1;
            case 6: goto L_0x01a1;
            case 7: goto L_0x01d0;
            default: goto L_0x0129;
        };	 Catch:{ all -> 0x014c }
    L_0x0129:
        r2 = new ajg;	 Catch:{ all -> 0x014c }
        r3 = org.eclipse.jgit.JGitText.j6();	 Catch:{ all -> 0x014c }
        r3 = r3.updatingRefFailed;	 Catch:{ all -> 0x014c }
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x014c }
        r8 = 0;
        r9 = "HEAD";
        r7[r8] = r9;	 Catch:{ all -> 0x014c }
        r8 = 1;
        r5 = r5.toString();	 Catch:{ all -> 0x014c }
        r7[r8] = r5;	 Catch:{ all -> 0x014c }
        r5 = 2;
        r7[r5] = r0;	 Catch:{ all -> 0x014c }
        r0 = java.text.MessageFormat.format(r3, r7);	 Catch:{ all -> 0x014c }
        r2.<init>(r0);	 Catch:{ all -> 0x014c }
        throw r2;	 Catch:{ all -> 0x014c }
    L_0x014c:
        r0 = move-exception;
        r6.we();	 Catch:{ all -> 0x0151 }
        throw r0;	 Catch:{ all -> 0x0151 }
    L_0x0151:
        r0 = move-exception;
        r4.Hw();	 Catch:{ all -> 0x0156 }
        throw r0;	 Catch:{ all -> 0x0156 }
    L_0x0156:
        r0 = move-exception;
        r1.u7();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        throw r0;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
    L_0x015b:
        r4 = r10.tp;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r5 = 0;
        r6 = r1[r0];	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r6 = r6.XL();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r4.add(r5, r6);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r0 = r0 + 1;
        goto L_0x00a9;
    L_0x016b:
        r0 = r10.tp;	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        r1 = 0;
        r0.add(r1, r3);	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        goto L_0x00ac;
    L_0x0173:
        r0 = r10.gn;	 Catch:{ all -> 0x014c }
        if (r0 == 0) goto L_0x0194;
    L_0x0177:
        r0 = "commit (amend): ";
    L_0x017a:
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x014c }
        r9.<init>(r0);	 Catch:{ all -> 0x014c }
        r0 = r7.J8();	 Catch:{ all -> 0x014c }
        r0 = r9.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r9 = 0;
        r8.j6(r0, r9);	 Catch:{ all -> 0x014c }
        goto L_0x0113;
    L_0x0194:
        r0 = "commit: ";
        goto L_0x017a;
    L_0x0198:
        r0 = ans.Zo();	 Catch:{ all -> 0x014c }
        r8.DW(r0);	 Catch:{ all -> 0x014c }
        goto L_0x0118;
    L_0x01a1:
        r0 = 0;
        r10.DW(r0);	 Catch:{ all -> 0x014c }
        r0 = aok.MERGING_RESOLVED;	 Catch:{ all -> 0x014c }
        if (r2 != r0) goto L_0x01bf;
    L_0x01a9:
        r0 = r10.j6;	 Catch:{ all -> 0x014c }
        r2 = 0;
        r0.Zo(r2);	 Catch:{ all -> 0x014c }
        r0 = r10.j6;	 Catch:{ all -> 0x014c }
        r2 = 0;
        r0.j6(r2);	 Catch:{ all -> 0x014c }
    L_0x01b5:
        r6.we();	 Catch:{ all -> 0x0151 }
        r4.Hw();	 Catch:{ all -> 0x0156 }
        r1.u7();	 Catch:{ amc -> 0x0071, IOException -> 0x007e }
        return r7;
    L_0x01bf:
        r0 = aok.CHERRY_PICKING_RESOLVED;	 Catch:{ all -> 0x014c }
        if (r2 != r0) goto L_0x01b5;
    L_0x01c3:
        r0 = r10.j6;	 Catch:{ all -> 0x014c }
        r2 = 0;
        r0.Zo(r2);	 Catch:{ all -> 0x014c }
        r0 = r10.j6;	 Catch:{ all -> 0x014c }
        r2 = 0;
        r0.j6(r2);	 Catch:{ all -> 0x014c }
        goto L_0x01b5;
    L_0x01d0:
        r2 = new aiz;	 Catch:{ all -> 0x014c }
        r3 = org.eclipse.jgit.JGitText.j6();	 Catch:{ all -> 0x014c }
        r3 = r3.couldNotLockHEAD;	 Catch:{ all -> 0x014c }
        r5 = r8.v5();	 Catch:{ all -> 0x014c }
        r2.<init>(r3, r5, r0);	 Catch:{ all -> 0x014c }
        throw r2;	 Catch:{ all -> 0x014c }
        */
        throw new UnsupportedOperationException("Method not decompiled: ahz.j6():aqc");
    }

    private void j6(ans ans) {
        ans ans2 = null;
        if (!this.tp.isEmpty()) {
            ans2 = (ans) this.tp.get(0);
        }
        ans2 = awo.j6(ans, ans2, this.DW, this.FH, this.Hw);
        this.Hw = awo.j6(this.Hw, ans2);
        if (ans2 != null) {
            this.Hw = this.Hw.replaceAll("\nChange-Id: I" + ans.Zo().FH() + "\n", "\nChange-Id: I" + ans2.FH() + "\n");
        }
    }

    private ako j6(ans ans, ako ako) {
        int DW;
        anw anw = null;
        aks FH = ako.FH();
        ako j6 = ako.j6();
        akq DW2 = j6.DW();
        this.VH = new boolean[this.Zo.size()];
        Object obj = 1;
        awc awc = new awc(this.j6);
        int j62 = awc.j6(new aku(ako));
        int j63 = awc.j6(new awa(this.j6));
        if (ans != null) {
            DW = awc.DW(new aql(this.j6).VH((anb) ans));
        } else {
            DW = -1;
        }
        awc.j6(true);
        loop0:
        while (awc.EQ()) {
            avx avx;
            String we = awc.we();
            int Hw = Hw(we);
            if (DW != -1) {
                avx = (avy) awc.j6(DW, avy.class);
            } else {
                avx = null;
            }
            if (Hw >= 0) {
                aku aku = (aku) awc.j6(j62, aku.class);
                awa awa = (awa) awc.j6(j63, awa.class);
                Object obj2 = (aku == null && avx == null) ? null : 1;
                if (obj2 == null) {
                    break loop0;
                }
                Object obj3;
                if (awa != null) {
                    akt akt = new akt(we);
                    long QX = awa.QX();
                    akt.DW(QX);
                    akt.j6(awa.XL());
                    akt.j6(awa.j6(aku));
                    obj3 = ((aku == null || !awa.DW((avx) aku)) && (avx == null || !awa.DW(avx))) ? null : 1;
                    if (obj3 != null) {
                        akt.j6(awa.EQ());
                    } else {
                        if (anl.v5.equals(akt.tp())) {
                            akt.j6(awa.EQ());
                        } else {
                            anw Hw2;
                            if (anw == null) {
                                Hw2 = this.j6.Hw();
                            } else {
                                Hw2 = anw;
                            }
                            InputStream aM = awa.aM();
                            try {
                                akt.j6(Hw2.j6(3, QX, aM));
                                anw = Hw2;
                            } finally {
                                aM.close();
                            }
                        }
                    }
                    FH.j6(new ahz$1(this, we, akt));
                    DW2.DW(akt);
                    if (!(obj == null || (avx != null && avx.DW((avx) awa) && avx.J0() == awa.J0()))) {
                        obj3 = null;
                    }
                    obj3 = obj;
                } else {
                    FH.j6(new aks$a(we));
                    if (!(obj == null || avx == null)) {
                        obj3 = null;
                    }
                    obj3 = obj;
                }
                this.VH[Hw] = true;
                obj = obj3;
            } else if (avx != null) {
                akt akt2 = new akt(we);
                akt2.j6(avx.EQ());
                akt2.j6(avx.we());
                DW2.DW(akt2);
            }
        }
        int i = 0;
        while (i < this.VH.length) {
            if (this.VH[i]) {
                i++;
            } else {
                throw new ajg(MessageFormat.format(JGitText.j6().entryNotFoundByPath, new Object[]{this.Zo.get(i)}));
            }
        }
        if (obj != null) {
            throw new ajg(JGitText.j6().emptyCommit);
        }
        FH.Hw();
        DW2.DW();
        return j6;
    }

    private int Hw(String str) {
        int i = 0;
        for (String str2 : this.Zo) {
            String str3 = str;
            while (!str3.equals(str2)) {
                int lastIndexOf = str3.lastIndexOf("/");
                if (lastIndexOf < 1) {
                    i++;
                } else {
                    str3 = str3.substring(0, lastIndexOf);
                }
            }
            return i;
        }
        return -1;
    }

    private void j6(aok aok) {
        if (this.FH == null) {
            this.FH = new aoa(this.j6);
        }
        if (this.DW == null) {
            this.DW = this.FH;
        }
        if (aok == aok.MERGING_RESOLVED) {
            try {
                this.tp = this.j6.lg();
                if (this.Hw == null) {
                    try {
                        this.Hw = this.j6.a8();
                    } catch (Throwable e) {
                        throw new ajg(MessageFormat.format(JGitText.j6().exceptionOccurredDuringReadingOfGIT_DIR, new Object[]{"MERGE_MSG", e}), e);
                    }
                }
            } catch (Throwable e2) {
                throw new ajg(MessageFormat.format(JGitText.j6().exceptionOccurredDuringReadingOfGIT_DIR, new Object[]{"MERGE_HEAD", e2}), e2);
            }
        }
        if (this.Hw == null) {
            throw new ajk(JGitText.j6().commitMessageNotSpecified);
        }
    }

    public ahz j6(String str) {
        Zo();
        this.Hw = str;
        return this;
    }

    public ahz j6(aoa aoa) {
        Zo();
        this.DW = aoa;
        return this;
    }

    public ahz j6(boolean z) {
        Zo();
        if (this.Zo.isEmpty()) {
            this.v5 = z;
            return this;
        }
        throw new ajg(MessageFormat.format(JGitText.j6().illegalCombinationOfArguments, new Object[]{"--all", "--only"}));
    }

    public ahz DW(String str) {
        Zo();
        if (this.v5) {
            throw new ajg(MessageFormat.format(JGitText.j6().illegalCombinationOfArguments, new Object[]{"--only", "--all"}));
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        if (!this.Zo.contains(str)) {
            this.Zo.add(str);
        }
        return this;
    }

    public ahz FH(String str) {
        this.EQ = str;
        return this;
    }
}
