package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    public boolean DW(String str) {
        return false;
    }

    public final int describeContents() {
        return 0;
    }

    public Object j6(String str) {
        return null;
    }
}
