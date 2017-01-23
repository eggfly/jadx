package com.qq.p035e.ads.banner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.qq.p035e.ads.cfg.BannerRollAnimation;
import com.qq.p035e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.adevent.ADEvent;
import com.qq.p035e.comm.adevent.ADListener;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.pi.BVI;
import com.qq.p035e.comm.pi.POFactory;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.umeng.message.proguard.C4233j;
import org.android.spdy.SpdyProtocol;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.qq.e.ads.banner.BannerView */
public class BannerView extends FrameLayout {
    private BVI f13393a;
    private BannerADListener f13394b;
    private boolean f13395c;
    private boolean f13396d;
    private boolean f13397e;
    private Integer f13398f;
    private BannerRollAnimation f13399g;
    private DownAPPConfirmPolicy f13400h;
    private Boolean f13401i;
    private volatile int f13402j;

    /* renamed from: com.qq.e.ads.banner.BannerView.1 */
    class C40421 implements Runnable {
        final /* synthetic */ Activity f13387a;
        final /* synthetic */ String f13388b;
        final /* synthetic */ ADSize f13389c;
        final /* synthetic */ String f13390d;
        final /* synthetic */ BannerView f13391e;

        /* renamed from: com.qq.e.ads.banner.BannerView.1.1 */
        class C40411 implements Runnable {
            private /* synthetic */ POFactory f13385a;
            private /* synthetic */ C40421 f13386b;

            C40411(C40421 c40421, POFactory pOFactory) {
                this.f13386b = c40421;
                this.f13385a = pOFactory;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r7 = this;
                r6 = 1;
                r0 = r7.f13385a;	 Catch:{ Throwable -> 0x00d0 }
                if (r0 == 0) goto L_0x00de;
            L_0x0005:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r7.f13385a;	 Catch:{ Throwable -> 0x00d0 }
                r2 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r2 = r2.f13387a;	 Catch:{ Throwable -> 0x00d0 }
                r3 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r3 = r3.f13389c;	 Catch:{ Throwable -> 0x00d0 }
                r4 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r4 = r4.f13388b;	 Catch:{ Throwable -> 0x00d0 }
                r5 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r5 = r5.f13390d;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.getBannerView(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x00d0 }
                r0.f13393a = r1;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13393a;	 Catch:{ Throwable -> 0x00d0 }
                r1 = new com.qq.e.ads.banner.BannerView$ADListenerAdapter;	 Catch:{ Throwable -> 0x00d0 }
                r2 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r2 = r2.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r3 = 0;
                r1.<init>(r3);	 Catch:{ Throwable -> 0x00d0 }
                r0.setAdListener(r1);	 Catch:{ Throwable -> 0x00d0 }
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13393a;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.getView();	 Catch:{ Throwable -> 0x00d0 }
                r0.addView(r1);	 Catch:{ Throwable -> 0x00d0 }
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = 1;
                r0.f13397e = true;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13400h;	 Catch:{ Throwable -> 0x00d0 }
                if (r0 == 0) goto L_0x006b;
            L_0x005c:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13400h;	 Catch:{ Throwable -> 0x00d0 }
                r0.setDownConfirmPilicy(r1);	 Catch:{ Throwable -> 0x00d0 }
            L_0x006b:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13398f;	 Catch:{ Throwable -> 0x00d0 }
                if (r0 == 0) goto L_0x0088;
            L_0x0075:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13398f;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.intValue();	 Catch:{ Throwable -> 0x00d0 }
                r0.setRefresh(r1);	 Catch:{ Throwable -> 0x00d0 }
            L_0x0088:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13399g;	 Catch:{ Throwable -> 0x00d0 }
                if (r0 == 0) goto L_0x00a1;
            L_0x0092:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13399g;	 Catch:{ Throwable -> 0x00d0 }
                r0.setRollAnimation(r1);	 Catch:{ Throwable -> 0x00d0 }
            L_0x00a1:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13401i;	 Catch:{ Throwable -> 0x00d0 }
                if (r0 == 0) goto L_0x00be;
            L_0x00ab:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.f13401i;	 Catch:{ Throwable -> 0x00d0 }
                r1 = r1.booleanValue();	 Catch:{ Throwable -> 0x00d0 }
                r0.setShowClose(r1);	 Catch:{ Throwable -> 0x00d0 }
            L_0x00be:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13402j = r0.f13402j - 1;	 Catch:{ Throwable -> 0x00d0 }
                if (r0 <= 0) goto L_0x00de;
            L_0x00c8:
                r0 = r7.f13386b;	 Catch:{ Throwable -> 0x00d0 }
                r0 = r0.f13391e;	 Catch:{ Throwable -> 0x00d0 }
                r0.loadAD();	 Catch:{ Throwable -> 0x00d0 }
                goto L_0x00be;
            L_0x00d0:
                r0 = move-exception;
                r1 = "Exception while init Banner Core";
                com.qq.p035e.comm.util.GDTLogger.m16601e(r1, r0);	 Catch:{ all -> 0x00e6 }
                r0 = r7.f13386b;
                r0 = r0.f13391e;
                r0.f13397e = true;
            L_0x00dd:
                return;
            L_0x00de:
                r0 = r7.f13386b;
                r0 = r0.f13391e;
                r0.f13397e = true;
                goto L_0x00dd;
            L_0x00e6:
                r0 = move-exception;
                r1 = r7.f13386b;
                r1 = r1.f13391e;
                r1.f13397e = true;
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.qq.e.ads.banner.BannerView.1.1.run():void");
            }
        }

