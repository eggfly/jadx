package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.security.C0684c;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4209a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;
import org.android.agoo.common.C4575b;
import org.android.spdy.SpdyProtocol;

/* renamed from: anet.channel.strategy.dispatch.d */
class C0718d {
    C0718d() {
    }

    public static String m2931a(String str) {
        String str2 = BuildConfig.FLAVOR;
        String sign;
        try {
            if (TextUtils.isEmpty(GlobalAppRuntimeInfo.getAppKey())) {
                ALog.m2962e("awcn.DispatchSecurityUtil", "getAppSign appkey null", null, new Object[0]);
                return null;
            }
            sign = C0684c.m2818a().sign(GlobalAppRuntimeInfo.getContext(), ISecurity.SIGN_ALGORITHM_HMAC_SHA1, GlobalAppRuntimeInfo.getAppKey(), str, GlobalAppRuntimeInfo.getAuthCode());
            return sign;
        } catch (Throwable th) {
            ALog.m2961e("awcn.DispatchSecurityUtil", "getSign", null, th, new Object[0]);
            return str2;
        }
    }

    public static Map<String, String> m2932a(Map<String, String> map) {
        map.put(C0714a.TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        StringBuilder stringBuilder = new StringBuilder(SpdyProtocol.SLIGHTSSLV2);
        stringBuilder.append(StringUtils.stringNull2Empty((String) map.get(C4209a.f14204g))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.DOMAIN))).append("&").append(StringUtils.stringNull2Empty((String) map.get(ModelFields.APP_NAME))).append("&").append(StringUtils.stringNull2Empty((String) map.get(Constants.KEY_APP_VERSION))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.BSSID))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C4209a.f14201d))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C4575b.KEY_DEVICE_TOKEN))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.LATITUDE))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.OTHER))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.MACHINE))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.NET_TYPE))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.OTHER))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.PLATFORM))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.PLATFORM_VERSION))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.PRE_IP))).append("&").append(StringUtils.stringNull2Empty((String) map.get(Constants.KEY_SID))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.TIMESTAMP))).append("&").append(StringUtils.stringNull2Empty((String) map.get(IXAdRequestInfo.f6909V))).append("&").append(StringUtils.stringNull2Empty((String) map.get(C0714a.SIGNTYPE)));
        map.put(Constants.KEY_SECURITY_SIGN, C0718d.m2931a(stringBuilder.toString()));
        return map;
    }
}
