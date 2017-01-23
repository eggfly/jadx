package com.baidu.mobads.openad.p097f;

import java.util.TimerTask;

/* renamed from: com.baidu.mobads.openad.f.b */
class C2026b extends TimerTask {
    final /* synthetic */ C2025a f7067a;

    C2026b(C2025a c2025a) {
        this.f7067a = c2025a;
    }

    public void run() {
        if (this.f7067a.f7066h.get() == 0) {
            if (this.f7067a.f7061b != null) {
                this.f7067a.f7064f = this.f7067a.f7062d - this.f7067a.f7063e;
                this.f7067a.f7061b.onTimer(this.f7067a.f7064f);
            }
            if (this.f7067a.f7063e > 0) {
                this.f7067a.f7063e = this.f7067a.f7063e - 1;
                return;
            }
            this.f7067a.stop();
            if (this.f7067a.f7061b != null) {
                this.f7067a.f7061b.onTimerComplete();
            }
        }
    }
}
