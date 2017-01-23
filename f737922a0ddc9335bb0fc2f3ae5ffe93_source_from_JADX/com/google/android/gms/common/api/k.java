package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.go;
import l;

public class k implements e {
    private final l<go<?>, ConnectionResult> DW;
    private final Status j6;

    public k(Status status, l<go<?>, ConnectionResult> lVar) {
        this.j6 = status;
        this.DW = lVar;
    }

    public Status DW() {
        return this.j6;
    }
}
