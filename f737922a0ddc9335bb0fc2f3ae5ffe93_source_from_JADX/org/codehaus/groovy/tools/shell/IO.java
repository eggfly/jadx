package org.codehaus.groovy.tools.shell;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import org.fusesource.jansi.AnsiRenderWriter;

public class IO {
    static final /* synthetic */ boolean VH;
    public final OutputStream DW;
    public final OutputStream FH;
    public final Reader Hw;
    public final PrintWriter Zo;
    public final InputStream j6;
    public final PrintWriter v5;

    public static final class Verbosity {
        public static final Verbosity DW;
        public static final Verbosity FH;
        public static final Verbosity Hw;
        static final /* synthetic */ boolean Zo;
        public static final Verbosity j6;
        public final String v5;

        static {
            Zo = !IO.class.desiredAssertionStatus();
            j6 = new Verbosity("QUIET");
            DW = new Verbosity("INFO");
            FH = new Verbosity("VERBOSE");
            Hw = new Verbosity("DEBUG");
        }

        private Verbosity(String str) {
            this.v5 = str;
        }

        public String toString() {
            return this.v5;
        }

        public static Verbosity j6(String str) {
            if (!Zo && str == null) {
                throw new AssertionError();
            } else if (j6.v5.equalsIgnoreCase(str)) {
                return j6;
            } else {
                if (DW.v5.equalsIgnoreCase(str)) {
                    return DW;
                }
                if (FH.v5.equalsIgnoreCase(str)) {
                    return FH;
                }
                if (Hw.v5.equalsIgnoreCase(str)) {
                    return Hw;
                }
                throw new IllegalArgumentException("Invalid verbosity name: " + str);
            }
        }
    }

    static {
        VH = !IO.class.desiredAssertionStatus();
    }

    public IO(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) {
        if (!VH && inputStream == null) {
            throw new AssertionError();
        } else if (!VH && outputStream == null) {
            throw new AssertionError();
        } else if (VH || outputStream2 != null) {
            this.j6 = inputStream;
            this.DW = outputStream;
            this.FH = outputStream2;
            this.Hw = new InputStreamReader(inputStream);
            this.v5 = new AnsiRenderWriter(outputStream, true);
            this.Zo = new AnsiRenderWriter(outputStream2, true);
        } else {
            throw new AssertionError();
        }
    }

    public IO() {
        this(System.in, System.out, System.err);
    }
}
