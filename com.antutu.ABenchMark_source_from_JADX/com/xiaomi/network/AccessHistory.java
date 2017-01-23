package com.xiaomi.network;

import com.umeng.message.MsgConstant;
import org.json.JSONObject;

public class AccessHistory {
    private int f14835a;
    private long f14836b;
    private long f14837c;
    private String f14838d;
    private long f14839e;

    public AccessHistory() {
        this(0, 0, 0, null);
    }

    public AccessHistory(int i, long j, long j2, Exception exception) {
        this.f14835a = i;
        this.f14836b = j;
        this.f14839e = j2;
        this.f14837c = System.currentTimeMillis();
        if (exception != null) {
            this.f14838d = exception.getClass().getSimpleName();
        }
    }

    public int m17888a() {
        return this.f14835a;
    }

    public AccessHistory m17889a(JSONObject jSONObject) {
        this.f14836b = jSONObject.getLong("cost");
        this.f14839e = jSONObject.getLong("size");
        this.f14837c = jSONObject.getLong(MsgConstant.KEY_TS);
        this.f14835a = jSONObject.getInt("wt");
        this.f14838d = jSONObject.optString("expt");
        return this;
    }

    public JSONObject m17890b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f14836b);
        jSONObject.put("size", this.f14839e);
        jSONObject.put(MsgConstant.KEY_TS, this.f14837c);
        jSONObject.put("wt", this.f14835a);
        jSONObject.put("expt", this.f14838d);
        return jSONObject;
    }
}
