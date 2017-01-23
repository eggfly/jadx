package com.xiaomi.push.service.timers;

import android.annotation.TargetApi;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.push.service.timers.C4441a.C4440a;
import com.xiaomi.smack.C4467j;

@TargetApi(21)
/* renamed from: com.xiaomi.push.service.timers.c */
public class C4443c implements C4440a {
    Context f15160a;
    JobScheduler f15161b;
    private boolean f15162c;

    C4443c(Context context) {
        this.f15162c = false;
        this.f15160a = context;
        this.f15161b = (JobScheduler) context.getSystemService("jobscheduler");
    }

    public void m18364a() {
        this.f15162c = false;
        this.f15161b.cancel(1);
    }

    void m18365a(long j) {
        Builder builder = new Builder(1, new ComponentName(this.f15160a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        C4302b.m17653c("schedule Job = " + builder.build().getId() + " in " + j);
        this.f15161b.schedule(builder.build());
    }

    public void m18366a(boolean z) {
        if (z || this.f15162c) {
            long c = (long) C4467j.m18506c();
            if (z) {
                m18364a();
                c -= SystemClock.elapsedRealtime() % c;
            }
            this.f15162c = true;
            m18365a(c);
        }
    }

    public boolean m18367b() {
        return this.f15162c;
    }
}
