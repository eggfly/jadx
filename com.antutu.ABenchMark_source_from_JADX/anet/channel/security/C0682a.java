package anet.channel.security;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import java.util.HashMap;
import java.util.Map;

/* renamed from: anet.channel.security.a */
class C0682a implements ISecurity {
    private static String f2263a;
    private static boolean f2264b;
    private Map<String, Integer> f2265c;
    private Map<String, Integer> f2266d;

    static {
        f2263a = "awcn.DefaultSecurityGuard";
        f2264b = false;
        try {
            SecurityGuardManager.getInstance(GlobalAppRuntimeInfo.getContext());
            f2264b = true;
        } catch (SecException e) {
            f2264b = true;
        } catch (Exception e2) {
            f2264b = false;
        }
    }

    C0682a() {
        this.f2265c = new HashMap();
        this.f2266d = new HashMap();
        if (f2264b) {
            this.f2265c.put(ISecurity.SIGN_ALGORITHM_HMAC_SHA1, Integer.valueOf(3));
            this.f2265c.put(ISecurity.SIGN_ALGORITHM_MD5, Integer.valueOf(4));
            this.f2266d.put(ISecurity.CIPHER_ALGORITHM_AES128, Integer.valueOf(16));
            this.f2266d.put(ISecurity.CIPHER_ALGORITHM_AES256, Integer.valueOf(18));
        }
    }

    public byte[] dynamicGetBytes(Context context, String str) {
        byte[] bArr = null;
        if (!(context == null || TextUtils.isEmpty(str))) {
            try {
                SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
                if (instance != null) {
                    IDynamicDataStoreComponent dynamicDataStoreComp = instance.getDynamicDataStoreComp();
                    if (dynamicDataStoreComp != null) {
                        bArr = dynamicDataStoreComp.getByteArray(str);
                    }
                }
            } catch (Throwable th) {
                ALog.m2961e(f2263a, "dynamicGetBytes", null, th, new Object[0]);
            }
        }
        return bArr;
    }

    public boolean dynamicPutBytes(Context context, String str, byte[] bArr) {
        if (context == null || bArr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            if (instance == null) {
                return false;
            }
            IDynamicDataStoreComponent dynamicDataStoreComp = instance.getDynamicDataStoreComp();
            return (dynamicDataStoreComp == null || dynamicDataStoreComp.putByteArray(str, bArr) == 0) ? false : true;
        } catch (Throwable th) {
            ALog.m2961e(f2263a, "dynamicPutBytes", null, th, new Object[0]);
            return false;
        }
    }

    public String sign(Context context, String str, String str2, String str3, String str4) {
        if (!f2264b || context == null || TextUtils.isEmpty(str2) || !this.f2265c.containsKey(str)) {
            return null;
        }
        try {
            ISecureSignatureComponent secureSignatureComp = SecurityGuardManager.getInstance(context).getSecureSignatureComp();
            if (secureSignatureComp != null) {
                SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                securityGuardParamContext.appKey = str2;
                securityGuardParamContext.paramMap.put("INPUT", str3);
                securityGuardParamContext.requestType = ((Integer) this.f2265c.get(str)).intValue();
                return secureSignatureComp.signRequest(securityGuardParamContext, str4);
            }
        } catch (SecException e) {
            ALog.m2961e(f2263a, "Securityguard sign request failed.", null, e, new Object[0]);
        }
        return null;
    }

    public String signAuth(Context context, String str, String str2, String str3, String str4) {
        return sign(context, str, str2, str3 + str2, str4);
    }

    public byte[] staticDecrypt(Context context, String str, String str2, byte[] bArr, String str3) {
        if (!f2264b || context == null || bArr == null || TextUtils.isEmpty(str2) || !this.f2266d.containsKey(str)) {
            return null;
        }
        Integer num = (Integer) this.f2266d.get(str);
        if (num == null) {
            return null;
        }
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            if (instance != null) {
                IStaticDataEncryptComponent staticDataEncryptComp = instance.getStaticDataEncryptComp();
                if (staticDataEncryptComp != null) {
                    return staticDataEncryptComp.staticBinarySafeDecryptNoB64(num.intValue(), str2, bArr, str3);
                }
            }
        } catch (Throwable th) {
            ALog.m2961e(f2263a, "staticBinarySafeDecryptNoB64", null, th, new Object[0]);
        }
        return null;
    }
}
