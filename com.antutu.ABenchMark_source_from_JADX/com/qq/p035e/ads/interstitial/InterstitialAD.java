package com.qq.p035e.ads.interstitial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.adevent.ADEvent;
import com.qq.p035e.comm.adevent.ADListener;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.pi.IADI;
import com.qq.p035e.comm.pi.POFactory;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.umeng.message.proguard.C4233j;
import org.android.spdy.SpdyProtocol;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.qq.e.ads.interstitial.InterstitialAD */
public class InterstitialAD {
    private IADI f13419a;
    private InterstitialADListener f13420b;
    private boolean f13421c;
    private boolean f13422d;
    private boolean f13423e;
    private volatile int f13424f;

    /* renamed from: com.qq.e.ads.interstitial.InterstitialAD.1 */
    class C40441 implements Runnable {
        final /* synthetic */ Activity f13414a;
        final /* synthetic */ String f13415b;
        final /* synthetic */ String f13416c;
        final /* synthetic */ InterstitialAD f13417d;

        /* renamed from: com.qq.e.ads.interstitial.InterstitialAD.1.1 */
        class C40431 implements Runnable {
            private /* synthetic */ POFactory f13412a;
            private /* synthetic */ C40441 f13413b;

            C40431(C40441 c40441, POFactory pOFactory) {
                this.f13413b = c40441;
                this.f13412a = pOFactory;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r6 = this;
                r5 = 1;
                r0 = r6.f13412a;	 Catch:{ Throwable -> 0x004d }
                if (r0 == 0) goto L_0x005b;
            L_0x0005:
                r0 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r0 = r0.f13417d;	 Catch:{ Throwable -> 0x004d }
                r1 = r6.f13412a;	 Catch:{ Throwable -> 0x004d }
                r2 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r2 = r2.f13414a;	 Catch:{ Throwable -> 0x004d }
                r3 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r3 = r3.f13415b;	 Catch:{ Throwable -> 0x004d }
                r4 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r4 = r4.f13416c;	 Catch:{ Throwable -> 0x004d }
                r1 = r1.getIADView(r2, r3, r4);	 Catch:{ Throwable -> 0x004d }
                r0.f13419a = r1;	 Catch:{ Throwable -> 0x004d }
                r0 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r0 = r0.f13417d;	 Catch:{ Throwable -> 0x004d }
                r0 = r0.f13419a;	 Catch:{ Throwable -> 0x004d }
                r1 = new com.qq.e.ads.interstitial.InterstitialAD$ADListenerAdapter;	 Catch:{ Throwable -> 0x004d }
                r2 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r2 = r2.f13417d;	 Catch:{ Throwable -> 0x004d }
                r3 = 0;
                r1.<init>(r3);	 Catch:{ Throwable -> 0x004d }
                r0.setAdListener(r1);	 Catch:{ Throwable -> 0x004d }
                r0 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r0 = r0.f13417d;	 Catch:{ Throwable -> 0x004d }
                r1 = 1;
                r0.f13423e = true;	 Catch:{ Throwable -> 0x004d }
            L_0x003b:
                r0 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r0 = r0.f13417d;	 Catch:{ Throwable -> 0x004d }
                r0 = r0.f13424f = r0.f13424f - 1;	 Catch:{ Throwable -> 0x004d }
                if (r0 <= 0) goto L_0x005b;
            L_0x0045:
                r0 = r6.f13413b;	 Catch:{ Throwable -> 0x004d }
                r0 = r0.f13417d;	 Catch:{ Throwable -> 0x004d }
                r0.loadAD();	 Catch:{ Throwable -> 0x004d }
                goto L_0x003b;
            L_0x004d:
                r0 = move-exception;
                r1 = "Exception while init IAD Core";
                com.qq.p035e.comm.util.GDTLogger.m16601e(r1, r0);	 Catch:{ all -> 0x0063 }
                r0 = r6.f13413b;
                r0 = r0.f13417d;
                r0.f13423e = true;
            L_0x005a:
                return;
            L_0x005b:
                r0 = r6.f13413b;
                r0 = r0.f13417d;
                r0.f13423e = true;
                goto L_0x005a;
            L_0x0063:
                r0 = move-exception;
                r1 = r6.f13413b;
                r1 = r1.f13417d;
                r1.f13423e = true;
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.qq.e.ads.interstitial.InterstitialAD.1.1.run():void");
            }
        }

        C40441(InterstitialAD interstitialAD, Activity activity, String str, String str2) {
            this.f13417d = interstitialAD;
            this.f13414a = activity;
            this.f13415b = str;
            this.f13416c = str2;
        }

        public void run() {
            if (GDTADManager.getInstance().initWith(this.f13414a, this.f13415b)) {
                try {
                    new Handler(Looper.getMainLooper()).post(new C40431(this, GDTADManager.getInstance().getPM().getPOFactory()));
                    return;
                } catch (Throwable th) {
                    GDTLogger.m16601e("Exception while init IAD plugin", th);
                    return;
                }
            }
            GDTLogger.m16600e("Fail to init ADManager");
        }
    }

    /* renamed from: com.qq.e.ads.interstitial.InterstitialAD.ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private /* synthetic */ InterstitialAD f13418a;

        private ADListenerAdapter(InterstitialAD interstitialAD) {
            this.f13418a = interstitialAD;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.f13418a.f13420b == null) {
                GDTLogger.m16602i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.f13418a.f13420b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                    } else {
                        GDTLogger.m16600e("AdEvent.Paras error for Banner(" + aDEvent + C4233j.f14397t);
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f13418a.f13420b.onADReceive();
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    this.f13418a.f13420b.onADExposure();
                case SpdyProtocol.QUIC /*4*/:
                    this.f13418a.f13420b.onADOpened();
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    this.f13418a.f13420b.onADClicked();
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    this.f13418a.f13420b.onADLeftApplication();
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    this.f13418a.f13420b.onADClosed();
                default:
            }
        }
    }

    public InterstitialAD(Activity activity, String str, String str2) {
        this.f13421c = false;
        this.f13422d = false;
        this.f13423e = false;
        this.f13424f = 0;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m16600e(String.format("Intersitial Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            return;
        }
        this.f13421c = true;
        if (C4048a.m16538a((Context) activity)) {
            this.f13422d = true;
            GDTADManager.INIT_EXECUTOR.execute(new C40441(this, activity, str, str2));
            return;
        }
        GDTLogger.m16600e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
    }

    public void closePopupWindow() {
        if (this.f13419a != null) {
            this.f13419a.closePopupWindow();
        }
    }

    public void destory() {
        if (this.f13419a != null) {
            this.f13419a.destory();
        }
    }

    public void loadAD() {
        if (!this.f13421c || !this.f13422d) {
            GDTLogger.m16600e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.f13423e) {
            this.f13424f++;
        } else if (this.f13419a != null) {
            this.f13419a.loadAd();
        } else {
            GDTLogger.m16600e("InterstitialAD Init error,See More Logs");
        }
    }

    public void setADListener(InterstitialADListener interstitialADListener) {
        this.f13420b = interstitialADListener;
    }

    public synchronized void show() {
        if (this.f13419a != null) {
            this.f13419a.show();
        }
    }

    public synchronized void show(Activity activity) {
        if (this.f13419a != null) {
            this.f13419a.show(activity);
        }
    }

    public synchronized void showAsPopupWindow() {
        if (this.f13419a != null) {
            this.f13419a.showAsPopupWindown();
        }
    }

    public synchronized void showAsPopupWindow(Activity activity) {
        if (this.f13419a != null) {
            this.f13419a.showAsPopupWindown(activity);
        }
    }
}
