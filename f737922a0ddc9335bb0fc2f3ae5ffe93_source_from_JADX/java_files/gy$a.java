import com.aide.uidesigner.ProxyTextView;
import java.io.Reader;

class gy$a {
    private char[] DW;
    private int FH;
    private int Hw;
    private boolean Zo;
    private Reader j6;
    private int v5;

    private gy$a() {
        this.DW = new char[10000];
    }

    public void j6(Reader reader, boolean z) {
        this.Zo = z;
        this.j6 = reader;
        this.v5 = 0;
        this.Hw = 0;
        this.FH = 0;
    }

    public void j6() {
        this.j6 = null;
    }

    public int j6(int[] iArr, char[] cArr, int i, int i2) {
        Object obj = this.DW;
        int i3 = this.FH;
        int i4 = this.Hw;
        int i5 = this.v5;
        int i6 = i + i2;
        int i7 = i;
        while (i7 < i6) {
            char c;
            int i8;
            int i9;
            char digit;
            while (i3 >= i4) {
                i4 = this.j6.read(obj);
                if (i4 == -1) {
                    this.FH = i3;
                    this.Hw = i4;
                    this.v5 = i5;
                    if (i7 == i) {
                        return -1;
                    }
                    return i7 - i;
                }
                i3 = 0;
            }
            int min = (Math.min(i4 - i3, i6 - i7) + i7) - 1;
            int i10 = i7;
            int i11 = i3;
            while (i10 < min) {
                Object obj2;
                int i12;
                int i13;
                Object obj3;
                char c2 = obj[i11];
                if (c2 == '\\') {
                    i3 = i11 + 1;
                    c = obj[i11];
                    if (c != '\\') {
                        iArr[i10] = 1;
                        i7 = i10 + 1;
                        cArr[i10] = c;
                    } else if (i5 <= 0) {
                        iArr[i10] = 1;
                        i7 = i10 + 1;
                        cArr[i10] = c;
                        i5--;
                    } else {
                        obj2 = null;
                        i11 = 0;
                        i12 = i4;
                        i8 = i3;
                        i4 = 0;
                        i13 = i3;
                        i3 = 0;
                        i5 = i13;
                        while (true) {
                            if (i5 < i12) {
                                i5 = i12 - i8;
                                System.arraycopy(obj, i8, obj, 0, i5);
                                i7 = this.j6.read(obj, i5, obj.length - i5);
                                if (i7 != -1) {
                                    i7 = i5;
                                } else {
                                    i7 += i5;
                                }
                                i8 = 0;
                                i9 = i5;
                                i12 = i7;
                            } else {
                                i9 = i5;
                            }
                            switch (obj2) {
                                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                    switch (obj[i9]) {
                                        case '\\':
                                            i5 = i3;
                                            i3 = 1;
                                            i7 = i4;
                                            i4 = i11;
                                            break;
                                        case 'u':
                                            i5 = i3;
                                            i3 = 2;
                                            i7 = i4;
                                            i4 = i11;
                                            break;
                                        default:
                                            iArr[i10] = 1;
                                            i7 = i10 + 1;
                                            cArr[i10] = c;
                                            i5 = 0;
                                            i4 = i12;
                                            i3 = i8;
                                            continue;
                                            continue;
                                            continue;
                                            continue;
                                    }
                                case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    switch (obj[i9]) {
                                        case '\\':
                                            i5 = i3;
                                            obj3 = null;
                                            i7 = i4;
                                            i4 = i11;
                                            break;
                                        default:
                                            iArr[i10] = 1;
                                            i7 = i10 + 1;
                                            cArr[i10] = c;
                                            i5 = i9 - i8;
                                            i4 = i12;
                                            i3 = i8;
                                            continue;
                                            continue;
                                            continue;
                                            continue;
                                    }
                                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                    switch (obj[i9]) {
                                        case '0':
                                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                        case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                                        case 'B':
                                        case 'C':
                                        case 'D':
                                        case 'E':
                                        case 'F':
                                        case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                        case 'b':
                                        case 'c':
                                        case 'd':
                                        case 'e':
                                        case 'f':
                                            i13 = i4;
                                            i4 = Character.digit(obj[i9], 16);
                                            i7 = i13;
                                            int i14 = i3;
                                            i3 = 3;
                                            i5 = i14;
                                            break;
                                        case 'u':
                                            i5 = i3;
                                            i3 = 2;
                                            i7 = i4;
                                            i4 = i11;
                                            break;
                                        default:
                                            iArr[i10] = 1;
                                            i7 = i10 + 1;
                                            cArr[i10] = c;
                                            i5 = 0;
                                            i4 = i12;
                                            i3 = i8;
                                            continue;
                                            continue;
                                            continue;
                                            continue;
                                    }
                                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                    switch (obj[i9]) {
                                        case '0':
                                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                        case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                                        case 'B':
                                        case 'C':
                                        case 'D':
                                        case 'E':
                                        case 'F':
                                        case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                        case 'b':
                                        case 'c':
                                        case 'd':
                                        case 'e':
                                        case 'f':
                                            i3 = 4;
                                            i5 = Character.digit(obj[i9], 16);
                                            i7 = i4;
                                            i4 = i11;
                                            break;
                                        default:
                                            iArr[i10] = 1;
                                            i7 = i10 + 1;
                                            cArr[i10] = c;
                                            i5 = 0;
                                            i4 = i12;
                                            i3 = i8;
                                            continue;
                                            continue;
                                            continue;
                                            continue;
                                    }
                                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                                    switch (obj[i9]) {
                                        case '0':
                                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                        case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                                        case 'B':
                                        case 'C':
                                        case 'D':
                                        case 'E':
                                        case 'F':
                                        case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                        case 'b':
                                        case 'c':
                                        case 'd':
                                        case 'e':
                                        case 'f':
                                            i7 = Character.digit(obj[i9], 16);
                                            i4 = i11;
                                            i13 = i3;
                                            i3 = 5;
                                            i5 = i13;
                                            break;
                                        default:
                                            i7 = i10 + 1;
                                            cArr[i10] = c;
                                            i5 = 0;
                                            i4 = i12;
                                            i3 = i8;
                                            continue;
                                            continue;
                                            continue;
                                            continue;
                                    }
                                case 5:
                                    switch (obj[i9]) {
                                        case '0':
                                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                        case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                                        case 'B':
                                        case 'C':
                                        case 'D':
                                        case 'E':
                                        case 'F':
                                        case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                        case 'b':
                                        case 'c':
                                        case 'd':
                                        case 'e':
                                        case 'f':
                                            digit = (char) (Character.digit(obj[i9], 16) | (((i11 << 12) | (i3 << 8)) | (i4 << 4)));
                                            if (digit == '\n' && digit != '\r' && (!this.Zo || digit != '\ufffe')) {
                                                iArr[i10] = (i9 - i8) + 2;
                                                i7 = i10 + 1;
                                                cArr[i10] = digit;
                                                i4 = i12;
                                                i3 = i9 + 1;
                                                i5 = 0;
                                                break;
                                            }
                                            iArr[i10] = 1;
                                            i7 = i10 + 1;
                                            cArr[i10] = '\u0000';
                                            i4 = i12;
                                            i3 = i9 + 1;
                                            i5 = 0;
                                            break;
                                        default:
                                            i7 = i10 + 1;
                                            cArr[i10] = c;
                                            i5 = 0;
                                            i4 = i12;
                                            i3 = i8;
                                            continue;
                                            continue;
                                    }
                                default:
                                    i7 = i4;
                                    i5 = i3;
                                    i4 = i11;
                                    obj3 = obj2;
                                    break;
                            }
                            obj2 = obj3;
                            i3 = i5;
                            i5 = i9 + 1;
                            i11 = i4;
                            i4 = i7;
                        }
                    }
                } else {
                    iArr[i10] = 1;
                    i7 = i10 + 1;
                    cArr[i10] = c2;
                    i10 = i7;
                    i11++;
                }
            }
            i3 = i11 + 1;
            c = obj[i11];
            if (c != '\\') {
                iArr[i10] = 1;
                i7 = i10 + 1;
                cArr[i10] = c;
            } else if (i5 <= 0) {
                obj2 = null;
                i11 = 0;
                i12 = i4;
                i8 = i3;
                i4 = 0;
                i13 = i3;
                i3 = 0;
                i5 = i13;
                while (true) {
                    if (i5 < i12) {
                        i9 = i5;
                    } else {
                        i5 = i12 - i8;
                        System.arraycopy(obj, i8, obj, 0, i5);
                        i7 = this.j6.read(obj, i5, obj.length - i5);
                        if (i7 != -1) {
                            i7 += i5;
                        } else {
                            i7 = i5;
                        }
                        i8 = 0;
                        i9 = i5;
                        i12 = i7;
                    }
                    switch (obj2) {
                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                            switch (obj[i9]) {
                                case '\\':
                                    i5 = i3;
                                    i3 = 1;
                                    i7 = i4;
                                    i4 = i11;
                                    break;
                                case 'u':
                                    i5 = i3;
                                    i3 = 2;
                                    i7 = i4;
                                    i4 = i11;
                                    break;
                                default:
                                    iArr[i10] = 1;
                                    i7 = i10 + 1;
                                    cArr[i10] = c;
                                    i5 = 0;
                                    i4 = i12;
                                    i3 = i8;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                            }
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            switch (obj[i9]) {
                                case '\\':
                                    i5 = i3;
                                    obj3 = null;
                                    i7 = i4;
                                    i4 = i11;
                                    break;
                                default:
                                    iArr[i10] = 1;
                                    i7 = i10 + 1;
                                    cArr[i10] = c;
                                    i5 = i9 - i8;
                                    i4 = i12;
                                    i3 = i8;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                            }
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            switch (obj[i9]) {
                                case '0':
                                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                                case 'B':
                                case 'C':
                                case 'D':
                                case 'E':
                                case 'F':
                                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    i13 = i4;
                                    i4 = Character.digit(obj[i9], 16);
                                    i7 = i13;
                                    int i142 = i3;
                                    i3 = 3;
                                    i5 = i142;
                                    break;
                                case 'u':
                                    i5 = i3;
                                    i3 = 2;
                                    i7 = i4;
                                    i4 = i11;
                                    break;
                                default:
                                    iArr[i10] = 1;
                                    i7 = i10 + 1;
                                    cArr[i10] = c;
                                    i5 = 0;
                                    i4 = i12;
                                    i3 = i8;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                            }
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            switch (obj[i9]) {
                                case '0':
                                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                                case 'B':
                                case 'C':
                                case 'D':
                                case 'E':
                                case 'F':
                                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    i3 = 4;
                                    i5 = Character.digit(obj[i9], 16);
                                    i7 = i4;
                                    i4 = i11;
                                    break;
                                default:
                                    iArr[i10] = 1;
                                    i7 = i10 + 1;
                                    cArr[i10] = c;
                                    i5 = 0;
                                    i4 = i12;
                                    i3 = i8;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                            }
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            switch (obj[i9]) {
                                case '0':
                                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                                case 'B':
                                case 'C':
                                case 'D':
                                case 'E':
                                case 'F':
                                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    i7 = Character.digit(obj[i9], 16);
                                    i4 = i11;
                                    i13 = i3;
                                    i3 = 5;
                                    i5 = i13;
                                    break;
                                default:
                                    i7 = i10 + 1;
                                    cArr[i10] = c;
                                    i5 = 0;
                                    i4 = i12;
                                    i3 = i8;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                            }
                        case 5:
                            switch (obj[i9]) {
                                case '0':
                                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                                case 'B':
                                case 'C':
                                case 'D':
                                case 'E':
                                case 'F':
                                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    digit = (char) (Character.digit(obj[i9], 16) | (((i11 << 12) | (i3 << 8)) | (i4 << 4)));
                                    if (digit == '\n') {
                                        break;
                                    }
                                    iArr[i10] = 1;
                                    i7 = i10 + 1;
                                    cArr[i10] = '\u0000';
                                    i4 = i12;
                                    i3 = i9 + 1;
                                    i5 = 0;
                                    break;
                                default:
                                    i7 = i10 + 1;
                                    cArr[i10] = c;
                                    i5 = 0;
                                    i4 = i12;
                                    i3 = i8;
                                    continue;
                                    continue;
                            }
                        default:
                            i7 = i4;
                            i5 = i3;
                            i4 = i11;
                            obj3 = obj2;
                            break;
                    }
                    obj2 = obj3;
                    i3 = i5;
                    i5 = i9 + 1;
                    i11 = i4;
                    i4 = i7;
                }
            } else {
                iArr[i10] = 1;
                i7 = i10 + 1;
                cArr[i10] = c;
                i5--;
            }
        }
        this.FH = i3;
        this.Hw = i4;
        this.v5 = i5;
        return i2;
    }
}
