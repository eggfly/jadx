package com.cmcm.support;

import android.annotation.SuppressLint;
import android.content.Context;
import com.cmcm.support.jni.C2240i;
import com.cmcm.support.p116a.C2191d;
import com.umeng.analytics.C4156a;
import java.io.File;

/* renamed from: com.cmcm.support.o */
public class C2246o {
    public static long m8495a(long j) {
        return (long) (((double) ((System.currentTimeMillis() - j) / C4156a.f13948j)) + 0.5d);
    }

    @SuppressLint({"SdCardPath"})
    public static File m8496a(Context context) {
        File file = null;
        if (context == null) {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            file = context.getFilesDir();
            if (file != null) {
                break;
            }
            try {
                Thread.sleep(166);
            } catch (InterruptedException e) {
            }
        }
        return file == null ? new File("/data/data/" + context.getPackageName() + "/files/") : file;
    }

    public static File m8497a(Context context, int i, String str) {
        return C2246o.m8498a(C2246o.m8504b(context, i, str));
    }

    public static File m8498a(File file) {
        return file == null ? null : (file.isDirectory() && file.exists()) ? file : null;
    }

    public static void m8499a() {
    }

    public static byte[] m8500a(String str) {
        byte[] bArr = null;
        if (str != null) {
            try {
                bArr = C2240i.b1(str);
            } catch (UnsatisfiedLinkError e) {
                C2246o.m8499a();
            }
        }
        return bArr;
    }

    public static byte[] m8501a(String str, String str2, int i, String str3) {
        byte[] bArr = null;
        if (!(str == null || str2 == null || str3 == null)) {
            try {
                bArr = C2240i.m8460c(str, str2, str3);
            } catch (UnsatisfiedLinkError e) {
                C2246o.m8499a();
            }
        }
        return bArr;
    }

    public static int m8502b(String str) {
        byte[] a = C2246o.m8500a(str);
        return a != null ? a.length : 0;
    }

    public static int m8503b(String str, String str2, int i, String str3) {
        byte[] a = C2246o.m8501a(str, str2, i, str3);
        return a != null ? a.length : 0;
    }

    public static File m8504b(Context context, int i, String str) {
        if (context == null) {
            return null;
        }
        File filesDir = context.getFilesDir();
        return filesDir != null ? new File(filesDir, str + Integer.toString(i)) : null;
    }

    public static int m8505c(Context context, int i, String str) {
        File a = C2246o.m8497a(context, i, str);
        return a != null ? C2191d.m8240c(a.getAbsolutePath()) : 0;
    }

    public static File m8506d(Context context, int i, String str) {
        File b = C2246o.m8504b(context, i, str);
        if (b == null) {
            return null;
        }
        if (!b.exists()) {
            b.mkdir();
        } else if (b.isFile()) {
            b.delete();
            b.mkdir();
        }
        if (!b.exists()) {
            b = null;
        }
        return b;
    }
}
