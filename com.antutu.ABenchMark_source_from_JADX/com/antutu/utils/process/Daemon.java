package com.antutu.utils.process;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.app.IApplicationThread;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.antutu.benchmark.service.BenchmarkMainService;
import com.antutu.utils.process.DaemonSocket.CmdHandler;
import com.antutu.utils.process.DaemonSocket.Server;
import com.igexin.sdk.PushConsts;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

public class Daemon {
    public static final int CURRENT_VERSION = 2;
    private static final String MY_PROCESS_NAME = "/daemon/user/6542";
    private static final int SLEEP_INTERVAL = 300000;
    private static final String TAG;
    private String mCallerId;
    private boolean mCanExit;
    private String mCodePath;
    private Server mListenerServer;
    private String mPackageName;
    private Map<String, String> mReportData;

    /* renamed from: com.antutu.utils.process.Daemon.1 */
    class C18261 implements CmdHandler {

        /* renamed from: com.antutu.utils.process.Daemon.1.1 */
        class C18251 extends TimerTask {
            C18251() {
            }

            public void run() {
                Log.w(Daemon.TAG, "exit daemon with exit cmd");
                System.exit(0);
            }
        }

        C18261() {
        }

        public void onExitReceived() {
            Daemon.this.mCanExit = true;
            Thread.currentThread().interrupt();
            new Timer().schedule(new C18251(), 100);
        }

        public void onNewPidReceived(String str) {
            Daemon.this.mCallerId = str;
        }
    }

    static {
        TAG = Daemon.class.getSimpleName() + "Jacob";
    }

    public Daemon(String str, String str2, String str3, Map<String, String> map) {
        Map hashMap;
        this.mCallerId = str;
        this.mPackageName = str2;
        this.mCodePath = str3;
        if (map == null) {
            hashMap = new HashMap();
        }
        hashMap.put(PushConsts.CMD_ACTION, "uninstall");
        this.mReportData = hashMap;
        this.mCanExit = false;
    }

    private boolean checkPackageExists() {
        File file = new File(this.mCodePath);
        boolean exists = file.exists();
        if (!exists) {
            String pkgNameFromName = getPkgNameFromName(file.getName());
            File file2 = new File(file.getParent(), pkgNameFromName + ".apk");
            if (file2.exists()) {
                exists = true;
            }
            if (!exists) {
                file = file2;
                int i = 0;
                while (i < 10) {
                    Object[] objArr = new Object[CURRENT_VERSION];
                    objArr[0] = pkgNameFromName;
                    objArr[1] = Integer.valueOf(i);
                    String format = String.format("%s-%d.apk", objArr);
                    Log.d(TAG, "test path: " + format);
                    File file3 = new File(file.getParent(), format);
                    if (file3.exists()) {
                        exists = true;
                        break;
                    }
                    i++;
                    file = file3;
                }
            }
        }
        String str = TAG;
        String str2 = "check package exists: %s";
        Object[] objArr2 = new Object[1];
        objArr2[0] = exists ? "exists" : "uninstalled";
        Log.d(str, String.format(str2, objArr2));
        return exists;
    }

    private boolean checkServiceDied() {
        boolean exists = new File(String.format("/proc/%s", new Object[]{this.mCallerId})).exists();
        String str = TAG;
        String str2 = "check pid(%s)'s health: %s";
        Object[] objArr = new Object[CURRENT_VERSION];
        objArr[0] = this.mCallerId;
        objArr[1] = exists ? "active" : "died";
        Log.d(str, String.format(str2, objArr));
        return !exists;
    }

    private void closeListener() {
        Log.e(TAG, "closeListener");
        if (this.mListenerServer != null) {
            this.mListenerServer.interrupt();
            this.mListenerServer = null;
        }
    }

    private String getPkgNameFromName(String str) {
        int lastIndexOf = str.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (lastIndexOf < 0) {
            lastIndexOf = str.lastIndexOf(".");
        }
        String substring = str.substring(0, lastIndexOf);
        Log.d(TAG, "package name: " + substring);
        return substring;
    }

