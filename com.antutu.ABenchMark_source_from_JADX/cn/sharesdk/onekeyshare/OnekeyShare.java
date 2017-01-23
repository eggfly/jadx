package cn.sharesdk.onekeyshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import anet.channel.strategy.dispatch.C0714a;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import com.igexin.download.Downloads;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import java.util.ArrayList;
import java.util.HashMap;

public class OnekeyShare {
    private HashMap<String, Object> params;

    public OnekeyShare() {
        this.params = new HashMap();
        this.params.put("customers", new ArrayList());
        this.params.put("hiddenPlatforms", new HashMap());
    }

    public void addHiddenPlatform(String str) {
        ((HashMap) C4021R.forceCast(this.params.get("hiddenPlatforms"))).put(str, str);
    }

    public void disableSSOWhenAuthorize() {
        this.params.put("disableSSO", Boolean.valueOf(true));
    }

    public PlatformActionListener getCallback() {
        return (PlatformActionListener) C4021R.forceCast(this.params.get("callback"));
    }

    public ShareContentCustomizeCallback getShareContentCustomizeCallback() {
        return (ShareContentCustomizeCallback) C4021R.forceCast(this.params.get("customizeCallback"));
    }

    public String getText() {
        return this.params.containsKey("text") ? String.valueOf(this.params.get("text")) : null;
    }

    public void setAddress(String str) {
        this.params.put("address", str);
    }

    public void setCallback(PlatformActionListener platformActionListener) {
        this.params.put("callback", platformActionListener);
    }

    public void setComment(String str) {
        this.params.put("comment", str);
    }

    public void setCustomerLogo(Bitmap bitmap, String str, OnClickListener onClickListener) {
        CustomerLogo customerLogo = new CustomerLogo();
        customerLogo.logo = bitmap;
        customerLogo.label = str;
        customerLogo.listener = onClickListener;
        ((ArrayList) C4021R.forceCast(this.params.get("customers"))).add(customerLogo);
    }

    @Deprecated
    public void setDialogMode() {
        this.params.put("dialogMode", Boolean.valueOf(true));
    }

    public void setExecuteUrl(String str) {
        this.params.put("executeurl", str);
    }

    public void setFilePath(String str) {
        this.params.put("filePath", str);
    }

    public void setImageArray(String[] strArr) {
        this.params.put("imageArray", strArr);
    }

    public void setImagePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.params.put("imagePath", str);
        }
    }

    public void setImageUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.params.put("imageUrl", str);
        }
    }

    public void setInstallUrl(String str) {
        this.params.put("installurl", str);
    }

    public void setLatitude(float f) {
        this.params.put("latitude", Float.valueOf(f));
    }

    public void setLongitude(float f) {
        this.params.put("longitude", Float.valueOf(f));
    }

    public void setMusicUrl(String str) {
        this.params.put("musicUrl", str);
    }

    public void setPlatform(String str) {
        this.params.put(C0714a.PLATFORM, str);
    }

    public void setShareContentCustomizeCallback(ShareContentCustomizeCallback shareContentCustomizeCallback) {
        this.params.put("customizeCallback", shareContentCustomizeCallback);
    }

    public void setShareToTencentWeiboWhenPerformingQQOrQZoneSharing() {
        this.params.put("isShareTencentWeibo", Boolean.valueOf(true));
    }

    public void setSilent(boolean z) {
        this.params.put("silent", Boolean.valueOf(z));
    }

    public void setSite(String str) {
        this.params.put("site", str);
    }

    public void setSiteUrl(String str) {
        this.params.put("siteUrl", str);
    }

    public void setText(String str) {
        this.params.put("text", str);
    }

    public void setTheme(OnekeyShareTheme onekeyShareTheme) {
        this.params.put("theme", Integer.valueOf(onekeyShareTheme.getValue()));
    }

    public void setTitle(String str) {
        this.params.put(Downloads.COLUMN_TITLE, str);
    }

    public void setTitleUrl(String str) {
        this.params.put("titleUrl", str);
    }

    public void setUrl(String str) {
        this.params.put("url", str);
    }

    public void setVenueDescription(String str) {
        this.params.put("venueDescription", str);
    }

    public void setVenueName(String str) {
        this.params.put("venueName", str);
    }

    public void setVideoUrl(String str) {
        this.params.put("url", str);
        this.params.put("shareType", Integer.valueOf(6));
    }

    public void setViewToShare(View view) {
        try {
            this.params.put("viewToShare", BitmapHelper.captureView(view, view.getWidth(), view.getHeight()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void show(Context context) {
        int parseInt;
        boolean z = false;
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.params);
        ShareSDK.initSDK(context.getApplicationContext());
        ShareSDK.logDemoEvent(1, null);
        try {
            parseInt = C4021R.parseInt(String.valueOf(hashMap.remove("theme")));
        } catch (Throwable th) {
            parseInt = 0;
        }
        OnekeyShareThemeImpl impl = OnekeyShareTheme.fromValue(parseInt).getImpl();
        impl.setShareParamsMap(hashMap);
        impl.setDialogMode(hashMap.containsKey("dialogMode") ? ((Boolean) hashMap.remove("dialogMode")).booleanValue() : false);
        if (hashMap.containsKey("silent")) {
            z = ((Boolean) hashMap.remove("silent")).booleanValue();
        }
        impl.setSilent(z);
        impl.setCustomerLogos((ArrayList) hashMap.remove("customers"));
        impl.setHiddenPlatforms((HashMap) hashMap.remove("hiddenPlatforms"));
        impl.setPlatformActionListener((PlatformActionListener) hashMap.remove("callback"));
        impl.setShareContentCustomizeCallback((ShareContentCustomizeCallback) hashMap.remove("customizeCallback"));
        if (hashMap.containsKey("disableSSO") && ((Boolean) hashMap.remove("disableSSO")).booleanValue()) {
            impl.disableSSO();
        }
        impl.show(context.getApplicationContext());
    }
}
