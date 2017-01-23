package com.google.android.gms.internal;

import aft;
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
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.f;
import java.util.Locale;

@eh
public final class zzio {

    public static final class zza {
        private boolean DW;
        private boolean EQ;
        private boolean FH;
        private int Hw;
        private double J0;
        private boolean J8;
        private String Mr;
        private boolean QX;
        private String U2;
        private String VH;
        private boolean Ws;
        private String XL;
        private int Zo;
        private float a8;
        private boolean aM;
        private int gn;
        private boolean j3;
        private int j6;
        private int lg;
        private int rN;
        private int tp;
        private int u7;
        private int v5;
        private int we;

        public zza(Context context) {
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            j6(context);
            j6(context, packageManager);
            DW(context);
            Locale locale = Locale.getDefault();
            this.Ws = j6(packageManager, "geo:0,0?q=donuts") != null;
            if (j6(packageManager, "http://www.google.com") == null) {
                z = false;
            }
            this.QX = z;
            this.XL = locale.getCountry();
            this.aM = w.j6().j6();
            this.j3 = aft.DW(context);
            this.Mr = locale.getLanguage();
            this.U2 = j6(packageManager);
            Resources resources = context.getResources();
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                if (displayMetrics != null) {
                    this.a8 = displayMetrics.density;
                    this.lg = displayMetrics.widthPixels;
                    this.rN = displayMetrics.heightPixels;
                }
            }
        }

        private void DW(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                this.J0 = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.J8 = z;
                return;
            }
            this.J0 = -1.0d;
            this.J8 = false;
        }

        private static ResolveInfo j6(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String j6(PackageManager packageManager) {
            String str = null;
            ResolveInfo j6 = j6(packageManager, "market://details?id=com.google.android.gms.ads");
            if (j6 != null) {
                ActivityInfo activityInfo = j6.activityInfo;
                if (activityInfo != null) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                        if (packageInfo != null) {
                            int i = packageInfo.versionCode;
                            String valueOf = String.valueOf(activityInfo.packageName);
                            str = new StringBuilder(String.valueOf(valueOf).length() + 12).append(i).append(".").append(valueOf).toString();
                        }
                    } catch (NameNotFoundException e) {
                    }
                }
            }
            return str;
        }

        private void j6(Context context) {
            AudioManager Hw = f.FH().Hw(context);
            if (Hw != null) {
                try {
                    this.j6 = Hw.getMode();
                    this.DW = Hw.isMusicActive();
                    this.FH = Hw.isSpeakerphoneOn();
                    this.Hw = Hw.getStreamVolume(3);
                    this.v5 = Hw.getRingerMode();
                    this.Zo = Hw.getStreamVolume(2);
                    return;
                } catch (Throwable th) {
                    f.Zo().j6(th, true);
                }
            }
            this.j6 = -2;
            this.DW = false;
            this.FH = false;
            this.Hw = 0;
            this.v5 = 0;
            this.Zo = 0;
        }

        @TargetApi(16)
        private void j6(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.VH = telephonyManager.getNetworkOperator();
            this.u7 = telephonyManager.getNetworkType();
            this.tp = telephonyManager.getPhoneType();
            this.gn = -2;
            this.EQ = false;
            this.we = -1;
            if (f.FH().j6(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.gn = activeNetworkInfo.getType();
                    this.we = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.gn = -1;
                }
                if (VERSION.SDK_INT >= 16) {
                    this.EQ = connectivityManager.isActiveNetworkMetered();
                }
            }
        }
    }
}
