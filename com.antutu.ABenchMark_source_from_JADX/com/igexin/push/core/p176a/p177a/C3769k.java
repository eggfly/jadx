package com.igexin.push.core.p176a.p177a;

import android.content.Intent;
import android.content.pm.PackageManager;
import anet.channel.strategy.dispatch.C0714a;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3832l;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.util.C3922a;
import com.qq.p035e.comm.pi.ACTD;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.k */
public class C3769k implements C3759a {
    private static final String f12690a;

    static {
        f12690a = C3753l.f12646a;
    }

    public C3820b m15456a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15457a(JSONObject jSONObject) {
        try {
            BaseAction c3832l = new C3832l();
            c3832l.setType("startapp");
            c3832l.setActionId(jSONObject.getString("actionid"));
            c3832l.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("appstartupid")) {
                c3832l.m15765a(jSONObject.getJSONObject("appstartupid").getString(C0714a.ANDROID));
            }
            if (jSONObject.has("is_autostart")) {
                c3832l.m15771d(jSONObject.getString("is_autostart"));
            }
            if (jSONObject.has(ACTD.APPID_KEY)) {
                c3832l.m15767b(jSONObject.getString(ACTD.APPID_KEY));
            }
            if (!jSONObject.has("noinstall_action")) {
                return c3832l;
            }
            c3832l.m15769c(jSONObject.getString("noinstall_action"));
            return c3832l;
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean m15458b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        boolean z = false;
        if (!(pushTaskBean == null || baseAction == null)) {
            boolean z2;
            C3832l c3832l = (C3832l) baseAction;
            PackageManager packageManager = C3855g.f12969g.getPackageManager();
            String b = c3832l.m15766b();
            if (b.equals(BuildConfig.FLAVOR)) {
                b = C3855g.f12963a;
                z2 = true;
            } else {
                z2 = C3855g.f12963a.equals(c3832l.m15766b());
            }
            C3688a.m15097b("doStartApp|" + z2 + "|" + b);
            Intent launchIntentForPackage;
            if (z2) {
                try {
                    C3777e.m15491a().m15543b(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), b, null);
                    if (((C3832l) baseAction).m15770d().equals("true")) {
                        launchIntentForPackage = packageManager.getLaunchIntentForPackage(C3855g.f12967e);
                        if (launchIntentForPackage == null) {
                            return false;
                        }
                        C3855g.f12969g.startActivity(launchIntentForPackage);
                    }
                    if (c3832l.getDoActionId() != null) {
                        C3777e.m15491a().m15532a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), c3832l.getDoActionId());
                    }
                } catch (Exception e) {
                }
            } else {
                C3777e.m15491a().m15543b(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), b, null);
                if (!c3832l.m15770d().equals("true")) {
                    z = true;
                } else if (C3922a.m16142a(c3832l.m15764a())) {
                    launchIntentForPackage = packageManager.getLaunchIntentForPackage(((C3832l) baseAction).m15764a());
                    if (launchIntentForPackage == null) {
                        return false;
                    }
                    C3855g.f12969g.startActivity(launchIntentForPackage);
                    z = true;
                }
                if (z) {
                    if (c3832l.getDoActionId() != null) {
                        C3777e.m15491a().m15532a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), c3832l.getDoActionId());
                    }
                } else if (c3832l.m15768c() != null) {
                    C3777e.m15491a().m15532a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), c3832l.m15768c());
                }
            }
        }
        return true;
    }
}
