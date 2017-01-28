import android.util.Log;
import java.io.Writer;

public class o extends Writer {
    private StringBuilder DW;
    private final String j6;

    public o(String str) {
        this.DW = new StringBuilder(128);
        this.j6 = str;
    }

    public void close() {
        j6();
    }

    public void flush() {
        j6();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                j6();
            } else {
                this.DW.append(c);
            }
        }
    }

    private void j6() {
        if (this.DW.length() > 0) {
            Log.d(this.j6, this.DW.toString());
            this.DW.delete(0, this.DW.length());
        }
    }
}
