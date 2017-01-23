package cn.sharesdk.tencent.qzone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.C0923b;
import cn.sharesdk.framework.Platform;
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
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyRequest;

/* renamed from: cn.sharesdk.tencent.qzone.b */
public class C1026b extends C0923b {
    private static final String[] f3456b;
    private static C1026b f3457c;
    private String f3458d;
    private String f3459e;
    private String f3460f;
    private C0932a f3461g;
    private String[] f3462h;

    /* renamed from: cn.sharesdk.tencent.qzone.b.1 */
    class C10251 implements SSOListener {
        final /* synthetic */ AuthorizeListener f3454a;
        final /* synthetic */ C1026b f3455b;

        C10251(C1026b c1026b, AuthorizeListener authorizeListener) {
            this.f3455b = c1026b;
            this.f3454a = authorizeListener;
        }

        public void onCancel() {
            this.f3454a.onCancel();
        }

        public void onComplete(Bundle bundle) {
            this.f3454a.onComplete(bundle);
        }

        public void onFailed(Throwable th) {
            this.f3455b.m4045b(this.f3454a);
        }
    }

    static {
        f3456b = new String[]{"get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t"};
    }

    private C1026b(Platform platform) {
        super(platform);
        this.f3461g = C0932a.m4083a();
    }

    public static C1026b m4559a(Platform platform) {
        if (f3457c == null) {
            f3457c = new C1026b(platform);
        }
        return f3457c;
    }

    private String m4561b() {
        int i = 0;
        String[] strArr = this.f3462h == null ? f3456b : this.f3462h;
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            if (i2 > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(str);
            i2++;
            i++;
        }
        return stringBuilder.toString();
    }

