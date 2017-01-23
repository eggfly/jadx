package cn.sharesdk.tencent.qq;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.analytics.tracking.android.ModelFields;
import com.igexin.download.Downloads;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.umeng.message.util.HttpRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: cn.sharesdk.tencent.qq.b */
public class C1011b extends C0923b {
    private static final String[] f3410b;
    private static C1011b f3411c;
    private String f3412d;
    private String[] f3413e;
    private String f3414f;
    private String f3415g;

    /* renamed from: cn.sharesdk.tencent.qq.b.1 */
    class C10101 implements SSOListener {
        final /* synthetic */ AuthorizeListener f3408a;
        final /* synthetic */ C1011b f3409b;

        C10101(C1011b c1011b, AuthorizeListener authorizeListener) {
            this.f3409b = c1011b;
            this.f3408a = authorizeListener;
        }

        public void onCancel() {
            this.f3408a.onCancel();
        }

        public void onComplete(Bundle bundle) {
            this.f3408a.onComplete(bundle);
        }

        public void onFailed(Throwable th) {
            this.f3409b.m4045b(this.f3408a);
        }
    }

    static {
        f3410b = new String[]{"get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t"};
    }

    private C1011b(Platform platform) {
        super(platform);
    }

    public static C1011b m4497a(Platform platform) {
        if (f3411c == null) {
            f3411c = new C1011b(platform);
        }
        return f3411c;
    }

