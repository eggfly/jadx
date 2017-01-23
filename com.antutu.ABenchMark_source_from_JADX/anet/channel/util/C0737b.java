package anet.channel.util;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;

/* renamed from: anet.channel.util.b */
final class C0737b implements ActivityLifecycleCallbacks {
    C0737b() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (GlobalAppRuntimeInfo.isBackground) {
            SessionCenter.getInstance().forground();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
