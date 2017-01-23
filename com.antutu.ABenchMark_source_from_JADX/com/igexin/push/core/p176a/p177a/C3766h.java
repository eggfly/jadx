package com.igexin.push.core.p176a.p177a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.igexin.download.Downloads;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3829i;
import com.igexin.push.core.bean.PushTaskBean;
import com.qq.p035e.comm.pi.ACTD;
import com.umeng.message.entity.UMessage;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.h */
public class C3766h implements C3759a {
    public static HashMap f12686a;
    private static final String f12687b;

    static {
        f12687b = C3753l.f12646a;
        f12686a = new HashMap();
    }

    private int m15443a(C3829i c3829i) {
        int identifier = C3855g.f12969g.getResources().getIdentifier("push", "drawable", C3855g.f12967e);
        if (c3829i.m15749f() == null) {
            return identifier != 0 ? identifier : 17301651;
        } else {
            if ("null".equals(c3829i.m15749f())) {
                return 17301651;
            }
            if (c3829i.m15749f().startsWith("@")) {
                String f = c3829i.m15749f();
                return f.substring(1, f.length()).endsWith(NotificationCompatApi21.CATEGORY_EMAIL) ? 17301647 : 17301651;
            } else {
                identifier = C3855g.f12969g.getResources().getIdentifier(c3829i.m15749f(), "drawable", C3855g.f12967e);
                if (identifier == 0) {
                    identifier = C3855g.f12969g.getResources().getIdentifier(c3829i.m15749f(), "mipmap", C3855g.f12967e);
                }
                return identifier != 0 ? identifier : 17301651;
            }
        }
    }

    private PendingIntent m15444a(String str, String str2, String str3, int i) {
        Intent intent = new Intent("com.igexin.sdk.action.doaction");
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        intent.putExtra(ACTD.APPID_KEY, C3855g.f12963a);
        intent.putExtra("actionid", str3);
        intent.putExtra("accesstoken", C3855g.at);
        intent.putExtra("notifID", i);
        return PendingIntent.getBroadcast(C3855g.f12969g, new Random().nextInt(AdError.NETWORK_ERROR_CODE), intent, 134217728);
    }

    public C3820b m15445a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15446a(JSONObject jSONObject) {
        try {
            BaseAction c3829i = new C3829i();
            c3829i.setType(UMessage.DISPLAY_TYPE_NOTIFICATION);
            c3829i.setActionId(jSONObject.getString("actionid"));
            c3829i.setDoActionId(jSONObject.getString("do"));
            String string = jSONObject.getString(Downloads.COLUMN_TITLE);
            String string2 = jSONObject.getString("text");
            c3829i.m15736a(string);
            c3829i.m15739b(string2);
            if (jSONObject.has("logo") && !BuildConfig.FLAVOR.equals(jSONObject.getString("logo"))) {
                string = jSONObject.getString("logo");
                if (string.lastIndexOf(".png") == -1 && string.lastIndexOf(".jpeg") == -1) {
                    string = "null";
                } else {
                    int indexOf = string.indexOf(".png");
                    if (indexOf == -1) {
                        indexOf = string.indexOf(".jpeg");
                    }
                    if (indexOf != -1) {
                        string = string.substring(0, indexOf);
                    }
                }
                c3829i.m15741c(string);
            }
            if (jSONObject.has("is_noclear")) {
                c3829i.m15737a(jSONObject.getBoolean("is_noclear"));
            }
            if (jSONObject.has("is_novibrate")) {
                c3829i.m15740b(jSONObject.getBoolean("is_novibrate"));
            }
            if (jSONObject.has("is_noring")) {
                c3829i.m15742c(jSONObject.getBoolean("is_noring"));
            }
            if (jSONObject.has("is_chklayout")) {
                c3829i.m15745d(jSONObject.getBoolean("is_chklayout"));
            }
            if (jSONObject.has("logo_url")) {
                c3829i.m15744d(jSONObject.getString("logo_url"));
            }
            if (jSONObject.has("banner_url")) {
                c3829i.m15747e(jSONObject.getString("banner_url"));
            }
            return c3829i;
        } catch (JSONException e) {
            return null;
        }
    }

    public void m15447a(String str, String str2, C3829i c3829i) {
        Notification notification;
        int currentTimeMillis = (int) System.currentTimeMillis();
        C3855g.ai.put(str, Integer.valueOf(currentTimeMillis));
        PendingIntent a = m15444a(str, str2, c3829i.getDoActionId(), currentTimeMillis);
        NotificationManager notificationManager = (NotificationManager) C3855g.f12969g.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        int a2 = m15443a(c3829i);
        if (VERSION.SDK_INT < 11) {
            notification = new Notification();
            notification.icon = a2;
            try {
                Method method = Class.forName("android.app.Notification").getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class});
                method.setAccessible(true);
                method.invoke(notification, new Object[]{C3855g.f12969g, c3829i.m15735a(), c3829i.m15738b(), a});
            } catch (Exception e) {
                C3688a.m15097b(f12687b + "reflect invoke setLatestEventInfo failed!");
                return;
            }
        }
        notification = new Builder(C3855g.f12969g).setContentTitle(c3829i.m15735a()).setContentText(c3829i.m15738b()).setSmallIcon(a2).setLargeIcon(BitmapFactory.decodeResource(C3855g.f12969g.getResources(), a2)).setContentIntent(a).getNotification();
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("right_icon");
            field.setAccessible(true);
            notification.contentView.setViewVisibility(field.getInt(null), 8);
        } catch (Exception e2) {
        }
        notification.tickerText = c3829i.m15738b();
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = AdError.NETWORK_ERROR_CODE;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        if (c3829i.m15743c()) {
            notification.flags |= 32;
        } else {
            notification.flags |= 16;
        }
        if (!c3829i.m15748e()) {
            notification.defaults |= 1;
        }
        if (!c3829i.m15746d()) {
            notification.defaults |= 2;
        }
        if ((c3829i.m15751h() == null && c3829i.m15750g() == null) || !c3829i.m15752i()) {
            notificationManager.notify(currentTimeMillis, notification);
        }
    }

    public boolean m15448b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (!(pushTaskBean == null || baseAction == null || !(baseAction instanceof C3829i))) {
            C3829i c3829i = (C3829i) baseAction;
            if (TextUtils.isEmpty(c3829i.m15735a()) || TextUtils.isEmpty(c3829i.m15738b())) {
                C3688a.m15096a(f12687b, "title = " + c3829i.m15735a() + ", content = " + c3829i.m15738b() + ", is invalid, don't show");
                C3688a.m15097b(f12687b + " title = " + c3829i.m15735a() + ", content = " + c3829i.m15738b() + ", is invalid, don't show");
            } else {
                m15447a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), c3829i);
            }
        }
        return true;
    }
}
