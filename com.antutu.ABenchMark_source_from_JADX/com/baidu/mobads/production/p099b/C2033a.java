package com.baidu.mobads.production.p099b;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.feeds.IXAdDummyContainer;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.C2028a;
import com.baidu.mobads.production.C2066q;
import com.baidu.mobads.vo.C2031d;
import com.google.analytics.tracking.android.ModelFields;
import com.qq.p035e.comm.constants.ErrorCode.AdError;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.baidu.mobads.production.b.a */
public class C2033a extends C2028a {
    public static String f7121w;
    private C2034b f7122x;
    private ArrayList<IXAdInstanceInfo> f7123y;

    static {
        f7121w = BuildConfig.FLAVOR;
    }

    public C2033a(Context context, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.p = SlotType.SLOT_TYPE_FEEDS;
        this.f7122x = new C2034b(getApplicationContext(), getActivity(), this.p);
        this.f7122x.m7613a((int) OtherError.CONTAINER_INVISIBLE_ERROR);
        this.f7122x.m7617b((int) AdError.PLACEMENT_ERROR);
        this.f7122x.m7625e(0);
        this.f7122x.m7623d(str);
        this.f7122x.m7619c(0);
        this.f7122x.m7622d(1);
        this.f7122x.m7627f(C1991m.m7449a().m7467p().getAdCreativeTypeImage());
    }

    private Map<String, Object> m7630a(int i, List<String> list) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(C1991m.m7449a().m7467p().feedsTrackerParameterKeyProgress(), Integer.valueOf(i));
        hashMap.put(C1991m.m7449a().m7467p().feedsTrackerParameterKeyList(), list);
        return hashMap;
    }

    public void m7631a(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public void m7632a(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        ((IXAdDummyContainer) this.h).onClose(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, m7630a(i, iXAdInstanceInfo.getCloseTrackers()));
    }

    public void m7633a(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        ((IXAdDummyContainer) this.h).onClick(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters, m7630a(i, iXAdInstanceInfo.getThirdClickTrackingUrls()));
    }

    public void m7634a(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        ((IXAdDummyContainer) this.h).onImpression(view, iXAdInstanceInfo, iXAdFeedsRequestParameters, m7630a(-1, iXAdInstanceInfo.getThirdImpressionTrackingUrls()));
    }

    public void m7635a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f7122x.m7613a(width);
            this.f7122x.m7617b(height);
        }
    }

    protected void m7636a(C2024d c2024d, C2066q c2066q, int i) {
        c2066q.m7546a(c2024d, (double) i);
    }

    public boolean m7637a(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iXAdInstanceInfo.getHtmlSnippet());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getQueryKey());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getAdId());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getMainPictureUrl());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getTitle());
            stringBuffer.append("_&_");
            f7121w = stringBuffer.toString();
        } catch (Exception e) {
            f7121w = ModelFields.EXCEPTION;
            e.printStackTrace();
        }
        return ((IXAdDummyContainer) this.h).isAdAvailable(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void m7638b() {
        this.h.load();
    }

    public void m7639b(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        ((IXAdDummyContainer) this.h).onFullScreen(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters, m7630a(i, iXAdInstanceInfo.getFullScreenTrackers()));
    }

    public void m7640b(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        ((IXAdDummyContainer) this.h).onStart(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, m7630a(0, iXAdInstanceInfo.getStartTrackers()));
    }

    public void m7641b(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        m7633a(view, iXAdInstanceInfo, -1, iXAdFeedsRequestParameters);
    }

    protected void m7642c() {
        this.f7085n = 8000;
    }

    public void m7643c(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        ((IXAdDummyContainer) this.h).onComplete(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, null);
    }

    protected void m7644c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        iXAdContainer.start();
    }

    public void m7645d(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        ((IXAdDummyContainer) this.h).onCstartcard(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, m7630a(0, iXAdInstanceInfo.getCstartcardTrackers()));
    }

    protected void m7646d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.f7123y = iXAdContainer.getAdContainerContext().getAdResponseInfo().getAdInstanceList();
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m7648m();
    }

    public ArrayList<IXAdInstanceInfo> m7647l() {
        return this.f7123y;
    }

    public C2031d m7648m() {
        return this.f7122x;
    }

    public void request() {
        super.m7575a(this.f7122x);
    }
}
