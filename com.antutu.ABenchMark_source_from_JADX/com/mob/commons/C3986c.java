package com.mob.commons;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.antutu.utils.PointMark;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.sdk.PushBuildConfig;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.SQLiteHelper;
import com.mob.tools.utils.SQLiteHelper.SingleTableDB;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.umeng.message.proguard.C4233j;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.mob.commons.c */
public class C3986c implements Callback {
    private static C3986c f13342a;
    private Context f13343b;
    private Handler f13344c;
    private SingleTableDB f13345d;
    private Hashon f13346e;
    private Random f13347f;

    /* renamed from: com.mob.commons.c.1 */
    class C39841 implements Runnable {
        final /* synthetic */ long f13338a;
        final /* synthetic */ HashMap f13339b;
        final /* synthetic */ C3986c f13340c;

        C39841(C3986c c3986c, long j, HashMap hashMap) {
            this.f13340c = c3986c;
            this.f13338a = j;
            this.f13339b = hashMap;
        }

        public void run() {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C4233j.f14377D, String.valueOf(this.f13338a));
                contentValues.put(Constants.KEY_DATA, Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.valueOf(ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13340c.f13343b), "getManufacturer", new Object[0]))), this.f13340c.f13346e.fromHashMap(this.f13339b).getBytes("utf-8")), 2));
                SQLiteHelper.insert(this.f13340c.f13345d, contentValues);
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
    }

    /* renamed from: com.mob.commons.c.2 */
    class C39852 implements Runnable {
        final /* synthetic */ C3986c f13341a;

        C39852(C3986c c3986c) {
            this.f13341a = c3986c;
        }

        public void run() {
            ArrayList d = this.f13341a.m16419b();
            if (d.size() > 0 && this.f13341a.m16416a(d)) {
                this.f13341a.m16422b(d);
            }
        }
    }

    private C3986c(Context context) {
        this.f13343b = context.getApplicationContext();
        this.f13346e = new Hashon();
        this.f13347f = new Random();
        MobHandlerThread mobHandlerThread = new MobHandlerThread();
        mobHandlerThread.start();
        this.f13344c = new Handler(mobHandlerThread.getLooper(), this);
        File file = new File(C4021R.getCacheRoot(context), "comm/dbs/.dh");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        this.f13345d = SQLiteHelper.getDatabase(file.getAbsolutePath(), "DataHeap_1");
        this.f13345d.addField(C4233j.f14377D, "text", true);
        this.f13345d.addField(Constants.KEY_DATA, "text", true);
        this.f13344c.sendEmptyMessage(1);
    }

    public static synchronized C3986c m16412a(Context context) {
        C3986c c3986c;
        synchronized (C3986c.class) {
            if (f13342a == null) {
                f13342a = new C3986c(context);
            }
            c3986c = f13342a;
        }
        return c3986c;
    }

    private String m16413a(String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeLong(this.f13347f.nextLong());
        dataOutputStream.writeLong(this.f13347f.nextLong());
        dataOutputStream.flush();
        dataOutputStream.close();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
        gZIPOutputStream.write(str.getBytes("utf-8"));
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        byte[] AES128Encode = Data.AES128Encode(toByteArray, byteArrayOutputStream2.toByteArray());
        toByteArray = new MobRSA(IXAdIOUtils.BUFFER_SIZE).encode(toByteArray, new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
        OutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream3);
        dataOutputStream2.writeInt(toByteArray.length);
        dataOutputStream2.write(toByteArray);
        dataOutputStream2.writeInt(AES128Encode.length);
        dataOutputStream2.write(AES128Encode);
        dataOutputStream2.flush();
        dataOutputStream2.close();
        return Base64.encodeToString(byteArrayOutputStream3.toByteArray(), 2);
    }

    private void m16414a() {
        Object obj;
        try {
            obj = (String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13343b), "getNetworkType", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            obj = null;
        }
        if (obj != null && !PushBuildConfig.sdk_conf_debug_level.equals(obj)) {
            C3991e.m16443a(new File(C4021R.getCacheRoot(this.f13343b), "comm/locks/.dhlock"), true, new C39852(this));
        }
    }

    private boolean m16416a(ArrayList<String[]> arrayList) {
        try {
            C3983b a = C3983b.m16407a(this.f13343b);
            ArrayList a2 = a.m16409a();
            if (a2.isEmpty()) {
                return false;
            }
            HashMap hashMap = new HashMap();
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13343b);
            hashMap.put("plat", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPlatformCode", new Object[0]));
            hashMap.put("device", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDeviceKey", new Object[0]));
            hashMap.put(PointMark.T_MAC, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
            hashMap.put(Constants.KEY_MODEL, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
            hashMap.put("duid", DeviceAuthorizer.authorize(this.f13343b, null));
            hashMap.put(Constants.KEY_IMEI, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getIMEI", new Object[0]));
            hashMap.put("serialno", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSerialno", new Object[0]));
            hashMap.put("networktype", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]));
            ArrayList arrayList2 = new ArrayList();
            byte[] rawMD5 = Data.rawMD5(String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getManufacturer", new Object[0])));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(this.f13346e.fromJson(new String(Data.AES128Decode(rawMD5, Base64.decode(((String[]) it.next())[1], 2)), "utf-8").trim()));
            }
            hashMap.put("datas", arrayList2);
            arrayList2 = new ArrayList();
            arrayList2.add(new KVPair(C4209a.f14204g, ((MobProduct) a2.get(0)).getProductAppkey()));
            arrayList2.add(new KVPair("m", m16413a(this.f13346e.fromHashMap(hashMap))));
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(new KVPair("User-Identity", a.m16408a(a2)));
            NetworkTimeOut networkTimeOut = new NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            boolean equals = "200".equals(String.valueOf(this.f13346e.fromJson(a.httpPost(C3986c.m16418b(this.f13343b), arrayList2, null, arrayList3, networkTimeOut)).get(MsgConstant.KEY_STATUS)));
            if (equals) {
                return equals;
            }
            C3996f.m16462e(this.f13343b, null);
            return equals;
        } catch (Throwable th) {
            C3996f.m16462e(this.f13343b, null);
            MobLog.getInstance().m4388w(th);
            return false;
        }
    }

    private static String m16418b(Context context) {
        Object obj = null;
        try {
            obj = C3996f.m16463f(context);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
        return TextUtils.isEmpty(obj) ? "http://c.data.mob.com/v2/cdata" : obj;
    }

    private ArrayList<String[]> m16419b() {
        ArrayList<String[]> arrayList = new ArrayList();
        try {
            Cursor query = SQLiteHelper.query(this.f13345d, new String[]{C4233j.f14377D, Constants.KEY_DATA}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    long a = C3972a.m16336a(this.f13343b);
                    do {
                        Object obj = new String[]{query.getString(0), query.getString(1)};
                        long j = -1;
                        try {
                            j = Long.parseLong(obj[0]);
                        } catch (Throwable th) {
                        }
                        if (j <= a) {
                            arrayList.add(obj);
                        }
                    } while (query.moveToNext());
                }
                query.close();
            }
        } catch (Throwable th2) {
            MobLog.getInstance().m4388w(th2);
        }
        return arrayList;
    }

    private void m16420b(long j, HashMap<String, Object> hashMap) {
        C3991e.m16443a(new File(C4021R.getCacheRoot(this.f13343b), "comm/locks/.dhlock"), true, new C39841(this, j, hashMap));
    }

    private void m16422b(ArrayList<String[]> arrayList) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] strArr = (String[]) it.next();
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append('\'').append(strArr[0]).append('\'');
            }
            SQLiteHelper.delete(this.f13345d, "time in (" + stringBuilder.toString() + C4233j.f14397t, null);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }

    public synchronized void m16425a(long j, HashMap<String, Object> hashMap) {
        Message message = new Message();
        message.what = 2;
        message.obj = new Object[]{Long.valueOf(j), hashMap};
        this.f13344c.sendMessage(message);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m16414a();
                this.f13344c.sendEmptyMessageDelayed(1, 10000);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                Object[] objArr = (Object[]) message.obj;
                long longValue = ((Long) C4021R.forceCast(objArr[0], Long.valueOf(-1))).longValue();
                if (longValue > 0) {
                    m16420b(longValue, (HashMap) objArr[1]);
                    break;
                }
                break;
        }
        return false;
    }
}
