package org.android.agoo.control;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.C4136b;
import com.taobao.agoo.TaobaoConstants;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.android.agoo.common.MsgDO;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;

public abstract class BaseIntentService extends IntentService {
    private static final String TAG = "BaseIntentService";
    private static final String msgStatus = "4";
    private AgooFactory agooFactory;
    private Context mContext;
    private MessageService messageService;
    private NotifManager notifyManager;

    public BaseIntentService() {
        super("AgooIntentService");
        this.mContext = null;
    }

    private final String getTrace(Context context, long j) {
        String str = null;
        String str2 = TextUtils.isEmpty(null) ? "unknow" : null;
        if (TextUtils.isEmpty(null)) {
            str = "unknow";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C4209a.f14204g);
        stringBuffer.append("|");
        stringBuffer.append(j);
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(str2);
        stringBuffer.append("|");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private final void handleRemoteMessage(Context context, Intent intent) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        String stringExtra4;
        String str;
        String stringExtra5;
        String str2;
        int parseInt;
        CharSequence stringExtra6;
        try {
            stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            stringExtra2 = intent.getStringExtra(C4156a.f13961w);
            String stringExtra7 = intent.getStringExtra(C4233j.f14402y);
            stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            stringExtra4 = intent.getStringExtra(AgooConstants.MESSAGE_REPORT);
            String stringExtra8 = intent.getStringExtra(AgooConstants.MESSAGE_ENCRYPTED);
            ExtraInfo extraInfo = null;
            str = null;
            Context context2 = context;
            getTrace(context2, Long.valueOf(intent.getLongExtra(AgooConstants.MESSAGE_TRACE, -1)).longValue());
            Bundle bundleExtra = intent.getBundleExtra(AgooConstants.MESSAGE_AGOO_BUNDLE);
            if (bundleExtra != null) {
                extraInfo = (ExtraInfo) bundleExtra.getSerializable(AgooConstants.MESSAGE_ACCS_EXTRA);
            }
            str = intent.getStringExtra(AgooConstants.MESSAGE_FROM_PKG);
            if (TextUtils.isEmpty(str)) {
                str = "oldsdk";
            }
            stringExtra5 = intent.getStringExtra(AgooConstants.MESSAGE_FROM_APPKEY);
            ExtraInfo extraInfo2 = extraInfo;
        } catch (Throwable th) {
            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive_exception" + th.toString(), 0.0d);
            return;
        }
        if (ALog.isPrintLog(Level.I)) {
            ALog.m16904i(TAG, "handleRemoteMessage", C4233j.f14376C, stringExtra2, AgooConstants.MESSAGE_FROM_PKG, stringExtra3, "msgId", stringExtra, MsgConstant.KEY_UTDID, C4135a.m16912b(context), "fromPkg", str, AgooConstants.MESSAGE_FROM_APPKEY, stringExtra5);
        }
        MsgDO msgDO = new MsgDO();
        msgDO.msgIds = stringExtra;
        msgDO.messageSource = stringExtra3;
        msgDO.msgStatus = msgStatus;
        msgDO.reportStr = stringExtra4;
        msgDO.fromPkg = str;
        msgDO.fromAppkey = stringExtra5;
        msgDO.isStartProc = C4085a.m16664d();
        if (!TextUtils.isEmpty(stringExtra2)) {
            if (Integer.toString(0).equals(stringExtra8)) {
                ALog.m16904i(TAG, "normal msg, onMessage() will be excuted", new Object[0]);
                str2 = stringExtra2;
            } else if (Integer.toString(4).equals(stringExtra8)) {
                if (!intent.getBooleanExtra(AgooConstants.MESSAGE_HAS_DECRYPTED, false)) {
                    ALog.m16904i(TAG, "message is encrypted, attemp to decrypt msg", new Object[0]);
                    str2 = AgooFactory.parseEncryptedMsg(stringExtra2);
                }
            } else {
                ALog.m16903e(TAG, "msg encrypted flag not exist~~", new Object[0]);
                try {
                    msgDO.errorCode = AgooConstants.REPORT_ENCRYPT_FAIL;
                    this.notifyManager.report(msgDO, extraInfo2);
                    return;
                } catch (Throwable th2) {
                    return;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                intent.putExtra(C4156a.f13961w, str2);
                try {
                    this.notifyManager.report(msgDO, extraInfo2);
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE_ID, msgDO.msgIds, 0.0d);
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive", 0.0d);
                } catch (Throwable th3) {
                    ALog.m16903e(TAG, "report message Throwable--->t=" + th3.toString(), new Object[0]);
                }
                if (this.messageService.m19276a(stringExtra)) {
                    if (ALog.isPrintLog(Level.I)) {
                        ALog.m16904i(TAG, "handleMessage--->[" + str2 + "],[" + stringExtra3 + "]", new Object[0]);
                    }
                    try {
                        CharSequence stringExtra9 = intent.getStringExtra(AgooConstants.MESSAGE_DUPLICATE);
                        if (!TextUtils.isEmpty(stringExtra9) && TextUtils.equals(stringExtra9, MessageService.MSG_DB_NOTIFY_REACHED)) {
                            if (this.messageService.m19277a(stringExtra, str2.hashCode())) {
                                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive_dupbody", 0.0d);
                                return;
                            }
                        }
                    } catch (Throwable th32) {
                        if (ALog.isPrintLog(Level.E)) {
                            ALog.m16903e(TAG, "hasMessageDuplicate message,e=" + th32.toString(), new Object[0]);
                        }
                    }
                    int i = -1;
                    try {
                        parseInt = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                    } catch (Throwable th4) {
                        parseInt = i;
                    }
                    stringExtra5 = BuildConfig.FLAVOR;
                    try {
                        stringExtra6 = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                        if (TextUtils.isEmpty(stringExtra6) && TextUtils.equals(stringExtra6, MessageService.MSG_DB_NOTIFY_REACHED)) {
                            this.messageService.m19275a(stringExtra, str2, stringExtra7, parseInt);
                            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive_test", 0.0d);
                            return;
                        }
                        stringExtra5 = getClass().getName();
                        this.messageService.m19275a(stringExtra, str2, stringExtra7, parseInt);
                        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, msgDO.msgIds, 0.0d);
                        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive_real_" + stringExtra5, 0.0d);
                        onMessage(context, intent);
                        return;
                    } catch (Throwable th5) {
                    }
                } else {
                    if (ALog.isPrintLog(Level.I)) {
                        ALog.m16904i(TAG, "handleRemoteMessage hasMessageDuplicate,messageId=" + stringExtra + ",utdid=" + C4135a.m16912b(context), new Object[0]);
                    }
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive_dup", 0.0d);
                    return;
                }
            }
            try {
                msgDO.errorCode = AgooConstants.REPORT_MESSAGE_NULL;
                this.notifyManager.report(msgDO, extraInfo2);
            } catch (Throwable th6) {
            }
            ALog.m16903e(TAG, "handleMessage--->[null]", new Object[0]);
        }
        str2 = stringExtra2;
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra(C4156a.f13961w, str2);
            this.notifyManager.report(msgDO, extraInfo2);
            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE_ID, msgDO.msgIds, 0.0d);
            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive", 0.0d);
            if (this.messageService.m19276a(stringExtra)) {
                if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i(TAG, "handleMessage--->[" + str2 + "],[" + stringExtra3 + "]", new Object[0]);
                }
                CharSequence stringExtra92 = intent.getStringExtra(AgooConstants.MESSAGE_DUPLICATE);
                if (this.messageService.m19277a(stringExtra, str2.hashCode())) {
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive_dupbody", 0.0d);
                    return;
                }
                int i2 = -1;
                parseInt = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                stringExtra5 = BuildConfig.FLAVOR;
                stringExtra6 = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                if (TextUtils.isEmpty(stringExtra6)) {
                }
                stringExtra5 = getClass().getName();
                this.messageService.m19275a(stringExtra, str2, stringExtra7, parseInt);
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, msgDO.msgIds, 0.0d);
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive_real_" + stringExtra5, 0.0d);
                onMessage(context, intent);
                return;
            }
            if (ALog.isPrintLog(Level.I)) {
                ALog.m16904i(TAG, "handleRemoteMessage hasMessageDuplicate,messageId=" + stringExtra + ",utdid=" + C4135a.m16912b(context), new Object[0]);
            }
            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ARRIVE, "arrive_dup", 0.0d);
            return;
        }
        msgDO.errorCode = AgooConstants.REPORT_MESSAGE_NULL;
        this.notifyManager.report(msgDO, extraInfo2);
        ALog.m16903e(TAG, "handleMessage--->[null]", new Object[0]);
    }

    private final void handleRemovePackage(Context context, Intent intent) {
        if (intent != null && context != null) {
            String str = null;
            Uri data = intent.getData();
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (!TextUtils.isEmpty(str)) {
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                if (ALog.isPrintLog(Level.D)) {
                    ALog.m16901d(TAG, "handleRemovePackage---->[replacing:" + booleanExtra + "],uninstallPack=" + str, new Object[0]);
                }
                if (!booleanExtra) {
                    this.notifyManager.doUninstall(str, booleanExtra);
                }
            }
        }
    }

    public static final void runIntentInService(Context context, Intent intent, String str) {
        try {
            intent.setClassName(context, str);
            context.startService(intent);
        } catch (Throwable th) {
            ALog.m16905w(TAG, "runIntentInService", th, new Object[0]);
        }
    }

    public void onCreate() {
        C4085a.f13626g.incrementAndGet();
        this.notifyManager = new NotifManager();
        this.notifyManager.init(getApplicationContext());
        this.messageService = new MessageService();
        this.messageService.m19272a(getApplicationContext());
        this.agooFactory = new AgooFactory();
        this.agooFactory.init(getApplicationContext(), this.notifyManager, this.messageService);
        super.onCreate();
    }

    protected abstract void onError(Context context, String str);

    protected void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent != null) {
            CharSequence action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                CharSequence agooCommand = IntentUtil.getAgooCommand(this.mContext);
                CharSequence thirdPushCommand = IntentUtil.getThirdPushCommand(this.mContext);
                ALog.m16904i(TAG, "onHandleIntent,action=" + action + ",agooCommand=" + agooCommand + ",mipushCommand=" + thirdPushCommand, new Object[0]);
                try {
                    if (TextUtils.equals(action, agooCommand)) {
                        action = intent.getStringExtra(IntentUtil.AGOO_COMMAND);
                        ALog.m16901d(TAG, "actionCommand --->[" + action + "]", new Object[0]);
                        if (TextUtils.equals(action, AgooConstants.AGOO_COMMAND_MESSAGE_READED) || TextUtils.equals(action, AgooConstants.AGOO_COMMAND_MESSAGE_DELETED)) {
                            onUserCommand(this.mContext, intent);
                        }
                    } else if (TextUtils.equals(action, thirdPushCommand)) {
                        action = intent.getStringExtra(IntentUtil.AGOO_COMMAND);
                        String stringExtra = intent.getStringExtra(AgooConstants.THIRD_PUSH_ID);
                        if (TextUtils.equals(action, AgooConstants.AGOO_COMMAND_MIPUSHID_REPORT)) {
                            this.notifyManager.reportThirdPushToken(stringExtra, "MI_TOKEN");
                        } else if (TextUtils.equals(action, AgooConstants.AGOO_COMMAND_HUAWEIPUSHID_REPORT)) {
                            ALog.m16901d(TAG, "HW_TOKEN report begin..regid=" + stringExtra, new Object[0]);
                            this.notifyManager.reportThirdPushToken(stringExtra, "HW_TOKEN");
                        } else if (TextUtils.equals(action, AgooConstants.AGOO_COMMAND_GCMIPUSHID_REPORT)) {
                            ALog.m16904i(TAG, "GCM_TOKEN report begin..regid=" + stringExtra, new Object[0]);
                            this.notifyManager.reportThirdPushToken(stringExtra, TaobaoConstants.MESSAGE_SYSTEM_SOURCE_GCM);
                        }
                    } else if (action.equals(AgooConstants.INTENT_FROM_AGOO_MESSAGE)) {
                        handleRemoteMessage(this.mContext, intent);
                    } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                        handleRemovePackage(this.mContext, intent);
                    } else if (TextUtils.equals(action, AgooConstants.INTENT_FROM_AGOO_REPORT) || TextUtils.equals(action, PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) || TextUtils.equals(action, PushConsts.ACTION_BROADCAST_TO_BOOT) || TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || TextUtils.equals(action, PushConsts.ACTION_BROADCAST_USER_PRESENT) || TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        try {
                            ALog.m16904i(TAG, "is report cache msg,Config.isReportCacheMsg(mContext)=" + C4575b.m19244a(this.mContext), new Object[0]);
                            if (C4575b.m19244a(this.mContext) && C4135a.m16913c(this.mContext)) {
                                C4575b.m19245b(this.mContext);
                                this.agooFactory.reportCacheMsg();
                                this.messageService.m19271a();
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (ALog.isPrintLog(Level.I)) {
                                ALog.m16904i(TAG, "is clear all msg=" + C4575b.m19247b(this.mContext, currentTimeMillis), new Object[0]);
                            }
                            if (C4575b.m19247b(this.mContext, currentTimeMillis)) {
                                C4575b.m19240a(this.mContext, currentTimeMillis);
                                this.messageService.m19271a();
                            }
                        } catch (Throwable th) {
                            ALog.m16902e(TAG, "reportCacheMsg", th, new Object[0]);
                        }
                    }
                    C4085a.f13626g.incrementAndGet();
                } catch (Throwable th2) {
                    C4085a.f13626g.incrementAndGet();
                }
            }
        }
    }

    protected abstract void onMessage(Context context, Intent intent);

    protected abstract void onRegistered(Context context, String str);

    protected void onUserCommand(Context context, Intent intent) {
    }
}
