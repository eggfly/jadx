public class aph {
    final int DW;
    int FH;
    int Hw;
    private final aph$a VH;
    int Zo;
    private ajw gn;
    final apg j6;
    int v5;

    aph(apg apg, int i) {
        this(apg, i, new aph$1(apg));
    }

    aph(apg apg, int i, aph$a aph_a) {
        this.j6 = apg;
        this.DW = i;
        this.VH = aph_a;
    }

    aph(apg apg, ajw ajw) {
        this(apg, apg.Ws.length);
        this.gn = ajw;
        this.FH = this.DW;
        this.Zo = 0;
        if (ajw.isEmpty()) {
            this.Hw = 0;
            this.v5 = 0;
            return;
        }
        this.Hw = ((ajv) ajw.get(0)).v5();
        this.v5 = ((ajv) ajw.get(ajw.size() - 1)).Zo() - this.Hw;
    }

    public apg j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public aph$a FH() {
        return this.VH;
    }

    public int Hw() {
        return this.Hw;
    }

    public int v5() {
        return this.v5;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ajw Zo() {
        /*
        r8 = this;
        r1 = 0;
        r0 = r8.gn;
        if (r0 != 0) goto L_0x0022;
    L_0x0005:
        r0 = new ajw;
        r0.<init>();
        r8.gn = r0;
        r0 = r8.j6;
        r5 = r0.Ws;
        r0 = r8.DW;
        r0 = axe.Hw(r5, r0);
        r2 = r8.VH;
        r3 = r2.j6;
        r2 = r8.Hw;
        r4 = r0;
        r0 = r1;
    L_0x001e:
        r6 = r8.FH;
        if (r4 < r6) goto L_0x0025;
    L_0x0022:
        r0 = r8.gn;
        return r0;
    L_0x0025:
        r6 = r5[r4];
        switch(r6) {
            case 10: goto L_0x002b;
            case 32: goto L_0x002b;
            case 43: goto L_0x004c;
            case 45: goto L_0x0036;
            case 92: goto L_0x0031;
            default: goto L_0x002a;
        };
    L_0x002a:
        goto L_0x0022;
    L_0x002b:
        r3 = r3 + 1;
        r0 = r2 + 1;
        r2 = r0;
        r0 = r1;
    L_0x0031:
        r4 = axe.Hw(r5, r4);
        goto L_0x001e;
    L_0x0036:
        if (r0 != 0) goto L_0x0046;
    L_0x0038:
        r0 = new ajv;
        r6 = r3 + -1;
        r7 = r2 + -1;
        r0.<init>(r6, r7);
        r6 = r8.gn;
        r6.add(r0);
    L_0x0046:
        r3 = r3 + 1;
        r0.gn();
        goto L_0x0031;
    L_0x004c:
        if (r0 != 0) goto L_0x005c;
    L_0x004e:
        r0 = new ajv;
        r6 = r3 + -1;
        r7 = r2 + -1;
        r0.<init>(r6, r7);
        r6 = r8.gn;
        r6.add(r0);
    L_0x005c:
        r2 = r2 + 1;
        r0.u7();
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: aph.Zo():ajw");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HunkHeader[");
        stringBuilder.append(FH().j6());
        stringBuilder.append(',');
        stringBuilder.append(FH().DW());
        stringBuilder.append("->");
        stringBuilder.append(Hw()).append(',').append(v5());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
