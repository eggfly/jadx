package org.codehaus.groovy.syntax;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public abstract class CSTNode {
    public abstract int Hw();

    public abstract Token Zo();

    public abstract CSTNode j6(int i);

    public int j6() {
        return j6(true).j6();
    }

    public int DW() {
        return j6(true).DW();
    }

    public boolean FH() {
        return false;
    }

    public int v5() {
        int Hw = Hw();
        if (Hw > 1) {
            return Hw - 1;
        }
        return 0;
    }

    public CSTNode j6(int i, boolean z) {
        CSTNode j6 = j6(i);
        if (j6 == null && z) {
            return Token.j6;
        }
        return j6;
    }

    public Token j6(boolean z) {
        Token Zo = Zo();
        if (Zo == null && z) {
            return Token.j6;
        }
        return Zo;
    }

    public int VH() {
        return j6(true).VH();
    }

    public int gn() {
        return j6(true).gn();
    }

    public String toString() {
        Writer stringWriter = new StringWriter();
        j6(new PrintWriter(stringWriter));
        stringWriter.flush();
        return stringWriter.toString();
    }

    public void j6(PrintWriter printWriter) {
        j6(printWriter, "");
    }

    protected void j6(PrintWriter printWriter, String str) {
        printWriter.print("(");
        if (!FH()) {
            Token j6 = j6(true);
            int DW = j6.DW();
            int j62 = j6.j6();
            printWriter.print(Types.DW(DW));
            if (j62 != DW) {
                printWriter.print(" as ");
                printWriter.print(Types.DW(j62));
            }
            if (VH() > -1) {
                printWriter.print(" at " + VH() + ":" + gn());
            }
            String u7 = j6.u7();
            DW = u7.length();
            if (DW > 0) {
                printWriter.print(": ");
                if (DW > 40) {
                    u7 = u7.substring(0, 17) + "..." + u7.substring(DW - 17, DW);
                }
                printWriter.print(" \"");
                printWriter.print(u7);
                printWriter.print("\" ");
            } else if (v5() > 0) {
                printWriter.print(": ");
            }
            DW = Hw();
            if (DW > 1) {
                printWriter.println("");
                String str2 = str + "  ";
                String str3 = str + "   ";
                for (int i = 1; i < DW; i++) {
                    printWriter.print(str2);
                    printWriter.print(i);
                    printWriter.print(": ");
                    j6(i, true).j6(printWriter, str3);
                }
                printWriter.print(str);
            }
        }
        if (str.length() > 0) {
            printWriter.println(")");
        } else {
            printWriter.print(")");
        }
    }
}
