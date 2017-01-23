package com.igexin.push.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.bean.C3827g;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.util.C3922a;
import com.igexin.sdk.PushConsts;
import org.android.agoo.message.MessageService;

/* renamed from: com.igexin.push.core.e */
public class C3853e extends Handler {
    private static String f12921a;

    static {
        f12921a = C3853e.class.getName();
    }

    public void handleMessage(Message message) {
        try {
            Bundle bundleExtra;
            if (message.what == C3794a.f12723c) {
                Intent intent = (Intent) message.obj;
                if (intent != null && intent.hasExtra(PushConsts.CMD_ACTION)) {
                    String stringExtra = intent.getStringExtra(PushConsts.CMD_ACTION);
                    if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE)) {
                        C3777e.m15491a().m15514a(intent);
                    } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
                        C3777e.m15491a().m15537b(intent);
                    } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
                        bundleExtra = intent.getBundleExtra("bundle");
                        C3688a.m15097b(f12921a + " receive broadcast com.igexin.sdk.action.pushmanager");
                        C3777e.m15491a().m15515a(bundleExtra);
                    } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
                        C3855g.f12946J = System.currentTimeMillis();
                        Object obj = 1;
                        if (C3777e.m15491a().m15528a(System.currentTimeMillis())) {
                            if (MessageService.MSG_DB_NOTIFY_REACHED.equals(C3777e.m15491a().m15551d("ccs"))) {
                                obj = null;
                            }
                        }
                        if (obj != null) {
                            C3777e.m15491a().m15576y();
                        }
                        if (C3855g.f12941E > C3754m.f12681y) {
                            long j = C3754m.f12681y / 10;
                            j = ((long) (((Math.random() * ((double) j)) * 2.0d) - ((double) j))) + C3754m.f12681y;
                            C3688a.m15097b(f12921a + "|USER_PRESENT, reConnectDelayTime > " + C3754m.f12681y + ",reset = " + j);
                            C3855g.f12941E = j;
                        }
                    } else if (stringExtra.equals("com.igexin.sdk.action.extdownloadsuccess")) {
                        C3777e.m15491a().m15552d(intent);
                    }
                }
            } else if (message.what == C3794a.f12724d) {
                C3777e.m15491a().m15546c((Intent) message.obj);
            } else if (message.what == C3794a.f12725e) {
                C3777e.m15491a().m15546c((Intent) message.obj);
            } else if (message.what == C3794a.f12726f) {
            } else {
                if (message.what == C3794a.f12727g) {
                    bundleExtra = (Bundle) message.obj;
                    C3777e.m15491a().m15542b(bundleExtra.getString("taskid"), bundleExtra.getString("messageid"), bundleExtra.getString("actionid"));
                } else if (message.what == C3794a.f12728h) {
                    C3922a.m16137a((C3827g) message.obj);
                } else if (message.what == C3794a.f12729i) {
                    C3777e.m15491a().m15571t();
                } else if (message.what == C3794a.f12730j) {
                    C3777e.m15491a().m15555e((Intent) message.obj);
                }
            }
        } catch (Throwable th) {
            C3688a.m15097b(f12921a + "|" + th.toString());
        }
    }
}