    public static void main(String[] strArr) {
        int i;
        Log.i(TAG, "arguments: " + strArr.length);
        for (i = 0; i < strArr.length; i++) {
            String str = TAG;
            Object[] objArr = new Object[CURRENT_VERSION];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = strArr[i];
            Log.i(str, String.format("\targuments %d: %s", objArr));
        }
        if (strArr.length < 3) {
            Log.e(TAG, "arguments error");
            System.exit(0);
            return;
        }
        setName(MY_PROCESS_NAME);
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = strArr[CURRENT_VERSION];
        Map map = null;
        if (strArr.length >= 4) {
            Map hashMap = new HashMap();
            for (i = 3; i < Math.min(strArr.length, 10); i++) {
                String[] split = strArr[i].split("=");
                if (split.length == CURRENT_VERSION) {
                    hashMap.put(split[0], split[1]);
                }
            }
            map = hashMap;
        }
        new Daemon(str2, str3, str4, map).start();
        Log.w(TAG, "exit Daemon");
        System.exit(0);
    }

    private void reportUninstallBehavior(String str) {
        Log.w(TAG, "report uninstalled");
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append("?");
        if (this.mReportData != null) {
            for (Entry entry : this.mReportData.entrySet()) {
                try {
                    stringBuilder.append((String) entry.getKey()).append("=").append(URLEncoder.encode((String) entry.getValue(), "utf-8")).append("&");
                } catch (Exception e) {
                }
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        Log.w(TAG, "send http request: " + stringBuilder);
        sendHttpRequest(stringBuilder.toString());
    }

    private void restartService() {
        Log.d(TAG, "restart service");
        Intent a = BenchmarkMainService.m6343a();
        IActivityManager iActivityManager = ActivityManagerNative.getDefault();
        try {
            Log.d(TAG, "start service return: " + iActivityManager.getClass().getMethod("startService", new Class[]{IApplicationThread.class, Intent.class, String.class, Integer.TYPE}).invoke(iActivityManager, new Object[]{null, a, a.getType(), Integer.valueOf(0)}));
        } catch (NoSuchMethodException e) {
            try {
                Log.d(TAG, "start service return: " + iActivityManager.getClass().getMethod("startService", new Class[]{IApplicationThread.class, Intent.class, String.class}).invoke(iActivityManager, new Object[]{null, a, a.getType()}));
            } catch (Throwable e2) {
                Log.w(TAG, "startService Method not found", e2);
            } catch (Throwable e22) {
                Log.w(TAG, "start service exception", e22);
            }
        } catch (Throwable e222) {
            Log.w(TAG, "start service exception", e222);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendHttpRequest(java.lang.String r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = 0;
        r2 = r0;
    L_0x0003:
        r0 = new java.net.URL;	 Catch:{ IOException -> 0x007b, all -> 0x0079 }
        r0.<init>(r8);	 Catch:{ IOException -> 0x007b, all -> 0x0079 }
        r0 = r0.openConnection();	 Catch:{ IOException -> 0x007b, all -> 0x0079 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x007b, all -> 0x0079 }
        r1 = r0.getResponseCode();	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 == r1) goto L_0x003c;
    L_0x0016:
        r3 = new java.io.IOException;	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        r4.<init>();	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        r5 = "http ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        r1 = r4.append(r1);	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        r1 = r1.toString();	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        r3.<init>(r1);	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        throw r3;	 Catch:{ IOException -> 0x002f, all -> 0x004a }
    L_0x002f:
        r1 = move-exception;
    L_0x0030:
        r1 = r2 + 1;
        r2 = 10;
        if (r1 < r2) goto L_0x005a;
    L_0x0036:
        if (r0 == 0) goto L_0x003b;
    L_0x0038:
        r0.disconnect();
    L_0x003b:
        return;
    L_0x003c:
        r1 = r0.getInputStream();	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        if (r1 != 0) goto L_0x0054;
    L_0x0042:
        r1 = new java.io.IOException;	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        r3 = "empty status line";
        r1.<init>(r3);	 Catch:{ IOException -> 0x002f, all -> 0x004a }
        throw r1;	 Catch:{ IOException -> 0x002f, all -> 0x004a }
    L_0x004a:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x004e:
        if (r1 == 0) goto L_0x0053;
    L_0x0050:
        r1.disconnect();
    L_0x0053:
        throw r0;
    L_0x0054:
        if (r0 == 0) goto L_0x003b;
    L_0x0056:
        r0.disconnect();
        goto L_0x003b;
    L_0x005a:
        r2 = r1 % 3;
        if (r2 != 0) goto L_0x006c;
    L_0x005e:
        r2 = 600000; // 0x927c0 float:8.40779E-40 double:2.964394E-318;
        java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x0072, all -> 0x004a }
    L_0x0064:
        if (r0 == 0) goto L_0x0069;
    L_0x0066:
        r0.disconnect();
    L_0x0069:
        r2 = r1;
        r1 = r0;
        goto L_0x0003;
    L_0x006c:
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x0072, all -> 0x004a }
        goto L_0x0064;
    L_0x0072:
        r1 = move-exception;
        if (r0 == 0) goto L_0x003b;
    L_0x0075:
        r0.disconnect();
        goto L_0x003b;
    L_0x0079:
        r0 = move-exception;
        goto L_0x004e;
    L_0x007b:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.process.Daemon.sendHttpRequest(java.lang.String):void");
    }

    private static void setName(String str) {
        setShellName(str);
        setProcessName(str);
    }

    private static void setProcessName(String str) {
        Class loadClass;
        try {
            loadClass = ClassLoader.getSystemClassLoader().loadClass("android.ddm.DdmHandleAppName");
        } catch (ClassNotFoundException e) {
            loadClass = null;
        }
        if (loadClass != null) {
            try {
                loadClass.getDeclaredMethod("setAppName", new Class[]{String.class}).invoke(loadClass, new Object[]{str});
            } catch (Throwable e2) {
                try {
                    Class[] clsArr = new Class[CURRENT_VERSION];
                    clsArr[0] = String.class;
                    clsArr[1] = Integer.TYPE;
                    Method declaredMethod = loadClass.getDeclaredMethod("setAppName", clsArr);
                    Object[] objArr = new Object[CURRENT_VERSION];
                    objArr[0] = str;
                    objArr[1] = Integer.valueOf(0);
                    declaredMethod.invoke(loadClass, objArr);
                } catch (Exception e3) {
                    Log.e(TAG, "setProcessName failed", e2);
                }
            } catch (Throwable e22) {
                Log.e(TAG, "setProcessName failed", e22);
            }
        }
    }

    private static void setShellName(String str) {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("setArgV0", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[]{str});
        } catch (Exception e) {
        }
    }

    private boolean setupListener() {
        Server server;
        boolean z = true;
        try {
            server = new Server(new C18261());
        } catch (IOException e) {
            Log.w(TAG, e.getMessage());
            server = null;
            z = false;
        }
        if (z) {
            server.start();
            this.mListenerServer = server;
        }
        return z;
    }

    protected void finalize() {
        closeListener();
        super.finalize();
    }

    public void start() {
        if (setupListener()) {
            while (!this.mCanExit) {
                if (checkServiceDied()) {
                    try {
                        Thread.sleep(300000);
                        if (!checkPackageExists()) {
                            closeListener();
                            this.mCanExit = true;
                            break;
                        }
                        restartService();
                    } catch (InterruptedException e) {
                        Log.w(TAG, "sleep InterruptedException 1");
                    }
                }
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e2) {
                    Log.w(TAG, "sleep InterruptedException 2");
                }
            }
            closeListener();
            return;
        }
        Log.e(TAG, "setupSocketServer failed");
        closeListener();
    }
}
