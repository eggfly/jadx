import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class awd$e extends awd$d {
    final aoh DW;

    awd$e(awd$a awd_a, aoh aoh) {
        super(awd_a);
        this.DW = aoh;
    }

    amx DW() {
        amx amx;
        if (this.j6 != null) {
            amx DW = super.DW();
            amx = DW == null ? new amx() : DW;
        } else {
            amx = new amx();
        }
        awp gn = this.DW.gn();
        String Hw = ((ank) this.DW.VH().j6(ank.j6)).Hw();
        if (Hw != null) {
            File j6;
            if (Hw.startsWith("~/")) {
                j6 = gn.j6(gn.FH(), Hw.substring(2));
            } else {
                j6 = gn.j6(null, Hw);
            }
            j6(amx, j6);
        }
        j6(amx, gn.j6(this.DW.DW(), "info/exclude"));
        return amx.j6().isEmpty() ? null : amx;
    }

    private void j6(amx amx, File file) {
        if (file.exists()) {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                amx.j6(fileInputStream);
            } finally {
                fileInputStream.close();
            }
        }
    }
}
