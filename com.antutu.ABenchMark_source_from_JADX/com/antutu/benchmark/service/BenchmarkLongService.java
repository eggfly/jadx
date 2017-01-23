package com.antutu.benchmark.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.BenchLongActivity;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.platform.C1571b;
import com.antutu.utils.CPUCoreInfo;
import com.antutu.utils.CPUCoreInfo.CpuItem;
import com.antutu.utils.Hash;
import com.antutu.utils.IO;
import com.antutu.utils.Methods;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.pushsdk.C4459R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BenchmarkLongService extends Service {
    private static boolean f5615f;
    private static ArrayList<C1607c> f5616o;
    CPUCoreInfo f5617a;
    private final int f5618b;
    private final int f5619c;
    private boolean f5620d;
    private C1606b f5621e;
    private int f5622g;
    private int f5623h;
    private int f5624i;
    private int f5625j;
    private int f5626k;
    private long f5627l;
    private boolean f5628m;
    private boolean f5629n;
    private C1605a f5630p;

    /* renamed from: com.antutu.benchmark.service.BenchmarkLongService.1 */
    class C16031 extends Thread {
        final /* synthetic */ BenchmarkLongService f5600a;

        C16031(BenchmarkLongService benchmarkLongService) {
            this.f5600a = benchmarkLongService;
        }

        public void run() {
            super.run();
            while (this.f5600a.f5628m) {
                try {
                    C16031.sleep(1000);
                    if (!this.f5600a.f5620d) {
                        C16031.sleep(1000);
                        if (!this.f5600a.f5620d) {
                            this.f5600a.m6335a(0.0d);
                            long currentTimeMillis = ((System.currentTimeMillis() - this.f5600a.f5627l) + 500) / 1000;
                            int i = (int) ((((float) currentTimeMillis) * 100.0f) / 900.0f);
                            if (i >= 100) {
                                i = 99;
                            }
                            if (!this.f5600a.f5620d) {
                                if (currentTimeMillis >= 900) {
                                    this.f5600a.f5629n = false;
                                }
                                this.f5600a.m6336a(i, ((int) ((900 - currentTimeMillis) + 59)) / 60);
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.service.BenchmarkLongService.2 */
    class C16042 extends Thread {
        final /* synthetic */ String f5601a;
        final /* synthetic */ BenchmarkLongService f5602b;

        C16042(BenchmarkLongService benchmarkLongService, String str) {
            this.f5602b = benchmarkLongService;
            this.f5601a = str;
        }

        public void run() {
            Methods.httpPost("http://interface.antutu.net/proMoudule/?action=stresstest&act=record&data=1", this.f5601a);
            super.run();
        }
    }

    /* renamed from: com.antutu.benchmark.service.BenchmarkLongService.a */
    public class C1605a extends BroadcastReceiver {
        final /* synthetic */ BenchmarkLongService f5603a;

        public C1605a(BenchmarkLongService benchmarkLongService) {
            this.f5603a = benchmarkLongService;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if ("android.intent.action.BATTERY_CHANGED".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                    int intExtra = intent.getIntExtra("level", 0);
                    this.f5603a.f5622g = (intExtra * 100) / intent.getIntExtra("scale", -1);
                    this.f5603a.f5624i = (int) ((((double) intent.getIntExtra("voltage", -1)) * 1.0d) / 10.0d);
                    this.f5603a.f5623h = (int) (((double) intent.getIntExtra("temperature", -1)) * 1.0d);
                    this.f5603a.f5625j = intent.getIntExtra(MsgConstant.KEY_STATUS, -1);
                    this.f5603a.f5626k = intent.getIntExtra("plugged", -1);
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.service.BenchmarkLongService.b */
    public class C1606b extends Thread {
        final /* synthetic */ BenchmarkLongService f5604a;

        public C1606b(BenchmarkLongService benchmarkLongService) {
            this.f5604a = benchmarkLongService;
        }

        public void m6317a() {
            this.f5604a.f5620d = true;
        }

        public void run() {
            this.f5604a.m6341c();
        }
    }

    /* renamed from: com.antutu.benchmark.service.BenchmarkLongService.c */
    public static class C1607c {
        public int f5605a;
        public List<Integer> f5606b;
        public List<Integer> f5607c;
        public int f5608d;
        public int f5609e;
        public int f5610f;
        public int f5611g;
        public int f5612h;
        public int f5613i;
        public int f5614j;

        public C1607c() {
            this.f5605a = 0;
            this.f5606b = null;
            this.f5607c = null;
            this.f5608d = -1;
            this.f5609e = -1;
            this.f5610f = -1;
            this.f5611g = -1;
            this.f5612h = -1;
            this.f5613i = 0;
            this.f5614j = 0;
        }

        public String m6318a() {
            int i;
            String str = (((((((("{ " + "\"s\":" + this.f5614j) + ",\"ts\":" + this.f5613i) + ",\"ct\":" + this.f5605a) + ",\"bs\":" + this.f5608d) + ",\"bp\":" + this.f5609e) + ",\"bl\":" + this.f5610f) + ",\"bv\":" + this.f5611g) + ",\"bt\":" + this.f5612h) + ",\"cfs\":[";
            for (i = 0; i < this.f5606b.size(); i++) {
                str = str + this.f5606b.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str.substring(0, str.length() - 1) + "],\"cts\":[";
            for (i = 0; i < this.f5607c.size(); i++) {
                str = str + this.f5607c.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            return str.substring(0, str.length() - 1) + "]}";
        }
    }

    static {
        f5615f = false;
        f5616o = new ArrayList();
    }

    public BenchmarkLongService() {
        this.f5618b = 900;
        this.f5619c = 13891;
        this.f5620d = false;
        this.f5621e = null;
        this.f5622g = -1;
        this.f5623h = -1;
        this.f5624i = -1;
        this.f5625j = -1;
        this.f5626k = -1;
        this.f5627l = 0;
        this.f5628m = false;
        this.f5629n = false;
        this.f5617a = new CPUCoreInfo();
        this.f5630p = null;
    }

    public static void m6320a(Context context) {
        try {
            context.startService(new Intent("com.antutu.benchmark.BENCHMARK_LONG_START", null, context, BenchmarkLongService.class));
        } catch (Exception e) {
        }
    }

    private void m6321a(Context context, String str) {
        try {
            new C16042(this, "gpv=" + jni.getDataSafe(("{\"os\":\"android\"," + IO.getJaonStr(context, true)) + "\"cpuinfo\":\"" + jni.getCpuInfo() + "\"}", BuildConfig.FLAVOR) + "&json=" + str).start();
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

    private void m6322a(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    public static void m6326b(Context context) {
        try {
            context.startService(new Intent("com.antutu.benchmark.BENCHMARK_LONG_STOP", null, context, BenchmarkLongService.class));
            C1503b.m5915c().m5926a(context);
        } catch (Exception e) {
        }
    }

    public static boolean m6332d() {
        return f5615f;
    }

    private void m6334e() {
        try {
            Intent intent = new Intent(this, BenchLongActivity.class);
            intent.setFlags(536870912);
            startForeground(13891, new Builder(this).setContentTitle(getString(C4459R.string.app_name)).setContentText(getString(C1082R.string.Testing)).setSmallIcon(C1082R.drawable.icon_small).setContentIntent(PendingIntent.getActivity(this, 0, intent, 0)).setOngoing(true).build());
        } catch (Exception e) {
        }
    }

    void m6335a(double d) {
        try {
            C1607c c1607c = new C1607c();
            c1607c.f5614j = (int) d;
            c1607c.f5610f = this.f5622g;
            c1607c.f5608d = this.f5625j;
            c1607c.f5609e = this.f5626k;
            c1607c.f5611g = this.f5624i;
            c1607c.f5612h = this.f5623h;
            c1607c.f5613i = (int) ((System.currentTimeMillis() - this.f5627l) / 1000);
            List<CpuItem> info = this.f5617a.getInfo();
            c1607c.f5606b = new ArrayList();
            c1607c.f5607c = new ArrayList();
            for (CpuItem cpuItem : info) {
                c1607c.f5606b.add(Integer.valueOf(cpuItem.lastFrequency));
                c1607c.f5607c.add(Integer.valueOf(cpuItem.usage_temp));
            }
            c1607c.f5605a = this.f5617a.getTotalUse();
            f5616o.add(c1607c);
        } catch (Exception e) {
        }
    }

    void m6336a(int i, int i2) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.antutu.benchmark.update.UI_LONG");
            intent.putExtra("percent", i);
            intent.putExtra("left", i2);
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
        } catch (Exception e) {
        }
    }

    void m6337a(boolean z) {
        if (z) {
            m6322a("com.antutu.benchmark.test_long.STOP");
        } else {
            m6322a("com.antutu.benchmark.test_long.FINISHED_LONG");
        }
        C1503b.m5915c().m5926a(getApplicationContext());
        System.gc();
        stopSelf();
    }

    boolean m6338a() {
        if (!this.f5620d) {
            return true;
        }
        m6337a(true);
        return false;
    }

    boolean m6339a(Context context, int i) {
        jni.benchmarkV6(context, i);
        return m6338a();
    }

    void m6340b() {
        Iterator it = f5616o.iterator();
        String str = "[";
        while (it.hasNext()) {
            str = str + ((C1607c) it.next()).m6318a() + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        String str2 = str.substring(0, str.length() - 1) + "]";
        str = getFilesDir().getAbsolutePath() + "/last_stress_result.gz";
        String str3 = str + ".hash";
        Utils.writeStringToFile(str2, str);
        Hash.fileToHashF(str, str3);
        m6321a(getApplicationContext(), str2);
    }

    void m6341c() {
        this.f5620d = false;
        Context applicationContext = getApplicationContext();
        C1571b c1571b = new C1571b();
        this.f5617a.getInfo();
        this.f5627l = System.currentTimeMillis();
        this.f5628m = true;
        this.f5629n = true;
        f5616o.clear();
        m6336a(0, 15);
        new C16031(this).start();
        while (this.f5629n) {
            if (!m6339a(applicationContext, 11)) {
                return;
            }
            if (!this.f5629n) {
                break;
            }
            m6335a(c1571b.m6215b());
            if (!m6338a()) {
                return;
            }
            if (!this.f5629n) {
                break;
            } else if (m6339a(applicationContext, 10)) {
                if (!this.f5629n) {
                    break;
                }
                m6335a(c1571b.m6215b());
                if (m6338a()) {
                    if (!this.f5629n) {
                        break;
                    }
                }
                return;
            } else {
                return;
            }
        }
        this.f5628m = false;
        m6340b();
        m6337a(false);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        jni.initPaths(getFilesDir().getAbsolutePath());
        this.f5630p = new C1605a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        registerReceiver(this.f5630p, intentFilter);
    }

    public void onDestroy() {
        try {
            jni.benchmarkStop();
        } catch (Exception e) {
        }
        try {
            if (this.f5630p != null) {
                unregisterReceiver(this.f5630p);
            }
        } catch (Exception e2) {
        }
        stopForeground(true);
        f5615f = false;
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            String action = intent.getAction();
            if (action.equals("com.antutu.benchmark.BENCHMARK_LONG_START")) {
                if (this.f5621e != null && m6332d()) {
                    return super.onStartCommand(intent, 2, i2);
                }
                f5615f = true;
                m6334e();
                this.f5621e = new C1606b(this);
                this.f5621e.start();
            } else if (action.equals("com.antutu.benchmark.BENCHMARK_LONG_STOP")) {
                stopForeground(true);
                jni.benchmarkStop();
                if (this.f5621e != null) {
                    this.f5621e.m6317a();
                }
                stopSelf();
            }
        } catch (Exception e) {
            f5615f = false;
        }
        return super.onStartCommand(intent, 2, i2);
    }
}
