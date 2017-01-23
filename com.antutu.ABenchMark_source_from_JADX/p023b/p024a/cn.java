package p023b.p024a;

import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.android.agoo.message.MessageService;

/* renamed from: b.a.cn */
public abstract class cn {
    private final int f2730a;
    private final int f2731b;
    private final String f2732c;
    private List<ac> f2733d;
    private ad f2734e;

    public cn(String str) {
        this.f2730a = 10;
        this.f2731b = 20;
        this.f2732c = str;
    }

    private boolean m3477g() {
        ad adVar = this.f2734e;
        String a = adVar == null ? null : adVar.m3135a();
        int d = adVar == null ? 0 : adVar.m3143d();
        String a2 = m3479a(m3478a());
        if (a2 == null || a2.equals(a)) {
            return false;
        }
        if (adVar == null) {
            adVar = new ad();
        }
        adVar.m3134a(a2);
        adVar.m3133a(System.currentTimeMillis());
        adVar.m3132a(d + 1);
        ac acVar = new ac();
        acVar.m3103a(this.f2732c);
        acVar.m3111c(a2);
        acVar.m3107b(a);
        acVar.m3102a(adVar.m3138b());
        if (this.f2733d == null) {
            this.f2733d = new ArrayList(2);
        }
        this.f2733d.add(acVar);
        if (this.f2733d.size() > 10) {
            this.f2733d.remove(0);
        }
        this.f2734e = adVar;
        return true;
    }

    public abstract String m3478a();

    public String m3479a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        return (trim.length() == 0 || MessageService.MSG_DB_READY_REPORT.equals(trim) || UtilityImpl.NET_TYPE_UNKNOWN.equals(trim.toLowerCase(Locale.US))) ? null : trim;
    }

    public void m3480a(ae aeVar) {
        this.f2734e = (ad) aeVar.m3165a().get(this.f2732c);
        List<ac> b = aeVar.m3168b();
        if (b != null && b.size() > 0) {
            if (this.f2733d == null) {
                this.f2733d = new ArrayList();
            }
            for (ac acVar : b) {
                if (this.f2732c.equals(acVar.f2539a)) {
                    this.f2733d.add(acVar);
                }
            }
        }
    }

    public void m3481a(List<ac> list) {
        this.f2733d = list;
    }

    public boolean m3482b() {
        return m3477g();
    }

    public String m3483c() {
        return this.f2732c;
    }

    public boolean m3484d() {
        return this.f2734e == null || this.f2734e.m3143d() <= 20;
    }

    public ad m3485e() {
        return this.f2734e;
    }

    public List<ac> m3486f() {
        return this.f2733d;
    }
}
