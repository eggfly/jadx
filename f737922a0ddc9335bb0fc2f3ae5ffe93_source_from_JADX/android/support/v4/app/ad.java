package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ad {
    private static Field DW;
    private static boolean FH;
    private static final Object Hw;
    private static final Object j6;

    public static class a implements v, w {
        private final Bundle DW;
        private List<Bundle> FH;
        private Builder j6;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            boolean z5;
            this.FH = new ArrayList();
            Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOngoing(z5);
            if ((notification.flags & 8) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOnlyAlertOnce(z5);
            if ((notification.flags & 16) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.j6 = lights.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.DW = new Bundle();
            if (bundle != null) {
                this.DW.putAll(bundle);
            }
            if (z3) {
                this.DW.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.DW.putString("android.support.groupKey", str);
                if (z4) {
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
            Notification build = this.j6.build();
            Bundle j6 = ad.j6(build);
            Bundle bundle = new Bundle(this.DW);
            for (String str : this.DW.keySet()) {
                if (j6.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            j6.putAll(bundle);
            SparseArray j62 = ad.j6(this.FH);
            if (j62 != null) {
                ad.j6(build).putSparseParcelableArray("android.support.actionExtras", j62);
            }
            return build;
        }
    }

    static {
        j6 = new Object();
        Hw = new Object();
    }

    public static void j6(w wVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(wVar.j6()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void j6(w wVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(wVar.j6()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void j6(w wVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(wVar.j6()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> j6(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle j6(Notification notification) {
        synchronized (j6) {
            if (FH) {
                return null;
            }
            try {
                if (DW == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        DW = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        FH = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) DW.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    DW.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                FH = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                FH = true;
                return null;
            }
        }
    }

    public static Bundle j6(Builder builder, android.support.v4.app.z.a aVar) {
        builder.addAction(aVar.j6(), aVar.DW(), aVar.FH());
        Bundle bundle = new Bundle(aVar.Hw());
        if (aVar.Zo() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", ai.j6(aVar.Zo()));
        }
        return bundle;
    }
}
