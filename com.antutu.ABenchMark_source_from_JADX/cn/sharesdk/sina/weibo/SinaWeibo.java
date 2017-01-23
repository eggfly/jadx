package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p026b.p028b.C0955f.C0954a;
import cn.sharesdk.framework.utils.C0979d;
import com.igexin.download.Downloads;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.umeng.message.proguard.C4233j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

public class SinaWeibo extends Platform {
    public static final String NAME;
    private String f3363a;
    private String f3364b;
    private String f3365c;
    private boolean f3366d;

    /* renamed from: cn.sharesdk.sina.weibo.SinaWeibo.1 */
    class C09951 implements AuthorizeListener {
        final /* synthetic */ C1003d f3361a;
        final /* synthetic */ SinaWeibo f3362b;

        C09951(SinaWeibo sinaWeibo, C1003d c1003d) {
            this.f3362b = sinaWeibo;
            this.f3361a = c1003d;
        }

        public void onCancel() {
            if (this.f3362b.listener != null) {
                this.f3362b.listener.onCancel(this.f3362b, 1);
            }
        }

        public void onComplete(Bundle bundle) {
            long parseLong;
            String string = bundle.getString("uid");
            String string2 = bundle.getString("access_token");
            String string3 = bundle.getString("expires_in");
            String string4 = bundle.getString("refresh_token");
            this.f3362b.db.put("nickname", bundle.getString("userName"));
            this.f3362b.db.put("remind_in", bundle.getString("remind_in"));
            this.f3362b.db.putToken(string2);
            try {
                parseLong = C4021R.parseLong(string3);
            } catch (Throwable th) {
                parseLong = 0;
            }
            this.f3362b.db.putExpiresIn(parseLong);
            this.f3362b.db.put("refresh_token", string4);
            this.f3362b.db.putUserId(string);
            this.f3361a.m4457b(string2);
            this.f3362b.afterRegister(1, null);
        }

        public void onError(Throwable th) {
            if (this.f3362b.listener != null) {
                this.f3362b.listener.onError(this.f3362b, 1, th);
            }
        }
    }

    public static class ShareParams extends cn.sharesdk.framework.Platform.ShareParams {
        @Deprecated
        public String imageUrl;
        @Deprecated
        public float latitude;
        @Deprecated
        public float longitude;
    }

    static {
        NAME = SinaWeibo.class.getSimpleName();
    }

    public SinaWeibo(Context context) {
        super(context);
    }

