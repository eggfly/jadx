package com.igexin.push.core.p180c;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.C3742a;
import com.igexin.push.config.C3756o;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.core.p176a.C3789q;
import com.igexin.push.p169f.p179a.C3836b;
import com.igexin.push.util.C3929h;
import org.json.JSONArray;

/* renamed from: com.igexin.push.core.c.f */
public class C3842f extends C3836b {
    public static JSONArray f12891a;

    public C3842f(String str, JSONArray jSONArray) {
        super(str);
        m15816a(jSONArray);
    }

    public void m15815a(Exception exception) {
        C3799f.m15623a().m15656c(System.currentTimeMillis());
        C3688a.m15097b("-> get idc config " + exception.toString());
    }

    public void m15816a(JSONArray jSONArray) {
        f12891a = jSONArray;
    }

    public void m15817a(byte[] bArr) {
        if (bArr != null) {
            try {
                String str = new String(C3700a.m15136c(C3929h.m16176a(bArr, 0)));
                C3688a.m15097b("->get idc config server resp data : " + str);
                C3742a.m15382a().m15393b(str);
                C3756o.m15416a(str, true);
                C3799f.m15623a().m15656c(0);
                C3742a.m15382a().m15390a(f12891a.toString());
                SDKUrlConfig.setIdcConfigUrl(C3789q.m15599a(f12891a));
            } catch (Exception e) {
                C3799f.m15623a().m15656c(System.currentTimeMillis());
                throw e;
            }
        }
    }

    public int m15818b() {
        return 0;
    }
}
