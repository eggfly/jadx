package com.antutu.benchmark.p040c;

import android.content.Context;
import android.os.Build;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.benchmark.modelreflact.CommonResponseModel;
import com.antutu.benchmark.modelreflact.RankResponseModel;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.utils.HttpRequestTask;
import com.antutu.utils.JsonParseUtil;
import com.antutu.utils.PointMark;
import com.antutu.utils.RequestListener;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;

/* renamed from: com.antutu.benchmark.c.c */
public class C1362c {
    private Context f4647a;

    /* renamed from: com.antutu.benchmark.c.c.1 */
    class C13611 implements RequestListener {
        final /* synthetic */ C1095a f4645a;
        final /* synthetic */ C1362c f4646b;

        C13611(C1362c c1362c, C1095a c1095a) {
            this.f4646b = c1362c;
            this.f4645a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4645a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4645a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4645a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4645a.m4842a((RankResponseModel) JsonParseUtil.parse(stringSafe, RankResponseModel.class));
                } catch (Exception e) {
                    this.f4645a.m4843a(BuildConfig.FLAVOR);
                }
            }
        }
    }

    public C1362c(Context context) {
        this.f4647a = context;
    }

    public void m5428a(C1095a<RankResponseModel> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put("softversion", Utils.getVersionCode());
        hashMap.put(Constants.KEY_BRAND, Build.BRAND);
        hashMap.put(Constants.KEY_MODEL, Build.MODEL);
        hashMap.put("product", Build.PRODUCT);
        hashMap.put("device", Build.DEVICE);
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("score", Integer.valueOf(C1503b.m5915c().m5967t()));
        hashMap.put("glVendor", C1516b.m6035i());
        hashMap.put("glRenderer", C1516b.m6036j());
        hashMap.put("oemid", Integer.valueOf(C1503b.m5915c().m5954k()));
        hashMap.put(PointMark.T_LANG, Utils.getLanguage(this.f4647a));
        hashMap.put("stype", "toplist");
        new HttpRequestTask(hashMap, "http://autovote.antutu.net/proMoudule/index.php?action=modeltopv6&act=Gettop&data=1", new C13611(this, c1095a)).submit();
    }
}
