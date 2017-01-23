package org.android.agoo.control;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4577d;

/* renamed from: org.android.agoo.control.g */
class C4588g implements Runnable {
    final /* synthetic */ int f16428a;
    final /* synthetic */ String f16429b;
    final /* synthetic */ String f16430c;
    final /* synthetic */ String f16431d;
    final /* synthetic */ NotifManager f16432e;

    C4588g(NotifManager notifManager, int i, String str, String str2, String str3) {
        this.f16432e = notifManager;
        this.f16428a = i;
        this.f16429b = str;
        this.f16430c = str2;
        this.f16431d = str3;
    }

    public void run() {
        try {
            if ((this.f16428a == 100 || C4577d.m19258a(100, C4135a.m16912b(NotifManager.mContext)) <= this.f16428a) && this.f16432e.isAppInstalled(this.f16429b)) {
                Intent intent = new Intent();
                intent.setAction(this.f16430c);
                intent.setClassName(this.f16429b, this.f16431d);
                intent.putExtra(AgooConstants.MESSAGE_FROM_PKG, NotifManager.mContext.getPackageName());
                NotifManager.mContext.startService(intent);
                String access$200 = this.f16432e.getVersion(this.f16429b);
                if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i("NotifManager", "pingApp [begin],action=" + this.f16430c + ",pack=" + this.f16429b + ",service=" + this.f16431d + ",appVersion=" + access$200, new Object[0]);
                }
                UTMini.getInstance().commitEvent(UT.EVENT_ID, "pingApp", C4135a.m16912b(NotifManager.mContext), this.f16429b, access$200);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "pingApp", C4135a.m16912b(NotifManager.mContext), th.toString());
            ALog.m16902e("NotifManager", "pingApp", th, new Object[0]);
        }
    }
}
