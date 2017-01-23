package com.miui.support.security;

import java.io.InputStream;
import javax.crypto.Cipher;

public class CipherUtils {

    private static class CipherStream extends InputStream {
        final Cipher f3540a;
        final InputStream f3541b;
        boolean f3542c;
        byte[] f3543d;
        byte[] f3544e;
        int f3545f;

        public int available() {
            if (this.f3544e == null || this.f3544e.length <= this.f3545f) {
                return 0;
            }
            return (this.f3544e.length - this.f3545f) + this.f3541b.available();
        }

        public int read() {
            if (this.f3544e == null) {
                return -1;
            }
            if (this.f3545f < this.f3544e.length) {
                byte[] bArr = this.f3544e;
                int i = this.f3545f;
                this.f3545f = i + 1;
                return bArr[i];
            }
            this.f3544e = null;
            if (this.f3542c) {
                return -1;
            }
            m5233a();
            return read();
        }

        private void m5233a() {
            int read = this.f3541b.read(this.f3543d);
            if (read > 0) {
                this.f3544e = this.f3540a.update(this.f3543d, 0, read);
                this.f3545f = 0;
                return;
            }
            this.f3542c = true;
            try {
                this.f3544e = this.f3540a.doFinal();
                this.f3545f = 0;
            } catch (Throwable e) {
                throw new RuntimeException("IllegalBlockSizeException", e);
            } catch (Throwable e2) {
                throw new RuntimeException("BadPaddingException", e2);
            }
        }
    }

    protected CipherUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }
}
