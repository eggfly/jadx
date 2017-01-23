package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.g;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.signin.internal.f;

public final class hv {
    public static final g<f> DW;
    public static final b<f, hx> FH;
    static final b<f, a> Hw;
    public static final com.google.android.gms.common.api.a<hx> VH;
    public static final Scope Zo;
    public static final com.google.android.gms.common.api.a<a> gn;
    public static final g<f> j6;
    public static final Scope v5;

    class 1 extends b<f, hx> {
        1() {
        }

        public f j6(Context context, Looper looper, n nVar, hx hxVar, com.google.android.gms.common.api.GoogleApiClient.a aVar, GoogleApiClient.b bVar) {
            return new f(context, looper, true, nVar, hxVar == null ? hx.j6 : hxVar, aVar, bVar);
        }
    }

    class 2 extends b<f, a> {
        2() {
        }

        public f j6(Context context, Looper looper, n nVar, a aVar, com.google.android.gms.common.api.GoogleApiClient.a aVar2, GoogleApiClient.b bVar) {
            return new f(context, looper, false, nVar, aVar.j6(), aVar2, bVar);
        }
    }

    public static class a implements com.google.android.gms.common.api.a.a.a {
        public Bundle j6() {
            return null;
        }
    }

    static {
        j6 = new g();
        DW = new g();
        FH = new 1();
        Hw = new 2();
        v5 = new Scope("profile");
        Zo = new Scope("email");
        VH = new com.google.android.gms.common.api.a("SignIn.API", FH, j6);
        gn = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", Hw, DW);
    }
}
