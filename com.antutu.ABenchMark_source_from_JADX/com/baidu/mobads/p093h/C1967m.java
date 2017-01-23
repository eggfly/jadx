package com.baidu.mobads.p093h;

import android.util.Log;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p081a.C1908b;
import com.umeng.message.proguard.C4233j;

/* renamed from: com.baidu.mobads.h.m */
class C1967m implements IOAdEventListener {
    final /* synthetic */ double f6849a;
    final /* synthetic */ C1966l f6850b;

    C1967m(C1966l c1966l, double d) {
        this.f6850b = c1966l;
        this.f6849a = d;
    }

    public void run(IOAdEvent iOAdEvent) {
        boolean z = true;
        this.f6850b.f6848a.f6847b.m7344l();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.f6850b.f6848a.f6847b.f6840j = new C1955e((String) iOAdEvent.getData().get(C4233j.f14376C));
            double a = C1908b.m7197a();
            float f = this.f6850b.f6848a.f6847b.m7342j().getFloat("__badApkVersion__8.8", 0.0f);
            Boolean valueOf = Boolean.valueOf(((float) this.f6850b.f6848a.f6847b.f6840j.m7312b()) == f);
            if (a >= this.f6850b.f6848a.f6847b.f6840j.m7312b() || Math.floor(a) != Math.floor(this.f6850b.f6848a.f6847b.f6840j.m7312b())) {
                z = false;
            }
            Boolean valueOf2 = Boolean.valueOf(z);
            Log.i("XAdApkLoader", "try to download apk badVer=" + f + ", isBad=" + valueOf + ", compatible=" + valueOf2);
            if (this.f6849a < this.f6850b.f6848a.f6847b.f6840j.m7312b() && this.f6850b.f6848a.f6847b.f6840j != null && this.f6850b.f6848a.f6847b.f6840j.m7311a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                this.f6850b.f6848a.f6847b.m7324a(this.f6850b.f6848a.f6847b.f6840j);
            }
        }
    }
}
