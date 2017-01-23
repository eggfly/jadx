import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.ui.e;

public class oj {
    public static boolean j6(String str) {
        return Hw(str) || v5(str);
    }

    private static boolean Hw(String str) {
        return ok.DW(e.a8().EQ(), e.a8().v5(), str) != null;
    }

    private static boolean v5(String str) {
        return qh.gn(str, "res") != null && qh.FH(e.a8().u7(), str);
    }

    public static int DW(String str) {
        if (Hw(str)) {
            return R.f.command_files_add_new_class;
        }
        if (v5(str)) {
            return R.f.command_files_add_new_xml;
        }
        return 0;
    }

    public static int FH(String str) {
        return R.drawable.file_new;
    }

    public static void j6(String str, y<String> yVar) {
        if (Hw(str)) {
            m.j6(e.u7(), (int) R.f.command_files_add_new_class, (int) R.f.dialog_create_message, "", new oj$1(str, yVar));
        } else if (v5(str)) {
            m.j6(e.u7(), (int) R.f.command_files_add_new_xml, (int) R.f.dialog_create_message, "", new oj$2(str, yVar));
        }
    }
}
