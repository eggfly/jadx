package anet.channel.util;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;

/* renamed from: anet.channel.util.c */
final class C0738c implements ComponentCallbacks2 {
    public static final String TAG = "awcn.ComponentCallbacks2";

    C0738c() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        ALog.m2963i(TAG, "onTrimMemory", null, "level", Integer.valueOf(i));
        if (i == 20 && !GlobalAppRuntimeInfo.isBackground) {
            SessionCenter.getInstance().background();
        }
    }
}
