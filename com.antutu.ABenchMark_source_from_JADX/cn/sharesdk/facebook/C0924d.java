package cn.sharesdk.facebook;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.facebook.ads.AdError;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyRequest;

/* renamed from: cn.sharesdk.facebook.d */
public class C0924d extends C0923b {
    private static final String[] f3144b;
    private static C0924d f3145c;
    private String f3146d;
    private String f3147e;
    private long f3148f;
    private String f3149g;
    private C0932a f3150h;
    private String[] f3151i;
    private String f3152j;

    /* renamed from: cn.sharesdk.facebook.d.1 */
    class C09221 implements SSOListener {
        final /* synthetic */ AuthorizeListener f3139a;
        final /* synthetic */ C0924d f3140b;

        C09221(C0924d c0924d, AuthorizeListener authorizeListener) {
            this.f3140b = c0924d;
            this.f3139a = authorizeListener;
        }

        public void onCancel() {
            this.f3139a.onCancel();
        }

        public void onComplete(Bundle bundle) {
            this.f3139a.onComplete(bundle);
        }

        public void onFailed(Throwable th) {
            C0979d.m4390a().m4376d(th);
            this.f3140b.m4045b(this.f3139a);
        }
    }

    static {
        f3144b = new String[]{"user_about_me", "user_birthday", "user_photos", "publish_actions", "user_friends"};
    }

    private C0924d(Platform platform) {
        super(platform);
        this.f3150h = C0932a.m4083a();
    }

    public static C0924d m4047a(Platform platform) {
        if (f3145c == null) {
            f3145c = new C0924d(platform);
        }
        return f3145c;
    }

