package kellinwood.sigblock;

import bcp;
import bdm;
import bdt;
import bdx;
import bef;
import bei;
import bgk;
import bgq;
import bgs;
import bhd;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Collections;

public class SignatureBlockWriter {
    private static boolean j6;

    class 1 implements bgq {
        private final /* synthetic */ byte[] j6;

        1(byte[] bArr) {
            this.j6 = bArr;
        }

        public bcp j6() {
            return new bgs().j6("SHA1withRSA");
        }

        public OutputStream DW() {
            return new ByteArrayOutputStream();
        }

        public byte[] FH() {
            return this.j6;
        }
    }

    static {
        j6 = false;
    }

    public static synchronized void writeSignatureBlock(byte[] bArr, X509Certificate x509Certificate, OutputStream outputStream) {
        synchronized (SignatureBlockWriter.class) {
            if (!j6) {
                Security.addProvider(new bgk());
                j6 = true;
            }
            bdx bdx = new bdx();
            try {
                bdx.j6(new bdm(Collections.singleton(x509Certificate)));
                bdx.j6(new bef(new bei(new bhd().j6("SC").j6()).j6(new 1(bArr), x509Certificate), null, null));
                outputStream.write(bdx.j6("1.2.840.113549.1.7.1", new bdt(new byte[0]), false, "SC", false).j6().j6("DER"));
            } catch (Throwable e) {
                System.err.println(e);
                throw new GeneralSecurityException(e);
            } catch (Throwable e2) {
                System.err.println(e2);
                throw new GeneralSecurityException(e2);
            } catch (RuntimeException e3) {
                System.err.println(e3);
                throw e3;
            } catch (Error e4) {
                System.err.println(e4);
                throw e4;
            }
        }
    }
}
