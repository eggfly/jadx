package com.baidu.mobads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.baidu.mobads.p080j.C1989j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: com.baidu.mobads.z */
public class C2083z extends ac {
    public String f7328a;

    /* renamed from: com.baidu.mobads.z.a */
    static class C2082a {
        private static String[] f7320a;
        private static String[] f7321b;
        private static String[] f7322c;
        private static String[] f7323d;
        private static final String[] f7324e;
        private static final String[] f7325f;
        private static String[] f7326g;
        private static String[] f7327h;

        static {
            f7320a = "apk,zip,rar,7z,tar.gz,bz".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            f7321b = "mp4,3gp,3g2,avi,rm,rmvb,wmv,flv,mkv,mov,asf,asx".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            f7322c = "mp3,ra,wma,m4a,wav,aac,mmf,amr,ogg,adp".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            f7323d = "sms,smsto,mms".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            f7324e = new String[]{"tel"};
            f7325f = new String[]{"mailto"};
            f7326g = "http,https".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            f7327h = "http,https,sms,smsto,mms,tel,fax,ftp,mailto,gopher,news,telnet,file".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }

    @TargetApi(3)
    public C2083z(Context context, boolean z, boolean z2) {
        super(context);
        this.f7328a = BuildConfig.FLAVOR;
        setClickable(true);
        if (z) {
            setBackgroundColor(0);
        }
        if (z2) {
            setFocusable(true);
        } else {
            setFocusable(false);
        }
        setScrollBarStyle(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        try {
            WebSettings.class.getMethod("setDatabasePath", new Class[]{String.class}).invoke(settings, new Object[]{path});
            WebSettings.class.getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
            WebSettings.class.getMethod("setDatabaseEnabled", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
        } catch (Exception e) {
        }
        try {
            WebSettings.class.getMethod("setAppCacheEnabled", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
            WebSettings.class.getMethod("setAppCachePath", new Class[]{String.class}).invoke(settings, new Object[]{path});
            WebSettings.class.getMethod("setAppCacheMaxSize", new Class[]{Long.TYPE}).invoke(settings, new Object[]{Long.valueOf(5242880)});
        } catch (Exception e2) {
        }
        try {
            WebSettings.class.getMethod("setGeolocationEnabled", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
            WebSettings.class.getMethod("setGeolocationDatabasePath", new Class[]{String.class}).invoke(settings, new Object[]{path});
        } catch (Exception e3) {
        }
        setWebViewClient(new aa());
        setWebChromeClient(new WebChromeClient());
        try {
            if (Integer.parseInt(VERSION.SDK) >= 14) {
                Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this, new Object[]{Integer.valueOf(1), null});
            }
        } catch (Throwable e4) {
            C1989j.m7430a().m7439e(e4);
        }
    }

    public static boolean m7777a(String str) {
        return !C2083z.m7781c(str) || C2083z.m7785g(str) || C2083z.m7786h(str) || C2083z.m7787i(str);
    }

    private static boolean m7778a(String[] strArr, String str) {
        if (str == null) {
            return false;
        }
        boolean z;
        Uri parse = Uri.parse(str);
        String toLowerCase = parse.getPath() == null ? BuildConfig.FLAVOR : parse.getPath().toLowerCase(Locale.getDefault());
        for (String str2 : strArr) {
            if (toLowerCase.trim().endsWith("." + str2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public static boolean m7779b(String str) {
        return C2083z.m7782d(str) || C2083z.m7783e(str) || C2083z.m7784f(str) || (C2083z.m7788j(str) && (!C2083z.m7781c(str) || C2083z.m7785g(str) || C2083z.m7786h(str) || C2083z.m7787i(str)));
    }

    private static boolean m7780b(String[] strArr, String str) {
        if (str == null) {
            return false;
        }
        String toLowerCase = str.toLowerCase(Locale.getDefault());
        for (String str2 : strArr) {
            if (toLowerCase.trim().startsWith(str2 + ":")) {
                return true;
            }
        }
        return false;
    }

    public static boolean m7781c(String str) {
        return C2083z.m7780b(C2082a.f7326g, str);
    }

    public static boolean m7782d(String str) {
        return C2083z.m7780b(C2082a.f7323d, str);
    }

    public static boolean m7783e(String str) {
        return C2083z.m7780b(C2082a.f7324e, str);
    }

    public static boolean m7784f(String str) {
        return C2083z.m7780b(C2082a.f7325f, str);
    }

    public static boolean m7785g(String str) {
        return C2083z.m7778a(C2082a.f7320a, str);
    }

    public static boolean m7786h(String str) {
        return C2083z.m7778a(C2082a.f7321b, str);
    }

    public static boolean m7787i(String str) {
        return C2083z.m7778a(C2082a.f7322c, str);
    }

    private static boolean m7788j(String str) {
        return C2083z.m7780b(C2082a.f7327h, str);
    }
}
