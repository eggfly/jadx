package com.igexin.push.core.p176a;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.core.p175b.C3819z;
import com.igexin.push.core.p180c.C3843g;
import com.igexin.push.p169f.p179a.C3913c;
import com.igexin.push.p174c.C3730i;
import com.igexin.push.p182d.C3875b;
import com.igexin.push.p182d.p185c.C3888m;
import com.igexin.push.util.C3926e;
import com.umeng.analytics.C4156a;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: com.igexin.push.core.a.l */
public class C3784l extends C3772a {
    public boolean m15589a(C3666d c3666d) {
        return false;
    }

    public boolean m15590a(Object obj) {
        boolean z = false;
        if (obj instanceof C3888m) {
            C3855g.f12941E = 0;
            if (!C3855g.f12976n) {
                C3730i.m15273a().m15277e().m15266h();
                if (((C3888m) obj).f13100a) {
                    C3875b.m15932a().m15942f();
                    C3688a.m15097b("loginRsp|" + C3855g.f12982t + "|success");
                    C3688a.m15097b("isCidBroadcast|" + C3855g.f12977o);
                    if (!C3855g.f12977o) {
                        C3777e.m15491a().m15563l();
                        C3855g.f12977o = true;
                    }
                    C3855g.f12976n = true;
                    C3777e.m15491a().m15564m();
                    C3777e.m15491a().m15559h();
                    if (TextUtils.isEmpty(C3855g.f12937A)) {
                        C3688a.m15097b("LoginResultAction device id is empty, get device id from server ++++++++++++");
                        C3777e.m15491a().m15560i();
                    }
                    C3926e.m16171f();
                    try {
                        long currentTimeMillis = System.currentTimeMillis() - C3855g.f12944H;
                        String d = C3777e.m15491a().m15551d("ua");
                        if (d == null || MessageService.MSG_DB_NOTIFY_REACHED.equals(d)) {
                            z = true;
                        }
                        if (z && C3754m.f12664h && currentTimeMillis - 259200000 > 0) {
                            if (!C3700a.m15132a(C3777e.m15491a().m15567p()).equals(C3777e.m15491a().m15565n()) || C3855g.f12944H == 0) {
                                C3855g.f12944H = System.currentTimeMillis();
                                C3777e.m15491a().m15566o();
                            }
                        }
                    } catch (Exception e) {
                    }
                    if ((System.currentTimeMillis() - C3855g.f12943G) - C4156a.f13948j > 0) {
                        if (TextUtils.isEmpty(C3855g.f12937A)) {
                            if (C3855g.au != null) {
                                C3855g.au.m14970t();
                                C3855g.au = null;
                            }
                            C3855g.au = new C3785m(this, 30000);
                            C3854f.m15859a().m15868a(C3855g.au);
                        } else {
                            C3777e.m15491a().m15561j();
                        }
                        C3855g.f12943G = System.currentTimeMillis();
                    }
                    try {
                        if ((System.currentTimeMillis() - C3855g.f12947K) - C4156a.f13948j > 0) {
                            C3685c.m15060b().m15053a(new C3913c(new C3843g(SDKUrlConfig.getConfigServiceUrl())), false, true);
                        }
                    } catch (Exception e2) {
                    }
                    C3799f.m15623a().m15648b();
                    C3854f.m15859a().m15878h().m16039a();
                    try {
                        if ((System.currentTimeMillis() - C3855g.f12949M) - C4156a.f13948j > 0) {
                            C3799f.m15623a().m15663f(System.currentTimeMillis());
                            C3819z.m15684a().m15690b(AgooConstants.REPORT_MESSAGE_NULL);
                        }
                    } catch (Throwable th) {
                        C3688a.m15097b("LoginResultAction|report third party guard exception :" + th.toString());
                    }
                } else {
                    C3688a.m15097b("loginRsp|" + C3855g.f12982t + "|failed");
                    C3688a.m15097b("LoginResultAction login failed, clear session or cid");
                    C3799f.m15623a().m15655c();
                    C3777e.m15491a().m15548c(true);
                }
            }
        }
        return true;
    }
}
