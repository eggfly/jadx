package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.p026b.C0948a;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.android.spdy.SpdyProtocol;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: cn.sharesdk.framework.f */
public class C0970f extends SSDKHandlerThread {
    private C0969a f3320a;
    private Context f3321b;
    private HashMap<String, HashMap<String, String>> f3322c;
    private ArrayList<Platform> f3323d;
    private HashMap<String, Integer> f3324e;
    private HashMap<Integer, String> f3325f;
    private HashMap<Integer, CustomPlatform> f3326g;
    private HashMap<Integer, HashMap<String, Object>> f3327h;
    private HashMap<Integer, Service> f3328i;
    private String f3329j;
    private boolean f3330k;
    private String f3331l;
    private boolean f3332m;
    private boolean f3333n;

    /* renamed from: cn.sharesdk.framework.f.1 */
    class C09671 extends Thread {
        final /* synthetic */ C0970f f3313a;

        C09671(C0970f c0970f) {
            this.f3313a = c0970f;
        }

        public void run() {
            try {
                HashMap hashMap = new HashMap();
                if (!this.f3313a.m4348d() && this.f3313a.m4334a(hashMap)) {
                    this.f3313a.m4342b(hashMap);
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4388w(th);
            }
        }
    }

    /* renamed from: cn.sharesdk.framework.f.2 */
    class C09682 extends Thread {
        final /* synthetic */ C0948a f3314a;
        final /* synthetic */ C0970f f3315b;

        C09682(C0970f c0970f, C0948a c0948a) {
            this.f3315b = c0970f;
            this.f3314a = c0948a;
        }

        public void run() {
            try {
                HashMap e = this.f3314a.m4178e();
                HashMap hashMap = new HashMap();
                if (this.f3315b.m4315a(this.f3314a, e, hashMap)) {
                    this.f3315b.m4342b(hashMap);
                }
                this.f3314a.m4172a(e);
            } catch (Throwable th) {
                C0979d.m4390a().m4388w(th);
            }
        }
    }

    /* renamed from: cn.sharesdk.framework.f.a */
    private enum C0969a {
        IDLE,
        INITIALIZING,
        READY
    }

    public C0970f(Context context, String str) {
        this.f3329j = str;
        this.f3320a = C0969a.IDLE;
        this.f3321b = context.getApplicationContext();
        this.f3322c = new HashMap();
        this.f3323d = new ArrayList();
        this.f3324e = new HashMap();
        this.f3325f = new HashMap();
        this.f3326g = new HashMap();
        this.f3327h = new HashMap();
        this.f3328i = new HashMap();
    }

