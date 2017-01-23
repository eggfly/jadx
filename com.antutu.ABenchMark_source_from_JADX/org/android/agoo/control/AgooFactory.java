package org.android.agoo.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.C0714a;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.UTMini;
import com.umeng.analytics.C4156a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4574a;
import org.android.agoo.common.C4576c;
import org.android.agoo.common.C4579e.C4578a;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;
import org.android.agoo.service.SendMessage;
import org.android.agoo.service.SendMessage.Stub;
import org.json.JSONArray;
import org.json.JSONObject;

public class AgooFactory {
    private static final String DEAL_MESSAGE = "accs.msgRecevie";
    private static final String TAG = "AgooFactory";
    private static Context mContext;
    private ScheduledThreadPoolExecutor mThreadPool;
    private MessageService messageService;
    protected NotifManager notifyManager;

    /* renamed from: org.android.agoo.control.AgooFactory.a */
    class C4580a implements ServiceConnection {
        final /* synthetic */ AgooFactory f16405a;
        private Intent f16406b;
        private String f16407c;
        private SendMessage f16408d;
        private ServiceConnection f16409e;

        public C4580a(AgooFactory agooFactory, String str, Intent intent) {
            this.f16405a = agooFactory;
            this.f16407c = str;
            this.f16406b = intent;
            this.f16409e = this;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALog.m16901d(AgooFactory.TAG, "MessageConnection conneted:" + componentName, new Object[0]);
            this.f16408d = Stub.asInterface(iBinder);
            ALog.m16901d(AgooFactory.TAG, "onConnected current tid:" + Thread.currentThread().getId(), new Object[0]);
            ALog.m16901d(AgooFactory.TAG, "MessageConnection sent:" + this.f16406b, new Object[0]);
            if (this.f16408d != null) {
                this.f16405a.mThreadPool.execute(new C4587f(this));
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ALog.m16901d(AgooFactory.TAG, "MessageConnection disConnected", new Object[0]);
        }
    }

    /* renamed from: org.android.agoo.control.AgooFactory.b */
    class C4581b implements Runnable {
        final /* synthetic */ AgooFactory f16410a;
        private String f16411b;
        private Intent f16412c;

        public C4581b(AgooFactory agooFactory, String str, Intent intent) {
            this.f16410a = agooFactory;
            this.f16411b = str;
            this.f16412c = intent;
        }

        public void run() {
            try {
                ALog.m16901d(AgooFactory.TAG, "running tid:" + Thread.currentThread().getId() + ",pack=" + this.f16411b, new Object[0]);
                AgooFactory.mContext.sendBroadcast(this.f16412c);
                ALog.m16901d(AgooFactory.TAG, "SendMessageRunnable for accs,pack=" + this.f16411b, new Object[0]);
                try {
                    this.f16412c.setPackage(this.f16411b);
                    this.f16412c.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
                    AgooFactory.mContext.startService(this.f16412c);
                } catch (Throwable th) {
                }
                Intent intent = new Intent(AgooConstants.BINDER_MSGRECEIVER_ACTION);
                intent.setPackage(this.f16411b);
                ALog.m16901d(AgooFactory.TAG, "this message pack:" + this.f16411b, new Object[0]);
                ALog.m16901d(AgooFactory.TAG, "start to service...", new Object[0]);
                ServiceConnection c4580a = new C4580a(this.f16410a, this.f16412c.getStringExtra(AgooConstants.MESSAGE_ID), this.f16412c);
                Context access$000 = AgooFactory.mContext;
                AgooFactory.mContext;
                AgooFactory.mContext;
                boolean bindService = access$000.bindService(intent, c4580a, 17);
                ALog.m16901d(AgooFactory.TAG, "start service ret:" + bindService, new Object[0]);
                if (!bindService) {
                    ALog.m16901d(AgooFactory.TAG, "SendMessageRunnable is error", new Object[0]);
                }
            } catch (Throwable th2) {
                ALog.m16903e(AgooFactory.TAG, "SendMessageRunnable is error,e=" + th2.toString(), new Object[0]);
            }
        }
    }

