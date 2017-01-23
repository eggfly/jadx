package anet.channel.util;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.os.Build.VERSION;
import anet.channel.GlobalAppRuntimeInfo;

/* renamed from: anet.channel.util.a */
public class C0736a {
    private static ActivityLifecycleCallbacks f2427a;
    private static ComponentCallbacks2 f2428b;

    static {
        f2427a = new C0737b();
        f2428b = new C0738c();
    }

    public static void m2966a() {
        if (VERSION.SDK_INT >= 14) {
            ((Application) GlobalAppRuntimeInfo.getContext().getApplicationContext()).registerActivityLifecycleCallbacks(f2427a);
            GlobalAppRuntimeInfo.getContext().registerComponentCallbacks(f2428b);
        }
    }
}
