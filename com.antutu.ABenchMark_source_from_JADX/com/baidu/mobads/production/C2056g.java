package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;

/* renamed from: com.baidu.mobads.production.g */
class C2056g extends Handler {
    final /* synthetic */ IXAdInstanceInfo f7162a;
    final /* synthetic */ C2028a f7163b;

    C2056g(C2028a c2028a, Looper looper, IXAdInstanceInfo iXAdInstanceInfo) {
        this.f7163b = c2028a;
        this.f7162a = iXAdInstanceInfo;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.getData().getBoolean("caching_result")) {
            this.f7162a.setLocalCreativeURL(message.getData().getString("local_creative_url"));
        } else {
            this.f7162a.setLocalCreativeURL(null);
        }
    }
}
