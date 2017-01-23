package cn.sharesdk.onekeyshare;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import anet.channel.strategy.dispatch.C0714a;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.UIHandler;
import com.umeng.message.ALIAS_TYPE;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;

public abstract class OnekeyShareThemeImpl implements Callback, PlatformActionListener {
    protected PlatformActionListener callback;
    protected Context context;
    protected ArrayList<CustomerLogo> customerLogos;
    protected ShareContentCustomizeCallback customizeCallback;
    protected boolean dialogMode;
    protected boolean disableSSO;
    protected HashMap<String, String> hiddenPlatforms;
    protected HashMap<String, Object> shareParamsMap;
    protected boolean silent;

    /* renamed from: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.1 */
    class C09841 implements Callback {
        final /* synthetic */ String val$resOrName;

        C09841(String str) {
            this.val$resOrName = str;
        }

        public boolean handleMessage(Message message) {
            int stringRes = C4021R.getStringRes(OnekeyShareThemeImpl.this.context, this.val$resOrName);
            if (stringRes > 0) {
                Toast.makeText(OnekeyShareThemeImpl.this.context, stringRes, 0).show();
            } else {
                Toast.makeText(OnekeyShareThemeImpl.this.context, this.val$resOrName, 0).show();
            }
            return false;
        }
    }

    public OnekeyShareThemeImpl() {
        this.callback = this;
    }

    private void prepareForEditPage(Platform platform) {
        if (formateShareData(platform)) {
            ShareParams shareDataToShareParams = shareDataToShareParams(platform);
            if (shareDataToShareParams != null) {
                ShareSDK.logDemoEvent(3, null);
                if (this.customizeCallback != null) {
                    this.customizeCallback.onShare(platform, shareDataToShareParams);
                }
                showEditPage(this.context, platform, shareDataToShareParams);
            }
        }
    }

    private void toast(String str) {
        UIHandler.sendEmptyMessage(0, new C09841(str));
    }

    public final void disableSSO() {
        this.disableSSO = true;
    }

    final boolean formateShareData(Platform platform) {
        String name = platform.getName();
        boolean z = "Alipay".equals(name) || "AlipayMoments".equals(name);
        if (z && !platform.isClientValid()) {
            toast("ssdk_alipay_client_inavailable");
            return false;
        } else if ("KakaoTalk".equals(name) && !platform.isClientValid()) {
            toast("ssdk_kakaotalk_client_inavailable");
            return false;
        } else if ("KakaoStory".equals(name) && !platform.isClientValid()) {
            toast("ssdk_kakaostory_client_inavailable");
            return false;
        } else if ("Line".equals(name) && !platform.isClientValid()) {
            toast("ssdk_line_client_inavailable");
            return false;
        } else if ("WhatsApp".equals(name) && !platform.isClientValid()) {
            toast("ssdk_whatsapp_client_inavailable");
            return false;
        } else if ("Pinterest".equals(name) && !platform.isClientValid()) {
            toast("ssdk_pinterest_client_inavailable");
            return false;
        } else if ("Instagram".equals(name) && !platform.isClientValid()) {
            toast("ssdk_instagram_client_inavailable");
            return false;
        } else if (!"QZone".equals(name) || platform.isClientValid()) {
            z = "Laiwang".equals(name);
            boolean equals = "LaiwangMoments".equals(name);
            if ((z || equals) && !platform.isClientValid()) {
                toast("ssdk_laiwang_client_inavailable");
                return false;
            }
            z = "YixinMoments".equals(name) || "Yixin".equals(name);
            if (!z || platform.isClientValid()) {
                z = "WechatFavorite".equals(name) || "Wechat".equals(name) || "WechatMoments".equals(name);
                if (z && !platform.isClientValid()) {
                    toast("ssdk_wechat_client_inavailable");
                    return false;
                } else if ("FacebookMessenger".equals(name) && !platform.isClientValid()) {
                    toast("ssdk_facebookmessenger_client_inavailable");
                    return false;
                } else if (this.shareParamsMap.containsKey("shareType")) {
                    return true;
                } else {
                    int i;
                    String valueOf = String.valueOf(this.shareParamsMap.get("imagePath"));
                    if (valueOf == null || !new File(valueOf).exists()) {
                        Bitmap bitmap = (Bitmap) C4021R.forceCast(this.shareParamsMap.get("viewToShare"));
                        if (bitmap == null || bitmap.isRecycled()) {
                            Object obj = this.shareParamsMap.get("imageUrl");
                            if (obj == null || TextUtils.isEmpty(String.valueOf(obj))) {
                                i = 1;
                            } else if (String.valueOf(obj).endsWith(".gif") && z) {
                                i = 9;
                            } else {
                                if (this.shareParamsMap.containsKey("url") && !TextUtils.isEmpty(this.shareParamsMap.get("url").toString())) {
                                    if (this.shareParamsMap.containsKey("musicUrl") && !TextUtils.isEmpty(this.shareParamsMap.get("musicUrl").toString()) && z) {
                                        i = 5;
                                    }
                                    i = 4;
                                }
                                i = 2;
                            }
                        } else {
                            if (this.shareParamsMap.containsKey("url") && !TextUtils.isEmpty(this.shareParamsMap.get("url").toString())) {
                                if (this.shareParamsMap.containsKey("musicUrl") && !TextUtils.isEmpty(this.shareParamsMap.get("musicUrl").toString()) && z) {
                                    i = 5;
                                }
                                i = 4;
                            }
                            i = 2;
                        }
                    } else if (valueOf.endsWith(".gif") && z) {
                        i = 9;
                    } else {
                        if (this.shareParamsMap.containsKey("url") && !TextUtils.isEmpty(this.shareParamsMap.get("url").toString())) {
                            if (this.shareParamsMap.containsKey("musicUrl") && !TextUtils.isEmpty(this.shareParamsMap.get("musicUrl").toString()) && z) {
                                i = 5;
                            }
                            i = 4;
                        }
                        i = 2;
                    }
                    this.shareParamsMap.put("shareType", Integer.valueOf(i));
                    return true;
                }
            }
            toast("ssdk_yixin_client_inavailable");
            return false;
        } else {
            toast("ssdk_qq_client_inavailable");
            return false;
        }
    }

