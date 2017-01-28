import java.nio.charset.Charset;

public class aqc extends aqg {
    static final aqc[] gn;
    int EQ;
    private byte[] J0;
    private aqk VH;
    int tp;
    aqc[] u7;

    static {
        gn = new aqc[0];
    }

    protected aqc(anb anb) {
        super(anb);
    }

    void j6(aql aql) {
        j6(aql, aql.v5((aqg) this));
    }

    void DW(aql aql) {
        if (this.J0 == null) {
            this.J0 = aql.v5((aqg) this);
            if ((this.we & 1) == 0) {
                j6(aql, this.J0);
            }
        }
    }

    void j6(aql aql, byte[] bArr) {
        int i;
        int i2;
        anb anb = aql.FH;
        anb.v5(bArr, 5);
        this.VH = aql.FH(anb);
        if (this.u7 == null) {
            Object obj;
            i = 46;
            aqc[] aqcArr = new aqc[1];
            i2 = 0;
            while (bArr[i] == 112) {
                anb.v5(bArr, i + 7);
                aqc Hw = aql.Hw(anb);
                int i3;
                if (i2 == 0) {
                    i3 = i2 + 1;
                    aqcArr[i2] = Hw;
                    i2 = i3;
                } else if (i2 == 1) {
                    aqcArr = new aqc[]{aqcArr[0], Hw};
                    i2 = 2;
                } else {
                    if (aqcArr.length <= i2) {
                        obj = new aqc[(aqcArr.length + 32)];
                        System.arraycopy(aqcArr, 0, obj, 0, i2);
                        aqcArr = obj;
                    }
                    i3 = i2 + 1;
                    aqcArr[i2] = Hw;
                    i2 = i3;
                }
                i += 48;
            }
            if (i2 != aqcArr.length) {
                obj = new aqc[i2];
                System.arraycopy(aqcArr, 0, obj, 0, i2);
                aqcArr = obj;
            }
            this.u7 = aqcArr;
        } else {
            i = 46;
        }
        i2 = axe.VH(bArr, i);
        if (i2 > 0) {
            this.tp = axe.j6(bArr, axe.DW(bArr, i2, '>'), null);
        }
        if (aql.Ws()) {
            this.J0 = bArr;
        }
        this.we |= 1;
    }

    public final int v_() {
        return 1;
    }

    static void j6(aqc aqc, int i) {
        while (true) {
            aqc[] aqcArr = aqc.u7;
            if (aqcArr != null) {
                int length = aqcArr.length;
                if (length != 0) {
                    for (int i2 = 1; i2 < length; i2++) {
                        aqc aqc2 = aqcArr[i2];
                        if ((aqc2.we & i) != i) {
                            aqc2.we |= i;
                            j6(aqc2, i);
                        }
                    }
                    aqc = aqcArr[0];
                    if ((aqc.we & i) != i) {
                        aqc.we |= i;
                    } else {
                        return;
                    }
                }
                return;
            }
            return;
        }
    }

    public void j6(aqe aqe) {
        int i = this.we & aqe.Hw;
        if (i != 0) {
            j6(this, i);
        }
    }

    public final int gn() {
        return this.tp;
    }

    public final aqk u7() {
        return this.VH;
    }

    public final int tp() {
        return this.u7.length;
    }

    public final aqc DW(int i) {
        return this.u7[i];
    }

    public final aqc[] EQ() {
        return this.u7;
    }

    public final aoa we() {
        byte[] bArr = this.J0;
        int Zo = axe.Zo(bArr, 0);
        if (Zo < 0) {
            return null;
        }
        return axe.u7(bArr, Zo);
    }

    public final String J0() {
        byte[] bArr = this.J0;
        int EQ = axe.EQ(bArr, 0);
        if (EQ < 0) {
            return "";
        }
        return axe.j6(axe.j6(bArr), bArr, EQ, bArr.length);
    }

    public final String J8() {
        byte[] bArr = this.J0;
        int EQ = axe.EQ(bArr, 0);
        if (EQ < 0) {
            return "";
        }
        Charset j6 = axe.j6(bArr);
        int J0 = axe.J0(bArr, EQ);
        String j62 = axe.j6(j6, bArr, EQ, J0);
        if (j6(bArr, EQ, J0)) {
            return j62.replace('\n', ' ');
        }
        return j62;
    }

    static boolean j6(byte[] bArr, int i, int i2) {
        while (i < i2) {
            int i3 = i + 1;
            if (bArr[i] == 10) {
                return true;
            }
            i = i3;
        }
        return false;
    }

    public void Ws() {
        this.EQ = 0;
    }

    final void QX() {
        this.J0 = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(anj.j6(v_()));
        stringBuilder.append(' ');
        stringBuilder.append(DW());
        stringBuilder.append(' ');
        stringBuilder.append(this.tp);
        stringBuilder.append(' ');
        j6(stringBuilder);
        return stringBuilder.toString();
    }
}
