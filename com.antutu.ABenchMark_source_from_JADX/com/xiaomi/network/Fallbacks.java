package com.xiaomi.network;

import android.text.TextUtils;
import com.taobao.accs.internal.C4103b;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class Fallbacks {
    private String host;
    private final ArrayList<Fallback> mFallbacks;

    public Fallbacks() {
        this.mFallbacks = new ArrayList();
    }

    public Fallbacks(String str) {
        this.mFallbacks = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.host = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addFallback(com.xiaomi.network.Fallback r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = 0;
        r1 = r0;
    L_0x0003:
        r0 = r2.mFallbacks;	 Catch:{ all -> 0x0031 }
        r0 = r0.size();	 Catch:{ all -> 0x0031 }
        if (r1 >= r0) goto L_0x001e;
    L_0x000b:
        r0 = r2.mFallbacks;	 Catch:{ all -> 0x0031 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0031 }
        r0 = (com.xiaomi.network.Fallback) r0;	 Catch:{ all -> 0x0031 }
        r0 = r0.m17904a(r3);	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x002d;
    L_0x0019:
        r0 = r2.mFallbacks;	 Catch:{ all -> 0x0031 }
        r0.set(r1, r3);	 Catch:{ all -> 0x0031 }
    L_0x001e:
        r0 = r2.mFallbacks;	 Catch:{ all -> 0x0031 }
        r0 = r0.size();	 Catch:{ all -> 0x0031 }
        if (r1 < r0) goto L_0x002b;
    L_0x0026:
        r0 = r2.mFallbacks;	 Catch:{ all -> 0x0031 }
        r0.add(r3);	 Catch:{ all -> 0x0031 }
    L_0x002b:
        monitor-exit(r2);
        return;
    L_0x002d:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0003;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.Fallbacks.addFallback(com.xiaomi.network.Fallback):void");
    }

    public synchronized Fallbacks fromJSON(JSONObject jSONObject) {
        this.host = jSONObject.getString(C4103b.ELECTION_KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.mFallbacks.add(new Fallback(this.host).m17892a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized Fallback getFallback() {
        Fallback fallback;
        for (int size = this.mFallbacks.size() - 1; size >= 0; size--) {
            fallback = (Fallback) this.mFallbacks.get(size);
            if (fallback.m17903a()) {
                HostManager.getInstance().setCurrentISP(fallback.m17911e());
                break;
            }
        }
        fallback = null;
        return fallback;
    }

    public ArrayList<Fallback> getFallbacks() {
        return this.mFallbacks;
    }

    public String getHost() {
        return this.host;
    }

    public synchronized void purge(boolean z) {
        for (int size = this.mFallbacks.size() - 1; size >= 0; size--) {
            Fallback fallback = (Fallback) this.mFallbacks.get(size);
            if (z) {
                if (fallback.m17909c()) {
                    this.mFallbacks.remove(size);
                }
            } else if (!fallback.m17908b()) {
                this.mFallbacks.remove(size);
            }
        }
    }

    public synchronized JSONObject toJSON() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(C4103b.ELECTION_KEY_HOST, this.host);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.mFallbacks.iterator();
        while (it.hasNext()) {
            jSONArray.put(((Fallback) it.next()).m17912f());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.host);
        stringBuilder.append("\n");
        Iterator it = this.mFallbacks.iterator();
        while (it.hasNext()) {
            stringBuilder.append((Fallback) it.next());
        }
        return stringBuilder.toString();
    }
}
