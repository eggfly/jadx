package android.support.v4.util;

public final class CircularArray<E> {
    private E[] f712a;
    private int f713b;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        if (Integer.bitCount(i) != 1) {
            i = 1 << (Integer.highestOneBit(i) + 1);
        }
        this.f713b = i - 1;
        this.f712a = new Object[i];
    }
}
