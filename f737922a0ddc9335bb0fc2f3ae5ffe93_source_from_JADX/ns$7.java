import android.app.Activity;
import com.aide.common.m;

class ns$7 implements nl$a {
    final /* synthetic */ String DW;
    final /* synthetic */ ns FH;
    final /* synthetic */ Activity j6;

    ns$7(ns nsVar, Activity activity, String str) {
        this.FH = nsVar;
        this.j6 = activity;
        this.DW = str;
    }

    public void j6(boolean z, String str) {
        if (z) {
            m.j6(this.j6, new ns(this.DW, str, null));
        } else {
            m.j6(this.j6, "Create keystore", "Failed to create keystore file " + str);
        }
    }
}
