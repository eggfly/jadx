package com.google.android.gms.internal;

import agh;
import agi;
import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.dv.a;

@eh
public final class ea extends agi<dw> {
    public ea() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    protected /* synthetic */ Object DW(IBinder iBinder) {
        return j6(iBinder);
    }

    public dv j6(Activity activity) {
        try {
            return a.j6(((dw) j6(activity)).j6(agh.j6((Object) activity)));
        } catch (Throwable e) {
            b.FH("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            b.FH("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected dw j6(IBinder iBinder) {
        return dw.a.j6(iBinder);
    }
}
