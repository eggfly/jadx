package cn.sharesdk.wechat.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.utils.C0979d;

public class WechatHandlerActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        setTheme(16973839);
        super.onCreate(bundle);
        try {
            WechatHelper.m4635a().m4659a(this);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
        finish();
    }

    public void onGetMessageFromWXReq(WXMediaMessage wXMediaMessage) {
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        try {
            WechatHelper.m4635a().m4659a(this);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
        finish();
    }

    public void onShowMessageFromWXReq(WXMediaMessage wXMediaMessage) {
    }
}
