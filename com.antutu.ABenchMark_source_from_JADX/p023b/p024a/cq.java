package p023b.p024a;

import android.content.Context;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: b.a.cq */
public class cq extends cn {
    private Context f2871a;

    public cq(Context context) {
        super("idfa");
        this.f2871a = context;
    }

    public String m3788a() {
        String a = aj.m3318a(this.f2871a);
        return a == null ? BuildConfig.FLAVOR : a;
    }
}
