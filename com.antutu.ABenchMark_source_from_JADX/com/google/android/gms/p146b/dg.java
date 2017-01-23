package com.google.android.gms.p146b;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.dg */
public class dg implements df {
    private final de f10633a;
    private final HashSet<SimpleEntry<String, cb>> f10634b;

    public dg(de deVar) {
        this.f10633a = deVar;
        this.f10634b = new HashSet();
    }

    public void m12281a() {
        Iterator it = this.f10634b.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            hf.m12982e("Unregistering eventhandler: " + ((cb) simpleEntry.getValue()).toString());
            this.f10633a.m12205b((String) simpleEntry.getKey(), (cb) simpleEntry.getValue());
        }
        this.f10634b.clear();
    }

    public void m12282a(String str, cb cbVar) {
        this.f10633a.m12202a(str, cbVar);
        this.f10634b.add(new SimpleEntry(str, cbVar));
    }

    public void m12283a(String str, String str2) {
        this.f10633a.m12203a(str, str2);
    }

    public void m12284a(String str, JSONObject jSONObject) {
        this.f10633a.m12204a(str, jSONObject);
    }

    public void m12285b(String str, cb cbVar) {
        this.f10633a.m12205b(str, cbVar);
        this.f10634b.remove(new SimpleEntry(str, cbVar));
    }

    public void m12286b(String str, JSONObject jSONObject) {
        this.f10633a.m12206b(str, jSONObject);
    }
}
