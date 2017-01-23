package cn.sharesdk.wechat.friends;

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
import com.igexin.download.Downloads;
import java.util.HashMap;

public class Wechat extends Platform {
    public static final String NAME;
    private String f3494a;
    private String f3495b;
    private boolean f3496c;

    /* renamed from: cn.sharesdk.wechat.friends.Wechat.1 */
    class C10381 implements AuthorizeListener {
        final /* synthetic */ Wechat f3493a;

        C10381(Wechat wechat) {
            this.f3493a = wechat;
        }

        public void onCancel() {
            if (this.f3493a.listener != null) {
                this.f3493a.listener.onCancel(this.f3493a, 1);
            }
        }

        public void onComplete(Bundle bundle) {
            this.f3493a.afterRegister(1, null);
        }

        public void onError(Throwable th) {
            if (this.f3493a.listener != null) {
                this.f3493a.listener.onError(this.f3493a, 1, th);
            }
        }
    }

    public static class ShareParams extends cn.sharesdk.wechat.utils.WechatHelper.ShareParams {
        public ShareParams() {
            this.scene = 0;
        }
    }

    static {
        NAME = Wechat.class.getSimpleName();
    }

    public Wechat(Context context) {
        super(context);
    }

    private boolean m4624c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        C1051g c1051g = new C1051g(this, 22);
        c1051g.m4696a(this.f3494a, this.f3495b);
        return c1051g.m4697a();
    }

    protected boolean checkAuthorize(int i, Object obj) {
        if (isClientValid()) {
            if (i == 9 || isAuthValid() || m4624c()) {
                return true;
            }
            innerAuthorize(i, obj);
            return false;
        } else if (this.listener == null) {
            return false;
        } else {
            this.listener.onError(this, i, new WechatClientNotExistException());
            return false;
        }
    }

    protected void doAuthorize(String[] strArr) {
        if (!TextUtils.isEmpty(this.f3494a) && !TextUtils.isEmpty(this.f3495b)) {
            WechatHelper a = WechatHelper.m4635a();
            a.m4658a(this.context, this.f3494a);
            if (a.m4662c()) {
                C1051g c1051g = new C1051g(this, 22);
                c1051g.m4696a(this.f3494a, this.f3495b);
                C1053i c1053i = new C1053i(this);
                c1053i.m4712a(c1051g);
                c1053i.m4710a(new C10381(this));
                try {
                    a.m4656a(c1053i);
                } catch (Throwable th) {
                    if (this.listener != null) {
                        this.listener.onError(this, 1, th);
                    }
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
        shareParams.set("scene", Integer.valueOf(0));
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3494a);
        C1053i c1053i = new C1053i(this);
        if (this.f3496c) {
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
        return 22;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return !this.f3496c;
    }

    protected void initDevInfo(String str) {
        this.f3494a = getDevinfo("AppId");
        this.f3495b = getDevinfo("AppSecret");
        this.f3496c = "true".equals(getDevinfo("BypassApproval"));
        if (this.f3494a == null || this.f3494a.length() <= 0) {
            this.f3494a = getDevinfo("WechatMoments", "AppId");
            this.f3496c = "true".equals(getDevinfo("WechatMoments", "BypassApproval"));
            if (this.f3494a == null || this.f3494a.length() <= 0) {
                this.f3494a = getDevinfo("WechatFavorite", "AppId");
                if (this.f3494a != null && this.f3494a.length() > 0) {
                    copyDevinfo("WechatFavorite", NAME);
                    this.f3494a = getDevinfo("AppId");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                    return;
                }
                return;
            }
            copyDevinfo("WechatMoments", NAME);
            this.f3494a = getDevinfo("AppId");
            this.f3496c = "true".equals(getDevinfo("BypassApproval"));
            C0979d.m4390a().m4375d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    public boolean isClientValid() {
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3494a);
        return a.m4662c();
    }

    @Deprecated
    public boolean isValid() {
        WechatHelper a = WechatHelper.m4635a();
        a.m4658a(this.context, this.f3494a);
        return a.m4662c() && super.isValid();
    }

    protected void setNetworkDevinfo() {
        this.f3494a = getNetworkDevinfo("app_id", "AppId");
        this.f3495b = getNetworkDevinfo("app_secret", "AppSecret");
        if (this.f3494a == null || this.f3494a.length() <= 0) {
            this.f3494a = getNetworkDevinfo(23, "app_id", "AppId");
            if (this.f3494a == null || this.f3494a.length() <= 0) {
                this.f3494a = getNetworkDevinfo(37, "app_id", "AppId");
                if (this.f3494a != null && this.f3494a.length() > 0) {
                    copyNetworkDevinfo(37, 22);
                    this.f3494a = getNetworkDevinfo("app_id", "AppId");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                }
            } else {
                copyNetworkDevinfo(23, 22);
                this.f3494a = getNetworkDevinfo("app_id", "AppId");
                C0979d.m4390a().m4375d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
        if (this.f3495b == null || this.f3495b.length() <= 0) {
            this.f3495b = getNetworkDevinfo(23, "app_secret", "AppSecret");
            if (this.f3495b == null || this.f3495b.length() <= 0) {
                this.f3495b = getNetworkDevinfo(37, "app_secret", "AppSecret");
                if (this.f3495b != null && this.f3495b.length() > 0) {
                    copyNetworkDevinfo(37, 22);
                    this.f3495b = getNetworkDevinfo("app_secret", "AppSecret");
                    C0979d.m4390a().m4375d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                    return;
                }
                return;
            }
            copyNetworkDevinfo(23, 22);
            this.f3495b = getNetworkDevinfo("app_secret", "AppSecret");
            C0979d.m4390a().m4375d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    protected void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    protected void userInfor(String str) {
        if (!TextUtils.isEmpty(this.f3494a) && !TextUtils.isEmpty(this.f3495b)) {
            C1051g c1051g = new C1051g(this, 22);
            c1051g.m4696a(this.f3494a, this.f3495b);
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
