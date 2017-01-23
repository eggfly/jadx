package com.mob.commons;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.mob.commons.authorize.C3982a;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.taobao.accs.internal.C4103b;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.mob.commons.a */
public class C3972a {
    private static HashMap<String, Object> f13308a;
    private static long f13309b;
    private static long f13310c;
    private static boolean f13311d;

    /* renamed from: com.mob.commons.a.1 */
    static class C39711 extends Thread {
        final /* synthetic */ Context f13307a;

        C39711(Context context) {
            this.f13307a = context;
        }

        public void run() {
            String n = C3972a.m16358r(this.f13307a);
            if (!TextUtils.isEmpty(n)) {
                C3972a.m16341b(n);
                C3996f.m16460d(this.f13307a, new Hashon().fromHashMap(C3972a.f13308a));
            }
            C3972a.f13311d = false;
        }
    }

    public static long m16336a(Context context) {
        long longValue;
        C3972a.m16355o(context);
        try {
            longValue = Long.valueOf(String.valueOf(f13308a.get("deviceTime"))).longValue();
        } catch (Throwable th) {
            longValue = 0;
        }
        return ((Long) C4021R.forceCast(f13308a.get("serverTime"), Long.valueOf(0))).longValue() + (SystemClock.elapsedRealtime() - longValue);
    }

    private static void m16340b() {
        f13308a = new HashMap();
        f13308a.put("in", Integer.valueOf(0));
        f13308a.put("all", Integer.valueOf(0));
        f13308a.put("aspa", Long.valueOf(2592000));
        f13308a.put("un", Integer.valueOf(0));
        f13308a.put("rt", Integer.valueOf(0));
        f13308a.put("rtsr", Integer.valueOf(300000));
        f13308a.put("mi", Integer.valueOf(0));
        f13308a.put("ext", Integer.valueOf(0));
        f13308a.put("bs", Integer.valueOf(0));
        f13308a.put("bsgap", Integer.valueOf(86400));
        f13308a.put("di", Integer.valueOf(0));
        f13308a.put("l", Integer.valueOf(0));
        f13308a.put("lgap", Integer.valueOf(86400));
        f13308a.put(IXAdRequestInfo.WIFI, Integer.valueOf(0));
        f13308a.put("adle", Integer.valueOf(172800));
    }

