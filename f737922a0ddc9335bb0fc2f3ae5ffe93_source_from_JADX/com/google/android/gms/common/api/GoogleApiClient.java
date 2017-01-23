package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.hf;
import com.google.android.gms.internal.hv;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.hx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import l;

public abstract class GoogleApiClient {
    private static final Set<GoogleApiClient> j6;

    public static final class Builder {
        private final Set<Scope> DW;
        private int EQ;
        private final Set<Scope> FH;
        private int Hw;
        private com.google.android.gms.common.a J0;
        private com.google.android.gms.common.api.a.b<? extends hw, hx> J8;
        private final ArrayList<b> QX;
        private String VH;
        private final ArrayList<a> Ws;
        private String Zo;
        private final Map<a<?>, com.google.android.gms.common.internal.n.a> gn;
        private Account j6;
        private final Map<a<?>, com.google.android.gms.common.api.a.a> tp;
        private final Context u7;
        private View v5;
        private Looper we;

        public Builder(Context context) {
            this.DW = new HashSet();
            this.FH = new HashSet();
            this.gn = new l();
            this.tp = new l();
            this.EQ = -1;
            this.J0 = com.google.android.gms.common.a.j6();
            this.J8 = hv.FH;
            this.Ws = new ArrayList();
            this.QX = new ArrayList();
            this.u7 = context;
            this.we = context.getMainLooper();
            this.Zo = context.getPackageName();
            this.VH = context.getClass().getName();
        }

        public n j6() {
            hx hxVar = hx.j6;
            if (this.tp.containsKey(hv.VH)) {
                hxVar = (hx) this.tp.get(hv.VH);
            }
            return new n(this.j6, this.DW, this.gn, this.Hw, this.v5, this.Zo, this.VH, hxVar);
        }
    }

    public interface a {
        void j6(int i);

        void j6(Bundle bundle);
    }

    public interface b {
        void j6(ConnectionResult connectionResult);
    }

    static {
        j6 = Collections.newSetFromMap(new WeakHashMap());
    }

    public void DW(hf hfVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void j6();

    public void j6(hf hfVar) {
        throw new UnsupportedOperationException();
    }
}
