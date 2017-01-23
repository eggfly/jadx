package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p026b.p028b.C0955f.C0954a;
import cn.sharesdk.framework.utils.C0979d;
import com.igexin.download.Downloads;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.umeng.message.ALIAS_TYPE;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.HashMap;
import org.android.agoo.message.MessageService;

public class QZone extends Platform {
    public static final String NAME;
    private String f3451a;

    /* renamed from: cn.sharesdk.tencent.qzone.QZone.1 */
    class C10201 implements AuthorizeListener {
        final /* synthetic */ C1026b f3444a;
        final /* synthetic */ QZone f3445b;

        C10201(QZone qZone, C1026b c1026b) {
            this.f3445b = qZone;
            this.f3444a = c1026b;
        }

        public void onCancel() {
            if (this.f3445b.listener != null) {
                this.f3445b.listener.onCancel(this.f3445b, 1);
            }
        }

        public void onComplete(Bundle bundle) {
            String string = bundle.getString("open_id");
            String string2 = bundle.getString("access_token");
            String string3 = bundle.getString("expires_in");
            this.f3445b.db.putToken(string2);
            this.f3445b.db.putTokenSecret(BuildConfig.FLAVOR);
            try {
                this.f3445b.db.putExpiresIn(C4021R.parseLong(string3));
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
            this.f3445b.db.putUserId(string);
            string3 = bundle.getString("pf");
            String string4 = bundle.getString("pfkey");
            String string5 = bundle.getString("pay_token");
            this.f3445b.db.put("pf", string3);
            this.f3445b.db.put("pfkey", string4);
            this.f3445b.db.put("pay_token", string5);
            this.f3444a.m4570b(string);
            this.f3444a.m4572c(string2);
            this.f3445b.afterRegister(1, null);
        }

        public void onError(Throwable th) {
            if (this.f3445b.listener != null) {
                this.f3445b.listener.onError(this.f3445b, 1, th);
            }
        }
    }

    /* renamed from: cn.sharesdk.tencent.qzone.QZone.2 */
    class C10212 implements PlatformActionListener {
        final /* synthetic */ PlatformActionListener f3446a;
        final /* synthetic */ cn.sharesdk.framework.Platform.ShareParams f3447b;
        final /* synthetic */ QZone f3448c;

        C10212(QZone qZone, PlatformActionListener platformActionListener, cn.sharesdk.framework.Platform.ShareParams shareParams) {
            this.f3448c = qZone;
            this.f3446a = platformActionListener;
            this.f3447b = shareParams;
        }

        public void onCancel(Platform platform, int i) {
            if (this.f3446a != null) {
                this.f3446a.onCancel(platform, 9);
            }
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            this.f3448c.setPlatformActionListener(this.f3446a);
            this.f3448c.doShare(this.f3447b);
        }

        public void onError(Platform platform, int i, Throwable th) {
            if (this.f3446a != null) {
                this.f3446a.onError(platform, 9, th);
            }
        }
    }

    /* renamed from: cn.sharesdk.tencent.qzone.QZone.3 */
    class C10223 implements PlatformActionListener {
        final /* synthetic */ cn.sharesdk.framework.Platform.ShareParams f3449a;
        final /* synthetic */ QZone f3450b;

        C10223(QZone qZone, cn.sharesdk.framework.Platform.ShareParams shareParams) {
            this.f3450b = qZone;
            this.f3449a = shareParams;
        }

        public void onCancel(Platform platform, int i) {
            if (this.f3450b.listener != null) {
                this.f3450b.listener.onCancel(this.f3450b, 9);
            }
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            if (this.f3450b.listener != null) {
                hashMap.put("ShareParams", this.f3449a);
                this.f3450b.listener.onComplete(this.f3450b, 9, hashMap);
            }
        }

        public void onError(Platform platform, int i, Throwable th) {
            if (this.f3450b.listener != null) {
                this.f3450b.listener.onError(this.f3450b, 9, th);
            }
        }
    }

    public static class ShareParams extends cn.sharesdk.framework.Platform.ShareParams {
        @Deprecated
        public String comment;
        @Deprecated
        public String imageUrl;
        @Deprecated
        public String site;
        @Deprecated
        public String siteUrl;
        @Deprecated
        public String title;
        @Deprecated
        public String titleUrl;
        @Deprecated
        boolean webShare;
    }

