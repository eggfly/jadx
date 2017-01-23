package com.xiaomi.channel.commonutils.android;

import android.os.Environment;
import com.xiaomi.channel.commonutils.file.C4298a;
import com.xiaomi.channel.commonutils.logger.C4302b;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/* renamed from: com.xiaomi.channel.commonutils.android.f */
public class C4294f {
    private static int f14714a;

    static {
        f14714a = 0;
    }

    public static synchronized boolean m17617a() {
        boolean z = true;
        synchronized (C4294f.class) {
            if (C4294f.m17619c() != 1) {
                z = false;
            }
        }
        return z;
    }

    public static synchronized boolean m17618b() {
        boolean z;
        synchronized (C4294f.class) {
            z = C4294f.m17619c() == 2;
        }
        return z;
    }

    public static synchronized int m17619c() {
        InputStream fileInputStream;
        Throwable th;
        int i = 1;
        synchronized (C4294f.class) {
            if (f14714a == 0) {
                try {
                    Properties properties = new Properties();
                    fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                    try {
                        properties.load(fileInputStream);
                        int i2 = (properties.getProperty("ro.miui.ui.version.code", null) == null && properties.getProperty("ro.miui.ui.version.name", null) == null) ? 0 : 1;
                        if (i2 == 0) {
                            i = 2;
                        }
                        f14714a = i;
                        C4298a.m17632a(fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            C4302b.m17650a("get isMIUI failed", th);
                            f14714a = 0;
                            C4298a.m17632a(fileInputStream);
                            C4302b.m17652b("isMIUI's value is:" + f14714a);
                            i = f14714a;
                            return i;
                        } catch (Throwable th3) {
                            th = th3;
                            C4298a.m17632a(fileInputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    C4298a.m17632a(fileInputStream);
                    throw th;
                }
                C4302b.m17652b("isMIUI's value is:" + f14714a);
            }
            i = f14714a;
        }
        return i;
    }
}