    private boolean m4315a(C0948a c0948a, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        try {
            if (hashMap.containsKey(C4233j.f14375B)) {
                C0979d.m4390a().m4381i("ShareSDK parse sns config ==>>", new Hashon().fromHashMap(hashMap));
                return false;
            } else if (hashMap.containsKey(Constants.SEND_TYPE_RES)) {
                String str = (String) hashMap.get(Constants.SEND_TYPE_RES);
                if (str == null) {
                    return false;
                }
                hashMap2.putAll(c0948a.m4174b(str));
                return true;
            } else {
                C0979d.m4390a().m4375d("ShareSDK platform config result ==>>", "SNS configuration is empty");
                return false;
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            return false;
        }
    }

    private void m4317f() {
        synchronized (this.f3322c) {
            this.f3322c.clear();
            m4318g();
            if (this.f3322c.containsKey("ShareSDK")) {
                HashMap hashMap = (HashMap) this.f3322c.remove("ShareSDK");
                if (hashMap != null) {
                    if (this.f3329j == null) {
                        this.f3329j = (String) hashMap.get("AppKey");
                    }
                    this.f3331l = hashMap.containsKey("UseVersion") ? (String) hashMap.get("UseVersion") : "latest";
                }
            }
        }
    }

    private void m4318g() {
        XmlPullParser newPullParser;
        InputStream open;
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            newPullParser = newInstance.newPullParser();
            open = this.f3321b.getAssets().open("ShareSDK.xml");
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return;
        }
        newPullParser.setInput(open, "utf-8");
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                HashMap hashMap = new HashMap();
                int attributeCount = newPullParser.getAttributeCount();
                for (eventType = 0; eventType < attributeCount; eventType++) {
                    hashMap.put(newPullParser.getAttributeName(eventType), newPullParser.getAttributeValue(eventType).trim());
                }
                this.f3322c.put(name, hashMap);
            }
        }
        open.close();
    }

    private void m4319h() {
        new C09671(this).start();
    }

    private void m4320i() {
        this.f3323d.clear();
        Collection a = new C0966e(this.f3321b, this.f3329j).m4305a();
        if (a != null) {
            this.f3323d.addAll(a);
        }
        synchronized (this.f3324e) {
            synchronized (this.f3325f) {
                Iterator it = this.f3323d.iterator();
                while (it.hasNext()) {
                    Platform platform = (Platform) it.next();
                    this.f3325f.put(Integer.valueOf(platform.getPlatformId()), platform.getName());
                    this.f3324e.put(platform.getName(), Integer.valueOf(platform.getPlatformId()));
                }
            }
        }
    }

    private void m4321j() {
        C0966e c0966e = new C0966e(this.f3321b, this.f3329j);
        c0966e.m4309a(this);
        c0966e.m4308a(this.handler, this.f3330k, 68);
    }

    public Platform m4322a(String str) {
        if (str == null) {
            return null;
        }
        Platform[] a = m4335a();
        if (a == null) {
            return null;
        }
        for (Platform platform : a) {
            if (str.equals(platform.getName())) {
                return platform;
            }
        }
        return null;
    }

    public String m4323a(int i, String str) {
        String a;
        synchronized (this.f3327h) {
            a = new C0966e(this.f3321b, this.f3329j).m4301a(i, str, this.f3327h);
        }
        return a;
    }

    public String m4324a(Bitmap bitmap) {
        return C0969a.READY != this.f3320a ? null : new C0966e(this.f3321b, this.f3329j).m4302a(bitmap);
    }

    public String m4325a(String str, boolean z, int i, String str2) {
        return C0969a.READY != this.f3320a ? str : new C0966e(this.f3321b, this.f3329j).m4304a(str, z, i, str2);
    }

    public void m4326a(int i) {
        NetworkHelper.connectionTimeout = i;
    }

    public void m4327a(int i, int i2) {
        synchronized (this.f3327h) {
            new C0966e(this.f3321b, this.f3329j).m4306a(i, i2, this.f3327h);
        }
    }

    public void m4328a(int i, Platform platform) {
        new C0966e(this.f3321b, this.f3329j).m4307a(i, platform);
    }

    public void m4329a(Class<? extends Service> cls) {
        synchronized (this.f3328i) {
            if (this.f3328i.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            try {
                Service service = (Service) cls.newInstance();
                this.f3328i.put(Integer.valueOf(cls.hashCode()), service);
                service.m4070a(this.f3321b);
                service.m4071a(this.f3329j);
                service.onBind();
            } catch (Throwable th) {
                C0979d.m4390a().m4388w(th);
            }
        }
    }

    public void m4330a(String str, int i) {
        new C0966e(this.f3321b, this.f3329j).m4310a(str, i);
    }

    public void m4331a(String str, String str2) {
        synchronized (this.f3322c) {
            this.f3322c.put(str2, (HashMap) this.f3322c.get(str));
        }
    }

    public void m4332a(String str, HashMap<String, Object> hashMap) {
        synchronized (this.f3322c) {
            HashMap hashMap2 = (HashMap) this.f3322c.get(str);
            HashMap hashMap3 = hashMap2 == null ? new HashMap() : hashMap2;
            synchronized (hashMap3) {
                for (Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value != null) {
                        hashMap3.put(str2, String.valueOf(value));
                    }
                }
            }
            this.f3322c.put(str, hashMap3);
        }
        synchronized (this.f3323d) {
            if (this.f3320a == C0969a.INITIALIZING) {
                try {
                    this.f3323d.wait();
                } catch (Throwable th) {
                    C0979d.m4390a().m4388w(th);
                }
            }
            Iterator it = this.f3323d.iterator();
            while (it.hasNext()) {
                Platform platform = (Platform) it.next();
                if (platform != null && platform.getName().equals(str)) {
                    platform.m4004a();
                    break;
                }
            }
        }
    }

    public void m4333a(boolean z) {
        this.f3330k = z;
    }

    public boolean m4334a(HashMap<String, Object> hashMap) {
        if (C0969a.READY != this.f3320a) {
            C0979d.m4390a().m4375d("Statistics module unopened", new Object[0]);
            return false;
        }
        C0948a a = C0948a.m4158a(this.f3321b, this.f3329j);
        boolean a2 = m4315a(a, a.m4177d(), hashMap);
        if (a2) {
            this.f3333n = true;
            new C09682(this, a).start();
            return a2;
        }
        try {
            HashMap e = a.m4178e();
            a2 = m4315a(a, e, hashMap);
            if (a2) {
                a.m4172a(e);
            }
            this.f3333n = true;
            return a2;
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            this.f3333n = false;
            return a2;
        }
    }

    public Platform[] m4335a() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f3323d) {
            if (this.f3320a == C0969a.IDLE) {
                return null;
            }
            if (this.f3320a == C0969a.INITIALIZING) {
                try {
                    this.f3323d.wait();
                } catch (Throwable th) {
                    C0979d.m4390a().m4388w(th);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f3323d.iterator();
            while (it.hasNext()) {
                Platform platform = (Platform) it.next();
                if (platform != null && platform.m4005b()) {
                    platform.m4004a();
                    arrayList.add(platform);
                }
            }
            for (Entry value : this.f3326g.entrySet()) {
                platform = (Platform) value.getValue();
                if (platform != null && platform.m4005b()) {
                    arrayList.add(platform);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            Platform[] platformArr = new Platform[arrayList.size()];
            for (int i = 0; i < platformArr.length; i++) {
                platformArr[i] = (Platform) arrayList.get(i);
            }
            C0979d.m4390a().m4381i("sort list use time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return platformArr;
        }
    }

    public int m4336b(String str) {
        int intValue;
        synchronized (this.f3324e) {
            if (this.f3324e.containsKey(str)) {
                intValue = ((Integer) this.f3324e.get(str)).intValue();
            } else {
                intValue = 0;
            }
        }
        return intValue;
    }

    public String m4337b() {
        try {
            return new C0966e(this.f3321b, this.f3329j).m4314c();
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            return "2.7.10";
        }
    }

    public String m4338b(String str, String str2) {
        String str3;
        synchronized (this.f3322c) {
            HashMap hashMap = (HashMap) this.f3322c.get(str);
            if (hashMap == null) {
                str3 = null;
            } else {
                str3 = (String) hashMap.get(str2);
            }
        }
        return str3;
    }

    public void m4339b(int i) {
        NetworkHelper.readTimout = i;
    }

    public void m4340b(Class<? extends Service> cls) {
        synchronized (this.f3328i) {
            int hashCode = cls.hashCode();
            if (this.f3328i.containsKey(Integer.valueOf(hashCode))) {
                ((Service) this.f3328i.get(Integer.valueOf(hashCode))).onUnbind();
                this.f3328i.remove(Integer.valueOf(hashCode));
            }
        }
    }

    public void m4341b(boolean z) {
        this.f3332m = z;
    }

    public boolean m4342b(HashMap<String, Object> hashMap) {
        boolean a;
        synchronized (this.f3327h) {
            this.f3327h.clear();
            a = new C0966e(this.f3321b, this.f3329j).m4312a((HashMap) hashMap, this.f3327h);
        }
        return a;
    }

    public <T extends Service> T m4343c(Class<T> cls) {
        synchronized (this.f3328i) {
            if (this.f3320a == C0969a.IDLE) {
                return null;
            }
            if (this.f3320a == C0969a.INITIALIZING) {
                try {
                    this.f3328i.wait();
                } catch (Throwable th) {
                    C0979d.m4390a().m4388w(th);
                }
            }
            try {
                Service service = (Service) cls.cast(this.f3328i.get(Integer.valueOf(cls.hashCode())));
                return service;
            } catch (Throwable th2) {
                C0979d.m4390a().m4388w(th2);
                return null;
            }
        }
    }

    public String m4344c(int i) {
        String str;
        synchronized (this.f3325f) {
            str = (String) this.f3325f.get(Integer.valueOf(i));
        }
        return str;
    }

    public String m4345c(String str) {
        return C0969a.READY != this.f3320a ? null : new C0966e(this.f3321b, this.f3329j).m4303a(str);
    }

    public boolean m4346c() {
        return this.f3332m;
    }

    public void m4347d(Class<? extends CustomPlatform> cls) {
        synchronized (this.f3326g) {
            if (this.f3326g.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            try {
                CustomPlatform customPlatform = (CustomPlatform) cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f3321b});
                this.f3326g.put(Integer.valueOf(cls.hashCode()), customPlatform);
                synchronized (this.f3324e) {
                    synchronized (this.f3325f) {
                        if (customPlatform != null) {
                            if (customPlatform.m4005b()) {
                                this.f3325f.put(Integer.valueOf(customPlatform.getPlatformId()), customPlatform.getName());
                                this.f3324e.put(customPlatform.getName(), Integer.valueOf(customPlatform.getPlatformId()));
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4388w(th);
            }
        }
    }

    public boolean m4348d() {
        boolean z;
        synchronized (this.f3327h) {
            if (this.f3327h == null || this.f3327h.size() <= 0) {
                z = this.f3333n;
            } else {
                z = true;
            }
        }
        return z;
    }

    public void m4349e() {
        try {
            C4021R.clearCache(this.f3321b);
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
        }
    }

    public void m4350e(Class<? extends CustomPlatform> cls) {
        int hashCode = cls.hashCode();
        synchronized (this.f3326g) {
            this.f3326g.remove(Integer.valueOf(hashCode));
        }
    }

    protected void onMessage(Message message) {
        switch (message.what) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f3320a = C0969a.IDLE;
                this.handler.getLooper().quit();
            default:
        }
    }

    protected void onStart(Message message) {
        synchronized (this.f3328i) {
            synchronized (this.f3323d) {
                try {
                    Object checkRecord = EventRecorder.checkRecord("ShareSDK");
                    if (!TextUtils.isEmpty(checkRecord)) {
                        C0948a.m4158a(this.f3321b, this.f3329j).m4172a(null);
                        C0979d.m4390a().m4387w("EventRecorder checkRecord result ==" + checkRecord, new Object[0]);
                        m4349e();
                    }
                    EventRecorder.clear();
                } catch (Throwable th) {
                    this.f3320a = C0969a.READY;
                    this.f3323d.notify();
                    this.f3328i.notify();
                    C0979d.m4390a().m4388w(th);
                }
                m4320i();
                m4321j();
                this.f3320a = C0969a.READY;
                this.f3323d.notify();
                this.f3328i.notify();
                m4319h();
            }
        }
    }

    protected void onStop(Message message) {
        synchronized (this.f3328i) {
            for (Entry value : this.f3328i.entrySet()) {
                ((Service) value.getValue()).onUnbind();
            }
            this.f3328i.clear();
        }
        synchronized (this.f3326g) {
            this.f3326g.clear();
        }
        try {
            new C0966e(this.f3321b, this.f3329j).m4313b();
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            this.handler.getLooper().quit();
            this.f3320a = C0969a.IDLE;
        }
    }

    public void startThread() {
        this.f3320a = C0969a.INITIALIZING;
        C0979d.m4391a(this.f3321b, 60068, this.f3329j);
        EventRecorder.prepare(this.f3321b);
        m4317f();
        super.startThread();
    }
}
