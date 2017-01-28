import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;

public class akv {
    private static final akv[] DW;
    private static final Comparator<akv> FH;
    private static final byte[] j6;
    private akv Hw;
    private ans VH;
    private int Zo;
    private akv[] gn;
    private int u7;
    private byte[] v5;

    static {
        j6 = new byte[0];
        DW = new akv[0];
        FH = new akv$1();
    }

    akv() {
        this.v5 = j6;
        this.gn = DW;
        this.u7 = 0;
        this.Zo = -1;
    }

    private akv(akv akv, byte[] bArr, int i, int i2) {
        this.Hw = akv;
        this.v5 = new byte[i2];
        System.arraycopy(bArr, i, this.v5, 0, i2);
        this.gn = DW;
        this.u7 = 0;
        this.Zo = -1;
    }

    akv(byte[] bArr, axa axa, akv akv) {
        this.Hw = akv;
        int j6 = axe.j6(bArr, axa.j6, '\u0000');
        int i = (j6 - axa.j6) - 1;
        if (i > 0) {
            this.v5 = new byte[i];
            System.arraycopy(bArr, axa.j6, this.v5, 0, i);
        } else {
            this.v5 = j6;
        }
        this.Zo = axe.j6(bArr, j6, axa);
        int j62 = axe.j6(bArr, axa.j6, axa);
        axa.j6 = axe.j6(bArr, axa.j6, '\n');
        if (this.Zo >= 0) {
            this.VH = ans.Hw(bArr, axa.j6);
            axa.j6 += 20;
        }
        if (j62 > 0) {
            char c = '\u0001';
            this.gn = new akv[j62];
            i = 0;
            while (i < j62) {
                this.gn[i] = new akv(bArr, axa, this);
                if (c != '\u0000' && i > 0 && FH.compare(this.gn[i - 1], this.gn[i]) > 0) {
                    c = '\u0000';
                }
                i++;
            }
            if (c == '\u0000') {
                Arrays.sort(this.gn, 0, j62, FH);
            }
        } else {
            this.gn = DW;
        }
        this.u7 = j62;
    }

    void j6(byte[] bArr, OutputStream outputStream) {
        int length = bArr.length - 1;
        bArr[length] = (byte) 10;
        int j6 = axe.j6(bArr, length, this.u7) - 1;
        bArr[j6] = (byte) 32;
        length = axe.j6(bArr, j6, j6() ? this.Zo : -1) - 1;
        bArr[length] = (byte) 0;
        outputStream.write(this.v5);
        outputStream.write(bArr, length, bArr.length - length);
        if (j6()) {
            this.VH.DW(bArr, 0);
            outputStream.write(bArr, 0, 20);
        }
        for (length = 0; length < this.u7; length++) {
            this.gn[length].j6(bArr, outputStream);
        }
    }

    public boolean j6() {
        return this.VH != null;
    }

    public int DW() {
        return this.Zo;
    }

    public int FH() {
        return this.u7;
    }

    public akv j6(int i) {
        return this.gn[i];
    }

    ans Hw() {
        return this.VH;
    }

    ans j6(akt[] aktArr, int i, int i2, anw anw) {
        if (this.VH == null) {
            int i3 = i + this.Zo;
            aoo aoo = new aoo(DW(aktArr, i, i2, anw));
            int i4 = 0;
            while (i < i3) {
                akt akt = aktArr[i];
                byte[] bArr = akt.j6;
                if (i4 < this.u7) {
                    akv akv = this.gn[i4];
                    if (akv.j6(bArr, i2, bArr.length)) {
                        aoo.j6(akv.v5, anl.j6, akv.VH);
                        i += akv.Zo;
                        i4++;
                    }
                }
                aoo.j6(bArr, i2, bArr.length - i2, akt.tp(), akt.FH(), akt.Hw());
                i++;
            }
            this.VH = anw.j6(aoo);
        }
        return this.VH;
    }

