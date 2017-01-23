package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;

/* renamed from: cn.sharesdk.framework.c */
public class C0962c {
    private Platform f3296a;
    private Context f3297b;
    private PlatformDb f3298c;
    private C0933a f3299d;
    private int f3300e;
    private int f3301f;
    private boolean f3302g;
    private boolean f3303h;
    private boolean f3304i;

    /* renamed from: cn.sharesdk.framework.c.1 */
    class C09601 extends Thread {
        final /* synthetic */ int f3291a;
        final /* synthetic */ Object f3292b;
        final /* synthetic */ C0962c f3293c;

        C09601(C0962c c0962c, int i, Object obj) {
            this.f3293c = c0962c;
            this.f3291a = i;
            this.f3292b = obj;
        }

        public void run() {
            try {
                this.f3293c.m4269j();
                if (this.f3293c.f3296a.checkAuthorize(this.f3291a, this.f3292b)) {
                    this.f3293c.m4285b(this.f3291a, this.f3292b);
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4388w(th);
            }
        }
    }

    /* renamed from: cn.sharesdk.framework.c.2 */
    class C09612 extends Thread {
        final /* synthetic */ String[] f3294a;
        final /* synthetic */ C0962c f3295b;

        C09612(C0962c c0962c, String[] strArr) {
            this.f3295b = c0962c;
            this.f3294a = strArr;
        }

        public void run() {
            try {
                this.f3295b.m4269j();
                this.f3295b.f3296a.doAuthorize(this.f3294a);
            } catch (Throwable th) {
                C0979d.m4390a().m4388w(th);
            }
        }
    }

    public C0962c(Platform platform, Context context) {
        this.f3303h = true;
        this.f3296a = platform;
        this.f3297b = context;
        String name = platform.getName();
        this.f3298c = new PlatformDb(context, name, platform.getVersion());
        m4279a(name);
        this.f3299d = new C0933a();
    }

    private boolean m4269j() {
        boolean z = false;
        String a;
        if (ShareSDK.m4078a()) {
            a = m4272a(this.f3296a.getPlatformId(), "covert_url", null);
            if (a != null) {
                a.trim();
            }
            if (!"false".equals(a)) {
                z = true;
            }
            this.f3303h = z;
            this.f3296a.setNetworkDevinfo();
            return true;
        }
        try {
            HashMap hashMap = new HashMap();
            if (!ShareSDK.m4079a(hashMap)) {
                return false;
            }
            if (ShareSDK.m4082b(hashMap)) {
                a = m4272a(this.f3296a.getPlatformId(), "covert_url", null);
                if (a != null) {
                    a.trim();
                }
                this.f3303h = !"false".equals(a);
                this.f3296a.setNetworkDevinfo();
                return true;
            }
            C0979d.m4390a().m4381i("Failed to parse network dev-info: " + new Hashon().fromHashMap(hashMap), new Object[0]);
            return false;
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            return false;
        }
    }

