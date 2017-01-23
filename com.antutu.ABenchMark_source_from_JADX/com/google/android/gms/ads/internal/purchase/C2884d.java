package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fb.C2883a;
import com.google.android.gms.p146b.gb;
import com.qq.p035e.comm.pi.ACTD;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.d */
public class C2884d extends C2883a {
    private String f9765a;
    private Context f9766b;
    private String f9767c;
    private ArrayList<String> f9768d;

    public C2884d(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.f9767c = str;
        this.f9768d = arrayList;
        this.f9765a = str2;
        this.f9766b = context;
    }

    protected int m11219a(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    public String m11220a() {
        return this.f9767c;
    }

    protected String m11221a(String str, HashMap<String, String> hashMap) {
        Object obj;
        String packageName = this.f9766b.getPackageName();
        Object obj2 = BuildConfig.FLAVOR;
        try {
            obj = this.f9766b.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (Throwable e) {
            C2972b.m11584d("Error to retrieve app version", e);
            obj = obj2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - C2968s.m11528h().m12947d().m12970a();
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{hashMap.get(str2)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{C2968s.m11528h().m12931a()})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{ACTD.APPID_KEY}), String.format("$1%s$2", new Object[]{packageName})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.f9765a})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{obj})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{BuildConfig.FLAVOR})).replaceAll("@@", "@");
    }

    void m11222b() {
        try {
            this.f9766b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.f9766b, this.f9767c, BuildConfig.FLAVOR, Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            C2972b.m11583d("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            C2972b.m11583d("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            C2972b.m11584d("Fail to report a conversion.", e3);
        }
    }

    public void m11223b(int i) {
        if (i == 1) {
            m11222b();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(MsgConstant.KEY_STATUS, String.valueOf(i));
        hashMap.put("sku", this.f9767c);
        List linkedList = new LinkedList();
        Iterator it = this.f9768d.iterator();
        while (it.hasNext()) {
            linkedList.add(m11221a((String) it.next(), hashMap));
        }
        C2968s.m11525e().m13037a(this.f9766b, this.f9765a, linkedList);
    }

    public void m11224c(int i) {
        if (i == 0) {
            m11222b();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(i));
        hashMap.put("sku", this.f9767c);
        hashMap.put(MsgConstant.KEY_STATUS, String.valueOf(m11219a(i)));
        List linkedList = new LinkedList();
        Iterator it = this.f9768d.iterator();
        while (it.hasNext()) {
            linkedList.add(m11221a((String) it.next(), hashMap));
        }
        C2968s.m11525e().m13037a(this.f9766b, this.f9765a, linkedList);
    }
}
