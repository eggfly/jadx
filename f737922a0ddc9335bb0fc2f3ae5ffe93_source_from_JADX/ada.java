import java.io.PrintStream;
import java.io.PrintWriter;

public class ada extends RuntimeException {
    private StringBuffer j6;

    public static ada j6(Throwable th, String str) {
        if (th instanceof ada) {
            th = (ada) th;
        } else {
            th = new ada(th);
        }
        th.j6(str);
        return th;
    }

    public ada(String str) {
        this(str, null);
    }

    public ada(Throwable th) {
        this(null, th);
    }

    public ada(String str, Throwable th) {
        if (str == null) {
            str = th != null ? th.getMessage() : null;
        }
        super(str, th);
        if (th instanceof ada) {
            String stringBuffer = ((ada) th).j6.toString();
            this.j6 = new StringBuffer(stringBuffer.length() + 200);
            this.j6.append(stringBuffer);
            return;
        }
        this.j6 = new StringBuffer(200);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.j6);
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.j6);
    }

    public void j6(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.j6.append(str);
        if (!str.endsWith("\n")) {
            this.j6.append('\n');
        }
    }
}
