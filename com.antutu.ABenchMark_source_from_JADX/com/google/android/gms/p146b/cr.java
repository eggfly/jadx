package com.google.android.gms.p146b;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.C2795e;
import com.google.android.gms.ads.internal.C2836l;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@gb
/* renamed from: com.google.android.gms.b.cr */
public class cr {
    private MutableContextWrapper f10478a;
    private final du f10479b;
    private final VersionInfoParcel f10480c;
    private final C2795e f10481d;

    cr(Context context, du duVar, VersionInfoParcel versionInfoParcel, C2795e c2795e) {
        this.f10478a = new MutableContextWrapper(context.getApplicationContext());
        this.f10479b = duVar;
        this.f10480c = versionInfoParcel;
        this.f10481d = c2795e;
    }

    public C2836l m12095a(String str) {
        return new C2836l(this.f10478a, new AdSizeParcel(), str, this.f10479b, this.f10480c, this.f10481d);
    }

    public cr m12096a() {
        return new cr(this.f10478a.getBaseContext(), this.f10479b, this.f10480c, this.f10481d);
    }

    public MutableContextWrapper m12097b() {
        return this.f10478a;
    }
}
