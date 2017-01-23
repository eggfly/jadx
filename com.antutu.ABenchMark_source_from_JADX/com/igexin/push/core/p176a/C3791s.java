package com.igexin.push.core.p176a;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.s */
public class C3791s extends C3773b {
    private static final String f12719a;

    static {
        f12719a = C3753l.f12646a;
    }

    public boolean m15603a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("response_deviceid")) {
                String string = jSONObject.getString("deviceid");
                C3688a.m15097b(f12719a + " get devid resp, devid : " + string + ", save 2db and file");
                C3799f.m15623a().m15651b(string);
                if (C3855g.au != null) {
                    C3688a.m15097b(f12719a + " deviceid arrived cancel addPhoneInfoTimerTask...");
                    C3855g.au.m14970t();
                    C3855g.au = null;
                }
                if (C3855g.f12937A != null) {
                    C3854f.m15859a().m15879i().m15561j();
                }
                C3688a.m15097b("deviceidRsp|" + C3855g.f12937A);
            }
        } catch (Exception e) {
        }
        return true;
    }
}
