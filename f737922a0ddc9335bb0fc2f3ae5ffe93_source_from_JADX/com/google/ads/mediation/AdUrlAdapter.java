package com.google.ads.mediation;

import aet;
import aev;
import aex;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class AdUrlAdapter extends a implements aet, aev, aex {
    protected Bundle j6(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBundle("sdk_less_server_data", bundle2);
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }

    public String j6(Bundle bundle) {
        return "adurl";
    }
}
