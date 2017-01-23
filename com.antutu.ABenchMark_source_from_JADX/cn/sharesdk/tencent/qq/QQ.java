package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p026b.p028b.C0955f.C0954a;
import cn.sharesdk.framework.utils.C0979d;
import com.google.analytics.tracking.android.ModelFields;
import com.igexin.download.Downloads;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import org.android.agoo.message.MessageService;

public class QQ extends Platform {
    public static final String NAME;
    private String f3403a;
    private boolean f3404b;
    private boolean f3405c;

    /* renamed from: cn.sharesdk.tencent.qq.QQ.1 */
    class C10061 implements AuthorizeListener {
        final /* synthetic */ C1011b f3399a;
        final /* synthetic */ QQ f3400b;

        C10061(QQ qq, C1011b c1011b) {
            this.f3400b = qq;
            this.f3399a = c1011b;
        }

        public void onCancel() {
            if (this.f3400b.listener != null) {
                this.f3400b.listener.onCancel(this.f3400b, 1);
            }
        }

        public void onComplete(Bundle bundle) {
            String string = bundle.getString("open_id");
            String string2 = bundle.getString("access_token");
            String string3 = bundle.getString("expires_in");
            this.f3400b.db.putToken(string2);
            this.f3400b.db.putTokenSecret(BuildConfig.FLAVOR);
            try {
                this.f3400b.db.putExpiresIn(C4021R.parseLong(string3));
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
            this.f3400b.db.putUserId(string);
            string3 = bundle.getString("pf");
            String string4 = bundle.getString("pfkey");
            String string5 = bundle.getString("pay_token");
            this.f3400b.db.put("pf", string3);
            this.f3400b.db.put("pfkey", string4);
            this.f3400b.db.put("pay_token", string5);
            this.f3399a.m4507b(string);
            this.f3399a.m4509d(string2);
            this.f3400b.afterRegister(1, null);
        }

        public void onError(Throwable th) {
            if (this.f3400b.listener != null) {
                this.f3400b.listener.onError(this.f3400b, 1, th);
            }
        }
    }

    /* renamed from: cn.sharesdk.tencent.qq.QQ.2 */
    class C10072 implements PlatformActionListener {
        final /* synthetic */ cn.sharesdk.framework.Platform.ShareParams f3401a;
        final /* synthetic */ QQ f3402b;

        C10072(QQ qq, cn.sharesdk.framework.Platform.ShareParams shareParams) {
            this.f3402b = qq;
            this.f3401a = shareParams;
        }

        public void onCancel(Platform platform, int i) {
            if (this.f3402b.listener != null) {
                this.f3402b.listener.onCancel(this.f3402b, 9);
            }
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            HashMap hashMap2 = new HashMap();
            if (hashMap != null) {
                hashMap2.putAll(hashMap);
            }
            hashMap2.put("ShareParams", this.f3401a);
            if (this.f3402b.listener != null) {
                this.f3402b.listener.onComplete(this.f3402b, 9, hashMap2);
            }
        }

        public void onError(Platform platform, int i, Throwable th) {
            if (this.f3402b.listener != null) {
                this.f3402b.listener.onError(this.f3402b, 9, th);
            }
        }
    }

    public static class ShareParams extends cn.sharesdk.framework.Platform.ShareParams {
        @Deprecated
        public String imageUrl;
        @Deprecated
        public String musicUrl;
        @Deprecated
        public String title;
        @Deprecated
        public String titleUrl;
    }

    static {
        NAME = QQ.class.getSimpleName();
    }

    public QQ(Context context) {
        super(context);
        this.f3405c = true;
    }

    protected boolean checkAuthorize(int i, Object obj) {
        if (isAuthValid() || (i == 9 && obj != null && (obj instanceof cn.sharesdk.framework.Platform.ShareParams) && !((cn.sharesdk.framework.Platform.ShareParams) obj).isShareTencentWeibo())) {
            C1011b a = C1011b.m4497a((Platform) this);
            a.m4503a(this.f3403a);
            a.m4507b(this.db.getUserId());
            a.m4509d(this.db.getToken());
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    protected void doAuthorize(String[] strArr) {
        C1011b a = C1011b.m4497a((Platform) this);
        a.m4503a(this.f3403a);
        a.m4505a(strArr);
        a.m4502a(new C10061(this, a), isSSODisable());
    }

    protected void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        if (this.listener != null) {
            this.listener.onCancel(this, i);
        }
    }

    protected void doShare(cn.sharesdk.framework.Platform.ShareParams shareParams) {
        Object title = shareParams.getTitle();
        String text = shareParams.getText();
        Object imagePath = shareParams.getImagePath();
        Object imageUrl = shareParams.getImageUrl();
        Object musicUrl = shareParams.getMusicUrl();
        String titleUrl = shareParams.getTitleUrl();
        boolean isShareTencentWeibo = shareParams.isShareTencentWeibo();
        int hidden = shareParams.getHidden();
        if (!TextUtils.isEmpty(title) || !TextUtils.isEmpty(text) || !TextUtils.isEmpty(imagePath) || !TextUtils.isEmpty(imageUrl) || !TextUtils.isEmpty(musicUrl)) {
            C1011b a = C1011b.m4497a((Platform) this);
            PlatformActionListener c10072 = new C10072(this, shareParams);
            if (!TextUtils.isEmpty(titleUrl)) {
                titleUrl = getShortLintk(titleUrl, false);
            }
            if (!TextUtils.isEmpty(text)) {
                text = getShortLintk(text, false);
            }
            a.m4504a(title, titleUrl, text, imagePath, imageUrl, musicUrl, this.f3404b, c10072, isShareTencentWeibo, hidden);
        } else if (this.listener != null) {
            this.listener.onError(this, 9, new Throwable("qq share must have one param at least"));
        }
    }

    protected HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> hashMap) {
        return null;
    }

