import android.content.SharedPreferences.Editor;
import com.aide.ui.e;

public class pe {
    private String DW;
    private pe$a j6;

    public void j6(pe$a pe_a) {
        this.j6 = pe_a;
    }

    public String j6() {
        String string = e.gn().getSharedPreferences("FileBrowserService", 0).getString("CurrentDir", null);
        if (string != null && qh.EQ(string)) {
            return string;
        }
        string = DW();
        qh.Mr(string);
        return string;
    }

    public String DW() {
        return qh.j6() + "/AppProjects";
    }

    public void j6(String str) {
        Editor edit = e.gn().getSharedPreferences("FileBrowserService", 0).edit();
        edit.putString("CurrentDir", str);
        edit.commit();
        FH();
    }

    public void FH() {
        if (this.j6 != null) {
            this.j6.Zo();
        }
    }

    public String Hw() {
        return this.DW;
    }

    public void DW(String str) {
        this.DW = str;
    }
}
