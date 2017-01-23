package com.cmcm.p074a.p075a.p115d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.cmcm.p074a.p075a.p112a.C2115i;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.d.y */
public class C2184y {
    public static String m8217a(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return null;
        }
    }

    public static String m8218b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String[] a = C2115i.m7968a(context);
            jSONObject.put("mcc", a[0]);
            jSONObject.put("mnc", a[1]);
            jSONObject.put("xaid", C2115i.m7970b(context));
            jSONObject.put("root", C2115i.m7973c());
            jSONObject.put(Constants.KEY_BRAND, Build.BRAND);
            jSONObject.put(Constants.KEY_MODEL, Build.MODEL);
            jSONObject.put("gaid", C2160a.m8150b().m8151a());
            jSONObject.put("devicebirthday", (int) (C2115i.m7974d() / 1000));
            jSONObject.put("osver", VERSION.RELEASE);
            jSONObject.put("hostapk", context.getPackageName());
            jSONObject.put("hostver", C2115i.m7978g(context));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            jSONObject.put("xdpi", (double) displayMetrics.xdpi);
            jSONObject.put("ydpi", (double) displayMetrics.ydpi);
            jSONObject.put("widthPixels", displayMetrics.widthPixels);
            jSONObject.put("heightPixels", displayMetrics.heightPixels);
            Object a2 = C2184y.m8217a(context);
            if (!TextUtils.isEmpty(a2)) {
                a2 = C2164e.m8157a().m8161b(a2.getBytes());
            }
            jSONObject.put("x1", a2);
            return jSONObject.toString();
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }
}
