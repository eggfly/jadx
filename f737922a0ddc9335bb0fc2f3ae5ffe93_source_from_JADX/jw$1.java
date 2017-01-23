import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.e;
import java.io.File;

class jw$1 implements y<String> {
    final /* synthetic */ jw DW;
    final /* synthetic */ String j6;

    jw$1(jw jwVar, String str) {
        this.DW = jwVar;
        this.j6 = str;
    }

    public void j6(String str) {
        try {
            String str2 = this.j6 + File.separator + str;
            qh.aM(str2);
            e.a8().j3();
            e.er().FH();
            e.nw().FH(str2);
            e.u7().j6(new qg(str2, 1, 1, 1, 1));
        } catch (Throwable e) {
            m.j6(e.u7(), "Create File", e);
        }
    }
}
