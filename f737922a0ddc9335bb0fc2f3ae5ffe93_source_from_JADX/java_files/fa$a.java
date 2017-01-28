import java.io.CharArrayReader;
import java.io.Reader;

class fa$a {
    private int DW;
    private char[] j6;

    private fa$a() {
        this.j6 = new char[100];
        this.DW = 0;
    }

    public void j6() {
        for (int i = this.DW - 1; i >= 0; i--) {
            if (this.j6[i] == '[') {
                this.j6[i] = '.';
                this.j6[i + 1] = '.';
                this.j6[i + 2] = '.';
                return;
            }
        }
    }

    public boolean j6(String str) {
        if (str.length() != this.DW) {
            return false;
        }
        for (int i = 0; i < this.DW; i++) {
            if (this.j6[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public void DW() {
        this.DW = 0;
    }

    public boolean FH() {
        return this.DW == 0;
    }

    public void j6(fa$a fa_a) {
        int i = this.DW + fa_a.DW;
        if (this.j6.length <= i) {
            Object obj = new char[Math.max(this.DW * 2, i)];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
        System.arraycopy(fa_a.j6, 0, this.j6, this.DW, fa_a.DW);
        this.DW += fa_a.DW;
    }

    public void j6(int i) {
        DW(Integer.toString(i));
    }

    public void DW(String str) {
        int i = 0;
        int length = this.DW + str.length();
        if (this.j6.length <= length) {
            Object obj = new char[Math.max(this.DW * 2, length)];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
        while (i < str.length()) {
            char[] cArr = this.j6;
            int i2 = this.DW;
            this.DW = i2 + 1;
            cArr[i2] = str.charAt(i);
            i++;
        }
    }

    public void j6(char[] cArr, int i, int i2) {
        int i3 = this.DW + i2;
        if (this.j6.length <= i3) {
            Object obj = new char[Math.max(this.DW * 2, i3)];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
        for (i3 = i; i3 < i + i2; i3++) {
            char[] cArr2 = this.j6;
            int i4 = this.DW;
            this.DW = i4 + 1;
            cArr2[i4] = cArr[i3];
        }
    }

    public void DW(char[] cArr, int i, int i2) {
        int i3 = this.DW + (i2 * 6);
        if (this.j6.length <= i3) {
            Object obj = new char[Math.max(this.DW * 2, i3)];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
        for (int i4 = i; i4 < i + i2; i4++) {
            char c = cArr[i4];
            char[] cArr2;
            int i5;
            switch (c) {
                case '\t':
                    cArr2 = this.j6;
                    i5 = this.DW;
                    this.DW = i5 + 1;
                    cArr2[i5] = '\\';
                    cArr2 = this.j6;
                    i5 = this.DW;
                    this.DW = i5 + 1;
                    cArr2[i5] = 't';
                    break;
                case '\n':
                    cArr2 = this.j6;
                    i5 = this.DW;
                    this.DW = i5 + 1;
                    cArr2[i5] = '\\';
                    cArr2 = this.j6;
                    i5 = this.DW;
                    this.DW = i5 + 1;
                    cArr2[i5] = 'n';
                    break;
                case '\r':
                    cArr2 = this.j6;
                    i5 = this.DW;
                    this.DW = i5 + 1;
                    cArr2[i5] = '\\';
                    cArr2 = this.j6;
                    i5 = this.DW;
                    this.DW = i5 + 1;
                    cArr2[i5] = 'r';
                    break;
                case '\"':
                    cArr2 = this.j6;
                    i5 = this.DW;
                    this.DW = i5 + 1;
                    cArr2[i5] = '\\';
                    cArr2 = this.j6;
                    i5 = this.DW;
                    this.DW = i5 + 1;
                    cArr2[i5] = '\"';
                    break;
                default:
                    char[] cArr3;
                    int i6;
                    if (!Character.isISOControl(c)) {
                        cArr3 = this.j6;
                        i6 = this.DW;
                        this.DW = i6 + 1;
                        cArr3[i6] = c;
                        break;
                    }
                    String toHexString = Integer.toHexString(c);
                    if (toHexString.length() == 1) {
                        toHexString = "000" + toHexString;
                    } else if (toHexString.length() == 2) {
                        toHexString = "00" + toHexString;
                    } else if (toHexString.length() == 3) {
                        toHexString = "0" + toHexString;
                    }
                    cArr3 = this.j6;
                    i6 = this.DW;
                    this.DW = i6 + 1;
                    cArr3[i6] = '\\';
                    cArr3 = this.j6;
                    i6 = this.DW;
                    this.DW = i6 + 1;
                    cArr3[i6] = 'u';
                    cArr3 = this.j6;
                    i6 = this.DW;
                    this.DW = i6 + 1;
                    cArr3[i6] = toHexString.charAt(0);
                    cArr3 = this.j6;
                    i6 = this.DW;
                    this.DW = i6 + 1;
                    cArr3[i6] = toHexString.charAt(1);
                    cArr3 = this.j6;
                    i6 = this.DW;
                    this.DW = i6 + 1;
                    cArr3[i6] = toHexString.charAt(2);
                    cArr3 = this.j6;
                    i6 = this.DW;
                    this.DW = i6 + 1;
                    cArr3[i6] = toHexString.charAt(3);
                    break;
            }
        }
    }

    public int Hw() {
        return this.DW;
    }

    public String toString() {
        return new String(this.j6, 0, this.DW);
    }

    public Reader v5() {
        return new CharArrayReader(this.j6, 0, this.DW);
    }
}
