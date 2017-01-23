package com.igexin.push.p182d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.igexin.p158b.p159a.p161b.C3667e;
import com.igexin.p158b.p159a.p161b.C3683b;
import com.igexin.p158b.p159a.p161b.p162a.p163a.C3678k;
import com.igexin.p158b.p159a.p165d.p166a.C3689b;

/* renamed from: com.igexin.push.d.a */
public class C3870a implements C3689b {
    public ConnectivityManager f13021a;
    public Context f13022b;

    public C3870a(Context context, ConnectivityManager connectivityManager) {
        this.f13021a = connectivityManager;
        this.f13022b = context;
    }

    public C3667e m15924a(String str, Integer num, C3683b c3683b) {
        if (!str.startsWith("socket") || this.f13021a == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = this.f13021a.getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) ? null : new C3678k(str, c3683b);
    }
}
