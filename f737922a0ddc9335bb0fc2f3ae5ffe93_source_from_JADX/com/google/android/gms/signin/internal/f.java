package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.a;
import com.google.android.gms.common.api.GoogleApiClient.b;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.hx;

public class f extends r<d> implements hw {
    private final boolean Hw;
    private Integer VH;
    private final Bundle Zo;
    private final n v5;

    public f(Context context, Looper looper, boolean z, n nVar, Bundle bundle, a aVar, b bVar) {
        super(context, looper, 44, nVar, aVar, bVar);
        this.Hw = z;
        this.v5 = nVar;
        this.Zo = bundle;
        this.VH = nVar.Zo();
    }

    public f(Context context, Looper looper, boolean z, n nVar, hx hxVar, a aVar, b bVar) {
        this(context, looper, z, nVar, j6(nVar), aVar, bVar);
    }

    public static Bundle j6(n nVar) {
        hx v5 = nVar.v5();
        Integer Zo = nVar.Zo();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", nVar.j6());
        if (Zo != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", Zo.intValue());
        }
        if (v5 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", v5.j6());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", v5.DW());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", v5.FH());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", v5.Hw());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", v5.v5());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", v5.Zo());
        }
        return bundle;
    }

    protected d DW(IBinder iBinder) {
        return d.a.j6(iBinder);
    }

    protected String VH() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle Ws() {
        if (!we().getPackageName().equals(this.v5.FH())) {
            this.Zo.putString("com.google.android.gms.signin.internal.realClientPackageName", this.v5.FH());
        }
        return this.Zo;
    }

    protected String Zo() {
        return "com.google.android.gms.signin.service.START";
    }

    public boolean j3() {
        return this.Hw;
    }

    protected /* synthetic */ IInterface j6(IBinder iBinder) {
        return DW(iBinder);
    }
}
