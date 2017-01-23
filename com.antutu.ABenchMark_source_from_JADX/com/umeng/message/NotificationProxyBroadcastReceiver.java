package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.UNotificationItem;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationProxyBroadcastReceiver extends BroadcastReceiver {
    public static final int EXTRA_ACTION_CLICK = 10;
    public static final int EXTRA_ACTION_DISMISS = 11;
    public static final int EXTRA_ACTION_NOT_EXIST = -1;
    public static final String EXTRA_KEY_ACTION = "ACTION";
    public static final String EXTRA_KEY_MESSAGE_ID = "MESSAGE_ID";
    public static final String EXTRA_KEY_MSG = "MSG";
    public static final String EXTRA_KEY_NOTIFICATION_ID = "NOTIFICATION_ID";
    public static final String EXTRA_KEY_TASK_ID = "TASK_ID";
    public static final int LOCAL_ACTION_CLICK = 12;
    private static final String f14095a;
    private UHandler f14096b;

    static {
        f14095a = NotificationProxyBroadcastReceiver.class.getName();
    }

    private void m17091a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            UmLog.m17138e(f14095a, "handleMessage(): cannot find app: " + context.getPackageName());
            return;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(268435456);
        context.startActivity(launchIntentForPackage);
        UmLog.m17136d(f14095a, "handleMessage(): lunach app: " + context.getPackageName());
    }

    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_KEY_MSG);
        try {
            int intExtra = intent.getIntExtra(EXTRA_KEY_ACTION, EXTRA_ACTION_NOT_EXIST);
            UmLog.m17136d(f14095a, String.format("onReceive[msg=%s, action=%d]", new Object[]{stringExtra, Integer.valueOf(intExtra)}));
            if (intExtra == LOCAL_ACTION_CLICK) {
                m17091a(context);
                return;
            }
            UMessage uMessage = new UMessage(new JSONObject(stringExtra));
            int intExtra2 = intent.getIntExtra(EXTRA_KEY_NOTIFICATION_ID, EXTRA_ACTION_NOT_EXIST);
            uMessage.message_id = intent.getStringExtra(EXTRA_KEY_MESSAGE_ID);
            uMessage.task_id = intent.getStringExtra(EXTRA_KEY_TASK_ID);
            switch (intExtra) {
                case EXTRA_ACTION_CLICK /*10*/:
                    UmLog.m17136d(f14095a, "click notification");
                    UTrack.getInstance(context).setClearPrevMessage(true);
                    UTrack.getInstance(context).trackMsgClick(uMessage);
                    this.f14096b = PushAgent.getInstance(context).getNotificationClickHandler();
                    if (this.f14096b != null) {
                        uMessage.clickOrDismiss = true;
                        this.f14096b.handleMessage(context, uMessage);
                        break;
                    }
                    break;
                case EXTRA_ACTION_DISMISS /*11*/:
                    UmLog.m17136d(f14095a, "dismiss notification");
                    UTrack.getInstance(context).setClearPrevMessage(true);
                    UTrack.getInstance(context).trackMsgDismissed(uMessage);
                    this.f14096b = PushAgent.getInstance(context).getNotificationClickHandler();
                    if (this.f14096b != null) {
                        uMessage.clickOrDismiss = false;
                        this.f14096b.handleMessage(context, uMessage);
                        break;
                    }
                    break;
            }
            if (MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber() > 0) {
                MessageNotificationQueue.getInstance().remove(new UNotificationItem(intExtra2, uMessage));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
