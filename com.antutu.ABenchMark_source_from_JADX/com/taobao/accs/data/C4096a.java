package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.util.Map;
import org.android.agoo.accs.AgooService;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: com.taobao.accs.data.a */
public class C4096a extends C4095e {
    private static AgooService f13688a;
    private static final Map<String, String> f13689b;

    static {
        f13688a = new AgooService();
        f13689b = new AliyunMsgDistribute$1();
    }

    protected String m16726a() {
        return "com.alibaba.sdk.android.push.ChannelService";
    }

    protected void m16727a(Context context, IAppReceiver iAppReceiver, Intent intent, int i, int i2) {
        super.m16721a(context, iAppReceiver, intent, i, i2);
    }

    protected void m16728a(Context context, IAppReceiver iAppReceiver, Intent intent, String str, String str2, int i, int i2) {
        AccsDataListener listener = GlobalClientInfo.getInstance(context).getListener(str);
        if (f13689b.containsKey(str)) {
            f13688a.m19233a();
            f13688a.m19234b();
        } else if (listener != null) {
            AccsAbstractDataListener.onReceiveData(context, intent, listener);
        } else {
            ALog.m16903e("AliyunMsgDistribute", "callback is null dataId:" + str2 + " serviceId\uff1a" + str + " command:" + i, new Object[0]);
            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, str, MessageService.MSG_DB_NOTIFY_REACHED, "service is null");
        }
        UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBuss", "commandId=" + i, "serviceId=" + str + " errorCode=" + i2 + " dataId=" + str2, Integer.valueOf(Constants.SDK_VERSION_CODE));
        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_TO_BUSS, "2commandId=" + i + "serviceId=" + str, 0.0d);
    }

    protected boolean m16729a(int i, String str) {
        return false;
    }

    protected boolean m16730a(Context context, String str, Intent intent, IAppReceiver iAppReceiver) {
        if (UtilityImpl.isMainProcess(context)) {
            return false;
        }
        ALog.m16904i("AliyunMsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str);
        intent.setClassName(intent.getPackage(), m16731b());
        context.startService(intent);
        return true;
    }

    protected String m16731b() {
        return "com.alibaba.sdk.android.push.MsgService";
    }
}
