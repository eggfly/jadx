package cn.sharesdk.tencent.qq;

import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.authorize.C0916d;
import cn.sharesdk.framework.authorize.C0937c;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.qq.p035e.comm.constants.Constants.KEYS;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* renamed from: cn.sharesdk.tencent.qq.c */
public class C1012c extends C0916d {
    private String f3416d;
    private String f3417e;

    public C1012c(C0937c c0937c) {
        super(c0937c);
    }

    public void m4511a() {
        String str = "com.tencent.mobileqq";
        try {
            if (this.a.getContext().getPackageManager().getPackageInfo(str, 0) == null) {
                this.a.finish();
                if (this.c != null) {
                    this.c.onFailed(new TencentSSOClientNotInstalledException());
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(str, "com.tencent.open.agent.AgentActivity");
            if (this.a.getContext().getPackageManager().resolveActivity(intent, 0) == null) {
                this.a.finish();
                if (this.c != null) {
                    this.c.onFailed(new TencentSSOClientNotInstalledException());
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("scope", this.f3417e);
            bundle.putString("client_id", this.f3416d);
            bundle.putString("pf", "openmobile_android");
            bundle.putString("need_pay", MessageService.MSG_DB_NOTIFY_REACHED);
            intent.putExtra("key_params", bundle);
            intent.putExtra("key_request_code", this.b);
            intent.putExtra("key_action", "action_login");
            try {
                this.a.startActivityForResult(intent, this.b);
            } catch (Throwable th) {
                this.a.finish();
                if (this.c != null) {
                    this.c.onFailed(th);
                }
            }
        } catch (Throwable th2) {
            this.a.finish();
            if (this.c != null) {
                this.c.onFailed(new TencentSSOClientNotInstalledException());
            }
        }
    }

    public void m4512a(int i, int i2, Intent intent) {
        this.a.finish();
        if (i2 == 0) {
            if (this.c != null) {
                this.c.onCancel();
            }
        } else if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                if (this.c != null) {
                    this.c.onFailed(new Throwable("response is empty"));
                }
            } else if (extras.containsKey("key_response")) {
                String string = extras.getString("key_response");
                if (string != null && string.length() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        extras = new Bundle();
                        extras.putInt(KEYS.RET, jSONObject.optInt(KEYS.RET));
                        extras.putString("pay_token", jSONObject.optString("pay_token"));
                        extras.putString("pf", jSONObject.optString("pf"));
                        extras.putString("open_id", jSONObject.optString("openid"));
                        extras.putString("expires_in", jSONObject.optString("expires_in"));
                        extras.putString("pfkey", jSONObject.optString("pfkey"));
                        extras.putString(XAdErrorCode.ERROR_CODE_MESSAGE, jSONObject.optString(XAdErrorCode.ERROR_CODE_MESSAGE));
                        extras.putString("access_token", jSONObject.optString("access_token"));
                        if (this.c != null) {
                            this.c.onComplete(extras);
                            this.c = null;
                        }
                    } catch (Throwable th) {
                        if (this.c != null) {
                            this.c.onFailed(th);
                        }
                    }
                } else if (this.c != null) {
                    this.c.onFailed(new Throwable("response is empty"));
                }
            } else if (this.c != null) {
                this.c.onFailed(new Throwable("response is empty"));
            }
        } else if (this.c != null) {
            this.c.onFailed(new Throwable("response is empty"));
        }
    }

    public void m4513a(String str, String str2) {
        this.f3416d = str;
        this.f3417e = str2;
    }
}
