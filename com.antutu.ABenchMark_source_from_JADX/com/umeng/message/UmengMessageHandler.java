package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import com.umeng.analytics.C4156a;
import com.umeng.message.common.C4211c;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.UNotificationItem;
import com.umeng.message.proguard.C4230g;
import com.umeng.message.proguard.C4232i;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.android.agoo.common.AgooConstants;

public class UmengMessageHandler implements UHandler {
    private static int f4018a = 0;
    private static final String f4019b;
    private static Date f4020c = null;
    private static String f4021d = null;
    private static final String f4022g = "umeng_push_notification_default_large_icon";
    private static final String f4023h = "umeng_push_notification_default_small_icon";
    private static final String f4024i = "umeng_push_notification_default_sound";
    private UMessage f4025e;
    private int f4026f;

    /* renamed from: com.umeng.message.UmengMessageHandler.1 */
    class C42081 {
        final /* synthetic */ PowerManager f14190a;
        final /* synthetic */ UmengMessageHandler f14191b;

        C42081(UmengMessageHandler umengMessageHandler, PowerManager powerManager) {
            this.f14191b = umengMessageHandler;
            this.f14190a = powerManager;
        }

        boolean m17135a() {
            return this.f14190a.isScreenOn();
        }
    }

    static {
        f4018a = 64;
        f4019b = UmengMessageHandler.class.getName();
        f4021d = "9999999999999";
    }

    public UmengMessageHandler() {
        this.f4025e = null;
    }

