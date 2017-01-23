package com.umeng.message.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.proguard.C4215b;
import org.android.agoo.common.C4575b;
import org.json.JSONObject;

/* renamed from: com.umeng.message.common.b */
public class C4210b {
    public static final String f14218C = "Android";
    public static final String f14219D = "Android";
    private static final String f14220E;
    public String f14221A;
    public String f14222B;
    private final String f14223F;
    private final String f14224G;
    private final String f14225H;
    private final String f14226I;
    private final String f14227J;
    private final String f14228K;
    private final String f14229L;
    private final String f14230M;
    private final String f14231N;
    private final String f14232O;
    private final String f14233P;
    private final String f14234Q;
    private final String f14235R;
    private final String f14236S;
    private final String f14237T;
    private final String f14238U;
    private final String f14239V;
    private final String f14240W;
    private final String f14241X;
    private final String f14242Y;
    private final String f14243Z;
    public String f14244a;
    private final String aa;
    private final String ab;
    private final String ac;
    private final String ad;
    private final String ae;
    private final String af;
    private final String ag;
    public String f14245b;
    public String f14246c;
    public String f14247d;
    public String f14248e;
    public long f14249f;
    public String f14250g;
    public String f14251h;
    public String f14252i;
    public String f14253j;
    public String f14254k;
    public String f14255l;
    public String f14256m;
    public String f14257n;
    public String f14258o;
    public String f14259p;
    public String f14260q;
    public String f14261r;
    public String f14262s;
    public String f14263t;
    public int f14264u;
    public String f14265v;
    public String f14266w;
    public String f14267x;
    public String f14268y;
    public String f14269z;

    static {
        f14220E = C4210b.class.getName();
    }

    public C4210b() {
        this.f14223F = C4209a.f14204g;
        this.f14224G = C4209a.f14201d;
        this.f14225H = "device_id";
        this.f14226I = C4209a.f14202e;
        this.f14227J = "mc";
        this.f14228K = "req_time";
        this.f14229L = "android_id";
        this.f14230M = "serial_number";
        this.f14231N = "device_model";
        this.f14232O = Constants.KEY_OS_VERSION;
        this.f14233P = "os_version";
        this.f14234Q = "resolution";
        this.f14235R = "cpu";
        this.f14236S = "gpu_vender";
        this.f14237T = "gpu_renderer";
        this.f14238U = C4575b.PROPERTY_APP_VERSION;
        this.f14239V = C4209a.f14203f;
        this.f14240W = "package_name";
        this.f14241X = "sdk_type";
        this.f14242Y = C4209a.f14205h;
        this.f14243Z = "timezone";
        this.aa = "country";
        this.ab = ModelFields.LANGUAGE;
        this.ac = "access";
        this.ad = "access_subtype";
        this.ae = "carrier";
        this.af = "wrapper_type";
        this.ag = "wrapper_version";
    }

    public C4210b(String str, String str2) {
        this.f14223F = C4209a.f14204g;
        this.f14224G = C4209a.f14201d;
        this.f14225H = "device_id";
        this.f14226I = C4209a.f14202e;
        this.f14227J = "mc";
        this.f14228K = "req_time";
        this.f14229L = "android_id";
        this.f14230M = "serial_number";
        this.f14231N = "device_model";
        this.f14232O = Constants.KEY_OS_VERSION;
        this.f14233P = "os_version";
        this.f14234Q = "resolution";
        this.f14235R = "cpu";
        this.f14236S = "gpu_vender";
        this.f14237T = "gpu_renderer";
        this.f14238U = C4575b.PROPERTY_APP_VERSION;
        this.f14239V = C4209a.f14203f;
        this.f14240W = "package_name";
        this.f14241X = "sdk_type";
        this.f14242Y = C4209a.f14205h;
        this.f14243Z = "timezone";
        this.aa = "country";
        this.ab = ModelFields.LANGUAGE;
        this.ac = "access";
        this.ad = "access_subtype";
        this.ae = "carrier";
        this.af = "wrapper_type";
        this.ag = "wrapper_version";
        this.f14244a = str;
        this.f14245b = str2;
    }

