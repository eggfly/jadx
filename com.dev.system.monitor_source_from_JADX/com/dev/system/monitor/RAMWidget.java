package com.dev.system.monitor;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.view.ViewCompat;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class RAMWidget extends AppWidgetProvider {
    public static final String ACTION_CLEAN_RAM = "CLEAN_RAM";
    public static final String ACTION_UPDATE_RAM = "UPDATE_RAM";
    private static Intent alarmIntent;
    private static AlarmManager alarmManager;
    private static AppWidgetManager appWidgetManager;
    private static Canvas canvas;
    private static Intent clearIntent;
    private static Context context;
    private static boolean isCleaning;
    private static PendingIntent pendingAlarm;
    private static PendingIntent pendingClean;
    private static PieGraph pg;
    private static RemoteViews remoteViews;
    private static ComponentName widget;

    private class DrawTask extends AsyncTask<Void, Void, Void> {
        private PieSlice _slice;
        private long free;
        private long rate;
        private PieSlice slice;
        private long total;

        private DrawTask() {
            this.total = 0;
            this.free = 0;
            this.rate = 0;
        }

        protected Void doInBackground(Void... unused) {
            Exception e;
            RandomAccessFile reader = null;
            try {
                RandomAccessFile reader2 = new RandomAccessFile("/proc/meminfo", "r");
                try {
                    long[] mems = new long[4];
                    for (int i = 0; i < 4; i++) {
                        mems[i] = Long.parseLong(reader2.readLine().split(":")[1].replace("kB", BuildConfig.VERSION_NAME).trim());
                    }
                    this.total = mems[0] / 1024;
                    this.free = ((mems[1] + mems[2]) + mems[3]) / 1024;
                    this.rate = (long) ((int) ((((float) (this.total - this.free)) / ((float) this.total)) * 100.0f));
                    reader = reader2;
                } catch (Exception e2) {
                    e = e2;
                    reader = reader2;
                    e.printStackTrace();
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    this.slice = new PieSlice();
                    this.slice.setColor(Color.parseColor("#99CC00"));
                    this.slice.setValue((float) (this.total - this.free));
                    this._slice = new PieSlice();
                    this._slice.setColor(Color.parseColor("#FFBB33"));
                    this._slice.setValue((float) this.free);
                    RAMWidget.pg = new PieGraph(RAMWidget.context);
                    publishProgress(new Void[0]);
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (reader != null) {
                    reader.close();
                }
                this.slice = new PieSlice();
                this.slice.setColor(Color.parseColor("#99CC00"));
                this.slice.setValue((float) (this.total - this.free));
                this._slice = new PieSlice();
                this._slice.setColor(Color.parseColor("#FFBB33"));
                this._slice.setValue((float) this.free);
                RAMWidget.pg = new PieGraph(RAMWidget.context);
                publishProgress(new Void[0]);
                return null;
            }
            if (reader != null) {
                reader.close();
            }
            this.slice = new PieSlice();
            this.slice.setColor(Color.parseColor("#99CC00"));
            this.slice.setValue((float) (this.total - this.free));
            this._slice = new PieSlice();
            this._slice.setColor(Color.parseColor("#FFBB33"));
            this._slice.setValue((float) this.free);
            RAMWidget.pg = new PieGraph(RAMWidget.context);
            publishProgress(new Void[0]);
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            try {
                if (RAMWidget.pg == null) {
                    RAMWidget.pg = new PieGraph(RAMWidget.context);
                }
                RAMWidget.pg.measure(200, 200);
                RAMWidget.pg.layout(0, 0, 200, 200);
                RAMWidget.pg.setDrawingCacheEnabled(true);
                RAMWidget.pg.addSlice(this.slice);
                RAMWidget.pg.addSlice(this._slice);
                RAMWidget.pg.setInnerCircleRatio(150);
                Iterator it = RAMWidget.pg.getSlices().iterator();
                while (it.hasNext()) {
                    PieSlice s = (PieSlice) it.next();
                    s.setGoalValue(s.getValue());
                }
                RAMWidget.pg.setDuration(1000);
                RAMWidget.pg.setInterpolator(new AccelerateDecelerateInterpolator());
                RAMWidget.pg.animateToGoalValues();
                RAMWidget.pg.setPadding(3);
                Bitmap bitmap = RAMWidget.pg.getDrawingCache();
                if (RAMWidget.canvas == null) {
                    RAMWidget.canvas = new Canvas(bitmap);
                } else {
                    RAMWidget.canvas.setBitmap(bitmap);
                }
                Paint paint = new Paint(1);
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                paint.setTextSize(18.0f);
                paint.setShadowLayer(1.0f, 0.0f, 1.0f, -1);
                Rect bounds = new Rect();
                paint.getTextBounds(this.rate + " %", 0, new String(this.rate + " %").length(), bounds);
                RAMWidget.canvas.drawText(this.rate + " %", (float) ((bitmap.getWidth() - bounds.width()) / 2), (float) ((bitmap.getHeight() + bounds.height()) / 2), paint);
                if (RAMWidget.remoteViews != null || RAMWidget.appWidgetManager != null || RAMWidget.context != null) {
                    RAMWidget.remoteViews.setTextViewText(C0133R.id.widget_ram_text, RAMWidget.context.getString(C0133R.string.total_ram) + " " + this.total + " MB");
                    RAMWidget.remoteViews.setTextViewText(C0133R.id.widget_ram_text1, RAMWidget.context.getString(C0133R.string.free_ram) + " " + this.free + " MB");
                    RAMWidget.remoteViews.setTextViewText(C0133R.id.widget_ram_text2, RAMWidget.context.getString(C0133R.string.used_ram) + " " + (this.total - this.free) + " MB");
                    RAMWidget.remoteViews.setImageViewBitmap(C0133R.id.graph_widget, bitmap);
                    RAMWidget.appWidgetManager.updateAppWidget(RAMWidget.widget, RAMWidget.remoteViews);
                }
            } catch (Exception e) {
            }
        }
    }

    private class KillProcesses extends AsyncTask<Void, Void, Void> {
        private KillProcesses() {
        }

        protected Void doInBackground(Void... params) {
            if (!(RAMWidget.remoteViews == null || RAMWidget.context == null || RAMWidget.appWidgetManager == null)) {
                ActivityManager activityManager = (ActivityManager) RAMWidget.context.getApplicationContext().getSystemService("activity");
                List<RunningAppProcessInfo> procInfo = activityManager.getRunningAppProcesses();
                for (int i = 0; i < procInfo.size(); i++) {
                    RunningAppProcessInfo process = (RunningAppProcessInfo) procInfo.get(i);
                    int importance = process.importance;
                    String name = process.processName;
                    if (!(name.equals(BuildConfig.APPLICATION_ID) || name.contains("launcher") || name.contains("googlequicksearchbox") || importance <= 200)) {
                        activityManager.killBackgroundProcesses(name);
                    }
                }
            }
            return null;
        }

        protected void onPostExecute(Void Void) {
            if (RAMWidget.context != null) {
                Toast.makeText(RAMWidget.context, RAMWidget.context.getString(C0133R.string.ram_cls), 1).show();
            }
            if (RAMWidget.pg != null) {
                RAMWidget.pg.removeSlices();
            } else if (RAMWidget.context != null) {
                RAMWidget.pg = new PieGraph(RAMWidget.context);
            }
            new DrawTask(null).execute(new Void[0]);
            RAMWidget.isCleaning = false;
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        context = context;
        appWidgetManager = appWidgetManager;
        remoteViews = new RemoteViews(context.getPackageName(), C0133R.layout.widget_ram);
        isCleaning = false;
        widget = new ComponentName(context, RAMWidget.class);
        clearIntent = new Intent(context, RAMWidget.class);
        clearIntent.setAction(ACTION_CLEAN_RAM);
        pendingClean = PendingIntent.getBroadcast(context, 0, clearIntent, 0);
        remoteViews.setOnClickPendingIntent(C0133R.id.widget_ram_clean, pendingClean);
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, 5000);
        alarmIntent = new Intent(context, RAMWidget.class);
        alarmIntent.setAction(ACTION_UPDATE_RAM);
        pendingAlarm = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
        alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.setRepeating(1, calendar.getTimeInMillis(), 5000, pendingAlarm);
        new DrawTask().execute(new Void[0]);
        appWidgetManager.updateAppWidget(widget, remoteViews);
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        context = context;
        remoteViews = new RemoteViews(context.getPackageName(), C0133R.layout.widget_ram);
        widget = new ComponentName(context, RAMWidget.class);
        appWidgetManager = AppWidgetManager.getInstance(context);
        if (!isCleaning && intent.getAction().equals(ACTION_CLEAN_RAM)) {
            if (remoteViews == null) {
                remoteViews = new RemoteViews(context.getPackageName(), C0133R.layout.widget_ram);
            }
            isCleaning = true;
            new KillProcesses().execute(new Void[0]);
        } else if (intent.getAction().equals(ACTION_UPDATE_RAM) && remoteViews != null && appWidgetManager != null && context != null) {
            new DrawTask().execute(new Void[0]);
        }
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        try {
            alarmManager.cancel(pendingAlarm);
        } catch (Exception e) {
        }
        super.onDeleted(context, appWidgetIds);
    }
}
