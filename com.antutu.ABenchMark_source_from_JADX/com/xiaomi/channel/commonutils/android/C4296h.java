package com.xiaomi.channel.commonutils.android;

/* renamed from: com.xiaomi.channel.commonutils.android.h */
public class C4296h {
    public static String m17623a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
