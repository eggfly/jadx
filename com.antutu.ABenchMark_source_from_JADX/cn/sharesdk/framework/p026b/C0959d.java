package cn.sharesdk.framework.p026b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.p026b.p027a.C0947e;
import cn.sharesdk.framework.p026b.p028b.C0949c;
import cn.sharesdk.framework.p026b.p028b.C0953e;
import cn.sharesdk.framework.p026b.p028b.C0956g;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.commons.SHARESDK;
import com.mob.commons.appcollector.PackageCollector;
import com.mob.commons.appcollector.RuntimeCollector;
import com.mob.commons.deviceinfo.DeviceInfoCollector;
import com.mob.commons.iosbridge.UDPServer;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.umeng.analytics.C4156a;
import java.io.File;
import java.util.Calendar;
import org.android.spdy.SpdyProtocol;

/* renamed from: cn.sharesdk.framework.b.d */
public class C0959d extends SSDKHandlerThread {
    private static C0959d f3278a;
    private Context f3279b;
    private DeviceHelper f3280c;
    private C0948a f3281d;
    private String f3282e;
    private Handler f3283f;
    private boolean f3284g;
    private int f3285h;
    private boolean f3286i;
    private long f3287j;
    private boolean f3288k;
    private File f3289l;
    private FileLocker f3290m;

    private C0959d(Context context, String str) {
        this.f3279b = context;
        this.f3282e = str;
        this.f3280c = DeviceHelper.getInstance(context);
        this.f3281d = C0948a.m4158a(context, str);
        this.f3290m = new FileLocker();
        this.f3289l = new File(context.getFilesDir(), ".statistics");
        if (!this.f3289l.exists()) {
            try {
                this.f3289l.createNewFile();
            } catch (Throwable e) {
                C0979d.m4390a().m4376d(e);
            }
        }
    }

    public static synchronized C0959d m4258a(Context context, String str) {
        C0959d c0959d = null;
        synchronized (C0959d.class) {
            if (f3278a == null) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        f3278a = new C0959d(context.getApplicationContext(), str);
                    }
                }
            }
            c0959d = f3278a;
        }
        return c0959d;
    }

    private void m4259a() {
        boolean b = m4261b();
        if (b) {
            if (!this.f3288k) {
                this.f3288k = b;
                this.f3287j = System.currentTimeMillis();
                m4265a(new C0956g());
            }
        } else if (this.f3288k) {
            this.f3288k = b;
            long currentTimeMillis = System.currentTimeMillis() - this.f3287j;
            C0949c c0953e = new C0953e();
            c0953e.f3247a = currentTimeMillis;
            m4265a(c0953e);
        }
    }

    private void m4260b(C0949c c0949c) {
        c0949c.f3222f = this.f3280c.getDeviceKey();
        c0949c.f3223g = this.f3282e;
        c0949c.f3224h = this.f3280c.getPackageName();
        c0949c.f3225i = this.f3280c.getAppVersion();
        c0949c.f3226j = String.valueOf(60000 + this.f3285h);
        c0949c.f3227k = this.f3280c.getPlatformCode();
        c0949c.f3228l = this.f3280c.getDetailNetworkTypeForStatic();
        if (TextUtils.isEmpty(this.f3282e)) {
            System.err.println("Your appKey of ShareSDK is null , this will cause its data won't be count!");
        } else if (!"cn.sharesdk.demo".equals(c0949c.f3224h) && ("api20".equals(this.f3282e) || "androidv1101".equals(this.f3282e))) {
            System.err.println("Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
        }
        c0949c.f3229m = this.f3280c.getDeviceData();
    }

    private boolean m4261b() {
        DeviceHelper instance = DeviceHelper.getInstance(this.f3279b);
        String topTaskPackageName = instance.getTopTaskPackageName();
        String packageName = instance.getPackageName();
        return packageName != null && packageName.equals(topTaskPackageName);
    }

    private void m4262c(C0949c c0949c) {
        try {
            this.f3281d.m4171a(c0949c);
            c0949c.m4183b(this.f3279b);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            C0979d.m4390a().m4375d(c0949c.toString(), new Object[0]);
        }
    }

    public void m4263a(int i) {
        this.f3285h = i;
    }

    public void m4264a(Handler handler) {
        this.f3283f = handler;
    }

    public void m4265a(C0949c c0949c) {
        if (this.f3286i) {
            m4260b(c0949c);
            if (c0949c.m4181a(this.f3279b)) {
                Message message = new Message();
                message.what = 3;
                message.obj = c0949c;
                try {
                    this.handler.sendMessage(message);
                    return;
                } catch (Throwable th) {
                    C0979d.m4390a().m4376d(th);
                    return;
                }
            }
            C0979d.m4390a().m4375d("Drop event: " + c0949c.toString(), new Object[0]);
        }
    }

    public void m4266a(boolean z) {
        this.f3284g = z;
    }

    protected void onMessage(Message message) {
        switch (message.what) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m4259a();
                try {
                    this.handler.sendEmptyMessageDelayed(1, 5000);
                } catch (Throwable th) {
                    C0979d.m4390a().m4376d(th);
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                try {
                    this.f3281d.m4176c();
                } catch (Throwable th2) {
                    C0979d.m4390a().m4376d(th2);
                }
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (message.obj != null) {
                    m4262c((C0949c) message.obj);
                    this.handler.removeMessages(2);
                    this.handler.sendEmptyMessageDelayed(2, 10000);
                }
            case SpdyProtocol.QUIC /*4*/:
                long longValue = C0947e.m4134a(this.f3279b).m4153f().longValue();
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(longValue);
                int i = instance.get(1);
                int i2 = instance.get(2);
                int i3 = instance.get(5);
                instance.setTimeInMillis(System.currentTimeMillis());
                int i4 = instance.get(1);
                int i5 = instance.get(2);
                int i6 = instance.get(5);
                if (!(i == i4 && i2 == i5 && i3 == i6)) {
                    this.f3281d.m4175b();
                }
                this.handler.sendEmptyMessageDelayed(4, C4156a.f13949k);
            default:
        }
    }

    protected void onStart(Message message) {
        if (!this.f3286i) {
            this.f3286i = true;
            try {
                this.f3290m.setLockFile(this.f3289l.getAbsolutePath());
                if (this.f3290m.lock(false)) {
                    this.f3281d.m4170a();
                    this.f3281d.m4175b();
                    SHARESDK.setAppKey(this.f3282e);
                    new SHARESDK().getDuid(this.f3279b);
                    DeviceInfoCollector.startCollector(this.f3279b);
                    PackageCollector.startCollector(this.f3279b);
                    RuntimeCollector.startCollector(this.f3279b);
                    UDPServer.start(this.f3279b);
                    this.handler.sendEmptyMessageDelayed(4, C4156a.f13949k);
                    this.f3281d.m4173a(this.f3284g);
                    this.handler.sendEmptyMessage(1);
                    this.handler.sendEmptyMessage(2);
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
    }

    protected void onStop(Message message) {
        if (this.f3286i) {
            long currentTimeMillis = System.currentTimeMillis() - this.f3287j;
            C0949c c0953e = new C0953e();
            c0953e.f3247a = currentTimeMillis;
            m4265a(c0953e);
            this.f3286i = false;
            try {
                this.f3283f.sendEmptyMessage(1);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
            f3278a = null;
            this.handler.getLooper().quit();
        }
    }
}
