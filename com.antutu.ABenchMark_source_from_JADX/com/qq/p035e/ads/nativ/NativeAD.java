package com.qq.p035e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.p035e.ads.cfg.BrowserType;
import com.qq.p035e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.adevent.ADEvent;
import com.qq.p035e.comm.adevent.ADListener;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.pi.NADI;
import com.qq.p035e.comm.pi.POFactory;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.umeng.message.proguard.C4233j;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.qq.e.ads.nativ.NativeAD */
public class NativeAD {
    private NADI f13432a;
    private NativeAdListener f13433b;
    private boolean f13434c;
    private boolean f13435d;
    private List<Integer> f13436e;
    private boolean f13437f;
    private BrowserType f13438g;
    private DownAPPConfirmPolicy f13439h;

    /* renamed from: com.qq.e.ads.nativ.NativeAD.NativeAdListener */
    public interface NativeAdListener {
        void onADError(NativeADDataRef nativeADDataRef, int i);

        void onADLoaded(List<NativeADDataRef> list);

        void onADStatusChanged(NativeADDataRef nativeADDataRef);

        void onNoAD(int i);
    }

    /* renamed from: com.qq.e.ads.nativ.NativeAD.1 */
    class C40461 implements Runnable {
        final /* synthetic */ Context f13427a;
        final /* synthetic */ String f13428b;
        final /* synthetic */ String f13429c;
        final /* synthetic */ NativeAD f13430d;

        /* renamed from: com.qq.e.ads.nativ.NativeAD.1.1 */
        class C40451 implements Runnable {
            private /* synthetic */ POFactory f13425a;
            private /* synthetic */ C40461 f13426b;

            C40451(C40461 c40461, POFactory pOFactory) {
                this.f13426b = c40461;
                this.f13425a = pOFactory;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r9 = this;
                r8 = 1;
                r0 = r9.f13425a;	 Catch:{ Throwable -> 0x0086 }
                if (r0 == 0) goto L_0x0094;
            L_0x0005:
                r0 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r1 = r9.f13425a;	 Catch:{ Throwable -> 0x0086 }
                r2 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r2 = r2.f13427a;	 Catch:{ Throwable -> 0x0086 }
                r3 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r3 = r3.f13428b;	 Catch:{ Throwable -> 0x0086 }
                r4 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r4 = r4.f13429c;	 Catch:{ Throwable -> 0x0086 }
                r5 = new com.qq.e.ads.nativ.NativeAD$ADListenerAdapter;	 Catch:{ Throwable -> 0x0086 }
                r6 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r6 = r6.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r7 = 0;
                r5.<init>(r7);	 Catch:{ Throwable -> 0x0086 }
                r1 = r1.getNativeADDelegate(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0086 }
                r0.f13432a = r1;	 Catch:{ Throwable -> 0x0086 }
                r0 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r1 = 1;
                r0.f13437f = true;	 Catch:{ Throwable -> 0x0086 }
                r0 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13438g;	 Catch:{ Throwable -> 0x0086 }
                if (r0 == 0) goto L_0x0049;
            L_0x003a:
                r0 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r1 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r1 = r1.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r1 = r1.f13438g;	 Catch:{ Throwable -> 0x0086 }
                r0.setBrowserType(r1);	 Catch:{ Throwable -> 0x0086 }
            L_0x0049:
                r0 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13439h;	 Catch:{ Throwable -> 0x0086 }
                if (r0 == 0) goto L_0x0062;
            L_0x0053:
                r0 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r1 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r1 = r1.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r1 = r1.f13439h;	 Catch:{ Throwable -> 0x0086 }
                r0.setDownAPPConfirmPolicy(r1);	 Catch:{ Throwable -> 0x0086 }
            L_0x0062:
                r0 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.f13436e;	 Catch:{ Throwable -> 0x0086 }
                r1 = r0.iterator();	 Catch:{ Throwable -> 0x0086 }
            L_0x006e:
                r0 = r1.hasNext();	 Catch:{ Throwable -> 0x0086 }
                if (r0 == 0) goto L_0x0094;
            L_0x0074:
                r0 = r1.next();	 Catch:{ Throwable -> 0x0086 }
                r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x0086 }
                r2 = r9.f13426b;	 Catch:{ Throwable -> 0x0086 }
                r2 = r2.f13430d;	 Catch:{ Throwable -> 0x0086 }
                r0 = r0.intValue();	 Catch:{ Throwable -> 0x0086 }
                r2.loadAD(r0);	 Catch:{ Throwable -> 0x0086 }
                goto L_0x006e;
            L_0x0086:
                r0 = move-exception;
                r1 = "Exception while init Native Core";
                com.qq.p035e.comm.util.GDTLogger.m16601e(r1, r0);	 Catch:{ all -> 0x009c }
                r0 = r9.f13426b;
                r0 = r0.f13430d;
                r0.f13437f = true;
            L_0x0093:
                return;
            L_0x0094:
                r0 = r9.f13426b;
                r0 = r0.f13430d;
                r0.f13437f = true;
                goto L_0x0093;
            L_0x009c:
                r0 = move-exception;
                r1 = r9.f13426b;
                r1 = r1.f13430d;
                r1.f13437f = true;
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.qq.e.ads.nativ.NativeAD.1.1.run():void");
            }
        }

