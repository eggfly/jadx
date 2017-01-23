package com.mob.commons.authorize;

import android.content.Context;
import android.util.Base64;
import com.antutu.utils.PointMark;
import com.mob.commons.C3991e;
import com.mob.commons.MobProduct;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.mob.commons.authorize.a */
public final class C3982a {

    /* renamed from: com.mob.commons.authorize.a.1 */
    class C39801 implements Runnable {
        final /* synthetic */ String[] f13327a;
        final /* synthetic */ Context f13328b;
        final /* synthetic */ MobProduct f13329c;
        final /* synthetic */ C3982a f13330d;

        C39801(C3982a c3982a, String[] strArr, Context context, MobProduct mobProduct) {
            this.f13330d = c3982a;
            this.f13327a = strArr;
            this.f13328b = context;
            this.f13329c = mobProduct;
        }

        public void run() {
            this.f13327a[0] = this.f13330d.m16401b(this.f13328b, this.f13329c);
        }
    }

    /* renamed from: com.mob.commons.authorize.a.2 */
    class C39812 implements Runnable {
        final /* synthetic */ Context f13331a;
        final /* synthetic */ String[] f13332b;
        final /* synthetic */ C3982a f13333c;

        C39812(C3982a c3982a, Context context, String[] strArr) {
            this.f13333c = c3982a;
            this.f13331a = context;
            this.f13332b = strArr;
        }

