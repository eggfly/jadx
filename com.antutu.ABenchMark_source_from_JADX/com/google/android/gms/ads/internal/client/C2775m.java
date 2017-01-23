package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.ab.C2741a;
import com.google.android.gms.ads.internal.client.ac.C2743a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.dt;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p151a.C2690b;
import com.google.android.gms.p151a.C2692c;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.m */
public final class C2775m extends C2692c<ac> {
    private static final C2775m f9432a;

    static {
        f9432a = new C2775m();
    }

    private C2775m() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static ab m10712a(Context context, String str, dt dtVar) {
        if (C2784w.m10741a().m11572b(context)) {
            ab b = f9432a.m10713b(context, str, dtVar);
            if (b != null) {
                return b;
            }
        }
        C2972b.m11576a("Using AdLoader from the client jar.");
        return C2784w.m10744c().m10735a(context, str, dtVar, new VersionInfoParcel(8487000, 8487000, true));
    }

    private ab m10713b(Context context, String str, dt dtVar) {
        try {
            return C2741a.m10526a(((ac) m10264a(context)).m10527a(C2690b.m10262a((Object) context), str, dtVar, 8487000));
        } catch (Throwable e) {
            C2972b.m11584d("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            C2972b.m11584d("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected ac m10714a(IBinder iBinder) {
        return C2743a.m10529a(iBinder);
    }

    protected /* synthetic */ Object m10715b(IBinder iBinder) {
        return m10714a(iBinder);
    }
}
