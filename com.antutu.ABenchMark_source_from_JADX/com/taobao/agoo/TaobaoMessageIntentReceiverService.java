package com.taobao.agoo;

import android.content.Context;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.utl.ALog;
import org.android.agoo.message.MessageReceiverService;

public class TaobaoMessageIntentReceiverService extends MessageReceiverService {
    public String getIntentServiceClassName(Context context) {
        ALog.m16906w("Taobao", "getPackage Name=" + context.getPackageName(), new Object[0]);
        return C4085a.m16663b(context.getPackageName());
    }
}
