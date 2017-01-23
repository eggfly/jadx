package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.C4188e;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;
import org.android.agoo.message.MessageService;
import p023b.p024a.ap;

public class UMGameAgent extends MobclickAgent {
    private static final String f13990a = "Input string is null or empty";
    private static final String f13991b = "Input string must be less than 64 chars";
    private static final String f13992c = "Input value type is negative";
    private static final String f13993d = "The int value for 'Pay Channels' ranges between 1 ~ 99 ";
    private static final C4170c f13994e;
    private static Context f13995f;

    static {
        f13994e = new C4170c();
    }

    private static boolean m17015a(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static void bonus(double d, int i) {
        if (d < 0.0d) {
            ap.m3391d(f13992c);
        } else if (i <= 0 || i >= 100) {
            ap.m3391d(f13993d);
        } else {
            f13994e.m17035a(d, i);
        }
    }

    public static void bonus(String str, int i, double d, int i2) {
        if (m17015a(str)) {
            ap.m3391d(f13990a);
        } else if (i < 0 || d < 0.0d) {
            ap.m3391d(f13992c);
        } else if (i2 <= 0 || i2 >= 100) {
            ap.m3391d(f13993d);
        } else {
            f13994e.m17041a(str, i, d, i2);
        }
    }

    public static void buy(String str, int i, double d) {
        if (m17015a(str)) {
            ap.m3391d(f13990a);
        } else if (i < 0 || d < 0.0d) {
            ap.m3391d(f13992c);
        } else {
            f13994e.m17040a(str, i, d);
        }
    }

    public static void exchange(double d, String str, double d2, int i, String str2) {
        if (d < 0.0d || d2 < 0.0d) {
            ap.m3391d(f13992c);
        } else if (i <= 0 || i >= 100) {
            ap.m3391d(f13993d);
        } else {
            f13994e.m17036a(d, str, d2, i, str2);
        }
    }

    public static void failLevel(String str) {
        if (m17015a(str)) {
            ap.m3391d(f13990a);
        } else if (str.length() > 64) {
            ap.m3391d(f13991b);
        } else {
            f13994e.m17047d(str);
        }
    }

    public static void finishLevel(String str) {
        if (m17015a(str)) {
            ap.m3391d(f13990a);
        } else if (str.length() > 64) {
            ap.m3391d(f13991b);
        } else {
            f13994e.m17046c(str);
        }
    }

    public static void init(Context context) {
        f13994e.m17038a(context);
        f13995f = context.getApplicationContext();
    }

    public static void onEvent(String str, String str2) {
        MobclickAgent.onEvent(f13995f, str, str2);
    }

    public static void onSocialEvent(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            ap.m3391d("context is null in onShareEvent");
            return;
        }
        C4188e.f14062e = MessageService.MSG_ACCS_READY_REPORT;
        UMSocialService.share(context, str, uMPlatformDataArr);
    }

    public static void onSocialEvent(Context context, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            ap.m3391d("context is null in onShareEvent");
            return;
        }
        C4188e.f14062e = MessageService.MSG_ACCS_READY_REPORT;
        UMSocialService.share(context, uMPlatformDataArr);
    }

    public static void pay(double d, double d2, int i) {
        if (i <= 0 || i >= 100) {
            ap.m3391d(f13993d);
        } else if (d < 0.0d || d2 < 0.0d) {
            ap.m3391d(f13992c);
        } else {
            f13994e.m17034a(d, d2, i);
        }
    }

    public static void pay(double d, String str, int i, double d2, int i2) {
        if (i2 <= 0 || i2 >= 100) {
            ap.m3391d(f13993d);
        } else if (d < 0.0d || i < 0 || d2 < 0.0d) {
            ap.m3391d(f13992c);
        } else if (m17015a(str)) {
            ap.m3391d(f13990a);
        } else {
            f13994e.m17037a(d, str, i, d2, i2);
        }
    }

    public static void setPlayerLevel(int i) {
        f13994e.m17039a(String.valueOf(i));
    }

    public static void setTraceSleepTime(boolean z) {
        f13994e.m17042a(z);
    }

    public static void startLevel(String str) {
        if (m17015a(str)) {
            ap.m3391d(f13990a);
        } else if (str.length() > 64) {
            ap.m3391d(f13991b);
        } else {
            f13994e.m17044b(str);
        }
    }

    public static void use(String str, int i, double d) {
        if (m17015a(str)) {
            ap.m3391d(f13990a);
        } else if (i < 0 || d < 0.0d) {
            ap.m3391d(f13992c);
        } else {
            f13994e.m17045b(str, i, d);
        }
    }
}
