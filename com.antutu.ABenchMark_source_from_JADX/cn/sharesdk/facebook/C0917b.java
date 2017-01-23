package cn.sharesdk.facebook;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.C0916d;
import cn.sharesdk.framework.authorize.C0937c;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.TnetStatusCode;

/* renamed from: cn.sharesdk.facebook.b */
public class C0917b extends C0916d {
    private String f3133d;
    private String[] f3134e;

    public C0917b(C0937c c0937c) {
        super(c0937c);
    }

    private boolean m4035b() {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", this.f3133d);
        if (this.f3134e != null && this.f3134e.length > 0) {
            intent.putExtra("scope", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, this.f3134e));
        }
        if (!m4036b(intent)) {
            return false;
        }
        try {
            this.a.startActivityForResult(intent, this.b);
        } catch (Throwable th) {
            z = false;
        }
        return z;
    }

    private boolean m4036b(Intent intent) {
        ResolveInfo resolveActivity = this.a.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            for (Signature toCharsString : this.a.getContext().getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures) {
                if ("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(toCharsString.toCharsString())) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void m4037c(Intent intent) {
        if (this.c != null) {
            String stringExtra = intent.getStringExtra("error_message");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_code");
            }
            if (stringExtra == null) {
                this.c.onComplete(intent.getExtras());
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                this.c.onCancel();
            } else {
                String stringExtra2 = intent.getStringExtra("error_message");
                if (stringExtra2 != null) {
                    stringExtra = intent.getStringExtra("error_code") + ": " + stringExtra2;
                }
                this.c.onFailed(new Throwable(stringExtra));
            }
        }
    }

    private void m4038d(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(C4233j.f14375B);
            Throwable th = new Throwable(stringExtra + " (" + intent.getStringExtra("error_code") + C4233j.f14397t);
            if (this.c != null) {
                this.c.onFailed(th);
            }
        } else if (this.c != null) {
            this.c.onCancel();
        }
    }

    public void m4039a() {
        if (!m4035b()) {
            this.a.finish();
            if (this.c != null) {
                this.c.onFailed(new Throwable());
            }
        }
    }

    public void m4040a(int i, int i2, Intent intent) {
        this.a.finish();
        if (i == this.b) {
            switch (i2) {
                case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                    m4037c(intent);
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    m4038d(intent);
                default:
            }
        }
    }

    public void m4041a(String str, String[] strArr) {
        this.f3133d = str;
        this.f3134e = strArr;
    }
}
