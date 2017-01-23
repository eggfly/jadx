package com.antutu.benchmark.platform.p056g;

import android.util.Log;
import com.antutu.utils.RSAUtil;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.antutu.benchmark.platform.g.c */
public class C1583c {
    private static String f5541a;

    static {
        f5541a = "KeyGenerators";
    }

    public static KeyPair m6275a(int i) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(RSAUtil.KEY_ALGORITHM);
            instance.initialize(i);
            return instance.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            Log.e(f5541a, "generateRsaKeys " + e.getMessage());
            return null;
        }
    }

    public static SecretKey m6276a(int i, String str) {
        try {
            SecureRandom instance = SecureRandom.getInstance("SHA1PRNG");
            instance.setSeed("alskdjfhgpqowieu".getBytes());
            KeyGenerator instance2 = KeyGenerator.getInstance(str);
            instance2.init(i, instance);
            return new SecretKeySpec(instance2.generateKey().getEncoded(), str);
        } catch (NoSuchAlgorithmException e) {
            Log.e(f5541a, "generateSymmetricKey " + e.getMessage());
            return null;
        }
    }

    public static KeyPair m6277b(int i) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
            instance.initialize(i, SecureRandom.getInstance("SHA1PRNG"));
            return instance.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            Log.e(f5541a, "generateEcKeys " + e.getMessage());
            return null;
        }
    }
}
