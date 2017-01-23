import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.JGitText;

class art extends ars {
    static boolean j6(aud aud) {
        return (aud.yS() >>> 1) < 2147483647L;
    }

    art(OutputStream outputStream) {
        super(outputStream);
    }

    protected void j6() {
        DW();
        for (aud aud : this.Hw) {
            if (j6(aud)) {
                axb.DW(this.FH, 0, (int) aud.yS());
                aud.DW(this.FH, 4);
                this.DW.write(this.FH);
            } else {
                throw new IOException(JGitText.j6().packTooLargeForIndexVersion1);
            }
        }
        FH();
    }
}