    static {
        mContext = null;
    }

    public AgooFactory() {
        this.notifyManager = null;
        this.messageService = null;
    }

    private static final boolean checkPackage(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    private static Bundle getFlag(long j, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] toCharArray = Long.toBinaryString(j).toCharArray();
            if (toCharArray != null && 8 <= toCharArray.length) {
                if (8 <= toCharArray.length) {
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, BuildConfig.FLAVOR + Integer.parseInt(BuildConfig.FLAVOR + toCharArray[1] + toCharArray[2] + toCharArray[3] + toCharArray[4], 2));
                    if (toCharArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, MessageService.MSG_DB_NOTIFY_REACHED);
                        msgDO.reportStr = MessageService.MSG_DB_NOTIFY_REACHED;
                    }
                    if (toCharArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, MessageService.MSG_DB_NOTIFY_REACHED);
                    }
                }
                if (9 <= toCharArray.length && toCharArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, MessageService.MSG_DB_NOTIFY_REACHED);
                }
                if (10 <= toCharArray.length && toCharArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, MessageService.MSG_DB_NOTIFY_REACHED);
                }
                if (11 <= toCharArray.length && toCharArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable th) {
        }
        return bundle;
    }

    public static String parseEncryptedMsg(String str) {
        try {
            byte[] a;
            if (C4085a.f13620a != 2) {
                SecurityGuardManager instance = SecurityGuardManager.getInstance(mContext);
                if (instance != null) {
                    ALog.m16901d(TAG, "SecurityGuardManager not null!", new Object[0]);
                    ISecureSignatureComponent secureSignatureComp = instance.getSecureSignatureComp();
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = C4135a.m16914d(mContext);
                    securityGuardParamContext.paramMap.put("INPUT", C4135a.m16914d(mContext) + C4135a.m16912b(mContext));
                    securityGuardParamContext.requestType = 3;
                    a = C4576c.m19254a(secureSignatureComp.signRequest(securityGuardParamContext, C4085a.f13622c));
                } else {
                    ALog.m16903e(TAG, "SecurityGuardManager is null", new Object[0]);
                    a = null;
                }
            } else if (TextUtils.isEmpty(C4085a.m16662a(mContext).m16665a())) {
                ALog.m16903e(TAG, "getAppsign secret null", new Object[0]);
                a = null;
            } else {
                a = C4576c.m19257a(C4085a.m16662a(mContext).m16665a().getBytes("utf-8"), (C4135a.m16914d(mContext) + C4135a.m16912b(mContext)).getBytes("utf-8"));
            }
            if (a != null && a.length > 0) {
                return new String(C4576c.m19256a(C4574a.m19237a(str, 16), new SecretKeySpec(C4576c.m19255a(a), "AES"), C4576c.m19255a(C4135a.m16914d(mContext).getBytes("utf-8"))), "utf-8");
            }
            ALog.m16903e(TAG, "aesDecrypt key is null!", new Object[0]);
            return null;
        } catch (Throwable th) {
            ALog.m16902e(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
        }
    }

    private void sendMsgByBindService(String str, Intent intent) {
        try {
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d(TAG, "onHandleMessage current tid:" + Thread.currentThread().getId(), new Object[0]);
            }
            this.mThreadPool.execute(new C4581b(this, str, intent));
        } catch (Throwable th) {
            ALog.m16902e(TAG, "sendMsgByBindService error >>", th, new Object[0]);
        }
    }

    private void sendMsgToBussiness(Context context, String str, Bundle bundle, boolean z, String str2, ExtraInfo extraInfo) {
        Intent intent = new Intent();
        intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
        intent.setPackage(str);
        intent.putExtras(bundle);
        intent.putExtra(C4233j.f14402y, "common-push");
        intent.putExtra(AgooConstants.MESSAGE_SOURCE, str2);
        intent.addFlags(32);
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(AgooConstants.MESSAGE_ACCS_EXTRA, extraInfo);
            intent.putExtra(AgooConstants.MESSAGE_AGOO_BUNDLE, bundle2);
        } catch (Throwable th) {
            ALog.m16902e(TAG, "sendMsgToBussiness", th, new Object[0]);
        }
        if (ALog.isPrintLog(Level.I)) {
            ALog.m16904i(TAG, "sendMsgToBussiness intent:" + bundle.toString() + ",utdid=" + C4135a.m16912b(context) + ",pack=" + str + ",agooFlag=" + z, new Object[0]);
        }
        if (z) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, C4135a.m16912b(context), "agooMsg", AgooConstants.ACK_PACK_ERROR);
            sendMsgByBindService(str, intent);
            return;
        }
        intent.setClassName(str, C4085a.m16663b(str));
        context.startService(intent);
    }

    public void init(Context context, NotifManager notifManager, MessageService messageService) {
        mContext = context;
        this.mThreadPool = C4578a.f16404a;
        this.notifyManager = notifManager;
        if (this.notifyManager == null) {
            this.notifyManager = new NotifManager();
        }
        this.notifyManager.init(mContext);
        this.messageService = messageService;
        if (this.messageService == null) {
            this.messageService = new MessageService();
        }
        this.messageService.m19272a(mContext);
    }

    public Bundle msgReceiverPreHandler(byte[] bArr, String str, ExtraInfo extraInfo, boolean z) {
        if (bArr != null) {
            if (bArr.length > 0) {
                Object str2 = new String(bArr, "utf-8");
                if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i(TAG, "msgRecevie,message--->[" + str2 + "]" + ",utdid=" + C4135a.m16912b(mContext), new Object[0]);
                }
                if (TextUtils.isEmpty(str2)) {
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, C4135a.m16912b(mContext), "message==null");
                    ALog.m16904i(TAG, "handleMessage message==null,utdid=" + C4135a.m16912b(mContext), new Object[0]);
                    return null;
                }
                JSONArray jSONArray = new JSONArray(str2);
                int length = jSONArray.length();
                Bundle bundle = new Bundle();
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                StringBuilder stringBuilder3 = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        MsgDO msgDO = new MsgDO();
                        String string = jSONObject.getString("p");
                        String string2 = jSONObject.getString("i");
                        String string3 = jSONObject.getString("b");
                        long j = jSONObject.getLong("f");
                        stringBuilder.append(string2);
                        if (i < length - 1) {
                            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        msgDO.msgIds = string2;
                        msgDO.removePacks = string;
                        msgDO.messageSource = str;
                        if (TextUtils.isEmpty(string3)) {
                            msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                            this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                        } else {
                            try {
                                if (TextUtils.isEmpty(string)) {
                                    msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                                    this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                } else if (j == -1) {
                                    msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                                    this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                } else if (checkPackage(mContext, string)) {
                                    Bundle flag = getFlag(j, msgDO);
                                    CharSequence string4 = flag.getString(AgooConstants.MESSAGE_ENCRYPTED);
                                    boolean z2 = false;
                                    if (mContext.getPackageName().equals(string)) {
                                        if (TextUtils.equals(string4, Integer.toString(0))) {
                                            ALog.m16904i(TAG, "normal msg~~", new Object[0]);
                                        } else if (TextUtils.equals(string4, Integer.toString(4))) {
                                            ALog.m16904i(TAG, "begin parse EncryptedMsg", new Object[0]);
                                            string3 = parseEncryptedMsg(string3);
                                            if (TextUtils.isEmpty(string3)) {
                                                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, C4135a.m16912b(mContext), "parseEncryptedMsg failure", AgooConstants.REPORT_ENCRYPT_FAIL);
                                                msgDO.errorCode = AgooConstants.REPORT_ENCRYPT_FAIL;
                                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                            }
                                        } else {
                                            ALog.m16903e(TAG, "msgRecevie msg encrypted flag not exist, cannot prase!!!", new Object[0]);
                                            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, C4135a.m16912b(mContext), "encrypted!=4", AgooConstants.ACK_PACK_ERROR);
                                            msgDO.errorCode = AgooConstants.ACK_PACK_ERROR;
                                            this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                        }
                                        bundle.putBoolean(AgooConstants.MESSAGE_HAS_DECRYPTED, true);
                                    } else {
                                        z2 = true;
                                    }
                                    if (flag != null) {
                                        bundle.putAll(flag);
                                    }
                                    Object string5 = jSONObject.getString(C0714a.TIMESTAMP);
                                    if (!TextUtils.isEmpty(string5)) {
                                        bundle.putString(C4233j.f14377D, string5);
                                    }
                                    bundle.putLong(AgooConstants.MESSAGE_TRACE, System.currentTimeMillis());
                                    bundle.putString(AgooConstants.MESSAGE_ID, string2);
                                    bundle.putString(C4156a.f13961w, string3);
                                    bundle.putString(AgooConstants.MESSAGE_FROM_PKG, string);
                                    bundle.putString(AgooConstants.MESSAGE_FROM_APPKEY, C4135a.m16914d(mContext));
                                    if (z) {
                                        sendMsgToBussiness(mContext, string, bundle, z2, str, extraInfo);
                                    } else {
                                        bundle.putString(C4233j.f14402y, "common-push");
                                        bundle.putString(AgooConstants.MESSAGE_SOURCE, str);
                                    }
                                } else {
                                    ALog.m16901d(TAG, "msgRecevie checkpackage is del,pack=" + string, new Object[0]);
                                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, C4135a.m16912b(mContext), "deletePack", string);
                                    stringBuilder3.append(string);
                                    stringBuilder2.append(string2);
                                    if (i < length - 1) {
                                        stringBuilder3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                        stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                }
                            } catch (Throwable th) {
                                if (ALog.isPrintLog(Level.E)) {
                                    ALog.m16903e(TAG, "msgRecevie is error,e=" + th, new Object[0]);
                                }
                                return null;
                            }
                        }
                    }
                }
                if (stringBuilder3 == null || stringBuilder3.length() <= 0) {
                    return bundle;
                }
                MsgDO msgDO2 = new MsgDO();
                msgDO2.msgIds = stringBuilder2.toString();
                msgDO2.removePacks = stringBuilder3.toString();
                msgDO2.errorCode = AgooConstants.ACK_REMOVE_PACKAGE;
                msgDO2.messageSource = str;
                this.notifyManager.handlerACKMessage(msgDO2, extraInfo);
                return bundle;
            }
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, C4135a.m16912b(mContext), "data==null");
        ALog.m16904i(TAG, "handleMessage data==null,utdid=" + C4135a.m16912b(mContext), new Object[0]);
        return null;
    }

    public void msgRecevie(byte[] bArr, String str) {
        msgRecevie(bArr, str, null);
    }

    public void msgRecevie(byte[] bArr, String str, ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(Level.I)) {
                ALog.m16904i(TAG, "into--[AgooFactory,msgRecevie]:messageSource=" + str, new Object[0]);
            }
            this.mThreadPool.execute(new C4583b(this, bArr, str, extraInfo));
        } catch (Throwable th) {
            ALog.m16903e(TAG, "serviceImpl init task fail:" + th.toString(), new Object[0]);
        }
    }

    public void reportCacheMsg() {
        try {
            this.mThreadPool.execute(new C4584c(this));
        } catch (Throwable th) {
            ALog.m16903e(TAG, "reportCacheMsg fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr) {
        saveMsg(bArr, null);
    }

    public void saveMsg(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            this.mThreadPool.execute(new C4582a(this, bArr, str));
        }
    }

    public void updateMsg(byte[] bArr, boolean z) {
        this.mThreadPool.execute(new C4585d(this, bArr, z));
    }

    public void updateNotifyMsg(String str, String str2) {
        this.mThreadPool.execute(new C4586e(this, str, str2));
    }
}
