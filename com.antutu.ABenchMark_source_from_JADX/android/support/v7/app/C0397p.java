package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase.Action;
import android.support.v7.appcompat.C0417R;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

/* renamed from: android.support.v7.app.p */
class C0397p {
    private static int m1093a(int i) {
        return i <= 3 ? C0417R.layout.notification_template_big_media_narrow : C0417R.layout.notification_template_big_media;
    }

    private static RemoteViews m1094a(Context context, Action action) {
        Object obj = action.getActionIntent() == null ? 1 : null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0417R.layout.notification_media_action);
        remoteViews.setImageViewResource(C0417R.id.action0, action.getIcon());
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(C0417R.id.action0, action.getActionIntent());
        }
        if (VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(C0417R.id.action0, action.getTitle());
        }
        return remoteViews;
    }

    private static RemoteViews m1095a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, boolean z2) {
        Object obj;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        Object obj2 = null;
        Object obj3 = null;
        if (bitmap == null || VERSION.SDK_INT < 16) {
            remoteViews.setViewVisibility(C0417R.id.icon, 8);
        } else {
            remoteViews.setViewVisibility(C0417R.id.icon, 0);
            remoteViews.setImageViewBitmap(C0417R.id.icon, bitmap);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(C0417R.id.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(C0417R.id.text, charSequence2);
            obj2 = 1;
        }
        if (charSequence3 != null) {
            remoteViews.setTextViewText(C0417R.id.info, charSequence3);
            remoteViews.setViewVisibility(C0417R.id.info, 0);
            obj = 1;
        } else if (i > 0) {
            if (i > context.getResources().getInteger(C0417R.integer.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(C0417R.id.info, context.getResources().getString(C0417R.string.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(C0417R.id.info, NumberFormat.getIntegerInstance().format((long) i));
            }
            remoteViews.setViewVisibility(C0417R.id.info, 0);
            int i3 = 1;
        } else {
            remoteViews.setViewVisibility(C0417R.id.info, 8);
            obj = obj2;
        }
        if (charSequence4 != null && VERSION.SDK_INT >= 16) {
            remoteViews.setTextViewText(C0417R.id.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0417R.id.text2, charSequence2);
                remoteViews.setViewVisibility(C0417R.id.text2, 0);
                obj3 = 1;
            } else {
                remoteViews.setViewVisibility(C0417R.id.text2, 8);
            }
        }
        if (obj3 != null && VERSION.SDK_INT >= 16) {
            if (z2) {
                remoteViews.setTextViewTextSize(C0417R.id.text, 0, (float) context.getResources().getDimensionPixelSize(C0417R.dimen.notification_subtext_size));
            }
            remoteViews.setViewPadding(C0417R.id.line1, 0, 0, 0, 0);
        }
        if (j != 0) {
            if (z) {
                remoteViews.setViewVisibility(C0417R.id.chronometer, 0);
                remoteViews.setLong(C0417R.id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                remoteViews.setBoolean(C0417R.id.chronometer, "setStarted", true);
            } else {
                remoteViews.setViewVisibility(C0417R.id.time, 0);
                remoteViews.setLong(C0417R.id.time, "setTime", j);
            }
        }
        remoteViews.setViewVisibility(C0417R.id.line3, obj != null ? 0 : 8);
        return remoteViews;
    }

    private static <T extends Action> RemoteViews m1096a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        int min = Math.min(list.size(), 5);
        RemoteViews a = C0397p.m1095a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, C0397p.m1093a(min), false);
        a.removeAllViews(C0417R.id.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                a.addView(C0417R.id.media_actions, C0397p.m1094a(context, (Action) list.get(i2)));
            }
        }
        if (z2) {
            a.setViewVisibility(C0417R.id.cancel_action, 0);
            a.setInt(C0417R.id.cancel_action, "setAlpha", context.getResources().getInteger(C0417R.integer.cancel_button_image_alpha));
            a.setOnClickPendingIntent(C0417R.id.cancel_action, pendingIntent);
        } else {
            a.setViewVisibility(C0417R.id.cancel_action, 8);
        }
        return a;
    }

    private static <T extends Action> RemoteViews m1097a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        RemoteViews a = C0397p.m1095a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, C0417R.layout.notification_template_media, true);
        int size = list.size();
        int min = iArr == null ? 0 : Math.min(iArr.length, 3);
        a.removeAllViews(C0417R.id.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                if (i2 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - 1)}));
                }
                a.addView(C0417R.id.media_actions, C0397p.m1094a(context, (Action) list.get(iArr[i2])));
            }
        }
        if (z2) {
            a.setViewVisibility(C0417R.id.end_padder, 8);
            a.setViewVisibility(C0417R.id.cancel_action, 0);
            a.setOnClickPendingIntent(C0417R.id.cancel_action, pendingIntent);
            a.setInt(C0417R.id.cancel_action, "setAlpha", context.getResources().getInteger(C0417R.integer.cancel_button_image_alpha));
        } else {
            a.setViewVisibility(C0417R.id.end_padder, 0);
            a.setViewVisibility(C0417R.id.cancel_action, 8);
        }
        return a;
    }

    public static <T extends Action> void m1098a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        notification.bigContentView = C0397p.m1096a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, z2, pendingIntent);
        if (z2) {
            notification.flags |= 2;
        }
    }

    public static <T extends Action> void m1099a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(C0397p.m1097a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, (List) list, iArr, z2, pendingIntent));
        if (z2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
    }
}
