package com.igexin.push.core.bean;

import android.os.Build.VERSION;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.utils.PointMark;
import com.igexin.push.core.C3855g;
import com.igexin.push.util.C3933l;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.bean.a */
public class C3821a {
    public String f12807a;
    public String f12808b;
    public String f12809c;
    public String f12810d;
    public String f12811e;
    public String f12812f;
    public String f12813g;
    public String f12814h;
    public String f12815i;
    public String f12816j;
    public String f12817k;
    public long f12818l;

    public C3821a() {
        this.f12812f = PushBuildConfig.sdk_conf_channelid;
        if (C3855g.f12967e != null) {
            this.f12812f += ":" + C3855g.f12967e;
        }
        this.f12811e = PushBuildConfig.sdk_conf_version;
        this.f12808b = C3855g.f12985w;
        this.f12809c = C3855g.f12984v;
        this.f12810d = C3855g.f12987y;
        this.f12815i = C3855g.f12988z;
        this.f12807a = C3855g.f12986x;
        this.f12814h = "ANDROID";
        this.f12816j = C0714a.ANDROID + VERSION.RELEASE;
        this.f12817k = "MDP";
        this.f12813g = C3855g.f12937A;
        this.f12818l = System.currentTimeMillis();
    }

    public static String m15693a(C3821a c3821a) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.KEY_MODEL, c3821a.f12807a == null ? BuildConfig.FLAVOR : c3821a.f12807a);
        jSONObject.put("sim", c3821a.f12808b == null ? BuildConfig.FLAVOR : c3821a.f12808b);
        jSONObject.put(Constants.KEY_IMEI, c3821a.f12809c == null ? BuildConfig.FLAVOR : c3821a.f12809c);
        jSONObject.put(PointMark.T_MAC, c3821a.f12810d == null ? BuildConfig.FLAVOR : c3821a.f12810d);
        jSONObject.put(Constants.SP_KEY_VERSION, c3821a.f12811e == null ? BuildConfig.FLAVOR : c3821a.f12811e);
        jSONObject.put("channelid", c3821a.f12812f == null ? BuildConfig.FLAVOR : c3821a.f12812f);
        jSONObject.put(C4233j.f14402y, "ANDROID");
        jSONObject.put("app", c3821a.f12817k == null ? BuildConfig.FLAVOR : c3821a.f12817k);
        jSONObject.put("deviceid", "ANDROID-" + (c3821a.f12813g == null ? BuildConfig.FLAVOR : c3821a.f12813g));
        jSONObject.put("system_version", c3821a.f12816j == null ? BuildConfig.FLAVOR : c3821a.f12816j);
        jSONObject.put("cell", c3821a.f12815i == null ? BuildConfig.FLAVOR : c3821a.f12815i);
        jSONObject.put("aid", C3933l.m16186b());
        jSONObject.put("adid", C3933l.m16187c());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PushConsts.CMD_ACTION, "addphoneinfo");
        jSONObject2.put(AgooConstants.MESSAGE_ID, String.valueOf(c3821a.f12818l));
        jSONObject2.put("info", jSONObject);
        return jSONObject2.toString();
    }
}
