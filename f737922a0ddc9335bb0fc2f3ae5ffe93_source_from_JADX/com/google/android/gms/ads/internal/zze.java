package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.eh;

@eh
public class zze {
    private final AutoClickProtectionConfigurationParcel DW;
    private boolean FH;
    private final Context j6;

    public zze(Context context) {
        this(context, false);
    }

    public zze(Context context, boolean z) {
        this.j6 = context;
        this.DW = new AutoClickProtectionConfigurationParcel(z);
    }

    public void j6(String str) {
        if (str == null) {
            str = "";
        }
        b.FH("Action was blocked because no touch was detected.");
        if (this.DW.DW && this.DW.FH != null) {
            for (String str2 : this.DW.FH) {
                if (!TextUtils.isEmpty(str2)) {
                    f.FH().j6(this.j6, "", str2.replace("{NAVIGATION_URL}", Uri.encode(str)));
                }
            }
        }
    }

    public boolean j6() {
        return !this.DW.DW || this.FH;
    }
}
