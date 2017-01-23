package com.antutu.benchmark.platform.p056g;

import android.util.Base64;
import com.facebook.ads.AdError;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.antutu.benchmark.platform.g.a */
public class C1581a {
    public static String f5524a;
    public C1585e f5525b;
    public C1584d f5526c;

    static {
        f5524a = "Benchmark";
    }

    public C1581a() {
        this.f5525b = null;
        this.f5526c = null;
    }

    private void m6269a(int i) {
        KeyPair a = C1583c.m6275a(C1582b.f5534h);
        C1582b.f5530d = a.getPublic();
        C1582b.f5531e = a.getPrivate();
        a = C1583c.m6277b(C1582b.f5535i);
        C1582b.f5533g = a.getPrivate();
        C1582b.f5532f = a.getPublic();
        C1582b.f5527a = new ArrayList();
        C1582b.f5528b = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            KeyPair a2 = C1583c.m6275a(C1582b.f5534h);
            C1582b.f5527a.add(a2.getPublic());
            C1582b.f5528b.add(a2.getPrivate());
        }
        try {
            this.f5525b = new C1585e();
            this.f5526c = new C1584d();
        } catch (NoSuchPaddingException e) {
        } catch (IllegalBlockSizeException e2) {
        } catch (NoSuchAlgorithmException e3) {
        }
    }

    private void m6270a(byte[] bArr, byte[] bArr2, int i) {
        m6272b(bArr, 1);
        m6271b();
        m6272b(bArr, i);
        m6271b();
        m6271b();
        m6272b(bArr2, 1);
        m6271b();
    }

    private void m6271b() {
        try {
            this.f5526c.m6278a();
        } catch (InvalidKeyException e) {
        } catch (BadPaddingException e2) {
        } catch (IllegalBlockSizeException e3) {
        } catch (SignatureException e4) {
        } catch (InvalidAlgorithmParameterException e5) {
        }
    }

    private void m6272b(byte[] bArr, int i) {
        try {
            this.f5525b.m6280a(bArr, i);
        } catch (InvalidKeyException e) {
        } catch (BadPaddingException e2) {
        } catch (IllegalBlockSizeException e3) {
        } catch (SignatureException e4) {
        } catch (InvalidAlgorithmParameterException e5) {
        }
    }

    public double m6273a() {
        int i = 0;
        byte[] bytes = "Twas brillig, and the slithy toves Did gyre and gimble in the wabe: All mimsy were the borogoves, And the mome raths outgrabe. Beware the Jabberwock, my son! Th".getBytes();
        byte[] a = m6274a(Base64.decode("/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAoHBwgHBgoICAgLCgoLDhgQDg0NDh0VFhEYIx8lJCIfIiEmKzcvJik0KSEiMEExNDk7Pj4+JS5ESUM8SDc9Pjv/2wBDAQoLCw4NDhwQEBw7KCIoOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozv/wAARCATIBmADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDzSAGCRSONpyK9x8AeOo9Wtl06+kAuoxhWJxvrgfiD4V/sbUWvbSPFnL/CP+Wdcfb3b2tykisRsYE4OO9ZQqKrDmiOzvqfVAJGe4PSmksYi235vSsLw54ih13TLa4tSNu3Egz93FRa9f3k91HZ6VeLC6/65uPlqbp3ig1Ej06Zri6ubmIJGB8sec5qt4X1u3gtnt55fLUMQEI+7z61Sjkv5L6GztdWM7OT5+Uxmr2v+HUmt4ksowD1chqdOLWg2jopYrEqLtxuC9GFZ8T6TfXksEKbimPNJONvpWb4TGqLcSpNN9oshgI5GPrxVvxJZx22m3l9GDvcDheK22JMjxtaaXBHC0bKJmztAOc15nqdx5kRgilCb/4vStCeG+nVk2SuO2c8VyupRSw3B+Y71P3COlc0ouUrmi06m3pd7LbeS9rKWeA/eC9fXivQ9K8Yl7mGPOLduGi/un61wegwXUd1EljGHunU/KfpWpFpN3ZwvfSLsWFssM85Jq", 0), AdError.NETWORK_ERROR_CODE);
        m6269a(3);
        m6270a(bytes, a, 3);
        long currentTimeMillis = System.currentTimeMillis();
        double d = 0.0d;
        do {
            m6270a(bytes, a, 3);
            d += ((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d;
            i++;
        } while (d < 5.0d);
        return (((double) i) * 100.0d) / d;
    }

    public byte[] m6274a(byte[] bArr, int i) {
        Object obj = new byte[(bArr.length * i)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            System.arraycopy(bArr, 0, obj, i2, bArr.length);
            i2 += bArr.length;
        }
        return obj;
    }
}
