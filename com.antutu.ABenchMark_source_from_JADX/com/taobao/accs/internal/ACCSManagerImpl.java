package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anet.channel.AccsSessionManager;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.strategy.StrategyCenter;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService.ExtHeaderType;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.client.AccsConfig.SECURITY_TYPE;
import com.taobao.accs.client.C4086b;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.C4095e;
import com.taobao.accs.data.C4097b;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.Message.ReqType;
import com.taobao.accs.net.C4112a;
import com.taobao.accs.p190a.C4073a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.C4144h;
import com.taobao.accs.utl.C4144h.C4143a;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;

public class ACCSManagerImpl implements IACCSManager {
    private int f13714a;
    private C4097b f13715b;
    private C4086b f13716c;

    public ACCSManagerImpl() {
        this.f13714a = 0;
    }

    private static Intent m16769a(Context context, int i) {
        if (i == 1 || UtilityImpl.getServiceEnabled(context)) {
            Intent intent = new Intent();
            intent.setAction(Constants.ACTION_COMMAND);
            intent.setClassName(context.getPackageName(), C4135a.channelService);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            intent.putExtra(IntentUtil.AGOO_COMMAND, i);
            return intent;
        }
        ALog.m16903e("ACCSManagerImpl", "getIntent null command:" + i + " serviceEnable:" + UtilityImpl.getServiceEnabled(context), new Object[0]);
        return null;
    }

