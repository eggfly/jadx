import java.io.Writer;
import java.util.ArrayList;

public final class acv implements acr, acy {
    private byte[] DW;
    private int FH;
    private boolean Hw;
    private int VH;
    private int Zo;
    private final boolean j6;
    private ArrayList<acv$a> v5;

    public acv(byte[] bArr) {
        this(bArr, false);
    }

    public acv() {
        this(1000);
    }

    public acv(int i) {
        this(new byte[i], true);
    }

    private acv(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        this.j6 = z;
        this.DW = bArr;
        this.FH = 0;
        this.Hw = false;
        this.v5 = null;
        this.Zo = 0;
        this.VH = 0;
    }

    public byte[] v5() {
        return this.DW;
    }

    public byte[] Zo() {
        Object obj = new byte[this.FH];
        System.arraycopy(this.DW, 0, obj, 0, this.FH);
        return obj;
    }

    public int VH() {
        return this.FH;
    }

    public void j6(int i) {
        if (this.FH != i) {
            throw new ada("expected cursor " + i + "; actual value: " + this.FH);
        }
    }

    public void FH(int i) {
        int i2 = this.FH;
        int i3 = i2 + 1;
        if (this.j6) {
            u7(i3);
        } else if (i3 > this.DW.length) {
            u7();
            return;
        }
        this.DW[i2] = (byte) i;
        this.FH = i3;
    }

    public void DW(int i) {
        int i2 = this.FH;
        int i3 = i2 + 2;
        if (this.j6) {
            u7(i3);
        } else if (i3 > this.DW.length) {
            u7();
            return;
        }
        this.DW[i2] = (byte) i;
        this.DW[i2 + 1] = (byte) (i >> 8);
        this.FH = i3;
    }

    public void Hw(int i) {
        int i2 = this.FH;
        int i3 = i2 + 4;
        if (this.j6) {
            u7(i3);
        } else if (i3 > this.DW.length) {
            u7();
            return;
        }
        this.DW[i2] = (byte) i;
        this.DW[i2 + 1] = (byte) (i >> 8);
        this.DW[i2 + 2] = (byte) (i >> 16);
        this.DW[i2 + 3] = (byte) (i >> 24);
        this.FH = i3;
    }

    public void j6(long j) {
        int i = this.FH;
        int i2 = i + 8;
        if (this.j6) {
            u7(i2);
        } else if (i2 > this.DW.length) {
            u7();
            return;
        }
        int i3 = (int) j;
        this.DW[i] = (byte) i3;
        this.DW[i + 1] = (byte) (i3 >> 8);
        this.DW[i + 2] = (byte) (i3 >> 16);
        this.DW[i + 3] = (byte) (i3 >> 24);
        i3 = (int) (j >> 32);
        this.DW[i + 4] = (byte) i3;
        this.DW[i + 5] = (byte) (i3 >> 8);
        this.DW[i + 6] = (byte) (i3 >> 16);
        this.DW[i + 7] = (byte) (i3 >> 24);
        this.FH = i2;
    }

    public int v5(int i) {
        if (this.j6) {
            u7(this.FH + 5);
        }
        int i2 = this.FH;
        adk.j6(this, i);
        return this.FH - i2;
    }

    public int Zo(int i) {
        if (this.j6) {
            u7(this.FH + 5);
        }
        int i2 = this.FH;
        adk.DW(this, i);
        return this.FH - i2;
    }

    public void j6(acu acu) {
        int j6 = acu.j6();
        int i = this.FH;
        j6 += i;
        if (this.j6) {
            u7(j6);
        } else if (j6 > this.DW.length) {
            u7();
            return;
        }
        acu.j6(this.DW, i);
        this.FH = j6;
    }

    public void j6(byte[] bArr, int i, int i2) {
        int i3 = this.FH;
        int i4 = i3 + i2;
        int i5 = i + i2;
        if (((i | i2) | i4) < 0 || i5 > bArr.length) {
            throw new IndexOutOfBoundsException("bytes.length " + bArr.length + "; " + i + "..!" + i4);
        }
        if (this.j6) {
            u7(i4);
        } else if (i4 > this.DW.length) {
            u7();
            return;
        }
        System.arraycopy(bArr, i, this.DW, i3, i2);
        this.FH = i4;
    }

