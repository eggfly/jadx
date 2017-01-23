package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@gb
@TargetApi(8)
/* renamed from: com.google.android.gms.b.hk */
public class hk {

    @TargetApi(9)
    /* renamed from: com.google.android.gms.b.hk.a */
    public static class C3254a extends hk {
        public C3254a() {
            super();
        }

        public int m13096a() {
            return 6;
        }

        public boolean m13097a(Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        public int m13098b() {
            return 7;
        }
    }

    @TargetApi(11)
    /* renamed from: com.google.android.gms.b.hk.b */
    public static class C3256b extends C3254a {

        /* renamed from: com.google.android.gms.b.hk.b.1 */
        class C32551 implements Callable<File> {
            final /* synthetic */ Context f11302a;
            final /* synthetic */ C3256b f11303b;

            C32551(C3256b c3256b, Context context) {
                this.f11303b = c3256b;
                this.f11302a = context;
            }

            public File m13099a() {
                return this.f11302a.getCacheDir();
            }

            public /* synthetic */ Object call() {
                return m13099a();
            }
        }

        public ij m13100a(ii iiVar, boolean z) {
            return new ip(iiVar, z);
        }

        public Set<String> m13101a(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public boolean m13102a(Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean m13103a(Context context, WebSettings webSettings) {
            super.m13085a(context, webSettings);
            if (((File) hu.m13160a(new C32551(this, context))) != null) {
                webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                webSettings.setAppCacheMaxSize(0);
                webSettings.setAppCacheEnabled(true);
            }
            webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            webSettings.setAllowContentAccess(false);
            return true;
        }

        public boolean m13104a(Window window) {
            window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
            return true;
        }

        public boolean m13105b(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public WebChromeClient m13106c(ii iiVar) {
            return new io(iiVar);
        }

        public boolean m13107c(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    @TargetApi(14)
    /* renamed from: com.google.android.gms.b.hk.c */
    public static class C3257c extends C3256b {
        public String m13108a(SslError sslError) {
            return sslError.getUrl();
        }

        public WebChromeClient m13109c(ii iiVar) {
            return new iq(iiVar);
        }
    }

    @TargetApi(16)
    /* renamed from: com.google.android.gms.b.hk.f */
    public static class C3258f extends C3257c {
        public void m13110a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                m13112a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
            }
        }

        public void m13111a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void m13112a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public boolean m13113a(Context context, WebSettings webSettings) {
            super.m13103a(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }
    }

    @TargetApi(17)
    /* renamed from: com.google.android.gms.b.hk.d */
    public static class C3259d extends C3258f {
        public Drawable m13114a(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException e) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        public String m13115a(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        public boolean m13116a(Context context, WebSettings webSettings) {
            super.m13113a(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    @TargetApi(18)
    /* renamed from: com.google.android.gms.b.hk.e */
    public static class C3260e extends C3259d {
        public boolean m13117a(View view) {
            return super.m13086a(view) || view.getWindowId() != null;
        }

        public int m13118c() {
            return 14;
        }
    }

    @TargetApi(19)
    /* renamed from: com.google.android.gms.b.hk.g */
    public static class C3261g extends C3260e {
        public boolean m13119a(View view) {
            return view.isAttachedToWindow();
        }

        public LayoutParams m13120d() {
            return new LayoutParams(-1, -1);
        }
    }

    private hk() {
    }

    public static hk m13074a(int i) {
        return i >= 19 ? new C3261g() : i >= 18 ? new C3260e() : i >= 17 ? new C3259d() : i >= 16 ? new C3258f() : i >= 14 ? new C3257c() : i >= 11 ? new C3256b() : i >= 9 ? new C3254a() : new hk();
    }

    public int m13075a() {
        return 0;
    }

    public Drawable m13076a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public ij m13077a(ii iiVar, boolean z) {
        return new ij(iiVar, z);
    }

    public String m13078a(Context context) {
        return BuildConfig.FLAVOR;
    }

    public String m13079a(SslError sslError) {
        return BuildConfig.FLAVOR;
    }

    public Set<String> m13080a(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void m13081a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            m13083a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public void m13082a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void m13083a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean m13084a(Request request) {
        return false;
    }

    public boolean m13085a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean m13086a(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean m13087a(Window window) {
        return false;
    }

    public boolean m13088a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        iiVar.m13220B();
        return true;
    }

    public int m13089b() {
        return 1;
    }

    public boolean m13090b(View view) {
        return false;
    }

    public boolean m13091b(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        iiVar.m13221C();
        return true;
    }

    public int m13092c() {
        return 5;
    }

    public WebChromeClient m13093c(ii iiVar) {
        return null;
    }

    public boolean m13094c(View view) {
        return false;
    }

    public LayoutParams m13095d() {
        return new LayoutParams(-2, -2);
    }
}
