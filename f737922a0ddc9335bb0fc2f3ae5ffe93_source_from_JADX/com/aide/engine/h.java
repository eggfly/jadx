package com.aide.engine;

import java.lang.reflect.Array;

public class h {
    private byte[][] j6;

    public h() {
        this.j6 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{100, 5});
    }

    public void j6(int i, h hVar, int i2) {
        if (hVar.j6.length > i2) {
            j6(i);
            Object obj = new byte[hVar.j6[i2].length];
            System.arraycopy(hVar.j6[i2], 0, obj, 0, obj.length);
            this.j6[i] = obj;
        }
    }

    public void j6(f[] fVarArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        j6();
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (fVarArr[i2] != null) {
                j6((byte) fVarArr[i2].ordinal(), iArr[i2] - 1, iArr2[i2] - 1, iArr3[i2] - 1, iArr4[i2] - 2);
            }
        }
    }

    public void j6(int i, int i2, int i3, int i4) {
        if (i == i3) {
            j6(i, i2, (i4 - i2) + 1);
            return;
        }
        for (int i5 = i; i5 < i3; i5++) {
            FH(i, i2);
        }
        j6(i3, 0, i4 + 1);
    }

    private void FH(int i, int i2) {
        if (this.j6.length > i + 2) {
            System.arraycopy(this.j6, i + 1, this.j6, i + 2, (this.j6.length - i) - 2);
            byte[] bArr = this.j6[i];
            byte[] bArr2 = new byte[bArr.length];
            this.j6[i + 1] = bArr2;
            if (bArr.length > i2) {
                byte b = bArr[i2];
                int i3 = 0;
                while (i2 < bArr.length) {
                    bArr2[i3] = bArr[i2];
                    bArr[i2] = b;
                    i2++;
                    i3++;
                }
            }
        }
    }

    private void j6(int i, int i2, int i3) {
        byte b = (byte) 0;
        if (i3 != 0 && this.j6.length > i) {
            int DW = DW(i);
            if (DW > i2) {
                byte b2;
                if (DW - 1 == i2 && i2 > 0) {
                    DW(i, DW + 1);
                    byte[] bArr = this.j6[i];
                    b2 = bArr[i2 - 1];
                    if (b2 == f.COMMENT.ordinal() + 1) {
                        bArr[i2] = b2;
                        return;
                    }
                }
                DW(i, DW + i3);
                Object obj = this.j6[i];
                System.arraycopy(obj, i2, obj, i2 + i3, (obj.length - i2) - i3);
                byte b3 = i2 > 0 ? obj[i2 - 1] : (byte) 0;
                b2 = obj[i2];
                if (b2 >= f.SCRIPT.ordinal() + 1) {
                    b = (byte) (f.SCRIPT.ordinal() + 1);
                }
                if (b3 != b2 || b3 == f.OPERATOR.ordinal() + 1 || b3 == f.SEPARATOR.ordinal() + 1) {
                    b3 = b;
                }
                for (int i4 = i2; i4 < i2 + i3; i4++) {
                    obj[i4] = b3;
                }
            }
        }
    }

    private int DW(int i) {
        if (i >= this.j6.length) {
            return 0;
        }
        byte[] bArr = this.j6[i];
        if (bArr.length == 0) {
            return 0;
        }
        byte b = bArr[bArr.length - 1];
        for (int length = bArr.length - 2; length >= 0; length--) {
            if (bArr[length] != b) {
                return length + 2;
            }
        }
        return 0;
    }

    public void DW(int i, int i2, int i3, int i4) {
        if (i != i3) {
            int i5;
            if (i3 < this.j6.length) {
                DW(i, DW(i) + DW(i3));
                byte[] bArr = this.j6[i];
                byte[] bArr2 = this.j6[i3];
                i5 = i4 + 1;
                while (i5 < bArr2.length && i2 < bArr.length) {
                    bArr[i2] = bArr2[i5];
                    i5++;
                    i2++;
                }
            }
            if (i3 + 1 < this.j6.length) {
                System.arraycopy(this.j6, i3 + 1, this.j6, i + 1, (this.j6.length - i3) - 2);
                int i6 = i3 - i;
                for (i5 = 0; i5 < i6; i5++) {
                    this.j6[(this.j6.length - i5) - 1] = new byte[5];
                }
            }
        } else if (i < this.j6.length) {
            Object obj = this.j6[i];
            if (i4 + 1 < obj.length) {
                System.arraycopy(obj, i4 + 1, obj, i2, (obj.length - i4) - 1);
            }
        }
    }

    public byte j6(int i, int i2) {
        if (i >= this.j6.length) {
            return (byte) 0;
        }
        byte[] bArr = this.j6[i];
        if (i2 >= bArr.length) {
            return bArr[bArr.length - 1];
        }
        return bArr[i2];
    }

    public void j6(byte b, int i, int i2, int i3, int i4) {
        int i5 = 0;
        byte[] bArr;
        if (i == i3) {
            DW(i3, i4 + 1);
            bArr = this.j6[i3];
            while (i2 <= i4) {
                if (bArr[i2] >= f.SCRIPT.ordinal() + 1) {
                    bArr[i2] = (byte) (f.values().length + b);
                } else {
                    bArr[i2] = b;
                }
                i2++;
            }
            return;
        }
        DW(i, i2 + 1);
        DW(i3, i4 + 1);
        bArr = this.j6[i];
        while (i2 < bArr.length) {
            if (bArr[i2] >= f.SCRIPT.ordinal() + 1) {
                bArr[i2] = (byte) (f.values().length + b);
            } else {
                bArr[i2] = b;
            }
            i2++;
        }
        for (int i6 = i + 1; i6 < i3; i6++) {
            byte[] bArr2 = this.j6[i6];
            for (int i7 = 0; i7 < bArr2.length; i7++) {
                if (bArr2[i7] >= f.SCRIPT.ordinal() + 1) {
                    bArr2[i7] = (byte) (f.values().length + b);
                } else {
                    bArr2[i7] = b;
                }
            }
        }
        bArr = this.j6[i3];
        while (i5 <= i4) {
            if (bArr[i5] >= f.SCRIPT.ordinal() + 1) {
                bArr[i5] = (byte) (f.values().length + b);
            } else {
                bArr[i5] = b;
            }
            i5++;
        }
    }

    public void j6() {
        for (byte[] bArr : this.j6) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) 0;
            }
        }
    }

    public void DW(int i, int i2) {
        j6(i);
        Object obj = this.j6[i];
        if (obj.length <= i2) {
            byte b = obj[obj.length - 1];
            Object obj2 = new byte[(((i2 * 5) / 4) + 1)];
            System.arraycopy(obj, 0, obj2, 0, obj.length);
            this.j6[i] = obj2;
            for (int length = obj.length; length < obj2.length; length++) {
                obj2[length] = b;
            }
        }
    }

    public void j6(int i) {
        if (this.j6.length <= i) {
            byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{(i * 5) / 4, 5});
            System.arraycopy(this.j6, 0, bArr, 0, this.j6.length);
            this.j6 = bArr;
        }
    }
}
