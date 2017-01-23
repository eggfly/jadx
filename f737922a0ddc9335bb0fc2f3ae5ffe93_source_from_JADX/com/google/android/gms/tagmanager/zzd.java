package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

class zzd implements b {
    private final Context j6;

    public zzd(Context context) {
        this.j6 = context;
    }

    public void j6(Map<String, Object> map) {
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null) {
            obj = map.get("gtm");
            if (obj != null && (obj instanceof Map)) {
                obj = ((Map) obj).get("url");
                if (obj != null && (obj instanceof String)) {
                    String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
                    if (queryParameter != null) {
                        q.FH(this.j6, queryParameter);
                        return;
                    }
                    return;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
        }
    }
}
