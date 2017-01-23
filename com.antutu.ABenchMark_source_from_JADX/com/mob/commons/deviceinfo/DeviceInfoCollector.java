package com.mob.commons.deviceinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Parcelable;
import anet.channel.strategy.dispatch.C0714a;
import com.mob.commons.C3972a;
import com.mob.commons.C3986c;
import com.mob.commons.C3991e;
import com.mob.commons.C3996f;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class DeviceInfoCollector implements Callback {
    private static DeviceInfoCollector f13351a;
    private Context f13352b;
    private Hashon f13353c;
    private Handler f13354d;
    private Random f13355e;

    /* renamed from: com.mob.commons.deviceinfo.DeviceInfoCollector.1 */
    class C39891 extends MobHandlerThread {
        final /* synthetic */ DeviceInfoCollector f13349a;

        /* renamed from: com.mob.commons.deviceinfo.DeviceInfoCollector.1.1 */
        class C39881 implements Runnable {
            final /* synthetic */ C39891 f13348a;

            C39881(C39891 c39891) {
                this.f13348a = c39891;
            }

            public void run() {
                this.f13348a.m16429a();
            }
        }

        C39891(DeviceInfoCollector deviceInfoCollector) {
            this.f13349a = deviceInfoCollector;
        }

        private void m16429a() {
            super.run();
        }

        public void run() {
            C3991e.m16442a(new File(C4021R.getCacheRoot(this.f13349a.f13352b), "comm/locks/.dic_lock"), new C39881(this));
        }
    }

    /* renamed from: com.mob.commons.deviceinfo.DeviceInfoCollector.2 */
    class C39902 extends BroadcastReceiver {
        final /* synthetic */ DeviceInfoCollector f13350a;

        C39902(DeviceInfoCollector deviceInfoCollector) {
            this.f13350a = deviceInfoCollector;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                    if (parcelableExtra != null && ((NetworkInfo) parcelableExtra).isAvailable()) {
                        HashMap hashMap = new HashMap();
                        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
                        hashMap.put("ssid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSSID", new Object[0]));
                        hashMap.put(C0714a.BSSID, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getBssid", new Object[0]));
                        String MD5 = Data.MD5(this.f13350a.f13353c.fromHashMap(hashMap));
                        String c = C3996f.m16457c(context);
                        if ((c == null || !c.equals(MD5)) && C3972a.m16352l(context)) {
                            this.f13350a.m16438d();
                        }
                    }
                }
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
    }

    private DeviceInfoCollector(Context context) {
        this.f13352b = context.getApplicationContext();
        this.f13353c = new Hashon();
        this.f13355e = new Random();
    }

    private void m16432a() {
        MobHandlerThread c39891 = new C39891(this);
        c39891.start();
        this.f13354d = new Handler(c39891.getLooper(), this);
        this.f13354d.sendEmptyMessage(1);
        this.f13354d.sendEmptyMessage(2);
        this.f13354d.sendEmptyMessage(3);
        this.f13354d.sendEmptyMessage(5);
    }

    private void m16433a(Location location, int i) {
        if (location != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("accuracy", Float.valueOf(location.getAccuracy()));
            hashMap.put("latitude", Double.valueOf(location.getLatitude()));
            hashMap.put("longitude", Double.valueOf(location.getLongitude()));
            hashMap.put("location_type", Integer.valueOf(i));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(C4233j.f14402y, "LOCATION");
            hashMap2.put(Constants.KEY_DATA, hashMap);
            hashMap2.put("datetime", Long.valueOf(C3972a.m16336a(this.f13352b)));
            C3986c.m16412a(this.f13352b).m16425a(C3972a.m16336a(this.f13352b), hashMap2);
        }
    }

    private void m16435b() {
        try {
            HashMap hashMap = new HashMap();
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13352b);
            hashMap.put("phonename", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getBluetoothName", new Object[0]));
            hashMap.put("signmd5", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSignMD5", new Object[0]));
            String MD5 = Data.MD5(this.f13353c.fromHashMap(hashMap));
            String a = C3996f.m16451a(this.f13352b);
            if (a == null || !a.equals(MD5)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(C4233j.f14402y, "DEVEXT");
                hashMap2.put(Constants.KEY_DATA, hashMap);
                hashMap2.put("datetime", Long.valueOf(C3972a.m16336a(this.f13352b)));
                C3986c.m16412a(this.f13352b).m16425a(C3972a.m16336a(this.f13352b), hashMap2);
                C3996f.m16453a(this.f13352b, MD5);
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }

    private boolean m16437c() {
        long b = C3996f.m16454b(this.f13352b);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(b);
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        long a = C3972a.m16336a(this.f13352b);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(a);
        return (i == instance2.get(1) && i2 == instance2.get(2) && i3 == instance2.get(5)) ? false : true;
    }

    private void m16438d() {
        synchronized (f13351a) {
            try {
                HashMap hashMap = new HashMap();
                Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13352b);
                hashMap.put("ssid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSSID", new Object[0]));
                hashMap.put(C0714a.BSSID, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getBssid", new Object[0]));
                HashMap hashMap2 = new HashMap();
                hashMap2.put(C4233j.f14402y, "WIFI_INFO");
                hashMap2.put(Constants.KEY_DATA, hashMap);
                long a = C3972a.m16336a(this.f13352b);
                hashMap2.put("datetime", Long.valueOf(a));
                C3986c.m16412a(this.f13352b).m16425a(C3972a.m16336a(this.f13352b), hashMap2);
                C3996f.m16452a(this.f13352b, a);
                C3996f.m16456b(this.f13352b, Data.MD5(this.f13353c.fromHashMap(hashMap)));
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
    }

    private void m16439e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.f13352b.registerReceiver(new C39902(this), intentFilter);
    }

    private void m16440f() {
        int parseInt;
        HashMap hashMap = new HashMap();
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13352b);
        try {
            parseInt = Integer.parseInt((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
        } catch (Throwable th) {
            parseInt = -1;
        }
        hashMap.put("carrier", Integer.valueOf(parseInt));
        hashMap.put("simopname", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrierName", new Object[0]));
        hashMap.put("lac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCellLac", new Object[0]));
        hashMap.put("cell", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCellId", new Object[0]));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(C4233j.f14402y, "BSINFO");
        hashMap2.put(Constants.KEY_DATA, hashMap);
        hashMap2.put("datetime", Long.valueOf(C3972a.m16336a(this.f13352b)));
        C3986c.m16412a(this.f13352b).m16425a(C3972a.m16336a(this.f13352b), hashMap2);
        C3996f.m16458c(this.f13352b, Data.MD5(this.f13353c.fromHashMap(hashMap)));
        C3996f.m16455b(this.f13352b, C3972a.m16336a(this.f13352b) + (((long) C3972a.m16349i(this.f13352b)) * 1000));
    }

    private boolean m16441g() {
        int parseInt;
        HashMap hashMap = new HashMap();
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13352b);
        try {
            parseInt = Integer.parseInt((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
        } catch (Throwable th) {
            parseInt = -1;
        }
        hashMap.put("carrier", Integer.valueOf(parseInt));
        hashMap.put("simopname", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrierName", new Object[0]));
        hashMap.put("lac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCellLac", new Object[0]));
        hashMap.put("cell", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCellId", new Object[0]));
        String MD5 = Data.MD5(this.f13353c.fromHashMap(hashMap));
        String d = C3996f.m16459d(this.f13352b);
        return d == null || !d.equals(MD5);
    }

    public static synchronized void startCollector(Context context) {
        synchronized (DeviceInfoCollector.class) {
            if (f13351a == null) {
                f13351a = new DeviceInfoCollector(context);
                f13351a.m16432a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r9) {
        /*
        r8 = this;
        r7 = 4;
        r6 = 0;
        r0 = r9.what;
        switch(r0) {
            case 1: goto L_0x0008;
            case 2: goto L_0x0014;
            case 3: goto L_0x0029;
            case 4: goto L_0x0050;
            case 5: goto L_0x0099;
            default: goto L_0x0007;
        };
    L_0x0007:
        return r6;
    L_0x0008:
        r0 = r8.f13352b;
        r0 = com.mob.commons.C3972a.m16347g(r0);
        if (r0 == 0) goto L_0x0007;
    L_0x0010:
        r8.m16435b();
        goto L_0x0007;
    L_0x0014:
        r0 = r8.f13352b;
        r0 = com.mob.commons.C3972a.m16352l(r0);
        if (r0 == 0) goto L_0x0007;
    L_0x001c:
        r0 = r8.m16437c();
        if (r0 == 0) goto L_0x0025;
    L_0x0022:
        r8.m16438d();
    L_0x0025:
        r8.m16439e();
        goto L_0x0007;
    L_0x0029:
        r0 = r8.f13352b;
        r0 = com.mob.commons.C3972a.m16348h(r0);
        if (r0 == 0) goto L_0x0034;
    L_0x0031:
        r8.m16440f();	 Catch:{ Throwable -> 0x0047 }
    L_0x0034:
        r0 = r8.f13355e;
        r1 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r0 = r0.nextInt(r1);
        r0 = r0 + 180;
        r1 = r8.f13354d;
        r0 = r0 * 1000;
        r2 = (long) r0;
        r1.sendEmptyMessageDelayed(r7, r2);
        goto L_0x0007;
    L_0x0047:
        r0 = move-exception;
        r1 = com.mob.tools.MobLog.getInstance();
        r1.m4388w(r0);
        goto L_0x0034;
    L_0x0050:
        r0 = r8.f13352b;
        r0 = com.mob.commons.C3972a.m16348h(r0);
        if (r0 == 0) goto L_0x007c;
    L_0x0058:
        r0 = r8.f13352b;
        r0 = com.mob.commons.C3972a.m16336a(r0);
        r2 = r8.f13352b;
        r2 = com.mob.commons.C3972a.m16349i(r2);
        r2 = (long) r2;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 * r4;
        r0 = r0 + r2;
        r2 = r8.f13352b;
        r2 = com.mob.commons.C3972a.m16336a(r2);
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0079;
    L_0x0073:
        r0 = r8.m16441g();	 Catch:{ Throwable -> 0x0090 }
        if (r0 == 0) goto L_0x007c;
    L_0x0079:
        r8.m16440f();	 Catch:{ Throwable -> 0x0090 }
    L_0x007c:
        r0 = r8.f13355e;
        r1 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r0 = r0.nextInt(r1);
        r0 = r0 + 180;
        r1 = r8.f13354d;
        r0 = r0 * 1000;
        r2 = (long) r0;
        r1.sendEmptyMessageDelayed(r7, r2);
        goto L_0x0007;
    L_0x0090:
        r0 = move-exception;
        r1 = com.mob.tools.MobLog.getInstance();
        r1.m4388w(r0);
        goto L_0x007c;
    L_0x0099:
        r0 = r8.f13352b;
        r0 = com.mob.commons.C3972a.m16350j(r0);
        if (r0 == 0) goto L_0x0101;
    L_0x00a1:
        r0 = "DeviceHelper";
        r1 = "getInstance";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0112 }
        r3 = 0;
        r4 = r8.f13352b;	 Catch:{ Throwable -> 0x0112 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0112 }
        r1 = com.mob.tools.utils.ReflectHelper.invokeStaticMethod(r0, r1, r2);	 Catch:{ Throwable -> 0x0112 }
        r0 = "getLocation";
        r2 = 3;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0112 }
        r3 = 0;
        r4 = 30;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0112 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0112 }
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0112 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0112 }
        r3 = 2;
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0112 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0112 }
        r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r1, r0, r2);	 Catch:{ Throwable -> 0x0112 }
        r0 = (android.location.Location) r0;	 Catch:{ Throwable -> 0x0112 }
        r2 = 1;
        r8.m16433a(r0, r2);	 Catch:{ Throwable -> 0x0112 }
        r0 = "getLocation";
        r2 = 3;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0112 }
        r3 = 0;
        r4 = 15;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0112 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0112 }
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0112 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0112 }
        r3 = 2;
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0112 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0112 }
        r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r1, r0, r2);	 Catch:{ Throwable -> 0x0112 }
        r0 = (android.location.Location) r0;	 Catch:{ Throwable -> 0x0112 }
        r1 = 2;
        r8.m16433a(r0, r1);	 Catch:{ Throwable -> 0x0112 }
    L_0x0101:
        r0 = r8.f13354d;
        r1 = 5;
        r2 = r8.f13352b;
        r2 = com.mob.commons.C3972a.m16351k(r2);
        r2 = r2 * 1000;
        r2 = (long) r2;
        r0.sendEmptyMessageDelayed(r1, r2);
        goto L_0x0007;
    L_0x0112:
        r0 = move-exception;
        r1 = com.mob.tools.MobLog.getInstance();
        r1.m4388w(r0);
        goto L_0x0101;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.deviceinfo.DeviceInfoCollector.handleMessage(android.os.Message):boolean");
    }
}
