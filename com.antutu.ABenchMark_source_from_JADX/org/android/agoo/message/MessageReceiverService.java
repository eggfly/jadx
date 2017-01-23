package org.android.agoo.message;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.BaseIntentService;
import org.android.agoo.service.SendMessage.Stub;

public abstract class MessageReceiverService extends Service {
    Stub f13901a;

    /* renamed from: org.android.agoo.message.MessageReceiverService.1 */
    class C45891 extends Stub {
        C45891() {
        }

        public int doSend(Intent intent) {
            BaseIntentService.runIntentInService(MessageReceiverService.this.getApplicationContext(), intent, MessageReceiverService.this.getIntentServiceClassName(MessageReceiverService.this.getApplicationContext()));
            return 0;
        }
    }

    public MessageReceiverService() {
        this.f13901a = new C45891();
    }

    public abstract String getIntentServiceClassName(Context context);

    public IBinder onBind(Intent intent) {
        ALog.m16901d("MessageReceiverService", "Message receiver aidl was binded {}", intent.getAction());
        return AgooConstants.BINDER_MSGRECEIVER_ACTION.equals(intent.getAction()) ? this.f13901a : this.f13901a;
    }

    public void onCreate() {
        super.onCreate();
    }
}
