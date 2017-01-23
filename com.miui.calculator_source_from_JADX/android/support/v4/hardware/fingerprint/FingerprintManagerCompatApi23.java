package android.support.v4.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FingerprintManagerCompatApi23 {

    public static abstract class AuthenticationCallback {
        public void m603a(int i, CharSequence charSequence) {
        }

        public void m605b(int i, CharSequence charSequence) {
        }

        public void m604a(AuthenticationResultInternal authenticationResultInternal) {
        }

        public void m602a() {
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.1 */
    final class C00421 extends android.hardware.fingerprint.FingerprintManager.AuthenticationCallback {
        final /* synthetic */ AuthenticationCallback f479a;

        public void onAuthenticationError(int i, CharSequence charSequence) {
            this.f479a.m603a(i, charSequence);
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            this.f479a.m605b(i, charSequence);
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            this.f479a.m604a(new AuthenticationResultInternal(FingerprintManagerCompatApi23.m621b(authenticationResult.getCryptoObject())));
        }

        public void onAuthenticationFailed() {
            this.f479a.m602a();
        }
    }

    public static final class AuthenticationResultInternal {
        private CryptoObject f480a;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.f480a = cryptoObject;
        }

        public CryptoObject m616a() {
            return this.f480a;
        }
    }

    public static class CryptoObject {
        private final Signature f481a;
        private final Cipher f482b;
        private final Mac f483c;

        public CryptoObject(Signature signature) {
            this.f481a = signature;
            this.f482b = null;
            this.f483c = null;
        }

        public CryptoObject(Cipher cipher) {
            this.f482b = cipher;
            this.f481a = null;
            this.f483c = null;
        }

        public CryptoObject(Mac mac) {
            this.f483c = mac;
            this.f482b = null;
            this.f481a = null;
        }

        public Signature m617a() {
            return this.f481a;
        }

        public Cipher m618b() {
            return this.f482b;
        }

        public Mac m619c() {
            return this.f483c;
        }
    }

    private static CryptoObject m621b(android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new CryptoObject(cryptoObject.getMac());
        }
        return null;
    }
}
