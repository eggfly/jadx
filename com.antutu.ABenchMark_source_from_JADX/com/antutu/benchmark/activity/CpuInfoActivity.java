package com.antutu.benchmark.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1528h;
import com.antutu.benchmark.p036a.C1110f;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p041d.C1378d;
import com.antutu.benchmark.p041d.C1378d.C1377a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.redacc.C1692R;
import com.antutu.utils.CPULoad;
import com.antutu.utils.DownloadJob;
import com.antutu.utils.DownloadJobListener;
import com.antutu.utils.MLog;
import com.antutu.utils.NetUtils;
import com.antutu.utils.SpecialHelper;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.antutu.utils.widget.SystemBarTintManager;
import com.facebook.ads.AdError;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;

public class CpuInfoActivity extends C1197a {
    ListView f4142a;
    C1110f f4143b;
    Handler f4144c;
    CPULoad f4145d;
    String[] f4146e;
    C1226b f4147f;
    public int[] f4148g;
    boolean f4149h;
    private List<C1227c> f4150i;
    private RandomAccessFile f4151k;
    private int f4152l;
    private int f4153m;
    private List<C1227c> f4154n;
    private String f4155o;
    private String f4156p;
    private C1228d f4157q;
    private ArrayList<C1377a> f4158r;
    private ArrayList<C1227c> f4159s;
    private DownloadJob f4160t;
    private C1227c f4161u;
    private View f4162v;
    private C1225a f4163w;
    private ProgressDialog f4164x;
    private String f4165y;

    /* renamed from: com.antutu.benchmark.activity.CpuInfoActivity.1 */
    class C12221 implements DownloadJobListener {
        final /* synthetic */ CpuInfoActivity f4119a;

        C12221(CpuInfoActivity cpuInfoActivity) {
            this.f4119a = cpuInfoActivity;
        }

