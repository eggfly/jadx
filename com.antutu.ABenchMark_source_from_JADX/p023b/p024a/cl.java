package p023b.p024a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: b.a.cl */
public class cl implements Serializable {
    private Map<String, cg> f2855a;

    public cl() {
        this.f2855a = new HashMap();
    }

    private void m3762a(String str) {
        this.f2855a.put(str, new cg(str, System.currentTimeMillis(), 1));
    }

    private void m3763b(String str) {
        this.f2855a.put(str, ((cg) this.f2855a.get(str)).m3679a());
    }

    public Map<String, cg> m3764a() {
        return this.f2855a;
    }

    public void m3765a(cd cdVar, String str) {
        if (this.f2855a.containsKey(str)) {
            m3763b(str);
        } else {
            m3762a(str);
        }
        cdVar.m3414a(this, false);
    }

    public void m3766b() {
        this.f2855a.clear();
    }
}
