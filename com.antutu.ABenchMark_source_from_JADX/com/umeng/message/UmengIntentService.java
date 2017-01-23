package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.umeng.analytics.C4156a;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.entity.UMessage;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class UmengIntentService extends UmengBaseIntentService {
    private static final String f14182a;

    /* renamed from: com.umeng.message.UmengIntentService.1 */
    class C42051 implements Runnable {
        final /* synthetic */ Context f14179a;
        final /* synthetic */ UMessage f14180b;
        final /* synthetic */ UmengIntentService f14181c;

        C42051(UmengIntentService umengIntentService, Context context, UMessage uMessage) {
            this.f14181c = umengIntentService;
            this.f14179a = context;
            this.f14180b = uMessage;
        }

        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (UmengMessageDeviceConfig.isServiceWork(this.f14179a, this.f14180b.pulled_service)) {
                UTrack.getInstance(this.f14179a).trackMsgPulled(this.f14180b, 51);
            } else {
                UTrack.getInstance(this.f14179a).trackMsgPulled(this.f14180b, 50);
            }
        }
    }

    static {
        f14182a = UmengIntentService.class.getName();
    }

    private Intent m17131a(Intent intent, UMessage uMessage) {
        if (!(intent == null || uMessage == null || uMessage.extra == null)) {
            for (Entry entry : uMessage.extra.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (str != null) {
                    intent.putExtra(str, str2);
                }
            }
        }
        return intent;
    }

    protected void onMessage(Context context, Intent intent) {
        super.onMessage(context, intent);
        String stringExtra = intent.getStringExtra(C4156a.f13961w);
        String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_ID);
        String stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
        try {
            UMessage uMessage = new UMessage(new JSONObject(stringExtra));
            if (UMessage.DISPLAY_TYPE_PULLAPP.equals(uMessage.display_type)) {
                if (UmengMessageDeviceConfig.isServiceWork(context, uMessage.pulled_service)) {
                    UTrack.getInstance(context).trackMsgPulled(uMessage, 52);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClassName(uMessage.pulled_package, uMessage.pulled_service);
                m17131a(intent2, uMessage);
                startService(intent2);
                new Thread(new C42051(this, context, uMessage)).start();
                return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String pushIntentServiceClass = MessageSharedPrefs.getInstance(context).getPushIntentServiceClass();
        if (pushIntentServiceClass.equalsIgnoreCase(BuildConfig.FLAVOR)) {
            try {
                Intent intent3 = new Intent();
                intent3.setPackage(context.getPackageName());
                intent3.setAction(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION);
                intent3.putExtra(C4156a.f13961w, stringExtra);
                intent3.putExtra(AgooConstants.MESSAGE_ID, stringExtra2);
                intent3.putExtra(AgooConstants.MESSAGE_TASK_ID, stringExtra3);
                context.startService(intent3);
                return;
            } catch (Exception e2) {
                Log.e(f14182a, e2.getMessage());
                return;
            }
        }
        intent2 = new Intent();
        intent2.setClassName(context, pushIntentServiceClass);
        intent2.setPackage(context.getPackageName());
        intent2.putExtra(C4156a.f13961w, stringExtra);
        intent2.putExtra(AgooConstants.MESSAGE_ID, stringExtra2);
        intent2.putExtra(AgooConstants.MESSAGE_TASK_ID, stringExtra3);
        context.startService(intent2);
    }
}
