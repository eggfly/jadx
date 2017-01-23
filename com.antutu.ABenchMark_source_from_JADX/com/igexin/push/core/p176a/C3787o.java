package com.igexin.push.core.p176a;

import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3855g;
import com.igexin.push.p182d.p185c.C3891p;
import com.igexin.sdk.PushConsts;
import java.util.Timer;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.o */
public class C3787o extends C3773b {
    private static final String f12716a;

    static {
        f12716a = C3753l.f12646a;
    }

    public boolean m15595a(Object obj, JSONObject jSONObject) {
        try {
            C3891p c3891p = (C3891p) obj;
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("pushmessage")) {
                byte[] bArr = (c3891p.f13117f == null || !(c3891p.f13117f instanceof byte[])) ? null : (byte[]) c3891p.f13117f;
                String string = jSONObject.getString("taskid");
                if (C3855g.aj.containsKey(string)) {
                    ((Timer) C3855g.aj.get(string)).cancel();
                    C3855g.aj.remove(string);
                }
                C3777e.m15491a().m15534a(jSONObject, bArr, true);
            }
        } catch (Exception e) {
        }
        return true;
    }
}