        C40461(NativeAD nativeAD, Context context, String str, String str2) {
            this.f13430d = nativeAD;
            this.f13427a = context;
            this.f13428b = str;
            this.f13429c = str2;
        }

        public void run() {
            if (GDTADManager.getInstance().initWith(this.f13427a, this.f13428b)) {
                try {
                    new Handler(Looper.getMainLooper()).post(new C40451(this, GDTADManager.getInstance().getPM().getPOFactory()));
                    return;
                } catch (Throwable th) {
                    GDTLogger.m16601e("Exception while init Native plugin", th);
                    return;
                }
            }
            GDTLogger.m16600e("Fail to init ADManager");
        }
    }

    /* renamed from: com.qq.e.ads.nativ.NativeAD.ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private /* synthetic */ NativeAD f13431a;

        private ADListenerAdapter(NativeAD nativeAD) {
            this.f13431a = nativeAD;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.f13431a.f13433b == null) {
                GDTLogger.m16602i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.f13431a.f13433b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                    } else {
                        GDTLogger.m16600e("AdEvent.Paras error for NativeAD(" + aDEvent + C4233j.f14397t);
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                        this.f13431a.f13433b.onADLoaded((List) aDEvent.getParas()[0]);
                    } else {
                        GDTLogger.m16600e("ADEvent.Paras error for NativeAD(" + aDEvent + C4233j.f14397t);
                    }
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeADDataRef)) {
                        this.f13431a.f13433b.onADStatusChanged((NativeADDataRef) aDEvent.getParas()[0]);
                    } else {
                        GDTLogger.m16600e("ADEvent.Paras error for NativeAD(" + aDEvent + C4233j.f14397t);
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeADDataRef) && (aDEvent.getParas()[1] instanceof Integer)) {
                        this.f13431a.f13433b.onADError((NativeADDataRef) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                    } else {
                        GDTLogger.m16600e("ADEvent.Paras error for NativeAD(" + aDEvent + C4233j.f14397t);
                    }
                default:
            }
        }
    }

    public NativeAD(Context context, String str, String str2, NativeAdListener nativeAdListener) {
        this.f13436e = new ArrayList();
        this.f13437f = false;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.m16600e(String.format("GDTNativeAd Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, context}));
            return;
        }
        this.f13434c = true;
        if (C4048a.m16538a(context)) {
            this.f13435d = true;
            this.f13433b = nativeAdListener;
            GDTADManager.INIT_EXECUTOR.execute(new C40461(this, context, str, str2));
            return;
        }
        GDTLogger.m16600e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
    }

    public void loadAD(int i) {
        if (!this.f13434c || !this.f13435d) {
            GDTLogger.m16600e("AD init Paras OR Context error,details in logs produced while init NativeAD");
        } else if (!this.f13437f) {
            this.f13436e.add(Integer.valueOf(i));
        } else if (this.f13432a != null) {
            this.f13432a.loadAd(i);
        } else {
            GDTLogger.m16600e("NativeAD Init error,See More Logs");
        }
    }

    public void setBrowserType(BrowserType browserType) {
        this.f13438g = browserType;
        if (this.f13432a != null && browserType != null) {
            this.f13432a.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f13439h = downAPPConfirmPolicy;
        if (this.f13432a != null && downAPPConfirmPolicy != null) {
            this.f13432a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
