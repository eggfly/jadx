package com.qq.p035e.comm.pi;

import com.qq.p035e.ads.cfg.DownAPPConfirmPolicy;

/* renamed from: com.qq.e.comm.pi.AWI */
public interface AWI {
    void prepare();

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setScreenOrientation(int i);

    void showAppWall();
}
