package com.igexin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.sdk.p186a.C3942d;
import org.android.agoo.message.MessageService;

public class PushManagerReceiver extends BroadcastReceiver {
    private static String f13228a;

    static {
        f13228a = "PushManagerReceiver";
    }

    public void onReceive(Context context, Intent intent) {
        String d = C3777e.m15491a().m15551d("ss");
        if ((d == null || !d.equals(MessageService.MSG_DB_NOTIFY_REACHED) || new C3942d(context).m16228c()) && intent != null) {
            if (PushConsts.ACTION_BROADCAST_PUSHMANAGER.equals(intent.getAction())) {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                if (extras.containsKey("verifyCode")) {
                    String verifyCode = PushManager.getInstance().getVerifyCode();
                    if (verifyCode == null || verifyCode.equals(extras.getString("verifyCode"))) {
                        try {
                            Intent intent2 = new Intent(context.getApplicationContext(), PushService.class);
                            intent2.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                            intent2.putExtra("bundle", intent.getExtras());
                            context.getApplicationContext().startService(intent2);
                            return;
                        } catch (Throwable th) {
                            C3688a.m15097b(f13228a + "|" + th.toString());
                            return;
                        }
                    }
                    C3688a.m15097b(f13228a + " bundle verifyCode : " + extras.getString("verifyCode") + " != " + verifyCode);
                    return;
                }
                C3688a.m15097b(f13228a + " bundle not contains verifyCode, ignore broadcast ####");
            }
        }
    }
}
