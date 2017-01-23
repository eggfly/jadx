package com.google.android.gms.common.stats;

import r;

public class e {
    private final int DW;
    private final r<String, Long> FH;
    private final long j6;

    public e() {
        this.j6 = 60000;
        this.DW = 10;
        this.FH = new r(10);
    }

    public e(int i, long j) {
        this.j6 = j;
        this.DW = i;
        this.FH = new r();
    }

    private void j6(long j, long j2) {
        for (int size = this.FH.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.FH.FH(size)).longValue() > j) {
                this.FH.Hw(size);
            }
        }
    }

    public boolean DW(String str) {
        boolean z;
        synchronized (this) {
            z = this.FH.remove(str) != null;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Long j6(java.lang.String r9) {
        /*
        r8 = this;
        r2 = android.os.SystemClock.elapsedRealtime();
        r0 = r8.j6;
        monitor-enter(r8);
    L_0x0007:
        r4 = r8.FH;	 Catch:{ all -> 0x0041 }
        r4 = r4.size();	 Catch:{ all -> 0x0041 }
        r5 = r8.DW;	 Catch:{ all -> 0x0041 }
        if (r4 < r5) goto L_0x0044;
    L_0x0011:
        r8.j6(r0, r2);	 Catch:{ all -> 0x0041 }
        r4 = 2;
        r0 = r0 / r4;
        r4 = "ConnectionTracker";
        r5 = r8.DW;	 Catch:{ all -> 0x0041 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r7 = 94;
        r6.<init>(r7);	 Catch:{ all -> 0x0041 }
        r7 = "The max capacity ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0041 }
        r5 = r6.append(r5);	 Catch:{ all -> 0x0041 }
        r6 = " is not enough. Current durationThreshold is: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0041 }
        r5 = r5.append(r0);	 Catch:{ all -> 0x0041 }
        r5 = r5.toString();	 Catch:{ all -> 0x0041 }
        android.util.Log.w(r4, r5);	 Catch:{ all -> 0x0041 }
        goto L_0x0007;
    L_0x0041:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0041 }
        throw r0;
    L_0x0044:
        r0 = r8.FH;	 Catch:{ all -> 0x0041 }
        r1 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0041 }
        r0 = r0.put(r9, r1);	 Catch:{ all -> 0x0041 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x0041 }
        monitor-exit(r8);	 Catch:{ all -> 0x0041 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.stats.e.j6(java.lang.String):java.lang.Long");
    }
}
