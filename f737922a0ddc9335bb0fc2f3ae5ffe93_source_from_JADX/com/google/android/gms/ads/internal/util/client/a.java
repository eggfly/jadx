package com.google.android.gms.ads.internal.util.client;

import agb;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.eh;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@eh
public class a {
    private static final String DW;
    private static final String FH;
    private static final String Hw;
    private static final String VH;
    private static final String Zo;
    public static final Handler j6;
    private static final String v5;

    public interface a {
        void j6(String str);
    }

    class 1 implements a {
        final /* synthetic */ a j6;

        class 1 extends Thread {
            final /* synthetic */ 1 DW;
            final /* synthetic */ String j6;

            1(1 1, String str) {
                this.DW = 1;
                this.j6 = str;
            }

            public void run() {
                new c().j6(this.j6);
            }
        }

        1(a aVar) {
            this.j6 = aVar;
        }

        public void j6(String str) {
            new 1(this, str).start();
        }
    }

    static {
        j6 = new Handler(Looper.getMainLooper());
        DW = AdView.class.getName();
        FH = InterstitialAd.class.getName();
        Hw = PublisherAdView.class.getName();
        v5 = PublisherInterstitialAd.class.getName();
        Zo = SearchAdView.class.getName();
        VH = b.class.getName();
    }

    private void j6(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int j6 = j6(context, 3);
            frameLayout.addView(textView, new LayoutParams(adSizeParcel.VH - j6, adSizeParcel.Hw - j6, 17));
            viewGroup.addView(frameLayout, adSizeParcel.VH, adSizeParcel.Hw);
        }
    }

    public int DW(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return DW(displayMetrics, i);
    }

    public int DW(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    public boolean DW() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean DW(Context context) {
        return i.DW().j6(context) == 0;
    }

    public boolean FH(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    public boolean Hw(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (agb.v5()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        } else {
            try {
                i = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        boolean z = displayMetrics.heightPixels == i && displayMetrics.widthPixels == i2;
        return z;
    }

    public int j6(Context context, int i) {
        return j6(context.getResources().getDisplayMetrics(), i);
    }

    public int j6(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public String j6(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || j6()) {
            string = "emulator";
        }
        return j6(string);
    }

    public String j6(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.lang.String j6(java.lang.String r6, java.lang.String r7, int r8) {
        /*
        r5 = this;
        r2 = new java.util.StringTokenizer;
        r2.<init>(r6, r7);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = r8 + -1;
        if (r8 <= 0) goto L_0x0039;
    L_0x000e:
        r1 = r2.hasMoreElements();
        if (r1 == 0) goto L_0x0039;
    L_0x0014:
        r1 = r2.nextToken();
        r3.append(r1);
    L_0x001b:
        r1 = r0 + -1;
        if (r0 <= 0) goto L_0x0035;
    L_0x001f:
        r0 = r2.hasMoreElements();
        if (r0 == 0) goto L_0x0035;
    L_0x0025:
        r0 = ".";
        r0 = r3.append(r0);
        r4 = r2.nextToken();
        r0.append(r4);
        r0 = r1;
        goto L_0x001b;
    L_0x0035:
        r6 = r3.toString();
    L_0x0039:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.a.j6(java.lang.String, java.lang.String, int):java.lang.String");
    }

    public String j6(StackTraceElement[] stackTraceElementArr, String str) {
        String className;
        for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (DW.equalsIgnoreCase(className2) || FH.equalsIgnoreCase(className2) || Hw.equalsIgnoreCase(className2) || v5.equalsIgnoreCase(className2) || Zo.equalsIgnoreCase(className2) || VH.equalsIgnoreCase(className2))) {
                className = stackTraceElementArr[i + 1].getClassName();
                break;
            }
        }
        className = null;
        if (str != null) {
            CharSequence j6 = j6(str, ".", 3);
            if (!(className == null || className.contains(j6))) {
                return className;
            }
        }
        return null;
    }

    public void j6(Context context, String str, String str2, Bundle bundle, boolean z) {
        j6(context, str, str2, bundle, z, new 1(this));
    }

    public void j6(Context context, String str, String str2, Bundle bundle, boolean z, a aVar) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                str = i.DW().DW(context) + "." + l.j6;
            }
            bundle.putString("js", str);
        }
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        aVar.j6(appendQueryParameter.toString());
    }

    public void j6(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str) {
        j6(viewGroup, adSizeParcel, str, -16777216, -1);
    }

    public void j6(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, String str2) {
        b.Hw(str2);
        j6(viewGroup, adSizeParcel, str, -65536, -16777216);
    }

    public void j6(boolean z, HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public boolean j6() {
        return Build.DEVICE.startsWith("generic");
    }

    public int v5(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }
}
