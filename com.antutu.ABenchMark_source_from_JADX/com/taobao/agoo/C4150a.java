package com.taobao.agoo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.umeng.message.util.HttpRequest;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;
import org.android.agoo.message.MessageService;

/* renamed from: com.taobao.agoo.a */
class C4150a extends Thread {
    final /* synthetic */ Intent f13921a;
    final /* synthetic */ BaseNotifyClickActivity f13922b;

    C4150a(BaseNotifyClickActivity baseNotifyClickActivity, Intent intent) {
        this.f13922b = baseNotifyClickActivity;
        this.f13921a = intent;
    }

    public void run() {
        if (this.f13921a != null) {
            try {
                String access$000 = AgooConstants.TAOBAO_PACKAGE.equals(this.f13922b.getPackageName()) ? this.f13922b.parseMsgFromNotifyListener(this.f13921a) : this.f13922b.parseMsgFromChannel(this.f13921a);
                if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i("accs.BaseNotifyClickActivity", "parse msg: " + access$000, new Object[0]);
                }
                if (!TextUtils.isEmpty(access$000) && !TextUtils.isEmpty(this.f13922b.msgSource)) {
                    if (this.f13922b.notifyManager == null) {
                        this.f13922b.notifyManager = new NotifManager();
                    }
                    if (this.f13922b.agooFactory == null) {
                        this.f13922b.agooFactory = new AgooFactory();
                        this.f13922b.agooFactory.init(this.f13922b.getApplicationContext(), this.f13922b.notifyManager, null);
                    }
                    Bundle msgReceiverPreHandler = this.f13922b.agooFactory.msgReceiverPreHandler(access$000.getBytes(HttpRequest.f14548a), this.f13922b.msgSource, null, false);
                    Intent intent = new Intent();
                    intent.putExtras(msgReceiverPreHandler);
                    this.f13922b.onMessage(intent);
                    this.f13922b.agooFactory.saveMsg(access$000.getBytes(HttpRequest.f14548a), MessageService.MSG_DB_NOTIFY_CLICK);
                    this.f13922b.reportClickNotifyMsg(intent);
                }
            } catch (Exception e) {
                ALog.m16903e("accs.BaseNotifyClickActivity", "buildMessage exception: " + e, new Object[0]);
            }
        }
    }
}
