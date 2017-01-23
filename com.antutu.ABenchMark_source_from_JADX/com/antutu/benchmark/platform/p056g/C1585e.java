package com.antutu.benchmark.platform.p056g;

import com.xiaomi.pushsdk.BuildConfig;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.antutu.benchmark.platform.g.e */
public class C1585e {
    public String f5548a;
    private Cipher f5549b;
    private Cipher f5550c;
    private Signature f5551d;
    private IvParameterSpec f5552e;
    private final String f5553f;
    private final String f5554g;

    public C1585e() {
        this.f5548a = "MessageSender";
        this.f5549b = null;
        this.f5550c = null;
        this.f5551d = null;
        this.f5552e = null;
        this.f5553f = "https://www.myserver.com";
        this.f5554g = "AES";
        this.f5549b = Cipher.getInstance("AES/CTR/NoPadding");
        this.f5550c = Cipher.getInstance("RSA/None/OAEPWithSHA-1AndMGF1Padding");
        this.f5552e = new IvParameterSpec("alskdjfhgpqowieu".getBytes());
        this.f5551d = Signature.getInstance("SHA1withECDSA");
    }

    private void m6279a(byte[] bArr, byte[] bArr2, int i) {
        int i2 = 0;
        C1582b.f5529c = i;
        Object a = C1583c.m6276a(C1582b.f5536j, "AES");
        this.f5549b.init(1, a, this.f5552e);
        String str = BuildConfig.FLAVOR;
        if (bArr2 != null) {
            bArr = ("https://www.myserver.com/" + new Random(System.currentTimeMillis()).nextLong()).getBytes();
        }
        byte[] doFinal = this.f5549b.doFinal(bArr);
        ArrayList arrayList = new ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            this.f5550c.init(1, (Key) C1582b.f5527a.get(i3));
            arrayList.add(this.f5550c.doFinal(a.getEncoded()));
        }
        this.f5551d.initSign(C1582b.f5533g);
        this.f5551d.update(doFinal);
        byte[] sign = this.f5551d.sign();
        while (i2 < i) {
            ByteBuffer a2 = C1587f.m6282a(doFinal, (byte[]) arrayList.get(i2), sign);
            C1582b.f5539m = C1583c.m6276a(C1582b.f5536j, "AES");
            C1588g a3 = C1588g.m6283a(C1582b.f5539m);
            if (a3 != null) {
                C1582b.f5537k = a3.m6284a(a2.array());
            }
            i2++;
        }
        if (bArr2 != null) {
            byte[] doFinal2 = this.f5549b.doFinal(bArr2);
            C1582b.f5540n = C1583c.m6276a(C1582b.f5536j, "AES");
            C1588g a4 = C1588g.m6283a(C1582b.f5540n);
            if (a4 != null) {
                C1582b.f5538l = a4.m6284a(doFinal2);
            }
        }
    }

    public void m6280a(byte[] bArr, int i) {
        m6279a(bArr, null, i);
    }
}
