package com.google.android.gms.internal;

import agb;
import agd;
import agf;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.b;

public class hy {
    private static String DW;
    private static boolean FH;
    private static String j6;
    private boolean EQ;
    private final WakeLock Hw;
    private int J0;
    private final String VH;
    private final int Zo;
    private final String gn;
    private final Context tp;
    private final String u7;
    private WorkSource v5;
    private int we;

    static {
        j6 = "WakeLock";
        DW = "*gcore*:";
        FH = false;
    }

    public hy(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public hy(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public hy(Context context, int i, String str, String str2, String str3, String str4) {
        this.EQ = true;
        b.j6(str, (Object) "Wake lock name can NOT be empty");
        this.Zo = i;
        this.gn = str2;
        this.u7 = str4;
        this.tp = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.VH = str;
        } else {
            String valueOf = String.valueOf(DW);
            String valueOf2 = String.valueOf(str);
            this.VH = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.Hw = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (agf.j6(this.tp)) {
            if (agd.j6(str3)) {
                str3 = context.getPackageName();
            }
            this.v5 = agf.j6(context, str3);
            j6(this.v5);
        }
    }

    private boolean DW(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.gn)) ? false : true;
    }

    private String j6(String str, boolean z) {
        return this.EQ ? z ? str : this.gn : this.gn;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j6(java.lang.String r10) {
        /*
        r9 = this;
        r0 = r9.DW(r10);
        r5 = r9.j6(r10, r0);
        monitor-enter(r9);
        r1 = r9.EQ;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r9.we;	 Catch:{ all -> 0x0045 }
        r1 = r1 + -1;
        r9.we = r1;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0020;
    L_0x0015:
        if (r0 != 0) goto L_0x0020;
    L_0x0017:
        r0 = r9.EQ;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0043;
    L_0x001b:
        r0 = r9.J0;	 Catch:{ all -> 0x0045 }
        r1 = 1;
        if (r0 != r1) goto L_0x0043;
    L_0x0020:
        r0 = com.google.android.gms.common.stats.h.j6();	 Catch:{ all -> 0x0045 }
        r1 = r9.tp;	 Catch:{ all -> 0x0045 }
        r2 = r9.Hw;	 Catch:{ all -> 0x0045 }
        r2 = com.google.android.gms.common.stats.f.j6(r2, r5);	 Catch:{ all -> 0x0045 }
        r3 = 8;
        r4 = r9.VH;	 Catch:{ all -> 0x0045 }
        r6 = r9.u7;	 Catch:{ all -> 0x0045 }
        r7 = r9.Zo;	 Catch:{ all -> 0x0045 }
        r8 = r9.v5;	 Catch:{ all -> 0x0045 }
        r8 = agf.DW(r8);	 Catch:{ all -> 0x0045 }
        r0.j6(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0045 }
        r0 = r9.J0;	 Catch:{ all -> 0x0045 }
        r0 = r0 + -1;
        r9.J0 = r0;	 Catch:{ all -> 0x0045 }
    L_0x0043:
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        return;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.hy.j6(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j6(java.lang.String r13, long r14) {
        /*
        r12 = this;
        r0 = r12.DW(r13);
        r6 = r12.j6(r13, r0);
        monitor-enter(r12);
        r1 = r12.EQ;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r12.we;	 Catch:{ all -> 0x0044 }
        r2 = r1 + 1;
        r12.we = r2;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x001f;
    L_0x0015:
        if (r0 != 0) goto L_0x001f;
    L_0x0017:
        r0 = r12.EQ;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001b:
        r0 = r12.J0;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001f:
        r1 = com.google.android.gms.common.stats.h.j6();	 Catch:{ all -> 0x0044 }
        r2 = r12.tp;	 Catch:{ all -> 0x0044 }
        r0 = r12.Hw;	 Catch:{ all -> 0x0044 }
        r3 = com.google.android.gms.common.stats.f.j6(r0, r6);	 Catch:{ all -> 0x0044 }
        r4 = 7;
        r5 = r12.VH;	 Catch:{ all -> 0x0044 }
        r7 = r12.u7;	 Catch:{ all -> 0x0044 }
        r8 = r12.Zo;	 Catch:{ all -> 0x0044 }
        r0 = r12.v5;	 Catch:{ all -> 0x0044 }
        r9 = agf.DW(r0);	 Catch:{ all -> 0x0044 }
        r10 = r14;
        r1.j6(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0044 }
        r0 = r12.J0;	 Catch:{ all -> 0x0044 }
        r0 = r0 + 1;
        r12.J0 = r0;	 Catch:{ all -> 0x0044 }
    L_0x0042:
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        return;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.hy.j6(java.lang.String, long):void");
    }

    public boolean DW() {
        return this.Hw.isHeld();
    }

    public void j6() {
        j6(null);
        this.Hw.release();
    }

    public void j6(long j) {
        if (!agb.FH() && this.EQ) {
            String str = j6;
            String str2 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ";
            String valueOf = String.valueOf(this.VH);
            Log.wtf(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        j6(null, j);
        this.Hw.acquire(j);
    }

    public void j6(WorkSource workSource) {
        if (workSource != null && agf.j6(this.tp)) {
            if (this.v5 != null) {
                this.v5.add(workSource);
            } else {
                this.v5 = workSource;
            }
            this.Hw.setWorkSource(this.v5);
        }
    }

    public void j6(boolean z) {
        this.Hw.setReferenceCounted(z);
        this.EQ = z;
    }
}
