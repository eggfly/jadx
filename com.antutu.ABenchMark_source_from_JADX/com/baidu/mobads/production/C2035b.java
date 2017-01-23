package com.baidu.mobads.production;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.vo.C2078c;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;

/* renamed from: com.baidu.mobads.production.b */
class C2035b implements IOAdEventListener {
    final /* synthetic */ C2028a f7124a;

    C2035b(C2028a c2028a) {
        this.f7124a = c2028a;
    }

    public void run(IOAdEvent iOAdEvent) {
        this.f7124a.m7589f();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            try {
                this.f7124a.setAdResponseInfo(new C2078c((String) iOAdEvent.getData().get(C4233j.f14376C)));
                if (this.f7124a.getAdResponseInfo().getAdInstanceList().size() > 0) {
                    this.f7124a.f7074b = Boolean.valueOf(true);
                    this.f7124a.m7572a("XAdMouldeLoader ad-server requesting success");
                    return;
                }
                C1991m.m7449a().m7468q().printErrorMessage(this.f7124a.getAdResponseInfo().getErrorCode(), this.f7124a.getAdResponseInfo().getErrorMessage(), BuildConfig.FLAVOR);
                this.f7124a.m7580b(this.f7124a.getAdResponseInfo().getErrorMessage());
                return;
            } catch (JSONException e) {
                r0 = "response json parsing error";
                C1991m.m7449a().m7468q().printErrorMessage(BuildConfig.FLAVOR, r0, BuildConfig.FLAVOR);
                this.f7124a.m7580b(r0);
                return;
            }
        }
        String str;
        str = "request ad-server error, io_err/timeout";
        C1991m.m7449a().m7468q().printErrorMessage(BuildConfig.FLAVOR, str, BuildConfig.FLAVOR);
        this.f7124a.m7580b(str);
    }
}
