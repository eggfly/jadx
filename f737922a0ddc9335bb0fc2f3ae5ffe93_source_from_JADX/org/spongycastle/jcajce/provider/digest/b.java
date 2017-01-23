package org.spongycastle.jcajce.provider.digest;

import ayq;
import bgc;
import bgf;

abstract class b extends bgf {
    b() {
    }

    protected void j6(bgc bgc, String str, String str2, String str3) {
        String str4 = "HMAC" + str;
        bgc.j6("Mac." + str4, str2);
        bgc.j6("Alg.Alias.Mac.HMAC-" + str, str4);
        bgc.j6("Alg.Alias.Mac.HMAC/" + str, str4);
        bgc.j6("KeyGenerator." + str4, str3);
        bgc.j6("Alg.Alias.KeyGenerator.HMAC-" + str, str4);
        bgc.j6("Alg.Alias.KeyGenerator.HMAC/" + str, str4);
    }

    protected void j6(bgc bgc, String str, ayq ayq) {
        String str2 = "HMAC" + str;
        bgc.j6("Alg.Alias.Mac." + ayq, str2);
        bgc.j6("Alg.Alias.KeyGenerator." + ayq, str2);
    }
}
