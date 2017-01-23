package cn.sharesdk.twitter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p026b.p028b.C0955f.C0954a;
import cn.sharesdk.framework.utils.C0979d;
import com.igexin.download.Downloads;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.umeng.message.proguard.C4233j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

public class Twitter extends Platform {
    public static final String NAME;
    private String f3479a;
    private String f3480b;
    private String f3481c;

    /* renamed from: cn.sharesdk.twitter.Twitter.1 */
    class C10321 implements AuthorizeListener {
        final /* synthetic */ C1036b f3477a;
        final /* synthetic */ Twitter f3478b;

        C10321(Twitter twitter, C1036b c1036b) {
            this.f3478b = twitter;
            this.f3477a = c1036b;
        }

        public void onCancel() {
            if (this.f3478b.listener != null) {
                this.f3478b.listener.onCancel(this.f3478b, 1);
            }
        }

        public void onComplete(Bundle bundle) {
            String string = bundle.getString("oauth_token");
            String string2 = bundle.getString("oauth_token_secret");
            String string3 = bundle.getString("user_id");
            String string4 = bundle.getString("screen_name");
            this.f3478b.db.putToken(string);
            this.f3478b.db.putTokenSecret(string2);
            this.f3478b.db.putUserId(string3);
            this.f3478b.db.put("nickname", string4);
            this.f3477a.m4606a(string, string2);
            this.f3478b.afterRegister(1, null);
        }

        public void onError(Throwable th) {
            if (this.f3478b.listener != null) {
                this.f3478b.listener.onError(this.f3478b, 1, th);
            }
        }
    }

    public static class ShareParams extends cn.sharesdk.framework.Platform.ShareParams {
    }

    static {
        NAME = Twitter.class.getSimpleName();
    }

    public Twitter(Context context) {
        super(context);
    }

    protected boolean checkAuthorize(int i, Object obj) {
        if (isAuthValid()) {
            C1036b a = C1036b.m4601a((Platform) this);
            a.m4607a(this.f3479a, this.f3480b, this.f3481c);
            String token = this.db.getToken();
            String tokenSecret = this.db.getTokenSecret();
            if (!(token == null || tokenSecret == null)) {
                a.m4606a(token, tokenSecret);
                return true;
            }
        }
        innerAuthorize(i, obj);
        return false;
    }

    protected void doAuthorize(String[] strArr) {
        C1036b a = C1036b.m4601a((Platform) this);
        a.m4607a(this.f3479a, this.f3480b, this.f3481c);
        a.m4605a(new C10321(this, a));
    }

