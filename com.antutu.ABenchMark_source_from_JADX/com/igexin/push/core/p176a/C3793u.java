package com.igexin.push.core.p176a;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.u */
public class C3793u extends C3773b {
    private static final String f12720a;

    static {
        f12720a = C3753l.f12646a + "_SetTagResultAction";
    }

    public boolean m15605a(Object obj, JSONObject jSONObject) {
        C3688a.m15097b(f12720a + "|set tag result resp data = " + jSONObject);
        if (jSONObject != null) {
            try {
                if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("settag_result")) {
                    C3777e.m15491a().m15540b(jSONObject.getString(IXAdRequestInfo.SN), jSONObject.getString("error_code"));
                }
            } catch (Exception e) {
                C3688a.m15097b(f12720a + "|" + e.toString());
            }
        }
        return true;
    }
}
