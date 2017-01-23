package com.qq.p035e.ads.appwall;

import android.content.Context;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.pi.AWI;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.appwall.APPWall */
public class APPWall {
    private AWI f13382a;

    public APPWall(Context context, String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.m16600e(String.format("APPWall ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, context}));
        } else if (!C4048a.m16538a(context)) {
            GDTLogger.m16600e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
        } else if (GDTADManager.getInstance().initWith(context, str)) {
            try {
                this.f13382a = GDTADManager.getInstance().getPM().getPOFactory().getAppWallView(context, str, str2);
            } catch (Throwable e) {
                GDTLogger.m16601e("Exception while init APPWall plugin", e);
            }
        } else {
            GDTLogger.m16600e("Fail to init ADManager");
        }
    }

    public void doShowAppWall() {
        if (this.f13382a != null) {
            this.f13382a.showAppWall();
        }
    }

    public void prepare() {
        if (this.f13382a != null) {
            this.f13382a.prepare();
        }
    }

    public void setScreenOrientation(int i) {
        if (this.f13382a != null) {
            this.f13382a.setScreenOrientation(i);
        }
    }
}
