package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.mobads.production.m */
class C2062m extends TimerTask {
    final /* synthetic */ IXAdPackageUtils f7182a;
    final /* synthetic */ Context f7183b;
    final /* synthetic */ String f7184c;
    final /* synthetic */ Timer f7185d;
    final /* synthetic */ String f7186e;
    final /* synthetic */ C2061l f7187f;

    C2062m(C2061l c2061l, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer, String str2) {
        this.f7187f = c2061l;
        this.f7182a = iXAdPackageUtils;
        this.f7183b = context;
        this.f7184c = str;
        this.f7185d = timer;
        this.f7186e = str2;
    }

    public void run() {
        if (this.f7187f.f7176g >= this.f7187f.f7177h) {
            if (this.f7187f.f7176g >= this.f7187f.f7178i) {
                this.f7185d.cancel();
                this.f7182a.sendAPOIsSuccess(this.f7183b, true, 0, this.f7186e, this.f7184c);
            } else if (!this.f7182a.isForeground(this.f7183b, this.f7184c)) {
                this.f7185d.cancel();
                this.f7182a.sendAPOIsSuccess(this.f7183b, false, this.f7187f.f7176g, this.f7186e, this.f7184c);
            }
        }
        this.f7187f.f7176g = this.f7187f.f7176g + 1;
    }
}
