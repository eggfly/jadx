package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.c;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class zzd {
    Context DW;
    SharedPreferences j6;

    public zzd(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public zzd(Context context, String str) {
        this.DW = context;
        this.j6 = context.getSharedPreferences(str, 4);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        VH(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private String DW(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    private void VH(String str) {
        File file = new File(new c().j6(this.DW), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !j6()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    InstanceIDListenerService.j6(this.DW, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String str2 = "InstanceID/Store";
                    String str3 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
            }
        }
    }

    public synchronized void DW() {
        this.j6.edit().clear().commit();
    }

    public synchronized void DW(String str) {
        Editor edit = this.j6.edit();
        for (String str2 : this.j6.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public KeyPair FH(String str) {
        return Zo(str);
    }

    void Hw(String str) {
        DW(String.valueOf(str).concat("|"));
    }

    KeyPair Zo(String str) {
        Object e;
        String j6 = j6(str, "|P|");
        String j62 = j6(str, "|K|");
        if (j62 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(j6, 8);
            byte[] decode2 = Base64.decode(j62, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            j6 = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(j6).length() + 19).append("Invalid key stored ").append(j6).toString());
            InstanceIDListenerService.j6(this.DW, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            j6 = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(j6).length() + 19).append("Invalid key stored ").append(j6).toString());
            InstanceIDListenerService.j6(this.DW, this);
            return null;
        }
    }

    synchronized String j6(String str) {
        return this.j6.getString(str, null);
    }

    synchronized String j6(String str, String str2) {
        SharedPreferences sharedPreferences;
        String valueOf;
        sharedPreferences = this.j6;
        valueOf = String.valueOf("|S|");
        return sharedPreferences.getString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), null);
    }

    public synchronized String j6(String str, String str2, String str3) {
        return this.j6.getString(DW(str, str2, str3), null);
    }

    synchronized KeyPair j6(String str, long j) {
        KeyPair j6;
        j6 = b.j6();
        Editor edit = this.j6.edit();
        j6(edit, str, "|P|", a.j6(j6.getPublic().getEncoded()));
        j6(edit, str, "|K|", a.j6(j6.getPrivate().getEncoded()));
        j6(edit, str, "cre", Long.toString(j));
        edit.commit();
        return j6;
    }

    synchronized void j6(Editor editor, String str, String str2, String str3) {
        String valueOf = String.valueOf("|S|");
        editor.putString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), str3);
    }

    public synchronized void j6(String str, String str2, String str3, String str4, String str5) {
        String DW = DW(str, str2, str3);
        Editor edit = this.j6.edit();
        edit.putString(DW, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    public boolean j6() {
        return this.j6.getAll().isEmpty();
    }

    public void v5(String str) {
        DW(String.valueOf(str).concat("|T|"));
    }
}