        C40421(BannerView bannerView, Activity activity, String str, ADSize aDSize, String str2) {
            this.f13391e = bannerView;
            this.f13387a = activity;
            this.f13388b = str;
            this.f13389c = aDSize;
            this.f13390d = str2;
        }

        public void run() {
            if (GDTADManager.getInstance().initWith(this.f13387a, this.f13388b)) {
                try {
                    new Handler(Looper.getMainLooper()).post(new C40411(this, GDTADManager.getInstance().getPM().getPOFactory()));
                    return;
                } catch (Throwable th) {
                    GDTLogger.m16601e("Exception while init Banner plugin", th);
                    return;
                }
            }
            GDTLogger.m16600e("Fail to init ADManager");
        }
    }

    /* renamed from: com.qq.e.ads.banner.BannerView.ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private /* synthetic */ BannerView f13392a;

        private ADListenerAdapter(BannerView bannerView) {
            this.f13392a = bannerView;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.f13392a.f13394b == null) {
                GDTLogger.m16602i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.f13392a.f13394b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                    } else {
                        GDTLogger.m16600e("AdEvent.Paras error for Banner(" + aDEvent + C4233j.f14397t);
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f13392a.f13394b.onADReceiv();
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    this.f13392a.f13394b.onADExposure();
                case SpdyProtocol.QUIC /*4*/:
                    this.f13392a.f13394b.onADClosed();
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    this.f13392a.f13394b.onADClicked();
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    this.f13392a.f13394b.onADLeftApplication();
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    this.f13392a.f13394b.onADOpenOverlay();
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    this.f13392a.f13394b.onADCloseOverlay();
                default:
            }
        }
    }

    public BannerView(Activity activity, ADSize aDSize, String str, String str2) {
        super(activity);
        this.f13395c = false;
        this.f13396d = false;
        this.f13397e = false;
        this.f13402j = 0;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m16600e(String.format("Banner ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            return;
        }
        this.f13395c = true;
        if (C4048a.m16538a((Context) activity)) {
            this.f13396d = true;
            setLayoutParams(new LayoutParams(-1, -2));
            GDTADManager.INIT_EXECUTOR.execute(new C40421(this, activity, str, aDSize, str2));
            return;
        }
        GDTLogger.m16600e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
    }

    public void destroy() {
        if (this.f13393a != null) {
            this.f13393a.destroy();
        }
    }

    public void loadAD() {
        if (!this.f13395c || !this.f13396d) {
            GDTLogger.m16600e("Banner init Paras OR Context error,See More logs while new BannerView");
        } else if (!this.f13397e) {
            this.f13402j++;
        } else if (this.f13393a != null) {
            this.f13393a.fetchAd();
        } else {
            GDTLogger.m16600e("Banner Init error,See More Logs");
        }
    }

    public void setADListener(BannerADListener bannerADListener) {
        this.f13394b = bannerADListener;
    }

    public void setDownConfirmPilicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f13400h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy != null && this.f13393a != null) {
            this.f13393a.setDownAPPConfirmPolicy(downAPPConfirmPolicy.value());
        }
    }

    public void setRefresh(int i) {
        this.f13398f = Integer.valueOf(i);
        if (i < 30 && i != 0) {
            i = 30;
        } else if (i > 120) {
            i = 120;
        }
        if (this.f13393a != null) {
            this.f13393a.setRefresh(i);
        }
    }

    public void setRollAnimation(BannerRollAnimation bannerRollAnimation) {
        this.f13399g = bannerRollAnimation;
        if (bannerRollAnimation != null && this.f13393a != null) {
            this.f13393a.setRollAnimation(bannerRollAnimation.value());
        }
    }

    public void setShowClose(boolean z) {
        this.f13401i = Boolean.valueOf(z);
        if (this.f13393a != null) {
            this.f13393a.setShowCloseButton(z);
        }
    }
}
