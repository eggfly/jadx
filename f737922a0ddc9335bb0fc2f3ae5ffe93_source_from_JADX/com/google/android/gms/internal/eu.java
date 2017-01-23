package com.google.android.gms.internal;

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
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@eh
@TargetApi(8)
public class eu {

    @TargetApi(9)
    public static class a extends eu {
        public a() {
            super();
        }

        public int DW() {
            return 7;
        }

        public int j6() {
            return 6;
        }

        public boolean j6(Request request) {
            request.setShowRunningNotification(true);
            return true;
        }
    }

    @TargetApi(11)
    public static class b extends a {

        class 1 implements Callable<Boolean> {
            final /* synthetic */ WebSettings DW;
            final /* synthetic */ b FH;
            final /* synthetic */ Context j6;

            1(b bVar, Context context, WebSettings webSettings) {
                this.FH = bVar;
                this.j6 = context;
                this.DW = webSettings;
            }

            public /* synthetic */ Object call() {
                return j6();
            }

            public Boolean j6() {
                if (this.j6.getCacheDir() != null) {
                    this.DW.setAppCachePath(this.j6.getCacheDir().getAbsolutePath());
                    this.DW.setAppCacheMaxSize(0);
                    this.DW.setAppCacheEnabled(true);
                }
                this.DW.setDatabasePath(this.j6.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                this.DW.setDatabaseEnabled(true);
                this.DW.setDomStorageEnabled(true);
                this.DW.setDisplayZoomControls(false);
                this.DW.setBuiltInZoomControls(true);
                this.DW.setSupportZoom(true);
                this.DW.setAllowContentAccess(false);
                return Boolean.valueOf(true);
            }
        }

        public boolean DW(View view) {
            view.setLayerType(1, null);
            return true;
        }

        public WebChromeClient FH(fj fjVar) {
            return new fp(fjVar);
        }

        public fk j6(fj fjVar, boolean z) {
            return new fq(fjVar, z);
        }

        public Set<String> j6(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public boolean j6(Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean j6(Context context, WebSettings webSettings) {
            super.j6(context, webSettings);
            return ((Boolean) ey.j6(new 1(this, context, webSettings))).booleanValue();
        }

        public boolean j6(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public boolean j6(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }
    }

    @TargetApi(14)
    public static class c extends b {
        public WebChromeClient FH(fj fjVar) {
            return new fr(fjVar);
        }

        public String j6(SslError sslError) {
            return sslError.getUrl();
        }
    }

    @TargetApi(16)
    public static class f extends c {
        public void j6(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                j6(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
            }
        }

        public void j6(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public boolean j6(Context context, WebSettings webSettings) {
            super.j6(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }
    }

    @TargetApi(17)
    public static class d extends f {
        public Drawable j6(Context context, Bitmap bitmap, boolean z, float f) {
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

        public String j6(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        public boolean j6(Context context, WebSettings webSettings) {
            super.j6(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    @TargetApi(18)
    public static class e extends d {
        public int FH() {
            return 14;
        }
    }

    @TargetApi(19)
    public static class g extends e {
    }

    @TargetApi(21)
    public static class h extends g {
    }

    private eu() {
    }

    public static eu j6(int i) {
        return i >= 21 ? new h() : i >= 19 ? new g() : i >= 18 ? new e() : i >= 17 ? new d() : i >= 16 ? new f() : i >= 14 ? new c() : i >= 11 ? new b() : i >= 9 ? new a() : new eu();
    }

    public int DW() {
        return 1;
    }

    public boolean DW(View view) {
        return false;
    }

    public boolean DW(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        fjVar.onResume();
        return true;
    }

    public int FH() {
        return 5;
    }

    public WebChromeClient FH(fj fjVar) {
        return null;
    }

    public int j6() {
        return 0;
    }

    public Drawable j6(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public fk j6(fj fjVar, boolean z) {
        return new fk(fjVar, z);
    }

    public String j6(Context context) {
        return "";
    }

    public String j6(SslError sslError) {
        return "";
    }

    public Set<String> j6(Uri uri) {
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

    public void j6(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            j6(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public void j6(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean j6(Request request) {
        return false;
    }

    public boolean j6(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean j6(View view) {
        return false;
    }

    public boolean j6(Window window) {
        return false;
    }

    public boolean j6(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        fjVar.onPause();
        return true;
    }
}
