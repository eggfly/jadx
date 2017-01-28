import java.io.CharArrayReader;
import java.io.Reader;

class cl$a {
    private char[] DW;
    private char[] j6;

    private cl$a() {
        this.j6 = new char[10000];
        this.DW = new char[10000];
    }

    public Reader j6(Reader reader, String str, int i, int i2) {
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int read = reader.read(this.j6);
            if (read == -1) {
                reader.close();
                return new CharArrayReader(this.DW, 0, i5);
            }
            int i6 = 0;
            while (i6 < read) {
                int i7;
                if (i3 == i && i4 == i2) {
                    j6(str.length() + i5);
                    i7 = i5;
                    i5 = 0;
                    while (i5 < str.length()) {
                        int i8 = i7 + 1;
                        this.DW[i7] = str.charAt(i5);
                        i5++;
                        i7 = i8;
                    }
                    i5 = i7;
                }
                char c = this.j6[i6];
                int i9;
                switch (c) {
                    case '\n':
                        if (i3 == i && i4 < i2) {
                            i9 = i2 - i4;
                            j6((str.length() + i5) + i9);
                            i4 = i5;
                            i5 = 0;
                            while (i5 < i9) {
                                i7 = i4 + 1;
                                this.DW[i4] = ' ';
                                i5++;
                                i4 = i7;
                            }
                            i5 = 0;
                            while (i5 < str.length()) {
                                i7 = i4 + 1;
                                this.DW[i4] = str.charAt(i5);
                                i5++;
                                i4 = i7;
                            }
                            i5 = i4;
                        }
                        j6(i5 + 1);
                        i4 = i5 + 1;
                        this.DW[i5] = c;
                        i7 = i3 + 1;
                        i3 = 1;
                        i5 = i6;
                        break;
                    case '\ufffe':
                        j6(i5 + 10);
                        i3 = i5 + 1;
                        this.DW[i5] = c;
                        char[] cArr = this.DW;
                        i7 = i3 + 1;
                        i9 = i6 + 1;
                        c = this.j6[i6];
                        cArr[i3] = c;
                        i5 = 0 | (c << 24);
                        cArr = this.DW;
                        i3 = i7 + 1;
                        i6 = i9 + 1;
                        c = this.j6[i9];
                        cArr[i7] = c;
                        i5 |= c << 16;
                        cArr = this.DW;
                        i7 = i3 + 1;
                        i9 = i6 + 1;
                        c = this.j6[i6];
                        cArr[i3] = c;
                        i5 |= c << 8;
                        cArr = this.DW;
                        i3 = i7 + 1;
                        i6 = i9 + 1;
                        c = this.j6[i9];
                        cArr[i7] = c;
                        i7 = i5 | (c << 0);
                        cArr = this.DW;
                        i8 = i3 + 1;
                        int i10 = i6 + 1;
                        char c2 = this.j6[i6];
                        cArr[i3] = c2;
                        i5 = 0 | (c2 << 24);
                        cArr = this.DW;
                        i3 = i8 + 1;
                        i9 = i10 + 1;
                        c2 = this.j6[i10];
                        cArr[i8] = c2;
                        i5 |= c2 << 16;
                        cArr = this.DW;
                        i8 = i3 + 1;
                        i10 = i9 + 1;
                        c2 = this.j6[i9];
                        cArr[i3] = c2;
                        i3 = i5 | (c2 << 8);
                        char[] cArr2 = this.DW;
                        i4 = i8 + 1;
                        i5 = i10 + 1;
                        char c3 = this.j6[i10];
                        cArr2[i8] = c3;
                        i3 |= c3 << 0;
                        break;
                    default:
                        j6(i5 + 1);
                        i7 = i5 + 1;
                        this.DW[i5] = c;
                        i5 = i4 + 1;
                        i4 = i7;
                        i7 = i3;
                        i3 = i5;
                        i5 = i6;
                        break;
                }
                i6 = i5 + 1;
                i5 = i4;
                i4 = i3;
                i3 = i7;
            }
        }
    }

    private void j6(int i) {
        if (this.DW.length <= i) {
            Object obj = new char[Math.max(i, (this.DW.length * 2) + 1)];
            System.arraycopy(this.DW, 0, obj, 0, this.DW.length);
            this.DW = obj;
        }
    }
}
