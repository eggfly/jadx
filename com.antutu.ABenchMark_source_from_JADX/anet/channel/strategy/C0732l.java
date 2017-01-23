package anet.channel.strategy;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import anet.channel.util.C0747h;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

/* renamed from: anet.channel.strategy.l */
class C0732l {
    private static File f2414a;

    static {
        f2414a = null;
    }

    C0732l() {
    }

    public static File m2941a(String str) {
        C0732l.m2944a(f2414a);
        return new File(f2414a, str);
    }

    public static void m2942a() {
        try {
            if (GlobalAppRuntimeInfo.getContext() != null) {
                f2414a = new File(GlobalAppRuntimeInfo.getContext().getExternalFilesDir(null), "awcn_strategy");
                if (!C0732l.m2944a(f2414a)) {
                    ALog.m2962e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f2414a.getAbsolutePath());
                }
                if (!GlobalAppRuntimeInfo.isTargetProcess()) {
                    String currentProcess = GlobalAppRuntimeInfo.getCurrentProcess();
                    f2414a = new File(f2414a, currentProcess.substring(currentProcess.indexOf(58) + 1));
                    if (!C0732l.m2944a(f2414a)) {
                        ALog.m2962e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f2414a.getAbsolutePath());
                    }
                }
                C0732l.m2948d();
            }
        } catch (Throwable th) {
            ALog.m2961e("awcn.StrategySerializeHelper", "StrategySerializeHelper initialize failed!!!", null, th, new Object[0]);
        }
    }

    static synchronized void m2943a(Serializable serializable, String str) {
        synchronized (C0732l.class) {
            C0747h.m2986a(serializable, C0732l.m2941a(str));
        }
    }

    private static boolean m2944a(File file) {
        return (file == null || file.exists()) ? true : file.mkdir();
    }

    static synchronized <T> T m2945b(String str) {
        T a;
        synchronized (C0732l.class) {
            a = C0747h.m2985a(C0732l.m2941a(str));
        }
        return a;
    }

    static synchronized void m2946b() {
        synchronized (C0732l.class) {
            ALog.m2963i("awcn.StrategySerializeHelper", "clear start.", null, new Object[0]);
            if (f2414a != null) {
                File[] listFiles = f2414a.listFiles();
                if (listFiles != null) {
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                    ALog.m2963i("awcn.StrategySerializeHelper", "clear end.", null, new Object[0]);
                }
            }
        }
    }

    static synchronized File[] m2947c() {
        File[] fileArr;
        synchronized (C0732l.class) {
            if (f2414a == null) {
                fileArr = null;
            } else {
                fileArr = f2414a.listFiles();
                if (fileArr != null) {
                    Arrays.sort(fileArr, new C0733m());
                }
            }
        }
        return fileArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m2948d() {
        /*
        r0 = 0;
        r3 = anet.channel.strategy.C0732l.class;
        monitor-enter(r3);
        r4 = anet.channel.strategy.C0732l.m2947c();	 Catch:{ all -> 0x0043 }
        if (r4 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r3);
        return;
    L_0x000c:
        r2 = r0;
    L_0x000d:
        r1 = r4.length;	 Catch:{ all -> 0x0043 }
        if (r2 >= r1) goto L_0x000a;
    L_0x0010:
        r5 = r4[r2];	 Catch:{ all -> 0x0043 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0043 }
        r8 = r5.lastModified();	 Catch:{ all -> 0x0043 }
        r6 = r6 - r8;
        r8 = 604800000; // 0x240c8400 float:3.046947E-17 double:2.988109026E-315;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 < 0) goto L_0x0029;
    L_0x0022:
        r5.delete();	 Catch:{ all -> 0x0043 }
    L_0x0025:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x000d;
    L_0x0029:
        r1 = r5.getName();	 Catch:{ all -> 0x0043 }
        r6 = "config";
        r1 = r1.equalsIgnoreCase(r6);	 Catch:{ all -> 0x0043 }
        if (r1 != 0) goto L_0x0025;
    L_0x0035:
        r1 = r0 + 1;
        r6 = (long) r0;	 Catch:{ all -> 0x0043 }
        r8 = 10;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0041;
    L_0x003e:
        r5.delete();	 Catch:{ all -> 0x0043 }
    L_0x0041:
        r0 = r1;
        goto L_0x0025;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.l.d():void");
    }
}
