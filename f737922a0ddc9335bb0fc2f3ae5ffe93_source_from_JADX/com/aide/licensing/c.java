package com.aide.licensing;

import android.content.Context;
import com.aide.uidesigner.ProxyTextView;
import im;
import in;
import io;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class c {

    public enum a {
        LICENSED,
        IN_GRACE_PERIOD,
        OVER_GRACE_PERIOD,
        NOT_LICENSED,
        TEMPORARY_ERROR
    }

    private static PublicKey j6(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(im.j6(str)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            io.DW("Could not decode from Base64.");
            throw new IllegalArgumentException(e2);
        } catch (Throwable e22) {
            io.DW("Invalid key specification.");
            throw new IllegalArgumentException(e22);
        }
    }

    private static boolean DW(String str, String str2, String str3) {
        PublicKey j6 = j6(str3);
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(j6);
            instance.update(str.getBytes());
            if (instance.verify(im.j6(str2))) {
                return true;
            }
            io.DW("Signature verification failed.");
            return false;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e2) {
            io.DW("Invalid public key.");
            return false;
        } catch (Throwable e3) {
            throw new RuntimeException(e3);
        } catch (in e4) {
            io.DW("Could not Base64-decode signature.");
            return false;
        }
    }

    public static a j6(Context context, long j, int i, int i2, String str, String str2, String str3, String str4) {
        io.j6((i == -1 ? "Licensing data from file" : "Licensing service response") + " - code: " + Integer.toHexString(i) + " data: " + str2 + " sig: " + str3);
        b bVar = null;
        if (str2 != null) {
            bVar = j6(str2, str3, str4);
        }
        if (i == -1 && bVar == null) {
            return a.NOT_LICENSED;
        }
        if (bVar != null && !j6(context, j, i, i2, str, false, bVar)) {
            return a.NOT_LICENSED;
        }
        if (i == -1) {
            i = bVar.j6;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (bVar == null) {
                    io.DW("Licensed but no data");
                    return a.NOT_LICENSED;
                }
                Object obj = System.currentTimeMillis() < bVar.gn ? 1 : null;
                Object obj2 = System.currentTimeMillis() < bVar.u7 ? 1 : null;
                if (obj2 == null && bVar.u7 - bVar.Zo > 432000000) {
                    obj2 = 1;
                }
                if (obj != null) {
                    return a.LICENSED;
                }
                if (obj2 != null) {
                    return a.IN_GRACE_PERIOD;
                }
                return a.OVER_GRACE_PERIOD;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                io.j6("Not licensed.");
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case 258:
            case 259:
                io.FH("Licensing error: " + i);
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                io.FH("An error has occurred on the licensing server.");
                return a.TEMPORARY_ERROR;
            case 5:
                io.FH("Licensing server is refusing to talk to this device, over quota.");
                return a.TEMPORARY_ERROR;
            case 257:
                io.FH("Error contacting licensing server.");
                return a.TEMPORARY_ERROR;
            default:
                io.DW("Unknown response code for license check: " + i);
                break;
        }
        return a.NOT_LICENSED;
    }

    public static boolean j6(Context context, long j, int i, int i2, String str, boolean z, b bVar) {
        if (i != -1 && bVar.j6 != i) {
            io.DW("Response codes don't match.");
            return false;
        } else if (j != -1 && bVar.DW != j) {
            io.DW("Nonce doesn't match.");
            return false;
        } else if (z && !e.j6(context, bVar.DW)) {
            io.DW("Nonce does not match device.");
            return false;
        } else if (bVar.FH.equals(str)) {
            try {
                int parseInt = Integer.parseInt(bVar.Hw);
                if (i2 == -1 || parseInt == i2) {
                    return true;
                }
                io.DW("Unexpected version code");
                return false;
            } catch (NumberFormatException e) {
                io.DW("Non-int version code");
                return false;
            }
        } else {
            io.DW("Package name doesn't match.");
            return false;
        }
    }

    public static boolean j6(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static b j6(String str, String str2, String str3) {
        try {
            b j6 = b.j6(str);
            if (!j6(j6.j6) || DW(str, str2, str3)) {
                return j6;
            }
            return null;
        } catch (Throwable e) {
            io.j6("Could not parse response.", e);
            return null;
        }
    }
}
