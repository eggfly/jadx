package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.C0714a;
import cn.sharesdk.framework.C0923b;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0916d;
import cn.sharesdk.framework.authorize.C0920b;
import cn.sharesdk.framework.authorize.C0937c;
import cn.sharesdk.framework.authorize.C0942e;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.p025a.C0932a;
import cn.sharesdk.framework.utils.C0979d;
import com.google.analytics.tracking.android.ModelFields;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyRequest;

/* renamed from: cn.sharesdk.sina.weibo.d */
public class C1003d extends C0923b {
    private static C1003d f3385b;
    private String f3386c;
    private String f3387d;
    private String f3388e;
    private String f3389f;
    private String[] f3390g;
    private C0932a f3391h;
    private Context f3392i;

    /* renamed from: cn.sharesdk.sina.weibo.d.1 */
    class C10011 implements SSOListener {
        final /* synthetic */ AuthorizeListener f3380a;
        final /* synthetic */ C1003d f3381b;

        C10011(C1003d c1003d, AuthorizeListener authorizeListener) {
            this.f3381b = c1003d;
            this.f3380a = authorizeListener;
        }

        public void onCancel() {
            this.f3380a.onCancel();
        }

        public void onComplete(Bundle bundle) {
            try {
                C4021R.parseLong(bundle.getString("expires_in"));
                this.f3380a.onComplete(bundle);
            } catch (Throwable th) {
                onFailed(th);
            }
        }

        public void onFailed(Throwable th) {
            C0979d.m4390a().m4376d(th);
            this.f3381b.m4045b(this.f3380a);
        }
    }

    /* renamed from: cn.sharesdk.sina.weibo.d.2 */
    class C10022 implements AuthorizeListener {
        final /* synthetic */ PlatformActionListener f3382a;
        final /* synthetic */ ShareParams f3383b;
        final /* synthetic */ C1003d f3384c;

        C10022(C1003d c1003d, PlatformActionListener platformActionListener, ShareParams shareParams) {
            this.f3384c = c1003d;
            this.f3382a = platformActionListener;
            this.f3383b = shareParams;
        }

        public void onCancel() {
            if (this.f3382a != null) {
                this.f3382a.onCancel(this.f3384c.a, 9);
            }
        }

        public void onComplete(Bundle bundle) {
            if (this.f3382a != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("ShareParams", this.f3383b);
                this.f3382a.onComplete(this.f3384c.a, 9, hashMap);
            }
        }

        public void onError(Throwable th) {
            if (this.f3382a != null) {
                this.f3382a.onError(this.f3384c.a, 9, th);
            }
        }
    }

    private C1003d(Platform platform) {
        super(platform);
        this.f3390g = new String[]{"follow_app_official_microblog"};
        this.f3391h = C0932a.m4083a();
        this.f3392i = platform.getContext();
    }

    public static synchronized C1003d m4438a(Platform platform) {
        C1003d c1003d;
        synchronized (C1003d.class) {
            if (f3385b == null) {
                f3385b = new C1003d(platform);
            }
            c1003d = f3385b;
        }
        return c1003d;
    }

    private HashMap<String, Object> m4439a(String str, float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        arrayList.add(new KVPair("access_token", this.f3389f));
        arrayList.add(new KVPair(MsgConstant.KEY_STATUS, str));
        arrayList.add(new KVPair("long", String.valueOf(f)));
        arrayList.add(new KVPair(C0714a.LATITUDE, String.valueOf(f2)));
        String b = this.f3391h.m4092b("https://api.weibo.com/2/statuses/update.json", arrayList, "/2/statuses/update.json", m4046c());
        return b != null ? new Hashon().fromJson(b) : null;
    }

