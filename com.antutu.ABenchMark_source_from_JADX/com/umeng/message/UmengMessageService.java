package com.umeng.message;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.umeng.analytics.C4156a;
import com.umeng.message.common.UmLog;

public abstract class UmengMessageService extends IntentService {
    private static final String f14192a;

    static {
        f14192a = UmengMessageService.class.getSimpleName();
    }

    public UmengMessageService() {
        super("UmengMessageService");
    }

    public void onCreate() {
        super.onCreate();
    }

    protected void onHandleIntent(Intent intent) {
        onMessage(this, intent);
        UmLog.m17140i(f14192a, "message:" + intent.getStringExtra(C4156a.f13961w));
    }

    public abstract void onMessage(Context context, Intent intent);
}
