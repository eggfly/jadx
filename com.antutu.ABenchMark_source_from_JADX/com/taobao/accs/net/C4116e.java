package com.taobao.accs.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.C4144h;
import com.umeng.analytics.C4156a;
import java.util.Calendar;
import org.android.agoo.intent.IntentUtil;

/* renamed from: com.taobao.accs.net.e */
public class C4116e {
    private static C4116e f13770a;
    private static final int[] f13771b;
    private int f13772c;
    private long f13773d;
    private boolean f13774e;
    private int[] f13775f;
    private Context f13776g;
    private PendingIntent f13777h;
    private AlarmManager f13778i;
    private boolean f13779j;

    static {
        f13770a = null;
        f13771b = new int[]{270, C4156a.f13955q, 480};
    }

    private C4116e(Context context) {
        this.f13774e = false;
        this.f13775f = new int[]{0, 0, 0};
        this.f13779j = true;
        try {
            this.f13776g = context;
            this.f13772c = 0;
            this.f13773d = System.currentTimeMillis();
            this.f13778i = (AlarmManager) this.f13776g.getSystemService(NotificationCompatApi21.CATEGORY_ALARM);
            this.f13779j = C4144h.m16945b();
        } catch (Throwable th) {
            ALog.m16902e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    public static synchronized C4116e m16824a(Context context) {
        C4116e c4116e;
        synchronized (C4116e.class) {
            if (f13770a == null) {
                f13770a = new C4116e(context);
            }
            c4116e = f13770a;
        }
        return c4116e;
    }

    public synchronized void m16825a() {
        if (this.f13773d < 0) {
            this.f13773d = System.currentTimeMillis();
        }
        if (this.f13777h == null) {
            Intent intent = new Intent();
            intent.setPackage(this.f13776g.getPackageName());
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra(IntentUtil.AGOO_COMMAND, Constants.COMMAND_PING);
            this.f13777h = PendingIntent.getBroadcast(this.f13776g, 0, intent, 0);
        }
        int b = m16826b();
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("HeartbeatManager", "set " + b, new Object[0]);
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.add(13, b);
        this.f13778i.set(0, instance.getTimeInMillis(), this.f13777h);
    }

    public int m16826b() {
        int i = 270;
        if (this.f13779j) {
            i = f13771b[this.f13772c];
        }
        this.f13779j = C4144h.m16945b();
        return i;
    }

    public void m16827c() {
        this.f13773d = -1;
        if (this.f13774e) {
            int[] iArr = this.f13775f;
            int i = this.f13772c;
            iArr[i] = iArr[i] + 1;
        }
        this.f13772c = this.f13772c > 0 ? this.f13772c - 1 : 0;
        ALog.m16901d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public void m16828d() {
        this.f13773d = -1;
        ALog.m16901d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void m16829e() {
        ALog.m16901d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.f13773d <= 7199000) {
            this.f13774e = false;
            this.f13775f[this.f13772c] = 0;
        } else if (this.f13772c < f13771b.length - 1 && this.f13775f[this.f13772c] <= 2) {
            ALog.m16901d("HeartbeatManager", "upgrade", new Object[0]);
            this.f13772c++;
            this.f13774e = true;
            this.f13773d = System.currentTimeMillis();
        }
    }

    public void m16830f() {
        this.f13772c = 0;
        this.f13773d = System.currentTimeMillis();
        ALog.m16901d("HeartbeatManager", "resetLevel", new Object[0]);
    }
}