    private int DW(akt[] aktArr, int i, int i2, anw anw) {
        int i3 = 0;
        int i4 = i + this.Zo;
        int i5 = 0;
        while (i < i4) {
            akt akt = aktArr[i];
            if (akt.VH() != 0) {
                throw new amc(akt);
            }
            byte[] bArr = akt.j6;
            if (i5 < this.u7) {
                akv akv = this.gn[i5];
                if (akv.j6(bArr, i2, bArr.length)) {
                    akv.j6(aktArr, i, (akv.v5() + i2) + 1, anw);
                    i3 += aoo.j6(anl.j6, akv.v5());
                    i += akv.Zo;
                    i5++;
                }
            }
            i3 += aoo.j6(akt.tp(), bArr.length - i2);
            i++;
        }
        return i3;
    }

    final int v5() {
        return this.v5.length;
    }

    final boolean j6(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.v5;
        int length = bArr2.length;
        int i3 = 0;
        while (i3 < length && i < i2) {
            if (bArr2[i3] != bArr[i]) {
                return false;
            }
            i3++;
            i++;
        }
        if (i != i2 && bArr[i] == 47) {
            return true;
        }
        return false;
    }

    void j6(akt[] aktArr, int i, int i2, int i3) {
        if (this.Zo < 0) {
            this.Zo = 0;
            if (i != 0) {
                byte[] bArr = aktArr[i2].j6;
                int i4 = 0;
                while (i2 < i) {
                    byte[] bArr2 = aktArr[i2].j6;
                    if (i3 > 0 && !j6(bArr, bArr2, i3)) {
                        break;
                    }
                    akv akv = i4 < this.u7 ? this.gn[i4] : null;
                    int j6 = j6(bArr2, i3, akv);
                    if (j6 > 0) {
                        DW(i4);
                    } else {
                        if (j6 < 0) {
                            j6 = j6(bArr2, i3);
                            if (j6 < 0) {
                                i2++;
                                this.Zo++;
                            } else {
                                akv = new akv(this, bArr2, i3, j6 - i3);
                                j6(i4, akv);
                            }
                        }
                        akv.j6(aktArr, i, i2, (akv.v5() + i3) + 1);
                        i2 += akv.Zo;
                        this.Zo = akv.Zo + this.Zo;
                        i4++;
                    }
                }
                while (i4 < this.u7) {
                    DW(this.u7 - 1);
                }
            }
        }
    }

    private void j6(int i, akv akv) {
        Object obj = this.gn;
        if (this.u7 + 1 <= obj.length) {
            if (i < this.u7) {
                System.arraycopy(obj, i, obj, i + 1, this.u7 - i);
            }
            obj[i] = akv;
            this.u7++;
            return;
        }
        int length = obj.length;
        Object obj2 = new akv[(length + 1)];
        if (i > 0) {
            System.arraycopy(obj, 0, obj2, 0, i);
        }
        obj2[i] = akv;
        if (i < length) {
            System.arraycopy(obj, i, obj2, i + 1, length - i);
        }
        this.gn = obj2;
        this.u7++;
    }

    private void DW(int i) {
        int i2 = this.u7 - 1;
        this.u7 = i2;
        if (i < i2) {
            System.arraycopy(this.gn, i + 1, this.gn, i, i2 - i);
        }
        this.gn[i2] = null;
    }

    static boolean j6(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length < i) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static int j6(byte[] bArr, int i, akv akv) {
        int i2 = 0;
        if (akv == null) {
            return -1;
        }
        byte[] bArr2 = akv.v5;
        int length = bArr.length;
        int length2 = bArr2.length;
        int i3 = 0;
        while (i < length && i3 < length2) {
            int i4 = (bArr[i] & 255) - (bArr2[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
            i++;
            i3++;
        }
        if (i3 != length2) {
            return length - length2;
        }
        if (bArr[i] != 47) {
            i2 = -1;
        }
        return i2;
    }

    private static int j6(byte[] bArr, int i) {
        int length = bArr.length;
        for (int i2 = i; i2 < length; i2++) {
            if (bArr[i2] == 47) {
                return i2;
            }
        }
        return -1;
    }
}