    private HashMap<String, Object> m4440a(String str, String str2, float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        arrayList.add(new KVPair("access_token", this.f3389f));
        arrayList.add(new KVPair(MsgConstant.KEY_STATUS, str));
        arrayList.add(new KVPair("long", String.valueOf(f)));
        arrayList.add(new KVPair(C0714a.LATITUDE, String.valueOf(f2)));
        arrayList.add(new KVPair("url", str2));
        String b = this.f3391h.m4092b("https://api.weibo.com/2/statuses/upload_url_text.json", arrayList, "/2/statuses/upload_url_text.json", m4046c());
        return b != null ? new Hashon().fromJson(b) : null;
    }

    private HashMap<String, Object> m4443b(String str, String str2, float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        arrayList.add(new KVPair("access_token", this.f3389f));
        arrayList.add(new KVPair(MsgConstant.KEY_STATUS, str2));
        arrayList.add(new KVPair("long", String.valueOf(f)));
        arrayList.add(new KVPair(C0714a.LATITUDE, String.valueOf(f2)));
        String a = this.f3391h.m4085a("https://api.weibo.com/2/statuses/upload.json", arrayList, new KVPair("pic", str), "/2/statuses/upload.json", m4046c());
        return a != null ? new Hashon().fromJson(a) : null;
    }

    private void m4445e(String str) {
        HashMap fromJson = new Hashon().fromJson(str);
        String valueOf = String.valueOf(fromJson.get("uid"));
        String valueOf2 = String.valueOf(fromJson.get("expires_in"));
        String valueOf3 = String.valueOf(fromJson.get("access_token"));
        String valueOf4 = String.valueOf(fromJson.get("refresh_token"));
        String valueOf5 = String.valueOf(fromJson.get("remind_in"));
        this.a.getDb().putUserId(valueOf);
        this.a.getDb().putExpiresIn(Long.valueOf(valueOf2).longValue());
        this.a.getDb().putToken(valueOf3);
        this.a.getDb().put("refresh_token", valueOf4);
        this.a.getDb().put("remind_in", valueOf5);
    }

