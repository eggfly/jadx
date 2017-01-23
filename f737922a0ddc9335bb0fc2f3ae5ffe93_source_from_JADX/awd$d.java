import java.io.InputStream;
import java.util.Collections;

class awd$d extends amx {
    final awd$a j6;

    awd$d(awd$a awd_a) {
        super(Collections.emptyList());
        this.j6 = awd_a;
    }

    amx DW() {
        amx amx = new amx();
        InputStream v5 = this.j6.v5();
        try {
            amx.j6(v5);
            return amx.j6().isEmpty() ? null : amx;
        } finally {
            v5.close();
        }
    }
}
