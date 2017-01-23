package com.antutu.benchmark.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.GeTuiPushMessage;
import com.antutu.utils.DeviceInfoUtil;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.PushMessageUtil;
import com.antutu.utils.infoc.InfocSupportContext;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.google.gson.Gson;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.Tag;
import com.taobao.accs.common.Constants;
import com.umeng.message.entity.UMessage;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.TnetStatusCode;

public class GeTuiReceiver extends BroadcastReceiver {
    private static final String f5595a;
    private Gson f5596b;
    private NotificationManager f5597c;

    /* renamed from: com.antutu.benchmark.receiver.GeTuiReceiver.a */
    private static class C1601a extends Tag {
        C1601a(int i) {
            this(String.valueOf(i));
        }

        C1601a(String str) {
            setName(str);
        }
    }

    static {
        f5595a = GeTuiReceiver.class.getSimpleName();
    }

    public GeTuiReceiver() {
        this.f5596b = new Gson();
    }

    private Notification m6307a(Context context, GeTuiPushMessage geTuiPushMessage) {
        return new Builder(context).setSmallIcon(C1082R.drawable.ic_noti_small).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), C1082R.drawable.app_icon)).setContentTitle(geTuiPushMessage.getTitle()).setContentText(geTuiPushMessage.getSummary()).setContentIntent(PendingIntent.getBroadcast(context, 1, m6308a(geTuiPushMessage), 134217728)).setAutoCancel(true).build();
    }

    private static Intent m6308a(GeTuiPushMessage geTuiPushMessage) {
        return new Intent().setAction("com.antutu.ABenchMark.action.GE_TUI_CLICK").putExtra("GeTuiPushMessage", geTuiPushMessage);
    }

    private void m6309a(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            int i = extras.getInt(PushConsts.CMD_ACTION);
            if (PushConsts.GET_CLIENTID == i) {
                MLog.m6865d(f5595a, "GeTui CID = " + extras.getString("clientid"));
                m6310b(context);
            } else if (PushConsts.GET_MSG_DATA == i) {
                MLog.m6865d(f5595a, "GeTui TaskId = " + extras.getString("taskid"));
                MLog.m6865d(f5595a, "GeTui MessageId = " + extras.getString("messageid"));
                byte[] byteArray = extras.getByteArray("payload");
                if (byteArray != null) {
                    GeTuiPushMessage geTuiPushMessage;
                    String str = new String(byteArray);
                    MLog.m6865d(f5595a, "GeTui StringJson = " + str);
                    try {
                        geTuiPushMessage = (GeTuiPushMessage) this.f5596b.fromJson(str, GeTuiPushMessage.class);
                    } catch (Throwable e) {
                        MLog.m6866d(f5595a, "GeTui JsonSyntaxException", e);
                        geTuiPushMessage = null;
                    }
                    if (geTuiPushMessage != null && !TextUtils.isEmpty(geTuiPushMessage.getTarget()) && !TextUtils.isEmpty(geTuiPushMessage.getTitle()) && !TextUtils.isEmpty(geTuiPushMessage.getSummary()) && !TextUtils.isEmpty(geTuiPushMessage.getUrl()) && !TextUtils.isEmpty(geTuiPushMessage.getShare_url())) {
                        m6312a(context).notify(4655312, m6307a(context, geTuiPushMessage));
                        InfocUtil.antutu_push(context, 1, geTuiPushMessage.getTitle(), "\u4e2a\u63a8");
                    }
                }
            } else if (PushConsts.SET_TAG_RESULT == i) {
                extras.getString(IXAdRequestInfo.SN);
                switch (Integer.valueOf(extras.getString(Constants.KEY_HTTP_CODE)).intValue()) {
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        MLog.m6865d(f5595a, "GeTui set tags success...");
                    case PushConsts.SETTAG_ERROR_COUNT /*20001*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_ERROR_COUNT...");
                    case PushConsts.SETTAG_ERROR_FREQUENCY /*20002*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_ERROR_FREQUENCY...");
                    case PushConsts.SETTAG_ERROR_REPEAT /*20003*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_ERROR_REPEAT...");
                    case PushConsts.SETTAG_ERROR_UNBIND /*20004*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_ERROR_UNBIND...");
                    case PushConsts.SETTAG_ERROR_EXCEPTION /*20005*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_ERROR_EXCEPTION...");
                    case PushConsts.SETTAG_ERROR_NULL /*20006*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_ERROR_NULL...");
                    case PushConsts.SETTAG_NOTONLINE /*20008*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_NOTONLINE...");
                    case PushConsts.SETTAG_IN_BLACKLIST /*20009*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_IN_BLACKLIST...");
                    case PushConsts.SETTAG_NUM_EXCEED /*20010*/:
                        MLog.m6865d(f5595a, "GeTui set tags error...");
                        MLog.m6865d(f5595a, "PushConsts.SETTAG_NUM_EXCEED...");
                    default:
                }
            }
        }
    }

    private void m6310b(Context context) {
        List arrayList = new ArrayList();
        arrayList.add(new C1601a("6.3.3"));
        arrayList.add(new C1601a(InfocSupportContext.getOemId(context)));
        arrayList.add(new C1601a(DeviceInfoUtil.getBrand()));
        arrayList.add(new C1601a(DeviceInfoUtil.getModel()));
        arrayList.add(new C1601a("Android " + DeviceInfoUtil.getOSVersion()));
        arrayList.add(new C1601a(DeviceInfoUtil.getLocale(context)));
        PushManager.getInstance().setTag(context, (Tag[]) arrayList.toArray(new Tag[arrayList.size()]), System.currentTimeMillis() + BuildConfig.FLAVOR);
    }

    private void m6311b(Context context, Intent intent) {
        GeTuiPushMessage geTuiPushMessage = (GeTuiPushMessage) intent.getParcelableExtra("GeTuiPushMessage");
        if (geTuiPushMessage != null) {
            PushMessageUtil.dealWithMessage(context, 2, geTuiPushMessage);
        }
    }

    public NotificationManager m6312a(Context context) {
        if (this.f5597c == null) {
            this.f5597c = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        }
        return this.f5597c;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.igexin.sdk.action.ZJJ5spRHSxAO0QpkSa6hz8".equals(intent.getAction())) {
            m6309a(context, intent);
        } else if ("com.antutu.ABenchMark.action.GE_TUI_CLICK".equals(intent.getAction())) {
            m6311b(context, intent);
        }
        PushMessageUtil.openLiveService(context);
    }
}
