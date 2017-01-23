package com.baidu.mobad.feeds;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters.Builder;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p093h.C1971q;
import com.baidu.mobads.production.p099b.C2033a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaiduNative {
    private final Context f6485a;
    private final String f6486b;
    private C2033a f6487c;
    private BaiduNativeNetworkListener f6488d;
    private BaiduNativeEventListener f6489e;

    public interface BaiduNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);
    }

    public interface BaiduNativeEventListener {
        void onClicked();

        void onImpressionSended();
    }

    class CustomIOAdEventListener implements IOAdEventListener {
        final /* synthetic */ BaiduNative f6483a;
        private IXAdFeedsRequestParameters f6484b;

        /* renamed from: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.1 */
        class C18901 implements Runnable {
            final /* synthetic */ List f6480a;
            final /* synthetic */ CustomIOAdEventListener f6481b;

            C18901(CustomIOAdEventListener customIOAdEventListener, List list) {
                this.f6481b = customIOAdEventListener;
                this.f6480a = list;
            }

            public void run() {
                this.f6481b.f6483a.f6488d.onNativeLoad(this.f6480a);
            }
        }

        /* renamed from: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.2 */
        class C18912 implements Runnable {
            final /* synthetic */ CustomIOAdEventListener f6482a;

            C18912(CustomIOAdEventListener customIOAdEventListener) {
                this.f6482a = customIOAdEventListener;
            }

            public void run() {
                this.f6482a.f6483a.f6488d.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
            }
        }

        public CustomIOAdEventListener(BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.f6483a = baiduNative;
            this.f6484b = iXAdFeedsRequestParameters;
        }

        public void run(IOAdEvent iOAdEvent) {
            if (IXAdEvent.AD_STARTED.equals(iOAdEvent.getType())) {
                this.f6483a.f6487c.removeAllListeners();
                if (this.f6483a.f6488d != null) {
                    List arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    IXAdConstants p = C1991m.m7449a().m7467p();
                    for (int i = 0; i < this.f6483a.f6487c.m7647l().size(); i++) {
                        boolean z;
                        boolean z2;
                        XAdNativeResponse xAdNativeResponse;
                        IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo) this.f6483a.f6487c.m7647l().get(i);
                        String appPackageName = iXAdInstanceInfo.getAppPackageName();
                        if (iXAdInstanceInfo.getActionType() == p.getActTypeDownload()) {
                            if (appPackageName == null || appPackageName.equals(BuildConfig.FLAVOR) || appPackageName.equals("null") || hashSet.contains(appPackageName)) {
                                z = false;
                                z2 = true;
                                if (z2) {
                                    xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, this.f6483a, this.f6484b, this.f6483a.f6487c.getCurrentXAdContainer());
                                    if (z) {
                                        xAdNativeResponse.setIsDownloadApp(false);
                                    }
                                    arrayList.add(xAdNativeResponse);
                                }
                            } else {
                                hashSet.add(appPackageName);
                                if (C1991m.m7449a().m7463l().isInstalled(this.f6483a.f6485a, appPackageName)) {
                                    z = true;
                                    z2 = false;
                                    if (z2) {
                                        xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, this.f6483a, this.f6484b, this.f6483a.f6487c.getCurrentXAdContainer());
                                        if (z) {
                                            xAdNativeResponse.setIsDownloadApp(false);
                                        }
                                        arrayList.add(xAdNativeResponse);
                                    }
                                }
                            }
                        }
                        z = false;
                        z2 = false;
                        if (z2) {
                            xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, this.f6483a, this.f6484b, this.f6483a.f6487c.getCurrentXAdContainer());
                            if (z) {
                                xAdNativeResponse.setIsDownloadApp(false);
                            }
                            arrayList.add(xAdNativeResponse);
                        }
                    }
                    C1991m.m7449a().m7464m().m7420a(new C18901(this, arrayList));
                }
            }
            if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                this.f6483a.f6487c.removeAllListeners();
                String str = (String) iOAdEvent.getData().get(C4233j.f14376C);
                if (this.f6483a.f6488d != null) {
                    C1991m.m7449a().m7464m().m7420a(new C18912(this));
                }
            }
        }
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener) {
        this.f6485a = context;
        C1991m.m7449a().m7450a(context.getApplicationContext());
        this.f6486b = str;
        this.f6488d = baiduNativeNetworkListener;
        C1971q.m7360a(context).m7369a();
        this.f6487c = new C2033a(this.f6485a, str);
    }

    public static void setAppSid(Context context, String str) {
        C1991m.m7449a().m7464m().setAppId(str);
    }

    public void destroy() {
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f6487c.m7633a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f6487c.m7641b(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnClickAd(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f6487c.m7645d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnClose(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f6487c.m7632a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnComplete(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f6487c.m7643c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnError(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.f6487c.m7631a(context, i, i2, iXAdInstanceInfo);
    }

    protected void handleOnFullScreen(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f6487c.m7639b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnStart(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f6487c.m7640b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.f6487c.m7637a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void makeRequest() {
        makeRequest((RequestParameters) null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        Object build;
        if (requestParameters == null) {
            build = new Builder().build();
        }
        build.mPlacementId = this.f6486b;
        IOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(this, build);
        this.f6487c.addEventListener(IXAdEvent.AD_STARTED, customIOAdEventListener);
        this.f6487c.addEventListener(IXAdEvent.AD_ERROR, customIOAdEventListener);
        this.f6487c.m7635a(build);
        this.f6487c.request();
    }

    protected void recordImpression(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f6487c.m7634a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.f6489e = baiduNativeEventListener;
    }
}
