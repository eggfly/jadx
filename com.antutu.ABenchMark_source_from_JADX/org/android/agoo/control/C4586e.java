package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import org.android.agoo.common.C4575b;
import org.android.agoo.message.MessageService;

/* renamed from: org.android.agoo.control.e */
class C4586e implements Runnable {
    final /* synthetic */ String f16424a;
    final /* synthetic */ String f16425b;
    final /* synthetic */ AgooFactory f16426c;

    C4586e(AgooFactory agooFactory, String str, String str2) {
        this.f16426c = agooFactory;
        this.f16424a = str;
        this.f16425b = str2;
    }

    public void run() {
        try {
            if (!TextUtils.isEmpty(this.f16424a) && !TextUtils.isEmpty(this.f16425b)) {
                if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i("AgooFactory", "updateNotifyMsg begin,messageId=" + this.f16424a + ",status=" + this.f16425b + ",reportTimes=" + C4575b.m19248c(AgooFactory.mContext), new Object[0]);
                }
                if (TextUtils.equals(this.f16425b, MessageService.MSG_ACCS_NOTIFY_CLICK)) {
                    this.f16426c.messageService.m19273a(this.f16424a, MessageService.MSG_DB_NOTIFY_CLICK);
                } else if (TextUtils.equals(this.f16425b, MessageService.MSG_ACCS_NOTIFY_DISMISS)) {
                    this.f16426c.messageService.m19273a(this.f16424a, MessageService.MSG_DB_NOTIFY_DISMISS);
                }
            }
        } catch (Throwable th) {
            ALog.m16903e("AgooFactory", "updateNotifyMsg e=" + th.toString(), new Object[0]);
        }
    }
}
