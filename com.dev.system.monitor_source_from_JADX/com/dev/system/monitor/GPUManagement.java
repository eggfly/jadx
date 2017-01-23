package com.dev.system.monitor;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dev.system.monitor.GPU.OnCompleteCallback;
import com.dev.system.monitor.GPU.OpenGLGles10Info;
import com.dev.system.monitor.GPU.OpenGLGles20Info;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import it.gmariotti.cardslib.library.view.CardView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class GPUManagement extends Fragment {
    private final String GPU_CUR_CLOCK;
    private final String GPU_MAX_CLOCK;
    private GeneralInfoCard card;
    private HashMap<String, String> gl10;
    private HashMap<String, String> gl20;
    private GraphView gpuGraph;
    private LinearLayout gpuGraphLayout;
    private GraphViewSeries gpuGraphSeries;
    private boolean gpu_data_loaded;
    private ArrayList<String> info;
    private Activity mainActivity;
    private long max_gpu_clock;
    private boolean methodAlreadyCalled;
    private View rootView;
    private Timer timer;
    private TimerTask timerTask;
    private ArrayList<String> values;
    private double f2x;

    /* renamed from: com.dev.system.monitor.GPUManagement.3 */
    class C01183 extends TimerTask {

        /* renamed from: com.dev.system.monitor.GPUManagement.3.1 */
        class C01171 extends AsyncTask<Void, Void, Void> {
            private long gpu_cur;
            private long gpu_max;

            C01171() {
            }

            private long getGPUClock(String param) {
                long j = 0;
                try {
                    BufferedReader localBufferedReader = new BufferedReader(new FileReader(param));
                    if (localBufferedReader != null) {
                        String str = localBufferedReader.readLine();
                        if (str != null) {
                            try {
                                j = Long.parseLong(str.trim().split("\\s+")[0]) / 1000000;
                            } catch (NumberFormatException localNumberFormatException) {
                                localNumberFormatException.printStackTrace();
                            }
                        }
                    }
                } catch (IOException localIOException) {
                    localIOException.printStackTrace();
                }
                return j;
            }

            protected Void doInBackground(Void... params) {
                this.gpu_cur = getGPUClock("/sys/class/kgsl/kgsl-3d0/gpuclk");
                if (GPUManagement.this.gpuGraph == null) {
                    GPUManagement gPUManagement = GPUManagement.this;
                    long gPUClock = getGPUClock("/sys/class/kgsl/kgsl-3d0/max_gpuclk");
                    this.gpu_max = gPUClock;
                    gPUManagement.max_gpu_clock = gPUClock;
                }
                return null;
            }

            protected void onPostExecute(Void aVoid) {
                if (GPUManagement.this.max_gpu_clock == 0) {
                    GPUManagement.this.rootView.findViewById(C0133R.id.gpu_graph).setVisibility(8);
                    GPUManagement.this.rootView.findViewById(C0133R.id.gpu_graph_max).setVisibility(8);
                    GPUManagement.this.rootView.findViewById(C0133R.id.gpu_graph_clock).setVisibility(8);
                    GPUManagement.this.rootView.findViewById(C0133R.id.gpu_graph_text).setVisibility(8);
                    GPUManagement.this.timer.cancel();
                    return;
                }
                if (GPUManagement.this.gpuGraph == null) {
                    GPUManagement.this.gpuGraphLayout = (LinearLayout) GPUManagement.this.rootView.findViewById(C0133R.id.gpu_graph);
                    GPUManagement.this.gpuGraph = new LineGraphView(GPUManagement.this.mainActivity, BuildConfig.VERSION_NAME);
                    GPUManagement.this.gpuGraph.setManualYAxisBounds((double) this.gpu_max, 0.0d);
                    GPUManagement.this.gpuGraphSeries = new GraphViewSeries(new GraphViewData[]{new GraphViewData(0.0d, 0.0d)});
                    ((LineGraphView) GPUManagement.this.gpuGraph).setDrawBackground(true);
                    GPUManagement.this.gpuGraph.addSeries(GPUManagement.this.gpuGraphSeries);
                    GPUManagement.this.gpuGraph.setViewPort(1.0d, 1.0d);
                    GPUManagement.this.gpuGraph.setScalable(true);
                    GPUManagement.this.gpuGraph.setShowHorizontalLabels(false);
                    GPUManagement.this.gpuGraph.setShowVerticalLabels(false);
                    GPUManagement.this.gpuGraphLayout.addView(GPUManagement.this.gpuGraph);
                    ((TextView) GPUManagement.this.rootView.findViewById(C0133R.id.gpu_graph_max)).setText("MAX clock : " + GPUManagement.this.max_gpu_clock + " MHz");
                }
                GPUManagement.this.f2x = GPUManagement.this.f2x + 0.2d;
                GPUManagement.this.gpuGraphSeries.appendData(new GraphViewData(GPUManagement.this.f2x, (double) this.gpu_cur), true, 10);
                ((TextView) GPUManagement.this.rootView.findViewById(C0133R.id.gpu_graph_clock)).setText("CUR clock : " + this.gpu_cur + " MHz");
                ((TextView) GPUManagement.this.rootView.findViewById(C0133R.id.gpu_graph_text)).setText("GPU Usage " + new DecimalFormat("#.##").format(((double) (((float) this.gpu_cur) / ((float) GPUManagement.this.max_gpu_clock))) * 100.0d) + " %");
            }
        }

        C01183() {
        }

        public void run() {
            new C01171().execute(new Void[0]);
        }
    }

    /* renamed from: com.dev.system.monitor.GPUManagement.1 */
    class C02401 implements OnCompleteCallback<OpenGLGles10Info> {
        C02401() {
        }

        public void onComplete(OpenGLGles10Info info) {
            GPUManagement.this.gl10 = info.getSummary();
        }
    }

    /* renamed from: com.dev.system.monitor.GPUManagement.2 */
    class C02412 implements OnCompleteCallback<OpenGLGles20Info> {
        C02412() {
        }

        public void onComplete(OpenGLGles20Info info) {
            GPUManagement.this.gl20 = info.getSummary();
            System.out.println("Calling printResult()");
            GPUManagement.this.printResults(true);
            GPUManagement.this.methodAlreadyCalled = true;
        }
    }

    public GPUManagement() {
        this.gl10 = null;
        this.gl20 = null;
        this.info = new ArrayList();
        this.values = new ArrayList();
        this.f2x = 0.0d;
        this.GPU_MAX_CLOCK = "/sys/class/kgsl/kgsl-3d0/max_gpuclk";
        this.GPU_CUR_CLOCK = "/sys/class/kgsl/kgsl-3d0/gpuclk";
        this.gpu_data_loaded = false;
        this.methodAlreadyCalled = false;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_gpu, container, false);
        this.mainActivity = getActivity();
        this.gpu_data_loaded = this.mainActivity.getSharedPreferences("PREFERENCE", 0).getBoolean("GPU_DATA", false);
        this.mainActivity.setTitle(getString(C0133R.string.gpu));
        if (this.gpu_data_loaded) {
            SharedPreferences pref = this.mainActivity.getSharedPreferences("PREFERENCE", 0);
            this.info.add("Resolution");
            this.values.add(pref.getInt("HEIGHT", 0) + " x " + pref.getInt("WIDTH", 0));
            this.info.add("Screen size");
            this.values.add(pref.getString("WIDTH_CM", BuildConfig.VERSION_NAME) + "\" - " + pref.getString("HEIGHT_CM", BuildConfig.VERSION_NAME) + " cm");
            this.info.add("Pixel density");
            this.values.add(pref.getFloat("PIXEL_DENS", 0.0f) + " ppi");
            this.info.add("Dots density");
            this.values.add(pref.getInt("DOTS_DENS", 0) + " dpi");
            this.info.add("Refresh rate");
            this.values.add(pref.getString("REFRESH", BuildConfig.VERSION_NAME) + " Hz");
            initCard(this.info, this.values);
        } else {
            DisplayMetrics display = new DisplayMetrics();
            this.mainActivity.getWindowManager().getDefaultDisplay().getMetrics(display);
            Display var7 = ((WindowManager) this.mainActivity.getSystemService("window")).getDefaultDisplay();
            DecimalFormat var5 = new DecimalFormat("#.##");
            double var3 = (double) (((float) display.widthPixels) / display.xdpi);
            double var1 = (double) (((float) display.heightPixels) / display.ydpi);
            var1 = Math.sqrt((var3 * var3) + (var1 * var1));
            this.mainActivity.getSharedPreferences("PREFERENCE", 0).edit().putInt("HEIGHT", display.heightPixels).putInt("WIDTH", display.widthPixels).putString("WIDTH_CM", var5.format(var1)).putString("HEIGHT_CM", var5.format(2.54d * var1)).putFloat("PIXEL_DENS", display.xdpi).putInt("DOTS_DENS", display.densityDpi).putString("REFRESH", var5.format((double) var7.getRefreshRate())).putBoolean("GPU_DATA", true).commit();
            this.info.add("Resolution");
            this.values.add(display.heightPixels + " x " + display.widthPixels);
            this.info.add("Screen size");
            this.values.add(var5.format(var1) + "\" - " + var5.format(2.54d * var1) + " cm");
            this.info.add("Pixel density");
            this.values.add(((int) display.xdpi) + " ppi");
            this.info.add("Dots density");
            this.values.add(display.densityDpi + " dpi");
            this.info.add("Refresh rate");
            this.values.add(var5.format((double) var7.getRefreshRate()) + " Hz");
            initCard(this.info, this.values);
        }
        return this.rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (this.mainActivity.getSharedPreferences("PREFERENCE", 0).getBoolean("GPU_GL", false)) {
            printResults(this.mainActivity.getSharedPreferences("PREFERENCE", 0).getBoolean("GPU_GL", false));
            return;
        }
        try {
            GPU gpu = new GPU(this.mainActivity);
            gpu.loadOpenGLGles10Info(new C02401());
            gpu.loadOpenGLGles20Info(new C02412());
        } catch (RuntimeException e) {
            printResults(this.mainActivity.getSharedPreferences("PREFERENCE", 0).getBoolean("GPU_GL", false));
        }
    }

    private void printResults(boolean canDisplayInfo) {
        if (canDisplayInfo) {
            HashMap<String, String> realValues;
            if (this.gl20 == null || ((String) this.gl20.get("VENDOR")).equals(BuildConfig.VERSION_NAME)) {
                realValues = this.gl10;
            } else {
                realValues = this.gl20;
            }
            if (realValues != null) {
                this.mainActivity.getSharedPreferences("PREFERENCE", 0).edit().putString("RENDERER", (String) realValues.get("RENDERER")).putString("VENDOR", (String) realValues.get("VENDOR")).putString("VERSION", ((String) realValues.get("VERSION")).substring(0, 13)).putBoolean("GPU_GL", true).commit();
                this.info.add("Renderer");
                this.values.add(realValues.get("RENDERER"));
                this.info.add("Vendor");
                this.values.add(realValues.get("VENDOR"));
                this.info.add("Version");
                this.values.add(((String) realValues.get("VERSION")).substring(0, 13));
                initCard(this.info, this.values);
            } else if (this.mainActivity.getSharedPreferences("PREFERENCE", 0).getBoolean("GPU_GL", false)) {
                SharedPreferences pref = this.mainActivity.getSharedPreferences("PREFERENCE", 0);
                this.info.add("Renderer");
                this.values.add(pref.getString("RENDERER", BuildConfig.VERSION_NAME));
                this.info.add("Vendor");
                this.values.add(pref.getString("VENDOR", BuildConfig.VERSION_NAME));
                this.info.add("Version");
                this.values.add(pref.getString("VERSION", BuildConfig.VERSION_NAME).substring(0, 13));
                initCard(this.info, this.values);
            }
        }
        this.timer = new Timer();
        this.timerTask = new C01183();
        this.timer.schedule(this.timerTask, 0, 1250);
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value) {
        this.card = new GeneralInfoCard(this.mainActivity, info, value, "GPU & Screen Information");
        this.card.init();
        ((CardView) this.rootView.findViewById(C0133R.id.card_gpu)).setCard(this.card);
    }
}
