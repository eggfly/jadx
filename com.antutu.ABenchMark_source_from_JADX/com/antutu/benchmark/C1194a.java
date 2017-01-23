package com.antutu.benchmark;

import android.app.Notification;
import android.content.Context;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.PushMessageUtil;
import com.igexin.download.Downloads;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

/* renamed from: com.antutu.benchmark.a */
public class C1194a extends UmengMessageHandler {
    public Notification getNotification(Context context, UMessage uMessage) {
        try {
            InfocUtil.antutu_push(context, 1, (String) uMessage.extra.get(Downloads.COLUMN_TITLE), "\u53cb\u76df");
            try {
                PushMessageUtil.openLiveService(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
        }
        return super.getNotification(context, uMessage);
    }
}
