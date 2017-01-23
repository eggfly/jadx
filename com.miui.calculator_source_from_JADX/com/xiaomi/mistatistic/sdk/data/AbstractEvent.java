package com.xiaomi.mistatistic.sdk.data;

import org.json.JSONObject;

public abstract class AbstractEvent {
    protected long f4808a;

    public abstract String m6541a();

    public abstract JSONObject m6542b();

    public abstract StatEventPojo m6543c();

    public AbstractEvent() {
        this.f4808a = System.currentTimeMillis();
    }
}
