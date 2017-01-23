package com.google.android.gms.common.internal;

import aeq$c;
import android.content.Context;
import android.content.res.Resources;

public class zzah {
    private final String DW;
    private final Resources j6;

    public zzah(Context context) {
        b.j6((Object) context);
        this.j6 = context.getResources();
        this.DW = this.j6.getResourcePackageName(aeq$c.common_google_play_services_unknown_issue);
    }

    public String j6(String str) {
        int identifier = this.j6.getIdentifier(str, "string", this.DW);
        return identifier == 0 ? null : this.j6.getString(identifier);
    }
}
