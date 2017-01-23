package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.mobads.production.n */
class C2063n extends TimerTask {
    final /* synthetic */ IXAdPackageUtils f7188a;
    final /* synthetic */ Context f7189b;
    final /* synthetic */ String f7190c;
    final /* synthetic */ Timer f7191d;
    final /* synthetic */ C2061l f7192e;

    C2063n(C2061l c2061l, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer) {
        this.f7192e = c2061l;
        this.f7188a = iXAdPackageUtils;
        this.f7189b = context;
        this.f7190c = str;
        this.f7191d = timer;
    }

    public void run() {
        if (this.f7192e.f7179j >= this.f7192e.f7180k) {
            if (this.f7192e.f7179j >= this.f7192e.f7181l) {
                this.f7191d.cancel();
                this.f7188a.sendDialerIsSuccess(this.f7189b, true, 0, this.f7190c);
            } else if (!this.f7188a.isForeground(this.f7189b, this.f7190c) && this.f7188a.isForeground(this.f7189b, this.f7189b.getPackageName())) {
                this.f7191d.cancel();
                this.f7188a.sendDialerIsSuccess(this.f7189b, false, this.f7192e.f7179j, this.f7190c);
            }
        }
        this.f7192e.f7179j = this.f7192e.f7179j + 1;
    }
}
