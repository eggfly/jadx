package com.taobao.accs.antibrush;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import anetwork.channel.p020a.C0749a;
import com.taobao.accs.utl.ALog;
import java.util.StringTokenizer;

/* renamed from: com.taobao.accs.antibrush.b */
public class C4077b {
    public static final String KEY_SEC = "sec";
    public static final String TAG = "CookieMgr";
    public static CookieManager f13574a;
    private static volatile boolean f13575b;

    static {
        f13575b = false;
    }

    public static synchronized String m16628a(String str) {
        String str2 = null;
        synchronized (C4077b.class) {
            if (C4077b.m16630a()) {
                try {
                    str2 = C4077b.m16631b(f13574a.getCookie(str));
                } catch (Throwable th) {
                    ALog.m16902e(TAG, "get cookie failed. url=" + str, th, new Object[0]);
                }
            } else {
                ALog.m16903e(TAG, "cookieMgr not setup", new Object[0]);
            }
        }
        return str2;
    }

    public static synchronized void m16629a(Context context) {
        synchronized (C4077b.class) {
            if (!f13575b) {
                CookieSyncManager.createInstance(context);
                f13574a = CookieManager.getInstance();
                f13574a.setAcceptCookie(true);
                f13574a.removeExpiredCookie();
                f13575b = true;
            }
        }
    }

    private static boolean m16630a() {
        if (!(f13575b || C0749a.f2438b == null)) {
            C4077b.m16629a(C0749a.f2438b);
        }
        return f13575b;
    }

    public static String m16631b(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
            do {
                try {
                    String nextToken = stringTokenizer.nextToken();
                    int indexOf = nextToken.indexOf(61);
                    if (indexOf != -1) {
                        String trim = nextToken.substring(0, indexOf).trim();
                        nextToken = nextToken.substring(indexOf + 1).trim();
                        if (KEY_SEC.equals(trim)) {
                            str2 = C4077b.m16632c(nextToken);
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid cookie name-value pair");
                    }
                } catch (Throwable th) {
                    ALog.m16902e(TAG, "parse", th, new Object[0]);
                }
            } while (stringTokenizer.hasMoreTokens());
        }
        return str2;
    }

    private static String m16632c(String str) {
        return (str == null || str.length() <= 2 || str.charAt(0) != '\"' || str.charAt(str.length() - 1) != '\"') ? (str == null || str.length() <= 2 || str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') ? str : str.substring(1, str.length() - 1) : str.substring(1, str.length() - 1);
    }
}
