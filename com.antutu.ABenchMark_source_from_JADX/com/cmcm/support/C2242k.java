package com.cmcm.support;

import com.qq.p035e.comm.constants.ErrorCode.AdError;
import org.android.agoo.message.MessageService;

/* renamed from: com.cmcm.support.k */
public class C2242k {
    private C1820a f7711a;

    /* renamed from: com.cmcm.support.k.a */
    public interface C1820a {
        String getCacheDirectoryName();

        String getClientPrefix();

        String getClientVersion();

        String getCtrlAssetFileName();

        String getCtrlDstFilePath();

        int getDeleteCacheNum();

        String getFmtAssetFileName();

        String getFmtDstFilePath();

        int getIntervalMobileNet();

        int getIntervalWifiNet();

        int getMaxCacheCount();

        String getNativeLibPathName();

        String getPreferenceConfigName();
    }

    /* renamed from: com.cmcm.support.k.1 */
    class C22411 implements C1820a {
        final /* synthetic */ C2242k f7710a;

        C22411(C2242k c2242k) {
            this.f7710a = c2242k;
        }

        public String getCacheDirectoryName() {
            return "support_";
        }

        public String getClientPrefix() {
            return "host_";
        }

        public String getClientVersion() {
            return MessageService.MSG_DB_READY_REPORT;
        }

        public String getCtrlAssetFileName() {
            return "kctrl.dat";
        }

        public String getCtrlDstFilePath() {
            return "kctrl.dat";
        }

        public int getDeleteCacheNum() {
            return AdError.PLACEMENT_ERROR;
        }

        public String getFmtAssetFileName() {
            return "kfmt.dat";
        }

        public String getFmtDstFilePath() {
            return "kfmt.dat";
        }

        public int getIntervalMobileNet() {
            return 1800000;
        }

        public int getIntervalWifiNet() {
            return 300000;
        }

        public int getMaxCacheCount() {
            return com.facebook.ads.AdError.SERVER_ERROR_CODE;
        }

        public String getNativeLibPathName() {
            return "/lib/libcmcm_support.so";
        }

        public String getPreferenceConfigName() {
            return "cmcm_support_config_name";
        }
    }

    public C2242k() {
        this.f7711a = new C22411(this);
    }

    public synchronized C1820a m8462a() {
        return this.f7711a;
    }

    public synchronized void m8463a(C1820a c1820a) {
        if (c1820a != null) {
            this.f7711a = c1820a;
        }
    }
}
