package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C4156a;
import java.lang.reflect.Method;
import p023b.p024a.C0909w.C0907n;

/* renamed from: b.a.t */
public class C0891t {
    private static String f2975d;
    private static Context f2976e;
    private final String f2977a;
    private final String f2978b;
    private final String f2979c;

    static {
        f2975d = null;
        f2976e = null;
    }

    public C0891t() {
        this.f2977a = "a_start_time";
        this.f2978b = "a_end_time";
        this.f2979c = "autoact";
    }

    public static String m3949a() {
        try {
            if (f2975d == null) {
                f2975d = C0888r.m3932a(f2976e).getString("session_id", null);
            }
        } catch (Exception e) {
        }
        return f2975d;
    }

    private String m3950a(Context context, SharedPreferences sharedPreferences) {
        C0877g b = C0877g.m3887b(context);
        String b2 = m3955b(context);
        C0882k a = m3954a(context);
        Editor edit = sharedPreferences.edit();
        edit.putString("session_id", b2);
        edit.putLong("session_start_time", System.currentTimeMillis());
        edit.putLong("session_end_time", 0);
        edit.putLong("a_start_time", System.currentTimeMillis());
        edit.putLong("a_end_time", 0);
        edit.putInt(C4156a.f13963y, Integer.parseInt(am.m3332a(context)));
        edit.putString(C4156a.f13964z, am.m3339b(context));
        edit.commit();
        if (a != null) {
            b.m3890a(a);
        } else {
            b.m3890a((C0907n) null);
        }
        return b2;
    }

    private void m3951a(SharedPreferences sharedPreferences) {
        Editor edit = sharedPreferences.edit();
        edit.remove("session_start_time");
        edit.remove("session_end_time");
        edit.remove("a_start_time");
        edit.remove("a_end_time");
        edit.remove("activities");
        edit.remove("autoact");
        edit.commit();
    }

    private boolean m3952b(SharedPreferences sharedPreferences) {
        long j = sharedPreferences.getLong("a_start_time", 0);
        long j2 = sharedPreferences.getLong("a_end_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j == 0 || currentTimeMillis - j >= AnalyticsConfig.kContinueSessionMillis) {
            return currentTimeMillis - j2 > AnalyticsConfig.kContinueSessionMillis;
        } else {
            ap.m3391d("onResume called before onPause");
            return false;
        }
    }

    public static String m3953g(Context context) {
        if (f2975d == null) {
            f2975d = C0888r.m3932a(context).getString("session_id", null);
        }
        return f2975d;
    }

    public C0907n m3954a(Context context) {
        SharedPreferences a = C0888r.m3932a(context);
        String string = a.getString("session_id", null);
        if (string == null) {
            return null;
        }
        long j = a.getLong("session_start_time", 0);
        long j2 = a.getLong("session_end_time", 0);
        long j3 = 0;
        if (j2 != 0) {
            j3 = j2 - j;
            if (Math.abs(j3) > C4156a.f13948j) {
                j3 = 0;
            }
        }
        C0907n c0907n = new C0907n();
        c0907n.f3082b = string;
        c0907n.f3083c = j;
        c0907n.f3084d = j2;
        c0907n.f3085e = j3;
        double[] location = AnalyticsConfig.getLocation();
        if (location != null) {
            c0907n.f3090j.f3018a = location[0];
            c0907n.f3090j.f3019b = location[1];
            c0907n.f3090j.f3020c = System.currentTimeMillis();
        }
        try {
            Class cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", new Class[]{Integer.TYPE});
            Method method2 = cls.getMethod("getUidTxBytes", new Class[]{Integer.TYPE});
            if (context.getApplicationInfo().uid == -1) {
                return null;
            }
            j = ((Long) method.invoke(null, new Object[]{Integer.valueOf(context.getApplicationInfo().uid)})).longValue();
            j3 = ((Long) method2.invoke(null, new Object[]{Integer.valueOf(r5)})).longValue();
            if (j > 0 && j3 > 0) {
                long j4 = a.getLong("uptr", -1);
                j2 = a.getLong("dntr", -1);
                a.edit().putLong("uptr", j3).putLong("dntr", j).commit();
                if (j4 > 0 && j2 > 0) {
                    j -= j2;
                    j3 -= j4;
                    if (j > 0 && j3 > 0) {
                        c0907n.f3089i.f3091a = j;
                        c0907n.f3089i.f3092b = j3;
                    }
                }
            }
            C0893v.m3974a(a, c0907n);
            C0867e.m3838a(a, c0907n);
            m3951a(a);
            return c0907n;
        } catch (Throwable th) {
        }
    }

    public String m3955b(Context context) {
        String c = am.m3342c(context);
        String appkey = AnalyticsConfig.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey == null) {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis).append(appkey).append(c);
        f2975d = an.m3370a(stringBuilder.toString());
        return f2975d;
    }

    public void m3956c(Context context) {
        f2976e = context;
        SharedPreferences a = C0888r.m3932a(context);
        if (a != null) {
            Editor edit = a.edit();
            int i = a.getInt(C4156a.f13963y, 0);
            int parseInt = Integer.parseInt(am.m3332a(f2976e));
            if (i != 0 && parseInt != i) {
                if (C0891t.m3953g(context) == null) {
                    m3950a(context, a);
                }
                m3958e(f2976e);
                C0877g.m3887b(f2976e).m3893c();
                m3959f(f2976e);
            } else if (m3952b(a)) {
                ap.m3386b("Start new session: " + m3950a(context, a));
            } else {
                String string = a.getString("session_id", null);
                edit.putLong("a_start_time", System.currentTimeMillis());
                edit.putLong("a_end_time", 0);
                edit.commit();
                ap.m3386b("Extend current session: " + string);
            }
        }
    }

    public void m3957d(Context context) {
        SharedPreferences a = C0888r.m3932a(context);
        if (a != null) {
            if (a.getLong("a_start_time", 0) == 0 && AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
                ap.m3391d("onPause called before onResume");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = a.edit();
            edit.putLong("a_start_time", 0);
            edit.putLong("a_end_time", currentTimeMillis);
            edit.putLong("session_end_time", currentTimeMillis);
            edit.commit();
        }
    }

    public boolean m3958e(Context context) {
        boolean z = false;
        SharedPreferences a = C0888r.m3932a(context);
        if (!(a == null || a.getString("session_id", null) == null)) {
            long j = a.getLong("a_start_time", 0);
            long j2 = a.getLong("a_end_time", 0);
            if (j > 0 && j2 == 0) {
                z = true;
                m3957d(context);
            }
            C0877g b = C0877g.m3887b(context);
            C0882k a2 = m3954a(context);
            if (a2 != null) {
                b.m3892b(a2);
            }
        }
        return z;
    }

    public void m3959f(Context context) {
        SharedPreferences a = C0888r.m3932a(context);
        if (a != null) {
            String b = m3955b(context);
            Editor edit = a.edit();
            edit.putString("session_id", b);
            edit.putLong("session_start_time", System.currentTimeMillis());
            edit.putLong("session_end_time", 0);
            edit.putLong("a_start_time", System.currentTimeMillis());
            edit.putLong("a_end_time", 0);
            edit.putInt(C4156a.f13963y, Integer.parseInt(am.m3332a(context)));
            edit.putString(C4156a.f13964z, am.m3339b(context));
            edit.commit();
            ap.m3386b("Restart session: " + b);
        }
    }
}
