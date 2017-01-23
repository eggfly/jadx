package com.miui.support.internal.hybrid;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PermissionManager {
    private Map<String, Boolean> f2467a;
    private Config f2468b;

    public PermissionManager(Config config) {
        this.f2467a = new HashMap();
        this.f2468b = config;
    }

    private boolean m4070b(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if ("file".equals(parse.getScheme())) {
            str2 = "*";
        } else {
            str2 = parse.getHost();
        }
        boolean z = false;
        for (Entry value : this.f2468b.m4006e().entrySet()) {
            boolean z2;
            Permission permission = (Permission) value.getValue();
            String a = permission.m4065a();
            if ("*".equals(a)) {
                a = "*";
            } else {
                a = Uri.parse(a).getHost();
            }
            if (permission.m4069b()) {
                String[] split = a.split("\\.");
                String[] split2 = str2.split("\\.");
                if (split2.length >= split.length) {
                    for (int i = 1; i <= split.length; i++) {
                        if (!split2[split2.length - i].equals(split[split.length - i])) {
                            z = false;
                            break;
                        }
                    }
                    z = true;
                }
                z2 = z;
            } else {
                z2 = str2.equals(a);
            }
            if (z2) {
                return z2;
            }
            z = z2;
        }
        return z;
    }

    public boolean m4071a(String str) {
        if (!this.f2467a.containsKey(str)) {
            this.f2467a.put(str, Boolean.valueOf(m4070b(str)));
        }
        return ((Boolean) this.f2467a.get(str)).booleanValue();
    }
}
