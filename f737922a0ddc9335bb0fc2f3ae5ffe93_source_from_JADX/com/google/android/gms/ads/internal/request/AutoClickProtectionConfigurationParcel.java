package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;
import java.util.Collections;
import java.util.List;

@eh
public final class AutoClickProtectionConfigurationParcel extends AbstractSafeParcelable {
    public static final d CREATOR;
    public final boolean DW;
    public final List<String> FH;
    public final int j6;

    static {
        CREATOR = new d();
    }

    public AutoClickProtectionConfigurationParcel() {
        this(1, false, Collections.emptyList());
    }

    public AutoClickProtectionConfigurationParcel(int i, boolean z, List<String> list) {
        this.j6 = i;
        this.DW = z;
        this.FH = list;
    }

    public AutoClickProtectionConfigurationParcel(boolean z) {
        this(1, z, Collections.emptyList());
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.j6(this, parcel, i);
    }
}