    private void m17148d(JSONObject jSONObject) {
        this.f14244a = jSONObject.getString(C4209a.f14204g);
        this.f14246c = jSONObject.getString("device_id");
        this.f14247d = jSONObject.getString(C4209a.f14202e);
        if (jSONObject.has("mc")) {
            this.f14248e = jSONObject.getString("mc");
        }
        if (jSONObject.has(C4209a.f14201d)) {
            this.f14245b = jSONObject.getString(C4209a.f14201d);
        }
        if (jSONObject.has("req_time")) {
            this.f14249f = jSONObject.getLong("req_time");
        }
    }

    private void m17149e(JSONObject jSONObject) {
        String str = null;
        this.f14252i = jSONObject.has("device_model") ? jSONObject.getString("device_model") : null;
        this.f14253j = jSONObject.has(Constants.KEY_OS_VERSION) ? jSONObject.getString(Constants.KEY_OS_VERSION) : null;
        this.f14254k = jSONObject.has("os_version") ? jSONObject.getString("os_version") : null;
        this.f14255l = jSONObject.has("resolution") ? jSONObject.getString("resolution") : null;
        this.f14256m = jSONObject.has("cpu") ? jSONObject.getString("cpu") : null;
        this.f14257n = jSONObject.has("gpu_vender") ? jSONObject.getString("gpu_vender") : null;
        this.f14258o = jSONObject.has("gpu_renderer") ? jSONObject.getString("gpu_renderer") : null;
        this.f14250g = jSONObject.has("android_id") ? jSONObject.getString("android_id") : null;
        if (jSONObject.has("serial_number")) {
            str = jSONObject.getString("serial_number");
        }
        this.f14251h = str;
    }

    private void m17150f(JSONObject jSONObject) {
        String str = null;
        this.f14259p = jSONObject.has(C4575b.PROPERTY_APP_VERSION) ? jSONObject.getString(C4575b.PROPERTY_APP_VERSION) : null;
        this.f14260q = jSONObject.has(C4209a.f14203f) ? jSONObject.getString(C4209a.f14203f) : null;
        if (jSONObject.has("package_name")) {
            str = jSONObject.getString("package_name");
        }
        this.f14261r = str;
    }

    private void m17151g(JSONObject jSONObject) {
        this.f14262s = jSONObject.getString("sdk_type");
        this.f14263t = jSONObject.getString(C4209a.f14205h);
    }

    private void m17152h(JSONObject jSONObject) {
        String str = null;
        this.f14264u = jSONObject.has("timezone") ? jSONObject.getInt("timezone") : 8;
        this.f14265v = jSONObject.has("country") ? jSONObject.getString("country") : null;
        if (jSONObject.has(ModelFields.LANGUAGE)) {
            str = jSONObject.getString(ModelFields.LANGUAGE);
        }
        this.f14266w = str;
    }

    private void m17153i(JSONObject jSONObject) {
        String str = null;
        this.f14267x = jSONObject.has("access") ? jSONObject.getString("access") : null;
        this.f14268y = jSONObject.has("access_subtype") ? jSONObject.getString("access_subtype") : null;
        if (jSONObject.has("carrier")) {
            str = jSONObject.getString("carrier");
        }
        this.f14269z = str;
    }

    private void m17154j(JSONObject jSONObject) {
        String str = null;
        this.f14221A = jSONObject.has("wrapper_type") ? jSONObject.getString("wrapper_type") : null;
        if (jSONObject.has("wrapper_version")) {
            str = jSONObject.getString("wrapper_version");
        }
        this.f14222B = str;
    }

