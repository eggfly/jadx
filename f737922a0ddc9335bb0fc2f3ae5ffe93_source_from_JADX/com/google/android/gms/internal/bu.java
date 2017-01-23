package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@eh
public final class bu implements by {
    private final bv j6;

    public bu(bv bvVar) {
        this.j6 = bvVar;
    }

    public void j6(fj fjVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            b.Hw("App event with no name parameter.");
        } else {
            this.j6.j6(str, (String) map.get("info"));
        }
    }
}
