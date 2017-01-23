import java.io.CharArrayReader;
import java.io.Reader;

public class er {
    protected int DW;
    protected int FH;
    private final cc Hw;
    protected char[] j6;

    public er(cc ccVar) {
        this.j6 = new char[100];
        this.DW = 0;
        this.FH = 0;
        this.Hw = ccVar;
    }

    public boolean j6(String str, int i) {
        if (str.length() + i > this.DW) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (this.j6[i + i2] != str.charAt(i2)) {
                return false;
            }
        }
        return true;
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

    public int DW(String str) {
        int i = 0;
        while (i <= this.DW - str.length()) {
            int i2 = 0;
            while (i2 < str.length()) {
                if (this.j6[i + i2] != str.charAt(i2)) {
                    i++;
                } else {
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    public void j6() {
        this.DW = 0;
        this.FH = 0;
    }

    public void j6(er erVar) {
        DW(erVar.DW);
        System.arraycopy(erVar.j6, 0, this.j6, this.DW, erVar.DW);
        this.DW += erVar.DW;
        this.FH += erVar.FH;
    }

    public void j6(er erVar, int i, int i2) {
        DW(i2);
        System.arraycopy(erVar.j6, i, this.j6, this.DW, i2);
        int i3 = this.DW + i2;
        int i4 = this.DW;
        while (i4 < i3) {
            if (this.j6[i4] == '\ufffe') {
                i4 += 8;
            } else {
                this.FH++;
            }
            i4++;
        }
        this.DW = i3;
    }

    public void DW() {
        j6(0, 0);
    }

    public void j6(int i, int i2) {
        DW(9);
        char[] cArr = this.j6;
        int i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = '\ufffe';
        cArr = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = (char) ((i >>> 24) & 255);
        cArr = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = (char) ((i >>> 16) & 255);
        cArr = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = (char) ((i >>> 8) & 255);
        cArr = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = (char) ((i >>> 0) & 255);
        cArr = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = (char) ((i2 >>> 24) & 255);
        cArr = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = (char) ((i2 >>> 16) & 255);
        cArr = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = (char) ((i2 >>> 8) & 255);
        cArr = this.j6;
        i3 = this.DW;
        this.DW = i3 + 1;
        cArr[i3] = (char) ((i2 >>> 0) & 255);
    }

    public void FH(String str) {
        DW(str.length());
        for (int i = 0; i < str.length(); i++) {
            char[] cArr = this.j6;
            int i2 = this.DW;
            this.DW = i2 + 1;
            cArr[i2] = str.charAt(i);
            this.FH++;
        }
    }

    public void j6(char[] cArr, int i, int i2) {
        DW(i2);
        int i3 = i + i2;
        while (i < i3) {
            char[] cArr2 = this.j6;
            int i4 = this.DW;
            this.DW = i4 + 1;
            cArr2[i4] = cArr[i];
            this.FH++;
            i++;
        }
    }

    public void j6(char c) {
        DW(1);
        char[] cArr = this.j6;
        int i = this.DW;
        this.DW = i + 1;
        cArr[i] = c;
        this.FH++;
    }

    public int FH() {
        return this.DW;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.DW);
        int i = 0;
        while (i < this.DW) {
            char c = this.j6[i];
            if (c == '\ufffe') {
                i++;
                stringBuffer.append("#[");
                int i2 = (((this.j6[i + 4] << 24) | (this.j6[i + 5] << 16)) | (this.j6[i + 6] << 8)) | this.j6[i + 7];
                stringBuffer.append((((this.j6[i] << 24) | (this.j6[i + 1] << 16)) | (this.j6[i + 2] << 8)) | this.j6[i + 3]);
                stringBuffer.append(", ");
                stringBuffer.append(i2);
                stringBuffer.append("]");
                i += 7;
            } else {
                stringBuffer.append(c);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public Reader Hw() {
        return new CharArrayReader(this.j6, 0, this.DW);
    }

    public int v5() {
        return this.Hw.ro.j6(this.j6, 0, this.DW);
    }

    public void j6(int i) {
        int DW = this.Hw.ro.DW(i);
        DW(DW);
        this.Hw.ro.j6(i, this.j6, this.DW);
        this.DW += DW;
        this.FH = DW + this.FH;
    }

    public void Zo() {
        int i = 0;
        while (i < this.DW) {
            char c = this.j6[i];
            if (c == '\ufffe') {
                i += 8;
            } else {
                this.j6[i] = Character.toUpperCase(c);
            }
            i++;
        }
    }

    protected final void DW(int i) {
        if (this.DW + i >= this.j6.length) {
            int length = this.j6.length * 2;
            while (this.DW + i >= length) {
                length *= 2;
            }
            Object obj = new char[length];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
    }
}
