public final class yp {
    public static boolean j6(int i) {
        if (i < -1) {
            return false;
        }
        if (i == -1) {
            return true;
        }
        int i2 = i & 255;
        if (i2 == 0 || i2 == 255 || (65280 & i) == 0) {
            return true;
        }
        return false;
    }

    public static boolean DW(int i) {
        return i >= 255;
    }
}
