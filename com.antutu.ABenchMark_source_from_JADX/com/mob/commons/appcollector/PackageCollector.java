package com.mob.commons.appcollector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.mob.commons.C3972a;
import com.mob.commons.C3986c;
import com.mob.commons.C3991e;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4209a;
import com.umeng.message.proguard.C4233j;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class PackageCollector {
    private static PackageCollector f13316b;
    private final String[] f13317a;
    private Context f13318c;
    private Hashon f13319d;
    private Handler f13320e;

    /* renamed from: com.mob.commons.appcollector.PackageCollector.1 */
    class C39741 extends MobHandlerThread {
        final /* synthetic */ PackageCollector f13313a;

        /* renamed from: com.mob.commons.appcollector.PackageCollector.1.1 */
        class C39731 implements Runnable {
            final /* synthetic */ C39741 f13312a;

            C39731(C39741 c39741) {
                this.f13312a = c39741;
            }

            public void run() {
                if (C3972a.m16344d(this.f13312a.f13313a.f13318c)) {
                    this.f13312a.f13313a.m16371b();
                }
                this.f13312a.f13313a.m16378e();
                this.f13312a.m16361a();
            }
        }

        C39741(PackageCollector packageCollector) {
            this.f13313a = packageCollector;
        }

        private void m16361a() {
            super.run();
        }

        public void run() {
            C3991e.m16442a(new File(C4021R.getCacheRoot(this.f13313a.f13318c), "comm/locks/.pkg_lock"), new C39731(this));
        }
    }

    /* renamed from: com.mob.commons.appcollector.PackageCollector.2 */
    class C39752 implements Callback {
        final /* synthetic */ PackageCollector f13314a;

        C39752(PackageCollector packageCollector) {
            this.f13314a = packageCollector;
        }

        public boolean handleMessage(Message message) {
            this.f13314a.m16379f();
            return false;
        }
    }

    /* renamed from: com.mob.commons.appcollector.PackageCollector.3 */
    class C39763 extends BroadcastReceiver {
        final /* synthetic */ PackageCollector f13315a;

        C39763(PackageCollector packageCollector) {
            this.f13315a = packageCollector;
        }

        public void onReceive(Context context, Intent intent) {
            String str = null;
            if (intent != null) {
                str = intent.getAction();
            }
            if (this.f13315a.m16370a(str) && this.f13315a.f13320e != null) {
                this.f13315a.f13320e.removeMessages(1);
                this.f13315a.f13320e.sendEmptyMessageDelayed(1, 5000);
            }
        }
    }

    private PackageCollector(Context context) {
        this.f13317a = new String[]{"android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED"};
        this.f13318c = context.getApplicationContext();
        this.f13319d = new Hashon();
    }

    private ArrayList<HashMap<String, String>> m16364a(ArrayList<HashMap<String, String>> arrayList, ArrayList<HashMap<String, String>> arrayList2) {
        ArrayList<HashMap<String, String>> arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HashMap hashMap = (HashMap) it.next();
            String str = (String) hashMap.get(Constants.KEY_ELECTION_PKG);
            if (!TextUtils.isEmpty(str)) {
                Object obj;
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (str.equals(((HashMap) it2.next()).get(Constants.KEY_ELECTION_PKG))) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    arrayList3.add(hashMap);
                }
            }
        }
        return arrayList3;
    }

    private void m16365a() {
        MobHandlerThread c39741 = new C39741(this);
        c39741.start();
        this.f13320e = new Handler(c39741.getLooper(), new C39752(this));
    }

    private void m16366a(long j) {
        File file = new File(C4021R.getCacheRoot(this.f13318c), "comm/dbs/.nulal");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeLong(j);
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
        }
    }

    private void m16367a(long j, String str, ArrayList<HashMap<String, String>> arrayList) {
        HashMap hashMap = new HashMap();
        hashMap.put(C4233j.f14402y, str);
        hashMap.put("list", arrayList);
        hashMap.put("datetime", Long.valueOf(C3972a.m16336a(this.f13318c)));
        C3986c.m16412a(this.f13318c).m16425a(j, hashMap);
    }

    private void m16368a(ArrayList<HashMap<String, String>> arrayList) {
        File file = new File(C4021R.getCacheRoot(this.f13318c), "comm/dbs/.al");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(file)), "utf-8");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                outputStreamWriter.append(this.f13319d.fromHashMap((HashMap) it.next())).append('\n');
            }
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
        }
    }

    private boolean m16370a(String str) {
        for (String equals : this.f13317a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void m16371b() {
        ArrayList c = m16373c();
        if (c == null || c.isEmpty()) {
            try {
                Object[] objArr = new Object[]{Boolean.valueOf(false)};
                c = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13318c), "getInstalledApp", objArr);
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
                c = new ArrayList();
            }
            m16367a(C3972a.m16353m(this.f13318c), "APPS_ALL", c);
            m16368a(c);
            m16366a(C3972a.m16336a(this.f13318c) + (C3972a.m16345e(this.f13318c) * 1000));
            return;
        }
        long a = C3972a.m16336a(this.f13318c);
        if (a >= m16375d()) {
            try {
                Object[] objArr2 = new Object[]{Boolean.valueOf(false)};
                c = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13318c), "getInstalledApp", objArr2);
            } catch (Throwable th2) {
                MobLog.getInstance().m4388w(th2);
                c = new ArrayList();
            }
            m16367a(C3972a.m16353m(this.f13318c), "APPS_ALL", c);
            m16368a(c);
            m16366a((C3972a.m16345e(this.f13318c) * 1000) + a);
            return;
        }
        m16379f();
    }

    private ArrayList<HashMap<String, String>> m16373c() {
        File file = new File(C4021R.getCacheRoot(this.f13318c), "comm/dbs/.al");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            try {
                ArrayList<HashMap<String, String>> arrayList = new ArrayList();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(file)), "utf-8"));
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    HashMap fromJson = this.f13319d.fromJson(readLine);
                    if (fromJson != null) {
                        arrayList.add(fromJson);
                    }
                }
                bufferedReader.close();
                return arrayList;
            } catch (Throwable th) {
                MobLog.getInstance().m4376d(th);
            }
        }
        return new ArrayList();
    }

    private long m16375d() {
        File file = new File(C4021R.getCacheRoot(this.f13318c), "comm/dbs/.nulal");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                long readLong = dataInputStream.readLong();
                dataInputStream.close();
                return readLong;
            } catch (Throwable th) {
                MobLog.getInstance().m4376d(th);
            }
        }
        return 0;
    }

    private void m16378e() {
        IntentFilter intentFilter = new IntentFilter();
        for (String addAction : f13316b.f13317a) {
            intentFilter.addAction(addAction);
        }
        intentFilter.addDataScheme(C4209a.f14200c);
        this.f13318c.registerReceiver(new C39763(this), intentFilter);
    }

    private void m16379f() {
        ArrayList arrayList;
        ArrayList c = m16373c();
        try {
            Object[] objArr = new Object[]{Boolean.valueOf(false)};
            arrayList = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13318c), "getInstalledApp", objArr);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            arrayList = new ArrayList();
        }
        if (c == null || c.isEmpty()) {
            m16367a(C3972a.m16353m(this.f13318c), "APPS_ALL", arrayList);
            m16368a(arrayList);
            m16366a(C3972a.m16336a(this.f13318c) + (C3972a.m16345e(this.f13318c) * 1000));
            return;
        }
        ArrayList a = m16364a(arrayList, c);
        if (!a.isEmpty()) {
            m16367a(C3972a.m16336a(this.f13318c), "APPS_INCR", a);
        }
        c = m16364a(c, arrayList);
        if (!c.isEmpty()) {
            m16367a(C3972a.m16336a(this.f13318c), "UNINSTALL", c);
        }
        m16368a(arrayList);
        m16366a(C3972a.m16336a(this.f13318c) + (C3972a.m16345e(this.f13318c) * 1000));
    }

    public static synchronized boolean register(Context context, String str) {
        synchronized (PackageCollector.class) {
            startCollector(context);
        }
        return true;
    }

    public static synchronized void startCollector(Context context) {
        synchronized (PackageCollector.class) {
            if (f13316b == null) {
                f13316b = new PackageCollector(context);
                f13316b.m16365a();
            }
        }
    }
}
