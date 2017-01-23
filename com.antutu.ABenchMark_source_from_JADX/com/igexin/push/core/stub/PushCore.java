package com.igexin.push.core.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import com.igexin.push.core.C3794a;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3863o;
import com.igexin.push.core.p181d.C3850a;
import com.igexin.push.core.p181d.C3851b;
import com.igexin.sdk.IPushCore;
import java.util.HashMap;
import java.util.Map;

public class PushCore implements IPushCore {
    private C3854f f13009a;
    private Map f13010b;

    public PushCore() {
        this.f13010b = new HashMap();
    }

    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        if (c3850a != null) {
            c3850a.m15839a(configuration);
        }
    }

    public boolean onActivityCreateOptionsMenu(Activity activity, Menu menu) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        return c3850a != null && c3850a.m15843a(menu);
    }

    public void onActivityDestroy(Activity activity) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        if (c3850a != null) {
            c3850a.m15850h();
            this.f13010b.remove(activity);
            C3851b.m15852a().m15857c(c3850a);
        }
    }

    public boolean onActivityKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        return c3850a != null && c3850a.m15842a(i, keyEvent);
    }

    public void onActivityNewIntent(Activity activity, Intent intent) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        if (c3850a != null) {
            c3850a.m15838a(intent);
        }
    }

    public void onActivityPause(Activity activity) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        if (c3850a != null) {
            c3850a.m15848f();
        }
    }

    public void onActivityRestart(Activity activity) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        if (c3850a != null) {
            c3850a.m15846d();
        }
    }

    public void onActivityResume(Activity activity) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        if (c3850a != null) {
            c3850a.m15847e();
        }
    }

    public void onActivityStart(Activity activity, Intent intent) {
        if (activity != null && intent != null && intent.hasExtra("activityid")) {
            C3850a a = C3851b.m15852a().m15854a(Long.valueOf(intent.getLongExtra("activityid", 0)));
            if (a != null) {
                a.m15837a(activity);
                this.f13010b.put(activity, a);
                a.m15845c();
                return;
            }
            activity.finish();
        }
    }

    public void onActivityStop(Activity activity) {
        C3850a c3850a = (C3850a) this.f13010b.get(activity);
        if (c3850a != null) {
            c3850a.m15849g();
        }
    }

    public IBinder onServiceBind(Intent intent) {
        return C3863o.m15907a();
    }

    public void onServiceDestroy() {
        if (this.f13009a != null) {
            this.f13009a.m15882l();
        }
    }

    public int onServiceStartCommand(Intent intent, int i, int i2) {
        if (this.f13009a != null) {
            Message obtain = Message.obtain();
            obtain.what = C3794a.f12723c;
            obtain.obj = intent;
            this.f13009a.m15865a(obtain);
        }
        return 1;
    }

    public boolean start(Context context) {
        this.f13009a = C3854f.m15859a();
        this.f13009a.m15863a(context);
        return true;
    }
}
