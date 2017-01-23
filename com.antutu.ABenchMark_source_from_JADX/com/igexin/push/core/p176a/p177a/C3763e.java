package com.igexin.push.core.p176a.p177a;

import com.igexin.push.core.C3820b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3825e;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p175b.C3799f;
import com.umeng.message.proguard.C4233j;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.e */
public class C3763e implements C3759a {
    public C3820b m15434a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15435a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("duration")) {
                BaseAction c3825e = new C3825e();
                c3825e.setType(jSONObject.getString(C4233j.f14402y));
                c3825e.setActionId(jSONObject.getString("actionid"));
                c3825e.setDoActionId(jSONObject.getString("do"));
                if (!jSONObject.has("duration")) {
                    return c3825e;
                }
                c3825e.m15710a(Long.valueOf(jSONObject.getString("duration")).longValue());
                return c3825e;
            }
        } catch (JSONException e) {
        }
        return null;
    }

    public boolean m15436b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        long currentTimeMillis = System.currentTimeMillis() + (((C3825e) baseAction).m15709a() * 1000);
        C3799f.m15623a().m15647a(true);
        C3799f.m15623a().m15662e(currentTimeMillis);
        return true;
    }
}
