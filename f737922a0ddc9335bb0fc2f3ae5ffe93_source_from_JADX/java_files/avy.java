import java.util.Arrays;

public class avy extends avx {
    private static final byte[] j6;
    private byte[] DW;
    private int FH;
    private int Hw;
    private int J0;

    public /* synthetic */ avx j6(any any) {
        return DW(any);
    }

    public /* synthetic */ avx j6(any any, ano ano) {
        return DW(any, ano);
    }

    static {
        j6 = new byte[0];
    }

    public avy() {
        j6(j6);
    }

    public avy(byte[] bArr, any any, anb anb) {
        super(bArr);
        j6(any, anb);
    }

    private avy(avy avy) {
        super((avx) avy);
    }

    public void j6(byte[] bArr) {
        this.DW = bArr;
        this.FH = -1;
        this.Hw = 0;
        if (u7()) {
            this.J0 = 0;
        } else {
            Ws();
        }
    }

    public avy tp() {
        while (this.J0 == this.DW.length) {
            if (this.Zo == null) {
                this.Hw = this.J0;
                break;
            }
            this = (avy) this.Zo;
        }
        this.FH = this.Hw;
        this.Hw = this.J0;
        Ws();
        return this;
    }

    public void j6(any any, anb anb) {
        j6(any.FH(anb, 2).v5());
    }

    public avy DW(any any, ano ano) {
        ano.Hw(v5(), Zo());
        if (anl.j6.DW(this.u7)) {
            return DW(any, (anb) ano);
        }
        throw new alb(ano.v5(), "tree");
    }

    public final avy DW(any any, anb anb) {
        avy avy = new avy(this);
        avy.j6(any, anb);
        return avy;
    }

    public avy DW(any any) {
        return DW(any, new ano());
    }

    public boolean Hw() {
        return true;
    }

    public byte[] v5() {
        return this.DW;
    }

    public int Zo() {
        return this.J0 - 20;
    }

    public void VH() {
        if (!gn()) {
            j6(this.DW);
        }
    }

    public boolean gn() {
        return this.Hw == 0;
    }

    public boolean u7() {
        return this.Hw == this.DW.length;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(int r4) {
        /*
        r3 = this;
        r0 = 1;
        if (r4 != r0) goto L_0x0015;
    L_0x0003:
        r0 = r3.Hw;
        r3.FH = r0;
        r0 = r3.J0;
        r3.Hw = r0;
        r0 = r3.u7();
        if (r0 != 0) goto L_0x0014;
    L_0x0011:
        r3.Ws();
    L_0x0014:
        return;
    L_0x0015:
        r0 = r3.DW;
        r1 = r0.length;
        r0 = r3.J0;
    L_0x001a:
        r4 = r4 + -1;
        if (r4 <= 0) goto L_0x0020;
    L_0x001e:
        if (r0 != r1) goto L_0x0028;
    L_0x0020:
        if (r4 == 0) goto L_0x0036;
    L_0x0022:
        r0 = new java.lang.ArrayIndexOutOfBoundsException;
        r0.<init>(r4);
        throw r0;
    L_0x0028:
        r3.FH = r0;
    L_0x002a:
        r2 = r3.DW;
        r2 = r2[r0];
        if (r2 != 0) goto L_0x0033;
    L_0x0030:
        r0 = r0 + 21;
        goto L_0x001a;
    L_0x0033:
        r0 = r0 + 1;
        goto L_0x002a;
    L_0x0036:
        r3.Hw = r0;
        r0 = r3.u7();
        if (r0 != 0) goto L_0x0014;
    L_0x003e:
        r3.Ws();
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: avy.j6(int):void");
    }

    public void DW(int i) {
        if (i == 1 && this.FH >= 0) {
            this.Hw = this.FH;
            this.FH = -1;
            if (!u7()) {
                Ws();
            }
        } else if (i <= 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        } else {
            Object obj = new int[(i + 1)];
            Arrays.fill(obj, -1);
            int i2 = 0;
            while (i2 != this.Hw) {
                System.arraycopy(obj, 1, obj, 0, i);
                obj[i] = i2;
                while (this.DW[i2] != null) {
                    i2++;
                }
                i2 += 21;
            }
            if (obj[1] == -1) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            this.FH = obj[0];
            this.Hw = obj[1];
            Ws();
        }
    }

    private void Ws() {
        int i = this.Hw;
        int i2 = i + 1;
        i = this.DW[i] - 48;
        while (true) {
            int i3 = i2 + 1;
            byte b = this.DW[i2];
            if (32 == b) {
                break;
            }
            i = (i << 3) + (b - 48);
            i2 = i3;
        }
        this.u7 = i;
        i = this.EQ;
        while (true) {
            i2 = i3 + 1;
            byte b2 = this.DW[i3];
            if (b2 == null) {
                this.we = i;
                this.J0 = i2 + 20;
                return;
            }
            try {
                this.tp[i] = b2;
            } catch (ArrayIndexOutOfBoundsException e) {
                FH(i);
                this.tp[i] = b2;
            }
            i++;
            i3 = i2;
        }
    }
}
