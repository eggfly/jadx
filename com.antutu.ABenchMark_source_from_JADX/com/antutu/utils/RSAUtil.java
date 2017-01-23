package com.antutu.utils;

import android.util.Base64;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public class RSAUtil {
    public static final String KEY_ALGORITHM = "RSA";
    private static final int MAX_DECRYPT_BLOCK = 128;
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    public static byte[] decryptBASE64(String str) {
        return Base64.decode(str, 0);
    }

    public static byte[] decryptBASE64NoWrap(String str) {
        return Base64.decode(str, 2);
    }

    public static byte[] decryptByPrivateKey(byte[] bArr, String str) {
        byte[] doFinal;
        Key generatePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decryptBASE64(str)));
        Cipher instance = Cipher.getInstance(RSA_ALGORITHM);
        instance.init(2, generatePrivate);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            doFinal = length - i2 > MAX_DECRYPT_BLOCK ? instance.doFinal(bArr, i2, MAX_DECRYPT_BLOCK) : instance.doFinal(bArr, i2, length - i2);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= MAX_DECRYPT_BLOCK;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static byte[] decryptByPublicKey(byte[] bArr, String str) {
        byte[] doFinal;
        Key generatePublic = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decryptBASE64(str)));
        Cipher instance = Cipher.getInstance(RSA_ALGORITHM);
        instance.init(2, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            doFinal = length - i2 > MAX_DECRYPT_BLOCK ? instance.doFinal(bArr, i2, MAX_DECRYPT_BLOCK) : instance.doFinal(bArr, i2, length - i2);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= MAX_DECRYPT_BLOCK;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static String encryptBASE64(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static byte[] encryptByPrivateKey(byte[] bArr, String str) {
        byte[] doFinal;
        Key generatePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decryptBASE64(str)));
        Cipher instance = Cipher.getInstance(RSA_ALGORITHM);
        instance.init(1, generatePrivate);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            doFinal = length - i2 > MAX_ENCRYPT_BLOCK ? instance.doFinal(bArr, i2, MAX_ENCRYPT_BLOCK) : instance.doFinal(bArr, i2, length - i2);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= MAX_ENCRYPT_BLOCK;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static byte[] encryptByPublicKey(byte[] bArr, String str) {
        byte[] doFinal;
        Key generatePublic = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decryptBASE64(str)));
        Cipher instance = Cipher.getInstance(RSA_ALGORITHM);
        instance.init(1, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            doFinal = length - i2 > MAX_ENCRYPT_BLOCK ? instance.doFinal(bArr, i2, MAX_ENCRYPT_BLOCK) : instance.doFinal(bArr, i2, length - i2);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= MAX_ENCRYPT_BLOCK;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static String getPrivateKey(Map<String, Object> map) {
        return encryptBASE64(((Key) map.get(PRIVATE_KEY)).getEncoded());
    }

    public static String getPublicKey(Map<String, Object> map) {
        return encryptBASE64(((Key) map.get(PUBLIC_KEY)).getEncoded());
    }

    public static Map<String, Object> initKey() {
        KeyPairGenerator instance = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        instance.initialize(IXAdIOUtils.BUFFER_SIZE);
        KeyPair generateKeyPair = instance.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
        Map<String, Object> hashMap = new HashMap(2);
        hashMap.put(PUBLIC_KEY, rSAPublicKey);
        hashMap.put(PRIVATE_KEY, rSAPrivateKey);
        return hashMap;
    }

    public static String sign(byte[] bArr, String str) {
        PrivateKey generatePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decryptBASE64(str)));
        Signature instance = Signature.getInstance(SIGNATURE_ALGORITHM);
        instance.initSign(generatePrivate);
        instance.update(bArr);
        return encryptBASE64(instance.sign());
    }

    public static boolean verify(byte[] bArr, String str, String str2) {
        PublicKey generatePublic = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decryptBASE64(str)));
        Signature instance = Signature.getInstance(SIGNATURE_ALGORITHM);
        instance.initVerify(generatePublic);
        instance.update(bArr);
        return instance.verify(decryptBASE64(str2));
    }
}
