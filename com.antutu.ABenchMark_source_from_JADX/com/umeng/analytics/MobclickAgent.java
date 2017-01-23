package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.social.C4188e;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import p023b.p024a.ap;

public class MobclickAgent {
    private static final String f13936a = "input map is null";
    private static final C4163b f13937b;

    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1),
        E_UM_ANALYTICS_OEM(224),
        E_UM_GAME_OEM(225);
        
        private int f13935a;

        private EScenarioType(int i) {
            this.f13935a = i;
        }

        public int toValue() {
            return this.f13935a;
        }
    }

    public static class UMAnalyticsConfig {
        public String mAppkey;
        public String mChannelId;
        public Context mContext;
        public boolean mIsCrashEnable;
        public EScenarioType mType;

        private UMAnalyticsConfig() {
            this.mAppkey = null;
            this.mChannelId = null;
            this.mIsCrashEnable = true;
            this.mType = EScenarioType.E_UM_NORMAL;
            this.mContext = null;
        }

        public UMAnalyticsConfig(Context context, String str, String str2) {
            this(context, str, str2, null, true);
        }

        public UMAnalyticsConfig(Context context, String str, String str2, EScenarioType eScenarioType) {
            this(context, str, str2, eScenarioType, true);
        }

        public UMAnalyticsConfig(Context context, String str, String str2, EScenarioType eScenarioType, boolean z) {
            this.mAppkey = null;
            this.mChannelId = null;
            this.mIsCrashEnable = true;
            this.mType = EScenarioType.E_UM_NORMAL;
            this.mContext = null;
            this.mContext = context;
            this.mAppkey = str;
            this.mChannelId = str2;
            this.mIsCrashEnable = z;
            if (eScenarioType != null) {
                this.mType = eScenarioType;
                return;
            }
            switch (AnalyticsConfig.getVerticalType(context)) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    this.mType = EScenarioType.E_UM_NORMAL;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.mType = EScenarioType.E_UM_GAME;
                case 224:
                    this.mType = EScenarioType.E_UM_ANALYTICS_OEM;
                case 225:
                    this.mType = EScenarioType.E_UM_GAME_OEM;
                default:
            }
        }
    }

    static {
        f13937b = new C4163b();
    }

    public static void enableEncrypt(boolean z) {
        f13937b.m17010e(z);
    }

    public static C4163b getAgent() {
        return f13937b;
    }

    public static void onEvent(Context context, String str) {
        f13937b.m16982a(context, str, null, -1, 1);
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            ap.m3386b("label is null or empty");
        } else {
            f13937b.m16982a(context, str, str2, -1, 1);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            ap.m3391d(f13936a);
            return;
        }
        f13937b.m16985a(context, str, new HashMap(map), -1);
    }

    public static void onEvent(Context context, List<String> list, int i, String str) {
        f13937b.m16988a(context, (List) list, i, str);
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("__ct__", Integer.valueOf(i));
        f13937b.m16985a(context, str, hashMap, -1);
    }

    public static void onKillProcess(Context context) {
        f13937b.m17007d(context);
    }

    public static void onPageEnd(String str) {
        if (TextUtils.isEmpty(str)) {
            ap.m3391d("pageName is null or empty");
        } else {
            f13937b.m17000b(str);
        }
    }

    public static void onPageStart(String str) {
        if (TextUtils.isEmpty(str)) {
            ap.m3391d("pageName is null or empty");
        } else {
            f13937b.m16991a(str);
        }
    }

    public static void onPause(Context context) {
        f13937b.m16998b(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            ap.m3389c("uid is null");
        } else if (str2.length() > 64) {
            ap.m3389c("uid is Illegal(length bigger then  legitimate length).");
        } else if (TextUtils.isEmpty(str)) {
            f13937b.m17001b("_adhoc", str2);
        } else if (str.length() > 32) {
            ap.m3389c("provider is Illegal(length bigger then  legitimate length).");
        } else {
            f13937b.m17001b(str, str2);
        }
    }

    public static void onProfileSignOff() {
        f13937b.m16996b();
    }

    public static void onResume(Context context) {
        if (context == null) {
            ap.m3391d("unexpected null context in onResume");
        } else {
            f13937b.m16977a(context);
        }
    }

    public static void onSocialEvent(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            ap.m3391d("context is null in onShareEvent");
            return;
        }
        C4188e.f14062e = MessageService.MSG_DB_NOTIFY_DISMISS;
        UMSocialService.share(context, str, uMPlatformDataArr);
    }

    public static void onSocialEvent(Context context, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            ap.m3391d("context is null in onShareEvent");
            return;
        }
        C4188e.f14062e = MessageService.MSG_DB_NOTIFY_DISMISS;
        UMSocialService.share(context, uMPlatformDataArr);
    }

    public static void openActivityDurationTrack(boolean z) {
        f13937b.m17002b(z);
    }

    public static void reportError(Context context, String str) {
        f13937b.m16980a(context, str);
    }

    public static void reportError(Context context, Throwable th) {
        f13937b.m16986a(context, th);
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        f13937b.m16995a(z);
    }

    public static void setCheckDevice(boolean z) {
        f13937b.m17005c(z);
    }

    public static void setDebugMode(boolean z) {
        f13937b.m17008d(z);
    }

    public static void setLatencyWindow(long j) {
        f13937b.m16976a(j);
    }

    public static void setLocation(double d, double d2) {
        f13937b.m16975a(d, d2);
    }

    public static void setOpenGLContext(GL10 gl10) {
        f13937b.m16994a(gl10);
    }

    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
        f13937b.m16979a(context, eScenarioType);
    }

    public static void setSecret(Context context, String str) {
        f13937b.m16999b(context, str);
    }

    public static void setSessionContinueMillis(long j) {
        f13937b.m16997b(j);
    }

    public static void startWithConfigure(UMAnalyticsConfig uMAnalyticsConfig) {
        if (uMAnalyticsConfig != null) {
            f13937b.m16990a(uMAnalyticsConfig);
        }
    }
}
