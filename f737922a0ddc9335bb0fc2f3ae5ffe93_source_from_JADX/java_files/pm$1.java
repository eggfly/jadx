import android.os.Bundle;
import org.json.JSONObject;
import tv.ouya.console.api.Receipt;
import tv.ouya.console.api.a;
import tv.ouya.console.api.e;

class pm$1 extends a<String> {
    final /* synthetic */ pm j6;

    pm$1(pm pmVar) {
        this.j6 = pmVar;
    }

    public void j6(String str) {
        this.j6.FH = false;
        try {
            for (Receipt j6 : new e().j6(new JSONObject(str), this.j6.DW)) {
                if (j6.j6().equals("aide_full_30")) {
                    com.aide.ui.e.Mr().j6(System.currentTimeMillis() + 86400000, true);
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void j6(int i, String str, Bundle bundle) {
        com.aide.common.e.j6("OUYA check purchases failed: " + str);
    }
}
