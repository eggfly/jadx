package com.google.android.gms.ads.internal.client;

import agh;
import agi;
import agi$a;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.ae.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.eh;

@eh
public class q extends agi<af> {
    public q() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    protected /* synthetic */ Object DW(IBinder iBinder) {
        return j6(iBinder);
    }

    public ae j6(Context context, AdSizeParcel adSizeParcel, String str, cr crVar, int i) {
        Throwable e;
        try {
            return a.j6(((af) j6(context)).j6(agh.j6((Object) context), adSizeParcel, str, crVar, l.j6, i));
        } catch (RemoteException e2) {
            e = e2;
            b.j6("Could not create remote AdManager.", e);
            return null;
        } catch (agi$a e3) {
            e = e3;
            b.j6("Could not create remote AdManager.", e);
            return null;
        }
    }

    protected af j6(IBinder iBinder) {
        return af.a.j6(iBinder);
    }
}