    protected void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        try {
            HashMap a = C1036b.m4601a((Platform) this).m4603a(str, str2, hashMap, hashMap2);
            if (a == null || a.size() <= 0) {
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable("response is null"));
                }
            } else if (a.containsKey("error_code") || a.containsKey(C4233j.f14375B)) {
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(a)));
                }
            } else if (this.listener != null) {
                this.listener.onComplete(this, i, a);
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, i, th);
            }
        }
    }

    protected void doShare(cn.sharesdk.framework.Platform.ShareParams shareParams) {
        C1036b a = C1036b.m4601a((Platform) this);
        HashMap hashMap = null;
        String shortLintk = getShortLintk(shareParams.getText(), false);
        try {
            String[] imageArray = shareParams.getImageArray();
            String imagePath = shareParams.getImagePath();
            Object imageUrl = shareParams.getImageUrl();
            if (imageArray != null && imageArray.length > 0) {
                hashMap = a.m4604a(shortLintk, imageArray);
            } else if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                hashMap = a.m4613e(shortLintk, imagePath);
            } else if (TextUtils.isEmpty(imageUrl)) {
                hashMap = a.m4610c(shortLintk);
            } else {
                String downloadBitmap = BitmapHelper.downloadBitmap(getContext(), imageUrl);
                if (new File(downloadBitmap).exists()) {
                    hashMap = a.m4613e(shortLintk, downloadBitmap);
                }
            }
            if (hashMap == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable("response is null"));
                }
            } else if (!hashMap.containsKey("error_code") && !hashMap.containsKey(C4233j.f14375B)) {
                hashMap.put("ShareParams", shareParams);
                if (this.listener != null) {
                    this.listener.onComplete(this, 9, hashMap);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(hashMap)));
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th);
            }
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
        CharSequence valueOf = hashMap.containsKey("next_cursor") ? String.valueOf(hashMap.get("next_cursor")) : null;
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
                hashMap4.put("icon", String.valueOf(hashMap3.get("profile_image_url")));
                hashMap4.put("gender", MessageService.MSG_DB_NOTIFY_CLICK);
                hashMap4.put("resume", String.valueOf(hashMap3.get(Downloads.COLUMN_DESCRIPTION)));
                hashMap4.put("secretType", "true".equals(String.valueOf(hashMap3.get("verified"))) ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
                hashMap4.put("followerCount", String.valueOf(hashMap3.get("followers_count")));
                hashMap4.put("favouriteCount", String.valueOf(hashMap3.get("friends_count")));
                hashMap4.put("shareCount", String.valueOf(hashMap3.get("statuses_count")));
                hashMap4.put("snsregat", String.valueOf(C4021R.dateToLong(String.valueOf(hashMap3.get("created_at")))));
                hashMap4.put("snsUserUrl", "https://twitter.com/" + hashMap3.get("screen_name"));
                arrayList.add(hashMap4);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        obj = valueOf + "_false";
        if (TextUtils.isEmpty(valueOf) || MessageService.MSG_DB_READY_REPORT.equals(valueOf)) {
            obj = "0_true";
        }
        hashMap2.put("nextCursor", obj);
        hashMap2.put("list", arrayList);
        return hashMap2;
    }

    protected C0954a filterShareContent(cn.sharesdk.framework.Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        C0954a c0954a = new C0954a();
        c0954a.f3249b = shareParams.getText();
        if (hashMap != null) {
            HashMap hashMap2 = (HashMap) hashMap.get("entities");
            if (hashMap2 != null) {
                ArrayList arrayList = (ArrayList) hashMap2.get("media");
                if (!(arrayList == null || arrayList.size() <= 0 || ((HashMap) arrayList.get(0)) == null)) {
                    c0954a.f3251d.add(String.valueOf(hashMap.get("media_url")));
                }
            }
            c0954a.f3248a = String.valueOf(hashMap.get(AgooConstants.MESSAGE_ID));
            c0954a.f3254g = hashMap;
        }
        return c0954a;
    }

    protected void follow(String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 6);
        }
    }

    protected HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        return null;
    }

    protected HashMap<String, Object> getFollowers(int i, int i2, String str) {
        HashMap<String, Object> hashMap = null;
        Object userId = TextUtils.isEmpty(null) ? this.db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.getUserName();
        }
        if (!TextUtils.isEmpty(userId)) {
            C1036b a = C1036b.m4601a((Platform) this);
            try {
                if (TextUtils.isEmpty(str)) {
                    str = MessageService.MSG_DB_READY_REPORT;
                }
                HashMap c = a.m4611c(userId, str);
                if (!(c == null || c.size() <= 0 || c.containsKey("error_code") || c.containsKey(C4233j.f14375B))) {
                    hashMap = filterFriendshipInfo(11, c);
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        return hashMap;
    }

    protected HashMap<String, Object> getFollowings(int i, int i2, String str) {
        HashMap<String, Object> hashMap = null;
        Object userId = TextUtils.isEmpty(null) ? this.db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.getUserName();
        }
        if (!TextUtils.isEmpty(userId)) {
            C1036b a = C1036b.m4601a((Platform) this);
            try {
                if (TextUtils.isEmpty(str)) {
                    str = MessageService.MSG_DB_READY_REPORT;
                }
                HashMap b = a.m4609b(userId, str);
                if (!(b == null || b.size() <= 0 || b.containsKey("error_code") || b.containsKey(C4233j.f14375B))) {
                    hashMap = filterFriendshipInfo(2, b);
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        return hashMap;
    }

    protected void getFriendList(int i, int i2, String str) {
        Object obj = null;
        if (TextUtils.isEmpty(null)) {
            obj = this.db.getUserId();
        }
        if (TextUtils.isEmpty(obj)) {
            obj = this.db.getUserName();
        }
        if (TextUtils.isEmpty(obj) && this.listener != null) {
            this.listener.onError(this, 2, new Throwable("The account do not authorize!"));
        }
        C1036b a = C1036b.m4601a((Platform) this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = MessageService.MSG_DB_READY_REPORT;
            }
            HashMap b = a.m4609b(obj, str);
            if (b == null || b.size() <= 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable("response is null"));
                }
            } else if (b.containsKey("error_code") || b.containsKey(C4233j.f14375B)) {
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(b)));
                }
            } else if (this.listener != null) {
                this.listener.onComplete(this, 2, b);
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 2, th);
            }
        }
    }

    public String getName() {
        return NAME;
    }

    public int getPlatformId() {
        return 11;
    }

    public int getVersion() {
        return 2;
    }

    public boolean hasShareCallback() {
        return true;
    }

    protected void initDevInfo(String str) {
        this.f3479a = getDevinfo("ConsumerKey");
        this.f3480b = getDevinfo("ConsumerSecret");
        this.f3481c = getDevinfo("CallbackUrl");
    }

    protected void setNetworkDevinfo() {
        this.f3479a = getNetworkDevinfo("consumer_key", "ConsumerKey");
        this.f3480b = getNetworkDevinfo("consumer_secret", "ConsumerSecret");
        this.f3481c = getNetworkDevinfo("redirect_uri", "CallbackUrl");
    }

    protected void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    protected void userInfor(String str) {
        try {
            HashMap b = C1036b.m4601a((Platform) this).m4608b(str);
            if (b == null || b.size() <= 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable("response is null"));
                }
            } else if (!b.containsKey("error_code") && !b.containsKey(C4233j.f14375B)) {
                if (str == null) {
                    this.db.put("nickname", String.valueOf(b.get("screen_name")));
                    this.db.put("icon", String.valueOf(b.get("profile_image_url")));
                    this.db.put("gender", MessageService.MSG_DB_NOTIFY_CLICK);
                    this.db.put("resume", String.valueOf(b.get(Downloads.COLUMN_DESCRIPTION)));
                    this.db.put("secretType", "true".equals(String.valueOf(b.get("verified"))) ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
                    this.db.put("followerCount", String.valueOf(b.get("followers_count")));
                    this.db.put("favouriteCount", String.valueOf(b.get("friends_count")));
                    this.db.put("shareCount", String.valueOf(b.get("statuses_count")));
                    this.db.put("snsregat", String.valueOf(C4021R.dateToLong(String.valueOf(b.get("created_at")))));
                    this.db.put("snsUserUrl", "https://twitter.com/" + b.get("screen_name"));
                }
                if (this.listener != null) {
                    this.listener.onComplete(this, 8, b);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(b)));
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 8, th);
            }
        }
    }
}
