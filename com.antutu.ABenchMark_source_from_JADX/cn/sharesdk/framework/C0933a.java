package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.p026b.C0959d;
import cn.sharesdk.framework.p026b.p028b.C0949c;
import cn.sharesdk.framework.p026b.p028b.C0951b;
import cn.sharesdk.framework.p026b.p028b.C0955f;
import cn.sharesdk.framework.p026b.p028b.C0955f.C0954a;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;

/* renamed from: cn.sharesdk.framework.a */
public class C0933a implements PlatformActionListener {
    private PlatformActionListener f3184a;
    private HashMap<Platform, ShareParams> f3185b;

    /* renamed from: cn.sharesdk.framework.a.1 */
    class C09301 implements PlatformActionListener {
        final /* synthetic */ PlatformActionListener f3175a;
        final /* synthetic */ int f3176b;
        final /* synthetic */ HashMap f3177c;
        final /* synthetic */ C0933a f3178d;

        C09301(C0933a c0933a, PlatformActionListener platformActionListener, int i, HashMap hashMap) {
            this.f3178d = c0933a;
            this.f3175a = platformActionListener;
            this.f3176b = i;
            this.f3177c = hashMap;
        }

        public void onCancel(Platform platform, int i) {
            this.f3178d.f3184a = this.f3175a;
            if (this.f3178d.f3184a != null) {
                this.f3178d.f3184a.onComplete(platform, this.f3176b, this.f3177c);
                this.f3178d.f3184a = null;
            }
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            this.f3178d.f3184a = this.f3175a;
            if (this.f3178d.f3184a != null) {
                this.f3178d.f3184a.onComplete(platform, this.f3176b, this.f3177c);
                if (!"Wechat".equals(platform.getName())) {
                    this.f3178d.f3184a = null;
                }
            }
            C0949c c0951b = new C0951b();
            c0951b.f3236a = platform.getPlatformId();
            c0951b.f3237b = "TencentWeibo".equals(platform.getName()) ? platform.getDb().get("name") : platform.getDb().getUserId();
            c0951b.f3238c = new Hashon().fromHashMap(hashMap);
            c0951b.f3239d = this.f3178d.m4096a(platform);
            C0959d a = C0959d.m4258a(platform.getContext(), c0951b.g);
            if (a != null) {
                a.m4265a(c0951b);
            }
            this.f3178d.m4099a(1, platform);
        }

        public void onError(Platform platform, int i, Throwable th) {
            C0979d.m4390a().m4388w(th);
            this.f3178d.f3184a = this.f3175a;
            if (this.f3178d.f3184a != null) {
                this.f3178d.f3184a.onComplete(platform, this.f3176b, this.f3177c);
                this.f3178d.f3184a = null;
            }
        }
    }

    /* renamed from: cn.sharesdk.framework.a.2 */
    class C09312 implements PlatformActionListener {
        final /* synthetic */ PlatformActionListener f3179a;
        final /* synthetic */ int f3180b;
        final /* synthetic */ Object f3181c;
        final /* synthetic */ C0933a f3182d;

        C09312(C0933a c0933a, PlatformActionListener platformActionListener, int i, Object obj) {
            this.f3182d = c0933a;
            this.f3179a = platformActionListener;
            this.f3180b = i;
            this.f3181c = obj;
        }

        public void onCancel(Platform platform, int i) {
            this.f3182d.f3184a = this.f3179a;
            if (this.f3182d.f3184a != null) {
                this.f3182d.f3184a.onCancel(platform, this.f3180b);
                this.f3182d.f3184a = null;
            }
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            this.f3182d.f3184a = this.f3179a;
            platform.afterRegister(this.f3180b, this.f3181c);
        }

        public void onError(Platform platform, int i, Throwable th) {
            this.f3182d.f3184a = this.f3179a;
            if (this.f3182d.f3184a != null) {
                this.f3182d.f3184a.onError(platform, i, th);
                this.f3182d.f3184a = null;
            }
        }
    }

    C0933a() {
        this.f3185b = new HashMap();
    }

