package com.google.android.gms.ads.internal.purchase;

import android.text.TextUtils;
import android.util.Base64;
import com.antutu.utils.RSAUtil;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.l */
public class C2895l {
    public static PublicKey m11263a(String str) {
        try {
            return KeyFactory.getInstance(RSAUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            C2972b.m11579b("Invalid key specification.");
            throw new IllegalArgumentException(e2);
        }
    }

    public static boolean m11264a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return C2895l.m11265a(C2895l.m11263a(str), str2, str3);
        }
        C2972b.m11579b("Purchase verification failed: missing data.");
        return false;
    }

    public static boolean m11265a(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2, 0))) {
                return true;
            }
            C2972b.m11579b("Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            C2972b.m11579b("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            C2972b.m11579b("Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            C2972b.m11579b("Signature exception.");
            return false;
        }
    }
}
