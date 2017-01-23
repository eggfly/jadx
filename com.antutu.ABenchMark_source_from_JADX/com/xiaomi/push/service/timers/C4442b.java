package com.xiaomi.push.service.timers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.timers.C4441a.C4440a;
import com.xiaomi.smack.C4467j;

/* renamed from: com.xiaomi.push.service.timers.b */
class C4442b implements C4440a {
    private PendingIntent f15157a;
    private Context f15158b;
    private volatile long f15159c;

    public C4442b(Context context) {
        this.f15157a = null;
        this.f15158b = null;
        this.f15159c = 0;
        this.f15158b = context;
    }

    private void m18359a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class}).invoke(alarmManager, new Object[]{Integer.valueOf(0), Long.valueOf(j), pendingIntent});
        } catch (Throwable e) {
            C4302b.m17651a(e);
        }
    }

    public void m18360a() {
        if (this.f15157a != null) {
            ((AlarmManager) this.f15158b.getSystemService(NotificationCompatApi21.CATEGORY_ALARM)).cancel(this.f15157a);
            this.f15157a = null;
            C4302b.m17653c("unregister timer");
        }
        this.f15159c = 0;
    }

    public void m18361a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f15158b.getSystemService(NotificationCompatApi21.CATEGORY_ALARM);
        this.f15157a = PendingIntent.getBroadcast(this.f15158b, 0, intent, 0);
        if (VERSION.SDK_INT >= 19) {
            m18359a(alarmManager, j, this.f15157a);
        } else {
            alarmManager.set(0, j, this.f15157a);
        }
        C4302b.m17653c("register timer " + j);
    }

    public void m18362a(boolean z) {
        long c = (long) C4467j.m18506c();
        if (z || this.f15159c != 0) {
            if (z) {
                m18360a();
            }
            if (z || this.f15159c == 0) {
                this.f15159c = (c - (SystemClock.elapsedRealtime() % c)) + System.currentTimeMillis();
            } else {
                this.f15159c += c;
                if (this.f15159c < System.currentTimeMillis()) {
                    this.f15159c = c + System.currentTimeMillis();
                }
            }
            Intent intent = new Intent(aa.f14991o);
            intent.setPackage(this.f15158b.getPackageName());
            m18361a(intent, this.f15159c);
        }
    }

    public boolean m18363b() {
        return this.f15159c != 0;
    }
}
