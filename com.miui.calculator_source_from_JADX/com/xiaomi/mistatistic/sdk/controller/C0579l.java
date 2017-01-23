package com.xiaomi.mistatistic.sdk.controller;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.CustomSettings;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.controller.asyncjobs.C0545b;
import com.xiaomi.mistatistic.sdk.controller.asyncjobs.C0545b.C0543a;
import com.xiaomi.mistatistic.sdk.controller.asyncjobs.C0548c;
import com.xiaomi.mistatistic.sdk.controller.asyncjobs.C0548c.C0547a;
import com.xiaomi.mistatistic.sdk.data.C0606g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.l */
public class C0579l {
    private static AtomicBoolean f4766a;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.l.1 */
    class C05741 implements C0543a {
        final /* synthetic */ C0579l f4757a;

        C05741(C0579l c0579l) {
            this.f4757a = c0579l;
        }

        public void m6453a(String str, long j, long j2, int i) {
            if (TextUtils.isEmpty(str)) {
                C0579l.f4766a.set(false);
                C0566h.m6415a("RDUM", "packing completed with empty data, set Uploading " + C0579l.f4766a.get());
                return;
            }
            this.f4757a.m6463a(str, j, j2, i);
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.l.2 */
    class C05752 implements C0547a {
        final /* synthetic */ long f4758a;
        final /* synthetic */ long f4759b;
        final /* synthetic */ C0579l f4760c;

        C05752(C0579l c0579l, long j, long j2) {
            this.f4760c = c0579l;
            this.f4758a = j;
            this.f4759b = j2;
        }

        public void m6454a(boolean z) {
            if (z) {
                this.f4760c.m6459a(this.f4758a, this.f4759b);
                return;
            }
            C0579l.f4766a.set(false);
            C0566h.m6415a("RDUM", "upload failed, set Uploading " + C0579l.f4766a.get());
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.l.3 */
    class C05763 implements C0523a {
        final /* synthetic */ long f4761a;
        final /* synthetic */ long f4762b;
        final /* synthetic */ C0579l f4763c;

        C05763(C0579l c0579l, long j, long j2) {
            this.f4763c = c0579l;
            this.f4761a = j;
            this.f4762b = j2;
        }

        public void m6455a() {
            try {
                new C0559f().m6380a(this.f4761a, this.f4762b);
            } catch (Throwable th) {
                C0566h.m6416a("RDUM", "doDeleting exception: ", th);
            }
            C0579l.f4766a.set(false);
            C0566h.m6415a("RDUM", "delete done, set Uploading " + C0579l.f4766a.get());
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.l.4 */
    class C05774 implements C0523a {
        final /* synthetic */ C0579l f4764a;

        C05774(C0579l c0579l) {
            this.f4764a = c0579l;
        }

        public void m6456a() {
            this.f4764a.m6469g();
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.l.a */
    public class C0578a implements C0523a {
        final /* synthetic */ C0579l f4765a;

        public C0578a(C0579l c0579l) {
            this.f4765a = c0579l;
        }

        public void m6457a() {
            this.f4765a.m6471a(false);
        }
    }

    static {
        f4766a = new AtomicBoolean(false);
    }

    public void m6470a() {
        m6471a(true);
    }

    public void m6471a(boolean z) {
        if (CustomSettings.m6255c()) {
            C0566h.m6414a("trigger upload job with retry: " + z);
            if (f4766a.compareAndSet(false, true)) {
                C0566h.m6425d("upload job start, set Uploading " + f4766a.get());
                if (C0579l.m6465c()) {
                    m6468f();
                    m6467e();
                    C0596p.m6514a().m6520d();
                    return;
                }
                f4766a.set(false);
                C0566h.m6425d("upload is not allowed by the server. set Uploading " + f4766a.get());
                return;
            } else if (z) {
                C0566h.m6414a(String.format("sUploading %s, trigger uploading job with delay %d", new Object[]{Boolean.valueOf(f4766a.get()), Long.valueOf(10000)}));
                C0555d.m6362a().m6366a(new C0578a(this), 10000);
                return;
            } else {
                return;
            }
        }
        C0566h.m6418a("upload is disabled.", null);
    }

    public static boolean m6464b() {
        return f4766a.get();
    }

    private void m6467e() {
        C0555d.m6362a().m6365a(new C0545b(C0596p.m6514a().m6522f(), new C05741(this)));
    }

    private void m6463a(String str, long j, long j2, int i) {
        C0555d.m6364b().m6365a(new C0548c(str, new C05752(this, j, j2), i));
    }

    private void m6459a(long j, long j2) {
        C0555d.m6362a().m6365a(new C05763(this, j, j2));
    }

    private void m6468f() {
        C0555d.m6362a().m6365a(new C05774(this));
    }

    private void m6469g() {
        try {
            if (CustomSettings.m6257e() && VERSION.SDK_INT <= 21) {
                Iterable arrayList = new ArrayList();
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) C0551c.m6352a().getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.importance == 100) {
                            arrayList.add(runningAppProcessInfo.processName);
                        }
                    }
                    LocalEventRecorder.m6297a(new C0606g("mistat_basic", "foreground_package", TextUtils.join(",", arrayList)));
                }
            }
        } catch (Throwable th) {
            C0566h.m6418a("", th);
        }
    }

    public static void m6458a(long j) {
        C0573k.m6451b(C0551c.m6352a(), "next_upload_ts", System.currentTimeMillis() + j);
        C0566h.m6417a("RDUM", "update next upload time to %d according to server delay %dms", Long.valueOf(r0), Long.valueOf(j));
    }

    public static boolean m6465c() {
        return System.currentTimeMillis() > C0573k.m6444a(C0551c.m6352a(), "next_upload_ts", 0);
    }
}
