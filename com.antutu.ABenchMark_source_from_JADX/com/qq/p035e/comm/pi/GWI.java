package com.qq.p035e.comm.pi;

import android.view.View;
import com.qq.p035e.ads.appwall.GridAPPWallListener;
import com.qq.p035e.ads.cfg.DownAPPConfirmPolicy;

/* renamed from: com.qq.e.comm.pi.GWI */
public interface GWI {
    GridAPPWallListener getAdListener();

    void setAdListener(GridAPPWallListener gridAPPWallListener);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void show();

    void showRelativeTo(int i, int i2);

    void showRelativeTo(View view);
}
