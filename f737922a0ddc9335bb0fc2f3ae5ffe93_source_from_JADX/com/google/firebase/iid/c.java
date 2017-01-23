package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static zzg VH;
    static String Zo;
    private static zzf gn;
    static Map<String, c> j6;
    Context DW;
    KeyPair FH;
    String Hw;
    long v5;

    static {
        j6 = new HashMap();
    }

    protected c(Context context, String str, Bundle bundle) {
        this.Hw = "";
        this.DW = context.getApplicationContext();
        this.Hw = str;
    }

    public static synchronized c j6(Context context, Bundle bundle) {
        c cVar;
        synchronized (c.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (VH == null) {
                VH = new zzg(applicationContext);
                gn = new zzf(applicationContext);
            }
            Zo = Integer.toString(FirebaseInstanceId.DW(applicationContext));
            cVar = (c) j6.get(str);
            if (cVar == null) {
                cVar = new c(applicationContext, str, bundle);
                j6.put(str, cVar);
            }
        }
        return cVar;
    }

    public String DW(String str, String str2, Bundle bundle) {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj2 = 1;
        String j6 = v5() ? null : VH.j6(this.Hw, str, str2);
        if (j6 == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(bundle.getString("type"))) {
                obj = obj2;
            }
            j6 = FH(str, str2, bundle);
            if (!(j6 == null || r1 == null)) {
                VH.j6(this.Hw, str, str2, j6, Zo);
            }
        }
        return j6;
    }

    public void DW() {
        this.v5 = 0;
        VH.Hw(this.Hw);
        this.FH = null;
    }

    public zzg FH() {
        return VH;
    }

    public String FH(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.Hw) ? str : this.Hw;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return gn.DW(gn.j6(bundle, j6()));
    }

    public zzf Hw() {
        return gn;
    }

    KeyPair j6() {
        if (this.FH == null) {
            this.FH = VH.FH(this.Hw);
        }
        if (this.FH == null) {
            this.v5 = System.currentTimeMillis();
            this.FH = VH.j6(this.Hw, this.v5);
        }
        return this.FH;
    }

    public void j6(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        VH.DW(this.Hw, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.Hw) ? str : this.Hw);
        String str3 = "X-subtype";
        if (!"".equals(this.Hw)) {
            str = this.Hw;
        }
        bundle.putString(str3, str);
        gn.DW(gn.j6(bundle, j6()));
    }

    boolean v5() {
        String j6 = VH.j6("appVersion");
        if (j6 == null || !j6.equals(Zo)) {
            return true;
        }
        j6 = VH.j6("lastToken");
        if (j6 == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(j6)).longValue() > 604800;
    }
}
