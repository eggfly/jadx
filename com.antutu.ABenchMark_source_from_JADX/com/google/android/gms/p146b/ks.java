package com.google.android.gms.p146b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.google.android.gms.b.ks */
public class ks {
    protected static final Comparator<byte[]> f11676a;
    private List<byte[]> f11677b;
    private List<byte[]> f11678c;
    private int f11679d;
    private final int f11680e;

    /* renamed from: com.google.android.gms.b.ks.1 */
    static class C33411 implements Comparator<byte[]> {
        C33411() {
        }

        public int m13733a(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m13733a((byte[]) obj, (byte[]) obj2);
        }
    }

    static {
        f11676a = new C33411();
    }

    public ks(int i) {
        this.f11677b = new LinkedList();
        this.f11678c = new ArrayList(64);
        this.f11679d = 0;
        this.f11680e = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m13734a() {
        /*
        r2 = this;
        monitor-enter(r2);
    L_0x0001:
        r0 = r2.f11679d;	 Catch:{ all -> 0x001d }
        r1 = r2.f11680e;	 Catch:{ all -> 0x001d }
        if (r0 <= r1) goto L_0x0020;
    L_0x0007:
        r0 = r2.f11677b;	 Catch:{ all -> 0x001d }
        r1 = 0;
        r0 = r0.remove(r1);	 Catch:{ all -> 0x001d }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x001d }
        r1 = r2.f11678c;	 Catch:{ all -> 0x001d }
        r1.remove(r0);	 Catch:{ all -> 0x001d }
        r1 = r2.f11679d;	 Catch:{ all -> 0x001d }
        r0 = r0.length;	 Catch:{ all -> 0x001d }
        r0 = r1 - r0;
        r2.f11679d = r0;	 Catch:{ all -> 0x001d }
        goto L_0x0001;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0020:
        monitor-exit(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ks.a():void");
    }

    public synchronized void m13735a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f11680e) {
                this.f11677b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f11678c, bArr, f11676a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f11678c.add(binarySearch, bArr);
                this.f11679d += bArr.length;
                m13734a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] m13736a(int r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 0;
        r1 = r0;
    L_0x0003:
        r0 = r4.f11678c;	 Catch:{ all -> 0x002f }
        r0 = r0.size();	 Catch:{ all -> 0x002f }
        if (r1 >= r0) goto L_0x002c;
    L_0x000b:
        r0 = r4.f11678c;	 Catch:{ all -> 0x002f }
        r0 = r0.get(r1);	 Catch:{ all -> 0x002f }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x002f }
        r2 = r0.length;	 Catch:{ all -> 0x002f }
        if (r2 < r5) goto L_0x0028;
    L_0x0016:
        r2 = r4.f11679d;	 Catch:{ all -> 0x002f }
        r3 = r0.length;	 Catch:{ all -> 0x002f }
        r2 = r2 - r3;
        r4.f11679d = r2;	 Catch:{ all -> 0x002f }
        r2 = r4.f11678c;	 Catch:{ all -> 0x002f }
        r2.remove(r1);	 Catch:{ all -> 0x002f }
        r1 = r4.f11677b;	 Catch:{ all -> 0x002f }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ks.a(int):byte[]");
    }
}
