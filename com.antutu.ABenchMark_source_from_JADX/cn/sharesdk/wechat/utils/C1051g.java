package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p025a.C0932a;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.qq.p035e.comm.pi.ACTD;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import org.android.agoo.message.MessageService;

/* renamed from: cn.sharesdk.wechat.utils.g */
public class C1051g {
    private String f3532a;
    private String f3533b;
    private C0932a f3534c;
    private Platform f3535d;
    private int f3536e;

    /* renamed from: cn.sharesdk.wechat.utils.g.1 */
    class C10491 extends Thread {
        final /* synthetic */ String f3527a;
        final /* synthetic */ AuthorizeListener f3528b;
        final /* synthetic */ C1051g f3529c;

        C10491(C1051g c1051g, String str, AuthorizeListener authorizeListener) {
            this.f3529c = c1051g;
            this.f3527a = str;
            this.f3528b = authorizeListener;
        }

        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new KVPair(ACTD.APPID_KEY, this.f3529c.f3532a));
                arrayList.add(new KVPair("secret", this.f3529c.f3533b));
                arrayList.add(new KVPair(Constants.KEY_HTTP_CODE, this.f3527a));
                arrayList.add(new KVPair("grant_type", "authorization_code"));
                String a = this.f3529c.f3534c.m4088a("https://api.weixin.qq.com/sns/oauth2/access_token", arrayList, "/sns/oauth2/access_token", this.f3529c.f3536e);
                if (TextUtils.isEmpty(a)) {
                    this.f3528b.onError(new Throwable("Authorize token is empty"));
                } else if (!a.contains("errcode")) {
                    this.f3529c.m4688a(a);
                    this.f3528b.onComplete(null);
                } else if (this.f3528b != null) {
                    this.f3528b.onError(new Throwable(a));
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
    }

    /* renamed from: cn.sharesdk.wechat.utils.g.2 */
    class C10502 extends Thread {
        final /* synthetic */ PlatformActionListener f3530a;
        final /* synthetic */ C1051g f3531b;

        C10502(C1051g c1051g, PlatformActionListener platformActionListener) {
            this.f3531b = c1051g;
            this.f3530a = platformActionListener;
        }