    private void m17155k(JSONObject jSONObject) {
        jSONObject.put(C4209a.f14204g, this.f14244a);
        if (this.f14244a == null || 24 != this.f14244a.length()) {
            this.f14246c = C4215b.m17209a(this.f14246c, "utf-8");
        } else {
            this.f14246c = C4215b.m17209a(this.f14246c, "utf-8", this.f14244a.substring(0, 16));
        }
        jSONObject.put("device_id", this.f14246c);
        jSONObject.put(C4209a.f14202e, this.f14247d);
        if (this.f14245b != null) {
            jSONObject.put(C4209a.f14201d, this.f14245b);
        }
        if (this.f14248e != null) {
            jSONObject.put("mc", this.f14248e);
        }
        if (this.f14249f > 0) {
            jSONObject.put("req_time", this.f14249f);
        }
        if (this.f14250g != null) {
            jSONObject.put("android_id", this.f14250g);
        }
        if (this.f14251h != null) {
            jSONObject.put("serial_number", this.f14251h);
        }
    }

    private void m17156l(JSONObject jSONObject) {
        jSONObject.put(C4209a.f14204g, this.f14244a);
        if (this.f14245b != null) {
            jSONObject.put(C4209a.f14201d, this.f14245b);
        }
    }

    private void m17157m(JSONObject jSONObject) {
        if (this.f14252i != null) {
            jSONObject.put("device_model", this.f14252i);
        }
        if (this.f14253j != null) {
            jSONObject.put(Constants.KEY_OS_VERSION, this.f14253j);
        }
        if (this.f14254k != null) {
            jSONObject.put("os_version", this.f14254k);
        }
        if (this.f14255l != null) {
            jSONObject.put("resolution", this.f14255l);
        }
        if (this.f14256m != null) {
            jSONObject.put("cpu", this.f14256m);
        }
        if (this.f14257n != null) {
            jSONObject.put("gpu_vender", this.f14257n);
        }
        if (this.f14258o != null) {
            jSONObject.put("gpu_vender", this.f14258o);
        }
    }

    private void m17158n(JSONObject jSONObject) {
        if (this.f14252i != null) {
            jSONObject.put("device_model", this.f14252i);
        }
        if (this.f14253j != null) {
            jSONObject.put(Constants.KEY_OS_VERSION, this.f14253j);
        }
        if (this.f14254k != null) {
            jSONObject.put("os_version", this.f14254k);
        }
    }

    private void m17159o(JSONObject jSONObject) {
        if (this.f14259p != null) {
            jSONObject.put(C4575b.PROPERTY_APP_VERSION, this.f14259p);
        }
        if (this.f14260q != null) {
            jSONObject.put(C4209a.f14203f, this.f14260q);
        }
        if (this.f14261r != null) {
            jSONObject.put("package_name", this.f14261r);
        }
    }

    private void m17160p(JSONObject jSONObject) {
        if (this.f14259p != null) {
            jSONObject.put(C4575b.PROPERTY_APP_VERSION, this.f14259p);
        }
        if (this.f14260q != null) {
            jSONObject.put(C4209a.f14203f, this.f14260q);
        }
    }

    private void m17161q(JSONObject jSONObject) {
        jSONObject.put("sdk_type", this.f14262s);
        jSONObject.put(C4209a.f14205h, this.f14263t);
    }

    private void m17162r(JSONObject jSONObject) {
        jSONObject.put("timezone", this.f14264u);
        if (this.f14265v != null) {
            jSONObject.put("country", this.f14265v);
        }
        if (this.f14266w != null) {
            jSONObject.put(ModelFields.LANGUAGE, this.f14266w);
        }
    }

    private void m17163s(JSONObject jSONObject) {
        if (this.f14267x != null) {
            jSONObject.put("access", this.f14267x);
        }
        if (this.f14268y != null) {
            jSONObject.put("access_subtype", this.f14268y);
        }
        if (this.f14269z != null) {
            jSONObject.put("carrier", this.f14269z);
        }
    }

    private void m17164t(JSONObject jSONObject) {
        if (this.f14221A != null) {
            jSONObject.put("wrapper_type", this.f14221A);
        }
        if (this.f14222B != null) {
            jSONObject.put("wrapper_version", this.f14222B);
        }
    }

