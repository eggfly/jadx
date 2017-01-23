package com.antutu.utils;

import android.content.Context;
import android.content.Intent;
import com.antutu.ABenchMark.ABenchMarkStart;
import com.antutu.benchmark.activity.ExposureActivity;
import com.antutu.benchmark.activity.ExposureDetailActivity;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.model.GeTuiPushMessage;
import com.antutu.benchmark.modelreflact.ExposureListModel;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.service.BenchmarkMainService;
import com.antutu.utils.widget.WebBrowserActivity;
import com.igexin.download.Downloads;
import com.taobao.accs.common.Constants;
import com.umeng.message.entity.UMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;
import org.android.spdy.TnetStatusCode;
import org.json.JSONException;
import org.json.JSONObject;

public class PushMessageUtil {
    public static final String ACTION_HAS_PUSH = "ACTION_HAS_PUSH";
    public static final String ACTION_PUSH_MESSAGE = "ACTION_PUSH_MESSAGE";
    public static final String ACTION_PUSH_PLATFORM = "ACTION_PUSH_PLATFORM";
    public static final String EXPOSURE_DETAIL = "EXPOSURE_DETAIL";
    public static final String EXPOSURE_LIST = "EXPOSURE_LIST";
    public static final String NEWS_DETAIL = "NEWS_DETAIL";
    public static final String NEWS_LIST = "NEWS_LIST";
    public static final int PLATFORM_GETUI = 2;
    public static final int PLATFORM_MI = 3;
    public static final int PLATFORM_UMENG = 1;

    public static void dealWithMessage(Context context, int i, Object obj) {
        if (obj != null) {
            if (!C1503b.f5115c) {
                openABenchMarkStart(context, i, obj);
            } else if (C1503b.f5116d) {
                processPushMessage(context, i, obj);
            } else {
                openMainActivity(context, i, obj);
            }
        }
    }

    private static void gotoExposureDetail(Context context, int i, Object obj) {
        if (obj != null) {
            String str;
            Intent intent = new Intent();
            intent.setClass(context, ExposureDetailActivity.class);
            intent.setFlags(268435456);
            String str2 = BuildConfig.FLAVOR;
            String str3 = BuildConfig.FLAVOR;
            String str4 = BuildConfig.FLAVOR;
            String str5 = BuildConfig.FLAVOR;
            String str6 = BuildConfig.FLAVOR;
            String str7 = BuildConfig.FLAVOR;
            Map map;
            switch (i) {
                case PLATFORM_UMENG /*1*/:
                    map = ((UMessage) obj).extra;
                    if (map != null) {
                        str2 = (String) map.get(Constants.KEY_MODEL);
                        str3 = (String) map.get("score");
                        str4 = (String) map.get("date");
                        str5 = (String) map.get("clicks");
                        str = (String) map.get("url");
                        str7 = (String) map.get("modelpic");
                        str6 = str5;
                        str5 = str4;
                        str4 = str3;
                        str3 = str2;
                        break;
                    }
                    return;
                case PLATFORM_GETUI /*2*/:
                    str = str7;
                    str7 = str6;
                    str6 = str5;
                    str5 = str4;
                    str4 = str3;
                    str3 = str2;
                    break;
                case PLATFORM_MI /*3*/:
                    map = ((MiPushMessage) obj).getExtra();
                    if (map != null) {
                        str2 = (String) map.get(Constants.KEY_MODEL);
                        str3 = (String) map.get("score");
                        str4 = (String) map.get("date");
                        str5 = (String) map.get("clicks");
                        str = (String) map.get("url");
                        str7 = (String) map.get("modelpic");
                        str6 = str5;
                        str5 = str4;
                        str4 = str3;
                        str3 = str2;
                        break;
                    }
                    return;
                default:
                    str = str7;
                    str7 = str6;
                    str6 = str5;
                    str5 = str4;
                    str4 = str3;
                    str3 = str2;
                    break;
            }
            intent.putExtra("ITEM", new ExposureListModel(str3, str4, str5, str6, str7, str));
            context.startActivity(intent);
        }
    }

