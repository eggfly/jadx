package p023b.p024a;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import p023b.p024a.C0909w.C0904k;
import p023b.p024a.C0909w.C0907n;

/* renamed from: b.a.e */
public class C0867e {
    public static String f2910a;
    ActivityLifecycleCallbacks f2911b;
    private final Map<String, Long> f2912c;
    private final ArrayList<C0904k> f2913d;
    private Application f2914e;

    /* renamed from: b.a.e.1 */
    class C08661 implements ActivityLifecycleCallbacks {
        final /* synthetic */ C0867e f2909a;

        C08661(C0867e c0867e) {
            this.f2909a = c0867e;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            this.f2909a.m3842c(activity);
        }

        public void onActivityResumed(Activity activity) {
            this.f2909a.m3840b(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        f2910a = null;
    }

    public C0867e(Activity activity) {
        this.f2912c = new HashMap();
        this.f2913d = new ArrayList();
        this.f2914e = null;
        this.f2911b = new C08661(this);
        if (activity != null) {
            this.f2914e = activity.getApplication();
            m3837a(activity);
        }
    }

    private void m3837a(Activity activity) {
        this.f2914e.registerActivityLifecycleCallbacks(this.f2911b);
        if (f2910a == null) {
            m3840b(activity);
        }
    }

    public static void m3838a(SharedPreferences sharedPreferences, C0907n c0907n) {
        if (sharedPreferences != null) {
            try {
                Object string = sharedPreferences.getString("autoact", BuildConfig.FLAVOR);
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split(";");
                    for (String jSONArray : split) {
                        JSONArray jSONArray2 = new JSONArray(jSONArray);
                        C0904k c0904k = new C0904k();
                        c0904k.f3021a = jSONArray2.getString(0);
                        c0904k.f3022b = (long) jSONArray2.getInt(1);
                        c0907n.f3088h.add(c0904k);
                    }
                }
            } catch (Throwable e) {
                ap.m3385a(e);
            }
        }
    }

    private void m3840b(Activity activity) {
        f2910a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f2912c) {
            this.f2912c.put(f2910a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    private void m3842c(Activity activity) {
        long j = 0;
        synchronized (this.f2912c) {
            if (this.f2912c.containsKey(f2910a)) {
                j = System.currentTimeMillis() - ((Long) this.f2912c.get(f2910a)).longValue();
                this.f2912c.remove(f2910a);
            }
        }
        synchronized (this.f2913d) {
            C0904k c0904k = new C0904k();
            c0904k.f3021a = f2910a;
            c0904k.f3022b = j;
            this.f2913d.add(c0904k);
        }
    }

    public void m3843a() {
        if (this.f2914e != null) {
            this.f2914e.unregisterActivityLifecycleCallbacks(this.f2911b);
        }
    }

    public void m3844a(Context context) {
        if (context == null) {
            try {
                context = this.f2914e.getApplicationContext();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (context != null) {
            SharedPreferences a = C0888r.m3932a(context);
            if (a != null) {
                Editor edit = a.edit();
                if (this.f2913d.size() > 0) {
                    String string = a.getString("autoact", BuildConfig.FLAVOR);
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!TextUtils.isEmpty(string)) {
                        stringBuilder.append(string);
                        if (!string.endsWith(";")) {
                            stringBuilder.append(";");
                        }
                    }
                    synchronized (this.f2913d) {
                        Iterator it = this.f2913d.iterator();
                        while (it.hasNext()) {
                            C0904k c0904k = (C0904k) it.next();
                            stringBuilder.append(String.format("[\"%s\",%d]", new Object[]{c0904k.f3021a, Long.valueOf(c0904k.f3022b)}));
                            stringBuilder.append(";");
                        }
                        this.f2913d.clear();
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    edit.remove("autoact");
                    edit.putString("autoact", stringBuilder.toString());
                }
                edit.commit();
            }
        }
    }

    public void m3845b(Context context) {
        m3842c(null);
        m3843a();
        m3844a(context);
    }
}
