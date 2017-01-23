package com.baidu.mobads.openad.p079d;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.openad.d.b */
public class C1899b implements IOAdEvent {
    public static final String COMPLETE = "complete";
    public static final String EVENT_MESSAGE = "message";
    private final String f6538a;
    private final HashMap<String, Object> f6539b;
    private final int f6540c;
    private Object f6541d;

    public C1899b(String str) {
        this(str, 0, new HashMap());
    }

    public C1899b(String str, int i) {
        this(str, i, new HashMap());
    }

    public C1899b(String str, int i, String str2) {
        this(str, i, new HashMap());
        this.f6539b.put(EVENT_MESSAGE, str2);
    }

    public C1899b(String str, int i, HashMap<String, Object> hashMap) {
        this.f6538a = str;
        this.f6540c = i;
        this.f6539b = hashMap;
    }

    public C1899b(String str, String str2) {
        this(str, 0, str2);
    }

    public C1899b(String str, HashMap<String, Object> hashMap) {
        this(str, 0, (HashMap) hashMap);
    }

    public int getCode() {
        return this.f6540c;
    }

    public HashMap<String, Object> getData() {
        return this.f6539b;
    }

    public String getMessage() {
        try {
            return (String) this.f6539b.get(EVENT_MESSAGE);
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public Object getTarget() {
        return this.f6541d;
    }

    public String getType() {
        return this.f6538a;
    }

    public void setTarget(Object obj) {
        this.f6541d = obj;
    }
}
