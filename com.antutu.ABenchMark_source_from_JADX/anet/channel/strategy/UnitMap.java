package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AccsSessionManager;
import anet.channel.strategy.C0731k.C0730c;
import anet.channel.util.ALog;
import anet.channel.util.LruCache;
import java.io.Serializable;
import java.util.Map;

class UnitMap implements Serializable {
    private Map<String, String> f2338a;

    UnitMap() {
        m2906a();
    }

    private String m2904b(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : !TextUtils.isEmpty(str2) ? str2 : null;
    }

    String m2905a(String str, String str2) {
        String b = m2904b(str, str2);
        if (b == null) {
            return null;
        }
        synchronized (this.f2338a) {
            b = (String) this.f2338a.get(b);
        }
        return b;
    }

    void m2906a() {
        if (this.f2338a == null) {
            this.f2338a = new LruCache(6);
        }
    }

    void m2907a(C0730c c0730c) {
        int i = 0;
        Object obj = c0730c.f2407b;
        if (!(TextUtils.isEmpty(obj) || obj.equalsIgnoreCase("center"))) {
            i = 1;
        }
        String b = m2904b(c0730c.f2409d, c0730c.f2410e);
        if (i == 0) {
            synchronized (this.f2338a) {
                this.f2338a.remove(b);
            }
        } else if (b != null) {
            synchronized (this.f2338a) {
                this.f2338a.put(b, obj);
            }
        }
        if (ALog.isPrintLog(1)) {
            synchronized (this.f2338a) {
                ALog.m2960d("awcn.UnitMap", "UnitMap : " + toString(), null, new Object[0]);
            }
        }
        AccsSessionManager.getInstance().checkAndStartAccsSession();
    }

    void m2908a(String str, String str2, String str3) {
        String b = m2904b(str, str2);
        if (b != null) {
            if (ALog.isPrintLog(1)) {
                ALog.m2960d("awcn.UnitMap", "set unit prefix", null, "key", b, "unitPrefix", str3);
            }
            if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("center")) {
                synchronized (this.f2338a) {
                    this.f2338a.remove(b);
                }
                return;
            }
            synchronized (this.f2338a) {
                this.f2338a.put(b, str3);
            }
            AccsSessionManager.getInstance().checkAndStartAccsSession();
        }
    }

    public String toString() {
        String str;
        synchronized (this.f2338a) {
            str = "UnitMap: " + this.f2338a.toString();
        }
        return str;
    }
}
