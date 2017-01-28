import java.io.File;
import java.io.IOException;

class br$1 extends br$d {
    final /* synthetic */ br DW;
    final /* synthetic */ String j6;

    br$1(br brVar, String str) {
        this.DW = brVar;
        this.j6 = str;
        super();
    }

    protected void j6(String str) {
        if (!new File(str).delete()) {
        }
    }

    protected void DW(String str) {
        try {
            new File(str).getAbsolutePath();
            if (!new File(str).getCanonicalPath().equals(this.j6) && !new File(str).delete()) {
            }
        } catch (IOException e) {
        }
    }
}
