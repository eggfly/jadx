package com.google.android.gms.internal;

import agh;
import agi;
import agi$a;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.bf.a;

@eh
public class bq extends agi<bg> {
    public bq() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    protected /* synthetic */ Object DW(IBinder iBinder) {
        return j6(iBinder);
    }

    public bf j6(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return a.j6(((bg) j6(context)).j6(agh.j6((Object) context), agh.j6((Object) frameLayout), agh.j6((Object) frameLayout2), l.j6));
        } catch (RemoteException e2) {
            e = e2;
            b.FH("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (agi$a e3) {
            e = e3;
            b.FH("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected bg j6(IBinder iBinder) {
        return bg.a.j6(iBinder);
    }
}
