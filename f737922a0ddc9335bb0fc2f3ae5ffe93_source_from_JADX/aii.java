import com.aide.uidesigner.ProxyTextView;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class aii extends aie<aij> {
    private static /* synthetic */ int[] Hw;
    private aov DW;
    private List<aoc> FH;

    public /* synthetic */ Object call() {
        return j6();
    }

    static /* synthetic */ int[] DW() {
        int[] iArr = Hw;
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
            Hw = iArr;
        }
        return iArr;
    }

    protected aii(aoh aoh) {
        super(aoh);
        this.DW = aov.Hw;
        this.FH = new LinkedList();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public aij j6() {
        /*
        r14 = this;
        r3 = 2;
        r6 = 1;
        r5 = 0;
        r11 = 0;
        r14.Zo();
        r1 = r14.FH;
        r1 = r1.size();
        if (r1 == r6) goto L_0x0044;
    L_0x000f:
        r2 = new ajd;
        r1 = r14.FH;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0023;
    L_0x0019:
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.noMergeHeadSpecified;
    L_0x001f:
        r2.<init>(r1);
        throw r2;
    L_0x0023:
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.mergeStrategyDoesNotSupportHeads;
        r3 = new java.lang.Object[r3];
        r4 = r14.DW;
        r4 = r4.j6();
        r3[r5] = r4;
        r4 = r14.FH;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r3[r6] = r4;
        r1 = java.text.MessageFormat.format(r1, r3);
        goto L_0x001f;
    L_0x0044:
        r1 = r14.j6;	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r2 = "HEAD";
        r5 = r1.FH(r2);	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        if (r5 != 0) goto L_0x0071;
    L_0x004f:
        r1 = new ajj;	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r2 = org.eclipse.jgit.JGitText.j6();	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r2 = r2.commitOnRepoWithoutHEADCurrentlyNotSupported;	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r1.<init>(r2);	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        throw r1;	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
    L_0x005b:
        r1 = move-exception;
        r2 = r11;
    L_0x005d:
        if (r2 != 0) goto L_0x0300;
    L_0x005f:
        r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x0069 }
    L_0x0063:
        r3 = new aiy;	 Catch:{ all -> 0x0069 }
        r3.<init>(r2, r1);	 Catch:{ all -> 0x0069 }
        throw r3;	 Catch:{ all -> 0x0069 }
    L_0x0069:
        r1 = move-exception;
        r12 = r11;
    L_0x006b:
        if (r12 == 0) goto L_0x0070;
    L_0x006d:
        r12.we();
    L_0x0070:
        throw r1;
    L_0x0071:
        r10 = new java.lang.StringBuilder;	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r1 = "merge ";
        r10.<init>(r1);	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r12 = new aql;	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r1 = r14.j6;	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r12.<init>(r1);	 Catch:{ akx -> 0x005b, IOException -> 0x0306, all -> 0x0321 }
        r1 = r14.FH;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r2 = 0;
        r1 = r1.get(r2);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = (aoc) r1;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r2 = r1.j6();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r10.append(r2);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r2 = r1.VH();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r2 != 0) goto L_0x0336;
    L_0x0096:
        r2 = r1.v5();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r2;
    L_0x009b:
        r2 = r12.Hw(r3);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r5.v5();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r6 != 0) goto L_0x0111;
    L_0x00a5:
        r12.Zo(r2);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9 = new akr;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r4 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r4 = r4.XL();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r2.u7();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9.<init>(r1, r4, r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = 1;
        r9.j6(r1);	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r9.v5();	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r1 = r14.j6;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r4 = r5.Hw();	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r4 = r4.j6();	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r1 = r1.j6(r4);	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r1.j6(r3);	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r3 = 0;
        r1.DW(r3);	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r3 = "initial pull";
        r4 = 0;
        r1.j6(r3, r4);	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r1 = r1.QX();	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r3 = aof$a.NEW;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        if (r1 == r3) goto L_0x00f5;
    L_0x00e4:
        r1 = new ajj;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r2 = org.eclipse.jgit.JGitText.j6();	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r2 = r2.commitOnRepoWithoutHEADCurrentlyNotSupported;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r1.<init>(r2);	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        throw r1;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
    L_0x00f0:
        r1 = move-exception;
        r2 = r9;
        r11 = r12;
        goto L_0x005d;
    L_0x00f5:
        r1 = 0;
        r14.DW(r1);	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r1 = new aij;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r3 = 2;
        r4 = new ans[r3];	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r3 = 1;
        r4[r3] = r2;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r5 = aij$a.FAST_FORWARD;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r6 = r14.DW;	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        r7 = 0;
        r8 = 0;
        r3 = r2;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ akx -> 0x00f0, IOException -> 0x0325 }
        if (r12 == 0) goto L_0x0110;
    L_0x010d:
        r12.we();
    L_0x0110:
        return r1;
    L_0x0111:
        r4 = r12.Hw(r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r12.j6(r2, r4);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r3 == 0) goto L_0x013b;
    L_0x011b:
        r1 = 0;
        r14.DW(r1);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = new aij;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = 2;
        r6 = new ans[r1];	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = 0;
        r6[r1] = r4;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = 1;
        r6[r1] = r2;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r7 = aij$a.ALREADY_UP_TO_DATE;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r8 = r14.DW;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9 = 0;
        r10 = 0;
        r5 = r2;
        r3.<init>(r4, r5, r6, r7, r8, r9, r10);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r12 == 0) goto L_0x0139;
    L_0x0136:
        r12.we();
    L_0x0139:
        r1 = r3;
        goto L_0x0110;
    L_0x013b:
        r3 = r12.j6(r4, r2);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r3 == 0) goto L_0x0196;
    L_0x0141:
        r1 = new java.lang.StringBuilder;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = ": ";
        r1.<init>(r3);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = aij$a.FAST_FORWARD;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r1.append(r3);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r1.toString();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r10.append(r1);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9 = new akr;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r4.u7();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = r5.XL();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r7 = r2.u7();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9.<init>(r1, r3, r5, r7);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = 1;
        r9.j6(r1);	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r9.v5();	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r14.j6(r10, r2, r6);	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r1 = 0;
        r14.DW(r1);	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r1 = new aij;	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r3 = 2;
        r10 = new ans[r3];	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r3 = 0;
        r10[r3] = r4;	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r3 = 1;
        r10[r3] = r2;	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r5 = aij$a.FAST_FORWARD;	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r6 = r14.DW;	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        r7 = 0;
        r8 = 0;
        r3 = r2;
        r4 = r10;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ akx -> 0x032c, IOException -> 0x0325 }
        if (r12 == 0) goto L_0x0110;
    L_0x0191:
        r12.we();
        goto L_0x0110;
    L_0x0196:
        r3 = new aot;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3.<init>();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r14.FH;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9 = r3.j6(r6, r5);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3.Zo(r9);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = 1;
        r5 = new ans[r5];	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = 0;
        r7 = r1.v5();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5[r6] = r7;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = java.util.Arrays.asList(r5);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3.j6(r5);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r14.DW;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = r3.j6(r5);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r5 instanceof aox;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r3 == 0) goto L_0x027b;
    L_0x01c5:
        r0 = r5;
        r0 = (aox) r0;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r0;
        r6 = 3;
        r6 = new java.lang.String[r6];	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r7 = 0;
        r8 = "BASE";
        r6[r7] = r8;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r7 = 1;
        r8 = "HEAD";
        r6[r7] = r8;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r7 = 2;
        r1 = r1.j6();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6[r7] = r1;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3.j6(r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = new awa;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1.<init>(r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3.j6(r1);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = 2;
        r1 = new anb[r1];	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = 0;
        r1[r6] = r4;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = 1;
        r1[r6] = r2;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r5.j6(r1);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r7 = r3.Zo();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r8 = r3.VH();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r3.v5();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r6;
    L_0x0206:
        r6 = ": Merge made by ";
        r10.append(r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r14.DW;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r6.j6();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r10.append(r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = 46;
        r10.append(r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r3 == 0) goto L_0x028e;
    L_0x021c:
        r9 = new akr;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r4.u7();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r6.XL();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = r5.Hw();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9.<init>(r1, r3, r6, r5);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = 1;
        r9.j6(r1);	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r9.v5();	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r1 = new aid;	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r3 = r14.v5();	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r1.<init>(r3);	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r1 = r1.FH();	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r3 = r10.toString();	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r1 = r1.FH(r3);	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r3 = r1.j6();	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r1 = new aij;	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r10 = r3.XL();	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r3 = 0;
        r5 = 2;
        r11 = new ans[r5];	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r5 = 0;
        r4 = r4.XL();	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r11[r5] = r4;	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r4 = 1;
        r2 = r2.XL();	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r11[r4] = r2;	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r5 = aij$a.MERGED;	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r6 = r14.DW;	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        r7 = 0;
        r8 = 0;
        r2 = r10;
        r4 = r11;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ akx -> 0x0331, IOException -> 0x0325 }
        if (r12 == 0) goto L_0x0110;
    L_0x0276:
        r12.we();
        goto L_0x0110;
    L_0x027b:
        r1 = 2;
        r1 = new anb[r1];	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = 0;
        r1[r3] = r4;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = 1;
        r1[r3] = r2;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r5.j6(r1);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r8 = r11;
        r7 = r11;
        r3 = r1;
        r1 = r11;
        goto L_0x0206;
    L_0x028e:
        if (r8 == 0) goto L_0x02c7;
    L_0x0290:
        r1 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = 0;
        r1.Zo(r3);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = 0;
        r1.j6(r3);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = new aij;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r10 = 0;
        r3 = 0;
        r6 = 1;
        r3 = r5.DW(r3, r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = 2;
        r13 = new ans[r5];	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = 0;
        r4 = r4.XL();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r13[r5] = r4;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r4 = 1;
        r2 = r2.XL();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r13[r4] = r2;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = aij$a.FAILED;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r14.DW;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9 = 0;
        r2 = r10;
        r4 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r12 == 0) goto L_0x0110;
    L_0x02c2:
        r12.we();
        goto L_0x0110;
    L_0x02c7:
        r3 = new aot;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3.<init>();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = r3.j6(r9, r1);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3 = r14.j6;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r3.Zo(r1);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r1 = new aij;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r9 = 0;
        r3 = 0;
        r6 = 1;
        r3 = r5.DW(r3, r6);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = 2;
        r10 = new ans[r5];	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = 0;
        r4 = r4.XL();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r10[r5] = r4;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r4 = 1;
        r2 = r2.XL();	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r10[r4] = r2;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r5 = aij$a.CONFLICTING;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r6 = r14.DW;	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        r8 = 0;
        r2 = r9;
        r4 = r10;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ akx -> 0x0327, IOException -> 0x0325 }
        if (r12 == 0) goto L_0x0110;
    L_0x02fb:
        r12.we();
        goto L_0x0110;
    L_0x0300:
        r2 = r2.j6();	 Catch:{ all -> 0x0069 }
        goto L_0x0063;
    L_0x0306:
        r1 = move-exception;
        r12 = r11;
    L_0x0308:
        r2 = new ajg;	 Catch:{ all -> 0x031e }
        r3 = org.eclipse.jgit.JGitText.j6();	 Catch:{ all -> 0x031e }
        r3 = r3.exceptionCaughtDuringExecutionOfMergeCommand;	 Catch:{ all -> 0x031e }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x031e }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ all -> 0x031e }
        r3 = java.text.MessageFormat.format(r3, r4);	 Catch:{ all -> 0x031e }
        r2.<init>(r3, r1);	 Catch:{ all -> 0x031e }
        throw r2;	 Catch:{ all -> 0x031e }
    L_0x031e:
        r1 = move-exception;
        goto L_0x006b;
    L_0x0321:
        r1 = move-exception;
        r12 = r11;
        goto L_0x006b;
    L_0x0325:
        r1 = move-exception;
        goto L_0x0308;
    L_0x0327:
        r1 = move-exception;
        r2 = r11;
        r11 = r12;
        goto L_0x005d;
    L_0x032c:
        r1 = move-exception;
        r2 = r9;
        r11 = r12;
        goto L_0x005d;
    L_0x0331:
        r1 = move-exception;
        r2 = r9;
        r11 = r12;
        goto L_0x005d;
    L_0x0336:
        r3 = r2;
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: aii.j6():aij");
    }

    private void j6(StringBuilder stringBuilder, ans ans, ans ans2) {
        aof j6 = this.j6.j6("HEAD");
        j6.j6((anb) ans);
        j6.j6(stringBuilder.toString(), false);
        j6.DW((anb) ans2);
        aof$a QX = j6.QX();
        switch (DW()[QX.ordinal()]) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case 7:
                throw new aiz(JGitText.j6().couldNotLockHEAD, j6.v5(), QX);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 6:
            default:
                throw new ajg(MessageFormat.format(JGitText.j6().updatingRefFailed, new Object[]{"HEAD", ans.toString(), QX}));
        }
    }

    public aii j6(aoc aoc) {
        Zo();
        this.FH.add(aoc);
        return this;
    }

    public aii j6(anb anb) {
        return j6(anb.FH(), anb);
    }

    public aii j6(String str, anb anb) {
        return j6(new anu$c(aoc$a.LOOSE, str, anb.Hw()));
    }
}
