package cn.sharesdk.twitter;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import cn.sharesdk.framework.C0923b;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0920b;
import cn.sharesdk.framework.authorize.C0942e;
import cn.sharesdk.framework.p025a.C0932a;
import cn.sharesdk.framework.utils.C0974a;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.android.spdy.SpdyRequest;

/* renamed from: cn.sharesdk.twitter.b */
public class C1036b extends C0923b {
    private static C1036b f3487b;
    private C0974a f3488c;
    private C0932a f3489d;

    private C1036b(Platform platform) {
        super(platform);
        this.f3488c = new C0974a();
        this.f3489d = C0932a.m4083a();
    }

    public static C1036b m4601a(Platform platform) {
        if (f3487b == null) {
            f3487b = new C1036b(platform);
        }
        return f3487b;
    }

    public String m4602a(String str) {
        try {
            String str2 = "https://api.twitter.com/oauth/access_token";
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair("oauth_verifier", str));
            return this.f3489d.m4087a(str2, arrayList, null, this.f3488c.m4359a(this.f3488c.m4357a(str2, arrayList)), "/oauth/access_token", m4046c());
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return null;
        }
    }

    public HashMap<String, Object> m4603a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
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
        if (hashMap2 == null || hashMap2.size() <= 0) {
            kVPair = null;
        } else {
            HashMap<String, Object> hashMap3 = null;
            for (Entry entry2 : hashMap2.entrySet()) {
                Object kVPair2 = new KVPair((String) entry2.getKey(), entry2.getValue());
            }
            kVPair = hashMap3;
        }
        if (SpdyRequest.GET_METHOD.equals(str2.toUpperCase())) {
            httpGet = this.f3489d.httpGet(str, arrayList, this.f3488c.m4359a(this.f3488c.m4362b(str, arrayList)), null);
        } else if (SpdyRequest.POST_METHOD.equals(str2.toUpperCase())) {
            ArrayList a;
            if (hashMap2 == null || hashMap2.size() <= 0) {
                a = this.f3488c.m4359a(this.f3488c.m4357a(str, arrayList));
            } else {
                a = this.f3488c.m4359a(this.f3488c.m4357a(str, new ArrayList()));
                a.remove(1);
            }
            httpGet = this.f3489d.httpPost(str, arrayList, kVPair, a, null);
        } else {
            httpGet = null;
        }
        return (httpGet == null || httpGet.length() <= 0) ? null : new Hashon().fromJson(httpGet);
    }

    public HashMap<String, Object> m4604a(String str, String[] strArr) {
        int i = 0;
        String str2 = "https://upload.twitter.com/1.1/media/upload.json";
        ArrayList arrayList = new ArrayList();
        ArrayList a = this.f3488c.m4359a(this.f3488c.m4357a(str2, arrayList));
        a.remove(1);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < strArr.length && (arrayList2 == null || arrayList2.size() <= 3); i2++) {
            try {
                Object obj = strArr[i2];
                if (obj.startsWith(HttpConstant.HTTP)) {
                    obj = BitmapHelper.downloadBitmap(this.a.getContext(), obj);
                } else {
                    if (!TextUtils.isEmpty(obj)) {
                        if (!new File(obj).exists()) {
                        }
                    }
                }
                String a2 = this.f3489d.m4087a(str2, arrayList, new KVPair("media", obj), a, "/1.1/media/upload.json", m4046c());
                stringBuilder.append(strArr[i2]).append(": ").append(a2).append("\n");
                if (a2 != null && a2.length() > 0) {
                    arrayList2.add(new Hashon().fromJson(a2));
                }
            } catch (Exception e) {
                C0979d.m4390a().m4375d(stringBuilder.toString(), new Object[0]);
            }
        }
        stringBuilder.setLength(0);
        while (i < arrayList2.size()) {
            if (((HashMap) arrayList2.get(i)).containsKey("image")) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(String.valueOf(((HashMap) arrayList2.get(i)).get("media_id")));
            }
            i++;
        }
        return m4612d(str, stringBuilder.toString());
    }

    public void m4605a(AuthorizeListener authorizeListener) {
        m4045b(authorizeListener);
    }

    public void m4606a(String str, String str2) {
        this.f3488c.m4360a(str, str2);
    }

    public void m4607a(String str, String str2, String str3) {
        this.f3488c.m4361a(str, str2, str3);
    }

    public HashMap<String, Object> m4608b(String str) {
        String str2 = "https://api.twitter.com/1.1/users/show.json";
        ArrayList arrayList = new ArrayList();
        long j = 0;
        try {
            j = C4021R.parseLong(str);
        } catch (Throwable th) {
            str = null;
        }
        arrayList.add(new KVPair("user_id", str == null ? this.a.getDb().getUserId() : String.valueOf(j)));
        String a = this.f3489d.m4089a(str2, arrayList, this.f3488c.m4359a(this.f3488c.m4362b(str2, arrayList)), null, "/1.1/users/show.json", m4046c());
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public HashMap<String, Object> m4609b(String str, String str2) {
        String str3 = "https://api.twitter.com/1.1/friends/list.json";
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("nextCursor", str2));
        Object obj = 1;
        try {
            C4021R.parseLong(str);
        } catch (Throwable th) {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new KVPair("user_id", str));
        } else {
            arrayList.add(new KVPair("screen_name", str));
        }
        String a = this.f3489d.m4089a(str3, arrayList, this.f3488c.m4359a(this.f3488c.m4362b(str3, arrayList)), null, "/1.1/friends/list.json", m4046c());
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public HashMap<String, Object> m4610c(String str) {
        return m4612d(str, null);
    }

    public HashMap<String, Object> m4611c(String str, String str2) {
        String str3 = "https://api.twitter.com/1.1/followers/list.json";
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("nextCursor", str2));
        Object obj = 1;
        try {
            C4021R.parseLong(str);
        } catch (Throwable th) {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new KVPair("user_id", str));
        } else {
            arrayList.add(new KVPair("screen_name", str));
        }
        String a = this.f3489d.m4089a(str3, arrayList, this.f3488c.m4359a(this.f3488c.m4362b(str3, arrayList)), null, "/1.1/followers/list.json", m4046c());
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public HashMap<String, Object> m4612d(String str, String str2) {
        String str3 = "https://api.twitter.com/1.1/statuses/update.json";
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(MsgConstant.KEY_STATUS, str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new KVPair("media_ids", str2));
        }
        String a = this.f3489d.m4087a(str3, arrayList, null, this.f3488c.m4359a(this.f3488c.m4357a(str3, arrayList)), "/1.1/statuses/update.json", m4046c());
        return (a == null || a.length() <= 0) ? null : new Hashon().fromJson(a);
    }

    public HashMap<String, Object> m4613e(String str, String str2) {
        String str3 = "https://api.twitter.com/1.1/statuses/update_with_media.json";
        ArrayList arrayList = new ArrayList();
        ArrayList a = this.f3488c.m4359a(this.f3488c.m4357a(str3, arrayList));
        a.remove(1);
        arrayList.add(new KVPair(MsgConstant.KEY_STATUS, str));
        String a2 = this.f3489d.m4087a(str3, arrayList, new KVPair("media[]", str2), a, "/1.1/statuses/update_with_media.json", m4046c());
        return (a2 == null || a2.length() <= 0) ? null : new Hashon().fromJson(a2);
    }

    public String getAuthorizeUrl() {
        try {
            String str = "https://api.twitter.com/oauth/request_token";
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair("oauth_callback", getRedirectUri()));
            m4606a(null, null);
            String a = this.f3489d.m4087a(str, arrayList, null, this.f3488c.m4359a(this.f3488c.m4357a(str, arrayList)), "/oauth/request_token", m4046c());
            if (a == null) {
                return null;
            }
            String[] split = a.split("&");
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                if (str2 != null) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            if (hashMap.containsKey("oauth_token")) {
                a = (String) hashMap.get("oauth_token");
                m4606a(a, (String) hashMap.get("oauth_token_secret"));
                ShareSDK.logApiEvent("/oauth/authorize", m4046c());
                return "https://api.twitter.com/oauth/authorize?oauth_token=" + a;
            }
            return null;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
    }

    public C0920b getAuthorizeWebviewClient(C0942e c0942e) {
        return new C1035a(c0942e);
    }

    public String getRedirectUri() {
        return this.f3488c.m4355a().f3342e;
    }
}
