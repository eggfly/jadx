package com.igexin.push.core.p176a.p177a;

import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3826f;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p180c.C3847k;
import com.igexin.push.p169f.p179a.C3913c;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.i */
public class C3767i implements C3759a {
    private static final String f12688a;

    static {
        f12688a = C3753l.f12646a;
    }

    public C3820b m15449a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15450a(JSONObject jSONObject) {
        try {
            BaseAction baseAction = new BaseAction();
            baseAction.setType("reportext");
            baseAction.setActionId(jSONObject.getString("actionid"));
            baseAction.setDoActionId(jSONObject.getString("do"));
            return baseAction;
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean m15451b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (!(pushTaskBean == null || baseAction == null || C3754m.f12675s == null || C3754m.f12675s.m15734b() == null || C3754m.f12675s.m15734b().isEmpty())) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                File[] listFiles = new File(C3855g.ac).listFiles();
                if (!(listFiles == null || listFiles.length == 0)) {
                    Map b = C3754m.f12675s.m15734b();
                    C3688a.m15097b(f12688a + "|DynamicConfig.extInfos");
                    boolean z = true;
                    for (Entry entry : b.entrySet()) {
                        boolean z2;
                        int intValue = ((Integer) entry.getKey()).intValue();
                        C3826f c3826f = (C3826f) entry.getValue();
                        if (z) {
                            stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
                            stringBuilder.append("|");
                            stringBuilder.append(C3855g.f12982t);
                            stringBuilder.append("|");
                            stringBuilder.append(C3855g.f12963a);
                            stringBuilder.append("|");
                            stringBuilder.append(C3855g.f12950N);
                            stringBuilder.append("|");
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        for (File name : listFiles) {
                            if (name.getName().equals(c3826f.m15719c())) {
                                stringBuilder.append(intValue);
                                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                stringBuilder.append(c3826f.m15716b());
                                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                stringBuilder.append(c3826f.m15719c());
                                stringBuilder.append("|");
                            }
                        }
                        z = z2;
                    }
                    C3688a.m15097b(f12688a + "check ext data : " + stringBuilder.toString());
                    if (stringBuilder.length() > 0) {
                        C3685c.m15060b().m15053a(new C3913c(new C3847k(SDKUrlConfig.getStatServiceUrl(), stringBuilder.toString().getBytes(), 17)), false, true);
                    }
                }
            } catch (Exception e) {
                C3688a.m15097b(f12688a + " | " + e.toString());
            }
        }
        return true;
    }
}
