package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.C3755n;
import com.igexin.push.core.C3794a;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.util.C3923b;
import com.igexin.push.util.C3926e;
import com.igexin.push.util.EncryptUtils;
import com.igexin.sdk.p186a.C3939a;
import com.igexin.sdk.p186a.C3942d;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.message.MessageService;

public class PushService extends Service {
    private static String f13230a;
    public static Context context;
    private IPushCore f13231b;
    private final AtomicBoolean f13232c;
    private boolean f13233d;
    private boolean f13234e;
    private ServiceConnection f13235f;

    static {
        f13230a = "PushService";
    }

    public PushService() {
        this.f13232c = new AtomicBoolean(false);
        this.f13235f = new C3948d(this);
    }

    private int m16202a(Intent intent, int i, int i2) {
        if (this.f13231b == null) {
            return 1;
        }
        C3688a.m15097b(f13230a + "|inInit = true, call onServiceStartCommand...");
        return this.f13231b.onServiceStartCommand(intent, i, i2);
    }

    private void m16204a(Intent intent) {
        try {
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                Message obtain = Message.obtain();
                obtain.what = C3794a.f12730j;
                obtain.obj = intent;
                C3854f.m15859a().m15865a(obtain);
            }
        } catch (Throwable th) {
            C3688a.m15097b(f13230a + "|" + th.getMessage());
        }
    }

    private int m16207b(Intent intent, int i, int i2) {
        m16213c();
        C3688a.m15097b(f13230a + "|start from initialize...");
        m16208b();
        return this.f13231b != null ? this.f13231b.onServiceStartCommand(intent, i, i2) : 1;
    }

    private void m16208b() {
        C3688a.m15097b(f13230a + "|startPushCore ++++");
        if (EncryptUtils.isLoadSuccess()) {
            C3939a.m16217a().m16219a((Context) this);
            this.f13231b = C3939a.m16217a().m16220b();
            if (this.f13231b != null) {
                this.f13231b.start(this);
                return;
            }
            return;
        }
        C3923b.m16150a(new C3947c(this), this);
    }

    private int m16211c(Intent intent, int i, int i2) {
        if (m16216f()) {
            m16213c();
            m16204a(intent);
            m16208b();
            if (this.f13231b != null) {
                return this.f13231b.onServiceStartCommand(intent, i, i2);
            }
        }
        C3688a.m15097b(f13230a + "|isNeedLook = " + C3754m.f12679w);
        C3688a.m15097b(f13230a + "|start by guard, firstInit = true or (ss = 1 switchOn = false), stop");
        stopSelf();
        return 1;
    }

    private void m16213c() {
        try {
            C3688a.m15097b(f13230a + "|bind PushServiceUser");
            bindService(new Intent(this, PushServiceUser.class), this.f13235f, 1);
        } catch (Throwable th) {
            C3688a.m15097b(f13230a + th.getMessage());
        }
    }

    private void m16214d() {
        try {
            C3688a.m15097b(f13230a + "| stop PushServiceUser");
            this.f13233d = true;
            unbindService(this.f13235f);
        } catch (Throwable th) {
            C3688a.m15097b(f13230a + th.getMessage());
        }
    }

    private int m16215e() {
        C3688a.m15097b(f13230a + "|intent = null");
        if (!this.f13232c.getAndSet(true)) {
            m16213c();
            m16208b();
        }
        return 1;
    }

    private boolean m16216f() {
        C3755n.m15413a((Context) this);
        return !C3926e.m16160a((Context) this) && ((!MessageService.MSG_DB_NOTIFY_REACHED.equals(C3855g.m15893c().get("ss")) || new C3942d(this).m16228c()) && C3754m.f12679w);
    }

    public IBinder onBind(Intent intent) {
        return this.f13231b != null ? this.f13231b.onServiceBind(intent) : null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        if (this.f13231b != null) {
            this.f13231b.onServiceDestroy();
        }
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }

    public void onLowMemory() {
        C3688a.m15097b(f13230a + "|PushService Low Memory!");
        super.onLowMemory();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        context = this;
        if (intent == null) {
            try {
                return m16215e();
            } catch (Throwable th) {
                C3688a.m15097b(f13230a + "|" + th.getMessage());
                return 1;
            }
        }
        String stringExtra = intent.getStringExtra(PushConsts.CMD_ACTION);
        if (stringExtra != null && stringExtra.equals("stopUserService") && this.f13234e) {
            m16214d();
            return 1;
        }
        if (PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra)) {
            C3926e.m16164b((Context) this);
        }
        if (this.f13232c.get()) {
            return m16202a(intent, i, i2);
        }
        this.f13232c.set(true);
        return PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra) ? m16207b(intent, i, i2) : m16211c(intent, i, i2);
    }
}
