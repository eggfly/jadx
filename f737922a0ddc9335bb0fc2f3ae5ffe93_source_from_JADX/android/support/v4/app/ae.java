package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

class ae {

    public static class a implements v, w {
        private Bundle DW;
        private List<Bundle> FH;
        private Builder j6;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            boolean z6;
            this.FH = new ArrayList();
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
            this.j6 = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.DW = new Bundle();
            if (bundle != null) {
                this.DW.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.DW.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.DW.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.DW.putString("android.support.groupKey", str);
                if (z5) {
                    this.DW.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.DW.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.DW.putString("android.support.sortKey", str2);
            }
        }

        public void j6(android.support.v4.app.z.a aVar) {
            this.FH.add(ad.j6(this.j6, aVar));
        }

        public Builder j6() {
            return this.j6;
        }

        public Notification DW() {
            SparseArray j6 = ad.j6(this.FH);
            if (j6 != null) {
                this.DW.putSparseParcelableArray("android.support.actionExtras", j6);
            }
            this.j6.setExtras(this.DW);
            return this.j6.build();
        }
    }
}
