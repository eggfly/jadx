package com.antutu.benchmark.p046j;

import android.os.Environment;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* renamed from: com.antutu.benchmark.j.a */
public class C1513a {
    private static boolean[] f5187a;
    private static boolean f5188b;
    private static boolean f5189c;

    static {
        f5187a = new boolean[26];
        f5188b = false;
        f5189c = false;
    }

    public static void m5998a() {
        for (int i = 0; i <= 25; i++) {
            f5187a[i] = true;
        }
        f5188b = false;
        try {
            C1514b.m6006a(new FileInputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.antutu/settings.xml"));
        } catch (Exception e) {
        }
    }

    public static void m5999a(int i, boolean z) {
        if (i >= 0 && i <= 99) {
            f5187a[i] = z;
        }
    }

    public static void m6000a(String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.antutu/last_result.json");
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
        }
    }

    public static void m6001a(boolean z) {
        f5189c = z;
    }

    public static boolean m6002a(int i) {
        return (i < 0 || i > 99) ? true : f5187a[i];
    }

    public static void m6003b(boolean z) {
        f5188b = z;
    }

    public static boolean m6004b() {
        return f5189c;
    }

    public static boolean m6005c() {
        return f5188b;
    }
}
