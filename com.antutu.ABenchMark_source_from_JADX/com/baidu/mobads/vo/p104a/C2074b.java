package com.baidu.mobads.vo.p104a;

import android.content.Context;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.p080j.C1991m;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import org.android.agoo.message.MessageService;

/* renamed from: com.baidu.mobads.vo.a.b */
public class C2074b extends C2073a {
    public boolean f7272n;
    private Context f7273o;
    private C1924a f7274p;

    public C2074b(Context context, C1924a c1924a) {
        super(c1924a.f6743n, c1924a.f6742m, c1924a.f6745p);
        this.f7272n = true;
        this.f7273o = context;
        this.f7274p = c1924a;
    }

    protected HashMap<String, String> m7758b() {
        String str = BuildConfig.FLAVOR + C1991m.m7449a().m7465n().getCurrentProcessId(this.f7273o);
        HashMap<String, String> hashMap = new HashMap();
        try {
            hashMap.put("autoOpen", this.f7272n ? "true" : "false");
            hashMap.put(IXAdRequestInfo.PACKAGE, this.f7274p.f6738i);
            hashMap.put("c", MessageService.MSG_DB_READY_REPORT);
            hashMap.put("clickProcId", str);
            hashMap.put("clickTime", this.f7274p.m7257c() + BuildConfig.FLAVOR);
            hashMap.put("contentLength", BuildConfig.FLAVOR + this.f7274p.m7259e());
            hashMap.put("dlCnt", MessageService.MSG_DB_NOTIFY_REACHED);
            hashMap.put("dlTime", String.valueOf(System.currentTimeMillis() - this.f7274p.m7257c()));
            hashMap.put("dlTunnel", MessageService.MSG_DB_NOTIFY_DISMISS);
            hashMap.put("dlWay", this.f7274p.m7260f() ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
            hashMap.put("exp_id", BuildConfig.FLAVOR);
            hashMap.put("exp2", BuildConfig.FLAVOR);
            hashMap.put(Constants.KEY_ELECTION_PKG, this.f7274p.f6738i);
            hashMap.put("typeProcId", str);
            hashMap.put("url2", BuildConfig.FLAVOR);
            hashMap.put(IXAdRequestInfo.SN, C1991m.m7449a().m7456e().encode(C1991m.m7449a().m7465n().getDeviceId(this.f7273o)));
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
        return hashMap;
    }
}
