package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0979d;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;

/* renamed from: cn.sharesdk.wechat.utils.a */
public class C1043a extends C1042j {
    public String f3516a;
    public String f3517b;

    public int m4670a() {
        return 1;
    }

    public void m4671a(Bundle bundle) {
        super.m4668a(bundle);
        bundle.putString("_wxapi_sendauth_req_scope", this.f3516a);
        bundle.putString("_wxapi_sendauth_req_state", this.f3517b);
    }

    public boolean m4672b() {
        if (this.f3516a == null || this.f3516a.length() == 0 || this.f3516a.length() > IXAdIOUtils.BUFFER_SIZE) {
            C0979d.m4390a().m4375d("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
            return false;
        } else if (this.f3517b == null || this.f3517b.length() <= IXAdIOUtils.BUFFER_SIZE) {
            return true;
        } else {
            C0979d.m4390a().m4375d("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
            return false;
        }
    }
}
