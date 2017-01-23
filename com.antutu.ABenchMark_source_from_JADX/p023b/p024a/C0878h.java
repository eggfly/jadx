package p023b.p024a;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: b.a.h */
public class C0878h implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler f2946a;
    private C0887p f2947b;

    public C0878h() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.f2946a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void m3894a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f2947b.m3931a(th);
        } else {
            this.f2947b.m3931a(null);
        }
    }

    public void m3895a(C0887p c0887p) {
        this.f2947b = c0887p;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m3894a(th);
        if (this.f2946a != null && this.f2946a != Thread.getDefaultUncaughtExceptionHandler()) {
            this.f2946a.uncaughtException(thread, th);
        }
    }
}
