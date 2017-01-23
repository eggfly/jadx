package com.igexin.push.core.p180c;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.push.core.C3855g;
import com.igexin.push.p169f.p179a.C3836b;
import com.igexin.sdk.PushConsts;
import com.umeng.message.util.HttpRequest;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.k */
public class C3847k extends C3836b {
    public C3847k(String str, byte[] bArr, int i) {
        super(str);
        m15829a(bArr, i);
    }

    private void m15829a(byte[] bArr, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "upload_BI");
            jSONObject.put("BIType", String.valueOf(i));
            jSONObject.put(IXAdRequestInfo.CELL_ID, C3855g.f12982t);
            jSONObject.put("BIData", new String(C3687f.m15094f(bArr, 0), HttpRequest.f14548a));
            m15799b(jSONObject.toString().getBytes());
        } catch (Exception e) {
        }
    }

    public void m15830a(byte[] bArr) {
    }

    public int m15831b() {
        return 0;
    }
}
