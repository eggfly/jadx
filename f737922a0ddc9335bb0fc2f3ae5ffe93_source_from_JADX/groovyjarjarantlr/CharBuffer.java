package groovyjarjarantlr;

import java.io.IOException;
import java.io.Reader;

public class CharBuffer extends InputBuffer {
    public transient Reader j6;

    public CharBuffer(Reader reader) {
        this.j6 = reader;
    }

    public void j6(int i) {
        try {
            FH();
            while (this.v5.DW < this.FH + i) {
                this.v5.j6((char) this.j6.read());
            }
        } catch (IOException e) {
            throw new CharStreamIOException(e);
        }
    }
}
