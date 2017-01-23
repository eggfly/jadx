package com.antutu.redacc.p068b;

import android.content.Context;
import android.content.pm.PackageInfo;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.redacc.p067f.C1715j;
import com.antutu.redacc.p067f.C1751g;
import com.antutu.redacc.p067f.C1752h;
import com.antutu.redacc.p067f.C1762r;
import com.antutu.redacc.p072e.C1738b;
import com.antutu.utils.PointMark;
import com.taobao.accs.common.Constants;
import com.tools.utility.JNILIB;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.redacc.b.a */
public class C1718a {
    private Context f6103a;

    /* renamed from: com.antutu.redacc.b.a.1 */
    class C17161 implements C1715j {
        final /* synthetic */ C1717a f6101a;
        final /* synthetic */ C1718a f6102b;

        C17161(C1718a c1718a, C1717a c1717a) {
            this.f6102b = c1718a;
            this.f6101a = c1717a;
        }

        public void m6661a(int i, String str) {
            if (i != -1 && str != null) {
                try {
                    C1738b c1738b = (C1738b) C1752h.m6757a(JNILIB.getString(str, BuildConfig.FLAVOR), C1738b.class);
                    if (c1738b.m6723a() == 1) {
                        this.f6101a.m6662a(c1738b.m6724b());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.antutu.redacc.b.a.a */
    public interface C1717a {
        void m6662a(List<String> list);
    }

    public C1718a(Context context) {
        this.f6103a = context;
    }

    private static PackageInfo m6663a(Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSL_L7E);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    public void m6664a(C1717a c1717a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(Constants.SP_KEY_VERSION, C1718a.m6663a(this.f6103a.getApplicationContext()).versionName);
        hashMap.put(PointMark.T_LANG, C1762r.m6777h(this.f6103a));
        new C1751g(hashMap, "http://autovote.antutu.net/antuapi.php?m=accelerator&c=config&a=exceptions", new C17161(this, c1717a)).m6756c();
    }
}
