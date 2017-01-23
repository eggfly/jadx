package com.baidu.mobads.production;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p084c.C1918a;
import com.baidu.mobads.p091f.C1933a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.production.l */
public class C2061l implements IXAdContainerEventListener {
    private Context f7170a;
    private final C2028a f7171b;
    private AtomicBoolean f7172c;
    private AtomicBoolean f7173d;
    private AtomicBoolean f7174e;
    private AtomicBoolean f7175f;
    private int f7176g;
    private int f7177h;
    private int f7178i;
    private int f7179j;
    private int f7180k;
    private int f7181l;

    public C2061l(Context context, C2028a c2028a) {
        this.f7176g = 0;
        this.f7177h = 2;
        this.f7178i = 15;
        this.f7179j = 0;
        this.f7180k = 2;
        this.f7181l = 15;
        this.f7170a = context;
        this.f7171b = c2028a;
        this.f7172c = new AtomicBoolean(false);
        this.f7173d = new AtomicBoolean(false);
        this.f7174e = new AtomicBoolean(false);
        this.f7175f = new AtomicBoolean(false);
    }

    private void m7734a(Context context, String str) {
        try {
            this.f7179j = 0;
            Timer timer = new Timer();
            timer.schedule(new C2063n(this, C1991m.m7449a().m7463l(), context, str, timer), 0, 1000);
        } catch (Exception e) {
        }
    }

    private void m7735a(Context context, String str, String str2) {
        try {
            this.f7176g = 0;
            Timer timer = new Timer();
            timer.schedule(new C2062m(this, C1991m.m7449a().m7463l(), context, str2, timer, str), 0, 1000);
        } catch (Exception e) {
        }
    }

