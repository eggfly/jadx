package com.igexin.push.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.sdk.PushConsts;

/* renamed from: com.igexin.push.core.n */
public class C3862n extends BroadcastReceiver {
    private static C3862n f13006a;

    private C3862n() {
    }

    public static C3862n m15905a() {
        if (f13006a == null) {
            f13006a = new C3862n();
        }
        return f13006a;
    }

    private void m15906a(Intent intent) {
        try {
            C3688a.m15097b("----------------------------------------------------------------------------------");
            C3688a.m15097b("InternalPublicReceiver|action = " + intent.getAction() + ", component = " + intent.getComponent());
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    C3688a.m15097b("InternalPublicReceiver|key [" + str + "]: " + extras.get(str));
                }
                return;
            }
            C3688a.m15097b("InternalPublicReceiver|no extras");
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (!(intent == null || intent.getAction() == null || !intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE))) {
            m15906a(intent);
        }
        if (C3854f.m15859a() != null) {
            Message message = new Message();
            message.what = C3794a.f12724d;
            message.obj = intent;
            C3854f.m15859a().m15865a(message);
        }
    }
}
