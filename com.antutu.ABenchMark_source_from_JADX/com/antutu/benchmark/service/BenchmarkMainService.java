package com.antutu.benchmark.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.p043g.C1502a;
import com.antutu.benchmark.receiver.C1602a;
import com.antutu.benchmark.receiver.KeepAliveReceiver;
import com.antutu.redacc.activity.AccelerateActivity;
import com.antutu.redacc.p067f.C1745b;
import com.antutu.utils.CPUCoreInfo;
import com.antutu.utils.DateUtil;
import com.antutu.utils.DeviceInfoUtil;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.NotificationUtil;
import com.antutu.utils.process.DaemonUtil;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class BenchmarkMainService extends Service {
    private static final String f5633a;
    private static C1602a f5634g;
    private CPUCoreInfo f5635b;
    private double f5636c;
    private int f5637d;
    private int f5638e;
    private boolean f5639f;
    private C1610a f5640h;
    private boolean f5641i;

    /* renamed from: com.antutu.benchmark.service.BenchmarkMainService.1 */
    class C16081 implements Runnable {
        final /* synthetic */ BenchmarkMainService f5631a;

        C16081(BenchmarkMainService benchmarkMainService) {
            this.f5631a = benchmarkMainService;
        }

        public void run() {
            Context applicationContext = this.f5631a.getApplicationContext();
            Map hashMap = new HashMap();
            hashMap.put("app", "com.antutu.ABenchMark");
            hashMap.put(Constants.SP_KEY_VERSION, "6.3.3");
            hashMap.put("did", DeviceInfoUtil.getAndroidId(this.f5631a.getApplicationContext()));
            hashMap.put(C4209a.f14201d, "99999");
            new DaemonUtil().setupDaemon(applicationContext, hashMap);
        }
    }

    /* renamed from: com.antutu.benchmark.service.BenchmarkMainService.2 */
    class C16092 implements Runnable {
        final /* synthetic */ BenchmarkMainService f5632a;

        C16092(BenchmarkMainService benchmarkMainService) {
            this.f5632a = benchmarkMainService;
        }

        public void run() {
            if (!this.f5632a.f5639f) {
                this.f5632a.m6361f();
            }
        }
    }

    public static class InnerService extends Service {
        public static Intent m6342a(Context context) {
            return new Intent(context, InnerService.class);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            startForeground(1, new Notification());
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
    }

    /* renamed from: com.antutu.benchmark.service.BenchmarkMainService.a */
    private static class C1610a extends Handler {
        private C1610a() {
        }

        public void handleMessage(Message message) {
        }
    }

    static {
        f5633a = BenchmarkMainService.class.getSimpleName();
        f5634g = null;
    }

    public BenchmarkMainService() {
        this.f5635b = null;
        this.f5636c = 0.0d;
        this.f5637d = 1;
        this.f5638e = 0;
        this.f5639f = false;
        this.f5641i = false;
    }

    public static Intent m6343a() {
        return m6346a("KeepAliveService.action.Daemon");
    }

    public static Intent m6344a(Context context) {
        return m6345a(context, "KeepAliveService.action.Alarm");
    }

    private static Intent m6345a(Context context, String str) {
        Intent intent = new Intent(context, BenchmarkMainService.class);
        intent.setAction(str);
        return intent;
    }

    private static Intent m6346a(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.antutu.ABenchMark", BenchmarkMainService.class.getName());
        intent.setAction(str);
        return intent;
    }

    private void m6347a(int i) {
        MLog.m6871i(f5633a, "Present alive\uff0c pSource = " + i);
        InfocUtil.antutu_act(this, i);
        C1502a.m5909b(this);
    }

    private void m6348a(Intent intent) {
        startService(m6369m(getApplicationContext()));
    }

    public static Intent m6350b(Context context) {
        return m6345a(context, "KeepAliveService.action.ReceiverAlarm");
    }

    private void m6351b() {
        if (VERSION.SDK_INT >= 21) {
            Builder builder = new Builder(0, new ComponentName(getApplication(), JobSchedulerService.class));
            builder.setPeriodic(600000);
            builder.setPersisted(true);
            ((JobScheduler) getSystemService("jobscheduler")).schedule(builder.build());
            return;
        }
        PendingIntent service = PendingIntent.getService(this, 0, m6344a((Context) this), 134217728);
        AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompatApi21.CATEGORY_ALARM);
        alarmManager.cancel(service);
        alarmManager.setRepeating(0, System.currentTimeMillis() + 600000, 600000, service);
    }

    private void m6352b(Intent intent) {
        if (C1502a.m5912e(this)) {
            if (this.f5635b == null) {
                this.f5635b = new CPUCoreInfo();
                m6361f();
            }
            this.f5636c = ((double) C1745b.m6737a((Context) this).m6741a(intent.getIntExtra("temperature", (int) (this.f5636c * 10.0d)))) * 0.1d;
            this.f5637d = intent.getIntExtra("health", this.f5637d);
            if (this.f5636c > 35.0d) {
                InfocUtil.antutu_temp_heat(this, (int) (this.f5636c * 10.0d), this.f5637d);
            }
            NotificationUtil.getInstance().showCoolingNotification(this, this.f5636c, this.f5638e);
            if (DateUtil.getTimeIntervalHours(C1502a.m5911d(this)) > 6) {
                InfocUtil.antutu_notibar_active(this, 1, (int) (this.f5636c * 10.0d), this.f5637d, this.f5638e);
                C1502a.m5910c(this);
                return;
            }
            return;
        }
        NotificationUtil.getInstance().hideCoolingNotification(this);
        m6363g();
    }

    public static Intent m6354c(Context context) {
        return m6345a(context, "KeepAliveService.action.Launcher");
    }

    private void m6355c() {
        if (VERSION.SDK_INT >= 21) {
            this.f5640h.postDelayed(new C16081(this), 1000);
        } else {
            this.f5640h.postDelayed(new C16081(this), 1000);
        }
    }

    public static Intent m6356d(Context context) {
        return m6345a(context, "KeepAliveService.action.PushMessage");
    }

    private void m6357d() {
        if (f5634g == null) {
            f5634g = new C1602a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action.infoc.report");
            LocalBroadcastManager.getInstance(this).registerReceiver(f5634g, intentFilter);
        }
    }

    public static Intent m6358e(Context context) {
        return m6345a(context, "KeepAliveService.action.PushMessageClick");
    }

    private void m6359e() {
        if (C1502a.m5912e(this)) {
            InfocUtil.antutu_start(this, 2);
            InfocUtil.antutu_notibar_active(this, 2, (int) (this.f5636c * 10.0d), this.f5637d, this.f5638e);
            sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            Intent intent = new Intent(this, AccelerateActivity.class);
            intent.putExtra("isLive", ABenchmarkApplication.f3647c);
            intent.setFlags(335544320);
            startActivity(intent);
        }
    }

    public static Intent m6360f(Context context) {
        return m6345a(context, "KeepAliveService.action.Connectivity");
    }

    private void m6361f() {
        this.f5635b.getInfo();
        this.f5638e = this.f5635b.getTotalUse();
        if (this.f5636c > 0.0d && C1502a.m5912e(this)) {
            NotificationUtil.getInstance().showCoolingNotification(this, this.f5636c, this.f5638e);
        }
        this.f5640h.postDelayed(new C16092(this), 10000);
    }

    public static Intent m6362g(Context context) {
        return m6345a(context, "KeepAliveService.action.Present");
    }

    private void m6363g() {
        Notification notification = new Notification();
        notification.flags = 2;
        notification.flags |= 32;
        notification.flags |= 64;
        if (VERSION.SDK_INT < 18) {
            startForeground(1, notification);
        } else if (VERSION.SDK_INT < 25) {
            startService(InnerService.m6342a(this));
            startForeground(1, notification);
        }
    }

    public static Intent m6364h(Context context) {
        return m6345a(context, "KeepAliveService.action.BootCompleted");
    }

    public static Intent m6365i(Context context) {
        return m6345a(context, "KeepAliveService.action.PowerConnected");
    }

    public static Intent m6366j(Context context) {
        return m6345a(context, "KeepAliveService.action.PowerDisconnected");
    }

    public static Intent m6367k(Context context) {
        return m6345a(context, "KeepAliveService.action.BatteryChanged");
    }

    public static Intent m6368l(Context context) {
        return m6345a(context, "KeepAliveService.action.Notification.StartCooling");
    }

    public static Intent m6369m(Context context) {
        return m6345a(context, "KeepAliveService.action.EndStart");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f5640h = new C1610a();
        if (!this.f5641i) {
            m6351b();
            this.f5641i = true;
        }
        m6355c();
        KeepAliveReceiver.m6313a(this);
        m6357d();
        m6363g();
        if (C1502a.m5912e(this)) {
            this.f5635b = new CPUCoreInfo();
            m6361f();
        }
    }

    public void onDestroy() {
        this.f5639f = true;
        KeepAliveReceiver.m6313a(this).m6316c(this);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(f5634g);
        m6348a(null);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String action = intent.getAction();
            boolean z = true;
            switch (action.hashCode()) {
                case -2123489404:
                    if (action.equals("KeepAliveService.action.Present")) {
                        z = true;
                        break;
                    }
                    break;
                case -1896797781:
                    if (action.equals("KeepAliveService.action.ReceiverAlarm")) {
                        z = true;
                        break;
                    }
                    break;
                case -1885393917:
                    if (action.equals("KeepAliveService.action.Notification.StartCooling")) {
                        z = true;
                        break;
                    }
                    break;
                case -1534246409:
                    if (action.equals("KeepAliveService.action.Launcher")) {
                        z = true;
                        break;
                    }
                    break;
                case -398677143:
                    if (action.equals("KeepAliveService.action.PowerDisconnected")) {
                        z = true;
                        break;
                    }
                    break;
                case 184923291:
                    if (action.equals("KeepAliveService.action.PowerConnected")) {
                        z = true;
                        break;
                    }
                    break;
                case 193574786:
                    if (action.equals("KeepAliveService.action.BootCompleted")) {
                        z = true;
                        break;
                    }
                    break;
                case 466435930:
                    if (action.equals("KeepAliveService.action.Alarm")) {
                        z = false;
                        break;
                    }
                    break;
                case 982558974:
                    if (action.equals("KeepAliveService.action.BatteryChanged")) {
                        z = true;
                        break;
                    }
                    break;
                case 1139267922:
                    if (action.equals("KeepAliveService.action.PushMessageClick")) {
                        z = true;
                        break;
                    }
                    break;
                case 1232246926:
                    if (action.equals("KeepAliveService.action.Connectivity")) {
                        z = true;
                        break;
                    }
                    break;
                case 1403957718:
                    if (action.equals("KeepAliveService.action.PushMessage")) {
                        z = true;
                        break;
                    }
                    break;
                case 1587465886:
                    if (action.equals("KeepAliveService.action.EndStart")) {
                        z = true;
                        break;
                    }
                    break;
                case 1650455195:
                    if (action.equals("KeepAliveService.action.Daemon")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    m6347a(8);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    m6347a(9);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    m6347a(10);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    m6347a(2);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    m6347a(33);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    m6347a(3);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    m6347a(7);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    m6347a(1);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    m6347a(4);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    m6347a(5);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    m6347a(6);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    m6347a(11);
                    break;
                case com.xiaomi.mipush.sdk.Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    m6352b(intent);
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    m6359e();
                    break;
            }
        }
        if (!this.f5641i) {
            m6351b();
            this.f5641i = true;
        }
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        m6348a(intent);
    }
}
