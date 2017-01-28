import java.io.Reader;
import java.io.Writer;

public class ip {
    public static void j6(Reader reader, Writer writer) {
        char[] cArr = new char[4096];
        while (true) {
            try {
                int read = reader.read(cArr);
                if (read != -1) {
                    writer.write(cArr, 0, read);
                } else {
                    reader.close();
                    writer.close();
                    return;
                }
            } catch (Throwable th) {
                writer.close();
            }
        }
    }
}
