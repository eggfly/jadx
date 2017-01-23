package com.baidu.mobads.vo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.utils.PointMark;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p081a.C1907a;
import com.qq.p035e.comm.pi.ACTD;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.android.agoo.message.MessageService;

/* renamed from: com.baidu.mobads.vo.d */
public abstract class C2031d implements IXAdRequestInfo {
    private String f7099a;
    protected String f7100b;
    protected String f7101c;
    protected Context f7102d;
    protected Activity f7103e;
    protected SlotType f7104f;
    protected IXAdProdInfo f7105g;
    protected IXAdConstants f7106h;
    private String f7107i;
    private int f7108j;
    private int f7109k;
    private int f7110l;
    private String f7111m;
    private String f7112n;
    private int f7113o;
    private int f7114p;
    private int f7115q;
    private String f7116r;
    private String f7117s;
    private String f7118t;
    private boolean f7119u;
    private long f7120v;

    public C2031d(Context context, Activity activity, SlotType slotType) {
        this.f7101c = "TODO";
        this.f7099a = C0714a.ANDROID;
        this.f7107i = BuildConfig.FLAVOR;
        this.f7110l = C1991m.m7449a().m7467p().getAdCreativeTypeImage();
        this.f7111m = "LP,DL";
        this.f7112n = BuildConfig.FLAVOR;
        this.f7114p = 0;
        this.f7116r = BuildConfig.FLAVOR;
        this.f7117s = BuildConfig.FLAVOR;
        this.f7118t = BuildConfig.FLAVOR;
        this.f7119u = true;
        this.f7120v = System.currentTimeMillis();
        this.f7100b = BuildConfig.FLAVOR;
        this.f7106h = C1991m.m7449a().m7467p();
        Activity activity2 = null;
        if (context instanceof Activity) {
            activity2 = (Activity) context;
        }
        this.f7103e = activity2;
        if (activity2 != null) {
            context = activity2.getApplicationContext();
        }
        this.f7102d = context;
        if (this.f7103e == null && activity != null) {
            this.f7103e = activity;
        }
        this.f7104f = slotType;
        this.f7105g = new C2077b(this, this.f7104f);
        m7620c(this.f7104f.getValue());
    }

    protected abstract HashMap<String, String> m7612a();

    public void m7613a(int i) {
        this.f7108j = i;
    }

    public void m7614a(String str) {
        this.f7099a = str;
    }

    public void m7615a(boolean z) {
        this.f7119u = z;
    }

    public String m7616b() {
        HashMap e = m7624e();
        e.putAll(m7612a());
        return C1991m.m7449a().m7460i().getRequestAdUrl(this.f7100b, e);
    }

    public void m7617b(int i) {
        this.f7109k = i;
    }

    public void m7618b(String str) {
        this.f7111m = str;
    }

    public void m7619c(int i) {
        this.f7113o = i;
    }

    public void m7620c(String str) {
        this.f7112n = str;
    }

    public IXAdProdInfo m7621d() {
        return this.f7105g;
    }

    public void m7622d(int i) {
        this.f7115q = i;
    }

    public void m7623d(String str) {
        this.f7107i = str;
    }

