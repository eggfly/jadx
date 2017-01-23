import com.aide.common.y;
import com.aide.ui.e;
import java.util.List;

class ok$7 implements y<String> {
    final /* synthetic */ pn$a DW;
    final /* synthetic */ ok FH;
    final /* synthetic */ String j6;

    ok$7(ok okVar, String str, pn$a pn_a) {
        this.FH = okVar;
        this.j6 = str;
        this.DW = pn_a;
    }

    public void j6(String str) {
        String replace = str.replace(" ", "");
        if (replace.length() != 0 && !"main".equals(replace)) {
            List j6 = this.FH.j6(this.j6);
            if (j6 == null || !j6.contains(replace)) {
                e.j6(e.u7(), "Creating Flavor ...", new ok$7$1(this, ok.DW(this.j6, null), replace), null);
            }
        }
    }
}
