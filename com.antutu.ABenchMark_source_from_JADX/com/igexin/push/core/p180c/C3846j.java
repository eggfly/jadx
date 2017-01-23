package com.igexin.push.core.p180c;

import android.content.ContentValues;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.p169f.p179a.C3836b;
import com.igexin.push.util.C3926e;
import com.igexin.sdk.PushConsts;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.j */
public class C3846j extends C3836b {
    public boolean f12897a;
    private boolean f12898g;
    private int f12899h;

    public C3846j(String str, byte[] bArr, int i, boolean z) {
        super(str);
        this.f12898g = false;
        this.f12898g = z;
        this.f12899h = i;
        m15826a(bArr, i);
    }

    private void m15826a(byte[] bArr, int i) {
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

    public void m15827a(byte[] bArr) {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        if (jSONObject.has("result")) {
            if (ITagManager.SUCCESS.equals(jSONObject.getString("result"))) {
                this.f12897a = true;
                if (this.f12899h == 10) {
                    C3926e.m16172g();
                }
                if (this.f12898g) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(C4233j.f14402y, MessageService.MSG_DB_READY_REPORT);
                    C3854f.m15859a().m15881k().m15244a("bi", contentValues, new String[]{C4233j.f14402y}, new String[]{MessageService.MSG_DB_NOTIFY_CLICK});
                    C3799f.m15623a().m15650b(System.currentTimeMillis());
                }
            }
        }
    }

    public int m15828b() {
        return 0;
    }
}
