package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* renamed from: cn.sharesdk.wechat.utils.j */
public abstract class C1042j {
    public String f3515c;

    public abstract int m4667a();

    public void m4668a(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", m4667a());
        bundle.putString("_wxapi_basereq_transaction", this.f3515c);
    }

    public abstract boolean m4669b();
}
