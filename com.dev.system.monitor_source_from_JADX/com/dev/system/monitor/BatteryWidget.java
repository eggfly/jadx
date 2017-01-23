package com.dev.system.monitor;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.view.ViewCompat;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RemoteViews;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;
import com.github.amlcurran.showcaseview.C0158R;
import it.gmariotti.cardslib.library.internal.Card;
import java.util.Iterator;

public class BatteryWidget extends AppWidgetProvider {
    private static AppWidgetManager appWidgetManager;
    private static Context context;
    private static PowerManager mPower;
    private static RemoteViews remoteViews;
    private static Intent service;
    private static ComponentName widget;

    public static class UpdateBattery extends Service {
        public static BroadcastReceiver broadcastReceiver;
        private PieGraph pieGraph;

        /* renamed from: com.dev.system.monitor.BatteryWidget.UpdateBattery.1 */
        class C00941 extends BroadcastReceiver {
            C00941() {
            }

            public void onReceive(Context context, Intent intent) {
                if (BatteryWidget.remoteViews != null && context != null && BatteryWidget.appWidgetManager != null && BatteryWidget.mPower.isScreenOn()) {
                    int batteryPct = intent.getIntExtra("level", 100);
                    PieSlice slice = new PieSlice();
                    PieSlice _slice = new PieSlice();
                    slice.setColor(Color.parseColor("#99CC00"));
                    slice.setValue((float) batteryPct);
                    _slice.setColor(Color.parseColor("#0099CC00"));
                    _slice.setValue(((float) (100 - batteryPct)) + 1.0E-5f);
                    UpdateBattery.this.pieGraph = new PieGraph(context);
                    UpdateBattery.this.pieGraph.measure(200, 200);
                    UpdateBattery.this.pieGraph.layout(0, 0, 200, 200);
                    UpdateBattery.this.pieGraph.setDrawingCacheEnabled(true);
                    UpdateBattery.this.pieGraph.addSlice(slice);
                    UpdateBattery.this.pieGraph.addSlice(_slice);
                    UpdateBattery.this.pieGraph.setInnerCircleRatio(150);
                    Iterator it = UpdateBattery.this.pieGraph.getSlices().iterator();
                    while (it.hasNext()) {
                        PieSlice s = (PieSlice) it.next();
                        s.setGoalValue(s.getValue());
                    }
                    UpdateBattery.this.pieGraph.setDuration(1000);
                    UpdateBattery.this.pieGraph.setInterpolator(new AccelerateDecelerateInterpolator());
                    UpdateBattery.this.pieGraph.animateToGoalValues();
                    UpdateBattery.this.pieGraph.setPadding(3);
                    Bitmap bitmap = UpdateBattery.this.pieGraph.getDrawingCache();
                    Canvas canvas = new Canvas(bitmap);
                    Paint paint = new Paint(1);
                    paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                    paint.setTextSize(18.0f);
                    paint.setShadowLayer(1.0f, 0.0f, 1.0f, -1);
                    Rect bounds = new Rect();
                    paint.getTextBounds(batteryPct + " %", 0, new String(batteryPct + " %").length(), bounds);
                    canvas.drawText(batteryPct + " %", (float) ((bitmap.getWidth() - bounds.width()) / 2), (float) ((bitmap.getHeight() + bounds.height()) / 2), paint);
                    if (!(BatteryWidget.remoteViews == null || BatteryWidget.appWidgetManager == null || context == null)) {
                        BatteryWidget.remoteViews.setImageViewBitmap(C0133R.id.widget_battery_graph, bitmap);
                        BatteryWidget.remoteViews.setTextViewText(C0133R.id.widget_battery_voltage, UpdateBattery.this.getString(C0133R.string.voltage) + " : " + intent.getIntExtra("voltage", 0) + " mV");
                        BatteryWidget.remoteViews.setTextViewText(C0133R.id.widget_battery_source, UpdateBattery.this.getString(C0133R.string.ba_power_source) + " : " + (intent.getIntExtra("plugged", 0) == 0 ? "Battery" : "Charge"));
                        BatteryWidget.remoteViews.setTextViewText(C0133R.id.widget_battery_type, UpdateBattery.this.getString(C0133R.string.ba_type) + " : " + intent.getExtras().getString("technology"));
                        BatteryWidget.remoteViews.setTextViewText(C0133R.id.widget_battery_temperature, UpdateBattery.this.getString(C0133R.string.temperature) + " : " + (((float) intent.getIntExtra("temperature", 0)) / 10.0f) + " \u00b0C");
                        BatteryWidget.remoteViews.setTextViewText(C0133R.id.widget_battery_health, UpdateBattery.this.getString(C0133R.string.health) + " : " + UpdateBattery.this.getBatteryHealth(intent.getIntExtra("health", 0)));
                        BatteryWidget.appWidgetManager.updateAppWidget(BatteryWidget.widget, BatteryWidget.remoteViews);
                    }
                    UpdateBattery.this.pieGraph.removeSlices();
                }
            }
        }

        public void onStart(Intent intent, int startId) {
            broadcastReceiver = new C00941();
            if (BatteryWidget.context != null) {
                BatteryWidget.context.getApplicationContext().registerReceiver(broadcastReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            }
        }

        private String getBatteryHealth(int health) {
            switch (health) {
                case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                    return getString(C0133R.string.unknown);
                case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                    return getString(C0133R.string.good);
                case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                    return getString(C0133R.string.over_heat);
                case FragmentManagerImpl.ANIM_STYLE_FADE_ENTER /*5*/:
                    return getString(C0133R.string.over_volt);
                case C0158R.styleable.ShowcaseView_sv_titleTextAppearance /*7*/:
                    return getString(C0133R.string.cold);
                default:
                    return getString(C0133R.string.unknown);
            }
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        context = context;
        appWidgetManager = appWidgetManager;
        remoteViews = new RemoteViews(context.getPackageName(), C0133R.layout.widget_battery);
        widget = new ComponentName(context, BatteryWidget.class);
        mPower = (PowerManager) context.getSystemService("power");
        Intent intent = new Intent(context, UpdateBattery.class);
        service = intent;
        context.startService(intent);
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        if (context != null) {
            try {
                context.getApplicationContext().unregisterReceiver(UpdateBattery.broadcastReceiver);
                context.stopService(service);
            } catch (IllegalArgumentException e) {
            }
        }
        super.onDeleted(context, appWidgetIds);
    }
}
