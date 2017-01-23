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
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.widget.RemoteViews;
import android.widget.Toast;
import it.gmariotti.cardslib.library.internal.Card;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class WifiWidget extends AppWidgetProvider {
    public static final String ACTION_CHANGE_WIFI_STATUS = "CHANGE_WIFI_STATUS";
    private static AppWidgetManager appWidgetManager;
    private static ConnectivityManager connManager;
    private static Context context;
    private static Handler handler;
    private static PowerManager mPower;
    private static RemoteViews remoteViews;
    private static RSSIBroadcastReceiverTask rssiBroadcastReceiverTask;
    private static Runnable runnable;
    private static Intent service;
    private static ComponentName widget;
    private static NetworkInfo wifi;
    private static WifiInfo wifiInfo;
    private static WifiManager wifiManager;

    public static class NetworkLog extends Service {
        public static BroadcastReceiver broadcastReceiver;
        private Long startRX;
        private Long startTX;

        /* renamed from: com.dev.system.monitor.WifiWidget.NetworkLog.1 */
        class C01431 extends BroadcastReceiver {
            C01431() {
            }

            public void onReceive(Context context, Intent intent) {
                if (WifiWidget.remoteViews != null && context != null && WifiWidget.appWidgetManager != null) {
                    try {
                        WifiWidget.rssiBroadcastReceiverTask.execute(new Void[0]);
                        WifiWidget.rssiBroadcastReceiverTask = new RSSIBroadcastReceiverTask();
                    } catch (NullPointerException e) {
                    }
                }
            }
        }

        /* renamed from: com.dev.system.monitor.WifiWidget.NetworkLog.2 */
        class C01442 implements Runnable {
            C01442() {
            }

            public void run() {
                if (WifiWidget.remoteViews != null && WifiWidget.context != null && WifiWidget.appWidgetManager != null) {
                    if (WifiWidget.mPower.isScreenOn()) {
                        WifiWidget.handler.removeCallbacks(WifiWidget.runnable);
                        new NetworkStat().execute(new Long[]{NetworkLog.this.startRX, NetworkLog.this.startTX});
                        return;
                    }
                    WifiWidget.handler.postDelayed(this, 3000);
                }
            }
        }

        public void onStart(Intent intent, int startId) {
            if (WifiWidget.context != null) {
                Context applicationContext = WifiWidget.context.getApplicationContext();
                BroadcastReceiver c01431 = new C01431();
                broadcastReceiver = c01431;
                applicationContext.registerReceiver(c01431, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
            }
            this.startRX = new Long(TrafficStats.getTotalRxBytes());
            this.startTX = new Long(TrafficStats.getTotalTxBytes());
            WifiWidget.handler = new Handler();
            WifiWidget.handler.postDelayed(WifiWidget.runnable = new C01442(), 1000);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    private static class NetworkStat extends AsyncTask<Long, String, Long[]> {
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

        protected Long[] doInBackground(Long[] params) {
            try {
                if (WifiWidget.wifi.isConnected() && WifiWidget.remoteViews != null) {
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
                    publishProgress(this.tmp);
                }
            } catch (NullPointerException e) {
                if (WifiWidget.remoteViews != null) {
                    this.tmp[0] = BuildConfig.VERSION_NAME;
                    this.tmp[1] = BuildConfig.VERSION_NAME;
                    publishProgress(this.tmp);
                }
            }
            return params;
        }

        protected void onProgressUpdate(String... values) {
            WifiWidget.remoteViews.setTextViewText(C0133R.id.widget_wifi_download, values[0]);
            WifiWidget.remoteViews.setTextViewText(C0133R.id.widget_wifi_upload, values[1]);
        }

        protected void onPostExecute(Long[] params) {
            if (!(WifiWidget.appWidgetManager == null || WifiWidget.remoteViews == null)) {
                WifiWidget.appWidgetManager.updateAppWidget(WifiWidget.widget, WifiWidget.remoteViews);
            }
            if (params[0].longValue() != -1 && params[1].longValue() != -1 && WifiWidget.remoteViews != null && WifiWidget.appWidgetManager != null && WifiWidget.context != null) {
                WifiWidget.handler.postDelayed(WifiWidget.runnable, 1000);
            }
        }
    }

    private static class RSSIBroadcastReceiverTask extends AsyncTask<Void, Void, Void> {
        private RSSIBroadcastReceiverTask() {
        }

        protected Void doInBackground(Void... params) {
            WifiWidget.wifiManager = (WifiManager) WifiWidget.context.getSystemService("wifi");
            WifiWidget.wifiInfo = WifiWidget.wifiManager.getConnectionInfo();
            WifiWidget.connManager = (ConnectivityManager) WifiWidget.context.getSystemService("connectivity");
            WifiWidget.wifi = WifiWidget.connManager.getNetworkInfo(1);
            publishProgress(new Void[0]);
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            NetworkInfo wifi = ((ConnectivityManager) WifiWidget.context.getSystemService("connectivity")).getNetworkInfo(1);
            if (wifi != null && wifi.isConnected() && WifiWidget.wifiManager.isWifiEnabled() && WifiWidget.remoteViews != null) {
                switch (WifiManager.calculateSignalLevel(WifiWidget.wifiInfo.getRssi(), 3)) {
                    case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                        WifiWidget.remoteViews.setImageViewResource(C0133R.id.widget_wifi_status, C0133R.drawable.wifi_low);
                        break;
                    case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                        WifiWidget.remoteViews.setImageViewResource(C0133R.id.widget_wifi_status, C0133R.drawable.wifi_med);
                        break;
                    case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                        WifiWidget.remoteViews.setImageViewResource(C0133R.id.widget_wifi_status, C0133R.drawable.wifi_full);
                        break;
                }
            } else if (WifiWidget.remoteViews != null) {
                WifiWidget.remoteViews.setImageViewResource(C0133R.id.widget_wifi_status, C0133R.drawable.wifi_off);
                WifiWidget.remoteViews.setTextViewText(C0133R.id.widget_wifi_download, BuildConfig.VERSION_NAME);
                WifiWidget.remoteViews.setTextViewText(C0133R.id.widget_wifi_upload, BuildConfig.VERSION_NAME);
            }
            if (WifiWidget.remoteViews != null && WifiWidget.appWidgetManager != null) {
                WifiWidget.appWidgetManager.updateAppWidget(WifiWidget.widget, WifiWidget.remoteViews);
            }
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        context = context;
        appWidgetManager = appWidgetManager;
        connManager = (ConnectivityManager) context.getSystemService("connectivity");
        wifi = connManager.getNetworkInfo(1);
        remoteViews = new RemoteViews(context.getPackageName(), C0133R.layout.widget_wifi);
        widget = new ComponentName(context, WifiWidget.class);
        mPower = (PowerManager) context.getSystemService("power");
        rssiBroadcastReceiverTask = new RSSIBroadcastReceiverTask();
        Intent intent = new Intent(context, WifiWidget.class);
        intent.setAction(ACTION_CHANGE_WIFI_STATUS);
        remoteViews.setOnClickPendingIntent(C0133R.id.widget_wifi_status, PendingIntent.getBroadcast(context, 0, intent, 0));
        Intent intent2 = new Intent(context, NetworkLog.class);
        service = intent2;
        context.startService(intent2);
    }

    public void onReceive(Context context, Intent intent) {
        boolean stat = true;
        super.onReceive(context, intent);
        if (remoteViews != null && context != null && appWidgetManager != null && intent.getAction().equals(ACTION_CHANGE_WIFI_STATUS)) {
            try {
                WifiManager wifiManager = wifiManager;
                if (wifiManager.isWifiEnabled()) {
                    stat = false;
                }
                wifiManager.setWifiEnabled(stat);
                if (stat || remoteViews == null || context == null) {
                    if (!(remoteViews == null || context == null)) {
                        Toast.makeText(context, context.getString(C0133R.string.wifi_on), 1).show();
                        wifiManager = (WifiManager) context.getSystemService("wifi");
                        wifiInfo = wifiManager.getConnectionInfo();
                        switch (WifiManager.calculateSignalLevel(wifiInfo.getRssi(), 3)) {
                            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                                remoteViews.setImageViewResource(C0133R.id.widget_wifi_status, C0133R.drawable.wifi_low);
                                break;
                            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                                remoteViews.setImageViewResource(C0133R.id.widget_wifi_status, C0133R.drawable.wifi_med);
                                break;
                            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                                remoteViews.setImageViewResource(C0133R.id.widget_wifi_status, C0133R.drawable.wifi_full);
                                break;
                            default:
                                break;
                        }
                    }
                    if (appWidgetManager != null && remoteViews != null) {
                        appWidgetManager.updateAppWidget(widget, remoteViews);
                        return;
                    }
                }
                remoteViews.setImageViewResource(C0133R.id.widget_wifi_status, C0133R.drawable.wifi_off);
                Toast.makeText(context, context.getString(C0133R.string.wifi_off), 1).show();
                remoteViews.setTextViewText(C0133R.id.widget_wifi_download, BuildConfig.VERSION_NAME);
                remoteViews.setTextViewText(C0133R.id.widget_wifi_upload, BuildConfig.VERSION_NAME);
                if (appWidgetManager != null) {
                }
            } catch (Exception e) {
            }
        }
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (context != null) {
            try {
                context.getApplicationContext().unregisterReceiver(NetworkLog.broadcastReceiver);
                context.stopService(service);
            } catch (IllegalArgumentException e) {
            }
        }
        super.onDeleted(context, appWidgetIds);
    }
}
