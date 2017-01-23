package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public class a extends t {
    public static boolean j6;
    private com.google.android.gms.ads.identifier.AdvertisingIdClient.a DW;
    private final m FH;
    private String Hw;
    private Object Zo;
    private boolean v5;

    a(v vVar) {
        super(vVar);
        this.v5 = false;
        this.Zo = new Object();
        this.FH = new m(vVar.Hw());
    }

    private boolean VH(String str) {
        try {
            String j6 = j6(str);
            DW("Storing hashed adid.");
            FileOutputStream openFileOutput = Ws().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(j6.getBytes());
            openFileOutput.close();
            this.Hw = j6;
            return true;
        } catch (IOException e) {
            v5("Error creating hash file", e);
            return false;
        }
    }

    private synchronized com.google.android.gms.ads.identifier.AdvertisingIdClient.a Zo() {
        if (this.FH.j6(1000)) {
            this.FH.j6();
            com.google.android.gms.ads.identifier.AdvertisingIdClient.a Hw = Hw();
            if (j6(this.DW, Hw)) {
                this.DW = Hw;
            } else {
                Zo("Failed to reset client id on adid change. Not using adid");
                this.DW = new com.google.android.gms.ads.identifier.AdvertisingIdClient.a("", false);
            }
        }
        return this.DW;
    }

    private static String j6(String str) {
        if (p.DW("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, p.DW("MD5").digest(str.getBytes()))});
    }

    private boolean j6(com.google.android.gms.ads.identifier.AdvertisingIdClient.a aVar, com.google.android.gms.ads.identifier.AdvertisingIdClient.a aVar2) {
        Object obj = null;
        CharSequence j6 = aVar2 == null ? null : aVar2.j6();
        if (TextUtils.isEmpty(j6)) {
            return true;
        }
        String DW = rN().DW();
        synchronized (this.Zo) {
            String valueOf;
            String valueOf2;
            if (!this.v5) {
                this.Hw = v5();
                this.v5 = true;
            } else if (TextUtils.isEmpty(this.Hw)) {
                if (aVar != null) {
                    obj = aVar.j6();
                }
                if (obj == null) {
                    valueOf = String.valueOf(j6);
                    String valueOf3 = String.valueOf(DW);
                    boolean VH = VH(valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf));
                    return VH;
                }
                valueOf2 = String.valueOf(obj);
                valueOf = String.valueOf(DW);
                this.Hw = j6(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            }
            valueOf2 = String.valueOf(j6);
            valueOf = String.valueOf(DW);
            obj = j6(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            if (TextUtils.isEmpty(obj)) {
                return false;
            } else if (obj.equals(this.Hw)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.Hw)) {
                    valueOf = DW;
                } else {
                    DW("Resetting the client id because Advertising Id changed.");
                    obj = rN().FH();
                    j6("New client Id", obj);
                }
                String valueOf4 = String.valueOf(j6);
                valueOf3 = String.valueOf(obj);
                VH = VH(valueOf3.length() != 0 ? valueOf4.concat(valueOf3) : new String(valueOf4));
                return VH;
            }
        }
    }

    public boolean DW() {
        P8();
        com.google.android.gms.ads.identifier.AdvertisingIdClient.a Zo = Zo();
        return (Zo == null || Zo.DW()) ? false : true;
    }

    public String FH() {
        P8();
        com.google.android.gms.ads.identifier.AdvertisingIdClient.a Zo = Zo();
        CharSequence j6 = Zo != null ? Zo.j6() : null;
        return TextUtils.isEmpty(j6) ? null : j6;
    }

    protected com.google.android.gms.ads.identifier.AdvertisingIdClient.a Hw() {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.a aVar = null;
        try {
            aVar = AdvertisingIdClient.DW(Ws());
        } catch (IllegalStateException e) {
            v5("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (Throwable th) {
            if (!j6) {
                j6 = true;
                Hw("Error getting advertiser id", th);
            }
        }
        return aVar;
    }

    protected void j6() {
    }

    protected String v5() {
        Object obj;
        String str = null;
        try {
            FileInputStream openFileInput = Ws().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                v5("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                Ws().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                DW("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    str = str2;
                    IOException iOException2 = iOException;
                    Hw("Error reading Hash file, deleting it", obj);
                    Ws().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            obj = e4;
            Hw("Error reading Hash file, deleting it", obj);
            Ws().deleteFile("gaClientIdData");
            return str;
        }
    }
}
