package com.baidu.mobads.p082b;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p084c.C1918a;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.baidu.mobads.b.a */
public class C1913a extends BroadcastReceiver {
    protected final IXAdLogger f6700a;
    private C1924a f6701b;

    public C1913a(C1924a c1924a) {
        this.f6700a = C1991m.m7449a().m7457f();
        this.f6701b = c1924a;
    }

    @TargetApi(3)
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String replace = intent.getDataString().replace("package:", BuildConfig.FLAVOR);
            if (replace.equals(this.f6701b.f6738i)) {
                IXAdPackageUtils l = C1991m.m7449a().m7463l();
                if (this.f6701b.f6751v && this.f6701b.f6752w != null && !this.f6701b.f6752w.equals(BuildConfig.FLAVOR)) {
                    IXAdConstants p = C1991m.m7449a().m7467p();
                    if (l.sendAPOInfo(context, this.f6701b.f6752w, replace, 381, p.getActTypeDownload())) {
                        C1991m.m7449a().m7464m().browserOutside(context, this.f6701b.f6752w);
                    }
                    context.unregisterReceiver(this);
                } else if (this.f6701b.f6741l) {
                    try {
                        Thread.sleep(600);
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(replace);
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        context.unregisterReceiver(this);
                    } catch (Throwable e) {
                        this.f6700a.m7394d("InstallReceiver", e);
                    }
                }
                C1918a.m7217a().m7228b(context, this.f6701b);
            }
        }
    }
}
