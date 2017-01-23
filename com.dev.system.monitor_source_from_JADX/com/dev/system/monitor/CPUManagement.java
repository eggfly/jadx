package com.dev.system.monitor;

import android.app.Activity;
import android.app.Fragment;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class CPUManagement extends Fragment {
    private static final String[] cpu_temp_paths;
    private int NUMBER_OF_CORES;
    private Handler _handler;
    private Timer _timer;
    private TimerTask _timerTask;
    private Activity activityBackup;
    private TextView[] cores_title;
    private TextView cpu_arch;
    private TextView cpu_temp;
    private int[] cur_freqs;
    private Runnable drawGraph;
    private GraphViewSeries[] graphViewData;
    private GraphView[] graphViews;
    private LinearLayout[] graphsIDs;
    private Handler handler;
    private Activity mainActivity;
    private TextView max;
    private int max_freq;
    private TextView min;
    private int min_freq;
    private View rootView;
    private Runnable tempValue;
    private Timer timer;
    private TimerTask timerTask;
    private double[] f1x;

    /* renamed from: com.dev.system.monitor.CPUManagement.1 */
    class C00971 implements FileFilter {
        C00971() {
        }

        public boolean accept(File pathname) {
            return Pattern.matches("cpu[0-9]+", pathname.getName());
        }
    }

    /* renamed from: com.dev.system.monitor.CPUManagement.2 */
    class C00982 implements Runnable {
        C00982() {
        }

        public void run() {
            try {
                new CPUFrequency(null).execute(new Void[0]);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.dev.system.monitor.CPUManagement.3 */
    class C00993 extends TimerTask {
        C00993() {
        }

        public void run() {
            CPUManagement.this.handler.post(CPUManagement.this.drawGraph);
        }
    }

    /* renamed from: com.dev.system.monitor.CPUManagement.4 */
    class C01004 implements Runnable {
        C01004() {
        }

        public void run() {
            try {
                new CPUTemperature(null).execute(new Void[0]);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.dev.system.monitor.CPUManagement.5 */
    class C01015 extends TimerTask {
        C01015() {
        }

        public void run() {
            CPUManagement.this._handler.post(CPUManagement.this.tempValue);
        }
    }

    private class CPUFrequency extends AsyncTask<Void, Integer, Void> {
        private String[] args;
        private ProcessBuilder cmd;
        private InputStream in;
        private Process process;
        private byte[] re;
        private String result;

        private CPUFrequency() {
        }

        protected Void doInBackground(Void... params) {
            int i;
            for (i = 0; i < CPUManagement.this.NUMBER_OF_CORES; i++) {
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
                    CPUManagement.this.cur_freqs[i] = value;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            for (i = 0; i < CPUManagement.this.NUMBER_OF_CORES; i++) {
                publishProgress(new Integer[]{Integer.valueOf(i)});
                double[] access$800 = CPUManagement.this.f1x;
                access$800[i] = access$800[i] + 0.2d;
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values) {
            CPUManagement.this.graphViewData[values[0].intValue()].appendData(new GraphViewData(CPUManagement.this.f1x[values[0].intValue()], (double) (CPUManagement.this.cur_freqs[values[0].intValue()] / 1000)), true, 10);
            if (CPUManagement.this.cur_freqs[values[0].intValue()] != 0) {
                CPUManagement.this.cores_title[values[0].intValue()].setText("Core " + values[0] + " " + (CPUManagement.this.cur_freqs[values[0].intValue()] / 1000) + " Mhz");
            } else {
                CPUManagement.this.cores_title[values[0].intValue()].setText("Core " + values[0] + " OFFLINE");
            }
            if (CPUManagement.this.cur_freqs.length < CPUManagement.this.NUMBER_OF_CORES) {
                for (int i = CPUManagement.this.NUMBER_OF_CORES - CPUManagement.this.cur_freqs.length; i < CPUManagement.this.NUMBER_OF_CORES; i++) {
                    CPUManagement.this.cores_title[values[0].intValue()].setText("Core " + i + " NOT PRESENT");
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

        /* renamed from: com.dev.system.monitor.CPUManagement.CPUTemperature.1 */
        class C01031 extends TimerTask {

            /* renamed from: com.dev.system.monitor.CPUManagement.CPUTemperature.1.1 */
            class C01021 extends AsyncTask<Void, Void, Void> {
                private String[] args;
                private ProcessBuilder cmd;
                private String cpu_temp;
                private boolean found;
                private InputStream in;
                private int index;
                private Process process;
                private byte[] re;
                private String result;

                C01021() {
                    this.result = BuildConfig.VERSION_NAME;
                    this.found = false;
                    this.index = 0;
                }

                protected Void doInBackground(Void... params) {
                    if (CPUManagement.this.mainActivity == null) {
                        CPUManagement.this.mainActivity = CPUManagement.this.activityBackup;
                    }
                    if (CPUManagement.this.mainActivity == null) {
                        CPUManagement.this.mainActivity = CPUManagement.this.getActivity();
                    }
                    CPUManagement.this.mainActivity;
                    char[] tmp;
                    int i;
                    if (CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).getBoolean("PATH_FOUND", false)) {
                        if (CPUManagement.this.mainActivity == null) {
                            CPUManagement.this.mainActivity = CPUManagement.this.getActivity();
                        }
                        if (CPUManagement.this.mainActivity == null) {
                            CPUManagement.this.mainActivity = CPUManagement.this.activityBackup;
                        }
                        if (CPUManagement.this.mainActivity != null) {
                            this.args = new String[]{"/system/bin/cat", CPUManagement.cpu_temp_paths[CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).getInt("PATH_INDEX", 0)]};
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
                            if (this.cpu_temp.equals(BuildConfig.VERSION_NAME) || this.cpu_temp.equals(" ")) {
                                this.cpu_temp = "40";
                            }
                        }
                    } else {
                        while (!this.found && this.index < 14) {
                            this.args = new String[]{"/system/bin/cat", CPUManagement.cpu_temp_paths[this.index]};
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
                                CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).edit().putBoolean("PATH_FOUND", true).commit();
                                CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).edit().putInt("PATH_INDEX", this.index).commit();
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

                protected void onPostExecute(Void aVoid) {
                    try {
                        if (Integer.parseInt(this.cpu_temp.substring(0, 2)) >= 50 && CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).getBoolean("NOTIFICATIONS", false)) {
                            Notification n;
                            if (VERSION.SDK_INT >= 16) {
                                n = new Builder(CPUManagement.this.getActivity()).setContentTitle("System Monitor Warning").setContentText("Your CPU temperature is getting high!").setSmallIcon(C0133R.drawable.icon).setAutoCancel(true).build();
                            } else {
                                n = new Builder(CPUManagement.this.getActivity()).setContentTitle("System Monitor Warning").setContentText("Your CPU temperature is getting high!").setSmallIcon(C0133R.drawable.icon).setAutoCancel(true).getNotification();
                            }
                            ((NotificationManager) CPUManagement.this.getActivity().getSystemService("notification")).notify(0, n);
                        }
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                }
            }

            C01031() {
            }

            public void run() {
                new C01021().execute(new Void[0]);
            }
        }

        private CPUTemperature() {
            this.result = BuildConfig.VERSION_NAME;
            this.found = false;
            this.index = 0;
        }

        protected Void doInBackground(Void... params) {
            if (CPUManagement.this.mainActivity == null) {
                CPUManagement.this.mainActivity = CPUManagement.this.activityBackup;
            }
            if (CPUManagement.this.mainActivity == null) {
                CPUManagement.this.mainActivity = CPUManagement.this.getActivity();
            }
            CPUManagement.this.mainActivity;
            char[] tmp;
            int i;
            if (CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).getBoolean("PATH_FOUND", false)) {
                if (CPUManagement.this.mainActivity == null) {
                    CPUManagement.this.mainActivity = CPUManagement.this.getActivity();
                }
                if (CPUManagement.this.mainActivity == null) {
                    CPUManagement.this.mainActivity = CPUManagement.this.activityBackup;
                }
                if (CPUManagement.this.mainActivity != null) {
                    this.args = new String[]{"/system/bin/cat", CPUManagement.cpu_temp_paths[CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).getInt("PATH_INDEX", 0)]};
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
                    if (this.cpu_temp.equals(BuildConfig.VERSION_NAME) || this.cpu_temp.equals(" ")) {
                        this.cpu_temp = "40";
                    }
                }
            } else {
                while (!this.found && this.index < 14) {
                    this.args = new String[]{"/system/bin/cat", CPUManagement.cpu_temp_paths[this.index]};
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
                        CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).edit().putBoolean("PATH_FOUND", true).commit();
                        CPUManagement.this.mainActivity.getSharedPreferences("PREFERENCE", 0).edit().putInt("PATH_INDEX", this.index).commit();
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
            if (!(CPUManagement.this.mainActivity == null || this.cpu_temp == null || !CPUManagement.this.isAdded())) {
                CPUManagement.this.cpu_temp.setText(CPUManagement.this.getString(C0133R.string.temperature) + " : " + this.cpu_temp + " \u00b0C");
            }
            super.onPostExecute(result);
            new Timer().schedule(new C01031(), 0, 6000);
        }
    }

    static {
        cpu_temp_paths = new String[]{"/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone0/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/platform/s5p-tmu/curr_temp", "/sys/htc/cpu_temp", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/ext_temperature", "/sys/devices/platform/tegra-tsensor/tsensor_temperature"};
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        InputStream in;
        byte[] re;
        int j;
        String result;
        int i;
        File[] files = new File("/sys/devices/system/cpu/").listFiles(new C00971());
        this.mainActivity = getActivity();
        this.NUMBER_OF_CORES = files.length;
        if (this.NUMBER_OF_CORES <= 4) {
            this.rootView = inflater.inflate(C0133R.layout.fragment_cpu, container, false);
            this.cores_title = new TextView[]{(TextView) this.rootView.findViewById(C0133R.id.textView1), (TextView) this.rootView.findViewById(C0133R.id.textView2), (TextView) this.rootView.findViewById(C0133R.id.textView3), (TextView) this.rootView.findViewById(C0133R.id.textView4)};
            this.graphsIDs = new LinearLayout[]{(LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout1), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout2), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout3), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout4)};
            this.min = (TextView) this.rootView.findViewById(C0133R.id.textView6);
            this.max = (TextView) this.rootView.findViewById(C0133R.id.textView5);
            this.cpu_temp = (TextView) this.rootView.findViewById(C0133R.id.textView7);
            this.cpu_arch = (TextView) this.rootView.findViewById(C0133R.id.textView8);
        } else {
            this.rootView = inflater.inflate(C0133R.layout.fragment_cpu_octa, container, false);
            this.cores_title = new TextView[]{(TextView) this.rootView.findViewById(C0133R.id.textView1), (TextView) this.rootView.findViewById(C0133R.id.textView2), (TextView) this.rootView.findViewById(C0133R.id.textView3), (TextView) this.rootView.findViewById(C0133R.id.textView4), (TextView) this.rootView.findViewById(C0133R.id.textView5), (TextView) this.rootView.findViewById(C0133R.id.textView6), (TextView) this.rootView.findViewById(C0133R.id.textView7), (TextView) this.rootView.findViewById(C0133R.id.textView8)};
            this.graphsIDs = new LinearLayout[]{(LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout1), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout2), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout3), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout4), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout5), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout6), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout7), (LinearLayout) this.rootView.findViewById(C0133R.id.linearLayout8)};
            this.max = (TextView) this.rootView.findViewById(C0133R.id.textView9);
            this.min = (TextView) this.rootView.findViewById(C0133R.id.textView10);
            this.cpu_temp = (TextView) this.rootView.findViewById(C0133R.id.textView11);
            this.cpu_arch = (TextView) this.rootView.findViewById(C0133R.id.textView12);
        }
        this.mainActivity.setTitle("Central Processing Unit");
        String chipset = System.getProperty("os.arch");
        this.cpu_arch.setText(getString(C0133R.string.architecture) + " : ");
        if (chipset.contains("64")) {
            this.cpu_arch.append("64 bit");
        } else {
            this.cpu_arch.append("32 bit");
        }
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
                    Integer.parseInt(result.charAt(j) + BuildConfig.VERSION_NAME);
                    result2 = result;
                } catch (NumberFormatException e) {
                    try {
                        String str = new String(result.substring(0, j));
                        this.min_freq = Integer.parseInt(str);
                    } catch (IOException e2) {
                        result2 = result;
                    }
                }
                j++;
                result = result2;
            }
        } catch (IOException e3) {
        }
        this.min.setText(getString(C0133R.string.min_freq));
        this.min.append(" : " + (this.min_freq / 1000) + " MHz");
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
                    Integer.parseInt(result.charAt(j) + BuildConfig.VERSION_NAME);
                    result2 = result;
                } catch (NumberFormatException e4) {
                    try {
                        str = new String(result.substring(0, j));
                        this.max_freq = Integer.parseInt(str);
                    } catch (IOException e5) {
                        result2 = result;
                    }
                }
                j++;
                result = result2;
            }
        } catch (IOException e6) {
        }
        this.max.setText(getString(C0133R.string.max_freq));
        this.max.append(" : " + (this.max_freq / 1000) + " MHz");
        this.graphViews = new GraphView[this.NUMBER_OF_CORES];
        this.graphViewData = new GraphViewSeries[this.NUMBER_OF_CORES];
        this.f1x = new double[this.NUMBER_OF_CORES];
        if (this.NUMBER_OF_CORES < 4) {
            for (i = 3; i >= this.NUMBER_OF_CORES; i--) {
                this.graphsIDs[i].setVisibility(8);
            }
        }
        for (i = 0; i < this.graphViews.length; i++) {
            this.graphViews[i] = new LineGraphView(this.mainActivity, BuildConfig.VERSION_NAME);
            this.graphViews[i].setManualYAxisBounds((double) (this.max_freq / 1000), 0.0d);
            this.graphViewData[i] = new GraphViewSeries(new GraphViewData[]{new GraphViewData(0.0d, 0.0d)});
            ((LineGraphView) this.graphViews[i]).setDrawBackground(true);
            this.graphViews[i].addSeries(this.graphViewData[i]);
            this.graphViews[i].setViewPort(1.0d, 1.0d);
            this.graphViews[i].setScalable(true);
            this.graphViews[i].setShowHorizontalLabels(false);
            this.graphViews[i].setShowVerticalLabels(false);
            this.graphsIDs[i].addView(this.graphViews[i]);
            this.f1x[i] = 0.2d;
        }
        this.cur_freqs = new int[this.NUMBER_OF_CORES];
        this.handler = new Handler();
        this.timer = new Timer();
        this.drawGraph = new C00982();
        this.timerTask = new C00993();
        this.timer.schedule(this.timerTask, 0, 1250);
        this._handler = new Handler();
        this._timer = new Timer();
        this.tempValue = new C01004();
        this._timerTask = new C01015();
        this._timer.schedule(this._timerTask, 0, 5000);
        return this.rootView;
    }

    public void onPause() {
        this.timer.cancel();
        this._timer.cancel();
        super.onPause();
    }

    public void onResume() {
        try {
            this.timer = new Timer();
            this.timer.schedule(this.timerTask, 0, 1250);
            this._timer = new Timer();
            this._timer.schedule(this.timerTask, 0, 5000);
        } catch (IllegalStateException e) {
        }
        super.onResume();
    }

    public void onAttach(Activity activity) {
        this.mainActivity = activity;
        super.onAttach(activity);
    }

    public void onDetach() {
        this.activityBackup = this.mainActivity;
        super.onDetach();
    }
}
