package com.taobao.accs.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService.ConnectInfo;
import com.taobao.accs.base.TaoBaseService.ExtHeaderType;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

public abstract class AccsAbstractDataListener implements AccsDataListener {
    private static final String TAG = "AccsAbstractDataListener";

    private static Map<ExtHeaderType, String> getExtHeader(Intent intent) {
        Map<ExtHeaderType, String> map = null;
        if (intent != null) {
            try {
                for (ExtHeaderType extHeaderType : ExtHeaderType.values()) {
                    CharSequence stringExtra = intent.getStringExtra(extHeaderType.toString());
                    if (!TextUtils.isEmpty(stringExtra)) {
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(extHeaderType, stringExtra);
                    }
                }
            } catch (Exception e) {
                ALog.m16903e(TAG, e.toString(), new Object[0]);
            }
        }
        return map;
    }

    private static ExtraInfo getExtraInfo(Intent intent) {
        Map extHeader = getExtHeader(intent);
        Object stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
        Object stringExtra2 = intent.getStringExtra(C4103b.ELECTION_KEY_HOST);
        if (extHeader == null && TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2)) {
            return null;
        }
        ExtraInfo extraInfo = new ExtraInfo();
        extraInfo.extHeader = extHeader;
        extraInfo.fromPackage = stringExtra;
        extraInfo.fromHost = stringExtra2;
        return extraInfo;
    }

    public static int onReceiveData(Context context, Intent intent, AccsDataListener accsDataListener) {
        Throwable e;
        if (accsDataListener == null || context == null) {
            ALog.m16903e(TAG, "onReceiveData listener or context null", new Object[0]);
        } else if (intent != null) {
            String str = BuildConfig.FLAVOR;
            try {
                int intExtra = intent.getIntExtra(IntentUtil.AGOO_COMMAND, -1);
                int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                String stringExtra = intent.getStringExtra(Constants.KEY_USER_ID);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_DATA_ID);
                String stringExtra3 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
                try {
                    if (ALog.isPrintLog(Level.I)) {
                        ALog.m16904i(TAG, "onReceiveData dataId:" + stringExtra2 + " serviceId:" + stringExtra3 + " command:" + intExtra, new Object[0]);
                    }
                    if (intExtra > 0) {
                        UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBuss5", "commandId=" + intExtra, "serviceId=" + stringExtra3 + " dataId=" + stringExtra2, Integer.valueOf(Constants.SDK_VERSION_CODE));
                        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_TO_BUSS, "3commandId=" + intExtra + "serviceId=" + stringExtra3, 0.0d);
                        boolean booleanExtra;
                        switch (intExtra) {
                            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                                accsDataListener.onBind(stringExtra3, intExtra2, getExtraInfo(intent));
                                break;
                            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                                accsDataListener.onUnbind(stringExtra3, intExtra2, getExtraInfo(intent));
                                break;
                            case Constants.COMMAND_SEND_DATA /*100*/:
                                String stringExtra4 = intent.getStringExtra(Constants.KEY_DATA_ID);
                                if (!TextUtils.equals(Constants.SEND_TYPE_RES, intent.getStringExtra(Constants.KEY_SEND_TYPE))) {
                                    accsDataListener.onSendData(stringExtra3, stringExtra4, intExtra2, getExtraInfo(intent));
                                    break;
                                }
                                accsDataListener.onResponse(stringExtra3, stringExtra4, intExtra2, intent.getByteArrayExtra(Constants.KEY_DATA), getExtraInfo(intent));
                                break;
                            case Constants.COMMAND_RECEIVE_DATA /*101*/:
                                byte[] byteArrayExtra = intent.getByteArrayExtra(Constants.KEY_DATA);
                                booleanExtra = intent.getBooleanExtra(Constants.KEY_NEED_BUSINESS_ACK, false);
                                if (byteArrayExtra == null) {
                                    ALog.m16903e(TAG, "COMMAND_RECEIVE_DATA msg null", new Object[0]);
                                    C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra3, MessageService.MSG_DB_NOTIFY_REACHED, "COMMAND_RECEIVE_DATA msg null");
                                    break;
                                }
                                String stringExtra5 = intent.getStringExtra(Constants.KEY_DATA_ID);
                                if (ALog.isPrintLog(Level.D)) {
                                    ALog.m16901d(TAG, "COMMAND_RECEIVE_DATA onData dataId:" + stringExtra5 + " serviceId:" + stringExtra3, new Object[0]);
                                }
                                ExtraInfo extraInfo = getExtraInfo(intent);
                                if (booleanExtra) {
                                    ALog.m16904i(TAG, "try to send biz ack dataId " + stringExtra5, new Object[0]);
                                    sendBusinessAck(context, intent, stringExtra5, extraInfo.extHeader);
                                }
                                accsDataListener.onData(stringExtra3, stringExtra, stringExtra5, byteArrayExtra, extraInfo);
                                break;
                            case Constants.COMMAND_CONNECT_INFO /*103*/:
                                booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                                str = intent.getStringExtra(C4103b.ELECTION_KEY_HOST);
                                String stringExtra6 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                                boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                                if (!TextUtils.isEmpty(str)) {
                                    if (!booleanExtra) {
                                        accsDataListener.onDisconnected(new ConnectInfo(str, booleanExtra2, booleanExtra3, intExtra2, stringExtra6));
                                        break;
                                    }
                                    accsDataListener.onConnected(new ConnectInfo(str, booleanExtra2, booleanExtra3));
                                    break;
                                }
                                break;
                            case Constants.COMMAND_ANTI_BRUSH /*104*/:
                                booleanExtra = intent.getBooleanExtra(Constants.KEY_ANTI_BRUSH_RET, false);
                                ALog.m16903e(TAG, "anti brush result:" + booleanExtra, new Object[0]);
                                accsDataListener.onAntiBrush(booleanExtra, null);
                                break;
                            default:
                                break;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = stringExtra3;
                    e.printStackTrace();
                    C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, str, MessageService.MSG_DB_NOTIFY_REACHED, "callback error" + e.toString());
                    ALog.m16902e(TAG, "onReceiveData", e, new Object[0]);
                    return 2;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, str, MessageService.MSG_DB_NOTIFY_REACHED, "callback error" + e.toString());
                ALog.m16902e(TAG, "onReceiveData", e, new Object[0]);
                return 2;
            }
        }
        return 2;
    }

    private static void sendBusinessAck(Context context, Intent intent, String str, Map<ExtHeaderType, String> map) {
        try {
            ALog.m16904i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra(C4103b.ELECTION_KEY_HOST);
                String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_FROM_PKG);
                ACCSManager.getManagerImpl(context).sendBusinessAck(intent.getStringExtra(Constants.KEY_TARGET), stringExtra2, str, intent.getShortExtra(Constants.KEY_FLAGS, (short) 0), stringExtra, map);
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_BUSINESS_ACK_SUCC, BuildConfig.FLAVOR, 0.0d);
            }
        } catch (Throwable th) {
            ALog.m16902e(TAG, "sendBusinessAck", th, new Object[0]);
            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }

    public void onAntiBrush(boolean z, ExtraInfo extraInfo) {
    }

    public void onConnected(ConnectInfo connectInfo) {
    }

    public void onDisconnected(ConnectInfo connectInfo) {
    }
}
