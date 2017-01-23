package com.mob.tools.utils;

import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.Base64;
import anet.channel.security.ISecurity;
import com.antutu.utils.RSAUtil;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.mob.tools.MobLog;
import com.mob.tools.network.BufferedByteArrayOutputStream;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.message.MessageService;

public class Data {
    private static final String CHAT_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String AES128Decode(String str, byte[] bArr) {
        return (str == null || bArr == null) ? null : new String(AES128Decode(str.getBytes(HttpRequest.f14548a), bArr), HttpRequest.f14548a);
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        Object obj = new byte[16];
        System.arraycopy(bArr, 0, obj, 0, Math.min(bArr.length, 16));
        Key secretKeySpec = new SecretKeySpec(obj, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/NoPadding", "BC");
        instance.init(2, secretKeySpec);
        byte[] bArr3 = new byte[instance.getOutputSize(bArr2.length)];
        int update = instance.update(bArr2, 0, bArr2.length, bArr3, 0);
        int doFinal = instance.doFinal(bArr3, update) + update;
        return bArr3;
    }

    public static byte[] AES128Encode(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        Object bytes = str.getBytes(HttpRequest.f14548a);
        Object obj = new byte[16];
        System.arraycopy(bytes, 0, obj, 0, Math.min(bytes.length, 16));
        byte[] bytes2 = str2.getBytes(HttpRequest.f14548a);
        Key secretKeySpec = new SecretKeySpec(obj, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        instance.init(1, secretKeySpec);
        byte[] bArr = new byte[instance.getOutputSize(bytes2.length)];
        instance.doFinal(bArr, instance.update(bytes2, 0, bytes2.length, bArr, 0));
        return bArr;
    }

    public static byte[] AES128Encode(byte[] bArr, String str) {
        return (bArr == null || str == null) ? null : AES128Encode(bArr, str.getBytes(HttpRequest.f14548a));
    }

    public static byte[] AES128Encode(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        instance.init(1, secretKeySpec);
        byte[] bArr3 = new byte[instance.getOutputSize(bArr2.length)];
        instance.doFinal(bArr3, instance.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }

    public static String Base64AES(String str, String str2) {
        String str3 = null;
        if (!(str == null || str2 == null)) {
            try {
                str3 = Base64.encodeToString(AES128Encode(str2, str), 0);
                if (!TextUtils.isEmpty(str3) && str3.contains("\n")) {
                    str3 = str3.replace("\n", BuildConfig.FLAVOR);
                }
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
        return str3;
    }

    public static String CRC32(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 56))) & MotionEventCompat.ACTION_MASK)}));
        stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 48))) & MotionEventCompat.ACTION_MASK)}));
        stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 40))) & MotionEventCompat.ACTION_MASK)}));
        stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 32))) & MotionEventCompat.ACTION_MASK)}));
        stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 24))) & MotionEventCompat.ACTION_MASK)}));
        stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 16))) & MotionEventCompat.ACTION_MASK)}));
        stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 8))) & MotionEventCompat.ACTION_MASK)}));
        stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) value)) & MotionEventCompat.ACTION_MASK)}));
        while (stringBuilder.charAt(0) == '0') {
            stringBuilder = stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString().toLowerCase();
    }

    public static String MD5(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            InputStream fileInputStream = new FileInputStream(file);
            byte[] rawMD5 = rawMD5(fileInputStream);
            fileInputStream.close();
            return rawMD5 != null ? toHex(rawMD5) : null;
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return null;
        }
    }

    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        byte[] rawMD5 = rawMD5(str);
        return rawMD5 != null ? toHex(rawMD5) : null;
    }

    public static String MD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] rawMD5 = rawMD5(bArr);
        return rawMD5 != null ? toHex(rawMD5) : null;
    }

    public static byte[] SHA1(File file) {
        byte[] bArr = null;
        if (file != null && file.exists()) {
            try {
                InputStream fileInputStream = new FileInputStream(file);
                bArr = SHA1(fileInputStream);
                fileInputStream.close();
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
        return bArr;
    }

    public static byte[] SHA1(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream != null) {
            try {
                byte[] bArr2 = new byte[IXAdIOUtils.BUFFER_SIZE];
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                int read = inputStream.read(bArr2);
                while (read != -1) {
                    instance.update(bArr2, 0, read);
                    read = inputStream.read(bArr2);
                }
                bArr = instance.digest();
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
        return bArr;
    }

    public static byte[] SHA1(String str) {
        return TextUtils.isEmpty(str) ? null : SHA1(str.getBytes("utf-8"));
    }

    public static byte[] SHA1(byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(bArr);
        return instance.digest();
    }

    public static String base62(long j) {
        String str = j == 0 ? MessageService.MSG_DB_READY_REPORT : BuildConfig.FLAVOR;
        while (j > 0) {
            int i = (int) (j % 62);
            j /= 62;
            str = CHAT_SET.charAt(i) + str;
        }
        return str;
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, 0, bArr.length);
    }

    public static String byteToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i < i2) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
            i++;
        }
        return stringBuffer.toString();
    }

    public static byte[] rawMD5(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream != null) {
            try {
                byte[] bArr2 = new byte[IXAdIOUtils.BUFFER_SIZE];
                MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
                int read = inputStream.read(bArr2);
                while (read != -1) {
                    instance.update(bArr2, 0, read);
                    read = inputStream.read(bArr2);
                }
                bArr = instance.digest();
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
        return bArr;
    }

    public static byte[] rawMD5(String str) {
        byte[] bArr = null;
        if (str != null) {
            try {
                bArr = rawMD5(str.getBytes("utf-8"));
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
        return bArr;
    }

    public static byte[] rawMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] rawMD5;
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            rawMD5 = rawMD5(byteArrayInputStream);
            byteArrayInputStream.close();
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            rawMD5 = null;
        }
        return rawMD5;
    }

    public static byte[] rawRSADecode(byte[] bArr, byte[] bArr2, int i) {
        KeyFactory.getInstance(RSAUtil.KEY_ALGORITHM);
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) KeyFactory.getInstance(RSAUtil.KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
        instance.init(2, rSAPrivateKey);
        int i2 = i / 8;
        ByteArrayOutputStream bufferedByteArrayOutputStream = new BufferedByteArrayOutputStream();
        for (int i3 = 0; bArr.length - i3 > 0; i3 += i2) {
            byte[] doFinal = instance.doFinal(bArr, i3, Math.min(bArr.length - i3, i2));
            bufferedByteArrayOutputStream.write(doFinal, 0, doFinal.length);
        }
        bufferedByteArrayOutputStream.close();
        return bufferedByteArrayOutputStream.toByteArray();
    }

    public static byte[] rawRSAEncode(byte[] bArr, byte[] bArr2, int i) {
        int i2 = (i / 8) - 11;
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(RSAUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
        instance.init(1, rSAPublicKey);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; bArr.length - i3 > 0; i3 += i2) {
            byte[] doFinal = instance.doFinal(bArr, i3, Math.min(bArr.length - i3, i2));
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static String toHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }

    public static String urlEncode(String str) {
        try {
            return urlEncode(str, "utf-8");
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return null;
        }
    }

    public static String urlEncode(String str, String str2) {
        String encode = URLEncoder.encode(str, str2);
        return TextUtils.isEmpty(encode) ? encode : encode.replace("+", "%20");
    }
}