    private boolean m4400c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        C1003d a = C1003d.m4438a((Platform) this);
        a.m4453a(this.f3363a, this.f3364b);
        a.m4452a(this.f3365c);
        return a.m4455a();
    }

    protected boolean checkAuthorize(int i, Object obj) {
        C1003d a = C1003d.m4438a((Platform) this);
        if (i == 9 && this.f3366d && a.m4458b()) {
            return true;
        }
        if (isAuthValid() || m4400c()) {
            a.m4453a(this.f3363a, this.f3364b);
            a.m4457b(this.db.getToken());
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    protected void doAuthorize(String[] strArr) {
        C1003d a = C1003d.m4438a((Platform) this);
        a.m4453a(this.f3363a, this.f3364b);
        a.m4452a(this.f3365c);
        a.m4454a(strArr);
        a.m4451a(new C09951(this, a), isSSODisable());
    }

    protected void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        try {
            HashMap a = C1003d.m4438a((Platform) this).m4449a(str, str2, (HashMap) hashMap, (HashMap) hashMap2);
            if (a == null || a.size() <= 0) {
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable());
                }
            } else if (!a.containsKey("error_code") || ((Integer) a.get("error_code")).intValue() == 0) {
                if (this.listener != null) {
                    this.listener.onComplete(this, i, a);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(a)));
            }
        } catch (Throwable th) {
            this.listener.onError(this, i, th);
        }
    }

    protected void doShare(cn.sharesdk.framework.Platform.ShareParams shareParams) {
        String string;
        C1003d a;
        String imagePath;
        String imageUrl;
        HashMap a2;
        CharSequence text = shareParams.getText();
        if (TextUtils.isEmpty(text)) {
            int stringRes = C4021R.getStringRes(getContext(), "ssdk_weibo_upload_content");
            if (stringRes > 0) {
                string = getContext().getString(stringRes);
                a = C1003d.m4438a((Platform) this);
                a.m4453a(this.f3363a, this.f3364b);
                imagePath = shareParams.getImagePath();
                imageUrl = shareParams.getImageUrl();
                if (this.f3366d || !a.m4458b()) {
                    float latitude = shareParams.getLatitude();
                    a2 = a.m4448a(getShortLintk(string, false), imageUrl, imagePath, shareParams.getLongitude(), latitude);
                    if (a2 != null) {
                        if (this.listener != null) {
                            this.listener.onError(this, 9, new Throwable());
                        }
                    } else if (a2.containsKey("error_code") || ((Integer) a2.get("error_code")).intValue() == 0) {
                        a2.put("ShareParams", shareParams);
                        if (this.listener != null) {
                            this.listener.onComplete(this, 9, a2);
                        }
                    } else if (this.listener != null) {
                        this.listener.onError(this, 9, new Throwable(new Hashon().fromHashMap(a2)));
                        return;
                    } else {
                        return;
                    }
                }
                try {
                    a.m4450a(shareParams, this.listener);
                    return;
                } catch (Throwable th) {
                    this.listener.onError(this, 9, th);
                    return;
                }
            }
        }
        CharSequence charSequence = text;
        a = C1003d.m4438a((Platform) this);
        a.m4453a(this.f3363a, this.f3364b);
        imagePath = shareParams.getImagePath();
        imageUrl = shareParams.getImageUrl();
        if (this.f3366d) {
        }
        try {
            float latitude2 = shareParams.getLatitude();
            a2 = a.m4448a(getShortLintk(string, false), imageUrl, imagePath, shareParams.getLongitude(), latitude2);
            if (a2 != null) {
                if (a2.containsKey("error_code")) {
                }
                a2.put("ShareParams", shareParams);
                if (this.listener != null) {
                    this.listener.onComplete(this, 9, a2);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 9, new Throwable());
            }
        } catch (Throwable th2) {
            this.listener.onError(this, 9, th2);
        }
    }

    protected HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2 = new HashMap();
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                hashMap2.put(C4233j.f14402y, "FOLLOWING");
                break;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                hashMap2.put(C4233j.f14402y, "FRIENDS");
                break;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                hashMap2.put(C4233j.f14402y, "FOLLOWERS");
                break;
            default:
                return null;
        }
        hashMap2.put("snsplat", Integer.valueOf(getPlatformId()));
        hashMap2.put("snsuid", this.db.getUserId());
        int parseInt = Integer.parseInt(String.valueOf(hashMap.get("current_cursor")));
        int parseInt2 = Integer.parseInt(String.valueOf(hashMap.get("total_number")));
        if (parseInt2 == 0) {
            return null;
        }
        Object obj = hashMap.get("users");
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2.size() <= 0) {
            return null;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            HashMap hashMap3 = (HashMap) it.next();
            if (hashMap3 != null) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("snsuid", String.valueOf(hashMap3.get(AgooConstants.MESSAGE_ID)));
                hashMap4.put("nickname", String.valueOf(hashMap3.get("screen_name")));
                hashMap4.put("icon", String.valueOf(hashMap3.get("avatar_hd")));
                if (String.valueOf(hashMap3.get("verified")).equals("true")) {
                    hashMap4.put("secretType", MessageService.MSG_DB_NOTIFY_REACHED);
                } else {
                    hashMap4.put("secretType", MessageService.MSG_DB_READY_REPORT);
                }
                hashMap4.put("secret", String.valueOf(hashMap3.get("verified_reason")));
                String valueOf = String.valueOf(hashMap3.get("gender"));
                if (valueOf.equals("m")) {
                    hashMap4.put("gender", MessageService.MSG_DB_READY_REPORT);
                } else if (valueOf.equals("f")) {
                    hashMap4.put("gender", MessageService.MSG_DB_NOTIFY_REACHED);
                } else {
                    hashMap4.put("gender", MessageService.MSG_DB_NOTIFY_CLICK);
                }
                hashMap4.put("snsUserUrl", "http://weibo.com/" + String.valueOf(hashMap3.get("profile_url")));
                hashMap4.put("resume", String.valueOf(hashMap3.get(Downloads.COLUMN_DESCRIPTION)));
                hashMap4.put("followerCount", String.valueOf(hashMap3.get("followers_count")));
                hashMap4.put("favouriteCount", String.valueOf(hashMap3.get("friends_count")));
                hashMap4.put("shareCount", String.valueOf(hashMap3.get("statuses_count")));
                hashMap4.put("snsregat", String.valueOf(C4021R.dateToLong(String.valueOf(hashMap3.get("created_at")))));
                arrayList.add(hashMap4);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (10 == i) {
            hashMap2.put("nextCursor", ((Integer) hashMap.get("page_count")).intValue() * (parseInt + 1) >= parseInt2 ? parseInt + "_true" : (parseInt + 1) + "_false");
        } else {
            int size = arrayList.size() + parseInt;
            hashMap2.put("nextCursor", size >= parseInt2 ? parseInt2 + "_true" : size + "_false");
        }
        hashMap2.put("list", arrayList);
        return hashMap2;
    }

    protected C0954a filterShareContent(cn.sharesdk.framework.Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        C0954a c0954a = new C0954a();
        c0954a.f3249b = shareParams.getText();
        if (hashMap != null) {
            c0954a.f3248a = String.valueOf(hashMap.get(AgooConstants.MESSAGE_ID));
            c0954a.f3251d.add(String.valueOf(hashMap.get("original_pic")));
            c0954a.f3254g = hashMap;
        }
        return c0954a;
    }

    protected void follow(String str) {
        try {
            HashMap d = C1003d.m4438a((Platform) this).m4462d(str);
            if (d == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 6, new Throwable());
                }
            } else if (!d.containsKey("error_code") || ((Integer) d.get("error_code")).intValue() == 0) {
                if (this.listener != null) {
                    this.listener.onComplete(this, 6, d);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 6, new Throwable(new Hashon().fromHashMap(d)));
            }
        } catch (Throwable th) {
            this.listener.onError(this, 6, th);
        }
    }

    protected HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        HashMap<String, Object> hashMap = null;
        if (TextUtils.isEmpty(str)) {
            Object userId = this.db.getUserId();
        }
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.get("nickname");
        }
        if (!TextUtils.isEmpty(userId)) {
            try {
                HashMap c = C1003d.m4438a((Platform) this).m4459c(i, i2, userId);
                if (!(c == null || c.containsKey("error_code"))) {
                    c.put("page_count", Integer.valueOf(i));
                    c.put("current_cursor", Integer.valueOf(i2));
                    hashMap = filterFriendshipInfo(10, c);
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        return hashMap;
    }

    protected HashMap<String, Object> getFollowers(int i, int i2, String str) {
        HashMap<String, Object> hashMap = null;
        if (TextUtils.isEmpty(str)) {
            Object userId = this.db.getUserId();
        }
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.get("nickname");
        }
        if (!TextUtils.isEmpty(userId)) {
            try {
                HashMap d = C1003d.m4438a((Platform) this).m4461d(i, i2, userId);
                if (!(d == null || d.containsKey("error_code"))) {
                    d.put("current_cursor", Integer.valueOf(i2));
                    hashMap = filterFriendshipInfo(11, d);
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        return hashMap;
    }

    protected HashMap<String, Object> getFollowings(int i, int i2, String str) {
        HashMap<String, Object> hashMap = null;
        if (TextUtils.isEmpty(str)) {
            Object userId = this.db.getUserId();
        }
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.get("nickname");
        }
        if (!TextUtils.isEmpty(userId)) {
            try {
                HashMap b = C1003d.m4438a((Platform) this).m4456b(i, i2, userId);
                if (!(b == null || b.containsKey("error_code"))) {
                    b.put("current_cursor", Integer.valueOf(i2));
                    hashMap = filterFriendshipInfo(2, b);
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        return hashMap;
    }

    protected void getFriendList(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            Object userId = this.db.getUserId();
        }
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.get("nickname");
        }
        if (!TextUtils.isEmpty(userId)) {
            try {
                HashMap b = C1003d.m4438a((Platform) this).m4456b(i, i2, userId);
                if (b == null) {
                    if (this.listener != null) {
                        this.listener.onError(this, 2, new Throwable());
                    }
                } else if (!b.containsKey("error_code") || ((Integer) b.get("error_code")).intValue() == 0) {
                    if (this.listener != null) {
                        this.listener.onComplete(this, 2, b);
                    }
                } else if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(b)));
                }
            } catch (Throwable th) {
                this.listener.onError(this, 2, th);
            }
        } else if (this.listener != null) {
            this.listener.onError(this, 2, new RuntimeException("Both weibo id and screen_name are null"));
        }
    }

    public String getName() {
        return NAME;
    }

    protected int getPlatformId() {
        return 1;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return true;
    }

    protected void initDevInfo(String str) {
        this.f3363a = getDevinfo("AppKey");
        this.f3364b = getDevinfo("AppSecret");
        this.f3365c = getDevinfo("RedirectUrl");
        this.f3366d = "true".equals(getDevinfo("ShareByAppClient"));
    }

    public boolean isClientValid() {
        return C1003d.m4438a((Platform) this).m4458b();
    }

    protected void setNetworkDevinfo() {
        this.f3363a = getNetworkDevinfo(C4575b.PROPERTY_APP_KEY, "AppKey");
        this.f3364b = getNetworkDevinfo("app_secret", "AppSecret");
        this.f3365c = getNetworkDevinfo("redirect_uri", "RedirectUrl");
    }

    protected void timeline(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.db.get("nickname");
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap a = C1003d.m4438a((Platform) this).m4447a(i, i2, str);
                if (a == null) {
                    if (this.listener != null) {
                        this.listener.onError(this, 7, new Throwable());
                    }
                } else if (!a.containsKey("error_code") || ((Integer) a.get("error_code")).intValue() == 0) {
                    if (this.listener != null) {
                        this.listener.onComplete(this, 7, a);
                    }
                } else if (this.listener != null) {
                    this.listener.onError(this, 7, new Throwable(new Hashon().fromHashMap(a)));
                }
            } catch (Throwable th) {
                this.listener.onError(this, 7, th);
            }
        } else if (this.listener != null) {
            this.listener.onError(this, 7, new RuntimeException("Both weibo id and screen_name are null"));
        }
    }

    protected void userInfor(String str) {
        Object obj = 1;
        Object obj2 = null;
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
            obj2 = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.db.get("nickname");
        } else {
            obj = obj2;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap c = C1003d.m4438a((Platform) this).m4460c(str);
                if (c == null) {
                    if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable());
                    }
                } else if (!c.containsKey("error_code") || ((Integer) c.get("error_code")).intValue() == 0) {
                    if (obj != null) {
                        this.db.putUserId(String.valueOf(c.get(AgooConstants.MESSAGE_ID)));
                        this.db.put("nickname", String.valueOf(c.get("screen_name")));
                        this.db.put("icon", String.valueOf(c.get("avatar_hd")));
                        if (String.valueOf(c.get("verified")).equals("true")) {
                            this.db.put("secretType", MessageService.MSG_DB_NOTIFY_REACHED);
                        } else {
                            this.db.put("secretType", MessageService.MSG_DB_READY_REPORT);
                        }
                        this.db.put("secret", String.valueOf(c.get("verified_reason")));
                        String valueOf = String.valueOf(c.get("gender"));
                        if (valueOf.equals("m")) {
                            this.db.put("gender", MessageService.MSG_DB_READY_REPORT);
                        } else if (valueOf.equals("f")) {
                            this.db.put("gender", MessageService.MSG_DB_NOTIFY_REACHED);
                        } else {
                            this.db.put("gender", MessageService.MSG_DB_NOTIFY_CLICK);
                        }
                        this.db.put("snsUserUrl", "http://weibo.com/" + String.valueOf(c.get("profile_url")));
                        this.db.put("resume", String.valueOf(c.get(Downloads.COLUMN_DESCRIPTION)));
                        this.db.put("followerCount", String.valueOf(c.get("followers_count")));
                        this.db.put("favouriteCount", String.valueOf(c.get("friends_count")));
                        this.db.put("shareCount", String.valueOf(c.get("statuses_count")));
                        this.db.put("snsregat", String.valueOf(C4021R.dateToLong(String.valueOf(c.get("created_at")))));
                    }
                    if (this.listener != null) {
                        this.listener.onComplete(this, 8, c);
                    }
                } else if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(c)));
                }
            } catch (Throwable th) {
                this.listener.onError(this, 8, th);
            }
        } else if (this.listener != null) {
            this.listener.onError(this, 8, new RuntimeException("Both weibo id and screen_name are null"));
        }
    }
}
