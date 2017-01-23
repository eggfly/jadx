package com.dev.system.monitor;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.widget.RemoteViews;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class CPUWidget extends AppWidgetProvider {
    private static int NUMBER_OF_CORES;
    private static AppWidgetManager appWidgetManager;
    private static Context context;
    private static final String[] cpu_temp_paths;
    private static Handler handler;
    private static boolean loading_done;
    private static PowerManager mPower;
    private static int max_freq;
    private static int min_freq;
    private static RemoteViews remoteViews;
    private static Runnable runnable;
    private static ComponentName widget;

    /* renamed from: com.dev.system.monitor.CPUWidget.1 */
    class C01041 implements Runnable {
        C01041() {
        }

        public void run() {
            if (!CPUWidget.loading_done) {
                new Init(null).execute(new Void[0]);
                CPUWidget.handler.postDelayed(this, 3000);
            }
        }
    }

    private class CPUFrequency extends AsyncTask<Void, Void, Void> {
        private String[] args;
        private ProcessBuilder cmd;
        private int[] cur_freqs;
        private InputStream in;
        private Process process;
        private int rate;
        private byte[] re;
        private String result;

        private CPUFrequency() {
            this.cur_freqs = new int[CPUWidget.NUMBER_OF_CORES];
        }

        protected Void doInBackground(Void... params) {
            for (int i = 0; i < CPUWidget.NUMBER_OF_CORES; i++) {
                this.args = new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq"};
                this.result = BuildConfig.VERSION_NAME;
                int value = 0;
                try {
                    this.cmd = new ProcessBuilder(this.args);
                    this.process = this.cmd.start();
                    this.in = this.process.getInputStream();
                    this.re = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                    while (this.in.read(this.re) != -1) {
                        this.result += new String(this.re);
                    }
                    this.in.close();
                    for (int j = 0; j < this.result.length(); j++) {
                        try {
                            Integer.parseInt(this.result.charAt(j) + BuildConfig.VERSION_NAME);
                        } catch (NumberFormatException e) {
                            this.result = new String(this.result.substring(0, j));
                            value = Integer.parseInt(this.result);
                        }
                    }
                    this.cur_freqs[i] = value;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            int cur_total_freq = 0;
            for (int i2 : this.cur_freqs) {
                cur_total_freq += i2;
            }
            this.rate = (int) ((((double) cur_total_freq) / (((double) CPUWidget.max_freq) * 4.0d)) * 100.0d);
            return null;
        }

        protected void onPostExecute(Void _void) {
            if (CPUWidget.appWidgetManager != null && CPUWidget.remoteViews != null && CPUWidget.widget != null) {
                CPUWidget.remoteViews.setTextViewText(C0133R.id.widget_cpu_cur, CPUWidget.context.getString(C0133R.string.usage) + " : " + this.rate + " %");
                synchronized (CPUWidget.appWidgetManager) {
                    CPUWidget.appWidgetManager.updateAppWidget(CPUWidget.widget, CPUWidget.remoteViews);
                }
            }
        }
    }

    private class CPUTemperature extends AsyncTask<Void, Void, Void> {
        private String[] args;
        private ProcessBuilder cmd;
        private String cpu_temp;
        private boolean found;
        private InputStream in;
        private int index;
        private Process process;
        private byte[] re;
        private String result;

        private CPUTemperature() {
            this.result = BuildConfig.VERSION_NAME;
            this.found = false;
            this.index = 0;
        }

        protected Void doInBackground(Void... params) {
            char[] tmp;
            int i;
            if (CPUWidget.context.getSharedPreferences("PREFERENCE", 0).getBoolean("PATH_FOUND", false)) {
                this.args = new String[]{"/system/bin/cat", CPUWidget.cpu_temp_paths[CPUWidget.context.getSharedPreferences("PREFERENCE", 0).getInt("PATH_INDEX", 0)]};
                this.cmd = new ProcessBuilder(this.args);
                try {
                    this.process = this.cmd.start();
                    this.in = this.process.getInputStream();
                    this.re = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                    while (this.in.read(this.re) != -1) {
                        this.result += new String(this.re);
                    }
                    this.in.close();
                } catch (IOException e) {
                }
                tmp = new char[100];
                i = 0;
                while (i < this.result.length()) {
                    if ((this.result.charAt(i) <= '9' && this.result.charAt(i) >= '0') || this.result.charAt(i) == '.') {
                        tmp[0] = this.result.charAt(i);
                        tmp[1] = this.result.charAt(i + 1);
                        break;
                    }
                    i++;
                }
                this.cpu_temp = String.valueOf(tmp);
            } else {
                while (!this.found && this.index < 14) {
                    this.args = new String[]{"/system/bin/cat", CPUWidget.cpu_temp_paths[this.index]};
                    this.cmd = new ProcessBuilder(this.args);
                    try {
                        this.process = this.cmd.start();
                        this.in = this.process.getInputStream();
                        this.re = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                        while (this.in.read(this.re) != -1) {
                            this.result += new String(this.re);
                        }
                        this.in.close();
                    } catch (IOException e2) {
                    }
                    tmp = new char[100];
                    i = 0;
                    while (i < this.result.length()) {
                        if ((this.result.charAt(i) <= '9' && this.result.charAt(i) >= '0') || this.result.charAt(i) == '.') {
                            tmp[0] = this.result.charAt(i);
                            tmp[1] = this.result.charAt(i + 1);
                            break;
                        }
                        i++;
                    }
                    this.cpu_temp = String.valueOf(tmp);
                    try {
                        Double.parseDouble(this.cpu_temp);
                        CPUWidget.context.getSharedPreferences("PREFERENCE", 0).edit().putBoolean("PATH_FOUND", true).commit();
                        CPUWidget.context.getSharedPreferences("PREFERENCE", 0).edit().putInt("PATH_INDEX", this.index).commit();
                        this.found = true;
                        break;
                    } catch (NumberFormatException e3) {
                        this.index++;
                        if (this.index == 14) {
                            this.cpu_temp = "40";
                        }
                    }
                }
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            CPUWidget.remoteViews.setTextViewText(C0133R.id.widget_cpu_temperature, CPUWidget.context.getString(C0133R.string.temperature) + " : " + this.cpu_temp + " \u00b0C");
            synchronized (CPUWidget.appWidgetManager) {
                CPUWidget.appWidgetManager.updateAppWidget(CPUWidget.widget, CPUWidget.remoteViews);
            }
            super.onPostExecute(result);
        }
    }

    private class Init extends AsyncTask<Void, Void, Void> {

        /* renamed from: com.dev.system.monitor.CPUWidget.Init.1 */
        class C01051 implements FileFilter {
            C01051() {
            }

            public boolean accept(File pathname) {
                return Pattern.matches("cpu[0-9]+", pathname.getName());
            }
        }

        /* renamed from: com.dev.system.monitor.CPUWidget.Init.2 */
        class C01062 implements Runnable {
            C01062() {
            }

            public void run() {
                if (CPUWidget.remoteViews == null || CPUWidget.context == null || CPUWidget.appWidgetManager == null || !CPUWidget.mPower.isScreenOn()) {
                    CPUWidget.handler.postDelayed(this, 6000);
                    return;
                }
                CPUWidget.handler.removeCallbacks(CPUWidget.runnable);
                new CPUFrequency(null).execute(new Void[0]);
                new CPUTemperature(null).execute(new Void[0]);
                CPUWidget.handler.postDelayed(this, 2000);
            }
        }

        private Init() {
        }

        protected Void doInBackground(Void... params) {
            InputStream in;
            byte[] re;
            int j;
            String result;
            CPUWidget.NUMBER_OF_CORES = new File("/sys/devices/system/cpu/").listFiles(new C01051()).length;
            String result2 = BuildConfig.VERSION_NAME;
            try {
                in = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
                re = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                while (in.read(re) != -1) {
                    result2 = result2 + new String(re);
                }
                in.close();
                j = 0;
                result = result2;
                while (j < result.length()) {
                    try {
                        try {
                            Integer.parseInt(result.charAt(j) + BuildConfig.VERSION_NAME);
                            result2 = result;
                        } catch (NumberFormatException e) {
                            result2 = new String(result.substring(0, j));
                            CPUWidget.min_freq = Integer.parseInt(result2);
                        }
                        j++;
                        result = result2;
                    } catch (IOException e2) {
                        result2 = result;
                    }
                }
            } catch (IOException e3) {
            }
            result2 = BuildConfig.VERSION_NAME;
            try {
                in = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
                re = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                while (in.read(re) != -1) {
                    result2 = result2 + new String(re);
                }
                in.close();
                j = 0;
                result = result2;
                while (j < result.length()) {
                    try {
                        try {
                            Integer.parseInt(result.charAt(j) + BuildConfig.VERSION_NAME);
                            result2 = result;
                        } catch (NumberFormatException e4) {
                            result2 = new String(result.substring(0, j));
                            CPUWidget.max_freq = Integer.parseInt(result2);
                        }
                        j++;
                        result = result2;
                    } catch (IOException e5) {
                        result2 = result;
                    }
                }
            } catch (IOException e6) {
            }
            publishProgress(new Void[0]);
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            CPUWidget.remoteViews.setTextViewText(C0133R.id.widget_cpu_max, "Max : " + (CPUWidget.max_freq / 1000) + " MHz");
            CPUWidget.remoteViews.setTextViewText(C0133R.id.widget_cpu_min, "Min : " + (CPUWidget.min_freq / 1000) + " MHz");
            CPUWidget.loading_done = true;
            CPUWidget.appWidgetManager.updateAppWidget(CPUWidget.widget, CPUWidget.remoteViews);
            CPUWidget.appWidgetManager.updateAppWidget(CPUWidget.widget, CPUWidget.remoteViews);
            CPUWidget.runnable = new C01062();
            CPUWidget.handler.postDelayed(CPUWidget.runnable, 2000);
        }
    }

    static {
        cpu_temp_paths = new String[]{"/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone0/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/platform/s5p-tmu/curr_temp", "/sys/htc/cpu_temp", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/ext_temperature", "/sys/devices/platform/tegra-tsensor/tsensor_temperature"};
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        context = context;
        remoteViews = new RemoteViews(context.getPackageName(), C0133R.layout.widget_cpu);
        widget = new ComponentName(context, CPUWidget.class);
        mPower = (PowerManager) context.getSystemService("power");
        appWidgetManager = appWidgetManager;
        loading_done = false;
        handler = new Handler();
        runnable = new C01041();
        handler.postDelayed(runnable, 3000);
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
