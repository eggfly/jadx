package com.antutu.benchmark.platform.p056g;

import android.annotation.SuppressLint;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.antutu.benchmark.platform.g.g */
public final class C1588g {
    private Cipher f5559a;
    private Cipher f5560b;
    private Mac f5561c;

    @SuppressLint({"TrulyRandom"})
    private C1588g(SecretKey secretKey) {
        this.f5559a = Cipher.getInstance("AES/CBC/PKCS7Padding");
        this.f5560b = Cipher.getInstance("AES/CBC/PKCS7Padding");
        this.f5561c = Mac.getInstance("HMACSHA1");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec("This is my IV:-)".getBytes());
        this.f5559a.init(1, secretKey, ivParameterSpec);
        this.f5560b.init(2, secretKey, ivParameterSpec);
        this.f5561c.init(secretKey);
    }

    public static C1588g m6283a(SecretKey secretKey) {
        try {
            return new C1588g(secretKey);
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (NoSuchPaddingException e2) {
            return null;
        } catch (InvalidKeyException e3) {
            return null;
        } catch (InvalidAlgorithmParameterException e4) {
            return null;
        }
    }

    public byte[] m6284a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int macLength = this.f5561c.getMacLength();
        int length = bArr.length;
        int blockSize = this.f5559a.getBlockSize();
        blockSize *= (length + blockSize) / blockSize;
        ByteBuffer allocate = ByteBuffer.allocate((macLength + 12) + blockSize);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putInt(macLength);
        allocate.putInt(length);
        allocate.putInt(blockSize);
        try {
            allocate.put(this.f5559a.doFinal(bArr, 0, length));
            allocate.put(this.f5561c.doFinal(bArr));
            return allocate.array();
        } catch (IllegalBlockSizeException e) {
            return null;
        } catch (BadPaddingException e2) {
            return null;
        }
    }

    public byte[] m6285b(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return null;
        }
        if (bArr.length < 12) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        allocate.put(bArr);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.rewind();
        int i2 = allocate.getInt();
        allocate.getInt();
        int i3 = allocate.getInt();
        if (bArr.length != (i2 + 12) + i3) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[i3];
            allocate.get(bArr2, 0, i3);
            byte[] doFinal = this.f5560b.doFinal(bArr2, 0, i3);
            bArr2 = this.f5561c.doFinal(doFinal);
            if (bArr2.length != i2) {
                return null;
            }
            byte[] bArr3 = new byte[i2];
            allocate.get(bArr3, 0, i2);
            while (i < bArr2.length) {
                if (bArr2[i] != bArr3[i]) {
                    return null;
                }
                i++;
            }
            return doFinal;
        } catch (IllegalBlockSizeException e) {
            return null;
        } catch (BadPaddingException e2) {
            return null;
        }
    }
}
