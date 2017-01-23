package com.qq.p035e.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.adevent.ADEvent;
import com.qq.p035e.comm.adevent.ADListener;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.pi.NSPVI;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.qq.e.ads.splash.SplashAD */
public final class SplashAD {
    private NSPVI f13441a;
    private SplashADListener f13442b;

    /* renamed from: com.qq.e.ads.splash.SplashAD.ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private /* synthetic */ SplashAD f13440a;

        private ADListenerAdapter(SplashAD splashAD) {
            this.f13440a = splashAD;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.f13440a.f13442b == null) {
                GDTLogger.m16600e("SplashADListener == null");
                return;
            }
            switch (aDEvent.getType()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f13440a.f13442b.onADDismissed();
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.f13440a.f13442b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                    } else {
                        GDTLogger.m16600e("Splash ADEvent error,");
                    }
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    this.f13440a.f13442b.onADPresent();
                case SpdyProtocol.QUIC /*4*/:
                    this.f13440a.f13442b.onADClicked();
                default:
            }
        }
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener) {
        this(activity, viewGroup, str, str2, splashADListener, 0);
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener, int i) {
        this.f13442b = splashADListener;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || viewGroup == null || activity == null) {
            GDTLogger.m16600e(String.format("SplashAd Constructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            SplashAD.m16532a(splashADListener, ErrorCode.APP_NOT_BIND);
        } else if (C4048a.m16538a((Context) activity)) {
            try {
                if (GDTADManager.getInstance().initWith(activity, str)) {
                    this.f13441a = GDTADManager.getInstance().getPM().getPOFactory().getNativeSplashAdView(activity, str, str2);
                    if (this.f13441a != null) {
                        this.f13441a.setFetchDelay(i);
                        this.f13441a.setAdListener(new ADListenerAdapter());
                        this.f13441a.fetchAndShowIn(viewGroup);
                        return;
                    }
                    GDTLogger.m16600e("SplashAdView created by factory return null");
                    SplashAD.m16532a(splashADListener, ErrorCode.DM_APPKEY_INVALID);
                    return;
                }
                GDTLogger.m16600e("Fail to Init GDT AD SDK,report logcat info filter by gdt_ad_mob");
                SplashAD.m16532a(splashADListener, Constants.COMMAND_STOP_FOR_ELECTION);
            } catch (Throwable e) {
                GDTLogger.m16601e("Fail to init splash plugin", e);
                SplashAD.m16532a(splashADListener, ErrorCode.DM_DEVICEID_INVALID);
            } catch (Throwable e2) {
                GDTLogger.m16601e("Unknown Exception", e2);
                SplashAD.m16532a(splashADListener, OtherError.UNKNOWN_ERROR);
            }
        } else {
            GDTLogger.m16600e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            SplashAD.m16532a(splashADListener, ErrorCode.APP_NOT_BIND);
        }
    }

    private static void m16532a(SplashADListener splashADListener, int i) {
        if (splashADListener != null) {
            splashADListener.onNoAD(i);
        }
    }
}
