package anet.channel.util;

import com.xiaomi.pushsdk.BuildConfig;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMacUtil {
    private static final String TAG = "awcn.HMacUtil";

    private static byte[] hmacSha1(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "HmacSHA256");
        byte[] bArr3 = null;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
        } catch (InvalidKeyException e2) {
        }
        return bArr3;
    }

    public static String hmacSha1Hex(byte[] bArr, byte[] bArr2) {
        String str = BuildConfig.FLAVOR;
        try {
            str = StringUtils.bytesToHexString(hmacSha1(bArr, bArr2));
            ALog.m2963i(TAG, "hmacSha1Hex", null, "result", str);
            return str;
        } catch (Throwable th) {
            ALog.m2962e(TAG, "hmacSha1Hex", null, "result", str);
            return str;
        }
    }
}
