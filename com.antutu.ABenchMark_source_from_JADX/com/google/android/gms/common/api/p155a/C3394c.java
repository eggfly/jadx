package com.google.android.gms.common.api.p155a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.internal.C3512u;

/* renamed from: com.google.android.gms.common.api.a.c */
public class C3394c implements C2921b, C2922c {
    public final C3444a<?> f11830a;
    private final int f11831b;
    private C3430j f11832c;

    public C3394c(C3444a<?> c3444a, int i) {
        this.f11830a = c3444a;
        this.f11831b = i;
    }

    private void m13975a() {
        C3512u.m14581a(this.f11832c, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void m13976a(int i) {
        m13975a();
        this.f11832c.m14179a(i);
    }

    public void m13977a(Bundle bundle) {
        m13975a();
        this.f11832c.m14180a(bundle);
    }

    public void m13978a(ConnectionResult connectionResult) {
        m13975a();
        this.f11832c.m14182a(connectionResult, this.f11830a, this.f11831b);
    }

    public void m13979a(C3430j c3430j) {
        this.f11832c = c3430j;
    }
}
