package com.antutu.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v7.app.C0377e;
import android.support.v7.app.C0395n.C0390a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.service.BenchmarkMainService;
import com.antutu.utils.widget.SystemBarTintManager;
import java.util.ArrayList;

public class NotificationUtil {
    private static final double COLOR_THRESHOLD = 180.0d;
    private static final String DUMMY_TITLE = "DUMMY_TITLE";
    private static final int NOTIFICATION_COOLING_ID = 1001;
    private static volatile NotificationUtil mNotificationUtil;
    private int mTitleColor;

    private interface Filter {
        void filter(View view);
    }

    /* renamed from: com.antutu.utils.NotificationUtil.1 */
    class C18001 implements Filter {
        final /* synthetic */ ArrayList val$_TextViews;

        C18001(ArrayList arrayList) {
            this.val$_TextViews = arrayList;
        }

        public void filter(View view) {
            if (view instanceof TextView) {
                this.val$_TextViews.add((TextView) view);
            }
        }
    }

    /* renamed from: com.antutu.utils.NotificationUtil.2 */
    class C18012 implements Filter {
        C18012() {
        }

        public void filter(View view) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (NotificationUtil.DUMMY_TITLE.equals(textView.getText().toString())) {
                    NotificationUtil.this.mTitleColor = textView.getCurrentTextColor();
                }
            }
        }
    }

    static {
        mNotificationUtil = null;
    }

    public static NotificationUtil getInstance() {
        if (mNotificationUtil == null) {
            synchronized (NotificationUtil.class) {
                if (mNotificationUtil == null) {
                    mNotificationUtil = new NotificationUtil();
                }
            }
        }
        return mNotificationUtil;
    }

    private int getNotificationColor(Context context) {
        return context instanceof C0377e ? getNotificationColorCompat(context) : getNotificationColorInternal(context);
    }

    private int getNotificationColorCompat(Context context) {
        int i = 0;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(new C0390a(context).build().contentView.getLayoutId(), null);
        TextView textView = (TextView) viewGroup.findViewById(16908310);
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        ArrayList arrayList = new ArrayList();
        iteratorView(viewGroup, new C18001(arrayList));
        float f = -2.14748365E9f;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            float f2;
            int i3;
            float textSize = ((TextView) arrayList.get(i2)).getTextSize();
            if (textSize > f) {
                f2 = textSize;
                i3 = i2;
            } else {
                i3 = i;
                f2 = f;
            }
            i2++;
            f = f2;
            i = i3;
        }
        return ((TextView) arrayList.get(i)).getCurrentTextColor();
    }

    private int getNotificationColorInternal(Context context) {
        C0390a c0390a = new C0390a(context);
        c0390a.setContentTitle(DUMMY_TITLE);
        ViewGroup viewGroup = (ViewGroup) c0390a.build().contentView.apply(context, new FrameLayout(context));
        TextView textView = (TextView) viewGroup.findViewById(16908310);
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        iteratorView(viewGroup, new C18012());
        return this.mTitleColor;
    }

    public static boolean isColorsSimilar(int i, int i2) {
        int i3 = i | SystemBarTintManager.DEFAULT_TINT_COLOR;
        int i4 = SystemBarTintManager.DEFAULT_TINT_COLOR | i2;
        int red = Color.red(i3) - Color.red(i4);
        int green = Color.green(i3) - Color.green(i4);
        i3 = Color.blue(i3) - Color.blue(i4);
        return Math.sqrt((double) ((i3 * i3) + ((red * red) + (green * green)))) < COLOR_THRESHOLD;
    }

    private void iteratorView(View view, Filter filter) {
        if (view != null && filter != null) {
            filter.filter(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    iteratorView(viewGroup.getChildAt(i), filter);
                }
            }
        }
    }

    public void hideCoolingNotification(Service service) {
        service.stopForeground(true);
    }

    public boolean isDarkNotificationBar(Context context) {
        return !isColorsSimilar(SystemBarTintManager.DEFAULT_TINT_COLOR, getNotificationColor(context));
    }

    public void showCoolingNotification(Service service, double d, int i) {
        PendingIntent service2 = PendingIntent.getService(service, 1, BenchmarkMainService.m6368l(service), 134217728);
        RemoteViews remoteViews = isDarkNotificationBar(service) ? new RemoteViews(service.getPackageName(), C1082R.layout.notifition_cooling_dark) : d > 35.0d ? new RemoteViews(service.getPackageName(), C1082R.layout.notifition_cooling_white_heat) : new RemoteViews(service.getPackageName(), C1082R.layout.notifition_cooling_white);
        if (VERSION.SDK_INT > 22) {
            remoteViews.setImageViewResource(C1082R.id.cooling_icon, C1082R.drawable.app_icon);
        } else {
            remoteViews.setImageViewBitmap(C1082R.id.cooling_icon, BitmapFactory.decodeResource(service.getResources(), C1082R.drawable.app_icon));
        }
        remoteViews.setTextViewText(C1082R.id.cooling_temperature, StringUtil.formatTempToC(d));
        remoteViews.setTextViewText(C1082R.id.cooling_cpu, i + "%");
        remoteViews.setOnClickPendingIntent(C1082R.id.cooling_start, service2);
        C0390a c0390a = new C0390a(service);
        if (VERSION.SDK_INT >= 21) {
            c0390a.setSmallIcon(C1082R.drawable.ic_noti_small);
        } else {
            c0390a.setSmallIcon(C1082R.drawable.app_icon);
        }
        c0390a.setLargeIcon(BitmapFactory.decodeResource(service.getResources(), C1082R.drawable.app_icon));
        c0390a.setPriority(2);
        c0390a.setContent(remoteViews);
        c0390a.setWhen(System.currentTimeMillis());
        c0390a.setAutoCancel(false);
        c0390a.setOngoing(true);
        c0390a.setVisibility(1);
        c0390a.setContentIntent(service2);
        Notification build = c0390a.build();
        build.flags = 2;
        build.flags |= 32;
        build.flags |= 64;
        service.startForeground(NOTIFICATION_COOLING_ID, build);
    }
}
