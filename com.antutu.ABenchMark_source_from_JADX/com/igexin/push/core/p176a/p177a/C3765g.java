package com.igexin.push.core.p176a.p177a;

import com.igexin.push.core.C3820b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3828h;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.g */
public class C3765g implements C3759a {
    public C3820b m15440a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15441a(JSONObject jSONObject) {
        try {
            BaseAction c3828h = new C3828h();
            c3828h.setType("goto");
            c3828h.setActionId(jSONObject.getString("actionid"));
            c3828h.setDoActionId(jSONObject.getString("do"));
            return c3828h;
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean m15442b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (!(pushTaskBean == null || baseAction == null || baseAction.getDoActionId() == null || baseAction.getDoActionId().equals(BuildConfig.FLAVOR))) {
            C3777e.m15491a().m15532a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        }
        return true;
    }
}
