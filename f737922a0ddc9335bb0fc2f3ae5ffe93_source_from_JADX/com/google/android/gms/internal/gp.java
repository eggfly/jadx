package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import java.util.Set;
import l;

public final class gp extends gs<k> {
    private int Hw;
    private boolean v5;

    private void j6(ConnectionResult connectionResult) {
        l lVar = null;
        for (int i = 0; i < lVar.size(); i++) {
            j6((go) lVar.DW(i), connectionResult);
        }
    }

    protected /* synthetic */ e DW(Status status) {
        return j6(status);
    }

    public Set<go<?>> DW() {
        l lVar = null;
        return lVar.keySet();
    }

    protected k j6(Status status) {
        k kVar;
        synchronized (null) {
            try {
                j6(new ConnectionResult(8));
                l lVar = null;
                if (lVar.size() != 1) {
                    kVar = new k(status, null);
                }
            } finally {
            }
        }
        return kVar;
    }

    public void j6(go<?> goVar, ConnectionResult connectionResult) {
        synchronized (null) {
            l lVar = null;
            try {
                lVar.put(goVar, connectionResult);
                this.Hw--;
                boolean DW = connectionResult.DW();
                if (!DW) {
                    this.v5 = DW;
                }
                if (this.Hw == 0) {
                    Status status = this.v5 ? new Status(13) : Status.j6;
                    lVar = null;
                    DW(lVar.size() == 1 ? new j(status, null) : new k(status, null));
                }
            } finally {
            }
        }
    }
}
