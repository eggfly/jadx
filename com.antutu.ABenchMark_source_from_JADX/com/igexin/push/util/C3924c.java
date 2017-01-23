package com.igexin.push.util;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.sdk.PushConsts;
import com.umeng.message.util.HttpRequest;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* renamed from: com.igexin.push.util.c */
final class C3924c implements Runnable {
    final /* synthetic */ Context f13192a;
    final /* synthetic */ C3925d f13193b;

    C3924c(Context context, C3925d c3925d) {
        this.f13192a = context;
        this.f13193b = c3925d;
    }

    public void run() {
        boolean z = false;
        try {
            if (C3923b.m16153c(this.f13192a)) {
                C3926e.m16159a(String.valueOf(System.currentTimeMillis()).getBytes(), this.f13192a.getFilesDir().getPath() + "/" + "init_er.pid", false);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PushConsts.CMD_ACTION, "upload_BI");
                jSONObject.put("BIType", "25");
                jSONObject.put(IXAdRequestInfo.CELL_ID, MessageService.MSG_DB_READY_REPORT);
                jSONObject.put("BIData", new String(C3687f.m15094f(C3923b.m16154d(this.f13192a).getBytes(), 0), HttpRequest.f14548a));
                byte[] a = C3938q.m16196a(SDKUrlConfig.getBiUploadServiceUrl(), C3700a.m15135b(jSONObject.toString().getBytes()), 10000, 10000);
                if (a != null) {
                    String str = new String(a);
                }
                z = true;
            }
        } catch (Throwable th) {
            C3688a.m15097b("ErrorReport|report 25 ex = " + th.toString());
        }
        if (this.f13193b != null) {
            this.f13193b.m16155a(z);
        }
    }
}
