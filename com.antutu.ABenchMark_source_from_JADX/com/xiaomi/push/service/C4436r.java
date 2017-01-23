package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.umeng.analytics.C4156a;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.android.C4290b;
import com.xiaomi.channel.commonutils.android.C4290b.C4289a;
import com.xiaomi.channel.commonutils.android.C4294f;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.reflect.C4323a;
import com.xiaomi.xmpush.thrift.C4529i;
import com.xiaomi.xmpush.thrift.C4542p;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.service.r */
public class C4436r {
    public static long f15142a;
    private static LinkedList<Pair<Integer, String>> f15143b;

    static {
        f15142a = 0;
        f15143b = new LinkedList();
    }

    private static int m18322a(Context context, String str, String str2) {
        return str.equals(context.getPackageName()) ? context.getResources().getIdentifier(str2, "drawable", str) : 0;
    }

    private static Notification m18323a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", new Class[]{CharSequence.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{str});
        } catch (Throwable e) {
            C4302b.m17651a(e);
        }
        return notification;
    }

    @SuppressLint({"NewApi"})
    private static Notification m18324a(Context context, C4542p c4542p, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        C4529i m = c4542p.m19025m();
        Map s = m.m18892s();
        Object builder = new Builder(context);
        String[] a = C4436r.m18334a(context, m);
        builder.setContentTitle(a[0]);
        builder.setContentText(a[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (VERSION.SDK_INT >= 16) {
            builder.setStyle(new BigTextStyle().bigText(a[1]));
        }
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(pendingIntent);
        int a2 = C4436r.m18322a(context, C4436r.m18328a(c4542p), "mipush_notification");
        int a3 = C4436r.m18322a(context, C4436r.m18328a(c4542p), "mipush_small_notification");
        if (a2 <= 0 || a3 <= 0) {
            builder.setSmallIcon(C4436r.m18342f(context, C4436r.m18328a(c4542p)));
        } else {
            builder.setLargeIcon(C4436r.m18326a(context, a2));
            builder.setSmallIcon(a3);
        }
        if (VERSION.SDK_INT >= 24) {
            String str = (String) s.get("notification_group");
            boolean parseBoolean = Boolean.parseBoolean((String) s.get("notification_is_summary"));
            C4323a.m17717a(builder, "setGroup", str);
            C4323a.m17717a(builder, "setGroupSummary", Boolean.valueOf(parseBoolean));
        }
        builder.setAutoCancel(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (s != null && s.containsKey("ticker")) {
            builder.setTicker((CharSequence) s.get("ticker"));
        }
        if (currentTimeMillis - f15142a > 10000) {
            f15142a = currentTimeMillis;
            a3 = C4436r.m18341e(context, C4436r.m18328a(c4542p)) ? C4436r.m18339c(context, C4436r.m18328a(c4542p)) : m.f15844f;
            builder.setDefaults(a3);
            if (!(s == null || (a3 & 1) == 0)) {
                str = (String) s.get("sound_uri");
                if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + C4436r.m18328a(c4542p))) {
                    builder.setDefaults(a3 ^ 1);
                    builder.setSound(Uri.parse(str));
                }
            }
        }
        return builder.getNotification();
    }

    private static PendingIntent m18325a(Context context, C4542p c4542p, C4529i c4529i, byte[] bArr) {
        Intent intent;
        if (c4529i != null && !TextUtils.isEmpty(c4529i.f15845g)) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(c4529i.f15845g));
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, 0, intent, 134217728);
        } else if (C4436r.m18338b(c4542p)) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(c4529i.m18890q()));
            return PendingIntent.getService(context, 0, intent, 134217728);
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(c4542p.f16046f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(c4529i.m18890q()));
            return PendingIntent.getService(context, 0, intent, 134217728);
        }
    }

    private static Bitmap m18326a(Context context, int i) {
        return C4436r.m18327a(context.getResources().getDrawable(i));
    }

    public static Bitmap m18327a(Drawable drawable) {
        int i = 1;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    static String m18328a(C4542p c4542p) {
        if ("com.xiaomi.xmsf".equals(c4542p.f16046f)) {
            C4529i m = c4542p.m19025m();
            if (!(m == null || m.m18892s() == null)) {
                String str = (String) m.m18892s().get("miui_package_name");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return c4542p.f16046f;
    }

    private static void m18329a(Notification notification, int i) {
        Object a = C4323a.m17716a((Object) notification, "extraNotification");
        if (a != null) {
            C4323a.m17717a(a, "setMessageCount", Integer.valueOf(i));
        }
    }

    public static void m18330a(Context context, C4542p c4542p, byte[] bArr) {
        if (C4290b.m17602d(context, C4436r.m18328a(c4542p)) == C4289a.NOT_ALLOWED) {
            C4302b.m17649a("Do not notify because user block " + C4436r.m18328a(c4542p) + "\u2018s notification");
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        C4529i m = c4542p.m19025m();
        RemoteViews b = C4436r.m18335b(context, c4542p, bArr);
        PendingIntent a = C4436r.m18325a(context, c4542p, m, bArr);
        if (a == null) {
            C4302b.m17649a("The click PendingIntent is null. ");
            return;
        }
        Notification a2;
        int i;
        String str;
        if (VERSION.SDK_INT >= 11) {
            a2 = C4436r.m18324a(context, c4542p, bArr, b, a);
        } else {
            Notification notification = new Notification(C4436r.m18342f(context, C4436r.m18328a(c4542p)), null, System.currentTimeMillis());
            String[] a3 = C4436r.m18334a(context, m);
            try {
                notification.getClass().getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification, new Object[]{context, a3[0], a3[1], a});
            } catch (Throwable e) {
                C4302b.m17651a(e);
            } catch (Throwable e2) {
                C4302b.m17651a(e2);
            } catch (Throwable e22) {
                C4302b.m17651a(e22);
            } catch (Throwable e222) {
                C4302b.m17651a(e222);
            }
            Map s = m.m18892s();
            if (s != null && s.containsKey("ticker")) {
                notification.tickerText = (CharSequence) s.get("ticker");
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f15142a > 10000) {
                int c;
                f15142a = currentTimeMillis;
                i = m.f15844f;
                if (C4436r.m18341e(context, C4436r.m18328a(c4542p))) {
                    c = C4436r.m18339c(context, C4436r.m18328a(c4542p));
                } else {
                    c = i;
                }
                notification.defaults = c;
                if (!(s == null || (c & 1) == 0)) {
                    str = (String) s.get("sound_uri");
                    if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + C4436r.m18328a(c4542p))) {
                        notification.defaults = c ^ 1;
                        notification.sound = Uri.parse(str);
                    }
                }
            }
            notification.flags |= 16;
            if (b != null) {
                notification.contentView = b;
            }
            a2 = notification;
        }
        str = (String) m.m18892s().get("message_count");
        if (C4294f.m17617a() && str != null) {
            try {
                C4436r.m18329a(a2, Integer.parseInt(str));
            } catch (Throwable e2222) {
                C4302b.m17651a(e2222);
            }
        }
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            C4436r.m18323a(a2, C4436r.m18328a(c4542p));
        }
        i = m.m18890q() + ((C4436r.m18328a(c4542p).hashCode() / 10) * 10);
        notificationManager.notify(i, a2);
        Pair pair = new Pair(Integer.valueOf(i), C4436r.m18328a(c4542p));
        synchronized (f15143b) {
            f15143b.add(pair);
            if (f15143b.size() > 100) {
                f15143b.remove();
            }
        }
    }

    public static void m18331a(Context context, String str, int i) {
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        ((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).cancel(hashCode);
        synchronized (f15143b) {
            Iterator it = f15143b.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (hashCode == ((Integer) pair.first).intValue() && TextUtils.equals(str, (CharSequence) pair.second)) {
                    f15143b.remove(pair);
                    break;
                }
            }
        }
    }

    public static boolean m18332a(Context context, String str) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m18333a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return MessageService.MSG_DB_NOTIFY_REACHED.equals((String) map.get("notify_foreground"));
    }

    private static String[] m18334a(Context context, C4529i c4529i) {
        String h = c4529i.m18881h();
        String j = c4529i.m18883j();
        Map s = c4529i.m18892s();
        if (s != null) {
            int intValue = Float.valueOf((((float) context.getResources().getDisplayMetrics().widthPixels) / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            String str;
            if (intValue <= 320) {
                str = (String) s.get("title_short");
                if (!TextUtils.isEmpty(str)) {
                    h = str;
                }
                CharSequence charSequence = (String) s.get("description_short");
                if (TextUtils.isEmpty(charSequence)) {
                    Object obj = j;
                }
                j = charSequence;
            } else if (intValue > C4156a.f13955q) {
                str = (String) s.get("title_long");
                if (!TextUtils.isEmpty(str)) {
                    h = str;
                }
                str = (String) s.get("description_long");
                if (!TextUtils.isEmpty(str)) {
                    j = str;
                }
            }
        }
        return new String[]{h, j};
    }

    private static RemoteViews m18335b(Context context, C4542p c4542p, byte[] bArr) {
        C4529i m = c4542p.m19025m();
        String a = C4436r.m18328a(c4542p);
        Map s = m.m18892s();
        if (s == null) {
            return null;
        }
        String str = (String) s.get("layout_name");
        String str2 = (String) s.get("layout_value");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a);
            int identifier = resourcesForApplication.getIdentifier(str, "layout", a);
            if (identifier == 0) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(a, identifier);
            try {
                JSONObject jSONObject;
                Iterator keys;
                JSONObject jSONObject2 = new JSONObject(str2);
                if (jSONObject2.has("text")) {
                    jSONObject = jSONObject2.getJSONObject("text");
                    keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        CharSequence string = jSONObject.getString(str);
                        identifier = resourcesForApplication.getIdentifier(str, AgooConstants.MESSAGE_ID, a);
                        if (identifier > 0) {
                            remoteViews.setTextViewText(identifier, string);
                        }
                    }
                }
                if (jSONObject2.has("image")) {
                    jSONObject = jSONObject2.getJSONObject("image");
                    keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        String string2 = jSONObject.getString(str);
                        identifier = resourcesForApplication.getIdentifier(str, AgooConstants.MESSAGE_ID, a);
                        int identifier2 = resourcesForApplication.getIdentifier(string2, "drawable", a);
                        if (identifier > 0) {
                            remoteViews.setImageViewResource(identifier, identifier2);
                        }
                    }
                }
                if (jSONObject2.has(C4233j.f14377D)) {
                    jSONObject2 = jSONObject2.getJSONObject(C4233j.f14377D);
                    keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        str2 = jSONObject2.getString(str);
                        if (str2.length() == 0) {
                            str2 = "yy-MM-dd hh:mm";
                        }
                        identifier = resourcesForApplication.getIdentifier(str, AgooConstants.MESSAGE_ID, a);
                        if (identifier > 0) {
                            remoteViews.setTextViewText(identifier, new SimpleDateFormat(str2).format(new Date(System.currentTimeMillis())));
                        }
                    }
                }
                return remoteViews;
            } catch (Throwable e) {
                C4302b.m17651a(e);
                return null;
            }
        } catch (Throwable e2) {
            C4302b.m17651a(e2);
            return null;
        }
    }

    public static void m18336b(Context context, String str) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        synchronized (f15143b) {
            Iterator it = ((LinkedList) f15143b.clone()).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (TextUtils.equals((CharSequence) pair.second, str)) {
                    notificationManager.cancel(((Integer) pair.first).intValue());
                    f15143b.remove(pair);
                }
            }
        }
    }

    static void m18337b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    public static boolean m18338b(C4542p c4542p) {
        C4529i m = c4542p.m19025m();
        return m != null && m.m18895v();
    }

    static int m18339c(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    static void m18340d(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    static boolean m18341e(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    private static int m18342f(Context context, String str) {
        int a = C4436r.m18322a(context, str, "mipush_notification");
        int a2 = C4436r.m18322a(context, str, "mipush_small_notification");
        if (a <= 0) {
            a = a2 > 0 ? a2 : context.getApplicationInfo().icon;
        }
        return (a != 0 || VERSION.SDK_INT < 9) ? a : context.getApplicationInfo().logo;
    }
}
