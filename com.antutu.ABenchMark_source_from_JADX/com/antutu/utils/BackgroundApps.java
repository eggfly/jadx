package com.antutu.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.antutu.utils.cache.HomeInfoCache;
import com.umeng.analytics.C4156a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BackgroundApps {
    private static final int MAXAPPNUM = 50;
    private static final String fileURI = "http://autovote.antutu.net/chart/secapps/secapps.txt";
    private static boolean isUpdating;
    private String appListStr;

    /* renamed from: com.antutu.utils.BackgroundApps.1 */
    class C17831 extends Thread {
        final /* synthetic */ Context val$context;

        C17831(Context context) {
            this.val$context = context;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r7 = this;
            r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0078 }
            r1.<init>();	 Catch:{ Exception -> 0x0078 }
            r0 = com.antutu.utils.BackgroundApps.this;	 Catch:{ Exception -> 0x0078 }
            r2 = r7.val$context;	 Catch:{ Exception -> 0x0078 }
            r2 = r0.getSecApps(r2);	 Catch:{ Exception -> 0x0078 }
            r0 = r7.val$context;	 Catch:{ Exception -> 0x0078 }
            r3 = r0.getPackageManager();	 Catch:{ Exception -> 0x0078 }
            r0 = r7.val$context;	 Catch:{ Exception -> 0x0078 }
            r4 = "activity";
            r0 = r0.getSystemService(r4);	 Catch:{ Exception -> 0x0078 }
            r0 = (android.app.ActivityManager) r0;	 Catch:{ Exception -> 0x0078 }
            r0 = r0.getRunningAppProcesses();	 Catch:{ Exception -> 0x0078 }
            r4 = com.antutu.utils.BackgroundApps.this;	 Catch:{ Exception -> 0x0078 }
            r5 = "";
            r4.appListStr = r5;	 Catch:{ Exception -> 0x0078 }
            if (r0 == 0) goto L_0x0079;
        L_0x002a:
            if (r3 == 0) goto L_0x0079;
        L_0x002c:
            r4 = r0.iterator();	 Catch:{ Exception -> 0x0078 }
        L_0x0030:
            r0 = r4.hasNext();	 Catch:{ Exception -> 0x0078 }
            if (r0 == 0) goto L_0x0045;
        L_0x0036:
            r0 = r4.next();	 Catch:{ Exception -> 0x0078 }
            r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0;	 Catch:{ Exception -> 0x0078 }
            r5 = r0.pkgList;	 Catch:{ Exception -> 0x0078 }
            if (r5 == 0) goto L_0x0045;
        L_0x0040:
            r5 = r0.pkgList;	 Catch:{ Exception -> 0x0078 }
            r5 = r5.length;	 Catch:{ Exception -> 0x0078 }
            if (r5 > 0) goto L_0x007d;
        L_0x0045:
            r1 = r1.iterator();	 Catch:{ Exception -> 0x0078 }
        L_0x0049:
            r0 = r1.hasNext();	 Catch:{ Exception -> 0x0078 }
            if (r0 == 0) goto L_0x0079;
        L_0x004f:
            r0 = r1.next();	 Catch:{ Exception -> 0x0078 }
            r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0078 }
            r2 = com.antutu.utils.BackgroundApps.this;	 Catch:{ Exception -> 0x0078 }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0078 }
            r3.<init>();	 Catch:{ Exception -> 0x0078 }
            r4 = com.antutu.utils.BackgroundApps.this;	 Catch:{ Exception -> 0x0078 }
            r4 = r4.appListStr;	 Catch:{ Exception -> 0x0078 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x0078 }
            r4 = "\n";
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x0078 }
            r0 = r3.append(r0);	 Catch:{ Exception -> 0x0078 }
            r0 = r0.toString();	 Catch:{ Exception -> 0x0078 }
            r2.appListStr = r0;	 Catch:{ Exception -> 0x0078 }
            goto L_0x0049;
        L_0x0078:
            r0 = move-exception;
        L_0x0079:
            super.run();
            return;
        L_0x007d:
            r0 = r0.pkgList;	 Catch:{ Exception -> 0x0078 }
            r5 = 0;
            r0 = r0[r5];	 Catch:{ Exception -> 0x0078 }
            r5 = 1;
            r0 = r3.getPackageInfo(r0, r5);	 Catch:{ Exception -> 0x0078 }
            r5 = com.antutu.utils.BackgroundApps.this;	 Catch:{ Exception -> 0x0078 }
            r6 = r0.applicationInfo;	 Catch:{ Exception -> 0x0078 }
            r5 = r5.filterApps(r6, r2);	 Catch:{ Exception -> 0x0078 }
            if (r5 == 0) goto L_0x0030;
        L_0x0091:
            r0 = r0.applicationInfo;	 Catch:{ Exception -> 0x0078 }
            r0 = r0.loadLabel(r3);	 Catch:{ Exception -> 0x0078 }
            r0 = r0.toString();	 Catch:{ Exception -> 0x0078 }
            r1.remove(r0);	 Catch:{ Exception -> 0x0078 }
            r1.add(r0);	 Catch:{ Exception -> 0x0078 }
            goto L_0x0030;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.BackgroundApps.1.run():void");
        }
    }

    /* renamed from: com.antutu.utils.BackgroundApps.2 */
    static class C17842 extends Thread {
        final /* synthetic */ Context val$context;

        C17842(Context context) {
            this.val$context = context;
        }

        public void run() {
            super.run();
            BackgroundApps.isUpdating = true;
            BackgroundApps.updateListFile(this.val$context);
            BackgroundApps.isUpdating = false;
        }
    }

    static {
        isUpdating = false;
    }

    public BackgroundApps() {
        this.appListStr = BuildConfig.FLAVOR;
    }

    private boolean filterApps(ApplicationInfo applicationInfo, List<String> list) {
        if ((applicationInfo.flags & 1) != 0) {
            return false;
        }
        for (String equals : list) {
            if (equals.equals(applicationInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    private List<String> getSecApps(Context context) {
        String readLine;
        int i = 0;
        List<String> arrayList = new ArrayList();
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(String.format("%s/secapps.txt", new Object[]{context.getFilesDir().getAbsolutePath()}))));
            for (int i2 = 0; i2 < MAXAPPNUM; i2++) {
                readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.isEmpty()) {
                    arrayList.add(jni.getStringSafe(readLine, BuildConfig.FLAVOR));
                }
            }
            lineNumberReader.close();
        } catch (Exception e) {
        }
        if (arrayList.size() <= 0) {
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(new InputStreamReader(context.getAssets().open("secapps.txt")));
                while (i < MAXAPPNUM) {
                    readLine = lineNumberReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!readLine.isEmpty()) {
                        arrayList.add(jni.getStringSafe(readLine, BuildConfig.FLAVOR));
                    }
                    i++;
                }
                lineNumberReader2.close();
            } catch (Exception e2) {
            }
        }
        return arrayList;
    }

    public static void updateAppsListFile(Context context) {
        if (!isUpdating) {
            try {
                new C17842(context).start();
            } catch (Exception e) {
            }
        }
    }

    private static void updateListFile(Context context) {
        int i = 0;
        try {
            if (context.getFilesDir() != null) {
                String format = String.format("%s/secapps.txt", new Object[]{context.getFilesDir().getAbsolutePath()});
                String format2 = String.format("%s/secapps_new.txt", new Object[]{r2.getAbsolutePath()});
                File file = new File(format);
                File file2 = new File(format2);
                if (file.exists() && file.isFile()) {
                    if (System.currentTimeMillis() - HomeInfoCache.getInstance().getInfo().getTime() < C4156a.f13948j) {
                        return;
                    }
                }
                file2.delete();
                InputStream inputStream = new URL(fileURI).openConnection().getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(format2);
                byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                    fileOutputStream.write(bArr, 0, read);
                }
                if (i < 10) {
                    file2.delete();
                    return;
                }
                LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(format2)));
                List arrayList = new ArrayList();
                for (int i2 = 1; i2 < MAXAPPNUM; i2++) {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!readLine.isEmpty()) {
                        arrayList.add(jni.getStringSafe(readLine, BuildConfig.FLAVOR));
                    }
                }
                lineNumberReader.close();
                if (arrayList.size() > 0) {
                    file.delete();
                    file2.renameTo(file);
                    return;
                }
                file2.delete();
            }
        } catch (Exception e) {
        }
    }

    public void checkRunningApps(Context context) {
        new C17831(context).start();
    }

    public String getAppList() {
        return this.appListStr;
    }
}
