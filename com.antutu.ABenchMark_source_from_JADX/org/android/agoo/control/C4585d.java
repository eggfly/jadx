package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.umeng.message.MsgConstant;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* renamed from: org.android.agoo.control.d */
class C4585d implements Runnable {
    final /* synthetic */ byte[] f16421a;
    final /* synthetic */ boolean f16422b;
    final /* synthetic */ AgooFactory f16423c;

    C4585d(AgooFactory agooFactory, byte[] bArr, boolean z) {
        this.f16423c = agooFactory;
        this.f16421a = bArr;
        this.f16422b = z;
    }

    public void run() {
        try {
            String str = new String(this.f16421a, "utf-8");
            if (TextUtils.isEmpty(str)) {
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_FAIL_ACK, "msg==null", 0.0d);
                return;
            }
            ALog.m16904i("AgooFactory", "message = " + str, new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            CharSequence charSequence = null;
            CharSequence string = jSONObject.getString("api");
            String string2 = jSONObject.getString(AgooConstants.MESSAGE_ID);
            if (TextUtils.equals(string, "agooReport")) {
                charSequence = jSONObject.getString(MsgConstant.KEY_STATUS);
            }
            if (TextUtils.equals(string, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "handlerACKMessage", 0.0d);
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(charSequence)) {
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_FAIL_ACK, "json key null", 0.0d);
                return;
            }
            if (ALog.isPrintLog(Level.I)) {
                ALog.m16904i("AgooFactory", "updateMsg data begin,api=" + string + ",id=" + string2 + ",status=" + charSequence + ",reportTimes=" + C4575b.m19248c(AgooFactory.mContext), new Object[0]);
            }
            if (TextUtils.equals(string, "agooReport")) {
                if (TextUtils.equals(charSequence, MessageService.MSG_ACCS_READY_REPORT) && this.f16422b) {
                    this.f16423c.messageService.m19273a(string2, MessageService.MSG_DB_NOTIFY_REACHED);
                } else if ((TextUtils.equals(charSequence, MessageService.MSG_ACCS_NOTIFY_CLICK) || TextUtils.equals(charSequence, MessageService.MSG_ACCS_NOTIFY_DISMISS)) && this.f16422b) {
                    this.f16423c.messageService.m19273a(string2, MessageService.MSG_DB_COMPLETE);
                }
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_SUCCESS_ACK, charSequence, 0.0d);
            }
        } catch (Throwable th) {
            ALog.m16903e("AgooFactory", "updateMsg get data error,e=" + th, new Object[0]);
            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_AGOO_FAIL_ACK, "json exception", 0.0d);
        }
    }
}
