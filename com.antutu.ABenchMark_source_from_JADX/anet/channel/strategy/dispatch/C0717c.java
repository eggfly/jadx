package anet.channel.strategy.dispatch;

import android.os.Build.VERSION;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;
import anet.channel.entity.C0667d;
import anet.channel.entity.C0668b;
import anet.channel.entity.C0670e;
import anet.channel.entity.EventType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.strategy.IConnStrategy;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.google.analytics.tracking.android.ModelFields;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.taobao.accs.antibrush.C4077b;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.C4103b;
import com.umeng.message.common.C4209a;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.android.agoo.common.C4575b;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: anet.channel.strategy.dispatch.c */
public class C0717c {
    private static LinkedBlockingQueue<C0716a> f2364a;

    /* renamed from: anet.channel.strategy.dispatch.c.a */
    private static class C0716a {
        String f2355a;
        String f2356b;
        int f2357c;
        String f2358d;
        boolean f2359e;
        String f2360f;
        String f2361g;
        long f2362h;
        String f2363i;

        C0716a(String str, String str2, String str3, IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d) {
            this.f2360f = str;
            this.f2361g = str2;
            this.f2355a = str3;
            this.f2356b = iConnStrategy.getIp();
            this.f2357c = iConnStrategy.getPort();
            this.f2358d = iConnStrategy.getConnType().toProtocol();
            if (eventType == EventType.CONNECTED) {
                this.f2359e = true;
                if (c0667d != null && (c0667d instanceof C0668b)) {
                    this.f2362h = ((C0668b) c0667d).f2220a;
                }
            } else if (eventType == EventType.CONNECT_FAIL) {
                this.f2359e = false;
                if (c0667d != null) {
                    this.f2363i = String.format("errorCode:%s errorDetail:%s", new Object[]{Integer.valueOf(c0667d.f2218d), c0667d.f2219e});
                }
            } else if (eventType == EventType.HORSE_RIDE && c0667d != null && (c0667d instanceof C0670e)) {
                this.f2359e = ((C0670e) c0667d).f2223a;
                if (this.f2359e) {
                    this.f2362h = ((C0670e) c0667d).f2224b;
                    return;
                }
                this.f2363i = String.format("errorCode:%s errorDetail:%s", new Object[]{Integer.valueOf(c0667d.f2218d), c0667d.f2219e});
            }
        }

        public JSONObject m2926a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C4103b.ELECTION_KEY_HOST, this.f2355a);
                jSONObject.put("ip", this.f2356b);
                jSONObject.put("port", this.f2357c);
                jSONObject.put("protocol", this.f2358d);
                jSONObject.put(KEYS.RET, this.f2359e);
                jSONObject.put("netIp", this.f2361g);
                jSONObject.put("reason", this.f2363i);
                jSONObject.put(KEYS.RET, this.f2359e);
                jSONObject.put("rt", this.f2362h);
                int indexOf = this.f2360f.indexOf("$");
                if (indexOf != -1) {
                    jSONObject.put(C0714a.NET_TYPE, this.f2360f.substring(0, indexOf));
                    return jSONObject;
                }
                jSONObject.put(C0714a.NET_TYPE, this.f2360f);
                return jSONObject;
            } catch (Exception e) {
                return null;
            }
        }
    }

    static {
        f2364a = new LinkedBlockingQueue();
    }

    public static Map<String, Object> m2927a(Map<String, Object> map) {
        map.put(IXAdRequestInfo.f6909V, C0714a.VER_CODE);
        if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getAppKey())) {
            map.put(C4209a.f14204g, GlobalAppRuntimeInfo.getAppKey());
        }
        map.put(C0714a.PLATFORM, C0714a.ANDROID);
        map.put(C0714a.PLATFORM_VERSION, VERSION.RELEASE);
        if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getUserId())) {
            map.put(Constants.KEY_SID, GlobalAppRuntimeInfo.getUserId());
        }
        if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getUtdid())) {
            map.put(C4575b.KEY_DEVICE_TOKEN, GlobalAppRuntimeInfo.getUtdid());
        }
        NetworkStatus a = NetworkStatusHelper.m2839a();
        map.put(C0714a.NET_TYPE, a.toString());
        if (a.isWifi()) {
            map.put(C0714a.BSSID, NetworkStatusHelper.m2845d());
        }
        map.put(C0714a.SIGNTYPE, SessionCenter.SECURITYGUARD_OFF ? "noSec" : C4077b.KEY_SEC);
        C0717c.m2930c(map);
        C0717c.m2929b(map);
        return map;
    }

    public static void m2928a(String str, String str2, String str3, IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d) {
        if (eventType == EventType.CONNECTED || eventType == EventType.CONNECT_FAIL || eventType == EventType.HORSE_RIDE) {
            f2364a.offer(new C0716a(str, str2, str3, iConnStrategy, eventType, c0667d));
        }
    }

    private static void m2929b(Map<String, Object> map) {
        try {
            String ttid = GlobalAppRuntimeInfo.getTtid();
            if (!TextUtils.isEmpty(ttid)) {
                int indexOf = ttid.indexOf("@");
                if (indexOf != -1) {
                    map.put(C4209a.f14201d, ttid.substring(0, indexOf));
                }
                ttid = ttid.substring(indexOf + 1);
                indexOf = ttid.lastIndexOf("_");
                if (indexOf != -1) {
                    map.put(ModelFields.APP_NAME, ttid.substring(0, indexOf));
                    map.put(Constants.KEY_APP_VERSION, ttid.substring(indexOf + 1));
                    return;
                }
                map.put(ModelFields.APP_NAME, ttid);
            }
        } catch (Exception e) {
        }
    }

    private static void m2930c(Map<String, Object> map) {
        try {
            JSONArray jSONArray = new JSONArray();
            while (true) {
                C0716a c0716a = (C0716a) f2364a.poll();
                if (c0716a != null) {
                    JSONObject a = c0716a.m2926a();
                    if (a == null) {
                        break;
                    }
                    jSONArray.put(a);
                } else {
                    break;
                }
            }
            map.put(C0714a.CONN_MSG, jSONArray.toString());
        } catch (Exception e) {
        }
    }
}
