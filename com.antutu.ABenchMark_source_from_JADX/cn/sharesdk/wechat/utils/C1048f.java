package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.wechat.utils.WXMediaMessage.C1040a;

/* renamed from: cn.sharesdk.wechat.utils.f */
public class C1048f extends WechatResp {
    public WXMediaMessage f3526a;

    public C1048f(Bundle bundle) {
        super(bundle);
    }

    public int m4683a() {
        return 4;
    }

    public void m4684a(Bundle bundle) {
        super.m4665a(bundle);
        this.f3526a = C1040a.m4633a(bundle);
    }

    public void m4685b(Bundle bundle) {
        super.m4666b(bundle);
        bundle.putAll(C1040a.m4632a(this.f3526a));
    }
}
