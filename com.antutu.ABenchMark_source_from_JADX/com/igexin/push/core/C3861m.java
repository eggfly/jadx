package com.igexin.push.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

/* renamed from: com.igexin.push.core.m */
public class C3861m extends BroadcastReceiver {
    private static C3861m f13005a;

    private C3861m() {
    }

    public static C3861m m15904a() {
        if (f13005a == null) {
            f13005a = new C3861m();
        }
        return f13005a;
    }

    public void onReceive(Context context, Intent intent) {
        if (C3854f.m15859a() != null) {
            Message message = new Message();
            message.what = C3794a.f12724d;
            message.obj = intent;
            C3854f.m15859a().m15865a(message);
        }
    }
}
