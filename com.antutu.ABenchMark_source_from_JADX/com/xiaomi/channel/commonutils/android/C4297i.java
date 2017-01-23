package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.reflect.C4323a;
import java.security.MessageDigest;
import org.android.agoo.message.MessageService;

/* renamed from: com.xiaomi.channel.commonutils.android.i */
public class C4297i {
    private static Context f14715a;

    public static Context m17624a() {
        return f14715a;
    }

    public static void m17625a(Context context) {
        f14715a = context.getApplicationContext();
    }

    public static String m17626b() {
        String c = C4293e.m17611c(f14715a);
        if (c == null) {
            c = C4293e.m17613e(f14715a);
        }
        if (c != null) {
            try {
                return Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(c.getBytes()), 8).substring(0, 16);
            } catch (Throwable e) {
                C4302b.m17651a(e);
            }
        }
        return null;
    }

    public static boolean m17627b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable e) {
            C4302b.m17651a(e);
            return false;
        }
    }

    public static int m17628c() {
        try {
            Class cls = Class.forName("miui.os.Build");
            return cls.getField("IS_STABLE_VERSION").getBoolean(null) ? 3 : cls.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean m17629d() {
        return TextUtils.equals((String) C4323a.m17718a("android.os.SystemProperties", "get", "sys.boot_completed"), MessageService.MSG_DB_NOTIFY_REACHED);
    }
}
