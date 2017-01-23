package com.antutu.benchmark;

import android.content.Context;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.utils.MLog;
import com.antutu.utils.PushMessageUtil;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

/* renamed from: com.antutu.benchmark.b */
public class C1342b extends UmengNotificationClickHandler {
    public void dealWithCustomAction(Context context, UMessage uMessage) {
        if (uMessage != null && uMessage.custom != null) {
            MLog.m6865d("hch", "DeviceInfoPreference.initStart\uff1d" + C1503b.f5115c);
            PushMessageUtil.dealWithMessage(context, 1, uMessage);
        }
    }
}
