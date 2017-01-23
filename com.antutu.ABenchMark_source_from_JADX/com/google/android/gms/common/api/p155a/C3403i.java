package com.google.android.gms.common.api.p155a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;

/* renamed from: com.google.android.gms.common.api.a.i */
public interface C3403i {
    <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m14030a(T t);

    void m14031a();

    void m14032a(int i);

    void m14033a(Bundle bundle);

    void m14034a(ConnectionResult connectionResult, C3444a<?> c3444a, int i);

    <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m14035b(T t);

    boolean m14036b();

    void m14037c();
}
