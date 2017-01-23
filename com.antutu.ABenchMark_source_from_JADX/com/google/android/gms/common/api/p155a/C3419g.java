package com.google.android.gms.common.api.p155a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import java.util.Collections;

/* renamed from: com.google.android.gms.common.api.a.g */
public class C3419g implements C3403i {
    private final C3430j f11891a;

    public C3419g(C3430j c3430j) {
        this.f11891a = c3430j;
    }

    public <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m14111a(T t) {
        this.f11891a.f11934g.f11901a.add(t);
        return t;
    }

    public void m14112a() {
        this.f11891a.m14192g();
        this.f11891a.f11934g.f11904d = Collections.emptySet();
    }

    public void m14113a(int i) {
    }

    public void m14114a(Bundle bundle) {
    }

    public void m14115a(ConnectionResult connectionResult, C3444a<?> c3444a, int i) {
    }

    public <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m14116b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public boolean m14117b() {
        return true;
    }

    public void m14118c() {
        this.f11891a.m14190e();
    }
}