    public void m17165a(Context context) {
        this.f14252i = Build.MODEL;
        this.f14253j = f14219D;
        this.f14254k = VERSION.RELEASE;
        this.f14255l = UmengMessageDeviceConfig.getResolution(context);
        this.f14256m = UmengMessageDeviceConfig.getCPU();
        this.f14250g = UmengMessageDeviceConfig.getAndroidId(context);
        this.f14251h = UmengMessageDeviceConfig.getSerial_number();
    }

    public void m17166a(Context context, String... strArr) {
        if (strArr != null && strArr.length == 2) {
            this.f14244a = strArr[0];
            this.f14245b = strArr[1];
        }
        if (this.f14244a == null) {
            this.f14244a = PushAgent.getInstance(context).getMessageAppkey();
        }
        if (this.f14245b == null) {
            this.f14245b = PushAgent.getInstance(context).getMessageChannel();
        }
        this.f14246c = UmengMessageDeviceConfig.getDeviceId(context);
        this.f14247d = UmengMessageDeviceConfig.getDeviceIdMD5(context);
        this.f14248e = UmengMessageDeviceConfig.getMac(context);
    }

    public void m17167a(JSONObject jSONObject) {
        if (jSONObject != null) {
            m17148d(jSONObject);
            m17149e(jSONObject);
            m17150f(jSONObject);
            m17151g(jSONObject);
            m17152h(jSONObject);
            m17153i(jSONObject);
            m17154j(jSONObject);
        }
    }

    public boolean m17168a() {
        if (this.f14244a == null) {
            UmLog.m17138e(f14220E, "missing appkey ");
            return false;
        } else if (this.f14246c != null && this.f14247d != null) {
            return true;
        } else {
            UmLog.m17138e(f14220E, "missing device id");
            return false;
        }
    }

    public void m17169b(Context context) {
        this.f14259p = UmengMessageDeviceConfig.getAppVersionName(context);
        this.f14260q = UmengMessageDeviceConfig.getAppVersionCode(context);
        this.f14261r = UmengMessageDeviceConfig.getPackageName(context);
    }

    public void m17170b(Context context, String... strArr) {
        m17166a(context, strArr);
        m17165a(context);
        m17169b(context);
        m17173c(context);
        m17176d(context);
        m17177e(context);
    }

    public void m17171b(JSONObject jSONObject) {
        m17155k(jSONObject);
        m17157m(jSONObject);
        m17159o(jSONObject);
        m17161q(jSONObject);
        m17162r(jSONObject);
        m17163s(jSONObject);
        m17164t(jSONObject);
    }

    public boolean m17172b() {
        return (this.f14244a == null || this.f14246c == null) ? false : true;
    }

    public void m17173c(Context context) {
        this.f14262s = f14219D;
        this.f14263t = MsgConstant.SDK_VERSION;
    }

    public void m17174c(Context context, String... strArr) {
        m17166a(context, strArr);
        m17165a(context);
        m17169b(context);
        m17173c(context);
        m17177e(context);
    }

    public void m17175c(JSONObject jSONObject) {
        m17156l(jSONObject);
        m17158n(jSONObject);
        m17160p(jSONObject);
        m17161q(jSONObject);
        m17163s(jSONObject);
    }

    public void m17176d(Context context) {
        this.f14264u = UmengMessageDeviceConfig.getTimeZone(context);
        String[] localeInfo = UmengMessageDeviceConfig.getLocaleInfo(context);
        this.f14265v = localeInfo[0];
        this.f14266w = localeInfo[1];
    }

    public void m17177e(Context context) {
        String[] networkAccessMode = UmengMessageDeviceConfig.getNetworkAccessMode(context);
        this.f14267x = networkAccessMode[0];
        this.f14268y = networkAccessMode[1];
        this.f14269z = UmengMessageDeviceConfig.getOperator(context);
    }
}
