package com.aide.ui.scm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class a {

    public static class a {
        private final int DW;
        private final int FH;
        private final int Hw;
        private final int j6;

        public a(int i, int i2, int i3, int i4) {
            this.j6 = i;
            this.DW = i2;
            this.FH = i3;
            this.Hw = i4;
        }

        public int j6() {
            return this.j6;
        }

        public int DW() {
            return this.DW;
        }

        public int FH() {
            return this.FH;
        }

        public int Hw() {
            return this.Hw;
        }
    }

    private static class b {
        public boolean DW;
        private int EQ;
        private int FH;
        private int[] Hw;
        private int[] VH;
        private int[] Zo;
        private int gn;
        public boolean j6;
        private final b[] tp;
        private int u7;
        private int[] v5;
        private boolean we;

        private static class a {
            public final int DW;
            public final int FH;
            public final int Hw;
            public a j6;
            public final int v5;

            public a(int i, int i2, int i3, int i4, a aVar) {
                this.Hw = i;
                this.v5 = i2;
                this.DW = i4;
                this.FH = i3;
                this.j6 = aVar;
            }
        }

        private class b {
            final int[] DW;
            final int[] FH;
            int Hw;
            private final int[] VH;
            final /* synthetic */ b Zo;
            final int j6;
            boolean[] v5;

            void j6() {
                this.v5 = new boolean[(this.j6 + 2)];
            }

            int[] DW() {
                int[] iArr = new int[this.Zo.FH];
                for (int i = 0; i < this.j6; i++) {
                    int i2 = this.VH[i];
                    iArr[i2] = iArr[i2] + 1;
                }
                return iArr;
            }

            void j6(b bVar) {
                j6();
                byte[] j6 = j6(bVar.DW());
                j6(j6);
                DW(j6);
            }

            private byte[] j6(int[] iArr) {
                int i = this.j6;
                byte[] bArr = new byte[i];
                int[] iArr2 = this.VH;
                int i2 = 5;
                int i3 = i / 64;
                while (true) {
                    i3 >>= 2;
                    if (i3 <= 0) {
                        break;
                    }
                    i2 *= 2;
                }
                for (i3 = 0; i3 < i; i3++) {
                    if (iArr2[i3] != 0) {
                        int i4 = iArr[iArr2[i3]];
                        if (i4 == 0) {
                            bArr[i3] = (byte) 1;
                        } else if (i4 > i2) {
                            bArr[i3] = (byte) 2;
                        }
                    }
                }
                return bArr;
            }

            private void j6(byte[] bArr) {
                int i = this.j6;
                int i2 = 0;
                while (i2 < i) {
                    int i3;
                    if (bArr[i2] == (byte) 2) {
                        bArr[i2] = (byte) 0;
                        i3 = i2;
                    } else {
                        if (bArr[i2] != null) {
                            int i4;
                            int i5;
                            i3 = 0;
                            int i6 = i2;
                            while (i6 < i) {
                                if (bArr[i6] == null) {
                                    i4 = i3;
                                    i3 = i6;
                                    i6 = i4;
                                    break;
                                }
                                if (bArr[i6] == (byte) 2) {
                                    i3++;
                                }
                                i6++;
                            }
                            i4 = i3;
                            i3 = i6;
                            i6 = i4;
                            while (i3 > i2 && bArr[i3 - 1] == (byte) 2) {
                                i5 = i3 - 1;
                                bArr[i5] = (byte) 0;
                                i6--;
                                i3 = i5;
                            }
                            i5 = i3 - i2;
                            if (i6 * 4 <= i5) {
                                i3 = i5 / 4;
                                i6 = 1;
                                while (true) {
                                    i3 >>= 2;
                                    if (i3 <= 0) {
                                        break;
                                    }
                                    i6 *= 2;
                                }
                                int i7 = i6 + 1;
                                i3 = 0;
                                i6 = 0;
                                while (i6 < i5) {
                                    if (bArr[i2 + i6] != (byte) 2) {
                                        i3 = 0;
                                    } else {
                                        i3++;
                                        if (i7 == i3) {
                                            i6 -= i3;
                                        } else if (i7 < i3) {
                                            bArr[i2 + i6] = (byte) 0;
                                        }
                                    }
                                    i6++;
                                }
                                i3 = 0;
                                i6 = 0;
                                while (i6 < i5 && (i6 < 8 || bArr[i2 + i6] != (byte) 1)) {
                                    if (bArr[i2 + i6] == (byte) 2) {
                                        bArr[i2 + i6] = (byte) 0;
                                        i3 = 0;
                                    } else if (bArr[i2 + i6] == null) {
                                        i3 = 0;
                                    } else {
                                        i3++;
                                    }
                                    if (i3 == 3) {
                                        break;
                                    }
                                    i6++;
                                }
                                i3 = (i5 - 1) + i2;
                                i6 = 0;
                                i2 = 0;
                                while (i2 < i5 && (i2 < 8 || bArr[i3 - i2] != (byte) 1)) {
                                    if (bArr[i3 - i2] == (byte) 2) {
                                        bArr[i3 - i2] = (byte) 0;
                                        i6 = 0;
                                    } else if (bArr[i3 - i2] == null) {
                                        i6 = 0;
                                    } else {
                                        i6++;
                                    }
                                    if (i6 == 3) {
                                        break;
                                    }
                                    i2++;
                                }
                            } else {
                                while (i3 > i2) {
                                    i3--;
                                    if (bArr[i3] == (byte) 2) {
                                        bArr[i3] = (byte) 0;
                                    }
                                }
                            }
                        }
                        i3 = i2;
                    }
                    i2 = i3 + 1;
                }
            }

            private void DW(byte[] bArr) {
                int i = 0;
                int i2 = this.j6;
                int i3 = 0;
                while (i3 < i2) {
                    if (this.Zo.DW || bArr[i3] == null) {
                        this.DW[i] = this.VH[i3];
                        int i4 = i + 1;
                        this.FH[i] = i3;
                        i = i4;
                    } else {
                        this.v5[i3 + 1] = true;
                    }
                    i3++;
                }
                this.Hw = i;
            }

            b(b bVar, Object[] objArr, Hashtable hashtable) {
                this.Zo = bVar;
                this.j6 = objArr.length;
                this.VH = new int[this.j6];
                this.DW = new int[this.j6];
                this.FH = new int[this.j6];
                for (int i = 0; i < objArr.length; i++) {
                    Integer num = (Integer) hashtable.get(objArr[i]);
                    if (num == null) {
                        Object obj = objArr[i];
                        int[] iArr = this.VH;
                        int FH = bVar.FH = bVar.FH + 1;
                        iArr[i] = FH;
                        hashtable.put(obj, new Integer(FH));
                    } else {
                        this.VH[i] = num.intValue();
                    }
                }
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            void DW(com.aide.ui.scm.a.b.b r13) {
                /*
                r12 = this;
                r0 = -1;
                r7 = 0;
                r8 = r12.v5;
                r9 = r13.v5;
                r10 = r12.j6;
                r6 = r0;
                r1 = r7;
                r3 = r7;
            L_0x000b:
                if (r3 >= r10) goto L_0x0022;
            L_0x000d:
                r2 = r3 + 1;
                r2 = r8[r2];
                if (r2 != 0) goto L_0x0022;
            L_0x0013:
                r2 = r1;
            L_0x0014:
                r1 = r2 + 1;
                r2 = r2 + 1;
                r2 = r9[r2];
                if (r2 == 0) goto L_0x001f;
            L_0x001c:
                r0 = r1;
                r2 = r1;
                goto L_0x0014;
            L_0x001f:
                r3 = r3 + 1;
                goto L_0x000b;
            L_0x0022:
                if (r3 != r10) goto L_0x0025;
            L_0x0024:
                return;
            L_0x0025:
                r2 = r3;
                r4 = r1;
                r5 = r3;
            L_0x0028:
                if (r5 >= r10) goto L_0x0034;
            L_0x002a:
                r3 = r5 + 1;
                r3 = r8[r3];
                if (r3 == 0) goto L_0x0034;
            L_0x0030:
                r3 = r5 + 1;
                r5 = r3;
                goto L_0x0028;
            L_0x0034:
                if (r5 == r10) goto L_0x0064;
            L_0x0036:
                r3 = r12.VH;
                r3 = r3[r2];
                r11 = r12.VH;
                r11 = r11[r5];
                if (r3 != r11) goto L_0x0064;
            L_0x0040:
                r3 = r4 + 1;
                r3 = r9[r3];
                if (r3 != 0) goto L_0x0064;
            L_0x0046:
                if (r5 == r10) goto L_0x0064;
            L_0x0048:
                if (r6 < 0) goto L_0x004c;
            L_0x004a:
                if (r2 == r6) goto L_0x0064;
            L_0x004c:
                if (r0 < 0) goto L_0x0050;
            L_0x004e:
                if (r1 == r0) goto L_0x0064;
            L_0x0050:
                r3 = r5 + 1;
                r3 = r5 + 1;
                r11 = 1;
                r8[r3] = r11;
                r3 = r2 + 1;
                r2 = r2 + 1;
                r8[r2] = r7;
                r5 = r5 + 1;
                r2 = r4 + 1;
                r4 = r2;
                r2 = r3;
                goto L_0x0028;
            L_0x0064:
                r0 = r4;
                r6 = r5;
                r1 = r4;
                r3 = r5;
                goto L_0x000b;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.scm.a.b.b.DW(com.aide.ui.scm.a$b$b):void");
            }
        }

        private b(Object[] objArr, Object[] objArr2) {
            this.FH = 1;
            this.j6 = false;
            this.DW = false;
            this.tp = new b[2];
            this.we = false;
            Hashtable hashtable = new Hashtable(objArr.length + objArr2.length);
            this.tp[0] = new b(this, objArr, hashtable);
            this.tp[1] = new b(this, objArr2, hashtable);
        }

        private int j6(int i, int i2, int i3, int i4) {
            int[] iArr = this.Zo;
            int[] iArr2 = this.VH;
            int[] iArr3 = this.Hw;
            int[] iArr4 = this.v5;
            int i5 = i3 - i2;
            int i6 = i4 - i;
            int i7 = i3 - i;
            int i8 = i4 - i2;
            Object obj = ((i7 - i8) & 1) != 0 ? 1 : null;
            iArr[this.gn + i7] = i3;
            iArr2[this.u7 + i8] = i4;
            int i9 = 1;
            int i10 = i8;
            int i11 = i8;
            int i12 = i7;
            int i13 = i7;
            while (true) {
                int i14;
                int i15;
                Object obj2 = null;
                if (i13 > i5) {
                    i14 = i13 - 1;
                    iArr[(this.gn + i14) - 1] = -1;
                    i13 = i14;
                } else {
                    i13++;
                }
                if (i12 < i6) {
                    i14 = i12 + 1;
                    iArr[(this.gn + i14) + 1] = -1;
                } else {
                    i14 = i12 - 1;
                }
                int i16 = i14;
                while (i16 >= i13) {
                    Object obj3;
                    i15 = iArr[(this.gn + i16) - 1];
                    i12 = iArr[(this.gn + i16) + 1];
                    if (i15 >= i12) {
                        i12 = i15 + 1;
                    }
                    i15 = i12 - i16;
                    int i17 = i12;
                    while (i17 < i4 && i15 < i2 && iArr3[i17] == iArr4[i15]) {
                        i17++;
                        i15++;
                    }
                    if (i17 - i12 > 20) {
                        obj3 = 1;
                    } else {
                        obj3 = obj2;
                    }
                    iArr[this.gn + i16] = i17;
                    if (obj == null || i11 > i16 || i16 > i10 || iArr2[this.u7 + i16] > iArr[this.gn + i16]) {
                        i16 -= 2;
                        obj2 = obj3;
                    } else {
                        this.EQ = (i9 * 2) - 1;
                        return i16;
                    }
                }
                if (i11 > i5) {
                    i12 = i11 - 1;
                    iArr2[(this.u7 + i12) - 1] = Integer.MAX_VALUE;
                    i11 = i12;
                } else {
                    i11++;
                }
                if (i10 < i6) {
                    i12 = i10 + 1;
                    iArr2[(this.u7 + i12) + 1] = Integer.MAX_VALUE;
                } else {
                    i12 = i10 - 1;
                }
                Object obj4 = obj2;
                i15 = i12;
                while (i15 >= i11) {
                    int i18 = iArr2[(this.u7 + i15) - 1];
                    i17 = iArr2[(this.u7 + i15) + 1];
                    if (i18 >= i17) {
                        i18 = i17 - 1;
                    }
                    i17 = i18 - i15;
                    i10 = i18;
                    while (i10 > i3 && i17 > i && iArr3[i10 - 1] == iArr4[i17 - 1]) {
                        i10--;
                        i17--;
                    }
                    if (i18 - i10 > 20) {
                        obj2 = 1;
                    } else {
                        obj2 = obj4;
                    }
                    iArr2[this.u7 + i15] = i10;
                    if (obj != null || i13 > i15 || i15 > i14 || iArr2[this.u7 + i15] > iArr[this.gn + i15]) {
                        i15 -= 2;
                        obj4 = obj2;
                    } else {
                        this.EQ = i9 * 2;
                        return i15;
                    }
                }
                if (i9 > 200 && obj4 != null && this.j6) {
                    int i19;
                    i15 = 0;
                    i18 = -1;
                    i16 = i14;
                    while (i16 >= i13) {
                        i10 = i16 - i7;
                        if (((iArr[this.gn + i16] - i3) * 2) - i10 > ((i10 > 0 ? i10 : -i10) + i9) * 12 && (iArr[this.gn + i16] * 2) - i10 > i15 && iArr[this.gn + i16] - i3 > 20 && (iArr[this.gn + i16] - i16) - i > 20) {
                            i19 = iArr[this.gn + i16];
                            i17 = 1;
                            while (i17 <= 20) {
                                if (this.Hw[i19 - i17] != this.v5[(i19 - i16) - i17]) {
                                    break;
                                }
                                i17++;
                            }
                            if (i17 == 21) {
                                i15 = (iArr[this.gn + i16] * 2) - i10;
                                i18 = i16;
                            }
                        }
                        i16 -= 2;
                    }
                    if (i15 > 0) {
                        this.EQ = (i9 * 2) - 1;
                        return i18;
                    }
                    i15 = 0;
                    i16 = i12;
                    while (i16 >= i11) {
                        i10 = i16 - i8;
                        if (((i4 - iArr2[this.u7 + i16]) * 2) + i10 > ((i10 > 0 ? i10 : -i10) + i9) * 12 && ((i4 - iArr2[this.u7 + i16]) * 2) + i10 > i15 && i4 - iArr2[this.u7 + i16] > 20 && i2 - (iArr2[this.u7 + i16] - i16) > 20) {
                            i19 = iArr2[this.u7 + i16];
                            i17 = 0;
                            while (i17 < 20) {
                                if (this.Hw[i19 + i17] != this.v5[(i19 - i16) + i17]) {
                                    break;
                                }
                                i17++;
                            }
                            if (i17 == 20) {
                                i15 = ((i4 - iArr2[this.u7 + i16]) * 2) + i10;
                                i18 = i16;
                            }
                        }
                        i16 -= 2;
                    }
                    if (i15 > 0) {
                        this.EQ = (i9 * 2) - 1;
                        return i18;
                    }
                }
                i9++;
                i10 = i12;
                i12 = i14;
            }
        }

        private void DW(int i, int i2, int i3, int i4) {
            int i5 = i3;
            int i6 = i;
            while (i6 < i2 && i5 < i4 && this.Hw[i6] == this.v5[i5]) {
                i6++;
                i5++;
            }
            while (i2 > i6 && i4 > i5 && this.Hw[i2 - 1] == this.v5[i4 - 1]) {
                i2--;
                i4--;
            }
            if (i6 == i2) {
                i6 = i5;
                while (i6 < i4) {
                    i5 = i6 + 1;
                    this.tp[1].v5[this.tp[1].FH[i6] + 1] = true;
                    i6 = i5;
                }
            } else if (i5 == i4) {
                while (i6 < i2) {
                    i5 = i6 + 1;
                    this.tp[0].v5[this.tp[0].FH[i6] + 1] = true;
                    i6 = i5;
                }
            } else {
                int j6 = j6(i5, i4, i6, i2);
                int i7 = this.EQ;
                int i8 = this.Zo[this.gn + j6];
                i8 = this.VH[this.u7 + j6];
                if (i7 != 1) {
                    DW(i6, i8, i5, i8 - j6);
                    DW(i8, i2, i8 - j6, i4);
                    return;
                }
                throw new IllegalArgumentException("Empty subsequence");
            }
        }

        private void j6() {
            this.tp[0].j6(this.tp[1]);
            this.tp[1].j6(this.tp[0]);
        }

        private void DW() {
            if (!this.we) {
                this.tp[0].DW(this.tp[1]);
                this.tp[1].DW(this.tp[0]);
            }
        }

        private a j6(boolean[] zArr, int i, boolean[] zArr2, int i2) {
            a aVar = null;
            int i3 = i2;
            int i4 = i;
            while (true) {
                if (i4 < 0 && i3 < 0) {
                    return aVar;
                }
                int i5;
                int i6;
                if (zArr[i4] || zArr2[i3]) {
                    i5 = i4;
                    while (zArr[i5]) {
                        i5--;
                    }
                    i6 = i3;
                    while (zArr2[i6]) {
                        i6--;
                    }
                    aVar = new a(i5, i6, i4 - i5, i3 - i6, aVar);
                } else {
                    i6 = i3;
                    i5 = i4;
                }
                i4 = i5 - 1;
                i3 = i6 - 1;
            }
        }

        private a FH() {
            j6();
            this.Hw = this.tp[0].DW;
            this.v5 = this.tp[1].DW;
            int i = (this.tp[0].Hw + this.tp[1].Hw) + 3;
            this.Zo = new int[i];
            this.gn = this.tp[1].Hw + 1;
            this.VH = new int[i];
            this.u7 = this.tp[1].Hw + 1;
            DW(0, this.tp[0].Hw, 0, this.tp[1].Hw);
            this.Zo = null;
            this.VH = null;
            DW();
            return j6(this.tp[0].v5, this.tp[0].j6, this.tp[1].v5, this.tp[1].j6);
        }
    }

    public static List<a> j6(List<String> list, List<String> list2) {
        List<a> arrayList = new ArrayList();
        for (a j6 = new b(list2.toArray(), null).FH(); j6 != null; j6 = j6.j6) {
            arrayList.add(new a(j6.Hw, j6.v5, j6.DW, j6.FH));
        }
        return arrayList;
    }
}
