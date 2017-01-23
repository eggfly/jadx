import android.os.Bundle;
import com.aide.common.m;
import org.json.JSONObject;
import tv.ouya.console.api.a;
import tv.ouya.console.api.c;
import tv.ouya.console.api.e;

class pm$2 extends a<String> {
    final /* synthetic */ pm j6;

    pm$2(pm pmVar) {
        this.j6 = pmVar;
    }

    public void j6(String str) {
        try {
            new e().DW(new JSONObject(str), this.j6.DW);
            com.aide.ui.e.Mr().j6(System.currentTimeMillis() + 86400000, true);
            com.aide.common.e.j6("OUYA purchase OK");
        } catch (Throwable e) {
            com.aide.common.e.j6("OUYA purchase failed.", e);
        }
    }

    public void j6(int i, String str, Bundle bundle) {
        com.aide.common.e.FH("OUYA purchase failed: " + str);
        if (!c.j6(com.aide.ui.e.tp(), i, str, bundle, 7811925, null)) {
            m.j6(com.aide.ui.e.tp(), "OUYA purchase failed", str);
        }
    }
}
