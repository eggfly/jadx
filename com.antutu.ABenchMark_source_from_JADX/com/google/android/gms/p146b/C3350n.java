package com.google.android.gms.p146b;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.b.n */
public class C3350n {
    private final C3158m f11698a;
    private final SecureRandom f11699b;

    /* renamed from: com.google.android.gms.b.n.a */
    public class C3349a extends Exception {
        final /* synthetic */ C3350n f11697a;

        public C3349a(C3350n c3350n) {
            this.f11697a = c3350n;
        }

        public C3349a(C3350n c3350n, Throwable th) {
            this.f11697a = c3350n;
            super(th);
        }
    }

    public C3350n(C3158m c3158m, SecureRandom secureRandom) {
        this.f11698a = c3158m;
        this.f11699b = secureRandom;
    }

    static void m13780a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m13781a(String str) {
        try {
            byte[] a = this.f11698a.m12447a(str, false);
            if (a.length != 32) {
                throw new C3349a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C3350n.m13780a(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C3349a(this, e);
        }
    }

    public byte[] m13782a(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new C3349a(this);
        }
        try {
            byte[] a = this.f11698a.m12447a(str, false);
            if (a.length <= 16) {
                throw new C3349a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C3349a(this, e);
        } catch (Throwable e2) {
            throw new C3349a(this, e2);
        } catch (Throwable e22) {
            throw new C3349a(this, e22);
        } catch (Throwable e222) {
            throw new C3349a(this, e222);
        } catch (Throwable e2222) {
            throw new C3349a(this, e2222);
        } catch (Throwable e22222) {
            throw new C3349a(this, e22222);
        } catch (Throwable e222222) {
            throw new C3349a(this, e222222);
        }
    }
}
