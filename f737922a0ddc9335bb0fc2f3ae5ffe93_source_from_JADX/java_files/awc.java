public class awc {
    private static final avx[] FH;
    avx DW;
    private boolean EQ;
    private final any Hw;
    private boolean VH;
    private awl Zo;
    private boolean gn;
    avx[] j6;
    private boolean tp;
    private int u7;
    private final ano v5;

    static {
        FH = new avx[0];
    }

    public static awc j6(any any, String str, anb... anbArr) {
        awc awc = new awc(any);
        awl j6 = awi.j6(str);
        awc.j6(j6);
        awc.j6(anbArr);
        awc.j6(false);
        while (awc.EQ()) {
            if (j6.DW(awc)) {
                return awc;
            }
            if (awc.Ws()) {
                awc.QX();
            }
        }
        return null;
    }

    public static awc j6(aoh aoh, String str, anb... anbArr) {
        any v5 = aoh.v5();
        try {
            awc j6 = j6(v5, str, anbArr);
            return j6;
        } finally {
            v5.FH();
        }
    }

    public static awc j6(aoh aoh, String str, aqk aqk) {
        return j6(aoh, str, aqk);
    }

    public awc(aoh aoh) {
        this(aoh.v5());
    }

    public awc(any any) {
        this.v5 = new ano();
        this.Hw = any;
        this.Zo = awl.FH;
        this.j6 = FH;
    }

    public void v5() {
        this.Hw.FH();
    }

    public awl Zo() {
        return this.Zo;
    }

    public void j6(awl awl) {
        if (awl == null) {
            awl = awl.FH;
        }
        this.Zo = awl;
    }

    public boolean VH() {
        return this.VH;
    }

    public void j6(boolean z) {
        this.VH = z;
    }

    public boolean gn() {
        return this.gn;
    }

    public void u7() {
        this.j6 = FH;
        this.tp = false;
        this.u7 = 0;
    }

    public void j6(anb anb) {
        if (this.j6.length == 1) {
            avx avx = this.j6[0];
            while (avx.Zo != null) {
                avx = avx.Zo;
            }
            if (avx instanceof avy) {
                avx.VH = null;
                avx.gn = 0;
                ((avy) avx).j6(this.Hw, anb);
                this.j6[0] = avx;
            } else {
                this.j6[0] = FH(anb);
            }
        } else {
            this.j6 = new avx[]{FH(anb)};
        }
        this.tp = false;
        this.u7 = 0;
    }

    public void j6(anb... anbArr) {
        avx[] avxArr;
        int length = this.j6.length;
        int length2 = anbArr.length;
        if (length2 == length) {
            avxArr = this.j6;
        } else {
            avxArr = new avx[length2];
        }
        for (int i = 0; i < length2; i++) {
            if (i < length) {
                avx avx = this.j6[i];
                while (avx.Zo != null) {
                    avx = avx.Zo;
                }
                if ((avx instanceof avy) && avx.EQ == 0) {
                    avx.VH = null;
                    avx.gn = 0;
                    ((avy) avx).j6(this.Hw, anbArr[i]);
                    avxArr[i] = avx;
                }
            }
            avxArr[i] = FH(anbArr[i]);
        }
        this.j6 = avxArr;
        this.tp = false;
        this.u7 = 0;
    }

    public int DW(anb anb) {
        return j6(FH(anb));
    }

    public int j6(avx avx) {
        int length = this.j6.length;
        Object obj = new avx[(length + 1)];
        System.arraycopy(this.j6, 0, obj, 0, length);
        obj[length] = avx;
        avx.VH = null;
        avx.gn = 0;
        this.j6 = obj;
        return length;
    }

    public int tp() {
        return this.j6.length;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean EQ() {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = r5.tp;	 Catch:{ alv -> 0x002f }
        if (r2 == 0) goto L_0x000f;
    L_0x0006:
        r2 = 0;
        r5.tp = r2;	 Catch:{ alv -> 0x002f }
        r2 = 0;
        r5.EQ = r2;	 Catch:{ alv -> 0x002f }
        r5.DW();	 Catch:{ alv -> 0x002f }
    L_0x000f:
        r2 = r5.j6();	 Catch:{ alv -> 0x002f }
        r3 = r2.u7();	 Catch:{ alv -> 0x002f }
        if (r3 == 0) goto L_0x003a;
    L_0x0019:
        r2 = r5.u7;	 Catch:{ alv -> 0x002f }
        if (r2 <= 0) goto L_0x0038;
    L_0x001d:
        r5.Hw();	 Catch:{ alv -> 0x002f }
        r2 = r5.gn;	 Catch:{ alv -> 0x002f }
        if (r2 == 0) goto L_0x002b;
    L_0x0024:
        r2 = 1;
        r5.tp = r2;	 Catch:{ alv -> 0x002f }
        r2 = 1;
        r5.EQ = r2;	 Catch:{ alv -> 0x002f }
    L_0x002a:
        return r0;
    L_0x002b:
        r5.DW();	 Catch:{ alv -> 0x002f }
        goto L_0x000f;
    L_0x002f:
        r0 = move-exception;
        r2 = r5.j6;
        r3 = r2.length;
        r0 = r1;
    L_0x0034:
        if (r0 < r3) goto L_0x005e;
    L_0x0036:
        r0 = r1;
        goto L_0x002a;
    L_0x0038:
        r0 = r1;
        goto L_0x002a;
    L_0x003a:
        r5.DW = r2;	 Catch:{ alv -> 0x002f }
        r3 = r5.Zo;	 Catch:{ alv -> 0x002f }
        r3 = r3.j6(r5);	 Catch:{ alv -> 0x002f }
        if (r3 != 0) goto L_0x0048;
    L_0x0044:
        r5.FH();	 Catch:{ alv -> 0x002f }
        goto L_0x000f;
    L_0x0048:
        r3 = r5.VH;	 Catch:{ alv -> 0x002f }
        if (r3 == 0) goto L_0x005a;
    L_0x004c:
        r3 = anl.j6;	 Catch:{ alv -> 0x002f }
        r2 = r2.u7;	 Catch:{ alv -> 0x002f }
        r2 = r3.DW(r2);	 Catch:{ alv -> 0x002f }
        if (r2 == 0) goto L_0x005a;
    L_0x0056:
        r5.QX();	 Catch:{ alv -> 0x002f }
        goto L_0x000f;
    L_0x005a:
        r2 = 1;
        r5.tp = r2;	 Catch:{ alv -> 0x002f }
        goto L_0x002a;
    L_0x005e:
        r4 = r2[r0];
        r4.DW();
        r0 = r0 + 1;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: awc.EQ():boolean");
    }

    public <T extends avx> T j6(int i, Class<T> cls) {
        T t = this.j6[i];
        return t.VH == this.DW ? t : null;
    }

    public int j6(int i) {
        avx avx = this.j6[i];
        return avx.VH == this.DW ? avx.u7 : 0;
    }

    public anl DW(int i) {
        return anl.j6(j6(i));
    }

    public ans FH(int i) {
        avx avx = this.j6[i];
        if (avx.VH == this.DW) {
            return avx.EQ();
        }
        return ans.Zo();
    }

    public void j6(ano ano, int i) {
        avx avx = this.j6[i];
        if (avx.VH == this.DW) {
            avx.j6(ano);
        } else {
            ano.Zo();
        }
    }

    public boolean j6(int i, int i2) {
        avx avx = this.DW;
        avx avx2 = this.j6[i];
        avx avx3 = this.j6[i2];
        if (avx2.VH != avx && avx3.VH != avx) {
            return true;
        }
        if (avx2.Hw() && avx3.Hw() && avx2.VH == avx && avx3.VH == avx) {
            return avx2.DW(avx3);
        }
        return false;
    }

    public String we() {
        return DW(this.DW);
    }

    public byte[] J0() {
        avx avx = this.DW;
        int i = avx.we;
        Object obj = new byte[i];
        System.arraycopy(avx.tp, 0, obj, 0, i);
        return obj;
    }

    public int J8() {
        return this.DW.we;
    }

    public int j6(byte[] bArr, int i) {
        avx avx = this.DW;
        byte[] bArr2 = avx.tp;
        int i2 = avx.we;
        int i3 = 0;
        while (i3 < i2 && i3 < i) {
            int i4 = (bArr2[i3] & 255) - (bArr[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
            i3++;
        }
        if (i3 < i2) {
            if (bArr2[i3] == (byte) 47) {
                return 0;
            }
            return -1;
        } else if (i3 >= i || bArr[i3] == (byte) 47) {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean Ws() {
        return anl.j6.DW(this.DW.u7);
    }

    public void QX() {
        avx avx = this.DW;
        Object obj = new avx[this.j6.length];
        for (int i = 0; i < this.j6.length; i++) {
            avx avx2 = this.j6[i];
            if (avx2.VH == avx && !avx2.u7() && anl.j6.DW(avx2.u7)) {
                avx2 = avx2.j6(this.Hw, this.v5);
            } else {
                avx2 = avx2.FH();
            }
            obj[i] = avx2;
        }
        this.u7++;
        this.tp = false;
        System.arraycopy(obj, 0, this.j6, 0, this.j6.length);
    }

    avx j6() {
        int i = 0;
        avx avx = this.j6[0];
        while (avx.u7()) {
            i++;
            if (i >= this.j6.length) {
                break;
            }
            avx = this.j6[i];
        }
        if (!avx.u7()) {
            avx.VH = avx;
            while (true) {
                int i2 = i + 1;
                if (i2 >= this.j6.length) {
                    break;
                }
                avx avx2 = this.j6[i2];
                if (avx2.u7()) {
                    i = i2;
                } else {
                    int j6 = avx2.j6(avx);
                    if (j6 < 0) {
                        avx2.VH = avx2;
                        avx = avx2;
                        i = i2;
                    } else {
                        if (j6 == 0) {
                            avx2.VH = avx;
                        }
                        i = i2;
                    }
                }
            }
        }
        return avx;
    }

    void DW() {
        avx avx = this.DW;
        for (avx avx2 : this.j6) {
            if (avx2.VH == avx) {
                avx2.j6(1);
                avx2.VH = null;
            }
        }
    }

    void FH() {
        avx avx = this.DW;
        for (avx avx2 : this.j6) {
            if (avx2.VH == avx) {
                avx2.j6();
                avx2.VH = null;
            }
        }
    }

    private void Hw() {
        this.u7--;
        for (int i = 0; i < this.j6.length; i++) {
            this.j6[i] = this.j6[i].Zo;
        }
        avx avx = null;
        for (avx avx2 : this.j6) {
            if (avx2.VH == avx2 && (avx == null || avx2.j6(avx) < 0)) {
                avx = avx2;
            }
        }
        this.DW = avx;
    }

    private avy FH(anb anb) {
        avy avy = new avy();
        avy.j6(this.Hw, anb);
        return avy;
    }

    static String DW(avx avx) {
        return axe.j6(anj.DW, avx.tp, 0, avx.we);
    }

    static String j6(byte[] bArr, int i, int i2) {
        return axe.j6(anj.DW, bArr, i, i2);
    }
}