    private void m16770a(Context context) {
        try {
            C4089a.m16687a(new C4104a(this, context), 10000, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.m16905w("ACCSManagerImpl", "startChannelService", th, new Object[0]);
        }
    }

    private void m16771a(Context context, int i, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra(IntentUtil.AGOO_COMMAND, i);
        intent.putExtra(Constants.KEY_SERVICE_ID, str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        intent.putExtra(Constants.KEY_ERROR_CODE, i == 2 ? Constants.COMMAND_HANDSHAKE : ErrorCode.APP_NOT_BIND);
        C4095e.m16711a(context, intent);
    }

    private void m16772a(Context context, Message message, int i) {
        if (this.f13715b == null) {
            this.f13715b = C4097b.m16732a(context);
        }
        this.f13715b.m16750a(message, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16773a(android.content.Context r10, com.taobao.accs.data.Message r11, int r12, boolean r13) {
        /*
        r9 = this;
        r8 = 2;
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = 1;
        r1 = 0;
        r3 = com.taobao.accs.net.C4112a.m16803a(r10, r2);
        r3.m16807a();
        if (r11 != 0) goto L_0x002b;
    L_0x000e:
        r0 = "ACCSManagerImpl";
        r2 = "message is null";
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.m16903e(r0, r2, r1);
        r0 = r10.getPackageName();
        r0 = com.taobao.accs.data.Message.buildParameterError(r0, r12);
        r1 = -2;
        r9.m16772a(r10, r0, r1);
    L_0x0023:
        r0 = r10.getApplicationContext();
        r9.m16770a(r0);
        return;
    L_0x002b:
        r0 = r9.f13716c;
        if (r0 != 0) goto L_0x0035;
    L_0x002f:
        r0 = com.taobao.accs.client.C4086b.m16670a(r10);
        r9.f13716c = r0;
    L_0x0035:
        switch(r12) {
            case 1: goto L_0x0052;
            case 2: goto L_0x0083;
            case 3: goto L_0x00b2;
            default: goto L_0x0038;
        };
    L_0x0038:
        r0 = r2;
    L_0x0039:
        if (r0 == 0) goto L_0x0023;
    L_0x003b:
        r0 = "ACCSManagerImpl";
        r4 = "sendControlMessage";
        r5 = new java.lang.Object[r8];
        r6 = "command";
        r5[r1] = r6;
        r1 = java.lang.Integer.valueOf(r12);
        r5[r2] = r1;
        com.taobao.accs.utl.ALog.m16904i(r0, r4, r5);
        r3.m16816b(r11, r2);
        goto L_0x0023;
    L_0x0052:
        r0 = r9.f13716c;
        r4 = r11.getPackageName();
        r0 = r0.m16679c(r4);
        if (r0 == 0) goto L_0x0038;
    L_0x005e:
        if (r13 != 0) goto L_0x0038;
    L_0x0060:
        r0 = "ACCSManagerImpl";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r11.getPackageName();
        r4 = r4.append(r5);
        r5 = " isAppBinded";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.m16904i(r0, r4, r5);
        r9.m16772a(r10, r11, r7);
        r0 = r1;
        goto L_0x0039;
    L_0x0083:
        r0 = r9.f13716c;
        r4 = r11.getPackageName();
        r0 = r0.m16680d(r4);
        if (r0 == 0) goto L_0x0038;
    L_0x008f:
        r0 = "ACCSManagerImpl";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r11.getPackageName();
        r4 = r4.append(r5);
        r5 = " isAppUnbinded";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.m16904i(r0, r4, r5);
        r9.m16772a(r10, r11, r7);
        r0 = r1;
        goto L_0x0039;
    L_0x00b2:
        r0 = r9.f13716c;
        r4 = r11.getPackageName();
        r5 = r11.userinfo;
        r0 = r0.m16678b(r4, r5);
        if (r0 == 0) goto L_0x0038;
    L_0x00c0:
        if (r13 != 0) goto L_0x0038;
    L_0x00c2:
        r0 = "ACCSManagerImpl";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r11.getPackageName();
        r4 = r4.append(r5);
        r5 = "/";
        r4 = r4.append(r5);
        r5 = r11.userinfo;
        r4 = r4.append(r5);
        r5 = " isUserBinded";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = new java.lang.Object[r8];
        r6 = "isForceBind";
        r5[r1] = r6;
        r6 = java.lang.Boolean.valueOf(r13);
        r5[r2] = r6;
        com.taobao.accs.utl.ALog.m16904i(r0, r4, r5);
        r9.m16772a(r10, r11, r7);
        r0 = r1;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.a(android.content.Context, com.taobao.accs.data.Message, int, boolean):void");
    }

    public void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, str, AgooConstants.MESSAGE_SOURCE_ACCS, str2, iAppReceiver);
    }

    public void bindApp(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (context != null) {
            ALog.m16901d("ACCSManagerImpl", "bindApp APPKEY:" + str, new Object[0]);
            Message buildParameterError = Message.buildParameterError(context.getPackageName(), 1);
            if (UtilityImpl.getFocusDisableStatus(context)) {
                m16772a(context, buildParameterError, -17);
            } else if (AccsConfig.mSecurityType == SECURITY_TYPE.SECURITY_OFF && TextUtils.isEmpty(str2)) {
                m16772a(context, buildParameterError, -15);
            } else if (iAppReceiver == null) {
                m16772a(context, buildParameterError, -16);
            } else if (TextUtils.isEmpty(str)) {
                m16772a(context, buildParameterError, -14);
            } else {
                if (!TextUtils.equals(UtilityImpl.getAppkey(context), str)) {
                    UtilityImpl.setAppInfo(context, str, null, str3);
                }
                GlobalClientInfo.getInstance(context).setAppReceiver(iAppReceiver);
                GlobalClientInfo.getInstance(context).setAppSecret(str2);
                UtilityImpl.enableService(context);
                Intent a = m16769a(context, 1);
                if (a != null) {
                    try {
                        String str4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        boolean appVersionChanged = UtilityImpl.appVersionChanged(context);
                        if (appVersionChanged) {
                            a.putExtra(Constants.KEY_FOUCE_BIND, true);
                        }
                        a.putExtra(Constants.KEY_APP_KEY, str);
                        a.putExtra(Constants.KEY_TTID, str3);
                        a.putExtra(Constants.KEY_APP_VERSION, str4);
                        a.putExtra(Constants.SP_APP_SECRET, str2);
                        if (UtilityImpl.isMainProcess(context)) {
                            m16773a(context, Message.buildBindApp(context, a), 1, appVersionChanged);
                        }
                        C4144h.m16938a(new String[]{AgooConstants.MESSAGE_SOURCE_ACCS}, new C4143a());
                        C4144h.m16947d();
                    } catch (Throwable th) {
                        ALog.m16902e("ACCSManagerImpl", "bindApp exception", th, new Object[0]);
                    }
                }
            }
        }
    }

    public void bindService(Context context, String str) {
        if (!UtilityImpl.getFocusDisableStatus(context) && !UtilityImpl.getFocusDisableStatus(context)) {
            Intent a = m16769a(context, 5);
            if (a == null) {
                m16771a(context, 5, str, null);
                return;
            }
            Object appkey = UtilityImpl.getAppkey(context);
            if (!TextUtils.isEmpty(appkey)) {
                a.putExtra(Constants.KEY_APP_KEY, appkey);
                a.putExtra(Constants.KEY_SERVICE_ID, str);
                if (UtilityImpl.isMainProcess(context)) {
                    m16773a(context, Message.buildBindService(context, a), 5, false);
                } else {
                    context.startService(a);
                }
            }
        }
    }

    public void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    public void bindUser(Context context, String str, boolean z) {
        try {
            ALog.m16904i("ACCSManagerImpl", "bindUser", "userId", str);
            if (UtilityImpl.getFocusDisableStatus(context)) {
                ALog.m16903e("ACCSManagerImpl", "accs disabled", new Object[0]);
                return;
            }
            Intent a = m16769a(context, 3);
            if (a == null) {
                ALog.m16903e("ACCSManagerImpl", "intent null", new Object[0]);
                m16771a(context, 3, null, null);
                return;
            }
            Object appkey = UtilityImpl.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                ALog.m16903e("ACCSManagerImpl", "appKey null", new Object[0]);
                return;
            }
            if (UtilityImpl.appVersionChanged(context) || z) {
                ALog.m16904i("ACCSManagerImpl", "force bind User", new Object[0]);
                a.putExtra(Constants.KEY_FOUCE_BIND, true);
                z = true;
            }
            a.putExtra(Constants.KEY_APP_KEY, appkey);
            a.putExtra(Constants.KEY_USER_ID, str);
            if (UtilityImpl.isMainProcess(context)) {
                m16773a(context, Message.buildBindUser(context, a), 3, z);
            } else {
                context.startService(a);
            }
        } catch (Throwable th) {
            ALog.m16902e("ACCSManagerImpl", "bindUser", th, new Object[0]);
        }
    }

    public boolean cancel(Context context, String str) {
        return C4112a.m16803a(context, 1).m16814a(str);
    }

    public void clearLoginInfo(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    public void forceDisableService(Context context) {
        UtilityImpl.focusDisableService(context);
    }

    public void forceEnableService(Context context) {
        UtilityImpl.focusEnableService(context);
    }

    public Map<String, Boolean> forceReConnectChannel() {
        AccsSessionManager.getInstance().forceReCreateSession();
        return getChannelState();
    }

    public Map<String, Boolean> getChannelState() {
        String userUnit = getUserUnit();
        String a = C4112a.m16804a(GlobalClientInfo.getContext(), null);
        Map<String, Boolean> hashMap = new HashMap();
        hashMap.put(userUnit, Boolean.valueOf(false));
        hashMap.put(a, Boolean.valueOf(false));
        Session throwsException = SessionCenter.getInstance().getThrowsException(a, 60000);
        Session throwsException2 = SessionCenter.getInstance().getThrowsException(userUnit, 60000);
        if (throwsException != null) {
            hashMap.put(a, Boolean.valueOf(true));
        }
        if (throwsException2 != null) {
            hashMap.put(userUnit, Boolean.valueOf(true));
        }
        ALog.m16901d("ACCSManagerImpl", "getChannelState " + hashMap.toString(), new Object[0]);
        return hashMap;
    }

    public String getUserUnit() {
        Context context = GlobalClientInfo.getContext();
        if (context == null) {
            ALog.m16903e("ACCSManagerImpl", "context is null", new Object[0]);
            return null;
        }
        String a = C4112a.m16804a(context, StrategyCenter.getInstance().getUnitPrefix(GlobalClientInfo.getInstance(context).getUserId(), UtilityImpl.getDeviceId(context)));
        if (!ALog.isPrintLog(Level.D)) {
            return a;
        }
        ALog.m16901d("ACCSManagerImpl", "getUserUnit " + a, new Object[0]);
        return a;
    }

    public boolean isChannelError(int i) {
        return ErrorCode.isChannelError(i);
    }

    public boolean isNetworkReachable(Context context) {
        return UtilityImpl.isNetworkConnected(context);
    }

    public void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    public void registerSerivce(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<ExtHeaderType, String> map) {
        C4112a.m16803a(GlobalClientInfo.getContext(), 1).m16816b(Message.buildPushAck(str, str2, str3, true, s, str4, map), true);
    }

    public String sendData(Context context, AccsRequest accsRequest) {
        try {
            boolean focusDisableStatus = UtilityImpl.getFocusDisableStatus(context);
            if (focusDisableStatus || accsRequest == null) {
                if (focusDisableStatus) {
                    C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "accs disable");
                } else {
                    C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, BuildConfig.FLAVOR, MessageService.MSG_DB_NOTIFY_REACHED, "data null");
                }
                ALog.m16903e("ACCSManagerImpl", "send data dataInfo null or disable:" + focusDisableStatus, new Object[0]);
                return null;
            }
            if (TextUtils.isEmpty(accsRequest.dataId)) {
                synchronized (ACCSManagerImpl.class) {
                    this.f13714a++;
                    accsRequest.dataId = this.f13714a + BuildConfig.FLAVOR;
                }
            }
            Object appkey = UtilityImpl.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "data appkey null");
                ALog.m16903e("ACCSManagerImpl", "send data appkey null dataid:" + accsRequest.dataId, new Object[0]);
                return null;
            }
            C4112a a = C4112a.m16803a(context, 1);
            a.m16807a();
            Message buildSendData = Message.buildSendData(context, context.getPackageName(), appkey, accsRequest);
            if (buildSendData.getNetPermanceMonitor() != null) {
                buildSendData.getNetPermanceMonitor().onSend();
            }
            a.m16816b(buildSendData, true);
            return accsRequest.dataId;
        } catch (Throwable th) {
            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "data " + th.toString());
            ALog.m16902e("ACCSManagerImpl", "send data dataid:" + accsRequest.dataId, th, new Object[0]);
        }
    }

    public String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendData(context, str, str2, bArr, str3, null);
    }

    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendData(context, str, str2, bArr, str3, str4, null);
    }

    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendData(context, new AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    public String sendPushResponse(Context context, AccsRequest accsRequest, ExtraInfo extraInfo) {
        boolean z = true;
        if (context == null || accsRequest == null) {
            try {
                ALog.m16903e("ACCSManagerImpl", "sendPushResponse input null", "context", context, "response", accsRequest, "extraInfo", extraInfo);
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, BuildConfig.FLAVOR, MessageService.MSG_DB_NOTIFY_REACHED, "sendPushResponse null");
            } catch (Throwable th) {
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "push response " + th.toString());
                ALog.m16902e("ACCSManagerImpl", "sendPushResponse dataid:" + accsRequest.dataId, th, new Object[0]);
            }
        } else {
            C4136b.m16915a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, "push response total");
            if (UtilityImpl.getFocusDisableStatus(context)) {
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "sendPushResponse accs disable");
            } else {
                Object appkey = UtilityImpl.getAppkey(context);
                if (TextUtils.isEmpty(appkey)) {
                    C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "sendPushResponse appkey null");
                    ALog.m16903e("ACCSManagerImpl", "sendPushResponse appkey null dataid:" + accsRequest.dataId, new Object[0]);
                } else {
                    if (TextUtils.isEmpty(accsRequest.dataId)) {
                        synchronized (ACCSManagerImpl.class) {
                            this.f13714a++;
                            accsRequest.dataId = this.f13714a + BuildConfig.FLAVOR;
                        }
                    }
                    if (extraInfo == null) {
                        extraInfo = new ExtraInfo();
                    }
                    accsRequest.host = null;
                    if (extraInfo.fromPackage == null) {
                        String str = C4073a.m16610a(context).f13561a;
                        if (TextUtils.isEmpty(str)) {
                            str = context.getPackageName();
                        }
                        extraInfo.fromPackage = str;
                    }
                    if (extraInfo.fromHost == null) {
                        extraInfo.fromHost = "https://" + C4112a.m16805b(context);
                        ALog.m16906w("ACCSManagerImpl", "response.host null, set channel host default", new Object[0]);
                    }
                    accsRequest.host = new URL(extraInfo.fromHost);
                    if (C4112a.m16805b(context).equals(accsRequest.host.getHost())) {
                        z = false;
                    }
                    ALog.m16904i("ACCSManagerImpl", "sendPushResponse", "sendbyInapp", Boolean.valueOf(z), C4103b.ELECTION_KEY_HOST, extraInfo.fromHost, Constants.KEY_ELECTION_PKG, extraInfo.fromPackage, Constants.KEY_DATA_ID, accsRequest.dataId);
                    Intent intent;
                    if (z) {
                        ALog.m16904i("ACCSManagerImpl", "sendPushResponse inapp by", "app", extraInfo.fromPackage);
                        if (context.getPackageName().equals(extraInfo.fromPackage) && UtilityImpl.isMainProcess(context)) {
                            sendRequest(context, accsRequest, context.getPackageName(), false);
                        } else {
                            intent = new Intent(Constants.ACTION_SEND);
                            intent.setClassName(extraInfo.fromPackage, C4135a.msgService);
                            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
                            intent.putExtra(Constants.KEY_SEND_REQDATA, accsRequest);
                            context.startService(intent);
                        }
                    } else {
                        intent = m16769a(context, 100);
                        if (intent == null) {
                            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "push response intent null");
                            m16771a(context, 100, accsRequest.serviceId, accsRequest.dataId);
                            ALog.m16903e("ACCSManagerImpl", "sendPushResponse input null", "context", context, "response", accsRequest, "extraInfo", extraInfo);
                        } else {
                            ALog.m16904i("ACCSManagerImpl", "sendPushResponse channel by", "app", extraInfo.fromPackage);
                            intent.setClassName(extraInfo.fromPackage, C4135a.channelService);
                            intent.putExtra(Constants.KEY_SEND_TYPE, ReqType.REQ);
                            intent.putExtra(Constants.KEY_APP_KEY, appkey);
                            intent.putExtra(Constants.KEY_USER_ID, accsRequest.userId);
                            intent.putExtra(Constants.KEY_SERVICE_ID, accsRequest.serviceId);
                            intent.putExtra(Constants.KEY_DATA, accsRequest.data);
                            intent.putExtra(Constants.KEY_DATA_ID, accsRequest.dataId);
                            if (!TextUtils.isEmpty(accsRequest.businessId)) {
                                intent.putExtra(Constants.KEY_BUSINESSID, accsRequest.businessId);
                            }
                            if (!TextUtils.isEmpty(accsRequest.tag)) {
                                intent.putExtra(Constants.KEY_EXT_TAG, accsRequest.tag);
                            }
                            if (accsRequest.target != null) {
                                intent.putExtra(Constants.KEY_TARGET, accsRequest.target);
                            }
                            context.startService(intent);
                        }
                    }
                }
            }
        }
        return null;
    }

    public String sendRequest(Context context, AccsRequest accsRequest) {
        return sendRequest(context, accsRequest, null, true);
    }

    public String sendRequest(Context context, AccsRequest accsRequest, String str, boolean z) {
        if (accsRequest == null) {
            try {
                ALog.m16903e("ACCSManagerImpl", "sendRequest request null", new Object[0]);
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, null, MessageService.MSG_DB_NOTIFY_REACHED, "request null");
                return null;
            } catch (Throwable th) {
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "request " + th.toString());
                ALog.m16902e("ACCSManagerImpl", "sendRequest dataid:" + accsRequest.dataId, th, new Object[0]);
            }
        } else if (UtilityImpl.getFocusDisableStatus(context)) {
            ALog.m16903e("ACCSManagerImpl", "sendRequest disable", new Object[0]);
            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "accs disable");
            return null;
        } else {
            if (TextUtils.isEmpty(accsRequest.dataId)) {
                synchronized (ACCSManagerImpl.class) {
                    this.f13714a++;
                    accsRequest.dataId = this.f13714a + BuildConfig.FLAVOR;
                }
            }
            Object appkey = UtilityImpl.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "request appkey null");
                ALog.m16903e("ACCSManagerImpl", "sendRequest appkey null dataid:" + accsRequest.dataId, new Object[0]);
                return null;
            }
            C4112a a = C4112a.m16803a(context, 1);
            a.m16807a();
            if (str == null) {
                str = context.getPackageName();
            }
            Message buildRequest = Message.buildRequest(context, str, appkey, accsRequest, z);
            if (buildRequest.getNetPermanceMonitor() != null) {
                buildRequest.getNetPermanceMonitor().onSend();
            }
            a.m16816b(buildRequest, true);
            return accsRequest.dataId;
        }
    }

    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendRequest(context, str, str2, bArr, str3, str4, null);
    }

    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendRequest(context, new AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    public void setLoginInfo(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(iLoginInfo);
    }

    public void setMode(Context context, int i) {
        if (UtilityImpl.getMode(context) != i) {
            UtilityImpl.setMode(context, i);
            C4086b.m16670a(context).m16686j(C4086b.SP_BIND_FILE_NAME);
            C4086b.m16670a(context).m16686j(C4086b.SP_AGOO_BIND_FILE_NAME);
            UtilityImpl.killService(context);
        }
    }

    public void setProxy(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(Constants.KEY_PROXY_HOST, str);
        }
        edit.putInt(Constants.KEY_PROXY_PORT, i);
        edit.apply();
    }

    public void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, str, AgooConstants.MESSAGE_SOURCE_ACCS, str2, iAppReceiver);
    }

    public void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        GlobalClientInfo.getInstance(context).setAppReceiver(iAppReceiver);
        GlobalClientInfo.getInstance(context).setAppSecret(str2);
        if (UtilityImpl.isMainProcess(context)) {
            ALog.m16901d("ACCSManagerImpl", "startInAppConnection APPKEY:" + str, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.equals(UtilityImpl.getAppkey(context), str)) {
                    UtilityImpl.setAppInfo(context, str, null, str3);
                }
                C4112a.m16803a(context, 1).m16807a();
                return;
            }
            return;
        }
        ALog.m16901d("ACCSManagerImpl", "inapp only init in main process!", new Object[0]);
    }

    public void unRegisterDataListener(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    public void unRegisterSerivce(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    public void unbindApp(Context context) {
        ALog.m16903e("ACCSManagerImpl", "unbindApp" + UtilityImpl.getStackMsg(new Exception()), new Object[0]);
        if (!UtilityImpl.getFocusDisableStatus(context)) {
            Intent a = m16769a(context, 2);
            if (a == null) {
                m16771a(context, 2, null, null);
            } else if (UtilityImpl.isMainProcess(context)) {
                m16773a(context, Message.buildUnbindApp(context, a), 2, false);
            } else {
                context.startService(a);
            }
        }
    }

    public void unbindService(Context context, String str) {
        if (!UtilityImpl.getFocusDisableStatus(context)) {
            Intent a = m16769a(context, 6);
            if (a == null) {
                m16771a(context, 6, str, null);
                return;
            }
            Object appkey = UtilityImpl.getAppkey(context);
            if (!TextUtils.isEmpty(appkey)) {
                a.putExtra(Constants.KEY_APP_KEY, appkey);
                a.putExtra(Constants.KEY_SERVICE_ID, str);
                if (UtilityImpl.isMainProcess(context)) {
                    m16773a(context, Message.buildUnbindService(context, a), 6, false);
                } else {
                    context.startService(a);
                }
            }
        }
    }

    public void unbindUser(Context context) {
        if (!UtilityImpl.getFocusDisableStatus(context) && !UtilityImpl.getFocusDisableStatus(context)) {
            Intent a = m16769a(context, 4);
            if (a == null) {
                m16771a(context, 4, null, null);
                return;
            }
            Object appkey = UtilityImpl.getAppkey(context);
            if (!TextUtils.isEmpty(appkey)) {
                a.putExtra(Constants.KEY_APP_KEY, appkey);
                if (UtilityImpl.isMainProcess(context)) {
                    m16773a(context, Message.buildUnbindUser(context, a), 4, false);
                } else {
                    context.startService(a);
                }
            }
        }
    }
}
