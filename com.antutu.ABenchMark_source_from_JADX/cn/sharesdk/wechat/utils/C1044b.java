package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* renamed from: cn.sharesdk.wechat.utils.b */
public class C1044b extends WechatResp {
    public String f3518a;
    public String f3519b;
    public int f3520c;
    public String f3521d;
    public String f3522e;

    public C1044b(Bundle bundle) {
        super(bundle);
    }

    public int m4673a() {
        return 1;
    }

    public void m4674a(Bundle bundle) {
        super.m4665a(bundle);
        this.f3518a = bundle.getString("_wxapi_sendauth_resp_userName");
        this.f3519b = bundle.getString("_wxapi_sendauth_resp_token");
        this.f3520c = bundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
        this.f3521d = bundle.getString("_wxapi_sendauth_resp_state");
        this.f3522e = bundle.getString("_wxapi_sendauth_resp_url");
    }

    public void m4675b(Bundle bundle) {
        super.m4666b(bundle);
        bundle.putString("_wxapi_sendauth_resp_userName", this.f3518a);
        bundle.putString("_wxapi_sendauth_resp_token", this.f3519b);
        bundle.putInt("_wxapi_sendauth_resp_expireDate", this.f3520c);
        bundle.putString("_wxapi_sendauth_resp_state", this.f3521d);
        bundle.putString("_wxapi_sendauth_resp_url", this.f3522e);
    }
}
