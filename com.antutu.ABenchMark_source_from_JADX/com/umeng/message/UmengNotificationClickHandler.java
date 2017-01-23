package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C4239k;
import java.lang.reflect.Method;
import java.util.Map.Entry;

public class UmengNotificationClickHandler implements UHandler {
    private static final String f4608a;

    static {
        f4608a = UmengNotificationClickHandler.class.getName();
    }

    private Intent m5401a(Intent intent, UMessage uMessage) {
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

    public void autoUpdate(Context context, UMessage uMessage) {
        try {
            Object g = C4239k.m17301a(context).m17328g();
            Class cls = Class.forName("com.umeng.update.UmengUpdateAgent");
            Class cls2 = Class.forName("com.umeng.update.UpdateResponse");
            Method method = cls.getMethod("showUpdateDialog", new Class[]{Context.class, cls2});
            if (g != null) {
                method.invoke(cls, new Object[]{context, cls2.cast(g)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dealWithCustomAction(Context context, UMessage uMessage) {
    }

    public void dismissNotification(Context context, UMessage uMessage) {
    }

    public void handleMessage(Context context, UMessage uMessage) {
        try {
            if (!uMessage.clickOrDismiss) {
                dismissNotification(context, uMessage);
            } else if (TextUtils.equals(UMessage.DISPLAY_TYPE_AUTOUPDATE, uMessage.display_type) && PushAgent.getInstance(context).isIncludesUmengUpdateSDK()) {
                autoUpdate(context, uMessage);
            } else {
                if (!TextUtils.isEmpty(uMessage.after_open)) {
                    if (TextUtils.equals(UMessage.NOTIFICATION_GO_URL, uMessage.after_open)) {
                        openUrl(context, uMessage);
                        return;
                    } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_ACTIVITY, uMessage.after_open)) {
                        openActivity(context, uMessage);
                        return;
                    } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_CUSTOM, uMessage.after_open)) {
                        dealWithCustomAction(context, uMessage);
                        return;
                    } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_APP, uMessage.after_open)) {
                        launchApp(context, uMessage);
                        return;
                    }
                }
                if (uMessage.url != null && !TextUtils.isEmpty(uMessage.url.trim())) {
                    openUrl(context, uMessage);
                } else if (uMessage.activity != null && !TextUtils.isEmpty(uMessage.activity.trim())) {
                    openActivity(context, uMessage);
                } else if (uMessage.custom == null || TextUtils.isEmpty(uMessage.custom.trim())) {
                    launchApp(context, uMessage);
                } else {
                    dealWithCustomAction(context, uMessage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchApp(Context context, UMessage uMessage) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            UmLog.m17138e(f4608a, "handleMessage(): cannot find app: " + context.getPackageName());
            return;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(268435456);
        m5401a(launchIntentForPackage, uMessage);
        context.startActivity(launchIntentForPackage);
        UmLog.m17136d(f4608a, "handleMessage(): lunach app: " + context.getPackageName());
    }

    public void openActivity(Context context, UMessage uMessage) {
        if (uMessage.activity != null && !TextUtils.isEmpty(uMessage.activity.trim())) {
            Intent intent = new Intent();
            m5401a(intent, uMessage);
            intent.setClassName(context, uMessage.activity);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void openUrl(Context context, UMessage uMessage) {
        if (uMessage.url != null && !TextUtils.isEmpty(uMessage.url.trim())) {
            UmLog.m17136d(f4608a, "handleMessage(): open url: " + uMessage.url);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uMessage.url));
            m5401a(intent, uMessage);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
