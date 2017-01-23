package com.qq.p035e.comm.managers;

import android.content.Context;
import android.os.Build.VERSION;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.constants.CustomPkgConstants;
import com.qq.p035e.comm.managers.plugin.PM;
import com.qq.p035e.comm.managers.setting.SM;
import com.qq.p035e.comm.managers.status.APPStatus;
import com.qq.p035e.comm.managers.status.DeviceStatus;
import com.qq.p035e.comm.services.C4066a;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.GDTADManager */
public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR;
    private volatile Boolean f13449a;
    private volatile Context f13450b;
    private volatile SM f13451c;
    private volatile PM f13452d;
    private volatile APPStatus f13453e;
    private volatile DeviceStatus f13454f;

    /* renamed from: com.qq.e.comm.managers.GDTADManager.a */
    static final class C4049a {
        private static GDTADManager f13448a;

        static {
            f13448a = new GDTADManager();
        }
    }

    static {
        INIT_EXECUTOR = Executors.newSingleThreadExecutor();
    }

    private GDTADManager() {
        this.f13449a = Boolean.valueOf(false);
    }

    public static GDTADManager getInstance() {
        return C4049a.f13448a;
    }

    public JSONObject buildS2SSBaseInfo() {
        if (!isInitialized()) {
            return null;
        }
        JSONObject a = C4048a.m16535a(this.f13451c);
        a.put("app", C4048a.m16536a(this.f13453e));
        a.put("c", C4048a.m16537a(this.f13454f));
        a.put("sdk", C4048a.m16534a(this.f13452d));
        return a;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f13450b;
    }

    public APPStatus getAppStatus() {
        return this.f13453e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f13454f;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public PM getPM() {
        return this.f13452d;
    }

    public SM getSM() {
        return this.f13451c;
    }

    public synchronized boolean initWith(Context context, String str) {
        boolean z;
        if (this.f13449a.booleanValue()) {
            z = true;
        } else {
            if (context != null) {
                if (!StringUtil.isEmpty(str)) {
                    try {
                        long nanoTime = System.nanoTime();
                        this.f13450b = context.getApplicationContext();
                        this.f13451c = new SM(this.f13450b);
                        this.f13452d = new PM(this.f13450b);
                        this.f13453e = new APPStatus(str, this.f13450b);
                        this.f13454f = new DeviceStatus(this.f13450b);
                        if (VERSION.SDK_INT > 7) {
                            C4066a.m16594a().m16598a(this.f13450b, this.f13451c, this.f13452d, this.f13454f, this.f13453e, nanoTime);
                        }
                        this.f13449a = Boolean.valueOf(true);
                        z = true;
                    } catch (Throwable th) {
                        GDTLogger.report("ADManager init error", th);
                        z = false;
                    }
                }
            }
            GDTLogger.m16600e("Context And APPID should Never Be NULL while init GDTADManager");
            z = false;
        }
        return z;
    }

    public boolean isInitialized() {
        return this.f13449a == null ? false : this.f13449a.booleanValue();
    }
}
