public class aoo {
    private int DW;
    private axj$c FH;
    private byte[] j6;

    public static int j6(anl anl, int i) {
        return ((anl.j6() + i) + 20) + 2;
    }

    public aoo() {
        this(8192);
    }

    public aoo(int i) {
        this.j6 = new byte[i];
    }

    public void j6(byte[] bArr, anl anl, anb anb) {
        j6(bArr, 0, bArr.length, anl, anb);
    }

    public void j6(byte[] bArr, int i, int i2, anl anl, anb anb) {
        if (j6(bArr, i, i2, anl)) {
            anb.DW(this.j6, this.DW);
            this.DW += 20;
            return;
        }
        try {
            DW(bArr, i, i2, anl);
            anb.j6(this.FH);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void j6(byte[] bArr, int i, int i2, anl anl, byte[] bArr2, int i3) {
        if (j6(bArr, i, i2, anl)) {
            System.arraycopy(bArr2, i3, this.j6, this.DW, 20);
            this.DW += 20;
            return;
        }
        try {
            DW(bArr, i, i2, anl);
            this.FH.write(bArr2, i3, 20);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private boolean j6(byte[] bArr, int i, int i2, anl anl) {
        if (this.j6 == null || this.j6.length < this.DW + j6(anl, i2)) {
            return false;
        }
        anl.j6(this.j6, this.DW);
        this.DW += anl.j6();
        byte[] bArr2 = this.j6;
        int i3 = this.DW;
        this.DW = i3 + 1;
        bArr2[i3] = (byte) 32;
        System.arraycopy(bArr, i, this.j6, this.DW, i2);
        this.DW += i2;
        bArr2 = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        bArr2[i3] = (byte) 0;
        return true;
    }

    private void DW(byte[] bArr, int i, int i2, anl anl) {
        if (this.j6 != null) {
            this.FH = new axj$c(Integer.MAX_VALUE);
            this.FH.write(this.j6, 0, this.DW);
            this.j6 = null;
        }
        anl.j6(this.FH);
        this.FH.write(32);
        this.FH.write(bArr, i, i2);
        this.FH.write(0);
    }

    public ans j6(anw anw) {
        if (this.j6 != null) {
            return anw.DW(2, this.j6, 0, this.DW);
        }
        return anw.j6(2, this.FH.DW(), this.FH.Hw());
    }

    public byte[] j6() {
        if (this.j6 != null) {
            Object obj = new byte[this.DW];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            return obj;
        }
        try {
            return this.FH.FH();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        byte[] j6 = j6();
        avy avy = new avy();
        avy.j6(j6);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tree={");
        if (!avy.u7()) {
            stringBuilder.append('\n');
            try {
                new anq().FH(j6);
            } catch (ala e) {
                stringBuilder.append("*** ERROR: ").append(e.getMessage()).append("\n");
                stringBuilder.append('\n');
            }
        }
        while (!avy.u7()) {
            anl we = avy.we();
            stringBuilder.append(we);
            stringBuilder.append(' ');
            stringBuilder.append(anj.j6(we.DW()));
            stringBuilder.append(' ');
            stringBuilder.append(avy.EQ().DW());
            stringBuilder.append(' ');
            stringBuilder.append(avy.J8());
            stringBuilder.append('\n');
            avy.tp();
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