    private String m4270k() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if ("TencentWeibo".equals(this.f3296a.getName())) {
                C0979d.m4390a().m4381i("user id %s ==>>", m4294g().getUserName());
                stringBuilder.append(Data.urlEncode(m4294g().getUserName(), "utf-8"));
            } else {
                stringBuilder.append(Data.urlEncode(m4294g().getUserId(), "utf-8"));
            }
            stringBuilder.append("|").append(Data.urlEncode(m4294g().get("secretType"), "utf-8"));
            stringBuilder.append("|").append(Data.urlEncode(m4294g().get("gender"), "utf-8"));
            stringBuilder.append("|").append(Data.urlEncode(m4294g().get("birthday"), "utf-8"));
            stringBuilder.append("|").append(Data.urlEncode(m4294g().get("educationJSONArrayStr"), "utf-8"));
            stringBuilder.append("|").append(Data.urlEncode(m4294g().get("workJSONArrayStr"), "utf-8"));
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
        }
        return stringBuilder.toString();
    }

    public int m4271a() {
        return this.f3300e;
    }

    public String m4272a(int i, String str, String str2) {
        Object a = ShareSDK.m4072a(i, str);
        return (TextUtils.isEmpty(a) || "null".equals(a)) ? this.f3296a.getDevinfo(this.f3296a.getName(), str2) : a;
    }

    public String m4273a(Bitmap bitmap) {
        return ShareSDK.m4073a(bitmap);
    }

    public String m4274a(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f3303h) {
            C0979d.m4390a().m4381i("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return str;
        } else if (TextUtils.isEmpty(str)) {
            C0979d.m4390a().m4381i("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return str;
        } else {
            str = ShareSDK.m4075a(str, z, this.f3296a.getPlatformId(), m4270k());
            C0979d.m4390a().m4381i("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return str;
        }
    }

    public void m4275a(int i, int i2, String str) {
        m4288c(2, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    public void m4276a(int i, Object obj) {
        this.f3299d.m4105a(this.f3296a, i, obj);
    }

    public void m4277a(ShareParams shareParams) {
        if (shareParams != null) {
            m4288c(9, shareParams);
        } else if (this.f3299d != null) {
            this.f3299d.onError(this.f3296a, 9, new NullPointerException());
        }
    }

    public void m4278a(PlatformActionListener platformActionListener) {
        this.f3299d.m4107a(platformActionListener);
    }

    public void m4279a(String str) {
        try {
            this.f3300e = C4021R.parseInt(String.valueOf(ShareSDK.m4080b(str, "Id")).trim());
        } catch (Throwable th) {
            if (!(this.f3296a instanceof CustomPlatform)) {
                C0979d.m4390a().m4375d(this.f3296a.getName() + " failed to parse Id, this will cause method getId() always returens 0", new Object[0]);
            }
        }
        try {
            this.f3301f = C4021R.parseInt(String.valueOf(ShareSDK.m4080b(str, "SortId")).trim());
        } catch (Throwable th2) {
            if (!(this.f3296a instanceof CustomPlatform)) {
                C0979d.m4390a().m4375d(this.f3296a.getName() + " failed to parse SortId, this won't cause any problem, don't worry", new Object[0]);
            }
        }
        String b = ShareSDK.m4080b(str, "Enable");
        if (b == null) {
            this.f3304i = true;
            if (!(this.f3296a instanceof CustomPlatform)) {
                C0979d.m4390a().m4375d(this.f3296a.getName() + " failed to parse Enable, this will cause platform always be enable", new Object[0]);
            }
        } else {
            this.f3304i = "true".equals(b.trim());
        }
        this.f3296a.initDevInfo(str);
    }

    public void m4280a(String str, int i, int i2) {
        m4288c(7, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    public void m4281a(String str, String str2, short s, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        m4288c(655360 | s, new Object[]{str, str2, hashMap, hashMap2});
    }

    public void m4282a(boolean z) {
        this.f3302g = z;
    }

    public void m4283a(String[] strArr) {
        new C09612(this, strArr).start();
    }

    public int m4284b() {
        return this.f3301f;
    }

    protected void m4285b(int i, Object obj) {
        Object[] objArr;
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (this.f3299d != null) {
                    this.f3299d.onComplete(this.f3296a, 1, null);
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                objArr = (Object[]) obj;
                this.f3296a.getFriendList(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), (String) objArr[2]);
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                this.f3296a.follow((String) obj);
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                objArr = (Object[]) obj;
                this.f3296a.timeline(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), (String) objArr[2]);
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                this.f3296a.userInfor(obj == null ? null : (String) obj);
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                ShareParams shareParams = (ShareParams) obj;
                HashMap toMap = shareParams.toMap();
                for (Field field : shareParams.getClass().getFields()) {
                    if (toMap.get(field.getName()) == null) {
                        Object obj2;
                        field.setAccessible(true);
                        try {
                            obj2 = field.get(shareParams);
                        } catch (Throwable th) {
                            C0979d.m4390a().m4388w(th);
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            toMap.put(field.getName(), obj2);
                        }
                    }
                }
                if (this.f3299d instanceof C0933a) {
                    this.f3299d.m4106a(this.f3296a, shareParams);
                }
                this.f3296a.doShare(shareParams);
            default:
                objArr = (Object[]) obj;
                this.f3296a.doCustomerProtocol(String.valueOf(objArr[0]), String.valueOf(objArr[1]), i, (HashMap) objArr[2], (HashMap) objArr[3]);
        }
    }

    public void m4286b(String str) {
        m4288c(6, str);
    }

    public PlatformActionListener m4287c() {
        return this.f3299d.m4104a();
    }

    protected void m4288c(int i, Object obj) {
        new C09601(this, i, obj).start();
    }

    public void m4289c(String str) {
        m4288c(8, str);
    }

    public String m4290d(String str) {
        return ShareSDK.m4074a(str);
    }

    public boolean m4291d() {
        return this.f3298c.isValid();
    }

    public boolean m4292e() {
        return this.f3302g;
    }

    public boolean m4293f() {
        return this.f3304i;
    }

    public PlatformDb m4294g() {
        return this.f3298c;
    }

    public void m4295h() {
        this.f3298c.removeAccount();
    }

    protected PlatformActionListener m4296i() {
        return this.f3299d;
    }
}
