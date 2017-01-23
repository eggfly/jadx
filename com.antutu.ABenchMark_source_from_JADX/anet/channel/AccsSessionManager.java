package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ConnType.TypeLevel;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import com.taobao.accs.internal.C4103b;
import java.util.Arrays;

public class AccsSessionManager {
    private static final String TAG = "awcn.AccsSessionManager";
    public volatile Callback cb;
    public SessionCenter sessionCenter;
    public String[] sessionKeyArray;

    public interface Callback {
        int getSessionCount();

        String getSessionKey(int i);
    }

    /* renamed from: anet.channel.AccsSessionManager.a */
    static class C0637a {
        static AccsSessionManager f2153a;

        static {
            f2153a = new AccsSessionManager();
        }

        C0637a() {
        }
    }

    private AccsSessionManager() {
        this.sessionCenter = SessionCenter.getInstance();
        this.cb = null;
        this.sessionKeyArray = new String[0];
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            this.cb = new C0647a(this);
        }
    }

    private void closeSessions(String str) {
        if (!TextUtils.isEmpty(str)) {
            ALog.m2960d(TAG, "closeSessions!!!!!!", null, C4103b.ELECTION_KEY_HOST, str);
            SessionRequest.m2736a(str).m2750a(false);
        }
    }

    public static AccsSessionManager getInstance() {
        return C0637a.f2153a;
    }

    private boolean isNeedCheckSession() {
        if (GlobalAppRuntimeInfo.isAppBackground()) {
            ALog.m2960d(TAG, "app is background not need check accs session, return", null, "bg", Boolean.valueOf(true));
            return false;
        } else if (NetworkStatusHelper.m2846e()) {
            return true;
        } else {
            ALog.m2960d(TAG, "network is not available, not need check accs session, return", null, "network", Boolean.valueOf(NetworkStatusHelper.m2846e()));
            return false;
        }
    }

    public synchronized void checkAndStartAccsSession() {
        if (this.cb == null) {
            ALog.m2963i(TAG, "call back is null", null, new Object[0]);
        } else {
            int sessionCount = this.cb.getSessionCount();
            if (this.sessionKeyArray.length != sessionCount) {
                this.sessionKeyArray = (String[]) Arrays.copyOf(this.sessionKeyArray, sessionCount);
            }
            boolean isNeedCheckSession = isNeedCheckSession();
            for (sessionCount = 0; sessionCount < this.sessionKeyArray.length; sessionCount++) {
                String str = this.sessionKeyArray[sessionCount];
                Object sessionKey = this.cb.getSessionKey(sessionCount);
                if ((sessionKey == null && str != null) || !(sessionKey == null || sessionKey.equalsIgnoreCase(str))) {
                    closeSessions(str);
                    this.sessionKeyArray[sessionCount] = sessionKey;
                }
                if (isNeedCheckSession) {
                    try {
                        if (!TextUtils.isEmpty(sessionKey)) {
                            this.sessionCenter.getInternal(sessionKey, TypeLevel.SPDY, 0);
                        }
                    } catch (Exception e) {
                        ALog.m2962e("start unit session failed", null, C4103b.ELECTION_KEY_HOST, sessionKey);
                    }
                }
            }
        }
    }

    public synchronized void forceCloseSession(boolean z) {
        int i = 0;
        synchronized (this) {
            if (ALog.isPrintLog(1)) {
                ALog.m2960d(TAG, "forceCloseSession", null, "reCreate", Boolean.valueOf(z));
            }
            while (i < this.sessionKeyArray.length) {
                closeSessions(this.sessionKeyArray[i]);
                this.sessionKeyArray[i] = null;
                i++;
            }
            if (z) {
                checkAndStartAccsSession();
            }
        }
    }

    public synchronized void forceReCreateSession() {
        forceCloseSession(true);
    }

    public void setCallback(Callback callback) {
        this.cb = callback;
    }
}
