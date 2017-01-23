package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.by;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.fj;
import java.util.Map;

@eh
public class b {
    private final Object DW;
    private Context FH;
    public final by j6;

    class 1 implements by {
        final /* synthetic */ b j6;

        1(b bVar) {
            this.j6 = bVar;
        }

        public void j6(fj fjVar, Map<String, String> map) {
            fjVar.j6("/appSettingsFetched", (by) this);
            synchronized (this.j6.DW) {
                if (map != null) {
                    if ("true".equalsIgnoreCase((String) map.get("isSuccessful"))) {
                        f.Zo().j6(this.j6.FH, (String) map.get("appSettingsJson"));
                    }
                }
            }
        }
    }

    public b() {
        this.DW = new Object();
        this.j6 = new 1(this);
    }
}
