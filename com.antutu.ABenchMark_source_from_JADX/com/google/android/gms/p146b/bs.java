package com.google.android.gms.p146b;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.bh.C2766a;
import com.google.android.gms.p146b.bi.C3045a;
import com.google.android.gms.p151a.C2690b;
import com.google.android.gms.p151a.C2692c;
import com.google.android.gms.p151a.C2692c.C2691a;

@gb
/* renamed from: com.google.android.gms.b.bs */
public class bs extends C2692c<bi> {
    public bs() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private bh m11952b(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return C2766a.m10690a(((bi) m10264a(context)).m11891a(C2690b.m10262a((Object) context), C2690b.m10262a((Object) frameLayout), C2690b.m10262a((Object) frameLayout2), 8487000));
        } catch (RemoteException e2) {
            e = e2;
            C2972b.m11584d("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (C2691a e3) {
            e = e3;
            C2972b.m11584d("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    public bh m11953a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        if (C2784w.m10741a().m11572b(context)) {
            bh b = m11952b(context, frameLayout, frameLayout2);
            if (b != null) {
                return b;
            }
        }
        C2972b.m11576a("Using NativeAdViewDelegate from the client jar.");
        return C2784w.m10744c().m10737a(frameLayout, frameLayout2);
    }

    protected bi m11954a(IBinder iBinder) {
        return C3045a.m11893a(iBinder);
    }

    protected /* synthetic */ Object m11955b(IBinder iBinder) {
        return m11954a(iBinder);
    }
}
