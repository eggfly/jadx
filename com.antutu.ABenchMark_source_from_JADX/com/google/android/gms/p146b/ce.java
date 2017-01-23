package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.Map;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.b.ce */
public class ce implements cb {
    private final cf f10435a;

    public ce(cf cfVar) {
        this.f10435a = cfVar;
    }

    public void m12043a(ii iiVar, Map<String, String> map) {
        float parseFloat;
        boolean equals = MessageService.MSG_DB_NOTIFY_REACHED.equals(map.get("transparentBackground"));
        boolean equals2 = MessageService.MSG_DB_NOTIFY_REACHED.equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.f10435a.m10981b(equals);
                this.f10435a.m10980a(equals2, parseFloat);
            }
        } catch (Throwable e) {
            C2972b.m11580b("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.f10435a.m10981b(equals);
        this.f10435a.m10980a(equals2, parseFloat);
    }
}
