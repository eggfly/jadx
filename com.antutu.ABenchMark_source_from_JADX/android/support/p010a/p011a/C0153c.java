package android.support.p010a.p011a;

import android.graphics.Path;
import android.util.Log;
import com.antutu.redacc.C1692R;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4216d;
import java.util.ArrayList;

/* renamed from: android.support.a.a.c */
class C0153c {

    /* renamed from: android.support.a.a.c.a */
    private static class C0151a {
        int f680a;
        boolean f681b;

        private C0151a() {
        }
    }

    /* renamed from: android.support.a.a.c.b */
    public static class C0152b {
        char f682a;
        float[] f683b;

        private C0152b(char c, float[] fArr) {
            this.f682a = c;
            this.f683b = fArr;
        }

        private C0152b(C0152b c0152b) {
            this.f682a = c0152b.f682a;
            this.f683b = C0153c.m723b(c0152b.f683b, 0, c0152b.f683b.length);
        }

        private static void m712a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int ceil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d10 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
            double d11 = d9 / ((double) ceil);
            int i = 0;
            cos2 = (sin2 * ((-d3) * sin)) + (cos2 * (d4 * cos));
            sin2 = d10;
            while (i < ceil) {
                double d12 = d8 + d11;
                d10 = Math.sin(d12);
                double cos3 = Math.cos(d12);
                double d13 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * d10);
                double d14 = ((d4 * cos) * d10) + (((d3 * sin) * cos3) + d2);
                double d15 = (((-d3) * cos) * d10) - ((d4 * sin) * cos3);
                cos3 = (cos3 * (d4 * cos)) + (d10 * ((-d3) * sin));
                d10 = Math.tan((d12 - d8) / 2.0d);
                d10 = ((Math.sqrt((d10 * (3.0d * d10)) + 4.0d) - 1.0d) * Math.sin(d12 - d8)) / 3.0d;
                Path path2 = path;
                path2.cubicTo((float) ((sin2 * d10) + d5), (float) (d6 + (cos2 * d10)), (float) (d13 - (d10 * d15)), (float) (d14 - (d10 * cos3)), (float) d13, (float) d14);
                i++;
                sin2 = d15;
                d8 = d12;
                d6 = d14;
                d5 = d13;
                cos2 = cos3;
            }
        }

        private static void m713a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double toRadians = Math.toRadians((double) f7);
            double cos = Math.cos(toRadians);
            double sin = Math.sin(toRadians);
            double d = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
            double d2 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
            double d3 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
            double d4 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
            double d5 = d - d3;
            double d6 = d2 - d4;
            double d7 = (d + d3) / 2.0d;
            double d8 = (d2 + d4) / 2.0d;
            double d9 = (d5 * d5) + (d6 * d6);
            if (d9 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d10 = (1.0d / d9) - 0.25d;
            if (d10 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d9);
                float sqrt = (float) (Math.sqrt(d9) / 1.99999d);
                C0152b.m713a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            d9 = Math.sqrt(d10);
            d5 *= d9;
            d6 *= d9;
            if (z == z2) {
                d6 = d7 - d6;
                d5 += d8;
            } else {
                d6 += d7;
                d5 = d8 - d5;
            }
            d7 = Math.atan2(d2 - d5, d - d6);
            d4 = Math.atan2(d4 - d5, d3 - d6) - d7;
            if (z2 != (d4 >= 0.0d)) {
                d4 = d4 > 0.0d ? d4 - 6.283185307179586d : d4 + 6.283185307179586d;
            }
            d = ((double) f5) * d6;
            d5 *= (double) f6;
            C0152b.m712a(path, (d * cos) - (d5 * sin), (d * sin) + (d5 * cos), (double) f5, (double) f6, (double) f, (double) f2, toRadians, d7, d4);
        }

        private static void m714a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            switch (c2) {
                case C1692R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*65*/:
                case C1692R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /*97*/:
                    i = 7;
                    break;
                case C1692R.styleable.AppCompatTheme_textColorSearchUrl /*67*/:
                case C1692R.styleable.AppCompatTheme_autoCompleteTextViewStyle /*99*/:
                    i = 6;
                    break;
                case C1692R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                case C1692R.styleable.AppCompatTheme_colorControlActivated /*86*/:
                case Constants.COMMAND_ANTI_BRUSH /*104*/:
                case 'v':
                    i = 1;
                    break;
                case C4216d.f14306b /*76*/:
                case C1692R.styleable.AppCompatTheme_textAppearanceListItemSmall /*77*/:
                case C1692R.styleable.AppCompatTheme_colorAccent /*84*/:
                case C1692R.styleable.AppCompatTheme_ratingBarStyleSmall /*108*/:
                case C1692R.styleable.AppCompatTheme_seekBarStyle /*109*/:
                case 't':
                    i = 2;
                    break;
                case C1692R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*81*/:
                case C1692R.styleable.AppCompatTheme_colorPrimaryDark /*83*/:
                case 'q':
                case 's':
                    i = 4;
                    break;
                case C1692R.styleable.AppCompatTheme_controlBackground /*90*/:
                case 'z':
                    path.close();
                    path.moveTo(f5, f6);
                    f4 = f6;
                    f3 = f5;
                    f2 = f6;
                    f = f5;
                    i = 2;
                    break;
                default:
                    i = 2;
                    break;
            }
            int i2 = 0;
            float f7 = f6;
            float f8 = f5;
            float f9 = f2;
            float f10 = f;
            while (i2 < fArr2.length) {
                float f11;
                switch (c2) {
                    case C1692R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*65*/:
                        C0152b.m713a(path, f10, f9, fArr2[i2 + 5], fArr2[i2 + 6], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f3 = fArr2[i2 + 5];
                        f4 = fArr2[i2 + 6];
                        f6 = f7;
                        f5 = f8;
                        f2 = f3;
                        f = f4;
                        f11 = f3;
                        f3 = f4;
                        break;
                    case C1692R.styleable.AppCompatTheme_textColorSearchUrl /*67*/:
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        f5 = fArr2[i2 + 4];
                        f6 = fArr2[i2 + 5];
                        f2 = fArr2[i2 + 2];
                        f = f6;
                        f11 = f5;
                        f6 = f7;
                        f5 = f8;
                        f3 = fArr2[i2 + 3];
                        break;
                    case C1692R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                        path.lineTo(fArr2[i2 + 0], f9);
                        f6 = f7;
                        f2 = f3;
                        f = f9;
                        f11 = fArr2[i2 + 0];
                        f3 = f4;
                        f5 = f8;
                        break;
                    case C4216d.f14306b /*76*/:
                        path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f5 = fArr2[i2 + 0];
                        f2 = f3;
                        f = fArr2[i2 + 1];
                        f11 = f5;
                        f6 = f7;
                        f5 = f8;
                        f3 = f4;
                        break;
                    case C1692R.styleable.AppCompatTheme_textAppearanceListItemSmall /*77*/:
                        f5 = fArr2[i2 + 0];
                        f6 = fArr2[i2 + 1];
                        if (i2 <= 0) {
                            path.moveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f2 = f3;
                            f = f6;
                            f11 = f5;
                            f3 = f4;
                            break;
                        }
                        path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f2 = f3;
                        f = f6;
                        f11 = f5;
                        f6 = f7;
                        f5 = f8;
                        f3 = f4;
                        break;
                    case C1692R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*81*/:
                        path.quadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f3 = fArr2[i2 + 0];
                        f4 = fArr2[i2 + 1];
                        f5 = fArr2[i2 + 2];
                        f2 = f3;
                        f = fArr2[i2 + 3];
                        f11 = f5;
                        f6 = f7;
                        f5 = f8;
                        f3 = f4;
                        break;
                    case C1692R.styleable.AppCompatTheme_colorPrimaryDark /*83*/:
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f6 = (2.0f * f10) - f3;
                            f3 = (2.0f * f9) - f4;
                        } else {
                            f3 = f9;
                            f6 = f10;
                        }
                        path.cubicTo(f6, f3, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f3 = fArr2[i2 + 0];
                        f4 = fArr2[i2 + 1];
                        f5 = fArr2[i2 + 2];
                        f2 = f3;
                        f = fArr2[i2 + 3];
                        f11 = f5;
                        f6 = f7;
                        f5 = f8;
                        f3 = f4;
                        break;
                    case C1692R.styleable.AppCompatTheme_colorAccent /*84*/:
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f10 = (2.0f * f10) - f3;
                            f9 = (2.0f * f9) - f4;
                        }
                        path.quadTo(f10, f9, fArr2[i2 + 0], fArr2[i2 + 1]);
                        f5 = fArr2[i2 + 0];
                        f3 = f9;
                        f2 = f10;
                        f = fArr2[i2 + 1];
                        f11 = f5;
                        f6 = f7;
                        f5 = f8;
                        break;
                    case C1692R.styleable.AppCompatTheme_colorControlActivated /*86*/:
                        path.lineTo(f10, fArr2[i2 + 0]);
                        f5 = f8;
                        f2 = f3;
                        f = fArr2[i2 + 0];
                        f11 = f10;
                        f3 = f4;
                        f6 = f7;
                        break;
                    case C1692R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /*97*/:
                        C0152b.m713a(path, f10, f9, fArr2[i2 + 5] + f10, fArr2[i2 + 6] + f9, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f3 = f10 + fArr2[i2 + 5];
                        f4 = fArr2[i2 + 6] + f9;
                        f6 = f7;
                        f5 = f8;
                        f2 = f3;
                        f = f4;
                        f11 = f3;
                        f3 = f4;
                        break;
                    case C1692R.styleable.AppCompatTheme_autoCompleteTextViewStyle /*99*/:
                        path.rCubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        f2 = f10 + fArr2[i2 + 2];
                        f = fArr2[i2 + 5] + f9;
                        f11 = f10 + fArr2[i2 + 4];
                        f6 = f7;
                        f5 = f8;
                        f3 = fArr2[i2 + 3] + f9;
                        break;
                    case Constants.COMMAND_ANTI_BRUSH /*104*/:
                        path.rLineTo(fArr2[i2 + 0], 0.0f);
                        f6 = f7;
                        f2 = f3;
                        f = f9;
                        f11 = f10 + fArr2[i2 + 0];
                        f3 = f4;
                        f5 = f8;
                        break;
                    case C1692R.styleable.AppCompatTheme_ratingBarStyleSmall /*108*/:
                        path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f2 = f3;
                        f = fArr2[i2 + 1] + f9;
                        f11 = f10 + fArr2[i2 + 0];
                        f6 = f7;
                        f5 = f8;
                        f3 = f4;
                        break;
                    case C1692R.styleable.AppCompatTheme_seekBarStyle /*109*/:
                        f5 = f10 + fArr2[i2 + 0];
                        f6 = fArr2[i2 + 1] + f9;
                        if (i2 <= 0) {
                            path.rMoveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f2 = f3;
                            f = f6;
                            f11 = f5;
                            f3 = f4;
                            break;
                        }
                        path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f2 = f3;
                        f = f6;
                        f11 = f5;
                        f6 = f7;
                        f5 = f8;
                        f3 = f4;
                        break;
                    case 'q':
                        path.rQuadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f2 = f10 + fArr2[i2 + 0];
                        f = fArr2[i2 + 3] + f9;
                        f11 = f10 + fArr2[i2 + 2];
                        f6 = f7;
                        f5 = f8;
                        f3 = fArr2[i2 + 1] + f9;
                        break;
                    case 's':
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f6 = f10 - f3;
                            f3 = f9 - f4;
                        } else {
                            f3 = 0.0f;
                            f6 = 0.0f;
                        }
                        path.rCubicTo(f6, f3, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f2 = f10 + fArr2[i2 + 0];
                        f = fArr2[i2 + 3] + f9;
                        f11 = f10 + fArr2[i2 + 2];
                        f6 = f7;
                        f5 = f8;
                        f3 = fArr2[i2 + 1] + f9;
                        break;
                    case 't':
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f6 = f10 - f3;
                            f4 = f9 - f4;
                        } else {
                            f4 = 0.0f;
                            f6 = 0.0f;
                        }
                        path.rQuadTo(f6, f4, fArr2[i2 + 0], fArr2[i2 + 1]);
                        f2 = f10 + f6;
                        f = fArr2[i2 + 1] + f9;
                        f11 = f10 + fArr2[i2 + 0];
                        f6 = f7;
                        f5 = f8;
                        f3 = f4 + f9;
                        break;
                    case 'v':
                        path.rLineTo(0.0f, fArr2[i2 + 0]);
                        f5 = f8;
                        f2 = f3;
                        f = fArr2[i2 + 0] + f9;
                        f11 = f10;
                        f3 = f4;
                        f6 = f7;
                        break;
                    default:
                        f6 = f7;
                        f5 = f8;
                        f2 = f3;
                        f = f9;
                        f11 = f10;
                        f3 = f4;
                        break;
                }
                i2 += i;
                f7 = f6;
                f8 = f5;
                f9 = f;
                f10 = f11;
                c = c2;
                f4 = f3;
                f3 = f2;
            }
            fArr[0] = f10;
            fArr[1] = f9;
            fArr[2] = f3;
            fArr[3] = f4;
            fArr[4] = f8;
            fArr[5] = f7;
        }

        public static void m715a(C0152b[] c0152bArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < c0152bArr.length; i++) {
                C0152b.m714a(path, fArr, c, c0152bArr[i].f682a, c0152bArr[i].f683b);
                c = c0152bArr[i].f682a;
            }
        }
    }

    private static int m716a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m717a(java.lang.String r7, int r8, android.support.p010a.p011a.C0153c.C0151a r9) {
        /*
        r1 = 0;
        r5 = 1;
        r9.f681b = r1;
        r0 = r1;
        r2 = r1;
        r3 = r1;
        r4 = r8;
    L_0x0008:
        r6 = r7.length();
        if (r4 >= r6) goto L_0x0018;
    L_0x000e:
        r6 = r7.charAt(r4);
        switch(r6) {
            case 32: goto L_0x001b;
            case 44: goto L_0x001b;
            case 45: goto L_0x001e;
            case 46: goto L_0x0027;
            case 69: goto L_0x0031;
            case 101: goto L_0x0031;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r1;
    L_0x0016:
        if (r3 == 0) goto L_0x0033;
    L_0x0018:
        r9.f680a = r4;
        return;
    L_0x001b:
        r0 = r1;
        r3 = r5;
        goto L_0x0016;
    L_0x001e:
        if (r4 == r8) goto L_0x0015;
    L_0x0020:
        if (r0 != 0) goto L_0x0015;
    L_0x0022:
        r9.f681b = r5;
        r0 = r1;
        r3 = r5;
        goto L_0x0016;
    L_0x0027:
        if (r2 != 0) goto L_0x002c;
    L_0x0029:
        r0 = r1;
        r2 = r5;
        goto L_0x0016;
    L_0x002c:
        r9.f681b = r5;
        r0 = r1;
        r3 = r5;
        goto L_0x0016;
    L_0x0031:
        r0 = r5;
        goto L_0x0016;
    L_0x0033:
        r4 = r4 + 1;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.a.a.c.a(java.lang.String, int, android.support.a.a.c$a):void");
    }

    private static void m718a(ArrayList<C0152b> arrayList, char c, float[] fArr) {
        arrayList.add(new C0152b(fArr, null));
    }

    public static C0152b[] m720a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a = C0153c.m716a(str, i);
            String trim = str.substring(i2, a).trim();
            if (trim.length() > 0) {
                C0153c.m718a(arrayList, trim.charAt(0), C0153c.m722b(trim));
            }
            i = a + 1;
            i2 = a;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            C0153c.m718a(arrayList, str.charAt(i2), new float[0]);
        }
        return (C0152b[]) arrayList.toArray(new C0152b[arrayList.size()]);
    }

    public static C0152b[] m721a(C0152b[] c0152bArr) {
        if (c0152bArr == null) {
            return null;
        }
        C0152b[] c0152bArr2 = new C0152b[c0152bArr.length];
        for (int i = 0; i < c0152bArr.length; i++) {
            c0152bArr2[i] = new C0152b(null);
        }
        return c0152bArr2;
    }

    private static float[] m722b(String str) {
        if (((str.charAt(0) == 'z' ? 1 : 0) | (str.charAt(0) == 'Z' ? 1 : 0)) != 0) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            C0151a c0151a = new C0151a();
            int length = str.length();
            int i = 0;
            int i2 = 1;
            while (i2 < length) {
                int i3;
                C0153c.m717a(str, i2, c0151a);
                int i4 = c0151a.f680a;
                if (i2 < i4) {
                    i3 = i + 1;
                    fArr[i] = Float.parseFloat(str.substring(i2, i4));
                } else {
                    i3 = i;
                }
                if (c0151a.f681b) {
                    i2 = i4;
                    i = i3;
                } else {
                    i2 = i4 + 1;
                    i = i3;
                }
            }
            return C0153c.m723b(fArr, 0, i);
        } catch (Throwable e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    private static float[] m723b(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new float[i3];
        System.arraycopy(fArr, i, obj, 0, length);
        return obj;
    }
}
