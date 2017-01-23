package com.mob.commons;

import android.content.Context;
import com.mob.tools.utils.SharePrefrenceHelper;

/* renamed from: com.mob.commons.f */
public class C3996f {
    private static SharePrefrenceHelper f13362a;

    public static synchronized String m16451a(Context context) {
        String string;
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            string = f13362a.getString("key_ext_info");
        }
        return string;
    }

    public static synchronized void m16452a(Context context, long j) {
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            f13362a.putLong("wifi_last_time", Long.valueOf(j));
        }
    }

    public static synchronized void m16453a(Context context, String str) {
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            f13362a.putString("key_ext_info", str);
        }
    }

    public static synchronized long m16454b(Context context) {
        long j;
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            j = f13362a.getLong("wifi_last_time");
        }
        return j;
    }

    public static synchronized void m16455b(Context context, long j) {
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            f13362a.putLong("key_cellinfo_next_total", Long.valueOf(j));
        }
    }

    public static synchronized void m16456b(Context context, String str) {
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            f13362a.putString("wifi_last_info", str);
        }
    }

    public static synchronized String m16457c(Context context) {
        String string;
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            string = f13362a.getString("wifi_last_info");
        }
        return string;
    }

    public static synchronized void m16458c(Context context, String str) {
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            f13362a.putString("key_cellinfo", str);
        }
    }

    public static synchronized String m16459d(Context context) {
        String string;
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            string = f13362a.getString("key_cellinfo");
        }
        return string;
    }

    public static synchronized void m16460d(Context context, String str) {
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            f13362a.putString("key_switches", str);
        }
    }

    public static synchronized String m16461e(Context context) {
        String string;
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            string = f13362a.getString("key_switches");
        }
        return string;
    }

    public static synchronized void m16462e(Context context, String str) {
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            if (str == null) {
                f13362a.remove("key_data_url");
            } else {
                f13362a.putString("key_data_url", str);
            }
        }
    }

    public static synchronized String m16463f(Context context) {
        String string;
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            string = f13362a.getString("key_data_url");
        }
        return string;
    }

    public static synchronized void m16464f(Context context, String str) {
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            if (str == null) {
                f13362a.remove("key_conf_url");
            } else {
                f13362a.putString("key_conf_url", str);
            }
        }
    }

    public static synchronized String m16465g(Context context) {
        String string;
        synchronized (C3996f.class) {
            C3996f.m16466h(context);
            string = f13362a.getString("key_conf_url");
        }
        return string;
    }

    private static synchronized void m16466h(Context context) {
        synchronized (C3996f.class) {
            if (f13362a == null) {
                f13362a = new SharePrefrenceHelper(context.getApplicationContext());
                f13362a.open("mob_commons", 1);
            }
        }
    }
}
