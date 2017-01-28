import java.io.Closeable;
import java.io.IOException;

public final class afx {
    public static void j6(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
