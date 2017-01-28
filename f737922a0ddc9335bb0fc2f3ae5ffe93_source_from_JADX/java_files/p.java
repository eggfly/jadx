import java.util.LinkedHashMap;

public class p<K, V> {
    private int DW;
    private int FH;
    private int Hw;
    private int VH;
    private int Zo;
    private final LinkedHashMap<K, V> j6;
    private int v5;

    public p(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.FH = i;
        this.j6 = new LinkedHashMap(0, 0.75f, true);
    }

    public final V j6(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.Hw++;
            this.DW += FH(k, v);
            put = this.j6.put(k, v);
            if (put != null) {
                this.DW -= FH(k, put);
            }
        }
        if (put != null) {
            j6(false, k, put, v);
        }
        j6(this.FH);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.DW;	 Catch:{ all -> 0x0033 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r4.j6;	 Catch:{ all -> 0x0033 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0036;
    L_0x000d:
        r0 = r4.DW;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0036;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0033 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0033 }
        r1.<init>();	 Catch:{ all -> 0x0033 }
        r2 = r4.getClass();	 Catch:{ all -> 0x0033 }
        r2 = r2.getName();	 Catch:{ all -> 0x0033 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0033 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0033 }
        r1 = r1.toString();	 Catch:{ all -> 0x0033 }
        r0.<init>(r1);	 Catch:{ all -> 0x0033 }
        throw r0;	 Catch:{ all -> 0x0033 }
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0033 }
        throw r0;
    L_0x0036:
        r0 = r4.DW;	 Catch:{ all -> 0x0033 }
        if (r0 <= r5) goto L_0x0042;
    L_0x003a:
        r0 = r4.j6;	 Catch:{ all -> 0x0033 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0044;
    L_0x0042:
        monitor-exit(r4);	 Catch:{ all -> 0x0033 }
        return;
    L_0x0044:
        r0 = r4.j6;	 Catch:{ all -> 0x0033 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0033 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0033 }
        r0 = r0.next();	 Catch:{ all -> 0x0033 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0033 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0033 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0033 }
        r2 = r4.j6;	 Catch:{ all -> 0x0033 }
        r2.remove(r1);	 Catch:{ all -> 0x0033 }
        r2 = r4.DW;	 Catch:{ all -> 0x0033 }
        r3 = r4.FH(r1, r0);	 Catch:{ all -> 0x0033 }
        r2 = r2 - r3;
        r4.DW = r2;	 Catch:{ all -> 0x0033 }
        r2 = r4.v5;	 Catch:{ all -> 0x0033 }
        r2 = r2 + 1;
        r4.v5 = r2;	 Catch:{ all -> 0x0033 }
        monitor-exit(r4);	 Catch:{ all -> 0x0033 }
        r2 = 1;
        r3 = 0;
        r4.j6(r2, r1, r0, r3);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: p.j6(int):void");
    }

    protected void j6(boolean z, K k, V v, V v2) {
    }

    private int FH(K k, V v) {
        int DW = DW(k, v);
        if (DW >= 0) {
            return DW;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int DW(K k, V v) {
        return 1;
    }

    public final void j6() {
        j6(-1);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.Zo + this.VH;
            if (i2 != 0) {
                i = (this.Zo * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.FH), Integer.valueOf(this.Zo), Integer.valueOf(this.VH), Integer.valueOf(i)});
        }
        return format;
    }
}
