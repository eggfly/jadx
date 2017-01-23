package com.baidu.mobads.p084c;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import com.antutu.benchmark.modelreflact.TestResultModel;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p081a.C1907a;
import com.baidu.mobads.vo.p104a.C2074b;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: com.baidu.mobads.c.a */
public class C1918a {
    private static C1918a f6710b;
    protected final IXAdLogger f6711a;
    private Context f6712c;

    static {
        f6710b = new C1918a();
    }

    private C1918a() {
        this.f6711a = C1991m.m7449a().m7457f();
    }

    public static C1918a m7217a() {
        return f6710b;
    }

    private String m7218a(Context context, String str, Map<String, String> map) {
        try {
            String encodeURIComponent;
            StringBuilder stringBuilder = new StringBuilder("type=" + str + "&");
            StringBuilder stringBuilder2 = new StringBuilder();
            map.put(MsgConstant.KEY_TS, System.currentTimeMillis() + BuildConfig.FLAVOR);
            IXAdCommonUtils m = C1991m.m7449a().m7464m();
            for (String encodeURIComponent2 : map.keySet()) {
                String str2 = (String) map.get(encodeURIComponent2);
                if (!(encodeURIComponent2 == null || str2 == null)) {
                    encodeURIComponent2 = m.encodeURIComponent(encodeURIComponent2);
                    str2 = m.encodeURIComponent(str2);
                    stringBuilder.append(encodeURIComponent2);
                    stringBuilder.append("=");
                    stringBuilder.append(str2);
                    stringBuilder.append("&");
                    stringBuilder2.append(str2);
                    stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            stringBuilder2.append("mobads,");
            encodeURIComponent2 = m.getMD5(stringBuilder2.toString());
            this.f6711a.m7392d("ExtraQuery.allValue:" + stringBuilder2);
            stringBuilder.append("vd=" + encodeURIComponent2 + "&");
            this.f6711a.m7392d("ExtraQuery.params:" + stringBuilder);
            return "http://mobads-logs.baidu.com/dz.zb" + "?" + stringBuilder.toString();
        } catch (Throwable e) {
            this.f6711a.m7395d(e);
            return BuildConfig.FLAVOR;
        }
    }

    private void m7219a(int i, String str) {
        C2021a c2021a = new C2021a();
        C2024d c2024d = new C2024d(str, BuildConfig.FLAVOR);
        c2024d.f7057e = i;
        c2021a.m7547a(c2024d, Boolean.valueOf(true));
    }

    private void m7220a(Context context, String str, C1924a c1924a) {
        C2074b c2074b = new C2074b(context, c1924a);
        c2074b.b = c1924a.f6743n;
        m7222b(m7218a(context, str, c2074b.m7757c()));
    }

    private void m7221a(String str, String str2, Builder builder) {
        IXAdConstants p = C1991m.m7449a().m7467p();
        IXAdCommonUtils m = C1991m.m7449a().m7464m();
        if (builder == null) {
            builder = new Builder();
        }
        try {
            builder.appendQueryParameter(C4233j.f14402y, str2).appendQueryParameter(IXAdRequestInfo.P_VER, "8.8").appendQueryParameter("appsid", p.getAppSid()).appendQueryParameter(IXAdRequestInfo.f6909V, "android_" + C1907a.f6655c + "_" + "4.1.30").appendQueryParameter("reason", str).appendQueryParameter(IXAdRequestInfo.OSV, VERSION.RELEASE).appendQueryParameter(IXAdRequestInfo.BDR, BuildConfig.FLAVOR + VERSION.SDK_INT).appendQueryParameter(IXAdRequestInfo.BRAND, BuildConfig.FLAVOR + m.getTextEncoder(Build.BRAND)).appendQueryParameter("pack", p.getAppPackageNameOfPublisher());
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7399e(e);
        }
        C2024d c2024d = new C2024d("http://mobads-logs.baidu.com/brwhis.log", BuildConfig.FLAVOR);
        c2024d.m7550a(builder);
        c2024d.m7549a(0);
        new C2021a().m7545a(c2024d);
    }

    private void m7222b(String str) {
        m7219a(1, str);
    }

    public void m7223a(Context context) {
        if (this.f6712c == null) {
            this.f6712c = context;
        }
    }

    public void m7224a(Context context, C1924a c1924a) {
        m7220a(context, MessageService.MSG_ACCS_NOTIFY_DISMISS, c1924a);
    }

    public void m7225a(C1924a c1924a) {
    }

    public void m7226a(String str) {
        m7221a(str, "400", null);
    }

    public void m7227a(String str, String str2, String str3) {
        Builder appendQueryParameter = new Builder().appendQueryParameter("stacktrace", str2);
        appendQueryParameter.appendQueryParameter(TestResultModel.TYPE_AD, str3);
        m7221a(str, "404", appendQueryParameter);
    }

    public void m7228b(Context context, C1924a c1924a) {
        m7220a(context, AgooConstants.ACK_BODY_NULL, c1924a);
    }

    public void m7229c(Context context, C1924a c1924a) {
        m7220a(context, AgooConstants.ACK_REMOVE_PACKAGE, c1924a);
    }
}