    private static void gotoExposureList(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, ExposureActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void gotoH5Page(Context context, int i, Object obj) {
        if (obj != null) {
            String str;
            String str2 = BuildConfig.FLAVOR;
            String str3 = BuildConfig.FLAVOR;
            String str4 = BuildConfig.FLAVOR;
            String str5 = BuildConfig.FLAVOR;
            String str6 = BuildConfig.FLAVOR;
            Map map;
            switch (i) {
                case PLATFORM_UMENG /*1*/:
                    map = ((UMessage) obj).extra;
                    if (map != null) {
                        str2 = (String) map.get("url");
                        str3 = (String) map.get(Downloads.COLUMN_TITLE);
                        str4 = (String) map.get("picture");
                        str = (String) map.get("share_url");
                        str6 = (String) map.get("summary");
                        str5 = str4;
                        str4 = str3;
                        str3 = str2;
                        break;
                    }
                    return;
                case PLATFORM_GETUI /*2*/:
                    GeTuiPushMessage geTuiPushMessage = (GeTuiPushMessage) obj;
                    str2 = geTuiPushMessage.getUrl();
                    str3 = geTuiPushMessage.getTitle();
                    str4 = geTuiPushMessage.getPicture();
                    str5 = geTuiPushMessage.getSummary();
                    str = geTuiPushMessage.getShare_url();
                    str6 = str5;
                    str5 = str4;
                    str4 = str3;
                    str3 = str2;
                    break;
                case PLATFORM_MI /*3*/:
                    map = ((MiPushMessage) obj).getExtra();
                    if (map != null) {
                        str2 = (String) map.get("url");
                        str3 = (String) map.get(Downloads.COLUMN_TITLE);
                        str4 = (String) map.get("picture");
                        str = (String) map.get("share_url");
                        str6 = (String) map.get("summary");
                        str5 = str4;
                        str4 = str3;
                        str3 = str2;
                        break;
                    }
                    return;
                default:
                    str = str6;
                    str6 = str5;
                    str5 = str4;
                    str4 = str3;
                    str3 = str2;
                    break;
            }
            WebBrowserActivity.openWebActivity(context, str3, str4, str5, str6, str);
        }
    }

    private static void gotoNewsDetail(Context context, int i, Object obj) {
        if (obj != null) {
            String str;
            String str2 = BuildConfig.FLAVOR;
            String str3 = BuildConfig.FLAVOR;
            String str4 = BuildConfig.FLAVOR;
            String str5 = BuildConfig.FLAVOR;
            String str6 = BuildConfig.FLAVOR;
            Map map;
            switch (i) {
                case PLATFORM_UMENG /*1*/:
                    map = ((UMessage) obj).extra;
                    if (map != null) {
                        str2 = (String) map.get("url");
                        str3 = (String) map.get(Downloads.COLUMN_TITLE);
                        str4 = (String) map.get("picture");
                        str5 = (String) map.get("summary");
                        str6 = (String) map.get("share_url");
                        InfocUtil.antutu_push(context, PLATFORM_GETUI, str3, "\u53cb\u76df");
                        str = str6;
                        str6 = str5;
                        str5 = str4;
                        str4 = str3;
                        str3 = str2;
                        break;
                    }
                    return;
                case PLATFORM_GETUI /*2*/:
                    GeTuiPushMessage geTuiPushMessage = (GeTuiPushMessage) obj;
                    str2 = geTuiPushMessage.getUrl();
                    str3 = geTuiPushMessage.getTitle();
                    str4 = geTuiPushMessage.getPicture();
                    str5 = geTuiPushMessage.getSummary();
                    str6 = geTuiPushMessage.getShare_url();
                    InfocUtil.antutu_push(context, PLATFORM_GETUI, str3, "\u4e2a\u63a8");
                    str = str6;
                    str6 = str5;
                    str5 = str4;
                    str4 = str3;
                    str3 = str2;
                    break;
                case PLATFORM_MI /*3*/:
                    map = ((MiPushMessage) obj).getExtra();
                    if (map != null) {
                        str2 = (String) map.get("url");
                        str3 = (String) map.get(Downloads.COLUMN_TITLE);
                        str4 = (String) map.get("picture");
                        str5 = (String) map.get("summary");
                        str6 = (String) map.get("share_url");
                        InfocUtil.antutu_push(context, PLATFORM_GETUI, str3, "\u5c0f\u7c73");
                        break;
                    }
                    return;
            }
            str = str6;
            str6 = str5;
            str5 = str4;
            str4 = str3;
            str3 = str2;
            WebBrowserActivity.openWebActivity(context, str3, str4, str5, str6, str);
        }
    }

    private static void gotoNewsList(Context context) {
        Intent intent = new Intent();
        intent.putExtra("ACTION_OPEN_PAGE", PLATFORM_MI);
        intent.setFlags(268435456);
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }

    private static void openABenchMarkStart(Context context, int i, Object obj) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra(ACTION_HAS_PUSH, true);
        intent.putExtra(ACTION_PUSH_PLATFORM, i);
        switch (i) {
            case PLATFORM_UMENG /*1*/:
                intent.putExtra(ACTION_PUSH_MESSAGE, ((UMessage) obj).getRaw().toString());
                break;
            case PLATFORM_GETUI /*2*/:
                intent.putExtra(ACTION_PUSH_MESSAGE, (GeTuiPushMessage) obj);
                break;
            case PLATFORM_MI /*3*/:
                intent.putExtra(ACTION_PUSH_MESSAGE, (MiPushMessage) obj);
                break;
        }
        intent.setClass(context, ABenchMarkStart.class);
        context.startActivity(intent);
    }

