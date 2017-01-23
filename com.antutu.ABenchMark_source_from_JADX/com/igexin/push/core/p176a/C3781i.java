package com.igexin.push.core.p176a;

import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.push.config.C3753l;
import com.igexin.push.p182d.p185c.C3891p;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.i */
public class C3781i extends C3772a {
    private static final String f12710a;
    private static Map f12711b;

    static {
        f12710a = C3753l.f12646a;
    }

    public C3781i() {
        f12711b = new HashMap();
        f12711b.put("redirect_server", new C3789q());
        f12711b.put("response_deviceid", new C3791s());
        f12711b.put("pushmessage", new C3787o());
        f12711b.put("received", new C3788p());
        f12711b.put("sendmessage_feedback", new C3792t());
        f12711b.put("block_client", new C3774c());
        f12711b.put("settag_result", new C3793u());
    }

    public boolean m15583a(C3666d c3666d) {
        return false;
    }

    public boolean m15584a(Object obj) {
        if (obj instanceof C3891p) {
            C3891p c3891p = (C3891p) obj;
            if (c3891p.m15992a() && c3891p.f13116e != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) c3891p.f13116e);
                    if (jSONObject.has(PushConsts.CMD_ACTION) && !jSONObject.getString(PushConsts.CMD_ACTION).equals("received") && jSONObject.has(AgooConstants.MESSAGE_ID)) {
                        C3777e.m15491a().m15519a(jSONObject.getString(AgooConstants.MESSAGE_ID));
                    }
                    if (jSONObject.has(PushConsts.CMD_ACTION)) {
                        C3773b c3773b = (C3773b) f12711b.get(jSONObject.getString(PushConsts.CMD_ACTION));
                        if (c3773b != null) {
                            return c3773b.m15480a(obj, jSONObject);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
}
