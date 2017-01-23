package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class hz {
    protected static final Comparator<byte[]> j6;
    private List<byte[]> DW;
    private List<byte[]> FH;
    private int Hw;
    private final int v5;

    class 1 implements Comparator<byte[]> {
        1() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((byte[]) obj, (byte[]) obj2);
        }

        public int j6(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    static {
        j6 = new 1();
    }

    public hz(int i) {
        this.DW = new LinkedList();
        this.FH = new ArrayList(64);
        this.Hw = 0;
        this.v5 = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void j6() {
        /*
        r2 = this;
        monitor-enter(r2);
    L_0x0001:
        r0 = r2.Hw;	 Catch:{ all -> 0x001d }
        r1 = r2.v5;	 Catch:{ all -> 0x001d }
        if (r0 <= r1) goto L_0x0020;
    L_0x0007:
        r0 = r2.DW;	 Catch:{ all -> 0x001d }
        r1 = 0;
        r0 = r0.remove(r1);	 Catch:{ all -> 0x001d }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x001d }
        r1 = r2.FH;	 Catch:{ all -> 0x001d }
        r1.remove(r0);	 Catch:{ all -> 0x001d }
        r1 = r2.Hw;	 Catch:{ all -> 0x001d }
        r0 = r0.length;	 Catch:{ all -> 0x001d }
        r0 = r1 - r0;
        r2.Hw = r0;	 Catch:{ all -> 0x001d }
        goto L_0x0001;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0020:
        monitor-exit(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.hz.j6():void");
    }

    public synchronized void j6(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.v5) {
                this.DW.add(bArr);
                int binarySearch = Collections.binarySearch(this.FH, bArr, j6);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.FH.add(binarySearch, bArr);
                this.Hw += bArr.length;
                j6();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] j6(int r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 0;
        r1 = r0;
    L_0x0003:
        r0 = r4.FH;	 Catch:{ all -> 0x002f }
        r0 = r0.size();	 Catch:{ all -> 0x002f }
        if (r1 >= r0) goto L_0x002c;
    L_0x000b:
        r0 = r4.FH;	 Catch:{ all -> 0x002f }
        r0 = r0.get(r1);	 Catch:{ all -> 0x002f }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x002f }
        r2 = r0.length;	 Catch:{ all -> 0x002f }
        if (r2 < r5) goto L_0x0028;
    L_0x0016:
        r2 = r4.Hw;	 Catch:{ all -> 0x002f }
        r3 = r0.length;	 Catch:{ all -> 0x002f }
        r2 = r2 - r3;
        r4.Hw = r2;	 Catch:{ all -> 0x002f }
        r2 = r4.FH;	 Catch:{ all -> 0x002f }
        r2.remove(r1);	 Catch:{ all -> 0x002f }
        r1 = r4.DW;	 Catch:{ all -> 0x002f }
        r1.remove(r0);	 Catch:{ all -> 0x002f }
    L_0x0026:
        monitor-exit(r4);
        return r0;
    L_0x0028:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0003;
    L_0x002c:
        r0 = new byte[r5];	 Catch:{ all -> 0x002f }
        goto L_0x0026;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.hz.j6(int):byte[]");
    }
}
