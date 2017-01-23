package com.google.android.gms.common.api.p155a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.common.api.a.m */
public interface C3398m {

    /* renamed from: com.google.android.gms.common.api.a.m.a */
    public interface C3395a {
        void m13980a(int i, boolean z);

        void m13981a(Bundle bundle);

        void m13982a(ConnectionResult connectionResult);
    }

    <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m13989a(T t);

    void m13990a();

    void m13991a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m13992b(T t);

    boolean m13993b();

    boolean m13994c();

    void m13995d();
}