    public HashMap<String, Object> m4049a(int i, int i2, String str) {
        String str2 = "me";
        if (str != null) {
            str2 = str;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", this.f3147e));
        arrayList.add(new KVPair("format", "json"));
        arrayList.add(new KVPair("limit", String.valueOf(i)));
        arrayList.add(new KVPair("offset", String.valueOf(i2)));
        arrayList.add(new KVPair("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,security_settings,significant_other,video_upload_limits,website,work"));
        String str3 = "/friends";
        if (!TextUtils.isEmpty(str)) {
            str3 = "/taggable_friends";
        }
        str2 = this.f3150h.m4088a("https://graph.facebook.com/v2.5/" + str2 + str3, arrayList, "friends", m4046c());
        return (str2 == null || str2.length() <= 0) ? null : new Hashon().fromJson(str2);
    }

    public HashMap<String, Object> m4050a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        if (str2 == null) {
            return null;
        }
        KVPair kVPair;
        ArrayList arrayList = new ArrayList();
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry entry : hashMap.entrySet()) {
                arrayList.add(new KVPair((String) entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        arrayList.add(new KVPair("access_token", this.f3147e));
        arrayList.add(new KVPair("format", "json"));
        if (hashMap2 == null || hashMap2.size() <= 0) {
            kVPair = null;
        } else {
            HashMap<String, Object> hashMap3 = null;
            for (Entry entry2 : hashMap2.entrySet()) {
                Object kVPair2 = new KVPair((String) entry2.getKey(), entry2.getValue());
            }
            kVPair = hashMap3;
        }
        String httpGet = SpdyRequest.GET_METHOD.equals(str2.toUpperCase()) ? this.f3150h.httpGet(str, arrayList, null, null) : SpdyRequest.POST_METHOD.equals(str2.toUpperCase()) ? this.f3150h.httpPost(str, arrayList, kVPair, null, null) : null;
        return (httpGet == null || httpGet.length() <= 0) ? null : new Hashon().fromJson(httpGet);
    }

    public void m4051a(ShareParams shareParams, PlatformActionListener platformActionListener) {
        Object imageUrl = shareParams.getImageUrl();
        Object title = shareParams.getTitle();
        Object text = shareParams.getText();
        Object musicUrl = shareParams.getMusicUrl();
        Object url = shareParams.getUrl();
        String titleUrl = shareParams.getTitleUrl();
        if (!TextUtils.isEmpty(titleUrl)) {
            titleUrl = this.a.getShortLintk(titleUrl, false);
        } else if (!TextUtils.isEmpty(url)) {
            titleUrl = this.a.getShortLintk(url, false);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://www.facebook.com/dialog/feed?");
        stringBuilder.append("app_id=").append(this.f3149g);
        stringBuilder.append("&redirect_uri=fbconnect://success");
        stringBuilder.append("&link=").append(Data.urlEncode(titleUrl, "utf-8"));
        if (!TextUtils.isEmpty(imageUrl)) {
            stringBuilder.append("&picture=").append(Data.urlEncode(imageUrl, "utf-8"));
        }
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append("&caption=").append(Data.urlEncode(title, "utf-8"));
        }
        if (!TextUtils.isEmpty(text)) {
            stringBuilder.append("&description=").append(Data.urlEncode(text, "utf-8"));
        }
        if (!TextUtils.isEmpty(musicUrl)) {
            stringBuilder.append("&source=").append(Data.urlEncode(musicUrl, "utf-8"));
            if (!TextUtils.isEmpty(text)) {
                stringBuilder.append("&name=").append(Data.urlEncode(text, "utf-8"));
            }
        }
        C0928e c0928e = new C0928e();
        c0928e.m4068a(stringBuilder.toString());
        c0928e.m4067a(platformActionListener);
        c0928e.show(this.a.getContext(), null);
    }

    public void m4052a(AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m4045b(authorizeListener);
        } else {
            m4044a(new C09221(this, authorizeListener));
        }
    }

    public void m4053a(String str) {
        this.f3149g = str;
    }

    public void m4054a(String str, String str2) {
        this.f3147e = str;
        if (str2 != null && !str2.equals(MessageService.MSG_DB_READY_REPORT)) {
            try {
                this.f3148f = System.currentTimeMillis() + ((long) (C4021R.parseInt(str2) * AdError.NETWORK_ERROR_CODE));
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
    }

    public void m4055a(String[] strArr) {
        this.f3151i = strArr;
    }

    public boolean m4056a() {
        return this.f3147e != null && (this.f3148f == 0 || System.currentTimeMillis() < this.f3148f);
    }

    public HashMap<String, Object> m4057b(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", this.f3147e));
        arrayList.add(new KVPair("format", "json"));
        arrayList.add(new KVPair(C4233j.f14376C, str));
        String b = this.f3150h.m4092b("https://graph.facebook.com/v2.5/me/feed", arrayList, "/v2.5/me/feed", m4046c());
        return (b == null || b.length() <= 0) ? null : new Hashon().fromJson(b);
    }

    public HashMap<String, Object> m4058b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", this.f3147e));
        arrayList.add(new KVPair("format", "json"));
        arrayList.add(new KVPair("caption", str));
        String a = this.f3150h.m4085a("https://graph.facebook.com/v2.5/me/photos", arrayList, new KVPair(AgooConstants.MESSAGE_FROM_PKG, str2), "/v2.5/me/photos", m4046c());
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public boolean m4059b() {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", this.f3149g);
        if (this.f3151i != null && this.f3151i.length > 0) {
            intent.putExtra("scope", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, this.f3151i));
        }
        ResolveInfo resolveActivity = getPlatform().getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            for (Signature toCharsString : getPlatform().getContext().getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures) {
                if ("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(toCharsString.toCharsString())) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public HashMap<String, Object> m4060c(String str) {
        String str2 = "/me";
        if (str != null) {
            str2 = "/" + str;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", this.f3147e));
        arrayList.add(new KVPair("format", "json"));
        arrayList.add(new KVPair("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,security_settings,significant_other,video_upload_limits,website,work"));
        str2 = this.f3150h.m4088a("https://graph.facebook.com/v2.5" + str2, arrayList, "get_user_info", m4046c());
        C0979d.m4390a().m4381i("facebook helper getUser", new Object[0]);
        return (str2 == null || str2.length() <= 0) ? null : new Hashon().fromJson(str2);
    }

    public void m4061d(String str) {
        this.f3152j = str;
    }

    public String getAuthorizeUrl() {
        int i = 0;
        String str = "https://www.facebook.com/dialog/oauth";
        Bundle bundle = new Bundle();
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", this.f3152j);
        bundle.putString(C4233j.f14402y, "user_agent");
        String[] strArr = this.f3151i == null ? f3144b : this.f3151i;
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (i2 > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(str2);
            i2++;
            i++;
        }
        bundle.putString("scope", stringBuilder.toString());
        bundle.putString("client_id", this.f3149g);
        bundle.putString("response_type", com.taobao.accs.common.Constants.KEY_HTTP_CODE);
        this.f3146d = str + "?" + C4021R.encodeUrl(bundle);
        ShareSDK.logApiEvent("/dialog/oauth", m4046c());
        return this.f3146d;
    }

    public C0920b getAuthorizeWebviewClient(C0942e c0942e) {
        return new C0921c(c0942e);
    }

    public String getRedirectUri() {
        return this.f3152j;
    }

    public C0916d getSSOProcessor(C0937c c0937c) {
        C0916d c0917b = new C0917b(c0937c);
        c0917b.m4032a(32525);
        c0917b.m4041a(this.f3149g, this.f3151i == null ? f3144b : this.f3151i);
        return c0917b;
    }
}
