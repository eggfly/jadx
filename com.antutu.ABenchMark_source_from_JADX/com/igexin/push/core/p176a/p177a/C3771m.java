package com.igexin.push.core.p176a.p177a;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import com.igexin.push.p169f.p170b.C3732h;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: com.igexin.push.core.a.a.m */
class C3771m extends C3732h {
    final /* synthetic */ Map f12695a;
    final /* synthetic */ C3770l f12696b;

    C3771m(C3770l c3770l, long j, Map map) {
        this.f12696b = c3770l;
        this.f12695a = map;
        super(j);
    }

    protected void m15476a() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C3855g.f12969g.getPackageName());
            stringBuilder.append("#");
            stringBuilder.append(this.f12696b.m15472d((String) this.f12695a.get("pkgName")));
            stringBuilder.append("#");
            stringBuilder.append((String) this.f12695a.get("pkgName"));
            stringBuilder.append("/");
            stringBuilder.append((String) this.f12695a.get("serviceName"));
            stringBuilder.append("#");
            if (C3770l.m15467a((String) this.f12695a.get("pkgName"), (String) this.f12695a.get("serviceName"))) {
                stringBuilder.append(MessageService.MSG_DB_NOTIFY_REACHED);
            } else {
                stringBuilder.append(MessageService.MSG_DB_READY_REPORT);
            }
            this.f12696b.m15469b("30026", stringBuilder.toString(), (String) this.f12695a.get("messageId"), (String) this.f12695a.get("taskId"), (String) this.f12695a.get(AgooConstants.MESSAGE_ID));
            C3688a.m15097b("feedback actionId=30026 result=" + stringBuilder.toString());
        } catch (Exception e) {
        }
    }

    public int m15477b() {
        return 0;
    }
}
