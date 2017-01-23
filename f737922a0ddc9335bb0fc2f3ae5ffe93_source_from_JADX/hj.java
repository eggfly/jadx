import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class hj {
    private final hq DW;
    private de FH;
    private final cc j6;

    public hj(cc ccVar, hq hqVar) {
        this.j6 = ccVar;
        this.DW = hqVar;
    }

    public void j6(de deVar, bv bvVar, int i, int i2, String str, List<String> list) {
        this.FH = deVar;
        deVar.j6();
        if (str.equals("SELECT")) {
            for (String j6 : list) {
                String j62;
                deVar.j6(j62);
            }
        }
        if (str.equals("SELECT_VARIABLE")) {
            j6(bvVar, i, i2, (List) list);
        }
        if (str.equals("SUGGEST_NAME")) {
            DW(bvVar, i, i2, j6(new String[]{"v", "f", "t"}));
        }
        if (str.equals("SUGGEST_ELEMENT_NAME")) {
            if (list.size() == 1) {
                j62 = (String) list.get(0);
                if (j62.endsWith("s")) {
                    j62 = j62.substring(0, j62.length() - 1);
                    DW(bvVar, i, i2, j6(new String[]{j62}));
                }
            }
            DW(bvVar, i, i2, j6(new String[]{"e", "m", "a"}));
        }
        if (str.equals("SUGGEST_INDEX_NAME")) {
            DW(bvVar, i, i2, j6(new String[]{"i", "j", "k", "n", "z", "l"}));
        }
        if (str.equals("SUGGEST_EXCEPTION_NAME")) {
            DW(bvVar, i, i2, j6(new String[]{"e", "ex", "e2", "e3", "e4"}));
        }
        deVar.DW();
    }

    private List<String> j6(String[] strArr) {
        List arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void j6(bv bvVar, int i, int i2, List<String> list) {
        cj DW = this.j6.sh.DW(bvVar, this.DW);
        for (cp j6 : j6(DW, i, i2, (List) list)) {
            this.FH.j6(j6);
        }
        this.j6.sh.j6(DW);
    }

    private void DW(bv bvVar, int i, int i2, List<String> list) {
        List<cp> j6 = j6(this.j6.sh.DW(bvVar, this.DW, i, i2, "i;"), i, i2, Collections.EMPTY_LIST);
        for (String str : list) {
            for (cp VH : j6) {
                if (VH.VH() == this.j6.ro.j6(str)) {
                    break;
                }
            }
            this.FH.j6(str);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<cp> j6(cj r21, int r22, int r23, java.util.List<java.lang.String> r24) {
        /*
        r20 = this;
        r16 = new java.util.ArrayList;
        r16.<init>();
        r0 = r21;
        r1 = r22;
        r2 = r23;
        r3 = r22;
        r4 = r23;
        r5 = r0.Zo(r1, r2, r3, r4);
        r0 = r21;
        r1 = r22;
        r2 = r23;
        r3 = r22;
        r4 = r23;
        r6 = r0.FH(r1, r2, r3, r4);
        r7 = -1;
        if (r6 != r7) goto L_0x026c;
    L_0x0024:
        r17 = new ec;
        r17.<init>();
        r6 = r5;
        r15 = r5;
    L_0x002b:
        r5 = -1;
        if (r15 == r5) goto L_0x0267;
    L_0x002e:
        r0 = r21;
        r5 = r0.rN(r15);
        r7 = 133; // 0x85 float:1.86E-43 double:6.57E-322;
        if (r5 != r7) goto L_0x00e8;
    L_0x0038:
        r0 = r21;
        r5 = r0.lg(r15);
        r5 = r5 + -1;
    L_0x0040:
        if (r5 < 0) goto L_0x004a;
    L_0x0042:
        r0 = r21;
        r7 = r0.Hw(r15, r5);
        if (r7 != r6) goto L_0x00df;
    L_0x004a:
        r5 = r5 + -1;
        r14 = r5;
    L_0x004d:
        if (r14 < 0) goto L_0x0256;
    L_0x004f:
        r0 = r21;
        r18 = r0.Hw(r15, r14);
        r0 = r21;
        r1 = r18;
        r5 = r0.rN(r1);
        r6 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        if (r5 == r6) goto L_0x006d;
    L_0x0061:
        r0 = r21;
        r1 = r18;
        r5 = r0.rN(r1);
        r6 = 152; // 0x98 float:2.13E-43 double:7.5E-322;
        if (r5 != r6) goto L_0x00e3;
    L_0x006d:
        r0 = r21;
        r1 = r18;
        r19 = r0.lg(r1);
        r5 = 1;
        r13 = r5;
    L_0x0077:
        r0 = r19;
        if (r13 >= r0) goto L_0x00e3;
    L_0x007b:
        r0 = r21;
        r1 = r18;
        r5 = r0.Hw(r1, r13);
        r6 = 0;
        r0 = r21;
        r10 = r0.Hw(r5, r6);
        r0 = r21;
        r11 = r0.gW(r10);
        r0 = r17;
        r5 = r0.FH(r11);
        if (r5 != 0) goto L_0x00db;
    L_0x0098:
        r0 = r21;
        r5 = r0.nw(r10);
        r0 = r22;
        if (r5 != r0) goto L_0x00b6;
    L_0x00a2:
        r0 = r21;
        r5 = r0.KD(r10);
        r0 = r23;
        if (r5 > r0) goto L_0x00b6;
    L_0x00ac:
        r0 = r21;
        r5 = r0.ro(r10);
        r0 = r23;
        if (r5 >= r0) goto L_0x00db;
    L_0x00b6:
        r5 = new cp;
        r6 = r21.we();
        r7 = r21.tp();
        r0 = r21;
        r8 = r0.nw(r10);
        r0 = r21;
        r9 = r0.KD(r10);
        r0 = r21;
        r10 = r0.ro(r10);
        r12 = 0;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12);
        r0 = r16;
        r0.add(r5);
    L_0x00db:
        r5 = r13 + 2;
        r13 = r5;
        goto L_0x0077;
    L_0x00df:
        r5 = r5 + -1;
        goto L_0x0040;
    L_0x00e3:
        r5 = r14 + -1;
        r14 = r5;
        goto L_0x004d;
    L_0x00e8:
        r0 = r21;
        r5 = r0.rN(r15);
        r6 = 146; // 0x92 float:2.05E-43 double:7.2E-322;
        if (r5 != r6) goto L_0x0179;
    L_0x00f2:
        r5 = 0;
        r0 = r21;
        r5 = r0.Hw(r15, r5);
        r0 = r21;
        r5 = r0.rN(r5);
        r6 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        if (r5 == r6) goto L_0x0114;
    L_0x0103:
        r5 = 0;
        r0 = r21;
        r5 = r0.Hw(r15, r5);
        r0 = r21;
        r5 = r0.rN(r5);
        r6 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r5 != r6) goto L_0x0179;
    L_0x0114:
        r5 = 0;
        r0 = r21;
        r5 = r0.Hw(r15, r5);
        r0 = r21;
        r6 = r0.lg(r15);
        r6 = r6 + -2;
        r0 = r21;
        r14 = r0.Hw(r5, r6);
        r0 = r21;
        r18 = r0.lg(r14);
        r5 = 1;
        r13 = r5;
    L_0x0131:
        r5 = r18 + -1;
        if (r13 >= r5) goto L_0x0256;
    L_0x0135:
        r0 = r21;
        r5 = r0.Hw(r14, r13);
        r6 = 0;
        r0 = r21;
        r10 = r0.Hw(r5, r6);
        r0 = r21;
        r11 = r0.gW(r10);
        r0 = r17;
        r5 = r0.FH(r11);
        if (r5 != 0) goto L_0x0175;
    L_0x0150:
        r5 = new cp;
        r6 = r21.we();
        r7 = r21.tp();
        r0 = r21;
        r8 = r0.nw(r10);
        r0 = r21;
        r9 = r0.KD(r10);
        r0 = r21;
        r10 = r0.ro(r10);
        r12 = 0;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12);
        r0 = r16;
        r0.add(r5);
    L_0x0175:
        r5 = r13 + 2;
        r13 = r5;
        goto L_0x0131;
    L_0x0179:
        r0 = r21;
        r5 = r0.rN(r15);
        r6 = 211; // 0xd3 float:2.96E-43 double:1.042E-321;
        if (r5 != r6) goto L_0x01e4;
    L_0x0183:
        r5 = 2;
        r0 = r21;
        r14 = r0.Hw(r15, r5);
        r0 = r21;
        r5 = r0.rN(r14);
        r6 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        if (r5 != r6) goto L_0x0256;
    L_0x0194:
        r0 = r21;
        r18 = r0.lg(r14);
        r5 = 1;
        r13 = r5;
    L_0x019c:
        r0 = r18;
        if (r13 >= r0) goto L_0x0256;
    L_0x01a0:
        r0 = r21;
        r5 = r0.Hw(r14, r13);
        r6 = 0;
        r0 = r21;
        r10 = r0.Hw(r5, r6);
        r0 = r21;
        r11 = r0.gW(r10);
        r0 = r17;
        r5 = r0.FH(r11);
        if (r5 != 0) goto L_0x01e0;
    L_0x01bb:
        r5 = new cp;
        r6 = r21.we();
        r7 = r21.tp();
        r0 = r21;
        r8 = r0.nw(r10);
        r0 = r21;
        r9 = r0.KD(r10);
        r0 = r21;
        r10 = r0.ro(r10);
        r12 = 0;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12);
        r0 = r16;
        r0.add(r5);
    L_0x01e0:
        r5 = r13 + 2;
        r13 = r5;
        goto L_0x019c;
    L_0x01e4:
        r0 = r21;
        r5 = r0.rN(r15);
        r6 = 149; // 0x95 float:2.09E-43 double:7.36E-322;
        if (r5 != r6) goto L_0x0256;
    L_0x01ee:
        r5 = 2;
        r0 = r21;
        r5 = r0.Hw(r15, r5);
        r6 = 0;
        r0 = r21;
        r14 = r0.Hw(r5, r6);
        r0 = r21;
        r5 = r0.rN(r14);
        r6 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        if (r5 != r6) goto L_0x0256;
    L_0x0206:
        r0 = r21;
        r18 = r0.lg(r14);
        r5 = 1;
        r13 = r5;
    L_0x020e:
        r0 = r18;
        if (r13 >= r0) goto L_0x0256;
    L_0x0212:
        r0 = r21;
        r5 = r0.Hw(r14, r13);
        r6 = 0;
        r0 = r21;
        r10 = r0.Hw(r5, r6);
        r0 = r21;
        r11 = r0.gW(r10);
        r0 = r17;
        r5 = r0.FH(r11);
        if (r5 != 0) goto L_0x0252;
    L_0x022d:
        r5 = new cp;
        r6 = r21.we();
        r7 = r21.tp();
        r0 = r21;
        r8 = r0.nw(r10);
        r0 = r21;
        r9 = r0.KD(r10);
        r0 = r21;
        r10 = r0.ro(r10);
        r12 = 0;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12);
        r0 = r16;
        r0.add(r5);
    L_0x0252:
        r5 = r13 + 2;
        r13 = r5;
        goto L_0x020e;
    L_0x0256:
        r0 = r21;
        r5 = r0.aM(r15);
        r6 = r21.Ws();
        if (r5 != r6) goto L_0x0268;
    L_0x0262:
        r5 = -1;
        r6 = r15;
        r15 = r5;
        goto L_0x002b;
    L_0x0267:
        return r16;
    L_0x0268:
        r6 = r15;
        r15 = r5;
        goto L_0x002b;
    L_0x026c:
        r5 = r6;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: hj.j6(cj, int, int, java.util.List):java.util.List<cp>");
    }
}
