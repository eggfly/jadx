package android.support.v4.hardware.fingerprint;

import android.os.Build.VERSION;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationResultInternal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class FingerprintManagerCompat {
    static final FingerprintManagerCompatImpl f478a;

    private interface FingerprintManagerCompatImpl {
    }

    private static class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {

        /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.1 */
        final class C00411 extends android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback {
            final /* synthetic */ AuthenticationCallback f473a;

            public void m607a(int i, CharSequence charSequence) {
                this.f473a.m613a(i, charSequence);
            }

            public void m609b(int i, CharSequence charSequence) {
                this.f473a.m615b(i, charSequence);
            }

            public void m608a(AuthenticationResultInternal authenticationResultInternal) {
                this.f473a.m614a(new AuthenticationResult(Api23FingerprintManagerCompatImpl.m611b(authenticationResultInternal.m616a())));
            }

            public void m606a() {
                this.f473a.m612a();
            }
        }

        private static CryptoObject m611b(android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.m618b() != null) {
                return new CryptoObject(cryptoObject.m618b());
            }
            if (cryptoObject.m617a() != null) {
                return new CryptoObject(cryptoObject.m617a());
            }
            if (cryptoObject.m619c() != null) {
                return new CryptoObject(cryptoObject.m619c());
            }
            return null;
        }
    }

    public static abstract class AuthenticationCallback {
        public void m613a(int i, CharSequence charSequence) {
        }

        public void m615b(int i, CharSequence charSequence) {
        }

        public void m614a(AuthenticationResult authenticationResult) {
        }

        public void m612a() {
        }
    }

    public static final class AuthenticationResult {
        private CryptoObject f474a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f474a = cryptoObject;
        }
    }

    public static class CryptoObject {
        private final Signature f475a;
        private final Cipher f476b;
        private final Mac f477c;

        public CryptoObject(Signature signature) {
            this.f475a = signature;
            this.f476b = null;
            this.f477c = null;
        }

        public CryptoObject(Cipher cipher) {
            this.f476b = cipher;
            this.f475a = null;
            this.f477c = null;
        }

        public CryptoObject(Mac mac) {
            this.f477c = mac;
            this.f476b = null;
            this.f475a = null;
        }
    }

    private static class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f478a = new Api23FingerprintManagerCompatImpl();
        } else {
            f478a = new LegacyFingerprintManagerCompatImpl();
        }
    }
}
