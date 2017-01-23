package com.igexin.push.core.p181d;

import android.content.Intent;
import com.igexin.push.core.C3855g;
import com.igexin.sdk.PushActivity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.igexin.push.core.d.b */
public class C3851b {
    private static C3851b f12914b;
    private Map f12915a;

    private C3851b() {
        this.f12915a = new HashMap();
    }

    public static C3851b m15852a() {
        if (f12914b == null) {
            f12914b = new C3851b();
        }
        return f12914b;
    }

    private void m15853d(C3850a c3850a) {
        if (c3850a != null) {
            this.f12915a.put(c3850a.m15836a(), c3850a);
        }
    }

    public C3850a m15854a(Long l) {
        return (C3850a) this.f12915a.get(l);
    }

    public void m15855a(C3850a c3850a) {
        if (c3850a != null) {
            m15853d(c3850a);
            Intent intent = new Intent(C3855g.f12969g, PushActivity.class);
            intent.putExtra("activityid", c3850a.m15836a());
            intent.setFlags(268435456);
            C3855g.f12969g.startActivity(intent);
        }
    }

    public void m15856b(C3850a c3850a) {
        if (c3850a != null) {
            c3850a.m15851i();
            m15857c(c3850a);
        }
    }

    public void m15857c(C3850a c3850a) {
        if (c3850a != null) {
            this.f12915a.remove(c3850a.m15836a());
        }
    }
}