    public static void openLiveService(Context context) {
        context.startService(BenchmarkMainService.m6356d(context));
    }

    private static void openMainActivity(Context context, int i, Object obj) {
        Intent intent = new Intent();
        intent.setFlags(335544320);
        intent.putExtra(ACTION_HAS_PUSH, true);
        intent.putExtra(ACTION_PUSH_PLATFORM, i);
        switch (i) {
            case PLATFORM_UMENG /*1*/:
                intent.putExtra(ACTION_PUSH_MESSAGE, ((UMessage) obj).getRaw().toString());
                break;
            case PLATFORM_GETUI /*2*/:
                intent.putExtra(ACTION_PUSH_MESSAGE, (GeTuiPushMessage) obj);
                break;
            case PLATFORM_MI /*3*/:
                intent.putExtra(ACTION_PUSH_MESSAGE, (MiPushMessage) obj);
                break;
        }
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }

    private static void processGeTuiPushMessage(Context context, GeTuiPushMessage geTuiPushMessage) {
        if (geTuiPushMessage != null) {
            String target = geTuiPushMessage.getTarget();
            int i = -1;
            switch (target.hashCode()) {
                case -1177965942:
                    if (target.equals(NEWS_LIST)) {
                        i = PLATFORM_UMENG;
                        break;
                    }
                    break;
                case -1095289207:
                    if (target.equals(EXPOSURE_DETAIL)) {
                        i = PLATFORM_GETUI;
                        break;
                    }
                    break;
                case -715980586:
                    if (target.equals(EXPOSURE_LIST)) {
                        i = PLATFORM_MI;
                        break;
                    }
                    break;
                case 1613382461:
                    if (target.equals(NEWS_DETAIL)) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    gotoNewsDetail(context, PLATFORM_GETUI, geTuiPushMessage);
                case PLATFORM_UMENG /*1*/:
                case PLATFORM_GETUI /*2*/:
                default:
            }
        }
    }

