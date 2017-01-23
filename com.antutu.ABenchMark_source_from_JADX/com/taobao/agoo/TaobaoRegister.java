package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.client.C4086b;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.p194a.C4149a;
import com.taobao.agoo.p194a.p195a.C4147a;
import com.umeng.message.common.C4209a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.android.agoo.accs.AgooService;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.NotifManager;
import org.android.agoo.message.MessageService;

public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    static final String PREFERENCES = "Agoo_AppStore";
    static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    protected static final String TAG = "TaobaoRegister";
    private static C4149a mRequestListener;

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        if (context == null) {
            try {
                throw new NullPointerException("Context==null");
            } catch (Throwable th) {
                ALog.m16902e(TAG, "bindAgoo", th, new Object[0]);
            }
        } else if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("appkey==null");
        } else if (TextUtils.isEmpty(str2)) {
            throw new NullPointerException("ttId==null");
        } else {
            C4575b.m19242a(context, str, str2);
            AgooService.f16390a = callBack;
            ACCSManager.bindService(context, SERVICEID);
            UTMini.getInstance().commitEvent(EVENT_ID, "bindAgoo", UtilityImpl.getDeviceId(context));
        }
    }

    public static void clickMessage(Context context, String str, String str2) {
        try {
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d(TAG, "clickMessage,messageId=" + str + ",taskId=" + str2, new Object[0]);
            }
            String str3 = AgooConstants.MESSAGE_SOURCE_ACCS;
            String str4 = MessageService.MSG_ACCS_NOTIFY_CLICK;
            if (TextUtils.isEmpty(str)) {
                ALog.m16901d(TAG, "messageId == null", new Object[0]);
                return;
            }
            NotifManager notifManager = new NotifManager();
            notifManager.init(context);
            MsgDO msgDO = new MsgDO();
            msgDO.msgIds = str;
            msgDO.messageSource = str3;
            msgDO.msgStatus = str4;
            notifManager.reportNotifyMessage(msgDO);
        } catch (Throwable th) {
            ALog.m16903e(TAG, "clickMessage,error=" + th, new Object[0]);
        }
    }

    public static void dismissMessage(Context context, String str, String str2) {
        try {
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d(TAG, "clickMessage,messageId=" + str + ",taskId=" + str2, new Object[0]);
            }
            String str3 = AgooConstants.MESSAGE_SOURCE_ACCS;
            String str4 = MessageService.MSG_ACCS_NOTIFY_DISMISS;
            if (TextUtils.isEmpty(str)) {
                ALog.m16901d(TAG, "messageId == null", new Object[0]);
                return;
            }
            NotifManager notifManager = new NotifManager();
            notifManager.init(context);
            MsgDO msgDO = new MsgDO();
            msgDO.msgIds = str;
            msgDO.messageSource = str3;
            msgDO.msgStatus = str4;
            notifManager.reportNotifyMessage(msgDO);
        } catch (Throwable th) {
            ALog.m16903e(TAG, "clickMessage,error=" + th, new Object[0]);
        }
    }

    public static void isEnableDaemonServer(Context context, boolean z) {
        if (ALog.isPrintLog(Level.I)) {
            ALog.m16904i(TAG, "isEnableDaemonServer begin,enable=" + z, new Object[0]);
        }
        C4575b.m19243a(context, z);
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i) {
        NotifManager notifManager = new NotifManager();
        notifManager.init(context);
        notifManager.pingApp(str, str2, str3, i);
    }

    public static void register(Context context, String str, String str2, String str3, IRegister iRegister) {
        if (context == null) {
            ALog.m16903e(TAG, "register context null", new Object[0]);
            return;
        }
        ALog.m16904i(TAG, MiPushClient.COMMAND_REGISTER, Constants.KEY_APP_KEY, str, Constants.KEY_TTID, str3);
        ACCSManager.bindApp(context, str, str2, str3, new C4151b(context.getApplicationContext(), iRegister, str, str3));
    }

    public static void removeAlias(Context context, ICallback iCallback) {
        ALog.m16904i(TAG, C4147a.JSON_CMD_REMOVEALIAS, new Object[0]);
        try {
            Object appkey = UtilityImpl.getAppkey(context);
            Object e = C4575b.m19250e(context);
            Object f = C4575b.m19251f(context);
            if (TextUtils.isEmpty(appkey) || TextUtils.isEmpty(e) || context == null || TextUtils.isEmpty(f)) {
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "input params null!!");
                }
                ALog.m16903e(TAG, "setAlias param null", C4209a.f14204g, appkey, C4575b.KEY_DEVICE_TOKEN, e, C4147a.JSON_PUSH_USER_TOKEN, f, "context", context);
                return;
            }
            if (mRequestListener == null) {
                mRequestListener = new C4149a();
                ACCSManager.registerDataListener(context, TaobaoConstants.SERVICE_ID_DEVICECMD, mRequestListener);
            }
            CharSequence sendRequest = ACCSManager.sendRequest(context, new AccsRequest(null, TaobaoConstants.SERVICE_ID_DEVICECMD, C4147a.m16949b(appkey, e, f), null));
            if (TextUtils.isEmpty(sendRequest)) {
                if (iCallback != null) {
                    iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "accs channel disabled!");
                }
            } else if (iCallback != null) {
                mRequestListener.f13920a.put(sendRequest, iCallback);
            }
        } catch (Throwable th) {
            ALog.m16902e(TAG, C4147a.JSON_CMD_REMOVEALIAS, th, new Object[0]);
        }
    }

    public static void setAgooMsgReceiveService(String str) {
        C4085a.f13621b = str;
    }

    public static void setAlias(Context context, String str, ICallback iCallback) {
        ALog.m16904i(TAG, C4147a.JSON_CMD_SETALIAS, C4233j.f14403z, str);
        Object appkey = UtilityImpl.getAppkey(context);
        Object e = C4575b.m19250e(context);
        if (TextUtils.isEmpty(appkey) || TextUtils.isEmpty(e) || context == null || TextUtils.isEmpty(str)) {
            if (iCallback != null) {
                iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "input params null!!");
            }
            ALog.m16903e(TAG, "setAlias param null", C4209a.f14204g, appkey, C4575b.KEY_DEVICE_TOKEN, e, C4233j.f14403z, str, "context", context);
            return;
        }
        try {
            if (C4086b.m16670a(context.getApplicationContext()).m16685i(str)) {
                ALog.m16904i(TAG, "Alias already set", C4233j.f14403z, str);
                if (iCallback != null) {
                    iCallback.onSuccess();
                }
            } else if (C4086b.m16670a(context).m16679c(context.getPackageName())) {
                if (mRequestListener == null) {
                    mRequestListener = new C4149a();
                    ACCSManager.registerDataListener(context, TaobaoConstants.SERVICE_ID_DEVICECMD, mRequestListener);
                }
                CharSequence sendRequest = ACCSManager.sendRequest(context, new AccsRequest(null, TaobaoConstants.SERVICE_ID_DEVICECMD, C4147a.m16948a(appkey, e, str), null));
                if (TextUtils.isEmpty(sendRequest)) {
                    if (iCallback != null) {
                        iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "accs channel disabled!");
                    }
                } else if (iCallback != null) {
                    iCallback.extra = str;
                    mRequestListener.f13920a.put(sendRequest, iCallback);
                }
            } else if (iCallback != null) {
                iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "bindApp first!!");
            }
        } catch (Throwable th) {
            ALog.m16902e(TAG, C4147a.JSON_CMD_SETALIAS, th, new Object[0]);
        }
    }

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z) {
    }

    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        if (context == null) {
            throw new NullPointerException("context==null");
        } else if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("appkey==null");
        } else if (TextUtils.isEmpty(str2)) {
            throw new NullPointerException("ttId==null");
        } else {
            AgooService.f16391b = callBack;
            ACCSManager.unbindService(context, SERVICEID);
            UTMini.getInstance().commitEvent(EVENT_ID, "unregister", UtilityImpl.getDeviceId(context));
        }
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        ALog.m16904i(TAG, "unregister,success,deviceid=" + UtilityImpl.getDeviceId(context), new Object[0]);
        UTMini.getInstance().commitEvent(EVENT_ID, "unregister", UtilityImpl.getDeviceId(context));
        ACCSManager.unbindService(context, SERVICEID);
    }
}
