package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.IAppReceiverV1;
import com.taobao.accs.client.C4086b;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.p194a.C4149a;
import com.taobao.agoo.p194a.p195a.C4148c;
import java.util.Map;
import org.android.agoo.common.C4575b;

/* renamed from: com.taobao.agoo.b */
final class C4151b extends IAppReceiverV1 {
    final /* synthetic */ Context f13923a;
    final /* synthetic */ IRegister f13924b;
    final /* synthetic */ String f13925c;
    final /* synthetic */ String f13926d;

    C4151b(Context context, IRegister iRegister, String str, String str2) {
        this.f13923a = context;
        this.f13924b = iRegister;
        this.f13925c = str;
        this.f13926d = str2;
    }

    public Map<String, String> getAllServices() {
        return null;
    }

    public String getService(String str) {
        return GlobalClientInfo.getInstance(this.f13923a).getService(str);
    }

    public void onBindApp(int i, String str) {
        try {
            ALog.m16904i("TaobaoRegister", "onBindApp", Constants.KEY_ERROR_CODE, Integer.valueOf(i));
            if (i == Constants.COMMAND_HANDSHAKE) {
                if (C4086b.m16670a(this.f13923a).m16683g(this.f13923a.getPackageName())) {
                    ALog.m16904i("TaobaoRegister", "agoo aready Registered return ", new Object[0]);
                    if (this.f13924b != null) {
                        this.f13924b.onSuccess(C4575b.m19250e(this.f13923a));
                        return;
                    }
                    return;
                }
                if (TaobaoRegister.mRequestListener == null) {
                    TaobaoRegister.mRequestListener = new C4149a();
                    ACCSManager.registerDataListener(this.f13923a, TaobaoConstants.SERVICE_ID_DEVICECMD, TaobaoRegister.mRequestListener);
                }
                byte[] a = C4148c.m16951a(this.f13923a, this.f13925c, this.f13926d);
                if (a != null) {
                    CharSequence sendRequest = ACCSManager.sendRequest(this.f13923a, new AccsRequest(null, TaobaoConstants.SERVICE_ID_DEVICECMD, a, null));
                    if (TextUtils.isEmpty(sendRequest)) {
                        if (this.f13924b != null) {
                            this.f13924b.onFailure(TaobaoConstants.REGISTER_ERROR, "accs channel disabled!");
                        }
                    } else if (this.f13924b != null) {
                        TaobaoRegister.mRequestListener.f13920a.put(sendRequest, this.f13924b);
                    }
                } else if (this.f13924b != null) {
                    this.f13924b.onFailure(TaobaoConstants.REGISTER_ERROR, "req data null");
                }
            } else if (this.f13924b != null) {
                this.f13924b.onFailure(String.valueOf(i), "accs bindapp error!");
            }
        } catch (Throwable th) {
            ALog.m16902e("TaobaoRegister", "register onBindApp", th, new Object[0]);
        }
    }

    public void onBindUser(String str, int i) {
    }

    public void onUnbindApp(int i) {
    }

    public void onUnbindUser(int i) {
    }
}
