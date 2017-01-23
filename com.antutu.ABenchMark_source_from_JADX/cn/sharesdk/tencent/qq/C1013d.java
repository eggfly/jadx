package cn.sharesdk.tencent.qq;

import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.C0979d;
import com.baidu.mobads.openad.p079d.C1899b;
import com.igexin.sdk.PushConsts;
import com.mob.tools.FakeActivity;
import com.mob.tools.MobUIShell;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.umeng.message.proguard.C4233j;

/* renamed from: cn.sharesdk.tencent.qq.d */
public class C1013d extends FakeActivity {
    private String f3418a;
    private Platform f3419b;
    private PlatformActionListener f3420c;

    public void m4514a(Platform platform, PlatformActionListener platformActionListener) {
        this.f3419b = platform;
        this.f3420c = platformActionListener;
    }

    public void m4515a(String str) {
        this.f3418a = str;
    }

    public void onCreate() {
        try {
            Intent intent = this.activity.getIntent();
            String scheme = intent.getScheme();
            finish();
            if (scheme != null && scheme.startsWith(this.f3418a)) {
                Bundle urlToBundle = C4021R.urlToBundle(intent.getDataString());
                scheme = String.valueOf(urlToBundle.get("result"));
                String valueOf = String.valueOf(urlToBundle.get(PushConsts.CMD_ACTION));
                if ("shareToQQ".equals(valueOf) || "shareToQzone".equals(valueOf)) {
                    if (C1899b.COMPLETE.equals(scheme)) {
                        if (this.f3420c != null) {
                            this.f3420c.onComplete(this.f3419b, 9, new Hashon().fromJson(String.valueOf(urlToBundle.get("response"))));
                        }
                    } else if (C4233j.f14375B.equals(scheme)) {
                        if (this.f3420c != null) {
                            this.f3420c.onError(this.f3419b, 9, new Throwable(String.valueOf(urlToBundle.get("response"))));
                        }
                    } else if (this.f3420c != null) {
                        this.f3420c.onCancel(this.f3419b, 9);
                    }
                }
                intent = new Intent("android.intent.action.VIEW");
                intent.setClass(this.activity, MobUIShell.class);
                intent.setFlags(335544320);
                startActivity(intent);
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
    }
}
