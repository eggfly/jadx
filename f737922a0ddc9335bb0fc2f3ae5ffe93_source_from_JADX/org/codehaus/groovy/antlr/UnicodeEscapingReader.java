package org.codehaus.groovy.antlr;

import groovyjarjarantlr.CharScanner;
import groovyjarjarantlr.Token;
import java.io.IOException;
import java.io.Reader;

public class UnicodeEscapingReader extends Reader {
    private CharScanner DW;
    private boolean FH;
    private int Hw;
    private int VH;
    private int Zo;
    private int gn;
    private final Reader j6;
    private final SourceBuffer v5;

    private static class DummyLexer extends CharScanner {
        private final Token j6;

        private DummyLexer() {
            this.j6 = new Token();
        }

        public Token j6() {
            return this.j6;
        }

        public int Hw() {
            return 0;
        }

        public int Zo() {
            return 0;
        }
    }

    public UnicodeEscapingReader(Reader reader, SourceBuffer sourceBuffer) {
        this.FH = false;
        this.VH = 0;
        this.gn = 0;
        this.j6 = reader;
        this.v5 = sourceBuffer;
        this.DW = new DummyLexer();
    }

    public void j6(CharScanner charScanner) {
        this.DW = charScanner;
    }

    public int read(char[] cArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            i4 = read();
            if (i4 == -1) {
                break;
            }
            cArr[i + i3] = (char) i4;
            i3++;
        }
        if (i3 == 0 && r2 == -1) {
            return -1;
        }
        return i3;
    }

    public int read() {
        int i = 0;
        if (this.FH) {
            this.FH = false;
            j6(this.Hw);
            return this.Hw;
        }
        if (this.Zo != this.DW.Zo()) {
            this.gn = 0;
            this.Zo = this.DW.Zo();
        }
        int read = this.j6.read();
        if (read != 92) {
            j6(read);
            return read;
        }
        read = this.j6.read();
        if (read != 117) {
            this.FH = true;
            this.Hw = read;
            j6(92);
            return 92;
        }
        int read2;
        read = 0;
        do {
            read++;
            read2 = this.j6.read();
        } while (read2 == 117);
        DW(read2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((char) read2);
        while (i < 3) {
            read2 = this.j6.read();
            DW(read2);
            stringBuilder.append((char) read2);
            i++;
        }
        i = Integer.parseInt(stringBuilder.toString(), 16);
        j6(i);
        this.VH += read + 4;
        this.gn = (read + 4) + this.gn;
        return i;
    }

    private void j6(int i) {
        if (this.v5 != null) {
            this.v5.j6(i);
        }
    }

    private void DW(int i) {
        if (i >= 48 && i <= 57) {
            return;
        }
        if (i >= 97 && i <= 102) {
            return;
        }
        if (i < 65 || i > 70) {
            this.FH = true;
            this.Hw = i;
            throw new IOException("Did not find four digit hex character code. line: " + this.DW.Zo() + " col:" + this.DW.Hw());
        }
    }

    public int j6() {
        return this.gn;
    }

    public void close() {
        this.j6.close();
    }
}
