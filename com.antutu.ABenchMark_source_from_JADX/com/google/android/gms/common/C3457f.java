package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.antutu.redacc.C1692R;
import com.google.android.gms.common.internal.C3495m;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.f */
public class C3457f {
    public static final int f12001a;
    private static final C3457f f12002b;

    static {
        f12001a = C3465h.f12008a;
        f12002b = new C3457f();
    }

    C3457f() {
    }

    public static C3457f m14269a() {
        return f12002b;
    }

    private String m14270b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f12001a);
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int m14271a(Context context) {
        int a = C3465h.m14286a(context);
        return C3465h.m14296b(context, a) ? 18 : a;
    }

    public Intent m14272a(Context context, int i, String str) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return C3495m.m14416a("com.google.android.gms", m14270b(context, str));
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return C3495m.m14415a("com.google.android.gms");
            case C1692R.styleable.AppCompatTheme_dialogTheme /*42*/:
                return C3495m.m14414a();
            default:
                return null;
        }
    }

    public boolean m14273a(int i) {
        return C3465h.m14295b(i);
    }

    public boolean m14274a(Context context, int i) {
        return C3465h.m14296b(context, i);
    }

    public boolean m14275a(Context context, String str) {
        return C3465h.m14291a(context, str);
    }

    @Deprecated
    public Intent m14276b(int i) {
        return m14272a(null, i, null);
    }

    public void m14277b(Context context) {
        C3465h.m14294b(context);
    }

    public int m14278c(Context context) {
        return C3465h.m14300e(context);
    }
}
