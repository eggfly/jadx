package android.support.v4.util;

public class LruCache<K, V> {
    private int f726a;
    private int f727b;
    private int f728c;

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f727b + this.f728c;
            if (i2 != 0) {
                i = (this.f727b * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f726a), Integer.valueOf(this.f727b), Integer.valueOf(this.f728c), Integer.valueOf(i)});
        }
        return format;
    }
}
