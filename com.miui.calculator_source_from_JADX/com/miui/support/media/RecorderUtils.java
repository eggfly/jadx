package com.miui.support.media;

import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

class RecorderUtils {
    RecorderUtils() {
    }

    public static int m5048a(int i, boolean z) {
        if (z) {
            switch (i) {
                case 100:
                    return 1010;
                case 800:
                    return 1008;
                case 801:
                    return 1007;
                default:
                    return 999;
            }
        }
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return 1001;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return 1002;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                return 1003;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                return 1004;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                return 1005;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                return 1006;
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                return 1007;
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                return 1009;
            default:
                return 999;
        }
    }

    public static byte[] m5049a(short[] sArr, int i) {
        byte[] bArr = new byte[(i * 2)];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2 * 2] = (byte) (sArr[i2] & 255);
            bArr[(i2 * 2) + 1] = (byte) (sArr[i2] >> 8);
            sArr[i2] = (short) 0;
        }
        return bArr;
    }
}
