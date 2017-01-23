package com.antutu.benchmark.platform.p056g;

import android.util.Log;
import com.antutu.benchmark.platform.p056g.C1587f.C1586a;
import java.security.Key;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.antutu.benchmark.platform.g.d */
public class C1584d {
    public String f5542a;
    private Cipher f5543b;
    private Cipher f5544c;
    private Signature f5545d;
    private IvParameterSpec f5546e;
    private final String f5547f;

    public C1584d() {
        this.f5542a = "MessageReceiver";
        this.f5543b = null;
        this.f5544c = null;
        this.f5545d = null;
        this.f5546e = null;
        this.f5547f = "AES";
        this.f5543b = Cipher.getInstance("AES/CTR/NoPadding");
        this.f5546e = new IvParameterSpec("alskdjfhgpqowieu".getBytes());
        this.f5544c = Cipher.getInstance("RSA/None/OAEPWithSHA-1AndMGF1Padding");
        this.f5545d = Signature.getInstance("SHA1withECDSA");
    }

    public void m6278a() {
        C1586a a = C1587f.m6281a(C1588g.m6283a(C1582b.f5539m).m6285b(C1582b.f5537k));
        this.f5545d.initVerify(C1582b.f5532f);
        this.f5545d.update(a.f5555a);
        if (!this.f5545d.verify(a.f5557c)) {
            Log.e(this.f5542a, "Signature was invalid");
        }
        this.f5544c.init(2, (Key) C1582b.f5528b.get(C1582b.f5529c - 1));
        this.f5543b.init(2, new SecretKeySpec(this.f5544c.doFinal(a.f5556b), "AES"), this.f5546e);
        if (new String(this.f5543b.doFinal(a.f5555a)).contains("https:")) {
            this.f5543b.doFinal(C1588g.m6283a(C1582b.f5540n).m6285b(C1582b.f5538l));
        }
    }
}
