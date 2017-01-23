package cn.sharesdk.sina.weibo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.C0916d;
import cn.sharesdk.framework.authorize.C0937c;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.lang.reflect.Method;
import org.android.spdy.TnetStatusCode;

/* renamed from: cn.sharesdk.sina.weibo.c */
public class C1000c extends C0916d implements ServiceConnection {
    private String f3377d;
    private String f3378e;
    private String[] f3379f;

    public C1000c(C0937c c0937c) {
        super(c0937c);
    }

    private boolean m4430a(String str, String str2) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtra(Constants.KEY_APP_KEY, this.f3377d);
        intent.putExtra("redirectUri", this.f3378e);
        if (this.f3379f != null && this.f3379f.length > 0) {
            intent.putExtra("scope", TextUtils.join(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP, this.f3379f));
        }
        if (!m4431b(intent)) {
            return false;
        }
        try {
            this.a.startActivityForResult(intent, this.b);
        } catch (Throwable th) {
            z = false;
        }
        this.a.getContext().getApplicationContext().unbindService(this);
        return z;
    }

    private boolean m4431b(Intent intent) {
        ResolveInfo resolveActivity = this.a.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            for (Signature toCharsString : this.a.getContext().getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures) {
                if ("30820295308201fea00302010202044b4ef1bf300d06092a864886f70d010105050030818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c74643020170d3130303131343130323831355a180f32303630303130323130323831355a30818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c746430819f300d06092a864886f70d010101050003818d00308189028181009d367115bc206c86c237bb56c8e9033111889b5691f051b28d1aa8e42b66b7413657635b44786ea7e85d451a12a82a331fced99c48717922170b7fc9bc1040753c0d38b4cf2b22094b1df7c55705b0989441e75913a1a8bd2bc591aa729a1013c277c01c98cbec7da5ad7778b2fad62b85ac29ca28ced588638c98d6b7df5a130203010001300d06092a864886f70d0101050500038181000ad4b4c4dec800bd8fd2991adfd70676fce8ba9692ae50475f60ec468d1b758a665e961a3aedbece9fd4d7ce9295cd83f5f19dc441a065689d9820faedbb7c4a4c4635f5ba1293f6da4b72ed32fb8795f736a20c95cda776402099054fccefb4a1a558664ab8d637288feceba9508aa907fc1fe2b1ae5a0dec954ed831c0bea4".equals(toCharsString.toCharsString())) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void m4432c(Intent intent) {
        if (this.c != null) {
            String stringExtra = intent.getStringExtra(C4233j.f14375B);
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                this.c.onComplete(intent.getExtras());
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                this.c.onCancel();
            } else {
                String stringExtra2 = intent.getStringExtra("error_description");
                if (stringExtra2 != null) {
                    stringExtra = stringExtra + ": " + stringExtra2;
                }
                this.c.onFailed(new Throwable(stringExtra));
            }
        }
    }

    private void m4433d(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(C4233j.f14375B);
            Throwable th = new Throwable(stringExtra + " (" + intent.getIntExtra("error_code", -1) + C4233j.f14397t);
            if (this.c != null) {
                this.c.onFailed(th);
            }
        } else if (this.c != null) {
            this.c.onCancel();
        }
    }

    public void m4434a() {
        Intent intent = new Intent();
        intent.setClassName("com.sina.weibo", "com.sina.weibo.business.RemoteSSOService");
        if (!this.a.getContext().getApplicationContext().bindService(intent, this, 1)) {
            this.a.finish();
            if (this.c != null) {
                this.c.onFailed(new Throwable());
            }
        }
    }

    public void m4435a(int i, int i2, Intent intent) {
        this.a.finish();
        if (i == this.b) {
            switch (i2) {
                case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                    m4432c(intent);
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    m4433d(intent);
                default:
            }
        }
    }

    public void m4436a(String str, String str2, String[] strArr) {
        this.f3377d = str;
        this.f3378e = str2;
        this.f3379f = strArr;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Class cls = Class.forName("com.sina.sso.RemoteSSO$Stub");
            Method method = cls.getMethod("asInterface", new Class[]{IBinder.class});
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[]{iBinder});
            Method method2 = cls.getMethod("getPackageName", new Class[0]);
            method2.setAccessible(true);
            String valueOf = String.valueOf(method2.invoke(invoke, new Object[0]));
            Method method3 = cls.getMethod("getActivityName", new Class[0]);
            method3.setAccessible(true);
            if (!m4430a(valueOf, String.valueOf(method3.invoke(invoke, new Object[0])))) {
                this.a.finish();
                if (this.c != null) {
                    this.c.onFailed(new Throwable());
                }
            }
        } catch (Throwable th) {
            this.a.finish();
            if (this.c != null) {
                this.c.onFailed(th);
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.finish();
        if (this.c != null) {
            this.c.onFailed(new Throwable());
        }
    }
}