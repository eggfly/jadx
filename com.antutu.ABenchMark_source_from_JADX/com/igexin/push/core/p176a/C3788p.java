package com.igexin.push.core.p176a;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.p175b.C3796c;
import com.igexin.sdk.PushConsts;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.p */
public class C3788p extends C3773b {
    public boolean m15596a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("received")) {
                String string = jSONObject.getString(AgooConstants.MESSAGE_ID);
                C3688a.m15097b("ReceivedAction received, cmd id :" + string);
                try {
                    if (C3796c.m15612a().m15617a(Long.parseLong(string))) {
                        C3777e.m15491a().m15559h();
                    }
                } catch (NumberFormatException e) {
                    C3688a.m15097b("ReceivedAction|" + e.toString());
                }
            }
        } catch (Exception e2) {
            C3688a.m15097b("ReceivedAction|" + e2.toString());
        }
        return true;
    }
}