    public HashMap<String, Object> m4562a(String str, String str2) {
        String str3 = "https://graph.qq.com/photo/upload_pic";
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", this.f3460f));
        arrayList.add(new KVPair("oauth_consumer_key", this.f3458d));
        arrayList.add(new KVPair("openid", this.f3459e));
        arrayList.add(new KVPair("format", "json"));
        if (!TextUtils.isEmpty(str2)) {
            Object obj;
            if (str2.length() > Constants.COMMAND_HANDSHAKE) {
                obj = str2.substring(0, 199) + "\u2026";
            }
            arrayList.add(new KVPair("photodesc", obj));
        }
        arrayList.add(new KVPair("mobile", MessageService.MSG_DB_NOTIFY_REACHED));
        KVPair kVPair = new KVPair("picture", str);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = this.f3461g.m4087a(str3, arrayList, kVPair, arrayList2, "/photo/upload_pic", m4046c());
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public HashMap<String, Object> m4563a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
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
        arrayList.add(new KVPair("access_token", this.f3460f));
        arrayList.add(new KVPair("oauth_consumer_key", this.f3458d));
        arrayList.add(new KVPair("openid", this.f3459e));
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
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        try {
            if (SpdyRequest.GET_METHOD.equals(str2.toUpperCase())) {
                httpGet = new NetworkHelper().httpGet(str, arrayList, arrayList2, null);
            } else {
                if (SpdyRequest.POST_METHOD.equals(str2.toUpperCase())) {
                    httpGet = new NetworkHelper().httpPost(str, arrayList, kVPair, arrayList2, null);
                }
                httpGet = null;
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
        return (httpGet == null || httpGet.length() <= 0) ? null : new Hashon().fromJson(httpGet);
    }

    public void m4564a(AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m4045b(authorizeListener);
        } else {
            m4044a(new C10251(this, authorizeListener));
        }
    }

    public void m4565a(String str) {
        this.f3458d = str;
    }

    public void m4566a(String str, String str2, String str3, String str4, String str5, PlatformActionListener platformActionListener) {
        if (TextUtils.isEmpty(str5)) {
            str5 = DeviceHelper.getInstance(this.a.getContext()).getAppName();
        }
        String str6 = str5.length() > 20 ? str5.substring(0, 20) + "..." : str5;
        String substring = (TextUtils.isEmpty(str) || str.length() <= Constants.COMMAND_HANDSHAKE) ? str : str.substring(0, Constants.COMMAND_HANDSHAKE);
        m4571b(substring, str2, str3, str4, str6, platformActionListener);
    }

    public void m4567a(String[] strArr) {
        this.f3462h = strArr;
    }

    public boolean m4568a() {
        CharSequence charSequence;
        try {
            charSequence = this.a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            charSequence = null;
        }
        return !TextUtils.isEmpty(charSequence);
    }

    public HashMap<String, Object> m4569b(String str, String str2) {
        Object obj = !TextUtils.isEmpty(str) ? 1 : null;
        String str3 = obj != null ? "/t/add_pic_t" : "/t/add_t";
        String str4 = "https://graph.qq.com" + str3;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("oauth_consumer_key", this.f3458d));
        arrayList.add(new KVPair("access_token", this.f3460f));
        arrayList.add(new KVPair("openid", this.f3459e));
        arrayList.add(new KVPair("format", "json"));
        arrayList.add(new KVPair("content", str2));
        String a = obj != null ? this.f3461g.m4085a(str4, arrayList, new KVPair("pic", str), str3, m4046c()) : this.f3461g.m4092b(str4, arrayList, str3, m4046c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        HashMap<String, Object> fromJson = new Hashon().fromJson(a);
        if (((Integer) fromJson.get(KEYS.RET)).intValue() == 0) {
            return fromJson;
        }
        throw new Throwable(a);
    }

    public void m4570b(String str) {
        this.f3459e = str;
    }

    public void m4571b(String str, String str2, String str3, String str4, String str5, PlatformActionListener platformActionListener) {
        String str6 = MessageService.MSG_DB_NOTIFY_REACHED;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            str6 = MessageService.MSG_DB_NOTIFY_DISMISS;
        } else if (TextUtils.isEmpty(str2)) {
            if (platformActionListener != null) {
                platformActionListener.onError(null, 9, new Throwable("The param of title or titleUrl is null !"));
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str4)) {
            File file = new File(str4);
            if (file.exists() && str4.startsWith("/data/")) {
                String absolutePath = new File(C4021R.getCachePath(this.a.getContext(), "images"), System.currentTimeMillis() + file.getName()).getAbsolutePath();
                Object obj = C4021R.copyFile(str4, absolutePath) ? absolutePath : null;
            }
        }
        if (!TextUtils.isEmpty(str3) && str3.length() > OtherError.CONTAINER_INVISIBLE_ERROR) {
            Object substring = str3.substring(0, OtherError.CONTAINER_INVISIBLE_ERROR);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (str6 == MessageService.MSG_DB_NOTIFY_DISMISS) {
            stringBuilder.append("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        } else {
            stringBuilder.append("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        }
        if (!TextUtils.isEmpty(obj)) {
            stringBuilder.append("&image_url=").append(Base64.encodeToString(obj.getBytes("utf-8"), 2));
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append("&title=").append(Base64.encodeToString(str.getBytes("utf-8"), 2));
        }
        if (!TextUtils.isEmpty(substring)) {
            stringBuilder.append("&description=").append(Base64.encodeToString(substring.getBytes("utf-8"), 2));
        }
        stringBuilder.append("&share_id=").append(this.f3458d);
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append("&url=").append(Base64.encodeToString(str2.getBytes("utf-8"), 2));
        }
        stringBuilder.append("&app_name=").append(Base64.encodeToString(str5.getBytes("utf-8"), 2));
        if (!TextUtils.isEmpty(substring)) {
            stringBuilder.append("&share_qq_ext_str=").append(Base64.encodeToString(substring.getBytes(), 2));
        }
        stringBuilder.append("&req_type=").append(Base64.encodeToString(str6.getBytes("utf-8"), 2));
        stringBuilder.append("&cflag=").append(Base64.encodeToString((m4568a() ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT).getBytes("utf-8"), 2));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuilder.toString()));
        if (this.a.getContext().getPackageManager().resolveActivity(intent, 1) != null) {
            C1031d c1031d = new C1031d();
            c1031d.m4590a(stringBuilder.toString(), true);
            c1031d.m4588a(platformActionListener);
            c1031d.m4589a(this.f3458d);
            c1031d.show(this.a.getContext(), null);
        }
    }

    public void m4572c(String str) {
        this.f3460f = str;
    }

    public HashMap<String, Object> m4573d(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", this.f3460f));
        arrayList.add(new KVPair("oauth_consumer_key", this.f3458d));
        arrayList.add(new KVPair("openid", this.f3459e));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = this.f3461g.m4089a("https://graph.qq.com/user/get_simple_userinfo", arrayList, arrayList2, null, "/user/get_simple_userinfo", m4046c());
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public HashMap<String, Object> m4574e(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", str));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = this.f3461g.m4089a("https://graph.qq.com/oauth2.0/me", arrayList, arrayList2, null, "/oauth2.0/me", m4046c());
        if (a.startsWith("callback")) {
            while (!a.startsWith("{") && a.length() > 0) {
                a = a.substring(1);
            }
            while (!a.endsWith("}") && a.length() > 0) {
                a = a.substring(0, a.length() - 1);
            }
        }
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public String getAuthorizeUrl() {
        String urlEncode;
        ShareSDK.logApiEvent("/oauth2.0/authorize", m4046c());
        String b = m4561b();
        try {
            urlEncode = Data.urlEncode(getRedirectUri(), "utf-8");
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            urlEncode = getRedirectUri();
        }
        return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.f3458d + "&" + "redirect_uri=" + urlEncode + "&" + "display=mobile&" + "scope=" + b;
    }

    public C0920b getAuthorizeWebviewClient(C0942e c0942e) {
        return new C1024a(c0942e);
    }

    public String getRedirectUri() {
        return "auth://tauth.qq.com/";
    }

    public C0916d getSSOProcessor(C0937c c0937c) {
        C0916d c1027c = new C1027c(c0937c);
        c1027c.m4032a(5656);
        c1027c.m4577a(this.f3458d, m4561b());
        return c1027c;
    }
}