    public final boolean handleMessage(Message message) {
        switch (message.arg1) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                int stringRes = C4021R.getStringRes(this.context, "ssdk_oks_share_completed");
                if (stringRes > 0) {
                    toast(this.context.getString(stringRes));
                    break;
                }
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                String simpleName = message.obj.getClass().getSimpleName();
                if (!"WechatClientNotExistException".equals(simpleName) && !"WechatTimelineNotSupportedException".equals(simpleName) && !"WechatFavoriteNotSupportedException".equals(simpleName)) {
                    if (!"GooglePlusClientNotExistException".equals(simpleName)) {
                        if (!"QQClientNotExistException".equals(simpleName)) {
                            if (!"YixinClientNotExistException".equals(simpleName) && !"YixinTimelineNotSupportedException".equals(simpleName)) {
                                if (!"KakaoTalkClientNotExistException".equals(simpleName)) {
                                    if (!"KakaoStoryClientNotExistException".equals(simpleName)) {
                                        if (!"WhatsAppClientNotExistException".equals(simpleName)) {
                                            if (!"FacebookMessengerClientNotExistException".equals(simpleName)) {
                                                toast("ssdk_oks_share_failed");
                                                break;
                                            }
                                            toast("ssdk_facebookmessenger_client_inavailable");
                                            break;
                                        }
                                        toast("ssdk_whatsapp_client_inavailable");
                                        break;
                                    }
                                    toast("ssdk_kakaostory_client_inavailable");
                                    break;
                                }
                                toast("ssdk_kakaotalk_client_inavailable");
                                break;
                            }
                            toast("ssdk_yixin_client_inavailable");
                            break;
                        }
                        toast("ssdk_qq_client_inavailable");
                        break;
                    }
                    toast("ssdk_google_plus_client_inavailable");
                    break;
                }
                toast("ssdk_wechat_client_inavailable");
                break;
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                toast("ssdk_oks_share_canceled");
                break;
        }
        return false;
    }

    final boolean isUseClientToShare(Platform platform) {
        String name = platform.getName();
        if ("Wechat".equals(name) || "WechatMoments".equals(name) || "WechatFavorite".equals(name) || "ShortMessage".equals(name) || "Email".equals(name) || "Qzone".equals(name) || ALIAS_TYPE.QQ.equals(name) || "Pinterest".equals(name) || "Instagram".equals(name) || "Yixin".equals(name) || "YixinMoments".equals(name) || "QZone".equals(name) || "Mingdao".equals(name) || "Line".equals(name) || "KakaoStory".equals(name) || "KakaoTalk".equals(name) || "Bluetooth".equals(name) || "WhatsApp".equals(name) || "BaiduTieba".equals(name) || "Laiwang".equals(name) || "LaiwangMoments".equals(name) || "Alipay".equals(name) || "AlipayMoments".equals(name) || "FacebookMessenger".equals(name) || "GooglePlus".equals(name)) {
            return true;
        }
        if ("Evernote".equals(name)) {
            if ("true".equals(platform.getDevinfo("ShareByAppClient"))) {
                return true;
            }
        } else if ("SinaWeibo".equals(name) && "true".equals(platform.getDevinfo("ShareByAppClient"))) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.sina.weibo");
            intent.setType("image/*");
            ResolveInfo resolveActivity = platform.getContext().getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null) {
                intent = new Intent("android.intent.action.SEND");
                intent.setPackage("com.sina.weibog3");
                intent.setType("image/*");
                resolveActivity = platform.getContext().getPackageManager().resolveActivity(intent, 0);
            }
            return resolveActivity != null;
        }
        return false;
    }

    public final void onCancel(Platform platform, int i) {
        Message message = new Message();
        message.arg1 = 3;
        message.arg2 = i;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(5, platform);
    }

    public final void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Message message = new Message();
        message.arg1 = 1;
        message.arg2 = i;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
    }

    public final void onError(Platform platform, int i, Throwable th) {
        th.printStackTrace();
        Message message = new Message();
        message.arg1 = 2;
        message.arg2 = i;
        message.obj = th;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(4, platform);
    }

    public final void setCustomerLogos(ArrayList<CustomerLogo> arrayList) {
        this.customerLogos = arrayList;
    }

    public final void setDialogMode(boolean z) {
        this.dialogMode = z;
    }

    public final void setHiddenPlatforms(HashMap<String, String> hashMap) {
        this.hiddenPlatforms = hashMap;
    }

    public final void setPlatformActionListener(PlatformActionListener platformActionListener) {
        if (platformActionListener == null) {
            platformActionListener = this;
        }
        this.callback = platformActionListener;
    }

    public final void setShareContentCustomizeCallback(ShareContentCustomizeCallback shareContentCustomizeCallback) {
        this.customizeCallback = shareContentCustomizeCallback;
    }

    public final void setShareParamsMap(HashMap<String, Object> hashMap) {
        this.shareParamsMap = hashMap;
    }

    public final void setSilent(boolean z) {
        this.silent = z;
    }

    final ShareParams shareDataToShareParams(Platform platform) {
        if (platform == null || this.shareParamsMap == null) {
            toast("ssdk_oks_share_failed");
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) C4021R.forceCast(this.shareParamsMap.get("viewToShare"));
            if (!(!TextUtils.isEmpty((String) C4021R.forceCast(this.shareParamsMap.get("imagePath"))) || bitmap == null || bitmap.isRecycled())) {
                File file = new File(C4021R.getCachePath(platform.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
                OutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                this.shareParamsMap.put("imagePath", file.getAbsolutePath());
            }
            return new ShareParams(this.shareParamsMap);
        } catch (Throwable th) {
            th.printStackTrace();
            toast("ssdk_oks_share_failed");
            return null;
        }
    }

    final void shareSilently(Platform platform) {
        if (formateShareData(platform)) {
            ShareParams shareDataToShareParams = shareDataToShareParams(platform);
            if (shareDataToShareParams != null) {
                toast("ssdk_oks_sharing");
                if (this.customizeCallback != null) {
                    this.customizeCallback.onShare(platform, shareDataToShareParams);
                }
                if (this.disableSSO) {
                    platform.SSOSetting(this.disableSSO);
                }
                platform.setPlatformActionListener(this.callback);
                platform.share(shareDataToShareParams);
            }
        }
    }

    public final void show(Context context) {
        this.context = context;
        if (this.shareParamsMap.containsKey(C0714a.PLATFORM)) {
            Platform platform = ShareSDK.getPlatform(String.valueOf(this.shareParamsMap.get(C0714a.PLATFORM)));
            boolean z = platform instanceof CustomPlatform;
            boolean isUseClientToShare = isUseClientToShare(platform);
            if (this.silent || z || isUseClientToShare) {
                shareSilently(platform);
                return;
            } else {
                prepareForEditPage(platform);
                return;
            }
        }
        showPlatformPage(context);
    }

    protected abstract void showEditPage(Context context, Platform platform, ShareParams shareParams);

    protected abstract void showPlatformPage(Context context);
}
