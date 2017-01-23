package com.igexin.push.core.p176a;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.pi.ACTD;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.t */
public class C3792t extends C3773b {
    public boolean m15604a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("sendmessage_feedback")) {
                String string = jSONObject.getString(ACTD.APPID_KEY);
                String string2 = jSONObject.getString("taskid");
                String string3 = jSONObject.getString("actionid");
                String string4 = jSONObject.getString("result");
                long j = jSONObject.getLong("timestamp");
                C3688a.m15097b("SendMessageFeedbackAction|appid:" + string + "|taskid:" + string2 + "|actionid:" + string3);
                C3777e.m15491a().m15523a(string, string2, string3, string4, j);
            }
        } catch (Exception e) {
        }
        return true;
    }
}
