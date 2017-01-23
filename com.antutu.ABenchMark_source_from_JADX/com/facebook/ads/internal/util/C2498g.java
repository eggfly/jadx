package com.facebook.ads.internal.util;

import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.C2409e;
import com.facebook.ads.internal.C2472h;
import com.facebook.ads.internal.p127e.p128a.C2360a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.android.spdy.SpdyProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.util.g */
public class C2498g {
    private static final Uri f8584a;
    private static final String f8585b;
    private static boolean f8586c;

    /* renamed from: com.facebook.ads.internal.util.g.1 */
    static class C24951 implements X509TrustManager {
        C24951() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    /* renamed from: com.facebook.ads.internal.util.g.2 */
    static /* synthetic */ class C24962 {
        static final /* synthetic */ int[] f8580a;

        static {
            f8580a = new int[AdSize.values().length];
            try {
                f8580a[AdSize.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8580a[AdSize.RECTANGLE_HEIGHT_250.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8580a[AdSize.BANNER_HEIGHT_90.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8580a[AdSize.BANNER_HEIGHT_50.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.util.g.a */
    public static class C2497a {
        public String f8581a;
        public String f8582b;
        public boolean f8583c;

        public C2497a(String str, String str2, boolean z) {
            this.f8581a = str;
            this.f8582b = str2;
            this.f8583c = z;
        }
    }

    static {
        f8584a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        f8585b = C2498g.class.getSimpleName();
        f8586c = false;
    }

    public static C2409e m9468a(AdSize adSize) {
        switch (C24962.f8580a[adSize.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return C2409e.WEBVIEW_INTERSTITIAL_UNKNOWN;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return C2409e.WEBVIEW_BANNER_250;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return C2409e.WEBVIEW_BANNER_90;
            case SpdyProtocol.QUIC /*4*/:
                return C2409e.WEBVIEW_BANNER_50;
            default:
                return C2409e.WEBVIEW_BANNER_LEGACY;
        }
    }

    public static C2497a m9469a(ContentResolver contentResolver) {
        C2497a c2497a;
        Throwable th;
        Cursor query;
        try {
            ContentResolver contentResolver2 = contentResolver;
            query = contentResolver2.query(f8584a, new String[]{"aid", "androidid", "limit_tracking"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c2497a = new C2497a(query.getString(query.getColumnIndex("aid")), query.getString(query.getColumnIndex("androidid")), Boolean.valueOf(query.getString(query.getColumnIndex("limit_tracking"))).booleanValue());
                        if (query != null) {
                            query.close();
                        }
                        return c2497a;
                    }
                } catch (Exception e) {
                    try {
                        c2497a = new C2497a(null, null, false);
                        if (query != null) {
                            query.close();
                        }
                        return c2497a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            c2497a = new C2497a(null, null, false);
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            query = null;
            c2497a = new C2497a(null, null, false);
            if (query != null) {
                query.close();
            }
            return c2497a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return c2497a;
    }

    public static Object m9470a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String m9471a(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                stringWriter.write(cArr, 0, read);
            } else {
                String stringWriter2 = stringWriter.toString();
                stringWriter.close();
                inputStreamReader.close();
                return stringWriter2;
            }
        }
    }

    public static String m9472a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static String m9473a(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            String a = C2498g.m9471a(gZIPInputStream);
            gZIPInputStream.close();
            byteArrayInputStream.close();
            return a;
        } catch (Throwable e) {
            C2490c.m9456a(C2489b.m9453a(e, "Error decompressing data"));
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static Method m9474a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method m9475a(String str, String str2, Class<?>... clsArr) {
        try {
            return C2498g.m9474a(Class.forName(str), str2, (Class[]) clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static void m9476a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.addFlags(268435456);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        intent.putExtra("create_new_tab", false);
        context.startActivity(intent);
    }

    public static void m9477a(Context context, String str) {
        if (AdSettings.isTestMode(context)) {
            Log.d("FBAudienceNetworkLog", str + " (displayed for test ads only)");
        }
    }

    public static void m9478a(DisplayMetrics displayMetrics, View view, AdSize adSize) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= adSize.getWidth() ? displayMetrics.widthPixels : (int) Math.ceil((double) (((float) adSize.getWidth()) * displayMetrics.density)), (int) Math.ceil((double) (((float) adSize.getHeight()) * displayMetrics.density)));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }

    public static void m9479a(View view, boolean z, String str) {
    }

    public static boolean m9480a() {
        String urlPrefix = AdSettings.getUrlPrefix();
        return !C2510r.m9516a(urlPrefix) && urlPrefix.endsWith(".sb");
    }

    public static boolean m9481a(Context context) {
        try {
            return !((PowerManager) context.getSystemService("power")).isScreenOn() ? false : !((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m9482a(Context context, View view, int i) {
        if (view == null) {
            C2498g.m9479a(view, false, "adView is null.");
            return false;
        } else if (view.getParent() == null) {
            C2498g.m9479a(view, false, "adView has no parent.");
            return false;
        } else if (view.getWindowVisibility() != 0) {
            C2498g.m9479a(view, false, "adView window is not set to VISIBLE.");
            return false;
        } else if (view.getVisibility() != 0) {
            C2498g.m9479a(view, false, "adView is not set to VISIBLE.");
            return false;
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            C2498g.m9479a(view, false, "adView has invisible dimensions (w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight());
            return false;
        } else if (VERSION.SDK_INT < 11 || view.getAlpha() >= 0.9f) {
            if (C2472h.m9399a(context)) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                if (C2498g.m9483a(rect, view)) {
                    C2498g.m9479a(view, false, "adView is obscured by another view.");
                    return false;
                }
            }
            int width = view.getWidth();
            int height = view.getHeight();
            int[] iArr = new int[2];
            try {
                view.getLocationOnScreen(iArr);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (iArr[0] < 0 || displayMetrics.widthPixels - iArr[0] < width) {
                    C2498g.m9479a(view, false, "adView is not fully on screen horizontally.");
                    return false;
                }
                width = (int) ((((double) height) * (100.0d - ((double) i))) / 100.0d);
                if (iArr[1] < 0 && Math.abs(iArr[1]) > width) {
                    C2498g.m9479a(view, false, "adView is not visible from the top.");
                    return false;
                } else if ((height + iArr[1]) - displayMetrics.heightPixels > width) {
                    C2498g.m9479a(view, false, "adView is not visible from the bottom.");
                    return false;
                } else {
                    C2498g.m9479a(view, true, "adView is visible.");
                    return C2498g.m9481a(context);
                }
            } catch (NullPointerException e) {
                C2498g.m9479a(view, false, "Cannot get location on screen.");
                return false;
            }
        } else {
            C2498g.m9479a(view, false, "adView is too transparent.");
            return false;
        }
    }

    private static boolean m9483a(Rect rect, View view) {
        if (!(view.getParent() instanceof ViewGroup)) {
            return false;
        }
        View view2 = (ViewGroup) view.getParent();
        for (int indexOfChild = view2.indexOfChild(view) + 1; indexOfChild < view2.getChildCount(); indexOfChild++) {
            if (C2498g.m9486b(rect, view2.getChildAt(indexOfChild))) {
                return true;
            }
        }
        return C2498g.m9483a(rect, view2);
    }

    public static byte[] m9484a(String str) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Throwable e) {
            C2490c.m9456a(C2489b.m9453a(e, "Error compressing data"));
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static void m9485b() {
        if (f8586c) {
            Log.d(f8585b, "Sandbox SSL validation already disabled, ignoring...");
            return;
        }
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new C24951()};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            Log.d(f8585b, "Sandbox SSL validation disabled.");
        } catch (Exception e) {
            Log.e(f8585b, "Failed to disable sandbox SSL validation: " + e);
        }
    }

    private static boolean m9486b(Rect rect, View view) {
        if (!view.isShown()) {
            return false;
        }
        if (VERSION.SDK_INT >= 11 && view.getAlpha() <= 0.0f) {
            return false;
        }
        if (C2498g.m9488c(rect, view)) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (C2498g.m9486b(rect, viewGroup.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static C2360a m9487c() {
        C2360a c2360a = new C2360a();
        c2360a.m9108c(30000);
        c2360a.m9107b(3);
        if (C2498g.m9480a()) {
            C2498g.m9485b();
        }
        return c2360a;
    }

    private static boolean m9488c(Rect rect, View view) {
        if (view instanceof ViewGroup) {
            if (view.getBackground() == null) {
                return false;
            }
            if (VERSION.SDK_INT >= 19 && view.getBackground().getAlpha() <= 0) {
                return false;
            }
        }
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        return rect.left < rect2.right && rect.right > rect2.left && rect.top < rect2.bottom && rect.bottom > rect2.top;
    }
}
