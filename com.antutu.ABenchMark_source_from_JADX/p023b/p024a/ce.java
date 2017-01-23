package p023b.p024a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: b.a.ce */
public class ce implements Serializable {
    private Map<List<String>, cf> f2805a;
    private long f2806b;

    /* renamed from: b.a.ce.1 */
    class C08451 extends cd {
        final /* synthetic */ cd f2803a;
        final /* synthetic */ ce f2804b;

        C08451(ce ceVar, cd cdVar) {
            this.f2804b = ceVar;
            this.f2803a = cdVar;
        }

        public void m3649a(Object obj, boolean z) {
            cf cfVar = (cf) obj;
            this.f2804b.f2805a.remove(cfVar.m3662a());
            this.f2804b.f2805a.put(cfVar.m3668b(), cfVar);
            this.f2803a.m3414a(this, false);
        }
    }

    public ce() {
        this.f2805a = new HashMap();
        this.f2806b = 0;
    }

    private void m3651a(cd cdVar, ch chVar, List<String> list) {
        if (m3659a((List) list)) {
            m3655a(cdVar, chVar);
        } else {
            m3657a(cdVar, (List) list, chVar);
        }
    }

    private void m3652a(cf cfVar, cf cfVar2) {
        cfVar2.m3673c(cfVar2.m3677g() + cfVar.m3677g());
        cfVar2.m3669b(cfVar2.m3676f() + cfVar.m3676f());
        cfVar2.m3663a(cfVar2.m3675e() + cfVar.m3675e());
        for (int i = 0; i < cfVar.m3674d().size(); i++) {
            cfVar2.m3666a((String) cfVar.m3674d().get(i));
        }
    }

    private void m3653b(Map<List<String>, cf> map) {
        ArrayList arrayList = new ArrayList();
        arrayList = new ArrayList();
        Iterator it = this.f2805a.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            List list = (List) entry.getKey();
            Iterator it2 = this.f2805a.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry2 = (Entry) it2.next();
                List list2 = (List) entry.getKey();
                if (list.equals(list2)) {
                    cf cfVar = (cf) entry2.getValue();
                    m3652a((cf) entry.getValue(), cfVar);
                    this.f2805a.remove(list);
                    this.f2805a.put(list, cfVar);
                } else {
                    this.f2805a.put(list2, entry2.getValue());
                }
            }
        }
    }

    public Map<List<String>, cf> m3654a() {
        return this.f2805a;
    }

    public void m3655a(cd cdVar, ch chVar) {
        try {
            if (m3659a(chVar.m3684a())) {
                cf cfVar = (cf) this.f2805a.get(chVar.m3684a());
                if (cfVar != null) {
                    cfVar.m3664a(new C08451(this, cdVar), chVar);
                    return;
                } else {
                    m3657a(cdVar, chVar.m3684a(), chVar);
                    return;
                }
            }
            m3657a(cdVar, chVar.m3684a(), chVar);
        } catch (Exception e) {
            ap.m3391d("aggregated faild!");
        }
    }

    public void m3656a(cd cdVar, ch chVar, List<String> list, List<String> list2) {
        while (list.size() >= 1) {
            try {
                if (list.size() == 1) {
                    if (m3660a((List) list2, (List) list)) {
                        m3651a(cdVar, chVar, (List) list);
                        return;
                    } else {
                        cdVar.m3414a(Boolean.valueOf(false), false);
                        return;
                    }
                } else if (m3660a((List) list2, (List) list)) {
                    m3651a(cdVar, chVar, (List) list);
                    return;
                } else {
                    list.remove(list.size() - 1);
                }
            } catch (Exception e) {
                ap.m3391d("overFlowAggregated faild");
                return;
            }
        }
    }

    public void m3657a(cd cdVar, List<String> list, ch chVar) {
        cf cfVar = new cf();
        cfVar.m3665a(chVar);
        this.f2805a.put(list, cfVar);
        cdVar.m3414a(this, false);
    }

    public void m3658a(Map<List<String>, cf> map) {
        if (this.f2805a.size() <= 0) {
            this.f2805a = map;
        } else {
            m3653b(map);
        }
    }

    public boolean m3659a(List<?> list) {
        return this.f2805a != null && this.f2805a.containsKey(list);
    }

    public boolean m3660a(List<String> list, List<String> list2) {
        if (list == null || list.size() == 0) {
            return false;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < list.size() - 1; i++) {
            arrayList.add(br.m3620a((String) list.get(i)));
        }
        return (list == null || list.size() == 0) ? false : arrayList.contains(list2);
    }

    public void m3661b() {
        this.f2805a.clear();
    }
}
