package com.antutu.utils;

import android.content.Context;
import com.antutu.utils.infoc.InfocSupportContext;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.cmcm.support.C2233f;
import com.cmcm.support.C2245n;
import com.igexin.download.Downloads;
import org.android.agoo.common.AgooConstants;

public class InfocUtil {
    private static final String TAG;
    private static C2233f sInfocClient;

    static {
        TAG = InfocUtil.class.getSimpleName();
    }

    public static void antutu_act(Context context, int i) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_act");
        c2245n.m8254a(IXAdRequestInfo.ACT, i);
        c2245n.m8494a();
    }

    public static void antutu_click_infotab(Context context, int i, String str) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_click_infotab");
        c2245n.m8254a("click", i);
        c2245n.m8256a("name", str);
        c2245n.m8494a();
    }

    public static void antutu_click_testtab(Context context, int i) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_click_testtab");
        c2245n.m8254a("click", i);
        c2245n.m8494a();
    }

    public static void antutu_clickshow_infotab(Context context, int i, String str) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_clickshow_infotab");
        c2245n.m8254a("click_show", i);
        c2245n.m8256a("name", str);
        c2245n.m8494a();
    }

    public static void antutu_gp_recorder(Context context, int i) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_gp_recorder");
        c2245n.m8254a("ads", i);
        c2245n.m8494a();
    }

    public static void antutu_install(Context context, int i) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_install");
        c2245n.m8254a("install", i);
        c2245n.m8494a();
    }

    public static void antutu_notibar_active(Context context, int i, int i2, int i3, int i4) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_notibar_active");
        c2245n.m8254a("notibar", i);
        c2245n.m8254a("temp", i2);
        c2245n.m8254a("temp_health", i3);
        c2245n.m8254a("cpu_use", i4);
        c2245n.m8494a();
    }

    public static void antutu_push(Context context, int i, String str, String str2) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_push");
        c2245n.m8254a("push", i);
        c2245n.m8256a(Downloads.COLUMN_TITLE, str);
        c2245n.m8256a(AgooConstants.MESSAGE_FROM_PKG, str2);
        c2245n.m8494a();
    }

    public static void antutu_start(Context context, int i) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_start");
        c2245n.m8254a("start", i);
        c2245n.m8494a();
    }

    public static void antutu_tabshow(Context context, int i) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_tabshow");
        c2245n.m8254a("tab", i);
        c2245n.m8494a();
    }

    public static void antutu_temp_finish(Context context, int i) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_temp_finish");
        c2245n.m8254a("temp_finsh", i);
        c2245n.m8494a();
    }

    public static void antutu_temp_heat(Context context, int i, int i2) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_temp_heat");
        c2245n.m8254a("temp_now", i);
        c2245n.m8254a("temp_health_now", i2);
        c2245n.m8494a();
    }

    public static void antutu_temp_main(Context context, int i, int i2) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_temp_main");
        c2245n.m8254a("temp_main", i);
        c2245n.m8254a("app_select", i2);
        c2245n.m8494a();
    }

    public static void antutu_yanji_new(Context context, int i) {
        C2245n c2245n = new C2245n(getInfocClient(context), "antutu_yanji_new");
        c2245n.m8254a("show_click", i);
        c2245n.m8494a();
    }

    private static synchronized C2233f getInfocClient(Context context) {
        C2233f c2233f;
        synchronized (InfocUtil.class) {
            if (sInfocClient == null) {
                sInfocClient = new C2233f();
                sInfocClient.m8417a(new InfocSupportContext(context));
            }
            c2233f = sInfocClient;
        }
        return c2233f;
    }
}
