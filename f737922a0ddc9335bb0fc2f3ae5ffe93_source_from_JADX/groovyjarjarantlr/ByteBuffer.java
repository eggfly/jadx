package groovyjarjarantlr;

import java.io.IOException;
import java.io.InputStream;

public class ByteBuffer extends InputBuffer {
    public transient InputStream j6;

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