    protected C0954a filterShareContent(cn.sharesdk.framework.Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        C0954a c0954a = new C0954a();
        String titleUrl = shareParams.getTitleUrl();
        c0954a.f3250c.add(titleUrl);
        c0954a.f3248a = this.f3403a;
        Object text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            c0954a.f3249b = text;
        }
        CharSequence imageUrl = shareParams.getImageUrl();
        CharSequence imagePath = shareParams.getImagePath();
        if (!TextUtils.isEmpty(imagePath)) {
            c0954a.f3252e.add(imagePath);
        } else if (!TextUtils.isEmpty(imageUrl)) {
            c0954a.f3251d.add(imageUrl);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Downloads.COLUMN_TITLE, shareParams.getTitle());
        hashMap2.put("url", titleUrl);
        hashMap2.put("imageLocalUrl", imagePath);
        hashMap2.put("summary", text);
        hashMap2.put(ModelFields.APP_NAME, DeviceHelper.getInstance(this.context).getAppName());
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
        return 24;
    }

    public int getVersion() {
        return 2;
    }

    public boolean hasShareCallback() {
        return this.f3405c;
    }

    protected void initDevInfo(String str) {
        this.f3403a = getDevinfo("AppId");
        this.f3404b = "true".equals(getDevinfo("ShareByAppClient"));
        if (this.f3403a == null || this.f3403a.length() <= 0) {
            this.f3403a = getDevinfo("QZone", "AppId");
            if (this.f3403a != null && this.f3403a.length() > 0) {
                copyDevinfo("QZone", NAME);
                this.f3403a = getDevinfo("AppId");
                this.f3404b = "true".equals(getDevinfo("ShareByAppClient"));
                C0979d.m4390a().m4375d("Try to use the dev info of QZone, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
    }

    public boolean isClientValid() {
        C1011b a = C1011b.m4497a((Platform) this);
        a.m4503a(this.f3403a);
        return a.m4506a();
    }

    protected void setNetworkDevinfo() {
        this.f3403a = getNetworkDevinfo("app_id", "AppId");
        if (this.f3403a == null || this.f3403a.length() <= 0) {
            this.f3403a = getNetworkDevinfo(6, "app_id", "AppId");
            if (this.f3403a != null && this.f3403a.length() > 0) {
                copyNetworkDevinfo(6, 24);
                this.f3403a = getNetworkDevinfo("app_id", "AppId");
                C0979d.m4390a().m4375d("Try to use the dev info of QZone, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
    }

    protected void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    protected String uploadImageToFileServer(String str) {
        return super.uploadImageToFileServer(str);
    }

    protected void userInfor(String str) {
        if (str == null || str.length() < 0) {
            str = this.db.getUserId();
        }
        if (str != null && str.length() >= 0) {
            try {
                HashMap e = C1011b.m4497a((Platform) this).m4510e(str);
                if (e == null || e.size() <= 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable());
                    }
                } else if (e.containsKey(KEYS.RET)) {
                    if (((Integer) e.get(KEYS.RET)).intValue() == 0) {
                        if (str == this.db.getUserId()) {
                            this.db.put("nickname", String.valueOf(e.get("nickname")));
                            if (e.containsKey("figureurl_qq_1")) {
                                this.db.put("icon", String.valueOf(e.get("figureurl_qq_1")));
                            } else if (e.containsKey("figureurl_qq_2")) {
                                this.db.put("icon", String.valueOf(e.get("figureurl_qq_2")));
                            }
                            if (e.containsKey("figureurl_2")) {
                                this.db.put("iconQzone", String.valueOf(e.get("figureurl_2")));
                            } else if (e.containsKey("figureurl_1")) {
                                this.db.put("iconQzone", String.valueOf(e.get("figureurl_1")));
                            } else if (e.containsKey("figureurl")) {
                                this.db.put("iconQzone", String.valueOf(e.get("figureurl")));
                            }
                            this.db.put("secretType", String.valueOf(e.get("is_yellow_vip")));
                            if (String.valueOf(e.get("is_yellow_vip")).equals(MessageService.MSG_DB_NOTIFY_REACHED)) {
                                this.db.put("snsUserLevel", String.valueOf(e.get("level")));
                            }
                            String valueOf = String.valueOf(e.get("gender"));
                            if (valueOf.equals("\u7537")) {
                                this.db.put("gender", MessageService.MSG_DB_READY_REPORT);
                            } else if (valueOf.equals("\u5973")) {
                                this.db.put("gender", MessageService.MSG_DB_NOTIFY_REACHED);
                            } else {
                                this.db.put("gender", MessageService.MSG_DB_NOTIFY_CLICK);
                            }
                        }
                        if (this.listener != null) {
                            this.listener.onComplete(this, 8, e);
                        }
                    } else if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(e)));
                    }
                } else if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable());
                }
            } catch (Throwable th) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, th);
                }
            }
        } else if (this.listener != null) {
            this.listener.onError(this, 8, new RuntimeException("qq account is null"));
        }
    }
}