    private static void m16341b(String str) {
        try {
            f13308a = new Hashon().fromJson(str);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }

    public static boolean m16342b(Context context) {
        C3972a.m16355o(context);
        return 1 == ((Integer) C4021R.forceCast(f13308a.get("rt"), Integer.valueOf(1))).intValue();
    }

    public static int m16343c(Context context) {
        C3972a.m16355o(context);
        return ((Integer) C4021R.forceCast(f13308a.get("rtsr"), Integer.valueOf(300000))).intValue();
    }

    public static boolean m16344d(Context context) {
        C3972a.m16355o(context);
        return 1 == ((Integer) C4021R.forceCast(f13308a.get("all"), Integer.valueOf(1))).intValue();
    }

    public static long m16345e(Context context) {
        C3972a.m16355o(context);
        return ((Long) C4021R.forceCast(f13308a.get("aspa"), Long.valueOf(2592000))).longValue();
    }

    public static boolean m16346f(Context context) {
        C3972a.m16355o(context);
        return 1 == ((Integer) C4021R.forceCast(f13308a.get("di"), Integer.valueOf(1))).intValue();
    }

    public static boolean m16347g(Context context) {
        C3972a.m16355o(context);
        return 1 == ((Integer) C4021R.forceCast(f13308a.get("ext"), Integer.valueOf(1))).intValue();
    }

    public static boolean m16348h(Context context) {
        C3972a.m16355o(context);
        return 1 == ((Integer) C4021R.forceCast(f13308a.get("bs"), Integer.valueOf(1))).intValue();
    }

    public static int m16349i(Context context) {
        C3972a.m16355o(context);
        return ((Integer) C4021R.forceCast(f13308a.get("bsgap"), Integer.valueOf(86400))).intValue();
    }

    public static boolean m16350j(Context context) {
        C3972a.m16355o(context);
        return 1 == ((Integer) C4021R.forceCast(f13308a.get("l"), Integer.valueOf(0))).intValue();
    }

    public static int m16351k(Context context) {
        C3972a.m16355o(context);
        return ((Integer) C4021R.forceCast(f13308a.get("lgap"), Integer.valueOf(86400))).intValue();
    }

    public static boolean m16352l(Context context) {
        C3972a.m16355o(context);
        return 1 == ((Integer) C4021R.forceCast(f13308a.get(IXAdRequestInfo.WIFI), Integer.valueOf(1))).intValue();
    }

    public static long m16353m(Context context) {
        C3972a.m16355o(context);
        return (((long) ((Integer) C4021R.forceCast(f13308a.get("adle"), Integer.valueOf(172800))).intValue()) * 1000) + C3972a.m16336a(context);
    }

    private static synchronized void m16355o(Context context) {
        synchronized (C3972a.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (f13308a == null) {
                if (C3972a.m16356p(context)) {
                    f13309b = elapsedRealtime;
                }
            } else if (elapsedRealtime - f13309b >= 60000 && C3972a.m16357q(context)) {
                f13309b = elapsedRealtime;
            }
        }
    }

    private static boolean m16356p(Context context) {
        String r = C3972a.m16358r(context);
        if (TextUtils.isEmpty(r)) {
            C3972a.m16340b();
            return false;
        }
        C3972a.m16341b(r);
        C3996f.m16460d(context, new Hashon().fromHashMap(f13308a));
        return true;
    }

    private static boolean m16357q(Context context) {
        String e = C3996f.m16461e(context);
        if (TextUtils.isEmpty(e)) {
            return C3972a.m16356p(context);
        }
        C3972a.m16341b(e);
        if (((Long) C4021R.forceCast(f13308a.get("timestamp"), Long.valueOf(0))).longValue() - f13310c >= C4156a.f13948j) {
            C3972a.m16359s(context);
        }
        return true;
    }

    private static String m16358r(Context context) {
        try {
            C3983b a = C3983b.m16407a(context);
            ArrayList a2 = a.m16409a();
            if (a2.isEmpty()) {
                return null;
            }
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair(C4209a.f14204g, ((MobProduct) a2.get(0)).getProductAppkey()));
            arrayList.add(new KVPair("plat", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPlatformCode", new Object[0]))));
            arrayList.add(new KVPair("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]))));
            arrayList.add(new KVPair("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersionName", new Object[0]))));
            arrayList.add(new KVPair("networktype", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]))));
            CharSequence a3 = new C3982a().m16405a(context);
            if (!TextUtils.isEmpty(a3)) {
                arrayList.add(new KVPair("duid", a3));
            }
            NetworkTimeOut networkTimeOut = new NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new KVPair("User-Identity", a.m16408a(a2)));
            String httpGet = a.httpGet(C3972a.m16360t(context), arrayList, arrayList2, networkTimeOut);
            Hashon hashon = new Hashon();
            HashMap fromJson = hashon.fromJson(httpGet);
            if (fromJson == null) {
                return null;
            }
            if ("200".equals(String.valueOf(fromJson.get(MsgConstant.KEY_STATUS)))) {
                String str = (String) C4021R.forceCast(fromJson.get("sr"));
                if (str != null) {
                    HashMap fromJson2 = hashon.fromJson(Data.AES128Decode("FYsAXMqlWJLCDpnc", Base64.decode(str, 2)));
                    if (fromJson2 != null) {
                        String str2;
                        int intValue;
                        HashMap hashMap = (HashMap) C4021R.forceCast(fromJson2.get("cdata"));
                        if (hashMap != null) {
                            str2 = (String) C4021R.forceCast(hashMap.get(C4103b.ELECTION_KEY_HOST));
                            intValue = ((Integer) C4021R.forceCast(hashMap.get("httpport"), Integer.valueOf(0))).intValue();
                            str = (String) C4021R.forceCast(hashMap.get("path"));
                            if (str2 == null || intValue == 0 || str == null) {
                                C3996f.m16462e(context, null);
                            } else {
                                C3996f.m16462e(context, "http://" + str2 + ":" + intValue + str);
                            }
                        } else {
                            C3996f.m16462e(context, null);
                        }
                        hashMap = (HashMap) C4021R.forceCast(fromJson2.get("cconf"));
                        if (hashMap != null) {
                            str2 = (String) C4021R.forceCast(hashMap.get(C4103b.ELECTION_KEY_HOST));
                            intValue = ((Integer) C4021R.forceCast(hashMap.get("httpport"), Integer.valueOf(0))).intValue();
                            str = (String) C4021R.forceCast(hashMap.get("path"));
                            if (str2 == null || intValue == 0 || str == null) {
                                C3996f.m16464f(context, null);
                            } else {
                                C3996f.m16464f(context, "http://" + str2 + ":" + intValue + str);
                            }
                        } else {
                            C3996f.m16464f(context, null);
                        }
                    }
                }
                str = (String) C4021R.forceCast(fromJson.get("sc"));
                if (str == null) {
                    throw new Throwable("response is illegal: " + httpGet);
                }
                HashMap fromJson3 = hashon.fromJson(Data.AES128Decode("FYsAXMqlWJLCDpnc", Base64.decode(str, 2)));
                if (fromJson3 == null) {
                    throw new Throwable("response is illegal: " + httpGet);
                }
                long longValue = ((Long) C4021R.forceCast(fromJson.get("timestamp"), Long.valueOf(0))).longValue();
                fromJson3.put("deviceTime", Long.valueOf(SystemClock.elapsedRealtime()));
                fromJson3.put("serverTime", Long.valueOf(longValue));
                return hashon.fromHashMap(fromJson3);
            }
            C3996f.m16462e(context, null);
            C3996f.m16464f(context, null);
            throw new Throwable("response is illegal: " + httpGet);
        } catch (Throwable th) {
            C3996f.m16462e(context, null);
            C3996f.m16464f(context, null);
            MobLog.getInstance().m4388w(th);
            return null;
        }
    }

    private static void m16359s(Context context) {
        if (!f13311d) {
            f13311d = true;
            new C39711(context).start();
        }
    }

    private static String m16360t(Context context) {
        Object obj = null;
        try {
            obj = C3996f.m16465g(context);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
        return TextUtils.isEmpty(obj) ? "http://m.data.mob.com/v2/cconf" : obj;
    }
}
