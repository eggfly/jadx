package com.igexin.push.core.p180c;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.p169f.p179a.C3836b;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.pi.ACTD;
import com.umeng.message.common.C4209a;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.g */
public class C3843g extends C3836b {
    public static final String f12892a;

    static {
        f12892a = C3843g.class.getName();
    }

    public C3843g(String str) {
        super(str);
        m15819a();
    }

    public void m15819a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "sdkconfig");
            jSONObject.put(IXAdRequestInfo.CELL_ID, C3855g.f12982t);
            jSONObject.put(ACTD.APPID_KEY, C3855g.f12963a);
            jSONObject.put(C4209a.f14205h, PushBuildConfig.sdk_conf_version);
            jSONObject.put("tag", C3754m.f12652F);
            m15799b(jSONObject.toString().getBytes());
        } catch (Exception e) {
        }
    }

    public void m15820a(byte[] bArr) {
        C3777e.m15491a().m15527a(bArr);
    }

    public int m15821b() {
        return 0;
    }
}
