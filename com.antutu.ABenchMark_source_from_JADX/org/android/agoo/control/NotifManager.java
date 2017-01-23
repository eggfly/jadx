package org.android.agoo.control;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.UTMini;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4579e.C4578a;
import org.android.agoo.common.MsgDO;
import org.json.JSONObject;

public class NotifManager {
    private static final String ACK_MESSAGE = "accs.ackMessage";
    private static final int EVENT_ID = 66001;
    private static final String TAG = "NotifManager";
    private static Context mContext;
    private ScheduledThreadPoolExecutor mThreadPool;

    static {
        mContext = null;
    }

    private byte[] convertMsgToBytes(MsgDO msgDO) {
        Map hashMap = new HashMap();
        hashMap.put("api", "agooReport");
        hashMap.put(AgooConstants.MESSAGE_ID, msgDO.msgIds + "@" + msgDO.messageSource);
        hashMap.put(MsgConstant.KEY_STATUS, msgDO.msgStatus);
        if (!TextUtils.isEmpty(msgDO.errorCode)) {
            hashMap.put("ec", msgDO.errorCode);
        }
        if (!TextUtils.isEmpty(msgDO.type)) {
            hashMap.put(C4233j.f14402y, msgDO.type);
        }
        if (!TextUtils.isEmpty(msgDO.fromPkg)) {
            hashMap.put("fromPkg", msgDO.fromPkg);
        }
        if (!TextUtils.isEmpty(msgDO.fromAppkey)) {
            hashMap.put(AgooConstants.MESSAGE_FROM_APPKEY, msgDO.fromAppkey);
        }
        hashMap.put("isStartProc", Boolean.toString(msgDO.isStartProc));
        hashMap.put(C4209a.f14204g, C4135a.m16914d(mContext));
        hashMap.put(MsgConstant.KEY_UTDID, C4135a.m16912b(mContext));
        return new JSONObject(hashMap).toString().getBytes(HttpRequest.f14548a);
    }