    private void m4499a(String str, String str2, String str3, String str4, String str5, String str6, PlatformActionListener platformActionListener) {
        if (str5 == null && str4 != null && new File(str4).exists()) {
            Object uploadImageToFileServer = ((QQ) this.a).uploadImageToFileServer(str4);
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://openmobile.qq.com/api/check?");
            stringBuilder.append("page=shareindex.html&");
            stringBuilder.append("style=9&");
            stringBuilder.append("action=shareToQQ&");
            stringBuilder.append("sdkv=2.2.1&");
            stringBuilder.append("sdkp=a&");
            stringBuilder.append("appId=").append(this.f3412d).append("&");
            DeviceHelper instance = DeviceHelper.getInstance(this.a.getContext());
            stringBuilder.append("status_os=").append(Data.urlEncode(instance.getOSVersionName(), "utf-8")).append("&");
            stringBuilder.append("status_machine=").append(Data.urlEncode(instance.getModel(), "utf-8")).append("&");
            stringBuilder.append("status_version=").append(Data.urlEncode(String.valueOf(instance.getOSVersionInt()), "utf-8")).append("&");
            Object appName = instance.getAppName();
            if (!TextUtils.isEmpty(appName)) {
                stringBuilder.append("site=").append(Data.urlEncode(appName, "utf-8")).append("&");
            }
            if (!TextUtils.isEmpty(str)) {
                String str7 = str.length() > 40 ? str.substring(40) + "..." : str;
                if (str7.length() > 80) {
                    str7 = str7.substring(80) + "...";
                }
                stringBuilder.append("title=").append(Data.urlEncode(str7, "utf-8")).append("&");
            }
            if (!TextUtils.isEmpty(str3)) {
                stringBuilder.append("summary=").append(Data.urlEncode(str3, "utf-8")).append("&");
            }
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder.append("targeturl=").append(Data.urlEncode(str2, "utf-8")).append("&");
            }
            if (!TextUtils.isEmpty(uploadImageToFileServer)) {
                stringBuilder.append("imageUrl=").append(Data.urlEncode(uploadImageToFileServer, "utf-8")).append("&");
            }
            stringBuilder.append("type=1");
            C1019f c1019f = new C1019f();
            c1019f.m4535a(stringBuilder.toString());
            c1019f.m4534a(platformActionListener);
            c1019f.m4536b(this.f3412d);
            c1019f.show(this.a.getContext(), null);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.a, 9, th);
            }
        }
    }

    private String m4500b() {
        int i = 0;
        String[] strArr = this.f3413e == null ? f3410b : this.f3413e;
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

    private void m4501b(String str, String str2, String str3, String str4, String str5, String str6, PlatformActionListener platformActionListener) {
        try {
            Object obj = (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) ? null : 1;
            String str7 = obj == null ? "/t/add_t" : "/t/add_pic_t";
            String str8 = "https://graph.qq.com" + str7;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair("oauth_consumer_key", this.f3412d));
            arrayList.add(new KVPair("access_token", this.f3415g));
            arrayList.add(new KVPair("openid", this.f3414f));
            arrayList.add(new KVPair("format", "json"));
            arrayList.add(new KVPair("content", str3));
            if (obj != null) {
                Object downloadBitmap;
                if (TextUtils.isEmpty(str4)) {
                    downloadBitmap = BitmapHelper.downloadBitmap(this.a.getContext(), str5);
                }
                str8 = C0932a.m4083a().m4085a(str8, arrayList, new KVPair("pic", downloadBitmap), str7, m4046c());
            } else {
                str8 = C0932a.m4083a().m4092b(str8, arrayList, str7, m4046c());
            }
            if (str8 != null && str8.length() > 0 && platformActionListener != null) {
                HashMap fromJson = new Hashon().fromJson(str8);
                if (((Integer) fromJson.get(KEYS.RET)).intValue() != 0) {
                    platformActionListener.onError(this.a, 9, new Exception(str8));
                } else {
                    platformActionListener.onComplete(this.a, 9, fromJson);
                }
            }
        } catch (Throwable th) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.a, 9, th);
            }
        }
    }

    public void m4502a(AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m4045b(authorizeListener);
        } else {
            m4044a(new C10101(this, authorizeListener));
        }
    }

    public void m4503a(String str) {
        this.f3412d = str;
    }

    public void m4504a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, PlatformActionListener platformActionListener, boolean z2, int i) {
        if (z2) {
            m4501b(str, str2, str3, str4, str5, str6, platformActionListener);
        } else if (z && m4506a()) {
            if (!TextUtils.isEmpty(str4)) {
                File file = new File(str4);
                if (file.exists() && str4.startsWith("/data/")) {
                    String absolutePath = new File(C4021R.getCachePath(this.a.getContext(), "images"), System.currentTimeMillis() + file.getName()).getAbsolutePath();
                    str4 = C4021R.copyFile(str4, absolutePath) ? absolutePath : null;
                }
            }
            Intent intent = new Intent();
            intent.putExtra(Downloads.COLUMN_TITLE, str);
            intent.putExtra("titleUrl", str2);
            intent.putExtra("summary", str3);
            intent.putExtra("imagePath", str4);
            intent.putExtra("imageUrl", str5);
            intent.putExtra("musicUrl", str6);
            intent.putExtra(ModelFields.APP_ID, this.f3412d);
            intent.putExtra("hidden", i);
            C1015e c1015e = new C1015e();
            c1015e.m4521a(this.a, platformActionListener);
            c1015e.m4522a(this.f3412d);
            c1015e.show(this.a.getContext(), intent);
        } else {
            m4499a(str, str2, str3, str4, str5, str6, platformActionListener);
        }
    }

    public void m4505a(String[] strArr) {
        this.f3413e = strArr;
    }

    public boolean m4506a() {
        CharSequence charSequence = null;
        try {
            charSequence = this.a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
        } catch (Throwable th) {
            try {
                charSequence = this.a.getContext().getPackageManager().getPackageInfo("com.tencent.qqlite", 0).versionName;
            } catch (Throwable th2) {
                try {
                    charSequence = this.a.getContext().getPackageManager().getPackageInfo("com.tencent.minihd.qq", 0).versionName;
                } catch (Throwable th3) {
                }
            }
        }
        return !TextUtils.isEmpty(charSequence);
    }

    public void m4507b(String str) {
        this.f3414f = str;
    }

    public HashMap<String, Object> m4508c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", str));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = C0932a.m4083a().m4089a("https://graph.qq.com/oauth2.0/me", arrayList, arrayList2, null, "/oauth2.0/me", m4046c());
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

    public void m4509d(String str) {
        this.f3415g = str;
    }

    public HashMap<String, Object> m4510e(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("access_token", this.f3415g));
        arrayList.add(new KVPair("oauth_consumer_key", this.f3412d));
        arrayList.add(new KVPair("openid", this.f3414f));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = C0932a.m4083a().m4089a("https://graph.qq.com/user/get_simple_userinfo", arrayList, arrayList2, null, "/user/get_simple_userinfo", m4046c());
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public String getAuthorizeUrl() {
        String urlEncode;
        ShareSDK.logApiEvent("/oauth2.0/authorize", m4046c());
        String b = m4500b();
        try {
            urlEncode = Data.urlEncode(getRedirectUri(), "utf-8");
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            urlEncode = getRedirectUri();
        }
        return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.f3412d + "&" + "redirect_uri=" + urlEncode + "&" + "display=mobile&" + "scope=" + b;
    }

    public C0920b getAuthorizeWebviewClient(C0942e c0942e) {
        return new C1009a(c0942e);
    }

    public String getRedirectUri() {
        return "auth://tauth.qq.com/";
    }

    public C0916d getSSOProcessor(C0937c c0937c) {
        C0916d c1012c = new C1012c(c0937c);
        c1012c.m4032a(5656);
        c1012c.m4513a(this.f3412d, m4500b());
        return c1012c;
    }
}
