package com.igexin.push.core.p176a;

import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.p169f.p170b.C3917b;
import com.igexin.push.p182d.p185c.C3877a;
import com.igexin.push.p182d.p185c.C3879c;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.core.a.d */
public class C3775d extends C3772a {
    private static final String f12698a;

    static {
        f12698a = C3753l.f12646a;
    }

    private void m15482a(String str, C3877a c3877a) {
        String str2 = BuildConfig.FLAVOR;
        str2 = BuildConfig.FLAVOR;
        str2 = BuildConfig.FLAVOR;
        if (str != null) {
            str2 = str.substring("CDN".length(), str.length());
            if (str2.contains("@")) {
                String[] split = str2.split("\\@");
                String str3 = split[0];
                if (split[1].contains("|")) {
                    split = split[1].split("\\|");
                    String str4 = split[0];
                    str2 = split[1];
                    if (str3 != null && str4 != null && str2 != null) {
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setAppid(C3855g.f12963a);
                        pushTaskBean.setMessageId(str3);
                        pushTaskBean.setTaskId(str4);
                        pushTaskBean.setId(str3);
                        pushTaskBean.setAppKey(C3855g.f12964b);
                        pushTaskBean.setCurrentActionid(1);
                        C3777e.m15491a().m15516a(pushTaskBean);
                        C3777e.m15491a().m15520a(str2, c3877a, pushTaskBean);
                    }
                }
            }
        }
    }

    public boolean m15483a(C3666d c3666d) {
        return super.m15478a(c3666d);
    }

    public boolean m15484a(Object obj) {
        if (obj instanceof C3877a) {
            C3877a c3877a = (C3877a) obj;
            if (c3877a.f13039c != null) {
                String str = (String) c3877a.f13039c;
                C3688a.m15097b("cdnpushmessage|" + str);
                if (str.startsWith("RCV")) {
                    String substring = str.substring("RCV".length(), str.length());
                    if (C3855g.ak.containsKey(substring)) {
                        C3879c c3879c = (C3879c) C3855g.ak.get(substring);
                        C3855g.ak.remove(substring);
                        if (c3879c != null) {
                            C3917b e = c3879c.m15963e();
                            if (e != null) {
                                e.m14970t();
                            }
                        }
                    }
                } else if (str.contains("CDN")) {
                    m15482a(str, c3877a);
                }
            }
        }
        return true;
    }
}
