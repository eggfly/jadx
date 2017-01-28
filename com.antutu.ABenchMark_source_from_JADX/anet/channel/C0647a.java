package anet.channel;

import android.text.TextUtils;
import anet.channel.AccsSessionManager.Callback;
import anet.channel.strategy.C0734n;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.HttpConstant;

/* renamed from: anet.channel.a */
class C0647a implements Callback {
    final /* synthetic */ AccsSessionManager f2180a;

    C0647a(AccsSessionManager accsSessionManager) {
        this.f2180a = accsSessionManager;
    }

    public int getSessionCount() {
        return 2;
    }

    public String getSessionKey(int i) {
        if (i >= getSessionCount()) {
            throw new IllegalArgumentException("index exceeds count!");
        }
        String a;
        if (i == 0) {
            a = C0734n.m2950a();
        } else {
            if (i == 1) {
                Object unitPrefix = StrategyCenter.getInstance().getUnitPrefix(GlobalAppRuntimeInfo.getUserId(), GlobalAppRuntimeInfo.getUtdid());
                if (!TextUtils.isEmpty(unitPrefix)) {
                    a = C0734n.m2953b(unitPrefix);
                }
            }
            a = null;
        }
        if (a == null) {
            return null;
        }
        String schemeByHost = StrategyCenter.getInstance().getSchemeByHost(a);
        if (TextUtils.isEmpty(schemeByHost)) {
            schemeByHost = HttpConstant.HTTPS;
        }
        return C0734n.m2951a(schemeByHost, a);
    }
}
