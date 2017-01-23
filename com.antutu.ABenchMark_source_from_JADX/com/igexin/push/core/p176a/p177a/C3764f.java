package com.igexin.push.core.p176a.p177a;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.f */
public class C3764f implements C3759a {
    public C3820b m15437a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15438a(JSONObject jSONObject) {
        try {
            BaseAction baseAction = new BaseAction();
            baseAction.setType("null");
            baseAction.setActionId(jSONObject.getString("actionid"));
            return baseAction;
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean m15439b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        String c = C3777e.m15491a().m15545c(pushTaskBean.getTaskId(), pushTaskBean.getMessageId());
        C3688a.m15097b("EndAction execute, remove pushMessage from pushMessageMap, key = " + c);
        try {
            C3855g.ah.remove(c);
        } catch (Exception e) {
            C3688a.m15097b("EndAction|" + e.toString());
        }
        return true;
    }
}