    public void j6(byte[] bArr) {
        j6(bArr, 0, bArr.length);
    }

    public void VH(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        int i2 = this.FH + i;
        if (this.j6) {
            u7(i2);
        } else if (i2 > this.DW.length) {
            u7();
            return;
        }
        this.FH = i2;
    }

    public void gn(int i) {
        int i2 = i - 1;
        if (i < 0 || (i2 & i) != 0) {
            throw new IllegalArgumentException("bogus alignment");
        }
        i2 = (i2 ^ -1) & (this.FH + i2);
        if (this.j6) {
            u7(i2);
        } else if (i2 > this.DW.length) {
            u7();
            return;
        }
        this.FH = i2;
    }

    public boolean j6() {
        return this.v5 != null;
    }

    public boolean DW() {
        return this.Hw;
    }

    public void j6(String str) {
        if (this.v5 != null) {
            FH();
            this.v5.add(new acv$a(this.FH, str));
        }
    }

    public void j6(int i, String str) {
        if (this.v5 != null) {
            FH();
            int size = this.v5.size();
            size = size == 0 ? 0 : ((acv$a) this.v5.get(size - 1)).DW();
            if (size <= this.FH) {
                size = this.FH;
            }
            this.v5.add(new acv$a(size, size + i, str));
        }
    }

    public void FH() {
        if (this.v5 != null) {
            int size = this.v5.size();
            if (size != 0) {
                ((acv$a) this.v5.get(size - 1)).j6(this.FH);
            }
        }
    }

    public int Hw() {
        return this.Zo - (((this.VH * 2) + 8) + (this.VH / 2));
    }

    public void j6(int i, boolean z) {
        int i2 = 6;
        if (this.v5 != null || this.FH != 0) {
            throw new RuntimeException("cannot enable annotations");
        } else if (i < 40) {
            throw new IllegalArgumentException("annotationWidth < 40");
        } else {
            int i3 = (((i - 7) / 15) + 1) & -2;
            if (i3 >= 6) {
                if (i3 > 10) {
                    i2 = 10;
                } else {
                    i2 = i3;
                }
            }
            this.v5 = new ArrayList(1000);
            this.Zo = i;
            this.VH = i2;
            this.Hw = z;
        }
    }

    public void gn() {
        FH();
        if (this.v5 != null) {
            int size = this.v5.size();
            while (size > 0) {
                acv$a acv_a = (acv$a) this.v5.get(size - 1);
                if (acv_a.j6() > this.FH) {
                    this.v5.remove(size - 1);
                    size--;
                } else if (acv_a.DW() > this.FH) {
                    acv_a.DW(this.FH);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void j6(Writer writer) {
        int Hw = Hw();
        adr adr = new adr(writer, (this.Zo - Hw) - 1, Hw, "|");
        Writer j6 = adr.j6();
        Writer DW = adr.DW();
        int size = this.v5.size();
        int i = 0;
        Hw = 0;
        while (Hw < this.FH && i < size) {
            String str;
            acv$a acv_a = (acv$a) this.v5.get(i);
            int j62 = acv_a.j6();
            if (Hw < j62) {
                str = "";
            } else {
                Hw = acv_a.DW();
                i++;
                str = acv_a.FH();
                int i2 = Hw;
                Hw = j62;
                j62 = i2;
            }
            j6.write(add.j6(this.DW, Hw, j62 - Hw, Hw, this.VH, 6));
            DW.write(str);
            adr.FH();
            Hw = j62;
        }
        if (Hw < this.FH) {
            j6.write(add.j6(this.DW, Hw, this.FH - Hw, Hw, this.VH, 6));
        }
        while (i < size) {
            DW.write(((acv$a) this.v5.get(i)).FH());
            i++;
        }
        adr.FH();
    }

    private static void u7() {
        throw new IndexOutOfBoundsException("attempt to write past the end");
    }

    private void u7(int i) {
        if (this.DW.length < i) {
            Object obj = new byte[((i * 2) + 1000)];
            System.arraycopy(this.DW, 0, obj, 0, this.FH);
            this.DW = obj;
        }
    }
}
