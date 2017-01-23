package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.p190a.C4073a.C4072a;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";
    public static final boolean SUPPORT_AUTO_UNIT = false;
    public static String f13606a;
    public static int f13607b;
    public static boolean f13608c;
    private static volatile GlobalClientInfo f13609d;
    private static Context f13610e;
    private String f13611f;
    private ILoginInfo f13612g;
    private IAppReceiver f13613h;
    private ActivityManager f13614i;
    private ConnectivityManager f13615j;
    private Map<String, Set<Integer>> f13616k;
    private C4072a f13617l;
    private Map<String, String> f13618m;
    private Map<String, AccsAbstractDataListener> f13619n;

    /* renamed from: com.taobao.accs.client.GlobalClientInfo.1 */
    class C40841 extends ConcurrentHashMap<String, String> {
        final /* synthetic */ GlobalClientInfo f13605a;

        C40841(GlobalClientInfo globalClientInfo) {
            this.f13605a = globalClientInfo;
            put(GlobalClientInfo.AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
            put("agooTokenReport", "org.android.agoo.accs.AgooService");
        }
    }

    static {
        f13607b = -1;
        f13608c = true;
    }

    private GlobalClientInfo(Context context) {
        this.f13618m = new C40841(this);
        this.f13619n = new ConcurrentHashMap();
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        if (f13610e == null) {
            f13610e = context.getApplicationContext();
        }
        C4089a.m16689a(new C4087c(this));
    }

    public static Context getContext() {
        return f13610e;
    }

    public static GlobalClientInfo getInstance(Context context) {
        if (f13609d == null) {
            synchronized (GlobalClientInfo.class) {
                if (f13609d == null) {
                    f13609d = new GlobalClientInfo(context);
                }
            }
        }
        return f13609d;
    }

    public void clearLoginInfoImpl() {
        this.f13612g = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f13614i == null) {
            this.f13614i = (ActivityManager) f13610e.getSystemService("activity");
        }
        return this.f13614i;
    }

    public IAppReceiver getAppReceiver() {
        return this.f13613h;
    }

    public String getAppSecret() {
        return this.f13611f;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.f13615j == null) {
            this.f13615j = (ConnectivityManager) f13610e.getSystemService("connectivity");
        }
        return this.f13615j;
    }

    public Map<String, Set<Integer>> getElectionBlackList() {
        return this.f13616k;
    }

    public C4072a getElectionResult() {
        return this.f13617l;
    }

    public AccsAbstractDataListener getListener(String str) {
        return (AccsAbstractDataListener) this.f13619n.get(str);
    }

    public String getNick() {
        return this.f13612g == null ? null : this.f13612g.getNick();
    }

    public String getService(String str) {
        return (String) this.f13618m.get(str);
    }

    public String getSid() {
        return this.f13612g == null ? null : this.f13612g.getSid();
    }

    public String getUserId() {
        return this.f13612g == null ? null : this.f13612g.getUserId();
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        if (!TextUtils.isEmpty(str) && accsAbstractDataListener != null) {
            this.f13619n.put(str, accsAbstractDataListener);
        }
    }

    public void registerService(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f13618m.put(str, str2);
        }
    }

    public void setAppReceiver(IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            this.f13613h = iAppReceiver;
            C4085a.m16662a(f13610e).m16666a(iAppReceiver);
        }
    }

    public void setAppSecret(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13611f = str;
            C4085a.m16662a(f13610e).m16667a(str);
        }
    }

    public void setElectionBlackList(Map<String, Set<Integer>> map) {
        this.f13616k = map;
    }

    public void setElectionReslt(C4072a c4072a) {
        this.f13617l = c4072a;
    }

    public void setLoginInfoImpl(ILoginInfo iLoginInfo) {
        if (iLoginInfo != null) {
            this.f13612g = iLoginInfo;
        }
    }

    public void unRegisterService(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13618m.remove(str);
        }
    }

    public void unregisterListener(String str) {
        this.f13619n.remove(str);
    }
}
