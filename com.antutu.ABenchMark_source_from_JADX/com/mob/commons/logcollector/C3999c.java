package com.mob.commons.logcollector;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.antutu.utils.PointMark;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.sdk.PushBuildConfig;
import com.mob.tools.MobLog;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.android.agoo.message.MessageService;

/* renamed from: com.mob.commons.logcollector.c */
public class C3999c extends SSDKHandlerThread {
    private static C3999c f13366a;
    private static String f13367b;
    private HashMap<String, Integer> f13368c;
    private Context f13369d;
    private NetworkHelper f13370e;
    private C4000d f13371f;
    private File f13372g;
    private FileLocker f13373h;

    static {
        f13367b = "http://api.exc.mob.com:80";
    }

    private C3999c(Context context) {
        this.f13369d = context.getApplicationContext();
        this.f13370e = new NetworkHelper();
        this.f13371f = C4000d.m16487a(context);
        this.f13368c = new HashMap();
        this.f13373h = new FileLocker();
        this.f13372g = new File(context.getFilesDir(), ".lock");
        if (!this.f13372g.exists()) {
            try {
                this.f13372g.createNewFile();
            } catch (Throwable e) {
                MobLog.getInstance().m4388w(e);
            }
        }
        NLog.setContext(context);
        startThread();
    }

    public static synchronized C3999c m16472a(Context context) {
        C3999c c3999c;
        synchronized (C3999c.class) {
            if (f13366a == null) {
                f13366a = new C3999c(context);
            }
            c3999c = f13366a;
        }
        return c3999c;
    }

