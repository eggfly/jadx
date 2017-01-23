package com.qq.p035e.ads.appwall;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.pi.GWI;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;

/* renamed from: com.qq.e.ads.appwall.GridAPPWall */
public final class GridAPPWall {
    private GWI f13383a;

    public GridAPPWall(Activity activity, String str, String str2, GridAPPWallListener gridAPPWallListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m16600e(String.format("GridAPPWall ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
        } else if (C4048a.m16538a((Context) activity)) {
            try {
                if (GDTADManager.getInstance().initWith(activity.getApplicationContext(), str)) {
                    this.f13383a = GDTADManager.getInstance().getPM().getPOFactory().createGridAppWallView(activity, str, str2);
                    if (this.f13383a != null) {
                        this.f13383a.setAdListener(gridAPPWallListener);
                        return;
                    }
                    GDTLogger.m16600e("Fail to INIT GDT SDK");
                    GridAPPWall.m16510a(gridAPPWallListener, ErrorCode.DM_APPKEY_INVALID);
                    return;
                }
                GDTLogger.m16600e("Fail to Init GDT AD SDK,report logcat info filter by gdt_ad_mob");
                GridAPPWall.m16510a(gridAPPWallListener, Constants.COMMAND_STOP_FOR_ELECTION);
            } catch (Throwable e) {
                GDTLogger.m16601e("Fail to init new appwall plugin", e);
                GridAPPWall.m16510a(gridAPPWallListener, ErrorCode.DM_DEVICEID_INVALID);
            } catch (Throwable e2) {
                GDTLogger.m16601e("Unknown Exception", e2);
                GridAPPWall.m16510a(gridAPPWallListener, OtherError.UNKNOWN_ERROR);
            }
        } else {
            GDTLogger.m16600e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            GridAPPWall.m16510a(gridAPPWallListener, OtherError.ANDROID_PERMMISON_ERROR);
        }
    }

    private static void m16510a(GridAPPWallListener gridAPPWallListener, int i) {
        if (gridAPPWallListener != null) {
            gridAPPWallListener.onNoAD(i);
        }
    }

    public final void show() {
        if (this.f13383a != null) {
            this.f13383a.show();
        }
    }

    public final void showRelativeTo(int i, int i2) {
        if (this.f13383a != null) {
            this.f13383a.showRelativeTo(i, i2);
        }
    }

    public final void showRelativeTo(View view) {
        if (this.f13383a != null) {
            this.f13383a.showRelativeTo(view);
        }
    }
}