        public void run() {
            ObjectInputStream objectInputStream;
            HashMap hashMap;
            Throwable th;
            try {
                File a = this.f13333c.m16400b(this.f13331a);
                if (a.exists() && a.isFile()) {
                    try {
                        objectInputStream = new ObjectInputStream(new FileInputStream(a));
                        try {
                            hashMap = (HashMap) objectInputStream.readObject();
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable th2) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                MobLog.getInstance().m4388w(th);
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                        hashMap = null;
                                    } catch (Throwable th4) {
                                        hashMap = null;
                                    }
                                    if (hashMap == null) {
                                        hashMap = this.f13333c.m16403c(this.f13331a);
                                    }
                                    this.f13332b[0] = (String) hashMap.get("duid");
                                }
                                hashMap = null;
                                if (hashMap == null) {
                                    hashMap = this.f13333c.m16403c(this.f13331a);
                                }
                                this.f13332b[0] = (String) hashMap.get("duid");
                            } catch (Throwable th5) {
                                th = th5;
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Throwable th6) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        objectInputStream = null;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw th;
                    }
                    if (hashMap == null) {
                        hashMap = this.f13333c.m16403c(this.f13331a);
                    }
                    this.f13332b[0] = (String) hashMap.get("duid");
                }
            } catch (Throwable th8) {
                MobLog.getInstance().m4388w(th8);
            }
            hashMap = null;
            if (hashMap == null) {
                hashMap = this.f13333c.m16403c(this.f13331a);
            }
            this.f13332b[0] = (String) hashMap.get("duid");
        }
    }

    private final String m16396a(Context context, MobProduct mobProduct, HashMap<String, Object> hashMap, boolean z) {
        int parseInt;
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Throwable th2;
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
        try {
            parseInt = C4021R.parseInt((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
        } catch (Throwable th3) {
            MobLog.getInstance().m4388w(th3);
            return null;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("adsid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAdvertisingID", new Object[0]));
        hashMap2.put(Constants.KEY_IMEI, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]));
        hashMap2.put("serialno", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]));
        hashMap2.put("androidid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAndroidID", new Object[0]));
        hashMap2.put(PointMark.T_MAC, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
        hashMap2.put(Constants.KEY_MODEL, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
        hashMap2.put("factory", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0]));
        hashMap2.put("carrier", Integer.valueOf(parseInt));
        hashMap2.put("screensize", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getScreenSize", new Object[0]));
        hashMap2.put("sysver", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionName", new Object[0]));
        hashMap2.put("plat", Integer.valueOf(1));
        Hashon hashon = new Hashon();
        String encodeToString = Base64.encodeToString(Data.AES128Encode("sdk.commonap.sdk", hashon.fromHashMap(hashMap2)), 2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("m", encodeToString));
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = 30000;
        networkTimeOut.connectionTimeout = 30000;
        HashMap fromJson = hashon.fromJson(new NetworkHelper().httpPost("http://devs.data.mob.com:80/dinfo", arrayList, null, null, networkTimeOut));
        if (fromJson == null) {
            return null;
        }
        encodeToString = (String) fromJson.get("duid");
        if (encodeToString == null || encodeToString.length() <= 0) {
            return null;
        }
        hashMap.put("duid", encodeToString);
        hashMap2.put("carrier", String.valueOf(parseInt));
        hashMap.put("deviceInfo", hashMap2);
        if (!z) {
            return encodeToString;
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(m16400b(context)));
            try {
                objectOutputStream.writeObject(hashMap);
                if (objectOutputStream == null) {
                    return encodeToString;
                }
                try {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    return encodeToString;
                } catch (Throwable th4) {
                    return encodeToString;
                }
            } catch (Throwable th5) {
                th2 = th5;
                try {
                    MobLog.getInstance().m4388w(th2);
                    if (objectOutputStream != null) {
                        return encodeToString;
                    }
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                        return encodeToString;
                    } catch (Throwable th6) {
                        return encodeToString;
                    }
                } catch (Throwable th7) {
                    th3 = th7;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.flush();
                            objectOutputStream.close();
                        } catch (Throwable th8) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th9) {
            th3 = th9;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            throw th3;
        }
    }

    private final void m16398a(Context context, MobProduct mobProduct, HashMap<String, Object> hashMap) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            String str = (String) hashMap.get("duid");
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair("product", mobProduct.getProductTag()));
            arrayList.add(new KVPair(C4209a.f14204g, mobProduct.getProductAppkey()));
            arrayList.add(new KVPair("duid", str));
            arrayList.add(new KVPair("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]))));
            arrayList.add(new KVPair("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersion", new Object[0]))));
            arrayList.add(new KVPair("sdkver", String.valueOf(mobProduct.getSdkver())));
            arrayList.add(new KVPair("network", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]))));
            NetworkTimeOut networkTimeOut = new NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            HashMap fromJson = new Hashon().fromJson(new NetworkHelper().httpPost("http://devs.data.mob.com:80/dsign", arrayList, null, null, networkTimeOut));
            if ("true".equals(String.valueOf(fromJson.get("reup"))) && m16396a(context, mobProduct, hashMap, false) == null) {
            }
            if ("200".equals(String.valueOf(fromJson.get(MsgConstant.KEY_STATUS)))) {
                ((HashMap) ((HashMap) hashMap.get("appInfo")).get((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]))).put(mobProduct.getProductTag(), mobProduct.getProductAppkey());
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(m16400b(context)));
                    try {
                        objectOutputStream.writeObject(hashMap);
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.flush();
                                objectOutputStream.close();
                            } catch (Throwable th2) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            MobLog.getInstance().m4388w(th);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.flush();
                                    objectOutputStream.close();
                                } catch (Throwable th4) {
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.flush();
                                    objectOutputStream2.close();
                                } catch (Throwable th6) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.flush();
                        objectOutputStream2.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th8) {
            MobLog.getInstance().m4388w(th8);
        }
    }

    private final boolean m16399a(Context context, HashMap<String, String> hashMap) {
        Object obj = null;
        if (hashMap == null) {
            return true;
        }
        Object invokeStaticMethod;
        Object obj2;
        try {
            invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            invokeStaticMethod = null;
        }
        Object obj3 = hashMap.get("adsid");
        if (invokeStaticMethod != null) {
            try {
                obj2 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAdvertisingID", new Object[0]);
            } catch (Throwable th2) {
                MobLog.getInstance().m4388w(th2);
            }
            if (obj2 == null && ((obj3 == null && obj2 != null) || (obj3 != null && !obj3.equals(obj2)))) {
                return true;
            }
            obj3 = hashMap.get(Constants.KEY_IMEI);
            if (invokeStaticMethod != null) {
                try {
                    obj2 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]);
                } catch (Throwable th22) {
                    MobLog.getInstance().m4388w(th22);
                }
                if (obj3 != null || !obj3.equals(r0)) {
                    return true;
                }
                obj3 = hashMap.get("serialno");
                if (invokeStaticMethod != null) {
                    try {
                        obj2 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]);
                    } catch (Throwable th222) {
                        MobLog.getInstance().m4388w(th222);
                    }
                    if (obj3 != null || !obj3.equals(r0)) {
                        return true;
                    }
                    obj3 = hashMap.get(PointMark.T_MAC);
                    if (invokeStaticMethod != null) {
                        try {
                            obj2 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]);
                        } catch (Throwable th2222) {
                            MobLog.getInstance().m4388w(th2222);
                        }
                        if (obj3 != null || !obj3.equals(r0)) {
                            return true;
                        }
                        obj3 = hashMap.get(Constants.KEY_MODEL);
                        if (invokeStaticMethod != null) {
                            try {
                                obj2 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]);
                            } catch (Throwable th22222) {
                                MobLog.getInstance().m4388w(th22222);
                            }
                            if (obj3 != null || !obj3.equals(r0)) {
                                return true;
                            }
                            obj3 = hashMap.get("factory");
                            if (invokeStaticMethod != null) {
                                try {
                                    obj2 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0]);
                                } catch (Throwable th222222) {
                                    MobLog.getInstance().m4388w(th222222);
                                }
                                if (obj3 != null || !obj3.equals(r0)) {
                                    return true;
                                }
                                obj3 = hashMap.get("androidid");
                                if (invokeStaticMethod != null) {
                                    try {
                                        obj2 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAndroidID", new Object[0]);
                                    } catch (Throwable th2222222) {
                                        MobLog.getInstance().m4388w(th2222222);
                                    }
                                    if (obj3 != null || !obj3.equals(r0)) {
                                        return true;
                                    }
                                    obj3 = hashMap.get("sysver");
                                    if (invokeStaticMethod != null) {
                                        try {
                                            obj = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionName", new Object[0]);
                                        } catch (Throwable th22222222) {
                                            MobLog.getInstance().m4388w(th22222222);
                                        }
                                    }
                                    return obj3 == null || !obj3.equals(obj);
                                }
                                obj2 = null;
                                if (obj3 != null) {
                                }
                                return true;
                            }
                            obj2 = null;
                            if (obj3 != null) {
                            }
                            return true;
                        }
                        obj2 = null;
                        if (obj3 != null) {
                        }
                        return true;
                    }
                    obj2 = null;
                    if (obj3 != null) {
                    }
                    return true;
                }
                obj2 = null;
                if (obj3 != null) {
                }
                return true;
            }
            obj2 = null;
            if (obj3 != null) {
            }
            return true;
        }
        obj2 = null;
        if (obj2 == null) {
        }
        obj3 = hashMap.get(Constants.KEY_IMEI);
        if (invokeStaticMethod != null) {
            obj2 = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]);
            if (obj3 != null) {
            }
            return true;
        }
        obj2 = null;
        if (obj3 != null) {
        }
        return true;
    }

    private final File m16400b(Context context) {
        File file = new File(C4021R.getCacheRoot(context), "comm/dbs/.duid");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m16401b(android.content.Context r9, com.mob.commons.MobProduct r10) {
        /*
        r8 = this;
        r2 = 0;
        r0 = r8.m16400b(r9);	 Catch:{ Throwable -> 0x00c5 }
        r1 = r0.exists();	 Catch:{ Throwable -> 0x00c5 }
        if (r1 == 0) goto L_0x00cd;
    L_0x000b:
        r1 = r0.isFile();	 Catch:{ Throwable -> 0x00c5 }
        if (r1 == 0) goto L_0x00cd;
    L_0x0011:
        r3 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x00a8, all -> 0x00bd }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x00a8, all -> 0x00bd }
        r1 = new java.io.ObjectInputStream;	 Catch:{ Throwable -> 0x00a8, all -> 0x00bd }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x00a8, all -> 0x00bd }
        r0 = r1.readObject();	 Catch:{ Throwable -> 0x00ed }
        r0 = (java.util.HashMap) r0;	 Catch:{ Throwable -> 0x00ed }
        if (r1 == 0) goto L_0x0026;
    L_0x0023:
        r1.close();	 Catch:{ Throwable -> 0x00e4 }
    L_0x0026:
        if (r0 != 0) goto L_0x00f7;
    L_0x0028:
        r0 = r8.m16404c(r9, r10);
        r4 = r0;
    L_0x002d:
        if (r4 == 0) goto L_0x00f5;
    L_0x002f:
        r0 = "duid";
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x00a7;
    L_0x0039:
        r1 = "deviceInfo";
        r1 = r4.get(r1);	 Catch:{ Throwable -> 0x00e9 }
        r1 = (java.util.HashMap) r1;	 Catch:{ Throwable -> 0x00e9 }
        r1 = r8.m16399a(r9, r1);	 Catch:{ Throwable -> 0x00e9 }
        if (r1 == 0) goto L_0x00f2;
    L_0x0047:
        r1 = 1;
        r3 = r8.m16396a(r9, r10, r4, r1);	 Catch:{ Throwable -> 0x00e9 }
        if (r3 == 0) goto L_0x00f2;
    L_0x004e:
        r0 = "appInfo";
        r0 = r4.get(r0);	 Catch:{ Throwable -> 0x00d9 }
        r0 = (java.util.HashMap) r0;	 Catch:{ Throwable -> 0x00d9 }
        if (r0 != 0) goto L_0x00ef;
    L_0x0058:
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00d9 }
        r0.<init>();	 Catch:{ Throwable -> 0x00d9 }
        r1 = "appInfo";
        r4.put(r1, r0);	 Catch:{ Throwable -> 0x00d9 }
        r1 = r0;
    L_0x0063:
        r0 = "DeviceHelper";
        r5 = "getInstance";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00d0 }
        r7 = 0;
        r6[r7] = r9;	 Catch:{ Throwable -> 0x00d0 }
        r0 = com.mob.tools.utils.ReflectHelper.invokeStaticMethod(r0, r5, r6);	 Catch:{ Throwable -> 0x00d0 }
        r5 = "getPackageName";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00d0 }
        r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r0, r5, r6);	 Catch:{ Throwable -> 0x00d0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00d0 }
        r2 = r0;
    L_0x007d:
        r0 = r1.get(r2);	 Catch:{ Throwable -> 0x00d9 }
        r0 = (java.util.HashMap) r0;	 Catch:{ Throwable -> 0x00d9 }
        if (r0 != 0) goto L_0x008d;
    L_0x0085:
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00d9 }
        r0.<init>();	 Catch:{ Throwable -> 0x00d9 }
        r1.put(r2, r0);	 Catch:{ Throwable -> 0x00d9 }
    L_0x008d:
        r1 = r10.getProductTag();	 Catch:{ Throwable -> 0x00d9 }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x00d9 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00d9 }
        if (r0 == 0) goto L_0x00a3;
    L_0x0099:
        r1 = r10.getProductAppkey();	 Catch:{ Throwable -> 0x00d9 }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x00d9 }
        if (r0 != 0) goto L_0x00a6;
    L_0x00a3:
        r8.m16398a(r9, r10, r4);	 Catch:{ Throwable -> 0x00d9 }
    L_0x00a6:
        r0 = r3;
    L_0x00a7:
        return r0;
    L_0x00a8:
        r0 = move-exception;
        r1 = r2;
    L_0x00aa:
        r3 = com.mob.tools.MobLog.getInstance();	 Catch:{ all -> 0x00eb }
        r3.m4388w(r0);	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x00cd;
    L_0x00b3:
        r1.close();	 Catch:{ Throwable -> 0x00b9 }
        r0 = r2;
        goto L_0x0026;
    L_0x00b9:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0026;
    L_0x00bd:
        r0 = move-exception;
        r1 = r2;
    L_0x00bf:
        if (r1 == 0) goto L_0x00c4;
    L_0x00c1:
        r1.close();	 Catch:{ Throwable -> 0x00e7 }
    L_0x00c4:
        throw r0;	 Catch:{ Throwable -> 0x00c5 }
    L_0x00c5:
        r0 = move-exception;
        r1 = com.mob.tools.MobLog.getInstance();
        r1.m4388w(r0);
    L_0x00cd:
        r0 = r2;
        goto L_0x0026;
    L_0x00d0:
        r0 = move-exception;
        r5 = com.mob.tools.MobLog.getInstance();	 Catch:{ Throwable -> 0x00d9 }
        r5.m4388w(r0);	 Catch:{ Throwable -> 0x00d9 }
        goto L_0x007d;
    L_0x00d9:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
    L_0x00dc:
        r2 = com.mob.tools.MobLog.getInstance();
        r2.m4388w(r1);
        goto L_0x00a7;
    L_0x00e4:
        r1 = move-exception;
        goto L_0x0026;
    L_0x00e7:
        r1 = move-exception;
        goto L_0x00c4;
    L_0x00e9:
        r1 = move-exception;
        goto L_0x00dc;
    L_0x00eb:
        r0 = move-exception;
        goto L_0x00bf;
    L_0x00ed:
        r0 = move-exception;
        goto L_0x00aa;
    L_0x00ef:
        r1 = r0;
        goto L_0x0063;
    L_0x00f2:
        r3 = r0;
        goto L_0x004e;
    L_0x00f5:
        r0 = r2;
        goto L_0x00a7;
    L_0x00f7:
        r4 = r0;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.a.b(android.content.Context, com.mob.commons.MobProduct):java.lang.String");
    }

    private HashMap<String, Object> m16403c(Context context) {
        Throwable th;
        HashMap<String, Object> hashMap = new HashMap();
        ObjectOutputStream objectOutputStream = null;
        try {
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            String str = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]);
            String str2 = str == null ? BuildConfig.FLAVOR : str;
            str = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]);
            String str3 = str == null ? BuildConfig.FLAVOR : str;
            str = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]);
            String str4 = str == null ? BuildConfig.FLAVOR : str;
            str = (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]);
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("duid", Data.byteToHex(Data.SHA1(str2 + ":" + str3 + ":" + str4 + ":" + str)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("adsid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAdvertisingID", new Object[0]));
            hashMap2.put(Constants.KEY_IMEI, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]));
            hashMap2.put("serialno", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]));
            hashMap2.put("androidid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAndroidID", new Object[0]));
            hashMap2.put(PointMark.T_MAC, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
            hashMap2.put(Constants.KEY_MODEL, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
            hashMap2.put("factory", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0]));
            hashMap2.put("carrier", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
            hashMap2.put("screensize", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getScreenSize", new Object[0]));
            hashMap2.put("sysver", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionName", new Object[0]));
            hashMap2.put("plat", Integer.valueOf(1));
            hashMap.put("deviceInfo", hashMap2);
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(m16400b(context)));
            try {
                objectOutputStream2.writeObject(hashMap);
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.flush();
                        objectOutputStream2.close();
                    } catch (Throwable th2) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            MobLog.getInstance().m4388w(th);
            if (objectOutputStream != null) {
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            return hashMap;
        }
        return hashMap;
    }

    private final HashMap<String, Object> m16404c(Context context, MobProduct mobProduct) {
        int parseInt;
        Throwable th;
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
        try {
            parseInt = C4021R.parseInt((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
        } catch (Throwable th2) {
            MobLog.getInstance().m4388w(th2);
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("adsid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAdvertisingID", new Object[0]));
        hashMap.put(Constants.KEY_IMEI, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]));
        hashMap.put("serialno", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]));
        hashMap.put("androidid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAndroidID", new Object[0]));
        hashMap.put(PointMark.T_MAC, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
        hashMap.put(Constants.KEY_MODEL, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
        hashMap.put("factory", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0]));
        hashMap.put("carrier", Integer.valueOf(parseInt));
        hashMap.put("screensize", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getScreenSize", new Object[0]));
        hashMap.put("sysver", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionName", new Object[0]));
        hashMap.put("plat", Integer.valueOf(1));
        Hashon hashon = new Hashon();
        String encodeToString = Base64.encodeToString(Data.AES128Encode("sdk.commonap.sdk", hashon.fromHashMap(hashMap)), 2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("m", encodeToString));
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = 30000;
        networkTimeOut.connectionTimeout = 30000;
        HashMap fromJson = hashon.fromJson(new NetworkHelper().httpPost("http://devs.data.mob.com:80/dinfo", arrayList, null, null, networkTimeOut));
        if (fromJson == null) {
            return null;
        }
        encodeToString = (String) fromJson.get("duid");
        if (encodeToString == null || encodeToString.length() <= 0) {
            return null;
        }
        HashMap<String, Object> hashMap2 = new HashMap();
        ObjectOutputStream objectOutputStream;
        try {
            hashMap2.put("duid", encodeToString);
            hashMap.put("carrier", String.valueOf(parseInt));
            hashMap2.put("deviceInfo", hashMap);
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(m16400b(context)));
            try {
                objectOutputStream.writeObject(hashMap2);
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    MobLog.getInstance().m4388w(th2);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.flush();
                            objectOutputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    return hashMap2;
                } catch (Throwable th6) {
                    th2 = th6;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.flush();
                            objectOutputStream.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th8) {
            th2 = th8;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            throw th2;
        }
        return hashMap2;
    }

    public final String m16405a(Context context) {
        String[] strArr = new String[1];
        C3991e.m16443a(new File(C4021R.getCacheRoot(context), "comm/locks/.globalLock"), true, new C39812(this, context, strArr));
        return strArr[0];
    }

    public final String m16406a(Context context, MobProduct mobProduct) {
        String[] strArr = new String[1];
        C3991e.m16443a(new File(C4021R.getCacheRoot(context), "comm/locks/.globalLock"), true, new C39801(this, strArr, context, mobProduct));
        return strArr[0];
    }
}
