package cn.sharesdk.wechat.favorite;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p026b.p028b.C0955f.C0954a;
import cn.sharesdk.framework.utils.C0979d;
import cn.sharesdk.wechat.utils.C1051g;
import cn.sharesdk.wechat.utils.C1053i;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.WechatHelper;
import cn.sharesdk.wechat.utils.WechatTimelineNotSupportedException;
import com.igexin.download.Downloads;
import java.util.HashMap;

public class WechatFavorite extends Platform {
    public static final String NAME;
    private String f3491a;
    private String f3492b;

    /* renamed from: cn.sharesdk.wechat.favorite.WechatFavorite.1 */
    class C10371 implements AuthorizeListener {
        final /* synthetic */ WechatFavorite f3490a;

        C10371(WechatFavorite wechatFavorite) {
            this.f3490a = wechatFavorite;
        }

        public void onCancel() {
            if (this.f3490a.listener != null) {
                this.f3490a.listener.onCancel(this.f3490a, 1);
            }
        }

        public void onComplete(Bundle bundle) {
            this.f3490a.afterRegister(1, null);
        }

        public void onError(Throwable th) {
            if (this.f3490a.listener != null) {
                this.f3490a.listener.onError(this.f3490a, 1, th);
            }
        }
    }

    public static class ShareParams extends cn.sharesdk.wechat.utils.WechatHelper.ShareParams {
        public ShareParams() {
            this.scene = 2;
        }
    }

    static {
        NAME = WechatFavorite.class.getSimpleName();
    }

    public WechatFavorite(Context context) {
        super(context);
    }

