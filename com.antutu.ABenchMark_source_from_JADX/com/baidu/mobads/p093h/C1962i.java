package com.baidu.mobads.p093h;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.baidu.mobads.h.i */
class C1962i extends Handler {
    final /* synthetic */ C1960g f6844a;

    C1962i(C1960g c1960g, Looper looper) {
        this.f6844a = c1960g;
        super(looper);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r8) {
        /*
        r7 = this;
        r3 = 2;
        r6 = 1;
        r5 = 0;
        r0 = r8.getData();
        r1 = "CODE";
        r1 = r0.getString(r1);
        r0 = r8.getData();
        r2 = "APK_INFO";
        r0 = r0.getParcelable(r2);
        r0 = (com.baidu.mobads.p093h.C1955e) r0;
        r2 = "OK";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x00a4;
    L_0x0021:
        r1 = new com.baidu.mobads.h.b;
        r2 = r0.m7315e();
        r3 = r7.f6844a;
        r3 = r3.f6841k;
        r1.<init>(r2, r3, r0);
        r2 = r7.f6844a;	 Catch:{ a -> 0x0069 }
        r2 = r2.f6837f;	 Catch:{ a -> 0x0069 }
        r3 = com.baidu.mobads.p093h.C1960g.f6834e;	 Catch:{ a -> 0x0069 }
        if (r2 != r3) goto L_0x0054;
    L_0x0038:
        r1.m7296a();	 Catch:{ a -> 0x0069 }
        r2 = r7.f6844a;	 Catch:{ a -> 0x0069 }
        r2 = r2.m7352e();	 Catch:{ a -> 0x0069 }
        r1.m7297a(r2);	 Catch:{ a -> 0x0069 }
        r2 = com.baidu.mobads.p093h.C1960g.f6832b;	 Catch:{ a -> 0x0069 }
        if (r2 == 0) goto L_0x0050;
    L_0x0048:
        r2 = com.baidu.mobads.p093h.C1960g.f6832b;	 Catch:{ a -> 0x0069 }
        r4 = r0.m7312b();	 Catch:{ a -> 0x0069 }
        r2.f6800a = r4;	 Catch:{ a -> 0x0069 }
    L_0x0050:
        r1.delete();
    L_0x0053:
        return;
    L_0x0054:
        r0 = r7.f6844a;	 Catch:{ a -> 0x0069 }
        r0.m7323a(r1);	 Catch:{ a -> 0x0069 }
        r0 = r7.f6844a;	 Catch:{ a -> 0x0069 }
        r0 = r0.m7352e();	 Catch:{ a -> 0x0069 }
        r1.m7297a(r0);	 Catch:{ a -> 0x0069 }
        r0 = r7.f6844a;	 Catch:{ a -> 0x0069 }
        r2 = 1;
        r0.m7328a(r2);	 Catch:{ a -> 0x0069 }
        goto L_0x0050;
    L_0x0069:
        r0 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
        r2.<init>();	 Catch:{ all -> 0x009f }
        r3 = "download apk file failed: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x009f }
        r0 = r0.toString();	 Catch:{ all -> 0x009f }
        r0 = r2.append(r0);	 Catch:{ all -> 0x009f }
        r0 = r0.toString();	 Catch:{ all -> 0x009f }
        r2 = r7.f6844a;	 Catch:{ all -> 0x009f }
        r3 = 0;
        r2.m7328a(r3);	 Catch:{ all -> 0x009f }
        r2 = r7.f6844a;	 Catch:{ all -> 0x009f }
        r2 = r2.f6842l;	 Catch:{ all -> 0x009f }
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x009f }
        r4 = 0;
        r5 = "XAdApkLoader";
        r3[r4] = r5;	 Catch:{ all -> 0x009f }
        r4 = 1;
        r3[r4] = r0;	 Catch:{ all -> 0x009f }
        r2.m7400e(r3);	 Catch:{ all -> 0x009f }
        r1.delete();
        goto L_0x0053;
    L_0x009f:
        r0 = move-exception;
        r1.delete();
        throw r0;
    L_0x00a4:
        r0 = r7.f6844a;
        r0 = r0.f6842l;
        r2 = new java.lang.Object[r3];
        r3 = "XAdApkLoader";
        r2[r5] = r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "mOnApkDownloadCompleted: download failed, code: ";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        r2[r6] = r1;
        r0.m7400e(r2);
        r0 = r7.f6844a;
        r0.m7328a(r5);
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.i.handleMessage(android.os.Message):void");
    }
}
