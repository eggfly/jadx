package android.support.v4.graphics;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY;
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    static {
        TEMP_ARRAY = new ThreadLocal();
    }

    private ColorUtils() {
    }

    public static int HSLToColor(float[] fArr) {
        int round;
        int round2;
        int round3;
        float f = fArr[0];
        float f2 = fArr[MIN_ALPHA_SEARCH_PRECISION];
        float f3 = fArr[2];
        float abs = (1.0f - Math.abs((2.0f * f3) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = abs * (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f));
        switch (((int) f) / 60) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round(255.0f * f4);
                break;
            case MIN_ALPHA_SEARCH_PRECISION /*1*/:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round(255.0f * f4);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                round = Math.round(255.0f * f4);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                round = Math.round(255.0f * f4);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case SpdyProtocol.QUIC /*4*/:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round(255.0f * f4);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round(255.0f * f4);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            default:
                round3 = 0;
                round2 = 0;
                round = 0;
                break;
        }
        return Color.rgb(constrain(round, 0, (int) MotionEventCompat.ACTION_MASK), constrain(round2, 0, (int) MotionEventCompat.ACTION_MASK), constrain(round3, 0, (int) MotionEventCompat.ACTION_MASK));
    }

    public static int LABToColor(double d, double d2, double d3) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d2, d3, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[MIN_ALPHA_SEARCH_PRECISION], tempDouble3Array[2]);
    }

    public static void LABToXYZ(double d, double d2, double d3, double[] dArr) {
        double d4 = (16.0d + d) / 116.0d;
        double d5 = (d2 / 500.0d) + d4;
        double d6 = d4 - (d3 / 200.0d);
        double pow = Math.pow(d5, 3.0d);
        d5 = pow > XYZ_EPSILON ? pow : ((116.0d * d5) - 16.0d) / XYZ_KAPPA;
        pow = d > 7.9996247999999985d ? Math.pow(d4, 3.0d) : d / XYZ_KAPPA;
        d4 = Math.pow(d6, 3.0d);
        if (d4 <= XYZ_EPSILON) {
            d4 = ((116.0d * d6) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = d5 * XYZ_WHITE_REFERENCE_X;
        dArr[MIN_ALPHA_SEARCH_PRECISION] = pow * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = d4 * XYZ_WHITE_REFERENCE_Z;
    }

    public static void RGBToHSL(int i, int i2, int i3, float[] fArr) {
        float f = ((float) i) / 255.0f;
        float f2 = ((float) i2) / 255.0f;
        float f3 = ((float) i3) / 255.0f;
        float max = Math.max(f, Math.max(f2, f3));
        float min = Math.min(f, Math.min(f2, f3));
        float f4 = max - min;
        float f5 = (max + min) / 2.0f;
        if (max == min) {
            f2 = 0.0f;
            f = 0.0f;
        } else {
            f = max == f ? ((f2 - f3) / f4) % 6.0f : max == f2 ? ((f3 - f) / f4) + 2.0f : ((f - f2) / f4) + 4.0f;
            f2 = f4 / (1.0f - Math.abs((2.0f * f5) - 1.0f));
        }
        f = (f * 60.0f) % 360.0f;
        if (f < 0.0f) {
            f += 360.0f;
        }
        fArr[0] = constrain(f, 0.0f, 360.0f);
        fArr[MIN_ALPHA_SEARCH_PRECISION] = constrain(f2, 0.0f, 1.0f);
        fArr[2] = constrain(f5, 0.0f, 1.0f);
    }

    public static void RGBToLAB(int i, int i2, int i3, double[] dArr) {
        RGBToXYZ(i, i2, i3, dArr);
        XYZToLAB(dArr[0], dArr[MIN_ALPHA_SEARCH_PRECISION], dArr[2], dArr);
    }

    public static void RGBToXYZ(int i, int i2, int i3, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = ((double) i) / 255.0d;
        double pow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        d = ((double) i2) / 255.0d;
        double pow2 = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        d = ((double) i3) / 255.0d;
        d = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        dArr[0] = XYZ_WHITE_REFERENCE_Y * (((0.4124d * pow) + (0.3576d * pow2)) + (0.1805d * d));
        dArr[MIN_ALPHA_SEARCH_PRECISION] = XYZ_WHITE_REFERENCE_Y * (((0.2126d * pow) + (0.7152d * pow2)) + (0.0722d * d));
        dArr[2] = ((d * 0.9505d) + ((pow2 * 0.1192d) + (pow * 0.0193d))) * XYZ_WHITE_REFERENCE_Y;
    }

    public static int XYZToColor(double d, double d2, double d3) {
        double d4 = (((3.2406d * d) + (-1.5372d * d2)) + (-0.4986d * d3)) / XYZ_WHITE_REFERENCE_Y;
        double d5 = (((-0.9689d * d) + (1.8758d * d2)) + (0.0415d * d3)) / XYZ_WHITE_REFERENCE_Y;
        double d6 = (((0.0557d * d) + (-0.204d * d2)) + (1.057d * d3)) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d4 > 0.0031308d ? (Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d) * 255.0d), 0, (int) MotionEventCompat.ACTION_MASK), constrain((int) Math.round((d5 > 0.0031308d ? (1.055d * Math.pow(d5, 0.4166666666666667d)) - 0.055d : 12.92d * d5) * 255.0d), 0, (int) MotionEventCompat.ACTION_MASK), constrain((int) Math.round((d6 > 0.0031308d ? (1.055d * Math.pow(d6, 0.4166666666666667d)) - 0.055d : 12.92d * d6) * 255.0d), 0, (int) MotionEventCompat.ACTION_MASK));
    }

    public static void XYZToLAB(double d, double d2, double d3, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double pivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
        double pivotXyzComponent2 = pivotXyzComponent(d2 / XYZ_WHITE_REFERENCE_Y);
        double pivotXyzComponent3 = pivotXyzComponent(d3 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
        dArr[MIN_ALPHA_SEARCH_PRECISION] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
        dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
    }

    public static int blendARGB(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, float f, float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f2 = 1.0f - f;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
        fArr3[MIN_ALPHA_SEARCH_PRECISION] = (fArr[MIN_ALPHA_SEARCH_PRECISION] * f2) + (fArr2[MIN_ALPHA_SEARCH_PRECISION] * f);
        fArr3[2] = (f2 * fArr[2]) + (fArr2[2] * f);
    }

    public static void blendLAB(double[] dArr, double[] dArr2, double d, double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d2 = 1.0d - d;
        dArr3[0] = (dArr[0] * d2) + (dArr2[0] * d);
        dArr3[MIN_ALPHA_SEARCH_PRECISION] = (dArr[MIN_ALPHA_SEARCH_PRECISION] * d2) + (dArr2[MIN_ALPHA_SEARCH_PRECISION] * d);
        dArr3[2] = (d2 * dArr[2]) + (dArr2[2] * d);
    }

    public static double calculateContrast(int i, int i2) {
        if (Color.alpha(i2) != MotionEventCompat.ACTION_MASK) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        }
        if (Color.alpha(i) < MotionEventCompat.ACTION_MASK) {
            i = compositeColors(i, i2);
        }
        double calculateLuminance = calculateLuminance(i) + 0.05d;
        double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
        return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
    }

    public static double calculateLuminance(int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[MIN_ALPHA_SEARCH_PRECISION] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(int i, int i2, float f) {
        int i3 = 0;
        int i4 = MotionEventCompat.ACTION_MASK;
        if (Color.alpha(i2) != MotionEventCompat.ACTION_MASK) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        } else if (calculateContrast(setAlphaComponent(i, MotionEventCompat.ACTION_MASK), i2) < ((double) f)) {
            return -1;
        } else {
            int i5 = 0;
            while (i5 <= MIN_ALPHA_SEARCH_MAX_ITERATIONS && i4 - i3 > MIN_ALPHA_SEARCH_PRECISION) {
                int i6 = (i3 + i4) / 2;
                if (calculateContrast(setAlphaComponent(i, i6), i2) >= ((double) f)) {
                    i4 = i6;
                    i6 = i3;
                }
                i5 += MIN_ALPHA_SEARCH_PRECISION;
                i3 = i6;
            }
            return i4;
        }
    }

    static float circularInterpolate(float f, float f2, float f3) {
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > f) {
                f += 360.0f;
            } else {
                f2 += 360.0f;
            }
        }
        return (((f2 - f) * f3) + f) % 360.0f;
    }

    public static void colorToHSL(int i, float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void colorToLAB(int i, double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void colorToXYZ(int i, double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / MotionEventCompat.ACTION_MASK);
    }

    public static int compositeColors(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i), alpha2, Color.red(i2), alpha, compositeAlpha), compositeComponent(Color.green(i), alpha2, Color.green(i2), alpha, compositeAlpha), compositeComponent(Color.blue(i), alpha2, Color.blue(i2), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? 0 : (((i * MotionEventCompat.ACTION_MASK) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * MotionEventCompat.ACTION_MASK);
    }

    private static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        return Math.sqrt((Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[MIN_ALPHA_SEARCH_PRECISION] - dArr2[MIN_ALPHA_SEARCH_PRECISION], 2.0d)) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        double[] dArr = (double[]) TEMP_ARRAY.get();
        if (dArr != null) {
            return dArr;
        }
        Object obj = new double[3];
        TEMP_ARRAY.set(obj);
        return obj;
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? Math.pow(d, 0.3333333333333333d) : ((XYZ_KAPPA * d) + 16.0d) / 116.0d;
    }

    public static int setAlphaComponent(int i, int i2) {
        if (i2 >= 0 && i2 <= MotionEventCompat.ACTION_MASK) {
            return (ViewCompat.MEASURED_SIZE_MASK & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
