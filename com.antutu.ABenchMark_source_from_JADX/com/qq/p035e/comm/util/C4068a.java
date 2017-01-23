package com.qq.p035e.comm.util;

import android.util.Base64;
import com.antutu.utils.RSAUtil;
import com.umeng.message.util.HttpRequest;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.qq.e.comm.util.a */
public class C4068a {
    private PublicKey f13558a;
    private final boolean f13559b;

    /* renamed from: com.qq.e.comm.util.a.a */
    static final class C4067a {
        public static final C4068a f13557a;

        static {
            f13557a = new C4068a();
        }
    }

    private C4068a() {
        boolean z;
        try {
            this.f13558a = C4068a.m16607b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable th) {
            z = false;
        }
        this.f13559b = z;
    }

    public static C4068a m16605a() {
        return C4067a.f13557a;
    }

    private String m16606a(String str) {
        if (this.f13558a != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher instance = Cipher.getInstance(RSAUtil.RSA_ALGORITHM);
                instance.init(2, this.f13558a);
                return new String(instance.doFinal(decode), HttpRequest.f14548a).trim();
            } catch (Throwable th) {
                GDTLogger.m16601e("ErrorWhileVerifySigNature", th);
            }
        }
        return null;
    }

    private static PublicKey m16607b(String str) {
        try {
            return KeyFactory.getInstance(RSAUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("\u65e0\u6b64\u7b97\u6cd5");
        } catch (InvalidKeySpecException e2) {
            throw new Exception("\u516c\u94a5\u975e\u6cd5");
        } catch (NullPointerException e3) {
            throw new Exception("\u516c\u94a5\u6570\u636e\u4e3a\u7a7a");
        }
    }

    public final boolean m16608a(String str, String str2) {
        return m16609b(str, Md5Util.encode(str2));
    }

    public final boolean m16609b(String str, String str2) {
        if (StringUtil.isEmpty(str2)) {
            return false;
        }
        if (!this.f13559b) {
            return true;
        }
        String a = m16606a(str);
        boolean equals = str2.equals(a);
        GDTLogger.m16599d("Verify Result" + equals + "src=" + str2 + " & target=" + a);
        return equals;
    }
}
