package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

class aa {
    public static Notification j6(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        return notification;
    }
}