    static {
        NAME = QZone.class.getSimpleName();
    }

    public QZone(Context context) {
        super(context);
    }

    private void m4538a(cn.sharesdk.framework.Platform.ShareParams shareParams) {
        Object imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        boolean isShareTencentWeibo = shareParams.isShareTencentWeibo();
        try {
            if (TextUtils.isEmpty(imagePath) && !TextUtils.isEmpty(imageUrl)) {
                shareParams.setImagePath(BitmapHelper.downloadBitmap(this.context, imageUrl));
                doShare(shareParams);
            } else if (isAuthValid()) {
                imageUrl = shareParams.getText();
                if (!TextUtils.isEmpty(imageUrl)) {
                    String shortLintk = getShortLintk(imageUrl, false);
                    C1026b a = C1026b.m4559a((Platform) this);
                    HashMap b = isShareTencentWeibo ? a.m4569b(imagePath, shortLintk) : a.m4562a(imagePath, shortLintk);
                    if (b == null && this.listener != null) {
                        this.listener.onError(this, 9, new Throwable("response is empty"));
                    }
                    b.put("ShareParams", shareParams);
                    if (this.listener != null) {
                        this.listener.onComplete(this, 9, b);
                    }
                } else if (this.listener != null) {
                    this.listener.onError(this, 9, new Throwable("share params' value of text is empty!"));
                }
            } else {
                setPlatformActionListener(new C10212(this, getPlatformActionListener(), shareParams));
                authorize();
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th);
            }
        }
    }

