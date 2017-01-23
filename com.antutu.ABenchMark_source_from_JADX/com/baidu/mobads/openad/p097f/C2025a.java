package com.baidu.mobads.openad.p097f;

import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer.EventHandler;
import com.baidu.mobads.p080j.C1991m;
import com.taobao.accs.ErrorCode;
import com.umeng.message.proguard.C4233j;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.baidu.mobads.openad.f.a */
public class C2025a implements IOAdTimer {
    private static String f7059c;
    protected int f7060a;
    private EventHandler f7061b;
    private int f7062d;
    private int f7063e;
    private int f7064f;
    private Timer f7065g;
    private AtomicInteger f7066h;

    static {
        f7059c = "OAdTimer";
    }

    public C2025a(int i) {
        this(i, ErrorCode.APP_NOT_BIND);
    }

    public C2025a(int i, int i2) {
        this.f7060a = ErrorCode.APP_NOT_BIND;
        this.f7060a = i2;
        int i3 = i / this.f7060a;
        C1991m.m7449a().m7457f().m7402i(f7059c, "RendererTimer(duration=" + i3 + C4233j.f14397t);
        this.f7062d = i3;
        this.f7063e = i3;
        this.f7065g = new Timer();
        this.f7066h = new AtomicInteger(-1);
    }

    public int getCurrentCount() {
        return this.f7064f;
    }

    public int getRepeatCount() {
        return this.f7062d;
    }

    public void pause() {
        C1991m.m7449a().m7457f().m7402i(f7059c, "pause");
        this.f7066h.set(1);
    }

    public void reset() {
        C1991m.m7449a().m7457f().m7402i(f7059c, "reset");
        this.f7066h.set(-1);
        this.f7063e = this.f7062d;
    }

    public void resume() {
        C1991m.m7449a().m7457f().m7402i(f7059c, "resume");
        this.f7066h.set(0);
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.f7061b = eventHandler;
    }

    public void start() {
        C1991m.m7449a().m7457f().m7402i(f7059c, "start");
        this.f7066h.set(0);
        this.f7065g.scheduleAtFixedRate(new C2026b(this), 0, (long) this.f7060a);
    }

    public void stop() {
        C1991m.m7449a().m7457f().m7402i(f7059c, "stop");
        this.f7066h.set(2);
        if (this.f7065g != null) {
            this.f7065g.purge();
            this.f7065g.cancel();
            this.f7065g = null;
        }
    }
}
