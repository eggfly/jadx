package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.ad.C2729a;
import com.google.android.gms.ads.internal.client.ae.C2746a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.dt;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p151a.C2690b;
import com.google.android.gms.p151a.C2692c;
import com.google.android.gms.p151a.C2692c.C2691a;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.n */
public class C2776n extends C2692c<ae> {
    public C2776n() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private ad m10716a(Context context, AdSizeParcel adSizeParcel, String str, dt dtVar, int i) {
        Throwable e;
        try {
            return C2729a.m10415a(((ae) m10264a(context)).m10552a(C2690b.m10262a((Object) context), adSizeParcel, str, dtVar, 8487000, i));
        } catch (RemoteException e2) {
            e = e2;
            C2972b.m11577a("Could not create remote AdManager.", e);
            return null;
        } catch (C2691a e3) {
            e = e3;
            C2972b.m11577a("Could not create remote AdManager.", e);
            return null;
        }
    }

    public ad m10717a(Context context, AdSizeParcel adSizeParcel, String str, dt dtVar) {
        if (C2784w.m10741a().m11572b(context)) {
            ad a = m10716a(context, adSizeParcel, str, dtVar, 1);
            if (a != null) {
                return a;
            }
        }
        C2972b.m11576a("Using BannerAdManager from the client jar.");
        return C2784w.m10744c().m10736a(context, adSizeParcel, str, dtVar, new VersionInfoParcel(8487000, 8487000, true));
    }

    protected ae m10718a(IBinder iBinder) {
        return C2746a.m10555a(iBinder);
    }

    public ad m10719b(Context context, AdSizeParcel adSizeParcel, String str, dt dtVar) {
        if (C2784w.m10741a().m11572b(context)) {
            ad a = m10716a(context, adSizeParcel, str, dtVar, 2);
            if (a != null) {
                return a;
            }
        }
        C2972b.m11583d("Using InterstitialAdManager from the client jar.");
        return C2784w.m10744c().m10739b(context, adSizeParcel, str, dtVar, new VersionInfoParcel(8487000, 8487000, true));
    }

    protected /* synthetic */ Object m10720b(IBinder iBinder) {
        return m10718a(iBinder);
    }
}
