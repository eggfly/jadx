package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public abstract class WechatResp {
    public int f3512f;
    public String f3513g;
    public String f3514h;

    public interface ErrCode {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;
    }

    public WechatResp(Bundle bundle) {
        m4665a(bundle);
    }

    public abstract int m4664a();

    public void m4665a(Bundle bundle) {
        this.f3512f = bundle.getInt("_wxapi_baseresp_errcode");
        this.f3513g = bundle.getString("_wxapi_baseresp_errstr");
        this.f3514h = bundle.getString("_wxapi_baseresp_transaction");
    }

    public void m4666b(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", m4664a());
        bundle.putInt("_wxapi_baseresp_errcode", this.f3512f);
        bundle.putString("_wxapi_baseresp_errstr", this.f3513g);
        bundle.putString("_wxapi_baseresp_transaction", this.f3514h);
    }
}