    private void m7736a(Set<String> set) {
        C2021a c2021a = new C2021a();
        for (String c2024d : set) {
            C2024d c2024d2 = new C2024d(c2024d, BuildConfig.FLAVOR);
            c2024d2.f7057e = 1;
            c2021a.m7547a(c2024d2, Boolean.valueOf(true));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdClicked(com.baidu.mobads.interfaces.IXAdContainer r21, com.baidu.mobads.interfaces.IXAdInstanceInfo r22, java.lang.Boolean r23, java.util.HashMap<java.lang.String, java.lang.Object> r24) {
        /*
        r20 = this;
        r4 = com.baidu.mobads.p080j.C1991m.m7449a();
        r8 = r4.m7464m();
        r4 = com.baidu.mobads.p080j.C1991m.m7449a();
        r12 = r4.m7467p();
        r4 = com.baidu.mobads.p080j.C1991m.m7449a();
        r4 = r4.m7463l();
        r0 = r20;
        r13 = r0.f7171b;
        r5 = r21.getAdContainerContext();
        r14 = r5.getAdResource();
        r5 = 0;
        r7 = java.lang.Boolean.valueOf(r5);
        r9 = r22.getClickThroughUrl();
        r10 = r22.getActionType();
        r11 = new java.util.ArrayList;
        r11.<init>();
        r15 = r22.getThirdClickTrackingUrls();
        r5 = 0;
        r6 = r5;
    L_0x003c:
        r5 = r15.size();
        if (r6 >= r5) goto L_0x0066;
    L_0x0042:
        r5 = r15.get(r6);
        r5 = (java.lang.String) r5;
        r16 = "\\$\\{PROGRESS\\}";
        r18 = r21.getPlayheadTime();
        r0 = r18;
        r0 = (int) r0;
        r17 = r0;
        r17 = java.lang.String.valueOf(r17);
        r0 = r16;
        r1 = r17;
        r5 = r5.replaceAll(r0, r1);
        r11.add(r5);
        r5 = r6 + 1;
        r6 = r5;
        goto L_0x003c;
    L_0x0066:
        r5 = new java.util.HashSet;
        r5.<init>();
        r5.addAll(r11);
        r0 = r20;
        r0.m7736a(r5);
        r5 = r12.getActTypeOpenExternalApp();
        if (r10 != r5) goto L_0x0166;
    L_0x0079:
        r5 = 1;
        r11 = java.lang.Boolean.valueOf(r5);
        r6 = 0;
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00e5 }
        r5.<init>(r9);	 Catch:{ Exception -> 0x00e5 }
        r10 = r5;
    L_0x0085:
        r5 = "page";
        r6 = "";
        r6 = r10.optString(r5, r6);
        r5 = r13.getApplicationContext();
        r7 = r22.getAppPackageName();
        r8 = 366; // 0x16e float:5.13E-43 double:1.81E-321;
        r9 = "fb_act";
        r15 = 0;
        r9 = r10.optInt(r9, r15);
        r4 = r4.sendAPOInfo(r5, r6, r7, r8, r9);
        if (r4 == 0) goto L_0x00e8;
    L_0x00a4:
        r4 = r23.booleanValue();
        if (r4 == 0) goto L_0x00b4;
    L_0x00aa:
        r4 = new com.baidu.mobads.command.b.a;
        r0 = r22;
        r4.<init>(r13, r0, r14, r6);
        r4.m7261a();
    L_0x00b4:
        r4 = r13.getApplicationContext();
        r5 = r22.getAppPackageName();
        r0 = r20;
        r0.m7735a(r4, r6, r5);
        r4 = r11;
    L_0x00c2:
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x00d6;
    L_0x00c8:
        r0 = r20;
        r4 = r0.f7171b;
        r5 = new com.baidu.mobads.f.a;
        r6 = "AdClickThru";
        r5.<init>(r6);
        r4.dispatchEvent(r5);
    L_0x00d6:
        r0 = r20;
        r4 = r0.f7171b;
        r5 = new com.baidu.mobads.f.a;
        r6 = "AdUserClick";
        r5.<init>(r6);
        r4.dispatchEvent(r5);
        return;
    L_0x00e5:
        r5 = move-exception;
        r10 = r6;
        goto L_0x0085;
    L_0x00e8:
        r4 = "fb_act";
        r5 = 0;
        r4 = r10.optInt(r4, r5);
        r5 = new org.json.JSONObject;
        r5.<init>();
        r7 = new com.baidu.mobads.vo.XAdInstanceInfo;
        r7.<init>(r5);
        r5 = r12.getActTypeLandingPage();
        if (r4 != r5) goto L_0x0128;
    L_0x00ff:
        r4 = r12.getActTypeLandingPage();
        r7.setActionType(r4);
        r4 = "fallback";
        r5 = "";
        r4 = r10.optString(r4, r5);
        r7.setClickThroughUrl(r4);
        r4 = r22.getTitle();
        r7.setTitle(r4);
        r4 = 1;
        r7.setInapp(r4);
        r0 = r20;
        r1 = r21;
        r2 = r23;
        r3 = r24;
        r0.onAdClicked(r1, r7, r2, r3);
        goto L_0x00b4;
    L_0x0128:
        r5 = r12.getActTypeDownload();
        if (r4 != r5) goto L_0x00b4;
    L_0x012e:
        r4 = r12.getActTypeDownload();
        r7.setActionType(r4);
        r4 = "fallback";
        r5 = "";
        r4 = r10.optString(r4, r5);
        r7.setClickThroughUrl(r4);
        r4 = r22.getTitle();
        r7.setTitle(r4);
        r4 = 1;
        r7.setInapp(r4);
        r4 = 1;
        r7.setAPOOpen(r4);
        r7.setPage(r6);
        r4 = r22.getAppPackageName();
        r7.setAppPackageName(r4);
        r0 = r20;
        r1 = r21;
        r2 = r23;
        r3 = r24;
        r0.onAdClicked(r1, r7, r2, r3);
        goto L_0x00b4;
    L_0x0166:
        r4 = r12.getActTypeDownload();
        if (r10 != r4) goto L_0x0183;
    L_0x016c:
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r5 = r23.booleanValue();
        if (r5 == 0) goto L_0x00c2;
    L_0x0177:
        r5 = new com.baidu.mobads.command.a.a;
        r0 = r22;
        r5.<init>(r13, r0, r14);
        r5.m7245a();
        goto L_0x00c2;
    L_0x0183:
        r4 = r12.getActTypeLandingPage();
        if (r10 != r4) goto L_0x01c5;
    L_0x0189:
        r0 = r20;
        r4 = r0.f7171b;
        r4 = r4.getProdInfo();
        r4 = r4.getProdType();
        r5 = r12.getProductionTypeSplash();
        if (r4 == r5) goto L_0x026b;
    L_0x019b:
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
    L_0x01a0:
        r5 = r23.booleanValue();
        if (r5 == 0) goto L_0x00c2;
    L_0x01a6:
        r5 = r22.isInapp();
        if (r5 == 0) goto L_0x01b8;
    L_0x01ac:
        r5 = new com.baidu.mobads.command.c.a;
        r0 = r22;
        r5.<init>(r13, r0, r14, r9);
        r5.m7262a();
        goto L_0x00c2;
    L_0x01b8:
        r5 = r21.getAdContainerContext();
        r5 = r5.getApplicationContext();
        r8.browserOutside(r5, r9);
        goto L_0x00c2;
    L_0x01c5:
        r4 = r12.getActTypeMakeCall();
        if (r10 == r4) goto L_0x01dd;
    L_0x01cb:
        r4 = r12.getActTypeSendSMS();
        if (r10 == r4) goto L_0x01dd;
    L_0x01d1:
        r4 = r12.getActTypeSendMail();
        if (r10 == r4) goto L_0x01dd;
    L_0x01d7:
        r4 = r12.getActTypeOpenMap();
        if (r10 != r4) goto L_0x0257;
    L_0x01dd:
        r4 = 1;
        r7 = java.lang.Boolean.valueOf(r4);
        r4 = r23.booleanValue();
        if (r4 == 0) goto L_0x01f2;
    L_0x01e8:
        r4 = new com.baidu.mobads.command.b.a;
        r0 = r22;
        r4.<init>(r13, r0, r14, r9);
        r4.m7261a();
    L_0x01f2:
        r4 = r12.getActTypeMakeCall();
        if (r10 != r4) goto L_0x0266;
    L_0x01f8:
        r4 = r13.getApplicationContext();
        r4 = r4.getPackageManager();
        r5 = new android.content.Intent;
        r6 = "android.intent.action.VIEW";
        r5.<init>(r6);
        r6 = android.net.Uri.parse(r9);
        r5.setData(r6);
        r6 = 64;
        r9 = r4.queryIntentActivities(r5, r6);
        if (r9 == 0) goto L_0x0246;
    L_0x0216:
        r4 = r9.size();
        if (r4 <= 0) goto L_0x0246;
    L_0x021c:
        r5 = 0;
        r8 = 1;
        r4 = 0;
        r6 = r5;
        r5 = r4;
    L_0x0221:
        r4 = r9.size();
        if (r5 >= r4) goto L_0x0269;
    L_0x0227:
        r4 = 1;
        if (r5 < r4) goto L_0x0249;
    L_0x022a:
        r4 = r9.get(r5);
        r4 = (android.content.pm.ResolveInfo) r4;
        r4 = r4.activityInfo;
        r4 = r4.processName;
        r4 = r6.equals(r4);
        if (r4 != 0) goto L_0x0249;
    L_0x023a:
        r4 = 0;
    L_0x023b:
        if (r4 == 0) goto L_0x0246;
    L_0x023d:
        r4 = r13.getApplicationContext();
        r0 = r20;
        r0.m7734a(r4, r6);
    L_0x0246:
        r4 = r7;
        goto L_0x00c2;
    L_0x0249:
        r4 = r9.get(r5);
        r4 = (android.content.pm.ResolveInfo) r4;
        r4 = r4.activityInfo;
        r6 = r4.processName;
        r4 = r5 + 1;
        r5 = r4;
        goto L_0x0221;
    L_0x0257:
        r4 = r12.getActTypeNothing2Do();
        if (r10 != r4) goto L_0x0260;
    L_0x025d:
        r4 = r7;
        goto L_0x00c2;
    L_0x0260:
        r4 = r12.getActTypeRichMedia();
        if (r10 != r4) goto L_0x0266;
    L_0x0266:
        r4 = r7;
        goto L_0x00c2;
    L_0x0269:
        r4 = r8;
        goto L_0x023b;
    L_0x026b:
        r4 = r7;
        goto L_0x01a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.l.onAdClicked(com.baidu.mobads.interfaces.IXAdContainer, com.baidu.mobads.interfaces.IXAdInstanceInfo, java.lang.Boolean, java.util.HashMap):void");
    }

    public void onAdCustomEvent(String str, IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdDurationChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdError(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
            if (hashMap != null) {
                IXAdConstants p = C1991m.m7449a().m7467p();
                C1918a.m7217a().m7226a(hashMap.get(p.getInfoKeyErrorCode()) + Constants.ACCEPT_TIME_SEPARATOR_SP + hashMap.get(p.getInfoKeyErrorMessage()) + Constants.ACCEPT_TIME_SEPARATOR_SP + hashMap.get(p.getInfoKeyErrorModule()));
            }
            this.f7174e.set(true);
            this.f7171b.dispatchEvent(new C1933a(IXAdEvent.AD_ERROR, hashMap));
        }
    }

    public void onAdExpandedChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdImpression(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        m7736a(iXAdInstanceInfo.getImpressionUrls());
    }

    public void onAdInteraction(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdLinearChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdLoaded(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f7171b.m7567a(iXAdContainer, (HashMap) hashMap);
        } else {
            new Handler(this.f7170a.getMainLooper()).post(new C2064o(this, iXAdContainer, hashMap));
        }
    }

    public void onAdPaused(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f7171b.dispatchEvent(new C1933a(IXAdEvent.AD_PAUSED));
    }

    public void onAdPlaying(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f7171b.dispatchEvent(new C1933a(IXAdEvent.AD_PLAYING));
    }

    public void onAdRemainingTimeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdSizeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdSkippableStateChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdSkipped(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdStarted(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f7171b.m7578b(iXAdContainer, hashMap);
        } else {
            new Handler(this.f7170a.getMainLooper()).post(new C2065p(this, iXAdContainer, hashMap));
        }
    }

    public void onAdStoped(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, Boolean bool2, HashMap<String, Object> hashMap) {
        Set hashSet = new HashSet();
        hashSet.addAll(iXAdInstanceInfo.getCloseTrackers());
        m7736a(hashSet);
        if (bool2.booleanValue()) {
            IXAdContainerContext adContainerContext = iXAdContainer.getAdContainerContext();
            this.f7171b.m7570a(adContainerContext.getAdResponseInfo(), adContainerContext.getAdInstanceInfo());
            return;
        }
        this.f7171b.m7588e(iXAdContainer, hashMap);
        this.f7171b.dispatchEvent(new C1933a(IXAdEvent.AD_STOPPED));
    }

    public void onAdUserAcceptInvitation(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdUserClosed(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f7171b.dispatchEvent(new C1933a(IXAdEvent.AD_USER_CLOSE));
    }

    public void onAdUserMinimize(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdVideoComplete(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdVideoFirstQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdVideoMidpoint(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdVideoStart(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdVideoThirdQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }

    public void onAdVolumeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f7174e.get()) {
        }
    }
}
