package com.miui.support.external;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.miui.support.external.SdkConstants.SdkError;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Application extends android.app.Application implements SdkConstants {
    private boolean f1298a;
    private ApplicationDelegate f1299b;

    public Application() {
        if (!m2550b()) {
        }
    }

    private boolean m2550b() {
        try {
            if (!SdkHelper.m3470a() || SdkLoader.m3480a(SdkHelper.m3466a(null, "com.miui.core", "miui"), null, SdkHelper.m3465a(null, "com.miui.core"), Application.class.getClassLoader())) {
                return true;
            }
            SdkErrorInstrumentation.m3464a(SdkError.NO_SDK);
            return false;
        } catch (Throwable th) {
            m2549a(th);
            return false;
        }
    }

    private boolean m2551f() {
        try {
            HashMap hashMap = new HashMap();
            int intValue = ((Integer) SdkEntranceHelper.m3446a().getMethod("initialize", new Class[]{android.app.Application.class, Map.class}).invoke(null, new Object[]{this, hashMap})).intValue();
            if (intValue == 0) {
                return true;
            }
            m2548a("initialize", intValue);
            return false;
        } catch (Throwable th) {
            m2549a(th);
            return false;
        }
    }

    private boolean m2552g() {
        try {
            HashMap hashMap = new HashMap();
            int intValue = ((Integer) SdkEntranceHelper.m3446a().getMethod("start", new Class[]{Map.class}).invoke(null, new Object[]{hashMap})).intValue();
            if (intValue == 1) {
                SdkErrorInstrumentation.m3464a(SdkError.LOW_SDK_VERSION);
                return false;
            } else if (intValue == 0) {
                return true;
            } else {
                m2548a("start", intValue);
                return false;
            }
        } catch (Throwable th) {
            m2549a(th);
            return false;
        }
    }

    private void m2549a(Throwable th) {
        while (th != null && th.getCause() != null) {
            if (!(th instanceof InvocationTargetException)) {
                if (!(th instanceof ExceptionInInitializerError)) {
                    break;
                }
                th = th.getCause();
            } else {
                th = th.getCause();
            }
        }
        Log.e("miuisdk", "MIUI SDK encounter errors, please contact miuisdk@xiaomi.com for support.", th);
        SdkErrorInstrumentation.m3464a(SdkError.GENERIC);
    }

    private void m2548a(String str, int i) {
        Log.e("miuisdk", "MIUI SDK encounter errors, please contact miuisdk@xiaomi.com for support. phase: " + str + " code: " + i);
        SdkErrorInstrumentation.m3464a(SdkError.GENERIC);
    }

    public ApplicationDelegate m2553a() {
        return null;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (m2551f() && m2552g()) {
            this.f1299b = m2553a();
            if (this.f1299b != null) {
                this.f1299b.m2545a(this);
            }
            this.f1298a = true;
        }
    }

    public final void onCreate() {
        if (!this.f1298a) {
            return;
        }
        if (this.f1299b != null) {
            this.f1299b.m2544a();
        } else {
            m2556c();
        }
    }

    final void m2556c() {
        super.onCreate();
    }

    public final void onTerminate() {
        if (this.f1299b != null) {
            this.f1299b.m2546b();
        } else {
            m2557d();
        }
    }

    final void m2557d() {
        super.onTerminate();
    }

    public final void onLowMemory() {
        if (this.f1299b != null) {
            this.f1299b.onLowMemory();
        } else {
            m2558e();
        }
    }

    final void m2558e() {
        super.onLowMemory();
    }

    public final void onTrimMemory(int i) {
        if (this.f1299b != null) {
            this.f1299b.onTrimMemory(i);
        } else {
            m2554a(i);
        }
    }

    final void m2554a(int i) {
        super.onTrimMemory(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.f1299b != null) {
            this.f1299b.onConfigurationChanged(configuration);
        } else {
            m2555a(configuration);
        }
    }

    final void m2555a(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
