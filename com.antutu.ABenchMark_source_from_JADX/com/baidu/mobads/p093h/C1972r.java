package com.baidu.mobads.p093h;

import android.text.TextUtils;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p084c.C1918a;

/* renamed from: com.baidu.mobads.h.r */
class C1972r implements Runnable {
    final /* synthetic */ C1971q f6866a;

    C1972r(C1971q c1971q) {
        this.f6866a = c1971q;
    }

    public void run() {
        try {
            String a = this.f6866a.m7362a("key_crash_trace");
            String a2 = this.f6866a.m7362a("key_crash_ad");
            if (!TextUtils.isEmpty(a)) {
                C1918a.m7217a().m7227a(this.f6866a.m7362a("key_crash_source"), a, a2);
                this.f6866a.m7368d();
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7399e(e);
        }
    }
}
