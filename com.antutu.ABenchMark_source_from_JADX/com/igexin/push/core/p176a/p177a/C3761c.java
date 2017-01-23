package com.igexin.push.core.p176a.p177a;

import android.os.Process;
import com.igexin.push.config.C3742a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3824d;
import com.igexin.push.core.bean.C3826f;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.util.C3926e;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.c */
public class C3761c implements C3759a {
    private boolean m15427a(C3826f c3826f) {
        String c = c3826f.m15719c();
        return c != null && C3926e.m16166b(c);
    }

    public C3820b m15428a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15429a(JSONObject jSONObject) {
        if (jSONObject.has("ids")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.getString("ids"));
                if (jSONArray.length() > 0) {
                    int[] iArr = new int[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        iArr[i] = jSONArray.getInt(i);
                    }
                    BaseAction c3824d = new C3824d();
                    c3824d.setType("cleanext");
                    c3824d.m15707a(iArr);
                    c3824d.setActionId(jSONObject.getString("actionid"));
                    c3824d.setDoActionId(jSONObject.getString("do"));
                    return c3824d;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    public boolean m15430b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        boolean z = false;
        if (C3754m.f12675s == null || C3754m.f12675s.m15734b() == null || C3754m.f12675s.m15734b().size() == 0) {
            return false;
        }
        if (!(pushTaskBean == null || baseAction == null)) {
            boolean z2;
            C3824d c3824d = (C3824d) baseAction;
            Map b = C3754m.f12675s.m15734b();
            int[] a = c3824d.m15708a();
            if (a == null || a.length <= 0) {
                z2 = false;
            } else {
                int i = 0;
                z2 = false;
                while (i < c3824d.m15708a().length) {
                    boolean z3;
                    if (b.containsKey(Integer.valueOf(a[i]))) {
                        m15427a((C3826f) b.get(Integer.valueOf(a[i])));
                        b.remove(Integer.valueOf(a[i]));
                        z2 = true;
                        z3 = true;
                    } else {
                        z3 = z2;
                        z2 = z;
                    }
                    i++;
                    z = z2;
                    z2 = z3;
                }
                if (z) {
                    C3742a.m15382a().m15399g();
                }
            }
            if (z2) {
                Process.killProcess(Process.myPid());
            }
        }
        if (baseAction.getDoActionId().equals(BuildConfig.FLAVOR)) {
            return true;
        }
        C3777e.m15491a().m15532a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
