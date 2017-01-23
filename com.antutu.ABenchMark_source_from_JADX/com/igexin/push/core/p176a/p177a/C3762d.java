package com.igexin.push.core.p176a.p177a;

import com.igexin.push.core.C3820b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.core.p176a.C3777e;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.d */
public class C3762d implements C3759a {
    public C3820b m15431a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15432a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid")) {
                BaseAction baseAction = new BaseAction();
                baseAction.setType(jSONObject.getString(C4233j.f14402y));
                baseAction.setActionId(jSONObject.getString("actionid"));
                baseAction.setDoActionId(jSONObject.getString("do"));
                return baseAction;
            }
        } catch (JSONException e) {
        }
        return null;
    }

    public boolean m15433b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C3799f.m15623a().m15647a(false);
        if (!baseAction.getDoActionId().equals(BuildConfig.FLAVOR)) {
            C3777e.m15491a().m15532a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        }
        return true;
    }
}
