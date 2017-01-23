package com.igexin.push.core.p176a;

import com.igexin.push.config.C3742a;
import com.igexin.push.config.C3753l;
import com.igexin.push.config.C3754m;
import com.igexin.push.p171a.p172a.C3714c;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.c */
public class C3774c extends C3773b {
    private static final String f12697a;

    static {
        f12697a = C3753l.f12646a;
    }

    public boolean m15481a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("block_client") && jSONObject.has("duration")) {
                long j = jSONObject.getLong("duration") * 1000;
                long currentTimeMillis = System.currentTimeMillis();
                if (j != 0) {
                    C3754m.f12659c = j + currentTimeMillis;
                    C3742a.m15382a().m15397e();
                    C3714c.m15218c().m15222d();
                }
            }
        } catch (Exception e) {
        }
        return true;
    }
}
