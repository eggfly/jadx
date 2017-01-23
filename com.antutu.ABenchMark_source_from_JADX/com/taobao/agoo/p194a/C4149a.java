package com.taobao.agoo.p194a;

import android.text.TextUtils;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.client.C4086b;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C4139d;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoConstants;
import com.taobao.agoo.p194a.p195a.C4146b;
import com.taobao.agoo.p194a.p195a.C4147a;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.C4575b;
import org.json.JSONObject;

/* renamed from: com.taobao.agoo.a.a */
public class C4149a extends AccsAbstractDataListener {
    public Map<String, ICallback> f13920a;

    public C4149a() {
        this.f13920a = new HashMap();
    }

    private void m16953a(JSONObject jSONObject, ICallback iCallback) {
        String a = C4139d.m16925a(jSONObject, C4147a.JSON_PUSH_USER_TOKEN, null);
        if (!TextUtils.isEmpty(a)) {
            C4575b.m19246b(GlobalClientInfo.getContext(), a);
            if (iCallback != null) {
                iCallback.onSuccess();
                C4086b.m16670a(GlobalClientInfo.getContext()).m16684h(iCallback.extra);
            }
        } else if (iCallback != null) {
            iCallback.onFailure(BuildConfig.FLAVOR, "agoo server error-pushtoken null");
        }
    }

    public void onBind(String str, int i, ExtraInfo extraInfo) {
    }

    public void onData(String str, String str2, String str3, byte[] bArr, ExtraInfo extraInfo) {
    }

    public void onResponse(String str, String str2, int i, byte[] bArr, ExtraInfo extraInfo) {
        try {
            if (TaobaoConstants.SERVICE_ID_DEVICECMD.equals(str)) {
                ICallback iCallback = (ICallback) this.f13920a.get(str2);
                if (i == Constants.COMMAND_HANDSHAKE) {
                    ALog.m16904i("RequestListener", "RequestListener onResponse", Constants.KEY_DATA_ID, str2, "listener", iCallback, "json", new String(bArr, "utf-8"));
                    JSONObject jSONObject = new JSONObject(r1);
                    String a = C4139d.m16925a(jSONObject, C4146b.JSON_ERRORCODE, null);
                    String a2 = C4139d.m16925a(jSONObject, C4146b.JSON_CMD, null);
                    if (!MsgConstant.KEY_SUCCESS.equals(a)) {
                        if (iCallback != null) {
                            iCallback.onFailure(String.valueOf(a), "agoo server error");
                        }
                        if (TaobaoConstants.SERVICE_ID_DEVICECMD.equals(str)) {
                            this.f13920a.remove(str2);
                            return;
                        }
                        return;
                    } else if (MiPushClient.COMMAND_REGISTER.equals(a2)) {
                        a = C4139d.m16925a(jSONObject, C4575b.KEY_DEVICE_TOKEN, null);
                        if (!TextUtils.isEmpty(a)) {
                            if (iCallback != null) {
                                if (iCallback instanceof IRegister) {
                                    ((IRegister) iCallback).onSuccess(a);
                                }
                            }
                            C4575b.m19241a(GlobalClientInfo.getContext(), a);
                            C4086b.m16670a(GlobalClientInfo.getContext()).m16682f(GlobalClientInfo.getContext().getPackageName());
                        } else if (iCallback != null) {
                            iCallback.onFailure(BuildConfig.FLAVOR, "agoo server error deviceid null");
                        }
                        if (TaobaoConstants.SERVICE_ID_DEVICECMD.equals(str)) {
                            this.f13920a.remove(str2);
                            return;
                        }
                        return;
                    } else if (C4147a.JSON_CMD_SETALIAS.equals(a2)) {
                        m16953a(jSONObject, iCallback);
                        if (TaobaoConstants.SERVICE_ID_DEVICECMD.equals(str)) {
                            this.f13920a.remove(str2);
                            return;
                        }
                        return;
                    } else if (C4147a.JSON_CMD_REMOVEALIAS.equals(a2)) {
                        C4575b.m19246b(GlobalClientInfo.getContext(), null);
                        if (iCallback != null) {
                            iCallback.onSuccess();
                        }
                        C4086b.m16670a(GlobalClientInfo.getContext()).m16674a();
                        if (TaobaoConstants.SERVICE_ID_DEVICECMD.equals(str)) {
                            this.f13920a.remove(str2);
                            return;
                        }
                        return;
                    }
                } else if (iCallback != null) {
                    iCallback.onFailure(String.valueOf(i), "accs channel error");
                }
            }
            if (TaobaoConstants.SERVICE_ID_DEVICECMD.equals(str)) {
                this.f13920a.remove(str2);
            }
        } catch (Throwable th) {
            if (TaobaoConstants.SERVICE_ID_DEVICECMD.equals(str)) {
                this.f13920a.remove(str2);
            }
        }
    }

    public void onSendData(String str, String str2, int i, ExtraInfo extraInfo) {
    }

    public void onUnbind(String str, int i, ExtraInfo extraInfo) {
    }
}
