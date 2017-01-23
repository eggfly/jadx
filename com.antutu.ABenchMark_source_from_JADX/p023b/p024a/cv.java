package p023b.p024a;

import android.os.Build;
import android.os.Build.VERSION;
import anet.channel.C0655b;

/* renamed from: b.a.cv */
public class cv extends cn {
    public cv() {
        super(C0655b.HR_SERIAL);
    }

    public String m3833a() {
        return VERSION.SDK_INT >= 9 ? Build.SERIAL : null;
    }
}
