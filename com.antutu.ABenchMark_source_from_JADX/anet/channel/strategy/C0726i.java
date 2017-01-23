package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.C0667d;
import anet.channel.entity.EventType;
import anet.channel.p018b.C0653b;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0731k.C0730c;
import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.taobao.accs.internal.C4103b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: anet.channel.strategy.i */
class C0726i implements IStrategyInstance, IDispatchEventListener {
    protected StrategyInfoHolder f2375a;
    private boolean f2376b;
    private long f2377c;

    C0726i() {
        this.f2376b = false;
        this.f2375a = null;
        this.f2377c = 0;
    }

    private String m2936a(String str, String str2) {
        if (m2937a()) {
            return str2;
        }
        String str3 = (String) this.f2375a.f2327f.get(str);
        if (TextUtils.isEmpty(str3)) {
            str3 = str;
        }
        String a = this.f2375a.f2324c.m2874a(str3);
        if (a == null) {
            a = this.f2375a.m2894c().querySchemeByHost(str3);
            if (a != null) {
                this.f2375a.f2324c.m2877a(str3, a);
            } else {
                this.f2375a.m2894c().m2902a(str3);
            }
        }
        if (a != null && !SafeAislesMap.NO_RESULT.equals(a)) {
            str3 = a;
        } else if (str2 == null) {
            str3 = (String) C0653b.m2767a().m2769a(2, str3);
        } else {
            str3 = str2;
        }
        return str3;
    }

    private boolean m2937a() {
        if (this.f2375a != null) {
            return false;
        }
        ALog.m2965w("StrategyCenter not initialized", null, "isInitialized", Boolean.valueOf(this.f2376b));
        return true;
    }

    public void forceRefreshStrategy(String str) {
        if (!m2937a() && !TextUtils.isEmpty(str)) {
            this.f2375a.m2894c().m2902a(str);
        }
    }

    public String getCNameByHost(String str) {
        if (m2937a() || TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = (String) this.f2375a.f2327f.get(str);
        return TextUtils.isEmpty(str2) ? null : str2;
    }

    public String getClientIp() {
        return m2937a() ? BuildConfig.FLAVOR : this.f2375a.m2894c().f2333b;
    }

    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        if (TextUtils.isEmpty(str) || m2937a()) {
            return Collections.EMPTY_LIST;
        }
        String str2 = (String) this.f2375a.f2327f.get(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        List<IConnStrategy> queryByHost = this.f2375a.m2894c().queryByHost(str2);
        if (queryByHost.isEmpty()) {
            queryByHost = this.f2375a.f2326e.m2912a(str2);
        }
        if (!ALog.isPrintLog(1)) {
            return queryByHost;
        }
        ALog.m2960d("getConnStrategyListByHost", null, C4103b.ELECTION_KEY_HOST, str2, "result", queryByHost);
        return queryByHost;
    }

    public String getFormalizeUrl(String str) {
        return getFormalizeUrl(str, HttpConstant.HTTP);
    }

    @Deprecated
    public String getFormalizeUrl(String str, String str2) {
        Throwable e;
        String[] parseURL = StringUtils.parseURL(str);
        if (parseURL == null) {
            ALog.m2962e("awcn.StrategyCenter", "url is invalid.", null, "URL", str, "stack", Utils.getStackMsg(new Exception("getFormalizeUrl")));
            return null;
        }
        String buildString;
        try {
            String str3 = parseURL[1];
            if (!str.startsWith("//")) {
                str2 = parseURL[0];
            }
            if (m2936a(str3, str2) == null) {
                return str;
            }
            buildString = StringUtils.buildString(m2936a(str3, str2), ":", str.substring(str.indexOf("//")));
            try {
                if (ALog.isPrintLog(1)) {
                    ALog.m2960d("awcn.StrategyCenter", BuildConfig.FLAVOR, null, "raw", str, KEYS.RET, buildString);
                }
            } catch (Exception e2) {
                e = e2;
                ALog.m2961e("awcn.StrategyCenter", "getFormalizeUrl failed", null, e, "raw", str);
                return buildString;
            }
            return buildString;
        } catch (Throwable e3) {
            e = e3;
            buildString = str;
            ALog.m2961e("awcn.StrategyCenter", "getFormalizeUrl failed", null, e, "raw", str);
            return buildString;
        }
    }

    public Map<String, IHRStrategy> getHRStrategyMap() {
        return m2937a() ? Collections.EMPTY_MAP : this.f2375a.f2325d.m2863a(this.f2375a.m2894c());
    }

    public String getSchemeByHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ALog.m2960d("awcn.StrategyCenter", "getSchemeByHost", null, C4103b.ELECTION_KEY_HOST, str, "scheme", m2936a(str, null));
        return m2936a(str, null);
    }

    public String getUnitPrefix(String str, String str2) {
        return m2937a() ? null : this.f2375a.f2323b.m2905a(str, str2);
    }

    public synchronized void initialize() {
        if (!this.f2376b) {
            try {
                ALog.m2963i("awcn.StrategyCenter", "StrategyCenter initialize started.", null, new Object[0]);
                C0732l.m2942a();
                HttpDispatcher.getInstance().addListener(this);
                NetworkStatusHelper.m2840a(GlobalAppRuntimeInfo.getContext());
                this.f2375a = StrategyInfoHolder.m2881a();
                this.f2376b = true;
                ALog.m2963i("awcn.StrategyCenter", "StrategyCenter initialize finished.", null, new Object[0]);
            } catch (Throwable e) {
                ALog.m2961e("awcn.StrategyCenter", "StrategyCenter initialize failed.", null, e, new Object[0]);
            }
        }
    }

    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d) {
        if (!m2937a()) {
            this.f2375a.m2894c().notifyConnEvent(str, iConnStrategy, eventType, c0667d);
        }
    }

    public void onEvent(DispatchEvent dispatchEvent) {
        if (dispatchEvent.eventType == 1 && this.f2375a != null) {
            ALog.m2960d("awcn.StrategyCenter", "receive DNS event", null, new Object[0]);
            C0730c a = C0731k.m2940a((JSONObject) dispatchEvent.extraObject);
            if (a != null) {
                this.f2375a.m2892a(a);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f2377c > 180000) {
                    saveData();
                    this.f2377c = currentTimeMillis;
                }
            }
        }
    }

    public synchronized void saveData() {
        new C0727j(this).execute(new Void[0]);
    }

    public void setUnitPrefix(String str, String str2, String str3) {
        if (!m2937a()) {
            this.f2375a.f2323b.m2908a(str, str2, str3);
        }
    }

    public synchronized void switchEnv() {
        if (this.f2376b) {
            C0732l.m2946b();
            HttpDispatcher.getInstance().switchENV();
            this.f2375a = StrategyInfoHolder.m2881a();
        } else {
            ALog.m2965w("awcn.StrategyCenter", "call switch Env before StrategyCenter not initialized!", null, new Object[0]);
        }
    }
}
