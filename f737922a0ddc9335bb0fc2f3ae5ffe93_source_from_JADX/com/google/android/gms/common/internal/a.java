package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.k;

public class a extends com.google.android.gms.common.internal.v.a {
    int j6;

    public static Account j6(v vVar) {
        Account account = null;
        if (vVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = vVar.j6();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return account.equals(account);
    }

    public Account j6() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.j6) {
            if (k.DW(null, callingUid)) {
                this.j6 = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }
}
