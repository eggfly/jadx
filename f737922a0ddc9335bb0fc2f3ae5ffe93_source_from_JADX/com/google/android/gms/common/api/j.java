package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.go;
import l;

public class j extends k {
    private final ConnectionResult j6;

    public j(Status status, l<go<?>, ConnectionResult> lVar) {
        super(status, lVar);
        this.j6 = (ConnectionResult) lVar.get(lVar.DW(0));
    }
}
