import java.io.File;
import java.util.Locale;

class br$2 extends br$d {
    final /* synthetic */ br j6;

    br$2(br brVar) {
        this.j6 = brVar;
        super();
    }

    protected void j6(String str) {
        if ((!str.toUpperCase(Locale.US).endsWith(".CLASS") && !str.toUpperCase(Locale.US).endsWith(".DEX")) || new File(str).delete()) {
        }
    }
}
