package com.igexin.push.core.p180c;

import com.igexin.p158b.p159a.p160a.C3658a;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.p169f.p179a.C3836b;
import com.igexin.push.p182d.p185c.C3876e;
import com.igexin.push.p182d.p185c.C3877a;
import com.igexin.push.p182d.p185c.C3879c;
import com.igexin.sdk.PushConsts;
import java.util.Timer;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.c */
public class C3839c extends C3836b {
    private String f12883a;
    private String f12884g;
    private C3877a f12885h;
    private PushTaskBean f12886i;

    public C3839c(String str, C3877a c3877a, PushTaskBean pushTaskBean) {
        super(str);
        this.f12884g = str;
        this.f12883a = pushTaskBean.getMessageId();
        this.f12885h = c3877a;
        this.f12886i = pushTaskBean;
    }

    protected void m15811a(PushTaskBean pushTaskBean, C3877a c3877a) {
        C3876e c3879c = new C3879c();
        c3879c.m15957a();
        c3879c.f13053c = "RTV" + pushTaskBean.getMessageId() + "@" + pushTaskBean.getTaskId();
        c3879c.f13054d = C3855g.f12982t;
        c3879c.f13051a = (int) System.currentTimeMillis();
        C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3879c);
        C3688a.m15097b("cdnRetrieve|" + pushTaskBean.getMessageId() + "|" + pushTaskBean.getTaskId());
        if (c3877a.m15953c() < 2) {
            long k = C3777e.m15491a().m15562k();
            Timer timer = new Timer();
            timer.schedule(new C3841e(this, pushTaskBean, c3877a), k);
            C3855g.aj.put(pushTaskBean.getTaskId(), timer);
        }
    }

    public void m15812a(Exception exception) {
        if (this.f12885h.m15949a() < 2) {
            new Timer().schedule(new C3840d(this), C3777e.m15491a().m15562k());
            return;
        }
        m15811a(this.f12886i, this.f12885h);
    }

    public void m15813a(byte[] bArr) {
        if (bArr != null) {
            byte[] d = C3687f.m15092d(C3658a.m14937c(bArr, C3855g.f12965c));
            if (d != null) {
                JSONObject jSONObject = new JSONObject(new String(d, "utf-8"));
                jSONObject.put(AgooConstants.MESSAGE_ID, this.f12883a);
                jSONObject.put("messageid", this.f12883a);
                jSONObject.put("cdnType", true);
                d = null;
                try {
                    if ("pushmessage".equals(jSONObject.getString(PushConsts.CMD_ACTION))) {
                        if (jSONObject.has("extraData")) {
                            d = jSONObject.getString("extraData").getBytes();
                        }
                        C3777e.m15491a().m15534a(jSONObject, d, true);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            throw new Exception("Get error CDNData, can not UnGzip it...");
        }
    }

    public int m15814b() {
        return 0;
    }
}
