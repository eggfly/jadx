import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.e;
import java.io.File;

class oj$1 implements y<String> {
    final /* synthetic */ y DW;
    final /* synthetic */ String j6;

    oj$1(String str, y yVar) {
        this.j6 = str;
        this.DW = yVar;
    }

    public void j6(String str) {
        try {
            if (str.endsWith(".java")) {
                str = str.substring(0, str.length() - 5);
            }
            String str2 = this.j6 + File.separator + str + ".java";
            String DW = ok.DW(e.a8().EQ(), e.a8().v5(), this.j6);
            String str3 = "";
            if (DW.length() > 0) {
                str3 = str3 + "package " + DW + ";\n\n";
            }
            qh.v5(str2, str3 + "public class " + str + "\n{\n}");
            this.DW.j6(str2);
        } catch (Throwable e) {
            m.j6(e.u7(), "Add class", e);
        }
    }
}