    private void m4541b(cn.sharesdk.framework.Platform.ShareParams shareParams) {
        try {
            String imageUrl = shareParams.getImageUrl();
            String imagePath = shareParams.getImagePath();
            if (isClientValid()) {
                if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
                    imagePath = imageUrl;
                }
                String title = shareParams.getTitle();
                String titleUrl = shareParams.getTitleUrl();
                String site = shareParams.getSite();
                String text = shareParams.getText();
                if (!TextUtils.isEmpty(text)) {
                    text = getShortLintk(text, false);
                }
                if (!TextUtils.isEmpty(titleUrl)) {
                    titleUrl = getShortLintk(titleUrl, false);
                }
                C1026b.m4559a((Platform) this).m4566a(title, titleUrl, text, imagePath, site, new C10223(this, shareParams));
            } else if (this.listener != null) {
                this.listener.onError(this, 9, new QQClientNotExistException());
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th);
            }
        }
    }

    protected boolean checkAuthorize(int i, Object obj) {
        if (isAuthValid() || i == 9) {
            C1026b a = C1026b.m4559a((Platform) this);
            a.m4565a(this.f3451a);
            a.m4570b(this.db.getUserId());
            a.m4572c(this.db.getToken());
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    protected void doAuthorize(String[] strArr) {
        C1026b a = C1026b.m4559a((Platform) this);
        a.m4565a(this.f3451a);
        a.m4567a(strArr);
        a.m4564a(new C10201(this, a), isSSODisable());
    }

    protected void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        HashMap a = C1026b.m4559a((Platform) this).m4563a(str, str2, hashMap, hashMap2);
        if (a == null || a.size() <= 0) {
            if (this.listener != null) {
                this.listener.onError(this, i, new Throwable());
            }
        } else if (a.containsKey(KEYS.RET)) {
            if (((Integer) a.get(KEYS.RET)).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(a)));
                }
            } else if (this.listener != null) {
                this.listener.onComplete(this, i, a);
            }
        } else if (this.listener != null) {
            this.listener.onError(this, i, new Throwable());
        }
    }

    protected void doShare(cn.sharesdk.framework.Platform.ShareParams shareParams) {
        if (shareParams.isShareTencentWeibo()) {
            m4538a(shareParams);
        } else {
            m4541b(shareParams);
        }
    }

    protected HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> hashMap) {
        return null;
    }

    protected C0954a filterShareContent(cn.sharesdk.framework.Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        C0954a c0954a = new C0954a();
        c0954a.f3249b = shareParams.getText();
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        if (imagePath != null) {
            c0954a.f3252e.add(imagePath);
        } else if (hashMap.get("large_url") != null) {
            c0954a.f3251d.add(String.valueOf(hashMap.get("large_url")));
        } else if (hashMap.get("small_url") != null) {
            c0954a.f3251d.add(String.valueOf(hashMap.get("small_url")));
        } else if (imageUrl != null) {
            c0954a.f3251d.add(imageUrl);
        }
        imageUrl = shareParams.getTitleUrl();
        if (imageUrl != null) {
            c0954a.f3250c.add(imageUrl);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Downloads.COLUMN_TITLE, shareParams.getTitle());
        hashMap2.put("titleUrl", shareParams.getTitleUrl());
        hashMap2.put("site", shareParams.getSite());
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
        return 6;
    }

    public int getVersion() {
        return 2;
    }

    public boolean hasShareCallback() {
        return true;
    }

    protected void initDevInfo(String str) {
        this.f3451a = getDevinfo("AppId");
        if (this.f3451a == null || this.f3451a.length() <= 0) {
            this.f3451a = getDevinfo(ALIAS_TYPE.QQ, "AppId");
            if (this.f3451a != null && this.f3451a.length() > 0) {
                copyDevinfo(ALIAS_TYPE.QQ, NAME);
                this.f3451a = getDevinfo("AppId");
                C0979d.m4390a().m4375d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
    }

    public boolean isClientValid() {
        C1026b a = C1026b.m4559a((Platform) this);
        a.m4565a(this.f3451a);
        return a.m4568a();
    }

    protected void setNetworkDevinfo() {
        this.f3451a = getNetworkDevinfo("app_id", "AppId");
        if (this.f3451a == null || this.f3451a.length() <= 0) {
            this.f3451a = getNetworkDevinfo(24, "app_id", "AppId");
            if (this.f3451a != null && this.f3451a.length() > 0) {
                copyNetworkDevinfo(24, 6);
                this.f3451a = getNetworkDevinfo("app_id", "AppId");
                C0979d.m4390a().m4375d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
    }

    protected void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    protected void userInfor(String str) {
        if (str == null || str.length() < 0) {
            str = this.db.getUserId();
        }
        if (str != null && str.length() >= 0) {
            try {
                HashMap d = C1026b.m4559a((Platform) this).m4573d(str);
                if (d == null || d.size() <= 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable());
                    }
                } else if (d.containsKey(KEYS.RET)) {
                    if (((Integer) d.get(KEYS.RET)).intValue() == 0) {
                        if (str == this.db.getUserId()) {
                            this.db.put("nickname", String.valueOf(d.get("nickname")));
                            if (d.containsKey("figureurl_qq_1")) {
                                this.db.put("iconQQ", String.valueOf(d.get("figureurl_qq_1")));
                            } else if (d.containsKey("figureurl_qq_2")) {
                                this.db.put("iconQQ", String.valueOf(d.get("figureurl_qq_2")));
                            }
                            if (d.containsKey("figureurl_2")) {
                                this.db.put("icon", String.valueOf(d.get("figureurl_2")));
                            } else if (d.containsKey("figureurl_1")) {
                                this.db.put("icon", String.valueOf(d.get("figureurl_1")));
                            } else if (d.containsKey("figureurl")) {
                                this.db.put("icon", String.valueOf(d.get("figureurl")));
                            }
                            this.db.put("secretType", String.valueOf(d.get("is_yellow_vip")));
                            if (String.valueOf(d.get("is_yellow_vip")).equals(MessageService.MSG_DB_NOTIFY_REACHED)) {
                                this.db.put("snsUserLevel", String.valueOf(d.get("level")));
                            }
                            String valueOf = String.valueOf(d.get("gender"));
                            if (valueOf.equals("\u7537")) {
                                this.db.put("gender", MessageService.MSG_DB_READY_REPORT);
                            } else if (valueOf.equals("\u5973")) {
                                this.db.put("gender", MessageService.MSG_DB_NOTIFY_REACHED);
                            } else {
                                this.db.put("gender", MessageService.MSG_DB_NOTIFY_CLICK);
                            }
                        }
                        if (this.listener != null) {
                            this.listener.onComplete(this, 8, d);
                        }
                    } else if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(d)));
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
