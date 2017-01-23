import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;

final class awd$b {
    final CharsetEncoder DW;
    MessageDigest FH;
    byte[] Hw;
    int Zo;
    final awe j6;
    awc v5;

    awd$b(awe awe) {
        this.j6 = awe;
        this.DW = anj.DW.newEncoder();
    }

    void j6() {
        if (this.FH == null) {
            this.FH = anj.j6();
            this.Hw = new byte[2048];
        }
    }
}
