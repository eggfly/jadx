package com.igexin.push.core.p180c;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p175b.C3819z;
import com.igexin.push.p169f.p179a.C3836b;
import com.igexin.sdk.PushConsts;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.util.HttpRequest;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.l */
public class C3848l extends C3836b {
    public static final String f12900a;
    private String f12901g;
    private ArrayList f12902h;

    static {
        f12900a = C3848l.class.getName();
    }

    public C3848l(byte[] bArr, String str, ArrayList arrayList) {
        super(SDKUrlConfig.getBiUploadServiceUrl());
        m15832a(bArr, str, arrayList);
    }

    private void m15832a(byte[] bArr, String str, ArrayList arrayList) {
        this.f12901g = str;
        this.f12902h = arrayList;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "upload_BI");
            jSONObject.put("BIType", str);
            jSONObject.put(IXAdRequestInfo.CELL_ID, C3855g.f12982t);
            jSONObject.put("BIData", new String(C3687f.m15094f(bArr, 0), HttpRequest.f14548a));
            m15799b(jSONObject.toString().getBytes());
        } catch (Exception e) {
        }
    }

    public void m15833a(byte[] bArr) {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        if (jSONObject.has("result") && ITagManager.SUCCESS.equals(jSONObject.getString("result"))) {
            C3819z.m15684a().m15688a(this.f12901g, this.f12902h);
        }
    }

    public int m15834b() {
        return 0;
    }
}
