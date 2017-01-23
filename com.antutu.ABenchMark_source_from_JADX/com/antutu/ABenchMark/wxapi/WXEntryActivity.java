package com.antutu.ABenchMark.wxapi;

import android.widget.Toast;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;

public class WXEntryActivity extends WechatHandlerActivity {
    public void onGetMessageFromWXReq(WXMediaMessage wXMediaMessage) {
        startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
    }

    public void onShowMessageFromWXReq(WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage != null && wXMediaMessage.mediaObject != null && (wXMediaMessage.mediaObject instanceof WXAppExtendObject)) {
            Toast.makeText(this, ((WXAppExtendObject) wXMediaMessage.mediaObject).extInfo, 0).show();
        }
    }
}
