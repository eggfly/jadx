package anet.channel.util;

import anet.channel.GlobalAppRuntimeInfo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/* renamed from: anet.channel.util.h */
public class C0747h {
    public static File m2984a(String str) {
        return new File(GlobalAppRuntimeInfo.getContext().getExternalCacheDir(), str);
    }

    public static synchronized <T> T m2985a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        T t = null;
        synchronized (C0747h.class) {
            FileInputStream fileInputStream2 = null;
            try {
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                        t = objectInputStream.readObject();
                        objectInputStream.close();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            if (ALog.isPrintLog()) {
                                ALog.m2961e("awcn.SerializeHelper", "restore file fail.", null, th, new Object[0]);
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return t;
                        } catch (Throwable th4) {
                            th2 = th4;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    if (ALog.isPrintLog()) {
                        ALog.m2965w("awcn.SerializeHelper", "file not exist.", null, "file", file.getName());
                    }
                    if (null != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th5) {
                fileInputStream = null;
                th2 = th5;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th2;
            }
        }
        return t;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m2986a(java.io.Serializable r13, java.io.File r14) {
        /*
        r0 = 1;
        r4 = 0;
        r2 = 0;
        r5 = anet.channel.util.C0747h.class;
        monitor-enter(r5);
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0073 }
        r1 = java.util.UUID.randomUUID();	 Catch:{ Exception -> 0x0076, all -> 0x009e }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0076, all -> 0x009e }
        r3 = "-";
        r8 = "";
        r1 = r1.replace(r3, r8);	 Catch:{ Exception -> 0x0076, all -> 0x009e }
        r3 = anet.channel.util.C0747h.m2984a(r1);	 Catch:{ Exception -> 0x0076, all -> 0x009e }
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00ca, all -> 0x009e }
        r1.<init>(r3);	 Catch:{ Exception -> 0x00ca, all -> 0x009e }
        r2 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x00ce }
        r8 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x00ce }
        r8.<init>(r1);	 Catch:{ Exception -> 0x00ce }
        r2.<init>(r8);	 Catch:{ Exception -> 0x00ce }
        r2.writeObject(r13);	 Catch:{ Exception -> 0x00ce }
        r2.flush();	 Catch:{ Exception -> 0x00ce }
        r2.close();	 Catch:{ Exception -> 0x00ce }
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();	 Catch:{ IOException -> 0x006e }
    L_0x003b:
        if (r0 == 0) goto L_0x006c;
    L_0x003d:
        r0 = r3.renameTo(r14);	 Catch:{ all -> 0x0073 }
        if (r0 == 0) goto L_0x00ab;
    L_0x0043:
        r0 = "awcn.SerializeHelper";
        r1 = "persist end.";
        r2 = 0;
        r3 = 4;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0073 }
        r4 = 0;
        r8 = "file";
        r3[r4] = r8;	 Catch:{ all -> 0x0073 }
        r4 = 1;
        r8 = r14.getAbsoluteFile();	 Catch:{ all -> 0x0073 }
        r3[r4] = r8;	 Catch:{ all -> 0x0073 }
        r4 = 2;
        r8 = "cost";
        r3[r4] = r8;	 Catch:{ all -> 0x0073 }
        r4 = 3;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0073 }
        r6 = r8 - r6;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0073 }
        r3[r4] = r6;	 Catch:{ all -> 0x0073 }
        anet.channel.util.ALog.m2963i(r0, r1, r2, r3);	 Catch:{ all -> 0x0073 }
    L_0x006c:
        monitor-exit(r5);
        return;
    L_0x006e:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0073 }
        goto L_0x003b;
    L_0x0073:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0076:
        r0 = move-exception;
        r1 = r2;
    L_0x0078:
        r3 = "awcn.SerializeHelper";
        r8 = "persist fail. ";
        r9 = 0;
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x00c8 }
        r11 = 0;
        r12 = "file";
        r10[r11] = r12;	 Catch:{ all -> 0x00c8 }
        r11 = 1;
        r12 = r14.getName();	 Catch:{ all -> 0x00c8 }
        r10[r11] = r12;	 Catch:{ all -> 0x00c8 }
        anet.channel.util.ALog.m2961e(r3, r8, r9, r0, r10);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x00d1;
    L_0x0091:
        r1.close();	 Catch:{ IOException -> 0x0097 }
        r0 = r4;
        r3 = r2;
        goto L_0x003b;
    L_0x0097:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0073 }
        r0 = r4;
        r3 = r2;
        goto L_0x003b;
    L_0x009e:
        r0 = move-exception;
        r1 = r2;
    L_0x00a0:
        if (r1 == 0) goto L_0x00a5;
    L_0x00a2:
        r1.close();	 Catch:{ IOException -> 0x00a6 }
    L_0x00a5:
        throw r0;	 Catch:{ all -> 0x0073 }
    L_0x00a6:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0073 }
        goto L_0x00a5;
    L_0x00ab:
        r0 = "awcn.SerializeHelper";
        r1 = "rename failed.";
        r2 = 0;
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0073 }
        anet.channel.util.ALog.m2962e(r0, r1, r2, r3);	 Catch:{ all -> 0x0073 }
        r0 = anet.channel.appmonitor.AppMonitor.getInstance();	 Catch:{ all -> 0x0073 }
        r1 = new anet.channel.statist.ExceptionStatistic;	 Catch:{ all -> 0x0073 }
        r2 = -106; // 0xffffffffffffff96 float:NaN double:NaN;
        r3 = 0;
        r4 = "rt";
        r1.<init>(r2, r3, r4);	 Catch:{ all -> 0x0073 }
        r0.commitStat(r1);	 Catch:{ all -> 0x0073 }
        goto L_0x006c;
    L_0x00c8:
        r0 = move-exception;
        goto L_0x00a0;
    L_0x00ca:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0078;
    L_0x00ce:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0078;
    L_0x00d1:
        r0 = r4;
        r3 = r2;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.h.a(java.io.Serializable, java.io.File):void");
    }
}