    private String m16473a(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = byteArrayInputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(toByteArray, 2);
            }
        }
    }

    private void m16474a(int i, String str, String str2, String[] strArr) {
        try {
            if (this.f13371f.m16494b()) {
                if (PushBuildConfig.sdk_conf_debug_level.equals((String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13369d), "getDetailNetworkTypeForStatic", new Object[0]))) {
                    throw new IllegalStateException("network is disconnected!");
                }
                ArrayList a = C4002f.m16503a(this.f13369d, strArr);
                for (int i2 = 0; i2 < a.size(); i2++) {
                    C4001e c4001e = (C4001e) a.get(i2);
                    HashMap c = m16481c(i, str, str2);
                    c.put("errmsg", c4001e.f13376a);
                    if (m16476a(m16473a(new Hashon().fromHashMap(c)), true)) {
                        C4002f.m16501a(this.f13369d, c4001e.f13377b);
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4382i(th);
        }
    }

    private void m16475a(Message message) {
        this.handler.sendMessageDelayed(message, 1000);
    }

    private boolean m16476a(String str, boolean z) {
        try {
            if (PushBuildConfig.sdk_conf_debug_level.equals((String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13369d), "getDetailNetworkTypeForStatic", new Object[0]))) {
                throw new IllegalStateException("network is disconnected!");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair("m", str));
            NetworkTimeOut networkTimeOut = new NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 10000;
            this.f13370e.httpPost(m16480c(), arrayList, null, null, networkTimeOut);
            return true;
        } catch (Throwable th) {
            MobLog.getInstance().m4382i(th);
            return false;
        }
    }

    private String m16477b() {
        return f13367b + "/errconf";
    }

    private void m16478b(int i, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13369d);
        arrayList.add(new KVPair("key", str2));
        arrayList.add(new KVPair("sdk", str));
        arrayList.add(new KVPair("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]))));
        arrayList.add(new KVPair("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersion", new Object[0]))));
        arrayList.add(new KVPair("sdkver", String.valueOf(i)));
        arrayList.add(new KVPair("plat", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPlatformCode", new Object[0]))));
        try {
            NetworkTimeOut networkTimeOut = new NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 10000;
            MobLog.getInstance().m4381i("get server config == %s", this.f13370e.httpPost(m16477b(), arrayList, null, null, networkTimeOut));
            HashMap fromJson = new Hashon().fromJson(r0);
            if ("-200".equals(String.valueOf(fromJson.get(MsgConstant.KEY_STATUS)))) {
                MobLog.getInstance().m4381i("error log server config response fail !!", new Object[0]);
                return;
            }
            invokeStaticMethod = fromJson.get("result");
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof HashMap)) {
                HashMap hashMap;
                fromJson = (HashMap) invokeStaticMethod;
                if (fromJson.containsKey("timestamp")) {
                    this.f13371f.m16490a(System.currentTimeMillis() - C4021R.parseLong(String.valueOf(fromJson.get("timestamp"))));
                }
                if (MessageService.MSG_DB_NOTIFY_REACHED.equals(String.valueOf(fromJson.get("enable")))) {
                    this.f13371f.m16492a(true);
                } else {
                    this.f13371f.m16492a(false);
                }
                Object obj = fromJson.get("upconf");
                if (obj != null && (obj instanceof HashMap)) {
                    hashMap = (HashMap) obj;
                    String valueOf = String.valueOf(hashMap.get("crash"));
                    String valueOf2 = String.valueOf(hashMap.get("sdkerr"));
                    String valueOf3 = String.valueOf(hashMap.get("apperr"));
                    this.f13371f.m16489a(Integer.parseInt(valueOf));
                    this.f13371f.m16493b(Integer.parseInt(valueOf2));
                    this.f13371f.m16496c(Integer.parseInt(valueOf3));
                }
                if (fromJson.containsKey("requesthost") && fromJson.containsKey("requestport")) {
                    obj = String.valueOf(fromJson.get("requesthost"));
                    Object valueOf4 = String.valueOf(fromJson.get("requestport"));
                    if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(valueOf4))) {
                        f13367b = "http://" + obj + ":" + valueOf4;
                    }
                }
                invokeStaticMethod = fromJson.get("filter");
                if (invokeStaticMethod != null && (invokeStaticMethod instanceof ArrayList)) {
                    ArrayList arrayList2 = (ArrayList) invokeStaticMethod;
                    if (arrayList2.size() > 0) {
                        hashMap = new HashMap();
                        hashMap.put("fakelist", arrayList2);
                        this.f13371f.m16491a(new Hashon().fromHashMap(hashMap));
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
        }
    }

    private void m16479b(Message message) {
        try {
            int i = message.arg1;
            Object[] objArr = (Object[]) message.obj;
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            m16478b(i, str, str2);
            m16474a(i, str, str2, null);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }

    private String m16480c() {
        return f13367b + "/errlog";
    }

    private HashMap<String, Object> m16481c(int i, String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap();
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13369d);
        hashMap.put("key", str2);
        hashMap.put("plat", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPlatformCode", new Object[0]));
        hashMap.put("sdk", str);
        hashMap.put("sdkver", Integer.valueOf(i));
        hashMap.put("appname", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppName", new Object[0]));
        hashMap.put("apppkg", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]));
        hashMap.put("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersion", new Object[0])));
        hashMap.put("deviceid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDeviceKey", new Object[0]));
        hashMap.put(Constants.KEY_MODEL, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
        hashMap.put(PointMark.T_MAC, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
        hashMap.put("udid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDeviceId", new Object[0]));
        hashMap.put("sysver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionInt", new Object[0])));
        hashMap.put("networktype", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]));
        return hashMap;
    }

    private void m16482c(Message message) {
        int c;
        String MD5;
        try {
            int i = message.arg1;
            Object[] objArr = (Object[]) message.obj;
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            String str3 = (String) objArr[2];
            int i2 = 1;
            if (message.arg2 == 0) {
                i2 = 2;
            } else if (message.arg2 == 2) {
                i2 = 1;
            }
            String f = this.f13371f.m16499f();
            if (!TextUtils.isEmpty(f)) {
                ArrayList arrayList = (ArrayList) new Hashon().fromJson(f).get("fakelist");
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        f = (String) it.next();
                        if (!TextUtils.isEmpty(f) && str3.contains(f)) {
                            return;
                        }
                    }
                }
            }
            c = this.f13371f.m16495c();
            int d = this.f13371f.m16497d();
            int e = this.f13371f.m16498e();
            if (3 != i2 || -1 != e) {
                if (1 != i2 || -1 != c) {
                    if (2 != i2 || -1 != d) {
                        MD5 = Data.MD5(str3);
                        this.f13373h.setLockFile(this.f13372g.getAbsolutePath());
                        if (this.f13373h.lock(false)) {
                            C4002f.m16500a(this.f13369d, System.currentTimeMillis() - this.f13371f.m16488a(), str3, i2, MD5);
                        }
                        this.f13373h.release();
                        this.f13368c.remove(MD5);
                        if (3 == i2 && 1 == e) {
                            m16474a(i, str, str2, new String[]{String.valueOf(3)});
                        } else if (1 == i2 && 1 == c) {
                            m16474a(i, str, str2, new String[]{String.valueOf(1)});
                        } else if (2 == i2 && 1 == d) {
                            m16474a(i, str, str2, new String[]{String.valueOf(2)});
                        }
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }

    public Context m16483a() {
        return this.f13369d;
    }

    public void m16484a(int i, int i2, String str, String str2, String str3) {
        Message message = new Message();
        message.what = Constants.COMMAND_RECEIVE_DATA;
        message.arg1 = i;
        message.arg2 = i2;
        message.obj = new Object[]{str, str2, str3};
        this.handler.sendMessage(message);
    }

    public void m16485a(int i, String str, String str2) {
        Message message = new Message();
        message.what = 100;
        message.arg1 = i;
        message.obj = new Object[]{str, str2};
        this.handler.sendMessage(message);
    }

    public void m16486b(int i, int i2, String str, String str2, String str3) {
        m16484a(i, i2, str, str2, str3);
        try {
            this.handler.wait();
        } catch (Throwable th) {
        }
    }

    protected void onMessage(Message message) {
        switch (message.what) {
            case Constants.COMMAND_SEND_DATA /*100*/:
                m16479b(message);
            case Constants.COMMAND_RECEIVE_DATA /*101*/:
                m16482c(message);
            default:
        }
    }
}
