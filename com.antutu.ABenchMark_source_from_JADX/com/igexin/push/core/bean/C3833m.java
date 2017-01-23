package com.igexin.push.core.bean;

import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;

/* renamed from: com.igexin.push.core.bean.m */
public class C3833m extends BaseAction {
    private String f12865a;
    private boolean f12866b;
    private boolean f12867c;
    private String f12868d;

    public String m15772a() {
        return this.f12865a;
    }

    public void m15773a(String str) {
        this.f12865a = str;
    }

    public void m15774a(boolean z) {
        this.f12866b = z;
    }

    public String m15775b() {
        return this.f12868d;
    }

    public void m15776b(String str) {
        this.f12868d = str;
    }

    public void m15777b(boolean z) {
        this.f12867c = z;
    }

    public String m15778c() {
        String str = this.f12865a;
        if (this.f12866b) {
            str = str.indexOf("?") > 0 ? str + "&cid=" + C3855g.f12982t : str + "?cid=" + C3855g.f12982t;
        }
        if (!this.f12867c) {
            return str;
        }
        String m = C3854f.m15859a().m15883m();
        return m != null ? str.indexOf("?") > 0 ? str + "&nettype=" + m : str + "?nettype=" + m : str;
    }
}
