package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static zzd VH;
    static String Zo;
    private static zzc gn;
    static Map<String, a> j6;
    Context DW;
    KeyPair FH;
    String Hw;
    long v5;

    static {
        j6 = new HashMap();
    }

    protected a(Context context, String str, Bundle bundle) {
        this.Hw = "";
        this.DW = context.getApplicationContext();
        this.Hw = str;
    }

    static String DW(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    public static a FH(Context context) {
        return j6(context, null);
    }

    static int j6(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return i;
        }
    }

    public static synchronized a j6(Context context, Bundle bundle) {
        a aVar;
        synchronized (a.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (VH == null) {
                VH = new zzd(applicationContext);
                gn = new zzc(applicationContext);
            }
            Zo = Integer.toString(j6(applicationContext));
            aVar = (a) j6.get(str);
            if (aVar == null) {
                aVar = new a(applicationContext, str, bundle);
                j6.put(str, aVar);
            }
        }
        return aVar;
    }

    static String j6(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String j6(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public String DW(String str, String str2, Bundle bundle) {
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

    public void DW() {
        this.v5 = 0;
        VH.Hw(this.Hw);
        this.FH = null;
    }

    public zzd FH() {
        return VH;
    }

    public zzc Hw() {
        return gn;
    }

    public String j6(String str, String str2, Bundle bundle) {
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
            j6 = DW(str, str2, bundle);
            if (!(j6 == null || r1 == null)) {
                VH.j6(this.Hw, str, str2, j6, Zo);
            }
        }
        return j6;
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
