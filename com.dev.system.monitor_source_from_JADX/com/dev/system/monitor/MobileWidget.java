package com.dev.system.monitor;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.media.TransportMediator;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.fortysevendeg.swipelistview.C0149R;
import com.github.amlcurran.showcaseview.C0158R;
import it.gmariotti.cardslib.library.internal.Card;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class MobileWidget extends AppWidgetProvider {
    private static final String ACTION_CHANGE_MOBILE_DATA_STATUS = "CHANGE_MOBILE_DATA_STATUS";
    private static AppWidgetManager appWidgetManager;
    private static ConnectivityManager connectivityManager;
    private static Context context;
    private static Handler handler;
    private static PowerManager mPower;
    private static RemoteViews remoteViews;
    private static Runnable runnable;
    private static Intent service;
    private static ComponentName widget;

    public static class MobileNetworkLog extends Service {
        public static BroadcastReceiver mobileData;

        /* renamed from: com.dev.system.monitor.MobileWidget.MobileNetworkLog.1 */
        class C01281 implements Runnable {
            C01281() {
            }

            public void run() {
                if (MobileWidget.remoteViews != null && MobileWidget.appWidgetManager != null && MobileWidget.context != null) {
                    if (MobileWidget.mPower.isScreenOn()) {
                        MobileWidget.handler.removeCallbacks(MobileWidget.runnable);
                        new NetworkStat().execute(new Void[0]);
                        return;
                    }
                    MobileWidget.handler.postDelayed(this, 3000);
                }
            }
        }

        /* renamed from: com.dev.system.monitor.MobileWidget.MobileNetworkLog.2 */
        class C01292 extends BroadcastReceiver {
            C01292() {
            }

            public void onReceive(Context context, Intent intent) {
                if (MobileWidget.remoteViews != null && MobileWidget.appWidgetManager != null && context != null) {
                    try {
                        if (((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0).isAvailable()) {
                            MobileNetworkLog.this.setMobileData();
                        } else {
                            MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobileoff);
                        }
                    } catch (Exception e) {
                        MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobileoff);
                    }
                }
            }
        }

        public void onStart(Intent intent, int startId) {
            MobileWidget.handler = new Handler();
            MobileWidget.handler.postDelayed(MobileWidget.runnable = new C01281(), 1000);
            mobileData = new C01292();
            if (MobileWidget.context != null) {
                MobileWidget.context.getApplicationContext().registerReceiver(mobileData, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
            setMobileData();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        private void setMobileData() {
            if (MobileWidget.remoteViews != null && MobileWidget.context != null && MobileWidget.appWidgetManager != null) {
                try {
                    MobileWidget.connectivityManager = (ConnectivityManager) getSystemService("connectivity");
                    if (MobileWidget.connectivityManager.getActiveNetworkInfo().getType() == 0) {
                        switch (MobileWidget.connectivityManager.getActiveNetworkInfo().getSubtype()) {
                            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                                MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobileg);
                                return;
                            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                            case TransportMediator.FLAG_KEY_MEDIA_PLAY /*4*/:
                            case C0158R.styleable.ShowcaseView_sv_titleTextAppearance /*7*/:
                                MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobilee);
                                return;
                            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                            case Card.CLICK_LISTENER_CONTENT_VIEW /*10*/:
                                MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobilehspa);
                                return;
                            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                            case C0158R.styleable.ShowcaseView_sv_tintButtonColor /*9*/:
                            case C0149R.styleable.MenuItem_android_onClick /*12*/:
                            case C0149R.styleable.MenuItem_actionLayout /*14*/:
                                MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobile3g);
                                return;
                            case C0149R.styleable.MenuItem_showAsAction /*13*/:
                                MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobile4g);
                                return;
                            case C0149R.styleable.MenuItem_actionViewClass /*15*/:
                                MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobilehspaplus);
                                return;
                            default:
                                MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobileoff);
                                MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_download, BuildConfig.VERSION_NAME);
                                MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_upload, BuildConfig.VERSION_NAME);
                                return;
                        }
                        MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobileoff);
                        MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_download, BuildConfig.VERSION_NAME);
                        MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_upload, BuildConfig.VERSION_NAME);
                    }
                    MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobileoff);
                    MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_download, BuildConfig.VERSION_NAME);
                    MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_upload, BuildConfig.VERSION_NAME);
                } catch (Exception e) {
                    MobileWidget.remoteViews.setImageViewResource(C0133R.id.widget_mobile_status, C0133R.drawable.mobileoff);
                    MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_download, BuildConfig.VERSION_NAME);
                    MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_upload, BuildConfig.VERSION_NAME);
                }
            }
        }
    }

    private static class NetworkStat extends AsyncTask<Void, String, Long[]> {
        private static long startRX;
        private static long startTX;
        private String[] tmp;

        private NetworkStat() {
            this.tmp = new String[2];
        }

        static {
            startRX = TrafficStats.getTotalRxBytes();
            startTX = TrafficStats.getTotalTxBytes();
        }

        protected Long[] doInBackground(Void... params) {
            try {
                if (MobileWidget.connectivityManager.getActiveNetworkInfo().getType() == 0) {
                    long rxBytes = TrafficStats.getTotalRxBytes() - startRX;
                    if (rxBytes / 1073741824 > 0) {
                        this.tmp[0] = (rxBytes / 1073741824) + " GB/s";
                    } else if (rxBytes / 1048576 > 0) {
                        this.tmp[0] = (rxBytes / 1048576) + " MB/s";
                    } else if (rxBytes / 1024 > 0) {
                        this.tmp[0] = (rxBytes / 1024) + " KB/s";
                    } else {
                        this.tmp[0] = rxBytes + " B/s";
                    }
                    long txBytes = TrafficStats.getTotalTxBytes() - startTX;
                    startRX += rxBytes;
                    startTX += txBytes;
                    if (txBytes / 1073741824 > 0) {
                        this.tmp[1] = (txBytes / 1073741824) + " GB/s";
                    } else if (txBytes / 1048576 > 0) {
                        this.tmp[1] = (txBytes / 1048576) + " MB/s";
                    } else if (txBytes / 1024 > 0) {
                        this.tmp[1] = (txBytes / 1024) + " KB/s";
                    } else {
                        this.tmp[1] = txBytes + " B/s";
                    }
                    Log.i("Stat", this.tmp[0] + " " + this.tmp[1]);
                    publishProgress(this.tmp);
                }
            } catch (NullPointerException e) {
                if (MobileWidget.remoteViews != null) {
                    this.tmp[0] = BuildConfig.VERSION_NAME;
                    this.tmp[1] = BuildConfig.VERSION_NAME;
                    publishProgress(this.tmp);
                }
            }
            return new Long[]{Long.valueOf(startRX), Long.valueOf(startTX)};
        }

        protected void onProgressUpdate(String... values) {
            MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_download, values[0]);
            MobileWidget.remoteViews.setTextViewText(C0133R.id.widget_mobile_upload, values[1]);
        }

        protected void onPostExecute(Long[] params) {
            if (!(MobileWidget.appWidgetManager == null || MobileWidget.remoteViews == null)) {
                MobileWidget.appWidgetManager.updateAppWidget(MobileWidget.widget, MobileWidget.remoteViews);
            }
            if (params[0].longValue() != -1 && params[1].longValue() != -1 && MobileWidget.remoteViews != null && MobileWidget.appWidgetManager != null && MobileWidget.context != null) {
                MobileWidget.handler.postDelayed(MobileWidget.runnable, 1000);
            }
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        context = context;
        appWidgetManager = appWidgetManager;
        remoteViews = new RemoteViews(context.getPackageName(), C0133R.layout.widget_mobile);
        widget = new ComponentName(context, MobileWidget.class);
        mPower = (PowerManager) context.getSystemService("power");
        Intent intent = new Intent(context, MobileWidget.class);
        intent.setAction(ACTION_CHANGE_MOBILE_DATA_STATUS);
        remoteViews.setOnClickPendingIntent(C0133R.id.widget_mobile_status, PendingIntent.getBroadcast(context, 0, intent, 0));
        Intent intent2 = new Intent(context, MobileNetworkLog.class);
        service = intent2;
        context.startService(intent2);
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        if (context != null) {
            try {
                context.getApplicationContext().unregisterReceiver(MobileNetworkLog.mobileData);
                context.stopService(service);
                if (!(handler == null || runnable == null)) {
                    handler.removeCallbacks(runnable);
                }
            } catch (IllegalArgumentException e) {
            }
        }
        super.onDeleted(context, appWidgetIds);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
        r13 = this;
        r1 = 0;
        r8 = 1;
        super.onReceive(r14, r15);
        r7 = r15.getAction();
        r9 = "CHANGE_MOBILE_DATA_STATUS";
        r7 = r7.equals(r9);
        if (r7 == 0) goto L_0x001b;
    L_0x0011:
        r7 = remoteViews;
        if (r7 == 0) goto L_0x001b;
    L_0x0015:
        if (r14 == 0) goto L_0x001b;
    L_0x0017:
        r7 = appWidgetManager;
        if (r7 != 0) goto L_0x001c;
    L_0x001b:
        return;
    L_0x001c:
        r7 = "connectivity";
        r7 = r14.getSystemService(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = (android.net.ConnectivityManager) r7;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        connectivityManager = r7;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r9 = 21;
        if (r7 >= r9) goto L_0x017c;
    L_0x002c:
        r7 = android.net.ConnectivityManager.class;
        r9 = "setMobileDataEnabled";
        r10 = 1;
        r10 = new java.lang.Class[r10];	 Catch:{ NoSuchMethodException -> 0x00d8, IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r11 = 0;
        r12 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x00d8, IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r10[r11] = r12;	 Catch:{ NoSuchMethodException -> 0x00d8, IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r5 = r7.getDeclaredMethod(r9, r10);	 Catch:{ NoSuchMethodException -> 0x00d8, IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
    L_0x003c:
        r7 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        if (r7 == 0) goto L_0x0048;
    L_0x0040:
        r7 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = r7.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        if (r7 != 0) goto L_0x0052;
    L_0x0048:
        r7 = "connectivity";
        r7 = r14.getSystemService(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = (android.net.ConnectivityManager) r7;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        connectivityManager = r7;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
    L_0x0052:
        r7 = 1;
        r5.setAccessible(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = r7.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        if (r7 == 0) goto L_0x00fb;
    L_0x005e:
        r7 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r10 = 0;
        r11 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r11 = r11.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r11 = r11.isConnected();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        if (r11 == 0) goto L_0x00f8;
    L_0x0070:
        r8 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r9[r10] = r8;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r5.invoke(r7, r9);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
    L_0x0079:
        if (r1 == 0) goto L_0x0113;
    L_0x007b:
        r7 = 2131624013; // 0x7f0e004d float:1.8875194E38 double:1.0531621947E-314;
        r7 = r14.getString(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
    L_0x0082:
        r8 = 1;
        r7 = android.widget.Toast.makeText(r14, r7, r8);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7.show();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = connectivityManager;	 Catch:{ NullPointerException -> 0x00c4 }
        r7 = r7.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x00c4 }
        r7 = r7.getType();	 Catch:{ NullPointerException -> 0x00c4 }
        if (r7 != 0) goto L_0x001b;
    L_0x0096:
        r7 = connectivityManager;	 Catch:{ NullPointerException -> 0x00c4 }
        r7 = r7.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x00c4 }
        r7 = r7.getSubtype();	 Catch:{ NullPointerException -> 0x00c4 }
        switch(r7) {
            case 1: goto L_0x012f;
            case 2: goto L_0x011c;
            case 3: goto L_0x0142;
            case 4: goto L_0x011c;
            case 5: goto L_0x00a3;
            case 6: goto L_0x00a3;
            case 7: goto L_0x011c;
            case 8: goto L_0x0155;
            case 9: goto L_0x0155;
            case 10: goto L_0x0142;
            case 11: goto L_0x00a3;
            case 12: goto L_0x0155;
            case 13: goto L_0x016f;
            case 14: goto L_0x0155;
            case 15: goto L_0x0162;
            default: goto L_0x00a3;
        };	 Catch:{ NullPointerException -> 0x00c4 }
    L_0x00a3:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427528; // 0x7f0b00c8 float:1.8476675E38 double:1.053065118E-314;
        r9 = "";
        r7.setTextViewText(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427529; // 0x7f0b00c9 float:1.8476677E38 double:1.0530651187E-314;
        r9 = "";
        r7.setTextViewText(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        goto L_0x001b;
    L_0x00c4:
        r4 = move-exception;
        r7 = remoteViews;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        goto L_0x001b;
    L_0x00d2:
        r4 = move-exception;
        r4.printStackTrace();
        goto L_0x001b;
    L_0x00d8:
        r4 = move-exception;
        r7 = 2;
        r2 = new java.lang.Class[r7];	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = 0;
        r9 = java.lang.String.class;
        r2[r7] = r9;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = 1;
        r9 = java.lang.Boolean.TYPE;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r2[r7] = r9;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = android.net.ConnectivityManager.class;
        r9 = "setMobileDataEnabled";
        r10 = 1;
        r10 = new java.lang.Class[r10];	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r11 = 0;
        r12 = java.lang.Boolean.TYPE;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r10[r11] = r12;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r5 = r7.getDeclaredMethod(r9, r10);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        goto L_0x003c;
    L_0x00f8:
        r1 = r8;
        goto L_0x0070;
    L_0x00fb:
        r7 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r9 = 0;
        r1 = 1;
        r10 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r8[r9] = r10;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r5.invoke(r7, r8);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        goto L_0x0079;
    L_0x010d:
        r0 = move-exception;
        r13.setDataManually();
        goto L_0x001b;
    L_0x0113:
        r7 = 2131624012; // 0x7f0e004c float:1.8875192E38 double:1.053162194E-314;
        r7 = r14.getString(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        goto L_0x0082;
    L_0x011c:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837660; // 0x7f02009c float:1.728028E38 double:1.0527736847E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        goto L_0x001b;
    L_0x0129:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x001b;
    L_0x012f:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837661; // 0x7f02009d float:1.7280282E38 double:1.052773685E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        goto L_0x001b;
    L_0x013c:
        r4 = move-exception;
        r4.printStackTrace();
        goto L_0x001b;
    L_0x0142:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837662; // 0x7f02009e float:1.7280284E38 double:1.0527736857E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        goto L_0x001b;
    L_0x014f:
        r4 = move-exception;
        r13.setDataManually();
        goto L_0x001b;
    L_0x0155:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837658; // 0x7f02009a float:1.7280276E38 double:1.0527736837E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        goto L_0x001b;
    L_0x0162:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837663; // 0x7f02009f float:1.7280286E38 double:1.052773686E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        goto L_0x001b;
    L_0x016f:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x00c4 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837659; // 0x7f02009b float:1.7280278E38 double:1.052773684E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x00c4 }
        goto L_0x001b;
    L_0x017c:
        r7 = "phone";
        r6 = r14.getSystemService(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r6 = (android.telephony.TelephonyManager) r6;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = r6.getClass();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = r7.getName();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = java.lang.Class.forName(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r9 = "setDataEnabled";
        r10 = 1;
        r10 = new java.lang.Class[r10];	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r11 = 0;
        r12 = java.lang.Boolean.TYPE;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r10[r11] = r12;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r5 = r7.getDeclaredMethod(r9, r10);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r9 = 0;
        r10 = 1;
        r10 = java.lang.Boolean.valueOf(r10);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7[r9] = r10;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r5.invoke(r6, r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        if (r7 == 0) goto L_0x01b8;
    L_0x01b0:
        r7 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = r7.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        if (r7 != 0) goto L_0x01c2;
    L_0x01b8:
        r7 = "connectivity";
        r7 = r14.getSystemService(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = (android.net.ConnectivityManager) r7;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        connectivityManager = r7;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
    L_0x01c2:
        r7 = 1;
        r5.setAccessible(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = r7.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        if (r7 == 0) goto L_0x0256;
    L_0x01ce:
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r9 = 0;
        r10 = connectivityManager;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r10 = r10.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r10 = r10.isConnected();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        if (r10 == 0) goto L_0x0254;
    L_0x01de:
        r8 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7[r9] = r8;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r5.invoke(r6, r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
    L_0x01e7:
        if (r1 == 0) goto L_0x0265;
    L_0x01e9:
        r7 = 2131624013; // 0x7f0e004d float:1.8875194E38 double:1.0531621947E-314;
        r7 = r14.getString(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
    L_0x01f0:
        r8 = 1;
        r7 = android.widget.Toast.makeText(r14, r7, r8);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7.show();	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = connectivityManager;	 Catch:{ NullPointerException -> 0x0232 }
        r7 = r7.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x0232 }
        r7 = r7.getType();	 Catch:{ NullPointerException -> 0x0232 }
        if (r7 != 0) goto L_0x001b;
    L_0x0204:
        r7 = connectivityManager;	 Catch:{ NullPointerException -> 0x0232 }
        r7 = r7.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x0232 }
        r7 = r7.getSubtype();	 Catch:{ NullPointerException -> 0x0232 }
        switch(r7) {
            case 1: goto L_0x027a;
            case 2: goto L_0x026d;
            case 3: goto L_0x0287;
            case 4: goto L_0x026d;
            case 5: goto L_0x0211;
            case 6: goto L_0x0211;
            case 7: goto L_0x026d;
            case 8: goto L_0x0294;
            case 9: goto L_0x0294;
            case 10: goto L_0x0287;
            case 11: goto L_0x0211;
            case 12: goto L_0x0294;
            case 13: goto L_0x02ae;
            case 14: goto L_0x0294;
            case 15: goto L_0x02a1;
            default: goto L_0x0211;
        };	 Catch:{ NullPointerException -> 0x0232 }
    L_0x0211:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427528; // 0x7f0b00c8 float:1.8476675E38 double:1.053065118E-314;
        r9 = "";
        r7.setTextViewText(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427529; // 0x7f0b00c9 float:1.8476677E38 double:1.0530651187E-314;
        r9 = "";
        r7.setTextViewText(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        goto L_0x001b;
    L_0x0232:
        r4 = move-exception;
        r7 = remoteViews;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = remoteViews;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r8 = 2131427528; // 0x7f0b00c8 float:1.8476675E38 double:1.053065118E-314;
        r9 = "";
        r7.setTextViewText(r8, r9);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7 = remoteViews;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r8 = 2131427529; // 0x7f0b00c9 float:1.8476677E38 double:1.0530651187E-314;
        r9 = "";
        r7.setTextViewText(r8, r9);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        goto L_0x001b;
    L_0x0254:
        r1 = r8;
        goto L_0x01de;
    L_0x0256:
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r8 = 0;
        r1 = 1;
        r9 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r7[r8] = r9;	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        r5.invoke(r6, r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        goto L_0x01e7;
    L_0x0265:
        r7 = 2131624012; // 0x7f0e004c float:1.8875192E38 double:1.053162194E-314;
        r7 = r14.getString(r7);	 Catch:{ IllegalAccessException -> 0x00d2, InvocationTargetException -> 0x010d, NoSuchMethodException -> 0x0129, ClassNotFoundException -> 0x013c, SecurityException -> 0x014f }
        goto L_0x01f0;
    L_0x026d:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837660; // 0x7f02009c float:1.728028E38 double:1.0527736847E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        goto L_0x001b;
    L_0x027a:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837661; // 0x7f02009d float:1.7280282E38 double:1.052773685E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        goto L_0x001b;
    L_0x0287:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837662; // 0x7f02009e float:1.7280284E38 double:1.0527736857E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        goto L_0x001b;
    L_0x0294:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837658; // 0x7f02009a float:1.7280276E38 double:1.0527736837E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        goto L_0x001b;
    L_0x02a1:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837663; // 0x7f02009f float:1.7280286E38 double:1.052773686E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        goto L_0x001b;
    L_0x02ae:
        r7 = remoteViews;	 Catch:{ NullPointerException -> 0x0232 }
        r8 = 2131427530; // 0x7f0b00ca float:1.8476679E38 double:1.053065119E-314;
        r9 = 2130837659; // 0x7f02009b float:1.7280278E38 double:1.052773684E-314;
        r7.setImageViewResource(r8, r9);	 Catch:{ NullPointerException -> 0x0232 }
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dev.system.monitor.MobileWidget.onReceive(android.content.Context, android.content.Intent):void");
    }

    private void setDataManually() {
        Intent intent = new Intent();
        intent.setAction("android.settings.SETTINGS");
        intent.setFlags(268435456);
        context.getApplicationContext().startActivity(intent);
        Toast.makeText(context, context.getString(C0133R.string.mobile_msg), 1).show();
    }
}
