package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.common.C3465h;
import com.umeng.message.MsgConstant;
import java.util.Locale;

@gb
/* renamed from: com.google.android.gms.b.gj */
public final class gj {
    public final int f11127a;
    public final boolean f11128b;
    public final boolean f11129c;
    public final String f11130d;
    public final String f11131e;
    public final boolean f11132f;
    public final boolean f11133g;
    public final boolean f11134h;
    public final boolean f11135i;
    public final String f11136j;
    public final String f11137k;
    public final int f11138l;
    public final int f11139m;
    public final int f11140n;
    public final int f11141o;
    public final int f11142p;
    public final int f11143q;
    public final float f11144r;
    public final int f11145s;
    public final int f11146t;
    public final double f11147u;
    public final boolean f11148v;
    public final boolean f11149w;
    public final int f11150x;
    public final String f11151y;

    /* renamed from: com.google.android.gms.b.gj.a */
    public static final class C3229a {
        private int f11102a;
        private boolean f11103b;
        private boolean f11104c;
        private int f11105d;
        private int f11106e;
        private int f11107f;
        private String f11108g;
        private int f11109h;
        private int f11110i;
        private int f11111j;
        private boolean f11112k;
        private int f11113l;
        private double f11114m;
        private boolean f11115n;
        private String f11116o;
        private boolean f11117p;
        private boolean f11118q;
        private String f11119r;
        private boolean f11120s;
        private boolean f11121t;
        private String f11122u;
        private String f11123v;
        private float f11124w;
        private int f11125x;
        private int f11126y;

        public C3229a(Context context) {
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            m12891a(context);
            m12892a(context, packageManager);
            m12893b(context);
            Locale locale = Locale.getDefault();
            this.f11117p = C3229a.m12889a(packageManager, "geo:0,0?q=donuts") != null;
            if (C3229a.m12889a(packageManager, "http://www.google.com") == null) {
                z = false;
            }
            this.f11118q = z;
            this.f11119r = locale.getCountry();
            this.f11120s = C2784w.m10741a().m11568a();
            this.f11121t = C3465h.m14301f(context);
            this.f11122u = locale.getLanguage();
            this.f11123v = C3229a.m12890a(packageManager);
            Resources resources = context.getResources();
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                if (displayMetrics != null) {
                    this.f11124w = displayMetrics.density;
                    this.f11125x = displayMetrics.widthPixels;
                    this.f11126y = displayMetrics.heightPixels;
                }
            }
        }

        public C3229a(Context context, gj gjVar) {
            PackageManager packageManager = context.getPackageManager();
            m12891a(context);
            m12892a(context, packageManager);
            m12893b(context);
            m12894c(context);
            this.f11117p = gjVar.f11128b;
            this.f11118q = gjVar.f11129c;
            this.f11119r = gjVar.f11131e;
            this.f11120s = gjVar.f11132f;
            this.f11121t = gjVar.f11133g;
            this.f11122u = gjVar.f11136j;
            this.f11123v = gjVar.f11137k;
            this.f11124w = gjVar.f11144r;
            this.f11125x = gjVar.f11145s;
            this.f11126y = gjVar.f11146t;
        }

        private static ResolveInfo m12889a(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), AccessibilityNodeInfoCompat.ACTION_CUT);
        }

        private static String m12890a(PackageManager packageManager) {
            String str = null;
            ResolveInfo a = C3229a.m12889a(packageManager, "market://details?id=com.google.android.gms.ads");
            if (a != null) {
                ActivityInfo activityInfo = a.activityInfo;
                if (activityInfo != null) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                        if (packageInfo != null) {
                            str = packageInfo.versionCode + "." + activityInfo.packageName;
                        }
                    } catch (NameNotFoundException e) {
                    }
                }
            }
            return str;
        }

        private void m12891a(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.f11102a = audioManager.getMode();
            this.f11103b = audioManager.isMusicActive();
            this.f11104c = audioManager.isSpeakerphoneOn();
            this.f11105d = audioManager.getStreamVolume(3);
            this.f11106e = audioManager.getRingerMode();
            this.f11107f = audioManager.getStreamVolume(2);
        }

        @TargetApi(16)
        private void m12892a(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.f11108g = telephonyManager.getNetworkOperator();
            this.f11110i = telephonyManager.getNetworkType();
            this.f11111j = telephonyManager.getPhoneType();
            this.f11109h = -2;
            this.f11112k = false;
            this.f11113l = -1;
            if (C2968s.m11525e().m13045a(packageManager, context.getPackageName(), MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.f11109h = activeNetworkInfo.getType();
                    this.f11113l = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.f11109h = -1;
                }
                if (VERSION.SDK_INT >= 16) {
                    this.f11112k = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        private void m12893b(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra(MsgConstant.KEY_STATUS, -1);
                this.f11114m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.f11115n = z;
                return;
            }
            this.f11114m = -1.0d;
            this.f11115n = false;
        }

        private void m12894c(Context context) {
            this.f11116o = Build.FINGERPRINT;
        }

        public gj m12895a() {
            return new gj(this.f11102a, this.f11117p, this.f11118q, this.f11108g, this.f11119r, this.f11120s, this.f11121t, this.f11103b, this.f11104c, this.f11122u, this.f11123v, this.f11105d, this.f11109h, this.f11110i, this.f11111j, this.f11106e, this.f11107f, this.f11124w, this.f11125x, this.f11126y, this.f11114m, this.f11115n, this.f11112k, this.f11113l, this.f11116o);
        }
    }

    gj(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5) {
        this.f11127a = i;
        this.f11128b = z;
        this.f11129c = z2;
        this.f11130d = str;
        this.f11131e = str2;
        this.f11132f = z3;
        this.f11133g = z4;
        this.f11134h = z5;
        this.f11135i = z6;
        this.f11136j = str3;
        this.f11137k = str4;
        this.f11138l = i2;
        this.f11139m = i3;
        this.f11140n = i4;
        this.f11141o = i5;
        this.f11142p = i6;
        this.f11143q = i7;
        this.f11144r = f;
        this.f11145s = i8;
        this.f11146t = i9;
        this.f11147u = d;
        this.f11148v = z7;
        this.f11149w = z8;
        this.f11150x = i10;
        this.f11151y = str5;
    }
}
