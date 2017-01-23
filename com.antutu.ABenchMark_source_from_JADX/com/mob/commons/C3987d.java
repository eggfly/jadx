package com.mob.commons;

import android.content.Context;
import com.mob.tools.MobLog;
import com.mob.tools.utils.C4021R;
import java.io.File;

/* renamed from: com.mob.commons.d */
public class C3987d {
    public static synchronized boolean m16426a(Context context, String str) {
        boolean exists;
        synchronized (C3987d.class) {
            try {
                exists = new File(C4021R.getCacheRoot(context), str).exists();
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
                exists = true;
            }
        }
        return exists;
    }

    public static synchronized void m16427b(Context context, String str) {
        synchronized (C3987d.class) {
            try {
                File file = new File(C4021R.getCacheRoot(context), str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
    }

    public static synchronized void m16428c(Context context, String str) {
        synchronized (C3987d.class) {
            try {
                File file = new File(C4021R.getCacheRoot(context), str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
    }
}
