package android.support.v4.util;

public final class CircularIntArray {
    private int[] f714a;
    private int f715b;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        if (Integer.bitCount(i) != 1) {
            i = 1 << (Integer.highestOneBit(i) + 1);
        }
        this.f715b = i - 1;
        this.f714a = new int[i];
    }
}
