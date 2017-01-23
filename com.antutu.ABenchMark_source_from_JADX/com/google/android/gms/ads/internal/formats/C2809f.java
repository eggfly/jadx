package com.google.android.gms.ads.internal.formats;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.bf;
import com.google.android.gms.p146b.bn.C2808a;
import com.google.android.gms.p146b.gb;
import java.util.Arrays;
import java.util.List;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.f */
public class C2809f extends C2808a implements C2804a {
    private final C2799a f9527a;
    private final String f9528b;
    private final SimpleArrayMap<String, C2802c> f9529c;
    private final SimpleArrayMap<String, String> f9530d;
    private final Object f9531e;
    private C2810h f9532f;

    public C2809f(String str, SimpleArrayMap<String, C2802c> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, C2799a c2799a) {
        this.f9531e = new Object();
        this.f9528b = str;
        this.f9529c = simpleArrayMap;
        this.f9530d = simpleArrayMap2;
        this.f9527a = c2799a;
    }

    public String m10853a(String str) {
        return (String) this.f9530d.get(str);
    }

    public List<String> m10854a() {
        int i = 0;
        String[] strArr = new String[(this.f9529c.size() + this.f9530d.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f9529c.size(); i3++) {
            strArr[i2] = (String) this.f9529c.keyAt(i3);
            i2++;
        }
        while (i < this.f9530d.size()) {
            strArr[i2] = (String) this.f9530d.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public void m10855a(C2810h c2810h) {
        synchronized (this.f9531e) {
            this.f9532f = c2810h;
        }
    }

    public bf m10856b(String str) {
        return (bf) this.f9529c.get(str);
    }

    public void m10857b() {
        synchronized (this.f9531e) {
            if (this.f9532f == null) {
                C2972b.m11579b("Attempt to perform recordImpression before ad initialized.");
                return;
            }
            this.f9532f.m10862a();
        }
    }

    public void m10858c(String str) {
        synchronized (this.f9531e) {
            if (this.f9532f == null) {
                C2972b.m11579b("Attempt to call performClick before ad initialized.");
                return;
            }
            this.f9532f.m10865a(str, null, null, null);
        }
    }

    public String m10859j() {
        return MessageService.MSG_DB_NOTIFY_DISMISS;
    }

    public String m10860k() {
        return this.f9528b;
    }

    public C2799a m10861l() {
        return this.f9527a;
    }
}
