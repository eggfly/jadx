package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

public class LogWriter extends Writer {
    private final String f719a;
    private StringBuilder f720b;

    public LogWriter(String str) {
        this.f720b = new StringBuilder(128);
        this.f719a = str;
    }

    public void close() {
        m1097a();
    }

    public void flush() {
        m1097a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1097a();
            } else {
                this.f720b.append(c);
            }
        }
    }

    private void m1097a() {
        if (this.f720b.length() > 0) {
            Log.d(this.f719a, this.f720b.toString());
            this.f720b.delete(0, this.f720b.length());
        }
    }
}