        public void run() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair("access_token", this.f3531b.f3535d.getDb().getToken()));
            arrayList.add(new KVPair("openid", this.f3531b.f3535d.getDb().get("openid")));
            String a = this.f3531b.f3534c.m4088a("https://api.weixin.qq.com/sns/userinfo", arrayList, "/sns/userinfo", this.f3531b.f3536e);
            if (!TextUtils.isEmpty(a)) {
                C0979d.m4390a().m4375d("getUserInfo ==>>" + a, new Object[0]);
                HashMap fromJson = new Hashon().fromJson(a);
                if (!fromJson.containsKey("errcode") || ((Integer) fromJson.get("errcode")).intValue() == 0) {
                    String valueOf;
                    String valueOf2;
                    int parseInt;
                    try {
                        valueOf = String.valueOf(fromJson.get("openid"));
                        valueOf2 = String.valueOf(fromJson.get("nickname"));
                        parseInt = C4021R.parseInt(String.valueOf(fromJson.get("sex")));
                    } catch (Throwable th) {
                        C0979d.m4390a().m4376d(th);
                        return;
                    }
                    String valueOf3 = String.valueOf(fromJson.get("province"));
                    String valueOf4 = String.valueOf(fromJson.get("city"));
                    String valueOf5 = String.valueOf(fromJson.get("country"));
                    String valueOf6 = String.valueOf(fromJson.get("headimgurl"));
                    String valueOf7 = String.valueOf(fromJson.get("unionid"));
                    this.f3531b.f3535d.getDb().put("nickname", valueOf2);
                    if (parseInt == 1) {
                        this.f3531b.f3535d.getDb().put("gender", MessageService.MSG_DB_READY_REPORT);
                    } else if (parseInt == 2) {
                        this.f3531b.f3535d.getDb().put("gender", MessageService.MSG_DB_NOTIFY_REACHED);
                    } else {
                        this.f3531b.f3535d.getDb().put("gender", MessageService.MSG_DB_NOTIFY_CLICK);
                    }
                    this.f3531b.f3535d.getDb().putUserId(valueOf);
                    this.f3531b.f3535d.getDb().put("icon", valueOf6);
                    this.f3531b.f3535d.getDb().put("province", valueOf3);
                    this.f3531b.f3535d.getDb().put("city", valueOf4);
                    this.f3531b.f3535d.getDb().put("country", valueOf5);
                    this.f3531b.f3535d.getDb().put("openid", valueOf);
                    this.f3531b.f3535d.getDb().put("unionid", valueOf7);
                    this.f3530a.onComplete(this.f3531b.f3535d, 8, fromJson);
                } else if (this.f3530a != null) {
                    this.f3530a.onError(this.f3531b.f3535d, 8, new Throwable(new Hashon().fromHashMap(fromJson)));
                }
            } else if (this.f3530a != null) {
                this.f3530a.onError(this.f3531b.f3535d, 8, new Throwable());
            }
        }
    }

    public C1051g(Platform platform, int i) {
        this.f3535d = platform;
        this.f3536e = i;
        this.f3534c = C0932a.m4083a();
    }

    private void m4688a(String str) {
        C0979d.m4390a().m4375d("wechat getAuthorizeToken ==>>" + str, new Object[0]);
        HashMap fromJson = new Hashon().fromJson(str);
        String valueOf = String.valueOf(fromJson.get("access_token"));
        String valueOf2 = String.valueOf(fromJson.get("refresh_token"));
        String valueOf3 = String.valueOf(fromJson.get("expires_in"));
        this.f3535d.getDb().put("openid", String.valueOf(fromJson.get("openid")));
        this.f3535d.getDb().putExpiresIn(Long.valueOf(valueOf3).longValue());
        this.f3535d.getDb().putToken(valueOf);
        this.f3535d.getDb().put("refresh_token", valueOf2);
    }

    public void m4693a(Bundle bundle, AuthorizeListener authorizeListener) {
        String string = bundle.getString("_wxapi_sendauth_resp_url");
        if (!TextUtils.isEmpty(string)) {
            int indexOf = string.indexOf("://oauth?");
            if (indexOf >= 0) {
                string = string.substring(indexOf + 1);
            }
            try {
                m4695a(C4021R.urlToBundle(string).getString(Constants.KEY_HTTP_CODE), authorizeListener);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
                if (authorizeListener != null) {
                    authorizeListener.onError(th);
                }
            }
        } else if (authorizeListener != null) {
            authorizeListener.onError(null);
        }
    }

    public void m4694a(PlatformActionListener platformActionListener) {
        new C10502(this, platformActionListener).start();
    }

    public void m4695a(String str, AuthorizeListener authorizeListener) {
        C0979d.m4390a().m4375d("getAuthorizeToken ==>> " + str, new Object[0]);
        new C10491(this, str, authorizeListener).start();
    }

    public void m4696a(String str, String str2) {
        this.f3532a = str;
        this.f3533b = str2;
    }

    public boolean m4697a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(ACTD.APPID_KEY, this.f3532a));
        arrayList.add(new KVPair("refresh_token", this.f3535d.getDb().get("refresh_token")));
        arrayList.add(new KVPair("grant_type", "refresh_token"));
        try {
            String a = this.f3534c.m4088a("https://api.weixin.qq.com/sns/oauth2/refresh_token", arrayList, "/sns/oauth2/refresh_token", this.f3536e);
            if (TextUtils.isEmpty(a) || a.contains("errcode")) {
                return false;
            }
            m4688a(a);
            return true;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return false;
        }
    }
}
