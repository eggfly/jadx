package com.google.android.gms.clearcut;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.a.g;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gk;

public final class a {
    public static final b<gk, com.google.android.gms.common.api.a.a.b> DW;
    public static final com.google.android.gms.common.api.a<com.google.android.gms.common.api.a.a.b> FH;
    public static final b Hw;
    public static final g<gk> j6;

    class 1 extends b<gk, com.google.android.gms.common.api.a.a.b> {
        1() {
        }

        public /* synthetic */ f j6(Context context, Looper looper, n nVar, Object obj, com.google.android.gms.common.api.GoogleApiClient.a aVar, GoogleApiClient.b bVar) {
            return j6(context, looper, nVar, (com.google.android.gms.common.api.a.a.b) obj, aVar, bVar);
        }

        public gk j6(Context context, Looper looper, n nVar, com.google.android.gms.common.api.a.a.b bVar, com.google.android.gms.common.api.GoogleApiClient.a aVar, GoogleApiClient.b bVar2) {
            return new gk(context, looper, nVar, aVar, bVar2);
        }
    }

    public interface a {
    }

    static {
        j6 = new g();
        DW = new 1();
        FH = new com.google.android.gms.common.api.a("ClearcutLogger.API", DW, j6);
        Hw = new gj();
    }
}