        public void downloadEnded(C1519k c1519k) {
            Object obj = 1;
            if (c1519k == null) {
                try {
                    Toast.makeText(this.f4119a, "request failed,try agin later.", 0).show();
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            try {
                C1528h c1528h = (C1528h) c1519k;
                if (c1528h == null || c1528h.f5296a == null || c1528h.f5296a.f5268K != 1) {
                    if (!c1528h.f5296a.f5265H.equals(BuildConfig.FLAVOR)) {
                        if (!(this.f4119a.f4147f.f4123a.contains("Intel") && this.f4119a.f4147f.f4123a.contains("Atom"))) {
                            obj = null;
                        }
                        if (obj == null) {
                            this.f4119a.f4147f.f4123a = c1528h.f5296a.f5265H;
                            this.f4119a.f4147f.f4125c = c1528h.f5296a.f5265H;
                            this.f4119a.f4156p = c1528h.f5296a.f5265H;
                        }
                    }
                    this.f4119a.getSharedPreferences("cpu_detail_info", 0).edit().putString("cpu_md", this.f4119a.f4156p).commit();
                    if (c1528h.f5296a.f5275f != null && !c1528h.f5296a.f5275f.equals(BuildConfig.FLAVOR) && !Build.BRAND.equalsIgnoreCase(c1528h.f5296a.f5275f)) {
                        this.f4119a.f4155o = c1528h.f5296a.f5275f + C4233j.f14396s + Build.BRAND + C4233j.f14397t;
                    }
                }
            } catch (Exception e2) {
                MLog.m6864d(e2.toString());
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.CpuInfoActivity.2 */
    class C12232 implements FileFilter {
        final /* synthetic */ CpuInfoActivity f4120a;

        C12232(CpuInfoActivity cpuInfoActivity) {
            this.f4120a = cpuInfoActivity;
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* renamed from: com.antutu.benchmark.activity.CpuInfoActivity.3 */
    class C12243 implements OnClickListener {
        final /* synthetic */ CpuInfoActivity f4121a;

        C12243(CpuInfoActivity cpuInfoActivity) {
            this.f4121a = cpuInfoActivity;
        }

        public void onClick(View view) {
            this.f4121a.finish();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.CpuInfoActivity.a */
    class C1225a extends AsyncTask<Integer, Integer, String> {
        final /* synthetic */ CpuInfoActivity f4122a;

        C1225a(CpuInfoActivity cpuInfoActivity) {
            this.f4122a = cpuInfoActivity;
        }

        protected String m5015a(Integer... numArr) {
            try {
                this.f4122a.m5033d();
                if (this.f4122a.f4147f.f4125c == null || !this.f4122a.f4147f.f4125c.contains("MT")) {
                    this.f4122a.f4156p = this.f4122a.f4147f.f4123a;
                } else {
                    this.f4122a.f4156p = this.f4122a.f4147f.f4125c;
                }
                this.f4122a.f4146e = new String[this.f4122a.f4152l];
                this.f4122a.f4159s = new ArrayList();
                for (int i = 0; i < this.f4122a.f4152l; i++) {
                    this.f4122a.f4146e[i] = "cpu" + String.valueOf(i);
                    this.f4122a.f4159s.add(null);
                    this.f4122a.f4150i.add(new C1227c());
                }
                this.f4122a.f4145d = new CPULoad();
                this.f4122a.f4148g = new int[this.f4122a.f4152l];
                this.f4122a.m5041b();
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
            return "\u6267\u884c\u5b8c\u6bd5";
        }

        protected void m5016a(String str) {
            try {
                this.f4122a.f4143b = new C1110f(this.f4122a, this.f4122a.f4154n);
                this.f4122a.f4143b.notifyDataSetChanged();
                this.f4122a.f4142a.setAdapter(this.f4122a.f4143b);
                this.f4122a.m5021a(this.f4122a.f4142a);
                String string = this.f4122a.getSharedPreferences("cpu_detail_info", 0).getString("cpu_md", MessageService.MSG_DB_READY_REPORT);
                if (string.equals(MessageService.MSG_DB_READY_REPORT)) {
                    this.f4122a.m5040a();
                } else {
                    this.f4122a.f4156p = string;
                }
                this.f4122a.f4164x.dismiss();
            } catch (Exception e) {
                this.f4122a.f4164x.dismiss();
            }
            super.onPostExecute(str);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m5015a((Integer[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m5016a((String) obj);
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.CpuInfoActivity.b */
    class C1226b {
        String f4123a;
        String f4124b;
        String f4125c;
        String f4126d;
        String f4127e;
        String f4128f;
        String f4129g;
        String f4130h;
        String f4131i;
        String f4132j;
        final /* synthetic */ CpuInfoActivity f4133k;

        C1226b(CpuInfoActivity cpuInfoActivity) {
            this.f4133k = cpuInfoActivity;
            this.f4123a = BuildConfig.FLAVOR;
            this.f4124b = BuildConfig.FLAVOR;
            this.f4125c = BuildConfig.FLAVOR;
            this.f4126d = BuildConfig.FLAVOR;
            this.f4127e = BuildConfig.FLAVOR;
            this.f4128f = BuildConfig.FLAVOR;
            this.f4129g = BuildConfig.FLAVOR;
            this.f4130h = BuildConfig.FLAVOR;
            this.f4131i = BuildConfig.FLAVOR;
            this.f4132j = BuildConfig.FLAVOR;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.CpuInfoActivity.c */
    public static class C1227c {
        public String[] f4134a;
        public long f4135b;
        public long f4136c;
        public long f4137d;
        public String f4138e;
        public String f4139f;
    }

    /* renamed from: com.antutu.benchmark.activity.CpuInfoActivity.d */
    public class C1228d extends Thread {
        final /* synthetic */ CpuInfoActivity f4140a;
        private boolean f4141b;

        public C1228d(CpuInfoActivity cpuInfoActivity) {
            this.f4140a = cpuInfoActivity;
            this.f4141b = false;
        }

        public void m5017a(boolean z) {
            this.f4141b = z;
        }

        public void run() {
            if (!this.f4141b) {
                this.f4140a.f4144c.postDelayed(this, 2000);
                this.f4140a.m5041b();
            }
        }
    }

    public CpuInfoActivity() {
        this.f4144c = null;
        this.f4150i = new ArrayList();
        this.f4152l = 0;
        this.f4148g = null;
        this.f4154n = new ArrayList();
        this.f4165y = null;
        this.f4149h = false;
    }

    private void m5021a(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            int i = 0;
            for (int i2 = 0; i2 < count; i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight() + 20;
            }
            LayoutParams layoutParams = (LayoutParams) listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    private void m5023a(String str) {
        try {
            String j = C1516b.m6036j();
            boolean equalsIgnoreCase = j.equalsIgnoreCase("Mali-T760");
            boolean equalsIgnoreCase2 = j.equalsIgnoreCase("UNIVERSAL5433");
            boolean equalsIgnoreCase3 = j.equalsIgnoreCase("PowerVR Rogue Han");
            boolean equalsIgnoreCase4 = j.equalsIgnoreCase("NVIDIA Tegra");
            if ("0xd07".equals(str) || "0xd03".equals(str)) {
                if (equalsIgnoreCase || equalsIgnoreCase2) {
                    this.f4147f.f4130h = "ARM Cortex-A57&A53";
                }
            } else if ("0xc0e".equals(str) || "0xc07".equals(str)) {
                if (equalsIgnoreCase3) {
                    this.f4147f.f4130h = "ARM Cortex-A17&A7";
                }
            } else if ("0x000".equals(str) && equalsIgnoreCase4) {
                this.f4147f.f4130h = "NVIDIA Denver";
            }
        } catch (Exception e) {
        }
    }

    private void m5024a(List<C1227c> list, int[] iArr) {
        int i = 0;
        if (list != null && list.size() != 0) {
            C1227c c1227c;
            Collection arrayList = new ArrayList();
            if (!BuildConfig.FLAVOR.equals(this.f4147f.f4130h)) {
                c1227c = new C1227c();
                c1227c.f4138e = getString(C1082R.string.cpu_model);
                c1227c.f4139f = this.f4147f.f4130h;
                arrayList.add(c1227c);
            }
            c1227c = new C1227c();
            c1227c.f4138e = getString(C1082R.string.model);
            int indexOf = this.f4156p.indexOf("@");
            if (indexOf != -1) {
                this.f4156p = this.f4156p.substring(0, indexOf);
            }
            c1227c.f4139f = this.f4156p;
            arrayList.add(c1227c);
            c1227c = new C1227c();
            c1227c.f4138e = getString(C1082R.string.CPU_Type);
            c1227c.f4139f = this.f4147f.f4131i;
            arrayList.add(c1227c);
            c1227c = new C1227c();
            c1227c.f4138e = getString(C1082R.string.core_count);
            c1227c.f4139f = this.f4147f.f4128f;
            arrayList.add(c1227c);
            c1227c = new C1227c();
            c1227c.f4138e = getString(C1082R.string.cpu_fre);
            c1227c.f4139f = this.f4147f.f4127e;
            arrayList.add(c1227c);
            c1227c = new C1227c();
            c1227c.f4138e = getString(C1082R.string.cpu_detail_load);
            c1227c.f4139f = this.f4161u.f4137d + "%";
            arrayList.add(c1227c);
            indexOf = "4+4".equals(this.f4147f.f4128f) ? 4 : "2+2".equals(this.f4147f.f4128f) ? 2 : Integer.parseInt(this.f4147f.f4128f);
            while (i < indexOf) {
                try {
                    C1227c c1227c2 = new C1227c();
                    if (i <= list.size() - 1) {
                        if (list.get(i) != null) {
                            c1227c2.f4138e = "Core " + i + ": " + ((C1227c) list.get(i)).f4137d + "%";
                        } else {
                            c1227c2.f4138e = getString(C1082R.string.sleep);
                        }
                        if (iArr[i] == -1) {
                            c1227c2.f4139f = getString(C1082R.string.sleep);
                        } else {
                            c1227c2.f4139f = (iArr[i] / AdError.NETWORK_ERROR_CODE) + " MHz";
                        }
                    } else {
                        c1227c2.f4138e = "Core " + i + ":" + getString(C1082R.string.sleep);
                        c1227c2.f4139f = getString(C1082R.string.sleep);
                    }
                    arrayList.add(c1227c2);
                } catch (Exception e) {
                }
                i++;
            }
            try {
                this.f4154n = new ArrayList(arrayList);
                this.f4143b.m4869a(this.f4154n);
                m5021a(this.f4142a);
            } catch (Exception e2) {
            }
        }
    }

    private void m5027b(String str) {
        try {
            if (("0xc0f".equals(str) || "0xc07".equals(str)) && this.f4147f.f4125c != null && !this.f4147f.f4125c.equals(BuildConfig.FLAVOR)) {
                String j = C1516b.m6036j();
                boolean equalsIgnoreCase = j.equalsIgnoreCase("PowerVR SGX 544MP");
                boolean equalsIgnoreCase2 = j.equalsIgnoreCase("Mali-T628");
                boolean equalsIgnoreCase3 = j.equalsIgnoreCase("Mali-T624");
                boolean equalsIgnoreCase4 = j.equalsIgnoreCase("PowerVR Rogue Han");
                boolean equalsIgnoreCase5 = j.equalsIgnoreCase("Mali-T760");
                boolean equalsIgnoreCase6 = j.equalsIgnoreCase("PowerVR Rogue G6430");
                boolean equalsIgnoreCase7 = this.f4147f.f4125c.equalsIgnoreCase("UNIVERSAL5420");
                boolean equalsIgnoreCase8 = this.f4147f.f4125c.equalsIgnoreCase("UNIVERSAL5410");
                boolean equalsIgnoreCase9 = this.f4147f.f4125c.equalsIgnoreCase("UNIVERSAL5422");
                boolean equalsIgnoreCase10 = this.f4147f.f4125c.equalsIgnoreCase("UNIVERSAL5260");
                boolean equalsIgnoreCase11 = this.f4147f.f4125c.equalsIgnoreCase("MX3");
                boolean equalsIgnoreCase12 = this.f4147f.f4125c.equalsIgnoreCase("MT6595");
                boolean equalsIgnoreCase13 = this.f4147f.f4125c.equalsIgnoreCase("UNIVERSAL5433");
                boolean equalsIgnoreCase14 = this.f4147f.f4125c.equalsIgnoreCase("Samsung EXYNOS5433");
                boolean equalsIgnoreCase15 = this.f4147f.f4125c.equalsIgnoreCase("UNIVERSAL5430");
                boolean equalsIgnoreCase16 = this.f4147f.f4125c.equalsIgnoreCase("MT8135");
                this.f4147f.f4125c.equalsIgnoreCase("Kirin920");
                this.f4147f.f4125c.equalsIgnoreCase("Kirin925");
                this.f4147f.f4125c.equalsIgnoreCase("Kirin928");
                boolean equalsIgnoreCase17 = this.f4147f.f4125c.equalsIgnoreCase("Odin");
                if (equalsIgnoreCase && (equalsIgnoreCase11 || equalsIgnoreCase8)) {
                    this.f4147f.f4130h = "ARM Cortex-A15&A7";
                }
                if (equalsIgnoreCase2 && (equalsIgnoreCase7 || equalsIgnoreCase9 || equalsIgnoreCase15)) {
                    this.f4147f.f4130h = "ARM Cortex-A15&A7";
                }
                if (equalsIgnoreCase3 && equalsIgnoreCase10) {
                    this.f4147f.f4130h = "ARM Cortex-A15&A7";
                }
                if (equalsIgnoreCase4 && equalsIgnoreCase12) {
                    this.f4147f.f4130h = "ARM Cortex-A17&A7";
                }
                if (equalsIgnoreCase5 && (equalsIgnoreCase13 || equalsIgnoreCase14)) {
                    this.f4147f.f4130h = "ARM Cortex-A57&A53";
                }
                if (equalsIgnoreCase4 && equalsIgnoreCase16) {
                    this.f4147f.f4130h = "ARM Cortex-A15&A7";
                }
                if (equalsIgnoreCase6 && equalsIgnoreCase17) {
                    this.f4147f.f4130h = "ARM Cortex-A15&A7";
                }
            }
        } catch (Exception e) {
            MLog.m6865d(getLocalClassName(), e.toString());
        }
    }

    private String m5029c(String str) {
        for (int i = 0; i < this.f4158r.size(); i++) {
            C1377a c1377a = (C1377a) this.f4158r.get(i);
            if (c1377a.f4682a.equals(Build.MODEL)) {
                if (c1377a.f4683b == 1) {
                    this.f4147f.f4128f = "4+4";
                } else if (c1377a.f4683b == 2) {
                    this.f4147f.f4128f = MessageService.MSG_DB_NOTIFY_CLICK;
                }
            }
        }
        return this.f4147f.f4128f;
    }

    private void m5030c() {
        try {
            this.f4144c = new Handler();
            this.f4156p = Build.MODEL;
            this.f4151k = new RandomAccessFile("/proc/stat", "r");
            this.f4152l = m5034e();
            this.f4163w = new C1225a(this);
            this.f4163w.execute(new Integer[]{Integer.valueOf(0)});
        } catch (Exception e) {
            this.f4151k = null;
            MLog.m6865d("CpuInfoActivity", e.toString());
        }
    }

    private String m5031d(String str) {
        try {
            return (str.equals("pyramid") && Build.DEVICE.equals("pyramid") && Build.MANUFACTURER.equals("HTC") && Build.PRODUCT.equals("htc_pyramid")) ? "Snapdragon MSM8260 (Cortex A8)" : str.equals("Tegra 2 Development System") ? "NVIDIA Tegra 2 (Dual-Core Cortex A9)" : str.startsWith("OMAP4430 ") ? "TI OMAP4430 (Cortex A9)" : str.startsWith("OMAP4460 ") ? "TI OMAP4460 (Cortex A9)" : str;
        } catch (Exception e) {
            return str;
        }
    }

    private void m5033d() {
        int i = 0;
        this.f4147f = new C1226b(this);
        try {
            boolean equalsIgnoreCase;
            float maxDef;
            float minDef;
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            String j = C1503b.m5915c().m5952j();
            if (j == null) {
                j = BuildConfig.FLAVOR;
            }
            String str = BuildConfig.FLAVOR;
            String str2 = null;
            int i2 = 0;
            for (int i3 = 1; i3 < 100; i3++) {
                CharSequence readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains("Processor")) {
                    this.f4147f.f4123a = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("BogoMIPS")) {
                    this.f4147f.f4124b = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("Hardware")) {
                    this.f4147f.f4125c = m5031d(readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim());
                }
                if (readLine.contains("vendor_id")) {
                    this.f4147f.f4126d = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (this.f4147f.f4126d.equals("GenuineIntel") && readLine.contains("model name")) {
                    this.f4147f.f4125c = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("cpu cores")) {
                    i2 = Integer.parseInt(readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim());
                }
                if (readLine.contains("CPU part")) {
                    str2 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("model name")) {
                    this.f4147f.f4123a = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("CPU part")) {
                    str2 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    if ("0xc0f".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A15";
                    } else if ("0xc09".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A9";
                    } else if ("0xc08".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A8";
                    } else if ("0xc07".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A7";
                    } else if ("0xc05".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A5";
                    } else if ("0x06f".equals(str2) && "Adreno (TM) 420".equals(this.f4165y)) {
                        this.f4147f.f4130h = "Krait 450";
                    } else if ("0x06f".equals(str2) && "Adreno (TM) 330".equals(this.f4165y)) {
                        this.f4147f.f4130h = "Krait 400";
                    } else if ("0x06f".equals(str2) && "Adreno (TM) 320".equals(this.f4165y)) {
                        this.f4147f.f4130h = "Krait 300";
                    } else if ("0x04d".equals(str2) && "Adreno (TM) 320".equals(this.f4165y)) {
                        this.f4147f.f4130h = "Krait 300";
                    } else if ("0x04d".equals(str2) && "Adreno (TM) 305".equals(this.f4165y)) {
                        this.f4147f.f4130h = "Krait 300";
                    } else if ("0x04d".equals(str2) && "Adreno (TM) 225".equals(this.f4165y)) {
                        this.f4147f.f4130h = "Krait";
                    } else if ("0x02d".equals(str2) && "Adreno (TM) 220".equals(this.f4165y)) {
                        this.f4147f.f4130h = "Scorpion";
                    } else if ("0x00f".equals(str2) && "Adreno (TM) 205".equals(this.f4165y)) {
                        this.f4147f.f4130h = "Scorpion";
                    } else if ("0xd07".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A57";
                    } else if ("0xd03".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A53";
                    } else if ("0xc0e".equals(str2) || "0xc0d".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A17";
                    } else if ("0xc0f".equals(str2)) {
                        this.f4147f.f4130h = "ARM Cortex-A15";
                    }
                }
                if (readLine.contains("model name")) {
                    this.f4147f.f4123a = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (!this.f4149h && readLine.contains("CPU architecture")) {
                    String toLowerCase = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim().toLowerCase();
                    if (toLowerCase.toLowerCase().contains("arch64")) {
                        this.f4149h = true;
                    } else if (toLowerCase.trim().equals(MessageService.MSG_ACCS_NOTIFY_CLICK)) {
                        this.f4149h = true;
                    }
                }
                if (!this.f4149h && readLine.startsWith(Constants.KEY_FLAGS) && Pattern.matches("^flags\\s+:\\s+.*\\slm\\s.*", readLine)) {
                    this.f4149h = true;
                }
            }
            m5027b(str2);
            m5023a(str2);
            if (j.indexOf("x86") != -1) {
                this.f4147f.f4130h = "x86";
            }
            if ("0xc07 & 0xc0f".equals(str2)) {
                String j2 = C1516b.m6036j();
                if (j2 != null) {
                    equalsIgnoreCase = j2.equalsIgnoreCase("Mali-T624");
                    boolean equals = this.f4147f.f4125c.equals("Kirin920");
                    boolean equals2 = this.f4147f.f4125c.equals("Kirin925");
                    boolean equals3 = this.f4147f.f4125c.equals("Kirin928");
                    if (equals || equals2 || equals3) {
                        i = 1;
                    }
                    if ((i & equalsIgnoreCase) != 0) {
                        this.f4147f.f4130h = "ARM Cortex-A15&A7";
                    }
                }
            }
            if ("0xc07".equals(str2) || "0xc0e".equals(str2)) {
                String j3 = C1516b.m6036j();
                if (j3 != null) {
                    boolean equalsIgnoreCase2 = j3.equalsIgnoreCase("PowerVR Rogue Han");
                    equalsIgnoreCase = this.f4147f.f4125c.equals("MT6595");
                    if (equalsIgnoreCase2 && equalsIgnoreCase) {
                        this.f4147f.f4130h = "ARM Cortex-A17&A7";
                    }
                }
            }
            lineNumberReader.close();
            StringBuilder stringBuilder;
            C1226b c1226b;
            if (this.f4149h) {
                stringBuilder = new StringBuilder();
                c1226b = this.f4147f;
                c1226b.f4131i = stringBuilder.append(c1226b.f4131i).append(getString(C1082R.string.bit64)).toString();
                if (j.contains("ARMv6")) {
                    j = j.replace("ARMv6", "ARMv8");
                }
            } else {
                stringBuilder = new StringBuilder();
                c1226b = this.f4147f;
                c1226b.f4131i = stringBuilder.append(c1226b.f4131i).append(getString(C1082R.string.bit32)).toString();
            }
            if (!this.f4149h && ("0xd07".equals(str2) || "0xd03".equals(str2))) {
                this.f4147f.f4131i = getString(C1082R.string.bit64);
            }
            if (j.length() > 1) {
                if (this.f4147f.f4123a.contains("Intel") && this.f4147f.f4123a.contains("Atom")) {
                    this.f4147f.f4129g = "X86";
                    this.f4147f.f4128f = i2 + BuildConfig.FLAVOR;
                } else {
                    this.f4147f.f4128f = jni.getCpuCount() + BuildConfig.FLAVOR;
                    this.f4147f.f4123a = j;
                }
            }
            long cPUFrequency = Utils.getCPUFrequency(true);
            long cPUFrequency2 = Utils.getCPUFrequency(false);
            if (cPUFrequency == 0 && cPUFrequency == 0) {
                maxDef = ((float) jni.getMaxDef()) / 1000.0f;
                minDef = ((float) jni.getMinDef()) / 1000.0f;
            } else {
                maxDef = ((float) cPUFrequency) / 1000.0f;
                minDef = ((float) cPUFrequency2) / 1000.0f;
            }
            MLog.m6865d("fre", "fmax:" + cPUFrequency + " fmin:" + cPUFrequency2 + " min:" + minDef + " max:" + maxDef);
            if (maxDef <= 0.0f || minDef <= 0.0f) {
                if (str.length() > 0) {
                    this.f4147f.f4127e = str + " MHz";
                }
            } else if (minDef < maxDef) {
                this.f4147f.f4127e = minDef + " ~ " + maxDef + " MHz";
            } else {
                this.f4147f.f4127e = maxDef + " MHz";
            }
            this.f4147f.f4128f = m5029c(this.f4147f.f4123a);
            j = SpecialHelper.updateFilterCoreNum(this, this.f4147f.f4125c);
            if (j != null) {
                this.f4147f.f4128f = j;
            }
        } catch (FileNotFoundException e) {
            this.f4147f = null;
            MLog.m6865d("fre", e.toString());
        }
    }

    private int m5034e() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C12232(this)).length;
        } catch (Exception e) {
            return 1;
        }
    }

    private void m5038h() {
        this.f4144c = new Handler();
        if (this.f4164x == null) {
            this.f4164x = ProgressDialog.show(this, getString(C1692R.string.loading), getString(C1692R.string.please_wait), true, false);
        }
        this.f4162v = findViewById(C1082R.id.title_layout);
        this.f4142a = (ListView) findViewById(C1082R.id.cpu_list);
        this.f4142a.setEnabled(false);
        findViewById(C1082R.id.menu_back_img).setOnClickListener(new C12243(this));
        ((TextView) findViewById(C1082R.id.title_text)).setText(getString(C1082R.string.cpu_detail_info));
        this.f4155o = Build.BRAND;
        this.f4158r = C1378d.m5455a(ABenchmarkApplication.getContext()).m5456a();
        m5030c();
    }

    public int m5039a(int i) {
        try {
            return Utils.readSystemFileAsInt("/sys/devices/system/cpu/cpu" + String.valueOf(i) + "/cpufreq/scaling_cur_freq");
        } catch (Exception e) {
            return -1;
        }
    }

    public void m5040a() {
        if (NetUtils.isNetworkAvailable()) {
            String str = Build.BRAND;
            String str2 = Build.MODEL;
            String language = getResources().getConfiguration().locale.getLanguage();
            String country = getResources().getConfiguration().locale.getCountry();
            if (language != null && language.contains("zh")) {
                language = (country == null || country.contains("CN")) ? "cn" : "tw";
            }
            String h = C1516b.m6034h();
            String i = C1516b.m6035i();
            String j = C1516b.m6036j();
            String str3 = Build.DEVICE;
            String str4 = Build.MANUFACTURER;
            String j2 = C1503b.m5915c().m5952j();
            String cPUSerial = Utils.getCPUSerial();
            String versionCode = Utils.getVersionCode();
            String localMacAddressFromIp = Utils.getLocalMacAddressFromIp(this);
            int maxSet = jni.getMaxSet();
            if (maxSet == 0) {
                maxSet = jni.getMaxDef();
            }
            country = maxSet + BuildConfig.FLAVOR;
            String str5 = this.f4147f.f4125c;
            MLog.m6864d("cpuid--------" + cPUSerial);
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "model=";
            stringBuilder.append("format=").append("json").append("&").append("brand=").append(str).append("&").append(r17).append(str2).append("&").append("lan=").append(language).append("&").append("resolution=").append(h).append("&").append("glVendor=").append(i).append("&").append("glRenderer=").append(j).append("&").append("device=").append(str3).append("&").append("manufacturer=").append(str4).append("&").append("cpuinfo=").append(j2).append("&").append("cupid=").append(cPUSerial).append("&").append("softversion=").append(versionCode).append("&").append("cpuMax=").append(country).append("&").append("archivement=").append(this.f4147f.f4130h).append("&").append("str10=").append(localMacAddressFromIp).append("&").append("str2=").append(str5);
            hashMap.put("gpv", jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR));
            this.f4160t = new DownloadJob(this, "http://autovote.antutu.net/proMoudule/index.php?action=rvAntuModelUrlnew&data=1", new C1528h(), hashMap);
            this.f4160t.setDownloadJobListener(new C12221(this));
            this.f4160t.start();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m5041b() {
        /*
        r15 = this;
        r0 = r15.f4151k;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = r15.f4153m;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = r15.f4151k;	 Catch:{ Exception -> 0x0084 }
        r2 = 0;
        r0.seek(r2);	 Catch:{ Exception -> 0x0084 }
        r0 = 0;
    L_0x000f:
        r1 = r15.f4152l;	 Catch:{ Exception -> 0x0084 }
        if (r0 < r1) goto L_0x006a;
    L_0x0013:
        r0 = r15.f4145d;	 Catch:{ Exception -> 0x0084 }
        if (r0 == 0) goto L_0x001c;
    L_0x0017:
        r0 = r15.f4145d;	 Catch:{ Exception -> 0x0084 }
        r0.getUsage();	 Catch:{ Exception -> 0x0084 }
    L_0x001c:
        r0 = 0;
        r1 = r0;
    L_0x001e:
        r0 = r15.f4151k;	 Catch:{ Exception -> 0x0084 }
        r0 = r0.readLine();	 Catch:{ Exception -> 0x0084 }
        if (r0 == 0) goto L_0x00ac;
    L_0x0026:
        r2 = "set_line";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0084 }
        r3.<init>();	 Catch:{ Exception -> 0x0084 }
        r4 = "str=";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0084 }
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x0084 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0084 }
        com.antutu.utils.MLog.m6865d(r2, r3);	 Catch:{ Exception -> 0x0084 }
        r10 = new com.antutu.benchmark.activity.CpuInfoActivity$c;	 Catch:{ Exception -> 0x0084 }
        r10.<init>();	 Catch:{ Exception -> 0x0084 }
        r2 = "[ ]+";
        r0 = r0.split(r2);	 Catch:{ Exception -> 0x0084 }
        r10.f4134a = r0;	 Catch:{ Exception -> 0x0084 }
        r0 = r10.f4134a;	 Catch:{ Exception -> 0x0084 }
        r2 = 0;
        r0 = r0[r2];	 Catch:{ Exception -> 0x0084 }
        r2 = "cpu";
        r0 = r0.contains(r2);	 Catch:{ Exception -> 0x0084 }
        if (r0 != 0) goto L_0x00b0;
    L_0x0058:
        r0 = r1 + 1;
    L_0x005a:
        r1 = r15.f4150i;	 Catch:{ Exception -> 0x0084 }
        r1 = r1.size();	 Catch:{ Exception -> 0x0084 }
        if (r0 >= r1) goto L_0x0075;
    L_0x0062:
        r1 = r15.f4150i;	 Catch:{ Exception -> 0x0084 }
        r1.remove(r0);	 Catch:{ Exception -> 0x0084 }
        r0 = r0 + 1;
        goto L_0x005a;
    L_0x006a:
        r1 = r15.f4148g;	 Catch:{ Exception -> 0x0084 }
        r2 = r15.m5039a(r0);	 Catch:{ Exception -> 0x0084 }
        r1[r0] = r2;	 Catch:{ Exception -> 0x0084 }
        r0 = r0 + 1;
        goto L_0x000f;
    L_0x0075:
        r0 = r15.f4150i;	 Catch:{ Exception -> 0x0084 }
        r1 = r15.f4148g;	 Catch:{ Exception -> 0x0084 }
        r15.m5024a(r0, r1);	 Catch:{ Exception -> 0x0084 }
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ Exception -> 0x0084 }
        r1 = "unable to get cpu line";
        r0.<init>(r1);	 Catch:{ Exception -> 0x0084 }
        throw r0;	 Catch:{ Exception -> 0x0084 }
    L_0x0084:
        r0 = move-exception;
        r1 = "set_line";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "exception:";
        r2 = r2.append(r3);
        r3 = r0.toString();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.antutu.utils.MLog.m6865d(r1, r2);
        r1 = r15.getLocalClassName();
        r0 = r0.toString();
        com.antutu.utils.MLog.m6868e(r1, r0);
    L_0x00ac:
        r0 = r15.f4153m;
        goto L_0x0006;
    L_0x00b0:
        r0 = r10.f4134a;	 Catch:{ Exception -> 0x0084 }
        r2 = 4;
        r0 = r0[r2];	 Catch:{ Exception -> 0x0084 }
        r2 = 10;
        r6 = java.lang.Long.parseLong(r0, r2);	 Catch:{ Exception -> 0x0084 }
        r4 = 0;
        r2 = 1;
        r8 = r10.f4134a;	 Catch:{ Exception -> 0x0084 }
        r9 = r8.length;	 Catch:{ Exception -> 0x0084 }
        r0 = 0;
        r14 = r0;
        r0 = r2;
        r2 = r4;
        r4 = r14;
    L_0x00c6:
        if (r4 >= r9) goto L_0x00d8;
    L_0x00c8:
        r5 = r8[r4];	 Catch:{ Exception -> 0x0084 }
        if (r0 == 0) goto L_0x00d0;
    L_0x00cc:
        r0 = 0;
    L_0x00cd:
        r4 = r4 + 1;
        goto L_0x00c6;
    L_0x00d0:
        r11 = 10;
        r12 = java.lang.Long.parseLong(r5, r11);	 Catch:{ Exception -> 0x0084 }
        r2 = r2 + r12;
        goto L_0x00cd;
    L_0x00d8:
        r0 = r10.f4134a;	 Catch:{ Exception -> 0x0084 }
        r4 = 0;
        r0 = r0[r4];	 Catch:{ Exception -> 0x0084 }
        r4 = "cpu";
        r0 = r0.equals(r4);	 Catch:{ Exception -> 0x0084 }
        if (r0 == 0) goto L_0x010a;
    L_0x00e5:
        r0 = r15.f4161u;	 Catch:{ Exception -> 0x0084 }
        if (r0 != 0) goto L_0x0156;
    L_0x00e9:
        r0 = new com.antutu.benchmark.activity.CpuInfoActivity$c;	 Catch:{ Exception -> 0x0084 }
        r0.<init>();	 Catch:{ Exception -> 0x0084 }
        r15.f4161u = r0;	 Catch:{ Exception -> 0x0084 }
        r4 = r2;
        r8 = r6;
    L_0x00f2:
        r8 = r4 - r8;
        r0 = (float) r8;	 Catch:{ Exception -> 0x0084 }
        r4 = (float) r4;	 Catch:{ Exception -> 0x0084 }
        r0 = r0 / r4;
        r4 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r0 = r0 * r4;
        r0 = (int) r0;	 Catch:{ Exception -> 0x0084 }
        if (r0 <= 0) goto L_0x0102;
    L_0x00fd:
        r4 = r15.f4161u;	 Catch:{ Exception -> 0x0084 }
        r8 = (long) r0;	 Catch:{ Exception -> 0x0084 }
        r4.f4137d = r8;	 Catch:{ Exception -> 0x0084 }
    L_0x0102:
        r0 = r15.f4161u;	 Catch:{ Exception -> 0x0084 }
        r0.f4136c = r2;	 Catch:{ Exception -> 0x0084 }
        r0 = r15.f4161u;	 Catch:{ Exception -> 0x0084 }
        r0.f4135b = r6;	 Catch:{ Exception -> 0x0084 }
    L_0x010a:
        r0 = r15.f4146e;	 Catch:{ Exception -> 0x0084 }
        r11 = r0.length;	 Catch:{ Exception -> 0x0084 }
        r0 = 0;
        r14 = r0;
        r0 = r1;
        r1 = r14;
    L_0x0111:
        if (r1 >= r11) goto L_0x0175;
    L_0x0113:
        r4 = r10.f4134a;	 Catch:{ Exception -> 0x0084 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0084 }
        r5 = r15.f4146e;	 Catch:{ Exception -> 0x0084 }
        r5 = r5[r1];	 Catch:{ Exception -> 0x0084 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0084 }
        if (r4 == 0) goto L_0x0153;
    L_0x0122:
        r0 = r15.f4150i;	 Catch:{ Exception -> 0x0163 }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x0163 }
        r0 = (com.antutu.benchmark.activity.CpuInfoActivity.C1227c) r0;	 Catch:{ Exception -> 0x0163 }
    L_0x012a:
        if (r0 != 0) goto L_0x0166;
    L_0x012c:
        r0 = new com.antutu.benchmark.activity.CpuInfoActivity$c;	 Catch:{ Exception -> 0x0084 }
        r0.<init>();	 Catch:{ Exception -> 0x0084 }
        r4 = r6;
        r8 = r2;
    L_0x0133:
        r4 = r8 - r4;
        r4 = (float) r4;	 Catch:{ Exception -> 0x0084 }
        r5 = (float) r8;	 Catch:{ Exception -> 0x0084 }
        r4 = r4 / r5;
        r5 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r4 = r4 * r5;
        r4 = (int) r4;	 Catch:{ Exception -> 0x0084 }
        if (r4 <= 0) goto L_0x0141;
    L_0x013e:
        r4 = (long) r4;	 Catch:{ Exception -> 0x0084 }
        r0.f4137d = r4;	 Catch:{ Exception -> 0x0084 }
    L_0x0141:
        r0.f4136c = r2;	 Catch:{ Exception -> 0x0084 }
        r0.f4135b = r6;	 Catch:{ Exception -> 0x0084 }
        r4 = r15.f4150i;	 Catch:{ Exception -> 0x0084 }
        r4 = r4.size();	 Catch:{ Exception -> 0x0084 }
        if (r4 != r1) goto L_0x016f;
    L_0x014d:
        r4 = r15.f4150i;	 Catch:{ Exception -> 0x0084 }
        r4.add(r0);	 Catch:{ Exception -> 0x0084 }
    L_0x0152:
        r0 = r1;
    L_0x0153:
        r1 = r1 + 1;
        goto L_0x0111;
    L_0x0156:
        r0 = r15.f4161u;	 Catch:{ Exception -> 0x0084 }
        r4 = r0.f4135b;	 Catch:{ Exception -> 0x0084 }
        r8 = r6 - r4;
        r0 = r15.f4161u;	 Catch:{ Exception -> 0x0084 }
        r4 = r0.f4136c;	 Catch:{ Exception -> 0x0084 }
        r4 = r2 - r4;
        goto L_0x00f2;
    L_0x0163:
        r0 = move-exception;
        r0 = 0;
        goto L_0x012a;
    L_0x0166:
        r4 = r0.f4135b;	 Catch:{ Exception -> 0x0084 }
        r4 = r6 - r4;
        r8 = r0.f4136c;	 Catch:{ Exception -> 0x0084 }
        r8 = r2 - r8;
        goto L_0x0133;
    L_0x016f:
        r4 = r15.f4150i;	 Catch:{ Exception -> 0x0084 }
        r4.set(r1, r0);	 Catch:{ Exception -> 0x0084 }
        goto L_0x0152;
    L_0x0175:
        r1 = r0;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.benchmark.activity.CpuInfoActivity.b():int");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.cpuinfo_list);
        SystemBarTintManager.setSystemBar(this, C1082R.color.status_bar_color, false);
        this.f4165y = C1516b.m6036j();
        this.f4149h = C1503b.m5915c().m5946f();
        m5038h();
    }

    public void onDestroy() {
        try {
            this.f4144c.removeCallbacks(this.f4157q);
            if (this.f4157q != null) {
                this.f4157q.m5017a(true);
            }
            this.f4157q.wait();
            this.f4157q.interrupt();
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public void onResume() {
        try {
            if (this.f4157q == null) {
                this.f4157q = new C1228d(this);
                this.f4144c.post(this.f4157q);
            } else {
                this.f4157q.m5017a(false);
            }
        } catch (Exception e) {
        }
        super.onResume();
    }
}