    private static void processMiPushMessage(Context context, MiPushMessage miPushMessage) {
        if (miPushMessage != null) {
            String content = miPushMessage.getContent();
            int i = -1;
            switch (content.hashCode()) {
                case -1177965942:
                    if (content.equals(NEWS_LIST)) {
                        i = PLATFORM_UMENG;
                        break;
                    }
                    break;
                case -1095289207:
                    if (content.equals(EXPOSURE_DETAIL)) {
                        i = PLATFORM_GETUI;
                        break;
                    }
                    break;
                case -715980586:
                    if (content.equals(EXPOSURE_LIST)) {
                        i = PLATFORM_MI;
                        break;
                    }
                    break;
                case 1613382461:
                    if (content.equals(NEWS_DETAIL)) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    gotoNewsDetail(context, PLATFORM_MI, miPushMessage);
                case PLATFORM_UMENG /*1*/:
                    gotoNewsList(context);
                case PLATFORM_GETUI /*2*/:
                    gotoExposureDetail(context, PLATFORM_MI, miPushMessage);
                case PLATFORM_MI /*3*/:
                    gotoExposureList(context);
                default:
            }
        }
    }

    private static void processPushMessage(Context context, int i, Object obj) {
        if (obj != null) {
            switch (i) {
                case PLATFORM_UMENG /*1*/:
                    processUmengPushMessage(context, (UMessage) obj);
                    break;
                case PLATFORM_GETUI /*2*/:
                    processGeTuiPushMessage(context, (GeTuiPushMessage) obj);
                    break;
                case PLATFORM_MI /*3*/:
                    processMiPushMessage(context, (MiPushMessage) obj);
                    break;
            }
            context.startService(BenchmarkMainService.m6358e(context));
        }
    }

    public static void processPushMessage(Context context, Intent intent) {
        if (intent != null && intent.getBooleanExtra(ACTION_HAS_PUSH, false)) {
            int intExtra = intent.getIntExtra(ACTION_PUSH_PLATFORM, 0);
            if (intExtra > 0) {
                switch (intExtra) {
                    case PLATFORM_UMENG /*1*/:
                        Object uMessage;
                        try {
                            uMessage = new UMessage(new JSONObject(intent.getStringExtra(ACTION_PUSH_MESSAGE)));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            uMessage = null;
                        }
                        processPushMessage(context, intExtra, uMessage);
                    case PLATFORM_GETUI /*2*/:
                        processPushMessage(context, intExtra, (GeTuiPushMessage) intent.getParcelableExtra(ACTION_PUSH_MESSAGE));
                    case PLATFORM_MI /*3*/:
                        processPushMessage(context, intExtra, (MiPushMessage) intent.getSerializableExtra(ACTION_PUSH_MESSAGE));
                    default:
                }
            }
        }
    }

    private static void processUmengPushMessage(Context context, UMessage uMessage) {
        if (uMessage != null) {
            String str = uMessage.custom;
            int i = -1;
            switch (str.hashCode()) {
                case -1177965942:
                    if (str.equals(NEWS_LIST)) {
                        i = PLATFORM_UMENG;
                        break;
                    }
                    break;
                case -1095289207:
                    if (str.equals(EXPOSURE_DETAIL)) {
                        i = PLATFORM_GETUI;
                        break;
                    }
                    break;
                case -715980586:
                    if (str.equals(EXPOSURE_LIST)) {
                        i = PLATFORM_MI;
                        break;
                    }
                    break;
                case 1613382461:
                    if (str.equals(NEWS_DETAIL)) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    gotoNewsDetail(context, PLATFORM_UMENG, uMessage);
                case PLATFORM_UMENG /*1*/:
                    gotoNewsList(context);
                case PLATFORM_GETUI /*2*/:
                    gotoExposureDetail(context, PLATFORM_UMENG, uMessage);
                case PLATFORM_MI /*3*/:
                    gotoExposureList(context);
                default:
            }
        }
    }
}
