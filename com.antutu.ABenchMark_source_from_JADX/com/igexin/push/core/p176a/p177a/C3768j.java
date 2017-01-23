package com.igexin.push.core.p176a.p177a;

import android.content.Intent;
import android.net.Uri;
import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3833m;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.j */
public class C3768j implements C3759a {
    private static final String f12689a;

    static {
        f12689a = C3753l.f12646a;
    }

    private void m15452a(C3833m c3833m, String str) {
        String a = c3833m.m15772a();
        if (a != null) {
            int indexOf = a.indexOf(str);
            if (indexOf != -1) {
                String str2 = BuildConfig.FLAVOR;
                String str3 = null;
                int indexOf2 = a.indexOf("&");
                if (indexOf2 == -1) {
                    str2 = a.substring(0, indexOf - 1);
                    a = a.substring(indexOf);
                    if (a.contains("=")) {
                        str3 = a.substring(a.indexOf("=") + 1);
                    }
                } else if (a.charAt(indexOf - 1) == '?') {
                    str2 = a.substring(0, indexOf);
                    str2 = str2 + a.substring(indexOf2 + 1);
                    a = a.substring(indexOf, indexOf2);
                    if (a.contains("=")) {
                        str3 = a.substring(a.indexOf("=") + 1);
                    }
                } else if (a.charAt(indexOf - 1) == '&') {
                    String substring = a.substring(0, indexOf - 1);
                    str2 = a.substring(indexOf);
                    str3 = BuildConfig.FLAVOR;
                    int indexOf3 = str2.indexOf("&");
                    if (indexOf3 != -1) {
                        str3 = str2.substring(indexOf3);
                        str2 = str2.substring(0, indexOf3);
                        str2 = str2.substring(str2.indexOf("=") + 1);
                    } else {
                        str2 = str2.substring(str2.indexOf("=") + 1);
                    }
                    String str4 = str2;
                    str2 = substring + str3;
                    str3 = str4;
                }
                c3833m.m15773a(str2);
                c3833m.m15776b(str3);
            }
        }
    }

    public C3820b m15453a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15454a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("url") && jSONObject.has("do") && jSONObject.has("actionid")) {
                String string = jSONObject.getString("url");
                if (!string.equals(BuildConfig.FLAVOR)) {
                    BaseAction c3833m = new C3833m();
                    c3833m.setType("startweb");
                    c3833m.setActionId(jSONObject.getString("actionid"));
                    c3833m.setDoActionId(jSONObject.getString("do"));
                    c3833m.m15773a(string);
                    if (jSONObject.has("is_withcid") && jSONObject.getString("is_withcid").equals("true")) {
                        c3833m.m15774a(true);
                    }
                    if (!jSONObject.has("is_withnettype") || !jSONObject.getString("is_withnettype").equals("true")) {
                        return c3833m;
                    }
                    c3833m.m15777b(true);
                    return c3833m;
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }

    public boolean m15455b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C3833m c3833m = (C3833m) baseAction;
        m15452a(c3833m, "targetpkgname");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setPackage(c3833m.m15775b());
        intent.setData(Uri.parse(c3833m.m15778c()));
        try {
            C3855g.f12969g.startActivity(intent);
        } catch (Exception e) {
        }
        if (!baseAction.getDoActionId().equals(BuildConfig.FLAVOR)) {
            C3777e.m15491a().m15532a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        }
        return true;
    }
}
