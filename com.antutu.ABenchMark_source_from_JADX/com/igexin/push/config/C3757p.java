package com.igexin.push.config;

import android.os.Bundle;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.config.p */
public class C3757p {
    public static void m15418a() {
        try {
            Bundle bundle = C3855g.f12969g.getPackageManager().getApplicationInfo(C3855g.f12969g.getPackageName(), SpdyProtocol.SLIGHTSSLV2).metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (str.equals("PUSH_DOMAIN")) {
                        C3688a.m15097b("PUSH_DOMAIN:" + bundle.getString(str));
                        C3757p.m15419a(bundle.getString(str));
                        return;
                    }
                }
            }
        } catch (Exception e) {
            C3688a.m15097b(e.toString());
        }
    }

    private static void m15419a(String str) {
        SDKUrlConfig.setXfrAddressIps(new String[]{"socket://xfr." + str + ":5224"});
        C3688a.m15097b("XFR_ADDRESS_IPS:" + SDKUrlConfig.getXfrAddress()[0]);
        SDKUrlConfig.XFR_ADDRESS_BAK = new String[]{"socket://xfr_bak." + str + ":5224"};
        C3688a.m15097b("XFR_ADDRESS_IPS_BAK:" + SDKUrlConfig.XFR_ADDRESS_BAK[0]);
        SDKUrlConfig.BI_ADDRESS_IPS = new String[]{"http://bi." + str + "/api.php"};
        C3688a.m15097b("BI_ADDRESS_IPS:" + SDKUrlConfig.BI_ADDRESS_IPS[0]);
        SDKUrlConfig.CONFIG_ADDRESS_IPS = new String[]{"http://config." + str + "/api.php"};
        C3688a.m15097b("CONFIG_ADDRESS_IPS:" + SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
        SDKUrlConfig.STATE_ADDRESS_IPS = new String[]{"http://stat." + str + "/api.php"};
        C3688a.m15097b("STATE_ADDRESS_IPS:" + SDKUrlConfig.STATE_ADDRESS_IPS[0]);
        SDKUrlConfig.LOG_ADDRESS_IPS = new String[]{"http://log." + str + "/api.php"};
        C3688a.m15097b("LOG_ADDRESS_IPS:" + SDKUrlConfig.LOG_ADDRESS_IPS[0]);
        SDKUrlConfig.AMP_ADDRESS_IPS = new String[]{"http://amp." + str + "/api.htm"};
        C3688a.m15097b("AMP_ADDRESS_IPS:" + SDKUrlConfig.AMP_ADDRESS_IPS[0]);
        SDKUrlConfig.LBS_ADDRESS_IPS = new String[]{"http://lbs." + str + "/api.htm"};
        C3688a.m15097b("LBS_ADDRESS_IPS:" + SDKUrlConfig.LBS_ADDRESS_IPS[0]);
        SDKUrlConfig.INC_ADDRESS_IPS = new String[]{"http://inc." + str + "/api.php"};
        C3688a.m15097b("INC_ADDRESS_IPS:" + SDKUrlConfig.INC_ADDRESS_IPS[0]);
    }
}
