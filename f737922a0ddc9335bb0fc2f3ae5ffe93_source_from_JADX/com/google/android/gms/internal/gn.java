package com.google.android.gms.internal;

import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.e;

public abstract class gn {
    public final int DW;
    public final int j6;

    public static final class a extends gn {
        public final com.google.android.gms.internal.gq.a<? extends e, c> FH;

        public void j6(SparseArray<hg> sparseArray) {
            hg hgVar = (hg) sparseArray.get(this.j6);
            if (hgVar != null) {
                hgVar.j6(this.FH);
            }
        }

        public void j6(Status status) {
            this.FH.j6(status);
        }

        public void j6(c cVar) {
            this.FH.j6(cVar);
        }

        public boolean j6() {
            return this.FH.VH();
        }
    }

    public void j6(SparseArray<hg> sparseArray) {
    }

    public abstract void j6(Status status);

    public abstract void j6(c cVar);

    public boolean j6() {
        return true;
    }
}
