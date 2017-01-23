package com.xiaomi.mistatistic.sdk.controller;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.k */
public class C0573k {
    public static String f4755a;
    private static ExecutorService f4756b;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.k.1 */
    final class C05721 implements Runnable {
        final /* synthetic */ Editor f4754a;

        C05721(Editor editor) {
            this.f4754a = editor;
        }

        public void run() {
            this.f4754a.commit();
        }
    }

    static {
        f4755a = null;
        f4756b = Executors.newSingleThreadExecutor();
    }

    public static int m6443a(Context context, String str, int i) {
        return context.getSharedPreferences(C0573k.m6445a(context), 0).getInt(str, i);
    }

    public static long m6444a(Context context, String str, long j) {
        return context.getSharedPreferences(C0573k.m6445a(context), 0).getLong(str, j);
    }

    public static String m6446a(Context context, String str, String str2) {
        return context.getSharedPreferences(C0573k.m6445a(context), 0).getString(str, str2);
    }

    public static void m6450b(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences(C0573k.m6445a(context), 0).edit();
        edit.putInt(str, i);
        C0573k.m6447a(edit);
    }

    public static void m6451b(Context context, String str, long j) {
        Editor edit = context.getSharedPreferences(C0573k.m6445a(context), 0).edit();
        edit.putLong(str, j);
        C0573k.m6447a(edit);
    }

    public static void m6452b(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences(C0573k.m6445a(context), 0).edit();
        edit.putString(str, str2);
        C0573k.m6447a(edit);
    }

    private static void m6447a(Editor editor) {
        f4756b.execute(new C05721(editor));
    }

    public static boolean m6448a(Context context, String str) {
        return context.getSharedPreferences(C0573k.m6445a(context), 0).contains(str);
    }

    public static String m6445a(Context context) {
        if (!TextUtils.isEmpty(f4755a)) {
            return f4755a;
        }
        String b = C0573k.m6449b(context);
        if (TextUtils.equals(b, context.getPackageName())) {
            f4755a = "mistat";
        } else {
            f4755a = "mistat" + C0597q.m6533c(b);
        }
        return f4755a;
    }

    private static String m6449b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager.getRunningAppProcesses() != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }
}
