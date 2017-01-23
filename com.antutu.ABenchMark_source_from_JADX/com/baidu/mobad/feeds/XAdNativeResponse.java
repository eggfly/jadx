package com.baidu.mobad.feeds;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobad.feeds.NativeResponse.MaterialType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

class XAdNativeResponse implements NativeResponse {
    private IXAdInstanceInfo f6508a;
    private BaiduNative f6509b;
    private boolean f6510c;
    private IXAdFeedsRequestParameters f6511d;
    private IXAdContainer f6512e;

    /* renamed from: com.baidu.mobad.feeds.XAdNativeResponse.1 */
    class C18931 implements OnClickListener {
        final /* synthetic */ View f6504a;
        final /* synthetic */ int f6505b;
        final /* synthetic */ XAdNativeResponse f6506c;

        C18931(XAdNativeResponse xAdNativeResponse, View view, int i) {
            this.f6506c = xAdNativeResponse;
            this.f6504a = view;
            this.f6505b = i;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f6506c.f6509b.handleClick(this.f6504a, this.f6506c.f6508a, this.f6505b, this.f6506c.f6511d);
        }
    }

    /* renamed from: com.baidu.mobad.feeds.XAdNativeResponse.2 */
    class C18942 implements OnClickListener {
        final /* synthetic */ XAdNativeResponse f6507a;

        C18942(XAdNativeResponse xAdNativeResponse) {
            this.f6507a = xAdNativeResponse;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public XAdNativeResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.f6510c = false;
        this.f6508a = iXAdInstanceInfo;
        this.f6509b = baiduNative;
        this.f6512e = iXAdContainer;
        if (this.f6508a.getActionType() == C1991m.m7449a().m7467p().getActTypeDownload()) {
            this.f6510c = true;
        }
        this.f6511d = iXAdFeedsRequestParameters;
    }

    public String getAppPackage() {
        return this.f6508a.getAppPackageName();
    }

    public long getAppSize() {
        return this.f6508a.getAppSize();
    }

    public String getDesc() {
        return this.f6508a.getDescription();
    }

    public int getDuration() {
        return this.f6508a.getVideoDuration();
    }

    public Map<String, String> getExtras() {
        return null;
    }

    public String getHtmlSnippet() {
        return this.f6508a.getHtmlSnippet();
    }

    public String getIconUrl() {
        String iconUrl = this.f6508a.getIconUrl();
        return (iconUrl == null || iconUrl.equals(BuildConfig.FLAVOR)) ? this.f6508a.getMainPictureUrl() : iconUrl;
    }

    public String getImageUrl() {
        return this.f6508a.getMainPictureUrl();
    }

    public int getMainPicHeight() {
        return this.f6508a.getMainMaterialHeight();
    }

    public int getMainPicWidth() {
        return this.f6508a.getMainMaterialWidth();
    }

    public MaterialType getMaterialType() {
        return this.f6508a.getCreativeType() == CreativeType.VIDEO ? MaterialType.VIDEO : this.f6508a.getCreativeType() == CreativeType.HTML ? MaterialType.HTML : MaterialType.NORMAL;
    }

    public List<String> getMultiPicUrls() {
        try {
            JSONArray optJSONArray = this.f6508a.getOriginJsonObject().optJSONArray("morepics");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            List<String> arrayList = new ArrayList();
            int i = 0;
            while (i < optJSONArray.length()) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                    i++;
                } catch (Exception e) {
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            return null;
        }
    }

    public String getTitle() {
        return this.f6508a.getTitle();
    }

    public String getVideoUrl() {
        return this.f6508a.getVideoUrl();
    }

    public WebView getWebView() {
        return (WebView) this.f6512e.getAdView();
    }

    public void handleClick(View view) {
        handleClick(view, -1);
    }

    public void handleClick(View view, int i) {
        this.f6508a.setActionOnlyWifi(false);
        if (isDownloadApp() && this.f6511d.isConfirmDownloading()) {
            Builder builder = new Builder(view.getContext());
            builder.setMessage("\u786e\u8ba4\u4e0b\u8f7d\"" + getTitle() + "\"?");
            builder.setTitle("\u63d0\u793a");
            builder.setPositiveButton("\u786e\u8ba4", new C18931(this, view, i));
            builder.setNegativeButton("\u53d6\u6d88", new C18942(this));
            builder.create().show();
            return;
        }
        this.f6509b.handleClick(view, this.f6508a, i, this.f6511d);
    }

    public boolean isAdAvailable(Context context) {
        return this.f6509b.isAdAvailable(context, this.f6508a, this.f6511d);
    }

    public boolean isDownloadApp() {
        return this.f6510c;
    }

    public void onClickAd(Context context) {
        this.f6509b.handleOnClickAd(context, this.f6508a, this.f6511d);
    }

    public void onClose(Context context, int i) {
        this.f6509b.handleOnClose(context, i, this.f6508a, this.f6511d);
    }

    public void onComplete(Context context) {
        this.f6509b.handleOnComplete(context, this.f6508a, this.f6511d);
    }

    public void onError(Context context, int i, int i2) {
        this.f6509b.handleOnError(context, i, i2, this.f6508a);
    }

    public void onFullScreen(Context context, int i) {
        this.f6509b.handleOnFullScreen(context, i, this.f6508a, this.f6511d);
    }

    public void onStart(Context context) {
        this.f6509b.handleOnStart(context, this.f6508a, this.f6511d);
    }

    public void recordImpression(View view) {
        this.f6509b.recordImpression(view, this.f6508a, this.f6511d);
    }

    public void setIsDownloadApp(boolean z) {
        this.f6510c = z;
    }
}