    private boolean m4618c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        C1051g c1051g = new C1051g(this, 37);
        c1051g.m4696a(this.f3491a, this.f3492b);
        return c1051g.m4697a();
    }

    protected boolean checkAuthorize(int i, Object obj) {
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3491a);
        if (a.m4662c()) {
            if (a.m4663d()) {
                if (i == 9 || isAuthValid() || m4618c()) {
                    return true;
                }
                innerAuthorize(i, obj);
                return false;
            } else if (this.listener == null) {
                return false;
            } else {
                this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
                return false;
            }
        } else if (this.listener == null) {
            return false;
        } else {
            this.listener.onError(this, i, new WechatClientNotExistException());
            return false;
        }
    }

    protected void doAuthorize(String[] strArr) {
        if (!TextUtils.isEmpty(this.f3491a) && !TextUtils.isEmpty(this.f3492b)) {
            WechatHelper a = WechatHelper.m4635a();
            a.m4658a(this.context, this.f3491a);
            if (a.m4662c()) {
                if (a.m4663d()) {
                    C1051g c1051g = new C1051g(this, 37);
                    c1051g.m4696a(this.f3491a, this.f3492b);
                    C1053i c1053i = new C1053i(this);
                    c1053i.m4712a(c1051g);
                    c1053i.m4710a(new C10371(this));
                    try {
                        a.m4656a(c1053i);
                    } catch (Throwable th) {
                        if (this.listener != null) {
                            this.listener.onError(this, 1, th);
                        }
                    }
                } else if (this.listener != null) {
                    this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 1, new WechatClientNotExistException());
            }
        } else if (this.listener != null) {
            this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
        }
    }

    protected void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        if (this.listener != null) {
            this.listener.onCancel(this, i);
        }
    }

    protected void doShare(cn.sharesdk.framework.Platform.ShareParams shareParams) {
        shareParams.set("scene", Integer.valueOf(2));
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3491a);
        C1053i c1053i = new C1053i(this);
        c1053i.m4709a(shareParams, this.listener);
        try {
            a.m4660b(c1053i);
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th);
            }
        }
    }

    protected HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> hashMap) {
        return null;
    }

    protected C0954a filterShareContent(cn.sharesdk.framework.Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        C0954a c0954a = new C0954a();
        String text = shareParams.getText();
        c0954a.f3249b = text;
        CharSequence imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        Bitmap imageData = shareParams.getImageData();
        if (!TextUtils.isEmpty(imageUrl)) {
            c0954a.f3251d.add(imageUrl);
        } else if (imagePath != null) {
            c0954a.f3252e.add(imagePath);
        } else if (imageData != null) {
            c0954a.f3253f.add(imageData);
        }
        String url = shareParams.getUrl();
        if (url != null) {
            c0954a.f3250c.add(url);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Downloads.COLUMN_TITLE, shareParams.getTitle());
        hashMap2.put("url", url);
        hashMap2.put("extInfo", null);
        hashMap2.put("content", text);
        hashMap2.put("image", c0954a.f3251d);
        hashMap2.put("musicFileUrl", url);
        c0954a.f3254g = hashMap2;
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
        return null;
    }

    protected HashMap<String, Object> getFollowings(int i, int i2, String str) {
        return null;
    }

    protected void getFriendList(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 2);
        }
    }

    public String getName() {
        return NAME;
    }

    public int getPlatformId() {
        return 37;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return false;
    }

    protected void initDevInfo(String str) {
        this.f3491a = getDevinfo("AppId");
        this.f3492b = getDevinfo("AppSecret");
        if (this.f3491a == null || this.f3491a.length() <= 0) {
            this.f3491a = getDevinfo("Wechat", "AppId");
            if (this.f3491a == null || this.f3491a.length() <= 0) {
                this.f3491a = getDevinfo("WechatMoments", "AppId");
                if (this.f3491a != null && this.f3491a.length() > 0) {
                    copyDevinfo("WechatMoments", NAME);
                    this.f3491a = getDevinfo("AppId");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
                    return;
                }
                return;
            }
            copyDevinfo("Wechat", NAME);
            this.f3491a = getDevinfo("AppId");
            C0979d.m4390a().m4375d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    public boolean isClientValid() {
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3491a);
        return a.m4662c();
    }

    @Deprecated
    public boolean isValid() {
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3491a);
        return a.m4662c() && super.isValid();
    }

    protected void setNetworkDevinfo() {
        this.f3491a = getNetworkDevinfo("app_id", "AppId");
        this.f3492b = getNetworkDevinfo("app_secret", "AppSecret");
        if (this.f3491a == null || this.f3491a.length() <= 0) {
            this.f3491a = getNetworkDevinfo(22, "app_id", "AppId");
            if (this.f3491a == null || this.f3491a.length() <= 0) {
                this.f3491a = getNetworkDevinfo(23, "app_id", "AppId");
                if (this.f3491a != null && this.f3491a.length() > 0) {
                    copyNetworkDevinfo(23, 37);
                    this.f3491a = getNetworkDevinfo("app_id", "AppId");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
                }
            } else {
                copyNetworkDevinfo(22, 37);
                this.f3491a = getNetworkDevinfo("app_id", "AppId");
                C0979d.m4390a().m4375d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
        if (this.f3492b == null || this.f3492b.length() <= 0) {
            this.f3492b = getNetworkDevinfo(22, "app_secret", "AppSecret");
            if (this.f3492b == null || this.f3492b.length() <= 0) {
                this.f3492b = getNetworkDevinfo(23, "app_secret", "AppSecret");
                if (this.f3492b != null && this.f3492b.length() > 0) {
                    copyNetworkDevinfo(23, 37);
                    this.f3492b = getNetworkDevinfo("app_secret", "AppSecret");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
                    return;
                }
                return;
            }
            copyNetworkDevinfo(22, 37);
            this.f3492b = getNetworkDevinfo("app_secret", "AppSecret");
            C0979d.m4390a().m4375d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    protected void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    protected void userInfor(String str) {
        if (!TextUtils.isEmpty(this.f3491a) && !TextUtils.isEmpty(this.f3492b)) {
            C1051g c1051g = new C1051g(this, 37);
            c1051g.m4696a(this.f3491a, this.f3492b);
            try {
                c1051g.m4694a(this.listener);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
                if (this.listener != null) {
                    this.listener.onError(this, 8, th);
                }
            }
        } else if (this.listener != null) {
            this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
        }
    }
}
