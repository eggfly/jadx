package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

class x {

    public static class a implements v, w {
        private Bundle DW;
        private Builder j6;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            boolean z6;
            Builder lights = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOngoing(z6);
            if ((notification.flags & 8) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOnlyAlertOnce(z6);
            if ((notification.flags & 16) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setAutoCancel(z6).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.j6 = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.DW = new Bundle();
            if (bundle != null) {
                this.DW.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.DW.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }

        public void j6(android.support.v4.app.z.a aVar) {
            x.j6(this.j6, aVar);
        }

        public Builder j6() {
            return this.j6;
        }

        public Notification DW() {
            this.j6.setExtras(this.DW);
            return this.j6.build();
        }
    }

    public static void j6(Builder builder, android.support.v4.app.z.a aVar) {
        Action.Builder builder2 = new Action.Builder(aVar.j6(), aVar.DW(), aVar.FH());
        if (aVar.Zo() != null) {
            for (RemoteInput addRemoteInput : ag.j6(aVar.Zo())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (aVar.Hw() != null) {
            builder2.addExtras(aVar.Hw());
        }
        builder.addAction(builder2.build());
    }
}
