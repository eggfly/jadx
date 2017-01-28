import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class axp extends BufferedOutputStream {
    public axp(OutputStream outputStream) {
        super(outputStream);
    }

    public axp(OutputStream outputStream, int i) {
        super(outputStream);
    }

    public void close() {
        try {
            flush();
        } finally {
            super.close();
        }
    }
}
