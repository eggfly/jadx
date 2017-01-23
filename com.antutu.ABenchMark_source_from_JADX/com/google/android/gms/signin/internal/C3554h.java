package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.C3010c;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.internal.C2926i;
import com.google.android.gms.common.internal.C2926i.C3486f;
import com.google.android.gms.common.internal.C3468n;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.p146b.kc;
import com.google.android.gms.p146b.kd;
import com.google.android.gms.signin.internal.C3549e.C3551a;

/* renamed from: com.google.android.gms.signin.internal.h */
public class C3554h extends C2926i<C3549e> implements kc {
    private final boolean f12263a;
    private final C3477g f12264e;
    private final Bundle f12265f;
    private Integer f12266g;

    public C3554h(Context context, Looper looper, boolean z, C3477g c3477g, Bundle bundle, C2921b c2921b, C2922c c2922c) {
        super(context, looper, 44, c3477g, c2921b, c2922c);
        this.f12263a = z;
        this.f12264e = c3477g;
        this.f12265f = bundle;
        this.f12266g = c3477g.m14353i();
    }

    public C3554h(Context context, Looper looper, boolean z, C3477g c3477g, kd kdVar, C2921b c2921b, C2922c c2922c) {
        this(context, looper, z, c3477g, C3554h.m14798a(c3477g), c2921b, c2922c);
    }

    public static Bundle m14798a(C3477g c3477g) {
        kd h = c3477g.m14352h();
        Integer i = c3477g.m14353i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c3477g.m14344a());
        if (i != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.m13604a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.m13605b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.m13606c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.m13607d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.m13608e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.m13609f());
        }
        return bundle;
    }

    private ResolveAccountRequest m14799s() {
        Account b = this.f12264e.m14346b();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(b.name)) {
            googleSignInAccount = C3010c.m11706a(m11394m()).m11708a();
        }
        return new ResolveAccountRequest(b, this.f12266g.intValue(), googleSignInAccount);
    }

    protected C3549e m14800a(IBinder iBinder) {
        return C3551a.m14794a(iBinder);
    }

    protected String m14801a() {
        return "com.google.android.gms.signin.service.START";
    }

    public void m14802a(C3468n c3468n, boolean z) {
        try {
            ((C3549e) m11398q()).m14778a(c3468n, this.f12266g.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void m14803a(C3413d c3413d) {
        C3512u.m14581a((Object) c3413d, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((C3549e) m11398q()).m14781a(new SignInRequest(m14799s()), c3413d);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                c3413d.m14059a(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected /* synthetic */ IInterface m14804b(IBinder iBinder) {
        return m14800a(iBinder);
    }

    protected String m14805b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public void m14806c() {
        try {
            ((C3549e) m11398q()).m14774a(this.f12266g.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public boolean m14807f() {
        return this.f12263a;
    }

    public void m14808j() {
        m11380a(new C3486f(this));
    }

    protected Bundle m14809o() {
        if (!m11394m().getPackageName().equals(this.f12264e.m14350f())) {
            this.f12265f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f12264e.m14350f());
        }
        return this.f12265f;
    }
}
