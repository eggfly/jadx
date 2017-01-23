package com.google.android.gms.ads.internal.client;

import agh;
import agi;
import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.ac.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.eh;

@eh
public final class p extends agi<ad> {
    public p() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    protected /* synthetic */ Object DW(IBinder iBinder) {
        return j6(iBinder);
    }

    public ac j6(Context context, String str, cr crVar) {
        try {
            return a.j6(((ad) j6(context)).j6(agh.j6((Object) context), str, crVar, l.j6));
        } catch (Throwable e) {
            b.FH("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            b.FH("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected ad j6(IBinder iBinder) {
        return ad.a.j6(iBinder);
    }
}
