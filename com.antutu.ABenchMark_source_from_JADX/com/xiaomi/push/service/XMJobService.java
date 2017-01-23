package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.reflect.C4323a;
import com.xiaomi.push.service.timers.C4441a;
import org.android.spdy.SpdyProtocol;

public class XMJobService extends Service {
    static Service f14934a;
    private IBinder f14935b;

    @TargetApi(21)
    /* renamed from: com.xiaomi.push.service.XMJobService.a */
    static class C4383a extends JobService {
        Binder f14932a;
        private Handler f14933b;

        /* renamed from: com.xiaomi.push.service.XMJobService.a.a */
        private static class C4382a extends Handler {
            JobService f14931a;

            C4382a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f14931a = jobService;
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        JobParameters jobParameters = (JobParameters) message.obj;
                        C4302b.m17649a("Job finished " + jobParameters.getJobId());
                        this.f14931a.jobFinished(jobParameters, false);
                        if (jobParameters.getJobId() == 1) {
                            C4441a.m18357a(false);
                        }
                    default:
                }
            }
        }

        C4383a(Service service) {
            this.f14932a = null;
            this.f14932a = (Binder) C4323a.m17717a((Object) this, "onBind", new Intent());
            C4323a.m17717a((Object) this, "attachBaseContext", service);
        }

        public boolean onStartJob(JobParameters jobParameters) {
            C4302b.m17649a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f14933b == null) {
                this.f14933b = new C4382a(this);
            }
            this.f14933b.sendMessage(Message.obtain(this.f14933b, 1, jobParameters));
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            C4302b.m17649a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    static {
        f14934a = null;
    }

    public XMJobService() {
        this.f14935b = null;
    }

    static Service m18018a() {
        return f14934a;
    }

    public IBinder onBind(Intent intent) {
        return this.f14935b != null ? this.f14935b : new Binder();
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 21) {
            this.f14935b = new C4383a(this).f14932a;
        }
        f14934a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        f14934a = null;
    }
}
