package com.antutu.benchmark;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.ScoreBenchActivity;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p046j.C1513a;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.benchmark.platform.C1571b;
import com.antutu.utils.IO;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.jni;
import com.taobao.accs.ErrorCode;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.pushsdk.C4459R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import org.android.spdy.SpdyProtocol;

public class BenchmarkService extends Service {
    private static final String f3651d;
    private static boolean f3652j;
    private static boolean f3653m;
    private static boolean f3654n;
    String f3655a;
    String f3656b;
    String f3657c;
    private final int f3658e;
    private boolean f3659f;
    private boolean f3660g;
    private boolean f3661h;
    private C1088c f3662i;
    private C1086a f3663k;
    private C1506g f3664l;
    private final IBinder f3665o;

    /* renamed from: com.antutu.benchmark.BenchmarkService.a */
    private class C1086a extends BroadcastReceiver {
        final /* synthetic */ BenchmarkService f3648a;

        private C1086a(BenchmarkService benchmarkService) {
            this.f3648a = benchmarkService;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (action.equals("com.antutu.benchmark.inter.marooned.FINISHED")) {
                    this.f3648a.f3661h = false;
                    this.f3648a.f3660g = false;
                } else if (action.equals("com.antutu.benchmark.inter.3D.ERROR")) {
                    this.f3648a.f3661h = true;
                    this.f3648a.f3660g = false;
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.BenchmarkService.b */
    public class C1087b extends Binder {
        final /* synthetic */ BenchmarkService f3649a;

        public C1087b(BenchmarkService benchmarkService) {
            this.f3649a = benchmarkService;
        }

        public BenchmarkService m4807a() {
            return this.f3649a;
        }
    }

    /* renamed from: com.antutu.benchmark.BenchmarkService.c */
    public class C1088c extends Thread {
        final /* synthetic */ BenchmarkService f3650a;

        public C1088c(BenchmarkService benchmarkService) {
            this.f3650a = benchmarkService;
        }

        public void m4808a() {
            this.f3650a.f3659f = true;
        }

        public void run() {
            this.f3650a.m4837e();
        }
    }

    static {
        f3651d = BenchmarkService.class.getSimpleName();
        f3652j = false;
        f3653m = false;
        f3654n = false;
    }

    public BenchmarkService() {
        this.f3658e = 13891;
        this.f3655a = BuildConfig.FLAVOR;
        this.f3659f = false;
        this.f3660g = false;
        this.f3661h = false;
        this.f3656b = BuildConfig.FLAVOR;
        this.f3662i = null;
        this.f3663k = null;
        this.f3664l = null;
        this.f3657c = "data_guid";
        this.f3665o = new C1087b(this);
    }

    public static void m4809a(Context context) {
        try {
            C1503b.m5915c().m5928a(context, Methods.httpPost("http://autovote.antutu.net/antuapi.php?m=clientscore&c=score&a=dosubmit", "gpv=" + jni.benchmarkGetData(context, IO.getJaonStr(context))).trim());
        } catch (Exception e) {
        }
    }

    public static void m4811b(Context context) {
        try {
            context.startService(new Intent("com.antutu.benchmark.BENCHMARK_START", null, context, BenchmarkService.class));
            ScoreBenchActivity.f4411c = true;
        } catch (Exception e) {
        }
    }

    static void m4812b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void m4814c(int i) {
        Methods.editSharedPreferences("benchmark_step", (long) i);
    }

    public static void m4815c(Context context) {
        try {
            context.startService(new Intent("com.antutu.benchmark.BENCHMARK_STOP", null, context, BenchmarkService.class));
            C1503b.m5915c().m5926a(context);
        } catch (Exception e) {
        }
    }

    public static void m4816c(Context context, int i) {
        if (!f3653m) {
            if (!(4 == i || i == 0)) {
                f3653m = true;
            }
            f3654n = false;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.QUIC /*4*/:
                    f3654n = true;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    m4812b(context, "com.antutu.benchmark.inter.3D.ERROR");
                    break;
            }
            try {
                context.startService(new Intent("com.antutu.benchmark.BENCHMARK_CONTINUE", null, context, BenchmarkService.class));
            } catch (Exception e) {
            }
        }
    }

    private void m4818d(Context context) {
        C1511h c1511h = new C1511h();
        for (int i = 30; i < 41; i++) {
            Log.i("AntutuLog", c1511h.m5995a(i) + " : " + jni.benchmarkTest(context, i));
        }
        Log.i("AntutuLog", "Score_Total : " + jni.benchmarkTest(context, 41));
    }

    private void m4819d(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    private void m4820e(Context context) {
        int i;
        C1511h c1511h = new C1511h();
        String str = "{";
        for (i = 1; i <= 25; i++) {
            str = str + "\"" + c1511h.m5995a(i) + "\":" + jni.benchmarkTest(context, i) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        for (i = 30; i < 41; i++) {
            str = str + "\"" + c1511h.m5995a(i) + "\":" + jni.benchmarkTest(context, i) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        C1513a.m6000a(str + "\"Score_Total\":" + jni.benchmarkTest(context, 41) + "}");
    }

    private void m4821f(Context context) {
        try {
            if (!this.f3661h) {
                jni.benchmarkProcess3D(context, this.f3656b);
            }
        } catch (Exception e) {
        }
        m4828a(context, 24);
        m4828a(context, 23);
        m4828a(context, 9);
        m4828a(context, 21);
        m4828a(context, 22);
    }

    public static boolean m4822g() {
        return f3652j;
    }

    private void m4823h() {
        try {
            Intent intent = new Intent(this, ScoreBenchActivity.class);
            intent.setFlags(536870912);
            startForeground(13891, new Builder(this).setContentTitle(getString(C4459R.string.app_name)).setContentText(getString(C1082R.string.Testing)).setSmallIcon(C1082R.drawable.icon_small).setContentIntent(PendingIntent.getActivity(this, 0, intent, 0)).setOngoing(true).build());
        } catch (Exception e) {
        }
    }

    void m4824a() {
        Intent intent = new Intent();
        intent.setAction("com.antutu.benchmark.update.UI");
        intent.putExtra("uid", 50);
        intent.putExtra("info", BuildConfig.FLAVOR);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
        MLog.m6870i(this.f3655a);
    }

    void m4825a(int i) {
        this.f3655a = this.f3664l.m5989a(i);
        Intent intent = new Intent();
        intent.setAction("com.antutu.benchmark.update.UI");
        intent.putExtra("uid", i);
        intent.putExtra("info", this.f3655a);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
        if (C1513a.m6005c()) {
            Log.i("AntutuLog", new C1511h().m5995a(i) + " : start");
            return;
        }
        MLog.m6870i(this.f3655a);
    }

    void m4826a(String str) {
        this.f3655a = str;
        Intent intent = new Intent();
        intent.setAction("com.antutu.benchmark.update.UI");
        intent.putExtra("uid", -2);
        intent.putExtra("info", this.f3655a);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
        MLog.m6870i(this.f3655a);
    }

    void m4827a(boolean z, int i) {
        if (z) {
            MLog.m6871i(f3651d, "finish : " + i);
            m4819d("com.antutu.benchmark.test.STOP");
        } else {
            m4819d("com.antutu.benchmark.test.FINISHED");
        }
        m4814c(0);
        System.gc();
        stopSelf();
    }

    boolean m4828a(Context context, int i) {
        if (C1513a.m6005c()) {
            Log.i("AntutuLog", new C1511h().m5995a(i) + " : " + jni.benchmarkTest(context, i));
        } else {
            MLog.m6870i(this.f3664l.m5989a(i) + " : " + jni.benchmarkTest(context, i));
        }
        if (!this.f3659f) {
            return true;
        }
        MLog.m6864d("force stop");
        m4827a(true, 1);
        return false;
    }

    boolean m4829a(Context context, String str) {
        f3654n = false;
        this.f3661h = false;
        if (!C1513a.m6002a(24)) {
            return true;
        }
        this.f3660g = true;
        C1516b.m6017b(context, 0);
        Intent intent = new Intent("com.antutu.benchmark.full.MAROONED_RUN");
        intent.setFlags(335544320);
        intent.setComponent(new ComponentName("com.antutu.benchmark.full", "com.antutu.benchmark.full.UnityPlayerActivity"));
        intent.putExtra("uid", str);
        startActivity(intent);
        while (this.f3660g) {
            try {
                Thread.sleep((long) ErrorCode.APP_NOT_BIND);
            } catch (Exception e) {
            }
        }
        return !this.f3661h;
    }

    void m4830b() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }

    void m4831b(String str) {
        try {
            FileOutputStream openFileOutput = openFileOutput(this.f3657c, 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
        } catch (Exception e) {
        }
    }

    boolean m4832b(int i) {
        if (!C1513a.m6002a(i)) {
            return false;
        }
        m4830b();
        return true;
    }

    boolean m4833b(Context context, int i) {
        m4825a(i);
        if (C1513a.m6002a(i)) {
            m4830b();
            jni.benchmarkV6(context, i);
        }
        if (m4828a(context, i)) {
            return true;
        }
        jni.benchmarkCleanup();
        return false;
    }

    String m4834c() {
        String str = BuildConfig.FLAVOR;
        try {
            FileInputStream openFileInput = openFileInput(this.f3657c);
            byte[] bArr = new byte[openFileInput.available()];
            openFileInput.read(bArr);
            return new String(bArr);
        } catch (Exception e) {
            return str;
        }
    }

    void m4835c(String str) {
        Object obj;
        do {
            try {
                for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.processName.contains(str)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    try {
                        Thread.sleep(300);
                        continue;
                    } catch (Exception e) {
                        continue;
                    }
                } else if (ScoreBenchActivity.f4411c) {
                    continue;
                } else {
                    Intent intent = new Intent(this, ScoreBenchActivity.class);
                    intent.setFlags(335544320);
                    intent.putExtra("startBench", true);
                    startActivity(intent);
                    continue;
                }
            } catch (Exception e2) {
                return;
            }
        } while (obj != null);
    }

    void m4836d() {
        File file = new File(getFilesDir(), this.f3657c);
        if (file.exists()) {
            file.delete();
        }
    }

    void m4837e() {
        f3653m = false;
        this.f3659f = false;
        Context applicationContext = getApplicationContext();
        C1571b c1571b = new C1571b();
        Random random = new Random();
        this.f3656b = applicationContext.getFilesDir().getAbsolutePath();
        this.f3656b += "/95du3_data.gz";
        C1513a.m5998a();
        String str = BuildConfig.FLAVOR;
        if (f3654n) {
            str = m4834c();
            if (str.isEmpty()) {
                m4827a(true, 2);
                return;
            }
        }
        do {
            str = str + random.nextInt(9999) + BuildConfig.FLAVOR;
        } while (str.length() < 4);
        m4831b(str);
        m4838f();
        jni.benchmarkReset();
        m4814c(1);
        m4825a(24);
        C1503b c = C1503b.m5915c();
        c.m5931a(applicationContext, 0);
        if (!f3654n) {
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
            }
            if (!m4829a(applicationContext, str)) {
                m4827a(true, 3);
                return;
            }
        } else if (f3654n) {
            m4835c("com.antutu.benchmark.full");
        }
        m4821f(applicationContext);
        m4836d();
        if (jni.benchmarkTest(applicationContext, 21) > 0) {
            m4824a();
        }
        if (jni.benchmarkTest(applicationContext, 22) > 0) {
            m4824a();
        }
        if ((Methods.getAvaliableMemSize(applicationContext) <= 180 || m4833b(applicationContext, 1)) && m4833b(applicationContext, 2) && m4833b(applicationContext, 3) && m4833b(applicationContext, 4) && m4833b(applicationContext, 5)) {
            jni.benchmarkInit(applicationContext, getAssets(), 0);
            if (m4833b(applicationContext, 7)) {
                jni.benchmarkCleanup();
                if (m4833b(applicationContext, 8) && m4833b(applicationContext, 10) && m4833b(applicationContext, 11)) {
                    if (jni.benchmarkTest(applicationContext, 9) <= 0) {
                        jni.testPhysX(applicationContext);
                        if (!m4828a(applicationContext, 9)) {
                            return;
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e2) {
                    }
                    if (m4833b(applicationContext, 6)) {
                        m4825a(16);
                        if (m4832b(16)) {
                            jni.benchmarkProcessUX(applicationContext, 16, c1571b.m6218c());
                        }
                        if (m4828a(applicationContext, 16)) {
                            m4825a(14);
                            if (m4832b(14)) {
                                jni.benchmarkProcessUX(applicationContext, 14, c1571b.m6212a(applicationContext, "person_300.xml"));
                            }
                            if (m4828a(applicationContext, 14)) {
                                m4825a(15);
                                if (m4832b(15)) {
                                    jni.benchmarkProcessUX(applicationContext, 15, c1571b.m6216b(applicationContext, "public_timeline.json"));
                                }
                                if (m4828a(applicationContext, 15) && m4833b(applicationContext, 12) && m4833b(applicationContext, 25)) {
                                    m4825a(13);
                                    if (m4832b(13)) {
                                        jni.benchmarkProcessUX(applicationContext, 13, c1571b.m6211a(applicationContext));
                                    }
                                    if (m4828a(applicationContext, 13) && m4833b(applicationContext, 18)) {
                                        m4825a(17);
                                        if (m4832b(17)) {
                                            jni.benchmarkProcessUX(applicationContext, 17, c1571b.m6220d());
                                        }
                                        if (m4828a(applicationContext, 17)) {
                                            m4825a(19);
                                            if (m4832b(19)) {
                                                jni.benchmarkProcessUX(applicationContext, 19, c1571b.m6221e());
                                            }
                                            if (m4828a(applicationContext, 19)) {
                                                m4825a(20);
                                                if (m4832b(20)) {
                                                    jni.benchmarkProcessUX(applicationContext, 20, c1571b.m6219c(applicationContext, C1082R.drawable.img2test));
                                                }
                                                if (m4828a(applicationContext, 20)) {
                                                    if (jni.benchmarkTest(applicationContext, 21) <= 0) {
                                                        m4825a(21);
                                                        if (m4832b(21)) {
                                                            c1571b.m6214a(applicationContext, (int) C1082R.drawable.img2test);
                                                        }
                                                        if (!m4828a(applicationContext, 21)) {
                                                            return;
                                                        }
                                                    }
                                                    if (jni.benchmarkTest(applicationContext, 22) <= 0) {
                                                        m4825a(22);
                                                        if (m4832b(22)) {
                                                            c1571b.m6217b(applicationContext, (int) C1082R.drawable.img2test);
                                                        }
                                                        if (!m4828a(applicationContext, 22)) {
                                                            return;
                                                        }
                                                    }
                                                    c.m5931a(applicationContext, 1);
                                                    jni.benchmarkUpdateScore(applicationContext);
                                                    c.m5959m(applicationContext);
                                                    if (C1513a.m6005c()) {
                                                        m4818d(applicationContext);
                                                    }
                                                    if (C1513a.m6004b()) {
                                                        m4820e(applicationContext);
                                                    }
                                                    m4826a(BuildConfig.FLAVOR);
                                                    m4809a(applicationContext);
                                                    m4827a(false, 4);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void m4838f() {
    }

    public IBinder onBind(Intent intent) {
        return this.f3665o;
    }

    public void onCreate() {
        super.onCreate();
        jni.initPaths(getFilesDir().getAbsolutePath());
        this.f3664l = new C1506g(getApplicationContext());
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.antutu.benchmark.inter.marooned.FINISHED");
            intentFilter.addAction("com.antutu.benchmark.inter.3D.ERROR");
            this.f3663k = new C1086a();
            registerReceiver(this.f3663k, intentFilter);
        } catch (Exception e) {
            stopSelf();
        }
    }

    public void onDestroy() {
        try {
            jni.benchmarkStop();
            unregisterReceiver(this.f3663k);
        } catch (Exception e) {
        }
        stopForeground(true);
        f3652j = false;
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            String action = intent.getAction();
            if (action.equals("com.antutu.benchmark.BENCHMARK_START")) {
                if (this.f3662i != null && m4822g()) {
                    return super.onStartCommand(intent, 2, i2);
                }
                f3654n = false;
                f3652j = true;
                m4823h();
                this.f3662i = new C1088c(this);
                this.f3662i.start();
            } else if (action.equals("com.antutu.benchmark.BENCHMARK_CONTINUE")) {
                if (this.f3662i != null && m4822g()) {
                    if (f3654n) {
                        m4812b(getApplicationContext(), "com.antutu.benchmark.inter.marooned.FINISHED");
                        f3654n = false;
                    }
                    return super.onStartCommand(intent, 2, i2);
                } else if (f3654n) {
                    f3652j = true;
                    m4823h();
                    this.f3662i = new C1088c(this);
                    this.f3662i.start();
                    if (f3654n) {
                        m4812b(getApplicationContext(), "com.antutu.benchmark.inter.marooned.FINISHED");
                    }
                } else {
                    m4827a(true, 5);
                    return super.onStartCommand(intent, 2, i2);
                }
            } else if (action.equals("com.antutu.benchmark.BENCHMARK_STOP")) {
                stopForeground(true);
                jni.benchmarkStop();
                if (this.f3662i != null) {
                    this.f3662i.m4808a();
                }
                stopSelf();
            }
        } catch (Exception e) {
            f3652j = false;
        }
        return super.onStartCommand(intent, 2, i2);
    }
}
