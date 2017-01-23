package com.igexin.push.config;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import java.util.ArrayList;
import java.util.List;

public class SDKUrlConfig {
    public static String[] AMP_ADDRESS_IPS;
    public static String[] BI_ADDRESS_IPS;
    public static String[] CONFIG_ADDRESS_IPS;
    public static String[] INC_ADDRESS_IPS;
    public static String[] LBS_ADDRESS_IPS;
    public static String[] LOG_ADDRESS_IPS;
    public static String[] STATE_ADDRESS_IPS;
    public static String[] XFR_ADDRESS_BAK;
    private static final Object f12627a;
    private static String[] f12628b;
    private static String f12629c;
    private static String[] f12630d;
    private static volatile String f12631e;

    static {
        f12627a = new Object();
        f12629c = "HZ";
        f12630d = new String[]{"socket://sdk.open.talk.igexin.com:5224", "socket://sdk.open.talk.getui.net:5224", "socket://sdk.open.talk.gepush.com:5224"};
        XFR_ADDRESS_BAK = new String[]{"socket://42.62.120.14:5224"};
        BI_ADDRESS_IPS = new String[]{"http://sdk.open.phone.igexin.com/api.php"};
        CONFIG_ADDRESS_IPS = new String[]{"http://c.sz.gt.igexin.com/api.php"};
        STATE_ADDRESS_IPS = new String[]{"http://s.sz.gt.igexin.com/api.php"};
        LOG_ADDRESS_IPS = new String[]{"http://d.gt.igexin.com/api.htm"};
        AMP_ADDRESS_IPS = new String[]{"http://sdk.open.amp.igexin.com/api.htm"};
        LBS_ADDRESS_IPS = new String[]{"http://sdk.open.lbs.igexin.com/api.htm"};
        INC_ADDRESS_IPS = new String[]{"http://sdk.open.inc2.igexin.com/api.php"};
    }

    public static String getAmpServiceUrl() {
        return AMP_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getBiUploadServiceUrl() {
        return BI_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getCmAddress() {
        return f12631e == null ? f12630d[0] : f12631e;
    }

    public static String getConfigServiceUrl() {
        return CONFIG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String[] getIdcConfigUrl() {
        return f12628b;
    }

    public static String getIncreaseServiceUrl() {
        return INC_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getLbsServiceUrl() {
        return LBS_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getLocation() {
        return f12629c;
    }

    public static String getLogServiceUrl() {
        return LOG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getStatServiceUrl() {
        return STATE_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String[] getXfrAddress() {
        String[] strArr;
        synchronized (f12627a) {
            strArr = f12630d;
        }
        return strArr;
    }

    public static boolean realXfrListIsOnly() {
        String[] xfrAddress = getXfrAddress();
        List arrayList = new ArrayList();
        for (Object obj : xfrAddress) {
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size() == 1;
    }

    public static void setCmAddress(String str) {
        C3688a.m15097b("set cm address : " + str);
        f12631e = str;
    }

    public static void setIdcConfigUrl(String[] strArr) {
        f12628b = strArr;
    }

    public static void setLocation(String str) {
        if (!TextUtils.isEmpty(str)) {
            C3855g.f12966d = str;
            f12629c = str;
        }
    }

    public static void setXfrAddressIps(String[] strArr) {
        synchronized (f12627a) {
            f12630d = strArr;
        }
    }
}
