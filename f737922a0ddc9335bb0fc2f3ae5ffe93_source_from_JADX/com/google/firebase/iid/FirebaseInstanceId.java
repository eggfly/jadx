package com.google.firebase.iid;

import agj;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import l;

public class FirebaseInstanceId {
    private static d DW;
    private static Map<String, FirebaseInstanceId> j6;
    private final agj FH;
    private final c Hw;
    private final String v5;

    static {
        j6 = new l();
    }

    private FirebaseInstanceId(agj agj, c cVar) {
        this.FH = agj;
        this.Hw = cVar;
        this.v5 = DW();
        if (this.v5 == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.j6(this.FH.j6(), this);
    }

    static int DW(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return i;
        }
    }

    static String FH(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static void Hw(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.DW(context, intent));
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(agj agj) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) j6.get(agj.FH().j6());
            if (firebaseInstanceId == null) {
                c j6 = c.j6(agj.j6(), null);
                if (DW == null) {
                    DW = new d(j6.FH());
                }
                firebaseInstanceId = new FirebaseInstanceId(agj, j6);
                j6.put(agj.FH().j6(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    public static FirebaseInstanceId j6() {
        return getInstance(agj.Hw());
    }

    static String j6(Context context) {
        return j6().FH.FH().j6();
    }

    static String j6(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String j6(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static void j6(Context context, zzg com_google_firebase_iid_zzg) {
        com_google_firebase_iid_zzg.FH();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.DW(context, intent));
    }

    String DW() {
        String DW = this.FH.FH().DW();
        if (DW != null) {
            return DW;
        }
        DW = this.FH.FH().j6();
        if (!DW.startsWith("1:")) {
            return DW;
        }
        String[] split = DW.split(":");
        if (split.length < 2) {
            return null;
        }
        DW = split[1];
        return DW.isEmpty() ? null : DW;
    }

    void DW(String str) {
        if (Hw() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        c cVar = this.Hw;
        valueOf = Hw();
        String valueOf3 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        cVar.j6(valueOf, valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3), bundle);
    }

    public String FH() {
        return j6(this.Hw.j6());
    }

    public String Hw() {
        String v5 = v5();
        if (v5 == null) {
            FirebaseInstanceIdService.j6(this.FH.j6());
        }
        return v5;
    }

    d VH() {
        return DW;
    }

    String Zo() {
        return j6(this.v5, "*");
    }

    public String j6(String str, String str2) {
        return this.Hw.DW(str, str2, null);
    }

    void j6(String str) {
        if (Hw() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        c cVar = this.Hw;
        valueOf = Hw();
        String valueOf3 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        cVar.DW(valueOf, valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3), bundle);
    }

    String v5() {
        return this.Hw.FH().j6("", this.v5, "*");
    }
}
