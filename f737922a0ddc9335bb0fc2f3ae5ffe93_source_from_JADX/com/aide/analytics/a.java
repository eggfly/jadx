package com.aide.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.d.b;
import com.google.android.gms.analytics.d.e;
import com.google.android.gms.analytics.d.f;
import com.google.android.gms.analytics.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public final class a {
    private static b DW;
    private static c FH;
    private static g Hw;
    private static String j6;
    private static boolean v5;

    static {
        j6 = "unknown";
        v5 = false;
    }

    public static boolean j6() {
        return v5;
    }

    public static void j6(Context context, b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Arguments may not be null");
        }
        Hw("initialize");
        DW = bVar;
        try {
            j6 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
        }
        FH = c.j6(context);
        Hw = FH.j6(com.aide.analytics.d.a.analytics);
        Hw.FH(true);
        v5 = true;
        FH();
    }

    public static void j6(Context context) {
        if (FH()) {
            Hw("startSession");
        }
    }

    public static void DW(Context context) {
        if (FH()) {
            Hw("endSession");
        }
    }

    public static void j6(Activity activity, String str) {
        j6(activity, str, null);
    }

    public static void j6(Activity activity, String str, Map<String, String> map) {
        if (FH()) {
            FH.j6(activity);
        }
    }

    public static void DW(Activity activity, String str) {
        if (FH()) {
            FH.FH(activity);
        }
    }

    public static void j6(String str) {
        Hw.j6(str);
        Hw.j6(new com.google.android.gms.analytics.d.a().j6());
    }

    public static void j6(String str, int i, String str2) {
        if (FH()) {
            Hw("logEvent: " + str);
            Hw.j6(((b) new b().j6("all_events").DW(str).FH(null).j6(0).j6(i, str2)).j6());
        }
    }

    public static void DW(String str) {
        if (FH()) {
            Hw("logEvent: " + str);
            FH(str);
        }
    }

    public static void j6(String str, Map<String, String> map) {
        if (FH()) {
            Hw("logEvent: " + str);
            FH(str);
        }
    }

    private static void FH(String str) {
        Hw.j6(new b().j6("all_events").DW(str).FH(null).j6(0).j6());
    }

    public static void j6(String str, File file) {
        if (FH()) {
            Hw("logInstalledEvents: " + str + " dir: " + file);
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!file2.getName().startsWith("tmp-") && file2.isFile()) {
                        String str2 = null;
                        Reader fileReader;
                        try {
                            fileReader = new FileReader(file2);
                            str2 = new BufferedReader(fileReader).readLine();
                            fileReader.close();
                        } catch (Throwable e) {
                            Log.e("aideanalytics", "I/O error reading referrer file", e);
                        } catch (Throwable th) {
                            fileReader.close();
                        }
                        if (str2 != null) {
                            j6(str, str2);
                            if (!file2.delete()) {
                                Log.e("aideanalytics", "I/O error deleting referrer file");
                            }
                        } else {
                            Log.e("aideanalytics", "Empty referrer file found");
                        }
                    }
                }
            }
        }
    }

    public static void j6(Context context, String str, String str2, String str3, String str4, String str5, double d, String str6) {
        if (FH()) {
            Hw.j6(new f().j6(str).DW(str2).FH(str6).j6(d).DW(0.0d).FH(0.0d).j6());
            Hw.j6(new e().j6(str).DW(str4).FH(str3).Hw(str5).j6(d).j6(1).v5(str6).j6());
        }
    }

    public static void DW() {
        if (!v5) {
            throw new IllegalStateException("Analytics not initialized");
        } else if (DW.j6()) {
            FH.DW(false);
        } else {
            FH.DW(true);
        }
    }

    public static String j6(String str, String str2, String str3) {
        return "market://details?id=" + str2 + "&referrer=utm_source%3D" + str + "%26utm_medium%3Dinapplink%26utm_campaign%3D" + str3;
    }

    private static void j6(String str, String str2) {
        if (FH()) {
            Hw("logInstalledEvent: " + str);
        }
    }

    private static boolean FH() {
        if (v5) {
            boolean z;
            c cVar = FH;
            if (DW.j6()) {
                z = false;
            } else {
                z = true;
            }
            cVar.DW(z);
            if (DW.j6()) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Analytics not initialized");
    }

    private static void Hw(String str) {
    }
}
