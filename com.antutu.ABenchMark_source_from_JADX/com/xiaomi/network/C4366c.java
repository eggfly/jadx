package com.xiaomi.network;

import com.taobao.accs.internal.C4103b;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.network.c */
class C4366c implements Comparable<C4366c> {
    String f14864a;
    protected int f14865b;
    private final LinkedList<AccessHistory> f14866c;
    private long f14867d;

    public C4366c() {
        this(null, 0);
    }

    public C4366c(String str, int i) {
        this.f14866c = new LinkedList();
        this.f14867d = 0;
        this.f14864a = str;
        this.f14865b = i;
    }

    public int m17938a(C4366c c4366c) {
        return c4366c == null ? 1 : c4366c.f14865b - this.f14865b;
    }

    public synchronized C4366c m17939a(JSONObject jSONObject) {
        this.f14867d = jSONObject.getLong("tt");
        this.f14865b = jSONObject.getInt("wt");
        this.f14864a = jSONObject.getString(C4103b.ELECTION_KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f14866c.add(new AccessHistory().m17889a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject m17940a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f14867d);
        jSONObject.put("wt", this.f14865b);
        jSONObject.put(C4103b.ELECTION_KEY_HOST, this.f14864a);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f14866c.iterator();
        while (it.hasNext()) {
            jSONArray.put(((AccessHistory) it.next()).m17890b());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    protected synchronized void m17941a(AccessHistory accessHistory) {
        if (accessHistory != null) {
            this.f14866c.add(accessHistory);
            int a = accessHistory.m17888a();
            if (a > 0) {
                this.f14865b += accessHistory.m17888a();
            } else {
                int i = 0;
                int size = this.f14866c.size() - 1;
                while (size >= 0 && ((AccessHistory) this.f14866c.get(size)).m17888a() < 0) {
                    i++;
                    size--;
                }
                this.f14865b += a * i;
            }
            if (this.f14866c.size() > 30) {
                this.f14865b -= ((AccessHistory) this.f14866c.remove()).m17888a();
            }
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m17938a((C4366c) obj);
    }

    public String toString() {
        return this.f14864a + ":" + this.f14865b;
    }
}
