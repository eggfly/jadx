package org.android.agoo.accs;

import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.UTMini;
import com.umeng.message.util.HttpRequest;
import java.nio.charset.Charset;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.android.agoo.common.CallBack;
import org.android.agoo.control.AgooFactory;

public class AgooService extends TaoBaseService {
    public static CallBack f16390a;
    public static CallBack f16391b;
    private AgooFactory f16392c;

    private String m19232a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement.toString() + "\n");
            }
        }
        return stringBuffer.toString();
    }

    public void m19233a() {
    }

    public void m19234b() {
    }

    public void onBind(String str, int i, ExtraInfo extraInfo) {
        if (ALog.isPrintLog(Level.E)) {
            ALog.m16903e("AgooService", "into--[onBind]:serviceId:" + str + ",errorCode=" + i, new Object[0]);
        }
        if (f16390a != null && GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            if (i == Constants.COMMAND_HANDSHAKE) {
                f16390a.onSuccess();
            } else {
                f16390a.onFailure(String.valueOf(i), "bind Agoo service fail");
            }
        }
        f16390a = null;
    }

    public void onCreate() {
        super.onCreate();
        ALog.m16901d("AgooService", "into--[onCreate]", new Object[0]);
        this.f16392c = new AgooFactory();
        this.f16392c.init(getApplicationContext(), null, null);
    }

    public void onData(String str, String str2, String str3, byte[] bArr, ExtraInfo extraInfo) {
        if (ALog.isPrintLog(Level.I)) {
            ALog.m16904i("AgooService", "into--[onData]:serviceId:" + str + ",dataId=" + str3, new Object[0]);
            ALog.m16901d("AgooService", "push data:" + new String(bArr, Charset.forName(HttpRequest.f14548a)), new Object[0]);
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", C4135a.m16912b(getApplicationContext()), str3);
        try {
            this.f16392c.saveMsg(bArr);
            this.f16392c.msgRecevie(bArr, AgooConstants.MESSAGE_SOURCE_ACCS, extraInfo);
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", "onDataError", th);
            ALog.m16903e("AgooService", "into--[onData,dealMessage]:error:" + th, new Object[0]);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResponse(String str, String str2, int i, byte[] bArr, ExtraInfo extraInfo) {
        String str3;
        if (ALog.isPrintLog(Level.I)) {
            ALog.m16904i("AgooService", "onResponse,dataId=" + str2 + ",errorCode=" + i + ",data=" + bArr + ",serviceId=" + str, new Object[0]);
        }
        String str4 = null;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    str3 = new String(bArr, "utf-8");
                    str4 = str3;
                    if (ALog.isPrintLog(Level.D)) {
                        ALog.m16901d("AgooService", "onResponse,message=" + str4, new Object[0]);
                    }
                    if (i != Constants.COMMAND_HANDSHAKE && TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                        if (ALog.isPrintLog(Level.I)) {
                            ALog.m16904i("AgooService", "business request is success,serviceId=" + str + ",message=" + str4, new Object[0]);
                        }
                        this.f16392c.updateMsg(bArr, true);
                        return;
                    } else if (i == Constants.COMMAND_HANDSHAKE && TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                        if (ALog.isPrintLog(Level.E)) {
                            ALog.m16903e("AgooService", "business request is error,serviceId='agooAck',message=" + str4, new Object[0]);
                        }
                        C4575b.m19239a(getApplicationContext(), 1);
                        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_FAIL_ACK, String.valueOf(i), 0.0d);
                        return;
                    } else if (ALog.isPrintLog(Level.E)) {
                        ALog.m16903e("AgooService", "business request is error,message=" + str4, new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ALog.m16904i("AgooService", "onResponse get data error,e=" + th, new Object[0]);
            }
        }
        str3 = null;
        str4 = str3;
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("AgooService", "onResponse,message=" + str4, new Object[0]);
        }
        if (i != Constants.COMMAND_HANDSHAKE) {
        }
        if (i == Constants.COMMAND_HANDSHAKE) {
        }
        if (ALog.isPrintLog(Level.E)) {
            ALog.m16903e("AgooService", "business request is error,message=" + str4, new Object[0]);
        }
    }

    public void onSendData(String str, String str2, int i, ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(Level.I)) {
                ALog.m16904i("AgooService", "onSendData,dataId=" + str2 + ",errorCode=" + i + ",serviceId=" + str, new Object[0]);
            }
            if (i == Constants.COMMAND_HANDSHAKE) {
                if (TextUtils.equals(AgooConstants.AGOO_SERVICE_AGOOACK, str)) {
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "8/9", 0.0d);
                }
                if (TextUtils.isEmpty(str) || !TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK) || Long.parseLong(str2) <= 300000000 || Long.parseLong(str2) >= 600000000) {
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK) && Long.parseLong(str2) > 600000000 && ALog.isPrintLog(Level.I)) {
                        ALog.m16904i("AgooService", "onSendData,reportData=" + str2 + ",serviceId=" + str, new Object[0]);
                        return;
                    }
                    return;
                } else if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i("AgooService", "onSendData,AckData=" + str2 + ",serviceId=" + str, new Object[0]);
                    return;
                } else {
                    return;
                }
            }
            if (TextUtils.equals(AgooConstants.AGOO_SERVICE_AGOOACK, str)) {
                C4575b.m19239a(getApplicationContext(), 1);
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_FAIL_ACK, String.valueOf(i), 0.0d);
            }
            if (ALog.isPrintLog(Level.I)) {
                ALog.m16904i("AgooService", "onSendData error,dataId=" + str2 + ",serviceId=" + str, new Object[0]);
                ALog.m16903e("AgooService", "into--[parseError]", new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", C4135a.m16912b(getApplicationContext()), Constants.KEY_ERROR_CODE, str2 + ",serviceId=" + str + ",errorCode=" + i);
        } catch (Throwable th) {
            Throwable th2 = th;
            if (ALog.isPrintLog(Level.E)) {
                ALog.m16903e("AgooService", "onSendData exception,e=" + th2.getMessage() + ",e.getStackMsg=" + m19232a(th2), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", C4135a.m16912b(getApplicationContext()), "onSendDataException", m19232a(th2));
        }
    }

    public void onUnbind(String str, int i, ExtraInfo extraInfo) {
        if (ALog.isPrintLog(Level.E)) {
            ALog.m16903e("AgooService", "into--[onUnbind]:serviceId:" + str + ",errorCode=" + i, new Object[0]);
        }
        if (f16391b != null && GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            if (i == Constants.COMMAND_HANDSHAKE) {
                f16391b.onSuccess();
            } else {
                f16391b.onFailure(String.valueOf(i), "unbind Agoo service fail");
            }
        }
        f16391b = null;
    }
}
