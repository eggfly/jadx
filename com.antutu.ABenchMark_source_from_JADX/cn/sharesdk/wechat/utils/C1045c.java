package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.wechat.utils.WXMediaMessage.C1040a;

/* renamed from: cn.sharesdk.wechat.utils.c */
public class C1045c extends WechatResp {
    public WXMediaMessage f3523a;

    public C1045c(Bundle bundle) {
        super(bundle);
    }

    public int m4676a() {
        return 3;
    }

    public void m4677a(Bundle bundle) {
        super.m4665a(bundle);
        this.f3523a = C1040a.m4633a(bundle);
    }

    public void m4678b(Bundle bundle) {
        super.m4666b(bundle);
        bundle.putAll(C1040a.m4632a(this.f3523a));
    }
}
