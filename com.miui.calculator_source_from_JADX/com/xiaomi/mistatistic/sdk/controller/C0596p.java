package com.xiaomi.mistatistic.sdk.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.xiaomi.mistatistic.sdk.C0534b;
import com.xiaomi.mistatistic.sdk.C0534b.C0533a;
import com.xiaomi.mistatistic.sdk.MiStatInterface;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.p */
public class C0596p {
    private static C0596p f4801a;
    private boolean f4802b;
    private int f4803c;
    private long f4804d;
    private long f4805e;
    private Handler f4806f;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.p.1 */
    class C05911 extends Handler {
        final /* synthetic */ C0596p f4794a;

        /* renamed from: com.xiaomi.mistatistic.sdk.controller.p.1.1 */
        class C05891 implements C0523a {
            final /* synthetic */ C05911 f4792a;

            C05891(C05911 c05911) {
                this.f4792a = c05911;
            }

            public void m6505a() {
                if (this.f4792a.f4794a.m6521e()) {
                    new C0579l().m6470a();
                }
            }
        }

        /* renamed from: com.xiaomi.mistatistic.sdk.controller.p.1.2 */
        class C05902 implements C0523a {
            final /* synthetic */ C05911 f4793a;

            C05902(C05911 c05911) {
                this.f4793a = c05911;
            }

            public void m6506a() {
                if (this.f4793a.f4794a.m6521e() || this.f4793a.f4794a.f4803c == 3) {
                    new C0579l().m6470a();
                }
            }
        }

        C05911(C0596p c0596p, Looper looper) {
            this.f4794a = c0596p;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    C0555d.m6362a().m6365a(new C05891(this));
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    this.f4794a.f4802b = true;
                    C0555d.m6362a().m6365a(new C05902(this));
                default:
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.p.2 */
    class C05922 implements C0523a {
        final /* synthetic */ C0596p f4795a;

        C05922(C0596p c0596p) {
            this.f4795a = c0596p;
        }

        public void m6507a() {
            Context a = C0551c.m6352a();
            this.f4795a.f4803c = C0573k.m6443a(a, "upload_policy", 4);
            if (this.f4795a.f4803c == 4) {
                this.f4795a.f4804d = C0573k.m6444a(a, "upload_interval", 180000);
            } else {
                this.f4795a.f4804d = -1;
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.p.3 */
    class C05943 implements C0523a {
        final /* synthetic */ int f4797a;
        final /* synthetic */ long f4798b;
        final /* synthetic */ C0596p f4799c;

        /* renamed from: com.xiaomi.mistatistic.sdk.controller.p.3.1 */
        class C05931 implements C0523a {
            final /* synthetic */ C05943 f4796a;

            C05931(C05943 c05943) {
                this.f4796a = c05943;
            }

            public void m6508a() {
                if (this.f4796a.f4799c.m6521e()) {
                    new C0579l().m6470a();
                }
            }
        }

        C05943(C0596p c0596p, int i, long j) {
            this.f4799c = c0596p;
            this.f4797a = i;
            this.f4798b = j;
        }

        public void m6509a() {
            this.f4799c.f4803c = this.f4797a;
            if (this.f4799c.f4803c == 4) {
                this.f4799c.f4804d = this.f4798b;
            } else {
                this.f4799c.f4804d = -1;
            }
            Context a = C0551c.m6352a();
            C0573k.m6450b(a, "upload_policy", this.f4799c.f4803c);
            if (this.f4799c.f4803c == 4) {
                C0573k.m6451b(a, "upload_interval", this.f4799c.f4804d);
                C0555d.m6362a().m6366a(new C05931(this), this.f4799c.f4804d);
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.p.4 */
    class C05954 implements C0523a {
        final /* synthetic */ C0596p f4800a;

        C05954(C0596p c0596p) {
            this.f4800a = c0596p;
        }

        public void m6510a() {
            if (MiStatInterface.m6270a() && !MiStatInterface.m6273b()) {
                for (C0533a a : C0534b.m6286b()) {
                    C0534b.m6283a(a, false);
                }
                C0534b.m6287c();
            }
        }
    }

    static {
        f4801a = null;
    }

    public static synchronized C0596p m6514a() {
        C0596p c0596p;
        synchronized (C0596p.class) {
            if (f4801a == null) {
                f4801a = new C0596p();
            }
            c0596p = f4801a;
        }
        return c0596p;
    }

    private C0596p() {
        this.f4802b = false;
        this.f4803c = 3;
        this.f4806f = new C05911(this, Looper.getMainLooper());
    }

    public void m6518b() {
        C0555d.m6362a().m6365a(new C05922(this));
        this.f4806f.sendEmptyMessageDelayed(2, 5000);
    }

    public void m6517a(int i, long j) {
        C0555d.m6362a().m6365a(new C05943(this, i, j));
    }

    public void m6519c() {
        try {
            if (!this.f4806f.hasMessages(1)) {
                if (this.f4803c == 4) {
                    this.f4806f.sendEmptyMessageDelayed(1, this.f4804d);
                    C0566h.m6415a("UPE", "onEventRecorded, no MESSAGE_UPLOAD_EVENT, send a msg for UPLOAD_POLICY_INTERVAL " + this.f4804d);
                } else if (this.f4803c == 0 || this.f4803c == 1) {
                    this.f4806f.sendEmptyMessageDelayed(1, 60000);
                    C0566h.m6417a("UPE", "onEventRecorded, no MESSAGE_UPLOAD_EVENT, send a msg for UPLOAD_POLICY %d with delay %dms ", Integer.valueOf(this.f4803c), Long.valueOf(60000));
                } else {
                    this.f4806f.sendEmptyMessage(1);
                    C0566h.m6415a("UPE", "onEventRecorded, no MESSAGE_UPLOAD_EVENT, send a msg for UPLOAD_POLICY " + this.f4803c);
                }
            }
        } catch (Throwable e) {
            C0566h.m6418a("onEventRecorded exception: ", e);
        }
    }

    public void m6520d() {
        this.f4805e = System.currentTimeMillis();
        C0555d.m6364b().m6365a(new C05954(this));
    }

    public boolean m6521e() {
        if (C0579l.m6464b()) {
            C0566h.m6414a("RemoteDataUploadManager isUploading, should NOT upload now");
            return false;
        }
        switch (this.f4803c) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                return true;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (C0571j.m6437a(C0551c.m6352a())) {
                    return true;
                }
                return false;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                int d = new C0559f().m6391d();
                if (!this.f4802b && d < 50) {
                    return false;
                }
                this.f4802b = false;
                return true;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f4802b && currentTimeMillis - this.f4805e <= this.f4804d) {
                    return false;
                }
                this.f4802b = false;
                return true;
            default:
                return false;
        }
    }

    public long m6522f() {
        return this.f4804d;
    }

    public int m6523g() {
        return this.f4803c;
    }
}
