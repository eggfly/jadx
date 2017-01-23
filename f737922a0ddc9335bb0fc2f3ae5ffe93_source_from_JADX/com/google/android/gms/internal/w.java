package com.google.android.gms.internal;

public final class w {
    public static final long[] DW;
    public static final float[] FH;
    public static final double[] Hw;
    public static final byte[][] VH;
    public static final String[] Zo;
    public static final byte[] gn;
    public static final int[] j6;
    public static final boolean[] v5;

    static {
        j6 = new int[0];
        DW = new long[0];
        FH = new float[0];
        Hw = new double[0];
        v5 = new boolean[0];
        Zo = new String[0];
        VH = new byte[0][];
        gn = new byte[0];
    }

    public static int DW(int i) {
        return i >>> 3;
    }

    public static final int DW(l lVar, int i) {
        int i2 = 1;
        int aM = lVar.aM();
        lVar.DW(i);
        while (lVar.j6() == i) {
            lVar.DW(i);
            i2++;
        }
        lVar.v5(aM);
        return i2;
    }

    static int j6(int i) {
        return i & 7;
    }

    public static int j6(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean j6(l lVar, int i) {
        return lVar.DW(i);
    }
}
