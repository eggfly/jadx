package com.baidu.mobads.openad.p096e;

import com.baidu.mobads.p080j.C1989j;

/* renamed from: com.baidu.mobads.openad.e.c */
class C2023c implements Runnable {
    final /* synthetic */ C2021a f7052a;

    C2023c(C2021a c2021a) {
        this.f7052a = c2021a;
    }

    public void run() {
        try {
            if (this.f7052a.f7047g != null && this.f7052a.f7045e.getAndSet(false)) {
                this.f7052a.f7047g.disconnect();
                this.f7052a.f7047g = null;
            }
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
    }
}
