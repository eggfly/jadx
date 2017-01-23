package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IAppReceiverV1;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService.ConnectInfo;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.client.AccsConfig.ACCS_GROUP;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.Constants.Operate;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.p190a.C4073a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.C4144h;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.taobao.accs.data.e */
public class C4095e {
    private static Set<String> f13686a;
    private static volatile C4095e f13687b;

    static {
        f13687b = null;
    }

    private void m16710a(Context context) {
        if (C4144h.m16946c()) {
            Intent intent = new Intent(C4073a.m16620b());
            intent.putExtra("operate", Operate.TRY_ELECTION);
            intent.setPackage(context.getPackageName());
            intent.setClassName(context.getPackageName(), m16720a());
            context.startService(intent);
        }
    }

    public static void m16711a(Context context, Intent intent) {
        try {
            C4089a.m16688a().execute(new C4100f(context, intent));
        } catch (Throwable th) {
            ALog.m16902e("MsgDistribute", "distribMessage", th, new Object[0]);
            UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBuss8", "distribMessage" + th.toString(), Integer.valueOf(Constants.SDK_VERSION_CODE));
        }
    }

    private void m16712a(Context context, Intent intent, int i, String str, String str2, String str3, IAppReceiver iAppReceiver, int i2) {
        if (iAppReceiver != null) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (iAppReceiver instanceof IAppReceiverV1) {
                        ((IAppReceiverV1) iAppReceiver).onBindApp(i2, null);
                    } else {
                        iAppReceiver.onBindApp(i2);
                    }
                    if (i2 == Constants.COMMAND_HANDSHAKE) {
                        try {
                            ALog.m16904i("MsgDistribute", "start election by bindapp....", new Object[0]);
                            m16710a(context);
                            return;
                        } catch (Throwable th) {
                            ALog.m16903e("MsgDistribute", "start election is error,e=" + th, new Object[0]);
                            return;
                        }
                    }
                    return;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (i2 == Constants.COMMAND_HANDSHAKE) {
                        UtilityImpl.disableService(context);
                    }
                    iAppReceiver.onUnbindApp(i2);
                    return;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    iAppReceiver.onBindUser(str, i2);
                    return;
                case SpdyProtocol.QUIC /*4*/:
                    iAppReceiver.onUnbindUser(i2);
                    return;
                case Constants.COMMAND_SEND_DATA /*100*/:
                    if (TextUtils.isEmpty(str2)) {
                        iAppReceiver.onSendData(str3, i2);
                        return;
                    }
                    return;
                case Constants.COMMAND_RECEIVE_DATA /*101*/:
                    if (TextUtils.isEmpty(str2)) {
                        ALog.m16901d("MsgDistribute", "serviceId isEmpty", new Object[0]);
                        byte[] byteArrayExtra = intent.getByteArrayExtra(Constants.KEY_DATA);
                        if (byteArrayExtra != null) {
                            iAppReceiver.onData(str, str3, byteArrayExtra);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, str2, MessageService.MSG_DB_NOTIFY_REACHED, "appReceiver null return");
        ALog.m16903e("MsgDistribute", "appReceiver null!", new Object[0]);
        UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBuss7", "commandId=" + i, "serviceId=" + str2 + " errorCode=" + i2 + " dataId=" + str3, Integer.valueOf(Constants.SDK_VERSION_CODE));
    }

    private boolean m16715a(Context context, Intent intent, String str) {
        boolean booleanExtra = intent.getBooleanExtra("routingAck", false);
        boolean booleanExtra2 = intent.getBooleanExtra("routingMsg", false);
        if (booleanExtra) {
            ALog.m16904i("MsgDistribute", "recieve routiong ack", Constants.KEY_DATA_ID, str);
            if (f13686a != null) {
                f13686a.remove(str);
            }
            C4136b.m16915a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_MSG_ROUTING_RATE, BuildConfig.FLAVOR);
            booleanExtra = true;
        } else {
            booleanExtra = false;
        }
        if (booleanExtra2) {
            try {
                String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
                ALog.m16904i("MsgDistribute", "send routiong ack", Constants.KEY_DATA_ID, str, "to pkg", stringExtra);
                Intent intent2 = new Intent(Constants.ACTION_COMMAND);
                intent2.putExtra(IntentUtil.AGOO_COMMAND, Constants.COMMAND_ROUTING_ACK);
                intent2.setClassName(stringExtra, C4135a.channelService);
                intent2.putExtra("routingAck", true);
                intent2.putExtra(Constants.KEY_PACKAGE_NAME, stringExtra);
                intent2.putExtra(Constants.KEY_DATA_ID, str);
                context.startService(intent2);
            } catch (Throwable th) {
                ALog.m16902e("MsgDistribute", "send routing ack", th, new Object[0]);
            }
        }
        return booleanExtra;
    }

