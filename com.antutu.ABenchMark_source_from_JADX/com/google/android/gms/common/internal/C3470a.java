package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C3465h;
import com.google.android.gms.common.internal.C3468n.C3469a;

/* renamed from: com.google.android.gms.common.internal.a */
public class C3470a extends C3469a {
    int f12051a;
    private Account f12052b;
    private Context f12053c;

    public static Account m14329a(C3468n c3468n) {
        Account account = null;
        if (c3468n != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = c3468n.m14327a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account m14330a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f12051a) {
            return this.f12052b;
        }
        if (C3465h.m14289a(this.f12053c, callingUid)) {
            this.f12051a = callingUid;
            return this.f12052b;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof C3470a) ? false : this.f12052b.equals(((C3470a) obj).f12052b);
    }
}
