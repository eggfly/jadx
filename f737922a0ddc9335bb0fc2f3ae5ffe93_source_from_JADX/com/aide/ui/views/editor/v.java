package com.aide.ui.views.editor;

import java.io.Reader;

public abstract class v {

    public interface a {
        void DW(int i, char[] cArr, int i2, int i3);

        void j6(String str);

        boolean j6(int i, char[] cArr, int i2, int i3);
    }

    public static char[] j6(Reader reader, a aVar, char[] cArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int read = reader.read(cArr, i4, cArr.length - i4);
            if (read != -1) {
                int i5 = i4;
                int i6 = 0;
                while (i5 < i4 + read) {
                    int i7;
                    switch (cArr[i5]) {
                        case '\n':
                            if (i2 == 0) {
                                if (i == 0) {
                                    aVar.j6("\n");
                                    i = 1;
                                }
                                if (!aVar.j6(i3, cArr, i6, i5 - i6)) {
                                    break;
                                }
                                i6 = i3 + 1;
                                i3 = i2;
                                i2 = i;
                                i = i5 + 1;
                                break;
                            }
                            i2 = i6 + 1;
                            if (i != 0) {
                                i6 = i3;
                                i3 = 0;
                                i7 = i;
                                i = i2;
                                i2 = i7;
                                break;
                            }
                            aVar.j6("\r\n");
                            i = i2;
                            i6 = i3;
                            i3 = 0;
                            i2 = 1;
                            break;
                        case '\r':
                            if (!aVar.j6(i3, cArr, i6, i5 - i6)) {
                                break;
                            }
                            i6 = i3 + 1;
                            i3 = 1;
                            i7 = i;
                            i = i5 + 1;
                            i2 = i7;
                            break;
                        default:
                            if (i2 != 0 && i == 0) {
                                aVar.j6("\r");
                                i = 1;
                            }
                            i2 = i;
                            i = i6;
                            i6 = i3;
                            i3 = 0;
                            break;
                    }
                    i5++;
                    i7 = i;
                    i = i2;
                    i2 = i3;
                    i3 = i6;
                    i6 = i7;
                }
                if (i6 == 0) {
                    if (i4 + read == cArr.length) {
                        Object obj = new char[(cArr.length * 2)];
                        System.arraycopy(cArr, 0, obj, 0, cArr.length);
                        i4 = cArr.length;
                        cArr = obj;
                    } else {
                        i4 += read;
                    }
                } else if (i6 < i4 + read) {
                    System.arraycopy(cArr, i6, cArr, 0, (i4 + read) - i6);
                    i4 = (i4 + read) - i6;
                } else {
                    i4 = 0;
                }
            } else if (i4 != 0) {
                aVar.DW(i3, cArr, 0, i4);
            }
            return cArr;
        }
    }
}
