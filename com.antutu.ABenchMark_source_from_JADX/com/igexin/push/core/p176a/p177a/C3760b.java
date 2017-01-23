package com.igexin.push.core.p176a.p177a;

import anet.channel.strategy.dispatch.C0714a;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3822b;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.b */
public class C3760b implements C3759a {
    public C3820b m15423a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15424a(JSONObject jSONObject) {
        try {
            if (jSONObject.has(C4233j.f14402y) && jSONObject.has("actionid")) {
                BaseAction c3822b = new C3822b();
                c3822b.setType("checkapp");
                c3822b.setActionId(jSONObject.getString("actionid"));
                if (jSONObject.has("appstartupid")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("appstartupid");
                    if (jSONObject2.has(C0714a.ANDROID)) {
                        c3822b.m15695a(jSONObject2.getString(C0714a.ANDROID));
                        if (jSONObject.has("do_installed") || jSONObject.has("do_uninstalled")) {
                            if (jSONObject.has("do_installed")) {
                                c3822b.m15697b(jSONObject.getString("do_installed"));
                            }
                            if (!jSONObject.has("do_uninstalled")) {
                                return c3822b;
                            }
                            c3822b.m15699c(jSONObject.getString("do_uninstalled"));
                            return c3822b;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean m15425a(String str) {
        try {
            return C3855g.f12969g.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean m15426b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C3822b c3822b = (C3822b) baseAction;
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        if (m15425a(c3822b.m15694a())) {
            if (!(c3822b.m15696b() == null || c3822b.m15696b().equals(BuildConfig.FLAVOR))) {
                C3777e.m15491a().m15532a(taskId, messageId, c3822b.m15696b());
            }
        } else if (!(c3822b.m15698c() == null || c3822b.m15698c().equals(BuildConfig.FLAVOR))) {
            C3777e.m15491a().m15532a(taskId, messageId, c3822b.m15698c());
        }
        return true;
    }
}