    private String m4096a(Platform platform) {
        try {
            return m4097a(platform.getDb(), new String[]{"nickname", "icon", "gender", "snsUserUrl", "resume", "secretType", "secret", "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            return null;
        }
    }

    private String m4097a(PlatformDb platformDb, String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            if (i > 0) {
                stringBuilder2.append('|');
                stringBuilder.append('|');
            }
            i++;
            String str2 = platformDb.get(str2);
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder.append(str2);
                stringBuilder2.append(Data.urlEncode(str2, "utf-8"));
            }
        }
        C0979d.m4390a().m4381i("======UserData: " + stringBuilder.toString(), new Object[0]);
        return stringBuilder2.toString();
    }

    private void m4099a(int i, Platform platform) {
    }

    private void m4100a(Platform platform, int i, HashMap<String, Object> hashMap) {
        this.f3184a = new C09301(this, this.f3184a, i, hashMap);
        platform.showUser(null);
    }

    private String m4102b(Platform platform) {
        PlatformDb db = platform.getDb();
        if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(db.getUserGender())) {
            Platform platform2 = ShareSDK.getPlatform("Wechat");
            if (platform2 != null) {
                db = platform2.getDb();
            }
        }
        try {
            return m4097a(db, new String[]{"gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            return null;
        }
    }

    private void m4103b(Platform platform, int i, HashMap<String, Object> hashMap) {
        ShareParams shareParams = hashMap != null ? (ShareParams) hashMap.remove("ShareParams") : (ShareParams) this.f3185b.remove(platform);
        try {
            HashMap hashMap2 = (HashMap) hashMap.clone();
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            HashMap<String, Object> hashMap3 = hashMap;
        }
        if (shareParams != null) {
            C0949c c0955f = new C0955f();
            c0955f.f3262o = shareParams.getCustomFlag();
            String userId = platform.getDb().getUserId();
            if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(userId)) {
                Platform platform2 = ShareSDK.getPlatform("Wechat");
                if (platform2 != null) {
                    userId = platform2.getDb().getUserId();
                }
            } else if ("TencentWeibo".equals(platform.getName())) {
                userId = platform.getDb().get("name");
            }
            c0955f.f3258b = userId;
            c0955f.f3257a = platform.getPlatformId();
            C0954a filterShareContent = platform.filterShareContent(shareParams, hashMap2);
            if (filterShareContent != null) {
                c0955f.f3259c = filterShareContent.f3248a;
                c0955f.f3260d = filterShareContent;
            }
            c0955f.f3261n = m4102b(platform);
            C0959d a = C0959d.m4258a(platform.getContext(), c0955f.g);
            if (a != null) {
                a.m4265a(c0955f);
            }
        }
        if (this.f3184a != null) {
            try {
                this.f3184a.onComplete(platform, i, hashMap);
                this.f3184a = null;
            } catch (Throwable th2) {
                C0979d.m4390a().m4376d(th2);
            }
        }
        m4099a(9, platform);
    }

    PlatformActionListener m4104a() {
        return this.f3184a;
    }

    void m4105a(Platform platform, int i, Object obj) {
        this.f3184a = new C09312(this, this.f3184a, i, obj);
        platform.doAuthorize(null);
    }

    public void m4106a(Platform platform, ShareParams shareParams) {
        this.f3185b.put(platform, shareParams);
    }

    void m4107a(PlatformActionListener platformActionListener) {
        this.f3184a = platformActionListener;
    }

    public void onCancel(Platform platform, int i) {
        if (this.f3184a != null) {
            this.f3184a.onCancel(platform, i);
            this.f3184a = null;
        }
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (!(platform instanceof CustomPlatform)) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    m4100a(platform, i, (HashMap) hashMap);
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    m4103b(platform, i, hashMap);
                default:
                    if (this.f3184a != null) {
                        this.f3184a.onComplete(platform, i, hashMap);
                        if (!"Wechat".equals(platform.getName())) {
                            this.f3184a = null;
                        }
                    }
            }
        } else if (this.f3184a != null) {
            this.f3184a.onComplete(platform, i, hashMap);
            this.f3184a = null;
        }
    }

    public void onError(Platform platform, int i, Throwable th) {
        if (this.f3184a != null) {
            this.f3184a.onError(platform, i, th);
            this.f3184a = null;
        }
    }
}
