package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.b;
import java.util.Iterator;

public class s {
    final String DW;
    final String FH;
    final long Hw;
    final EventParams Zo;
    final String j6;
    final long v5;

    s(ai aiVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        b.j6(str2);
        b.j6(str3);
        this.j6 = str2;
        this.DW = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.FH = str;
        this.Hw = j;
        this.v5 = j2;
        if (this.v5 != 0 && this.v5 > this.Hw) {
            aiVar.Zo().yS().j6("Event created with reverse previous/current timestamps");
        }
        this.Zo = j6(aiVar, bundle);
    }

    private s(ai aiVar, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        b.j6(str2);
        b.j6(str3);
        b.j6((Object) eventParams);
        this.j6 = str2;
        this.DW = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.FH = str;
        this.Hw = j;
        this.v5 = j2;
        if (this.v5 != 0 && this.v5 > this.Hw) {
            aiVar.Zo().yS().j6("Event created with reverse previous/current timestamps");
        }
        this.Zo = eventParams;
    }

    EventParams j6(ai aiVar, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                aiVar.Zo().Zo().j6("Param name can't be null");
                it.remove();
            } else {
                Object DW = aiVar.J8().DW(str, bundle2.get(str));
                if (DW == null) {
                    aiVar.Zo().yS().j6("Param value can't be null", str);
                    it.remove();
                } else {
                    aiVar.J8().j6(bundle2, str, DW);
                }
            }
        }
        return new EventParams(bundle2);
    }

    s j6(ai aiVar, long j) {
        return new s(aiVar, this.FH, this.j6, this.DW, this.Hw, j, this.Zo);
    }

    public String toString() {
        String str = this.j6;
        String str2 = this.DW;
        String valueOf = String.valueOf(this.Zo);
        return new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("'").append(", name='").append(str2).append("'").append(", params=").append(valueOf).append("}").toString();
    }
}
