package com.google.android.gms.internal;

import agh;
import agi;
import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.dp.a;

@eh
public final class do extends agi<dr> {
    public do() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    protected /* synthetic */ Object DW(IBinder iBinder) {
        return j6(iBinder);
    }

    public dp j6(Activity activity) {
        try {
            return a.j6(((dr) j6(activity)).j6(agh.j6((Object) activity)));
        } catch (Throwable e) {
            b.FH("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            b.FH("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected dr j6(IBinder iBinder) {
        return dr.a.j6(iBinder);
    }
}
