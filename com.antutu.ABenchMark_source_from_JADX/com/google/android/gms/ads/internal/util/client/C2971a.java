package com.google.android.gms.ads.internal.util.client;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.v4.internal.view.SupportMenu;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.utils.widget.SystemBarTintManager;
import com.google.android.gms.ads.C2710b;
import com.google.android.gms.ads.C2723e;
import com.google.android.gms.ads.C2725h;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.p152a.C2697d;
import com.google.android.gms.ads.p152a.C2698e;
import com.google.android.gms.ads.p154e.C2721b;
import com.google.android.gms.common.C3465h;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.jq;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@gb
/* renamed from: com.google.android.gms.ads.internal.util.client.a */
public class C2971a {
    public static final Handler f10085a;
    private static final String f10086b;
    private static final String f10087c;
    private static final String f10088d;
    private static final String f10089e;
    private static final String f10090f;
    private static final String f10091g;

    static {
        f10085a = new Handler(Looper.getMainLooper());
        f10086b = C2723e.class.getName();
        f10087c = C2725h.class.getName();
        f10088d = C2697d.class.getName();
        f10089e = C2698e.class.getName();
        f10090f = C2721b.class.getName();
        f10091g = C2710b.class.getName();
    }

    private void m11559a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m11560a(context, 3);
            frameLayout.addView(textView, new LayoutParams(adSizeParcel.f9331g - a, adSizeParcel.f9328d - a, 17));
            viewGroup.addView(frameLayout, adSizeParcel.f9331g, adSizeParcel.f9328d);
        }
    }

    public int m11560a(Context context, int i) {
        return m11561a(context.getResources().getDisplayMetrics(), i);
    }

    public int m11561a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public String m11562a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || m11568a()) {
            string = "emulator";
        }
        return m11563a(string);
    }

    public String m11563a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5).update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.lang.String m11564a(java.lang.String r6, java.lang.String r7, int r8) {
        /*
        r5 = this;
        r2 = new java.util.StringTokenizer;
        r2.<init>(r6, r7);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = r8 + -1;
        if (r8 <= 0) goto L_0x0038;
    L_0x000e:
        r1 = r2.hasMoreElements();
        if (r1 == 0) goto L_0x0038;
    L_0x0014:
        r1 = r2.nextToken();
        r3.append(r1);
    L_0x001b:
        r1 = r0 + -1;
        if (r0 <= 0) goto L_0x0034;
    L_0x001f:
        r0 = r2.hasMoreElements();
        if (r0 == 0) goto L_0x0034;
    L_0x0025:
        r0 = ".";
        r0 = r3.append(r0);
        r4 = r2.nextToken();
        r0.append(r4);
        r0 = r1;
        goto L_0x001b;
    L_0x0034:
        r6 = r3.toString();
    L_0x0038:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.a.a(java.lang.String, java.lang.String, int):java.lang.String");
    }

    public String m11565a(StackTraceElement[] stackTraceElementArr, String str) {
        String className;
        for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (f10086b.equalsIgnoreCase(className2) || f10087c.equalsIgnoreCase(className2) || f10088d.equalsIgnoreCase(className2) || f10089e.equalsIgnoreCase(className2) || f10090f.equalsIgnoreCase(className2) || f10091g.equalsIgnoreCase(className2))) {
                className = stackTraceElementArr[i + 1].getClassName();
                break;
            }
        }
        className = null;
        if (str != null) {
            CharSequence a = m11564a(str, ".", 3);
            if (!(className == null || className.contains(a))) {
                return className;
            }
        }
        return null;
    }

    public void m11566a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str) {
        m11559a(viewGroup, adSizeParcel, str, SystemBarTintManager.DEFAULT_TINT_COLOR, -1);
    }

    public void m11567a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, String str2) {
        C2972b.m11583d(str2);
        m11559a(viewGroup, adSizeParcel, str, SupportMenu.CATEGORY_MASK, SystemBarTintManager.DEFAULT_TINT_COLOR);
    }

    public boolean m11568a() {
        return Build.DEVICE.startsWith("generic");
    }

    public int m11569b(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return m11570b(displayMetrics, i);
    }

    public int m11570b(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    public boolean m11571b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean m11572b(Context context) {
        return C3465h.m14286a(context) == 0;
    }

    public boolean m11573c(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < OtherError.CONTAINER_INVISIBLE_ERROR;
    }

    public boolean m11574d(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (jq.m13570c()) {
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

    public int m11575e(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", C0714a.ANDROID);
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }
}
