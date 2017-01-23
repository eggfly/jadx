package org.android.agoo.control;

import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.MsgDO;

/* renamed from: org.android.agoo.control.c */
class C4584c implements Runnable {
    final /* synthetic */ AgooFactory f16420a;

    C4584c(AgooFactory agooFactory) {
        this.f16420a = agooFactory;
    }

    public void run() {
        ArrayList b = this.f16420a.messageService.m19278b();
        if (b != null && b.size() > 0) {
            Iterator it = b.iterator();
            while (it.hasNext()) {
                MsgDO msgDO = (MsgDO) it.next();
                if (msgDO != null) {
                    msgDO.isFromCache = true;
                    this.f16420a.notifyManager.report(msgDO, null);
                }
            }
        }
    }
}
