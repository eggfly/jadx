package anet.channel.strategy;

import anet.channel.strategy.dispatch.C0714a;
import anet.channel.util.ALog;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.utl.BaseMonitor;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: anet.channel.strategy.k */
public class C0731k {

    /* renamed from: anet.channel.strategy.k.a */
    public static class C0728a {
        public final int f2379a;
        public final String f2380b;
        public final int f2381c;
        public final int f2382d;
        public final int f2383e;
        public final int f2384f;
        public final String f2385g;
        public final boolean f2386h;
        public final boolean f2387i;
        public final String f2388j;

        public C0728a(JSONObject jSONObject) {
            boolean z = true;
            this.f2379a = jSONObject.optInt("port");
            this.f2380b = jSONObject.optString("protocol");
            this.f2381c = jSONObject.optInt("cto");
            this.f2382d = jSONObject.optInt("rto");
            this.f2383e = jSONObject.optInt("retry");
            this.f2384f = jSONObject.optInt("heartbeat");
            this.f2385g = jSONObject.optString("rtt", BuildConfig.FLAVOR);
            this.f2387i = jSONObject.optInt("l7encript", 0) == 1;
            this.f2388j = jSONObject.optString("publickey");
            if (jSONObject.optInt(BaseMonitor.ALARM_POINT_AUTH, 0) != 1) {
                z = false;
            }
            this.f2386h = z;
        }

        public String toString() {
            return "{port=" + this.f2379a + "protocol=" + this.f2380b + "publickey=" + this.f2388j + "}";
        }
    }

    /* renamed from: anet.channel.strategy.k.b */
    public static class C0729b {
        public final String f2389a;
        public final int f2390b;
        public final String f2391c;
        public final String f2392d;
        public final String[] f2393e;
        public final C0728a[] f2394f;
        public final String f2395g;
        public final int f2396h;
        public final String f2397i;
        public final int f2398j;
        public final int f2399k;
        public final boolean f2400l;
        public final boolean f2401m;
        public final String f2402n;
        public final boolean f2403o;
        public final int f2404p;
        public final boolean f2405q;

        public C0729b(JSONObject jSONObject) {
            boolean z = true;
            int i = 0;
            this.f2389a = jSONObject.optString(C4103b.ELECTION_KEY_HOST);
            this.f2390b = jSONObject.optInt("ttl");
            this.f2391c = jSONObject.optString("safeAisles");
            this.f2392d = jSONObject.optString("cname");
            this.f2395g = jSONObject.optString("hrStrategy");
            this.f2396h = jSONObject.optInt("hrIntervalTime");
            this.f2397i = jSONObject.optString("hrUrlPath");
            this.f2398j = jSONObject.optInt("hrNum");
            this.f2399k = jSONObject.optInt("parallelConNum");
            this.f2400l = jSONObject.optBoolean("idc");
            this.f2404p = jSONObject.optInt("isHot", -1);
            this.f2401m = jSONObject.optInt("clear") == 1;
            this.f2402n = jSONObject.optString("etag");
            if (jSONObject.optInt("notModified") != 1) {
                z = false;
            }
            this.f2403o = z;
            this.f2405q = jSONObject.optBoolean("effectNow");
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f2393e = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f2393e[i2] = optJSONArray.optString(i2);
                }
            } else {
                this.f2393e = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("aisles");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.f2394f = new C0728a[length2];
                while (i < length2) {
                    this.f2394f[i] = new C0728a(optJSONArray2.optJSONObject(i));
                    i++;
                }
                return;
            }
            this.f2394f = null;
        }
    }

    /* renamed from: anet.channel.strategy.k.c */
    public static class C0730c {
        public final String f2406a;
        public final String f2407b;
        public final C0729b[] f2408c;
        public final String f2409d;
        public final String f2410e;
        public final int f2411f;
        public final int f2412g;
        public final int f2413h;

        public C0730c(JSONObject jSONObject) {
            this.f2406a = jSONObject.optString("ip");
            this.f2407b = jSONObject.optString("unit");
            this.f2409d = jSONObject.optString("uid", null);
            this.f2410e = jSONObject.optString(MsgConstant.KEY_UTDID, null);
            this.f2411f = jSONObject.optInt(C0714a.CONFIG_VERSION);
            this.f2412g = jSONObject.optInt("fcl");
            this.f2413h = jSONObject.optInt("fct");
            JSONArray optJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f2408c = new C0729b[length];
                for (int i = 0; i < length; i++) {
                    this.f2408c[i] = new C0729b(optJSONArray.optJSONObject(i));
                }
                return;
            }
            this.f2408c = null;
        }
    }

    public static C0730c m2940a(JSONObject jSONObject) {
        try {
            return new C0730c(jSONObject);
        } catch (Throwable e) {
            ALog.m2961e("StrategyResultParser", "Parse HttpDns response failed.", null, e, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
