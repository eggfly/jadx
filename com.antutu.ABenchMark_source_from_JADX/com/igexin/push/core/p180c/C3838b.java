package com.igexin.push.core.p180c;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.core.C3855g;
import com.igexin.push.p169f.p179a.C3836b;
import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.pi.ACTD;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.C4233j;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.b */
public class C3838b extends C3836b {
    public C3838b(String str, String str2) {
        super(str);
        m15805a(str2);
    }

    public void m15805a(String str) {
        if (str != null && C3855g.f12963a != null && C3855g.f12982t != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PushConsts.CMD_ACTION, "alias_bind");
                jSONObject.put(C4233j.f14403z, str);
                jSONObject.put(ACTD.APPID_KEY, C3855g.f12963a);
                jSONObject.put(IXAdRequestInfo.CELL_ID, C3855g.f12982t);
                m15799b(C3700a.m15135b(jSONObject.toString().getBytes()));
            } catch (Exception e) {
            }
        }
    }

    public void m15806a(byte[] bArr) {
        if (bArr != null) {
            C3688a.m15097b("-> BindAlias result::" + new String(C3700a.m15136c(bArr)));
            JSONObject jSONObject = new JSONObject();
            if (jSONObject.has("result")) {
                if (!ITagManager.SUCCESS.equals(jSONObject.getString("result"))) {
                }
            }
        }
    }

    public int m15807b() {
        return 0;
    }
}