    private void m16716b(Context context, Intent intent) {
        Object action = intent.getAction();
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("MsgDistribute", "action:" + action, new Object[0]);
        }
        if (TextUtils.isEmpty(action)) {
            ALog.m16903e("MsgDistribute", "action null", new Object[0]);
            UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBuss9", "action null", Integer.valueOf(Constants.SDK_VERSION_CODE));
            return;
        }
        String str = null;
        int i = 0;
        try {
            if (TextUtils.equals(action, Constants.ACTION_RECEIVE)) {
                i = intent.getIntExtra(IntentUtil.AGOO_COMMAND, -1);
                String stringExtra = intent.getStringExtra(Constants.KEY_USER_ID);
                int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                str = intent.getStringExtra(Constants.KEY_SERVICE_ID);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_DATA_ID);
                if (intent.getPackage() == null) {
                    intent.setPackage(context.getPackageName());
                }
                if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i("MsgDistribute", "command:" + i + " serviceId:" + str + " dataId:" + stringExtra2, new Object[0]);
                }
                if (!m16715a(context, intent, stringExtra2)) {
                    if (i < 0) {
                        ALog.m16903e("MsgDistribute", "command error:" + i, new Object[0]);
                        return;
                    } else if (!m16723a(i, str) && !m16717b(context, intent, stringExtra2)) {
                        IAppReceiver appReceiver = GlobalClientInfo.getInstance(context).getAppReceiver();
                        if (!m16724a(context, stringExtra2, intent, appReceiver)) {
                            m16712a(context, intent, i, stringExtra, str, stringExtra2, appReceiver, intExtra);
                            if (TextUtils.isEmpty(str)) {
                                m16721a(context, appReceiver, intent, i, intExtra);
                                return;
                            } else {
                                m16722a(context, appReceiver, intent, str, stringExtra2, i, intExtra);
                                return;
                            }
                        }
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            ALog.m16903e("MsgDistribute", "action error " + action, new Object[0]);
            UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBuss10", action, Integer.valueOf(Constants.SDK_VERSION_CODE));
        } catch (Throwable th) {
            ALog.m16902e("MsgDistribute", "distribMessage :", th, new Object[0]);
            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, str, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.getStackMsg(th));
        }
    }

    private boolean m16717b(Context context, Intent intent, String str) {
        if (context.getPackageName().equals(intent.getPackage())) {
            return false;
        }
        try {
            ALog.m16904i("MsgDistribute", "start MsgDistributeService", "receive pkg", context.getPackageName(), "target pkg", intent.getPackage());
            intent.setClassName(intent.getPackage(), C4135a.msgService);
            intent.putExtra("routingMsg", true);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            context.startService(intent);
            if (f13686a == null) {
                f13686a = new HashSet();
            }
            f13686a.add(str);
            C4089a.m16687a(new C4101g(this, str, context, intent), 10, TimeUnit.SECONDS);
            return true;
        } catch (Throwable th) {
            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_MSG_ROUTING_RATE, BuildConfig.FLAVOR, ModelFields.EXCEPTION, th.toString());
            ALog.m16903e("MsgDistribute", "routing msg error, try election", Constants.KEY_DATA_ID, str, th);
            m16710a(context);
            return true;
        }
    }

    public static C4095e m16718c() {
        if (f13687b == null) {
            synchronized (C4095e.class) {
                if (f13687b == null) {
                    if (AccsConfig.mGroup == ACCS_GROUP.ALIYUN) {
                        f13687b = new C4096a();
                    } else {
                        f13687b = new C4095e();
                    }
                }
            }
        }
        return f13687b;
    }

    protected String m16720a() {
        return C4135a.channelService;
    }

    protected void m16721a(Context context, IAppReceiver iAppReceiver, Intent intent, int i, int i2) {
        Map allServices = iAppReceiver != null ? iAppReceiver.getAllServices() : null;
        Object obj;
        if (i == Constants.COMMAND_CONNECT_INFO) {
            Serializable serializable;
            if (allServices != null) {
                for (String str : allServices.keySet()) {
                    if (AgooConstants.MESSAGE_SOURCE_ACCS.equals(str) || "windvane".equals(str) || "motu-remote".equals(str)) {
                        obj = (String) allServices.get(str);
                        if (TextUtils.isEmpty(obj)) {
                            obj = GlobalClientInfo.getInstance(context).getService(str);
                        }
                        if (!TextUtils.isEmpty(obj)) {
                            intent.setClassName(context, obj);
                            context.startService(intent);
                        }
                    }
                }
            }
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra(C4103b.ELECTION_KEY_HOST);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
            boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
            boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
            if (TextUtils.isEmpty(stringExtra)) {
                serializable = null;
            } else {
                serializable = booleanExtra ? new ConnectInfo(stringExtra, booleanExtra2, booleanExtra3) : new ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, i2, stringExtra2);
                serializable.connected = booleanExtra;
            }
            if (serializable != null) {
                Intent intent2 = new Intent(Constants.ACTION_CONNECT_INFO);
                intent2.setPackage(context.getPackageName());
                intent2.putExtra(Constants.KEY_CONNECT_INFO, serializable);
                context.sendBroadcast(intent2);
                return;
            }
            ALog.m16903e("MsgDistribute", "connect info null, host empty", new Object[0]);
        } else if (i != Constants.COMMAND_ANTI_BRUSH) {
            ALog.m16904i("MsgDistribute", "distribMessage serviceId is null!! command:" + i, new Object[0]);
        } else if (allServices != null) {
            for (String str2 : allServices.keySet()) {
                obj = (String) allServices.get(str2);
                if (TextUtils.isEmpty(obj)) {
                    obj = GlobalClientInfo.getInstance(context).getService(str2);
                }
                if (!TextUtils.isEmpty(obj)) {
                    intent.setClassName(context, obj);
                    context.startService(intent);
                }
            }
        }
    }

    protected void m16722a(Context context, IAppReceiver iAppReceiver, Intent intent, String str, String str2, int i, int i2) {
        String str3 = null;
        if (iAppReceiver != null) {
            str3 = iAppReceiver.getService(str);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = GlobalClientInfo.getInstance(context).getService(str);
        }
        if (TextUtils.isEmpty(str3)) {
            AccsDataListener listener = GlobalClientInfo.getInstance(context).getListener(str);
            if (listener != null) {
                AccsAbstractDataListener.onReceiveData(context, intent, listener);
            } else {
                ALog.m16903e("MsgDistribute", "callback is null dataId:" + str2 + " serviceId\uff1a" + str + " command:" + i, new Object[0]);
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, str, MessageService.MSG_DB_NOTIFY_REACHED, "service is null");
            }
        } else {
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("MsgDistribute", "to start service:" + str3, new Object[0]);
            }
            intent.setClassName(context, str3);
            context.startService(intent);
        }
        UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBuss", "commandId=" + i, "serviceId=" + str + " errorCode=" + i2 + " dataId=" + str2, Integer.valueOf(Constants.SDK_VERSION_CODE));
        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_TO_BUSS, "2commandId=" + i + "serviceId=" + str, 0.0d);
    }

    protected boolean m16723a(int i, String str) {
        if (!(i == 100 || GlobalClientInfo.AGOO_SERVICE_ID.equals(str))) {
            long usableSpace = UtilityImpl.getUsableSpace();
            if (usableSpace != -1 && usableSpace <= 5242880) {
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, str, MessageService.MSG_DB_NOTIFY_REACHED, "space low " + usableSpace);
                ALog.m16903e("MsgDistribute", "user space low, don't distribute", "size", Long.valueOf(usableSpace));
                return true;
            }
        }
        return false;
    }

    protected boolean m16724a(Context context, String str, Intent intent, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null || UtilityImpl.isMainProcess(context)) {
            return false;
        }
        ALog.m16904i("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str);
        intent.setClassName(intent.getPackage(), m16725b());
        context.startService(intent);
        return true;
    }

    protected String m16725b() {
        return C4135a.msgService;
    }
}
