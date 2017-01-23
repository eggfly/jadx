package com.mob.commons;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.ReflectHelper;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TimeZone;

/* renamed from: com.mob.commons.b */
public class C3983b extends NetworkHelper {
    private static final String[] f13334a;
    private static C3983b f13335b;
    private Context f13336c;
    private HashMap<String, MobProduct> f13337d;

    static {
        f13334a = new String[]{ShareSDK.SDK_TAG, "SMSSDK", "SHAREREC", "MOBAPI"};
    }

    private C3983b(Context context) {
        this.f13336c = context.getApplicationContext();
        this.f13337d = new HashMap();
    }

    public static C3983b m16407a(Context context) {
        if (f13335b == null) {
            f13335b = new C3983b(context);
        }
        return f13335b;
    }

    public String m16408a(ArrayList<MobProduct> arrayList) {
        try {
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13336c);
            String str = ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]) + "/" + ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersionName", new Object[0]);
            String str2 = BuildConfig.FLAVOR;
            int size = arrayList.size();
            String str3 = str2;
            for (int i = 0; i < size; i++) {
                try {
                    str2 = str3.length() > 0 ? str3 + " " : str3;
                    try {
                        MobProduct mobProduct = (MobProduct) arrayList.get(i);
                        str3 = str2 + mobProduct.getProductTag() + "/" + mobProduct.getSdkver();
                    } catch (Throwable th) {
                        str3 = str2;
                    }
                } catch (Throwable th2) {
                }
            }
            str2 = "Android/" + ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionInt", new Object[0]);
            return str + " " + str3 + (str3.length() > 0 ? " " : BuildConfig.FLAVOR) + str2 + " " + TimeZone.getDefault().getID() + " " + ("Lang/" + Locale.getDefault().toString().replace("-r", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        } catch (Throwable th3) {
            MobLog.getInstance().m4388w(th3);
            return BuildConfig.FLAVOR;
        }
    }

    public ArrayList<MobProduct> m16409a() {
        try {
            ReflectHelper.importClass("com.mob.commons.*");
            for (String newInstance : f13334a) {
                try {
                    MobProduct mobProduct = (MobProduct) ReflectHelper.newInstance(newInstance, new Object[0]);
                    if (mobProduct != null) {
                        this.f13337d.put(mobProduct.getProductTag(), mobProduct);
                    }
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            MobLog.getInstance().m4388w(th2);
        }
        ArrayList<MobProduct> arrayList = new ArrayList();
        for (Entry value : this.f13337d.entrySet()) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public void m16410a(MobProduct mobProduct) {
        if (mobProduct != null && !this.f13337d.containsKey(mobProduct.getProductTag())) {
            this.f13337d.put(mobProduct.getProductTag(), mobProduct);
        }
    }
}
