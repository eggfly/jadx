package com.baidu.mobads.p090e;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;

/* renamed from: com.baidu.mobads.e.a */
public class C1931a implements IXAdErrorCode {
    protected final IXAdLogger f6769a;

    public C1931a(IXAdLogger iXAdLogger) {
        this.f6769a = iXAdLogger;
    }

    private String m7272a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ErrorCode: [");
        stringBuilder.append(str);
        stringBuilder.append("]; ErrorDesc: [");
        stringBuilder.append(str2);
        stringBuilder.append("];");
        if (!TextUtils.isEmpty(str3)) {
            stringBuilder.append(" Extra: [");
            stringBuilder.append(str3);
            stringBuilder.append("];");
        }
        return stringBuilder.toString();
    }

    public String genCompleteErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        return xAdErrorCode == null ? BuildConfig.FLAVOR : m7272a(xAdErrorCode.getCode() + BuildConfig.FLAVOR, xAdErrorCode.getMessage(), str);
    }

    public String getMessage(Map<String, Object> map) {
        if (map == null) {
            return BuildConfig.FLAVOR;
        }
        return C1991m.m7449a().m7468q().genCompleteErrorMessage((XAdErrorCode) map.get(XAdErrorCode.ERROR_CODE_MESSAGE), BuildConfig.FLAVOR);
    }

    public void printErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        this.f6769a.m7397e(genCompleteErrorMessage(xAdErrorCode, str));
    }

    public void printErrorMessage(String str, String str2, String str3) {
        this.f6769a.m7397e(m7272a(str, str2, str3));
    }
}