    public String m4446a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("client_id", this.f3386c));
        arrayList.add(new KVPair("client_secret", this.f3387d));
        arrayList.add(new KVPair("redirect_uri", this.f3388e));
        arrayList.add(new KVPair("grant_type", "authorization_code"));
        arrayList.add(new KVPair(Constants.KEY_HTTP_CODE, str));
        String b = this.f3391h.m4092b("https://api.weibo.com/oauth2/access_token", arrayList, "/oauth2/access_token", m4046c());
        ShareSDK.logApiEvent("/oauth2/access_token", m4046c());
        return b;
    }

    public HashMap<String, Object> m4447a(int i, int i2, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        Object obj = 1;
        try {
            C4021R.parseLong(str);
        } catch (Throwable th) {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new KVPair("uid", str));
        } else {
            arrayList.add(new KVPair("screen_name", str));
        }
        arrayList.add(new KVPair("count", String.valueOf(i)));
        arrayList.add(new KVPair(ModelFields.PAGE, String.valueOf(i2)));
        String a = this.f3391h.m4088a("https://api.weibo.com/2/statuses/user_timeline.json", arrayList, "/2/statuses/user_timeline.json", m4046c());
        return a != null ? new Hashon().fromJson(a) : null;
    }

    public HashMap<String, Object> m4448a(String str, String str2, String str3, float f, float f2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return !TextUtils.isEmpty(str3) ? m4443b(str3, str, f, f2) : !TextUtils.isEmpty(str2) ? m4440a(str, str2, f, f2) : m4439a(str, f, f2);
        } else {
            throw new Throwable("weibo content can not be null!");
        }
    }

    public HashMap<String, Object> m4449a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        if (str2 == null) {
            return null;
        }
        KVPair kVPair;
        String httpGet;
        ArrayList arrayList = new ArrayList();
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry entry : hashMap.entrySet()) {
                arrayList.add(new KVPair((String) entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        if (this.f3389f != null) {
            arrayList.add(new KVPair("access_token", this.f3389f));
        }
        if (hashMap2 == null || hashMap2.size() <= 0) {
            kVPair = null;
        } else {
            HashMap<String, Object> hashMap3 = null;
            for (Entry entry2 : hashMap2.entrySet()) {
                Object kVPair2 = new KVPair((String) entry2.getKey(), entry2.getValue());
            }
            kVPair = hashMap3;
        }
        try {
            if (SpdyRequest.GET_METHOD.equals(str2.toUpperCase())) {
                httpGet = new NetworkHelper().httpGet(str, arrayList, null, null);
            } else {
                if (SpdyRequest.POST_METHOD.equals(str2.toUpperCase())) {
                    httpGet = new NetworkHelper().httpPost(str, arrayList, kVPair, null, null);
                }
                httpGet = null;
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
        return (httpGet == null || httpGet.length() <= 0) ? null : new Hashon().fromJson(httpGet);
    }

    public void m4450a(ShareParams shareParams, PlatformActionListener platformActionListener) {
        if (shareParams.getImageData() == null && TextUtils.isEmpty(shareParams.getImagePath()) && !TextUtils.isEmpty(shareParams.getImageUrl())) {
            try {
                File file = new File(BitmapHelper.downloadBitmap(this.f3392i, shareParams.getImageUrl()));
                if (file.exists()) {
                    shareParams.setImagePath(file.getAbsolutePath());
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        Object text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            shareParams.setText(getPlatform().getShortLintk(text, false));
        }
        AuthorizeListener c10022 = new C10022(this, platformActionListener, shareParams);
        C0997a c0997a = new C0997a();
        c0997a.m4423a(this.f3386c);
        c0997a.m4421a(shareParams);
        c0997a.m4422a(c10022);
        c0997a.show(this.f3392i, null, true);
    }

    public void m4451a(AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m4045b(authorizeListener);
        } else {
            m4044a(new C10011(this, authorizeListener));
        }
    }

    public void m4452a(String str) {
        this.f3388e = str;
    }

    public void m4453a(String str, String str2) {
        this.f3386c = str;
        this.f3387d = str2;
    }

    public void m4454a(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f3390g = strArr;
        }
    }

    public boolean m4455a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("client_id", this.f3386c));
        arrayList.add(new KVPair("client_secret", this.f3387d));
        arrayList.add(new KVPair("redirect_uri", this.f3388e));
        arrayList.add(new KVPair("grant_type", "refresh_token"));
        arrayList.add(new KVPair("refresh_token", this.a.getDb().get("refresh_token")));
        try {
            String b = this.f3391h.m4092b("https://api.weibo.com/oauth2/access_token", arrayList, "/oauth2/access_token", m4046c());
            if (TextUtils.isEmpty(b) || b.contains(C4233j.f14375B) || b.contains("error_code")) {
                return false;
            }
            m4445e(b);
            return true;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return false;
        }
    }

    public HashMap<String, Object> m4456b(int i, int i2, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        if (this.f3389f != null) {
            arrayList.add(new KVPair("access_token", this.f3389f));
        }
        Object obj = 1;
        try {
            C4021R.parseLong(str);
        } catch (Throwable th) {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new KVPair("uid", str));
        } else {
            arrayList.add(new KVPair("screen_name", str));
        }
        arrayList.add(new KVPair("count", String.valueOf(i)));
        arrayList.add(new KVPair("cursor", String.valueOf(i2)));
        String a = this.f3391h.m4088a("https://api.weibo.com/2/friendships/friends.json", arrayList, "/2/friendships/friends.json", m4046c());
        return a != null ? new Hashon().fromJson(a) : null;
    }

    public void m4457b(String str) {
        this.f3389f = str;
    }

    public boolean m4458b() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage("com.sina.weibo");
        intent.setType("image/*");
        ResolveInfo resolveActivity = this.a.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.sina.weibog3");
            intent.setType("image/*");
            resolveActivity = this.a.getContext().getPackageManager().resolveActivity(intent, 0);
        }
        return resolveActivity != null;
    }

    public HashMap<String, Object> m4459c(int i, int i2, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        if (this.f3389f != null) {
            arrayList.add(new KVPair("access_token", this.f3389f));
        }
        Object obj = 1;
        try {
            C4021R.parseLong(str);
        } catch (Throwable th) {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new KVPair("uid", str));
        } else {
            arrayList.add(new KVPair("screen_name", str));
        }
        arrayList.add(new KVPair("count", String.valueOf(i)));
        arrayList.add(new KVPair(ModelFields.PAGE, String.valueOf(i2)));
        String a = this.f3391h.m4088a("https://api.weibo.com/2/friendships/friends/bilateral.json", arrayList, "/2/friendships/friends/bilateral.json", m4046c());
        return a != null ? new Hashon().fromJson(a) : null;
    }

    public HashMap<String, Object> m4460c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        if (this.f3389f != null) {
            arrayList.add(new KVPair("access_token", this.f3389f));
        }
        Object obj = 1;
        try {
            C4021R.parseLong(str);
        } catch (Throwable th) {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new KVPair("uid", str));
        } else {
            arrayList.add(new KVPair("screen_name", str));
        }
        String a = this.f3391h.m4088a("https://api.weibo.com/2/users/show.json", arrayList, "/2/users/show.json", m4046c());
        return a != null ? new Hashon().fromJson(a) : null;
    }

    public HashMap<String, Object> m4461d(int i, int i2, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        if (this.f3389f != null) {
            arrayList.add(new KVPair("access_token", this.f3389f));
        }
        Object obj = 1;
        try {
            C4021R.parseLong(str);
        } catch (Throwable th) {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new KVPair("uid", str));
        } else {
            arrayList.add(new KVPair("screen_name", str));
        }
        arrayList.add(new KVPair("count", String.valueOf(i)));
        arrayList.add(new KVPair("cursor", String.valueOf(i2)));
        String a = this.f3391h.m4088a("https://api.weibo.com/2/friendships/followers.json", arrayList, "/2/friendships/followers.json", m4046c());
        return a != null ? new Hashon().fromJson(a) : null;
    }

    public HashMap<String, Object> m4462d(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(AgooConstants.MESSAGE_FROM_PKG, this.f3386c));
        arrayList.add(new KVPair("access_token", this.f3389f));
        Object obj = 1;
        try {
            C4021R.parseLong(str);
        } catch (Throwable th) {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new KVPair("uid", str));
        } else {
            arrayList.add(new KVPair("screen_name", str));
        }
        String b = this.f3391h.m4092b("https://api.weibo.com/2/friendships/create.json", arrayList, "/2/friendships/create.json", m4046c());
        return b != null ? new Hashon().fromJson(b) : null;
    }

    public String getAuthorizeUrl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("client_id", this.f3386c));
        arrayList.add(new KVPair("response_type", Constants.KEY_HTTP_CODE));
        arrayList.add(new KVPair("redirect_uri", this.f3388e));
        if (this.f3390g != null && this.f3390g.length > 0) {
            arrayList.add(new KVPair("scope", TextUtils.join(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP, this.f3390g)));
        }
        arrayList.add(new KVPair("display", "mobile"));
        String str = "https://open.weibo.cn/oauth2/authorize?" + C4021R.encodeUrl(arrayList);
        ShareSDK.logApiEvent("/oauth2/authorize", m4046c());
        return str;
    }

    public C0920b getAuthorizeWebviewClient(C0942e c0942e) {
        return new C0999b(c0942e);
    }

    public String getRedirectUri() {
        return TextUtils.isEmpty(this.f3388e) ? "https://api.weibo.com/oauth2/default.html" : this.f3388e;
    }

    public C0916d getSSOProcessor(C0937c c0937c) {
        C0916d c1000c = new C1000c(c0937c);
        c1000c.m4032a(32973);
        c1000c.m4436a(this.f3386c, this.f3388e, this.f3390g);
        return c1000c;
    }
}
