package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.internal.k.b;
import com.google.android.gms.common.internal.k.c;
import java.util.Set;

public abstract class r<T extends IInterface> extends k<T> implements f {
    private final n Hw;
    private final Account Zo;
    private final Set<Scope> v5;

    class 1 implements b {
        final /* synthetic */ a j6;

        1(a aVar) {
            this.j6 = aVar;
        }

        public void j6(int i) {
            this.j6.j6(i);
        }

        public void j6(Bundle bundle) {
            this.j6.j6(bundle);
        }
    }

    class 2 implements c {
        final /* synthetic */ GoogleApiClient.b j6;

        2(GoogleApiClient.b bVar) {
            this.j6 = bVar;
        }

        public void j6(ConnectionResult connectionResult) {
            this.j6.j6(connectionResult);
        }
    }

    protected r(Context context, Looper looper, int i, n nVar, a aVar, GoogleApiClient.b bVar) {
        this(context, looper, s.j6(context), com.google.android.gms.common.a.j6(), i, nVar, (a) b.j6((Object) aVar), (GoogleApiClient.b) b.j6((Object) bVar));
    }

    protected r(Context context, Looper looper, s sVar, com.google.android.gms.common.a aVar, int i, n nVar, a aVar2, GoogleApiClient.b bVar) {
        super(context, looper, sVar, aVar, i, j6(aVar2), j6(bVar), nVar.Hw());
        this.Hw = nVar;
        this.Zo = nVar.j6();
        this.v5 = DW(nVar.DW());
    }

    private Set<Scope> DW(Set<Scope> set) {
        Set<Scope> j6 = j6((Set) set);
        for (Scope contains : j6) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return j6;
    }

    private static b j6(a aVar) {
        return aVar == null ? null : new 1(aVar);
    }

    private static c j6(GoogleApiClient.b bVar) {
        return bVar == null ? null : new 2(bVar);
    }

    public final Account J0() {
        return this.Zo;
    }

    protected final Set<Scope> U2() {
        return this.v5;
    }

    protected Set<Scope> j6(Set<Scope> set) {
        return set;
    }
}