    @TargetApi(4)
    protected HashMap<String, String> m7624e() {
        Object obj;
        String str = BuildConfig.FLAVOR;
        IXAdSystemUtils n = C1991m.m7449a().m7465n();
        IXAdCommonUtils m = C1991m.m7449a().m7464m();
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("net", BuildConfig.FLAVOR + n.getNetworkCatagory(this.f7102d));
        hashMap.put("u", "default");
        hashMap.put("ie", MessageService.MSG_DB_NOTIFY_REACHED);
        hashMap.put(IXAdRequestInfo.AD_COUNT, BuildConfig.FLAVOR + getN());
        hashMap.put(IXAdRequestInfo.MAX_TITLE_LENGTH, "512");
        hashMap.put(IXAdRequestInfo.MAX_CONTENT_LENGTH, "512");
        hashMap.put(IXAdRequestInfo.TEST_MODE, MessageService.MSG_DB_NOTIFY_REACHED);
        hashMap.put(IXAdRequestInfo.AD_TYPE, BuildConfig.FLAVOR + getAt());
        hashMap.put(IXAdRequestInfo.f6909V, m7626f() + "_" + C1907a.f6655c + "_" + "4.1.30");
        hashMap.put(IXAdRequestInfo.CS, BuildConfig.FLAVOR);
        hashMap.put(IXAdRequestInfo.PACKAGE, m.getAppPackage(this.f7102d));
        hashMap.put(IXAdRequestInfo.SDK_VALID, "sdk_8.8");
        str = m.getAppId(this.f7102d);
        hashMap.put(IXAdRequestInfo.COST_NAME, str + "_cpr");
        hashMap.put(ACTD.APPID_KEY, str);
        hashMap.put(IXAdRequestInfo.PHONE_TYPE, Build.MODEL);
        hashMap.put(IXAdRequestInfo.BRAND, n.getPhoneOSBrand());
        DisplayMetrics displayMetrics = m.getDisplayMetrics(this.f7102d);
        hashMap.put(IXAdRequestInfo.DENSITY, BuildConfig.FLAVOR + displayMetrics.density);
        hashMap.put(IXAdRequestInfo.WIDTH, BuildConfig.FLAVOR + getW());
        hashMap.put(IXAdRequestInfo.HEIGHT, BuildConfig.FLAVOR + getH());
        Rect screenRect = m.getScreenRect(this.f7102d);
        hashMap.put(IXAdRequestInfo.SCREEN_WIDTH, BuildConfig.FLAVOR + screenRect.width());
        hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, BuildConfig.FLAVOR + screenRect.height());
        hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(((float) getW()) / displayMetrics.density)));
        hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(((float) getH()) / displayMetrics.density)));
        hashMap.put(IXAdRequestInfo.SN, n.getSn(this.f7102d));
        try {
            obj = BuildConfig.FLAVOR;
            List cell = n.getCell(this.f7102d);
            if (cell.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < cell.size(); i++) {
                    String[] strArr = (String[]) cell.get(i);
                    stringBuilder.append(String.format("%s_%s_%s|", new Object[]{strArr[0], strArr[1], strArr[2]}));
                }
                obj = stringBuilder.substring(0, stringBuilder.length() - 1);
            }
        } catch (Exception e) {
            obj = BuildConfig.FLAVOR;
        }
        try {
            Object obj2;
            hashMap.put(IXAdRequestInfo.CELL_ID, obj);
            hashMap.put(IXAdRequestInfo.NETWORK_OPERATOR, n.getNetworkOperator(this.f7102d));
            hashMap.put(IXAdRequestInfo.IMSI, m.getSubscriberId(this.f7102d));
            try {
                double[] gps = n.getGPS(this.f7102d);
                str = BuildConfig.FLAVOR;
                if (gps != null) {
                    System.currentTimeMillis();
                    str = String.format("%s_%s_%s", new Object[]{Double.valueOf(gps[0]), Double.valueOf(gps[1]), Double.valueOf(gps[2])});
                }
                obj2 = str;
            } catch (Exception e2) {
                obj2 = BuildConfig.FLAVOR;
            }
            hashMap.put(IXAdRequestInfo.GPS, obj2);
            try {
                obj2 = BuildConfig.FLAVOR;
                List wifi = n.getWIFI(this.f7102d);
                if (wifi.size() > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    for (int i2 = 0; i2 < wifi.size(); i2++) {
                        strArr = (String[]) wifi.get(i2);
                        stringBuilder2.append(String.format("%s_%s|", new Object[]{strArr[0], strArr[1]}));
                    }
                    obj = stringBuilder2.substring(0, stringBuilder2.length() - 1);
                } else {
                    obj = obj2;
                }
            } catch (Exception e3) {
                obj = obj2;
            }
            hashMap.put(IXAdRequestInfo.WIFI, obj);
            hashMap.put("swi", BuildConfig.FLAVOR + (UtilityImpl.NET_TYPE_WIFI.equals(n.getNetworkType(this.f7102d)) ? 1 : 0));
            hashMap.put("tel", BuildConfig.FLAVOR);
            try {
                hashMap.put("uk", URLEncoder.encode(getUk(), "utf-8"));
                hashMap.put("sex", URLEncoder.encode(getSex(), "utf-8"));
                hashMap.put("zip", URLEncoder.encode(getZip(), "utf-8"));
            } catch (Exception e4) {
            }
            hashMap.put("tab", n.isTablet(this.f7102d) ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
            hashMap.put("sdc", n.getAppSDC() + Constants.ACCEPT_TIME_SEPARATOR_SP + n.getMem());
            hashMap.put(IXAdRequestInfo.ACT, getAct());
            hashMap.put("prod", getProd());
            hashMap.put(com.taobao.accs.common.Constants.KEY_OS_VERSION, C0714a.ANDROID);
            hashMap.put(IXAdRequestInfo.OSV, VERSION.RELEASE);
            hashMap.put(IXAdRequestInfo.BDR, BuildConfig.FLAVOR + VERSION.SDK_INT);
            hashMap.put("apinfo", m.getBaiduMapsInfo(this.f7102d));
            hashMap.put("apid", getApid());
            hashMap.put("chid", m.getChannelId());
            hashMap.put("apt", MessageService.MSG_DB_READY_REPORT);
            hashMap.put("ap", BuildConfig.FLAVOR + getAp());
            hashMap.put("nt", n.getNetType(this.f7102d));
            hashMap.put("udid", BuildConfig.FLAVOR);
            hashMap.put("ses", BuildConfig.FLAVOR + getSes());
            hashMap.put("android_id", n.getAndroidId(this.f7102d));
            hashMap.put(com.taobao.accs.common.Constants.KEY_IMEI, n.getIMEI(this.f7102d));
            hashMap.put(PointMark.T_MAC, n.getMacAddress(this.f7102d));
            hashMap.put("cuid", n.getCUID(this.f7102d));
            hashMap.put(IXAdRequestInfo.P_VER, "8.8");
            hashMap.put("req_id", m.createRequestId(this.f7102d, getApid()));
            hashMap.put("cssid", n.isWifiConnected(this.f7102d).booleanValue() ? n.getWifiConnected(this.f7102d) : BuildConfig.FLAVOR);
        } catch (Exception e5) {
        }
        return hashMap;
    }

    public void m7625e(int i) {
        this.f7114p = i;
    }

    public String m7626f() {
        return this.f7099a;
    }

    public void m7627f(int i) {
        this.f7110l = i;
    }

    public String getAct() {
        return this.f7111m;
    }

    public int getAp() {
        return this.f7114p;
    }

    public String getApid() {
        return this.f7107i;
    }

    public int getApt() {
        return this.f7113o;
    }

    public int getAt() {
        return this.f7110l;
    }

    public int getH() {
        return this.f7109k;
    }

    public int getN() {
        return this.f7115q;
    }

    public String getProd() {
        return this.f7112n;
    }

    public long getSes() {
        return this.f7120v;
    }

    public String getSex() {
        return this.f7117s;
    }

    public String getUk() {
        return this.f7116r;
    }

    public int getW() {
        return this.f7108j;
    }

    public String getZip() {
        return this.f7118t;
    }

    public boolean isCanClick() {
        return this.f7119u;
    }
}