    private String getVersion(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "null";
            }
            String str2 = mContext.getPackageManager().getPackageInfo(str, 0).versionName;
            ALog.m16901d(TAG, "getVersion###\u7248\u672c\u53f7\u4e3a : " + str2, new Object[0]);
            return str2;
        } catch (Throwable th) {
            return "null";
        }
    }

    private boolean isAppInstalled(String str) {
        PackageInfo packageInfo;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            packageInfo = mContext.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return false;
            }
            ALog.m16904i(TAG, "isAppInstalled true..", new Object[0]);
            return true;
        } catch (Throwable th) {
            packageInfo = null;
        }
    }

    private void reportMethod(MsgDO msgDO, ExtraInfo extraInfo) {
        try {
            AccsRequest accsRequest = new AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), null, null, null, null);
            if (msgDO != null) {
                accsRequest.setTag(msgDO.msgIds);
            }
            String sendPushResponse = ACCSManager.sendPushResponse(mContext, accsRequest, extraInfo);
            if (ALog.isPrintLog(Level.I)) {
                ALog.m16904i(TAG, "report,endRequest,dataId=" + sendPushResponse + ",status=" + msgDO.msgStatus, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportMethod", C4135a.m16912b(mContext), th.toString());
        }
    }

    public void doUninstall(String str, boolean z) {
        try {
            Map hashMap = new HashMap();
            hashMap.put("pack", str);
            hashMap.put(C4209a.f14204g, C4135a.m16914d(mContext));
            hashMap.put(MsgConstant.KEY_UTDID, C4135a.m16912b(mContext));
            ACCSManager.sendPushResponse(mContext, new AccsRequest(null, "agooKick", new JSONObject(hashMap).toString().getBytes(HttpRequest.f14548a), null, null, null, null), new ExtraInfo());
        } catch (Throwable th) {
            ALog.m16902e(TAG, "[doUninstall] is error", th, new Object[0]);
        }
    }

    public void handlerACKMessage(MsgDO msgDO, ExtraInfo extraInfo) {
        if (msgDO != null) {
            if (TextUtils.isEmpty(msgDO.msgIds) && TextUtils.isEmpty(msgDO.removePacks) && TextUtils.isEmpty(msgDO.errorCode)) {
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, C4135a.m16912b(mContext), "handlerACKMessageRetuen", "msgids=" + msgDO.msgIds + ",removePacks=" + msgDO.removePacks + ",errorCode=" + msgDO.errorCode);
                return;
            }
            try {
                Map hashMap = new HashMap();
                hashMap.put("api", AgooConstants.AGOO_SERVICE_AGOOACK);
                hashMap.put(AgooConstants.MESSAGE_ID, msgDO.msgIds + "@" + msgDO.messageSource);
                if (!TextUtils.isEmpty(msgDO.removePacks)) {
                    hashMap.put("del_pack", msgDO.removePacks);
                }
                if (!TextUtils.isEmpty(msgDO.errorCode)) {
                    hashMap.put("ec", msgDO.errorCode);
                }
                if (!TextUtils.isEmpty(msgDO.type)) {
                    hashMap.put(C4233j.f14402y, msgDO.type);
                }
                hashMap.put(C4209a.f14204g, C4135a.m16914d(mContext));
                hashMap.put(MsgConstant.KEY_UTDID, C4135a.m16912b(mContext));
                byte[] bytes = new JSONObject(hashMap).toString().getBytes(HttpRequest.f14548a);
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, C4135a.m16912b(mContext), "handlerACKMessageSendData", msgDO.msgIds);
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ACK, "handlerACKMessage", 0.0d);
                AccsRequest accsRequest = new AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, bytes, null, null, null, null);
                if (msgDO != null) {
                    accsRequest.setTag(msgDO.msgIds);
                }
                ALog.m16904i(TAG, "handlerACKMessage,endRequest,dataId=" + ACCSManager.sendPushResponse(mContext, accsRequest, extraInfo), new Object[0]);
            } catch (Throwable th) {
                Throwable th2 = th;
                if (ALog.isPrintLog(Level.E)) {
                    ALog.m16903e(TAG, "handlerACKMessage Throwable,msgIds=" + msgDO.msgIds + ",type=" + msgDO.type + ",e=" + th2.toString(), new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, C4135a.m16912b(mContext), "handlerACKMessageExceptionFailed", th2.toString());
            }
        }
    }

    public void init(Context context) {
        mContext = context;
        this.mThreadPool = C4578a.f16404a;
    }

    public void pingApp(String str, String str2, String str3, int i) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (ALog.isPrintLog(Level.I)) {
                ALog.m16904i(TAG, "pingApp [print param],percent=" + i + ",pack=" + str2 + ",service=" + str3 + ",action=" + str, new Object[0]);
            }
            this.mThreadPool.execute(new C4588g(this, i, str2, str, str3));
        }
    }

    public void report(MsgDO msgDO, ExtraInfo extraInfo) {
        if (!TextUtils.isEmpty(msgDO.reportStr)) {
            try {
                if (Integer.parseInt(msgDO.reportStr) >= -1) {
                    reportMethod(msgDO, extraInfo);
                    if (!msgDO.isFromCache) {
                        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
                    }
                }
            } catch (Throwable th) {
                ALog.m16902e(TAG, "[report] is error", th, new Object[0]);
            }
        }
    }

    public void reportNotifyMessage(MsgDO msgDO) {
        if (msgDO != null) {
            try {
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_REPORT_ID, msgDO.msgIds, 0.0d);
                String sendRequest = ACCSManager.sendRequest(mContext, new AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), null, null, null, null));
                if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i(TAG, "reportNotifyMessage,endRequest,dataId=" + sendRequest + ",status=" + msgDO.msgStatus, new Object[0]);
                }
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_CLICK, msgDO.msgStatus, 0.0d);
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
            } catch (Throwable th) {
                ALog.m16902e(TAG, "[reportNotifyMessage] is error", th, new Object[0]);
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportMethod", C4135a.m16912b(mContext), th.toString());
            }
        }
    }

    public void reportThirdPushToken(String str, String str2) {
        try {
            Map hashMap = new HashMap();
            hashMap.put("thirdTokenType", str2);
            hashMap.put(Constants.EXTRA_KEY_TOKEN, str);
            hashMap.put(C4209a.f14204g, C4135a.m16914d(mContext));
            hashMap.put(MsgConstant.KEY_UTDID, C4135a.m16912b(mContext));
            ALog.m16901d(TAG, "report,utdid=" + C4135a.m16912b(mContext) + ",regId=" + str + ",type=" + str2, new Object[0]);
            String sendData = ACCSManager.sendData(mContext, new AccsRequest(null, "agooTokenReport", new JSONObject(hashMap).toString().getBytes(HttpRequest.f14548a), null, null, null, null));
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16904i(TAG, "reportThirdPushToken,dataId=" + sendData + ",regId=" + str + ",type=" + str2, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", C4135a.m16912b(mContext), th.toString());
            if (ALog.isPrintLog(Level.E)) {
                ALog.m16902e(TAG, "[report] is error", th, new Object[0]);
            }
        }
    }
}
