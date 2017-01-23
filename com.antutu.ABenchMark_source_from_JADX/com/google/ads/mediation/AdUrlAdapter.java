package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.C2635c;
import com.google.android.gms.ads.mediation.C2636g;
import com.google.android.gms.ads.mediation.C2637e;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class AdUrlAdapter extends C2638a implements C2635c, C2637e, C2636g {
    protected Bundle m10169a(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBundle("sdk_less_server_data", bundle2);
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }

    public String m10170a(Bundle bundle) {
        return "adurl";
    }
}