    @SuppressLint({"NewApi", "Wakelock"})
    private void m4956a(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            boolean z = false;
            if (VERSION.SDK_INT >= 7) {
                z = new C42081(this, powerManager).m17135a();
            } else {
                UmLog.m17136d(f4019b, "android os version < 7, skip checking screen on status");
            }
            UmLog.m17136d(f4019b, "screen on................................." + z);
            if (!z) {
                powerManager.newWakeLock(805306374, "MyLock").acquire(10000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m4957a(Context context, Notification notification, boolean z, UMessage uMessage) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            int i = this.f4026f;
            if (!(C4230g.m17279c(context) && C4230g.m17276b(context) && !PushAgent.getInstance(context).getNotificationOnForeground()) && (MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber() != 1 || z)) {
                if (MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber() > 0) {
                    while (MessageNotificationQueue.getInstance().size() >= MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber()) {
                        UNotificationItem pollFirst = MessageNotificationQueue.getInstance().pollFirst();
                        notificationManager.cancel(pollFirst.id);
                        UTrack.getInstance(context).setClearPrevMessage(false);
                        UTrack.getInstance(context).trackMsgDismissed(pollFirst.message);
                    }
                    MessageNotificationQueue.getInstance().addLast(new UNotificationItem(i, uMessage));
                }
                notificationManager.notify(i, notification);
                return;
            }
            UTrack.getInstance(context).setClearPrevMessage(false);
            UTrack.getInstance(context).trackMsgDismissed(uMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean m4958a(Context context, Builder builder, UMessage uMessage) {
        int smallIconId = getSmallIconId(context, uMessage);
        Bitmap largeIcon = getLargeIcon(context, uMessage);
        if (smallIconId < 0) {
            return false;
        }
        builder.setSmallIcon(smallIconId);
        builder.setLargeIcon(largeIcon);
        return true;
    }

    public void dealWithCustomMessage(Context context, UMessage uMessage) {
    }

    public void dealWithNotificationMessage(Context context, UMessage uMessage) {
        UmLog.m17136d(f4019b, "notify: " + uMessage.getRaw().toString());
        if (!uMessage.hasResourceFromInternet() || MessageSharedPrefs.getInstance(context).hasMessageResourceDownloaded(uMessage.msg_id) || !startDownloadResourceService(context, uMessage)) {
            String substring;
            String lastMessageMsgID = MessageSharedPrefs.getInstance(context).getLastMessageMsgID();
            lastMessageMsgID = BuildConfig.FLAVOR.equals(lastMessageMsgID) ? BuildConfig.FLAVOR : lastMessageMsgID.substring(7, 20);
            if (uMessage.msg_id != null && 22 == uMessage.msg_id.length() && uMessage.msg_id.startsWith("u")) {
                MessageSharedPrefs.getInstance(context).setLastMessageMsgID(uMessage.msg_id);
                substring = uMessage.msg_id.substring(7, 20);
            } else {
                substring = f4021d;
            }
            boolean z = BuildConfig.FLAVOR.equals(lastMessageMsgID) ? true : substring.compareToIgnoreCase(lastMessageMsgID) >= 0;
            MessageSharedPrefs.getInstance(context).removeMessageResouceRecord(uMessage.msg_id);
            Notification notification = getNotification(context, uMessage);
            Builder builder;
            PendingIntent clickPendingIntent;
            int notificationDefaults;
            Uri sound;
            if (notification == null || notification.icon == 0) {
                if (notification == null) {
                    builder = new Builder(context);
                    if (m4958a(context, builder, uMessage)) {
                        builder.setContentTitle(uMessage.title).setContentText(uMessage.text).setTicker(uMessage.ticker).setAutoCancel(true);
                        notification = builder.getNotification();
                    } else {
                        return;
                    }
                }
                this.f4026f = new Random(System.nanoTime()).nextInt();
                clickPendingIntent = getClickPendingIntent(context, uMessage);
                notification.deleteIntent = getDismissPendingIntent(context, uMessage);
                notification.contentIntent = clickPendingIntent;
                notificationDefaults = getNotificationDefaults(context, uMessage);
                if ((notificationDefaults & 1) != 0) {
                    sound = getSound(context, uMessage);
                    if (sound != null) {
                        notification.sound = getSound(context, uMessage);
                    }
                    if (sound != null) {
                        notificationDefaults ^= 1;
                    }
                }
                notification.defaults = notificationDefaults;
                m4957a(context, notification, z, uMessage);
            }
            if (notification == null) {
                builder = new Builder(context);
                if (m4958a(context, builder, uMessage)) {
                    builder.setContentTitle(uMessage.title).setContentText(uMessage.text).setTicker(uMessage.ticker).setAutoCancel(true);
                    notification = builder.getNotification();
                } else {
                    return;
                }
            }
            this.f4026f = new Random(System.nanoTime()).nextInt();
            clickPendingIntent = getClickPendingIntent(context, uMessage);
            notification.deleteIntent = getDismissPendingIntent(context, uMessage);
            notification.contentIntent = clickPendingIntent;
            notificationDefaults = getNotificationDefaults(context, uMessage);
            if ((notificationDefaults & 1) != 0) {
                sound = getSound(context, uMessage);
                if (sound != null) {
                    notification.sound = getSound(context, uMessage);
                }
                if (sound != null) {
                    notificationDefaults ^= 1;
                }
            }
            notification.defaults = notificationDefaults;
            m4957a(context, notification, z, uMessage);
        }
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, NotificationProxyBroadcastReceiver.class);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MSG, uMessage.getRaw().toString());
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 10);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MESSAGE_ID, uMessage.message_id);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_NOTIFICATION_ID, this.f4026f);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_TASK_ID, uMessage.task_id);
        return PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, 268435456);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, NotificationProxyBroadcastReceiver.class);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MSG, uMessage.getRaw().toString());
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 11);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MESSAGE_ID, uMessage.message_id);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_NOTIFICATION_ID, this.f4026f);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_TASK_ID, uMessage.task_id);
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, 268435456);
    }

    public Bitmap getLargeIcon(Context context, UMessage uMessage) {
        try {
            Bitmap decodeResource;
            int dimension;
            Bitmap decodeFile = uMessage.isLargeIconFromInternet() ? BitmapFactory.decodeFile(UmengDownloadResourceService.getMessageResourceFolder(context, uMessage) + uMessage.img.hashCode()) : null;
            if (decodeFile == null) {
                int i = -1;
                if (!TextUtils.isEmpty(uMessage.largeIcon)) {
                    i = C4211c.m17179a(context).m17183c(uMessage.largeIcon);
                }
                if (i < 0) {
                    i = C4211c.m17179a(context).m17183c(f4022g);
                }
                if (i > 0) {
                    decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
                    if (decodeResource != null) {
                        return null;
                    }
                    dimension = VERSION.SDK_INT < 11 ? (int) context.getResources().getDimension(17104902) : C4232i.m17287a((float) f4018a);
                    return Bitmap.createScaledBitmap(decodeResource, dimension, dimension, true);
                }
            }
            decodeResource = decodeFile;
            if (decodeResource != null) {
                return null;
            }
            if (VERSION.SDK_INT < 11) {
            }
            return Bitmap.createScaledBitmap(decodeResource, dimension, dimension, true);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Notification getNotification(Context context, UMessage uMessage) {
        return null;
    }

    public int getNotificationDefaults(Context context, UMessage uMessage) {
        int i = 0;
        long muteDuration = (1 * ((long) MessageSharedPrefs.getInstance(context).getMuteDuration())) * 1000;
        if (!isInNoDisturbTime(context) && (f4020c == null || Calendar.getInstance().getTimeInMillis() - f4020c.getTime() >= muteDuration)) {
            int notificationPlayVibrate = MessageSharedPrefs.getInstance(context).getNotificationPlayVibrate();
            UmLog.m17136d(f4019b, "playVibrate:" + notificationPlayVibrate);
            if (notificationPlayVibrate == 1) {
                i = 2;
            } else if (notificationPlayVibrate != 2 && uMessage.play_vibrate) {
                i = 2;
            }
            notificationPlayVibrate = MessageSharedPrefs.getInstance(context).getNotificationPlayLights();
            UmLog.m17136d(f4019b, "playLights:" + notificationPlayVibrate);
            if (notificationPlayVibrate == 1) {
                i |= 4;
            } else if (notificationPlayVibrate != 2 && uMessage.play_lights) {
                i |= 4;
            }
            notificationPlayVibrate = MessageSharedPrefs.getInstance(context).getNotificationPlaySound();
            UmLog.m17136d(f4019b, "playSound:" + notificationPlayVibrate);
            if (notificationPlayVibrate == 1) {
                i |= 1;
            } else if (notificationPlayVibrate != 2 && uMessage.play_sound) {
                i |= 1;
            }
            f4020c = Calendar.getInstance().getTime();
            if (uMessage.screen_on) {
                m4956a(context);
            }
        }
        return i;
    }

    public int getSmallIconId(Context context, UMessage uMessage) {
        int i;
        Exception e;
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(uMessage.icon)) {
                i2 = C4211c.m17179a(context).m17183c(uMessage.icon);
            }
            if (i2 < 0) {
                i2 = C4211c.m17179a(context).m17183c(f4023h);
            }
            if (i2 < 0) {
                UmLog.m17136d(f4019b, "no custom notificaiton icon, fail back to app icon.");
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
            } else {
                i = i2;
            }
            if (i < 0) {
                try {
                    UmLog.m17138e(f4019b, "Cann't find appropriate icon for notification, please make sure you have specified an icon for this notification or the app has defined an icon.");
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return i;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            i = -1;
            e = exception;
            e.printStackTrace();
            return i;
        }
        return i;
    }

    public Uri getSound(Context context, UMessage uMessage) {
        Uri uri = null;
        try {
            String str;
            if (uMessage.isSoundFromInternet()) {
                str = UmengDownloadResourceService.getMessageResourceFolder(context, uMessage) + uMessage.sound.hashCode();
                if (!new File(str).exists()) {
                    str = null;
                }
            } else {
                str = null;
            }
            if (str == null) {
                int i = -1;
                if (!TextUtils.isEmpty(uMessage.sound)) {
                    i = C4211c.m17179a(context).m17188h(uMessage.sound);
                }
                if (i < 0) {
                    i = C4211c.m17179a(context).m17188h(f4024i);
                }
                if (i > 0) {
                    str = "android.resource://" + context.getPackageName() + "/" + i;
                }
            }
            if (str != null) {
                uri = Uri.parse(str);
            }
        } catch (Throwable th) {
        }
        return uri;
    }

    public void handleMessage(Context context, UMessage uMessage) {
        if (UMessage.DISPLAY_TYPE_NOTIFICATION.equals(uMessage.display_type)) {
            dealWithNotificationMessage(context, uMessage);
        } else if (UMessage.DISPLAY_TYPE_CUSTOM.equals(uMessage.display_type)) {
            UTrack.getInstance(context).setClearPrevMessage(false);
            dealWithCustomMessage(context, uMessage);
        }
    }

    public boolean isInNoDisturbTime(Context context) {
        int i = Calendar.getInstance().get(11);
        int i2 = Calendar.getInstance().get(12);
        boolean z = (i * 60) + i2 >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute();
        boolean z2 = (i * 60) + i2 <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute();
        return (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute() ? z && z2 : z || z2;
    }

    public void setPrevMessage(UMessage uMessage) {
        this.f4025e = uMessage;
    }

    public boolean startDownloadResourceService(Context context, UMessage uMessage) {
        try {
            Intent intent = new Intent(context, UmengDownloadResourceService.class);
            intent.putExtra(C4156a.f13961w, uMessage.getRaw().toString());
            intent.putExtra(AgooConstants.MESSAGE_ID, uMessage.message_id);
            intent.putExtra(AgooConstants.MESSAGE_TASK_ID, uMessage.task_id);
            context.startService(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
