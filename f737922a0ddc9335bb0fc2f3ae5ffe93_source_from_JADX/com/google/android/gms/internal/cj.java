package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.i;
import java.util.Map;
import java.util.concurrent.Future;

@eh
public class cj implements by {
    public void j6(fj fjVar, Map<String, String> map) {
        ch EQ = f.EQ();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                b.Hw("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : "";
            if (EQ.DW(fjVar)) {
                b.Hw("Precache task already running.");
                return;
            }
            i.j6(fjVar.u7());
            Future future = (Future) new cg(fjVar, fjVar.u7().j6.j6(fjVar, parseInt, str2), str).FH();
        } else if (!EQ.j6(fjVar)) {
            b.Hw("Precache abort but no preload task running.");
        }
    }
}
