package com.igexin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.sdk.p186a.C3942d;
import org.android.agoo.message.MessageService;

public class PushReceiver extends BroadcastReceiver {
    private static final String f13229a;

    static {
        f13229a = PushReceiver.class.getName();
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                String d = C3777e.m15491a().m15551d("ss");
                if (d == null || !d.equals(MessageService.MSG_DB_NOTIFY_REACHED) || new C3942d(context).m16228c()) {
                    d = intent.getAction();
                    String verifyCode;
                    if (PushConsts.ACTION_BROADCAST_PUSHMANAGER.equals(d)) {
                        Bundle extras = intent.getExtras();
                        if (extras == null) {
                            return;
                        }
                        if (extras.containsKey("verifyCode")) {
                            verifyCode = PushManager.getInstance().getVerifyCode();
                            if (verifyCode == null || verifyCode.equals(extras.getString("verifyCode"))) {
                                Intent intent2 = new Intent(context.getApplicationContext(), PushService.class);
                                intent2.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                                intent2.putExtra("bundle", intent.getExtras());
                                context.getApplicationContext().startService(intent2);
                                return;
                            }
                            C3688a.m15097b(f13229a + " bundle verifyCode : " + extras.getString("verifyCode") + " != " + verifyCode);
                            return;
                        }
                        C3688a.m15097b(f13229a + " bundle not contains verifyCode, ignore broadcast ####");
                    } else if (PushConsts.ACTION_BROADCAST_REFRESHLS.equals(d)) {
                        d = intent.getStringExtra("callback_pkgname");
                        verifyCode = intent.getStringExtra("callback_classname");
                        Intent intent3 = new Intent(context.getApplicationContext(), PushService.class);
                        intent3.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_REFRESHLS);
                        intent3.putExtra("callback_pkgname", d);
                        intent3.putExtra("callback_classname", verifyCode);
                        context.startService(intent3);
                    } else if (PushConsts.ACTION_BROADCAST_TO_BOOT.equals(d) || d.equals("android.intent.action.ACTION_POWER_CONNECTED") || d.equals("android.intent.action.ACTION_POWER_DISCONNECTED") || d.equals("android.intent.action.MEDIA_MOUNTED")) {
                        context.startService(new Intent(context.getApplicationContext(), PushService.class));
                    } else if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(d) || PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(d)) {
                        Intent intent4 = new Intent(context.getApplicationContext(), PushService.class);
                        intent4.putExtra(PushConsts.CMD_ACTION, d);
                        context.startService(intent4);
                    }
                }
            } catch (Throwable th) {
                C3688a.m15097b(f13229a + "|" + th.toString());
            }
        }
    }
}
