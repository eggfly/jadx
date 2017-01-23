package cn.sharesdk.wechat.moments;

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

public class WechatMoments extends Platform {
    public static final String NAME;
    private String f3498a;
    private String f3499b;
    private boolean f3500c;

    /* renamed from: cn.sharesdk.wechat.moments.WechatMoments.1 */
    class C10391 implements AuthorizeListener {
        final /* synthetic */ WechatMoments f3497a;

        C10391(WechatMoments wechatMoments) {
            this.f3497a = wechatMoments;
        }

        public void onCancel() {
            if (this.f3497a.listener != null) {
                this.f3497a.listener.onCancel(this.f3497a, 1);
            }
        }

        public void onComplete(Bundle bundle) {
            this.f3497a.afterRegister(1, null);
        }

        public void onError(Throwable th) {
            if (this.f3497a.listener != null) {
                this.f3497a.listener.onError(this.f3497a, 1, th);
            }
        }
    }

    public static class ShareParams extends cn.sharesdk.wechat.utils.WechatHelper.ShareParams {
        public ShareParams() {
            this.scene = 1;
        }
    }

    static {
        NAME = WechatMoments.class.getSimpleName();
    }

    public WechatMoments(Context context) {
        super(context);
    }

    private boolean m4630c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        C1051g c1051g = new C1051g(this, 23);
        c1051g.m4696a(this.f3498a, this.f3499b);
        return c1051g.m4697a();
    }

    protected boolean checkAuthorize(int i, Object obj) {
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3498a);
        if (a.m4662c()) {
            if (a.m4663d()) {
                if (i == 9 || isAuthValid() || m4630c()) {
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
        if (!TextUtils.isEmpty(this.f3498a) && !TextUtils.isEmpty(this.f3499b)) {
            WechatHelper a = WechatHelper.m4635a();
            a.m4658a(this.context, this.f3498a);
            if (a.m4662c()) {
                if (a.m4663d()) {
                    C1051g c1051g = new C1051g(this, 23);
                    c1051g.m4696a(this.f3498a, this.f3499b);
                    C1053i c1053i = new C1053i(this);
                    c1053i.m4712a(c1051g);
                    c1053i.m4710a(new C10391(this));
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
        shareParams.set("scene", Integer.valueOf(1));
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3498a);
        C1053i c1053i = new C1053i(this);
        if (this.f3500c) {
            try {
                a.m4657a(c1053i, shareParams, this.listener);
                return;
            } catch (Throwable th) {
                if (this.listener != null) {
                    this.listener.onError(this, 9, th);
                    return;
                }
                return;
            }
        }
        c1053i.m4709a(shareParams, this.listener);
        try {
            a.m4660b(c1053i);
            if (this.listener != null && a.m4661b()) {
                HashMap hashMap = new HashMap();
                hashMap.put("ShareParams", shareParams);
                if (this.listener != null) {
                    this.listener.onComplete(this, 9, hashMap);
                }
            }
        } catch (Throwable th2) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th2);
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
        return 23;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return !this.f3500c;
    }

    protected void initDevInfo(String str) {
        this.f3498a = getDevinfo("AppId");
        this.f3499b = getDevinfo("AppSecret");
        this.f3500c = "true".equals(getDevinfo("BypassApproval"));
        if (this.f3498a == null || this.f3498a.length() <= 0) {
            this.f3498a = getDevinfo("Wechat", "AppId");
            this.f3500c = "true".equals(getDevinfo("Wechat", "BypassApproval"));
            if (this.f3498a == null || this.f3498a.length() <= 0) {
                this.f3498a = getDevinfo("WechatFavorite", "AppId");
                if (this.f3498a != null && this.f3498a.length() > 0) {
                    copyDevinfo("WechatFavorite", NAME);
                    this.f3498a = getDevinfo("AppId");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                    return;
                }
                return;
            }
            copyDevinfo("Wechat", NAME);
            this.f3498a = getDevinfo("AppId");
            this.f3500c = "true".equals(getDevinfo("BypassApproval"));
            C0979d.m4390a().m4375d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    public boolean isClientValid() {
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3498a);
        return a.m4662c() && a.m4663d();
    }

    @Deprecated
    public boolean isValid() {
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3498a);
        return a.m4662c() && a.m4663d() && super.isValid();
    }

    protected void setNetworkDevinfo() {
        this.f3498a = getNetworkDevinfo("app_id", "AppId");
        this.f3499b = getNetworkDevinfo("app_secret", "AppSecret");
        if (this.f3498a == null || this.f3498a.length() <= 0) {
            this.f3498a = getNetworkDevinfo(22, "app_id", "AppId");
            if (this.f3498a == null || this.f3498a.length() <= 0) {
                this.f3498a = getNetworkDevinfo(37, "app_id", "AppId");
                if (this.f3498a != null && this.f3498a.length() > 0) {
                    copyNetworkDevinfo(23, 23);
                    this.f3498a = getNetworkDevinfo("app_id", "AppId");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                }
            } else {
                copyNetworkDevinfo(22, 23);
                this.f3498a = getNetworkDevinfo("app_id", "AppId");
                C0979d.m4390a().m4375d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
        if (this.f3499b == null || this.f3499b.length() <= 0) {
            this.f3499b = getNetworkDevinfo(22, "app_secret", "AppSecret");
            if (this.f3499b == null || this.f3499b.length() <= 0) {
                this.f3499b = getNetworkDevinfo(37, "app_secret", "AppSecret");
                if (this.f3499b != null && this.f3499b.length() > 0) {
                    copyNetworkDevinfo(23, 23);
                    this.f3499b = getNetworkDevinfo("app_secret", "AppSecret");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                    return;
                }
                return;
            }
            copyNetworkDevinfo(22, 23);
            this.f3499b = getNetworkDevinfo("app_secret", "AppSecret");
            C0979d.m4390a().m4375d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    protected void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    protected void userInfor(String str) {
        if (!TextUtils.isEmpty(this.f3498a) && !TextUtils.isEmpty(this.f3499b)) {
            C1051g c1051g = new C1051g(this, 23);
            c1051g.m4696a(this.f3498a, this.f3499b);
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
