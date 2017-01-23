package org.spongycastle.jcajce.provider.digest;

import bbu;
import bcc;
import bce;
import bfa;
import bgc;

public class SHA1 {

    public static class Digest extends a implements Cloneable {
        public Digest() {
            super(new bfa());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.j6 = new bfa((bfa) this.j6);
            return digest;
        }
    }

    public static class Mappings extends b {
        private static final String j6;

        static {
            j6 = SHA1.class.getName();
        }

        public void configure(bgc bgc) {
            bgc.j6("MessageDigest.SHA-1", j6 + "$Digest");
            bgc.j6("Alg.Alias.MessageDigest.SHA1", "SHA-1");
            bgc.j6("Alg.Alias.MessageDigest.SHA", "SHA-1");
            bgc.j6("Alg.Alias.MessageDigest." + bcc.u7, "SHA-1");
            j6(bgc, "SHA1", j6 + "$HashMac", j6 + "$KeyGenerator");
            j6(bgc, "SHA1", bce.KD);
            j6(bgc, "SHA1", bbu.FH);
        }
    }
}
