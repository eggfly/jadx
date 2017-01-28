import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.e;
import java.io.File;

class jv$1 implements y<String> {
    final /* synthetic */ jv DW;
    final /* synthetic */ String j6;

    jv$1(jv jvVar, String str) {
        this.DW = jvVar;
        this.j6 = str;
    }

    public void j6(String str) {
        try {
            String str2 = this.j6 + File.separator + str;
            qh.XL(str2);
            e.a8().j3();
            e.er().FH();
            e.nw().FH(str2);
        } catch (Throwable e) {
            m.j6(e.u7(), "Create Folder", e);
        }
    }
}
