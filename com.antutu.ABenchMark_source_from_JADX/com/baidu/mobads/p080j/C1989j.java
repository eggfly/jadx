package com.baidu.mobads.p080j;

import android.util.Log;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p081a.C1907a;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.baidu.mobads.j.j */
public class C1989j implements IXAdLogger {
    private static volatile C1989j f6937a;

    static {
        f6937a = null;
    }

    public static C1989j m7430a() {
        if (f6937a == null) {
            synchronized (C1989j.class) {
                if (f6937a == null) {
                    f6937a = new C1989j();
                }
            }
        }
        return f6937a;
    }

    private String m7431a(Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object append : objArr) {
            stringBuilder.append(append).append(' ');
        }
        return stringBuilder.toString();
    }

    public int m7432d(String str) {
        return m7433d(IXAdLogger.TAG, str);
    }

    public int m7433d(String str, String str2) {
        int i = -1;
        if (isLoggable(3)) {
            try {
                i = Log.d(str, str2);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int m7434d(String str, Throwable th) {
        int i = -1;
        if (isLoggable(3)) {
            try {
                i = Log.d(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int m7435d(Throwable th) {
        return m7434d(BuildConfig.FLAVOR, th);
    }

    public int m7436d(Object... objArr) {
        return !isLoggable(3) ? -1 : m7432d(m7431a(objArr));
    }

    public int m7437e(String str) {
        int i = -1;
        if (isLoggable(6)) {
            try {
                i = Log.e(IXAdLogger.TAG, str);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int m7438e(String str, Throwable th) {
        int i = -1;
        if (isLoggable(6)) {
            try {
                i = Log.e(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int m7439e(Throwable th) {
        return m7438e(BuildConfig.FLAVOR, th);
    }

    public int m7440e(Object... objArr) {
        return !isLoggable(6) ? -1 : m7437e(m7431a(objArr));
    }

    public int m7441i(String str) {
        return m7442i(IXAdLogger.TAG, str);
    }

    public int m7442i(String str, String str2) {
        int i = -1;
        if (isLoggable(4)) {
            try {
                i = Log.i(str, str2);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int m7443i(String str, Throwable th) {
        int i = -1;
        if (isLoggable(4)) {
            try {
                i = Log.i(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int m7444i(Object... objArr) {
        return !isLoggable(4) ? -1 : m7441i(m7431a(objArr));
    }

    public boolean isLoggable(int i) {
        return isLoggable(IXAdLogger.TAG, i);
    }

    public boolean isLoggable(String str, int i) {
        return i >= C1907a.f6654b;
    }

    public int m7445w(String str) {
        int i = -1;
        if (isLoggable(5)) {
            try {
                i = Log.w(IXAdLogger.TAG, str);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int m7446w(String str, Throwable th) {
        int i = -1;
        if (isLoggable(5)) {
            try {
                i = Log.w(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int m7447w(Throwable th) {
        return m7446w(BuildConfig.FLAVOR, th);
    }

    public int m7448w(Object... objArr) {
        return !isLoggable(5) ? -1 : m7445w(m7431a(objArr));
    }
}
