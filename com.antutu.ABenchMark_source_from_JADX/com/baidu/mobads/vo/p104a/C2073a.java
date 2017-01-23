package com.baidu.mobads.vo.p104a;

import android.content.Context;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.p080j.C1982d;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p081a.C1907a;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.mobads.vo.a.a */
public abstract class C2073a {
    public long f7259a;
    public String f7260b;
    public String f7261c;
    public String f7262d;
    public String f7263e;
    public String f7264f;
    public String f7265g;
    public String f7266h;
    public String f7267i;
    public String f7268j;
    protected Context f7269k;
    protected C1982d f7270l;
    protected IXAdSystemUtils f7271m;

    public C2073a(XAdCommandExtraInfo xAdCommandExtraInfo) {
        this(xAdCommandExtraInfo.getAdInstanceInfo().getAdId(), xAdCommandExtraInfo.getAdInstanceInfo().getQueryKey(), xAdCommandExtraInfo.mProdType);
    }

    public C2073a(String str, String str2, String str3) {
        this.f7260b = "-1";
        this.f7261c = BuildConfig.FLAVOR;
        this.f7262d = BuildConfig.FLAVOR;
        this.f7263e = BuildConfig.FLAVOR;
        this.f7264f = BuildConfig.FLAVOR;
        this.f7265g = BuildConfig.FLAVOR;
        this.f7266h = BuildConfig.FLAVOR;
        this.f7268j = BuildConfig.FLAVOR;
        this.f7270l = C1991m.m7449a().m7464m();
        this.f7271m = C1991m.m7449a().m7465n();
        this.f7269k = C1991m.m7449a().m7455d();
        this.f7259a = System.currentTimeMillis();
        this.f7260b = str;
        this.f7261c = str2;
        this.f7263e = this.f7270l.getAppSec(this.f7269k);
        if (this.f7269k != null) {
            this.f7262d = this.f7269k.getPackageName();
        }
        this.f7264f = this.f7270l.getAppId(this.f7269k);
        this.f7266h = this.f7271m.getEncodedSN(this.f7269k);
        this.f7267i = C0714a.ANDROID;
        this.f7265g = "android_" + C1907a.f6655c + "_" + "4.1.30";
        this.f7268j = str3;
    }

    protected String m7753a(String str) {
        try {
            str = URLEncoder.encode(str, HttpRequest.f14548a).replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", C4233j.f14396s).replaceAll("\\%29", C4233j.f14397t).replaceAll("\\%7E", "~");
        } catch (Exception e) {
        }
        return str;
    }

    protected String m7754a(HashMap<String, String> hashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            C1982d m = C1991m.m7449a().m7464m();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String str : hashMap.keySet()) {
                String str2;
                String str3 = (String) hashMap.get(str2);
                if (!(str2 == null || str3 == null)) {
                    str2 = m7753a(str2);
                    str3 = m7753a(str3);
                    stringBuilder.append(str2 + "=" + str3 + "&");
                    stringBuilder2.append(str3 + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            stringBuilder2.append("mobads,");
            stringBuilder.append("vd=" + m.getMD5(stringBuilder2.toString()) + "&");
            return stringBuilder.toString();
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    protected HashMap<String, String> m7755a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("adid", this.f7260b);
        hashMap.put("appsec", this.f7263e);
        hashMap.put("appsid", this.f7264f);
        hashMap.put("pack", this.f7262d);
        hashMap.put("qk", this.f7261c);
        hashMap.put(IXAdRequestInfo.SN, this.f7266h);
        hashMap.put(MsgConstant.KEY_TS, BuildConfig.FLAVOR + this.f7259a);
        hashMap.put(IXAdRequestInfo.f6909V, this.f7265g);
        hashMap.put(com.taobao.accs.common.Constants.KEY_OS_VERSION, this.f7267i);
        hashMap.put("prod", this.f7268j);
        hashMap.put(IXAdRequestInfo.P_VER, "8.8");
        return hashMap;
    }

    protected abstract HashMap<String, String> m7756b();

    public HashMap<String, String> m7757c() {
        HashMap<String, String> a = m7755a();
        Map b = m7756b();
        if (b != null) {
            a.putAll(b);
        }
        return a;
    }

    public String toString() {
        return m7754a(m7757c());
    }
}
